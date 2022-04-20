package com.example.order_delivery2;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ChefMenu> menus;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView menuitem = findViewById(R.id.menuitem);
        menus = new ArrayList<>();
        queryPosts();
        menuAdapter = new MenuAdapter(this, menus);

        menuitem.setAdapter(menuAdapter);

        menuitem.setLayoutManager(new LinearLayoutManager(this));
    }

    private void queryPosts() {
        ParseQuery<ChefMenu> query = ParseQuery.getQuery(ChefMenu.class);
        query.findInBackground(new FindCallback<ChefMenu>() {
            @Override
            public void done(List<ChefMenu> items, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                for (ChefMenu item: items){
                    Log.i(TAG, "item:" + item.getDescription());
                }
                menus.addAll(menus);
                menuAdapter.notifyDataSetChanged();
            }
        });
    }
}