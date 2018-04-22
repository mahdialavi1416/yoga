package com.technologygroup.rayannoor.yoga.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.technologygroup.rayannoor.yoga.Gyms.HonourFragment;
import com.technologygroup.rayannoor.yoga.Gyms.coachsFragment;
import com.technologygroup.rayannoor.yoga.Gyms.coursesFragment;
import com.technologygroup.rayannoor.yoga.Gyms.galleryFragment;
import com.technologygroup.rayannoor.yoga.Gyms.infoFragment;
import com.technologygroup.rayannoor.yoga.Gyms.notifsFragment;

/**
 * Created by Mohamad Hasan on 3/5/2018.
 */

public class GymServicesPager extends FragmentStatePagerAdapter {

    private boolean calledFromPanel;
    private int idGym;
    Bundle bundle;

    public GymServicesPager(FragmentManager fm, boolean calledFromPanel, int idGym) {
        super(fm);

        this.calledFromPanel = calledFromPanel;
        this.idGym = idGym;

        bundle = new Bundle();
        bundle.putBoolean("calledFromPanel", calledFromPanel);
        bundle.putInt("idGym", idGym);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                HonourFragment hno = new HonourFragment();
                hno.setArguments(bundle);
                return hno;

            case 1:
                galleryFragment gal = new galleryFragment();
                gal.setArguments(bundle);
                return gal;

            case 2:
                coachsFragment gym = new coachsFragment();
                gym.setArguments(bundle);
                return gym;

            case 3:
                coursesFragment cer = new coursesFragment();
                cer.setArguments(bundle);
                return cer;

            case 4:
                infoFragment info = new infoFragment();
                info.setArguments(bundle);
                return info;

            case 5:
                notifsFragment notif = new notifsFragment();
                notif.setArguments(bundle);
                return notif;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

}

