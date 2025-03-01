package com.example.carrentalapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editPickup, editDropoff, editPickupDate, editDropoffDate;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editPickup = findViewById(R.id.editPickup);
        editDropoff = findViewById(R.id.editDropoff);
        editPickupDate = findViewById(R.id.editPickupDate);
        editDropoffDate = findViewById(R.id.editDropoffDate);
        btnSearch = findViewById(R.id.btnSearch);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pickupLocation = editPickup.getText().toString().trim();
                String dropoffLocation = editDropoff.getText().toString().trim();
                String pickupDate = editPickupDate.getText().toString().trim();
                String dropoffDate = editDropoffDate.getText().toString().trim();


                if (pickupLocation.isEmpty() || pickupDate.isEmpty() || dropoffDate.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (dropoffLocation.isEmpty()) {
                    dropoffLocation = pickupLocation;
                }


                openKayak(pickupLocation, dropoffLocation, pickupDate, dropoffDate);
            }
        });
    }


    private void openKayak(String pickupLocation, String dropoffLocation, String pickupDate, String dropoffDate) {

        String affiliateId = "your_affiliate_id";

        String kayakDomain = "www.kayak.com";


        String url = String.format(
                "https://%s/in?a=%s&url=/cars/%s/%s/%s/%s",
                kayakDomain,
                affiliateId,
                Uri.encode(pickupLocation),
                Uri.encode(dropoffLocation),
                pickupDate,
                dropoffDate
        );


        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        startActivity(browserIntent);
    }
}