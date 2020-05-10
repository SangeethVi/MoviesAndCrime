public class TotalCount {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: TotalCount <input path> <output path>");
      System.exit(-1);
    }

    final Configuration conf = new Configuration();
    conf.set("mapred.textoutputformat.separator", ",");
    Job job = Job.getInstance(conf);

    job.setJarByClass(TotalCount.class);
    job.setJobName("Total count");

    //We can ask for specific reducers:
    job.setNumReduceTasks(1);

     FileInputFormat.addInputPath(job, new Path(args[0]));
     FileOutputFormat.setOutputPath(job, new Path(args[1]));
     job.setMapperClass(TotalCountMapper.class);
     job.setReducerClass(TotalCountReducer.class);
     job.setOutputKeyClass(Text.class);
     job.setOutputValueClass(IntWritable.class);
    System.exit(job.waitForCompletion(true) ? 0 : 1);

         }

     }