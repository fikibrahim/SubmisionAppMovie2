package picodiploma.dicoding.submission2appmovie.data;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

import picodiploma.dicoding.submission2appmovie.R;

public class DataRepository {

    private static DataRepository dataRepository;

    private static String[] movieTitles;
    private static String[] movieDates;
    private static String[] movieDescriptions;
    private static String[] movieOverview;
    private static TypedArray moviePoster;

    private static String[] tvShowTitles;
    private static String[] tvMovieDates;
    private static String[] tvShowDescriptions;
    private static String[] tvMovieOverview;
    private static TypedArray tvShowPoster;

    public DataRepository() {}

    public static synchronized DataRepository getInstance(Context context) {
        if (dataRepository == null){
            dataRepository = new DataRepository();

            movieTitles = context.getResources().getStringArray( R.array.string_movie );
            movieDates = context.getResources().getStringArray( R.array.date_movie );
            movieDescriptions = context.getResources().getStringArray( R.array.description_movie );
            movieOverview = context.getResources().getStringArray( R.array.description_movie );
            moviePoster = context.getResources().obtainTypedArray( R.array.image_movie );

            tvShowTitles = context.getResources().getStringArray( R.array.string_movie );
            tvMovieDates = context.getResources().getStringArray( R.array.date_movie );
            tvShowDescriptions = context.getResources().getStringArray( R.array.description_movie );
            tvMovieOverview = context.getResources().getStringArray( R.array.description_movie );
            tvShowPoster = context.getResources().obtainTypedArray( R.array.image_tvshow );
        }
        return dataRepository;
    }

    public List<Data> getTvShowData() {
        List<Data> data = new ArrayList<>(  );
        for (int i = 0; i < movieTitles.length; i++) {
            data.add( new Data(
                    movieTitles[i],
                    movieDates[i],
                    movieDescriptions[i],
                    movieOverview[i],
                    moviePoster.getResourceId( i,0 )));
        }
        return data;
    }

    public List<Data> getMovieData() {
        List<Data> data = new ArrayList<>();
        for (int i = 0; i < movieTitles.length; i++) {
            data.add( new Data(
                    tvShowTitles[i],
                    tvMovieDates[i],
                    tvMovieDates[i],
                    tvMovieOverview[i],
                    tvShowPoster.getResourceId( i, 0 ) ) );
        }
        return data;
    }
}
