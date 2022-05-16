mvn clean install test \
-Dbrowser=chrome \
-DgroupToRun=tc006 \
-DtestEnvironment=project06 \
-DSuiteFilePath=src/test/resources/suites/project06.xml \
-DexecutionEnvironment=local \
-DskipEmail=true