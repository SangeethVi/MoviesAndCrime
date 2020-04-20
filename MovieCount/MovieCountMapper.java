import java.io.IOException;
import java.util.regex.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MovieCountMapper 
    extends Mapper<LongWritable, Text, Text, IntWritable> {
    
    public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException {
            String line = value.toString();
            ArrayList<String> list = new ArrayList<>(Arrays.asList(line.split(",")));
            String genres = list[2];
            boolean matched = Pattern.matches("Crime", genres);
            boolean matched1 = Pattern.matches("Thriller", genres);
            Int year = list[6];
            if ((matched== true)||(matched1== true)){
                context.write(new Text(year), new IntWritable(1));
            }

}
    }