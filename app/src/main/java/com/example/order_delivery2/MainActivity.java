package com.example.order_delivery2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMenu;
    private ChefMenuAdapter adapter;
    private List<ChefMenu> all_item;
    private Button addbutton;
    public static final String TAG = "MenuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMenu = findViewById(R.id.menuitem);
        all_item = new ArrayList<>();
        queryPosts();
        adapter = new ChefMenuAdapter(this, all_item);
        rvMenu.setAdapter(adapter);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        addbutton = findViewById(R.id.addbutton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditMenu();
                addbutton.setEnabled(true);
            }
        });
    }
    public void openEditMenu() {
        Intent intent = new Intent(this, EditMenu.class);
        startActivity(intent);
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
                all_item.addAll(items);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
