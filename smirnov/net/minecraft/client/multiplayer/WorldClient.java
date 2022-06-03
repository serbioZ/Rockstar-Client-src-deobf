// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.multiplayer;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFirework;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.SoundEvents;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;
import net.minecraft.network.Packet;
import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.entity.item.EntityMinecart;
import optifine.DynamicLights;
import optifine.Config;
import net.minecraft.world.chunk.Chunk;
import java.util.Collection;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.CrashReport;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.scoreboard.Scoreboard;
import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.block.state.IBlockState;
import optifine.CustomGuis;
import optifine.PlayerControllerOF;
import optifine.Reflector;
import net.minecraft.world.storage.SaveDataMemoryStorage;
import com.google.common.collect.Sets;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.storage.SaveHandlerMP;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldSettings;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Item;
import net.minecraft.world.GameType;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.entity.Entity;
import java.util.Set;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.world.World;

public class WorldClient extends World
{
    private /* synthetic */ int playerChunkY;
    private final /* synthetic */ NetHandlerPlayClient connection;
    private final /* synthetic */ Set<Entity> entityList;
    private /* synthetic */ int playerChunkX;
    protected /* synthetic */ Set<ChunkPos> viewableChunks;
    private /* synthetic */ int ambienceTicks;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ ChunkProviderClient clientChunkProvider;
    private /* synthetic */ boolean playerUpdate;
    private final /* synthetic */ Set<Entity> entitySpawnQueue;
    private final /* synthetic */ Set<ChunkPos> previousActiveChunkSet;
    
    @Override
    protected IChunkProvider createChunkProvider() {
        this.clientChunkProvider = new ChunkProviderClient(this);
        return this.clientChunkProvider;
    }
    
    public void invalidateBlockReceiveRegion(final int lllllllllllIllIIlllIIIIIIlIllIIl, final int lllllllllllIllIIlllIIIIIIlIllIII, final int lllllllllllIllIIlllIIIIIIlIlIlll, final int lllllllllllIllIIlllIIIIIIlIlIllI, final int lllllllllllIllIIlllIIIIIIlIlIlIl, final int lllllllllllIllIIlllIIIIIIlIlIlII) {
    }
    
    public void doVoidFogParticles(final int lllllllllllIllIIllIllllllIIIIlll, final int lllllllllllIllIIllIllllllIIIIllI, final int lllllllllllIllIIllIllllllIIIIlIl) {
        final int lllllllllllIllIIllIllllllIIIlllI = 32;
        final Random lllllllllllIllIIllIllllllIIIllIl = new Random();
        ItemStack lllllllllllIllIIllIllllllIIIllII = this.mc.player.getHeldItemMainhand();
        if (lllllllllllIllIIllIllllllIIIllII == null || Block.getBlockFromItem(lllllllllllIllIIllIllllllIIIllII.getItem()) != Blocks.BARRIER) {
            lllllllllllIllIIllIllllllIIIllII = this.mc.player.getHeldItemOffhand();
        }
        final boolean lllllllllllIllIIllIllllllIIIlIll = this.mc.playerController.getCurrentGameType() == GameType.CREATIVE && !lllllllllllIllIIllIllllllIIIllII.func_190926_b() && lllllllllllIllIIllIllllllIIIllII.getItem() == Item.getItemFromBlock(Blocks.BARRIER);
        final BlockPos.MutableBlockPos lllllllllllIllIIllIllllllIIIlIlI = new BlockPos.MutableBlockPos();
        for (int lllllllllllIllIIllIllllllIIIlIIl = 0; lllllllllllIllIIllIllllllIIIlIIl < 667; ++lllllllllllIllIIllIllllllIIIlIIl) {
            this.showBarrierParticles(lllllllllllIllIIllIllllllIIIIlll, lllllllllllIllIIllIllllllIIIIllI, lllllllllllIllIIllIllllllIIIIlIl, 16, lllllllllllIllIIllIllllllIIIllIl, lllllllllllIllIIllIllllllIIIlIll, lllllllllllIllIIllIllllllIIIlIlI);
            this.showBarrierParticles(lllllllllllIllIIllIllllllIIIIlll, lllllllllllIllIIllIllllllIIIIllI, lllllllllllIllIIllIllllllIIIIlIl, 32, lllllllllllIllIIllIllllllIIIllIl, lllllllllllIllIIllIllllllIIIlIll, lllllllllllIllIIllIllllllIIIlIlI);
        }
    }
    
