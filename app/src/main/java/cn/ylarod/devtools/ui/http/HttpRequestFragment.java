package cn.ylarod.devtools.ui.http;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Map;

import cn.ylarod.devtools.R;
import cn.ylarod.devtools.adapter.KeyValuePairAdapter;
import cn.ylarod.devtools.databinding.FragmentHttpRequestBinding;
import cn.ylarod.devtools.entity.KeyValuePair;

public class HttpRequestFragment extends Fragment {

    private HttpRequestViewModel httpRequestViewModel;
    private FragmentHttpRequestBinding binding;
    ArrayList<KeyValuePair> headers;
    KeyValuePairAdapter headersListAdapter;
    ArrayList<KeyValuePair> parameters;
    KeyValuePairAdapter parametersListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHttpRequestBinding.inflate(inflater, container, false);
        httpRequestViewModel = new ViewModelProvider(requireParentFragment()).get(HttpRequestViewModel.class);
        httpRequestViewModel.getMethod().observe(getViewLifecycleOwner(), method -> binding.buttonHttpMethod.setText(method));
        httpRequestViewModel.getUrl().observe(getViewLifecycleOwner(), url -> binding.buttonHttpUrl.setText(url));

        headers = new ArrayList<>();
        headersListAdapter = new KeyValuePairAdapter(requireContext(),this.headers);
        binding.headerListView.setAdapter((ListAdapter) this.headersListAdapter);
        parameters = new ArrayList<>();
        parametersListAdapter = new KeyValuePairAdapter(requireContext(),this.parameters);
        binding.parameterListView.setAdapter((ListAdapter) this.parametersListAdapter);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.buttonHttpMethod.setOnClickListener(v -> showMethodDialog(requireContext()));
        binding.buttonHttpUrl.setOnClickListener(v -> showUrlDialog(requireContext()));
        binding.headerListView.setOnItemClickListener((parent, v, position, id) -> {
            KeyValuePair keyValuePair = headers.get(position);
            binding.headerKeyEditText.setText(keyValuePair.getKey());
            binding.headerValueEditText.setText(keyValuePair.getValue());
        });
        binding.headerListView.setOnItemLongClickListener((parent, v, position, id) -> {
            KeyValuePair keyValuePair = headers.get(position);
            new AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.delete_header))
                    .setMessage(getString(R.string.delete_header_question))
                    .setPositiveButton(getString(R.string.positive_btn), (dialog, which) -> {
                        Map<String,String> map = httpRequestViewModel.getHeaders().getValue();
                        map.remove(parameters.get(position).getKey());
                        headers.remove(position);
                        headersListAdapter.notifyDataSetChanged();
                    }).setNegativeButton(getString(R.string.negative_btn), null)
                    .show();
            return true;
        });
        binding.headerAddButton.setOnClickListener(v -> {
            String key = binding.headerKeyEditText.getText().toString();
            String value = binding.headerValueEditText.getText().toString();
            if (key == null || value == null || key.equalsIgnoreCase("") || value.equalsIgnoreCase("")) {
                Snackbar.make(v,R.string.alert_type_key_value,Snackbar.LENGTH_SHORT).show();
                return;
            }
            Map<String,String> map = httpRequestViewModel.getHeaders().getValue();
            if (map.containsKey(key)){
                map.replace(key,value);
            }else{
                map.put(key,value);
            }
            httpRequestViewModel.setHeaders(map);

            int headersSize = headers.size();
            boolean found = false;
            int i = 0;
            while (true) {
                if (i >= headersSize) {
                    break;
                } else if (headers.get(i).getKey().equalsIgnoreCase(key)) {
                    headers.get(i).setValue(value);
                    found = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!found) {
                headers.add(new KeyValuePair(key, value));
            }
            headersListAdapter.notifyDataSetChanged();
            binding.headerKeyEditText.setText("");
            binding.headerValueEditText.setText("");
            setListViewHeightBasedOnChildren(binding.headerListView);
        });
        binding.buttonHttpHeaderClean.setOnClickListener(v -> {
            binding.headerKeyEditText.setText("");
            binding.headerValueEditText.setText("");
            headers.clear();
            Map<String,String> map = httpRequestViewModel.getHeaders().getValue();
            map.clear();
            httpRequestViewModel.setHeaders(map);
            headersListAdapter.notifyDataSetChanged();
            setListViewHeightBasedOnChildren(binding.headerListView);
        });

        binding.parameterListView.setOnItemClickListener((parent, v, position, id) -> {
            KeyValuePair keyValuePair = parameters.get(position);
            binding.parameterKeyEditText.setText(keyValuePair.getKey());
            binding.parameterValueEditText.setText(keyValuePair.getValue());
        });
        binding.parameterListView.setOnItemLongClickListener((parent, v, position, id) -> {
            KeyValuePair keyValuePair = parameters.get(position);
            new AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.delete_parameter))
                    .setMessage(getString(R.string.delete_parameter_question))
                    .setPositiveButton(getString(R.string.positive_btn), (dialog, which) -> {
                        Map<String,String> map = httpRequestViewModel.getParameters().getValue();
                        map.remove(parameters.get(position).getKey());
                        httpRequestViewModel.setParameters(map);
                        parameters.remove(position);
                        parametersListAdapter.notifyDataSetChanged();
                    }).setNegativeButton(getString(R.string.negative_btn), null)
                    .show();
            return true;
        });
        binding.parameterAddButton.setOnClickListener(v -> {
            String key = binding.parameterKeyEditText.getText().toString();
            String value = binding.parameterValueEditText.getText().toString();
            if (key == null || value == null || key.equalsIgnoreCase("") || value.equalsIgnoreCase("")) {
                Snackbar.make(v,R.string.alert_type_key_value,Snackbar.LENGTH_SHORT).show();
                return;
            }
            Map<String,String> map = httpRequestViewModel.getParameters().getValue();
            if (map.containsKey(key)){
                map.replace(key,value);
            }else{
                map.put(key,value);
            }
            httpRequestViewModel.setParameters(map);
            int parametersSize = parameters.size();
            boolean found = false;
            int i = 0;
            while (true) {
                if (i >= parametersSize) {
                    break;
                } else if (parameters.get(i).getKey().equalsIgnoreCase(key)) {
                    parameters.get(i).setValue(value);
                    found = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!found) {
                parameters.add(new KeyValuePair(key, value));
            }
            parametersListAdapter.notifyDataSetChanged();
            binding.parameterKeyEditText.setText("");
            binding.parameterValueEditText.setText("");
            setListViewHeightBasedOnChildren(binding.parameterListView);
        });
        binding.buttonHttpParameterClean.setOnClickListener(v -> {
            binding.parameterKeyEditText.setText("");
            binding.parameterValueEditText.setText("");
            parameters.clear();
            Map<String,String> map = httpRequestViewModel.getParameters().getValue();
            map.clear();
            httpRequestViewModel.setParameters(map);
            parametersListAdapter.notifyDataSetChanged();
            setListViewHeightBasedOnChildren(binding.parameterListView);
        });
//        binding.buttonHttpParameterClean.setOnClickListener(v -> binding.parameters.setText(""));
    }


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        Adapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount()))
                + listView.getListPaddingBottom() + listView.getListPaddingTop();
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // listView.getListPaddingBottom()获取ListView的内边距
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    private void showMethodDialog(Context context) {
        final String[] methods = {
                context.getString(R.string.method_get),
                context.getString(R.string.method_post)
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
