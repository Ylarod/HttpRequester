package cn.ylarod.devtools.ui.main.http;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ejlchina.okhttps.HTTP;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Date;

import cn.ylarod.devtools.R;
import cn.ylarod.devtools.core.db.AppDatabase;
import cn.ylarod.devtools.core.db.entity.HttpEntity;
import cn.ylarod.devtools.core.db.entity.HttpRequestEntity;
import cn.ylarod.devtools.databinding.FragmentHttpBinding;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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
            HttpRequestEntity httpRequestEntity = new HttpRequestEntity();
            httpRequestEntity.setUrl(httpRequestViewModel.getUrl().getValue());
            if(httpRequestEntity.url.equals("")){
                Snackbar.make(v, getText(R.string.url_not_empty), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                return;
            }
            httpRequestEntity.setMethod(httpRequestViewModel.getMethod().getValue());
            httpRequestEntity.setHeaders(httpRequestViewModel.getHeaders().getValue());
            httpRequestEntity.setParameters(httpRequestViewModel.getParameters().getValue());

            httpResponseViewModel.setData("dddd");
            binding.httpViewPager.setCurrentItem(1);
        });

        return binding.getRoot();
    }
}