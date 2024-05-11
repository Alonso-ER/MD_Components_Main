package com.alain.cursos.alonso.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.FragmentAppBarBottomBinding;
import com.alain.cursos.alonso.databinding.FragmentBottomNavigationBarBinding;
import com.alain.cursos.alonso.utils.BottomAppBarCutCornersTopEdge;
import com.google.android.material.shape.MaterialShapeDrawable;

public class BottomNavigationDrawerFragment extends DialogFragment {
    FragmentBottomNavigationBarBinding binding;
    FragmentAppBarBottomBinding barBottomBinding;
    public static final String TAG = "Bottom Navigation Drawer";

    public BottomNavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBottomNavigationBarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        barBottomBinding.bottomAppBar.setNavigationOnClickListener(v -> {
            ModalBottomSheetFragment fragment = new ModalBottomSheetFragment();
            fragment.show(getParentFragmentManager(), ModalBottomSheetFragment.TAG);
        });

        BottomAppBarCutCornersTopEdge topEdge = new BottomAppBarCutCornersTopEdge(
                barBottomBinding.bottomAppBar.getFabCradleMargin(),
                barBottomBinding.bottomAppBar.getFabCradleRoundedCornerRadius(),
                barBottomBinding.bottomAppBar.getCradleVerticalOffset()
        );

        MaterialShapeDrawable shapeDrawable = (MaterialShapeDrawable)barBottomBinding.bottomAppBar.getBackground();
        shapeDrawable.setShapeAppearanceModel(
                shapeDrawable.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopEdge(topEdge)
                        .build());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}