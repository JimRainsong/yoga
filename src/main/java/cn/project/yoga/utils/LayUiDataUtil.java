package cn.project.yoga.utils;

public class LayUiDataUtil {
    private Integer code;
    private String msg;
    private Long count;
    private Object data;


    public LayUiDataUtil(Integer code, String msg, Long total, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
    public LayUiDataUtil(){

    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data=data;
    }

    public LayUiDataUtil(Integer code) {
        this.code = code;
    }
    public LayUiDataUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public LayUiDataUtil(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
    public static LayUiDataUtil ok(){
        return new LayUiDataUtil(0);
    }

    public static LayUiDataUtil ok(String msg){
        return new LayUiDataUtil(0,msg);
    }

    public static LayUiDataUtil ok(Object data){
        return new LayUiDataUtil(0,data);
    }

    public static LayUiDataUtil error(){
        return new LayUiDataUtil(500);
    }

    public static LayUiDataUtil error(String msg){
        return new LayUiDataUtil(500,msg);
    }
    
}
