package com.jakefoundation.buildabotworkshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.jakefoundation.buildabotworkshop.R.id.bot_launcher;
import static com.jakefoundation.buildabotworkshop.R.id.play_launcher;
import static com.jakefoundation.buildabotworkshop.R.id.scenario_launcher;

public class ScenarioPageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_page);

        Button fire = findViewById(R.id.fire);
        Button move = findViewById(R.id.move);
        Button survive = findViewById(R.id.scenario_ffa);
        Button botAndU = findViewById(R.id.scenario_bot);
        Button y = findViewById(R.id.scenario_y);
        Button x = findViewById(R.id.scenario_x);
        Button random = findViewById(R.id.scenario_random);

        fire.setOnClickListener(this);
        move.setOnClickListener(this);
        survive.setOnClickListener(this);
        botAndU.setOnClickListener(this);
        y.setOnClickListener(this);
        x.setOnClickListener(this);
        random.setOnClickListener(this);



        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemReselectedListener((BottomNavigationView.OnNavigationItemReselectedListener) navListener);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fire:
                Toast.makeText(this, "Fire tutorial", Toast.LENGTH_SHORT).show();
                break;
            case R.id.move:
                Toast.makeText(this, "Move tutorial", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scenario_random:
                Toast.makeText(this, "Random Scenario", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scenario_bot:
                Toast.makeText(this, "You x Bot", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scenario_x:
                Toast.makeText(this, "Scenario x", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scenario_y:
                Toast.makeText(this, "Scenario y", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scenario_ffa:
                Toast.makeText(this, "Scenario FFA", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment selectedFragment = null;

        switch (item.getItemId()){
            case bot_launcher:
                selectedFragment = new bot_Fragment();
                break;
            case play_launcher:
                selectedFragment = new play_Fragment();
                break;
            case scenario_launcher:
                selectedFragment = new scenario_Fragment();
                break;

        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment);
        return true;
    };

}



