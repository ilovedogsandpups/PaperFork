package org.bukkit.craftbukkit.entity;

import net.minecraft.world.entity.projectile.hurtingprojectile.Fireball;
import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.entity.SizedFireball;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NonNull;

public class CraftSizedFireball extends CraftFireball implements SizedFireball {

    public CraftSizedFireball(CraftServer server, Fireball entity) {
        super(server, entity);
    }

    @Override
    public Fireball getHandle() {
        return (Fireball) this.entity;
    }

    @Override
    public @NonNull ItemStack getDisplayItem() {
        if (this.getHandle().getItem().isEmpty()) {
            return new ItemStack(Material.FIRE_CHARGE);
        } else {
            return CraftItemStack.asBukkitCopy(this.getHandle().getItem());
        }
    }

    @Override
    public void setDisplayItem(@NonNull ItemStack item) {
        this.getHandle().setItem(CraftItemStack.asNMSCopy(item));
    }
}
