package com.aplication.vlineupss.ui.dashboard;

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

import com.aplication.vlineupss.DetailSova;
import com.aplication.vlineupss.R;
import com.aplication.vlineupss.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Button btn1 = (Button) rootView.findViewById(R.id.detailsova);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailSova.class);
                startActivity(intent);
                final TextView textView = binding.sova;
                dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

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