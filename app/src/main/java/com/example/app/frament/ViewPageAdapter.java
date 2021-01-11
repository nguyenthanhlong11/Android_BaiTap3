package com.example.app.frament;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NewFragment();
            case 1:
                return new OrderFragment();
            case 2:
                return new AccountFragment();
            default:
                return new NewFragment();

        }

    }

    @Override
//    get ra số lượng item
    public int getCount() {
        return 3;
    }
}
