package org.bukkit.craftbukkit.craftImpl.command;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.craftbukkit.craftMC.block.CraftBlock;
import org.bukkit.craftbukkit.craftUtils.util.CraftChatMessage;
import org.bukkit.permissions.PermissibleBase;
import org.bukkit.permissions.ServerOperator;
import org.jspecify.annotations.NonNull;

/**
 * Represents input from a command block
 */
public class CraftBlockCommandSender extends ServerCommandSender implements BlockCommandSender {

    // For performance reasons, use one PermissibleBase for all command blocks.
    private static final PermissibleBase SHARED_PERM = new PermissibleBase(new ServerOperator() {

        @Override
        public boolean isOp() {
            return true;
        }

        @Override
        public void setOp(boolean value) {
            throw new UnsupportedOperationException("Cannot change operator status of a block");
        }
    });
    private final CommandSourceStack sourceStack;
    private final BlockEntity blockEntity;

    public CraftBlockCommandSender(CommandSourceStack sourceStack, BlockEntity blockEntity) {
        super(CraftBlockCommandSender.SHARED_PERM);
        this.sourceStack = sourceStack;
        this.blockEntity = blockEntity;
    }

    @Override
    public @NonNull Block getBlock() {
        return CraftBlock.at(this.blockEntity.getLevel(), this.blockEntity.getBlockPos());
    }

    @Override
    public void sendMessage(@NonNull String message) {
        for (Component component : CraftChatMessage.fromString(message)) {
            this.sourceStack.source.sendSystemMessage(component);
        }
    }

    @Override
    public void sendMessage(String... messages) {
        for (String message : messages) {
            this.sendMessage(message);
        }
    }

    @Override
    public @NonNull String getName() {
        return this.sourceStack.getTextName();
    }

    @Override
    public void sendMessage(final net.kyori.adventure.text.@NonNull Component message) {
        this.sourceStack.source.sendSystemMessage(io.papermc.paper.adventure.PaperAdventure.asVanilla(message));
    }

    @Override
    public net.kyori.adventure.text.@NonNull Component name() {
        return io.papermc.paper.adventure.PaperAdventure.asAdventure(this.sourceStack.getDisplayName());
    }

    @Override
    public boolean isOp() {
        return CraftBlockCommandSender.SHARED_PERM.isOp();
    }

    @Override
    public void setOp(boolean value) {
        CraftBlockCommandSender.SHARED_PERM.setOp(value);
    }

    public CommandSourceStack getSourceStack() {
        return this.sourceStack;
    }
}
