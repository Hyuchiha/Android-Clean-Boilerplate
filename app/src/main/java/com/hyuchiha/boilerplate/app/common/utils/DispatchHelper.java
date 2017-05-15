package com.hyuchiha.boilerplate.app.common.utils;

import android.support.annotation.NonNull;

/**
 * Provides a helper definition to fetch data from a data source and
 * take action while the application is dispatching the user to a specific view
 * depending on his application state.
 *
 * @param <Data> to fetch from data source.
 */
public abstract class DispatchHelper<Data> {

    public abstract void begin(@NonNull final DispatchListener<Data> listener);

    public interface DispatchListener<Data> {
        void onFetchData(Data data);
        void onError(String error);
    }

}