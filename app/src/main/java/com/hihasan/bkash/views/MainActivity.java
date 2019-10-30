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
import com.hihasan.bkash.adapter.ContentAdapter;
import com.hihasan.bkash.adapter.ContentAdapterTest;
import com.hihasan.bkash.model.ContentModel;
import com.hihasan.bkash.model.ContentModelTest;
import com.hihasan.bkash.util.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
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
    ContentAdapter contentAdapter;
    LinearLayoutManager linearLayoutManager;

    //ListView
    private static MainActivity inst;


    ArrayList <ContentModel> itemList = new ArrayList<ContentModel>();

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

        //Utils.contentModel();


        recycler = findViewById (R.id.content);
        contentAdapter=new ContentAdapter(R.layout.activity_content, itemList);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(contentAdapter);

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

                AppCompatImageView github = dialog.findViewById(R.id.github);
                AppCompatImageView facebook = dialog.findViewById (R.id.facebook);
                AppCompatImageView linkedin = dialog.findViewById (R.id.linkedin);

                github.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("https://github.com/hihasan"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });

                facebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("https://www.facebook.com/hnadim4"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });

                linkedin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("https://www.linkedin.com/in/hihasan/"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
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
                //itemList.add(new ContentModel(str));
                String str=smsInboxCursor.getString(indexBody);
                String [] data1=str.split("Tk",2);
                System.out.println("Type: "+data1[0]);
                String str2=data1[1];

                String [] data2=str2.split("from",2);
                System.out.println("Ammount: "+data2[0]);
                String str3=data2[1];

                String [] data3=str3.split("successful",2);
                System.out.println("From: "+data3[0]);
                String str4=data3[1];


                String []data4=str4.split("Balance Tk",2);
                String str5=data4[1];
                String [] data5=str5.split("\\. TrxID",2);
                System.out.println("Total Ammount:  "+data5[0]);
                String str6=data5[1];

                String [] data6=str6.split("at",2);
                System.out.println("Transaction ID: "+data6[0]);
                String str7=data6[1];

                String [] data7=str7.split("\\.",2);
                System.out.println("Date & Time: "+data7[0]);


                itemList.add(new ContentModel(data1[0],data3[0],data6[0],data7[0],data2[0]));
            }

        } while (smsInboxCursor.moveToNext());
    }


}
