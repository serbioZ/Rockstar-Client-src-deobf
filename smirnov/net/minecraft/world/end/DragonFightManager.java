// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.end;

import net.minecraft.entity.boss.dragon.phase.PhaseList;
import net.minecraft.world.gen.feature.WorldGenSpikes;
import net.minecraft.world.biome.BiomeEndDecorator;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import java.util.Collections;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Set;
import com.google.common.collect.Sets;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenEndPodium;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenEndGateway;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.CriteriaTriggers;
import com.google.common.base.Predicates;
import net.minecraft.util.EntitySelectors;
import org.apache.logging.log4j.LogManager;
import java.util.Collection;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import com.google.common.collect.Lists;
import net.minecraft.entity.item.EntityEnderCrystal;
import org.apache.logging.log4j.Logger;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.base.Predicate;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.WorldServer;
import net.minecraft.block.state.pattern.BlockPattern;
import java.util.List;
import java.util.UUID;
import net.minecraft.util.math.BlockPos;

public class DragonFightManager
{
    private /* synthetic */ BlockPos exitPortalLocation;
    private /* synthetic */ DragonSpawnManager respawnState;
    private /* synthetic */ int respawnStateTicks;
    private /* synthetic */ int aliveCrystals;
    private /* synthetic */ boolean scanForLegacyFight;
    private /* synthetic */ UUID dragonUniqueId;
    private /* synthetic */ int ticksSinceDragonSeen;
    private /* synthetic */ int ticksSinceCrystalsScanned;
    private final /* synthetic */ List<Integer> gateways;
    private final /* synthetic */ BlockPattern portalPattern;
    private final /* synthetic */ WorldServer world;
    private final /* synthetic */ BossInfoServer bossInfo;
    private /* synthetic */ int ticksSinceLastPlayerScan;
    private /* synthetic */ boolean dragonKilled;
    private static final /* synthetic */ Predicate<EntityPlayerMP> VALID_PLAYER;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ List<EntityEnderCrystal> crystals;
    private /* synthetic */ boolean previouslyKilled;
    
