package com.refresh.pos.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.refresh.pos.ui.CreAbsActivity;

public class NetworkBroadcastReceiver extends BroadcastReceiver  {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        if(isInternetConnected(context)) {
            // Here, I read all the pending requests from the SharedPreferences file, and execute them one by one.
        }    
    }
    public boolean isInternetConnected(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}