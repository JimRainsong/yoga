package cn.project.yoga.utils;

public class FilePathUtil {
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");

    public static String getRealFilePath(String path) {
        return path.replace("/", FILE_SEPARATOR).replace("\\", FILE_SEPARATOR);
    }

    public static String getHttpURLPath(String path) {
        return path.replace("\\", "/");
    }
}