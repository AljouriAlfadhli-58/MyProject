package com.example.mahaasel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

public class Page5 extends AppCompatActivity {
    private Button back;
    private  Button buy;
    private TextView txt1;
    private TextView txtshow;
    private TextView txt200;
    private ImageView imgproduct1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
        imgproduct1= findViewById(R.id.imgproduct1);
        txt200= findViewById(R.id.txt8);
        txt1 = findViewById(R.id.txt1);
        txtshow= findViewById(R.id.txtshow);






        buy= findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Page5.this, Page7.class);
                startActivity(i);

            }
        });


        back= findViewById(R.id.button3);
        back.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(Page5.this, Page4.class);
                                        startActivity(i);
                                    }
                                });


                AccountHeader ah = new AccountHeaderBuilder()
                        .withActivity(this)
                        .withHeaderBackground(R.drawable.menu)
                        .addProfiles(new ProfileDrawerItem().withName("jouri").withEmail("joo@gmail.com"))
                        .build();

                PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
                PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Location").withIcon(R.drawable.ic_baseline_location_on_24);
                PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Card").withIcon(R.drawable.ic_baseline_shopping_cart_24);
                PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Sign out").withIcon(R.drawable.ic_baseline_input_24);

                Toolbar toolbar = findViewById(R.id.toolbar1);
                new DrawerBuilder().withActivity(this)
                        .withToolbar(toolbar)
                        .withAccountHeader(ah)
                        .addDrawerItems(item1)
                        .addDrawerItems(item2)
                        .addDrawerItems(item3)
                        .addDrawerItems(new DividerDrawerItem())
                        .addDrawerItems(item4)
                        .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                if (drawerItem.getIdentifier() == 1) {
                                    Intent i = new Intent(Page5.this, Page4.class);
                                    startActivity(i);
                                }
                                if (drawerItem.getIdentifier() == 2){
                                    Intent i2= new Intent(Page5.this, Page6.class);
                                    startActivity(i2);
                                }
                                if (drawerItem.getIdentifier() == 3) {
                                    Intent i3 = new Intent(Page5.this, Page5.class);
                                    startActivity(i3);
                                }
                                if (drawerItem.getIdentifier() == 4) {
                                    Intent i3 = new Intent(Page5.this, Page1.class);
                                    startActivity(i3);
                                }

                                return false;
                            }
                        })
                        .build();
            }

        }