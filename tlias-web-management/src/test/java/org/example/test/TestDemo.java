package org.example.test;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) throws Exception {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-beijing.aliyuncs.com";



        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "your accessKeyId";
        String accessKeySecret = "your accessKeySecret";

        // 填写Bucket名称，例如examplebucket。
        String bucketName = "your bucketName";
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        //String objectName = "1.jpg";//定死了图片的上传名称  需要改成动态的
        //2024/12/11
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String format = simpleDateFormat.format(new Date());
        // /2024/12/11/时间戳
        String objectName = format + "/" + System.currentTimeMillis() + ".jpg";

        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath= "C:\\Users\\Bing\\Desktop\\MNKIPFVIZZ%FNG2@E@)9F58.png";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = new FileInputStream(filePath);
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            // 设置该属性可以返回response。如果不设置，则返回的response为空。
            putObjectRequest.setProcess("true");
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            // 如果上传成功，则返回200。
            System.out.println(result.getResponse().getStatusCode());
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
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


    /**
     * 第一部分(加密的算法 和盐 ).第二部分(核心数据).第三部分 ( 由第一部分和第二部分 加密后得到第三部分)
     * 123 -> 加密后  aaa   因为里面有算法
     * A同学 123 -> 加密后  aaa   因为里面有算法
     * B同学 123 -> 加密后  aaa   因为里面有算法
     * C同学 123 -> 加密后  aaa   因为里面有算法
     *
     * 加盐(每一个程序中 自定义一个特殊的字符串拼接到数据中)
     * A同学 123+zhanbgsan -> 加密后  qqqqq   因为里面有算法
     * B同学 123+lisi      -> 加密后  ttttt   因为里面有算法
     * C同学 123+wangwu    -> 加密后  yyyyyyyyy   因为里面有算法
     */
    @Test
    public void genJwt(){
        //核心数据
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","jack");

        String jwt = Jwts.builder()
                .setClaims(claims) //自定义内容(载荷)    设置核心数据部分  第二部分
                .signWith(SignatureAlgorithm.HS256, "example") //签名算法  第一部分
                .setExpiration(new Date(System.currentTimeMillis() + 60*60*24*1000)) //有效期
                .compact(); //生成加密

        System.out.println(jwt);
    }
    //eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzM0ODM1OTYwLCJ1c2VybmFtZSI6IlRvbSJ9.oMvm20H2LsD6rSYPkY0Vi2ay_ob_vURWhMQgiJV66-A

    //eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzM0ODU0NDg0LCJ1c2VybmFtZSI6ImphY2sifQ.SMQ3gZ4DnwuY4Gwu2UjVG0BKGVyThbFQACCReHBgjiQ

    @Test
    public void parseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("example")//指定签名密钥（必须保证和生成令牌时使用相同的签名密钥）
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzM0ODU0NDg0LCJ1c2VybmFtZSI6ImphY2sifQ.SMQ3gZ4DnwuY4Gwu2UjVG0BKGVyThbFQACCReHBgjiQ")
                .getBody();

        System.out.println(claims);
    }
}

