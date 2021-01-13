package cn.ylarod.devtools.tools;

import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.HttpResult;
import com.ejlchina.okhttps.internal.SyncHttpTask;

import cn.ylarod.devtools.core.db.entity.HttpRequestEntity;
import cn.ylarod.devtools.core.db.entity.HttpResponseEntity;

public class HttpUtil {
    public static HttpResponseEntity doRequest(HttpRequestEntity request){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        HTTP http = HTTP.builder().build();
        SyncHttpTask task = http.sync(request.url);
        task.addHeader(request.headers);
        task.addUrlPara(request.parameters);
        HttpResult result = task.request(request.method);

        return httpResponseEntity;
    }
}
