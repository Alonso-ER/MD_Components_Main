package com.alain.cursos.alonso.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.FragmentNavigationDrawerBinding;

public class NavigationDrawerFragment extends Fragment {
    FragmentNavigationDrawerBinding binding;

    public static final String TAG = "Navigation Drawer";

    public static Component getmInstance() {
        Component mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_navigation_drawer);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNavigationDrawerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

        binding.btnModal.setOnClickListener(v -> {
            ModalNavigationDrawerFragment modalFragment = new ModalNavigationDrawerFragment();
            modalFragment.show(transaction, ModalNavigationDrawerFragment.TAG);
        });

        binding.btnBottom.setOnClickListener(v -> {
            BottomNavigationDrawerFragment bottomFragment = new BottomNavigationDrawerFragment();
            bottomFragment.show(transaction, BottomNavigationDrawerFragment.TAG);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}