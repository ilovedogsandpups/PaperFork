package org.bukkit.craftbukkit.craftImpl.metadata;

import org.bukkit.OfflinePlayer;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataStoreBase;
import org.jspecify.annotations.NonNull;

/**
 * A PlayerMetadataStore stores metadata for {@link org.bukkit.entity.Player} and {@link OfflinePlayer} objects.
 */
public class PlayerMetadataStore extends MetadataStoreBase<OfflinePlayer> implements MetadataStore<OfflinePlayer> {
    /**
     * Generates a unique metadata key for {@link org.bukkit.entity.Player} and {@link OfflinePlayer} using the player
     * UUID.
     *
     * @param player the player
     * @param metadataKey The name identifying the metadata value
     * @return a unique metadata key
     * @see MetadataStoreBase#disambiguate(Object, String)
     */
    @Override
    protected @NonNull String disambiguate(OfflinePlayer player, @NonNull String metadataKey) {
        return player.getUniqueId() + ":" + metadataKey;
    }
}
