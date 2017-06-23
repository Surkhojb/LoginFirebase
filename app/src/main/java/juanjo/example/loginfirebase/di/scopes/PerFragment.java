package juanjo.example.loginfirebase.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by juanjoberenguer on 23/6/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}