package cn.project.yoga.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Attributes {
    /**
     * 这里存放一些名词
     */

    public static final String currentUserName = "currentUserName";

    public static final String currentTeacherId = "currentTeacherId";

    public static final String currentUserId = "currentUserId";


    public  static final String currentTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

}
