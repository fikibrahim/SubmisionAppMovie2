package picodiploma.dicoding.submission2appmovie.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable{

    private String title;
    private String description;
    private String date;
    private String overview;
    private int poster;


    Data(String title, String description, String date, String overview, int poster) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.overview = overview;
        this.poster = poster;
    }

    private Data(Parcel in) {
        title = in.readString();
        description = in.readString();
        date = in.readString();
        overview = in.readString();
        poster = in.readInt();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data( in );
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getOverview() {
        return overview;
    }

    public int getPoster() {
        return poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString( title );
        parcel.writeString( description );
        parcel.writeString( date );
        parcel.writeString( overview );
        parcel.writeInt( poster );
    }

}
