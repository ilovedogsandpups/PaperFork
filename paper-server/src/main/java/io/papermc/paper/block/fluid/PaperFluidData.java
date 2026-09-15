package io.papermc.paper.block.fluid;

import com.google.common.base.Preconditions;
import io.papermc.paper.block.fluid.type.PaperFallingFluidData;
import io.papermc.paper.block.fluid.type.PaperFlowingFluidData;
import net.minecraft.world.level.material.FluidState;
import org.bukkit.Fluid;
import org.bukkit.Location;
import org.bukkit.craftbukkit.craftImpl.CraftFluid;
import org.bukkit.craftbukkit.craftImpl.worlds.CraftWorld;
import org.bukkit.craftbukkit.craftOthers.util.CraftLocation;
import org.bukkit.craftbukkit.craftOthers.util.CraftVector;
import org.bukkit.util.Vector;

public class PaperFluidData implements FluidData {

    private final FluidState state;

    protected PaperFluidData(final FluidState state) {
        this.state = state;
    }

    public FluidState getState() {
        return this.state;
    }

    @Override
    public final Fluid getFluidType() {
        return CraftFluid.minecraftToBukkit(this.state.getType());
    }

    @Override
    public PaperFluidData clone() {
        try {
            return (PaperFluidData) super.clone();
        } catch (final CloneNotSupportedException ex) {
            throw new AssertionError("Clone not supported", ex);
        }
    }

    @Override
    public Vector computeFlowDirection(final Location location) {
        Preconditions.checkArgument(location.getWorld() != null, "Cannot compute flow direction on world-less location");
        return CraftVector.toBukkit(this.state.getFlow(
            ((CraftWorld) location.getWorld()).getHandle(),
            CraftLocation.toBlockPos(location)
        ));
    }

    @Override
    public int getLevel() {
        return this.state.getAmount();
    }

    @Override
    public float computeHeight(final Location location) {
        Preconditions.checkArgument(location.getWorld() != null, "Cannot compute height on world-less location");
        return this.state.getHeight(((CraftWorld) location.getWorld()).getHandle(), CraftLocation.toBlockPos(location));
    }

    @Override
    public boolean isSource() {
        return this.state.isSource();
    }

    @Override
    public int hashCode() {
        return this.state.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof final PaperFluidData paperFluidData && this.state.equals(paperFluidData.state);
    }

    @Override
    public String toString() {
        return "PaperFluidData{" + this.state + "}";
    }

    public static PaperFluidData createData(final FluidState state) {
        if (state.isEmpty()) {
            return new PaperFluidData(state);
        }
        return state.isSource() ? new PaperFallingFluidData(state) : new PaperFlowingFluidData(state);
    }
}
