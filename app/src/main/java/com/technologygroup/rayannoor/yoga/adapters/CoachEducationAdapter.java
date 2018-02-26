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
 * Created by Mohamad Hasan on 2/13/2018.
 */

public class CoachEducationAdapter extends RecyclerView.Adapter<CoachEducationAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;



    public CoachEducationAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CoachEducationAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_coach_education_list, parent, false);
        CoachEducationAdapter.myViewHolder holder = new CoachEducationAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CoachEducationAdapter.myViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }



    class myViewHolder extends RecyclerView.ViewHolder {

        private TextView txtEducationTitle;
        private ImageView imgEducation;


        myViewHolder(View itemView) {
            super(itemView);
            txtEducationTitle = (TextView) itemView.findViewById(R.id.txtEducationTitle);
            imgEducation = (ImageView) itemView.findViewById(R.id.imgEducation);
        }
    }
}