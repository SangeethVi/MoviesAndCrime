javac -classpath `yarn classpath` -d . CleanMapper.java
javac -classpath `yarn classpath` -d . CleanReducer.java
javac -classpath `yarn classpath`:. -d . Clean.java

jar -cvf clean.jar *.class

hadoop jar clean.jar Clean /user/clg469/project/table-1.csv /user/clg469/project/output

