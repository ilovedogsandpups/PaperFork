package org.bukkit.craftbukkit.craftMC.entity;

import net.minecraft.world.entity.vehicle.minecart.MinecartChest;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftInventory;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.inventory.Inventory;
import org.jspecify.annotations.NonNull;

public class CraftMinecartChest extends CraftMinecartContainer implements StorageMinecart, com.destroystokyo.paper.loottable.PaperLootableEntityInventory { // Paper

    public CraftMinecartChest(CraftServer server, MinecartChest entity) {
        super(server, entity);
    }

    @Override
    public @NonNull Inventory getInventory() {
        return new CraftInventory(getHandle());
    }
}
