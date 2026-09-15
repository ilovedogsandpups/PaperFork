package org.bukkit.craftbukkit.craftMC.entity.boat;

import net.minecraft.world.entity.vehicle.boat.AbstractChestBoat;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftMC.entity.CraftChestBoat;
import org.bukkit.entity.boat.AcaciaChestBoat;

public class CraftAcaciaChestBoat extends CraftChestBoat implements AcaciaChestBoat {

    public CraftAcaciaChestBoat(CraftServer server, AbstractChestBoat entity) {
        super(server, entity);
    }
}
