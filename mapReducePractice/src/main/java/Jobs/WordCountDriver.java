package Jobs;

import mapperReducer.WordCountMapper;
import mapperReducer.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class WordCountDriver {


    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        //System.out.println("Ravibhushan Kumar");
        //Create an instance of configuration object
        Configuration conf = new Configuration();
        conf.addResource(new Path("/usr/lib/hadoop/etc/hadoop/core-site.xml"));
        conf.addResource(new Path("/usr/lib/hadoop/etc/hadoop/hdfs-site.xml"));

        //Create an Instance of filesystem that holds FileSystems namespace
        FileSystem fs = FileSystem.get(conf);

        //Variable that hold the path of input and output location

        String inPath;
        String outPath;

        if(args.length!=2) {
            System.err.println("Usages: wordcount <input file> <output dir>");
            System.out.println("Using default file: WordCount.txt");
            inPath="/user/cloudera/WordCount.txt";
            outPath="/user/cloudera/WordCountOutput";
        } else {
            inPath = args[0];
            outPath = args[1];
        }

        //Create an instance of job
        Job job = new Job(conf, "Word Count");
        job.setJarByClass(WordCountDriver.class);
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
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
