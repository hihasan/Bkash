package com.hihasan.bkash.adapter;

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

public class ContentAdapterTest extends RecyclerView.Adapter<ContentAdapterTest.ViewHolder> {
    public ContentModelTest[]contentTest;

    public ContentAdapterTest(ContentModelTest[]contentTest){
        this.contentTest=contentTest;
    }
    @NonNull
    @Override
    public ContentAdapterTest.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View listAdapter=inflater.inflate(R.layout.activity_content_test,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(listAdapter);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentAdapterTest.ViewHolder holder, int position) {
        final ContentModelTest data=contentTest[position];
        holder.msg_txt.setText(data.getMsg());
        holder.model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.Toaster(view.getContext(),data.msg);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contentTest.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView msg_txt;
        CardView model;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            msg_txt = itemView.findViewById (R.id.msg_txt);
            model= itemView.findViewById (R.id.model);
        }
    }
}
