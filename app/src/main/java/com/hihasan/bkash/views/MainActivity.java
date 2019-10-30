package com.hihasan.bkash.views;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.hihasan.bkash.R;
import com.hihasan.bkash.adapter.ContentAdapterTest;
import com.hihasan.bkash.model.ContentModelTest;
import com.hihasan.bkash.util.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton about_us,faq,follow;
    Context context=this;
    RecyclerView recycler;
    ContentAdapterTest contentAdapterTest;
    LinearLayoutManager linearLayoutManager;

    //ListView
    private static MainActivity inst;


    ArrayList <ContentModelTest> itemList = new ArrayList<ContentModelTest>();

    public static MainActivity instance() {
        return inst;
    }
    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Utils.contentModel();


        recycler = findViewById (R.id.content);
        contentAdapterTest=new ContentAdapterTest(R.layout.activity_content_test, itemList);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(contentAdapterTest);

        // Add SMS Read Permision At Runtime
        // Todo : If Permission Is Not GRANTED
        if(ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_SMS") == PackageManager.PERMISSION_GRANTED) {

            // Todo : If Permission Granted Then Show SMS
            //;
            refreshSmsInbox();

        } else {
            // Todo : Then Set Permission
            final int REQUEST_CODE_ASK_PERMISSIONS = 123;
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{"android.permission.READ_SMS"}, REQUEST_CODE_ASK_PERMISSIONS);
        }

        initFab();
    }

    private void initFab() {
        about_us= findViewById (R.id.about_us);
        faq= findViewById (R.id.faq);
        follow= findViewById (R.id.follow);

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.activity_about);

                final AppCompatButton close=(AppCompatButton) dialog.findViewById (R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,FaqActivity.class);
                startActivity(i);
            }
        });

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Utils.Toaster(getApplicationContext(),"Action Required");
                final Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.activity_follow);

                dialog.show();
            }
        });
    }

    public void refreshSmsInbox() {
        ContentResolver contentResolver = getContentResolver();
        Cursor smsInboxCursor = contentResolver.query(Uri.parse("content://sms/inbox"), null, null, null, null);
        int indexBody = smsInboxCursor.getColumnIndex("body");
        int indexAddress = smsInboxCursor.getColumnIndex("address");
        if (indexBody < 0 || !smsInboxCursor.moveToFirst()) return;
        do {

            if (smsInboxCursor.getString(indexAddress).toString().equalsIgnoreCase("BKASH")){
//                String str = "SMS From: " + smsInboxCursor.getString(indexAddress)
//                        + "\n" + smsInboxCursor.getString(indexBody) + "\n";
                String str=smsInboxCursor.getString(indexBody);
                itemList.add(new ContentModelTest(str));
            }

        } while (smsInboxCursor.moveToNext());
    }


}
