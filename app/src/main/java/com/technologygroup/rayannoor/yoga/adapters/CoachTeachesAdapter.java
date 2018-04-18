package com.technologygroup.rayannoor.yoga.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.technologygroup.rayannoor.yoga.Classes.App;
import com.technologygroup.rayannoor.yoga.Classes.ClassDate;
import com.technologygroup.rayannoor.yoga.Coaches.CoachServicesActivity;
import com.technologygroup.rayannoor.yoga.Coaches.addTeachActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymProfileActivity;
import com.technologygroup.rayannoor.yoga.Gyms.GymsListActivity;
import com.technologygroup.rayannoor.yoga.Models.CoachGymsModel;
import com.technologygroup.rayannoor.yoga.Models.CoachHonorModel;
import com.technologygroup.rayannoor.yoga.Models.TeachesModel;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.imageActivity;

import java.util.List;

/**
 * Created by Mohamad Hasan on 3/16/2018.
 */

public class CoachTeachesAdapter extends RecyclerView.Adapter<CoachTeachesAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private List<TeachesModel> list;
    private String result;
    private Dialog dialog;
    private boolean calledFromPanel = false;
    private static int idCoach;
    CoachServicesActivity activity;
    ClassDate classDate;


    public CoachTeachesAdapter(Context context, List<TeachesModel> list, int idCoach, boolean calledFromPanel) {
        this.context = context;
        this.list = list;
        this.mInflater = LayoutInflater.from(context);
        this.idCoach = idCoach;
        this.calledFromPanel = calledFromPanel;
        activity = (CoachServicesActivity) context;
        classDate = new ClassDate();
    }

    @Override
    public CoachTeachesAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_coach_teach_list, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {

        final TeachesModel currentObj = list.get(position);
        holder.setData(currentObj, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CoachServicesActivity activity = (CoachServicesActivity) context;
                Intent intent = new Intent(activity, addTeachActivity.class);
                intent.putExtra("calledToAdd", false);
                intent.putExtra("id", currentObj.id);
                intent.putExtra("idRow", currentObj.idRow);
                intent.putExtra("Title", currentObj.Title);
                intent.putExtra("Body", currentObj.Body);
                intent.putExtra("Images", currentObj.Images);
                context.startActivity(intent);

            }
        });


        // edit and delete an item from recyclerView
        holder.setListeners();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtitle;
        private TextView txtDate;
        private ImageView imgDelete;
        private ImageView imgEdit;
//        private ImageView imgCertificate;
//        private TextView txtCertificateDate;

        private int position;
        private TeachesModel current;

        myViewHolder(View itemView) {
            super(itemView);

            txtitle = (TextView) itemView.findViewById(R.id.txtitle);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            imgDelete = (ImageView) itemView.findViewById(R.id.imgDelete);
            imgEdit = (ImageView) itemView.findViewById(R.id.imgEdit);
//            imgCertificate = (ImageView) itemView.findViewById(R.id.imgCertificate);
//            txtCertificateDate = (TextView) itemView.findViewById(R.id.txtCertificateDate);


        }


        private void setData(TeachesModel current, int position) {

            if (!calledFromPanel) {
                imgEdit.setVisibility(View.INVISIBLE);
                imgDelete.setVisibility(View.INVISIBLE);
            }

//            if (current.Img != null)
//                if (!current.Img.equals("") && !current.Img.equals("null"))
//                    Glide.with(context).load(App.imgAddr + current.Img).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imgCertificate);

            txtitle.setText(current.Title);
            txtDate.setText(classDate.changeDateToString(current.Date));

            this.position = position;
            this.current = current;

        }


        // edit and delete an item from recyclerView s
        public void setListeners() {
            Log.i("TAG", "onSetListeners" + position);
            imgDelete.setOnClickListener(myViewHolder.this);
            imgEdit.setOnClickListener(myViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgDelete:
                    //removeItem(position, current);
                    break;
                case R.id.imgEdit:
                    //editItem(position, current);
                    break;
            }
        }

    }
}
