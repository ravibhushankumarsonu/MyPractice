package com.example.csv;

import com.google.common.base.Splitter;
import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;

/**
 * created by ravibhushan.k on 02/09/18
 */
public class StringToTable extends DoFn<String, String > {

    private static final Splitter SPLITER=Splitter.on(',').omitEmptyStrings();
    @Override
    public void process(String line, Emitter<String> emitter) {
        Iterable<String> words=SPLITER.split(line);
        Integer count=0;
        for(String word:words){
            count++;
        }
        emitter.emit(count.toString());
    }
}
