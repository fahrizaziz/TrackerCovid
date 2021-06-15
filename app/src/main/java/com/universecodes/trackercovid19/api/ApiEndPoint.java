package com.universecodes.trackercovid19.api;

import com.universecodes.trackercovid19.model.HistoryModel;
import com.universecodes.trackercovid19.model.IndonesiaModel;
import com.universecodes.trackercovid19.model.WorldModel;
import com.universecodes.trackercovid19.model.news.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoint {
    @GET(Api.SUMMARY_WORLD)
    Call<WorldModel> getSummaryWorldCase();
    @GET(Api.END_POINT_IDN)
    Call<IndonesiaModel> getSummaryIdn();
    @GET(Api.END_POINT_WORLD_HISTORY)
    Call<List<HistoryModel>> getHistoryList(@Path("date") String date);
    @GET(Api.ENDPOINT_TOP_HEADLINE_NEWS)
    Call<NewsResponse> getNews(@Query("country") String countryCode,
                               @Query("category") String category,
                               @Query("apiKey") String apiKey);
}
