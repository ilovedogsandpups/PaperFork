package org.bukkit.craftbukkit.craftUtils.util;

import org.bukkit.Location;
import org.bukkit.generator.structure.Structure;
import org.bukkit.util.StructureSearchResult;
import org.jspecify.annotations.NonNull;

public record CraftStructureSearchResult(Structure structure, Location location) implements StructureSearchResult {

    @Override
    public @NonNull Structure getStructure() {
        return this.structure;
    }

    @Override
    public @NonNull Location getLocation() {
        return this.location;
    }
}
