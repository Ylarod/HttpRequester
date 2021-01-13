package cn.ylarod.devtools.ui.main.http;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.ColumnInfo;

import java.util.List;

import cn.ylarod.devtools.core.db.entity.KeyValuePair;

public class HttpRequestViewModel extends ViewModel {
    private final MutableLiveData<String> protocol;
    private final MutableLiveData<String> method;
    private final MutableLiveData<String> url;
    private final MutableLiveData<List<KeyValuePair>> parameters;
    private final MutableLiveData<List<KeyValuePair>> headers;
    private String contentType;
    private String content;

    public HttpRequestViewModel() {
        protocol = new MutableLiveData<>();
        protocol.setValue("HTTP/2.0");
        method = new MutableLiveData<>();
        method.setValue("GET");
        url = new MutableLiveData<>();
        url.setValue("");
        parameters = new MutableLiveData<>();
        headers= new MutableLiveData<>();

    }

    public LiveData<String> getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol){
        this.protocol.postValue(protocol);
    }

    public LiveData<String> getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method.postValue(method);
    }

    public LiveData<String> getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url.postValue(url);
    }

    public LiveData<List<KeyValuePair>> getParameters() {
        return parameters;
    }

    public void setParameters(List<KeyValuePair> parameters) {
        this.parameters.postValue(parameters);
    }

    public LiveData<List<KeyValuePair>> getHeaders() {
        return headers;
    }

    public void setHeaders(List<KeyValuePair> headers) {
        this.headers.postValue(headers);
    }

}
