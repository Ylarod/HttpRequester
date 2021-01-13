package cn.ylarod.devtools.core.db.conventer;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class MapConverter {
    @TypeConverter
    public static Map<String,String> toMap(String mapJson) {
        return new Gson().fromJson(mapJson,new TypeToken<Map<String,String>>(){}.getType());

    }

    @TypeConverter
    public static String toJsonString(Map<String,String> map) {
        return new Gson().toJson(map);
    }
}
