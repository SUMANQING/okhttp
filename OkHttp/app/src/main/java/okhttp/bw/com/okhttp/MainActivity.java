package okhttp.bw.com.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private String url="http://172.17.8.100/small/commodity/v1/bannerShow";
    private String path="http://172.17.8.100/small/user/v1/register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getData();
        postData();
    }


    private void getData() {
        //创建OkHttpClient网络请求对象
        OkHttpClient okHttpClient=new OkHttpClient();
        //创建Request请求方式
        Request request=new Request.Builder().url(url).build();
        //执行请求
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //此方法回掉在子线程
                String json = response.body().string();
                Log.i("xxx",json);
            }
        });

    }

    private void postData() {
        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody=new FormBody.Builder()
                .add("phone","17729796626")
                .add("pwd","123")
                .build();
        Request request=new Request.Builder().url(path).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Log.i("xxx",json);
            }
        });
    }

}
