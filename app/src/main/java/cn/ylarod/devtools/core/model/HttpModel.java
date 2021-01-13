package cn.ylarod.devtools.core.model;

import java.util.Date;

import cn.ylarod.devtools.core.db.entity.HttpRequestEntity;
import cn.ylarod.devtools.core.db.entity.HttpResponseEntity;

public interface HttpModel {
    Date getStartTime();
    void setStartTime(Date startTime);
    Date getEndTime();
    void setEndTime(Date endTime);
    HttpRequestEntity getHttpRequestEntity();
    void setHttpRequestEntity(HttpRequestEntity httpRequestEntity);
    HttpResponseEntity getHttpResponseEntity();
    void setHttpResponseEntity(HttpResponseEntity httpResponseEntity);
}
