package cn.edu.nuc.lesson2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<Response> {

    private ListView listView;
    private ItemAdapter adapter;
    private Call<Response> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_list);

        adapter = new ItemAdapter(this);

        listView.setAdapter(adapter);

        Retrofit build
                = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QsbkService service = build.create(QsbkService.class);
        call = service.getList("image",4);
        call.enqueue(this);

    }

    @Override
    public void onResponse(retrofit.Response<Response> response, Retrofit retrofit) {
        adapter.addAll(response.body().getItems());
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(this,"网络错误",Toast.LENGTH_SHORT).show();
    }
}