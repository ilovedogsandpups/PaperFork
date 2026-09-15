package com.destroystokyo.paper.network;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.CachedServerIcon;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nullable;

class PaperServerListPingEventImpl extends PaperServerListPingEvent {

    private final MinecraftServer server;

    PaperServerListPingEventImpl(MinecraftServer server, StatusClient client, int protocolVersion, @Nullable CachedServerIcon icon) {
        super(client, server.motd(), server.getPlayerCount(), server.getMaxPlayers(),
                server.getServerModName() + ' ' + server.getServerVersion(), protocolVersion, icon);
        this.server = server;
    }

    @Override
    protected final Object @NonNull [] getOnlinePlayers() {
        return this.server.getPlayerList().getPlayers().toArray();
    }

    @Override
    protected final @NonNull Player getBukkitPlayer(@NonNull Object player) {
        return ((ServerPlayer) player).getBukkitEntity();
    }

}
