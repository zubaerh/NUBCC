package com.zubaer.nubcc;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeacherRecyclerAdapter extends RecyclerView.Adapter<TeacherRecyclerAdapter.MyViewHolder> {
    ArrayList<Teacher> mData;
    Context mContext;

    public TeacherRecyclerAdapter(ArrayList<Teacher> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }


    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_teacher, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherRecyclerAdapter.MyViewHolder holder, int position){
        Picasso.get().load(mData.get(position).getImg()).into(holder.iv_teacher_img);
        holder.tv_teacher_name.setText(mData.get(position).getName());
        holder.tv_teacher_deg.setText(mData.get(position).getDeg());
        holder.tv_teacher_phone.setText(""+mData.get(position).getPhone());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(mContext);
                dialog.setContentView(R.layout.dialog_teacher);

                ImageView iv_teacher_img;
                TextView tv_teacher_name;
                TextView tv_teacher_deg;
                TextView tv_teacher_phone;

                iv_teacher_img = dialog.findViewById(R.id.iv_teacher_img);
                tv_teacher_name = dialog.findViewById(R.id.tv_teacher_name);
                tv_teacher_deg = dialog.findViewById(R.id.tv_teacher_deg);
                tv_teacher_phone = dialog.findViewById(R.id.tv_teacher_phone);

                Picasso.get().load(mData.get(position).getImg()).into(iv_teacher_img);
                tv_teacher_name.setText(mData.get(position).getName());
               tv_teacher_deg.setText(mData.get(position).getDeg());
                tv_teacher_phone.setText(""+mData.get(position).getPhone());

                dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_teacher_img;
        TextView tv_teacher_name;
        TextView tv_teacher_deg;
        TextView tv_teacher_phone;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_teacher_img = itemView.findViewById(R.id.iv_teacher_img);
            tv_teacher_name = itemView.findViewById(R.id.tv_teacher_name);
            tv_teacher_deg = itemView.findViewById(R.id.tv_teacher_deg);
            tv_teacher_phone = itemView.findViewById(R.id.tv_teacher_phone);
        }
    }
}