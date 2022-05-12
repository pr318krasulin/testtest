package com.example.myapplication123;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication123.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private final String BASE_URL = "http://numberapi.com";
    private EditText et_number;
    private TextView txtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_number = findViewById(R.id.et_number);
        txtt = findViewById(R.id.txtt);
    }

    public void getFact(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        API api = retrofit.create(API.class);

        Call<FactResponse> call;
        call = api.getFact(et_number.getText().toString());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                call.enqueue(new Callback<FactResponse>() {
                    @Override
                    public void onResponse(Call<FactResponse> call, Response<FactResponse> response) {
                        txtt.setText(response.body().getFact());
                    }

                    @Override
                    public void onFailure(Call<FactResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }
}