package com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.obstacles

import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.Collidable
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Location
import com.jakefoundation.buildabotworkshop.localgamestatecalculator.domain.entities.protocols.data.Size

class Wall (override val location: Location, override val size: Size): Collidable {
}