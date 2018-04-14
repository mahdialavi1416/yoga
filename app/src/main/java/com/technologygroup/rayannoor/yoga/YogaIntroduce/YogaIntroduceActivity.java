package com.technologygroup.rayannoor.yoga.YogaIntroduce;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_introduce);
        initView();
        typeface = Typeface.createFromAsset(getAssets(), "font.ttf");

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("یوگا در زندگی روزمره"));
        tabLayout.addTab(tabLayout.newTab().setText("یوگا برای سنین مختلف"));
        tabLayout.addTab(tabLayout.newTab().setText("یوگا در طول روز"));
        tabLayout.addTab(tabLayout.newTab().setText("پرسش و پاسخ"));
        tabLayout.addTab(tabLayout.newTab().setText("مقدمات یوگا"));

        boolean handler = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tabLayout.getTabAt(4).select();
            }
        }, 20);

        changeTabsFont();
        setUpRecyclerView();

    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        Recycler = (RecyclerView) findViewById(R.id.Recycler);
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

    private void setUpRecyclerView(){

        IntroduceAdapter adapter = new IntroduceAdapter(this);
        Recycler.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        Recycler.setLayoutManager(mLinearLayoutManagerVertical);
    }
}
