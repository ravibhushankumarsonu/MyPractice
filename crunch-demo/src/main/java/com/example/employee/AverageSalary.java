package com.example.employee;

import java.io.Serializable;

import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;
import org.apache.crunch.PCollection;
import org.apache.crunch.PObject;
import org.apache.crunch.PTable;
import org.apache.crunch.Pipeline;
import org.apache.crunch.PipelineResult;
import org.apache.crunch.fn.Aggregators;
import org.apache.crunch.impl.mr.MRPipeline;
import org.apache.crunch.types.writable.Writables;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * created by ravibhushan.k on 31/08/18
 */
public class AverageSalary extends Configured implements Tool, Serializable {

    public int run(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println();
            System.err.println("Usage: " + this.getClass().getName() + " [generic options] input");
            System.err.println();
            GenericOptionsParser.printGenericCommandUsage(System.err);
            return 1;
        }
        String inputPath=args[0];
        String outputPath=args[1];
        // Create an object to coordinate pipeline creation and execution.
        Pipeline pipeline = new MRPipeline(AverageSalary.class, getConf());
        // Reference a given text file as a collection of Strings.
        PCollection<String> lines = pipeline.readTextFile(args[0]);

        // Define a function that splits each line in a PCollection of Strings into
        // a
        // PCollection made up of the individual words in the file.
        PCollection<Long> numberOfWords = lines.parallelDo(new DoFn<String, Long>() {
            public void process(String line, Emitter<Long> emitter) {
                emitter.emit((long)line.split("\\s+").length);
            }
        }, Writables.longs()); // Indicates the serialization format

        // The aggregate method groups a collection into a single PObject.
        //PObject<Long> totalCount = numberOfWords.aggregate(Aggregators.SUM_LONGS()).first();
        pipeline.writeTextFile(numberOfWords,outputPath);

        // Execute the pipeline as a MapReduce.
        PipelineResult result = pipeline.run();

        //System.out.println("Total number of words: " + totalCount.getValue());


        pipeline.done();

        return result.succeeded() ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        int result = ToolRunner.run(new Configuration(), new AverageSalary(), args);
        System.exit(result);
    }
}
