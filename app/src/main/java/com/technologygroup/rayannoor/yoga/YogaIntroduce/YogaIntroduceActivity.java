package com.technologygroup.rayannoor.yoga.YogaIntroduce;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.adapters.IntroduceAdapter;
import com.technologygroup.rayannoor.yoga.adapters.TeachListAdapter;

public class YogaIntroduceActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private TabLayout tabLayout;
    private RecyclerView Recycler;
    private Typeface typeface;


    int tab_number;
    String mogaddamat = "مقدمات یوگا"; int mogaddamat_num = 0;
    String porsesh_pasokh = "پرسش و پاسخ"; int porsesh_pasokh_num = 1;
    String tool_rooz = "یوگا در طول روز"; int tool_rooz_num = 2;
    String senin_mokhtalef = "یوگا برای سنین مختلف"; int senin_mokhtalef_num = 3;
    String roozmarre = "یوگا در زندگی روزمره"; int roozmarre_num = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachs_list);
        initView();
        typeface = Typeface.createFromAsset(getAssets(), "font.ttf");

        tabLayout.addTab(tabLayout.newTab().setText(mogaddamat));
        tabLayout.addTab(tabLayout.newTab().setText(porsesh_pasokh));
        tabLayout.addTab(tabLayout.newTab().setText(tool_rooz));
        tabLayout.addTab(tabLayout.newTab().setText(senin_mokhtalef));
        tabLayout.addTab(tabLayout.newTab().setText(roozmarre));

//        boolean handler = new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tabLayout.getTabAt(4).select();
//            }
//        }, 20);
//

        tab_number = getIntent().getIntExtra("tab_number", 0);



        setUpRecyclerView(tab_number);
        changeTabsFont();

        tabLayout.setScrollPosition(tab_number,0f,true);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                tab_number = tab.getPosition();
                Intent intent = getIntent();
                intent.putExtra("tab_number", tab.getPosition());
                startActivity(intent);
                setUpRecyclerView(tab_number);
                finish();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        Recycler = (RecyclerView) findViewById(R.id.Recycler);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }

    private void changeTabsFont() {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {

                    ((TextView) tabViewChild).setTypeface(typeface);
                }
            }
        }

    }

    private void setUpRecyclerView(int tab_number){

        IntroduceAdapter adapter = new IntroduceAdapter(this, tab_number);
        Recycler.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        Recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }
}
