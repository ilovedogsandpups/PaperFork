package org.bukkit.craftbukkit.block;

import net.minecraft.world.level.block.entity.CalibratedSculkSensorBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.CalibratedSculkSensor;
import org.jspecify.annotations.NonNull;

public class CraftCalibratedSculkSensor extends CraftSculkSensor<CalibratedSculkSensorBlockEntity> implements CalibratedSculkSensor {

    public CraftCalibratedSculkSensor(World world, CalibratedSculkSensorBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftCalibratedSculkSensor(CraftCalibratedSculkSensor state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftCalibratedSculkSensor copy() {
        return new CraftCalibratedSculkSensor(this, null);
    }

    @Override
    public @NonNull CraftCalibratedSculkSensor copy(@NonNull Location location) {
        return new CraftCalibratedSculkSensor(this, location);
    }
}
