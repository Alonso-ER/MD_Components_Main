package com.example.mdcomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mdcomponents.Adapters.ComponentAdapter;
import com.example.mdcomponents.Fragments.AppBarFragment;
import com.example.mdcomponents.Fragments.CardFragment;
import com.example.mdcomponents.Fragments.CheckboxFragment;
import com.example.mdcomponents.Fragments.AlertDialogFragment;
import com.example.mdcomponents.Fragments.FloatingActionButtonFragment;
import com.example.mdcomponents.Fragments.MenuFragment;
import com.example.mdcomponents.Fragments.SnackBarFragment;
import com.example.mdcomponents.Fragments.TextFieldFragment;
import com.example.mdcomponents.databinding.ActivityMainBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.example.mdcomponents.utils.OnClickListener;

import java.util.ArrayList;

import com.example.mdcomponents.Fragments.BottomNavigationBarFragment;
import com.example.mdcomponents.Fragments.ButtonFragment;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
    private ComponentAdapter mAdapter;

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding.inflate(getLayoutInflater());
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
        mAdapter.reverse();
    }

    private void configRecyclerView() {
        binding.recyclerView.setAdapter(mAdapter);
    }

    //OnClickListener
    @Override
    public void onClick(Component component) {
        Intent intent;
        if(component.getType() == Constants.SCROLL){
            intent = new Intent(this, ScrollActivity.class);
        } else { // STATIC
            intent = new Intent(this, StaticActivity.class);
        }
        intent.putExtra(Constants.ARG_NAME, component.getName());
    }
}


