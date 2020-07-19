package com.example.mahaasel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Page3 extends AppCompatActivity {
    private ImageView next1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        TextView txt1 = findViewById(R.id.txtname);
        Bundle extras = getIntent().getExtras();
        txt1.setText(extras.getString("username1"));

        next1 = findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Page3.this, Page4.class);
                startActivity(i);
            }
        });
    }
}