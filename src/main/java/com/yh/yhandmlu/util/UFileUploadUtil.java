package com.yh.yhandmlu.util;

import cn.ucloud.ufile.UFileClient;
import cn.ucloud.ufile.UFileConfig;
import cn.ucloud.ufile.UFileRequest;
import cn.ucloud.ufile.UFileResponse;
import cn.ucloud.ufile.sender.PostSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author chunxiao
 * @since 2018/5/17.
 */
public class UFileUploadUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(UFileUploadUtil.class);

    private static final int MAX_RETRY_COUNT = 1;

    private static final int UPLOAD_SUCCESS_CODE = 200;

    /**
     * @param filePath 文件路径
     */
    public static boolean uploadFile(String filePath) {

        UFileConfig config = UFileConfig.getInstance();

        config.setDownloadProxySuffix(".ufile.cn-north-02.ucloud.cn");
        config.setProxySuffix(".ufile.cn-north-02.ucloud.cn");
        config.setUcloudPrivateKey("7ead274f609b5ce4fe0b4da4679d1e3cb4ad5f1a");
        config.setUcloudPublicKey("jwQfA02RA3YjnGtbH4mdIbhyfIogrS4a6qDTLldr7Cg");

        String md5 = FileUtil.getFileMd5(filePath);

        /**
         * <pre>
         *  env     bucket_name     inner network                           outer network
         *
         *  qa      ic-xp-qa        ic-xp-qa.ufile.cn-north-02.ucloud.cn    ic-xp-qa.cn-bj.ufileos.com
         *  pre     ic-xp-pre       ic-xp-pre.ufile.cn-north-03.ucloud.cn   ic-xp-pre.cn-bj.ufileos.com
         *  pd      ic-xp           ic-xp.ufile.cn-north-03.ucloud.cn       ic-xp.cn-bj.ufileos.com
         *
         *  jwQfA02RA3YjnGtbH4mdIbhyfIogrS4a6qDTLldr7Cg=7ead274f609b5ce4fe0b4da4679d1e3cb4ad5f1a
         * </pre>
         *
         */
//        String bucketName = ConfigService.getAppConfig().getProperty("ic.xp.ufile.upload.bucketName", "ic-xp-qa");
//        String secretKey = ConfigService.getAppConfig().getProperty("ic.xp.ufile.upload.secretKey", "abc");
//        int retryCount = ConfigService.getAppConfig().getIntProperty("ic.xp.ufile.upload.retryCount", 1);

        UFileRequest request = new UFileRequest();
//        request.setBucketName(bucketName);
        request.setKey(md5);
        request.setFilePath(filePath);

        UFileClient ufileClient = null;
        try {
            ufileClient = new UFileClient();
//            return uploadFile(ufileClient, request, md5, retryCount);
            return uploadFile(ufileClient, request, md5, 0);
        } finally {
            if (ufileClient != null) {
                ufileClient.shutdown();
            }
        }
    }


    private static boolean uploadFile(UFileClient uFileClient, UFileRequest uFileRequest, String key,
                                      int retryCount) {

        if (retryCount > MAX_RETRY_COUNT) {
            return false;
        }
        UFileResponse response = null;
        try {
            PostSender sender = new PostSender();
            sender.makeAuth(uFileClient, uFileRequest);

            LOGGER.info("[UFileUploadUtil] before sender. key={} uFileClient={},uFileRequest={}", key, uFileClient, uFileRequest);
            response = sender.send(uFileClient, uFileRequest);
            LOGGER.info("[UFileUploadUtil.uploadFile] after sender.send. response={}, key={}", response, key);
        } catch (Throwable e) {
            LOGGER.error("[UFileUploadUtil] sender.send error  key={}", key, e);
            response = null;
        }

//        if (response != null && response.getStatusLine().getStatusCode() == UPLOAD_SUCCESS_CODE) {
//            return true;
//        }
        LOGGER.info("[UFileUploadUtil] Upload fail, retryCount={}, key={}", retryCount, key);
        uFileClient = new UFileClient();
        return uploadFile(uFileClient, uFileRequest, key, ++retryCount);
    }

}
