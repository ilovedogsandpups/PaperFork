package org.bukkit.craftbukkit.scoreboard;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.RenderType;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Team;
import org.jspecify.annotations.NonNull;

public final class CraftScoreboard implements org.bukkit.scoreboard.Scoreboard {
    private final Scoreboard board;
    public boolean registeredGlobally = false; // Paper - Lazily track plugin scoreboards by default

    CraftScoreboard(Scoreboard board) {
        this.board = board;
    }

    @Override
    public @NonNull Objective registerNewObjective(@NonNull String name, @NonNull String criteria, net.kyori.adventure.text.Component displayName, @NonNull RenderType renderType) {
        return this.registerNewObjective(name, CraftCriteria.getFromBukkit(criteria), displayName, renderType);
    }

    @Override
    public @NonNull Objective registerNewObjective(@NonNull String name, @NonNull Criteria criteria, net.kyori.adventure.text.Component displayName, @NonNull RenderType renderType) throws IllegalArgumentException {
        if (displayName == null) {
            displayName = net.kyori.adventure.text.Component.empty();
        }
        Preconditions.checkArgument(name != null, "Objective name cannot be null");
        Preconditions.checkArgument(criteria != null, "Criteria cannot be null");
        Preconditions.checkArgument(renderType != null, "RenderType cannot be null");
        Preconditions.checkArgument(name.length() <= Short.MAX_VALUE, "The name '%s' is longer than the limit of 32767 characters (%s)", name, name.length());
        Preconditions.checkArgument(this.getHandle().getObjective(name) == null, "An objective of name '%s' already exists", name);
        // Paper start - lazily track plugin scoreboards
        if (((CraftCriteria) criteria).criteria != net.minecraft.world.scores.criteria.ObjectiveCriteria.DUMMY && !this.registeredGlobally) {
            net.minecraft.server.MinecraftServer.getServer().server.getScoreboardManager().registerScoreboardForVanilla(this);
            this.registeredGlobally = true;
        }
        // Paper end - lazily track plugin scoreboards
        net.minecraft.world.scores.Objective objective = this.getHandle().addObjective(name, ((CraftCriteria) criteria).criteria, io.papermc.paper.adventure.PaperAdventure.asVanilla(displayName), CraftScoreboardTranslations.fromBukkitRender(renderType), true, null);
        return new CraftObjective(this, objective);
    }

    @Override
    public @NonNull Objective registerNewObjective(@NonNull String name, @NonNull String criteria, @NonNull String displayName, @NonNull RenderType renderType) {
        return this.registerNewObjective(name, CraftCriteria.getFromBukkit(criteria), displayName, renderType);
    }

    @Override
    public Objective getObjective(@NonNull String name) {
        Preconditions.checkArgument(name != null, "Objective name cannot be null");
        net.minecraft.world.scores.Objective nms = this.getHandle().getObjective(name);
        return nms == null ? null : new CraftObjective(this, nms);
    }

    @Override
    public @NonNull ImmutableSet<Objective> getObjectivesByCriteria(@NonNull String criteria) {
        Preconditions.checkArgument(criteria != null, "Criteria name cannot be null");

        ImmutableSet.Builder<Objective> result = ImmutableSet.builder();
        for (net.minecraft.world.scores.Objective objective : this.getHandle().getObjectives()) {
            CraftObjective craftObjective = new CraftObjective(this, objective);

            if (craftObjective.getCriteria().equals(criteria)) {
                result.add(craftObjective);
            }
        }
        return result.build();
    }

    @Override
    public @NonNull ImmutableSet<Objective> getObjectivesByCriteria(@NonNull Criteria criteria) {
        Preconditions.checkArgument(criteria != null, "Criteria cannot be null");

        ImmutableSet.Builder<Objective> result = ImmutableSet.builder();
        for (net.minecraft.world.scores.Objective objective : this.getHandle().getObjectives()) {
            CraftObjective craftObjective = new CraftObjective(this, objective);

            if (craftObjective.getTrackedCriteria().equals(criteria)) {
                result.add(craftObjective);
            }
        }

        return result.build();
    }

    @Override
    public @NonNull ImmutableSet<Objective> getObjectives() {
        return ImmutableSet.copyOf(Iterables.transform(this.getHandle().getObjectives(), (Function<net.minecraft.world.scores.Objective, Objective>) input -> new CraftObjective(CraftScoreboard.this, input)));
    }

    @Override
    public Objective getObjective(@NonNull DisplaySlot slot) {
        Preconditions.checkArgument(slot != null, "Display slot cannot be null");
        net.minecraft.world.scores.Objective objective = this.getHandle().getDisplayObjective(CraftScoreboardTranslations.fromBukkitSlot(slot));
        if (objective == null) {
            return null;
        }
        return new CraftObjective(this, objective);
    }

    @Override
    public @NonNull ImmutableSet<Score> getScores(@NonNull OfflinePlayer player) {
        return this.getScores(CraftScoreboard.getScoreHolder(player));
    }

    @Override
    public @NonNull ImmutableSet<Score> getScores(@NonNull String entry) {
        return this.getScores(CraftScoreboard.getScoreHolder(entry));
    }

