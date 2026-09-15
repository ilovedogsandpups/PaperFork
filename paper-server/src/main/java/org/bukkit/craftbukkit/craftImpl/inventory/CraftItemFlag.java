package org.bukkit.craftbukkit.craftImpl.inventory;

import com.google.common.base.Preconditions;
import org.bukkit.craftbukkit.craftOthers.legacy.FieldRename;
import org.bukkit.craftbukkit.craftOthers.util.ApiVersion;
import org.bukkit.inventory.ItemFlag;

public class CraftItemFlag {

    public static String bukkitToString(ItemFlag bukkit) {
        Preconditions.checkArgument(bukkit != null);

        return bukkit.name();
    }

    public static ItemFlag stringToBukkit(String string) {
        Preconditions.checkArgument(string != null);

        // We currently do not have any version-dependent remapping, so we can use current version
        string = FieldRename.convertItemFlagName(ApiVersion.CURRENT, string);
        return ItemFlag.valueOf(string);
    }
}