    public void respawnDragon() {
        if (this.dragonKilled && this.respawnState == null) {
            BlockPos lllllllllllIIIIllIllIllIIIlIlIIl = this.exitPortalLocation;
            if (lllllllllllIIIIllIllIllIIIlIlIIl == null) {
                DragonFightManager.LOGGER.debug("Tried to respawn, but need to find the portal first.");
                final BlockPattern.PatternHelper lllllllllllIIIIllIllIllIIIlIlIII = this.findExitPortal();
                if (lllllllllllIIIIllIllIllIIIlIlIII == null) {
                    DragonFightManager.LOGGER.debug("Couldn't find a portal, so we made one.");
                    this.generatePortal(true);
                }
                else {
                    DragonFightManager.LOGGER.debug("Found the exit portal & temporarily using it.");
                }
                lllllllllllIIIIllIllIllIIIlIlIIl = this.exitPortalLocation;
            }
            final List<EntityEnderCrystal> lllllllllllIIIIllIllIllIIIlIIlll = (List<EntityEnderCrystal>)Lists.newArrayList();
            final BlockPos lllllllllllIIIIllIllIllIIIlIIllI = lllllllllllIIIIllIllIllIIIlIlIIl.up(1);
            for (final EnumFacing lllllllllllIIIIllIllIllIIIlIIlIl : EnumFacing.Plane.HORIZONTAL) {
                final List<EntityEnderCrystal> lllllllllllIIIIllIllIllIIIlIIlII = this.world.getEntitiesWithinAABB((Class<? extends EntityEnderCrystal>)EntityEnderCrystal.class, new AxisAlignedBB(lllllllllllIIIIllIllIllIIIlIIllI.offset(lllllllllllIIIIllIllIllIIIlIIlIl, 2)));
                if (lllllllllllIIIIllIllIllIIIlIIlII.isEmpty()) {
                    return;
                }
                lllllllllllIIIIllIllIllIIIlIIlll.addAll(lllllllllllIIIIllIllIllIIIlIIlII);
            }
            DragonFightManager.LOGGER.debug("Found all crystals, respawning dragon.");
            this.respawnDragon(lllllllllllIIIIllIllIllIIIlIIlll);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        VALID_PLAYER = Predicates.and((Predicate)EntitySelectors.IS_ALIVE, (Predicate)EntitySelectors.withinRange(0.0, 128.0, 0.0, 192.0));
    }
    
    protected void setRespawnState(final DragonSpawnManager lllllllllllIIIIllIllIllIllIIIIll) {
        if (this.respawnState == null) {
            throw new IllegalStateException("Dragon respawn isn't in progress, can't skip ahead in the animation.");
        }
        this.respawnStateTicks = 0;
        if (lllllllllllIIIIllIllIllIllIIIIll == DragonSpawnManager.END) {
            this.respawnState = null;
            this.dragonKilled = false;
            final EntityDragon lllllllllllIIIIllIllIllIllIIIllI = this.func_192445_m();
            for (final EntityPlayerMP lllllllllllIIIIllIllIllIllIIIlIl : this.bossInfo.getPlayers()) {
                CriteriaTriggers.field_192133_m.func_192229_a(lllllllllllIIIIllIllIllIllIIIlIl, lllllllllllIIIIllIllIllIllIIIllI);
            }
        }
        else {
            this.respawnState = lllllllllllIIIIllIllIllIllIIIIll;
        }
    }
    
    private void generateGateway(final BlockPos lllllllllllIIIIllIllIllIIlIllIIl) {
        this.world.playEvent(3000, lllllllllllIIIIllIllIllIIlIllIIl, 0);
        new WorldGenEndGateway().generate(this.world, new Random(), lllllllllllIIIIllIllIllIIlIllIIl);
    }
    
    public void onCrystalDestroyed(final EntityEnderCrystal lllllllllllIIIIllIllIllIIIllIlll, final DamageSource lllllllllllIIIIllIllIllIIIlllIlI) {
        if (this.respawnState != null && this.crystals.contains(lllllllllllIIIIllIllIllIIIllIlll)) {
            DragonFightManager.LOGGER.debug("Aborting respawn sequence");
            this.respawnState = null;
            this.respawnStateTicks = 0;
            this.resetSpikeCrystals();
            this.generatePortal(true);
        }
        else {
            this.findAliveCrystals();
            final Entity lllllllllllIIIIllIllIllIIIlllIIl = this.world.getEntityFromUuid(this.dragonUniqueId);
            if (lllllllllllIIIIllIllIllIIIlllIIl instanceof EntityDragon) {
                ((EntityDragon)lllllllllllIIIIllIllIllIIIlllIIl).onCrystalDestroyed(lllllllllllIIIIllIllIllIIIllIlll, new BlockPos(lllllllllllIIIIllIllIllIIIllIlll), lllllllllllIIIIllIllIllIIIlllIlI);
            }
        }
    }
    
    private boolean hasDragonBeenKilled() {
        for (int lllllllllllIIIIllIllIllIlIlllIII = -8; lllllllllllIIIIllIllIllIlIlllIII <= 8; ++lllllllllllIIIIllIllIllIlIlllIII) {
            for (int lllllllllllIIIIllIllIllIlIllIlll = -8; lllllllllllIIIIllIllIllIlIllIlll <= 8; ++lllllllllllIIIIllIllIllIlIllIlll) {
                final Chunk lllllllllllIIIIllIllIllIlIllIllI = this.world.getChunkFromChunkCoords(lllllllllllIIIIllIllIllIlIlllIII, lllllllllllIIIIllIllIllIlIllIlll);
                for (final TileEntity lllllllllllIIIIllIllIllIlIllIlIl : lllllllllllIIIIllIllIllIlIllIllI.getTileEntityMap().values()) {
                    if (lllllllllllIIIIllIllIllIlIllIlIl instanceof TileEntityEndPortal) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void processDragonDeath(final EntityDragon lllllllllllIIIIllIllIllIIllIlIll) {
        if (lllllllllllIIIIllIllIllIIllIlIll.getUniqueID().equals(this.dragonUniqueId)) {
            this.bossInfo.setPercent(0.0f);
            this.bossInfo.setVisible(false);
            this.generatePortal(true);
            this.spawnNewGateway();
            if (!this.previouslyKilled) {
                this.world.setBlockState(this.world.getHeight(WorldGenEndPodium.END_PODIUM_LOCATION), Blocks.DRAGON_EGG.getDefaultState());
            }
            this.previouslyKilled = true;
            this.dragonKilled = true;
        }
    }
    
    private void spawnNewGateway() {
        if (!this.gateways.isEmpty()) {
            final int lllllllllllIIIIllIllIllIIllIIlIl = this.gateways.remove(this.gateways.size() - 1);
            final int lllllllllllIIIIllIllIllIIllIIlII = (int)(96.0 * Math.cos(2.0 * (-3.141592653589793 + 0.15707963267948966 * lllllllllllIIIIllIllIllIIllIIlIl)));
            final int lllllllllllIIIIllIllIllIIllIIIll = (int)(96.0 * Math.sin(2.0 * (-3.141592653589793 + 0.15707963267948966 * lllllllllllIIIIllIllIllIIllIIlIl)));
            this.generateGateway(new BlockPos(lllllllllllIIIIllIllIllIIllIIlII, 75, lllllllllllIIIIllIllIllIIllIIIll));
        }
    }
    
    public NBTTagCompound getCompound() {
        final NBTTagCompound lllllllllllIIIIllIllIllIlllIIIll = new NBTTagCompound();
        if (this.dragonUniqueId != null) {
            lllllllllllIIIIllIllIllIlllIIIll.setUniqueId("DragonUUID", this.dragonUniqueId);
        }
        lllllllllllIIIIllIllIllIlllIIIll.setBoolean("DragonKilled", this.dragonKilled);
        lllllllllllIIIIllIllIllIlllIIIll.setBoolean("PreviouslyKilled", this.previouslyKilled);
        if (this.exitPortalLocation != null) {
            lllllllllllIIIIllIllIllIlllIIIll.setTag("ExitPortalLocation", NBTUtil.createPosTag(this.exitPortalLocation));
        }
        final NBTTagList lllllllllllIIIIllIllIllIlllIIIlI = new NBTTagList();
        for (final int lllllllllllIIIIllIllIllIlllIIIII : this.gateways) {
            lllllllllllIIIIllIllIllIlllIIIlI.appendTag(new NBTTagInt(lllllllllllIIIIllIllIllIlllIIIII));
        }
        lllllllllllIIIIllIllIllIlllIIIll.setTag("Gateways", lllllllllllIIIIllIllIllIlllIIIlI);
        return lllllllllllIIIIllIllIllIlllIIIll;
    }
    
    private void updateplayers() {
        final Set<EntityPlayerMP> lllllllllllIIIIllIllIllIlIIIIlIl = (Set<EntityPlayerMP>)Sets.newHashSet();
        for (final EntityPlayerMP lllllllllllIIIIllIllIllIlIIIIlII : this.world.getPlayers((Class<? extends Entity>)EntityPlayerMP.class, (com.google.common.base.Predicate<? super Entity>)DragonFightManager.VALID_PLAYER)) {
            this.bossInfo.addPlayer(lllllllllllIIIIllIllIllIlIIIIlII);
            lllllllllllIIIIllIllIllIlIIIIlIl.add(lllllllllllIIIIllIllIllIlIIIIlII);
        }
        final Set<EntityPlayerMP> lllllllllllIIIIllIllIllIlIIIIIll = (Set<EntityPlayerMP>)Sets.newHashSet((Iterable)this.bossInfo.getPlayers());
        lllllllllllIIIIllIllIllIlIIIIIll.removeAll(lllllllllllIIIIllIllIllIlIIIIlIl);
        for (final EntityPlayerMP lllllllllllIIIIllIllIllIlIIIIIlI : lllllllllllIIIIllIllIllIlIIIIIll) {
            this.bossInfo.removePlayer(lllllllllllIIIIllIllIllIlIIIIIlI);
        }
    }
    
    public void dragonUpdate(final EntityDragon lllllllllllIIIIllIllIllIIlIIIlII) {
        if (lllllllllllIIIIllIllIllIIlIIIlII.getUniqueID().equals(this.dragonUniqueId)) {
            this.bossInfo.setPercent(lllllllllllIIIIllIllIllIIlIIIlII.getHealth() / lllllllllllIIIIllIllIllIIlIIIlII.getMaxHealth());
            this.ticksSinceDragonSeen = 0;
            if (lllllllllllIIIIllIllIllIIlIIIlII.hasCustomName()) {
                this.bossInfo.setName(lllllllllllIIIIllIllIllIIlIIIlII.getDisplayName());
            }
        }
    }
    
    public DragonFightManager(final WorldServer lllllllllllIIIIllIllIllIllllIIlI, final NBTTagCompound lllllllllllIIIIllIllIllIllllIIIl) {
        this.bossInfo = (BossInfoServer)new BossInfoServer(new TextComponentTranslation("entity.EnderDragon.name", new Object[0]), BossInfo.Color.PINK, BossInfo.Overlay.PROGRESS).setPlayEndBossMusic(true).setCreateFog(true);
        this.gateways = (List<Integer>)Lists.newArrayList();
        this.scanForLegacyFight = true;
        this.world = lllllllllllIIIIllIllIllIllllIIlI;
        if (lllllllllllIIIIllIllIllIllllIIIl.hasKey("DragonKilled", 99)) {
            if (lllllllllllIIIIllIllIllIllllIIIl.hasUniqueId("DragonUUID")) {
                this.dragonUniqueId = lllllllllllIIIIllIllIllIllllIIIl.getUniqueId("DragonUUID");
            }
            this.dragonKilled = lllllllllllIIIIllIllIllIllllIIIl.getBoolean("DragonKilled");
            this.previouslyKilled = lllllllllllIIIIllIllIllIllllIIIl.getBoolean("PreviouslyKilled");
            if (lllllllllllIIIIllIllIllIllllIIIl.getBoolean("IsRespawning")) {
                this.respawnState = DragonSpawnManager.START;
            }
            if (lllllllllllIIIIllIllIllIllllIIIl.hasKey("ExitPortalLocation", 10)) {
                this.exitPortalLocation = NBTUtil.getPosFromTag(lllllllllllIIIIllIllIllIllllIIIl.getCompoundTag("ExitPortalLocation"));
            }
        }
        else {
            this.dragonKilled = true;
            this.previouslyKilled = true;
        }
        if (lllllllllllIIIIllIllIllIllllIIIl.hasKey("Gateways", 9)) {
            final NBTTagList lllllllllllIIIIllIllIllIllllIIII = lllllllllllIIIIllIllIllIllllIIIl.getTagList("Gateways", 3);
            for (int lllllllllllIIIIllIllIllIlllIllll = 0; lllllllllllIIIIllIllIllIlllIllll < lllllllllllIIIIllIllIllIllllIIII.tagCount(); ++lllllllllllIIIIllIllIllIlllIllll) {
                this.gateways.add(lllllllllllIIIIllIllIllIllllIIII.getIntAt(lllllllllllIIIIllIllIllIlllIllll));
            }
        }
        else {
            this.gateways.addAll((Collection<? extends Integer>)ContiguousSet.create(Range.closedOpen((Comparable)0, (Comparable)20), DiscreteDomain.integers()));
            Collections.shuffle(this.gateways, new Random(lllllllllllIIIIllIllIllIllllIIlI.getSeed()));
        }
        this.portalPattern = FactoryBlockPattern.start().aisle("       ", "       ", "       ", "   #   ", "       ", "       ", "       ").aisle("       ", "       ", "       ", "   #   ", "       ", "       ", "       ").aisle("       ", "       ", "       ", "   #   ", "       ", "       ", "       ").aisle("  ###  ", " #   # ", "#     #", "#  #  #", "#     #", " #   # ", "  ###  ").aisle("       ", "  ###  ", " ##### ", " ##### ", " ##### ", "  ###  ", "       ").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockMatcher.forBlock(Blocks.BEDROCK))).build();
    }
    
    @Nullable
    private BlockPattern.PatternHelper findExitPortal() {
        for (int lllllllllllIIIIllIllIllIlIlIIlIl = -8; lllllllllllIIIIllIllIllIlIlIIlIl <= 8; ++lllllllllllIIIIllIllIllIlIlIIlIl) {
            for (int lllllllllllIIIIllIllIllIlIlIIlII = -8; lllllllllllIIIIllIllIllIlIlIIlII <= 8; ++lllllllllllIIIIllIllIllIlIlIIlII) {
                final Chunk lllllllllllIIIIllIllIllIlIlIIIll = this.world.getChunkFromChunkCoords(lllllllllllIIIIllIllIllIlIlIIlIl, lllllllllllIIIIllIllIllIlIlIIlII);
                for (final TileEntity lllllllllllIIIIllIllIllIlIlIIIlI : lllllllllllIIIIllIllIllIlIlIIIll.getTileEntityMap().values()) {
                    if (lllllllllllIIIIllIllIllIlIlIIIlI instanceof TileEntityEndPortal) {
                        final BlockPattern.PatternHelper lllllllllllIIIIllIllIllIlIlIIIIl = this.portalPattern.match(this.world, lllllllllllIIIIllIllIllIlIlIIIlI.getPos());
                        if (lllllllllllIIIIllIllIllIlIlIIIIl != null) {
                            final BlockPos lllllllllllIIIIllIllIllIlIlIIIII = lllllllllllIIIIllIllIllIlIlIIIIl.translateOffset(3, 3, 3).getPos();
                            if (this.exitPortalLocation == null && lllllllllllIIIIllIllIllIlIlIIIII.getX() == 0 && lllllllllllIIIIllIllIllIlIlIIIII.getZ() == 0) {
                                this.exitPortalLocation = lllllllllllIIIIllIllIllIlIlIIIII;
                            }
                            return lllllllllllIIIIllIllIllIlIlIIIIl;
                        }
                        continue;
                    }
                }
            }
        }
        int lllllllllllIIIIllIllIllIlIIllllI;
        for (int lllllllllllIIIIllIllIllIlIIlllll = lllllllllllIIIIllIllIllIlIIllllI = this.world.getHeight(WorldGenEndPodium.END_PODIUM_LOCATION).getY(); lllllllllllIIIIllIllIllIlIIllllI >= 0; --lllllllllllIIIIllIllIllIlIIllllI) {
            final BlockPattern.PatternHelper lllllllllllIIIIllIllIllIlIIlllIl = this.portalPattern.match(this.world, new BlockPos(WorldGenEndPodium.END_PODIUM_LOCATION.getX(), lllllllllllIIIIllIllIllIlIIllllI, WorldGenEndPodium.END_PODIUM_LOCATION.getZ()));
            if (lllllllllllIIIIllIllIllIlIIlllIl != null) {
                if (this.exitPortalLocation == null) {
                    this.exitPortalLocation = lllllllllllIIIIllIllIllIlIIlllIl.translateOffset(3, 3, 3).getPos();
                }
                return lllllllllllIIIIllIllIllIlIIlllIl;
            }
        }
        return null;
    }
    
    private void respawnDragon(final List<EntityEnderCrystal> lllllllllllIIIIllIllIllIIIIlIlII) {
        if (this.dragonKilled && this.respawnState == null) {
            for (BlockPattern.PatternHelper lllllllllllIIIIllIllIllIIIIlIIll = this.findExitPortal(); lllllllllllIIIIllIllIllIIIIlIIll != null; lllllllllllIIIIllIllIllIIIIlIIll = this.findExitPortal()) {
                for (int lllllllllllIIIIllIllIllIIIIlIIlI = 0; lllllllllllIIIIllIllIllIIIIlIIlI < this.portalPattern.getPalmLength(); ++lllllllllllIIIIllIllIllIIIIlIIlI) {
                    for (int lllllllllllIIIIllIllIllIIIIlIIIl = 0; lllllllllllIIIIllIllIllIIIIlIIIl < this.portalPattern.getThumbLength(); ++lllllllllllIIIIllIllIllIIIIlIIIl) {
                        for (int lllllllllllIIIIllIllIllIIIIlIIII = 0; lllllllllllIIIIllIllIllIIIIlIIII < this.portalPattern.getFingerLength(); ++lllllllllllIIIIllIllIllIIIIlIIII) {
                            final BlockWorldState lllllllllllIIIIllIllIllIIIIIllll = lllllllllllIIIIllIllIllIIIIlIIll.translateOffset(lllllllllllIIIIllIllIllIIIIlIIlI, lllllllllllIIIIllIllIllIIIIlIIIl, lllllllllllIIIIllIllIllIIIIlIIII);
                            if (lllllllllllIIIIllIllIllIIIIIllll.getBlockState().getBlock() == Blocks.BEDROCK || lllllllllllIIIIllIllIllIIIIIllll.getBlockState().getBlock() == Blocks.END_PORTAL) {
                                this.world.setBlockState(lllllllllllIIIIllIllIllIIIIIllll.getPos(), Blocks.END_STONE.getDefaultState());
                            }
                        }
                    }
                }
            }
            this.respawnState = DragonSpawnManager.START;
            this.respawnStateTicks = 0;
            this.generatePortal(false);
            this.crystals = lllllllllllIIIIllIllIllIIIIlIlII;
        }
    }
    
    private void findAliveCrystals() {
        this.ticksSinceCrystalsScanned = 0;
        this.aliveCrystals = 0;
        int lllllllllllIIIIllIllIllIIlllIIIl;
        for (String lllllllllllIIIIllIllIllIIlllIIlI = (String)((WorldGenSpikes.EndSpike[])(Object)(lllllllllllIIIIllIllIllIIlllIIIl = (int)(Object)BiomeEndDecorator.getSpikesForWorld(this.world))).length, lllllllllllIIIIllIllIllIIlllIIll = (String)0; lllllllllllIIIIllIllIllIIlllIIll < lllllllllllIIIIllIllIllIIlllIIlI; ++lllllllllllIIIIllIllIllIIlllIIll) {
            final WorldGenSpikes.EndSpike lllllllllllIIIIllIllIllIIlllIllI = lllllllllllIIIIllIllIllIIlllIIIl[lllllllllllIIIIllIllIllIIlllIIll];
            this.aliveCrystals += this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityEnderCrystal.class, lllllllllllIIIIllIllIllIIlllIllI.getTopBoundingBox()).size();
        }
        DragonFightManager.LOGGER.debug("Found {} end crystals still alive", (Object)this.aliveCrystals);
    }
    
    public boolean hasPreviouslyKilledDragon() {
        return this.previouslyKilled;
    }
    
    private void generatePortal(final boolean lllllllllllIIIIllIllIllIIlIlIIIl) {
        final WorldGenEndPodium lllllllllllIIIIllIllIllIIlIlIIll = new WorldGenEndPodium(lllllllllllIIIIllIllIllIIlIlIIIl);
        if (this.exitPortalLocation == null) {
            this.exitPortalLocation = this.world.getTopSolidOrLiquidBlock(WorldGenEndPodium.END_PODIUM_LOCATION).down();
            while (this.world.getBlockState(this.exitPortalLocation).getBlock() == Blocks.BEDROCK && this.exitPortalLocation.getY() > this.world.getSeaLevel()) {
                this.exitPortalLocation = this.exitPortalLocation.down();
            }
        }
        lllllllllllIIIIllIllIllIIlIlIIll.generate(this.world, new Random(), this.exitPortalLocation);
    }
    
    public void tick() {
        this.bossInfo.setVisible(!this.dragonKilled);
        if (++this.ticksSinceLastPlayerScan >= 20) {
            this.updateplayers();
            this.ticksSinceLastPlayerScan = 0;
        }
        if (!this.bossInfo.getPlayers().isEmpty()) {
            if (this.scanForLegacyFight) {
                DragonFightManager.LOGGER.info("Scanning for legacy world dragon fight...");
                this.loadChunks();
                this.scanForLegacyFight = false;
                final boolean lllllllllllIIIIllIllIllIllIlIlIl = this.hasDragonBeenKilled();
                if (lllllllllllIIIIllIllIllIllIlIlIl) {
                    DragonFightManager.LOGGER.info("Found that the dragon has been killed in this world already.");
                    this.previouslyKilled = true;
                }
                else {
                    DragonFightManager.LOGGER.info("Found that the dragon has not yet been killed in this world.");
                    this.previouslyKilled = false;
                    this.generatePortal(false);
                }
                final List<EntityDragon> lllllllllllIIIIllIllIllIllIlIlII = this.world.getEntities((Class<? extends EntityDragon>)EntityDragon.class, (com.google.common.base.Predicate<? super EntityDragon>)EntitySelectors.IS_ALIVE);
                if (lllllllllllIIIIllIllIllIllIlIlII.isEmpty()) {
                    this.dragonKilled = true;
                }
                else {
                    final EntityDragon lllllllllllIIIIllIllIllIllIlIIll = lllllllllllIIIIllIllIllIllIlIlII.get(0);
                    this.dragonUniqueId = lllllllllllIIIIllIllIllIllIlIIll.getUniqueID();
                    DragonFightManager.LOGGER.info("Found that there's a dragon still alive ({})", (Object)lllllllllllIIIIllIllIllIllIlIIll);
                    this.dragonKilled = false;
                    if (!lllllllllllIIIIllIllIllIllIlIlIl) {
                        DragonFightManager.LOGGER.info("But we didn't have a portal, let's remove it.");
                        lllllllllllIIIIllIllIllIllIlIIll.setDead();
                        this.dragonUniqueId = null;
                    }
                }
                if (!this.previouslyKilled && this.dragonKilled) {
                    this.dragonKilled = false;
                }
            }
            if (this.respawnState != null) {
                if (this.crystals == null) {
                    this.respawnState = null;
                    this.respawnDragon();
                }
                this.respawnState.process(this.world, this, this.crystals, this.respawnStateTicks++, this.exitPortalLocation);
            }
            if (!this.dragonKilled) {
                if (this.dragonUniqueId == null || ++this.ticksSinceDragonSeen >= 1200) {
                    this.loadChunks();
                    final List<EntityDragon> lllllllllllIIIIllIllIllIllIlIIlI = this.world.getEntities((Class<? extends EntityDragon>)EntityDragon.class, (com.google.common.base.Predicate<? super EntityDragon>)EntitySelectors.IS_ALIVE);
                    if (lllllllllllIIIIllIllIllIllIlIIlI.isEmpty()) {
                        DragonFightManager.LOGGER.debug("Haven't seen the dragon, respawning it");
                        this.func_192445_m();
                    }
                    else {
                        DragonFightManager.LOGGER.debug("Haven't seen our dragon, but found another one to use.");
                        this.dragonUniqueId = lllllllllllIIIIllIllIllIllIlIIlI.get(0).getUniqueID();
                    }
                    this.ticksSinceDragonSeen = 0;
                }
                if (++this.ticksSinceCrystalsScanned >= 100) {
                    this.findAliveCrystals();
                    this.ticksSinceCrystalsScanned = 0;
                }
            }
        }
    }
    
    public void resetSpikeCrystals() {
        long lllllllllllIIIIllIllIlIllllllIIl;
        for (double lllllllllllIIIIllIllIlIllllllIlI = ((WorldGenSpikes.EndSpike[])(Object)(lllllllllllIIIIllIllIlIllllllIIl = (long)(Object)BiomeEndDecorator.getSpikesForWorld(this.world))).length, lllllllllllIIIIllIllIlIllllllIll = 0; lllllllllllIIIIllIllIlIllllllIll < lllllllllllIIIIllIllIlIllllllIlI; ++lllllllllllIIIIllIllIlIllllllIll) {
            final WorldGenSpikes.EndSpike lllllllllllIIIIllIllIlIlllllllll = lllllllllllIIIIllIllIlIllllllIIl[lllllllllllIIIIllIllIlIllllllIll];
            for (final EntityEnderCrystal lllllllllllIIIIllIllIlIllllllllI : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityEnderCrystal.class, lllllllllllIIIIllIllIlIlllllllll.getTopBoundingBox())) {
                lllllllllllIIIIllIllIlIllllllllI.setEntityInvulnerable(false);
                lllllllllllIIIIllIllIlIllllllllI.setBeamTarget(null);
            }
        }
    }
    
    public int getNumAliveCrystals() {
        return this.aliveCrystals;
    }
    
    private EntityDragon func_192445_m() {
        this.world.getChunkFromBlockCoords(new BlockPos(0, 128, 0));
        final EntityDragon lllllllllllIIIIllIllIllIIlIIllII = new EntityDragon(this.world);
        lllllllllllIIIIllIllIllIIlIIllII.getPhaseManager().setPhase(PhaseList.HOLDING_PATTERN);
        lllllllllllIIIIllIllIllIIlIIllII.setLocationAndAngles(0.0, 128.0, 0.0, this.world.rand.nextFloat() * 360.0f, 0.0f);
        this.world.spawnEntityInWorld(lllllllllllIIIIllIllIllIIlIIllII);
        this.dragonUniqueId = lllllllllllIIIIllIllIllIIlIIllII.getUniqueID();
        return lllllllllllIIIIllIllIllIIlIIllII;
    }
    
    private void loadChunks() {
        for (int lllllllllllIIIIllIllIllIlIIlIIII = -8; lllllllllllIIIIllIllIllIlIIlIIII <= 8; ++lllllllllllIIIIllIllIllIlIIlIIII) {
            for (int lllllllllllIIIIllIllIllIlIIIllll = -8; lllllllllllIIIIllIllIllIlIIIllll <= 8; ++lllllllllllIIIIllIllIllIlIIIllll) {
                this.world.getChunkFromChunkCoords(lllllllllllIIIIllIllIllIlIIlIIII, lllllllllllIIIIllIllIllIlIIIllll);
            }
        }
    }
}
