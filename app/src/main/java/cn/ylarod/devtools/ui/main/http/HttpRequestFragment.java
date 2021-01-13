package cn.ylarod.devtools.ui.main.http;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import cn.ylarod.devtools.R;
import cn.ylarod.devtools.databinding.FragmentHttpRequestBinding;

public class HttpRequestFragment extends Fragment {

    private HttpRequestViewModel httpRequestViewModel;
    private FragmentHttpRequestBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHttpRequestBinding.inflate(inflater, container, false);
        httpRequestViewModel = new ViewModelProvider(this).get(HttpRequestViewModel.class);
        httpRequestViewModel.getProtocol().observe(getViewLifecycleOwner(), protocol -> binding.buttonHttpProtocol.setText(protocol));
        httpRequestViewModel.getMethod().observe(getViewLifecycleOwner(), method -> binding.buttonHttpMethod.setText(method));
        httpRequestViewModel.getUrl().observe(getViewLifecycleOwner(), url -> binding.buttonHttpUrl.setText(url));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.buttonHttpProtocol.setOnClickListener(v -> showProtocolDialog(requireContext()));
        binding.buttonHttpMethod.setOnClickListener(v -> showMethodDialog(requireContext()));
        binding.buttonHttpUrl.setOnClickListener(v -> showUrlDialog(requireContext()));
        binding.buttonHttpParameterAdd.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_nav_http_to_nav_http_edit_parameter));
    }

    private void showProtocolDialog(Context context) {
        final String[] protocols = {
                context.getString(R.string.HTTP_1_0),
                context.getString(R.string.HTTP_1_1),
                context.getString(R.string.HTTP_2_0)
        };
        AlertDialog.Builder listDialog = new AlertDialog.Builder(context);
        listDialog.setTitle(R.string.method_options);
        listDialog.setItems(protocols, (dialog, which) -> httpRequestViewModel.setProtocol(protocols[which]));
        listDialog.show();
    }

    private void showMethodDialog(Context context) {
        final String[] methods = {
                context.getString(R.string.method_get),
                context.getString(R.string.method_head),
                context.getString(R.string.method_post),
                context.getString(R.string.method_put),
                context.getString(R.string.method_delete),
                context.getString(R.string.method_connect),
                context.getString(R.string.method_trace),
                context.getString(R.string.method_patch)
        };
        AlertDialog.Builder listDialog = new AlertDialog.Builder(context);
        listDialog.setTitle(R.string.method_options);
        listDialog.setItems(methods, (dialog, which) -> httpRequestViewModel.setMethod(methods[which]));
        listDialog.show();
    }

    private void showUrlDialog(Context context) {
        final EditText editText = new EditText(context);
        editText.setText(binding.buttonHttpUrl.getText());
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(context);
        inputDialog.setTitle(context.getString(R.string.url_options)).setView(editText);
        inputDialog.setPositiveButton(R.string.positive_btn, (dialog, which) -> httpRequestViewModel.setUrl(editText.getText().toString())).show();
    }
}
