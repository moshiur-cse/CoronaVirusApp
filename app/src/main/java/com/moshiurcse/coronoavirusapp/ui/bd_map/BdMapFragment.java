package com.moshiurcse.coronoavirusapp.ui.bd_map;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.moshiurcse.coronoavirusapp.R;


public class BdMapFragment extends Fragment{

    private GoogleMap mMap;
    private CircleOptions circleOptions;
    private Marker mMarker;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bd_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
               mapInit(mMap);

            }

        });

        return rootView;
    }

    public void mapInit(GoogleMap mMap){
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.clear(); //clear old markers

        LatLng latLng = new LatLng(23.777176,90.399452);

        CameraPosition googlePlex = CameraPosition.builder()
                .target(latLng)
                .zoom(7)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 3000, null);

       /* mMap.addMarker(new MarkerOptions()
                .position(new LatLng(23.777176, 90.399452))
                .title("Dhaka")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .snippet("Total: 3 | Revoer: 0 | Active: 3")
        );*/

        drawMarkerWithCircle(mMap,latLng);





    }

    public void drawMarkerWithCircle(GoogleMap mMap ,LatLng position){
       double radiusInMeters = 10000.0;
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill

         circleOptions = new CircleOptions().center(position).radius(radiusInMeters).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(8);
         mMap.addCircle(circleOptions);


        mMap.addMarker(new MarkerOptions()
                .position(position)
                .title("Dhaka")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .snippet("Total Confirmed: 10 | Recovered: 3 | Active: 7")
        );


    }

}
