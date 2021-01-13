package cn.ylarod.devtools.core.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import cn.ylarod.devtools.core.db.entity.HttpEntity;

@Dao
public interface HttpDao {
    @Query("SELECT * FROM http_db")
    LiveData<List<HttpEntity>> loadAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<HttpEntity> httpEntities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HttpEntity httpEntity);
}
