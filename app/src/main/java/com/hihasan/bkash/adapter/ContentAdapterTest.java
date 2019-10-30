package com.hihasan.bkash.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hihasan.bkash.R;
import com.hihasan.bkash.model.ContentModelTest;
import com.hihasan.bkash.util.Utils;

import java.util.ArrayList;

public class ContentAdapterTest extends RecyclerView.Adapter<ContentAdapterTest.ViewHolder> {
    //public ContentModelTest[]contentTest;
    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<ContentModelTest> itemList;

    public ContentAdapterTest(int listItemLayout, ArrayList<ContentModelTest> itemList){
        this.listItemLayout=listItemLayout;
        this.itemList=itemList;

    }
    @Override
    public int getItemCount() {
        //return itemList == null ? 0 : itemList.size();
        return itemList.size();
    }

    @NonNull
    @Override
    public ContentAdapterTest.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
//        View listAdapter=inflater.inflate(R.layout.activity_content_test,viewGroup,false);
//        ViewHolder viewHolder=new ViewHolder(listAdapter);
//        return viewHolder;

        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ContentAdapterTest.ViewHolder holder, int listPosition) {
        //AppCompatTextView item = holder.msg_txt;
        holder.msg_txt.setText(itemList.get(listPosition).getMsg());

    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        AppCompatTextView msg_txt;
        CardView model;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            msg_txt = itemView.findViewById (R.id.msg_txt);
            model= itemView.findViewById (R.id.model);
        }

        @Override
        public void onClick(View view) {
            Log.d("Hihasan", "onClick " + getLayoutPosition() + " " + msg_txt.getText());
        }
    }
}
