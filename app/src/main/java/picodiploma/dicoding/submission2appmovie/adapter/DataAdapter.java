package picodiploma.dicoding.submission2appmovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import picodiploma.dicoding.submission2appmovie.R;
import picodiploma.dicoding.submission2appmovie.data.Data;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private final Context context;
    private List<Data> data;
    private ItemClickListener onItemClickListener;


    public DataAdapter(Context context, List<Data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( LayoutInflater.from( context ).inflate( R.layout.item_data,parent,false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = this.data.get( position );
        holder.txtTitle.setText( data.getTitle() );
        holder.txtDate.setText( data.getDate() );
        holder.txtDescription.setText( data.getDescription() );
        holder.txtOverview.setText( data.getOverview() );
        holder.imgPoster.setImageResource( data.getPoster() );
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtTitle;
        private TextView txtDate;
        private TextView txtDescription;
        private TextView txtOverview;
        private ImageView imgPoster;

        ViewHolder(View view) {
            super( view );

            txtTitle = view.findViewById( R.id.title_id );
            txtDate = view.findViewById( R.id.date_id );
            txtDescription = view.findViewById( R.id.desc_id );
            txtOverview = view.findViewById( R.id.overview_id );
            imgPoster = view.findViewById( R.id.poster_id );

            view.setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onClick( v,getAdapterPosition() );
        }
    }

    public void setItemClickListener(ItemClickListener clickListener){
        onItemClickListener = clickListener;
    }

    private interface ItemClickListener {
        void onClick(View v, int i);
    }
}
