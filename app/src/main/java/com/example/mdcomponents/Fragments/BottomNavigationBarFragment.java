package com.example.mdcomponents.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentBottomNavigationBarBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavigationBarFragment extends Fragment {

    public static final String TAG = "Button Navigation";
    private static Component mInstance;
    private FragmentBottomNavigationBarBinding binding;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);
        return getmInstance();
    }

    public BottomNavigationBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using ViewBinding
        binding = FragmentBottomNavigationBarBinding.inflate(inflater, container, false);
        // Access the BottomNavigationView
        BottomNavigationView bottomNavigation = binding.bottomNavigation;
        BadgeDrawable badge = bottomNavigation.getOrCreateBadge(R.id.action_menu);
        //bottomNavigation.removeBadge(R.id.action_menu);

        BadgeDrawable favoriteBadge = bottomNavigation.getOrCreateBadge(R.id.action_favorite);
        favoriteBadge.setNumber(21);

        BadgeDrawable profileBadge = bottomNavigation.getOrCreateBadge(R.id.action_menu);
        profileBadge.setMaxCharacterCount(3);
        profileBadge.setNumber(1000);
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