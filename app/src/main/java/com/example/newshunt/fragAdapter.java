package com.example.newshunt;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newshunt.categoryFragments.businessFragment;
import com.example.newshunt.categoryFragments.entertainmentFragment;
import com.example.newshunt.categoryFragments.healthFragment;
import com.example.newshunt.categoryFragments.politicsFragment;
import com.example.newshunt.categoryFragments.scienceFragment;
import com.example.newshunt.categoryFragments.sportsFragment;
import com.example.newshunt.categoryFragments.technologyFragment;

public class fragAdapter extends FragmentPagerAdapter {

    public fragAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public fragAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0 : return new sportsFragment();
            case 1 : return new healthFragment();
            case 2 : return new scienceFragment();
            case 3 : return new entertainmentFragment();
            case 4 : return new politicsFragment();
            case 5 : return new businessFragment();
            case 6 : return new technologyFragment();

            default:return new sportsFragment();

        }

    }

    @Override
    public int getCount() {
        return 7;
    }


}
