package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.CopperGolemStatueBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.CopperGolemStatue;
import org.jspecify.annotations.NonNull;

public class CraftCopperGolemStatue extends CraftBlockEntityState<CopperGolemStatueBlockEntity> implements CopperGolemStatue {
    public CraftCopperGolemStatue(World world, CopperGolemStatueBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftCopperGolemStatue(CraftCopperGolemStatue state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftBlockEntityState<CopperGolemStatueBlockEntity> copy() {
        return new CraftCopperGolemStatue(this, null);
    }

    @Override
    public @NonNull CraftBlockEntityState<CopperGolemStatueBlockEntity> copy(@NonNull Location location) {
        return new CraftCopperGolemStatue(this, location);
    }
}
