package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropperBlock;
import net.minecraft.world.level.block.entity.DropperBlockEntity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftInventory;
import org.bukkit.inventory.Inventory;
import org.jspecify.annotations.NonNull;

public class CraftDropper extends CraftLootable<DropperBlockEntity> implements Dropper {

    public CraftDropper(World world, DropperBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftDropper(CraftDropper state, Location location) {
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
    public void drop() {
        this.ensureNoWorldGeneration();
        Block block = this.getBlock();
        if (block.getType() == Material.DROPPER) {
            CraftWorld world = (CraftWorld) this.getWorld();

            ((DropperBlock) Blocks.DROPPER).dispenseFrom(world.getHandle(), this.getHandle(), this.getPosition());
        }
    }

    @Override
    public @NonNull CraftDropper copy() {
        return new CraftDropper(this, null);
    }

    @Override
    public @NonNull CraftDropper copy(@NonNull Location location) {
        return new CraftDropper(this, location);
    }
}
