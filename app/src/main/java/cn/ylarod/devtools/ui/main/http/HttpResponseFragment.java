package cn.ylarod.devtools.ui.main.http;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cn.ylarod.devtools.databinding.FragmentHttpResponseBinding;

public class HttpResponseFragment extends Fragment {

    private FragmentHttpResponseBinding binding;
    private HttpResponseViewModel httpResponseViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHttpResponseBinding.inflate(inflater, container, false);
        httpResponseViewModel = new ViewModelProvider(requireParentFragment()).get(HttpResponseViewModel.class);
        httpResponseViewModel.getData().observe(getViewLifecycleOwner(), response -> binding.httpResponse.setText(response));
        return binding.getRoot();
    }
}
