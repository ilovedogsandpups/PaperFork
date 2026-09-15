package org.bukkit.craftbukkit.craftImpl.generator;

import com.google.common.base.Preconditions;
import com.mojang.serialization.MapCodec;
import java.util.stream.Stream;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import org.bukkit.craftbukkit.craftMC.block.CraftBiome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.jspecify.annotations.NonNull;

public class CustomWorldChunkManager extends BiomeSource {

    private final WorldInfo worldInfo;
    private final BiomeProvider biomeProvider;
    public final BiomeSource vanillaBiomeSource;

    public CustomWorldChunkManager(WorldInfo worldInfo, BiomeProvider biomeProvider, BiomeSource vanillaBiomeSource) {
        this.worldInfo = worldInfo;
        this.biomeProvider = biomeProvider;
        this.vanillaBiomeSource = vanillaBiomeSource;
    }

    @Override
    protected @NonNull MapCodec<? extends BiomeSource> codec() {
        throw new UnsupportedOperationException("Cannot serialize CustomWorldChunkManager");
    }

    @Override
    public @NonNull Holder<net.minecraft.world.level.biome.Biome> getNoiseBiome(int x, int y, int z, Climate.@NonNull Sampler noise) {
        Holder<net.minecraft.world.level.biome.Biome> biome = CraftBiome.bukkitToMinecraftHolder(
            this.biomeProvider.getBiome(this.worldInfo, QuartPos.toBlock(x), QuartPos.toBlock(y), QuartPos.toBlock(z), CraftBiomeParameterPoint.createBiomeParameterPoint(noise, noise.sample(x, y, z)))
        );
        Preconditions.checkArgument(biome != null, "Cannot set the biome to %s", biome);

        return biome;
    }

    @Override
    protected @NonNull Stream<Holder<net.minecraft.world.level.biome.Biome>> collectPossibleBiomes() {
        return this.biomeProvider.getBiomes(this.worldInfo).stream().map(biome -> {
            Holder<net.minecraft.world.level.biome.Biome> b = CraftBiome.bukkitToMinecraftHolder(biome);
            Preconditions.checkArgument(b != null, "Cannot use the biome %s", biome);
            return b;
        });
    }
}
