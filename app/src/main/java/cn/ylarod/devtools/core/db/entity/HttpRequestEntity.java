package cn.ylarod.devtools.core.db.entity;

import androidx.room.ColumnInfo;

import java.util.List;

import cn.ylarod.devtools.core.model.HttpRequestModel;

public class HttpRequestEntity implements HttpRequestModel {
    public String protocol;
    public String method;
    public String url;
    public List<KeyValuePair> parameters;
    @ColumnInfo(name = "request_headers")
    public List<KeyValuePair> headers;
    @ColumnInfo(name = "request_content_type")
    public String contentType;
    @ColumnInfo(name = "request_content")
    public String content;

    @Override
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setParameters(List<KeyValuePair> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void setHeaders(List<KeyValuePair> headers) {
        this.headers = headers;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }
}
