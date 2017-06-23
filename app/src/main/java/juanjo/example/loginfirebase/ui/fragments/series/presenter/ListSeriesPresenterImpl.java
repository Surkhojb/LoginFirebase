package juanjo.example.loginfirebase.ui.fragments.series.presenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import juanjo.example.loginfirebase.ui.fragments.series.interactor.ListSeriesInteractor;
import juanjo.example.loginfirebase.ui.fragments.series.ListSeriesView;

/**
 * Created by juanjoberenguer on 23/6/17.
 */

public class ListSeriesPresenterImpl implements ListSeriesPresenter {

    ListSeriesView view;
    ListSeriesInteractor interactor;

    @Inject
    public ListSeriesPresenterImpl(ListSeriesView v,ListSeriesInteractor in){
        view = v;
        interactor = in;
    }

    @Override
    public void loadSeries(String query) {
        view.showLoading(true);
        interactor.getSeries(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(series -> view.showSeries(series),
                throwable -> {
                    view.showLoading(false);
                    view.showError(throwable.getLocalizedMessage());
                },
                () -> view.showLoading(false));

    }
}
