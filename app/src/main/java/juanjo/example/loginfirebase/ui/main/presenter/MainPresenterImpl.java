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
    public void loadPost() {
        interactor.getPosts().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(posts -> view.showPost(posts.get(4)),
                throwable -> view.showError(throwable.getLocalizedMessage()));

    }
}
