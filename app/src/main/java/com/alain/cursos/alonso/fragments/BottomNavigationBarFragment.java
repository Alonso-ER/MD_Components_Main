package com.alain.cursos.alonso.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alain.cursos.alonso.R;
import com.alain.cursos.alonso.databinding.FragmentBottomNavigationBarBinding;
import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.google.android.material.badge.BadgeDrawable;

public class BottomNavigationBarFragment extends Fragment {

    FragmentBottomNavigationBarBinding binding;

    public static final String TAG = "Bottom Navigation";

    public static Component getmInstance() {
        Component mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public BottomNavigationBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBottomNavigationBarBinding.inflate(inflater, container, false);

        binding.bottomNavigation.getOrCreateBadge(R.id.action_start);
        //bottomNavigation.removeBadge(R.id.action_start);

        BadgeDrawable favoriteBadge = binding.bottomNavigation.getOrCreateBadge(R.id.action_favorites);
        favoriteBadge.setNumber(21);

        BadgeDrawable profileBadge = binding.bottomNavigation.getOrCreateBadge(R.id.action_profile);
        profileBadge.setNumber(999);
        profileBadge.setMaxCharacterCount(3);
        profileBadge.setBackgroundColor(Color.CYAN);
        profileBadge.setBadgeTextColor(Color.MAGENTA);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
