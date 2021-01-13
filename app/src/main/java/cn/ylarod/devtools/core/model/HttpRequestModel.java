package cn.ylarod.devtools.core.model;

import java.util.List;

import cn.ylarod.devtools.core.db.entity.KeyValuePair;

public interface HttpRequestModel {
    void setProtocol(String protocol);
    void setMethod(String method);
    void setUrl(String url);
    void setParameters(List<KeyValuePair> parameters);
    void setHeaders(List<KeyValuePair> headers);
    void setContentType(String contentType);
    void setContent(String content);
}
