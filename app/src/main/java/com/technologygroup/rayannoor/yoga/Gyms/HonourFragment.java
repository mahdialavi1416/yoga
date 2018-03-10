package com.technologygroup.rayannoor.yoga.Gyms;


import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.adapters.GymHonourAdapter;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class HonourFragment extends Fragment {


    private ShimmerRecyclerView recycler;
    private FloatingActionButton floactAction;
    private LinearLayout lytMain;
    private LinearLayout lytDisconnect;
    private LinearLayout lytEmpty;
    private Dialog dialog;
    private ImageView imgClose;
    private EditText edtTitle;
    private EditText edtDate;
    private TextView txtNoImage;
    private ImageView imgHonour;
    private ImageView imgSelectPicture;
    private CircularProgressButton btnOk;

    public HonourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_honour, container, false);
        recycler = (ShimmerRecyclerView) view.findViewById(R.id.Recycler);
        floactAction = (FloatingActionButton) view.findViewById(R.id.floactAction);
        lytMain = (LinearLayout) view.findViewById(R.id.lytMain);
        lytDisconnect = (LinearLayout) view.findViewById(R.id.lytDisconnect);
        lytEmpty = (LinearLayout) view.findViewById(R.id.lytEmpty);

        setUpRecyclerView();


        floactAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });


        return view;
    }

    private void setUpRecyclerView() {
        GymHonourAdapter adapter = new GymHonourAdapter(getContext());
        recycler.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(getContext());
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }


    private void showDialog() {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_gym_honour);
        imgClose = (ImageView) dialog.findViewById(R.id.imgClose);
        edtTitle = (EditText) dialog.findViewById(R.id.edtTitle);
        edtDate = (EditText) dialog.findViewById(R.id.edtDate);
        txtNoImage = (TextView) dialog.findViewById(R.id.txtNoImage);
        imgHonour = (ImageView) dialog.findViewById(R.id.imgHonour);
        imgSelectPicture = (ImageView) dialog.findViewById(R.id.imgSelectPicture);
        btnOk = (CircularProgressButton) dialog.findViewById(R.id.btnOk);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

}
