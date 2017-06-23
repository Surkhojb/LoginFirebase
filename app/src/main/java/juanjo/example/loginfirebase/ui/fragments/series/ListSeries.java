package juanjo.example.loginfirebase.ui.fragments.series;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import juanjo.example.loginfirebase.LoginApplication;
import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.data.model.Image;
import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.ui.fragments.ListSeriesModule;
import juanjo.example.loginfirebase.ui.fragments.series.presenter.ListSeriesPresenter;
import juanjo.example.loginfirebase.ui.main.MainActivity;
import juanjo.example.loginfirebase.ui.main.QueryListener;
import juanjo.example.loginfirebase.ui.main.adapter.SeriesAdapter;

public class ListSeries extends Fragment implements ListSeriesView,QueryListener{
    RecyclerView mRecycler;
    ProgressBar mProgressBar;
    LinearLayout mEmptyView;
    TextView mEmptyText;
    ImageView mImageEmpty;

    @Inject
    ListSeriesPresenter presenter;

    public ListSeries() {
        // Required empty public constructor
    }

    public static ListSeries newInstance() {
        ListSeries fragment = new ListSeries();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LoginApplication.get(getContext()).getAppComponent()
                .plusFragment(new ListSeriesModule(this))
                .inject(this);

        ((MainActivity) getActivity()).setQueryListener(this);

        View v = inflater.inflate(R.layout.list_of_series_fragment, container, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecycler = (RecyclerView) v.findViewById(R.id.main_activity_recyclerview);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(layoutManager);

        mEmptyView = (LinearLayout) v.findViewById(R.id.empty_list_series);
        mImageEmpty = (ImageView) v.findViewById(R.id.image_empty);
        mEmptyText = (TextView) v.findViewById(R.id.text_empty);

        mProgressBar = (ProgressBar) v.findViewById(R.id.progressBar);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void showLoading(boolean state) {
        mProgressBar.setVisibility(state ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSeries(List<Serie> series) {
        if(!series.isEmpty()){
            mEmptyView.setVisibility(View.GONE);
            mRecycler.setVisibility(View.VISIBLE);

            SeriesAdapter mAdapter = new SeriesAdapter(series);
            mRecycler.setAdapter(mAdapter);
        }
        else{
            mRecycler.setVisibility(View.GONE);
            mEmptyView.setVisibility(View.VISIBLE);
            mImageEmpty.setImageResource(R.drawable.no_items);
            mEmptyText.setText(getString(R.string.no_items_found));
        }

    }

    @Override
    public void doSearchInFragment(String query) {
        presenter.loadSeries(query);
    }
}
