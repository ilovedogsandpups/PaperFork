package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BrewingStand;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftInventoryBrewer;
import org.bukkit.inventory.BrewerInventory;
import org.jspecify.annotations.NonNull;

public class CraftBrewingStand extends CraftContainer<BrewingStandBlockEntity> implements BrewingStand {

    public CraftBrewingStand(World world, BrewingStandBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftBrewingStand(CraftBrewingStand state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull BrewerInventory getSnapshotInventory() {
        return new CraftInventoryBrewer(this.getSnapshot());
    }

    @Override
    public @NonNull BrewerInventory getInventory() {
        if (!this.isPlaced()) {
            return this.getSnapshotInventory();
        }

        return new CraftInventoryBrewer(this.getBlockEntity());
    }

    @Override
    public int getBrewingTime() {
        return this.getSnapshot().brewTime;
    }

    @Override
    public void setBrewingTime(int brewTime) {
        this.getSnapshot().brewTime = brewTime;
    }

    // Paper start - Add recipeBrewTime
    @Override
    public void setRecipeBrewTime(int recipeBrewTime) {
        com.google.common.base.Preconditions.checkArgument(recipeBrewTime > 0, "recipeBrewTime must be positive");
        this.getSnapshot().recipeBrewTime = recipeBrewTime;
    }

    @Override
    public int getRecipeBrewTime() {
        return this.getSnapshot().recipeBrewTime;
    }
    // Paper end - Add recipeBrewTime

    @Override
    public int getFuelLevel() {
        return this.getSnapshot().fuel;
    }

    @Override
    public void setFuelLevel(int level) {
        this.getSnapshot().fuel = level;
    }

    @Override
    public @NonNull CraftBrewingStand copy() {
        return new CraftBrewingStand(this, null);
    }

    @Override
    public @NonNull CraftBrewingStand copy(@NonNull Location location) {
        return new CraftBrewingStand(this, location);
    }
}
