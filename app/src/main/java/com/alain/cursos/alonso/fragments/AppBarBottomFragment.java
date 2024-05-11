package com.alain.cursos.alonso.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.FragmentAppBarBottomBinding;
import com.alain.cursos.alonso.utils.BottomAppBarCutCornersTopEdge;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;


public class AppBarBottomFragment extends DialogFragment {

    FragmentAppBarBottomBinding binding;
    public static final String TAG = "AppBarBottomFragment";

    private boolean isCentered;

    public AppBarBottomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAppBarBottomBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(v -> {
            if (isCentered){
                binding.bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            }else{
                binding.bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            }
            isCentered = !isCentered;
        });

        binding.bottomAppBar.setOnMenuItemClickListener(item -> {
            int resMessage;
            if (item.getItemId() == R.id.action_favorites) {
                resMessage = R.string.menu_favorites;
            } else if (item.getItemId() == R.id.action_profile) {
                resMessage = R.string.menu_profile;
            } else {
                resMessage = R.string.menu_start;
            }
            Snackbar.make(binding.containerMain, resMessage, Snackbar.LENGTH_LONG)
                    .setAnchorView(binding.fab)
                    .show();

            return true;
        });

        binding.bottomAppBar.setNavigationOnClickListener(view1 -> {
            Snackbar.make(binding.containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG)
                    .setAnchorView(binding.fab)
                    .show();
        });

        BottomAppBarCutCornersTopEdge topEdge = new BottomAppBarCutCornersTopEdge(
                binding.bottomAppBar.getFabCradleMargin(),
                binding.bottomAppBar.getFabCradleRoundedCornerRadius(),
                binding.bottomAppBar.getCradleVerticalOffset()
        );

        MaterialShapeDrawable shapeDrawable = (MaterialShapeDrawable)binding.bottomAppBar.getBackground();
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
