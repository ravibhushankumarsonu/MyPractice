package com.example.multiFileRead;

import org.apache.crunch.PCollection;
import org.apache.crunch.Pipeline;
import org.apache.crunch.PipelineResult;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.io.From;
import org.apache.crunch.types.writable.Writables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ravibhushan.k on 03/09/18
 */
public class AtTime extends Configured implements Tool {

    public static void main(String[] args) throws Exception {
        ToolRunner.run(new Configuration(),new AtTime(), args);
    }

    @Override
    public int run(String[] args) throws Exception {
        if(args.length!=2) {
            System.err.println("Enter input and ouput sources in argument");
            GenericOptionsParser.printGenericCommandUsage(System.err);
            return 1;
        }

        String inputPath=args[0];
        String outputPath=args[1];

        Pipeline pipeline=new MRPipeline(AtTime.class,getConf());
        //PCollection<String> col = pipeline.read(From.textFile(getSources(inputPath)),Writables.strings());
        PCollection<String> collection1=pipeline.read(From.textFile(getSources(inputPath)));

        pipeline.writeTextFile(collection1,outputPath);

        PipelineResult result=pipeline.done();

        return result.succeeded()?0:1;
    }

    private List<Path> getSources(String inputPath){
        List<Path> paths=new ArrayList<Path>();
        paths.add(new Path(inputPath+"/first.txt"));
        paths.add(new Path(inputPath+"/second.txt"));

        return paths;
    }
}
