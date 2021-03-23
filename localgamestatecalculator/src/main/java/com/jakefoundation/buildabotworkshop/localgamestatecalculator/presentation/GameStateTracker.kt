package com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.obstacles.Wall

data class GameStateTracker (var tanks: List<OwnedTank> = listOf<OwnedTank>(), var bullets: List<OwnedBullet> = listOf<OwnedBullet>(), var gameBoard: GameBoard = GameBoard()) {
}