package com.technologygroup.rayannoor.yoga.Coaches;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technologygroup.rayannoor.yoga.FadePageTransformer;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.adapters.CoachServicesPager;

public class CoachServicesActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private TabLayout tabLayout;
    private ViewPager CoachPager;
    private Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_services);
        initView();
        typeface = Typeface.createFromAsset(getAssets(), "font.ttf");


        tabLayout.addTab(tabLayout.newTab().setText("سوابق تحصیلی"));
        tabLayout.addTab(tabLayout.newTab().setText("رزومه"));
        tabLayout.addTab(tabLayout.newTab().setText("باشگاه ها"));
        tabLayout.addTab(tabLayout.newTab().setText("مدارک"));
        CoachServicesPager adapter = new CoachServicesPager(getSupportFragmentManager());
        CoachPager.setAdapter(adapter);
        CoachPager.setPageTransformer(false, new FadePageTransformer());
        CoachPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                CoachPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        changeTabsFont();
    }

    private void initView() {
        btnBack = (RelativeLayout) findViewById(R.id.btnBack);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        CoachPager = (ViewPager) findViewById(R.id.CoachServicesPager);
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
}
