package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.jspecify.annotations.NonNull;

public class CraftEndPortal extends CraftBlockEntityState<TheEndPortalBlockEntity> {

    public CraftEndPortal(World world, TheEndPortalBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftEndPortal(CraftEndPortal state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftEndPortal copy() {
        return new CraftEndPortal(this, null);
    }

    @Override
    public @NonNull CraftEndPortal copy(Location location) {
        return new CraftEndPortal(this, location);
    }
}
