package org.bukkit.craftbukkit.craftMC.entity;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.world.item.Item;
import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftInventory;
import org.bukkit.craftbukkit.craftImpl.inventory.CraftItemType;
import org.bukkit.entity.Piglin;
import org.bukkit.inventory.Inventory;
import org.jspecify.annotations.NonNull;

public class CraftPiglin extends CraftPiglinAbstract implements Piglin, com.destroystokyo.paper.entity.CraftRangedEntity<net.minecraft.world.entity.monster.piglin.Piglin> { // Paper

    public CraftPiglin(CraftServer server, net.minecraft.world.entity.monster.piglin.Piglin entity) {
        super(server, entity);
    }

    @Override
    public net.minecraft.world.entity.monster.piglin.Piglin getHandle() {
        return (net.minecraft.world.entity.monster.piglin.Piglin) this.entity;
    }

    @Override
    public boolean isAbleToHunt() {
        return !this.getHandle().cannotHunt;
    }

    @Override
    public void setIsAbleToHunt(boolean flag) {
        this.getHandle().cannotHunt = !flag;
    }

    @Override
    public boolean addBarterMaterial(@NonNull Material material) {
        Preconditions.checkArgument(material != null, "material cannot be null");

        Item item = CraftItemType.bukkitToMinecraft(material);
        return this.getHandle().allowedBarterItems.add(item);
    }

    @Override
    public boolean removeBarterMaterial(@NonNull Material material) {
        Preconditions.checkArgument(material != null, "material cannot be null");

        Item item = CraftItemType.bukkitToMinecraft(material);
        return this.getHandle().allowedBarterItems.remove(item);
    }

    @Override
    public boolean addMaterialOfInterest(@NonNull Material material) {
        Preconditions.checkArgument(material != null, "material cannot be null");

        Item item = CraftItemType.bukkitToMinecraft(material);
        return this.getHandle().interestItems.add(item);
    }

    @Override
    public boolean removeMaterialOfInterest(@NonNull Material material) {
        Preconditions.checkArgument(material != null, "material cannot be null");

        Item item = CraftItemType.bukkitToMinecraft(material);
        return this.getHandle().interestItems.remove(item);
    }

    @Override
    public @NonNull Set<Material> getInterestList() {
        return Collections.unmodifiableSet(this.getHandle().interestItems.stream().map(CraftItemType::minecraftToBukkit).collect(Collectors.toSet()));
    }

    @Override
    public @NonNull Set<Material> getBarterList() {
        return Collections.unmodifiableSet(this.getHandle().allowedBarterItems.stream().map(CraftItemType::minecraftToBukkit).collect(Collectors.toSet()));
    }

    @Override
    public @NonNull Inventory getInventory() {
        return new CraftInventory(this.getHandle().getInventory());
    }

    @Override
    public void setChargingCrossbow(boolean chargingCrossbow) {
        this.getHandle().setChargingCrossbow(chargingCrossbow);
    }

    @Override
    public boolean isChargingCrossbow() {
        return this.getHandle().isChargingCrossbow();
    }

    @Override
    public void setDancing(boolean dancing) {
        if (dancing) {
            this.getHandle().getBrain().setMemory(net.minecraft.world.entity.ai.memory.MemoryModuleType.DANCING, true);
            this.getHandle().getBrain().setMemory(net.minecraft.world.entity.ai.memory.MemoryModuleType.CELEBRATE_LOCATION, this.getHandle().getOnPos());
        } else {
            this.getHandle().getBrain().eraseMemory(net.minecraft.world.entity.ai.memory.MemoryModuleType.DANCING);
            this.getHandle().getBrain().eraseMemory(net.minecraft.world.entity.ai.memory.MemoryModuleType.CELEBRATE_LOCATION);
        }
    }

    @Override
    public void setDancing(long duration) {
        this.getHandle().getBrain().setMemoryWithExpiry(net.minecraft.world.entity.ai.memory.MemoryModuleType.DANCING, true, duration);
        this.getHandle().getBrain().setMemoryWithExpiry(net.minecraft.world.entity.ai.memory.MemoryModuleType.CELEBRATE_LOCATION, this.getHandle().getOnPos(), duration);
    }

    @Override
    public boolean isDancing() {
        return this.getHandle().isDancing();
    }
}
