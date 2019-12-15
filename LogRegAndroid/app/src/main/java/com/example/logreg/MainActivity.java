package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button button_Login, button_Registration;
    EditText editText_LoginEmail, editText_LoginPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        button_Registration.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent toRegisterActivity = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(toRegisterActivity);
                finish();
            }
        });

        button_Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email = editText_LoginEmail.getText().toString();
                String password = editText_LoginPassword.getText().toString();
                if(email.isEmpty()||password.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "EMPTY FIELD!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent toLoggedIn = new Intent(MainActivity.this, LoggenInActivity.class);
                startActivity(toLoggedIn);
                finish();
            }
        });
    }

    public void init()
    {
        button_Login = findViewById(R.id.button_Login);
        button_Registration = findViewById(R.id.button_Registration);
        editText_LoginEmail = findViewById(R.id.editText_LoginEmail);
        editText_LoginPassword = findViewById(R.id.editText_LoginPassword);
    }
}
