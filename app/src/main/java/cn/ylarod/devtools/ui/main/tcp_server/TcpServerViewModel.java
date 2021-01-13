package cn.ylarod.devtools.ui.main.tcp_server;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TcpServerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TcpServerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}