package org.bukkit.craftbukkit.craftMC.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Mule;
import org.jspecify.annotations.NonNull;

public class CraftMule extends CraftChestedHorse implements Mule {

    public CraftMule(CraftServer server, net.minecraft.world.entity.animal.equine.Mule entity) {
        super(server, entity);
    }

    @Override
    public @NonNull Variant getVariant() {
        return Variant.MULE;
    }
}
