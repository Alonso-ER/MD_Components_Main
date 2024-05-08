package com.alain.cursos.mdcomponents;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.alain.cursos.mdcomponents.utils.CommonUtils;
import com.alain.cursos.mdcomponents.utils.Constants;

import com.mdcomponents.cursos.alain.R;
import com.mdcomponents.cursos.alain.databinding.ActivityStaticBinding;

public class StaticActivity extends AppCompatActivity {

    ActivityStaticBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStaticBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        String nameFragment = null;
        if (savedInstanceState == null){
            nameFragment = getIntent().getStringExtra(Constants.ARG_NAME);

            CommonUtils.setFragment(this, nameFragment, R.id.content_static);
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(nameFragment);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bottom_nav, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
