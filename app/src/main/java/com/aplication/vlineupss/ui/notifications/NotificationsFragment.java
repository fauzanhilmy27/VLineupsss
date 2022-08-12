package com.aplication.vlineupss.ui.notifications;

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

import com.aplication.vlineupss.DetailBrim;
import com.aplication.vlineupss.DetailSova;
import com.aplication.vlineupss.R;
import com.aplication.vlineupss.databinding.FragmentDashboardBinding;
import com.aplication.vlineupss.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
        Button btn1 = (Button) rootView.findViewById(R.id.detailbrim);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailBrim.class);
                startActivity(intent);
                final TextView textView = binding.brim;
                notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

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