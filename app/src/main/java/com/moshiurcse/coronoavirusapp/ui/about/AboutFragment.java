package com.moshiurcse.coronoavirusapp.ui.about;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.moshiurcse.coronoavirusapp.R;
import com.moshiurcse.coronoavirusapp.ui.send.SendViewModel;

public class AboutFragment extends Fragment {

    private AboutViewModel aboutViewModel;


    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {





      /*  aboutViewModel = ViewModelProviders.of(this).get(AboutViewModel.class);
        View root = inflater.inflate(R.layout.about_fragment, container, false);
        final TextView textView = root.findViewById(R.id.aboutTV);
        aboutViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
*/

        return inflater.inflate(R.layout.about_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ToggleButton toggleBtn=view.findViewById(R.id.languageTB);
        final TextView banglaTitle,banglaDes,engTitle,engDes;

        banglaTitle=view.findViewById(R.id.banglaTitleTV);
        banglaDes=view.findViewById(R.id.banglaDesTV);
        engTitle=view.findViewById(R.id.engTitleTV);
        engDes=view.findViewById(R.id.engDesTV);


        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    banglaTitle.setVisibility(View.VISIBLE);
                    banglaDes.setVisibility(View.VISIBLE);
                    engTitle.setVisibility(View.GONE);
                    engDes.setVisibility(View.GONE);

                }else{
                    banglaTitle.setVisibility(View.GONE);
                    banglaDes.setVisibility(View.GONE);
                    engTitle.setVisibility(View.VISIBLE);
                    engDes.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        aboutViewModel = ViewModelProviders.of(this).get(AboutViewModel.class);
        // TODO: Use the ViewModel
    }

}
