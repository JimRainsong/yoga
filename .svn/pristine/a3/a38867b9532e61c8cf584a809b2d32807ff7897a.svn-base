package cn.project.yoga.utils;

/**
 * JSON数据响应结果的封装类
 */
public class ResultUtil {
    /**
     * 返回结果的状态码 0 表示成功
     */
    private Integer code;
    /**
     * 返回消息数据
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultUtil() {
    }

    public ResultUtil(Integer code) {
        this.code = code;
    }

    public ResultUtil(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultUtil(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static ResultUtil ok(){
        return new ResultUtil(0);
    }

    public static ResultUtil ok(String msg){
        return new ResultUtil(0,msg);
    }

    public static ResultUtil ok(Object data){
        return new ResultUtil(0,data);
    }

    public static ResultUtil error(){
        return new ResultUtil(500);
    }

    public static ResultUtil error(String msg){
        return new ResultUtil(500,msg);
    }
}
