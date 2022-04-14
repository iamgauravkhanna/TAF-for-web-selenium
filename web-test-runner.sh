mvn clean install test \
-DgroupToRun=tc004 \
-Dbrowser=chrome \
-DtestEnvironment=project04 \
-DSuiteFilePath=src/test/resources/suites/master.xml \
-DexecutionEnvironment=local \
-DskipEmail=true