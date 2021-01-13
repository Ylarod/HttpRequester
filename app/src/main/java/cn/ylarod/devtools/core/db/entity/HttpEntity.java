package cn.ylarod.devtools.core.db.entity;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

import cn.ylarod.devtools.core.model.HttpModel;


@Entity(tableName = "http_db")
public class HttpEntity implements HttpModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public Date startTime;
    public Date endTime;

    @Embedded
    public HttpRequestEntity httpRequestEntity;

    @Embedded
    public HttpResponseEntity httpResponseEntity;

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public HttpRequestEntity getHttpRequestEntity() {
        return httpRequestEntity;
    }

    @Override
    public void setHttpRequestEntity(HttpRequestEntity httpRequestEntity) {
        this.httpRequestEntity = httpRequestEntity;
    }

    @Override
    public HttpResponseEntity getHttpResponseEntity() {
        return httpResponseEntity;
    }

    @Override
    public void setHttpResponseEntity(HttpResponseEntity httpResponseEntity) {
        this.httpResponseEntity = httpResponseEntity;
    }
}
