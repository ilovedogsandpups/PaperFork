package org.bukkit.craftbukkit.craftImpl.help;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.help.HelpTopic;
import org.jspecify.annotations.NonNull;

/**
 * This is a help topic implementation for general topics registered in the help.yml file.
 */
public class CustomHelpTopic extends HelpTopic {
    private final String permissionNode;

    public CustomHelpTopic(String name, String shortText, String fullText, String permissionNode) {
        this.permissionNode = permissionNode;
        this.name = name;
        this.shortText = shortText;
        this.fullText = shortText + "\n" + fullText;
    }

    @Override
    public boolean canSee(@NonNull CommandSender sender) {
        if (sender instanceof ConsoleCommandSender) {
            return true;
        }

        if (!this.permissionNode.isEmpty()) {
            return sender.hasPermission(this.permissionNode);
        } else {
            return true;
        }
    }
}
