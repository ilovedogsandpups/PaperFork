package org.bukkit.craftbukkit;

import java.util.HashMap;
import net.minecraft.world.level.block.SoundType;
import org.bukkit.Sound;
import org.bukkit.SoundGroup;
import org.jspecify.annotations.NonNull;

public class CraftSoundGroup implements SoundGroup {

    private final net.minecraft.world.level.block.SoundType handle;
    private static final HashMap<SoundType, CraftSoundGroup> SOUND_GROUPS = new HashMap<>();

    public static SoundGroup getSoundGroup(SoundType soundEffectType) {
        return CraftSoundGroup.SOUND_GROUPS.computeIfAbsent(soundEffectType, CraftSoundGroup::new);
    }

    private CraftSoundGroup(net.minecraft.world.level.block.SoundType soundEffectType) {
        this.handle = soundEffectType;
    }

    public net.minecraft.world.level.block.SoundType getHandle() {
        return this.handle;
    }

    @Override
    public float getVolume() {
        return this.getHandle().getVolume();
    }

    @Override
    public float getPitch() {
        return this.getHandle().getPitch();
    }

    @Override
    public @NonNull Sound getBreakSound() {
        return CraftSound.minecraftToBukkit(this.getHandle().getBreakSound());
    }

    @Override
    public @NonNull Sound getStepSound() {
        return CraftSound.minecraftToBukkit(this.getHandle().getStepSound());
    }

    @Override
    public @NonNull Sound getPlaceSound() {
        return CraftSound.minecraftToBukkit(this.getHandle().getPlaceSound());
    }

    @Override
    public @NonNull Sound getHitSound() {
        return CraftSound.minecraftToBukkit(this.getHandle().getHitSound());
    }

    @Override
    public @NonNull Sound getFallSound() {
        return CraftSound.minecraftToBukkit(this.getHandle().getFallSound());
    }
}
