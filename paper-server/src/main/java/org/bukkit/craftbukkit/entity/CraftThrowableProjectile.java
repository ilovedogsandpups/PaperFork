package org.bukkit.craftbukkit.entity;

import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.entity.ThrowableProjectile;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NonNull;

public abstract class CraftThrowableProjectile extends CraftProjectile implements ThrowableProjectile {

    public CraftThrowableProjectile(CraftServer server, ThrowableItemProjectile entity) {
        super(server, entity);
    }

    @Override
    public ThrowableItemProjectile getHandle() {
        return (ThrowableItemProjectile) this.entity;
    }

    @Override
    public @NonNull ItemStack getItem() {
        return CraftItemStack.asBukkitCopy(this.getHandle().getItem());
    }

    @Override
    public void setItem(@NonNull ItemStack item) {
        this.getHandle().setItem(CraftItemStack.asNMSCopy(item));
    }
}
