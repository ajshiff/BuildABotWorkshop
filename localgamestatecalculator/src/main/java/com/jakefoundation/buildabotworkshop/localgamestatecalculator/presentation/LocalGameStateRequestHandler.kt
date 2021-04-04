package com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation

import com.jakefoundation.buildabotworkshop.application.MoveTankCommand.MoveTankRequest
import com.jakefoundation.buildabotworkshop.application.fireBulletCommand.FireBulletRequest
import com.jakefoundation.buildabotworkshop.application.getgamestate.GetGameStateRequest
import com.jakefoundation.buildabotworkshop.application.spawntankrequest.SpawnTankRequest
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.projectiles.Bullet
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Direction
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Speed
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.units.Tank
import kotlinx.coroutines.*
import kotlin.random.Random

class LocalGameStateRequestHandler {

    private var spawnRequests = mutableListOf<SpawnTankRequest>()
    private var moveRequests = mutableListOf<MoveTankRequest>()
    private var fireRequests = mutableListOf<FireBulletRequest>()
    private var gameState = GameStateTracker()
    private val randomGenerator = Random

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
        var counter = 0
        while (!gameOver) {
            System.out.println("running game loop")
            var gs = gameState.copy()
            // copy requests
            val spawnTankRequest = spawnRequests.toList()
            val fireBulletRequests = fireRequests.toList()
            val moveTankRequests = moveRequests.toList()
            // clear requests
            spawnRequests = mutableListOf<SpawnTankRequest>()
            fireRequests = mutableListOf<FireBulletRequest>()
            moveRequests = mutableListOf<MoveTankRequest>()

            gs.tanks = handleSpawnRequests(spawnTankRequest, gs)
            // Move Bullets
            gs.bullets = handleMoveBullets(gs)
            // Check Collisions
            gs = handleBulletCollisions(gs)
            // Fire New Bullets
            gs.bullets = handleFireRequests(fireBulletRequests, gs)
            // Move Tanks
            gs.tanks = handleMoveRequests(moveTankRequests, gs)
            // Spawn New Tanks
            gameState = gs
            delay(20)
            if (counter++ > 10000)
                gameOver = true
        }
    }

    private fun handleSpawnRequests (requests: List<SpawnTankRequest>, gameStateTracker: GameStateTracker) : List<OwnedTank> {
        val newTanks = requests.filter { request ->
            // filter out any requests that come from someone who already has a tank
            !gameStateTracker.tanks.any{tank -> tank.owner == request.username }
        }.map { request ->
            val randomX = randomGenerator.nextDouble(0.0, gameStateTracker.gameBoard.x.toDouble())
            val randomY = randomGenerator.nextDouble(0.0, gameStateTracker.gameBoard.y.toDouble())
            OwnedTank(request.username, Tank(Location(randomX, randomY)))
        }
        return newTanks + gameStateTracker.tanks
    }

    private fun handleMoveRequests (requests: List<MoveTankRequest>, gameStateTracker: GameStateTracker) : List<OwnedTank> {
        val tanks = gameStateTracker.tanks.toList();
        val movingTanks = tanks.filter { tank ->
            requests.any { request -> request.username == tank.owner }
        }
        val notMovingTanks = tanks - movingTanks;
        val newTankDetails = movingTanks.map { tank ->
            val request = requests.first {request -> request.username == tank.owner}
            val direction = Direction(request.angle)
            val speed = Speed(request.speed)
            val location = tank.tank.move(direction, speed).loopLocation(gameState.gameBoard.x, gameState.gameBoard.y)
            val newTankDetails = Tank(location, direction, speed)
            OwnedTank(tank.owner, newTankDetails)
        }
        return notMovingTanks + newTankDetails
    }

    private fun handleFireRequests (requests: List<FireBulletRequest>, gameStateTracker: GameStateTracker) : List<OwnedBullet> {
        val newBullets = requests.distinctBy { request -> request.username }.map { request ->
            val ownerTank = gameStateTracker.tanks.first() { ownedTank -> ownedTank.owner == request.username }
            val direction = Direction(request.angle)
            OwnedBullet(ownerTank.owner, ownerTank.tank, Bullet(ownerTank.tank.location, direction))
        }
        return gameStateTracker.bullets + newBullets
    }

    private fun handleMoveBullets (gameStateTracker: GameStateTracker) : List<OwnedBullet> {
        return gameStateTracker.bullets.map { bullet ->
            val newLocation = bullet.bullet.move().loopLocation(gameState.gameBoard.x, gameState.gameBoard.y)
            val newBulletDetails = bullet.bullet.copy(location = newLocation)
            bullet.copy(bullet = newBulletDetails)
        }
    }

    private fun handleBulletCollisions (gameStateTracker: GameStateTracker) : GameStateTracker {
        gameStateTracker.bullets.forEach { bullet ->
            gameStateTracker.tanks.forEach {tank ->
                val isTouching = bullet.bullet.isTouching(tank.tank)
                if (isTouching) {
                    tank.tank.takeDamage(bullet.bullet.damage)
                }
            }
        }
        val newBullets = gameStateTracker.bullets.filter { bullet -> !bullet.bullet.isDestroyed() }
        val newTanks = gameStateTracker.tanks.filter { tank -> !tank.tank.isDestroyed() }
        return gameStateTracker.copy(bullets = newBullets, tanks = newTanks)
    }


}