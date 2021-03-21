package com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankRequest
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.FireBulletRequest
import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateRequest
import com.jakefoundation.buildabotworkshop.application.spawntankrequest.SpawnTankRequest
import com.jakefoundation.buildabotworkshop.domain.GameState
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.obstacles.Wall
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.projectiles.Bullet
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.units.Tank
import kotlinx.coroutines.*

class LocalGameStateRequestHandler {

    private val spawnRequests = mutableListOf<SpawnTankRequest>()
    private val moveRequests = mutableListOf<MoveTankRequest>()
    private val fireRequests = mutableListOf<FireBulletRequest>()
    private var gameState = GameStateTracker()

    constructor() {
        GlobalScope.launch{
            gameloop()
        }
    }

    fun receiveSpawnTankRequest (request: SpawnTankRequest) {
        spawnRequests.add(request)
    }

    fun receiveMoveCommand (request: MoveTankRequest) {
        moveRequests.add(request)
    }

    fun receiveFireCommand(request: FireBulletRequest) {
        fireRequests.add(request)
    }

    fun receiveGetGameStateRequest (request: GetGameStateRequest) : GameStateTracker {
        return gameState
    }

    private suspend fun gameloop () {

        var gameOver = false
        while (!gameOver) {
            delay(100)
            gameOver = true
        }
    }
}