package com.example.mahaasel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class details extends AppCompatActivity {

    private ImageView buy1;
    private ImageView buy2;
    private TextView montaj;
    private TextView product;
    private TextView txtshow;
    private ImageView btngo;
    private ImageView imgproduct1;
    private TextView product2;
    private TextView montaj2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        product2= findViewById(R.id.product2);
        imgproduct1= findViewById(R.id.imgproduct1);
        txtshow= findViewById(R.id.txtshow);
        montaj= findViewById(R.id.txt8);
        product= findViewById(R.id.product1);
        buy1 = findViewById(R.id.buy1);
        buy2 = findViewById(R.id.img2);
        montaj2= findViewById(R.id.txt9);
        buy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(details.this, "add to cart", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(details.this,kuwait1.class);
                startActivity(i);
            }
        });

        buy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(details.this, "add to cart", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(details.this,kuwait2.class);
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
                            Intent i = new Intent(details.this, Page4.class);
                            startActivity(i);
                        }
                        if (drawerItem.getIdentifier() == 2){
                            Intent i2= new Intent(details.this, Page6.class);
                            startActivity(i2);
                        }
                        if (drawerItem.getIdentifier() == 3) {
                            Intent i3 = new Intent(details.this, Page5.class);
                            startActivity(i3);
                        }
                        if (drawerItem.getIdentifier() == 4) {
                            Intent i3 = new Intent(details.this, Page1.class);
                            startActivity(i3);
                        }

                        return false;
                    }
                })
                .build();
    }
}