package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Donkey;
import org.bukkit.entity.Horse.Variant;
import org.jspecify.annotations.NonNull;

public class CraftDonkey extends CraftChestedHorse implements Donkey {

    public CraftDonkey(CraftServer server, net.minecraft.world.entity.animal.equine.Donkey entity) {
        super(server, entity);
    }

    @Override
    public @NonNull Variant getVariant() {
        return Variant.DONKEY;
    }
}