    public WorldClient(final NetHandlerPlayClient lllllllllllIllIIlllIIIIIIlllIIIl, final WorldSettings lllllllllllIllIIlllIIIIIIllIlIlI, final int lllllllllllIllIIlllIIIIIIllIlIIl, final EnumDifficulty lllllllllllIllIIlllIIIIIIllIlIII, final Profiler lllllllllllIllIIlllIIIIIIllIllIl) {
        super(new SaveHandlerMP(), new WorldInfo(lllllllllllIllIIlllIIIIIIllIlIlI, "MpServer"), makeWorldProvider(lllllllllllIllIIlllIIIIIIllIlIIl), lllllllllllIllIIlllIIIIIIllIllIl, true);
        this.entityList = (Set<Entity>)Sets.newHashSet();
        this.entitySpawnQueue = (Set<Entity>)Sets.newHashSet();
        this.mc = Minecraft.getMinecraft();
        this.previousActiveChunkSet = (Set<ChunkPos>)Sets.newHashSet();
        this.playerChunkX = Integer.MIN_VALUE;
        this.playerChunkY = Integer.MIN_VALUE;
        this.playerUpdate = false;
        this.ambienceTicks = this.rand.nextInt(12000);
        this.viewableChunks = (Set<ChunkPos>)Sets.newHashSet();
        this.connection = lllllllllllIllIIlllIIIIIIlllIIIl;
        this.getWorldInfo().setDifficulty(lllllllllllIllIIlllIIIIIIllIlIII);
        this.provider.registerWorld(this);
        this.setSpawnPoint(new BlockPos(8, 64, 8));
        this.chunkProvider = this.createChunkProvider();
        this.mapStorage = new SaveDataMemoryStorage();
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
        Reflector.call((Object)this, Reflector.ForgeWorld_initCapabilities, new Object[0]);
        Reflector.postForgeBusEvent(Reflector.WorldEvent_Load_Constructor, new Object[] { this });
        if (this.mc.playerController != null && this.mc.playerController.getClass() == PlayerControllerMP.class) {
            this.mc.playerController = (PlayerControllerMP)new PlayerControllerOF(this.mc, lllllllllllIllIIlllIIIIIIlllIIIl);
            CustomGuis.setPlayerControllerOF((PlayerControllerOF)this.mc.playerController);
        }
    }
    
    @Override
    public boolean setBlockState(final BlockPos lllllllllllIllIIllIllllIlIlIIlll, final IBlockState lllllllllllIllIIllIllllIlIlIIllI, final int lllllllllllIllIIllIllllIlIlIIIII) {
        this.playerUpdate = this.isPlayerActing();
        final boolean lllllllllllIllIIllIllllIlIlIIlII = super.setBlockState(lllllllllllIllIIllIllllIlIlIIlll, lllllllllllIllIIllIllllIlIlIIllI, lllllllllllIllIIllIllllIlIlIIIII);
        this.playerUpdate = false;
        return lllllllllllIllIIllIllllIlIlIIlII;
    }
    
    public void playSound(final BlockPos lllllllllllIllIIllIlllllIIIlIlll, final SoundEvent lllllllllllIllIIllIlllllIIIIllll, final SoundCategory lllllllllllIllIIllIlllllIIIIlllI, final float lllllllllllIllIIllIlllllIIIIllIl, final float lllllllllllIllIIllIlllllIIIlIIll, final boolean lllllllllllIllIIllIlllllIIIIlIll) {
        this.playSound(lllllllllllIllIIllIlllllIIIlIlll.getX() + 0.5, lllllllllllIllIIllIlllllIIIlIlll.getY() + 0.5, lllllllllllIllIIllIlllllIIIlIlll.getZ() + 0.5, lllllllllllIllIIllIlllllIIIIllll, lllllllllllIllIIllIlllllIIIIlllI, lllllllllllIllIIllIlllllIIIIllIl, lllllllllllIllIIllIlllllIIIlIIll, lllllllllllIllIIllIlllllIIIIlIll);
    }
    
    @Override
    protected void onEntityAdded(final Entity lllllllllllIllIIllIllllllllllIlI) {
        super.onEntityAdded(lllllllllllIllIIllIllllllllllIlI);
        if (this.entitySpawnQueue.contains(lllllllllllIllIIllIllllllllllIlI)) {
            this.entitySpawnQueue.remove(lllllllllllIllIIllIllllllllllIlI);
        }
    }
    
    @Override
    protected void updateWeather() {
    }
    
    @Override
    public void playSound(@Nullable final EntityPlayer lllllllllllIllIIllIlllllIIllIIII, final double lllllllllllIllIIllIlllllIIlIllll, final double lllllllllllIllIIllIlllllIIlIlllI, final double lllllllllllIllIIllIlllllIIlIllIl, final SoundEvent lllllllllllIllIIllIlllllIIlIllII, final SoundCategory lllllllllllIllIIllIlllllIIlIIIlI, final float lllllllllllIllIIllIlllllIIlIIIIl, final float lllllllllllIllIIllIlllllIIlIlIIl) {
        if (lllllllllllIllIIllIlllllIIllIIII == this.mc.player) {
            this.playSound(lllllllllllIllIIllIlllllIIlIllll, lllllllllllIllIIllIlllllIIlIlllI, lllllllllllIllIIllIlllllIIlIllIl, lllllllllllIllIIllIlllllIIlIllII, lllllllllllIllIIllIlllllIIlIIIlI, lllllllllllIllIIllIlllllIIlIIIIl, lllllllllllIllIIllIlllllIIlIlIIl, false);
        }
    }
    
