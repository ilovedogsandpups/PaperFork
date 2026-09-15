package org.bukkit.craftbukkit.craftMC.block;

import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Jigsaw;
import org.jspecify.annotations.NonNull;

public class CraftJigsaw extends CraftBlockEntityState<JigsawBlockEntity> implements Jigsaw {

    public CraftJigsaw(World world, JigsawBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftJigsaw(CraftJigsaw state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftJigsaw copy() {
        return new CraftJigsaw(this, null);
    }

    @Override
    public @NonNull CraftJigsaw copy(@NonNull Location location) {
        return new CraftJigsaw(this, location);
    }
}
