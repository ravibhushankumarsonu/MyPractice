# A 100-node example for ad-hoc simulation with AODV

# Define options
set val(chan)           Channel/WirelessChannel    ;# channel type
set val(prop)           Propagation/TwoRayGround   ;# radio-propagation model
set val(netif)          Phy/WirelessPhy            ;# network interface type

set val(mac)            Mac/802_11                 ;# MAC type
set val(ifq)            Queue/DropTail/PriQueue    ;# interface queue type
set val(ll)             LL                         ;# link layer type
set val(ant)            Antenna/OmniAntenna        ;# antenna model
set val(ifqlen)         50                         ;# max packet in ifq
set val(nn)             14                         ;# number of mobilenodes
set val(rp)             AODV                       ;# routing protocol
set val(x)              500                        ;# X dimension of topography
set val(y)              400                        ;# Y dimension of topography
set val(stop)           20                         ;# time of simulation end
set sender              0                          ;#sender
set reciever            9                          ;#receiver


set ns          [new Simulator]
set tracefd       [open attack.tr w]
set windowVsTime2 [open win.tr w]
set namtrace      [open attack.nam w]

$ns trace-all $tracefd
$ns namtrace-all-wireless $namtrace $val(x) $val(y)

# set up topography object
set topo       [new Topography]

$topo load_flatgrid $val(x) $val(y)

create-god $val(nn)


#unity gain, omni-directional antennas
#set up the antennas to be centered in the node and 1.5 meters above it
Antenna/OmniAntenna set X_ 0
Antenna/OmniAntenna set Y_ 0
Antenna/OmniAntenna set Z_ 1.5
Antenna/OmniAntenna set Gt_ 1.0
Antenna/OmniAntenna set Gr_ 1.0

#Initialize the SharedMedia interface with parameters to make
#it work like the 914MHz Lucent WaveLAN DSSS radio interface
Phy/WirelessPhy set CPThresh_ 10.0
Phy/WirelessPhy set CSThresh_ 1.559e-11
Phy/WirelessPhy set RXThresh_ 3.652e-10 ;#250m
Phy/WirelessPhy set Rb_ 2*1e6
Phy/WirelessPhy set Pt_ 0.2818
Phy/WirelessPhy set freq_ 914e+6
Phy/WirelessPhy set L_ 1.0

# configure the nodes
        $ns node-config -adhocRouting $val(rp) \
             -llType $val(ll) \
             -macType $val(mac) \
             -ifqType $val(ifq) \
             -ifqLen $val(ifqlen) \
             -antType $val(ant) \
             -propType $val(prop) \
             -phyType $val(netif) \
             -channelType $val(chan) \
             -topoInstance $topo \
             -agentTrace ON \
             -routerTrace ON \
             -macTrace OFF \
             -movementTrace ON

#
#  Create nn mobilenodes [$val(nn)] and attach them to the channel.
#
    for {set i 0} {$i < $val(nn) } { incr i } {
        set node_($i) [$ns node]
        $node_($i) set X_ [ expr 10+round(rand()*480) ]
        $node_($i) set Y_ [ expr 10+round(rand()*380) ]
        $node_($i) set Z_ 0.0

    }

#    for {set i 0} {$i < $val(nn) } { incr i } {
#        $ns at [ expr 15+round(rand()*60) ] "$node_($i) setdest [ expr 10+round(rand()*480) ] [ expr 10+round(rand()*380) ] [ expr 2+round(rand()*15) ]"
#
#    }


    set udp [new Agent/UDP]
    $ns attach-agent $node_(0) $udp

    set cbr [new Application/Traffic/CBR]
    $cbr set packetSize_ 1024
    $cbr set interval_ 0.1
    $cbr attach-agent $udp


    set null [new Agent/Null]
    $ns attach-agent $node_(1) $null

    $ns connect $udp $null
    $ns at 2.0 "$cbr start"
    $ns at 10.0 "$cbr stop"


    $ns at 2.0 "$ns trace-annotate \"Sender sends the data to the receiver through the selected router which is attacker\""
    $ns at 2.1 "$ns trace-annotate \"Attacker 3 and 8 forms wormhole\""
    set udp [new Agent/UDP]
    $ns attach-agent $node_(1) $udp

    set cbr [new Application/Traffic/CBR]
    $cbr set packetSize_ 1024
    $cbr set interval_ 0.1
    $cbr attach-agent $udp

    set null [new Agent/Null]
    $ns attach-agent $node_(3) $null

    $ns connect $udp $null
    $ns at 3.0 "$cbr start"
    $ns at 10.0 "$cbr stop"
    $ns at 3.0 "$ns trace-annotate \"Attacker forwards the data to Attacker 8 which does not forward the data to receiver\""


# Printing the window size
#proc plotWindow {udpSource file} {
#global ns
#set time 0.01
#set now [$ns now]
#set cwnd [$udpSource set cwnd_]
#puts $file "$now $cwnd"
#$ns at [expr $now+$time] "plotWindow $tcpSource $file" }
#$ns at 10.1 "plotWindow $udp $windowVsTime2"

# Define node initial position in nam
for {set i 0} {$i < $val(nn)} { incr i } {
# 30 defines the node size for nam
$ns initial_node_pos $node_($i) 30
}

# Telling nodes when the simulation ends
for {set i 0} {$i < $val(nn) } { incr i } {
    $ns at $val(stop) "$node_($i) reset";
}

# ending nam and the simulation
$ns at $val(stop) "$ns nam-end-wireless $val(stop)"
$ns at $val(stop) "stop"
$ns at 150 "puts \"end simulation\" ; $ns halt"
proc stop {} {
    global ns tracefd namtrace
    $ns flush-trace
    close $tracefd
    close $namtrace
}

$ns run
