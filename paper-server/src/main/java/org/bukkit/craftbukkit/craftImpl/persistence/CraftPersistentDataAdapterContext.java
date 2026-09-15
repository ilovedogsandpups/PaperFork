package org.bukkit.craftbukkit.craftImpl.persistence;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.jspecify.annotations.NonNull;

public final class CraftPersistentDataAdapterContext implements PersistentDataAdapterContext {

    private final CraftPersistentDataTypeRegistry registry;

    public CraftPersistentDataAdapterContext(CraftPersistentDataTypeRegistry registry) {
        this.registry = registry;
    }

    /**
     * Creates a new and empty tag container instance
     *
     * @return the fresh container instance
     */
    @Override
    public @NonNull CraftPersistentDataContainer newPersistentDataContainer() {
        return new CraftPersistentDataContainer(this.registry);
    }
}
