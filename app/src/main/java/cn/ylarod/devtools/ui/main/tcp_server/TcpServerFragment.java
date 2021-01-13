package cn.ylarod.devtools.ui.main.tcp_server;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import cn.ylarod.devtools.databinding.FragmentTcpServerBinding;

public class TcpServerFragment extends Fragment {

    private TcpServerViewModel tcpServerViewModel;
    private FragmentTcpServerBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTcpServerBinding.inflate(inflater, container, false);
        tcpServerViewModel = new ViewModelProvider(this).get(TcpServerViewModel.class);

        tcpServerViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.textSlideshow.setText(s);
            }
        });
        return binding.getRoot();
    }

}