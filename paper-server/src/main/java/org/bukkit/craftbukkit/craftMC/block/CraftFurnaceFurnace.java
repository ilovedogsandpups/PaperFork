package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.jspecify.annotations.NonNull;

public class CraftFurnaceFurnace extends CraftFurnace<FurnaceBlockEntity> {

    public CraftFurnaceFurnace(World world, FurnaceBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftFurnaceFurnace(CraftFurnaceFurnace state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftFurnaceFurnace copy() {
        return new CraftFurnaceFurnace(this, null);
    }

    @Override
    public @NonNull CraftFurnaceFurnace copy(Location location) {
        return new CraftFurnaceFurnace(this, location);
    }
}
