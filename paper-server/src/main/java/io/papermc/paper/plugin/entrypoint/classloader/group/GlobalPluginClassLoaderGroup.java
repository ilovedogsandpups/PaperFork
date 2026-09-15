package io.papermc.paper.plugin.entrypoint.classloader.group;

import io.papermc.paper.plugin.provider.classloader.ClassLoaderAccess;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NonNull;

@ApiStatus.Internal
public class GlobalPluginClassLoaderGroup extends SimpleListPluginClassLoaderGroup {

    @Override
    public @NonNull ClassLoaderAccess getAccess() {
        return (v) -> true;
    }

    @Override
    public String toString() {
        return "GLOBAL:" + super.toString();
    }
}
