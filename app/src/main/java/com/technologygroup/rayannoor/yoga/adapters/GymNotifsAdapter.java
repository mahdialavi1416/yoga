package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.NotifDetailsActivity;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.Teaches.TeachDetailsActivity;
import com.technologygroup.rayannoor.yoga.Teaches.teachsListActivity;
import com.technologygroup.rayannoor.yoga.notificationActivity;

/**
 * Created by Mohamad Hasan on 3/12/2018.
 */

public class GymNotifsAdapter extends RecyclerView.Adapter<GymNotifsAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;


    public GymNotifsAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_gym_notif_list, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationActivity activity = (notificationActivity)context;
                Intent intent = new Intent(activity , NotifDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }



    class myViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNotifTitle;
        private TextView txtNotifBody;
        private TextView txtNotifDate;
        private TextView txtNotifSender;
        private ImageView txtNotifSenderText;
        private TextView txtGymDetails;

        myViewHolder(View itemView) {
            super(itemView);
            txtNotifTitle = (TextView) itemView.findViewById(R.id.txtNotifTitle);
            txtNotifBody = (TextView) itemView.findViewById(R.id.txtNotifBody);
            txtNotifDate = (TextView) itemView.findViewById(R.id.txtNotifDate);
            txtNotifSender = (TextView) itemView.findViewById(R.id.txtNotifSender);
            txtNotifSenderText = (ImageView) itemView.findViewById(R.id.txtNotifSenderText);
            txtGymDetails = (TextView) itemView.findViewById(R.id.txtGymDetails);
        }
    }
}
