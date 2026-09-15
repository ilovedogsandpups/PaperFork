package org.bukkit.craftbukkit.entity;

import java.util.Set;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.vehicle.minecart.MinecartCommandBlock;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.util.CraftChatMessage;
import org.bukkit.entity.minecart.CommandMinecart;
import org.bukkit.permissions.PermissibleBase;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.jspecify.annotations.NonNull;

public class CraftMinecartCommand extends CraftMinecart implements CommandMinecart, io.papermc.paper.commands.PaperCommandBlockHolder {

    private final PermissibleBase perm = new PermissibleBase(this);

    public CraftMinecartCommand(CraftServer server, MinecartCommandBlock entity) {
        super(server, entity);
    }

    @Override
    public MinecartCommandBlock getHandle() {
        return (MinecartCommandBlock) this.entity;
    }

    @Override
    public @NonNull String getCommand() {
        return this.getHandle().getCommandBlock().getCommand();
    }

    @Override
    public void setCommand(String command) {
        this.getHandle().getCommandBlock().setCommand(command != null ? command : "");
        this.getHandle().getEntityData().set(MinecartCommandBlock.DATA_ID_COMMAND_NAME, this.getHandle().getCommandBlock().getCommand());
    }

    @Override
    public void setName(String name) {
        this.getHandle().getCommandBlock().setCustomName(CraftChatMessage.fromStringOrNull(name));
    }

    @Override
    public void sendMessage(@NonNull String message) {
    }

    @Override
    public void sendMessage(String... messages) {
    }

    @Override
    public @NonNull String getName() {
        return CraftChatMessage.fromComponent(this.getHandle().getCommandBlock().getName());
    }

    @Override
    public net.kyori.adventure.text.@org.jetbrains.annotations.NotNull Component name() {
        return io.papermc.paper.adventure.PaperAdventure.asAdventure(this.getHandle().getCommandBlock().getName());
    }

    @Override
    public net.minecraft.world.level.@NonNull BaseCommandBlock getCommandBlockHandle() {
        return this.getHandle().getCommandBlock();
    }

    @Override
    public void lastOutput(net.kyori.adventure.text.Component lastOutput) {
        io.papermc.paper.commands.PaperCommandBlockHolder.super.lastOutput(lastOutput);
        this.getCommandBlockHandle().onUpdated((ServerLevel) this.getHandle().level());
    }

    @Override
    public boolean isOp() {
        return true;
    }

    @Override
    public void setOp(boolean value) {
        throw new UnsupportedOperationException("Cannot change operator status of a minecart");
    }

    @Override
    public boolean isPermissionSet(@NonNull String name) {
        return this.perm.isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(@NonNull Permission perm) {
        return this.perm.isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(@NonNull String name) {
        return this.perm.hasPermission(name);
    }

    @Override
    public boolean hasPermission(@NonNull Permission perm) {
        return this.perm.hasPermission(perm);
    }

    @Override
    public @NonNull PermissionAttachment addAttachment(@NonNull Plugin plugin, @NonNull String name, boolean value) {
        return this.perm.addAttachment(plugin, name, value);
    }

    @Override
    public @NonNull PermissionAttachment addAttachment(@NonNull Plugin plugin) {
        return this.perm.addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(@NonNull Plugin plugin, @NonNull String name, boolean value, int ticks) {
        return this.perm.addAttachment(plugin, name, value, ticks);
    }

    @Override
    public PermissionAttachment addAttachment(@NonNull Plugin plugin, int ticks) {
        return this.perm.addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(@NonNull PermissionAttachment attachment) {
        this.perm.removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        this.perm.recalculatePermissions();
    }

    @Override
    public @NonNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return this.perm.getEffectivePermissions();
    }

    @Override
    public @NonNull Server getServer() {
        return Bukkit.getServer();
    }
}
