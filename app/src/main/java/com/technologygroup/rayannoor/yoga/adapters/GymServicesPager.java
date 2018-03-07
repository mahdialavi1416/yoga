package com.technologygroup.rayannoor.yoga.adapters;

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

    public GymServicesPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                HonourFragment hno = new HonourFragment();
                return hno;

            case 1:
                galleryFragment gal = new galleryFragment();
                return gal;

            case 2:
                coachsFragment gym = new coachsFragment();
                return gym;

            case 3:
                coursesFragment cer = new coursesFragment();
                return cer;

            case 4:
                infoFragment info = new infoFragment();
                return info;

            case 5:
                notifsFragment notif = new notifsFragment();
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

