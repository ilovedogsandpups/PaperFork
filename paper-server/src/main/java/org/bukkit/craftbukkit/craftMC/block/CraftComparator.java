package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.ComparatorBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Comparator;
import org.jspecify.annotations.NonNull;

public class CraftComparator extends CraftBlockEntityState<ComparatorBlockEntity> implements Comparator {

    public CraftComparator(World world, ComparatorBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftComparator(CraftComparator state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftComparator copy() {
        return new CraftComparator(this, null);
    }

    @Override
    public @NonNull CraftComparator copy(@NonNull Location location) {
        return new CraftComparator(this, location);
    }
}
