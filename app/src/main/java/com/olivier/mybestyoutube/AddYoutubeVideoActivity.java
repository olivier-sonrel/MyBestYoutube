package com.olivier.mybestyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddYoutubeVideoActivity extends AppCompatActivity {
    private static final int RESULT_OK = 1;
    private static final int RESULT_CANCELED = 0;

    private EditText etTitle;
    private EditText etDescription;
    private EditText etUrl;
    private Spinner spCategory;
    private Button btnAdd;
    private Button btnCancel;
    private Context context;
    private String[] categories;
    private YoutubeVideo youtubeVideo;

    public static String[] getCategories() {
        return new String[]{
                "Sport",
                "Music",
                "Comedy",
                "Cooking"
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_youtube_video);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        etUrl = findViewById(R.id.etUrl);
        spCategory = findViewById(R.id.spCategory);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);

        categories = getCategories();

        context = getApplicationContext();

        final List<String> categoriesList = new ArrayList<>(Arrays.asList(categories));

        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(context, R.layout.spinner_item, categoriesList);

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spCategory.setAdapter(spinnerArrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();
                String url = etUrl.getText().toString();
                String category = spCategory.getSelectedItem().toString();

                if (
                        title.length() >= 1 &&
                        description.length() >= 1 &&
                        url.length() >= 1 &&
                        category.length() >= 1
                ) {

                    youtubeVideo = new YoutubeVideo(title, description, url, category);

                    YoutubeVideoDAO youtubeVideoDAO = new YoutubeVideoDAO(context);
                    youtubeVideoDAO.add(youtubeVideo);

                    Intent resultIntent = new Intent();
                    /* TODO resultIntent.putExtra("youtube_video", youtubeVideo);*/
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    CharSequence text = "Put something in the bazar, please!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                setResult(RESULT_CANCELED, resultIntent);
                finish();
            }
        });
    }
}