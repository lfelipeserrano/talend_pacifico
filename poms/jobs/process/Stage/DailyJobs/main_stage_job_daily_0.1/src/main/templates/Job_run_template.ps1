$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' -cp '.;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/httpclient-4.5.13.jar;../lib/talend_file_enhanced-1.1.jar;../lib/commons-codec-1.14.jar;../lib/jackson-core-2.11.4.jar;../lib/joda-time-2.8.1.jar;../lib/commons-logging-1.2.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/httpcore-4.4.13.jar;../lib/aws-java-sdk-1.11.848.jar;../lib/jackson-annotations-2.11.4.jar;../lib/jackson-databind-2.11.4.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/trove.jar;../lib/talendcsv-1.0.0.jar;../lib/crypto-utils-0.31.12.jar;main_stage_job_daily_0_1.jar;putaccounttaxstage_dailyjob_0_1.jar;putsaleordertemplateline_dailyjob_0_1.jar;getstage_rescountrystate_0_1.jar;runposbillstage_dailyjob_0_1.jar;putposbillstage_dailyjob_0_1.jar;putsaleordertemplateoption_dailyjob_0_1.jar;getstage_productproduct_0_1.jar;dailyjobstage_rescountrystate_0_1.jar;getsaleordertemplateoptionstage_dailyjob_0_1.jar;rundailyjob_productattribute_0_1.jar;dailyjobstage_productattribute_0_1.jar;rundailyjob_productcategory_0_1.jar;putsaleordertemplatestage_dailyjob_0_1.jar;getstage_productattribute_0_1.jar;runaccounttaxstage_dailyjob_0_1.jar;putposconfigstage_dailyjob_0_1.jar;rundailyjob_producttemplate_0_1.jar;getposbillstage_dailyjob_0_1.jar;getstage_rescountry_0_1.jar;rundailyjob_posorder_0_1.jar;dailyjobstage_productproduct_0_1.jar;runsaleordertemplatestage_dailyjob_0_1.jar;rundailyjob_productproduct_0_1.jar;dailyjobstage_productcategory_0_1.jar;runsaleorderoptionstage_dailyjob_0_1.jar;rundailyjob_rescountrystate_0_1.jar;getstage_productcategory_0_1.jar;dailyjobstage_pospaymentmethod_0_1.jar;dailyjobstage_saleorder_0_1.jar;getsaleorderoption_dailyjob_0_1.jar;getstage_rescompany_0_1.jar;rundailyjob_saleorder_0_1.jar;rundailyjob_pospayment_0_1.jar;rundailyjob_possession_0_1.jar;rundailyjob_rescompany_0_1.jar;dailyjobstage_producttemplate_0_1.jar;rundailyjob_rescountry_0_1.jar;getstage_saleorder_0_1.jar;runposconfigstage_dailyjob_0_1.jar;getstage_pospaymentmethod_0_1.jar;dailyjobstage_possession_0_1.jar;dailyjobstage_rescountry_0_1.jar;getstage_posorderline_0_1.jar;getstage_possession_0_1.jar;getsaleordertemplatestage_dailyjob_0_1.jar;runsaleordertemplatelinestage_dailyjob_0_1.jar;getstage_posorder_0_1.jar;getstage_producttemplate_0_1.jar;dailyjobstage_posorder_0_1.jar;getaccounttaxstage_dailyjob_0_1.jar;runsaleordertemplateoptionstage_dailyjob_0_1.jar;getsaleordertemplatelinestage_dailyjob_0_1.jar;getstage_pospayment_0_1.jar;dailyjobstage_rescompany_0_1.jar;rundailyjob_posorderline_0_1.jar;productattributevalue_0_1.jar;rundailyjob_pospaymentmethod_0_1.jar;dailyjob_posorderline_0_1.jar;putsaleorderoptionstage_dailyjob_0_1.jar;dailyjobstage_pospayment_0_1.jar;getposconfigstage_dailyjob_0_1.jar;productattributeproducttemplaterel_0_1.jar;' pacifico.main_stage_job_daily_0_1.main_stage_job_daily --context=Default $args
