package org.bukkit.craftbukkit.craftMC.entity;

import net.minecraft.world.entity.Pose;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Camel;
import org.bukkit.entity.Horse;
import org.jspecify.annotations.NonNull;

public class CraftCamel extends CraftAbstractHorse implements Camel {

    public CraftCamel(CraftServer server, net.minecraft.world.entity.animal.camel.Camel entity) {
        super(server, entity);
    }

    @Override
    public net.minecraft.world.entity.animal.camel.Camel getHandle() {
        return (net.minecraft.world.entity.animal.camel.Camel) this.entity;
    }

    @Override
    public Horse.@NonNull Variant getVariant() {
        return Horse.Variant.CAMEL;
    }

    @Override
    public boolean isDashing() {
        return this.getHandle().isDashing();
    }

    @Override
    public void setDashing(boolean dashing) {
        this.getHandle().setDashing(dashing);
    }

    @Override
    public boolean isSitting() {
        return this.getHandle().getPose() == Pose.SITTING;
    }

    @Override
    public void setSitting(boolean sitting) {
        if (sitting) {
            this.getHandle().sitDown();
        } else {
            this.getHandle().standUp();
        }
    }
}
