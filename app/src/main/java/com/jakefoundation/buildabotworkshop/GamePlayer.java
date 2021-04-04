package com.jakefoundation.buildabotworkshop;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jakefoundation.buildabotworkshop.domain.Position;
import com.jakefoundation.buildabotworkshop.domain.projectile.Projectile;
import com.jakefoundation.buildabotworkshop.domain.unit.Unit;
import com.jakefoundation.buildabotworkshop.models.Player;
import com.jakefoundation.buildabotworkshop.models.TankColors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamePlayer extends Fragment {

    private GamePlayerViewModel mViewModel;
    private final Map<TankColors, View> tankViews = new HashMap<>();
    private final List<View> projectileViews = new ArrayList<>();
    int pixelHeight = 1;
    int pixelWidth = 1;
    Thread gameLoopThread;

    public static GamePlayer newInstance() {
        return new GamePlayer();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_player_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GamePlayerViewModel.class);
        // TODO: Use the ViewModel
        DisplayMetrics displayMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        pixelHeight = displayMetrics.heightPixels - 200;
        pixelWidth = displayMetrics.widthPixels;
    }

    @Override
    public void onStart () {
        super.onStart();
        tankViews.put(TankColors.cyan, getView().findViewById(R.id.cyan_tank));
        tankViews.put(TankColors.blue, getView().findViewById(R.id.blue_tank));
        tankViews.put(TankColors.pink, getView().findViewById(R.id.pink_tank));
        tankViews.put(TankColors.green, getView().findViewById(R.id.green_tank));
        tankViews.put(TankColors.orange, getView().findViewById(R.id.orange_tank));
        tankViews.put(TankColors.purple, getView().findViewById(R.id.pruple_tank));
        projectileViews.add(getView().findViewById(R.id.cyan_bullet));
        projectileViews.add(getView().findViewById(R.id.blue_bullet));
        projectileViews.add(getView().findViewById(R.id.pink_bullet));
        projectileViews.add(getView().findViewById(R.id.green_bullet));
        projectileViews.add(getView().findViewById(R.id.orange_bullet));
        projectileViews.add(getView().findViewById(R.id.purple_bullet));
        gameLoopThread = new Thread(gameLoop);
        gameLoopThread.start();
    }

    @Override
    public void onPause () {
        super.onPause();
        gameLoopThread.interrupt();
    }

    private final Runnable gameLoop = () -> {
        mViewModel.init();
        mViewModel.playLoop();
        int counter = 0;
        while ((counter < 100 || mViewModel.gameState.getUnits().size() > 1) && !gameLoopThread.isInterrupted()) {
            counter++;
            try {
                //noinspection BusyWait
                Thread.sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateView();
            mViewModel.playLoop();
        }
        updateView();
        for (Player player : mViewModel.players) {
            if (player.getSelfDetails() != null) {
                requireActivity().runOnUiThread( () -> {
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getContext(),
                            String.format("The %s tank won! Congrats %s and their bot, %s!",
                                    player.getColor().name(),
                                    player.getAuth().getUsername(),
                                    player.getBot().getBotCommonName()),
                            duration);
                    toast.show();
                });
            }
        }
        gameLoopThread.interrupt();
    };

    private void updateView () {
        AnimatorSet animSetXY = new AnimatorSet();
        Collection<Animator> animations = new ArrayList<>();
        // update tank views
        for (Player player : mViewModel.players) {
            if (player.getSelfDetails() != null) {
                requireActivity().runOnUiThread(() -> tankViews.get(player.getColor()).setVisibility(View.VISIBLEgit ));
                View v = tankViews.get(player.getColor());
                Unit details = player.getSelfDetails();
//                v.setRotation((float)details.getAngle().getAngleValue());
                Pair<Float, Float> pixelPos = convertPosToPixel(details.getPosition());
                float xOffset = pixelPos.first % pixelWidth;
                float yOffset = pixelPos.second % pixelHeight;

                ObjectAnimator y = ObjectAnimator.ofFloat(v,"translationY", yOffset);
                ObjectAnimator x = ObjectAnimator.ofFloat(v,"translationX", xOffset);

                animations.add(x);
                animations.add(y);
            } else {
                requireActivity().runOnUiThread(() -> tankViews.get(player.getColor()).setVisibility(View.GONE));
            }
        }
        // update bullet views
        int counter = 0;
        for (Projectile bullet : mViewModel.gameState.getProjectiles()) {
            counter++;
            View v = projectileViews.get(counter);
//            requireActivity().runOnUiThread(() -> v.setVisibility(View.VISIBLE));
            Pair<Float, Float> pixelPos = convertPosToPixel(bullet.getPos());
            float xOffset = pixelPos.first % pixelWidth;
            float yOffset = pixelPos.second % pixelHeight;
            ObjectAnimator y = ObjectAnimator.ofFloat(v,"translationY", yOffset);
            ObjectAnimator x = ObjectAnimator.ofFloat(v,"translationX", xOffset);

            animations.add(x);
            animations.add(y);
        }
        for (int i = counter; i < projectileViews.size(); i++) {
            int finalI = i;
//            requireActivity().runOnUiThread(() -> projectileViews.get(finalI).setVisibility(View.GONE));
        }
        animSetXY.playTogether(animations);
        animSetXY.setDuration(0);
        if (mViewModel.gameState.getUnits().size() >= 1 && !gameLoopThread.isInterrupted()) {
            requireActivity().runOnUiThread(animSetXY::start);
        }
    }

    private float convertAxisToPixel (double conversionScale, int pixels) {
        return (float) ((conversionScale * pixels));
    }

    private Pair<Float, Float> convertPosToPixel (Position pos) {
        double conversionScaleX = pos.getX() / mViewModel.gameState.getGameBoard().getX();
        double conversionScaleY = pos.getY() / mViewModel.gameState.getGameBoard().getY();
        return new Pair<>(convertAxisToPixel(conversionScaleX, pixelWidth),
                convertAxisToPixel(conversionScaleY, pixelHeight));
    }



}