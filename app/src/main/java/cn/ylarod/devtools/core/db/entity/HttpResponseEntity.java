package cn.ylarod.devtools.core.db.entity;

import androidx.room.ColumnInfo;

import java.util.List;
import java.util.Map;

import cn.ylarod.devtools.core.model.HttpResponseModel;

public class HttpResponseEntity implements HttpResponseModel {
    public String code;
    public String message;
    @ColumnInfo(name = "response_headers")
    public Map<String,String> headers;
    @ColumnInfo(name = "response_content")
    public String content;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Map<String,String> getHeaders() {
        return headers;
    }

    @Override
    public String getContent() {
        return content;
    }
}
