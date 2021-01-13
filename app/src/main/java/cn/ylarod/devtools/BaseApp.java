package cn.ylarod.devtools;

import android.app.Application;

import cn.ylarod.devtools.core.AppExecutors;
import cn.ylarod.devtools.core.DataRepository;
import cn.ylarod.devtools.core.db.AppDatabase;

public class BaseApp extends Application {
    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }
}
