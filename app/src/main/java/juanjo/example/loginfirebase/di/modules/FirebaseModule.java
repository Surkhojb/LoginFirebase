package juanjo.example.loginfirebase.di.modules;

import android.app.Application;

import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import juanjo.example.loginfirebase.di.scopes.ActivityScope;

/**
 * Created by juanjoberenguer on 14/6/17.
 */

@Module
public class FirebaseModule {

    @Provides
    @ActivityScope
    public FirebaseAuth providesFirebaseService(){
        return FirebaseAuth.getInstance();
    }
}
