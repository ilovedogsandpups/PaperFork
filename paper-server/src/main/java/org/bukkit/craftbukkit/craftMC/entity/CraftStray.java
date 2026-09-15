package org.bukkit.craftbukkit.craftMC.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Stray;
import org.jspecify.annotations.NonNull;

public class CraftStray extends CraftAbstractSkeleton implements Stray {

    public CraftStray(CraftServer server, net.minecraft.world.entity.monster.skeleton.Stray entity) {
        super(server, entity);
    }

    @Override
    public @NonNull SkeletonType getSkeletonType() {
        return SkeletonType.STRAY;
    }
}
