mvn clean install test \
-DgroupToRun=tc003 \
-DEnvironmentFilePath=ngage.properties \
-DSuiteFilePath=src/test/resources/suites/master.xml \
-Dbrowser=firefox \
-DexecutionEnvironment=local \
-DtestEnvironment=project01 \
-DskipEmail=true