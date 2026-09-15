package org.bukkit.craftbukkit.craftMC.boss;

import net.minecraft.server.bossevents.CustomBossEvent;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.craftbukkit.craftUtils.util.CraftNamespacedKey;
import org.jspecify.annotations.NonNull;

public class CraftKeyedBossbar extends CraftBossBar implements KeyedBossBar {

    public CraftKeyedBossbar(CustomBossEvent bossBattleCustom) {
        super(bossBattleCustom);
    }

    @Override
    public @NonNull NamespacedKey getKey() {
        return CraftNamespacedKey.fromMinecraft(this.getHandle().customId());
    }

    @Override
    public CustomBossEvent getHandle() {
        return (CustomBossEvent) super.getHandle();
    }
}
