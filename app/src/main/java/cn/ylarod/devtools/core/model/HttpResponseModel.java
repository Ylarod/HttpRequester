package cn.ylarod.devtools.core.model;

import java.util.Map;

public interface HttpResponseModel {
    String getCode();
    String getMessage();
    Map<String,String> getHeaders();
    String getContent();
}
