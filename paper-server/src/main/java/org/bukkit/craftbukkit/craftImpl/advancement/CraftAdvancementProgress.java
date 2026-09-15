package org.bukkit.craftbukkit.craftImpl.advancement;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import net.minecraft.advancements.CriterionProgress;
import net.minecraft.server.PlayerAdvancements;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.jspecify.annotations.NonNull;

public class CraftAdvancementProgress implements AdvancementProgress {

    private final CraftAdvancement advancement;
    private final PlayerAdvancements playerData;
    private final net.minecraft.advancements.AdvancementProgress handle;

    public CraftAdvancementProgress(CraftAdvancement advancement, PlayerAdvancements player, net.minecraft.advancements.AdvancementProgress handle) {
        this.advancement = advancement;
        this.playerData = player;
        this.handle = handle;
    }

    @Override
    public @NonNull Advancement getAdvancement() {
        return this.advancement;
    }

    @Override
    public boolean isDone() {
        return this.handle.isDone();
    }

    @Override
    public boolean awardCriteria(@NonNull String criteria) {
        return this.playerData.award(this.advancement.getHandle(), criteria);
    }

    @Override
    public boolean revokeCriteria(@NonNull String criteria) {
        return this.playerData.revoke(this.advancement.getHandle(), criteria);
    }

    @Override
    public Date getDateAwarded(@NonNull String criteria) {
        CriterionProgress criterion = this.handle.getCriterion(criteria);
        return (criterion == null) ? null : criterion.getObtained() == null ? null : Date.from(criterion.getObtained()); // Paper - fix NPE if criterion isn't obtained
    }

    @Override
    public @NonNull Collection<String> getRemainingCriteria() {
        return Collections.unmodifiableCollection(Lists.newArrayList(this.handle.getRemainingCriteria()));
    }

    @Override
    public @NonNull Collection<String> getAwardedCriteria() {
        return Collections.unmodifiableCollection(Lists.newArrayList(this.handle.getCompletedCriteria()));
    }
}
