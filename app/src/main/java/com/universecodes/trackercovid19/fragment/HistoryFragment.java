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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.universecodes.trackercovid19.R;
import com.universecodes.trackercovid19.adapter.HistoryListAdapter;
import com.universecodes.trackercovid19.model.HistoryModel;
import com.universecodes.trackercovid19.viewmodel.HistoryViewModel;

import java.util.ArrayList;

public class HistoryFragment extends Fragment{
    private HistoryListAdapter adapter;
    private ProgressDialog mProgressApp;
    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressApp = new ProgressDialog(getActivity());
        mProgressApp.setTitle("Mohon tunggu");
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage("Sedang menampilkan data...");
        RecyclerView recyclerView = view.findViewById(R.id.listRecycler);
        adapter = new HistoryListAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        loadListData();
    }

    private void loadListData() {
        HistoryViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(HistoryViewModel.class);
        viewModel.setTodayData();
        mProgressApp.show();
        viewModel.getTodayListData().observe(this, new Observer<ArrayList<HistoryModel>>() {
            @Override
            public void onChanged(ArrayList<HistoryModel> riwayatModels) {
                adapter.setRiwayatModels(riwayatModels);
                mProgressApp.dismiss();
            }
        });
    }
}