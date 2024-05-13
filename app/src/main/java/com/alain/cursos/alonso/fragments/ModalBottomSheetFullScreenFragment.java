package com.alain.cursos.alonso.fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.FragmentModalBottomSheetFullScreenBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.transition.MaterialFadeThrough;
import com.google.android.material.transition.SlideDistanceProvider;

public class ModalBottomSheetFullScreenFragment extends BottomSheetDialogFragment {

    FragmentModalBottomSheetFullScreenBinding binding;

    public static final String TAG = "Modal BottomSheet FullScreen";

    private BottomSheetBehavior nBottomSheetBehavior;

    public ModalBottomSheetFullScreenFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        binding = FragmentModalBottomSheetFullScreenBinding.inflate(getLayoutInflater());

        binding.vExtraSpace.setMinimumHeight((Resources.getSystem().getDisplayMetrics().heightPixels) / 4);

        nBottomSheetBehavior = BottomSheetBehavior.from((View) binding.getRoot().getParent());
        nBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        nBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                MaterialFadeThrough fadeThrough = new MaterialFadeThrough();
                fadeThrough.setSecondaryAnimatorProvider(new SlideDistanceProvider(Gravity.TOP));
                fadeThrough.setDuration(250L);

                TransitionManager.beginDelayedTransition(binding.containerBar);

                int statusBarColor = ContextCompat.getColor(requireActivity(), R.color.colorPrimaryDark);

                if(BottomSheetBehavior.STATE_HIDDEN == newState){
                    binding.appBar.setVisibility(View.VISIBLE);
                    binding.tvBar.setVisibility(View.GONE);
                    statusBarColor = ContextCompat.getColor(requireActivity(), R.color.colorAccent);
                } else if(BottomSheetBehavior.STATE_COLLAPSED == newState){
                    binding.appBar.setVisibility(View.GONE);
                    binding.tvBar.setVisibility(View.VISIBLE);
                }
                requireActivity().getWindow().setStatusBarColor(statusBarColor);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        binding.ibCancel.setOnClickListener(v -> nBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN));

        bottomSheetDialog.setContentView(binding.getRoot());
        return bottomSheetDialog;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}