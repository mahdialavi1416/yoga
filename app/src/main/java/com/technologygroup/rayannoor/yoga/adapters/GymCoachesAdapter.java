package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.technologygroup.rayannoor.yoga.R;

/**
 * Created by Mohamad Hasan on 3/8/2018.
 */

public class GymCoachesAdapter extends RecyclerView.Adapter<GymCoachesAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;



    public GymCoachesAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public GymCoachesAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_gym_coach_list, parent, false);
        GymCoachesAdapter.myViewHolder holder = new GymCoachesAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final GymCoachesAdapter.myViewHolder holder, int position) {
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
