package com.vk.studentapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.vk.studentapp.R;
import com.vk.studentapp.models.OverviewModel;

import java.util.List;

public class OverViewAdapter extends RecyclerView.Adapter<OverViewAdapter.ViewHolder> {

    private Context mContext;
    private List<OverviewModel> overviewModels;

    public OverViewAdapter(Context mContext, List<OverviewModel> overviewModels) {
        this.mContext = mContext;
        this.overviewModels = overviewModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_overview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.im_university.setImageDrawable(overviewModels.get(position).getDrawable());
        holder.tv_name.setText(overviewModels.get(position).getName().toString()+": ");
        holder.tv_value.setText(overviewModels.get(position).getValue().toString());
    }

    @Override
    public int getItemCount() {
        return overviewModels.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView im_university;
        AppCompatTextView tv_name,tv_value;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            im_university=itemView.findViewById(R.id.im_university);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_value=itemView.findViewById(R.id.tv_value);
        }
    }
}
