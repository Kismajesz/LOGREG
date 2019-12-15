package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoggenInActivity extends AppCompatActivity
{
    Button button_Logout;
    TextView textView_Userdata;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggen_in);
        init();

        textView_Userdata.setText("Hello!");
        button_Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent logout = new Intent(LoggenInActivity.this, MainActivity.class);
                startActivity(logout);
                finish();
            }
        });

    }

    public void init()
    {
        button_Logout = findViewById(R.id.button_Logout);
        textView_Userdata = findViewById(R.id.textView_Userdata);
    }
}
