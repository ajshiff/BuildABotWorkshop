package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Health

interface Damagable {
    val health : Health;
    fun takeDamage (damage: Health) : Health {
        return health - damage
    }
}