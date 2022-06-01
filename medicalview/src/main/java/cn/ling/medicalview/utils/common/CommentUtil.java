package cn.ling.medicalview.utils.common;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/**
 * @program: medical2
 * @author: zhanling.li
 * @create: 2021-04-25 22:38
 */
public class CommentUtil {

    /* *
     *获取唯一标识 uuid
     *
     * @Param: []
     * @return: java.lang.String
     * @author: zhanling.li
     * @date: 2021/4/25
     */
    public static String getUuidStr() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /* * 
     *生成唯一标识token
     *
     * @Param: []
     * @return: java.lang.String
     * @author: zhanling.li
     * @date: 2021/5/9
    */
    public static String makeToken() {
        //  7346734837483  834u938493493849384  43434384
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        System.out.println("唯一标识 = "+token);
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        System.out.println("uuid = " + CommentUtil.getUuidStr());
        System.out.println("token= "+CommentUtil.makeToken());
    }
}
