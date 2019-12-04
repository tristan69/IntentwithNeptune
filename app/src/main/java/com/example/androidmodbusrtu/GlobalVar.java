package com.example.androidmodbusrtu;

import android.app.Application;

public class GlobalVar extends Application {

    String String1;
    String String2;

    public String getString1() {
        return String1;
    }

    public void setString1(String string1) {
        String1 = string1;
    }

    public String getString2() {
        return String2;
    }

    public void setString2(String string2) {
        String2 = string2;
    }

}
