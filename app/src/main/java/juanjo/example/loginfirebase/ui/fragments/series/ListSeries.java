package juanjo.example.loginfirebase.ui.fragments.series;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import juanjo.example.loginfirebase.LoginApplication;
import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.ui.fragments.ListSeriesModule;
import juanjo.example.loginfirebase.ui.fragments.series.presenter.ListSeriesPresenter;
import juanjo.example.loginfirebase.ui.main.MainActivity;
import juanjo.example.loginfirebase.ui.main.QueryListener;
import juanjo.example.loginfirebase.ui.main.adapter.SeriesAdapter;

public class ListSeries extends Fragment implements ListSeriesView,QueryListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView mRecycler;
    ProgressBar mProgressBar;

    @Inject
    ListSeriesPresenter presenter;

    public ListSeries() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static ListSeries newInstance() {
        ListSeries fragment = new ListSeries();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        mProgressBar = (ProgressBar) v.findViewById(R.id.progressBar);

        return v;
    }

    @Override
    public void showLoading(boolean state) {
        mProgressBar.setVisibility(state ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(String msg) {
        Log.e("Fragment error: ",msg);
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSeries(List<Serie> series) {
        Log.e("Fragment series: ",String.valueOf(series.size()));
        SeriesAdapter mAdapter = new SeriesAdapter(series);
        mRecycler.setAdapter(mAdapter);

    }

    @Override
    public void doSearchInFragment(String query) {
        presenter.loadSeries(query);
    }
}
