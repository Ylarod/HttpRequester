package cn.ylarod.devtools.ui.main.http;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Map;

public class HttpRequestViewModel extends ViewModel {
    private final MutableLiveData<String> method;
    private final MutableLiveData<String> url;
    private final MutableLiveData<Map<String,String>> parameters;
    private final MutableLiveData<Map<String,String>> headers;
    private String body;

    public HttpRequestViewModel() {
        method = new MutableLiveData<>();
        method.setValue("GET");
        url = new MutableLiveData<>();
        url.setValue("");
        parameters = new MutableLiveData<>();
        headers= new MutableLiveData<>();

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

    public LiveData<Map<String,String> > getParameters() {
        return parameters;
    }

    public void setParameters(Map<String,String>  parameters) {
        this.parameters.postValue(parameters);
    }

    public LiveData<Map<String,String> > getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String,String>  headers) {
        this.headers.postValue(headers);
    }

}
