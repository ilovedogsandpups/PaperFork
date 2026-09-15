package org.bukkit.craftbukkit.metadata;

import org.bukkit.World;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataStoreBase;
import org.jspecify.annotations.NonNull;

/**
 * An WorldMetadataStore stores metadata values for {@link World} objects.
 */
public class WorldMetadataStore extends MetadataStoreBase<World> implements MetadataStore<World> {
    /**
     * Generates a unique metadata key for a {@link World} object based on the world UID.
     *
     * @param world the world
     * @param metadataKey The name identifying the metadata value
     * @return a unique metadata key
     * @see MetadataStoreBase#disambiguate(Object, String)
     */
    @Override
    protected @NonNull String disambiguate(World world, @NonNull String metadataKey) {
        return world.getUID().toString() + ":" + metadataKey;
    }
}
