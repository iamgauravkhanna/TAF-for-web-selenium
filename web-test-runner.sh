mvn clean install test \
-DgroupToRun=tc003 \
-Dbrowser=firefox \
-DtestEnvironment=project01 \
-DSuiteFilePath=src/test/resources/suites/master.xml \
-DexecutionEnvironment=local \
-DskipEmail=true