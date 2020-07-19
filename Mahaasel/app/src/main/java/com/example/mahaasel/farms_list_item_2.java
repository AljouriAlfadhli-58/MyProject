package com.example.mahaasel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class farms_list_item_2 extends AppCompatActivity {
        ImageView img;
        TextView nam;
        TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farms_list_item_2);
        img = findViewById(R.id.imageView2);
        nam= findViewById(R.id.textView);
        time= findViewById(R.id.textView6);


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
                            Intent i = new Intent(farms_list_item_2.this, Page4.class);
                            startActivity(i);
                        }
                        if (drawerItem.getIdentifier() == 2){
                            Intent i2= new Intent(farms_list_item_2.this, Page6.class);
                            startActivity(i2);
                        }
                        if (drawerItem.getIdentifier() == 3) {
                            Intent i3 = new Intent(farms_list_item_2.this, Page5.class);
                            startActivity(i3);
                        }
                        if (drawerItem.getIdentifier() == 4) {
                            Intent i3 = new Intent(farms_list_item_2.this, Page1.class);
                            startActivity(i3);
                        }
                        return false;
                    }

                })
                .build();
    }

}