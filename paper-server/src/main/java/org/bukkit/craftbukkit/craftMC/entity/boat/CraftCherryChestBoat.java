package org.bukkit.craftbukkit.craftMC.entity.boat;

import net.minecraft.world.entity.vehicle.boat.AbstractChestBoat;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftMC.entity.CraftChestBoat;
import org.bukkit.entity.boat.CherryChestBoat;

public class CraftCherryChestBoat extends CraftChestBoat implements CherryChestBoat {

    public CraftCherryChestBoat(CraftServer server, AbstractChestBoat entity) {
        super(server, entity);
    }
}
