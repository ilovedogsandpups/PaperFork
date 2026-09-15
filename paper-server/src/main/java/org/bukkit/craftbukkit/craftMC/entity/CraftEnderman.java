package org.bukkit.craftbukkit.craftMC.entity;

import com.google.common.base.Preconditions;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftMC.block.data.CraftBlockData;
import org.bukkit.craftbukkit.craftUtils.util.CraftMagicNumbers;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.material.MaterialData;
import org.jspecify.annotations.NonNull;

public class CraftEnderman extends CraftMonster implements Enderman {

    public CraftEnderman(CraftServer server, EnderMan entity) {
        super(server, entity);
    }

    @Override
    public EnderMan getHandle() {
        return (EnderMan) this.entity;
    }

    @Override
    public boolean teleportRandomly() {
        return getHandle().teleport();
    }

    @Override
    public @NonNull MaterialData getCarriedMaterial() {
        BlockState carried = this.getHandle().getCarriedBlock();
        return (carried == null) ? Material.AIR.getNewData((byte) 0) : CraftMagicNumbers.getMaterial(carried);
    }

    @Override
    public BlockData getCarriedBlock() {
        BlockState carried = this.getHandle().getCarriedBlock();
        return (carried == null) ? null : carried.asBlockData();
    }

    @Override
    public void setCarriedMaterial(@NonNull MaterialData data) {
        this.getHandle().setCarriedBlock(CraftMagicNumbers.getBlock(data));
    }

    @Override
    public void setCarriedBlock(BlockData blockData) {
        this.getHandle().setCarriedBlock(blockData == null ? null : ((CraftBlockData) blockData).getState());
    }

    @Override
    public boolean isScreaming() {
        return this.getHandle().isCreepy();
    }

    @Override
    public void setScreaming(boolean screaming) {
        this.getHandle().setCreepy(screaming);
    }

    @Override
    public boolean hasBeenStaredAt() {
        return this.getHandle().hasBeenStaredAt();
    }

    @Override
    public void setHasBeenStaredAt(boolean hasBeenStaredAt) {
        this.getHandle().setHasBeenStaredAt(hasBeenStaredAt);
    }

    @Override
    public boolean teleport() {
        return this.getHandle().teleport();
    }

    @Override
    public boolean teleportTowards(@NonNull Entity entity) {
        Preconditions.checkArgument(entity != null, "entity cannot be null");

        return this.getHandle().teleportTowards(((CraftEntity) entity).getHandle());
    }
}
