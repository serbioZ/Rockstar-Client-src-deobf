// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server;

import java.util.concurrent.Executors;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import com.google.common.collect.Queues;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.MinecraftException;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import java.awt.GraphicsEnvironment;
import net.minecraft.advancements.FunctionManager;
import net.minecraft.command.CommandBase;
import com.google.common.collect.Lists;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.util.IProgressUpdate;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import net.minecraft.util.ReportedException;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.util.Util;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.IWorldEventListener;
import net.minecraft.world.ServerWorldEventHandler;
import net.minecraft.world.WorldServerMulti;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldServerDemo;
import net.minecraft.world.WorldType;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.UUID;
import java.awt.image.BufferedImage;
import io.netty.buffer.ByteBuf;
import java.nio.charset.StandardCharsets;
import io.netty.handler.codec.base64.Base64;
import java.io.OutputStream;
import java.awt.image.RenderedImage;
import io.netty.buffer.ByteBufOutputStream;
import org.apache.commons.lang3.Validate;
import javax.imageio.ImageIO;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import net.minecraft.world.World;
import net.minecraft.world.GameType;
import java.util.Collections;
import java.util.Arrays;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.MathHelper;
import com.mojang.authlib.GameProfile;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.command.ICommandManager;
import java.util.Random;
import net.minecraft.profiler.Snooper;
import net.minecraft.network.NetworkSystem;
import java.util.concurrent.FutureTask;
import java.util.Queue;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import java.security.KeyPair;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.WorldServer;
import org.apache.logging.log4j.Logger;
import net.minecraft.server.management.PlayerProfileCache;
import com.mojang.authlib.GameProfileRepository;
import java.io.File;
import net.minecraft.server.management.PlayerList;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import net.minecraft.profiler.Profiler;
import net.minecraft.util.ITickable;
import java.util.List;
import net.minecraft.network.ServerStatusResponse;
import java.net.Proxy;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.IThreadListener;
import net.minecraft.profiler.ISnooperInfo;

public abstract class MinecraftServer implements ISnooperInfo, Runnable, IThreadListener, ICommandSender
{
    private /* synthetic */ long timeOfLastWarning;
    private /* synthetic */ boolean onlineMode;
    protected final /* synthetic */ Proxy serverProxy;
    private /* synthetic */ String resourcePackHash;
    private final /* synthetic */ ServerStatusResponse statusResponse;
    private /* synthetic */ boolean canSpawnAnimals;
    private /* synthetic */ String userMessage;
    private /* synthetic */ boolean allowFlight;
    private /* synthetic */ int maxPlayerIdleMinutes;
    private /* synthetic */ String serverOwner;
    private final /* synthetic */ List<ITickable> tickables;
    private /* synthetic */ String folderName;
    public final /* synthetic */ Profiler theProfiler;
    private /* synthetic */ long nanoTimeSinceStatusRefresh;
    private /* synthetic */ boolean isDemo;
    private /* synthetic */ boolean serverRunning;
    public /* synthetic */ long[][] timeOfLastDimensionTick;
    private final /* synthetic */ YggdrasilAuthenticationService authService;
    private /* synthetic */ PlayerList playerList;
    public /* synthetic */ int percentDone;
    private /* synthetic */ int tickCounter;
    private /* synthetic */ boolean serverIsRunning;
    public /* synthetic */ String currentTask;
    private /* synthetic */ boolean field_190519_A;
    private final /* synthetic */ GameProfileRepository profileRepo;
    private /* synthetic */ boolean startProfiling;
    private /* synthetic */ long currentTime;
    private final /* synthetic */ PlayerProfileCache profileCache;
    private /* synthetic */ boolean enableBonusChest;
    private static final /* synthetic */ Logger LOG;
    public /* synthetic */ WorldServer[] worldServers;
    private /* synthetic */ String worldName;
    private final /* synthetic */ ISaveFormat anvilConverterForAnvilFile;
    private /* synthetic */ String resourcePackUrl;
    private /* synthetic */ KeyPair serverKeyPair;
    private final /* synthetic */ MinecraftSessionService sessionService;
    public final /* synthetic */ Queue<FutureTask<?>> futureTaskQueue;
    private /* synthetic */ boolean isGamemodeForced;
    private /* synthetic */ boolean serverStopped;
    public final /* synthetic */ long[] tickTimeArray;
    private /* synthetic */ Thread serverThread;
    private /* synthetic */ int serverPort;
    private final /* synthetic */ NetworkSystem networkSystem;
    private /* synthetic */ boolean canSpawnNPCs;
    private /* synthetic */ boolean worldIconSet;
    private final /* synthetic */ Snooper usageSnooper;
    private final /* synthetic */ File anvilFile;
    private final /* synthetic */ Random random;
    private /* synthetic */ String motd;
    public final /* synthetic */ ICommandManager commandManager;
    private /* synthetic */ int buildLimit;
    private final /* synthetic */ DataFixer dataFixer;
    private /* synthetic */ boolean pvpEnabled;
    
    public void setAllowFlight(final boolean lllllllllllllIIIIIIllIIlIlIlllIl) {
        this.allowFlight = lllllllllllllIIIIIIllIIlIlIlllIl;
    }
    
    @Override
    public String getName() {
        return "Server";
    }
    
    @Override
    public MinecraftServer getServer() {
        return this;
    }
    
    @Override
    public boolean isCallingFromMinecraftThread() {
        return Thread.currentThread() == this.serverThread;
    }
    
    public void tick() {
        final long lllllllllllllIIIIIIllIlIIllllIll = System.nanoTime();
        ++this.tickCounter;
        if (this.startProfiling) {
            this.startProfiling = false;
            this.theProfiler.profilingEnabled = true;
            this.theProfiler.clearProfiling();
        }
        this.theProfiler.startSection("root");
        this.updateTimeLightAndEntities();
        if (lllllllllllllIIIIIIllIlIIllllIll - this.nanoTimeSinceStatusRefresh >= 5000000000L) {
            this.nanoTimeSinceStatusRefresh = lllllllllllllIIIIIIllIlIIllllIll;
            this.statusResponse.setPlayers(new ServerStatusResponse.Players(this.getMaxPlayers(), this.getCurrentPlayerCount()));
            final GameProfile[] lllllllllllllIIIIIIllIlIIllllIlI = new GameProfile[Math.min(this.getCurrentPlayerCount(), 12)];
            final int lllllllllllllIIIIIIllIlIIllllIIl = MathHelper.getInt(this.random, 0, this.getCurrentPlayerCount() - lllllllllllllIIIIIIllIlIIllllIlI.length);
            for (int lllllllllllllIIIIIIllIlIIllllIII = 0; lllllllllllllIIIIIIllIlIIllllIII < lllllllllllllIIIIIIllIlIIllllIlI.length; ++lllllllllllllIIIIIIllIlIIllllIII) {
                lllllllllllllIIIIIIllIlIIllllIlI[lllllllllllllIIIIIIllIlIIllllIII] = this.playerList.getPlayerList().get(lllllllllllllIIIIIIllIlIIllllIIl + lllllllllllllIIIIIIllIlIIllllIII).getGameProfile();
            }
            Collections.shuffle(Arrays.asList(lllllllllllllIIIIIIllIlIIllllIlI));
            this.statusResponse.getPlayers().setPlayers(lllllllllllllIIIIIIllIlIIllllIlI);
        }
        if (this.tickCounter % 900 == 0) {
            this.theProfiler.startSection("save");
            this.playerList.saveAllPlayerData();
            this.saveAllWorlds(true);
            this.theProfiler.endSection();
        }
        this.theProfiler.startSection("tallying");
        this.tickTimeArray[this.tickCounter % 100] = System.nanoTime() - lllllllllllllIIIIIIllIlIIllllIll;
        this.theProfiler.endSection();
        this.theProfiler.startSection("snooper");
        if (!this.usageSnooper.isSnooperRunning() && this.tickCounter > 100) {
            this.usageSnooper.startSnooper();
        }
        if (this.tickCounter % 6000 == 0) {
            this.usageSnooper.addMemoryStatsToSnooper();
        }
        this.theProfiler.endSection();
        this.theProfiler.endSection();
    }
    
