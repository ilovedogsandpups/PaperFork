package org.bukkit.craftbukkit.craftMC.entity;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Rabbit;
import org.jspecify.annotations.NonNull;

public class CraftRabbit extends CraftAnimals implements Rabbit {

    public CraftRabbit(CraftServer server, net.minecraft.world.entity.animal.rabbit.Rabbit entity) {
        super(server, entity);
    }

    @Override
    public net.minecraft.world.entity.animal.rabbit.Rabbit getHandle() {
        return (net.minecraft.world.entity.animal.rabbit.Rabbit) this.entity;
    }

    @Override
    public @NonNull Type getRabbitType() {
        return Type.values()[this.getHandle().getVariant().ordinal()];
    }

    @Override
    public void setRabbitType(Type type) {
        this.getHandle().setVariant(net.minecraft.world.entity.animal.rabbit.Rabbit.Variant.values()[type.ordinal()]);
    }

    @Override
    public void setMoreCarrotTicks(int ticks) {
        this.getHandle().moreCarrotTicks = ticks;
    }

    @Override
    public int getMoreCarrotTicks() {
        return this.getHandle().moreCarrotTicks;
    }
}
