package com.alain.cursos.alonso.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.FragmentMotionBinding;
import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.google.android.material.transition.MaterialContainerTransform;


public class MotionFragment extends Fragment {
    FragmentMotionBinding binding;

    public static final String TAG = "Motion";

    public static Component getmInstance() {
        Component mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_motion);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public MotionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMotionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialContainerTransform transform = new MaterialContainerTransform();
        transform.setDuration(2500L);

        binding.ibCancel.setOnClickListener(v -> {
            transform.setStartView(binding.viewEnd);
            transform.setEndView(binding.viewStart);
            transform.addTarget(binding.viewStart);

            TransitionManager.beginDelayedTransition(binding.containerMain, transform);
            binding.viewEnd.setVisibility(View.GONE);
            binding.viewStart.setVisibility(View.VISIBLE);
        });

        binding.viewStart.setOnClickListener(v -> {
            transform.setStartView(binding.viewStart);
            transform.setEndView(binding.viewEnd);
            transform.addTarget(binding.viewEnd);

            TransitionManager.beginDelayedTransition(binding.containerMain, transform);
            binding.viewStart.setVisibility(View.GONE);
            binding.viewEnd.setVisibility(View.VISIBLE);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}