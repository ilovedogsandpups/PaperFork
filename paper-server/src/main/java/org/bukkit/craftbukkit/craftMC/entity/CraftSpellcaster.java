package org.bukkit.craftbukkit.craftMC.entity;

import com.google.common.base.Preconditions;
import net.minecraft.world.entity.monster.illager.SpellcasterIllager;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Spellcaster;
import org.jspecify.annotations.NonNull;

public class CraftSpellcaster extends CraftIllager implements Spellcaster {

    public CraftSpellcaster(CraftServer server, SpellcasterIllager entity) {
        super(server, entity);
    }

    @Override
    public SpellcasterIllager getHandle() {
        return (SpellcasterIllager) this.entity;
    }

    @Override
    public @NonNull Spell getSpell() {
        return CraftSpellcaster.toBukkitSpell(this.getHandle().getCurrentSpell());
    }

    @Override
    public void setSpell(@NonNull Spell spell) {
        Preconditions.checkArgument(spell != null, "Use Spell.NONE");

        this.getHandle().setIsCastingSpell(CraftSpellcaster.toNMSSpell(spell));
    }

    public static Spell toBukkitSpell(SpellcasterIllager.IllagerSpell spell) {
        return Spell.valueOf(spell.name());
    }

    public static SpellcasterIllager.IllagerSpell toNMSSpell(Spell spell) {
        return SpellcasterIllager.IllagerSpell.byId(spell.ordinal());
    }
}
