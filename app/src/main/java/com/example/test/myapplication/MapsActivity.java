package com.example.test.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.example.test.myapplication.bus.PushNotificationBus;
import com.example.test.myapplication.fcm.FirebaseManager;
import com.example.test.myapplication.fragment.FragmentA;
import com.example.test.myapplication.fragment.FragmentB;
import com.example.test.myapplication.fragment.FragmentC;
import com.example.test.myapplication.pojo.pushonotification.List;
import com.example.test.myapplication.pojo.pushonotification.PushContainer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, NavigationInterface {



    private GoogleMap mMap;
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;
    FirebaseManager firebaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        populate();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onBackClick() {
        onBackPressed();
    }

    @Override
    public void onNextClick() {

    }

    @Override
    public void populate() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        firebaseManager = new FirebaseManager(this);
        showFragmentA();
        String firebaseAccessToken = getFirebaseAccessToken();
        if (firebaseAccessToken==null){
            Toast.makeText(this, "Snap! Push notification not registered. Make sure you have good internet connection. Close then re-open the app.", Toast.LENGTH_LONG).show();
        }else{
            Log.d("", "populate: accessToken:"+firebaseAccessToken);
            Toast.makeText(this, "Push notification status is working. Please test with pushtry.com.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void sendPushNotification() {

    }

    @Override
    public void showFragmentA() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, getFragmentA());
        //ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void showFragmentB() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, getFragmentB());
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void showFragmentC() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, getFragmentC());
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public FragmentA getFragmentA() {
        if (fragmentA==null)
            fragmentA = FragmentA.newInstance("","");
        return fragmentA;
    }

    @Override
    public FragmentB getFragmentB() {
        if (fragmentB==null)
            fragmentB = FragmentB.newInstance("","");
        return fragmentB;
    }

    @Override
    public FragmentC getFragmentC() {
        if (fragmentC==null)
            fragmentC = FragmentC.newInstance(1);
        return fragmentC;
    }

    @Override
    public String getFirebaseAccessToken() {
        return firebaseManager.getValueByKey(FirebaseManager.TOKEN_KEY);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount()==0){
            Toast.makeText(this, "Goodbye!", Toast.LENGTH_SHORT).show();
        }
        super.onBackPressed();
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPushNotificationEvent(PushNotificationBus event) {
        if (event!=null){
            if (event.getPushContainer()!=null){
                PushContainer pushContainer = event.getPushContainer();
                int size = pushContainer.getList().size();
                String message = "";
                for (int x = 0; x < size; x++){
                    List list = pushContainer.getList().get(x);
                    message+=list.getName()+",";
                }
                String str = "Received:"+size+" entries."+"\n" +
                        ""+message+"";
                Toast.makeText(this, str, Toast.LENGTH_LONG).show();
            }
        }
    };
}

