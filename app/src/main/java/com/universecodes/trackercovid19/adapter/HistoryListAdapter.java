package com.universecodes.trackercovid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.universecodes.trackercovid19.R;
import com.universecodes.trackercovid19.model.HistoryModel;

import java.util.ArrayList;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {
    private ArrayList<HistoryModel> historyModels = new ArrayList<>();
    private Context context;

    public HistoryListAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<HistoryModel> getRiwayatModels() {
        return historyModels;
    }

    public void setRiwayatModels(ArrayList<HistoryModel> items) {
        if (historyModels != null) {
            if (historyModels.size() > 0) {
                historyModels.clear();
            }
            historyModels.addAll(items);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lastUpdateDate.setText(historyModels.get(position).getLastUpdate());
        holder.tvConfirmed.setText(historyModels.get(position).getConfirmed());
        holder.tvRecovered.setText(historyModels.get(position).getRecovered());
        holder.tvDeath.setText(historyModels.get(position).getDeaths());
        holder.tvListCountry.setText("Negara : " + historyModels.get(position).getCountryRegion());

    }

    @Override
    public int getItemCount() {
        return historyModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lastUpdateDate;
        TextView tvConfirmed;
        TextView tvRecovered;
        TextView tvDeath;
        TextView tvListCountry;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lastUpdateDate = itemView.findViewById(R.id.tvListLastUpdate);
            tvConfirmed = itemView.findViewById(R.id.tvListConfirmed);
            tvRecovered = itemView.findViewById(R.id.tvListRecovered);
            tvDeath = itemView.findViewById(R.id.tvListDeath);
            tvListCountry = itemView.findViewById(R.id.tvListCountry);
        }
    }
}
