package com.example.Employee;

import com.google.common.base.Splitter;
import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ravibhushan.k on 31/08/18
 */
public class SegregateGenderDoFn extends DoFn<String, Employee > {
    private static final Splitter SPLITTER = Splitter.on('|').omitEmptyStrings();

    @Override
    public void process(String line, Emitter<Employee> emitter) {
        List<String > values = new ArrayList<String>();
        Employee employee=new Employee();
        for(String words: SPLITTER.split(line)) {
            values.add(words);
        }
        if(values.size()==5) {
            employee.setId(new IntWritable(Integer.parseInt(values.get(0))));
            employee.setAge(new IntWritable(Integer.parseInt(values.get(1))));
            employee.setGender(new Text(values.get(2)));
            employee.setRole(new Text(values.get(3)));
            //employee.setSalary(new LongWritable(Long.parseLong(values.get(4))));
            //emitter.emit(employee);
        }
        emitter.emit(employee);
    }
}
