package com.bjpowernode.mp06.vo;

import lombok.Data;

/**
 * @author xuzihao
 * @param <T>
 */

@Data
public class ResultData<T> {
    private int status;
    private String message;
    private T data;


    public ResultData (){

    }


    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(ReturnCode.RC100.getCode());
        resultData.setMessage(ReturnCode.RC100.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }



}
