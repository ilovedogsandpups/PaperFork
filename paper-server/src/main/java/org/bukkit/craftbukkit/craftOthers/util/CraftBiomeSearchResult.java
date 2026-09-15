package org.bukkit.craftbukkit.craftOthers.util;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.util.BiomeSearchResult;
import org.jspecify.annotations.NonNull;

public record CraftBiomeSearchResult(Biome biome, Location location) implements BiomeSearchResult {

    @Override
    public @NonNull Biome getBiome() {
        return this.biome;
    }

    @Override
    public @NonNull Location getLocation() {
        return this.location;
    }
}
