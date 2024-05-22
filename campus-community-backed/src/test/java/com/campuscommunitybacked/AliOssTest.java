package com.campuscommunitybacked;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

public class AliOssTest {
    // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
    private static final String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    // 填写Bucket名称，例如examplebucket。
    private static final String bucketName = "intelligent-campus-community";
    private static final String accessKeyId = "LTAI5tGFz5oK23HyqZtf42ci";
    private static final String accessKeySecret = "WILAnGCTFIdrHEhnwf7bME5tz6ZaKb";
    public static void main(String[] args) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String filePath = "users/"+ UUID.randomUUID().toString() + ".png";
        System.out.println(filePath);
        try {
            ossClient.putObject(bucketName, filePath, new FileInputStream("C:\\Users\\86150\\Pictures\\pivix\\41028787_p0.jpg"));
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException | FileNotFoundException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
