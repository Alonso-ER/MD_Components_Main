package com.alain.cursos.alonso.fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.FragmentModalBottomSheetBinding;
import com.mdcomponents.cursos.alain.databinding.FragmentModalBottomSheetFullScreenBinding;

import java.util.Objects;


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
        bottomSheetDialog.setContentView(binding.getRoot());

        binding.vExtraSpace.setMinimumHeight((Resources.getSystem().getDisplayMetrics().heightPixels) / 4);

        nBottomSheetBehavior = BottomSheetBehavior.from((View) binding.getRoot().getParent());
        nBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        nBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

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