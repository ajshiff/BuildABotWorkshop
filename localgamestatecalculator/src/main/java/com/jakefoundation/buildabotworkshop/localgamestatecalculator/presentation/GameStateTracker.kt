package com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.obstacles.Wall

class GameStateTracker {
    val tanks = listOf<OwnedTank>()
    val bullets = listOf<OwnedBullet>()
    val gameBoard = GameBoard()
}