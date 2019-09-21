package picodiploma.dicoding.submission2appmovie;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import picodiploma.dicoding.submission2appmovie.adapter.ViewPagerAdapter;
import picodiploma.dicoding.submission2appmovie.data.DataRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        setSupportActionBar( findViewById( R.id.toolbar_id ) );
    }

    public void setViewPagerTab(ViewPager viewPager, TabLayout tabLayout) {
        ViewPagerAdapter adapter = new ViewPagerAdapter( getSupportFragmentManager() );
        adapter.addFragment( MainFragment.newInstance( DataRepository.getInstance( this ).getMovieData() ),"Movies" );
        adapter.addFragment( MainFragment.newInstance( DataRepository.getInstance( this ).getTvShowData() ),"Tv Show" );
        viewPager.setAdapter( adapter );
        tabLayout.setupWithViewPager( viewPager );
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout ) );
        viewPager.setCurrentItem( 0 );
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            startActivity(new Intent( Settings.ACTION_LOCALE_SETTINGS));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setViewPagerTab( findViewById( R.id.viewpager_id ),findViewById( R.id.tab_layout_id ) );
    }
}
