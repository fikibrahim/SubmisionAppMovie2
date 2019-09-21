package picodiploma.dicoding.submission2appmovie.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentsList = new ArrayList<>(  );
    private final List<String> fragmentsTitle = new ArrayList<>(  );

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super( fm );
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get( position );
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentsList.add( fragment );
        fragmentsTitle.add( title );
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int poition) {
        return fragmentsTitle.get( poition );
    }
}
