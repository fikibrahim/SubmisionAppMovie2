package picodiploma.dicoding.submission2appmovie;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import picodiploma.dicoding.submission2appmovie.data.Data;

public class DetailActivity extends AppCompatActivity {

    private TextView txtTitle;
    private TextView txtDate;
    private TextView txtOverview;
    private ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );
        setToolbar();

        txtTitle = findViewById( R.id.title_id );
        txtDate = findViewById( R.id.date_id );
        txtOverview = findViewById( R.id.overview_id );
        img = findViewById( R.id.poster_id );

        if (getIntent().getParcelableExtra( MainFragment.ITEM_EXTRA ) != null) {
            setItem( getIntent().getParcelableExtra( MainFragment.ITEM_EXTRA ) );
        }

    }

    private void setToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        }
    }

    void setItem(Data data) {

        txtTitle.setText( data.getTitle() );
        txtDate.setText( data.getDate() );
        txtOverview.setText( data.getOverview() );
        img.setImageResource( data.getPoster() );
    }

    public boolean OnOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)onBackPressed();
        return super.onOptionsItemSelected( item );
    }
}
