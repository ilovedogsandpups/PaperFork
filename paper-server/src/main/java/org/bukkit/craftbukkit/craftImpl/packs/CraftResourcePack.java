package org.bukkit.craftbukkit.craftImpl.packs;

import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.bukkit.craftbukkit.craftOthers.util.CraftChatMessage;
import org.bukkit.packs.ResourcePack;
import org.jspecify.annotations.NonNull;

public class CraftResourcePack implements ResourcePack {

    private final MinecraftServer.ServerResourcePackInfo handle;

    public CraftResourcePack(MinecraftServer.ServerResourcePackInfo handle) {
        this.handle = handle;
    }

    @Override
    public @NonNull UUID getId() {
        return this.handle.id();
    }

    @Override
    public @NonNull String getUrl() {
        return this.handle.url();
    }

    @Override
    public String getHash() {
        return this.handle.hash();
    }

    @Override
    public String getPrompt() {
        return (this.handle.prompt() == null) ? "" : CraftChatMessage.fromComponent(this.handle.prompt());
    }

    @Override
    public boolean isRequired() {
        return this.handle.isRequired();
    }

    @Override
    public String toString() {
        return "CraftResourcePack{id=" + this.getId() + ",url=" + this.getUrl() + ",hash=" + this.getHash() + ",prompt=" + this.getPrompt() + ",required=" + this.isRequired() + "}";
    }
}
