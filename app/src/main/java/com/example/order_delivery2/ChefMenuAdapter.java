package com.example.order_delivery2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class ChefMenuAdapter extends RecyclerView.Adapter<ChefMenuAdapter.ViewHolder> {
    private Context context;
    private List<ChefMenu> item_cust;

    public ChefMenuAdapter(Context context, List<ChefMenu> item_cust) {
        this.context = context;
        this.item_cust = item_cust;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menuimage, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChefMenu item = item_cust.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return item_cust.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivItem;
        private TextView tvItemName;
        private TextView tvDescription;
        private TextView tvPrice;
        private TextView tvRating;
        private RelativeLayout itemContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.ivimage);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvRating = itemView.findViewById(R.id.tvRating);
            itemContainer = itemView.findViewById(R.id.itemContainer);
        }


        public void bind(ChefMenu item) {
            tvItemName.setText("item.getItemName");
            tvDescription.setText(item.getDescription());
            tvPrice.setText("$");
            tvRating.setText("/5");
            ParseFile image = item.getImage();

            if (image != null) {
                Glide.with(context).load(item.getImage().getUrl()).into(ivItem);
            }
        }
    }
}


