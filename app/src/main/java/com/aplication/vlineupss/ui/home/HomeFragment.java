package com.aplication.vlineupss.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.aplication.vlineupss.DetailBrim;
import com.aplication.vlineupss.DetailFade;
import com.aplication.vlineupss.DetailKayo;
import com.aplication.vlineupss.DetailKilljoy;
import com.aplication.vlineupss.DetailSova;
import com.aplication.vlineupss.DetailViper;
import com.aplication.vlineupss.R;
import com.aplication.vlineupss.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        RelativeLayout btn1 = (RelativeLayout) rootView.findViewById(R.id.tmt1);
        RelativeLayout btn2 = (RelativeLayout) rootView.findViewById(R.id.tmt2);
        RelativeLayout btn3 = (RelativeLayout) rootView.findViewById(R.id.tmt3);
        RelativeLayout btn4 = (RelativeLayout) rootView.findViewById(R.id.tmt4);
        RelativeLayout btn5 = (RelativeLayout) rootView.findViewById(R.id.tmt5);
        RelativeLayout btn6 = (RelativeLayout) rootView.findViewById(R.id.tmt6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), DetailKilljoy.class);
                startActivity(intent1);
                final TextView textView1 = binding.killjoy;
                homeViewModel.getText().observe(getViewLifecycleOwner(), textView1::setText);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailKayo.class);
                startActivity(intent);
                final TextView textView = binding.kayo;
                homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailViper.class);
                startActivity(intent);
                final TextView textView = binding.viper;
                homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailSova.class);
                startActivity(intent);
                final TextView textView = binding.sova;
                homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailBrim.class);
                startActivity(intent);
                final TextView textView = binding.brim;
                homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailFade.class);
                startActivity(intent);
                final TextView textView = binding.fade;
                homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

            }

        });
        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}