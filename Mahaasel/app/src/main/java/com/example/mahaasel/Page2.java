package com.example.mahaasel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.gms.common.api.Result;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mikepenz.materialdrawer.DrawerBuilder;


public class Page2 extends AppCompatActivity {
    private ImageView next;
    private EditText name;
    private EditText email;
    private EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        next= findViewById(R.id.next1);
        name= findViewById(R.id.name);
        email= findViewById(R.id.email);
        pass= findViewById(R.id.pass);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Page2.this, Page3.class);
                i.putExtra("username1", name.getText().toString());
                i.putExtra("email1",email.getText().toString());
                i.putExtra("pass1",pass.getText().toString());
                startActivity(i);
            }
        });

    }
}