    public String getMinecraftVersion() {
        return "1.12.2";
    }
    
    public void setGameType(final GameType lllllllllllllIIIIIIllIIlIIllIlll) {
        final int lllllllllllllIIIIIIllIIlIIllIIII;
        final String lllllllllllllIIIIIIllIIlIIllIIIl = (String)((WorldServer[])(Object)(lllllllllllllIIIIIIllIIlIIllIIII = (int)(Object)this.worldServers)).length;
        for (double lllllllllllllIIIIIIllIIlIIllIIlI = 0; lllllllllllllIIIIIIllIIlIIllIIlI < lllllllllllllIIIIIIllIIlIIllIIIl; ++lllllllllllllIIIIIIllIIlIIllIIlI) {
            final WorldServer lllllllllllllIIIIIIllIIlIIllIllI = lllllllllllllIIIIIIllIIlIIllIIII[lllllllllllllIIIIIIllIIlIIllIIlI];
            lllllllllllllIIIIIIllIIlIIllIllI.getWorldInfo().setGameType(lllllllllllllIIIIIIllIIlIIllIlll);
        }
    }
    
    public boolean allowSpawnMonsters() {
        return true;
    }
    
    public boolean isServerStopped() {
        return this.serverStopped;
    }
    
    public int getMaxWorldSize() {
        return 29999984;
    }
    
    @Override
    public World getEntityWorld() {
        return this.worldServers[0];
    }
    
    public void setFolderName(final String lllllllllllllIIIIIIllIIllllIlIll) {
        this.folderName = lllllllllllllIIIIIIllIIllllIlIll;
    }
    
    public String getServerOwner() {
        return this.serverOwner;
    }
    
    public boolean getGuiEnabled() {
        return false;
    }
    
    public void enableProfiling() {
        this.startProfiling = true;
    }
    
    static {
        LOG = LogManager.getLogger();
        USER_CACHE_FILE = new File("usercache.json");
    }
    
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
    
    public int getBuildLimit() {
        return this.buildLimit;
    }
    
    @Override
    public boolean isSnooperEnabled() {
        return true;
    }
    
    public void setServerOwner(final String lllllllllllllIIIIIIllIIlllllIlll) {
        this.serverOwner = lllllllllllllIIIIIIllIIlllllIlll;
    }
    
    public String getResourcePackUrl() {
        return this.resourcePackUrl;
    }
    
    public String getServerModName() {
        return "vanilla";
    }
    
    public abstract boolean startServer() throws IOException;
    
    public GameProfile[] getGameProfiles() {
        return this.playerList.getAllProfiles();
    }
    
    public void applyServerIconToResponse(final ServerStatusResponse lllllllllllllIIIIIIllIlIlIIllIII) {
        File lllllllllllllIIIIIIllIlIlIIlIlll = this.getFile("server-icon.png");
        if (!lllllllllllllIIIIIIllIlIlIIlIlll.exists()) {
            lllllllllllllIIIIIIllIlIlIIlIlll = this.getActiveAnvilConverter().getFile(this.getFolderName(), "icon.png");
        }
        if (lllllllllllllIIIIIIllIlIlIIlIlll.isFile()) {
            final ByteBuf lllllllllllllIIIIIIllIlIlIIlIllI = Unpooled.buffer();
            try {
                final BufferedImage lllllllllllllIIIIIIllIlIlIIlIlIl = ImageIO.read(lllllllllllllIIIIIIllIlIlIIlIlll);
                Validate.validState(lllllllllllllIIIIIIllIlIlIIlIlIl.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
                Validate.validState(lllllllllllllIIIIIIllIlIlIIlIlIl.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
                ImageIO.write(lllllllllllllIIIIIIllIlIlIIlIlIl, "PNG", (OutputStream)new ByteBufOutputStream(lllllllllllllIIIIIIllIlIlIIlIllI));
                final ByteBuf lllllllllllllIIIIIIllIlIlIIlIlII = Base64.encode(lllllllllllllIIIIIIllIlIlIIlIllI);
                lllllllllllllIIIIIIllIlIlIIllIII.setFavicon("data:image/png;base64," + lllllllllllllIIIIIIllIlIlIIlIlII.toString(StandardCharsets.UTF_8));
            }
            catch (Exception lllllllllllllIIIIIIllIlIlIIlIIll) {
                MinecraftServer.LOG.error("Couldn't load server icon", (Throwable)lllllllllllllIIIIIIllIlIlIIlIIll);
                return;
            }
            finally {
                lllllllllllllIIIIIIllIlIlIIlIllI.release();
            }
            lllllllllllllIIIIIIllIlIlIIlIllI.release();
        }
    }
    
    public int getCurrentPlayerCount() {
        return this.playerList.getCurrentPlayerCount();
    }
    
    public void setCanSpawnAnimals(final boolean lllllllllllllIIIIIIllIIlIllllIII) {
        this.canSpawnAnimals = lllllllllllllIIIIIIllIIlIllllIII;
    }
    
    public String[] getAllUsernames() {
        return this.playerList.getAllUsernames();
    }
    
    public void setBuildLimit(final int lllllllllllllIIIIIIllIIlIlIIlIll) {
        this.buildLimit = lllllllllllllIIIIIIllIIlIlIIlIll;
    }
    
    public Proxy getServerProxy() {
        return this.serverProxy;
    }
    
    @Nullable
    public Entity getEntityFromUuid(final UUID lllllllllllllIIIIIIllIIIlllIlllI) {
        final String lllllllllllllIIIIIIllIIIlllIlIlI;
        final short lllllllllllllIIIIIIllIIIlllIlIll = (short)((WorldServer[])(Object)(lllllllllllllIIIIIIllIIIlllIlIlI = (String)(Object)this.worldServers)).length;
        for (String lllllllllllllIIIIIIllIIIlllIllII = (String)0; lllllllllllllIIIIIIllIIIlllIllII < lllllllllllllIIIIIIllIIIlllIlIll; ++lllllllllllllIIIIIIllIIIlllIllII) {
            final WorldServer lllllllllllllIIIIIIllIIIllllIIIl = lllllllllllllIIIIIIllIIIlllIlIlI[lllllllllllllIIIIIIllIIIlllIllII];
            if (lllllllllllllIIIIIIllIIIllllIIIl != null) {
                final Entity lllllllllllllIIIIIIllIIIllllIIII = lllllllllllllIIIIIIllIIIllllIIIl.getEntityFromUuid(lllllllllllllIIIIIIllIIIlllIlllI);
                if (lllllllllllllIIIIIIllIIIllllIIII != null) {
                    return lllllllllllllIIIIIIllIIIllllIIII;
                }
            }
        }
        return null;
    }
    
    public void startServerThread() {
        this.serverThread = new Thread(this, "Server thread");
        this.serverThread.start();
    }
    
    public void stopServer() {
        MinecraftServer.LOG.info("Stopping server");
        if (this.getNetworkSystem() != null) {
            this.getNetworkSystem().terminateEndpoints();
        }
        if (this.playerList != null) {
            MinecraftServer.LOG.info("Saving players");
            this.playerList.saveAllPlayerData();
            this.playerList.removeAllPlayers();
        }
        if (this.worldServers != null) {
            MinecraftServer.LOG.info("Saving worlds");
            int lllllllllllllIIIIIIllIlIllIIIIIl;
            String lllllllllllllIIIIIIllIlIllIIIIlI = (String)((WorldServer[])(Object)(lllllllllllllIIIIIIllIlIllIIIIIl = (int)(Object)this.worldServers)).length;
            for (long lllllllllllllIIIIIIllIlIllIIIIll = 0; lllllllllllllIIIIIIllIlIllIIIIll < lllllllllllllIIIIIIllIlIllIIIIlI; ++lllllllllllllIIIIIIllIlIllIIIIll) {
                final WorldServer lllllllllllllIIIIIIllIlIllIIIlll = lllllllllllllIIIIIIllIlIllIIIIIl[lllllllllllllIIIIIIllIlIllIIIIll];
                if (lllllllllllllIIIIIIllIlIllIIIlll != null) {
                    lllllllllllllIIIIIIllIlIllIIIlll.disableLevelSaving = false;
                }
            }
            this.saveAllWorlds(false);
            lllllllllllllIIIIIIllIlIllIIIIlI = (String)((WorldServer[])(Object)(lllllllllllllIIIIIIllIlIllIIIIIl = (int)(Object)this.worldServers)).length;
            for (long lllllllllllllIIIIIIllIlIllIIIIll = 0; lllllllllllllIIIIIIllIlIllIIIIll < lllllllllllllIIIIIIllIlIllIIIIlI; ++lllllllllllllIIIIIIllIlIllIIIIll) {
                final WorldServer lllllllllllllIIIIIIllIlIllIIIllI = lllllllllllllIIIIIIllIlIllIIIIIl[lllllllllllllIIIIIIllIlIllIIIIll];
                if (lllllllllllllIIIIIIllIlIllIIIllI != null) {
                    lllllllllllllIIIIIIllIlIllIIIllI.flush();
                }
            }
        }
        if (this.usageSnooper.isSnooperRunning()) {
            this.usageSnooper.stopSnooper();
        }
    }
    
    public void setPlayerList(final PlayerList lllllllllllllIIIIIIllIIlIIllllll) {
        this.playerList = lllllllllllllIIIIIIllIIlIIllllll;
    }
    
    public boolean isDemo() {
        return this.isDemo;
    }
    
    public boolean getCanSpawnAnimals() {
        return this.canSpawnAnimals;
    }
    
    public abstract boolean canStructuresSpawn();
    
    public boolean isBlockProtected(final World lllllllllllllIIIIIIllIIlIIIllIll, final BlockPos lllllllllllllIIIIIIllIIlIIIllIlI, final EntityPlayer lllllllllllllIIIIIIllIIlIIIllIIl) {
        return false;
    }
    
    @Nullable
    public synchronized String getUserMessage() {
        return this.userMessage;
    }
    
    public CrashReport addServerInfoToCrashReport(final CrashReport lllllllllllllIIIIIIllIlIIIllIllI) {
        lllllllllllllIIIIIIllIlIIIllIllI.getCategory().setDetail("Profiler Position", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return MinecraftServer.this.theProfiler.profilingEnabled ? MinecraftServer.this.theProfiler.getNameOfLastSection() : "N/A (disabled)";
            }
        });
        if (this.playerList != null) {
            lllllllllllllIIIIIIllIlIIIllIllI.getCategory().setDetail("Player Count", new ICrashReportDetail<String>() {
                @Override
                public String call() {
                    return String.valueOf(MinecraftServer.this.playerList.getCurrentPlayerCount()) + " / " + MinecraftServer.this.playerList.getMaxPlayers() + "; " + MinecraftServer.this.playerList.getPlayerList();
                }
            });
        }
        return lllllllllllllIIIIIIllIlIIIllIllI;
    }
    
