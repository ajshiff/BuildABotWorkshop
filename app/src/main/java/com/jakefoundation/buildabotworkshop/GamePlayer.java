package com.jakefoundation.buildabotworkshop;

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

import com.jakefoundation.buildabotworkshop.domain.Position;
import com.jakefoundation.buildabotworkshop.domain.unit.Unit;
import com.jakefoundation.buildabotworkshop.models.Player;
import com.jakefoundation.buildabotworkshop.models.TankColors;

import java.util.HashMap;
import java.util.Map;

public class GamePlayer extends Fragment {

    private GamePlayerViewModel mViewModel;
    private final Map<TankColors, View> tankViews = new HashMap<>();
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
        pixelHeight = displayMetrics.heightPixels;
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
        gameLoopThread = new Thread(gameLoop);
        gameLoopThread.start();
    }

    @Override
    public void onPause () {
        super.onPause();
        gameLoopThread.interrupt();
        try {
            //noinspection BusyWait
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final Runnable gameLoop = () -> {
        mViewModel.init();
        mViewModel.playLoop();
        int counter = 0;
        while (counter < 100 && !gameLoopThread.isInterrupted()) {
//            Log.i("HALP", "MEEEEE");
            counter++;
            updateView();
            mViewModel.playLoop();
            try {
                //noinspection BusyWait
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private float po = 0f;
    private void updateView () {
        po += 25;
        for (Player player : mViewModel.players) {
//            Position playerPos = player.getSelfDetails().getPosition();
            requireActivity().runOnUiThread(() -> animateDiagonalPan(tankViews.get(player.getColor()),
                   po % pixelWidth,
                    po % pixelWidth));
        }
    }

    private void animateDiagonalPan(View v, float xOffset, float yOffset) {
        if (!gameLoopThread.isInterrupted()) {
            AnimatorSet animSetXY = new AnimatorSet();
            ObjectAnimator y = ObjectAnimator.ofFloat(v,
                    "translationY", yOffset);

            ObjectAnimator x = ObjectAnimator.ofFloat(v,
                    "translationX", xOffset);

            animSetXY.playTogether(x, y);
            animSetXY.setDuration(100);
            animSetXY.start();
        }
    }

    private float convertAxisToPixel (double conversionScale, int pixels) {
        return (float) conversionScale * pixels;
    }

    private Pair<Float, Float> convertPosToPixel (Position pos) {
        double conversionScaleX = pos.getX() / mViewModel.gameState.getGameBoard().getX();
        double conversionScaleY = pos.getY() / mViewModel.gameState.getGameBoard().getY();
        return new Pair<>(convertAxisToPixel(conversionScaleX, pixelWidth),
                convertAxisToPixel(conversionScaleY, pixelHeight));
    }



}