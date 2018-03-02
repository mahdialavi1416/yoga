package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Coaches.CoachServicesActivity;
import com.technologygroup.rayannoor.yoga.Models.CoachEduModel;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.imageActivity;

import java.util.List;

/**
 * Created by Mohamad Hasan on 2/13/2018.
 */

public class CoachEducationAdapter extends RecyclerView.Adapter<CoachEducationAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private List<CoachEduModel> list;


    public CoachEducationAdapter(Context context, List<CoachEduModel> list) {
        this.context = context;
        this.list = list;
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

        final CoachEduModel currentObj = list.get(position);
        holder.setData(currentObj, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CoachServicesActivity activity = (CoachServicesActivity) context;
                Intent intent = new Intent(activity, imageActivity.class);
                intent.putExtra("ImgName", currentObj.Img);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class myViewHolder extends RecyclerView.ViewHolder {

        private TextView txtEducationTitle;
        private ImageView imgEducation;
        private ImageView imgDelete;
        private ImageView imgEdit;

        private int position;
        private CoachEduModel current;

        myViewHolder(View itemView) {
            super(itemView);
            txtEducationTitle = (TextView) itemView.findViewById(R.id.txtEducationTitle);
            imgEducation = (ImageView) itemView.findViewById(R.id.imgEducation);
            imgDelete =  itemView.findViewById(R.id.imgDelete);
            imgEdit =  itemView.findViewById(R.id.imgEdit);
        }

        private void setData(CoachEduModel current, int position) {

            if (current.Img != null)
                if (!current.Img.equals("") && !current.Img.equals("null"))
                    Glide.with(context).load(App.imgAddr + current.Img).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imgEducation);

            txtEducationTitle.setText(current.Name);

            this.position = position;
            this.current = current;

        }

    }
}