package com.hihasan.bkash.util;

import android.content.Context;
import android.widget.Toast;

import com.hihasan.bkash.model.ContentModelTest;

public class Utils
{
    public static ContentModelTest[]contentModelTests;

    public static void contentModel(){
        contentModelTests=new ContentModelTest[]{
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
                new ContentModelTest("Cash In Tk 1,200.00 from 01848207862 successful. Fee Tk 0.00. Balance Tk 1,225.97. TrxID 6JJ6GP052S at 19/10/2019 20:01. Download bKash App: bKa.sh/8app"),
        };
    }
    public static void Toaster(Context c, String msg){
        Toast.makeText(c,msg,Toast.LENGTH_SHORT).show();
    }
}
