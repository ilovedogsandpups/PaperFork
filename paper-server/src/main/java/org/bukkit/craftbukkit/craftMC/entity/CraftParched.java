package org.bukkit.craftbukkit.craftMC.entity;

import net.minecraft.world.entity.monster.skeleton.Parched;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Skeleton;
import org.jspecify.annotations.NonNull;

public class CraftParched extends CraftAbstractSkeleton implements org.bukkit.entity.Parched {
    public CraftParched(final CraftServer server, final Parched entity) {
        super(server, entity);
    }

    @Override
    public Parched getHandle() {
        return (Parched) this.entity;
    }

    @Override
    public Skeleton.@NonNull SkeletonType getSkeletonType() {
        return Skeleton.SkeletonType.PARCHED;
    }
}
