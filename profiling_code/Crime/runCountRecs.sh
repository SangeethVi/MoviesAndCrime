javac -classpath `yarn classpath` -d . CountRecsMapper.java
javac -classpath `yarn classpath` -d . CountRecsReducer.java
javac -classpath `yarn classpath`:. -d . CountRecs.java

jar -cvf countRecs.jar *.class

# cleaned dataset (should be 244)
# hadoop jar countRecs.jar CountRecs /user/clg469/project/output/part-r-00000 /user/clg469/project/count

# original dataset (should be 408)
# hadoop jar countRecs.jar CountRecs /user/clg469/project/table-1.csv /user/clg469/project/count

