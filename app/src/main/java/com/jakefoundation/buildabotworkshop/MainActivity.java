package com.jakefoundation.buildabotworkshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void inspectBots (View view) {
        Navigation.findNavController(view).navigate(R.id.action_mainMenu_to_botInspector);
    }

    public void startGame (View view) {
        Navigation.findNavController(view).navigate(R.id.action_mainMenu_to_gamePlayer);
    }
}