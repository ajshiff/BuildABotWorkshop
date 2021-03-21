package com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.obstacles.Wall
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.projectiles.Bullet
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.units.Tank

class GameStateTracker {
    val tanks = listOf<Tank>()
    val bullets = listOf<Bullet>()
    val walls = listOf<Wall>()
}