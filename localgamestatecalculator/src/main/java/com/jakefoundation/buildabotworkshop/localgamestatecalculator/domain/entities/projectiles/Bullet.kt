package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.projectiles

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Collidable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Movable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Direction
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Size
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Speed

class Bullet (override val location: Location, override val direction: Direction) : Movable, Collidable {
    override val speed: Speed = Speed(5.0)
    override val size: Size = Size(1.0)
}