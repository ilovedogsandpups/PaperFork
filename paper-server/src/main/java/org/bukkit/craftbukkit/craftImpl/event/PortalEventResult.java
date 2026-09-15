package org.bukkit.craftbukkit.craftImpl.event;

import org.bukkit.Location;

public record PortalEventResult(Location to, int searchRadius, int createRadius, boolean canCreatePortal) {
}
