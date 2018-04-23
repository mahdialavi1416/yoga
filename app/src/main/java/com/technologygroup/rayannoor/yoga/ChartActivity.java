package com.technologygroup.rayannoor.yoga;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import net.cachapa.expandablelayout.ExpandableLayout;

public class ChartActivity extends AppCompatActivity {

    private ImageView btnBack;
    private LinearLayout lyt1;
    private ExpandableLayout expanableLayout1;
    private boolean c1 = false, c2 = false, c3 = false, c4 = false, c5 = false, c6 = false, c7 = false, c8 = false, c9 = false, c10 = false, c11 = false, c12 = false, c13 = false;
    private ImageView img1;
    private LinearLayout lyt2;
    private ImageView img2;
    private ExpandableLayout expanableLayout2;
    private LinearLayout lyt3;
    private ImageView img3;
    private ExpandableLayout expanableLayout3;
    private LinearLayout lyt4;
    private ImageView img4;
    private ExpandableLayout expanableLayout4;
    private LinearLayout lyt5;
    private ImageView img5;
    private ExpandableLayout expanableLayout5;
    private LinearLayout lyt6;
    private ImageView img6;
    private ExpandableLayout expanableLayout6;
    private LinearLayout lyt7;
    private ImageView img7;
    private ExpandableLayout expanableLayout7;
    private LinearLayout lyt8;
    private ImageView img8;
    private ExpandableLayout expanableLayout8;
    private LinearLayout lyt9;
    private ImageView img9;
    private ExpandableLayout expanableLayout9;
    private LinearLayout lyt10;
    private ImageView img10;
    private ExpandableLayout expanableLayout10;
    private LinearLayout lyt11;
    private ImageView img11;
    private ExpandableLayout expanableLayout11;
    private LinearLayout lyt12;
    private ImageView img12;
    private ExpandableLayout expanableLayout12;
    private LinearLayout lyt13;
    private ImageView img13;
    private ExpandableLayout expanableLayout13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        initView();


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lyt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c1) {
                    expanableLayout1.setExpanded(true);
                    c1 = true;
                    img1.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout1.setExpanded(false);
                    c1 = false;
                    img1.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c2) {
                    expanableLayout2.setExpanded(true);
                    c2 = true;
                    img2.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout2.setExpanded(false);
                    c2 = false;
                    img2.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c3) {
                    expanableLayout3.setExpanded(true);
                    c3 = true;
                    img3.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout3.setExpanded(false);
                    c3 = false;
                    img3.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c4) {
                    expanableLayout4.setExpanded(true);
                    c4 = true;
                    img4.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout4.setExpanded(false);
                    c4 = false;
                    img4.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c5) {
                    expanableLayout5.setExpanded(true);
                    c5 = true;
                    img5.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout5.setExpanded(false);
                    c5 = false;
                    img5.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c6) {
                    expanableLayout6.setExpanded(true);
                    c6 = true;
                    img6.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout6.setExpanded(false);
                    c6 = false;
                    img6.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c7) {
                    expanableLayout7.setExpanded(true);
                    c7 = true;
                    img7.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout7.setExpanded(false);
                    c7 = false;
                    img7.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c8) {
                    expanableLayout8.setExpanded(true);
                    c8 = true;
                    img8.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout8.setExpanded(false);
                    c8 = false;
                    img8.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c9) {
                    expanableLayout9.setExpanded(true);
                    c9 = true;
                    img9.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout9.setExpanded(false);
                    c9 = false;
                    img9.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c10) {
                    expanableLayout10.setExpanded(true);
                    c10 = true;
                    img10.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout10.setExpanded(false);
                    c10 = false;
                    img10.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c11) {
                    expanableLayout11.setExpanded(true);
                    c11 = true;
                    img11.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout11.setExpanded(false);
                    c11 = false;
                    img11.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c12) {
                    expanableLayout12.setExpanded(true);
                    c12 = true;
                    img12.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout12.setExpanded(false);
                    c12 = false;
                    img12.animate().rotation(0).setDuration(700).start();
                }
            }
        });

        lyt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!c13) {
                    expanableLayout13.setExpanded(true);
                    c13 = true;
                    img13.animate().rotation(180).setDuration(700).start();
                } else {
                    expanableLayout13.setExpanded(false);
                    c13 = false;
                    img13.animate().rotation(0).setDuration(700).start();
                }
            }
        });
    }

    private void initView() {
        btnBack = (ImageView) findViewById(R.id.btnBack);
        lyt1 = (LinearLayout) findViewById(R.id.lyt1);
        expanableLayout1 = (ExpandableLayout) findViewById(R.id.expanableLayout1);
        img1 = (ImageView) findViewById(R.id.img1);
        lyt2 = (LinearLayout) findViewById(R.id.lyt2);
        img2 = (ImageView) findViewById(R.id.img2);
        expanableLayout2 = (ExpandableLayout) findViewById(R.id.expanableLayout2);
        lyt3 = (LinearLayout) findViewById(R.id.lyt3);
        img3 = (ImageView) findViewById(R.id.img3);
        expanableLayout3 = (ExpandableLayout) findViewById(R.id.expanableLayout3);
        lyt4 = (LinearLayout) findViewById(R.id.lyt4);
        img4 = (ImageView) findViewById(R.id.img4);
        expanableLayout4 = (ExpandableLayout) findViewById(R.id.expanableLayout4);
        lyt5 = (LinearLayout) findViewById(R.id.lyt5);
        img5 = (ImageView) findViewById(R.id.img5);
        expanableLayout5 = (ExpandableLayout) findViewById(R.id.expanableLayout5);
        lyt6 = (LinearLayout) findViewById(R.id.lyt6);
        img6 = (ImageView) findViewById(R.id.img6);
        expanableLayout6 = (ExpandableLayout) findViewById(R.id.expanableLayout6);
        lyt7 = (LinearLayout) findViewById(R.id.lyt7);
        img7 = (ImageView) findViewById(R.id.img7);
        expanableLayout7 = (ExpandableLayout) findViewById(R.id.expanableLayout7);
        lyt8 = (LinearLayout) findViewById(R.id.lyt8);
        img8 = (ImageView) findViewById(R.id.img8);
        expanableLayout8 = (ExpandableLayout) findViewById(R.id.expanableLayout8);
        lyt9 = (LinearLayout) findViewById(R.id.lyt9);
        img9 = (ImageView) findViewById(R.id.img9);
        expanableLayout9 = (ExpandableLayout) findViewById(R.id.expanableLayout9);
        lyt10 = (LinearLayout) findViewById(R.id.lyt10);
        img10 = (ImageView) findViewById(R.id.img10);
        expanableLayout10 = (ExpandableLayout) findViewById(R.id.expanableLayout10);
        lyt11 = (LinearLayout) findViewById(R.id.lyt11);
        img11 = (ImageView) findViewById(R.id.img11);
        expanableLayout11 = (ExpandableLayout) findViewById(R.id.expanableLayout11);
        lyt12 = (LinearLayout) findViewById(R.id.lyt12);
        img12 = (ImageView) findViewById(R.id.img12);
        expanableLayout12 = (ExpandableLayout) findViewById(R.id.expanableLayout12);
        lyt13 = (LinearLayout) findViewById(R.id.lyt13);
        img13 = (ImageView) findViewById(R.id.img13);
        expanableLayout13 = (ExpandableLayout) findViewById(R.id.expanableLayout13);
    }
}
