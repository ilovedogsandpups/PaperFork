package org.bukkit.craftbukkit.craftUtils.util;

import org.jspecify.annotations.NullMarked;

@NullMarked
public interface Handleable<M> {

    M getHandle();
}
