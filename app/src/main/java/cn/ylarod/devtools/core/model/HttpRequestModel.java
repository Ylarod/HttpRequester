package cn.ylarod.devtools.core.model;

import java.util.Map;

public interface HttpRequestModel {
    void setMethod(String method);
    void setUrl(String url);
    void setParameters(Map<String,String> parameters);
    void setHeaders(Map<String,String> headers);
    void setBody(String content);
}
