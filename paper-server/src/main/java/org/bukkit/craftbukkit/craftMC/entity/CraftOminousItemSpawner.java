package org.bukkit.craftbukkit.craftMC.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftItemStack;
import org.bukkit.entity.OminousItemSpawner;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NonNull;

public class CraftOminousItemSpawner extends CraftEntity implements OminousItemSpawner {

    public CraftOminousItemSpawner(CraftServer server, net.minecraft.world.entity.OminousItemSpawner entity) {
        super(server, entity);
    }

    @Override
    public net.minecraft.world.entity.OminousItemSpawner getHandle() {
        return (net.minecraft.world.entity.OminousItemSpawner) this.entity;
    }

    @Override
    public @NonNull ItemStack getItem() {
        return CraftItemStack.asBukkitCopy(this.getHandle().getItem());
    }

    @Override
    public void setItem(ItemStack item) {
        this.getHandle().setItem(CraftItemStack.asNMSCopy(item));
    }

    @Override
    public long getSpawnItemAfterTicks() {
        return this.getHandle().spawnItemAfterTicks;
    }

    @Override
    public void setSpawnItemAfterTicks(long ticks) {
        this.getHandle().spawnItemAfterTicks = ticks;
    }
}
