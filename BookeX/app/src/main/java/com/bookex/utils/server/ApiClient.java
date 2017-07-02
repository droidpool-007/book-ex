package com.bookex.utils.server;

/**
 * Created by faasos on 7/8/15.
 */

import com.bookex.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ServerApi serverApi;

    public static ServerApi getApiClient() {
        if (serverApi == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                    .setLevel(BuildConfig.DEBUG ?
                            HttpLoggingInterceptor.Level.BODY :
                            HttpLoggingInterceptor.Level.NONE);

            okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
            builder.connectTimeout(10, TimeUnit.SECONDS);
            builder.readTimeout(15, TimeUnit.SECONDS);
            builder.addInterceptor(loggingInterceptor);
            okhttp3.OkHttpClient okHttpClient = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api-dev.faasos.io")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            serverApi = retrofit.create(ServerApi.class);
        }
        return serverApi;
    }
}
