package com.example.androidmodbusrtu;

import android.content.Context;
import android.widget.TextView;

public class DataModel {

    public DataModel() {
    }

    public void updateTextView (TextView mTextView, Context context){
        mTextView.findViewById(R.id.textView);
        GlobalVar globalVar = (GlobalVar) context.getApplicationContext();
        mTextView.setText (globalVar.getString1());
    }

}