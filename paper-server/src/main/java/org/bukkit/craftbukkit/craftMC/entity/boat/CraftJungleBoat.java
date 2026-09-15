package org.bukkit.craftbukkit.craftMC.entity.boat;

import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftMC.entity.CraftBoat;
import org.bukkit.entity.boat.JungleBoat;

public class CraftJungleBoat extends CraftBoat implements JungleBoat {

    public CraftJungleBoat(CraftServer server, AbstractBoat entity) {
        super(server, entity);
    }
}
