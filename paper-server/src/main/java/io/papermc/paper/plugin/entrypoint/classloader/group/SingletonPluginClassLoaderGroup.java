package io.papermc.paper.plugin.entrypoint.classloader.group;

import io.papermc.paper.plugin.provider.classloader.ClassLoaderAccess;
import io.papermc.paper.plugin.provider.classloader.ConfiguredPluginClassLoader;
import io.papermc.paper.plugin.provider.classloader.PluginClassLoaderGroup;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

@ApiStatus.Internal
public class SingletonPluginClassLoaderGroup implements PluginClassLoaderGroup {

    private final ConfiguredPluginClassLoader configuredPluginClassLoader;
    private final Access access;

    public SingletonPluginClassLoaderGroup(ConfiguredPluginClassLoader configuredPluginClassLoader) {
        this.configuredPluginClassLoader = configuredPluginClassLoader;
        this.access = new Access();
    }

    @Override
    public @Nullable Class<?> getClassByName(@NonNull String name, boolean resolve, @NonNull ConfiguredPluginClassLoader requester) {
        try {
            return this.configuredPluginClassLoader.loadClass(name, resolve, false, true);
        } catch (ClassNotFoundException ignored) {
        }

        return null;
    }

    @Override
    public void remove(@NonNull ConfiguredPluginClassLoader configuredPluginClassLoader) {
    }

    @Override
    public void add(@NonNull ConfiguredPluginClassLoader configuredPluginClassLoader) {
    }

    @Override
    public @NonNull ClassLoaderAccess getAccess() {
        return this.access;
    }

    @ApiStatus.Internal
    private class Access implements ClassLoaderAccess {

        @Override
        public boolean canAccess(@NonNull ConfiguredPluginClassLoader classLoader) {
            return SingletonPluginClassLoaderGroup.this.configuredPluginClassLoader == classLoader;
        }

    }

    @Override
    public String toString() {
        return "SingletonPluginClassLoaderGroup{" +
            "configuredPluginClassLoader=" + this.configuredPluginClassLoader +
            ", access=" + this.access +
            '}';
    }
}
