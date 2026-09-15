package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.PotentSulfurBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.PotentSulfur;
import org.jspecify.annotations.NonNull;

public class CraftPotentSulfur extends CraftBlockEntityState<PotentSulfurBlockEntity> implements PotentSulfur {

    public CraftPotentSulfur(World world, PotentSulfurBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftPotentSulfur(CraftPotentSulfur state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftPotentSulfur copy() {
        return new CraftPotentSulfur(this, null);
    }

    @Override
    public @NonNull CraftPotentSulfur copy(@NonNull Location location) {
        return new CraftPotentSulfur(this, location);
    }
}
