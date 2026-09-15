package org.bukkit.craftbukkit.craftMC.entity.boat;

import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftMC.entity.CraftBoat;
import org.bukkit.entity.boat.MangroveBoat;

public class CraftMangroveBoat extends CraftBoat implements MangroveBoat {

    public CraftMangroveBoat(CraftServer server, AbstractBoat entity) {
        super(server, entity);
    }
}
