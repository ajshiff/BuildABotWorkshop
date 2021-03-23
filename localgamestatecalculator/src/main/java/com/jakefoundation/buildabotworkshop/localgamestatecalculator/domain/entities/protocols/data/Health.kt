package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data

data class Health(val health: Int) {
    operator fun minus (other: Health) : Health {
        return Health(health - other.health)
    }
}
