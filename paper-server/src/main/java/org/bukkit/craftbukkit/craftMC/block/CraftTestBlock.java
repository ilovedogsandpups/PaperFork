package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.TestBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.TestBlock;
import org.jspecify.annotations.NonNull;

public class CraftTestBlock extends CraftBlockEntityState<TestBlockEntity> implements TestBlock {

    public CraftTestBlock(World world, TestBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftTestBlock(CraftTestBlock state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftTestBlock copy() {
        return new CraftTestBlock(this, null);
    }

    @Override
    public @NonNull CraftTestBlock copy(@NonNull Location location) {
        return new CraftTestBlock(this, location);
    }
}
