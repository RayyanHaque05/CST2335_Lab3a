package com.cst2335.lab3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private Button btnDontCall;
    private Button btnThankYou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }

        tvWelcome = findViewById(R.id.tv_welcome);
        btnDontCall = findViewById(R.id.btn_dont_call);
        btnThankYou = findViewById(R.id.btn_thank_you);

        // Retrieve the user's name passed from MainActivity
        String userName = getIntent().getStringExtra(MainActivity.KEY_NAME);
        if (userName != null && !userName.trim().isEmpty()) {
            tvWelcome.setText(getString(R.string.welcome_message, userName));
        } else {
            tvWelcome.setText(getString(R.string.welcome_default));
        }

        // If user presses "Don't call me that", set result to 0 and return
        btnDontCall.setOnClickListener(v -> {
            setResult(0);
            finish();
        });

        // If user presses "Thank you", set result to 1 and return
        btnThankYou.setOnClickListener(v -> {
            setResult(1);
            finish();
        });
    }
}
