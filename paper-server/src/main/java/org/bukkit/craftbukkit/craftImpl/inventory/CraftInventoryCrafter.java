package org.bukkit.craftbukkit.craftImpl.inventory;

import net.minecraft.world.Container;
import org.bukkit.inventory.CrafterInventory;

public class CraftInventoryCrafter extends CraftResultInventory implements CrafterInventory {

    public CraftInventoryCrafter(Container inventory, Container resultInventory) {
        super(inventory, resultInventory);
    }
}
