package com.example.Employee;

import lombok.Data;
import org.apache.hadoop.io.*;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * created by ravibhushan.k on 31/08/18
 */
@Data
public class Employee implements Writable {
    private IntWritable id;
    private IntWritable age;
    private Text gender;
    private Text role;
    private LongWritable salary;

    @Override
    public void readFields(DataInput in) throws IOException{
        id.readFields(in);
        age.readFields(in);
        gender.readFields(in);
        role.readFields(in);
        salary.readFields(in);
    }

    @Override
    public void write(DataOutput output) throws IOException{
        id.write(output);
        age.write(output);
        gender.write(output);
        role.write(output);
        salary.write(output);
    }
}
