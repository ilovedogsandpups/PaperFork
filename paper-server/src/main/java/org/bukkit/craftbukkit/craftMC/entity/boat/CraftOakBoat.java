package org.bukkit.craftbukkit.craftMC.entity.boat;

import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftMC.entity.CraftBoat;
import org.bukkit.entity.boat.OakBoat;

public class CraftOakBoat extends CraftBoat implements OakBoat {

    public CraftOakBoat(CraftServer server, AbstractBoat entity) {
        super(server, entity);
    }
}
