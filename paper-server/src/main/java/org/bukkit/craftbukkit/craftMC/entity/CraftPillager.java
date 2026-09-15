package org.bukkit.craftbukkit.craftMC.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftInventory;
import org.bukkit.entity.Pillager;
import org.bukkit.inventory.Inventory;
import org.jspecify.annotations.NonNull;

public class CraftPillager extends CraftIllager implements Pillager, com.destroystokyo.paper.entity.CraftRangedEntity<net.minecraft.world.entity.monster.illager.Pillager> { // Paper

    public CraftPillager(CraftServer server, net.minecraft.world.entity.monster.illager.Pillager entity) {
        super(server, entity);
    }

    @Override
    public net.minecraft.world.entity.monster.illager.Pillager getHandle() {
        return (net.minecraft.world.entity.monster.illager.Pillager) this.entity;
    }

    @Override
    public @NonNull Inventory getInventory() {
        return new CraftInventory(this.getHandle().getInventory());
    }
}
