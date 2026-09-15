package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Smoker;
import org.jspecify.annotations.NonNull;

public class CraftSmoker extends CraftFurnace<SmokerBlockEntity> implements Smoker {

    public CraftSmoker(World world, SmokerBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftSmoker(CraftSmoker state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftSmoker copy() {
        return new CraftSmoker(this, null);
    }

    @Override
    public @NonNull CraftSmoker copy(@NonNull Location location) {
        return new CraftSmoker(this, location);
    }
}
