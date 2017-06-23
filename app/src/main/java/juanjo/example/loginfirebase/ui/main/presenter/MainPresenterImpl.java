package juanjo.example.loginfirebase.ui.main.presenter;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import juanjo.example.loginfirebase.ui.main.interactor.MainInteractor;
import juanjo.example.loginfirebase.ui.main.MainView;

/**
 * Created by juanjoberenguer on 20/6/17.
 */

public class MainPresenterImpl implements MainPresenter {
    MainView view;
    MainInteractor interactor;

    @Inject
    MainPresenterImpl(MainView v,MainInteractor i){
        view = v;
        interactor = i;
    }
    @Override
    public void loadSeries(String query) {
        /*
        view.showLoading(true);
        interactor.getSeries(query).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(series -> view.showSerie(series),
                        throwable -> {
                            view.showLoading(false);
                            view.showError(throwable.getLocalizedMessage());
                        },
                        () -> view.showLoading(false));
                        */

    }

    @Override
    public void loadSerie(String query) {

    }


}
