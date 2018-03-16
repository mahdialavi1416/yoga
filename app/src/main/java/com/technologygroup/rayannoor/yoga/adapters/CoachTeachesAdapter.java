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

import com.technologygroup.rayannoor.yoga.Gyms.GymProfileActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymsListActivity;
import com.technologygroup.rayannoor.yoga.Models.CoachGymsModel;
import com.technologygroup.rayannoor.yoga.R;

/**
 * Created by Mohamad Hasan on 3/16/2018.
 */

public class CoachTeachesAdapter extends RecyclerView.Adapter<CoachTeachesAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;




    public CoachTeachesAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CoachTeachesAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_coach_teach_list, parent, false);
        CoachTeachesAdapter.myViewHolder holder = new CoachTeachesAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CoachTeachesAdapter.myViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class myViewHolder extends RecyclerView.ViewHolder {


        myViewHolder(View itemView) {
            super(itemView);
        }
    }
}
