package com.example.Employee;

import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;
import org.apache.crunch.PCollection;
import org.apache.crunch.Pair;
import org.apache.crunch.types.PTableType;

/**
 * created by ravibhushan.k on 31/08/18
 */
public class Segregation extends DoFn<Employee, Pair<String, Integer>> {

    @Override
    public void process(Employee employee, Emitter<Pair<String, Integer>> emitter){
        if(employee!=null && employee.getGender()!=null){
            emitter.emit(Pair.of(employee.getGender().toString(),Integer.parseInt(employee.getId().toString())));
        }
    }
}
