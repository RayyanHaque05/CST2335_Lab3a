package com.cst2335.lab3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String PREF_NAME = "MyPrefs";
    public static final String KEY_NAME = "USER_NAME";
    public static final int REQUEST_CODE_NAME = 1;

    private EditText etName;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }

        etName = findViewById(R.id.et_name);
        btnNext = findViewById(R.id.btn_next);

        // Load the user's name from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String savedName = sharedPreferences.getString(KEY_NAME, "");
        if (savedName != null && !savedName.trim().isEmpty()) {
            etName.setText(savedName);
        }

        // When Next button is clicked, pass current value in an Intent to NameActivity
        btnNext.setOnClickListener(v -> {
            String enteredName = etName.getText().toString();
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            intent.putExtra(KEY_NAME, enteredName);
            startActivityForResult(intent, REQUEST_CODE_NAME);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save the current value inside EditText to SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String currentName = etName.getText().toString();
        editor.putString(KEY_NAME, currentName);
        editor.apply();
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NAME) {
            if (resultCode == 1) {
                // User is happy with the name, close the app
                finish();
            } else if (resultCode == 0) {
                // User wants to change their name, return to MainActivity
            }
        }
    }
}
