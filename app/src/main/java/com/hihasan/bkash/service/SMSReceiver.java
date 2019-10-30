package com.hihasan.bkash.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import com.hihasan.bkash.util.Utils;
import com.hihasan.bkash.views.MainActivity;

public class SMSReceiver extends BroadcastReceiver {
    public static final String SMS_BUNDLE = "pdus";

    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            String smsMessageStr = "";
            for (int i = 0; i < sms.length; ++i) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                String smsBody = smsMessage.getMessageBody().toString();
                String address = smsMessage.getOriginatingAddress();

                if (address.equals("GP")){
                    smsMessageStr += "SMS From: " + address + "\n";
                    smsMessageStr += smsBody + "\n";
                }

            }
//            Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();
            Utils.Toaster(context,smsMessageStr);

            //this will update the UI with message
            MainActivity inst = MainActivity.instance();
//            inst.updateList(smsMessageStr);
        }
    }
}
