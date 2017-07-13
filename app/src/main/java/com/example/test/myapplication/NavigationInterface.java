package com.example.test.myapplication;

import com.example.test.myapplication.fragment.FragmentA;
import com.example.test.myapplication.fragment.FragmentB;
import com.example.test.myapplication.fragment.FragmentC;
import com.example.test.myapplication.fragment.helper.OnFragmentInteractionListener;

/**
 * Created by itdept on 10/7/2017.
 */

public interface NavigationInterface extends OnFragmentInteractionListener {

    void populate();
    void sendPushNotification();
    public void showFragmentA();
    public void showFragmentB();
    public void showFragmentC();

    FragmentA getFragmentA();
    FragmentB getFragmentB();
    FragmentC getFragmentC();
    String getFirebaseAccessToken();
}
