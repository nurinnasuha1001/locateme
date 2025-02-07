package com.example.groupassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Initialize the buttons
        Button githubButton = findViewById(R.id.githubButton);
        Button backButton = findViewById(R.id.backButton); // Assuming you have a back button in the layout

        // Set GitHub button action
        githubButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/nurinnasuha1001/locateme.git"));
            startActivity(intent);
        });

        // Set Back button action
        backButton.setOnClickListener(this::goBack);
    }

    // Go back method to close the AboutActivity
    public void goBack(View view) {
        finish(); // Closes AboutActivity and returns to MainActivity
