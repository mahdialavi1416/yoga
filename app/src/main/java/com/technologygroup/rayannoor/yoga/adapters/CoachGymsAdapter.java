package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.R;

/**
 * Created by Mohamad Hasan on 2/12/2018.
 */

public class CoachGymsAdapter extends RecyclerView.Adapter<CoachGymsAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;



    public CoachGymsAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_coach_gym_list, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }




    class myViewHolder extends RecyclerView.ViewHolder {

        private TextView txtGymRate;
        private TextView txtGymLikeCount;
        private TextView txtGymName;
        private ImageView imgGym;


        myViewHolder(View itemView) {
            super(itemView);
            txtGymRate = (TextView) itemView.findViewById(R.id.txtGymRate);
            txtGymLikeCount = (TextView) itemView.findViewById(R.id.txtGymLikeCount);
            txtGymName = (TextView) itemView.findViewById(R.id.txtGymName);
            imgGym = (ImageView) itemView.findViewById(R.id.imgGym);
        }
    }
}
