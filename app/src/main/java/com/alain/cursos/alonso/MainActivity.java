package com.alain.cursos.alonso;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alain.cursos.alonso.adapters.ComponentAdapter;
import com.alain.cursos.alonso.fragments.AlertDialogFragment;
import com.alain.cursos.alonso.fragments.AppBarFragment;
import com.alain.cursos.alonso.fragments.BottomNavigationBarFragment;
import com.alain.cursos.alonso.fragments.ButtonFragment;
import com.alain.cursos.alonso.fragments.CardFragment;
import com.alain.cursos.alonso.fragments.CheckboxFragment;
import com.alain.cursos.alonso.fragments.FloatingActionButtonFragment;
import com.alain.cursos.alonso.fragments.MenuFragment;
import com.alain.cursos.alonso.fragments.PickerFragment;
import com.alain.cursos.alonso.fragments.SnackBarFragment;
import com.alain.cursos.alonso.fragments.TextFieldFragment;
import com.alain.cursos.alonso.utils.Component;
import com.alain.cursos.alonso.utils.Constants;
import com.alain.cursos.alonso.utils.OnClickListener;
import com.mdcomponents.cursos.alain.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ActivityMainBinding binding;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configAdapter();
        configRecyclerView();
    }

    private void configAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(), this);
        mAdapter.add(ButtonFragment.getmInstance());
        mAdapter.add(BottomNavigationBarFragment.getmInstance());
        mAdapter.add(SnackBarFragment.getmInstance());
        mAdapter.add(TextFieldFragment.getmInstance());
        mAdapter.add(FloatingActionButtonFragment.getmInstance());
        mAdapter.add(CheckboxFragment.getmInstance());
        mAdapter.add(CardFragment.getmInstance());
        mAdapter.add(MenuFragment.getmInstance());
        mAdapter.add(AlertDialogFragment.getmInstance());
        mAdapter.add(AppBarFragment.getmInstance());
        mAdapter.add(PickerFragment.getmInstance());
        mAdapter.add(AlertDialogFragment.getmInstance());
        mAdapter.reverse();
    }

    private void configRecyclerView() {
        binding.recyclerView.setAdapter(mAdapter);
    }

    /*
    * OnClickListener
    * */
    @Override
    public void onClick(Component component) {
        Intent intent;
        if (component.getType() == Constants.SCROLL){
            intent = new Intent(this, ScrollActivity.class);
        } else { //STATIC
            intent = new Intent(this, StaticActivity.class);
        }
        intent.putExtra(Constants.ARG_NAME, component.getName());
        startActivity(intent);
    }
}
