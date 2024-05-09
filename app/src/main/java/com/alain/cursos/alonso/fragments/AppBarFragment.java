package com.alain.cursos.alonso.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.FragmentAppBarBinding;

public class AppBarFragment extends Fragment {

    FragmentAppBarBinding binding;

    public static final String TAG = "App Bar";

    private static Component mInstance;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_topappbar);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public AppBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAppBarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

        binding.btnTop.setOnClickListener(view1 -> {
            AppBarTopFragment topFragment = new AppBarTopFragment();
            topFragment.show(transaction, FullScreenDialogFragment.TAG);
        });

        binding.btnBottom.setOnClickListener(view12 -> {
            AppBarBottomFragment bottomFragment = new AppBarBottomFragment();
            bottomFragment.show(transaction, FullScreenDialogFragment.TAG);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
