package org.bukkit.craftbukkit.craftImpl.command;

import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.conversations.ManuallyAbandonedConversationCanceller;
import org.bukkit.craftbukkit.craftOthers.conversations.ConversationTracker;
import org.jspecify.annotations.NonNull;

/**
 * Represents CLI input from a console
 */
public class CraftConsoleCommandSender extends ServerCommandSender implements ConsoleCommandSender {

    protected final ConversationTracker conversationTracker = new ConversationTracker();

    protected CraftConsoleCommandSender() {
        super();
    }

    @Override
    public void sendMessage(@NonNull String message) {
        this.sendRawMessage(message);
    }

    @Override
    public void sendRawMessage(@NonNull String message) {
        System.out.println(ChatColor.stripColor(message));
    }

    @Override
    public void sendRawMessage(UUID sender, @NonNull String message) {
      this.sendRawMessage(message); // Console doesn't know of senders
    }

    @Override
    public void sendMessage(String... messages) {
        for (String message : messages) {
            this.sendMessage(message);
        }
    }

    @Override
    public @NonNull String getName() {
        return "CONSOLE";
    }

    @Override
    public net.kyori.adventure.text.@NonNull Component name() {
        return net.kyori.adventure.text.Component.text(this.getName());
    }

    @Override
    public boolean isOp() {
        return true;
    }

    @Override
    public void setOp(boolean value) {
        throw new UnsupportedOperationException("Cannot change operator status of server console");
    }

    @Override
    public boolean beginConversation(@NonNull Conversation conversation) {
        return this.conversationTracker.beginConversation(conversation);
    }

    @Override
    public void abandonConversation(@NonNull Conversation conversation) {
        this.conversationTracker.abandonConversation(conversation, new ConversationAbandonedEvent(conversation, new ManuallyAbandonedConversationCanceller()));
    }

    @Override
    public void abandonConversation(@NonNull Conversation conversation, @NonNull ConversationAbandonedEvent details) {
        this.conversationTracker.abandonConversation(conversation, details);
    }

    @Override
    public void acceptConversationInput(@NonNull String input) {
        this.conversationTracker.acceptConversationInput(input);
    }

    @Override
    public boolean isConversing() {
        return this.conversationTracker.isConversing();
    }

    @Override
    public void sendMessage(final net.kyori.adventure.text.@NonNull Component message) {
        this.sendRawMessage(net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.legacySection().serialize(message));
    }

    @Override
    public boolean hasPermission(@NonNull String name) {
        return io.papermc.paper.configuration.GlobalConfiguration.get().console.hasAllPermissions || super.hasPermission(name);
    }

    @Override
    public boolean hasPermission(org.bukkit.permissions.@NonNull Permission perm) {
        return io.papermc.paper.configuration.GlobalConfiguration.get().console.hasAllPermissions || super.hasPermission(perm);
    }
}
