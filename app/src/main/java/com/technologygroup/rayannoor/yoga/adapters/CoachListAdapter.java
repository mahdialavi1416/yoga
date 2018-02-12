package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.Coaches.CoachDetailsActivity;
import com.technologygroup.rayannoor.yoga.Coaches.CoachProfileActivity;
import com.technologygroup.rayannoor.yoga.Coaches.CoachListActivity;
import com.technologygroup.rayannoor.yoga.R;

/**
 * Created by Mohamad Hasan on 2/7/2018.
 */

public class CoachListAdapter extends RecyclerView.Adapter<CoachListAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;



    public CoachListAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_coach_list, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        if (position % 2 == 0)
            holder.imgCoach.setImageResource(R.mipmap.ic_woman);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CoachListActivity activity = (CoachListActivity)context;
                Intent intent = new Intent(activity , CoachDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class myViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCoachName;
        private ImageView imgCoach;


        myViewHolder(View itemView) {
            super(itemView);
            txtCoachName = (TextView) itemView.findViewById(R.id.txtCoachName);
            imgCoach = (ImageView) itemView.findViewById(R.id.imgCoach);
        }
    }
}
