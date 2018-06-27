package com.example.extensibletenderexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.clover.sdk.util.CustomerMode;
import com.clover.sdk.v1.Intents;

import static android.text.TextUtils.isEmpty;


public class PaymentReceiver extends BroadcastReceiver {
    private Context mContext;
    private String TAG = "PaymentReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;

        String orderId = intent.getStringExtra("order_id");
        String paymentId = intent.getStringExtra(Intents.EXTRA_CLOVER_PAYMENT_ID);
        String tenderKey = intent.getStringExtra(Intents.EXTRA_CLOVER_TENDER_LABEL_KEY);
        long amount = intent.getLongExtra("com.clover.intent.extra.AMOUNT", 0L);
        Log.i(TAG, "Payment processed! Order: " + orderId + " Payment ID: " + paymentId + " Amount: " + amount);

        //Launching activity to complete loyalty transaction

        Intent transactionIntent = new Intent(mContext, TransactionActivity.class);
        transactionIntent.putExtra("order_id", orderId);
        transactionIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(transactionIntent);
    }
}