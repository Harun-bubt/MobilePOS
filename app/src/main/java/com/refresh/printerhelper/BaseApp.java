package com.refresh.printerhelper;

import android.app.Application;

import com.refresh.printerhelper.utils.AidlUtil;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by Administrator on 2017/4/27.
 */

public class BaseApp extends Application {
    private boolean isAidl;

    public boolean isAidl() {
        return isAidl;
    }

    public void setAidl(boolean aidl) {
        isAidl = aidl;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        isAidl = true;
        AidlUtil.getInstance().connectPrinterService(this);
        Realm.init(this) ; // context, usually an Activity or Application
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("Mobile POS").allowWritesOnUiThread(true)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);

    }


}
