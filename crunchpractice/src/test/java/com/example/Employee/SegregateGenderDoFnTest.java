package com.example.Employee;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.apache.crunch.Emitter;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * created by ravibhushan.k on 31/08/18
 */
@RunWith(MockitoJUnitRunner.class)
public class SegregateGenderDoFnTest {

    @Mock
    private Emitter<Employee> emitter;


    @Test
    public void TestProcess(){
        SegregateGenderDoFn segregateGenderDoFn=new SegregateGenderDoFn();

        segregateGenderDoFn.process("1|24|M|consultant|85711", emitter);
        Employee employee=new Employee();
        employee.setId(new IntWritable(1));
        employee.setAge(new IntWritable(24));
        employee.setGender(new Text("M"));
        employee.setRole(new Text("consultant"));
        //employee.setSalary(new LongWritable(85711));
        System.out.println(employee);
        verify(emitter).emit(employee);
        //verifyNoMoreInteractions(emitter);
    }
}
