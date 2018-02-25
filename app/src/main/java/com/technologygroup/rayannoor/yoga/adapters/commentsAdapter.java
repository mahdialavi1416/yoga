package com.technologygroup.rayannoor.yoga.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.technologygroup.rayannoor.yoga.R;

/**
 * Created by Mohamad Hasan on 2/25/2018.
 */

public class commentsAdapter extends RecyclerView.Adapter<commentsAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater mInflater;



    public commentsAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public commentsAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_comment_list, parent, false);
        commentsAdapter.myViewHolder holder = new commentsAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(commentsAdapter.myViewHolder holder, int position) {
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