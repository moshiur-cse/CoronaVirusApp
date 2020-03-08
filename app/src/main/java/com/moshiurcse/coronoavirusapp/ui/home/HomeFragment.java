package com.moshiurcse.coronoavirusapp.ui.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.moshiurcse.coronoavirusapp.MainActivity;
import com.moshiurcse.coronoavirusapp.R;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class HomeFragment extends Fragment{// implements View.OnKeyListener {

    private HomeViewModel homeViewModel;
    private WebView webView;
    private MyConnectivityReceiver receiver;
    private AlertDialog.Builder alertDialogBuilder;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        receiver = new MyConnectivityReceiver();
        webView = root.findViewById(R.id.text_home);
        return root;
    }


    public  void webView(){
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.arcgis.com/apps/opsdashboard/index.html#/85320e2ea5424dfaaa75ae62e5c06e61/");

    }




    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(receiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }


    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(receiver);
    }

    private class MyConnectivityReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null && info.isConnected()){
                Toast.makeText(context, "connected", Toast.LENGTH_SHORT).show();

               /* if (myLocation != null){
                    getNearbyPlaces(placeType,radius);
                }*/

                webView();
            }else{

                alertDialogBuilder=new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("No Internet Available!");
                alertDialogBuilder.setMessage("Please Connect Internet");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

               /* alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                });*/

                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();
                //Toast.makeText(context, "You are not connected to internet", Toast.LENGTH_LONG).show();
            }
        }
    }
}