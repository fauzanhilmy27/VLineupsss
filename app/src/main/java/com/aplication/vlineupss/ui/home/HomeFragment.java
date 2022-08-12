package com.aplication.vlineupss.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.aplication.vlineupss.DetailFade;
import com.aplication.vlineupss.DetailSova;
import com.aplication.vlineupss.R;
import com.aplication.vlineupss.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Button btn1 = (Button) rootView.findViewById(R.id.detailfade);
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