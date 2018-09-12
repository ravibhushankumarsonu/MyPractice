package Jobs;


import mapperReducer.MaxTemperatureMapper;
import mapperReducer.MaxTempratureReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import javax.xml.soap.Text;
import java.io.IOException;

public class MaxTemprature {
    public static void main(String[] args) throws Exception {
        //Create an instance of configuration object
        Configuration conf = new Configuration();
        conf.addResource(new Path("/usr/lib/hadoop/etc/hadoop/core-site.xml"));
        conf.addResource(new Path("/usr/lib/hadoop/etc/hadoop/hdfs-site.xml"));

        //Create an Instance of filesystem that holds FileSystems namespace
        FileSystem fs = FileSystem.get(conf);

        //Variable that hold the path of input and output location

        String inPath;
        String outPath;

        if(args.length !=2) {
            System.err.println("Usage: MaxTemprature <input_path> <output_path>");
            inPath="/user/cloudera/WordCount.txt";
            outPath="/user/cloudera/WordCountOutput";
            System.exit(-1);
        }else {
            inPath = args[0];
            outPath = args[1];
        }

        Job job=new Job(conf, "Max Temprature");
        job.setJarByClass(MaxTemprature.class);
        job.setMapperClass(MaxTemperatureMapper.class);
        job.setReducerClass(MaxTempratureReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path(inPath));

        if(fs.exists(new Path(outPath))) {
            fs.delete(new Path(outPath), true);
        }

        FileOutputFormat.setOutputPath(job,new Path(outPath));

        System.exit(job.waitForCompletion(true)?0:1);
    }
}
