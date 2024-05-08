package com.alain.cursos.mdcomponents;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alain.cursos.mdcomponents.adapters.ComponentAdapter;
import com.alain.cursos.mdcomponents.fragments.AlertDialogFragment;
import com.alain.cursos.mdcomponents.fragments.AppBarFragment;
import com.alain.cursos.mdcomponents.fragments.BottomNavigationBarFragment;
import com.alain.cursos.mdcomponents.fragments.ButtonFragment;
import com.alain.cursos.mdcomponents.fragments.CardFragment;
import com.alain.cursos.mdcomponents.fragments.CheckboxFragment;
import com.alain.cursos.mdcomponents.fragments.FloatingActionButtonFragment;
import com.alain.cursos.mdcomponents.fragments.MenuFragment;
import com.alain.cursos.mdcomponents.fragments.PickerFragment;
import com.alain.cursos.mdcomponents.fragments.SnackBarFragment;
import com.alain.cursos.mdcomponents.fragments.TextFieldFragment;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.alain.cursos.mdcomponents.utils.OnClickListener;
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
