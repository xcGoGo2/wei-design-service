package com.design.weidesignservice.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class ResultDTO<T> extends com.design.weidesignservice.result.AbstractResultDTO {
    private static final long serialVersionUID = 1668914867578552488L;
    @ApiModelProperty(value = "业务数据", position = 1)
    private T data;
    private String message;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty(value = "data", index = 2)
    public T getData() {
        return this.data;
    }

    private void setData(T data) {
        this.data = data;
    }

    private void setMessage(String msg) {
        this.message = msg;
    }
    @JsonProperty(value = "message", index = 3)
    public String getMessage() {
        return this.message;
    }

    public ResultDTO() {
    }

    ResultDTO(Status status) {
        this.status = status;
    }

    public static <T> ResultDTO<T> success() {
        return new ResultDTO<T>(Status.success);
    }

    public static <T> ResultDTO<T> failure(com.design.weidesignservice.result.ResultError... errors) {
        ResultDTO<T> result = new ResultDTO<T>(Status.failure);
        result.setErrors(errors);
        return result;
    }

    /**
     *
     * @param data 返回数据
     * @param msg 返回信息
     * @return ResultDTO
     */
    public static <T> ResultDTO<T> success(T data, String msg) {
        ResultDTO<T> result = new ResultDTO<T>(Status.success);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }

    public static <T> ResultDTO<T> failure(T data, com.design.weidesignservice.result.ResultError... errors) {
        ResultDTO<T> result = new ResultDTO<T>(Status.failure);
        result.setData(data);
        result.setErrors(errors);
        return result;
    }
}