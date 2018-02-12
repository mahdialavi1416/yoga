package com.technologygroup.rayannoor.yoga.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.technologygroup.rayannoor.yoga.Coaches.certificateFragment;
import com.technologygroup.rayannoor.yoga.Coaches.educationFragment;
import com.technologygroup.rayannoor.yoga.Coaches.gymsFragment;
import com.technologygroup.rayannoor.yoga.Coaches.resumeFragment;

/**
 * Created by Mohamad Hasan on 2/12/2018.
 */

public class CoachServicesPager extends FragmentStatePagerAdapter {

    public CoachServicesPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                educationFragment edu = new educationFragment();
                return edu;

            case 1:
                resumeFragment res = new resumeFragment();
                return res;

            case 2:
                gymsFragment gym = new gymsFragment();
                return gym;

            case 3:
                certificateFragment cer = new certificateFragment();
                return cer;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

}
