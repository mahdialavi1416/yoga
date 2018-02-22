package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.technologygroup.rayannoor.yoga.R;
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
    public TeachCoachesAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_teach_coach_list, parent, false);
        TeachCoachesAdapter.myViewHolder holder = new TeachCoachesAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TeachCoachesAdapter.myViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teachsActivity activity = (teachsActivity)context;
                Intent intent = new Intent(activity , TeachDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class myViewHolder extends RecyclerView.ViewHolder {



        myViewHolder(View itemView) {
            super(itemView);
        }
    }
}
