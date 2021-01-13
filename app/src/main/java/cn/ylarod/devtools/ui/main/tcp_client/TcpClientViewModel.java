package cn.ylarod.devtools.ui.main.tcp_client;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TcpClientViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TcpClientViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}