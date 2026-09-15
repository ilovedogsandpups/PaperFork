package io.papermc.paper.entity;

import org.bukkit.Sound;
import org.bukkit.craftbukkit.craftImpl.sounds.CraftSound;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NonNull;

public interface PaperBucketable extends Bucketable {

    net.minecraft.world.entity.Bucketable getHandle();

    @Override
    default boolean isFromBucket() {
        return this.getHandle().fromBucket();
    }

    @Override
    default void setFromBucket(boolean fromBucket) {
        this.getHandle().setFromBucket(fromBucket);
    }

    @Override
    default @NonNull ItemStack getBaseBucketItem() {
        return CraftItemStack.asBukkitCopy(this.getHandle().getBucketItemStack());
    }

    @Override
    default @NonNull Sound getPickupSound() {
        return CraftSound.minecraftToBukkit(this.getHandle().getPickupSound());
    }
}
