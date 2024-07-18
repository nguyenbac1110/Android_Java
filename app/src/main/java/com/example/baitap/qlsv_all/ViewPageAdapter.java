package com.example.baitap.qlsv_all;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new SinhVien_Frag();
            case 1: return new Lop_Frag();
            case 2: return new TaiKhoan_Frag();
        }
        return new SinhVien_Frag();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
