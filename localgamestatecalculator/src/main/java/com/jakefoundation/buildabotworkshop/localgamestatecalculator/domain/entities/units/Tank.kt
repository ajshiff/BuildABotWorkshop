package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.units

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Collidable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Damageable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Destroyable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Directable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Health
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Size
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Speed

data class Tank(override val location: Location)
        : Directable, Collidable, Damageable, Destroyable {
    override val maxSpeed: Speed = Speed(3.0)
    override val size: Size = Size(3.0)
    override val health: Health = Health(9)

    override fun isDestroyed(): Boolean {
        return health.health <= 0
    }
}