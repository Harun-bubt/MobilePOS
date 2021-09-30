package com.refresh.pos.ui;

public interface CreAbsActivity {

    public abstract int onRequestSuccess(String code, String msg);
    public abstract int onRequestFail(String code, String msg);
    public abstract void showProgress(boolean bshow);
}
