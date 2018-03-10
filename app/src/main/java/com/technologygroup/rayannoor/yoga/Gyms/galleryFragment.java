package com.technologygroup.rayannoor.yoga.Gyms;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.adapters.GymImageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class galleryFragment extends Fragment {


    private ShimmerRecyclerView recycler;
    private FloatingActionButton floactAction;
    private LinearLayout lytMain;
    private LinearLayout lytDisconnect;
    private LinearLayout lytEmpty;


    public galleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        recycler = (ShimmerRecyclerView) view.findViewById(R.id.Recycler);
        floactAction = (FloatingActionButton) view.findViewById(R.id.floactAction);
        lytMain = (LinearLayout) view.findViewById(R.id.lytMain);
        lytDisconnect = (LinearLayout) view.findViewById(R.id.lytDisconnect);
        lytEmpty = (LinearLayout) view.findViewById(R.id.lytEmpty);

        setUpRecyclerView();

        return view;

    }

    private void setUpRecyclerView() {

        GymImageAdapter adapter = new GymImageAdapter(getContext());
        recycler.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recycler.setLayoutManager(gridLayoutManager);
    }

}