    @Nullable
    @Override
    public Entity getEntityByID(final int lllllllllllIllIIllIllllllllIIIlI) {
        return (lllllllllllIllIIllIllllllllIIIlI == this.mc.player.getEntityId()) ? this.mc.player : super.getEntityByID(lllllllllllIllIIllIllllllllIIIlI);
    }
    
    public void setWorldScoreboard(final Scoreboard lllllllllllIllIIllIllllIllIIIlIl) {
        this.worldScoreboard = lllllllllllIllIIllIllllIllIIIlIl;
    }
    
    @Override
    public void playSound(final double lllllllllllIllIIllIllllIllllllIl, final double lllllllllllIllIIllIllllIllllIIII, final double lllllllllllIllIIllIllllIlllIllll, final SoundEvent lllllllllllIllIIllIllllIlllIlllI, final SoundCategory lllllllllllIllIIllIllllIlllIllIl, final float lllllllllllIllIIllIllllIlllllIII, final float lllllllllllIllIIllIllllIlllIlIll, final boolean lllllllllllIllIIllIllllIllllIllI) {
        final double lllllllllllIllIIllIllllIllllIlIl = this.mc.getRenderViewEntity().getDistanceSq(lllllllllllIllIIllIllllIllllllIl, lllllllllllIllIIllIllllIllllIIII, lllllllllllIllIIllIllllIlllIllll);
        final PositionedSoundRecord lllllllllllIllIIllIllllIllllIlII = new PositionedSoundRecord(lllllllllllIllIIllIllllIlllIlllI, lllllllllllIllIIllIllllIlllIllIl, lllllllllllIllIIllIllllIlllllIII, lllllllllllIllIIllIllllIlllIlIll, (float)lllllllllllIllIIllIllllIllllllIl, (float)lllllllllllIllIIllIllllIllllIIII, (float)lllllllllllIllIIllIllllIlllIllll);
        if (lllllllllllIllIIllIllllIllllIllI && lllllllllllIllIIllIllllIllllIlIl > 100.0) {
            final double lllllllllllIllIIllIllllIllllIIll = Math.sqrt(lllllllllllIllIIllIllllIllllIlIl) / 40.0;
            this.mc.getSoundHandler().playDelayedSound(lllllllllllIllIIllIllllIllllIlII, (int)(lllllllllllIllIIllIllllIllllIIll * 20.0));
        }
        else {
            this.mc.getSoundHandler().playSound(lllllllllllIllIIllIllllIllllIlII);
        }
    }
    
