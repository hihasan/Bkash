package com.hihasan.bkash.util;

import android.content.Context;
import android.widget.Toast;

public class Utils
{
    public static void Toaster(Context c, String msg){
        Toast.makeText(c,msg,Toast.LENGTH_SHORT).show();
    }
}
