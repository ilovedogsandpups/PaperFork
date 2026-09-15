package org.bukkit.craftbukkit.command;

import java.util.Set;
import java.util.UUID;
import net.minecraft.commands.CommandSourceStack;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ProxiedCommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.jspecify.annotations.NonNull;

public class ProxiedNativeCommandSender implements ProxiedCommandSender {

    private final CommandSourceStack orig;
    private final CommandSender caller;
    private final CommandSender callee;

    public ProxiedNativeCommandSender(CommandSourceStack orig, CommandSender caller, CommandSender callee) {
        this.orig = orig;
        this.caller = caller;
        this.callee = callee;
    }

    public CommandSourceStack getHandle() {
        return this.orig;
    }

    @Override
    public @NonNull CommandSender getCaller() {
        return this.caller;
    }

    @Override
    public @NonNull CommandSender getCallee() {
        return this.callee;
    }

    @Override
    public void sendMessage(@NonNull String message) {
        this.getCaller().sendMessage(message);
    }

    @Override
    public void sendMessage(String... messages) {
        this.getCaller().sendMessage(messages);
    }

    @Override
    public void sendMessage(UUID sender, @NonNull String message) {
        this.getCaller().sendMessage(sender, message);
    }

    @Override
    public void sendMessage(UUID sender, String... messages) {
        this.getCaller().sendMessage(sender, messages);
    }

    @Override
    public @NonNull Server getServer() {
        return this.getCallee().getServer();
    }

    @Override
    public @NonNull String getName() {
        return this.getCallee().getName();
    }

    @Override
    public net.kyori.adventure.text.@NonNull Component name() {
        return this.getCallee().name();
    }

    @Override
    public boolean isPermissionSet(@NonNull String name) {
        return this.getCaller().isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(@NonNull Permission perm) {
        return this.getCaller().isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(@NonNull String name) {
        return this.getCaller().hasPermission(name);
    }

    @Override
    public boolean hasPermission(@NonNull Permission perm) {
        return this.getCaller().hasPermission(perm);
    }

    @Override
    public @NonNull PermissionAttachment addAttachment(@NonNull Plugin plugin, @NonNull String name, boolean value) {
        return this.getCaller().addAttachment(plugin, name, value);
    }

    @Override
    public @NonNull PermissionAttachment addAttachment(@NonNull Plugin plugin) {
        return this.getCaller().addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(@NonNull Plugin plugin, @NonNull String name, boolean value, int ticks) {
        return this.getCaller().addAttachment(plugin, name, value, ticks);
    }

    @Override
    public PermissionAttachment addAttachment(@NonNull Plugin plugin, int ticks) {
        return this.getCaller().addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(@NonNull PermissionAttachment attachment) {
        this.getCaller().removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        this.getCaller().recalculatePermissions();
    }

    @Override
    public @NonNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return this.getCaller().getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return this.getCaller().isOp();
    }

    @Override
    public void setOp(boolean value) {
        this.getCaller().setOp(value);
    }

    @Override
    public org.bukkit.command.CommandSender.@NonNull Spigot spigot() {
        return this.getCaller().spigot();
    }
}
