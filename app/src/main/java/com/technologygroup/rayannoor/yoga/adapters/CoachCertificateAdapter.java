package com.technologygroup.rayannoor.yoga.adapters;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.Coaches.CoachServicesActivity;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.imageActivity;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

/**
 * Created by Mohamad Hasan on 2/13/2018.
 */

public class CoachCertificateAdapter extends RecyclerView.Adapter<CoachCertificateAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private Dialog dialog;



    public CoachCertificateAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_coach_certificate_list, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CoachServicesActivity activity = (CoachServicesActivity) context;
                Intent intent = new Intent(activity, imageActivity.class);
                context.startActivity(intent);
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }



    class myViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCertificateTitle;
        private TextView txtCertificateBody;
        private ImageView imgDelete;
        private ImageView imgEdit;
        private ImageView imgCertificate;
        private TextView txtCertificateDate;


        myViewHolder(View itemView) {
            super(itemView);
            txtCertificateTitle = (TextView) itemView.findViewById(R.id.txtCertificateTitle);
            txtCertificateBody = (TextView) itemView.findViewById(R.id.txtCertificateBody);
            imgDelete = (ImageView) itemView.findViewById(R.id.imgDelete);
            imgEdit = (ImageView) itemView.findViewById(R.id.imgEdit);
            imgCertificate = (ImageView) itemView.findViewById(R.id.imgCertificate);
            txtCertificateDate = (TextView) itemView.findViewById(R.id.txtCertificateDate);
        }
    }

    private void showDialog() {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_wait);
        ImageView logo = dialog.findViewById(R.id.logo);

        //logo 360 rotate
        ObjectAnimator rotation = ObjectAnimator.ofFloat(logo, "rotationY", 0, 360);
        rotation.setDuration(3000);
        rotation.setRepeatCount(Animation.INFINITE);
        rotation.start();

        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }
}

