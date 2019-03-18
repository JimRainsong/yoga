package cn.project.yoga.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Encoder {
    /**
     * 传入用户名与密码，以用户名为盐值加密两次
     */
    public static String md5Encode(String userName, String password) {
        return new Md5Hash(password, userName, 2).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Md5Hash("123","test",2).toString());
    }
}
