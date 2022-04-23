mvn clean install test \
-DgroupToRun=tc004 \
-Dbrowser=chrome \
-DtestEnvironment=project01 \
-DSuiteFilePath=src/test/resources/suites/project01.xml \
-DexecutionEnvironment=local \
-DskipEmail=true