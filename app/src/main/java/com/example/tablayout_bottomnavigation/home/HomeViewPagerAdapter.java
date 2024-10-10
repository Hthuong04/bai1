package com.example.tablayout_bottomnavigation.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tablayout_bottomnavigation.fragment.CartFragment;
import com.example.tablayout_bottomnavigation.fragment.HomeFragment;
import com.example.tablayout_bottomnavigation.fragment.UserFragment;

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {

    public HomeViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Tab_Item_Fragment();
            case 1:
                return new Tab_Catalog_Fragment();
            case 2:
                return new Tab_Sales_Fragment();
            default:
                return new Tab_Item_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Sản phẩm ";
            case 1:
                return "Danh mục";
            case 2:
                return "Khuyến mãi";
            default:
                return "Sản phẩm ";
        }
    }
}
