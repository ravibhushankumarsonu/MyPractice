package com.example.Employee;

import org.apache.crunch.*;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.io.To;
import org.apache.crunch.lib.SecondarySort;
import org.apache.crunch.types.PTableType;
import org.apache.crunch.types.writable.Writables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.fs.FileSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * created by ravibhushan.k on 31/08/18
 */
public class CountGender extends Configured implements Tool, Serializable {

    public static void main(String[] args) throws Exception{
        ToolRunner.run(new Configuration(), new CountGender(), args);
    }

    public int run(String[] args)  throws  Exception {
        if(args.length!=2) {
            System.err.println("hadoop jar crunch.practice-*-job.jar com.example.Employee.CountGender [inputpath]");
            GenericOptionsParser.printGenericCommandUsage(System.err);
            return 1;
        }

        String inputPath=args[0];
        //String ouputPath=args[1];

        if(!inputPath.contains("Consultentdata.txt")) {
            System.err.println("Enter the valid input data");
            return 1;
        }

        Pipeline pipeline = new MRPipeline(CountGender.class, getConf());

        PCollection<String> inputData=pipeline.readTextFile(inputPath);


        PCollection<Employee> employeePCollection = inputData.parallelDo(new SegregateGenderDoFn(), Writables.records(Employee.class));

        PTable<String, Integer> segregatedGenderData=employeePCollection.parallelDo(new Segregation(),Writables.tableOf(Writables.strings(),Writables.ints()));

        PGroupedTable<String,Integer> segregatedGender=segregatedGenderData.groupByKey();


        PCollection<String> IdByGender=segregatedGender.parallelDo(new FinalSegregation(),Writables.strings());


        //pipeline.writeTextFile(employeePCollection,ouputPath);
        Path outputPath=new Path(args[1]);
        FileSystem fs=  FileSystem.get(getConf());
        if(fs.exists(outputPath)){
            fs.delete(outputPath,true);
        }
        //pipeline.writeTextFile(employeePCollection.filter(new FilterGender("M")),outputPath.toString()+"/M");
        pipeline.writeTextFile(employeePCollection,outputPath.toString()+"/F");
        /*List<String> keys=new ArrayList<String>();
        keys.add("M");
        //keys.add("F");
        for(String key:keys){
            //Target outputHdfs= To.textFile(outputPath.toString()+"/"+key);
            //employeePCollection.filter(new FilterGender(key)).write(outputHdfs);
            pipeline.writeTextFile(employeePCollection.filter(new FilterGender(key)),outputPath.toString()+"/"+key);
        }*/

        PipelineResult result=pipeline.done();
        System.out.println("Execution till 7");

        return result.succeeded()?0:1;
    }
}
