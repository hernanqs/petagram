package android.fundamentos.mascotas;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class PageAdapter extends androidx.fragment.app.FragmentPagerAdapter{
    private ArrayList<androidx.fragment.app.Fragment> fragments;

    public PageAdapter(@NonNull FragmentManager fm, ArrayList<androidx.fragment.app.Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
