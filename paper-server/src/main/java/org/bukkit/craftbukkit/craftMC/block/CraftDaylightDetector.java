package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.DaylightDetectorBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.DaylightDetector;
import org.jspecify.annotations.NonNull;

public class CraftDaylightDetector extends CraftBlockEntityState<DaylightDetectorBlockEntity> implements DaylightDetector {

    public CraftDaylightDetector(World world, DaylightDetectorBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftDaylightDetector(CraftDaylightDetector state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftDaylightDetector copy() {
        return new CraftDaylightDetector(this, null);
    }

    @Override
    public @NonNull CraftDaylightDetector copy(@NonNull Location location) {
        return new CraftDaylightDetector(this, location);
    }
}
