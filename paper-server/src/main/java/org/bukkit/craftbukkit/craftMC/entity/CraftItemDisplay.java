package org.bukkit.craftbukkit.craftMC.entity;

import com.google.common.base.Preconditions;
import net.minecraft.world.item.ItemDisplayContext;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftItemStack;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NonNull;

public class CraftItemDisplay extends CraftDisplay implements ItemDisplay {

    public CraftItemDisplay(CraftServer server, net.minecraft.world.entity.Display.ItemDisplay entity) {
        super(server, entity);
    }

    @Override
    public net.minecraft.world.entity.Display.ItemDisplay getHandle() {
        return (net.minecraft.world.entity.Display.ItemDisplay) this.entity;
    }

    @Override
    public @NonNull ItemStack getItemStack() {
        return CraftItemStack.asBukkitCopy(this.getHandle().getItemStack());
    }

    @Override
    public void setItemStack(ItemStack item) {
        this.getHandle().setItemStack(CraftItemStack.asNMSCopy(item));
    }

    @Override
    public @NonNull ItemDisplayTransform getItemDisplayTransform() {
        return ItemDisplayTransform.values()[this.getHandle().getItemTransform().ordinal()];
    }

    @Override
    public void setItemDisplayTransform(ItemDisplayTransform display) {
        Preconditions.checkArgument(display != null, "Display cannot be null");

        this.getHandle().setItemTransform(ItemDisplayContext.BY_ID.apply(display.ordinal()));
    }
}
