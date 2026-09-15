package org.bukkit.craftbukkit.craftImpl.help;

import org.bukkit.command.MultipleCommandAlias;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.HelpTopicFactory;
import org.jspecify.annotations.NonNull;

/**
 * This class creates {@link MultipleCommandAliasHelpTopic} help topics from {@link MultipleCommandAlias} commands.
 */
public class MultipleCommandAliasHelpTopicFactory implements HelpTopicFactory<MultipleCommandAlias> {

    @Override
    public HelpTopic createTopic(@NonNull MultipleCommandAlias multipleCommandAlias) {
        return new MultipleCommandAliasHelpTopic(multipleCommandAlias);
    }
}
