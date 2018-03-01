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

public class CoachResumeAdapter extends RecyclerView.Adapter<CoachResumeAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;



    public CoachResumeAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_coach_resume_list, parent, false);
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

        private TextView txtResumeTitle;
        private TextView txtStartDate;
        private TextView txtEndDate;
        private ImageView imgDelete;
        private ImageView imgEdit;

        myViewHolder(View itemView) {
            super(itemView);
            txtResumeTitle = (TextView) itemView.findViewById(R.id.txtResumeTitle);
            txtStartDate = (TextView) itemView.findViewById(R.id.txtStartDate);
            txtEndDate = (TextView) itemView.findViewById(R.id.txtEndDate);
            imgDelete =  itemView.findViewById(R.id.imgDelete);
            imgEdit =  itemView.findViewById(R.id.imgEdit);
        }
    }
}