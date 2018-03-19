package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.Teaches.TeachDetailsActivity;
import com.technologygroup.rayannoor.yoga.Teaches.teachsActivity;
import com.technologygroup.rayannoor.yoga.Teaches.teachsListActivity;

/**
 * Created by Mohamad Hasan on 2/7/2018.
 */

public class TeachListAdapter extends RecyclerView.Adapter<TeachListAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    TextView harakat;
    String[] harakat_omumi;



    public TeachListAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        harakat_omumi = context.getResources().getStringArray(R.array.harakat_omumi);
    }

    @Override
    public TeachListAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_teach_list, parent, false);
        TeachListAdapter.myViewHolder holder = new TeachListAdapter.myViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(final TeachListAdapter.myViewHolder holder, int position) {

        String item1 = harakat_omumi[position];
        int startIndex = item1.indexOf("StartOnvan");
        int endIndex = item1.indexOf("EndOnvan");
        holder.onvan = item1.substring(startIndex + "StartOnvan".length(), endIndex);


        startIndex = item1.indexOf("StartMatn");
        endIndex = item1.indexOf("EndMatn");
        holder.matn = item1.substring(startIndex + "StartMatn".length(), endIndex);


        startIndex = item1.indexOf("StartTasvir");
        endIndex = item1.indexOf("EndTasvir");
        holder.tasvir = item1.substring(startIndex + "StartTasvir".length(), endIndex);

        harakat.setText(holder.onvan);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teachsListActivity activity = (teachsListActivity)context;
                Intent intent = new Intent(activity , TeachDetailsActivity.class);
                intent.putExtra("onvan", holder.onvan);
                intent.putExtra("matn", holder.matn);
                intent.putExtra("tasvir", holder.tasvir);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return harakat_omumi.length;
    }


    class myViewHolder extends RecyclerView.ViewHolder {
        private String onvan;
        private String matn;
        private String tasvir;

        myViewHolder(View itemView) {

            super(itemView);
            harakat = (TextView) itemView.findViewById(R.id.harakat);
        }
    }
}
