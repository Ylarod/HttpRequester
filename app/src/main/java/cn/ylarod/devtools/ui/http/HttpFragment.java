package cn.ylarod.devtools.ui.http;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.internal.HttpException;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayoutMediator;

import cn.ylarod.devtools.R;
import cn.ylarod.devtools.databinding.FragmentHttpBinding;

public class HttpFragment extends Fragment {

    private FragmentHttpBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHttpBinding.inflate(inflater, container, false);

        binding.httpViewPager.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return 2;
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if(position == 0){
                    return new HttpRequestFragment();
                }else{
                    return new HttpResponseFragment();
                }
            }
        });

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.httpTabLayout, binding.httpViewPager, (tab, position) -> {
            if(position == 0){
                tab.setText("REQUEST");
            }else{
                tab.setText("RESPONSE");
            }
        });
        tabLayoutMediator.attach();

        binding.fab.setOnClickListener(v -> {
            HttpRequestViewModel httpRequestViewModel = new ViewModelProvider(this).get(HttpRequestViewModel.class);
            HttpResponseViewModel httpResponseViewModel = new ViewModelProvider(this).get(HttpResponseViewModel.class);
            if(!httpRequestViewModel.getUrl().getValue().equalsIgnoreCase("")){
                try {
                    if(httpRequestViewModel.getMethod().getValue().equals("GET")){
                        HTTP http = HTTP.builder().build();
                        http.async(httpRequestViewModel.getUrl().getValue())
                                .addUrlPara(httpRequestViewModel.getParameters().getValue())
                                .addHeader(httpRequestViewModel.getHeaders().getValue())
                                .setOnResString(httpResponseViewModel::setData)
                                .get();

                    }else{
                        HTTP http = HTTP.builder().build();
                        http.async(httpRequestViewModel.getUrl().getValue())
                                .addBodyPara(httpRequestViewModel.getParameters().getValue())
                                .addHeader(httpRequestViewModel.getHeaders().getValue())
                                .setOnResString(httpResponseViewModel::setData)
                                .post();
                    }
                    binding.httpViewPager.setCurrentItem(1);
                }catch (HttpException httpException){
                    Snackbar.make(v, R.string.alert_http_error,Snackbar.LENGTH_SHORT).show();
                }

            }else{
                Snackbar.make(v, R.string.alert_type_url,Snackbar.LENGTH_SHORT).show();
            }
            


        });

        return binding.getRoot();
    }
}