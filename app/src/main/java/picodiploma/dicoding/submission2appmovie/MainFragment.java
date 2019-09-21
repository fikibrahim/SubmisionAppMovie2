package picodiploma.dicoding.submission2appmovie;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import picodiploma.dicoding.submission2appmovie.adapter.DataAdapter;
import picodiploma.dicoding.submission2appmovie.data.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    static final String ITEM_EXTRA = "picodiploma.dicoding.submission2appmovie.item_data";
    static final String KEY_DATA = "picodiploma.dicoding.submission2appmovie.data";
    private RecyclerView recyclerView;
    private List<Data>data;

    static MainFragment newInstance(List<Data> data) {
        Bundle args = new Bundle();
        args.putParcelableArrayList( KEY_DATA,(ArrayList<? extends Parcelable>) data );
        MainFragment fragment = new MainFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_main,container,false );
        recyclerView = view.findViewById( R.id.recyclerView_id );
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        if (getArguments() != null) {
            data = getArguments().getParcelableArrayList( KEY_DATA );
        }

        DataAdapter adapter = new DataAdapter( getActivity(),data );
        recyclerView.setAdapter( adapter );

        adapter.setItemClickListener((viewRow, position) -> {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra( ITEM_EXTRA, data.get( position ) );
            startActivity(intent);
        });

    }
}
