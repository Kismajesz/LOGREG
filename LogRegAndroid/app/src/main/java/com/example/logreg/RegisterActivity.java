package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity
{
    Button button_RegisterRegistration, button_Back;
    EditText editText_RegisterEmail, editText_RegisterUsername, editText_RegisterPassword, editText_RegisterFullname;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        button_RegisterRegistration.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email = editText_RegisterEmail.getText().toString();
                String username = editText_RegisterUsername.getText().toString();
                String password = editText_RegisterPassword.getText().toString();
                String fullname = editText_RegisterFullname.getText().toString();
                if (email.isEmpty() || username.isEmpty() || password.isEmpty() || fullname.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "EMPTY FIELD!", Toast.LENGTH_SHORT).show();
                    return;
                }
                dataRecord(email, username, password, fullname);
                Intent back = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
        button_Back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent back = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }

    public void dataRecord(String email, String username, String password, String fullname)
    {
        dbHelper dbHelper = new dbHelper(RegisterActivity.this);
        if(dbHelper.dataRecord(email, username, password, fullname))
        {
            Toast.makeText(this, "New user created succesfully!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    public void init()
    {
        button_RegisterRegistration = findViewById(R.id.button_RegisterRegistration);
        button_Back = findViewById(R.id.button_Back);
        editText_RegisterEmail = findViewById(R.id.editText_RegisterEmail);
        editText_RegisterUsername = findViewById(R.id.editText_RegisterUsername);
        editText_RegisterPassword = findViewById(R.id.editText_RegisterPassword);
        editText_RegisterFullname = findViewById(R.id.editText_RegisterFullname);
    }
}
