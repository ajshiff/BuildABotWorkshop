package com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.projectiles.Bullet
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.units.Tank

data class OwnedBullet (val owner: String, val tankOwner: Tank, val bullet: Bullet) {
}