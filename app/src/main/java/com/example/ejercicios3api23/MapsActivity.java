package com.example.ejercicios3api23;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        int status= GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if(status== ConnectionResult.SUCCESS){
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }else{
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialog.show();
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        /*mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Log.e(TAG,marker.getTitle());
                if(marker.getTitle().equals("Jugos")){
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                    Uri.parse("https://www.google.com/maps/seach/Jugos/@-12.1947396,-76.9710182.17z");
                    startActivity(intent);
                }
                return false;
            }
        });*/

    }
;


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        LatLng autonoma = new LatLng(-12.195483, -76.9719602);
        LatLng libreria = new LatLng(-12.1953084, -76.9712983);
        LatLng jugos = new LatLng(-12.1963635, -76.9721322);
        LatLng polideportido = new LatLng(-12.1963157, -76.9725309);
        LatLng makro = new LatLng(-12.1929311, -76.9716932);
        LatLng parquezonal = new LatLng(-12.19201, -76.9724273);
        mMap.addMarker(new MarkerOptions().position(autonoma).title("Universidad Autónoma"));
        mMap.addMarker(new MarkerOptions().position(libreria).title("Librería"));
        mMap.addMarker(new MarkerOptions().position(jugos).title("Jugos"));
        mMap.addMarker(new MarkerOptions().position(polideportido).title("Polideportivo"));
        mMap.addMarker(new MarkerOptions().position(makro).title("Makro"));
        mMap.addMarker(new MarkerOptions().position(parquezonal).title("Parque Zonal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(autonoma,17));
    }
}
