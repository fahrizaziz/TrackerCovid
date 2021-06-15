package com.universecodes.trackercovid19.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.universecodes.trackercovid19.api.ApiEndPoint;
import com.universecodes.trackercovid19.api.ApiService;
import com.universecodes.trackercovid19.model.IndonesiaModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IndonesiaViewModel extends ViewModel {
    private MutableLiveData<IndonesiaModel> mutableLiveData = new MutableLiveData<>();
    public void setSummaryIdnData() {
        Retrofit retrofit = ApiService.getIndRetrofit();
        ApiEndPoint apiEndpoint = retrofit.create(ApiEndPoint.class);
        Call<IndonesiaModel> call = apiEndpoint.getSummaryIdn();
        call.enqueue(new Callback<IndonesiaModel>() {
            @Override
            public void onResponse(Call<IndonesiaModel> call, Response<IndonesiaModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<IndonesiaModel> call, Throwable t) {

            }
        });

    }
    public LiveData<IndonesiaModel> getCountryData() {
        return mutableLiveData;
    }
}
