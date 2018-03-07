package com.technologygroup.rayannoor.yoga.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.Gyms.GymProfileActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymsListActivity;
import com.technologygroup.rayannoor.yoga.Models.CoachGymsModel;
import com.technologygroup.rayannoor.yoga.R;

/**
 * Created by Mohamad Hasan on 2/7/2018.
 */

public class GymListAdapter extends RecyclerView.Adapter<GymListAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private CoachGymsModel models[];
    private Dialog dialog;



    public GymListAdapter(Context context, CoachGymsModel[] models) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.models = models;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_gym_list, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {

        holder.txtGymName.setText(models[position].id + "");
        holder.id = models[position].id;
        holder.Img = models[position].Img;
        holder.like = models[position].like;
        holder.Rate = models[position].Rate;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GymsListActivity activity = (GymsListActivity)context;
                Intent intent = new Intent(activity , GymProfileActivity.class);
                intent.putExtra("id", holder.id);
                intent.putExtra("Img", holder.Img);
                intent.putExtra("like", holder.like);
                intent.putExtra("Rate", holder.Rate);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.length;
    }


    class myViewHolder extends RecyclerView.ViewHolder {

        private TextView txtGymName;
        private ImageView imgGym;

        public int id;
        private String Img;
        private String Name;
        private int like;
        private double Rate;


        myViewHolder(View itemView) {
            super(itemView);
//            Toast.makeText(itemView.getContext(), "Salaam", Toast.LENGTH_LONG).show();
            txtGymName = (TextView) itemView.findViewById(R.id.txtCoachName);
            imgGym = (ImageView) itemView.findViewById(R.id.imgGym);
        }
    }
}