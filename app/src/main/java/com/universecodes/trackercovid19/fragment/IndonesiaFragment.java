package com.universecodes.trackercovid19.fragment;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.universecodes.trackercovid19.R;
import com.universecodes.trackercovid19.model.IndonesiaModel;
import com.universecodes.trackercovid19.util.ColorTemplate;
import com.universecodes.trackercovid19.viewmodel.IndonesiaViewModel;

import java.util.ArrayList;
import java.util.List;

public class IndonesiaFragment extends Fragment {

    private ProgressDialog mProgressApp;
    public IndonesiaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indonesia, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressApp = new ProgressDialog(getActivity());
        mProgressApp.setTitle("Mohon tunggu");
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage("Sedang menampilkan data...");
        mProgressApp.show();
        PieChart pieChart = view.findViewById(R.id.Indpie);
        IndonesiaViewModel  viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(IndonesiaViewModel.class);
        viewModel.setSummaryIdnData();
        viewModel.getCountryData().observe(this, new Observer<IndonesiaModel>(){

            @Override
            public void onChanged(IndonesiaModel indonesiaModel) {
                mProgressApp.dismiss();
                List<PieEntry> pieEntries = new ArrayList<>();
                pieEntries.add(new PieEntry(indonesiaModel.getIdnConfirmed().getValue(), "Confirmed"));
                pieEntries.add(new PieEntry(indonesiaModel.getIdnRecovered().getValue(), "Recovered"));
                pieEntries.add(new PieEntry(indonesiaModel.getIdnDeaths().getValue(), "Deaths"));
                PieDataSet pieDataSet = new PieDataSet(pieEntries, "Dari Covid 19");
                pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                pieDataSet.setValueTextColor(Color.WHITE);
                pieDataSet.setValueTextSize(14);
                Description description = new Description();
                description.setText("Last Update" + " : " + indonesiaModel.getLastUpdate());
                description.setTextColor(Color.WHITE);
                description.setTextSize(12);
                description.getPosition();
                Legend legend = pieChart.getLegend();
                legend.setTextColor(Color.WHITE);
                legend.setTextSize(12);
                legend.setForm(Legend.LegendForm.SQUARE);
                PieData pieData = new PieData(pieDataSet);
                pieChart.setVisibility(View.VISIBLE);
                pieChart.animateXY(2000, 2000);
                pieChart.setDescription(description);
                pieChart.setHoleColor(Color.TRANSPARENT);
                pieChart.setHoleRadius(60);
                pieChart.setRotationAngle(320);
                pieChart.setData(pieData);
                pieDataSet.setSliceSpace(4);
            }
        });
    }
}