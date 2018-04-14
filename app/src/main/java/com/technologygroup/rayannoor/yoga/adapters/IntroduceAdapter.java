package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.technologygroup.rayannoor.yoga.R;

/**
 * Created by Mohamad Hasan on 4/14/2018.
 */

public class IntroduceAdapter extends RecyclerView.Adapter<IntroduceAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;



    public IntroduceAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public IntroduceAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_article_list, parent, false);
        IntroduceAdapter.myViewHolder holder = new IntroduceAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final IntroduceAdapter.myViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class myViewHolder extends RecyclerView.ViewHolder {

        myViewHolder(View itemView) {
            super(itemView);
        }
    }
}

