package com.example.mahaasel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.ArrayList;
import java.util.jar.Attributes;

public class Page4 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MyFarms> myFarms;
    FarmAdapter FarmAdapter;
    SearchView searchView;
    private TextView txtshow;

    ImageView photo;
    TextView nam;
    TextView delivery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        txtshow= findViewById(R.id.txtshow);
        photo = findViewById(R.id.imageView2);
         nam= findViewById(R.id.textView);
         delivery= findViewById(R.id.textView6);
        Bundle extras = getIntent().getExtras();


        AccountHeader ah = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.menu)
                // dont forget to change name and email
                .addProfiles(new ProfileDrawerItem().withName("jouri"))
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
                            Intent i = new Intent(Page4.this, Page4.class);
                            startActivity(i);
                        }
                        if (drawerItem.getIdentifier() == 2){
                            Intent i2= new Intent(Page4.this, Page6.class);
                            startActivity(i2);
                        }
                        if (drawerItem.getIdentifier() == 3) {
                            Intent i3 = new Intent(Page4.this, Page5.class);
                            startActivity(i3);
                        }
                        if (drawerItem.getIdentifier() == 4) {
                            Intent i3 = new Intent(Page4.this, Page1.class);
                            startActivity(i3);
                        }
                        return false;
                    }

                })
                .build();
        recyclerView= findViewById(R.id.recycler_View);
        // create Integer array
        Integer[] langImg = {R.drawable.kuwaitfarm,R.drawable.abdlyfarm,R.drawable.wafrafarm};
        // create string array
        String[] langName= {"مزرعة الكويت","مزرعة العبدلي","مزرعة الوفرة"};

        String[] langTime= {"120 دقيقة","150 دقيقة","120 دقيقة"};

        Integer[] key = {1,2,3};

        myFarms = new ArrayList<>();
        for (int i=0;i<langImg.length;i++){
            MyFarms farms = new MyFarms(langImg[i],langName[i], langTime[i],key[i]);
            myFarms.add(farms);

        }
        // design hori
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                Page4.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        FarmAdapter = new FarmAdapter(Page4.this, myFarms);
        recyclerView.setAdapter(FarmAdapter);
    }
}