package com.alain.cursos.alonso.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.BottomSheetBinding;
import com.alain.cursos.alonso.databinding.FragmentSheetsBottomBinding;
import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class SheetsBottomFragment extends Fragment {

    FragmentSheetsBottomBinding binding;
    BottomSheetBinding bottomSheetBinding;

    public static final String TAG = "Sheets Bottom";

    private boolean mIsExpanded;

    public static Component getmInstance() {
        Component mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_sheets_bottom);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public SheetsBottomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSheetsBottomBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomSheetBehavior<ConstraintLayout> nBottomSheetBehavior =
                BottomSheetBehavior.from(bottomSheetBinding.bottomSheet);
        nBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        nBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback(){
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    mIsExpanded = true;
                    bottomSheetBinding.btnResize.setImageDrawable(
                            ContextCompat.getDrawable(requireContext(),
                                    R.drawable.ic_expand_more));
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mIsExpanded = false;
                    bottomSheetBinding.btnResize.setImageDrawable(
                            ContextCompat.getDrawable(requireContext(),
                                    R.drawable.ic_expand_less));
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // Do something as the bottom sheet slides
            }
        });

        binding.btnStandard.setOnLongClickListener(v -> {
            nBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
            return true;
        });

        binding.btnStandard.setOnClickListener(v -> {
            if(nBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                nBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                nBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        binding.btnModal.setOnClickListener(v -> {
            ModalBottomSheetFullScreenFragment fragment = new ModalBottomSheetFullScreenFragment();
            fragment.show(getParentFragmentManager().beginTransaction(), ModalBottomSheetFragment.TAG);
        });

        bottomSheetBinding.btnResize.setOnClickListener(v -> {
            if (mIsExpanded) {
                nBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                nBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}