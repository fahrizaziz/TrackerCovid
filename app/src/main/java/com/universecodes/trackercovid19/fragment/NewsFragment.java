package com.universecodes.trackercovid19.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.universecodes.trackercovid19.R;
import com.universecodes.trackercovid19.adapter.NewsAdapter;
import com.universecodes.trackercovid19.api.Api;
import com.universecodes.trackercovid19.model.news.NewsModel;
import com.universecodes.trackercovid19.ui.NewsDetail;
import com.universecodes.trackercovid19.viewmodel.NewsViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipe;
    private NewsAdapter adapter;
    private TextView tvEmpty;
    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvEmpty = view.findViewById(R.id.tvEmptyListNews);
        swipe = view.findViewById(R.id.swipeRefreshNews);
        RecyclerView rv = view.findViewById(R.id.newsRecycler);
        adapter = new NewsAdapter(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);

        loadNewsData();
    }

    private void loadNewsData() {
        NewsViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(NewsViewModel.class);
        viewModel.setNewsData();
        refreshNews(true);
        viewModel.getNewsData().observe(this, new Observer<ArrayList<NewsModel>>() {
            @Override
            public void onChanged(ArrayList<NewsModel> newsModels) {
                if (newsModels == null) {
                    tvEmpty.setVisibility(View.VISIBLE);
                    refreshNews(false);
                } else {
                    adapter.setNewsModels(newsModels);
                    refreshNews(false);
                }
            }
        });
        swipe.setOnRefreshListener(this);
    }

    private void refreshNews(boolean isRefresh) {
        if (isRefresh) {
            swipe.setRefreshing(true);
        } else {
            swipe.setRefreshing(false);
        }
    }


    @Override
    public void onRefresh() {
        loadNewsData();
    }
}