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
    int OMUMI = 0, MAKUS = 1, KHABIDE = 2, NESHASTE = 3, ISTADE = 4;
    final int harakat_number;
    String[] harakat_omumi;
    String[] harakat_makus;
    String[] harakat_khabide;
    String[] harakat_neshaste;
    String[] harakat_istade;



    public TeachListAdapter(Context context, int harakat_number) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        harakat_omumi = context.getResources().getStringArray(R.array.harakat_omumi);
        harakat_makus = context.getResources().getStringArray(R.array.harakat_makus);
        harakat_khabide = context.getResources().getStringArray(R.array.harakat_khabide);
        harakat_neshaste = context.getResources().getStringArray(R.array.harakat_neshaste);
        harakat_istade = context.getResources().getStringArray(R.array.harakat_istade);

        this.harakat_number = harakat_number;
    }

    @Override
    public TeachListAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_teach_list, parent, false);
        TeachListAdapter.myViewHolder holder = new TeachListAdapter.myViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(final TeachListAdapter.myViewHolder holder, int position) {
        String item1;
        if (harakat_number == 0){
            item1 = harakat_omumi[position];
        }else if(harakat_number == 1){
            item1 = harakat_makus[position];
        }else if (harakat_number == 2){
            item1 = harakat_khabide[position];
        }else if (harakat_number == 3){
            item1 = harakat_neshaste[position];
        }else {
            item1 = harakat_istade[position];
        }


        int startOnvan = item1.indexOf("StartOnvan");
        int EndOnvan = item1.indexOf("EndOnvan");
        holder.onvan = item1.substring(startOnvan + "StartOnvan".length(), EndOnvan);


        int startMatn = item1.indexOf("StartMatn");
        int endMatn = item1.indexOf("EndMatn");
        holder.matn = item1.substring(startMatn + "StartMatn".length(), endMatn);


        int startTasvir = item1.indexOf("StartTasvir");
        int endTasvir = item1.indexOf("EndTasvir");
        holder.tasvir = item1.substring(startTasvir + "StartTasvir".length(), endTasvir);

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
        if (harakat_number == 0)
            return harakat_omumi.length;
        else if(harakat_number == 1)
            return harakat_makus.length;
        else if(harakat_number == 2)
            return harakat_khabide.length;
        else if (harakat_number == 3)
            return harakat_neshaste.length;
        else
            return harakat_istade.length;
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
