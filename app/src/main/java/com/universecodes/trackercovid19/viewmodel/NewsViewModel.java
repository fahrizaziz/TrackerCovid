package com.universecodes.trackercovid19.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.universecodes.trackercovid19.BuildConfig;
import com.universecodes.trackercovid19.api.ApiEndPoint;
import com.universecodes.trackercovid19.api.ApiService;
import com.universecodes.trackercovid19.model.news.NewsModel;
import com.universecodes.trackercovid19.model.news.NewsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NewsViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<NewsModel>> liveData = new MutableLiveData<>();

    public void setNewsData() {
        Retrofit retrofit = ApiService.getRetrofitServiceNews();
        ApiEndPoint endpoint = retrofit.create(ApiEndPoint.class);
        Call<NewsResponse> call = endpoint.getNews("id", "health", BuildConfig.API_NEWS);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                liveData.setValue((ArrayList<NewsModel>) response.body().getGetArticles());
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<NewsModel>> getNewsData() {
        return liveData;
    }
}
