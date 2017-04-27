package com.davidc.uiwrapper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public final class UiWrapperRepositoryFragment<R extends BaseUiWrapperRepository> extends Fragment implements UiWrapperRepositoryProvider {
    private R repository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        initRepository();
    }

    private void initRepository() {
        repository = CastHelper.repositoryFromFactory(getActivity());
    }

    @Override
    @NonNull
    public R get() {
        return repository;
    }
}
