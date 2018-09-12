package com.example.multiFileWrite;

import lombok.ToString;
import org.apache.crunch.PCollection;
import org.apache.crunch.Pipeline;
import org.apache.crunch.PipelineResult;
import org.apache.crunch.impl.dist.collect.MRCollection;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ravibhushan.k on 01/09/18
 */
public class MultiFile extends Configured implements Tool {

    public static void main(String[] args) throws Exception{
        ToolRunner.run(new Configuration(), new MultiFile(),args);
    }


    public int run(String[] args) throws Exception{

        if(args.length!=2){
            System.err.println("Input argument length should be two.");
            GenericOptionsParser.printGenericCommandUsage(System.err);
            return 1;
        }

        String inputPath=args[0];
        String ouputPath=args[1];

        Pipeline pipeline=new MRPipeline(MultiFile.class, getConf());
        PCollection<String> values=pipeline.readTextFile(inputPath);

        List<PCollection<String >> resultData=new ArrayList<PCollection<String>>();
        for(int i=0;i<10;i++) {
            resultData.add(values.filter(new FirstDigitFilter(new Integer(i).toString())));
        }

        for(int i=0;i<resultData.size();i++){
            pipeline.writeTextFile(resultData.get(i),ouputPath+"/"+new Integer(i).toString());
        }

        PipelineResult result=pipeline.done();

        return  result.succeeded()?0:1;
    }
}
