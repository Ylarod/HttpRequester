package cn.ylarod.devtools.ui.http;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HttpResponseViewModel  extends ViewModel {
    private final MutableLiveData<String> data;

    public HttpResponseViewModel() {
        data = new MutableLiveData<>();
        data.setValue("");
    }

    public LiveData<String> getData() {
        return data;
    }

    public void setData(String data) {
        this.data.postValue(data);
    }

}
