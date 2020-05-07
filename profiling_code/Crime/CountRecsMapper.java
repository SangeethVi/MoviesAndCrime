import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountRecsMapper
    extends Mapper<LongWritable, Text, Text, IntWritable> {
   

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString();
    String[] words = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //ignores commas within cells
    IntWritable one = new IntWritable(1);
    Text original = new Text("Number of Records Original");
    Text cleaned = new Text("Number of Records after Clean");

    if(words.length>11){ //skip irrelevant rows of original dataset
      for(int i =0; i<words.length; i++){
        String str = words[i];
        str = str.replaceAll("[^\\d.]", "");
        if(str.length()!=0){
          context.write(original, one);
        }
      }
    }
   

  }
}
