package com.jakefoundation.buildabotworkshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NavController navController;

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    public void inspectBots (View view) {
        Navigation.findNavController(view).navigate(R.id.action_mainMenu_to_botInspector);
    }

    public void startGame (View view) {
        Navigation.findNavController(view).navigate(R.id.action_mainMenu_to_gamePlayer);
    }
}