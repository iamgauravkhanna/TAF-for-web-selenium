mvn clean install test \
-Dbrowser=edge \
-DgroupToRun=tc001 \
-DtestEnvironment=project01 \
-DSuiteFilePath=src/test/resources/suites/project01.xml \
-DexecutionEnvironment=local \
-DskipEmail=true