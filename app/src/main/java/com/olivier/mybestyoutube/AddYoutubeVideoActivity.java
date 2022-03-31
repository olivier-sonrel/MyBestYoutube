package com.olivier.mybestyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddYoutubeVideoActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etDescription;
    private EditText etUrl;
    private Spinner spCategory;
    private Button btnAdd;
    private Button btnCancel;
    private Context context;
    private String[] categories;

    public static String[] getCategories(){
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

        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(context , R.layout.spinner_item , categoriesList);

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spCategory.setAdapter(spinnerArrayAdapter);
    }
}