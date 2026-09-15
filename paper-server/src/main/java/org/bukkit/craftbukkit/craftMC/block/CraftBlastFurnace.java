package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlastFurnace;
import org.jspecify.annotations.NonNull;

public class CraftBlastFurnace extends CraftFurnace<BlastFurnaceBlockEntity> implements BlastFurnace {

    public CraftBlastFurnace(World world, BlastFurnaceBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftBlastFurnace(CraftBlastFurnace state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftBlastFurnace copy() {
        return new CraftBlastFurnace(this, null);
    }

    @Override
    public @NonNull CraftBlastFurnace copy(@NonNull Location location) {
        return new CraftBlastFurnace(this, location);
    }
}
