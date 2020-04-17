import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper
    extends Mapper<LongWritable, Text, Text, Text> {
   

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString();
    String[] words = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //ignores commas within cells
    StringBuilder values = new StringBuilder();

    if(words.length == 22){ //skip irrelevant rows
      if(words[0].chars().allMatch(Character::isDigit)){ //check if first entry is numeric
        String num = words[0].substring(0,4);
        Text year = new Text(num);
        for(int i =1; i<22; i++){
          String str = words[i];
          str = str.replaceAll(",", "");
          str = str.replaceAll("^\"|\"$", "");
          if(i==1 || i==2 || i==3 || i==5 || i==9 || i==11 || i==13 || i==15 || i==17 || i==19 || i==21){
            // DoubleWritable curr = new DoubleWritable(Double.parseDouble(str));
            values.append(str + ", ");
          }

        }
        context.write(year, new Text(values.toString()));
      }
      
    }

  }
}
