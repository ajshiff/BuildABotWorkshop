package com.jakefoundation.buildabotworkshop.localgamestatecalculator.presentation

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.units.Tank

data class OwnedTank(val owner: String, val tank: Tank) {
}
