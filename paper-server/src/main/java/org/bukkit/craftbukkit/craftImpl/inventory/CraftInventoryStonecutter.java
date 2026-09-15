package org.bukkit.craftbukkit.craftImpl.inventory;

import net.minecraft.world.Container;
import org.bukkit.inventory.StonecutterInventory;

public class CraftInventoryStonecutter extends CraftResultInventory implements StonecutterInventory {

    public CraftInventoryStonecutter(Container inventory, Container resultInventory) {
        super(inventory, resultInventory);
    }
}
