package com.alain.cursos.alonso.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.FragmentModalNavigationDrawerBinding;

public class ModalNavigationDrawerFragment extends DialogFragment
        implements NavigationView.OnNavigationItemSelectedListener{
    FragmentModalNavigationDrawerBinding binding;

    public static final String TAG = "Modal Navigation Drawer";

    public ModalNavigationDrawerFragment() {
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
        binding = FragmentModalNavigationDrawerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity) requireActivity()).setSupportActionBar(binding.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                requireActivity(), binding.drawerLayout, binding.toolbar,
                R.string.dialog_ok, R.string.dialog_cancel);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.nmd.setNavigationItemSelectedListener(this);
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
        } else if (itemId == R.id.action_app_bar_bottom) {
            AppBarBottomFragment bottomFragment = new AppBarBottomFragment();
            bottomFragment.show(requireActivity().getSupportFragmentManager(), AppBarBottomFragment.TAG);
        } else {
            String msg = item.getTitle().toString();
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}