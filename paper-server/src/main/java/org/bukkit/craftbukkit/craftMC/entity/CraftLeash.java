package org.bukkit.craftbukkit.craftMC.entity;

import com.google.common.base.Preconditions;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.LeashHitch;
import org.jspecify.annotations.NonNull;

public class CraftLeash extends CraftBlockAttachedEntity implements LeashHitch {

    public CraftLeash(CraftServer server, LeashFenceKnotEntity entity) {
        super(server, entity);
    }

    @Override
    public LeashFenceKnotEntity getHandle() {
        return (LeashFenceKnotEntity) this.entity;
    }

    @Override
    public boolean setFacingDirection(@NonNull BlockFace face, boolean force) {
        Preconditions.checkArgument(face == BlockFace.SELF, "%s is not a valid facing direction", face);

        return force || this.getHandle().generation || this.getHandle().survives();
    }

    @Override
    public @NonNull BlockFace getFacing() {
        // Leash hitch has no facing direction, so we return self
        return BlockFace.SELF;
    }

    @Override
    public @NonNull BlockFace getAttachedFace() {
        // Leash hitch has no facing direction, so we return self
        return BlockFace.SELF;
    }

    @Override
    public void setFacingDirection(@NonNull BlockFace face) {
        // Leash hitch has no facing direction
    }
}
