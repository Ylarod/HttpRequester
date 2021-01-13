package cn.ylarod.devtools.core.model;

import java.util.List;

import cn.ylarod.devtools.core.db.entity.KeyValuePair;

public interface HttpResponseModel {
    String getCode();
    String getMessage();
    List<KeyValuePair> getHeaders();
    String getContent();
}
