package com.alain.cursos.alonso.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.FragmentAppBarTopBinding;

public class AppBarTopFragment extends DialogFragment {

    FragmentAppBarTopBinding binding;

    public static final String TAG = "AppBarTopFragment";

    public AppBarTopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAppBarTopBinding.inflate(inflater, container, false);

        binding.toolbar.setNavigationOnClickListener(view1 -> dismiss());

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
