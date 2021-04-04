package com.jakefoundation.buildabotworkshop.bots;


import com.jakefoundation.buildabotworkshop.domain.Angle;
import com.jakefoundation.buildabotworkshop.domain.Bot;
import com.jakefoundation.buildabotworkshop.domain.FireBulletCommand;
import com.jakefoundation.buildabotworkshop.domain.GameState;
import com.jakefoundation.buildabotworkshop.domain.MoveTankCommand;
import com.jakefoundation.buildabotworkshop.domain.ShouldDo;
import com.jakefoundation.buildabotworkshop.domain.Speed;
import java.util.Objects;


public class PamBot implements Bot {


    @Override
    public String getBotCommonName() {
        return "Pam Bot";
    }

    @Override
    public MoveTankCommand moveCommand(GameState gameState) {


        final MoveTankCommand moveTankCommand = new MoveTankCommand(ShouldDo.doit, new Angle(2.), new Speed(3.));
        return moveTankCommand;


        }




    @Override
    public FireBulletCommand fireCommand(GameState gameState){

        final FireBulletCommand fireBulletCommand = new FireBulletCommand(ShouldDo.doit, new Angle(120.));
        return fireBulletCommand;}}


