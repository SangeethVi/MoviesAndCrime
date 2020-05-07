rm *.class
rm *.jar
hdfs dfs -rm -r project/output
./runClean.sh

hdfs dfs -cat project/output/part-r-00000
