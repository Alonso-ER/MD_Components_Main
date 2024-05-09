package com.alain.cursos.alonso.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdcomponents.Fragments.FullScreenDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;
import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.FragmentModalBottomSheetBinding;

public class ModalBottomSheetFragment extends BottomSheetDialogFragment
    implements NavigationView.OnNavigationItemSelectedListener {
    FragmentModalBottomSheetBinding binding;
    public static final String TAG = "Modal Bottom Sheet";

    public ModalBottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentModalBottomSheetBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.nmdBottom.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_cancel) {
            //binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else if (itemId == R.id.action_full_screen_dialog) {
            FullScreenDialogFragment fullScreenFragment = new FullScreenDialogFragment();
            fullScreenFragment.show(getParentFragmentManager().beginTransaction(), FullScreenDialogFragment.TAG);
        } else {
            String msg = item.getTitle().toString();
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
        dismiss();
        return true;
    }
}