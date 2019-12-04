package com.example.androidmodbusrtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Intent.EXTRA_TEXT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button mButton = findViewById(R.id.btn1);
        mButton.setOnClickListener(this);

        Button mButton2 = findViewById(R.id.btn2);
        mButton2.setOnClickListener(this);

        Button mButton3 = findViewById(R.id.btn3);
        mButton3.setOnClickListener(this);

        Button mButton4 = findViewById(R.id.btn4);
        mButton4.setOnClickListener(this);

        GlobalVar globalVar = (GlobalVar) getApplicationContext();

        globalVar.setString1("test 1");
        globalVar.setString2("test 2");


        IntentFilter filter = new IntentFilter("com.darryncampbell.cordova.plugin.intent.ACTION");
        MyBroadcastReceiver receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, filter);


        // log
        //GlobalVar singleToneClass = com.example.androidmodbusrtu.GlobalVar.getInstance();
        //TextView textView = findViewById(R.id.textView);
        //textView.setText(singleToneClass.getData());

        /*
        CharSequence receivedtext = (CharSequence) filter;
        Toast toastreceived = Toast.makeText(getApplicationContext(), receivedtext, Toast.LENGTH_LONG);
        toastreceived.show();
        */
/*
        String stuffreceived = filter;
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(stuffreceived);
*/
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.btn1:{
                sendStuff();
                break;
            }
            case R.id.btn2:{
                receiveStuff();
                break;
            }
            case R.id.btn3:{
                TestStuff();
                break;
            }
            case R.id.btn4:{
                resetStuff();
                break;
            }
        }
    }

    public void sendStuff(){
        Intent intent = new Intent();
        intent.setAction("com.example.androidmodbusrtu.ACTION_SEND");
        intent.putExtra(EXTRA_TEXT, "Text send test");
        sendBroadcast(intent);
    }

    public void receiveStuff(){
        TextView textView = (TextView) findViewById(R.id.textView);
        DataModel dataModel = new DataModel();
        dataModel.updateTextView(textView, getApplicationContext());
    }

    public void TestStuff(){
        GlobalVar globalVar = (GlobalVar) getApplicationContext();
        globalVar.setString1("TEST WORKS");
        Toast.makeText(getApplicationContext(), globalVar.getString1(), Toast.LENGTH_LONG).show();
    }

    public void resetStuff(){
        GlobalVar globalVar = (GlobalVar) getApplicationContext();
        globalVar.setString1("RESET");
        Toast.makeText(getApplicationContext(), globalVar.getString1(), Toast.LENGTH_LONG).show();
    }

/*
        DataModel datamodel = new DataModel("coucou1", "coucou2", "coucou3");

        TextView viewData1, viewData2, viewData3;

        viewData1 = findViewById(R.id.viewdata1);
        viewData1.setText(datamodel.data1);

        viewData2 = findViewById(R.id.viewdata2);
        viewData2.setText(datamodel.data2);

        viewData3 = findViewById(R.id.viewdata3);
        viewData3.setText(datamodel.data3);
*/
        //setContentView(R.layout.datamodel);


/*
    public void testBLE(){
        Context context = getApplicationContext();
        RxBleClient rxBleClient = RxBleClient.create(context);
        try{
            Disposable scanSubscription = rxBleClient.scanBleDevices(
                    new ScanSettings.Builder()
                            // .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY) // change if needed
                            // .setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES) // change if needed
                            .build()
                    // add filters if needed
            )
                    .subscribe(
                            scanResult -> {

                                // Process scan result here.
                            },
                            throwable -> {
                            }
                    );

// When done, just dispose.
            scanSubscription.dispose();
        }
        catch (Exception e){
            CharSequence text = e.getMessage();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        try{
            String macAddress = "70-18-8B-CE-BE-29";
            RxBleDevice device = rxBleClient.getBleDevice(macAddress);

            Disposable disposable = device.establishConnection(false) // <-- autoConnect flag
                    .subscribe(
                            rxBleConnection -> {
                                // All GATT operations are done through the rxBleConnection.
                            },
                            throwable -> {
                                // Handle an error here.
                            }
                    );
// When done... dispose and forget about connection teardown :)
            disposable.dispose();
        }
        catch (Exception e){
            CharSequence text = e.getMessage();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    public void testMODBUS(){
        ModbusTCPMaster master;
        //Logger logger;
        try {
            // master = new ModbusTCPMaster(<address>);  // Uses port 502 and a timeout of 3000ms
            // master = new ModbusTCPMaster(<address>, <port>); // Uses a timeout of 3000ms
            master = new ModbusTCPMaster("", 1, true);
            master.connect();

            // master.readCoils(<coil ref>, <count>);           // Uses a UNIT ID of 1
            // master.readCoils(<unit id>, <coil ref>, <count>);

            // master.readInputDiscretes(<discrete ref>, <count>);  // Uses a UNIT ID of 1
            // master.readInputDiscretes(<unit id>, <discrete ref>, <count>);

            // master.readInputInputRegisters(<discrete ref>, <count>); // Uses a UNIT ID of 1
            // master.readInputInputRegisters(<unit id>, <discrete ref>, <count>);

            // master.readMultipleRegisters(<discrete ref>, <count>);  // Uses a UNIT ID of 1
            // master.readMultipleRegisters(<unit id>, <discrete ref>, <count>);
            if (master != null) {
                master.disconnect();
            }
        }
        catch (Exception e) {
            Context context = getApplicationContext();
            CharSequence text = e.getMessage();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            //logger = new Logger();
            //logger.error("Cannot connect to slave - %s", e.getMessage());
        }

    }

    */

}

