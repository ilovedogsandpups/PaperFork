package org.bukkit.craftbukkit.craftMC.block;

import com.google.common.base.Preconditions;
import net.minecraft.world.level.block.entity.SculkSensorBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.SculkSensor;
import org.jspecify.annotations.NonNull;

public class CraftSculkSensor<T extends SculkSensorBlockEntity> extends CraftBlockEntityState<T> implements SculkSensor {

    public CraftSculkSensor(World world, T blockEntity) {
        super(world, blockEntity);
    }

    protected CraftSculkSensor(CraftSculkSensor<T> state, Location location) {
        super(state, location);
    }

    @Override
    public int getLastVibrationFrequency() {
        return this.getSnapshot().getLastVibrationFrequency();
    }

    @Override
    public void setLastVibrationFrequency(int lastVibrationFrequency) {
        Preconditions.checkArgument(0 <= lastVibrationFrequency && lastVibrationFrequency <= 15, "Vibration frequency must be between 0-15");
        this.getSnapshot().setLastVibrationFrequency(lastVibrationFrequency);
    }

    @Override
    public @NonNull CraftSculkSensor<T> copy() {
        return new CraftSculkSensor<>(this, null);
    }

    @Override
    public @NonNull CraftSculkSensor<T> copy(@NonNull Location location) {
        return new CraftSculkSensor<>(this, location);
    }

    // Paper start
    @Override
    public int getListenerRange() {
        return this.getSnapshot().getListener().getListenerRadius();
    }

    @Override
    public void setListenerRange(int range) {
        Preconditions.checkArgument(range > 0, "Vibration listener range must be greater than 0");
        this.getSnapshot().rangeOverride = range;
    }
    // Paper end
}