    private ImmutableSet<Score> getScores(ScoreHolder entry) {
        Preconditions.checkArgument(entry != null, "Entry cannot be null");

        ImmutableSet.Builder<Score> scores = ImmutableSet.builder();
        for (net.minecraft.world.scores.Objective objective : this.getHandle().getObjectives()) {
            scores.add(new CraftScore(new CraftObjective(this, objective), entry));
        }
        return scores.build();
    }

    @Override
    public void resetScores(@NonNull OfflinePlayer player) {
        this.resetScores(CraftScoreboard.getScoreHolder(player));
    }

    @Override
    public void resetScores(@NonNull String entry) {
        this.resetScores(CraftScoreboard.getScoreHolder(entry));
    }

    private void resetScores(ScoreHolder entry) {
        Preconditions.checkArgument(entry != null, "Entry cannot be null");

        for (net.minecraft.world.scores.Objective objective : this.getHandle().getObjectives()) {
            this.getHandle().resetSinglePlayerScore(entry, objective);
        }
    }

    @Override
    public Team getPlayerTeam(OfflinePlayer player) {
        Preconditions.checkArgument(player != null, "OfflinePlayer cannot be null");

        PlayerTeam team = this.getHandle().getPlayersTeam(player.getName());
        return team == null ? null : new CraftTeam(this, team);
    }

    @Override
    public Team getEntryTeam(@NonNull String entry) {
        Preconditions.checkArgument(entry != null, "Entry cannot be null");

        PlayerTeam team = this.getHandle().getPlayersTeam(entry);
        return team == null ? null : new CraftTeam(this, team);
    }

    @Override
    public Team getTeam(@NonNull String teamName) {
        Preconditions.checkArgument(teamName != null, "Team name cannot be null");

        PlayerTeam team = this.getHandle().getPlayerTeam(teamName);
        return team == null ? null : new CraftTeam(this, team);
    }

    @Override
    public @NonNull ImmutableSet<Team> getTeams() {
        return ImmutableSet.copyOf(Iterables.transform(this.getHandle().getPlayerTeams(), (Function<PlayerTeam, Team>) input -> new CraftTeam(CraftScoreboard.this, input)));
    }

    @Override
    public @NonNull Team registerNewTeam(@NonNull String name) {
        Preconditions.checkArgument(name != null, "Team name cannot be null");
        Preconditions.checkArgument(name.length() <= Short.MAX_VALUE, "Team name '%s' is longer than the limit of 32767 characters (%s)", name, name.length());
        Preconditions.checkArgument(this.getHandle().getPlayerTeam(name) == null, "Team name '%s' is already in use", name);

        return new CraftTeam(this, this.getHandle().addPlayerTeam(name));
    }

    @Override
    public @NonNull ImmutableSet<OfflinePlayer> getPlayers() {
        ImmutableSet.Builder<OfflinePlayer> players = ImmutableSet.builder();
        for (ScoreHolder playerName : this.getHandle().getTrackedPlayers()) {
            players.add(Bukkit.getOfflinePlayer(playerName.getScoreboardName()));
        }
        return players.build();
    }

    @Override
    public @NonNull ImmutableSet<String> getEntries() {
        ImmutableSet.Builder<String> entries = ImmutableSet.builder();
        for (ScoreHolder entry : this.getHandle().getTrackedPlayers()) {
            entries.add(entry.getScoreboardName());
        }
        return entries.build();
    }

    @Override
    public void clearSlot(@NonNull DisplaySlot slot) {
        Preconditions.checkArgument(slot != null, "Slot cannot be null");
        this.getHandle().setDisplayObjective(CraftScoreboardTranslations.fromBukkitSlot(slot), null);
    }

    @Override
    public @NonNull ImmutableSet<Score> getScoresFor(org.bukkit.entity.@NonNull Entity entity) throws IllegalArgumentException {
        Preconditions.checkArgument(entity != null, "Entity cannot be null");
        return this.getScores(((org.bukkit.craftbukkit.entity.CraftEntity) entity).getHandle());
    }

    @Override
    public void resetScoresFor(org.bukkit.entity.@NonNull Entity entity) throws IllegalArgumentException {
        Preconditions.checkArgument(entity != null, "Entity cannot be null");
        this.resetScores(((org.bukkit.craftbukkit.entity.CraftEntity) entity).getHandle());
    }

    @Override
    public Team getEntityTeam(org.bukkit.entity.@NonNull Entity entity) throws IllegalArgumentException {
        Preconditions.checkArgument(entity != null, "Entity cannot be null");
        return this.getEntryTeam(((org.bukkit.craftbukkit.entity.CraftEntity) entity).getHandle().getScoreboardName());
    }

    public Scoreboard getHandle() {
        return this.board;
    }

    static ScoreHolder getScoreHolder(String entry) {
        return () -> entry;
    }

    static ScoreHolder getScoreHolder(OfflinePlayer player) {
        Preconditions.checkArgument(player != null, "OfflinePlayer cannot be null");

        if (player instanceof CraftPlayer craft) {
            return craft.getHandle();
        } else {
            return CraftScoreboard.getScoreHolder(player.getName());
        }
    }
}
