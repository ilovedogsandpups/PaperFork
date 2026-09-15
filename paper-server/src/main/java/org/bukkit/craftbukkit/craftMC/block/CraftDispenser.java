package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftInventory;
import org.bukkit.craftbukkit.craftImpl.projectiles.CraftBlockProjectileSource;
import org.bukkit.inventory.Inventory;
import org.bukkit.projectiles.BlockProjectileSource;
import org.jspecify.annotations.NonNull;

public class CraftDispenser extends CraftLootable<DispenserBlockEntity> implements Dispenser {

    public CraftDispenser(World world, DispenserBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftDispenser(CraftDispenser state, Location location) {
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
    public BlockProjectileSource getBlockProjectileSource() {
        Block block = this.getBlock();

        if (block.getType() != Material.DISPENSER) {
            return null;
        }

        return new CraftBlockProjectileSource((DispenserBlockEntity) this.getBlockEntityFromWorld());
    }

    @Override
    public boolean dispense() {
        this.ensureNoWorldGeneration();
        Block block = this.getBlock();
        if (block.getType() == Material.DISPENSER) {
            CraftWorld world = (CraftWorld) this.getWorld();

            ((DispenserBlock) Blocks.DISPENSER).dispenseFrom(world.getHandle(), this.getHandle(), this.getPosition());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public @NonNull CraftDispenser copy() {
        return new CraftDispenser(this, null);
    }

    @Override
    public @NonNull CraftDispenser copy(@NonNull Location location) {
        return new CraftDispenser(this, location);
    }
}
