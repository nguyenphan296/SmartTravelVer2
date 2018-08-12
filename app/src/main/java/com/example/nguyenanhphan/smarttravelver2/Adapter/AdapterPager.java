package com.example.nguyenanhphan.smarttravelver2.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nguyenanhphan.smarttravelver2.Fragment.FragmentKhachSan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nguyễn Đức Cảnh
 * @version 1.0.0
 * @description
 * @desc BKHN
 * @created ${Date}
 * @updated ${Date}
 * @modified by
 * @updated on ${Date}
 * @since 1.0
 */
public class AdapterPager extends FragmentPagerAdapter {

    List<Fragment> mLisFragment = new ArrayList<>();
    List<String> mListTitle = new ArrayList<>();

    public AdapterPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mLisFragment.get(i);
    }

    @Override
    public int getCount() {
        return mLisFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitle.get(position);
    }
    public void add_Fragment(Fragment fragment, String sTitle){
        if (fragment!=null){
            mLisFragment.add(fragment);
            mListTitle.add(sTitle);
        }
    }
}
