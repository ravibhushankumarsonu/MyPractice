package com.example.csv;

import org.apache.crunch.PCollection;
import org.apache.crunch.Pipeline;
import org.apache.crunch.PipelineResult;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.types.writable.Writables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.List;


/**
 * created by ravibhushan.k on 02/09/18
 */
public class CsvReader extends Configured implements Tool {

    public static void main(String[] args) throws Exception{
        ToolRunner.run(new Configuration(), new CsvReader(), args);
    }

    public int run(String[] args) throws Exception{
        if(args.length!=2){
            System.err.println("Enter the input and output sources only");
        }

        Pipeline pipeline =new MRPipeline(CsvReader.class,getConf());

        PCollection<String > data=pipeline.readTextFile(args[0]);

        PCollection<String> filterData= data.parallelDo(new StringToTable(), Writables.strings());
        pipeline.writeTextFile(filterData,args[1]);
        PipelineResult result =pipeline.done();
        return result.succeeded()?0:1;
    }
}
