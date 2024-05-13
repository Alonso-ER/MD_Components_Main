package com.alain.cursos.alonso.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.FragmentButtonBinding;
import com.alain.cursos.alonso.databinding.FragmentCheckboxBinding;
import com.alain.cursos.alonso.databinding.FragmentMotionBinding;
import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.google.android.material.transition.MaterialArcMotion;
import com.google.android.material.transition.MaterialContainerTransform;
import com.google.android.material.transition.MaterialSharedAxis;


public class MotionFragment extends Fragment {
    FragmentMotionBinding binding;
    FragmentCheckboxBinding bindingCheckbox;
    FragmentButtonBinding bindingButton;

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
        bindingButton = FragmentButtonBinding.inflate(inflater, container, false);
        bindingCheckbox = FragmentCheckboxBinding.inflate(inflater, container, false);

        bindingButton.btnCustom.setText(R.string.motion_button_back);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialContainerTransform transform = new MaterialContainerTransform();
        transform.setScrimColor(Color.TRANSPARENT);
        transform.setDuration(500L);

        binding.ibCancel.setOnClickListener(v -> {
            transform.setStartView(binding.viewEnd);
            transform.setEndView(binding.viewStart);
            transform.addTarget(binding.viewStart);

            TransitionManager.beginDelayedTransition(binding.containerMain, transform);
            binding.viewEnd.setVisibility(View.GONE);
            binding.viewStart.setVisibility(View.VISIBLE);
        });

        binding.viewStart.setOnClickListener(v -> {
            transform.setPathMotion(new MaterialArcMotion());
            transform.setStartView(binding.viewStart);
            transform.setEndView(binding.viewEnd);
            transform.addTarget(binding.viewEnd);

            TransitionManager.beginDelayedTransition(binding.containerMain, transform);
            binding.viewStart.setVisibility(View.GONE);
            binding.viewEnd.setVisibility(View.VISIBLE);
        });

        bindingButton.btnCustom.setOnClickListener(v -> {
            MaterialSharedAxis sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            sharedAxis.setDuration(1500L);
            TransitionManager.beginDelayedTransition(binding.viewEnd, sharedAxis);

            binding.viewOut.setVisibility(View.GONE);
            binding.viewIn.setVisibility(View.VISIBLE);
        });

        binding.btnBack.setOnClickListener(v -> {
            MaterialSharedAxis sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.X, false);
            sharedAxis.setDuration(1500L);
            TransitionManager.beginDelayedTransition(binding.viewEnd, sharedAxis);

            binding.viewIn.setVisibility(View.GONE);
            binding.viewOut.setVisibility(View.VISIBLE);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}