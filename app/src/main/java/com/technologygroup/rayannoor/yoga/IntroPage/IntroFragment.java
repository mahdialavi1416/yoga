package com.technologygroup.rayannoor.yoga.IntroPage;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.LoginActivity;
import com.technologygroup.rayannoor.yoga.MainActivity;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.RegisterActivity;

/**
 * Created by mohamadHasan on 20/07/2017.
 */

public class IntroFragment extends Fragment {

    private static final String PAGE = "page";
    int layoutResId;
    private int mPage;
    private Dialog dialog;


    public static IntroFragment newInstance(int page) {
        IntroFragment frag = new IntroFragment();
        Bundle b = new Bundle();
        //b.putInt(BACKGROUND_COLOR, backgroundColor);
        b.putInt(PAGE, page);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!getArguments().containsKey(PAGE))
            throw new RuntimeException("Fragment must contain a \"" + PAGE + "\" argument!");
        mPage = getArguments().getInt(PAGE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Select a layout based on the current page

        switch (mPage) {
            case 0:
                layoutResId = R.layout.intro_fragment_layout_1;
                break;
            case 1:
                layoutResId = R.layout.intro_fragment_layout_2;
                break;
            case 2:
                layoutResId = R.layout.intro_fragment_layout_3;
                break;
            case 3:
                layoutResId = R.layout.intro_fragment_layout_4;
                break;
            case 4:
                layoutResId = R.layout.intro_fragment_layout_5;
                break;
            default:
                layoutResId = R.layout.intro_fragment_layout_6;
                break;
        }

        // Inflate the layout resource file
        View view = getActivity().getLayoutInflater().inflate(layoutResId, container, false);

        // Set the current page index as the View's tag (useful in the PageTransformer)
        view.setTag(mPage);


        if (mPage == 5) {
            Button btnGuset = (Button) view.findViewById(R.id.btnGuset);
            Button btnRegister = (Button) view.findViewById(R.id.btnRegister);
            Button btnLogin = (Button) view.findViewById(R.id.btnLogin);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getContext(), LoginActivity.class);
                    getContext().startActivity(i);
                }
            });

            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getContext(), RegisterActivity.class);
                    getContext().startActivity(i);
                }
            });

            btnGuset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showStateDialog();
                }
            });
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private void showStateDialog() {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_state_city);
        Spinner StateSpinner = (Spinner) dialog.findViewById(R.id.StateSpinner);
        Spinner CitySpinner = (Spinner) dialog.findViewById(R.id.CitySpinner);
        Button btnSendStateCity = (Button) dialog.findViewById(R.id.btnSendState_city);

        btnSendStateCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), MainActivity.class);
                getContext().startActivity(i);
                getActivity().finish();
            }
        });

        dialog.show();
    }

}
