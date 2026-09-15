package org.bukkit.craftbukkit.craftImpl.attribute;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.craftbukkit.craftImpl.CraftEquipmentSlot;
import org.bukkit.craftbukkit.craftOthers.util.CraftNamespacedKey;
import org.jspecify.annotations.NonNull;

public class CraftAttributeInstance implements AttributeInstance {

    private final net.minecraft.world.entity.ai.attributes.AttributeInstance handle;
    private final Attribute attribute;

    public CraftAttributeInstance(net.minecraft.world.entity.ai.attributes.AttributeInstance handle, Attribute attribute) {
        this.handle = handle;
        this.attribute = attribute;
    }

    @Override
    public @NonNull Attribute getAttribute() {
        return this.attribute;
    }

    @Override
    public double getBaseValue() {
        return this.handle.getBaseValue();
    }

    @Override
    public void setBaseValue(double d) {
        this.handle.setBaseValue(d);
    }

    @Override
    public @NonNull Collection<AttributeModifier> getModifiers() {
        List<AttributeModifier> result = new ArrayList<AttributeModifier>();
        for (net.minecraft.world.entity.ai.attributes.AttributeModifier nms : this.handle.getModifiers()) {
            result.add(CraftAttributeInstance.convert(nms));
        }

        return result;
    }

    @Override
    public AttributeModifier getModifier(final net.kyori.adventure.key.@NonNull Key key) {
        Preconditions.checkArgument(key != null, "Key cannot be null");
        net.minecraft.world.entity.ai.attributes.AttributeModifier modifier = this.handle.getModifier(io.papermc.paper.adventure.PaperAdventure.asVanilla(key));
        return modifier == null ? null : CraftAttributeInstance.convert(modifier);
    }

    @Override
    public void removeModifier(final net.kyori.adventure.key.@NonNull Key key) {
        Preconditions.checkArgument(key != null, "Key cannot be null");
        this.handle.removeModifier(io.papermc.paper.adventure.PaperAdventure.asVanilla(key));
    }

    @Override
    public AttributeModifier getModifier(java.util.@NonNull UUID uuid) {
        Preconditions.checkArgument(uuid != null, "UUID cannot be null");
        return this.getModifier(AttributeMappings.uuidToKey(uuid));
    }

    @Override
    public void removeModifier(java.util.@NonNull UUID uuid) {
        Preconditions.checkArgument(uuid != null, "UUID cannot be null");
        this.removeModifier(AttributeMappings.uuidToKey(uuid));
    }

    @Override
    public void addModifier(@NonNull AttributeModifier modifier) {
        Preconditions.checkArgument(modifier != null, "modifier");
        this.handle.addPermanentModifier(CraftAttributeInstance.convert(modifier));
    }

    @Override
    public void addTransientModifier(@NonNull AttributeModifier modifier) {
        Preconditions.checkArgument(modifier != null, "modifier");
        this.handle.addTransientModifier(CraftAttributeInstance.convert(modifier));
    }

    @Override
    public void removeModifier(@NonNull AttributeModifier modifier) {
        Preconditions.checkArgument(modifier != null, "modifier");
        this.handle.removeModifier(CraftAttributeInstance.convert(modifier));
    }

    @Override
    public double getValue() {
        return this.handle.getValue();
    }

    @Override
    public double getDefaultValue() {
       return this.handle.getAttribute().value().getDefaultValue();
    }

    public static net.minecraft.world.entity.ai.attributes.AttributeModifier convert(AttributeModifier bukkit) {
        return new net.minecraft.world.entity.ai.attributes.AttributeModifier(CraftNamespacedKey.toMinecraft(bukkit.getKey()), bukkit.getAmount(), net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.values()[bukkit.getOperation().ordinal()]);
    }

    public static AttributeModifier convert(net.minecraft.world.entity.ai.attributes.AttributeModifier nms) {
        return new AttributeModifier(CraftNamespacedKey.fromMinecraft(nms.id()), nms.amount(), AttributeModifier.Operation.values()[nms.operation().ordinal()], org.bukkit.inventory.EquipmentSlotGroup.ANY);
    }

    public static AttributeModifier convert(net.minecraft.world.entity.ai.attributes.AttributeModifier nms, net.minecraft.world.entity.EquipmentSlotGroup slot) { // Paper
        return new AttributeModifier(CraftNamespacedKey.fromMinecraft(nms.id()), nms.amount(), AttributeModifier.Operation.values()[nms.operation().ordinal()], CraftEquipmentSlot.getSlotGroup(slot)); // Paper
    }
}
