package com.universecodes.trackercovid19.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.universecodes.trackercovid19.api.ApiEndPoint;
import com.universecodes.trackercovid19.api.ApiService;
import com.universecodes.trackercovid19.model.WorldModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WorldViewModel extends ViewModel {
    private MutableLiveData<WorldModel> mutableLiveData = new MutableLiveData<>();
    public void setSummaryWorldData() {
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<WorldModel> call = apiEndPoint.getSummaryWorldCase();
        call.enqueue(new Callback<WorldModel>() {
            @Override
            public void onResponse(Call<WorldModel> call, Response<WorldModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WorldModel> call, Throwable t) {

            }
        });
    }
    public LiveData<WorldModel> getSummaryWorldData() {
        return mutableLiveData;
    }
}
