package org.bukkit.craftbukkit.craftMC.entity.boat;

import net.minecraft.world.entity.vehicle.boat.AbstractChestBoat;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftMC.entity.CraftChestBoat;
import org.bukkit.entity.boat.MangroveChestBoat;

public class CraftMangroveChestBoat extends CraftChestBoat implements MangroveChestBoat {

    public CraftMangroveChestBoat(CraftServer server, AbstractChestBoat entity) {
        super(server, entity);
    }
}
