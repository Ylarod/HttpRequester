package cn.ylarod.devtools.core.db.conventer;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import cn.ylarod.devtools.core.db.entity.KeyValuePair;

public class KeyValueConverter {
    @TypeConverter
    public static List<KeyValuePair> toKeyValueList(String keyValueJson) {
        return new Gson().fromJson(keyValueJson,new TypeToken<List<KeyValuePair>>(){}.getType());

    }

    @TypeConverter
    public static String toJsonString(List<KeyValuePair> keyValuePairs) {
        return new Gson().toJson(keyValuePairs);
    }
}
