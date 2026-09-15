package org.bukkit.craftbukkit.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.Entity;
import org.jspecify.annotations.NonNull;

public class CraftEnderDragonPart extends CraftComplexPart implements EnderDragonPart {
    public CraftEnderDragonPart(CraftServer server, net.minecraft.world.entity.boss.enderdragon.EnderDragonPart entity) {
        super(server, entity);
    }

    @Override
    public @NonNull EnderDragon getParent() {
        return (EnderDragon) super.getParent();
    }

    @Override
    public void damage(double amount, @NonNull DamageSource damageSource) {
        this.getParent().damage(amount, damageSource);
    }

    @Override
    public void damage(double amount) {
        this.getParent().damage(amount);
    }

    @Override
    public void damage(double amount, Entity source) {
        this.getParent().damage(amount, source);
    }

    @Override
    public void kill(@NonNull DamageSource damageSource) {
        this.getParent().kill(damageSource);
    }

    @Override
    public double getHealth() {
        return this.getParent().getHealth();
    }

    @Override
    public void setHealth(double health) {
        this.getParent().setHealth(health);
    }

    @Override
    public void heal(final double amount, final org.bukkit.event.entity.EntityRegainHealthEvent.@NonNull RegainReason reason) {
        this.getParent().heal(amount, reason);
    }

    @Override
    public double getAbsorptionAmount() {
        return this.getParent().getAbsorptionAmount();
    }

    @Override
    public void setAbsorptionAmount(double amount) {
        this.getParent().setAbsorptionAmount(amount);
    }

    @Override
    public double getMaxHealth() {
        return this.getParent().getMaxHealth();
    }

    @Override
    public void setMaxHealth(double health) {
        this.getParent().setMaxHealth(health);
    }

    @Override
    public void resetMaxHealth() {
        this.getParent().resetMaxHealth();
    }
}
