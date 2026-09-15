package org.bukkit.craftbukkit.block;

import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.HangingSign;
import org.jspecify.annotations.NonNull;

public class CraftHangingSign extends CraftSign<HangingSignBlockEntity> implements HangingSign {

    public CraftHangingSign(World world, HangingSignBlockEntity blockEntity) {
        super(world, blockEntity);
    }

    protected CraftHangingSign(CraftHangingSign state, Location location) {
        super(state, location);
    }

    @Override
    public @NonNull CraftHangingSign copy() {
        return new CraftHangingSign(this, null);
    }

    @Override
    public @NonNull CraftHangingSign copy(@NonNull Location location) {
        return new CraftHangingSign(this, location);
    }
}
