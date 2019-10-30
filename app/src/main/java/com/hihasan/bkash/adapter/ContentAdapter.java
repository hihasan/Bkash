package com.hihasan.bkash.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.hihasan.bkash.R;
import com.hihasan.bkash.model.ContentModel;

import java.util.ArrayList;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {
    private int listItemLayout;
    private ArrayList<ContentModel> itemList;

    public ContentAdapter(int listItemLayout,ArrayList<ContentModel> itemList){
        this.listItemLayout=listItemLayout;
        this.itemList=itemList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ContentAdapter.ViewHolder myViewHolder = new ContentAdapter.ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int listPosition) {
        holder.type.setText(itemList.get(listPosition).getType());
        holder.from_phn.setText(itemList.get(listPosition).getFrom_phn());
        holder.trxid.setText(itemList.get(listPosition).getTrxid());
        holder.datevalue.setText(itemList.get(listPosition).getDatevalue());
        holder.totalvalue.setText(itemList.get(listPosition).getTotalvalue());
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        AppCompatTextView type,from_phn,trxid,datevalue,totalvalue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            type = itemView.findViewById (R.id.type);
            from_phn = itemView.findViewById (R.id.from_phn);
            trxid = itemView.findViewById (R.id.trxid);
            datevalue = itemView.findViewById (R.id.datevalue);
            totalvalue = itemView.findViewById (R.id.totalvalue);
        }

        @Override
        public void onClick(View v) {
            Log.d("Hihasan", "onClick " + getLayoutPosition() + " " + from_phn.getText());
        }
    }
}
