package com.technologygroup.rayannoor.yoga.IntroPage;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.LoginActivity;
import com.technologygroup.rayannoor.yoga.MainActivity;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.RegisterActivity;
import com.technologygroup.rayannoor.yoga.fetchDataCity;
import com.technologygroup.rayannoor.yoga.fetchDataState;

/**
 * Created by mohamadHasan on 20/07/2017.
 */

public class IntroFragment extends Fragment {

    public static String[] provinces;
    private static final String PAGE = "page";
    int layoutResId;
    private int mPage;
    public static Dialog dialog;
    public static TextView textView;
    public static TextView textView2;
    public static Spinner StateSpinner;
    public static Spinner CitySpinner;
    private int stateNumber = 1;
    private int cityNumber = 1;
    ArrayAdapter<String> spinnerArrayAdapter;

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

        CitySpinner = (Spinner) dialog.findViewById(R.id.CitySpinner);
        final Button btnSendStateCity = (Button) dialog.findViewById(R.id.btnSendState_city);
        btnSendStateCity.setEnabled(false);
        btnSendStateCity.setAlpha(0.25f);

        StateSpinner = dialog.findViewById(R.id.StateSpinner);
        fetchDataState url_read_process = new fetchDataState();
        url_read_process.execute();//change the province to the expected value

        textView = dialog.findViewById(R.id.use_province_help);


        //Toast.makeText(dialog.getContext(), "salaam", Toast.LENGTH_LONG).show();


        StateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               Toast.makeText(dialog.getContext(), (position+1) + "", Toast.LENGTH_LONG).show();

                stateNumber = position + 1;
                //get the city information
                fetchDataCity fetchDataCity = new fetchDataCity(stateNumber);
                fetchDataCity.execute();
                btnSendStateCity.setEnabled(true);
                btnSendStateCity.setAlpha(1.0f);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnSendStateCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), MainActivity.class);
                i.putExtra("stateNumber", stateNumber);
                i.putExtra("cityNumber", cityNumber);

                getContext().startActivity(i);
                getActivity().finish();

            }
        });

        dialog.show();
    }

   }
