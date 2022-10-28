// ============================================================================
//
// Copyright (c) 2006-2015, Talend Inc.
//
// This source code has been automatically generated by_Talend Open Studio for Data Integration
// / Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package pacifico.productproduct_stage_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: productProduct_stage Purpose: <br>
 * Description: Move account taxt data to stage <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class productProduct_stage implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "productProduct_stage";
	private final String projectName = "PACIFICO";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					productProduct_stage.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(productProduct_stage.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tS3Connection_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tS3Connection_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tS3Copy_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tS3Copy_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tS3Connection_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tS3Copy_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tS3Connection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tS3Connection_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tS3Connection_1 begin ] start
				 */

				ok_Hash.put("tS3Connection_1", false);
				start_Hash.put("tS3Connection_1", System.currentTimeMillis());

				currentComponent = "tS3Connection_1";

				int tos_count_tS3Connection_1 = 0;

				final String decryptedPassword_tS3Connection_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:h/RwrHq8JQyu3rad3MXMQVSGSqIOBq69PReM3EnmleqotZ8DdvrHCsMGfE+FNuxYZyeR4+28d/pMlVNauxpVIo7GqMA=");

				com.amazonaws.auth.AWSCredentials credentials_tS3Connection_1 = new com.amazonaws.auth.BasicAWSCredentials(
						"AKIAVMNG53PS4OCUVYGK", decryptedPassword_tS3Connection_1);
				com.amazonaws.auth.AWSCredentialsProvider credentialsProvider_tS3Connection_1 = new com.amazonaws.auth.AWSStaticCredentialsProvider(
						credentials_tS3Connection_1);

				com.amazonaws.ClientConfiguration cc_tS3Connection_1 = new com.amazonaws.ClientConfiguration();
				cc_tS3Connection_1.setUserAgent("APN/1.0 Talend/8.0 Studio/8.0 (Talend Open Studio)");

				com.amazonaws.services.s3.AmazonS3ClientBuilder builder_tS3Connection_1 = com.amazonaws.services.s3.AmazonS3ClientBuilder
						.standard();

				final boolean useRegionEndpoint_tS3Connection_1 = false;
				final String regionEndpoint_tS3Connection_1 = "s3.amazonaws.com";
				final boolean enableAccelerateMode_tS3Connection_1 = false;
				final boolean enablePathStyleAccess_tS3Connection_1 = false;

				if (useRegionEndpoint_tS3Connection_1 && regionEndpoint_tS3Connection_1 != null
						&& !regionEndpoint_tS3Connection_1.isEmpty()) {
					builder_tS3Connection_1
							.withEndpointConfiguration(
									new com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration(
											regionEndpoint_tS3Connection_1, null))
							.withForceGlobalBucketAccessEnabled(true);
				} else {
					builder_tS3Connection_1.withRegion("us-east-1") // The first region to try your request against
							.withForceGlobalBucketAccessEnabled(true); // If a bucket is in a different region, try
																		// again in the correct region
				}

				if (enableAccelerateMode_tS3Connection_1) {
					builder_tS3Connection_1.withAccelerateModeEnabled(true);
				}

				builder_tS3Connection_1.withCredentials(credentialsProvider_tS3Connection_1)
						.withClientConfiguration(cc_tS3Connection_1);

				if (useRegionEndpoint_tS3Connection_1 && enablePathStyleAccess_tS3Connection_1) {
					builder_tS3Connection_1.enablePathStyleAccess();
				}

				com.amazonaws.services.s3.AmazonS3 conn_tS3Connection_1 = builder_tS3Connection_1.build();

				// This method is just for test connection.
				conn_tS3Connection_1.getS3AccountOwner();

				globalMap.put("conn_" + "tS3Connection_1", conn_tS3Connection_1);

				/**
				 * [tS3Connection_1 begin ] stop
				 */

				/**
				 * [tS3Connection_1 main ] start
				 */

				currentComponent = "tS3Connection_1";

				tos_count_tS3Connection_1++;

				/**
				 * [tS3Connection_1 main ] stop
				 */

				/**
				 * [tS3Connection_1 process_data_begin ] start
				 */

				currentComponent = "tS3Connection_1";

				/**
				 * [tS3Connection_1 process_data_begin ] stop
				 */

				/**
				 * [tS3Connection_1 process_data_end ] start
				 */

				currentComponent = "tS3Connection_1";

				/**
				 * [tS3Connection_1 process_data_end ] stop
				 */

				/**
				 * [tS3Connection_1 end ] start
				 */

				currentComponent = "tS3Connection_1";

				ok_Hash.put("tS3Connection_1", true);
				end_Hash.put("tS3Connection_1", System.currentTimeMillis());

				/**
				 * [tS3Connection_1 end ] stop
				 */
			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tS3Connection_1:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tS3Copy_1Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tS3Connection_1 finally ] start
				 */

				currentComponent = "tS3Connection_1";

				/**
				 * [tS3Connection_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tS3Connection_1_SUBPROCESS_STATE", 1);
	}

	public void tS3Copy_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tS3Copy_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tS3Copy_1 begin ] start
				 */

				ok_Hash.put("tS3Copy_1", false);
				start_Hash.put("tS3Copy_1", System.currentTimeMillis());

				currentComponent = "tS3Copy_1";

				int tos_count_tS3Copy_1 = 0;

				com.amazonaws.services.s3.AmazonS3Client conn_tS3Copy_1 = (com.amazonaws.services.s3.AmazonS3Client) globalMap
						.get("conn_tS3Connection_1");

				try {

					long partSizeInBytes_tS3Copy_1 = 100 * 1024 * 1024;
					long maxBytes4SingleCopyCall_tS3Copy_1 = 5120 * 1024 * 1024;
					com.amazonaws.services.s3.model.ObjectMetadata objectMetadata_tS3Copy_1 = null;

					final String from_bucket_tS3Copy_1 = "libreriapacifico/raw";
					final String from_key_tS3Copy_1 = "productProduct_20221026.csv";
					final String to_bucket_tS3Copy_1 = "libreriapacifico/stage";
					final String to_key_tS3Copy_1 = "productProduct.csv";

					// get the source metadata information
					com.amazonaws.services.s3.model.GetObjectMetadataRequest metadataRequest_tS3Copy_1 = new com.amazonaws.services.s3.model.GetObjectMetadataRequest(
							from_bucket_tS3Copy_1, from_key_tS3Copy_1);
					com.amazonaws.services.s3.model.ObjectMetadata metadataResult_tS3Copy_1 = conn_tS3Copy_1
							.getObjectMetadata(metadataRequest_tS3Copy_1);
					long objectSize_tS3Copy_1 = metadataResult_tS3Copy_1.getContentLength();

					boolean multiUpload_tS3Copy_1 = objectSize_tS3Copy_1 > maxBytes4SingleCopyCall_tS3Copy_1;

					if (!multiUpload_tS3Copy_1) {
						com.amazonaws.services.s3.model.CopyObjectRequest putRequest_tS3Copy_1 = new com.amazonaws.services.s3.model.CopyObjectRequest(
								from_bucket_tS3Copy_1, from_key_tS3Copy_1, to_bucket_tS3Copy_1, to_key_tS3Copy_1);
						if (objectMetadata_tS3Copy_1 != null) {
							putRequest_tS3Copy_1.setNewObjectMetadata(objectMetadata_tS3Copy_1);
						}

						conn_tS3Copy_1.copyObject(putRequest_tS3Copy_1);
					} else {
						java.util.Map<String, String> userMetadata_tS3Copy_1 = metadataResult_tS3Copy_1
								.getUserMetadata();
						if ((userMetadata_tS3Copy_1 != null) && userMetadata_tS3Copy_1.get("x-amz-iv") != null) {
							throw new RuntimeException(
									"the metadata key : \"x-amz-iv\" exists in the current object metadata, its value is important for client encrypt with KMS, which can't be copied as s3 service limit it");
						}

						com.amazonaws.services.s3.model.InitiateMultipartUploadRequest putRequest_tS3Copy_1 = null;
						if (objectMetadata_tS3Copy_1 != null) {
							putRequest_tS3Copy_1 = new com.amazonaws.services.s3.model.InitiateMultipartUploadRequest(
									to_bucket_tS3Copy_1, to_key_tS3Copy_1, objectMetadata_tS3Copy_1);
						} else {
							// even pass the source object metadata, some metadata will change too like
							// "x-amz-iv"
							putRequest_tS3Copy_1 = new com.amazonaws.services.s3.model.InitiateMultipartUploadRequest(
									to_bucket_tS3Copy_1, to_key_tS3Copy_1, metadataResult_tS3Copy_1);
						}

						com.amazonaws.services.s3.model.InitiateMultipartUploadResult initResult_tS3Copy_1 = conn_tS3Copy_1
								.initiateMultipartUpload(putRequest_tS3Copy_1);

						long bytePosition_tS3Copy_1 = 0;
						int partNum_tS3Copy_1 = 1;

						java.util.List<com.amazonaws.services.s3.model.PartETag> partTags_tS3Copy_1 = new java.util.ArrayList<com.amazonaws.services.s3.model.PartETag>();

						try {
							while (bytePosition_tS3Copy_1 < objectSize_tS3Copy_1) {
								long lastByte_tS3Copy_1 = java.lang.Math.min(
										bytePosition_tS3Copy_1 + partSizeInBytes_tS3Copy_1 - 1,
										objectSize_tS3Copy_1 - 1);

								com.amazonaws.services.s3.model.CopyPartRequest copyPartRequest_tS3Copy_1 = new com.amazonaws.services.s3.model.CopyPartRequest()
										.withSourceBucketName(from_bucket_tS3Copy_1).withSourceKey(from_key_tS3Copy_1)
										.withDestinationBucketName(to_bucket_tS3Copy_1)
										.withDestinationKey(to_key_tS3Copy_1)
										.withUploadId(initResult_tS3Copy_1.getUploadId())
										.withFirstByte(bytePosition_tS3Copy_1).withLastByte(lastByte_tS3Copy_1)
										.withPartNumber(partNum_tS3Copy_1++);
								partTags_tS3Copy_1
										.add(conn_tS3Copy_1.copyPart(copyPartRequest_tS3Copy_1).getPartETag());
								bytePosition_tS3Copy_1 += partSizeInBytes_tS3Copy_1;
							}

							com.amazonaws.services.s3.model.CompleteMultipartUploadRequest completeRequest_tS3Copy_1 = new com.amazonaws.services.s3.model.CompleteMultipartUploadRequest(
									to_bucket_tS3Copy_1, to_key_tS3Copy_1, initResult_tS3Copy_1.getUploadId(),
									partTags_tS3Copy_1);
							conn_tS3Copy_1.completeMultipartUpload(completeRequest_tS3Copy_1);
						} catch (java.lang.Exception uploadException_tS3Copy_1) {
							globalMap.put("tS3Copy_1_ERROR_MESSAGE", uploadException_tS3Copy_1.getMessage());
							conn_tS3Copy_1.abortMultipartUpload(
									new com.amazonaws.services.s3.model.AbortMultipartUploadRequest(to_bucket_tS3Copy_1,
											to_key_tS3Copy_1, initResult_tS3Copy_1.getUploadId()));
							throw uploadException_tS3Copy_1;
						}
					}

				} catch (java.lang.Exception e_tS3Copy_1) {
					globalMap.put("tS3Copy_1_ERROR_MESSAGE", e_tS3Copy_1.getMessage());
					System.err.println(e_tS3Copy_1.getMessage());
				}

				/**
				 * [tS3Copy_1 begin ] stop
				 */

				/**
				 * [tS3Copy_1 main ] start
				 */

				currentComponent = "tS3Copy_1";

				tos_count_tS3Copy_1++;

				/**
				 * [tS3Copy_1 main ] stop
				 */

				/**
				 * [tS3Copy_1 process_data_begin ] start
				 */

				currentComponent = "tS3Copy_1";

				/**
				 * [tS3Copy_1 process_data_begin ] stop
				 */

				/**
				 * [tS3Copy_1 process_data_end ] start
				 */

				currentComponent = "tS3Copy_1";

				/**
				 * [tS3Copy_1 process_data_end ] stop
				 */

				/**
				 * [tS3Copy_1 end ] start
				 */

				currentComponent = "tS3Copy_1";

				ok_Hash.put("tS3Copy_1", true);
				end_Hash.put("tS3Copy_1", System.currentTimeMillis());

				/**
				 * [tS3Copy_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tS3Copy_1 finally ] start
				 */

				currentComponent = "tS3Copy_1";

				/**
				 * [tS3Copy_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tS3Copy_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final productProduct_stage productProduct_stageClass = new productProduct_stage();

		int exitCode = productProduct_stageClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = productProduct_stage.class.getClassLoader()
					.getResourceAsStream("pacifico/productproduct_stage_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = productProduct_stage.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tS3Connection_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tS3Connection_1) {
			globalMap.put("tS3Connection_1_SUBPROCESS_STATE", -1);

			e_tS3Connection_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : productProduct_stage");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {
		closeS3Connections();

	}

	private void closeS3Connections() {
		try {
			com.amazonaws.services.s3.AmazonS3Client conn_tS3Connection_1 = (com.amazonaws.services.s3.AmazonS3Client) globalMap
					.get("conn_tS3Connection_1");
			if (conn_tS3Connection_1 != null) {
				conn_tS3Connection_1.shutdown();
			}
		} catch (java.lang.Exception e) {
		}
	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		connections.put("conn_tS3Connection_1", globalMap.get("conn_tS3Connection_1"));

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 39130 characters generated by Talend Open Studio for Data Integration on the
 * October 27, 2022 at 10:53:16 PM CST
 ************************************************************************************************/