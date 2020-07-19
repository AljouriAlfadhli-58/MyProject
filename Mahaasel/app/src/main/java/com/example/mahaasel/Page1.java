package com.example.mahaasel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.DrawerBuilder;

public class Page1 extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private ImageView next;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.button2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // dont forget to make the button unborder
                Intent i2 = new Intent(Page1.this, Page2.class);
                startActivity(i2);
            }
        });


        next = findViewById(R.id.next1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("jouri") && password.getText().toString().equals("123")) {

                    Intent i = new Intent(Page1.this, Page3.class);
                    startActivity(i);
                    finish();

                }

                //correcct password
                else {
                    Toast.makeText(Page1.this, "username or password is wrong", Toast.LENGTH_SHORT).show();
                }
            }

        });

        }

}

