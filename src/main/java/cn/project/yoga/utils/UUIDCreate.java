package cn.project.yoga.utils;


import java.util.UUID;

public class UUIDCreate {

    public static String createID(){

        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }

}
