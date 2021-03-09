package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data

data class Size (val radius: Double) {
    init {
        require(radius >= 0.0) {
            "A radius value $radius must be greater than or equal to zero"
        }
    }
}
