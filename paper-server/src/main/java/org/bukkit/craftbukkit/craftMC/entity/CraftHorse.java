package org.bukkit.craftbukkit.craftMC.entity;

import com.google.common.base.Preconditions;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.equine.Markings;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftInventoryHorse;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.HorseInventory;
import org.jspecify.annotations.NonNull;

public class CraftHorse extends CraftAbstractHorse implements Horse {

    public CraftHorse(CraftServer server, net.minecraft.world.entity.animal.equine.Horse entity) {
        super(server, entity);
    }

    @Override
    public net.minecraft.world.entity.animal.equine.Horse getHandle() {
        return (net.minecraft.world.entity.animal.equine.Horse) this.entity;
    }

    @Override
    public @NonNull Variant getVariant() {
        return Variant.HORSE;
    }

    @Override
    public @NonNull Color getColor() {
        return Color.values()[this.getHandle().getVariant().getId()];
    }

    @Override
    public void setColor(Color color) {
        Preconditions.checkArgument(color != null, "Color cannot be null");
        this.getHandle().setVariantAndMarkings(net.minecraft.world.entity.animal.equine.Variant.byId(color.ordinal()), this.getHandle().getMarkings());
    }

    @Override
    public @NonNull Style getStyle() {
        return Style.values()[this.getHandle().getMarkings().getId()];
    }

    @Override
    public void setStyle(Style style) {
        Preconditions.checkArgument(style != null, "Style cannot be null");
        this.getHandle().setVariantAndMarkings(this.getHandle().getVariant(), Markings.byId(style.ordinal()));
    }

    @Override
    public boolean isCarryingChest() {
        return false;
    }

    @Override
    public void setCarryingChest(boolean chest) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public @NonNull HorseInventory getInventory() {
        return new CraftInventoryHorse(this.getHandle().inventory,
            this.getHandle().createEquipmentSlotContainer(EquipmentSlot.BODY),
            this.getHandle().createEquipmentSlotContainer(EquipmentSlot.SADDLE)
        );
    }
}
