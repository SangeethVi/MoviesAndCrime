import java.io.IOException;
import java.util.regex.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.*;

public class MovieCountMapper
    extends Mapper<LongWritable, Text, Text, IntWritable> {

    public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException {
            String line = value.toString();
            ArrayList<String> list = new ArrayList<>(Arrays.asList(line.split(",")));
            ArrayList<String> newList = new ArrayList<>();
            for(int i =0; i < list.size(); i++){
                if (list.get(i).length()==0){
                    continue;
                }
                if (list.get(i).charAt(0)=='"'){
                    String built = "";
                    while(list.get(i).charAt(list.get(i).length()-1) != '"'){
                        built += list.get(i) + ",";
                        i++;
                    }
                    built+=list.get(i);
                    newList.add(built);
                }
                else{
                    newList.add(list.get(i));
                }
            }
            String genres = newList.get(2);
            boolean matched = Pattern.matches(".*(Crime|Thriller|Mystery).*", genres);
            String year = newList.get(6);
            String movie = newList.get(1);
            if (matched== true){
                context.write(new Text(year), new IntWritable(1));
            }

        }
    }