package com.universecodes.trackercovid19.fragment;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.universecodes.trackercovid19.R;
import com.universecodes.trackercovid19.model.WorldModel;
import com.universecodes.trackercovid19.viewmodel.WorldViewModel;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WorldFragment extends Fragment {
    private ProgressDialog mProgressApp;
    private TextView tvC,tvR,tvD,tvCa,tvDa;
    private String today;
    public WorldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_world, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Loading();
        tvC = view.findViewById(R.id.tvConfirmed);
        tvR = view.findViewById(R.id.tvRevocered);
        tvD = view.findViewById(R.id.tvDeaths);
        tvCa = view.findViewById(R.id.tvCases);
        tvDa = view.findViewById(R.id.tvDate);
        Date dateNow = Calendar.getInstance().getTime();
        today = (String) DateFormat.format("EEEE", dateNow);
        PieChart pieChart = view.findViewById(R.id.piechartworld);
        WorldViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(WorldViewModel.class);
        viewModel.setSummaryWorldData();
        viewModel.getSummaryWorldData().observe(this, new Observer<WorldModel>(){

            @Override
            public void onChanged(WorldModel WorldModel) {
                mProgressApp.dismiss();
                if (WorldModel != null){
                    Locale localeID = new Locale("id","ID");
                    NumberFormat numberFormat = NumberFormat.getInstance(localeID);
                    tvC.setText(String.valueOf(numberFormat.format(WorldModel.getLastActive())));
                    tvR.setText(String.valueOf(numberFormat.format(WorldModel.getLastRevocered())));
                    tvD.setText(String.valueOf(numberFormat.format(WorldModel.getLastDeaths())));
                    tvCa.setText(String.valueOf(numberFormat.format(WorldModel.getLastCases())));
                    pieChart.addPieSlice(
                            new PieModel(
                                    "Confirmed",
                                    WorldModel.getLastActive(),
                                    Color.parseColor("#F2B900")
                            )
                    );
                    pieChart.addPieSlice(
                            new PieModel(
                                    "Recovered",
                                    WorldModel.getLastRevocered(),
                                    Color.parseColor("#00CC99")
                            )
                    );
                    pieChart.addPieSlice(
                            new PieModel(
                                    "Deaths",
                                    WorldModel.getLastDeaths(),
                                    Color.parseColor("#F76353")

                            )
                    );
                    pieChart.startAnimation();
                }
            }
        });
        Date date = Calendar.getInstance().getTime();
        String tanggal = (String) DateFormat.format("d MMM yyyy",date);
        String formatBaku = today + ", " + tanggal;
        tvDa.setText(formatBaku);
    }


    private void Loading() {
        mProgressApp = new ProgressDialog(getActivity());
        mProgressApp.setTitle("Mohon tunggu");
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage("Sedang menampilkan data...");
        mProgressApp.show();
    }
}