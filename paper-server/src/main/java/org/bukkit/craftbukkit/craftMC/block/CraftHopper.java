package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.HopperBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Hopper;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftInventory;
import org.bukkit.inventory.Inventory;
import org.jspecify.annotations.NonNull;

public class CraftHopper extends CraftLootable<HopperBlockEntity> implements Hopper {

    public CraftHopper(World world, HopperBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftHopper(CraftHopper state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull Inventory getSnapshotInventory() {
        return new CraftInventory(this.getSnapshot());
    }

    @Override
    public @NonNull Inventory getInventory() {
        if (!this.isPlaced()) {
            return this.getSnapshotInventory();
        }

        return new CraftInventory(this.getBlockEntity());
    }

    @Override
    public @NonNull CraftHopper copy() {
        return new CraftHopper(this, null);
    }

    @Override
    public @NonNull CraftHopper copy(@NonNull Location location) {
        return new CraftHopper(this, location);
    }

    // Paper start - Expanded Hopper API
    @Override
    public void setTransferCooldown(final int cooldown) {
        com.google.common.base.Preconditions.checkArgument(cooldown >= 0, "Hooper transfer cooldown cannot be negative (" + cooldown + ")");
        getSnapshot().setCooldown(cooldown);
    }

    @Override
    public int getTransferCooldown() {
        return getSnapshot().cooldownTime;
    }
    // Paper end - Expanded Hopper API
}
