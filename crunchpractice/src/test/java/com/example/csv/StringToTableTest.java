package com.example.csv;

import static org.mockito.Mockito.verify;

import org.apache.crunch.Emitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * created by ravibhushan.k on 02/09/18
 */
@RunWith(MockitoJUnitRunner.class)
public class StringToTableTest {

    @Mock
    private Emitter<String > emitter;

    @Test
    public void Fisrtprocess() {
        StringToTable stringToTable=new StringToTable();
        String testString="nc,34454,34343,345,2sdssd";
        stringToTable.process(testString,emitter);
        verify(emitter).emit("5");
    }

    @Test
    public void process() {
        StringToTable stringToTable=new StringToTable();
        String testString="nc,71920701,1,\"Saturday, January 12, 2013 19:43:18 UTC\",38.7865,-122.7630,1.5,1.10,27,\"Northern California\"";
        stringToTable.process(testString,emitter);
        verify(emitter).emit("12");
    }
}