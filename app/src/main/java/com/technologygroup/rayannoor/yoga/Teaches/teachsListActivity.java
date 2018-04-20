package com.technologygroup.rayannoor.yoga.Teaches;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.technologygroup.rayannoor.yoga.MainActivity;
import com.technologygroup.rayannoor.yoga.R;
import com.technologygroup.rayannoor.yoga.adapters.TeachListAdapter;

public class teachsListActivity extends AppCompatActivity {

    private RelativeLayout btnBack;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RecyclerView Recycler;
    private Typeface typeface;
    LinearLayoutManager mLinearLayoutManagerVertical;

    int tab_number;
    String omumi = "حرکات عمومی"; int omumi_num = 0;
    String makus = "حرکات معکوس"; int makus_num = 1;
    String khabide = "حرکات خوابیده"; int khabide_num = 2;
    String neshaste = "حرکات نشسته"; int neshaste_num = 3;
    String istade = "حرکات ایستاده"; int istade_num = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachs_list);
        initView();
        typeface = Typeface.createFromAsset(getAssets(), "font.ttf");

        tabLayout.addTab(tabLayout.newTab().setText(omumi));
        tabLayout.addTab(tabLayout.newTab().setText(makus));
        tabLayout.addTab(tabLayout.newTab().setText(khabide));
        tabLayout.addTab(tabLayout.newTab().setText(neshaste));
        tabLayout.addTab(tabLayout.newTab().setText(istade));

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
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
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

    private void setUpRecyclerView(int tab_number){

        TeachListAdapter adapter = new TeachListAdapter(this, tab_number);
        Recycler.setAdapter(adapter);

        mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        Recycler.setLayoutManager(mLinearLayoutManagerVertical);

    }

}