package juanjo.example.loginfirebase.ui.main;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import javax.inject.Inject;

import juanjo.example.loginfirebase.LoginApplication;
import juanjo.example.loginfirebase.R;
import juanjo.example.loginfirebase.ui.fragments.series.ListSeries;
import juanjo.example.loginfirebase.ui.main.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter presenter;


    DrawerLayout mDrawer;
    NavigationView mNavigationView;
    SearchView searchView;
    QueryListener queryListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadUI();

        LoginApplication.get(this).getAppComponent()
                .plus(new MainModule(this))
                .inject(this);

    }

    private void loadUI() {

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open,
                        R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        mNavigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
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
                if(queryListener != null)
                    queryListener.doSearchInFragment(query);
                clearSearchView();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    public void setQueryListener(QueryListener activityListener) {
        this.queryListener = activityListener;
    }

    void clearSearchView(){
        searchView.setQuery("",false);
        searchView.clearFocus();
        searchView.onActionViewCollapsed();
    }

    @Override
    public void launchDetailActivity() {

    }

    void loadFragment(Fragment f,String tag){
        if(getSupportFragmentManager().findFragmentByTag(tag) == null)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_content, f, tag);
            fragmentTransaction.commit();
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            loadFragment(ListSeries.newInstance(),"home");

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
