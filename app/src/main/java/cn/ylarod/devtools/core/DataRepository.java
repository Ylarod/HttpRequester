package cn.ylarod.devtools.core;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import cn.ylarod.devtools.core.db.AppDatabase;
import cn.ylarod.devtools.core.db.entity.HttpEntity;

import java.util.List;

/**
 * Repository handling the work with products and comments.
 */
public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<HttpEntity>> mObservableHttpEntities;

    private DataRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableHttpEntities = new MediatorLiveData<>();

        mObservableHttpEntities.addSource(mDatabase.httpDao().loadAll(),
                httpEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableHttpEntities.postValue(httpEntities);
                    }
                });
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<HttpEntity>> getHttpEntities() {
        return mObservableHttpEntities;
    }

}