    @Override
    public boolean sendCommandFeedback() {
        return this.worldServers[0].getGameRules().getBoolean("sendCommandFeedback");
    }
    
    public void loadAllWorlds(final String lllllllllllllIIIIIIllIllIIlllIII, final String lllllllllllllIIIIIIllIllIIllIlll, final long lllllllllllllIIIIIIllIllIIlIlIIl, final WorldType lllllllllllllIIIIIIllIllIIllIlIl, final String lllllllllllllIIIIIIllIllIIllIlII) {
        this.convertMapIfNeeded(lllllllllllllIIIIIIllIllIIlllIII);
        this.setUserMessage("menu.loadingLevel");
        this.worldServers = new WorldServer[3];
        this.timeOfLastDimensionTick = new long[this.worldServers.length][100];
        final ISaveHandler lllllllllllllIIIIIIllIllIIllIIll = this.anvilConverterForAnvilFile.getSaveLoader(lllllllllllllIIIIIIllIllIIlllIII, true);
        this.setResourcePackFromWorld(this.getFolderName(), lllllllllllllIIIIIIllIllIIllIIll);
        WorldInfo lllllllllllllIIIIIIllIllIIllIIlI = lllllllllllllIIIIIIllIllIIllIIll.loadWorldInfo();
        WorldSettings lllllllllllllIIIIIIllIllIIlIllll;
        if (lllllllllllllIIIIIIllIllIIllIIlI == null) {
            WorldSettings lllllllllllllIIIIIIllIllIIllIIII = null;
            if (this.isDemo()) {
                final WorldSettings lllllllllllllIIIIIIllIllIIllIIIl = WorldServerDemo.DEMO_WORLD_SETTINGS;
            }
            else {
                lllllllllllllIIIIIIllIllIIllIIII = new WorldSettings(lllllllllllllIIIIIIllIllIIlIlIIl, this.getGameType(), this.canStructuresSpawn(), this.isHardcore(), lllllllllllllIIIIIIllIllIIllIlIl);
                lllllllllllllIIIIIIllIllIIllIIII.setGeneratorOptions(lllllllllllllIIIIIIllIllIIllIlII);
                if (this.enableBonusChest) {
                    lllllllllllllIIIIIIllIllIIllIIII.enableBonusChest();
                }
            }
            lllllllllllllIIIIIIllIllIIllIIlI = new WorldInfo(lllllllllllllIIIIIIllIllIIllIIII, lllllllllllllIIIIIIllIllIIllIlll);
        }
        else {
            lllllllllllllIIIIIIllIllIIllIIlI.setWorldName(lllllllllllllIIIIIIllIllIIllIlll);
            lllllllllllllIIIIIIllIllIIlIllll = new WorldSettings(lllllllllllllIIIIIIllIllIIllIIlI);
        }
        for (int lllllllllllllIIIIIIllIllIIlIlllI = 0; lllllllllllllIIIIIIllIllIIlIlllI < this.worldServers.length; ++lllllllllllllIIIIIIllIllIIlIlllI) {
            int lllllllllllllIIIIIIllIllIIlIllIl = 0;
            if (lllllllllllllIIIIIIllIllIIlIlllI == 1) {
                lllllllllllllIIIIIIllIllIIlIllIl = -1;
            }
            if (lllllllllllllIIIIIIllIllIIlIlllI == 2) {
                lllllllllllllIIIIIIllIllIIlIllIl = 1;
            }
            if (lllllllllllllIIIIIIllIllIIlIlllI == 0) {
                if (this.isDemo()) {
                    this.worldServers[lllllllllllllIIIIIIllIllIIlIlllI] = (WorldServer)new WorldServerDemo(this, lllllllllllllIIIIIIllIllIIllIIll, lllllllllllllIIIIIIllIllIIllIIlI, lllllllllllllIIIIIIllIllIIlIllIl, this.theProfiler).init();
                }
                else {
                    this.worldServers[lllllllllllllIIIIIIllIllIIlIlllI] = (WorldServer)new WorldServer(this, lllllllllllllIIIIIIllIllIIllIIll, lllllllllllllIIIIIIllIllIIllIIlI, lllllllllllllIIIIIIllIllIIlIllIl, this.theProfiler).init();
                }
                this.worldServers[lllllllllllllIIIIIIllIllIIlIlllI].initialize(lllllllllllllIIIIIIllIllIIlIllll);
            }
            else {
                this.worldServers[lllllllllllllIIIIIIllIllIIlIlllI] = (WorldServer)new WorldServerMulti(this, lllllllllllllIIIIIIllIllIIllIIll, lllllllllllllIIIIIIllIllIIlIllIl, this.worldServers[0], this.theProfiler).init();
            }
            this.worldServers[lllllllllllllIIIIIIllIllIIlIlllI].addEventListener(new ServerWorldEventHandler(this, this.worldServers[lllllllllllllIIIIIIllIllIIlIlllI]));
            if (!this.isSinglePlayer()) {
                this.worldServers[lllllllllllllIIIIIIllIllIIlIlllI].getWorldInfo().setGameType(this.getGameType());
            }
        }
        this.playerList.setPlayerManager(this.worldServers);
        this.setDifficultyForAllWorlds(this.getDifficulty());
        this.initialWorldChunkLoad();
    }
    
