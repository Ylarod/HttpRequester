package cn.ylarod.devtools.ui.main.tcp_client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import cn.ylarod.devtools.databinding.FragmentTcpClientBinding;

public class TcpClientFragment extends Fragment {

    private TcpClientViewModel tcpClientViewModel;
    private FragmentTcpClientBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTcpClientBinding.inflate(inflater, container, false);
        tcpClientViewModel = new ViewModelProvider(this).get(TcpClientViewModel.class);
        tcpClientViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.textGallery.setText(s);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        getActivity().findViewById(R.id.btn_setting).setVisibility(View.INVISIBLE);
    }
}