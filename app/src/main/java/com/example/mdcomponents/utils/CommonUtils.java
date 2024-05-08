package com.example.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mdcomponents.Fragments.AppBarFragment;
import com.example.mdcomponents.Fragments.BottomNavigationBarFragment;
import com.example.mdcomponents.Fragments.ButtonFragment;
import com.example.mdcomponents.Fragments.CardFragment;
import com.example.mdcomponents.Fragments.CheckboxFragment;
import com.example.mdcomponents.Fragments.AlertDialogFragment;
import com.example.mdcomponents.Fragments.FloatingActionButtonFragment;
import com.example.mdcomponents.Fragments.MenuFragment;
import com.example.mdcomponents.Fragments.SnackBarFragment;
import com.example.mdcomponents.Fragments.TextFieldFragment;

public class CommonUtils {
    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes) {
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){
            //SCROLL
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;
            case CheckboxFragment.TAG:
                fragment = new CheckboxFragment();
                break;
            case CardFragment.TAG:
                fragment = new CardFragment();
                break;

            //STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
                break;
            case MenuFragment.TAG:
                fragment = new MenuFragment();
                break;
            case AlertDialogFragment.TAG:
                fragment = new AlertDialogFragment();
                break;
            case AppBarFragment.TAG:
                fragment = new AppBarFragment();
                break;
        }

        return fragment;
    }
}
