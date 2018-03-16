package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.Teaches.CoachTeachDetailsActivity;
import com.technologygroup.rayannoor.yoga.Teaches.CoachTeachsActivity;
import com.technologygroup.rayannoor.yoga.Teaches.TeachDetailsActivity;
import com.technologygroup.rayannoor.yoga.Teaches.teachsActivity;

/**
 * Created by Mohamad Hasan on 2/21/2018.
 */

public class TeachCoachesAdapter extends RecyclerView.Adapter<TeachCoachesAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;



    public TeachCoachesAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_teach_coach_list, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CoachTeachsActivity activity = (CoachTeachsActivity) context;
                Intent intent = new Intent(activity, CoachTeachDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class myViewHolder extends RecyclerView.ViewHolder {


        private TextView txtDate;
        private TextView txtTitle;
        private TextView txtProfile;
        private TextView txtCoachName;
        private ImageView imgTeach;

        myViewHolder(View itemView) {
            super(itemView);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtProfile = (TextView) itemView.findViewById(R.id.txtProfile);
            txtCoachName = (TextView) itemView.findViewById(R.id.txtCoachName);
            imgTeach = (ImageView) itemView.findViewById(R.id.imgTeach);
        }
    }
}
