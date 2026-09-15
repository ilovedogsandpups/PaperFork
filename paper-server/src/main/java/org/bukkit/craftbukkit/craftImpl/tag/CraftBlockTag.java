package org.bukkit.craftbukkit.craftImpl.tag;

import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.bukkit.Material;
import org.bukkit.craftbukkit.craftMC.block.CraftBlockType;
import org.jspecify.annotations.NonNull;

public class CraftBlockTag extends CraftTag<Block, Material> {

    public CraftBlockTag(Registry<Block> registry, TagKey<Block> tag) {
        super(registry, tag);
    }

    @Override
    public boolean isTagged(@NonNull Material item) {
        Block block = CraftBlockType.bukkitToMinecraft(item);

        // SPIGOT-6952: A Material is not necessary a block, in this case return false
        if (block == null) {
            return false;
        }

        return block.builtInRegistryHolder().is(this.tag);
    }

    @Override
    public @NonNull Set<Material> getValues() {
        return this.getHandle().stream().map((block) -> CraftBlockType.minecraftToBukkit(block.value())).collect(Collectors.toUnmodifiableSet());
    }
}
