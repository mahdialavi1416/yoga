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
import com.technologygroup.rayannoor.yoga.Teaches.TeachDetailsActivity;
import com.technologygroup.rayannoor.yoga.Teaches.teachsListActivity;
import com.technologygroup.rayannoor.yoga.YogaIntroduce.IntroduceDetailsActivity;
import com.technologygroup.rayannoor.yoga.YogaIntroduce.YogaIntroduceActivity;

/**
 * Created by Mohamad Hasan on 4/14/2018.
 */

public class IntroduceAdapter extends RecyclerView.Adapter<IntroduceAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    TextView harakat;
    //    int mog = 0, pors = 1, toolr = 2, senin = 3, rooz = 4, tech = 5, medit = 6;
    final int mored_number;
    String[] mogaddamat;
    String[] porsesh_pasokh;
    String[] tool_rooz;
    String[] senin_mokhtalef;
    String[] roozmarre;

    String[] technicha;
    String[] chakra;
    String[] meditation;



    public IntroduceAdapter(Context context, int mored_number) {
        this.context = context;
        mInflater = LayoutInflater.from(context);


        mogaddamat = context.getResources().getStringArray(R.array.mogaddamat);
        porsesh_pasokh = context.getResources().getStringArray(R.array.porsesh_pasokh);
        tool_rooz = context.getResources().getStringArray(R.array.tool_rooz);
        senin_mokhtalef = context.getResources().getStringArray(R.array.senin_mokhtalef);
        roozmarre = context.getResources().getStringArray(R.array.roozmarre);

//        technicha = context.getResources().getStringArray(R.array.technicha);
//        chakra = context.getResources().getStringArray(R.array.chakra);
//        meditation = context.getResources().getStringArray(R.array.meditation);



        this.mored_number = mored_number;
    }

    @Override
    public IntroduceAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_teach_list, parent, false);
        IntroduceAdapter.myViewHolder holder = new IntroduceAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final IntroduceAdapter.myViewHolder holder, int position) {

        String item1;

        if (mored_number == 0)
            item1 = mogaddamat[position];
        else if(mored_number == 1)
            item1 = porsesh_pasokh[position];
        else if(mored_number == 2)
            item1 = tool_rooz[position];
        else if (mored_number == 3)
            item1 = senin_mokhtalef[position];
        else
            item1 = roozmarre[position];


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
                YogaIntroduceActivity activity = (YogaIntroduceActivity) context;
                Intent intent = new Intent(activity , IntroduceDetailsActivity.class);
                intent.putExtra("onvan", holder.onvan);
                intent.putExtra("matn", holder.matn);
                intent.putExtra("tasvir", holder.tasvir);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        if (mored_number == 0)
            return mogaddamat.length;
        else if(mored_number == 1)
            return porsesh_pasokh.length;
        else if(mored_number == 2)
            return tool_rooz.length;
        else if (mored_number == 3)
            return senin_mokhtalef.length;
        else
            return roozmarre.length;
        /*
        * else if(mored_number == 4)
        *   return ...*/
    }


    class myViewHolder extends RecyclerView.ViewHolder {
        private String onvan;
        private String matn;
        private String tasvir;

        myViewHolder(View itemView) {

            super(itemView);
            harakat = (TextView) itemView.findViewById(R.id.harakat);
            //imageView = (ImageView) itemView.findViewById(R.id.img?)
        }
    }
}

