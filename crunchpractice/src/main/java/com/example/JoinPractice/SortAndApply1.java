package com.example.JoinPractice;

import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;
import org.apache.crunch.Pair;

/**
 * created by ravibhushan.k on 03/09/18
 */
public class SortAndApply1 extends DoFn<Pair<String ,Iterable<Pair<String,String >>>,String > {

    @Override
    public void process(Pair<String ,Iterable<Pair<String,String >>> input, Emitter<String > emitter) {

        String id=input.first();

        //String result="";
        for(Pair<String ,String > value:input.second() ){
            emitter.emit(id+" first: "+value.first()+" second: "+value.second());
        }
        //emitter.emit(Pair.of(id,result));
    }
}
