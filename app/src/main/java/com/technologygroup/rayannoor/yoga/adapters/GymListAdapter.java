package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.technologygroup.rayannoor.yoga.Gyms.GymProfileActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymsListActivity;
import com.technologygroup.rayannoor.yoga.R;

/**
 * Created by Mohamad Hasan on 2/7/2018.
 */

public class GymListAdapter extends RecyclerView.Adapter<GymListAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;



    public GymListAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public GymListAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_gym_list, parent, false);
        GymListAdapter.myViewHolder holder = new GymListAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GymListAdapter.myViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GymsListActivity activity = (GymsListActivity)context;
                Intent intent = new Intent(activity , GymProfileActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class myViewHolder extends RecyclerView.ViewHolder {

        private TextView txtGymName;
        private ImageView imgGym;


        myViewHolder(View itemView) {
            super(itemView);
            txtGymName = (TextView) itemView.findViewById(R.id.txtGymName);
            imgGym = (ImageView) itemView.findViewById(R.id.imgGym);
        }
    }
}