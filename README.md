# MoviesAndCrime

Crime Data
1. Crime Data can be found at: https://ucr.fbi.gov/crime-in-the-u.s/2016/crime-in-the-u.s.-2016/tables/table-1/table-1.xls#overview
2. Convert the xls file into a csv file. Ingest into Hadoop.
3. ETL and Profiling: getsetClean.sh and getsetCountRecs.sh
<br>a. Change the directories in the run.sh files to match your own directories.
<br>b. In runCountRecs.sh, uncomment the bottom two commands separately. The first command will count the records of the cleaned data, and the second will count the original data. 
<br>c. Run the getset files. The results will be in the part-r-00000 file.

Movie Data
1. Movie Data can be found at:
https://www.kaggle.com/PromptCloudHQ/imdb-data
2. Ingest the csv file into Hadoop.
3. ETL: Create an HDFS directory for output. Then compile and run MovieCountMapper, MovieCountReducer and MovieCount. This will output the number of crime related movies produced each year.
4. Profiling: Create an HDFS directory for output. Compile and run TotalCountMapper, TotalCountReducer and TotalCount. This will output the total number of movies produced each year.
5. The output from ETL and Profiling are both required for analysis so they must both be run.


Analysis
1. In crimeAna.q, change the locations in the commands to match your own HDFS directories to access the cleaned data
2. crimeAna.q contains all the commands we used
