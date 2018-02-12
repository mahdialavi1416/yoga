package com.technologygroup.rayannoor.yoga.Coaches;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.adapters.CoachGymsAdapter;
import com.technologygroup.rayannoor.yoga.adapters.CoachListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class gymsFragment extends Fragment {


    private RecyclerView Recycler;

    public gymsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gyms, container, false);
        Recycler = view.findViewById(R.id.Recycler);


        setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView(){
        CoachGymsAdapter adapter = new CoachGymsAdapter(getActivity());
        Recycler.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        Recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }

}
