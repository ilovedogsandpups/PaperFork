package com.destroystokyo.paper.block;

import net.minecraft.world.level.block.SoundType;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.craftUtils.sounds.CraftSound;
import org.jspecify.annotations.NonNull;

@Deprecated(forRemoval = true)
public class CraftBlockSoundGroup implements BlockSoundGroup {
    private final SoundType soundEffectType;

    public CraftBlockSoundGroup(SoundType soundEffectType) {
        this.soundEffectType = soundEffectType;
    }

    @Override
    public @NonNull Sound getBreakSound() {
        return CraftSound.minecraftToBukkit(soundEffectType.getBreakSound());
    }

    @Override
    public @NonNull Sound getStepSound() {
        return CraftSound.minecraftToBukkit(soundEffectType.getStepSound());
    }

    @Override
    public @NonNull Sound getPlaceSound() {
        return CraftSound.minecraftToBukkit(soundEffectType.getPlaceSound());
    }

    @Override
    public @NonNull Sound getHitSound() {
        return CraftSound.minecraftToBukkit(soundEffectType.getHitSound());
    }

    @Override
    public @NonNull Sound getFallSound() {
        return CraftSound.minecraftToBukkit(soundEffectType.getFallSound());
    }
}
