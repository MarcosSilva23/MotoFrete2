package com.example.marcos.motofrete;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by marcos on 27/11/2016.
 */
public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        if(googleServicesAvaliable()){
            Toast.makeText(this,"Conectado com Sucesso",Toast.LENGTH_SHORT).show();
            initMap();
        }

    }

    private void initMap() {
        MapFragment mapfragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapfragment.getMapAsync(this);
    }

    public boolean googleServicesAvaliable(){

            GoogleApiAvailability api = GoogleApiAvailability.getInstance();
            int isAvaliable = api.isGooglePlayServicesAvailable(this);
            if (isAvaliable == ConnectionResult.SUCCESS){
                return true;
            } else if (api.isUserResolvableError(isAvaliable)){
                Dialog dialog = api.getErrorDialog(this,isAvaliable,0);
                dialog.show();
            } else {
                Toast.makeText(this,"Não é possível conectar ao Google Play Services",Toast.LENGTH_SHORT).show();
            }
            return false;
        }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
    }
}


