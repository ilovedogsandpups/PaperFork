package org.spigotmc;

import net.minecraft.server.MinecraftServer;

public final class AsyncGuard {
    private AsyncGuard() {}
    public static void catchOperation(String reason) {
        if (!ca.spottedleaf.moonrise.common.util.TickThread.isTickThread()) { // Paper - chunk system
            MinecraftServer.LOGGER.error("Thread {} failed main thread check: {}", Thread.currentThread().getName(), reason, new Throwable()); // Paper
            throw new IllegalStateException("Asynchronous " + reason + "!");
        }
    }
}
