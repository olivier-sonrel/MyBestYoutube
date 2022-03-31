package com.olivier.mybestyoutube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    private RecyclerView recyclerView;
    List<YoutubeVideo> youtubeVideoList = new ArrayList<>();
    YoutubeVideoAdapter youtubeVideoAdapter;
    TextView tvYoutubeVideo;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itAddYoutubeVideo:

                Intent intent = new Intent(context, AddYoutubeVideoActivity.class);

                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        YoutubeVideoDAO youtubeVideoDAO = new YoutubeVideoDAO(context);
        List<YoutubeVideo> youtubeVideoList = youtubeVideoDAO.list();

        String text = "";
        for( YoutubeVideo youtubeVideo : youtubeVideoList){
            text += String.format(" %s / %s \n", youtubeVideo.getTitle(), youtubeVideo.getDescription());
        }
        tvYoutubeVideo.setText(text);

/*        YoutubeVideoAdapter youtubeVideoAdapter = new YoutubeVideoAdapter(youtubeVideoList*//*, new TodoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Todo todo) {
                Intent intent = new Intent(context, DetailActivity.class);
                startActivity(intent);
            }
        }*//*
        );*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvYoutubeVideo = findViewById(R.id.tvYoutubeVideo);
        /*tvYoutubeVideo.setText(text);*/

/*        recyclerView = findViewById(R.id.rvYoutubeVideo);*//* TODO on call pas le bon main je pense ou c le tvTodos qui est pas du bon type dans les init... *//*
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        youtubeVideoAdapter = new YoutubeVideoAdapter(youtubeVideoList);
        recyclerView.setAdapter(youtubeVideoAdapter);*/


        context = getApplicationContext();
    }
}