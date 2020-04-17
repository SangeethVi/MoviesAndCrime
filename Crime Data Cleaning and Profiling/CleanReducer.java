import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CleanReducer
    extends Reducer<Text, Text, Text, Text> {
  
  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
    
    // StringBuilder sb = new StringBuilder();

    // for (DoubleWritable value : values) {
    //     sb.append(String.valueOf(value.get()) + ", ");
    // }

    for(Text value: values){
      context.write(key, value);
    }

  }
}
