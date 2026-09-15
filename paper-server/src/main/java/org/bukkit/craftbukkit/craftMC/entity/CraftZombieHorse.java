package org.bukkit.craftbukkit.craftMC.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.ZombieHorse;
import org.jspecify.annotations.NonNull;

public class CraftZombieHorse extends CraftAbstractHorse implements ZombieHorse {

    public CraftZombieHorse(CraftServer server, net.minecraft.world.entity.animal.equine.ZombieHorse entity) {
        super(server, entity);
    }

    @Override
    public @NonNull Variant getVariant() {
        return Variant.UNDEAD_HORSE;
    }
}
