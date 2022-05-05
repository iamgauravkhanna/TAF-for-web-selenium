mvn clean install test \
-Dbrowser=chrome \
-DtestEnvironment=project01 \
-DSuiteFilePath=src/test/resources/suites/project01.xml \
-DexecutionEnvironment=local \
-DgroupToRun=tc004 \
-DskipEmail=true