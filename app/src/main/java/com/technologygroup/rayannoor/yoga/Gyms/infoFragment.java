package com.technologygroup.rayannoor.yoga.Gyms;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class infoFragment extends Fragment {

    private ImageView imgInfo;

    public infoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        imgInfo = view.findViewById(R.id.imgInfo);





        return view;
    }

}
