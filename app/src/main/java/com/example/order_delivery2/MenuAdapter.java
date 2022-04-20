package com.example.order_delivery2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    Context context;
    List<ChefMenu> menus;

    public MenuAdapter(Context context, List<ChefMenu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View menuView = LayoutInflater.from(context).inflate(R.layout.menuimage,parent,false);
        return new ViewHolder(menuView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChefMenu menu = menus.get(position);
        holder.bind(menu);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivimage;
        TextView tvDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivimage = itemView.findViewById(R.id.ivimage);
            tvDescription = itemView.findViewById(R.id.tvDescription);

        }

        public void bind(ChefMenu menu) {
            tvDescription.setText(menu.getDescription());
            ParseFile image = menu.getImage ( );
            if (image!= null) {
                Glide.with(context).load(menu.getImage()).load(image.getUrl()).into(ivimage);
            }
        }
    }
}
