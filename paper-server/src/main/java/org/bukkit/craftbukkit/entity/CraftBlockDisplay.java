package org.bukkit.craftbukkit.entity;

import com.google.common.base.Preconditions;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.block.data.CraftBlockData;
import org.bukkit.entity.BlockDisplay;
import org.jspecify.annotations.NonNull;

public class CraftBlockDisplay extends CraftDisplay implements BlockDisplay {

    public CraftBlockDisplay(CraftServer server, net.minecraft.world.entity.Display.BlockDisplay entity) {
        super(server, entity);
    }

    @Override
    public net.minecraft.world.entity.Display.BlockDisplay getHandle() {
        return (net.minecraft.world.entity.Display.BlockDisplay) this.entity;
    }

    @Override
    public @NonNull BlockData getBlock() {
        return this.getHandle().getBlockState().asBlockData();
    }

    @Override
    public void setBlock(@NonNull BlockData block) {
        Preconditions.checkArgument(block != null, "Block cannot be null");

        this.getHandle().setBlockState(((CraftBlockData) block).getState());
    }
}
