package com.jakefoundation.buildabotworkshop.application.spawntankrequest;

import com.jakefoundation.buildabotworkshop.application.common.ResultStatus;

public interface ISpawnTankService {
     ResultStatus sendSpawnTankRequest(SpawnTankRequest spawnTankRequest);
}
