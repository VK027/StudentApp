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
import com.vk.studentapp.models.HomeGrid;

import java.util.List;

public class HomeGridAdapter extends RecyclerView.Adapter<HomeGridAdapter.ViewHolder> {

    private Context context;
    private List<HomeGrid> homeGridList;
    private HomeGridAdapter.OnItemViewListener OnItemViewListener;

    public HomeGridAdapter(Context context, List<HomeGrid> homeGridList,HomeGridAdapter.OnItemViewListener onItemViewListener) {
        this.context = context;
        this.homeGridList = homeGridList;
        this.OnItemViewListener=onItemViewListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_update_grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (homeGridList !=null && homeGridList.size() >0 ){

            holder.image_grid_home.setImageDrawable(homeGridList.get(position).getDrawable());
            holder.text_grid.setText(homeGridList.get(position).getTextGrid());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( OnItemViewListener !=null) {
                        OnItemViewListener.selectedItem(position);
                    }
                }
            });
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
        return homeGridList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        AppCompatTextView text_grid;
        AppCompatImageView image_grid_home;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_grid = itemView.findViewById(R.id.text_grid);
            image_grid_home = itemView.findViewById(R.id.image_grid_home);
        }
    }

    public interface OnItemViewListener {
        void selectedItem(int homeGrid);
    }
    /*public void SetOnItemClickListener(final HomeGridAdapter.OnItemViewListener OnItemViewListener) {
        this.OnItemViewListener = OnItemViewListener;
    }*/
}
