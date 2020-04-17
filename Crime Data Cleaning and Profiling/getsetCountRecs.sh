rm *.class
rm *.jar
hdfs dfs -rm -r project/count
./runCountRecs.sh

hdfs dfs -cat project/count/part-r-00000
