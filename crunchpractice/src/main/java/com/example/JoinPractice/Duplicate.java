package com.example.JoinPractice;

import org.apache.crunch.*;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.lib.Join;
import org.apache.crunch.lib.SecondarySort;
import org.apache.crunch.types.writable.Writables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


/**
 * created by ravibhushan.k on 03/09/18
 */
public class Duplicate extends Configured implements Tool {

    public static void main(String[] args) throws Exception{
        ToolRunner.run(new Configuration(), new Duplicate(), args);
    }

    @Override
    public int run(String[] args) throws Exception{
        if(args.length!=2){
            System.err.println("Argument must contains input and output path");
            GenericOptionsParser.printGenericCommandUsage(System.err);
            return 1;
        }

        Pipeline pipeline=new MRPipeline(Duplicate.class,getConf());
        PCollection<String > collection1=pipeline.readTextFile(args[0]+"/first.txt");
        PCollection<String > collection2=pipeline.readTextFile(args[0]+"/second.txt");

        PTable<String ,String > pTable1=collection1.parallelDo(new DoFn1(),Writables.tableOf(Writables.strings(),Writables.strings()));
        PTable<String ,String > pTable2=collection2.parallelDo(new DoFn1(),Writables.tableOf(Writables.strings(),Writables.strings()));

        PTable<String ,Pair<String,String >> joinedTable=Join.leftJoin(pTable1,pTable2);

        PCollection<String> resultCollection= SecondarySort.sortAndApply(joinedTable,new SortAndApply1(),Writables.strings());

        //pipeline.writeTextFile(pTable1,args[1]+"/first");
        //pipeline.writeTextFile(pTable2,args[1]+"/second");
        pipeline.writeTextFile(resultCollection,args[1]);

        PipelineResult result=pipeline.done();
        return result.succeeded()?0:1;
    }
}
