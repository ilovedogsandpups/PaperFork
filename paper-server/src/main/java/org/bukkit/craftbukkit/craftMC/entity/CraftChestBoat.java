package org.bukkit.craftbukkit.craftMC.entity;

import net.minecraft.world.entity.vehicle.boat.AbstractChestBoat;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftInventory;
import org.bukkit.inventory.Inventory;
import org.jspecify.annotations.NonNull;

public abstract class CraftChestBoat extends CraftBoat implements org.bukkit.entity.ChestBoat, com.destroystokyo.paper.loottable.PaperLootableEntityInventory { // Paper

    public CraftChestBoat(CraftServer server, AbstractChestBoat entity) {
        super(server, entity);
    }

    @Override
    public AbstractChestBoat getHandle() {
        return (AbstractChestBoat) this.entity;
    }

    @Override
    public @NonNull Inventory getInventory() {
        return new CraftInventory(getHandle());
    }
}
