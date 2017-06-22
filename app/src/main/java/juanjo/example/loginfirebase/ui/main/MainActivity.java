package juanjo.example.loginfirebase.ui.main;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.util.List;

import javax.inject.Inject;

import juanjo.example.loginfirebase.LoginApplication;
import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.data.model.Serie;
import juanjo.example.loginfirebase.data.model.SingleSerie;
import juanjo.example.loginfirebase.ui.main.adapter.SeriesAdapter;
import juanjo.example.loginfirebase.ui.main.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;

    RecyclerView mRecycler;
    ProgressBar mProgressBar;
    DrawerLayout mDrawer;
    NavigationView mNavigationView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadUI();

        LoginApplication.get(this).getAppComponent().plus(new MainModule(this)).inject(this);

    }

    private void loadUI() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        mRecycler = (RecyclerView) findViewById(R.id.main_activity_recyclerview);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(layoutManager);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open,
                        R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

    }
    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate( R.menu.menu_search_view, menu);
        MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
        searchView = (SearchView) myActionMenuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.loadSeries(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        return true;
    }

    @Override
    public void showLoading(boolean state) {
        mProgressBar.setVisibility(state ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSerie(List<Serie> series) {

        SeriesAdapter mAdapter = new SeriesAdapter(series);
        mRecycler.setAdapter(mAdapter);

    }

    @Override
    public void launchDetailActivity() {

    }

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_following) {

        } else if (id == R.id.nav_favorites) {

        } else if (id == R.id.nav_explore) {

        } else if (id == R.id.nav_configuration) {

        } else if (id == R.id.nav_about) {

        }

        mDrawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
