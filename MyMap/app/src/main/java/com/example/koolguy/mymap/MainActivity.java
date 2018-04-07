package com.example.koolguy.mymap;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnMyLocationButtonClickListener,GoogleMap.OnMapClickListener {

    GoogleMap map;
    EditText coord;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (googleServicesAvaliable()) {
            setContentView(R.layout.activity_main);
            coord=(EditText)findViewById(R.id.coord);
            Toast.makeText(this, "perfect", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},9999);
            initmap();
        }
    }

    private void initmap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.Mapfragment);
        mapFragment.getMapAsync(this);
    }

    public boolean googleServicesAvaliable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvailable)) {
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(this, "can.t coonect", Toast.LENGTH_LONG).show();
        }
        return false;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        map.setMyLocationEnabled(true);

    }

    private void goToLocation(double lat, double lng) {
        LatLng ll = new LatLng(lat,lng);
        CameraUpdate upd = CameraUpdateFactory.newLatLng(ll);
        map.moveCamera(upd);
    }
    private void goToLocationZoom(double lat, double lng,float zoom) {
        LatLng ll = new LatLng(lat,lng);
        CameraUpdate upd = CameraUpdateFactory.newLatLngZoom(ll,zoom);
        map.moveCamera(upd);
    }



    public void goMake(View view)
    {
        if(map!=null)
        {
          try {

            String[] latLng = coord.getText().toString().split(",");
            double latitude = Double.parseDouble(latLng[0]);
            double longitude = Double.parseDouble(latLng[1]);
            Toast.makeText(this,""+latitude+" "+longitude,Toast.LENGTH_LONG).show();
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(latitude,longitude))
                    .title("Mark")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.flag))
                    .draggable(false));
          }catch (Exception e){}

        }
    }
    @Override
    public boolean onMyLocationButtonClick() {

        return false;
    }

    @Override
    public void onMapClick(LatLng latLng) {
        map.addMarker(new MarkerOptions()
                .position(latLng)
                .title("Mark")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.flag))
                .draggable(false)
        );
    }
}
