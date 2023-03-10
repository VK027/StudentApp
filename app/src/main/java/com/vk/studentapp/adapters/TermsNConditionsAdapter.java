package com.vk.studentapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.vk.studentapp.R;
import com.vk.studentapp.models.TermsConditions;
import com.vk.studentapp.models.HomeGrid;

import java.util.List;

public class TermsNConditionsAdapter extends RecyclerView.Adapter<TermsNConditionsAdapter.ViewHolder> {

    private Context context;
    private List<TermsConditions> termsConditionsList;
    private TermsNConditionsAdapter.OnItemViewListener OnItemViewListener;

    public TermsNConditionsAdapter(Context context, List<TermsConditions> termsConditionsList) {
        this.context = context;
        this.termsConditionsList = termsConditionsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_terms_conditions, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (termsConditionsList!=null && termsConditionsList.size() >0 ){
            holder.text_condition.setText(termsConditionsList.get(position).getCondition());
            holder.text_sub_condition.setText(termsConditionsList.get(position).getSub_condition());
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public int getItemCount() {
        return termsConditionsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        AppCompatTextView text_condition, text_sub_condition;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_condition = itemView.findViewById(R.id.text_condition);
            text_sub_condition = itemView.findViewById(R.id.text_sub_condition);
        }
    }

    public interface OnItemViewListener {
        void selectedItem(HomeGrid homeGrid);
    }
    public void SetOnItemClickListener(final TermsNConditionsAdapter.OnItemViewListener OnItemViewListener) {
        this.OnItemViewListener = OnItemViewListener;
    }
}
