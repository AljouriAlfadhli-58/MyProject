package com.example.mahaasel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class Page6 extends AppCompatActivity {
    Button btPicker;
    TextView textView;
    int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);
        btPicker = findViewById(R.id.bt_picker);
        textView=findViewById(R.id.text_view);

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
                            Intent i = new Intent(Page6.this, Page4.class);
                            startActivity(i);
                        }
                        if (drawerItem.getIdentifier() == 2){
                            Intent i2= new Intent(Page6.this, Page6.class);
                            startActivity(i2);
                        }
                        if (drawerItem.getIdentifier() == 3) {
                            Intent i3 = new Intent(Page6.this, Page5.class);
                            startActivity(i3);
                        }
                        if (drawerItem.getIdentifier() == 4) {
                            Intent i3 = new Intent(Page6.this, Page1.class);
                            startActivity(i3);
                        }

                        return false;
                    }

                })
                .build();


         btPicker.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                 try {
                     startActivityForResult(builder.build(Page6.this)
                             ,PLACE_PICKER_REQUEST);
                 } catch (GooglePlayServicesRepairableException e) {
                     e.printStackTrace();
                 } catch (GooglePlayServicesNotAvailableException e) {
                     e.printStackTrace();
                 }
             }
         });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST){
            if (resultCode == RESULT_OK){
                Place place = PlacePicker.getPlace(data,this);
                StringBuilder stringBuilder =  new StringBuilder();
                String latitude = String.valueOf(place.getLatLng().latitude);
                String longitude = String.valueOf(place.getLatLng().longitude);
                stringBuilder.append("LATITUDE :");
                stringBuilder.append(latitude);
                stringBuilder.append("\n");
                stringBuilder.append("LONGITUDE");
                stringBuilder.append(longitude);
                textView.setText(stringBuilder.toString());

            }
        }
    }
}