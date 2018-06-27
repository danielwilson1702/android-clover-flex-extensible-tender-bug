package com.example.extensibletenderexample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class TransactionActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
    }

    @Override
    protected void onResume() {
        super.onResume();


        //After a payment for this order is received,
        //we talk to our server to allow the customer to earn some loyalty points and then close the activity
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 5000);
    }
}