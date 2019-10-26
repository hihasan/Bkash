package com.hihasan.bkash.views;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton about_us,faq,follow;
    Context context=this;
    RecyclerView recycler;
    ContentAdapterTest contentAdapterTest;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Utils.contentModel();

        recycler = findViewById (R.id.content);
        contentAdapterTest=new ContentAdapterTest(Utils.contentModelTests);
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(contentAdapterTest);


        initFab();
    }

    private void initFab()
    {
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
}
