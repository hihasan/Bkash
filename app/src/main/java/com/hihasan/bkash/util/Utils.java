package com.hihasan.bkash.util;

import android.content.Context;
import android.widget.Toast;

import com.hihasan.bkash.model.ContentModelTest;

public class Utils
{
    public static ContentModelTest[]contentModelTests;

    public static void contentModel(){
        contentModelTests=new ContentModelTest[]{
                new ContentModelTest("THis is test"),
                new ContentModelTest("THis is test"),
                new ContentModelTest("THis is test"),
                new ContentModelTest("THis is test"),
                new ContentModelTest("THis is test"),
        };
    }
    public static void Toaster(Context c, String msg){
        Toast.makeText(c,msg,Toast.LENGTH_SHORT).show();
    }
}