    public boolean isWorldIconSet() {
        this.worldIconSet = (this.worldIconSet || this.getWorldIconFile().isFile());
        return this.worldIconSet;
    }
    
    public int getTickCounter() {
        return this.tickCounter;
    }
    
    public void updateTimeLightAndEntities() {
        this.theProfiler.startSection("jobs");
        synchronized (this.futureTaskQueue) {
            while (!this.futureTaskQueue.isEmpty()) {
                Util.runTask(this.futureTaskQueue.poll(), MinecraftServer.LOG);
            }
        }
        // monitorexit(this.futureTaskQueue)
        this.theProfiler.endStartSection("levels");
        for (int lllllllllllllIIIIIIllIlIIllIlIll = 0; lllllllllllllIIIIIIllIlIIllIlIll < this.worldServers.length; ++lllllllllllllIIIIIIllIlIIllIlIll) {
            final long lllllllllllllIIIIIIllIlIIllIlIlI = System.nanoTime();
            if (lllllllllllllIIIIIIllIlIIllIlIll == 0 || this.getAllowNether()) {
                final WorldServer lllllllllllllIIIIIIllIlIIllIlIIl = this.worldServers[lllllllllllllIIIIIIllIlIIllIlIll];
                this.theProfiler.func_194340_a(() -> lllllllllllllIIIIIIllIlIIllIlIIl.getWorldInfo().getWorldName());
                if (this.tickCounter % 20 == 0) {
                    this.theProfiler.startSection("timeSync");
                    this.playerList.sendPacketToAllPlayersInDimension(new SPacketTimeUpdate(lllllllllllllIIIIIIllIlIIllIlIIl.getTotalWorldTime(), lllllllllllllIIIIIIllIlIIllIlIIl.getWorldTime(), lllllllllllllIIIIIIllIlIIllIlIIl.getGameRules().getBoolean("doDaylightCycle")), lllllllllllllIIIIIIllIlIIllIlIIl.provider.getDimensionType().getId());
                    this.theProfiler.endSection();
                }
                this.theProfiler.startSection("tick");
                try {
                    lllllllllllllIIIIIIllIlIIllIlIIl.tick();
                }
                catch (Throwable lllllllllllllIIIIIIllIlIIllIlIII) {
                    final CrashReport lllllllllllllIIIIIIllIlIIllIIlll = CrashReport.makeCrashReport(lllllllllllllIIIIIIllIlIIllIlIII, "Exception ticking world");
                    lllllllllllllIIIIIIllIlIIllIlIIl.addWorldInfoToCrashReport(lllllllllllllIIIIIIllIlIIllIIlll);
                    throw new ReportedException(lllllllllllllIIIIIIllIlIIllIIlll);
                }
                try {
                    lllllllllllllIIIIIIllIlIIllIlIIl.updateEntities();
                }
                catch (Throwable lllllllllllllIIIIIIllIlIIllIIllI) {
                    final CrashReport lllllllllllllIIIIIIllIlIIllIIlIl = CrashReport.makeCrashReport(lllllllllllllIIIIIIllIlIIllIIllI, "Exception ticking world entities");
                    lllllllllllllIIIIIIllIlIIllIlIIl.addWorldInfoToCrashReport(lllllllllllllIIIIIIllIlIIllIIlIl);
                    throw new ReportedException(lllllllllllllIIIIIIllIlIIllIIlIl);
                }
                this.theProfiler.endSection();
                this.theProfiler.startSection("tracker");
                lllllllllllllIIIIIIllIlIIllIlIIl.getEntityTracker().updateTrackedEntities();
                this.theProfiler.endSection();
                this.theProfiler.endSection();
            }
            this.timeOfLastDimensionTick[lllllllllllllIIIIIIllIlIIllIlIll][this.tickCounter % 100] = System.nanoTime() - lllllllllllllIIIIIIllIlIIllIlIlI;
        }
        this.theProfiler.endStartSection("connection");
        this.getNetworkSystem().networkTick();
        this.theProfiler.endStartSection("players");
        this.playerList.onTick();
        this.theProfiler.endStartSection("commandFunctions");
        this.func_193030_aL().update();
        this.theProfiler.endStartSection("tickables");
        for (int lllllllllllllIIIIIIllIlIIllIIlII = 0; lllllllllllllIIIIIIllIlIIllIIlII < this.tickables.size(); ++lllllllllllllIIIIIIllIlIIllIIlII) {
            this.tickables.get(lllllllllllllIIIIIIllIlIIllIIlII).update();
        }
        this.theProfiler.endSection();
    }
    
    public abstract boolean shouldBroadcastConsoleToOps();
    
    public void systemExitNow() {
    }
    
    public File getWorldIconFile() {
        return this.getActiveAnvilConverter().getFile(this.getFolderName(), "icon.png");
    }
    
    public void setKeyPair(final KeyPair lllllllllllllIIIIIIllIIlllIlllII) {
        this.serverKeyPair = lllllllllllllIIIIIIllIIlllIlllII;
    }
    
    protected synchronized void setUserMessage(final String lllllllllllllIIIIIIllIllIlIIlIlI) {
        this.userMessage = lllllllllllllIIIIIIllIllIlIIlIlI;
    }
    
    public <V> ListenableFuture<V> callFromMainThread(final Callable<V> lllllllllllllIIIIIIllIIIllIllIII) {
        Validate.notNull((Object)lllllllllllllIIIIIIllIIIllIllIII);
        if (!this.isCallingFromMinecraftThread() && !this.isServerStopped()) {
            final ListenableFutureTask<V> lllllllllllllIIIIIIllIIIllIllIll = (ListenableFutureTask<V>)ListenableFutureTask.create((Callable)lllllllllllllIIIIIIllIIIllIllIII);
            synchronized (this.futureTaskQueue) {
                this.futureTaskQueue.add((FutureTask<?>)lllllllllllllIIIIIIllIIIllIllIll);
                final ListenableFutureTask<V> listenableFutureTask = lllllllllllllIIIIIIllIIIllIllIll;
                // monitorexit(this.futureTaskQueue)
                return (ListenableFuture<V>)listenableFutureTask;
            }
        }
        try {
            return (ListenableFuture<V>)Futures.immediateFuture((Object)lllllllllllllIIIIIIllIIIllIllIII.call());
        }
        catch (Exception lllllllllllllIIIIIIllIIIllIllIlI) {
            return (ListenableFuture<V>)Futures.immediateFailedCheckedFuture(lllllllllllllIIIIIIllIIIllIllIlI);
        }
    }
    
    public String getWorldName() {
        return this.worldName;
    }
    
    public KeyPair getKeyPair() {
        return this.serverKeyPair;
    }
    
    public String getFolderName() {
        return this.folderName;
    }
    
