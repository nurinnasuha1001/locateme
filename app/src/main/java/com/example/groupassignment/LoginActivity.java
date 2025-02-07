package com.example.groupassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    // Replace with your actual data source (e.g., a database, shared preferences)
    private HashMap<String, String> userCredentials = new HashMap<>();
    private HashMap<String, String> userRealNames = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI components
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Populate userCredentials and userRealNames with sample data (replace with your actual data)
        userCredentials.put("widainani", "wida2502");
        userCredentials.put("nurinnasuha", "nurin1808");
        userCredentials.put("iffahdania", "iffah0303");
        userCredentials.put("madamasma", "lectasma");

        userRealNames.put("widainani", "Wida Inani");
        userRealNames.put("nurinnasuha", "Nurin Nasuha");
        userRealNames.put("iffahdania", "Iffah Dania");
        userRealNames.put("madamasma", "Madam Asma");

        // Handle Login button click
        btnLogin.setOnClickListener(v -> {
            if (isLoginValid()) {
                // If login is valid, move to MainActivity
                String username = etUsername.getText().toString();
                String realName = userRealNames.get(username); // Get the real name
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("USER_NAME", realName); // Pass real name to MainActivity
                startActivity(intent);
                finish();  // Close LoginActivity
            } else {
                // Show an error
                Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Check if the entered username and password are correct
    private boolean isLoginValid() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        // Check if username exists and password matches
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}