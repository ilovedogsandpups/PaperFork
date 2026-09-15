package io.papermc.paper.connection;

import java.util.Set;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jspecify.annotations.NonNull;

public class PaperPlayerGameConnection extends PaperCommonConnection<ServerGamePacketListenerImpl> implements PlayerGameConnection {

    public PaperPlayerGameConnection(final ServerGamePacketListenerImpl packetListener) {
        super(packetListener);
    }

    @Override
    public ClientInformation getClientInformation() {
        return this.packetListener.player.clientInformation();
    }

    @Override
    public void reenterConfiguration() {
        if (HorriblePlayerLoginEventHack.warnReenterConfiguration(this.packetListener.connection)) {
            return;
        }
        this.packetListener.switchToConfig();
    }

    @Override
    public @NonNull Player getPlayer() {
        return this.packetListener.getCraftPlayer();
    }

    @Override
    public void sendPluginMessage(final @NonNull Plugin source, final @NonNull String channel, final byte @NonNull [] message) {
        getPlayer().sendPluginMessage(source, channel, message);
    }

    @Override
    public @NonNull Set<String> getListeningPluginChannels() {
        return getPlayer().getListeningPluginChannels();
    }

    @Override
    public boolean isConnected() {
        return getPlayer().isConnected();
    }
}