    public void convertMapIfNeeded(final String lllllllllllllIIIIIIllIllIlIlIIII) {
        if (this.getActiveAnvilConverter().isOldMapFormat(lllllllllllllIIIIIIllIllIlIlIIII)) {
            MinecraftServer.LOG.info("Converting map!");
            this.setUserMessage("menu.convertingLevel");
            this.getActiveAnvilConverter().convertMapFormat(lllllllllllllIIIIIIllIllIlIlIIII, new IProgressUpdate() {
                private /* synthetic */ long startTime = System.currentTimeMillis();
                
                @Override
                public void setDoneWorking() {
                }
                
                @Override
                public void resetProgressAndMessage(final String llllllllllIlllllIIlIIllllIllllIl) {
                }
                
                @Override
                public void setLoadingProgress(final int llllllllllIlllllIIlIIllllIllIlll) {
                    if (System.currentTimeMillis() - this.startTime >= 1000L) {
                        this.startTime = System.currentTimeMillis();
                        MinecraftServer.LOG.info("Converting... {}%", (Object)llllllllllIlllllIIlIIllllIllIlll);
                    }
                }
                
                @Override
                public void displayLoadingString(final String llllllllllIlllllIIlIIllllIllIlII) {
                }
                
                @Override
                public void displaySavingString(final String llllllllllIlllllIIlIIllllIllllll) {
                }
            });
        }
    }
    
    public void setDemo(final boolean lllllllllllllIIIIIIllIIlllIIIIIl) {
        this.isDemo = lllllllllllllIIIIIIllIIlllIIIIIl;
    }
    
    public void func_193031_aM() {
        if (this.isCallingFromMinecraftThread()) {
            this.getPlayerList().saveAllPlayerData();
            this.worldServers[0].getLootTableManager().reloadLootTables();
            this.func_191949_aK().func_192779_a();
            this.func_193030_aL().func_193059_f();
            this.getPlayerList().func_193244_w();
        }
        else {
            this.addScheduledTask(this::func_193031_aM);
        }
    }
    
    public boolean isServerInOnlineMode() {
        return this.onlineMode;
    }
    
    public MinecraftSessionService getMinecraftSessionService() {
        return this.sessionService;
    }
    
    public int getMaxPlayers() {
        return this.playerList.getMaxPlayers();
    }
    
    public ServerStatusResponse getServerStatusResponse() {
        return this.statusResponse;
    }
    
    public boolean getForceGamemode() {
        return this.isGamemodeForced;
    }
    
    public void setMOTD(final String lllllllllllllIIIIIIllIIlIlIlIlII) {
        this.motd = lllllllllllllIIIIIIllIIlIlIlIlII;
    }
    
    public ServerCommandManager createNewCommandManager() {
        return new ServerCommandManager(this);
    }
    
    public boolean isServerRunning() {
        return this.serverRunning;
    }
    
    public boolean getCanSpawnNPCs() {
        return this.canSpawnNPCs;
    }
    
    public void initialWorldChunkLoad() {
        final int lllllllllllllIIIIIIllIllIIIlIIll = 16;
        final int lllllllllllllIIIIIIllIllIIIlIIlI = 4;
        final int lllllllllllllIIIIIIllIllIIIlIIIl = 192;
        final int lllllllllllllIIIIIIllIllIIIlIIII = 625;
        int lllllllllllllIIIIIIllIllIIIIllll = 0;
        this.setUserMessage("menu.generatingTerrain");
        final int lllllllllllllIIIIIIllIllIIIIlllI = 0;
        MinecraftServer.LOG.info("Preparing start region for level 0");
        final WorldServer lllllllllllllIIIIIIllIllIIIIllIl = this.worldServers[0];
        final BlockPos lllllllllllllIIIIIIllIllIIIIllII = lllllllllllllIIIIIIllIllIIIIllIl.getSpawnPoint();
        long lllllllllllllIIIIIIllIllIIIIlIll = getCurrentTimeMillis();
        for (int lllllllllllllIIIIIIllIllIIIIlIlI = -192; lllllllllllllIIIIIIllIllIIIIlIlI <= 192 && this.isServerRunning(); lllllllllllllIIIIIIllIllIIIIlIlI += 16) {
            for (int lllllllllllllIIIIIIllIllIIIIlIIl = -192; lllllllllllllIIIIIIllIllIIIIlIIl <= 192 && this.isServerRunning(); lllllllllllllIIIIIIllIllIIIIlIIl += 16) {
                final long lllllllllllllIIIIIIllIllIIIIlIII = getCurrentTimeMillis();
                if (lllllllllllllIIIIIIllIllIIIIlIII - lllllllllllllIIIIIIllIllIIIIlIll > 1000L) {
                    this.outputPercentRemaining("Preparing spawn area", lllllllllllllIIIIIIllIllIIIIllll * 100 / 625);
                    lllllllllllllIIIIIIllIllIIIIlIll = lllllllllllllIIIIIIllIllIIIIlIII;
                }
                ++lllllllllllllIIIIIIllIllIIIIllll;
                lllllllllllllIIIIIIllIllIIIIllIl.getChunkProvider().provideChunk(lllllllllllllIIIIIIllIllIIIIllII.getX() + lllllllllllllIIIIIIllIllIIIIlIlI >> 4, lllllllllllllIIIIIIllIllIIIIllII.getZ() + lllllllllllllIIIIIIllIllIIIIlIIl >> 4);
            }
        }
        this.clearCurrentTask();
    }
    
    public NetworkSystem getNetworkSystem() {
        return this.networkSystem;
    }
    
    public AdvancementManager func_191949_aK() {
        return this.worldServers[0].func_191952_z();
    }
    
    public Snooper getPlayerUsageSnooper() {
        return this.usageSnooper;
    }
    
    public int getNetworkCompressionThreshold() {
        return 256;
    }
    
    public List<String> getTabCompletions(final ICommandSender lllllllllllllIIIIIIllIlIIIlIIlll, String lllllllllllllIIIIIIllIlIIIIllIIl, @Nullable final BlockPos lllllllllllllIIIIIIllIlIIIIllIII, final boolean lllllllllllllIIIIIIllIlIIIlIIlII) {
        final List<String> lllllllllllllIIIIIIllIlIIIlIIIll = (List<String>)Lists.newArrayList();
        final boolean lllllllllllllIIIIIIllIlIIIlIIIlI = ((String)lllllllllllllIIIIIIllIlIIIIllIIl).startsWith("/");
        if (lllllllllllllIIIIIIllIlIIIlIIIlI) {
            lllllllllllllIIIIIIllIlIIIIllIIl = ((String)lllllllllllllIIIIIIllIlIIIIllIIl).substring(1);
        }
        if (!lllllllllllllIIIIIIllIlIIIlIIIlI && !lllllllllllllIIIIIIllIlIIIlIIlII) {
            final String[] lllllllllllllIIIIIIllIlIIIlIIIIl = ((String)lllllllllllllIIIIIIllIlIIIIllIIl).split(" ", -1);
            final String lllllllllllllIIIIIIllIlIIIlIIIII = lllllllllllllIIIIIIllIlIIIlIIIIl[lllllllllllllIIIIIIllIlIIIlIIIIl.length - 1];
            final float lllllllllllllIIIIIIllIlIIIIIllll;
            final float lllllllllllllIIIIIIllIlIIIIlIIII = ((String[])(Object)(lllllllllllllIIIIIIllIlIIIIIllll = (float)(Object)this.playerList.getAllUsernames())).length;
            for (boolean lllllllllllllIIIIIIllIlIIIIlIIIl = false; (lllllllllllllIIIIIIllIlIIIIlIIIl ? 1 : 0) < lllllllllllllIIIIIIllIlIIIIlIIII; ++lllllllllllllIIIIIIllIlIIIIlIIIl) {
                final String lllllllllllllIIIIIIllIlIIIIlllll = lllllllllllllIIIIIIllIlIIIIIllll[lllllllllllllIIIIIIllIlIIIIlIIIl];
                if (CommandBase.doesStringStartWith(lllllllllllllIIIIIIllIlIIIlIIIII, lllllllllllllIIIIIIllIlIIIIlllll)) {
                    lllllllllllllIIIIIIllIlIIIlIIIll.add(lllllllllllllIIIIIIllIlIIIIlllll);
                }
            }
            return lllllllllllllIIIIIIllIlIIIlIIIll;
        }
        final boolean lllllllllllllIIIIIIllIlIIIIllllI = !((String)lllllllllllllIIIIIIllIlIIIIllIIl).contains(" ");
        final List<String> lllllllllllllIIIIIIllIlIIIIlllIl = this.commandManager.getTabCompletionOptions(lllllllllllllIIIIIIllIlIIIlIIlll, (String)lllllllllllllIIIIIIllIlIIIIllIIl, lllllllllllllIIIIIIllIlIIIIllIII);
        if (!lllllllllllllIIIIIIllIlIIIIlllIl.isEmpty()) {
            for (final String lllllllllllllIIIIIIllIlIIIIlllII : lllllllllllllIIIIIIllIlIIIIlllIl) {
                if (lllllllllllllIIIIIIllIlIIIIllllI && !lllllllllllllIIIIIIllIlIIIlIIlII) {
                    lllllllllllllIIIIIIllIlIIIlIIIll.add("/" + lllllllllllllIIIIIIllIlIIIIlllII);
                }
                else {
                    lllllllllllllIIIIIIllIlIIIlIIIll.add(lllllllllllllIIIIIIllIlIIIIlllII);
                }
            }
        }
        return lllllllllllllIIIIIIllIlIIIlIIIll;
    }
    
