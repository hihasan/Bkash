package com.hihasan.bkash.views;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hihasan.bkash.R;

public class FaqActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
    }

    public void goBack(View view){
        if (view.getId() == R.id.back){
            Intent i = new Intent(FaqActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
