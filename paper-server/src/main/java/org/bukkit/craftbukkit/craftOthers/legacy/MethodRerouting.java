package org.bukkit.craftbukkit.craftOthers.legacy;

import org.bukkit.craftbukkit.craftOthers.legacy.reroute.NotInBukkit;
import org.bukkit.event.entity.EntityCombustEvent;

public class MethodRerouting {

    @NotInBukkit
    public static int getDuration(EntityCombustEvent event) {
        return (int) event.getDuration();
    }
}
