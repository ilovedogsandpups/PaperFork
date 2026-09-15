package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.piston.PistonMovingBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.jspecify.annotations.NonNull;

public class CraftMovingPiston extends CraftBlockEntityState<PistonMovingBlockEntity> implements io.papermc.paper.block.MovingPiston { // Paper - Add Moving Piston API

    public CraftMovingPiston(World world, PistonMovingBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftMovingPiston(CraftMovingPiston state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftMovingPiston copy() {
        return new CraftMovingPiston(this, null);
    }

    @Override
    public @NonNull CraftMovingPiston copy(@NonNull Location location) {
        return new CraftMovingPiston(this, location);
    }

    // Paper start - Add Moving Piston API
    @Override
    public org.bukkit.block.data.@NonNull BlockData getMovingBlock() {
        return this.getBlockEntity().getMovedState().asBlockData();
    }

    @Override
    public org.bukkit.block.@NonNull BlockFace getDirection() {
        return CraftBlock.notchToBlockFace(this.getBlockEntity().getDirection());
    }

    @Override
    public boolean isExtending() {
        return this.getBlockEntity().isExtending();
    }

    @Override
    public boolean isPistonHead() {
        return this.getBlockEntity().isSourcePiston();
    }
    // Paper end - Add Moving Piston API
}
