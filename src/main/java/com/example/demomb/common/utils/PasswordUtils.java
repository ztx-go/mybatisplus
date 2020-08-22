package com.example.demomb.common.utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.RandomStringUtils;
//import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;

/**
 *  <p> 加密工具 </p>
 *
 * @description:
 * @author: zhengqing
 * @date: 2019/10/13 0013 15:25
 */
@Slf4j
public class PasswordUtils {

    /**
     * 校验密码是否一致
     *
     * @param password: 前端传过来的密码
     * @param hashedPassword：数据库中储存加密过后的密码
     * @param salt：盐值
     * @return
     */
    public static boolean isValidPassword(String password, String hashedPassword, String salt) {
        return hashedPassword.equalsIgnoreCase(encodePassword(password, salt));
    }

    /**
     * 通过SHA1对密码进行编码
     *
     * @param password：密码
     * @param salt：盐值
     * @return
     */
    public static String encodePassword(String password, String salt) {
        String encodedPassword;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            if (salt != null) {
                digest.reset();
                digest.update(salt.getBytes());
            }
            byte[] hashed = digest.digest(password.getBytes());
            int iterations = 2;
            for (int i = 0; i < iterations; ++i) {
                digest.reset();
                hashed = digest.digest(hashed);
            }
//            encodedPassword = new String(Hex.encode(hashed));
            encodedPassword = new String(Hex.encodeHex(hashed));

        } catch (Exception e) {
            log.error("验证密码异常:", e);
            return null;
        }
        return encodedPassword;
    }

    public static void main(String[] args) {
        String salt = RandomStringUtils.randomAlphanumeric(24);
        System.out.println(salt);
        System.out.println(encodePassword("123456", salt));
        System.out.println(Integer.MAX_VALUE);
    }

}
