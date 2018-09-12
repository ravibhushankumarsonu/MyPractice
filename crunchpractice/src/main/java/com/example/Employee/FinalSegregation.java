package com.example.Employee;

import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;
import org.apache.crunch.Pair;

/**
 * created by ravibhushan.k on 31/08/18
 */
public class FinalSegregation extends DoFn<Pair<String, Iterable<Integer>> , String> {

    @Override
    public void process(Pair<String, Iterable<Integer>> value, Emitter<String> emitter){
        String result="Start";
        if(value.first().equals("M")){
            result="Male Employee with Id : ";
        }else if(value.first().equals("F")) {
            result="Female Employee with Id ";
        }
        Integer totalCount=0;
        for(Integer id: value.second()) {
            result+=id.toString()+" ";
            totalCount++;
        }
        result+="\n Total female is "+totalCount.toString();
        //System.out.println(result);
        emitter.emit(result);
    }
}
