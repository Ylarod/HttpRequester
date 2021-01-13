package cn.ylarod.devtools.core.db.entity;

import androidx.room.ColumnInfo;

import java.util.List;
import java.util.Map;

import cn.ylarod.devtools.core.model.HttpRequestModel;

public class HttpRequestEntity implements HttpRequestModel {
    public String method;
    public String url;
    public Map<String,String> parameters;
    @ColumnInfo(name = "request_headers")
    public Map<String,String> headers;
    @ColumnInfo(name = "request_body")
    public String body;

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setParameters(Map<String,String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void setHeaders(Map<String,String> headers) {
        this.headers = headers;
    }

    @Override
    public void setBody(String content) {
        this.body = content;
    }
}
