package com.example.JoinPractice;

import com.google.common.base.Splitter;
import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;
import org.apache.crunch.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ravibhushan.k on 03/09/18
 */
public class DoFn1 extends DoFn<String ,Pair<String,String >> {
    private static final Splitter SPLITTER=Splitter.on(',').omitEmptyStrings();

    @Override
    public void process(String input, Emitter<Pair<String,String>> emitter) {
        List<String > words=new ArrayList<String>();

        for(String word:SPLITTER.split(input)) {
            words.add(word);
        }
        if(words.size()==2){
            emitter.emit(Pair.of(words.get(0),words.get(1)));
        }
    }
}
