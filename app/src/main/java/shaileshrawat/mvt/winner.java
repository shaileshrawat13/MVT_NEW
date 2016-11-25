package shaileshrawat.mvt;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static java.lang.Boolean.TRUE;

/**
 * Created by shailesh.rawat on 11/24/2016.
 */

public class winner extends Activity implements LocationListener{

    TextView country;
    String getCountry;
    LocationManager locationManager;
    LocationListener locationListener=null;
    String provider;
    Geocoder geocoder;
    List<Address> addresses;
    ImageView img,img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner);
        img = (ImageView) findViewById(R.id.winid);
        img1 = (ImageView) findViewById(R.id.winid1);
        img.setVisibility(View.INVISIBLE);
        img1.setVisibility(View.INVISIBLE);
        geocoder = new Geocoder(this, Locale.getDefault());
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        country = (TextView) findViewById(R.id.country);
        Criteria criteria = new Criteria();
// Getting the name of the provider that meets the criteria
        provider = locationManager.getBestProvider(criteria, false);
        if (provider != null && !provider.equals("")) {
            // Get the location from the given provider
            if (!provider.isEmpty()) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    if( new Random().nextInt(100)%2 == 0){
                        img.setVisibility(View.VISIBLE);
                    }else{
                        img1.setVisibility(View.VISIBLE);
                    }
                    return;
                }
                Location location = locationManager.getLastKnownLocation(provider);
                if (location != null)
                    onLocationChanged(location);

            } else {

            }
        }
        if ("India".equalsIgnoreCase(country.getText().toString())) {
            img.setVisibility(View.VISIBLE);
        } else if ("United States".equalsIgnoreCase(country.getText().toString())){
            img1.setVisibility(View.VISIBLE);
        } else {
            if( new Random().nextInt(100)%2 == 0){
                img.setVisibility(View.VISIBLE);
            }else{
                img1.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void onBackPressed(){
       finish();
    }
        @Override
        public void onLocationChanged(Location location) {
                        try {
                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            country.setText(addresses.get(0).getCountryName());
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();
        }

}
