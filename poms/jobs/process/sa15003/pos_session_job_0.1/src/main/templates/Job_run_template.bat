%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/httpclient-4.5.13.jar;../lib/commons-codec-1.14.jar;../lib/jackson-core-2.11.4.jar;../lib/joda-time-2.8.1.jar;../lib/commons-logging-1.2.jar;../lib/httpcore-4.4.13.jar;../lib/aws-java-sdk-1.11.848.jar;../lib/jackson-annotations-2.11.4.jar;../lib/jackson-databind-2.11.4.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/postgresql-42.2.14.jar;../lib/talendcsv-1.0.0.jar;../lib/crypto-utils-0.31.12.jar;pos_session_job_0_1.jar; pacifico.pos_session_job_0_1.pos_session_job %*