    public abstract int getOpPermissionLevel();
    
    public String getResourcePackHash() {
        return this.resourcePackHash;
    }
    
    public abstract boolean isHardcore();
    
    public abstract boolean shouldBroadcastRconToOps();
    
    public boolean isAnvilFileSet() {
        return this.anvilFile != null;
    }
    
    public FunctionManager func_193030_aL() {
        return this.worldServers[0].func_193037_A();
    }
    
    public boolean isFlightAllowed() {
        return this.allowFlight;
    }
    
    @Override
    public void addServerTypeToSnooper(final Snooper lllllllllllllIIIIIIllIIllIIlIIII) {
        lllllllllllllIIIIIIllIIllIIlIIII.addStatToSnooper("singleplayer", this.isSinglePlayer());
        lllllllllllllIIIIIIllIIllIIlIIII.addStatToSnooper("server_brand", this.getServerModName());
        lllllllllllllIIIIIIllIIllIIlIIII.addStatToSnooper("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        lllllllllllllIIIIIIllIIllIIlIIII.addStatToSnooper("dedicated", this.isDedicatedServer());
    }
    
    public abstract GameType getGameType();
    
    protected void outputPercentRemaining(final String lllllllllllllIIIIIIllIlIlllIIlII, final int lllllllllllllIIIIIIllIlIlllIIIll) {
        this.currentTask = lllllllllllllIIIIIIllIlIlllIIlII;
        this.percentDone = lllllllllllllIIIIIIllIlIlllIIIll;
        MinecraftServer.LOG.info("{}: {}%", (Object)lllllllllllllIIIIIIllIlIlllIIlII, (Object)lllllllllllllIIIIIIllIlIlllIIIll);
    }
    
    protected void clearCurrentTask() {
        this.currentTask = null;
        this.percentDone = 0;
    }
    
    @Override
    public void addChatMessage(final ITextComponent lllllllllllllIIIIIIllIlIIIIIIlll) {
        MinecraftServer.LOG.info(lllllllllllllIIIIIIllIlIIIIIIlll.getUnformattedText());
    }
    
    @Override
    public void run() {
        try {
            if (this.startServer()) {
                this.currentTime = getCurrentTimeMillis();
                long lllllllllllllIIIIIIllIlIlIllIIIl = 0L;
                this.statusResponse.setServerDescription(new TextComponentString(this.motd));
                this.statusResponse.setVersion(new ServerStatusResponse.Version("1.12.2", 340));
                this.applyServerIconToResponse(this.statusResponse);
                while (this.serverRunning) {
                    final long lllllllllllllIIIIIIllIlIlIllIIII = getCurrentTimeMillis();
                    long lllllllllllllIIIIIIllIlIlIlIllll = lllllllllllllIIIIIIllIlIlIllIIII - this.currentTime;
                    if (lllllllllllllIIIIIIllIlIlIlIllll > 2000L && this.currentTime - this.timeOfLastWarning >= 15000L) {
                        MinecraftServer.LOG.warn("Can't keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", (Object)lllllllllllllIIIIIIllIlIlIlIllll, (Object)(lllllllllllllIIIIIIllIlIlIlIllll / 50L));
                        lllllllllllllIIIIIIllIlIlIlIllll = 2000L;
                        this.timeOfLastWarning = this.currentTime;
                    }
                    if (lllllllllllllIIIIIIllIlIlIlIllll < 0L) {
                        MinecraftServer.LOG.warn("Time ran backwards! Did the system time change?");
                        lllllllllllllIIIIIIllIlIlIlIllll = 0L;
                    }
                    lllllllllllllIIIIIIllIlIlIllIIIl += lllllllllllllIIIIIIllIlIlIlIllll;
                    this.currentTime = lllllllllllllIIIIIIllIlIlIllIIII;
                    if (this.worldServers[0].areAllPlayersAsleep()) {
                        this.tick();
                        lllllllllllllIIIIIIllIlIlIllIIIl = 0L;
                    }
                    else {
                        while (lllllllllllllIIIIIIllIlIlIllIIIl > 50L) {
                            lllllllllllllIIIIIIllIlIlIllIIIl -= 50L;
                            this.tick();
                        }
                    }
                    Thread.sleep(Math.max(1L, 50L - lllllllllllllIIIIIIllIlIlIllIIIl));
                    this.serverIsRunning = true;
                }
            }
            else {
                this.finalTick(null);
            }
        }
        catch (Throwable lllllllllllllIIIIIIllIlIlIlIlllI) {
            MinecraftServer.LOG.error("Encountered an unexpected exception", lllllllllllllIIIIIIllIlIlIlIlllI);
            CrashReport lllllllllllllIIIIIIllIlIlIlIllIl = null;
            if (lllllllllllllIIIIIIllIlIlIlIlllI instanceof ReportedException) {
                lllllllllllllIIIIIIllIlIlIlIllIl = this.addServerInfoToCrashReport(((ReportedException)lllllllllllllIIIIIIllIlIlIlIlllI).getCrashReport());
            }
            else {
                lllllllllllllIIIIIIllIlIlIlIllIl = this.addServerInfoToCrashReport(new CrashReport("Exception in server tick loop", lllllllllllllIIIIIIllIlIlIlIlllI));
            }
            final File lllllllllllllIIIIIIllIlIlIlIllII = new File(new File(this.getDataDirectory(), "crash-reports"), "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-server.txt");
            if (lllllllllllllIIIIIIllIlIlIlIllIl.saveToFile(lllllllllllllIIIIIIllIlIlIlIllII)) {
                MinecraftServer.LOG.error("This crash report has been saved to: {}", (Object)lllllllllllllIIIIIIllIlIlIlIllII.getAbsolutePath());
            }
            else {
                MinecraftServer.LOG.error("We were unable to save this crash report to disk.");
            }
            this.finalTick(lllllllllllllIIIIIIllIlIlIlIllIl);
            return;
        }
        finally {
            Label_0503: {
                try {
                    this.serverStopped = true;
                    this.stopServer();
                }
                catch (Throwable lllllllllllllIIIIIIllIlIlIlIlIlI) {
                    MinecraftServer.LOG.error("Exception stopping the server", lllllllllllllIIIIIIllIlIlIlIlIlI);
                    this.systemExitNow();
                    break Label_0503;
                }
                finally {
                    this.systemExitNow();
                }
                this.systemExitNow();
            }
        }
        try {
            this.serverStopped = true;
            this.stopServer();
        }
        catch (Throwable lllllllllllllIIIIIIllIlIlIlIlIIl) {
            MinecraftServer.LOG.error("Exception stopping the server", lllllllllllllIIIIIIllIlIlIlIlIIl);
            return;
        }
        finally {
            this.systemExitNow();
        }
        this.systemExitNow();
    }
    
    public void refreshStatusNextTick() {
        this.nanoTimeSinceStatusRefresh = 0L;
    }
    
    public GameProfileRepository getGameProfileRepository() {
        return this.profileRepo;
    }
    
    public void saveAllWorlds(final boolean lllllllllllllIIIIIIllIlIllIlIIll) {
        long lllllllllllllIIIIIIllIlIllIIllll;
        for (double lllllllllllllIIIIIIllIlIllIlIIII = ((WorldServer[])(Object)(lllllllllllllIIIIIIllIlIllIIllll = (long)(Object)this.worldServers)).length, lllllllllllllIIIIIIllIlIllIlIIIl = 0; lllllllllllllIIIIIIllIlIllIlIIIl < lllllllllllllIIIIIIllIlIllIlIIII; ++lllllllllllllIIIIIIllIlIllIlIIIl) {
            final WorldServer lllllllllllllIIIIIIllIlIllIlIllI = lllllllllllllIIIIIIllIlIllIIllll[lllllllllllllIIIIIIllIlIllIlIIIl];
            if (lllllllllllllIIIIIIllIlIllIlIllI != null) {
                if (!lllllllllllllIIIIIIllIlIllIlIIll) {
                    MinecraftServer.LOG.info("Saving chunks for level '{}'/{}", (Object)lllllllllllllIIIIIIllIlIllIlIllI.getWorldInfo().getWorldName(), (Object)lllllllllllllIIIIIIllIlIllIlIllI.provider.getDimensionType().getName());
                }
                try {
                    lllllllllllllIIIIIIllIlIllIlIllI.saveAllChunks(true, null);
                }
                catch (MinecraftException lllllllllllllIIIIIIllIlIllIlIlIl) {
                    MinecraftServer.LOG.warn(lllllllllllllIIIIIIllIlIllIlIlIl.getMessage());
                }
            }
        }
    }
    
    public boolean getAllowNether() {
        return true;
    }
    
    public void logWarning(final String lllllllllllllIIIIIIllIlIIlIlIIII) {
        MinecraftServer.LOG.warn(lllllllllllllIIIIIIllIlIIlIlIIII);
    }
    
    @Override
    public void addServerStatsToSnooper(final Snooper lllllllllllllIIIIIIllIIllIIllIlI) {
        lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("whitelist_enabled", false);
        lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("whitelist_count", 0);
        if (this.playerList != null) {
            lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("players_current", this.getCurrentPlayerCount());
            lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("players_max", this.getMaxPlayers());
            lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("players_seen", this.playerList.getAvailablePlayerDat().length);
        }
        lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("uses_auth", this.onlineMode);
        lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("gui_state", this.getGuiEnabled() ? "enabled" : "disabled");
        lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("run_time", (getCurrentTimeMillis() - lllllllllllllIIIIIIllIIllIIllIlI.getMinecraftStartTimeMillis()) / 60L * 1000L);
        lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("avg_tick_ms", (int)(MathHelper.average(this.tickTimeArray) * 1.0E-6));
        int lllllllllllllIIIIIIllIIllIIllllI = 0;
        if (this.worldServers != null) {
            float lllllllllllllIIIIIIllIIllIIlIlIl;
            for (int lllllllllllllIIIIIIllIIllIIlIllI = ((WorldServer[])(Object)(lllllllllllllIIIIIIllIIllIIlIlIl = (float)(Object)this.worldServers)).length, lllllllllllllIIIIIIllIIllIIlIlll = 0; lllllllllllllIIIIIIllIIllIIlIlll < lllllllllllllIIIIIIllIIllIIlIllI; ++lllllllllllllIIIIIIllIIllIIlIlll) {
                final WorldServer lllllllllllllIIIIIIllIIllIIlllIl = lllllllllllllIIIIIIllIIllIIlIlIl[lllllllllllllIIIIIIllIIllIIlIlll];
                if (lllllllllllllIIIIIIllIIllIIlllIl != null) {
                    final WorldInfo lllllllllllllIIIIIIllIIllIIlllII = lllllllllllllIIIIIIllIIllIIlllIl.getWorldInfo();
                    lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("world[" + lllllllllllllIIIIIIllIIllIIllllI + "][dimension]", lllllllllllllIIIIIIllIIllIIlllIl.provider.getDimensionType().getId());
                    lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("world[" + lllllllllllllIIIIIIllIIllIIllllI + "][mode]", lllllllllllllIIIIIIllIIllIIlllII.getGameType());
                    lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("world[" + lllllllllllllIIIIIIllIIllIIllllI + "][difficulty]", lllllllllllllIIIIIIllIIllIIlllIl.getDifficulty());
                    lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("world[" + lllllllllllllIIIIIIllIIllIIllllI + "][hardcore]", lllllllllllllIIIIIIllIIllIIlllII.isHardcoreModeEnabled());
                    lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("world[" + lllllllllllllIIIIIIllIIllIIllllI + "][generator_name]", lllllllllllllIIIIIIllIIllIIlllII.getTerrainType().getWorldTypeName());
                    lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("world[" + lllllllllllllIIIIIIllIIllIIllllI + "][generator_version]", lllllllllllllIIIIIIllIIllIIlllII.getTerrainType().getGeneratorVersion());
                    lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("world[" + lllllllllllllIIIIIIllIIllIIllllI + "][height]", this.buildLimit);
                    lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("world[" + lllllllllllllIIIIIIllIIllIIllllI + "][chunks_loaded]", lllllllllllllIIIIIIllIIllIIlllIl.getChunkProvider().getLoadedChunkCount());
                    ++lllllllllllllIIIIIIllIIllIIllllI;
                }
            }
        }
        lllllllllllllIIIIIIllIIllIIllIlI.addClientStat("worlds", lllllllllllllIIIIIIllIIllIIllllI);
    }
    
    public abstract EnumDifficulty getDifficulty();
    
    public File getDataDirectory() {
        return new File(".");
    }
    
    public PlayerProfileCache getPlayerProfileCache() {
        return this.profileCache;
    }
    
    public ISaveFormat getActiveAnvilConverter() {
        return this.anvilConverterForAnvilFile;
    }
    
    public int getMaxPlayerIdleMinutes() {
        return this.maxPlayerIdleMinutes;
    }
    
    public WorldServer worldServerForDimension(final int lllllllllllllIIIIIIllIlIIlIIlIlI) {
        if (lllllllllllllIIIIIIllIlIIlIIlIlI == -1) {
            return this.worldServers[1];
        }
        return (lllllllllllllIIIIIIllIlIIlIIlIlI == 1) ? this.worldServers[2] : this.worldServers[0];
    }
    
    public MinecraftServer(final File lllllllllllllIIIIIIllIllIllIIlIl, final Proxy lllllllllllllIIIIIIllIllIlIlllII, final DataFixer lllllllllllllIIIIIIllIllIllIIIll, final YggdrasilAuthenticationService lllllllllllllIIIIIIllIllIllIIIlI, final MinecraftSessionService lllllllllllllIIIIIIllIllIlIllIIl, final GameProfileRepository lllllllllllllIIIIIIllIllIllIIIII, final PlayerProfileCache lllllllllllllIIIIIIllIllIlIlllll) {
        this.usageSnooper = new Snooper("server", this, getCurrentTimeMillis());
        this.tickables = (List<ITickable>)Lists.newArrayList();
        this.theProfiler = new Profiler();
        this.statusResponse = new ServerStatusResponse();
        this.random = new Random();
        this.serverPort = -1;
        this.serverRunning = true;
        this.tickTimeArray = new long[100];
        this.resourcePackUrl = "";
        this.resourcePackHash = "";
        this.futureTaskQueue = (Queue<FutureTask<?>>)Queues.newArrayDeque();
        this.currentTime = getCurrentTimeMillis();
        this.serverProxy = lllllllllllllIIIIIIllIllIlIlllII;
        this.authService = lllllllllllllIIIIIIllIllIllIIIlI;
        this.sessionService = lllllllllllllIIIIIIllIllIlIllIIl;
        this.profileRepo = lllllllllllllIIIIIIllIllIllIIIII;
        this.profileCache = lllllllllllllIIIIIIllIllIlIlllll;
        this.anvilFile = lllllllllllllIIIIIIllIllIllIIlIl;
        this.networkSystem = new NetworkSystem(this);
        this.commandManager = this.createNewCommandManager();
        this.anvilConverterForAnvilFile = new AnvilSaveConverter(lllllllllllllIIIIIIllIllIllIIlIl, lllllllllllllIIIIIIllIllIllIIIll);
        this.dataFixer = lllllllllllllIIIIIIllIllIllIIIll;
    }
    
    public void setDifficultyForAllWorlds(final EnumDifficulty lllllllllllllIIIIIIllIIlllIIllll) {
        final int lllllllllllllIIIIIIllIIlllIIlIll;
        final char lllllllllllllIIIIIIllIIlllIIllII = (char)((WorldServer[])(Object)(lllllllllllllIIIIIIllIIlllIIlIll = (int)(Object)this.worldServers)).length;
        for (float lllllllllllllIIIIIIllIIlllIIllIl = 0; lllllllllllllIIIIIIllIIlllIIllIl < lllllllllllllIIIIIIllIIlllIIllII; ++lllllllllllllIIIIIIllIIlllIIllIl) {
            final WorldServer lllllllllllllIIIIIIllIIlllIlIIIl = lllllllllllllIIIIIIllIIlllIIlIll[lllllllllllllIIIIIIllIIlllIIllIl];
            if (lllllllllllllIIIIIIllIIlllIlIIIl != null) {
                if (lllllllllllllIIIIIIllIIlllIlIIIl.getWorldInfo().isHardcoreModeEnabled()) {
                    lllllllllllllIIIIIIllIIlllIlIIIl.getWorldInfo().setDifficulty(EnumDifficulty.HARD);
                    lllllllllllllIIIIIIllIIlllIlIIIl.setAllowedSpawnTypes(true, true);
                }
                else if (this.isSinglePlayer()) {
                    lllllllllllllIIIIIIllIIlllIlIIIl.getWorldInfo().setDifficulty(lllllllllllllIIIIIIllIIlllIIllll);
                    lllllllllllllIIIIIIllIIlllIlIIIl.setAllowedSpawnTypes(lllllllllllllIIIIIIllIIlllIlIIIl.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                }
                else {
                    lllllllllllllIIIIIIllIIlllIlIIIl.getWorldInfo().setDifficulty(lllllllllllllIIIIIIllIIlllIIllll);
                    lllllllllllllIIIIIIllIIlllIlIIIl.setAllowedSpawnTypes(this.allowSpawnMonsters(), this.canSpawnAnimals);
                }
            }
        }
    }
    
    public int getSpawnRadius(@Nullable final WorldServer lllllllllllllIIIIIIllIIIllIIlIII) {
        return (lllllllllllllIIIIIIllIIIllIIlIII != null) ? lllllllllllllIIIIIIllIIIllIIlIII.getGameRules().getInt("spawnRadius") : 10;
    }
    
    public boolean isPVPEnabled() {
        return this.pvpEnabled;
    }
    
    public boolean serverIsInRunLoop() {
        return this.serverIsRunning;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllllIIIIIIllIlIIIIIIlIl, final String lllllllllllllIIIIIIllIlIIIIIIlII) {
        return true;
    }
    
    public void canCreateBonusChest(final boolean lllllllllllllIIIIIIllIIllIlllIll) {
        this.enableBonusChest = lllllllllllllIIIIIIllIIllIlllIll;
    }
    
    public String getMOTD() {
        return this.motd;
    }
    
    public PlayerList getPlayerList() {
        return this.playerList;
    }
    
    public void setResourcePackFromWorld(final String lllllllllllllIIIIIIllIlIlllIllll, final ISaveHandler lllllllllllllIIIIIIllIlIllllIIll) {
        final File lllllllllllllIIIIIIllIlIllllIIlI = new File(lllllllllllllIIIIIIllIlIllllIIll.getWorldDirectory(), "resources.zip");
        if (lllllllllllllIIIIIIllIlIllllIIlI.isFile()) {
            try {
                this.setResourcePack("level://" + URLEncoder.encode(lllllllllllllIIIIIIllIlIlllIllll, StandardCharsets.UTF_8.toString()) + "/" + "resources.zip", "");
            }
            catch (UnsupportedEncodingException lllllllllllllIIIIIIllIlIllllIIIl) {
                MinecraftServer.LOG.warn("Something went wrong url encoding {}", (Object)lllllllllllllIIIIIIllIlIlllIllll);
            }
        }
    }
    
    public abstract boolean isCommandBlockEnabled();
    
    public boolean func_190518_ac() {
        return this.field_190519_A;
    }
    
    public void initiateShutdown() {
        this.serverRunning = false;
    }
    
    public void setAllowPvp(final boolean lllllllllllllIIIIIIllIIlIllIIllI) {
        this.pvpEnabled = lllllllllllllIIIIIIllIIlIllIIllI;
    }
    
    public void setOnlineMode(final boolean lllllllllllllIIIIIIllIIllIIIIllI) {
        this.onlineMode = lllllllllllllIIIIIIllIIllIIIIllI;
    }
    
    public File getFile(final String lllllllllllllIIIIIIllIlIIlIlIlII) {
        return new File(this.getDataDirectory(), lllllllllllllIIIIIIllIlIIlIlIlII);
    }
    
    public void finalTick(final CrashReport lllllllllllllIIIIIIllIlIlIIIIIll) {
    }
    
    public void setWorldName(final String lllllllllllllIIIIIIllIIllllIIlIl) {
        this.worldName = lllllllllllllIIIIIIllIIllllIIlIl;
    }
    
    public void setResourcePack(final String lllllllllllllIIIIIIllIIllIlIllIl, final String lllllllllllllIIIIIIllIIllIlIllII) {
        this.resourcePackUrl = lllllllllllllIIIIIIllIIllIlIllIl;
        this.resourcePackHash = lllllllllllllIIIIIIllIIllIlIllII;
    }
    
    public abstract boolean isDedicatedServer();
    
    public void setPlayerIdleTimeout(final int lllllllllllllIIIIIIllIIlIIIIlIlI) {
        this.maxPlayerIdleMinutes = lllllllllllllIIIIIIllIIlIIIIlIlI;
    }
    
    public ICommandManager getCommandManager() {
        return this.commandManager;
    }
    
    public boolean isSinglePlayer() {
        return this.serverOwner != null;
    }
    
    @Override
    public ListenableFuture<Object> addScheduledTask(final Runnable lllllllllllllIIIIIIllIIIllIlIIlI) {
        Validate.notNull((Object)lllllllllllllIIIIIIllIIIllIlIIlI);
        return this.callFromMainThread(Executors.callable(lllllllllllllIIIIIIllIIIllIlIIlI));
    }
    
    public abstract String shareToLAN(final GameType p0, final boolean p1);
    
    public void setCanSpawnNPCs(final boolean lllllllllllllIIIIIIllIIlIllIllll) {
        this.canSpawnNPCs = lllllllllllllIIIIIIllIIlIllIllll;
    }
    
    public abstract boolean shouldUseNativeTransport();
}
