package com.moshiurcse.coronoavirusapp.ui.symptoms;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moshiurcse.coronoavirusapp.R;

public class CoronaSymptomsFragment extends Fragment {

    private CoronaSymptomsViewModel mViewModel;

    public static CoronaSymptomsFragment newInstance() {
        return new CoronaSymptomsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.corona_symptoms_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CoronaSymptomsViewModel.class);
        // TODO: Use the ViewModel
    }

}
