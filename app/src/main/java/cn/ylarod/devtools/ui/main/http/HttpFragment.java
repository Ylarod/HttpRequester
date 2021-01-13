package cn.ylarod.devtools.ui.main.http;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

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

        return binding.getRoot();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("HttpFragment","onDestroy");
        binding = null;
    }


}