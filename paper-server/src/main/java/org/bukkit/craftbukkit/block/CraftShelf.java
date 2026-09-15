package org.bukkit.craftbukkit.block;

import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Shelf;
import org.bukkit.craftbukkit.inventory.CraftInventoryShelf;
import org.bukkit.inventory.ShelfInventory;
import org.jspecify.annotations.NonNull;

public class CraftShelf extends CraftBlockEntityState<ShelfBlockEntity> implements Shelf {

    public CraftShelf(World world, ShelfBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftShelf(CraftShelf state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull ShelfInventory getSnapshotInventory() {
        return new CraftInventoryShelf(this.getSnapshot());
    }

    @Override
    public @NonNull ShelfInventory getInventory() {
        if (!this.isPlaced()) {
            return this.getSnapshotInventory();
        }

        return new CraftInventoryShelf(this.getBlockEntity());
    }

    @Override
    public @NonNull CraftBlockEntityState<ShelfBlockEntity> copy() {
        return new CraftShelf(this, null);
    }

    @Override
    public @NonNull CraftBlockEntityState<ShelfBlockEntity> copy(final @NonNull Location location) {
        return new CraftShelf(this, location);
    }
}
