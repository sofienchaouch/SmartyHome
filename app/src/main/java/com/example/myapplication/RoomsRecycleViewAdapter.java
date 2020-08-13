package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RoomsRecycleViewAdapter extends RecyclerView.Adapter<RoomsRecycleViewAdapter.MyViewHolder> {

    Context context ;
    String data1[] ;
    String data2[] ;
    int images[] ;

    public  RoomsRecycleViewAdapter (Context ct , String s1[] , String s2[] , int img[]){
        context = ct ;
        data1 = s1 ;
        data2 = s2 ;
        images = img ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.room,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.roomText.setText(data1[position]);
        holder.devicesText.setText(data2[position]);
        holder.roomImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView roomText ,devicesText ;
        ImageView roomImage ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            roomText = itemView.findViewById(R.id.room_txt);
            devicesText =  itemView.findViewById(R.id.devices_txt);
            roomImage =  itemView.findViewById(R.id.room_image);
        }
    }
}