    @Override
    public CrashReportCategory addWorldInfoToCrashReport(final CrashReport lllllllllllIllIIllIlllllIIllllll) {
        final CrashReportCategory lllllllllllIllIIllIlllllIIlllllI = super.addWorldInfoToCrashReport(lllllllllllIllIIllIlllllIIllllll);
        lllllllllllIllIIllIlllllIIlllllI.setDetail("Forced entities", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(WorldClient.this.entityList.size()) + " total; " + WorldClient.this.entityList;
            }
        });
        lllllllllllIllIIllIlllllIIlllllI.setDetail("Retry entities", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(WorldClient.this.entitySpawnQueue.size()) + " total; " + WorldClient.this.entitySpawnQueue;
            }
        });
        lllllllllllIllIIllIlllllIIlllllI.setDetail("Server brand", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return WorldClient.this.mc.player.getServerBrand();
            }
        });
        lllllllllllIllIIllIlllllIIlllllI.setDetail("Server type", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return (WorldClient.this.mc.getIntegratedServer() == null) ? "Non-integrated multiplayer server" : "Integrated singleplayer server";
            }
        });
        return lllllllllllIllIIllIlllllIIlllllI;
    }
    
    public void showBarrierParticles(final int lllllllllllIllIIllIlllllIllIIlIl, final int lllllllllllIllIIllIlllllIllIIlII, final int lllllllllllIllIIllIlllllIllIIIll, final int lllllllllllIllIIllIlllllIllIIIlI, final Random lllllllllllIllIIllIlllllIllIIIIl, final boolean lllllllllllIllIIllIlllllIllIllII, final BlockPos.MutableBlockPos lllllllllllIllIIllIlllllIllIlIll) {
        final int lllllllllllIllIIllIlllllIllIlIlI = lllllllllllIllIIllIlllllIllIIlIl + this.rand.nextInt(lllllllllllIllIIllIlllllIllIIIlI) - this.rand.nextInt(lllllllllllIllIIllIlllllIllIIIlI);
        final int lllllllllllIllIIllIlllllIllIlIIl = lllllllllllIllIIllIlllllIllIIlII + this.rand.nextInt(lllllllllllIllIIllIlllllIllIIIlI) - this.rand.nextInt(lllllllllllIllIIllIlllllIllIIIlI);
        final int lllllllllllIllIIllIlllllIllIlIII = lllllllllllIllIIllIlllllIllIIIll + this.rand.nextInt(lllllllllllIllIIllIlllllIllIIIlI) - this.rand.nextInt(lllllllllllIllIIllIlllllIllIIIlI);
        lllllllllllIllIIllIlllllIllIlIll.setPos(lllllllllllIllIIllIlllllIllIlIlI, lllllllllllIllIIllIlllllIllIlIIl, lllllllllllIllIIllIlllllIllIlIII);
        final IBlockState lllllllllllIllIIllIlllllIllIIlll = this.getBlockState(lllllllllllIllIIllIlllllIllIlIll);
        lllllllllllIllIIllIlllllIllIIlll.getBlock().randomDisplayTick(lllllllllllIllIIllIlllllIllIIlll, this, lllllllllllIllIIllIlllllIllIlIll, lllllllllllIllIIllIlllllIllIIIIl);
        if (lllllllllllIllIIllIlllllIllIllII && lllllllllllIllIIllIlllllIllIIlll.getBlock() == Blocks.BARRIER) {
            this.spawnParticle(EnumParticleTypes.BARRIER, lllllllllllIllIIllIlllllIllIlIlI + 0.5f, lllllllllllIllIIllIlllllIllIlIIl + 0.5f, lllllllllllIllIIllIlllllIllIlIII + 0.5f, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public void sendQuittingDisconnectingPacket() {
        this.connection.getNetworkManager().closeChannel(new TextComponentString("Quitting"));
    }
    
    @Override
    public void removeEntity(final Entity lllllllllllIllIIllIllllllllllllI) {
        super.removeEntity(lllllllllllIllIIllIllllllllllllI);
        this.entityList.remove(lllllllllllIllIIllIllllllllllllI);
    }
    
    private static WorldProvider makeWorldProvider(final int lllllllllllIllIIlllIIIIIIllIIlII) {
        return (WorldProvider)(Reflector.DimensionManager_createProviderFor.exists() ? Reflector.call(Reflector.DimensionManager_createProviderFor, new Object[] { lllllllllllIllIIlllIIIIIIllIIlII }) : DimensionType.getById(lllllllllllIllIIlllIIIIIIllIIlII).createDimension());
    }
    
    @Override
    protected void updateBlocks() {
        this.buildChunkCoordList();
        if (this.ambienceTicks > 0) {
            --this.ambienceTicks;
        }
        this.previousActiveChunkSet.retainAll(this.viewableChunks);
        if (this.previousActiveChunkSet.size() == this.viewableChunks.size()) {
            this.previousActiveChunkSet.clear();
        }
        int lllllllllllIllIIlllIIIIIIIlIIlII = 0;
        for (final ChunkPos lllllllllllIllIIlllIIIIIIIlIIIll : this.viewableChunks) {
            if (!this.previousActiveChunkSet.contains(lllllllllllIllIIlllIIIIIIIlIIIll)) {
                final int lllllllllllIllIIlllIIIIIIIlIIIlI = lllllllllllIllIIlllIIIIIIIlIIIll.chunkXPos * 16;
                final int lllllllllllIllIIlllIIIIIIIlIIIIl = lllllllllllIllIIlllIIIIIIIlIIIll.chunkZPos * 16;
                this.theProfiler.startSection("getChunk");
                final Chunk lllllllllllIllIIlllIIIIIIIlIIIII = this.getChunkFromChunkCoords(lllllllllllIllIIlllIIIIIIIlIIIll.chunkXPos, lllllllllllIllIIlllIIIIIIIlIIIll.chunkZPos);
                this.playMoodSoundAndCheckLight(lllllllllllIllIIlllIIIIIIIlIIIlI, lllllllllllIllIIlllIIIIIIIlIIIIl, lllllllllllIllIIlllIIIIIIIlIIIII);
                this.theProfiler.endSection();
                this.previousActiveChunkSet.add(lllllllllllIllIIlllIIIIIIIlIIIll);
                if (++lllllllllllIllIIlllIIIIIIIlIIlII >= 10) {
                    return;
                }
                continue;
            }
        }
    }
    
    @Override
    public int getCombinedLight(final BlockPos lllllllllllIllIIllIllllIlIllIIII, final int lllllllllllIllIIllIllllIlIlIllll) {
        int lllllllllllIllIIllIllllIlIllIIlI = super.getCombinedLight(lllllllllllIllIIllIllllIlIllIIII, lllllllllllIllIIllIllllIlIlIllll);
        if (Config.isDynamicLights()) {
            lllllllllllIllIIllIllllIlIllIIlI = DynamicLights.getCombinedLight(lllllllllllIllIIllIllllIlIllIIII, lllllllllllIllIIllIllllIlIllIIlI);
        }
        return lllllllllllIllIIllIllllIlIllIIlI;
    }
    
    @Override
    public boolean spawnEntityInWorld(final Entity lllllllllllIllIIlllIIIIIIIIIlIII) {
        final boolean lllllllllllIllIIlllIIIIIIIIIIlll = super.spawnEntityInWorld(lllllllllllIllIIlllIIIIIIIIIlIII);
        this.entityList.add(lllllllllllIllIIlllIIIIIIIIIlIII);
        if (lllllllllllIllIIlllIIIIIIIIIIlll) {
            if (lllllllllllIllIIlllIIIIIIIIIlIII instanceof EntityMinecart) {
                this.mc.getSoundHandler().playSound(new MovingSoundMinecart((EntityMinecart)lllllllllllIllIIlllIIIIIIIIIlIII));
            }
        }
        else {
            this.entitySpawnQueue.add(lllllllllllIllIIlllIIIIIIIIIlIII);
        }
        return lllllllllllIllIIlllIIIIIIIIIIlll;
    }
    
    @Override
    protected void onEntityRemoved(final Entity lllllllllllIllIIllIlllllllllIIlI) {
        super.onEntityRemoved(lllllllllllIllIIllIlllllllllIIlI);
        if (this.entityList.contains(lllllllllllIllIIllIlllllllllIIlI)) {
            if (lllllllllllIllIIllIlllllllllIIlI.isEntityAlive()) {
                this.entitySpawnQueue.add(lllllllllllIllIIllIlllllllllIIlI);
            }
            else {
                this.entityList.remove(lllllllllllIllIIllIlllllllllIIlI);
            }
        }
    }
    
    public void removeAllEntities() {
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (int lllllllllllIllIIllIlllllIlIlIIll = 0; lllllllllllIllIIllIlllllIlIlIIll < this.unloadedEntityList.size(); ++lllllllllllIllIIllIlllllIlIlIIll) {
            final Entity lllllllllllIllIIllIlllllIlIlIIlI = this.unloadedEntityList.get(lllllllllllIllIIllIlllllIlIlIIll);
            final int lllllllllllIllIIllIlllllIlIlIIIl = lllllllllllIllIIllIlllllIlIlIIlI.chunkCoordX;
            final int lllllllllllIllIIllIlllllIlIlIIII = lllllllllllIllIIllIlllllIlIlIIlI.chunkCoordZ;
            if (lllllllllllIllIIllIlllllIlIlIIlI.addedToChunk && this.isChunkLoaded(lllllllllllIllIIllIlllllIlIlIIIl, lllllllllllIllIIllIlllllIlIlIIII, true)) {
                this.getChunkFromChunkCoords(lllllllllllIllIIllIlllllIlIlIIIl, lllllllllllIllIIllIlllllIlIlIIII).removeEntity(lllllllllllIllIIllIlllllIlIlIIlI);
            }
        }
        for (int lllllllllllIllIIllIlllllIlIIllll = 0; lllllllllllIllIIllIlllllIlIIllll < this.unloadedEntityList.size(); ++lllllllllllIllIIllIlllllIlIIllll) {
            this.onEntityRemoved(this.unloadedEntityList.get(lllllllllllIllIIllIlllllIlIIllll));
        }
        this.unloadedEntityList.clear();
        for (int lllllllllllIllIIllIlllllIlIIlllI = 0; lllllllllllIllIIllIlllllIlIIlllI < this.loadedEntityList.size(); ++lllllllllllIllIIllIlllllIlIIlllI) {
            final Entity lllllllllllIllIIllIlllllIlIIllIl = this.loadedEntityList.get(lllllllllllIllIIllIlllllIlIIlllI);
            final Entity lllllllllllIllIIllIlllllIlIIllII = lllllllllllIllIIllIlllllIlIIllIl.getRidingEntity();
            if (lllllllllllIllIIllIlllllIlIIllII != null) {
                if (!lllllllllllIllIIllIlllllIlIIllII.isDead && lllllllllllIllIIllIlllllIlIIllII.isPassenger(lllllllllllIllIIllIlllllIlIIllIl)) {
                    continue;
                }
                lllllllllllIllIIllIlllllIlIIllIl.dismountRidingEntity();
            }
            if (lllllllllllIllIIllIlllllIlIIllIl.isDead) {
                final int lllllllllllIllIIllIlllllIlIIlIll = lllllllllllIllIIllIlllllIlIIllIl.chunkCoordX;
                final int lllllllllllIllIIllIlllllIlIIlIlI = lllllllllllIllIIllIlllllIlIIllIl.chunkCoordZ;
                if (lllllllllllIllIIllIlllllIlIIllIl.addedToChunk && this.isChunkLoaded(lllllllllllIllIIllIlllllIlIIlIll, lllllllllllIllIIllIlllllIlIIlIlI, true)) {
                    this.getChunkFromChunkCoords(lllllllllllIllIIllIlllllIlIIlIll, lllllllllllIllIIllIlllllIlIIlIlI).removeEntity(lllllllllllIllIIllIlllllIlIIllIl);
                }
                this.loadedEntityList.remove(lllllllllllIllIIllIlllllIlIIlllI--);
                this.onEntityRemoved(lllllllllllIllIIllIlllllIlIIllIl);
            }
        }
    }
    
    public boolean isPlayerUpdate() {
        return this.playerUpdate;
    }
    
    public Entity removeEntityFromWorld(final int lllllllllllIllIIllIlllllllIllIII) {
        final Entity lllllllllllIllIIllIlllllllIllIlI = this.entitiesById.removeObject(lllllllllllIllIIllIlllllllIllIII);
        if (lllllllllllIllIIllIlllllllIllIlI != null) {
            this.entityList.remove(lllllllllllIllIIllIlllllllIllIlI);
            this.removeEntity(lllllllllllIllIIllIlllllllIllIlI);
        }
        return lllllllllllIllIIllIlllllllIllIlI;
    }
    
    @Override
    public void sendPacketToServer(final Packet<?> lllllllllllIllIIllIllllIllIIlIIl) {
        this.connection.sendPacket(lllllllllllIllIIllIllllIllIIlIIl);
    }
    
    @Override
    public void setWorldTime(long lllllllllllIllIIllIllllIlIllllIl) {
        if (lllllllllllIllIIllIllllIlIllllIl < 0L) {
            lllllllllllIllIIllIllllIlIllllIl = -lllllllllllIllIIllIllllIlIllllIl;
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
        }
        else {
            this.getGameRules().setOrCreateGameRule("doDaylightCycle", "true");
        }
        super.setWorldTime(lllllllllllIllIIllIllllIlIllllIl);
    }
    
    @Override
    public void tick() {
        super.tick();
        this.setTotalWorldTime(this.getTotalWorldTime() + 1L);
        if (this.getGameRules().getBoolean("doDaylightCycle")) {
            this.setWorldTime(this.getWorldTime() + 1L);
        }
        this.theProfiler.startSection("reEntryProcessing");
        for (int lllllllllllIllIIlllIIIIIIlIlllll = 0; lllllllllllIllIIlllIIIIIIlIlllll < 10 && !this.entitySpawnQueue.isEmpty(); ++lllllllllllIllIIlllIIIIIIlIlllll) {
            final Entity lllllllllllIllIIlllIIIIIIlIllllI = this.entitySpawnQueue.iterator().next();
            this.entitySpawnQueue.remove(lllllllllllIllIIlllIIIIIIlIllllI);
            if (!this.loadedEntityList.contains(lllllllllllIllIIlllIIIIIIlIllllI)) {
                this.spawnEntityInWorld(lllllllllllIllIIlllIIIIIIlIllllI);
            }
        }
        this.theProfiler.endStartSection("chunkCache");
        this.clientChunkProvider.unloadQueuedChunks();
        this.theProfiler.endStartSection("blocks");
        this.updateBlocks();
        this.theProfiler.endSection();
    }
    
    @Deprecated
    public boolean invalidateRegionAndSetBlock(final BlockPos lllllllllllIllIIllIlllllllIIlIIl, final IBlockState lllllllllllIllIIllIlllllllIIlllI) {
        final int lllllllllllIllIIllIlllllllIIllIl = lllllllllllIllIIllIlllllllIIlIIl.getX();
        final int lllllllllllIllIIllIlllllllIIllII = lllllllllllIllIIllIlllllllIIlIIl.getY();
        final int lllllllllllIllIIllIlllllllIIlIll = lllllllllllIllIIllIlllllllIIlIIl.getZ();
        this.invalidateBlockReceiveRegion(lllllllllllIllIIllIlllllllIIllIl, lllllllllllIllIIllIlllllllIIllII, lllllllllllIllIIllIlllllllIIlIll, lllllllllllIllIIllIlllllllIIllIl, lllllllllllIllIIllIlllllllIIllII, lllllllllllIllIIllIlllllllIIlIll);
        return super.setBlockState(lllllllllllIllIIllIlllllllIIlIIl, lllllllllllIllIIllIlllllllIIlllI, 3);
    }
    
    @Override
    protected boolean isChunkLoaded(final int lllllllllllIllIIlllIIIIIIlIIlIll, final int lllllllllllIllIIlllIIIIIIlIIlIlI, final boolean lllllllllllIllIIlllIIIIIIlIIIlIl) {
        return lllllllllllIllIIlllIIIIIIlIIIlIl || !this.getChunkProvider().provideChunk(lllllllllllIllIIlllIIIIIIlIIlIll, lllllllllllIllIIlllIIIIIIlIIlIlI).isEmpty();
    }
    
    public void doPreChunk(final int lllllllllllIllIIlllIIIIIIIIlIIll, final int lllllllllllIllIIlllIIIIIIIIlIIlI, final boolean lllllllllllIllIIlllIIIIIIIIlIIIl) {
        if (lllllllllllIllIIlllIIIIIIIIlIIIl) {
            this.clientChunkProvider.loadChunk(lllllllllllIllIIlllIIIIIIIIlIIll, lllllllllllIllIIlllIIIIIIIIlIIlI);
        }
        else {
            this.clientChunkProvider.unloadChunk(lllllllllllIllIIlllIIIIIIIIlIIll, lllllllllllIllIIlllIIIIIIIIlIIlI);
            this.markBlockRangeForRenderUpdate(lllllllllllIllIIlllIIIIIIIIlIIll * 16, 0, lllllllllllIllIIlllIIIIIIIIlIIlI * 16, lllllllllllIllIIlllIIIIIIIIlIIll * 16 + 15, 256, lllllllllllIllIIlllIIIIIIIIlIIlI * 16 + 15);
        }
    }
    
    protected void buildChunkCoordList() {
        final int lllllllllllIllIIlllIIIIIIIlllIll = MathHelper.floor(this.mc.player.posX / 16.0);
        final int lllllllllllIllIIlllIIIIIIIlllIlI = MathHelper.floor(this.mc.player.posZ / 16.0);
        if (lllllllllllIllIIlllIIIIIIIlllIll != this.playerChunkX || lllllllllllIllIIlllIIIIIIIlllIlI != this.playerChunkY) {
            this.playerChunkX = lllllllllllIllIIlllIIIIIIIlllIll;
            this.playerChunkY = lllllllllllIllIIlllIIIIIIIlllIlI;
            this.viewableChunks.clear();
            final int lllllllllllIllIIlllIIIIIIIlllIIl = this.mc.gameSettings.renderDistanceChunks;
            this.theProfiler.startSection("buildList");
            final int lllllllllllIllIIlllIIIIIIIlllIII = MathHelper.floor(this.mc.player.posX / 16.0);
            final int lllllllllllIllIIlllIIIIIIIllIlll = MathHelper.floor(this.mc.player.posZ / 16.0);
            for (int lllllllllllIllIIlllIIIIIIIllIllI = -lllllllllllIllIIlllIIIIIIIlllIIl; lllllllllllIllIIlllIIIIIIIllIllI <= lllllllllllIllIIlllIIIIIIIlllIIl; ++lllllllllllIllIIlllIIIIIIIllIllI) {
                for (int lllllllllllIllIIlllIIIIIIIllIlIl = -lllllllllllIllIIlllIIIIIIIlllIIl; lllllllllllIllIIlllIIIIIIIllIlIl <= lllllllllllIllIIlllIIIIIIIlllIIl; ++lllllllllllIllIIlllIIIIIIIllIlIl) {
                    this.viewableChunks.add(new ChunkPos(lllllllllllIllIIlllIIIIIIIllIllI + lllllllllllIllIIlllIIIIIIIlllIII, lllllllllllIllIIlllIIIIIIIllIlIl + lllllllllllIllIIlllIIIIIIIllIlll));
                }
            }
            this.theProfiler.endSection();
        }
    }
    
    @Override
    protected void playMoodSoundAndCheckLight(final int lllllllllllIllIIllIllllllIlIIlll, final int lllllllllllIllIIllIllllllIllIIlI, final Chunk lllllllllllIllIIllIllllllIllIIIl) {
        super.playMoodSoundAndCheckLight(lllllllllllIllIIllIllllllIlIIlll, lllllllllllIllIIllIllllllIllIIlI, lllllllllllIllIIllIllllllIllIIIl);
        if (this.ambienceTicks == 0) {
            final EntityPlayerSP lllllllllllIllIIllIllllllIllIIII = this.mc.player;
            if (lllllllllllIllIIllIllllllIllIIII == null) {
                return;
            }
            if (Math.abs(lllllllllllIllIIllIllllllIllIIII.chunkCoordX - lllllllllllIllIIllIllllllIllIIIl.xPosition) > 1 || Math.abs(lllllllllllIllIIllIllllllIllIIII.chunkCoordZ - lllllllllllIllIIllIllllllIllIIIl.zPosition) > 1) {
                return;
            }
            this.updateLCG = this.updateLCG * 3 + 1013904223;
            final int lllllllllllIllIIllIllllllIlIllll = this.updateLCG >> 2;
            int lllllllllllIllIIllIllllllIlIlllI = lllllllllllIllIIllIllllllIlIllll & 0xF;
            int lllllllllllIllIIllIllllllIlIllIl = lllllllllllIllIIllIllllllIlIllll >> 8 & 0xF;
            int lllllllllllIllIIllIllllllIlIllII = lllllllllllIllIIllIllllllIlIllll >> 16 & 0xFF;
            lllllllllllIllIIllIllllllIlIllII /= 2;
            if (lllllllllllIllIIllIllllllIllIIII.posY > 160.0) {
                lllllllllllIllIIllIllllllIlIllII += 128;
            }
            else if (lllllllllllIllIIllIllllllIllIIII.posY > 96.0) {
                lllllllllllIllIIllIllllllIlIllII += 64;
            }
            final BlockPos lllllllllllIllIIllIllllllIlIlIll = new BlockPos(lllllllllllIllIIllIllllllIlIlllI + lllllllllllIllIIllIllllllIlIIlll, lllllllllllIllIIllIllllllIlIllII, lllllllllllIllIIllIllllllIlIllIl + lllllllllllIllIIllIllllllIllIIlI);
            final IBlockState lllllllllllIllIIllIllllllIlIlIlI = lllllllllllIllIIllIllllllIllIIIl.getBlockState(lllllllllllIllIIllIllllllIlIlIll);
            lllllllllllIllIIllIllllllIlIlllI += lllllllllllIllIIllIllllllIlIIlll;
            lllllllllllIllIIllIllllllIlIllIl += lllllllllllIllIIllIllllllIllIIlI;
            final double lllllllllllIllIIllIllllllIlIlIIl = this.mc.player.getDistanceSq(lllllllllllIllIIllIllllllIlIlllI + 0.5, lllllllllllIllIIllIllllllIlIllII + 0.5, lllllllllllIllIIllIllllllIlIllIl + 0.5);
            if (lllllllllllIllIIllIllllllIlIlIIl < 4.0) {
                return;
            }
            if (lllllllllllIllIIllIllllllIlIlIIl > 255.0) {
                return;
            }
            if (lllllllllllIllIIllIllllllIlIlIlI.getMaterial() == Material.AIR && this.getLight(lllllllllllIllIIllIllllllIlIlIll) <= this.rand.nextInt(8) && this.getLightFor(EnumSkyBlock.SKY, lllllllllllIllIIllIllllllIlIlIll) <= 0) {
                this.playSound(lllllllllllIllIIllIllllllIlIlllI + 0.5, lllllllllllIllIIllIllllllIlIllII + 0.5, lllllllllllIllIIllIllllllIlIllIl + 0.5, SoundEvents.AMBIENT_CAVE, SoundCategory.AMBIENT, 0.7f, 0.8f + this.rand.nextFloat() * 0.2f, false);
                this.ambienceTicks = this.rand.nextInt(12000) + 6000;
            }
        }
    }
    
    private boolean isPlayerActing() {
        if (this.mc.playerController instanceof PlayerControllerOF) {
            final PlayerControllerOF lllllllllllIllIIllIllllIlIIllIll = (PlayerControllerOF)this.mc.playerController;
            return lllllllllllIllIIllIllllIlIIllIll.isActing();
        }
        return false;
    }
    
    public void addEntityToWorld(final int lllllllllllIllIIllIllllllllIllII, final Entity lllllllllllIllIIllIllllllllIIlll) {
        final Entity lllllllllllIllIIllIllllllllIlIlI = this.getEntityByID(lllllllllllIllIIllIllllllllIllII);
        if (lllllllllllIllIIllIllllllllIlIlI != null) {
            this.removeEntity(lllllllllllIllIIllIllllllllIlIlI);
        }
        this.entityList.add(lllllllllllIllIIllIllllllllIIlll);
        lllllllllllIllIIllIllllllllIIlll.setEntityId(lllllllllllIllIIllIllllllllIllII);
        if (!this.spawnEntityInWorld(lllllllllllIllIIllIllllllllIIlll)) {
            this.entitySpawnQueue.add(lllllllllllIllIIllIllllllllIIlll);
        }
        this.entitiesById.addKey(lllllllllllIllIIllIllllllllIllII, lllllllllllIllIIllIllllllllIIlll);
    }
    
    @Override
    public ChunkProviderClient getChunkProvider() {
        return (ChunkProviderClient)super.getChunkProvider();
    }
    
    @Override
    public void makeFireworks(final double lllllllllllIllIIllIllllIllIlllIl, final double lllllllllllIllIIllIllllIllIlIlII, final double lllllllllllIllIIllIllllIllIllIll, final double lllllllllllIllIIllIllllIllIlIIlI, final double lllllllllllIllIIllIllllIllIlIIIl, final double lllllllllllIllIIllIllllIllIlIIII, @Nullable final NBTTagCompound lllllllllllIllIIllIllllIllIlIlll) {
        this.mc.effectRenderer.addEffect(new ParticleFirework.Starter(this, lllllllllllIllIIllIllllIllIlllIl, lllllllllllIllIIllIllllIllIlIlII, lllllllllllIllIIllIllllIllIllIll, lllllllllllIllIIllIllllIllIlIIlI, lllllllllllIllIIllIllllIllIlIIIl, lllllllllllIllIIllIllllIllIlIIII, this.mc.effectRenderer, lllllllllllIllIIllIllllIllIlIlll));
    }
}
