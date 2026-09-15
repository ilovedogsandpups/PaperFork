package org.bukkit.craftbukkit.craftMC.entity;

import com.google.common.base.Preconditions;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Parrot;
import org.jspecify.annotations.NonNull;

public class CraftParrot extends CraftTameableAnimal implements Parrot {

    public CraftParrot(CraftServer server, net.minecraft.world.entity.animal.parrot.Parrot parrot) {
        super(server, parrot);
    }

    @Override
    public net.minecraft.world.entity.animal.parrot.Parrot getHandle() {
        return (net.minecraft.world.entity.animal.parrot.Parrot) this.entity;
    }

    @Override
    public @NonNull Variant getVariant() {
        return Variant.values()[this.getHandle().getVariant().ordinal()];
    }

    @Override
    public void setVariant(Variant variant) {
        Preconditions.checkArgument(variant != null, "variant cannot be null");

        this.getHandle().setVariant(net.minecraft.world.entity.animal.parrot.Parrot.Variant.byId(variant.ordinal()));
    }

    @Override
    public boolean isDancing() {
        return this.getHandle().isPartyParrot();
    }
}
