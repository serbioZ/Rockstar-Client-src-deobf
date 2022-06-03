// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.integrated;

import net.minecraft.profiler.Snooper;
import net.minecraft.util.Util;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Future;
import com.google.common.util.concurrent.Futures;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Lists;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.IWorldEventListener;
import net.minecraft.world.ServerWorldEventHandler;
import net.minecraft.world.WorldServerMulti;
import optifine.WorldServerOF;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.command.ServerCommandManager;
import optifine.Reflector;
import net.minecraft.util.CryptManager;
import org.apache.logging.log4j.LogManager;
import net.minecraft.world.WorldServerDemo;
import net.minecraft.server.management.PlayerList;
import java.io.File;
import net.minecraft.server.management.PlayerProfileCache;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import net.minecraft.crash.CrashReport;
import java.net.InetAddress;
import java.io.IOException;
import net.minecraft.util.HttpUtil;
import net.minecraft.world.GameType;
import net.minecraft.client.Minecraft;
import net.minecraft.world.WorldSettings;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.multiplayer.ThreadLanServerPing;
import net.minecraft.server.MinecraftServer;

public class IntegratedServer extends MinecraftServer
{
    private /* synthetic */ ThreadLanServerPing lanServerPing;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ boolean isPublic;
    private /* synthetic */ boolean isGamePaused;
    private final /* synthetic */ WorldSettings theWorldSettings;
    private final /* synthetic */ Minecraft mc;
    
    @Override
    public int getOpPermissionLevel() {
        return 4;
    }
    
    @Override
    public String shareToLAN(final GameType lllllllllllllIllIlIIIIlIlIlIIlII, final boolean lllllllllllllIllIlIIIIlIlIlIIIll) {
        try {
            int lllllllllllllIllIlIIIIlIlIlIIIlI = -1;
            try {
                lllllllllllllIllIlIIIIlIlIlIIIlI = HttpUtil.getSuitableLanPort();
            }
            catch (IOException ex) {}
            if (lllllllllllllIllIlIIIIlIlIlIIIlI <= 0) {
                lllllllllllllIllIlIIIIlIlIlIIIlI = 25564;
            }
            this.getNetworkSystem().addLanEndpoint(null, lllllllllllllIllIlIIIIlIlIlIIIlI);
            IntegratedServer.LOGGER.info("Started on {}", (Object)lllllllllllllIllIlIIIIlIlIlIIIlI);
            this.isPublic = true;
            this.lanServerPing = new ThreadLanServerPing(this.getMOTD(), new StringBuilder(String.valueOf(lllllllllllllIllIlIIIIlIlIlIIIlI)).toString());
            this.lanServerPing.start();
            this.getPlayerList().setGameType(lllllllllllllIllIlIIIIlIlIlIIlII);
            this.getPlayerList().setCommandsAllowedForAll(lllllllllllllIllIlIIIIlIlIlIIIll);
            this.mc.player.setPermissionLevel(lllllllllllllIllIlIIIIlIlIlIIIll ? 4 : 0);
            return new StringBuilder(String.valueOf(lllllllllllllIllIlIIIIlIlIlIIIlI)).toString();
        }
        catch (IOException lllllllllllllIllIlIIIIlIlIlIIIIl) {
            return null;
        }
    }
    
    public boolean getPublic() {
        return this.isPublic;
    }
    
    @Override
    public void finalTick(final CrashReport lllllllllllllIllIlIIIIlIllIIIIII) {
        this.mc.crashed(lllllllllllllIllIlIIIIlIllIIIIII);
    }
    
    @Override
    public GameType getGameType() {
        return this.theWorldSettings.getGameType();
    }
    
    public IntegratedServer(final Minecraft lllllllllllllIllIlIIIIllIIllIIll, final String lllllllllllllIllIlIIIIllIIllIIlI, final String lllllllllllllIllIlIIIIllIIlIlIII, final WorldSettings lllllllllllllIllIlIIIIllIIlIIlll, final YggdrasilAuthenticationService lllllllllllllIllIlIIIIllIIlIllll, final MinecraftSessionService lllllllllllllIllIlIIIIllIIlIlllI, final GameProfileRepository lllllllllllllIllIlIIIIllIIlIIlII, final PlayerProfileCache lllllllllllllIllIlIIIIllIIlIllII) {
        super(new File(lllllllllllllIllIlIIIIllIIllIIll.mcDataDir, "saves"), lllllllllllllIllIlIIIIllIIllIIll.getProxy(), lllllllllllllIllIlIIIIllIIllIIll.getDataFixer(), lllllllllllllIllIlIIIIllIIlIllll, lllllllllllllIllIlIIIIllIIlIlllI, lllllllllllllIllIlIIIIllIIlIIlII, lllllllllllllIllIlIIIIllIIlIllII);
        this.setServerOwner(lllllllllllllIllIlIIIIllIIllIIll.getSession().getUsername());
        this.setFolderName(lllllllllllllIllIlIIIIllIIllIIlI);
        this.setWorldName(lllllllllllllIllIlIIIIllIIlIlIII);
        this.setDemo(lllllllllllllIllIlIIIIllIIllIIll.isDemo());
        this.canCreateBonusChest(lllllllllllllIllIlIIIIllIIlIIlll.isBonusChestEnabled());
        this.setBuildLimit(256);
        this.setPlayerList(new IntegratedPlayerList(this));
        this.mc = lllllllllllllIllIlIIIIllIIllIIll;
        this.theWorldSettings = (this.isDemo() ? WorldServerDemo.DEMO_WORLD_SETTINGS : lllllllllllllIllIlIIIIllIIlIIlll);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public boolean isSnooperEnabled() {
        return Minecraft.getMinecraft().isSnooperEnabled();
    }
    
    @Override
    public boolean startServer() throws IOException {
        IntegratedServer.LOGGER.info("Starting integrated minecraft server version 1.12.2");
        this.setOnlineMode(true);
        this.setCanSpawnAnimals(true);
        this.setCanSpawnNPCs(true);
        this.setAllowPvp(true);
        this.setAllowFlight(true);
        IntegratedServer.LOGGER.info("Generating keypair");
        this.setKeyPair(CryptManager.generateKeyPair());
        if (Reflector.FMLCommonHandler_handleServerAboutToStart.exists()) {
            final Object lllllllllllllIllIlIIIIlIllllIIll = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            if (!Reflector.callBoolean(lllllllllllllIllIlIIIIlIllllIIll, Reflector.FMLCommonHandler_handleServerAboutToStart, new Object[] { this })) {
                return false;
            }
        }
        this.loadAllWorlds(this.getFolderName(), this.getWorldName(), this.theWorldSettings.getSeed(), this.theWorldSettings.getTerrainType(), this.theWorldSettings.getGeneratorOptions());
        this.setMOTD(String.valueOf(this.getServerOwner()) + " - " + this.worldServers[0].getWorldInfo().getWorldName());
        if (Reflector.FMLCommonHandler_handleServerStarting.exists()) {
            final Object lllllllllllllIllIlIIIIlIllllIIlI = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            if (Reflector.FMLCommonHandler_handleServerStarting.getReturnType() == Boolean.TYPE) {
                return Reflector.callBoolean(lllllllllllllIllIlIIIIlIllllIIlI, Reflector.FMLCommonHandler_handleServerStarting, new Object[] { this });
            }
            Reflector.callVoid(lllllllllllllIllIlIIIIlIllllIIlI, Reflector.FMLCommonHandler_handleServerStarting, new Object[] { this });
        }
        return true;
    }
    
    @Override
    public void stopServer() {
        super.stopServer();
        if (this.lanServerPing != null) {
            this.lanServerPing.interrupt();
            this.lanServerPing = null;
        }
    }
    
    @Override
    public boolean shouldBroadcastRconToOps() {
        return true;
    }
    
    @Override
    public boolean shouldBroadcastConsoleToOps() {
        return true;
    }
    
    @Override
    public ServerCommandManager createNewCommandManager() {
        return new IntegratedServerCommandManager(this);
    }
    
    @Override
    public File getDataDirectory() {
        return this.mc.mcDataDir;
    }
    
    @Override
    public boolean isDedicatedServer() {
        return false;
    }
    
    @Override
    public void saveAllWorlds(final boolean lllllllllllllIllIlIIIIlIllIIlIIl) {
        super.saveAllWorlds(lllllllllllllIllIlIIIIlIllIIlIIl);
    }
    
    @Override
    public void loadAllWorlds(final String lllllllllllllIllIlIIIIllIIIlIIlI, final String lllllllllllllIllIlIIIIllIIIlIIIl, final long lllllllllllllIllIlIIIIllIIIlIIII, final WorldType lllllllllllllIllIlIIIIllIIIIllll, final String lllllllllllllIllIlIIIIllIIIIlllI) {
        this.convertMapIfNeeded(lllllllllllllIllIlIIIIllIIIlIIlI);
        final ISaveHandler lllllllllllllIllIlIIIIllIIIIllIl = this.getActiveAnvilConverter().getSaveLoader(lllllllllllllIllIlIIIIllIIIlIIlI, true);
        this.setResourcePackFromWorld(this.getFolderName(), lllllllllllllIllIlIIIIllIIIIllIl);
        WorldInfo lllllllllllllIllIlIIIIllIIIIllII = lllllllllllllIllIlIIIIllIIIIllIl.loadWorldInfo();
        if (Reflector.DimensionManager.exists()) {
            final WorldServer lllllllllllllIllIlIIIIllIIIIlIll = (WorldServer)(this.isDemo() ? new WorldServerDemo(this, lllllllllllllIllIlIIIIllIIIIllIl, lllllllllllllIllIlIIIIllIIIIllII, 0, this.theProfiler).init() : ((WorldServer)new WorldServerOF((MinecraftServer)this, lllllllllllllIllIlIIIIllIIIIllIl, lllllllllllllIllIlIIIIllIIIIllII, 0, this.theProfiler).init()));
            lllllllllllllIllIlIIIIllIIIIlIll.initialize(this.theWorldSettings);
            final Integer[] lllllllllllllIllIlIIIIllIIIIlIIl;
            final Integer[] lllllllllllllIllIlIIIIllIIIIlIlI = lllllllllllllIllIlIIIIllIIIIlIIl = (Integer[])Reflector.call(Reflector.DimensionManager_getStaticDimensionIDs, new Object[0]);
            for (int lllllllllllllIllIlIIIIllIIIIlIII = lllllllllllllIllIlIIIIllIIIIlIlI.length, lllllllllllllIllIlIIIIllIIIIIlll = 0; lllllllllllllIllIlIIIIllIIIIIlll < lllllllllllllIllIlIIIIllIIIIlIII; ++lllllllllllllIllIlIIIIllIIIIIlll) {
                final int lllllllllllllIllIlIIIIllIIIIIllI = lllllllllllllIllIlIIIIllIIIIlIIl[lllllllllllllIllIlIIIIllIIIIIlll];
                final WorldServer lllllllllllllIllIlIIIIllIIIIIlIl = (WorldServer)((lllllllllllllIllIlIIIIllIIIIIllI == 0) ? lllllllllllllIllIlIIIIllIIIIlIll : new WorldServerMulti(this, lllllllllllllIllIlIIIIllIIIIllIl, lllllllllllllIllIlIIIIllIIIIIllI, lllllllllllllIllIlIIIIllIIIIlIll, this.theProfiler).init());
                lllllllllllllIllIlIIIIllIIIIIlIl.addEventListener(new ServerWorldEventHandler(this, lllllllllllllIllIlIIIIllIIIIIlIl));
                if (!this.isSinglePlayer()) {
                    lllllllllllllIllIlIIIIllIIIIIlIl.getWorldInfo().setGameType(this.getGameType());
                }
                if (Reflector.EventBus.exists()) {
                    Reflector.postForgeBusEvent(Reflector.WorldEvent_Load_Constructor, new Object[] { lllllllllllllIllIlIIIIllIIIIIlIl });
                }
            }
            this.getPlayerList().setPlayerManager(new WorldServer[] { lllllllllllllIllIlIIIIllIIIIlIll });
            if (lllllllllllllIllIlIIIIllIIIIlIll.getWorldInfo().getDifficulty() == null) {
                this.setDifficultyForAllWorlds(this.mc.gameSettings.difficulty);
            }
        }
        else {
            this.worldServers = new WorldServer[3];
            this.timeOfLastDimensionTick = new long[this.worldServers.length][100];
            this.setResourcePackFromWorld(this.getFolderName(), lllllllllllllIllIlIIIIllIIIIllIl);
            if (lllllllllllllIllIlIIIIllIIIIllII == null) {
                lllllllllllllIllIlIIIIllIIIIllII = new WorldInfo(this.theWorldSettings, lllllllllllllIllIlIIIIllIIIlIIIl);
            }
            else {
                lllllllllllllIllIlIIIIllIIIIllII.setWorldName(lllllllllllllIllIlIIIIllIIIlIIIl);
            }
            for (int lllllllllllllIllIlIIIIllIIIIIlII = 0; lllllllllllllIllIlIIIIllIIIIIlII < this.worldServers.length; ++lllllllllllllIllIlIIIIllIIIIIlII) {
                int lllllllllllllIllIlIIIIllIIIIIIll = 0;
                if (lllllllllllllIllIlIIIIllIIIIIlII == 1) {
                    lllllllllllllIllIlIIIIllIIIIIIll = -1;
                }
                if (lllllllllllllIllIlIIIIllIIIIIlII == 2) {
                    lllllllllllllIllIlIIIIllIIIIIIll = 1;
                }
                if (lllllllllllllIllIlIIIIllIIIIIlII == 0) {
                    if (this.isDemo()) {
                        this.worldServers[lllllllllllllIllIlIIIIllIIIIIlII] = (WorldServer)new WorldServerDemo(this, lllllllllllllIllIlIIIIllIIIIllIl, lllllllllllllIllIlIIIIllIIIIllII, lllllllllllllIllIlIIIIllIIIIIIll, this.theProfiler).init();
                    }
                    else {
                        this.worldServers[lllllllllllllIllIlIIIIllIIIIIlII] = (WorldServer)new WorldServerOF((MinecraftServer)this, lllllllllllllIllIlIIIIllIIIIllIl, lllllllllllllIllIlIIIIllIIIIllII, lllllllllllllIllIlIIIIllIIIIIIll, this.theProfiler).init();
                    }
                    this.worldServers[lllllllllllllIllIlIIIIllIIIIIlII].initialize(this.theWorldSettings);
                }
                else {
                    this.worldServers[lllllllllllllIllIlIIIIllIIIIIlII] = (WorldServer)new WorldServerMulti(this, lllllllllllllIllIlIIIIllIIIIllIl, lllllllllllllIllIlIIIIllIIIIIIll, this.worldServers[0], this.theProfiler).init();
                }
                this.worldServers[lllllllllllllIllIlIIIIllIIIIIlII].addEventListener(new ServerWorldEventHandler(this, this.worldServers[lllllllllllllIllIlIIIIllIIIIIlII]));
            }
            this.getPlayerList().setPlayerManager(this.worldServers);
            if (this.worldServers[0].getWorldInfo().getDifficulty() == null) {
                this.setDifficultyForAllWorlds(this.mc.gameSettings.difficulty);
            }
        }
        this.initialWorldChunkLoad();
    }
    
    @Override
    public void setGameType(final GameType lllllllllllllIllIlIIIIlIlIIIllll) {
        super.setGameType(lllllllllllllIllIlIIIIlIlIIIllll);
        this.getPlayerList().setGameType(lllllllllllllIllIlIIIIlIlIIIllll);
    }
    
    @Override
    public EnumDifficulty getDifficulty() {
        return (this.mc.world == null) ? this.mc.gameSettings.difficulty : this.mc.world.getWorldInfo().getDifficulty();
    }
    
    @Override
    public boolean isCommandBlockEnabled() {
        return true;
    }
    
    @Override
    public CrashReport addServerInfoToCrashReport(CrashReport lllllllllllllIllIlIIIIlIlIlllIII) {
        lllllllllllllIllIlIIIIlIlIlllIII = super.addServerInfoToCrashReport(lllllllllllllIllIlIIIIlIlIlllIII);
        lllllllllllllIllIlIIIIlIlIlllIII.getCategory().setDetail("Type", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return "Integrated Server (map_client.txt)";
            }
        });
        lllllllllllllIllIlIIIIlIlIlllIII.getCategory().setDetail("Is Modded", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                String lllllllllllIlIllllIIIlIIIIIlIIlI = ClientBrandRetriever.getClientModName();
                if (!lllllllllllIlIllllIIIlIIIIIlIIlI.equals("vanilla")) {
                    return "Definitely; Client brand changed to '" + lllllllllllIlIllllIIIlIIIIIlIIlI + "'";
                }
                lllllllllllIlIllllIIIlIIIIIlIIlI = IntegratedServer.this.getServerModName();
                if (!"vanilla".equals(lllllllllllIlIllllIIIlIIIIIlIIlI)) {
                    return "Definitely; Server brand changed to '" + lllllllllllIlIllllIIIlIIIIIlIIlI + "'";
                }
                return (Minecraft.class.getSigners() == null) ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and both client + server brands are untouched.";
            }
        });
        return lllllllllllllIllIlIIIIlIlIlllIII;
    }
    
    @Override
    public void initiateShutdown() {
        if (!Reflector.MinecraftForge.exists() || this.isServerRunning()) {
            Futures.getUnchecked((Future)this.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    for (final EntityPlayerMP lllllllllllIlIIllIIIlIlIlIllllIl : Lists.newArrayList((Iterable)IntegratedServer.this.getPlayerList().getPlayerList())) {
                        if (!lllllllllllIlIIllIIIlIlIlIllllIl.getUniqueID().equals(IntegratedServer.this.mc.player.getUniqueID())) {
                            IntegratedServer.this.getPlayerList().playerLoggedOut(lllllllllllIlIIllIIIlIlIlIllllIl);
                        }
                    }
                }
            }));
        }
        super.initiateShutdown();
        if (this.lanServerPing != null) {
            this.lanServerPing.interrupt();
            this.lanServerPing = null;
        }
    }
    
    @Override
    public void tick() {
        final boolean lllllllllllllIllIlIIIIlIlllIIllI = this.isGamePaused;
        this.isGamePaused = (Minecraft.getMinecraft().getConnection() != null && Minecraft.getMinecraft().isGamePaused());
        if (!lllllllllllllIllIlIIIIlIlllIIllI && this.isGamePaused) {
            IntegratedServer.LOGGER.info("Saving and pausing game...");
            this.getPlayerList().saveAllPlayerData();
            this.saveAllWorlds(false);
        }
        if (this.isGamePaused) {
            synchronized (this.futureTaskQueue) {
                while (!this.futureTaskQueue.isEmpty()) {
                    Util.runTask(this.futureTaskQueue.poll(), IntegratedServer.LOGGER);
                }
                // monitorexit(this.futureTaskQueue)
                return;
            }
        }
        super.tick();
        if (this.mc.gameSettings.renderDistanceChunks != this.getPlayerList().getViewDistance()) {
            IntegratedServer.LOGGER.info("Changing view distance to {}, from {}", (Object)this.mc.gameSettings.renderDistanceChunks, (Object)this.getPlayerList().getViewDistance());
            this.getPlayerList().setViewDistance(this.mc.gameSettings.renderDistanceChunks);
        }
        if (this.mc.world != null) {
            final WorldInfo lllllllllllllIllIlIIIIlIlllIIlIl = this.worldServers[0].getWorldInfo();
            final WorldInfo lllllllllllllIllIlIIIIlIlllIIlII = this.mc.world.getWorldInfo();
            if (!lllllllllllllIllIlIIIIlIlllIIlIl.isDifficultyLocked() && lllllllllllllIllIlIIIIlIlllIIlII.getDifficulty() != lllllllllllllIllIlIIIIlIlllIIlIl.getDifficulty()) {
                IntegratedServer.LOGGER.info("Changing difficulty to {}, from {}", (Object)lllllllllllllIllIlIIIIlIlllIIlII.getDifficulty(), (Object)lllllllllllllIllIlIIIIlIlllIIlIl.getDifficulty());
                this.setDifficultyForAllWorlds(lllllllllllllIllIlIIIIlIlllIIlII.getDifficulty());
            }
            else if (lllllllllllllIllIlIIIIlIlllIIlII.isDifficultyLocked() && !lllllllllllllIllIlIIIIlIlllIIlIl.isDifficultyLocked()) {
                IntegratedServer.LOGGER.info("Locking difficulty to {}", (Object)lllllllllllllIllIlIIIIlIlllIIlII.getDifficulty());
                final float lllllllllllllIllIlIIIIlIllIllIll;
                final float lllllllllllllIllIlIIIIlIllIlllII = ((WorldServer[])(Object)(lllllllllllllIllIlIIIIlIllIllIll = (float)(Object)this.worldServers)).length;
                for (Exception lllllllllllllIllIlIIIIlIllIlllIl = (Exception)0; lllllllllllllIllIlIIIIlIllIlllIl < lllllllllllllIllIlIIIIlIllIlllII; ++lllllllllllllIllIlIIIIlIllIlllIl) {
                    final WorldServer lllllllllllllIllIlIIIIlIlllIIIll = lllllllllllllIllIlIIIIlIllIllIll[lllllllllllllIllIlIIIIlIllIlllIl];
                    if (lllllllllllllIllIlIIIIlIlllIIIll != null) {
                        lllllllllllllIllIlIIIIlIlllIIIll.getWorldInfo().setDifficultyLocked(true);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isHardcore() {
        return this.theWorldSettings.getHardcoreEnabled();
    }
    
    @Override
    public boolean canStructuresSpawn() {
        return false;
    }
    
    @Override
    public boolean shouldUseNativeTransport() {
        return false;
    }
    
    @Override
    public void addServerStatsToSnooper(final Snooper lllllllllllllIllIlIIIIlIlIlIlllI) {
        super.addServerStatsToSnooper(lllllllllllllIllIlIIIIlIlIlIlllI);
        lllllllllllllIllIlIIIIlIlIlIlllI.addClientStat("snooper_partner", this.mc.getPlayerUsageSnooper().getUniqueID());
    }
    
    @Override
    public void setDifficultyForAllWorlds(final EnumDifficulty lllllllllllllIllIlIIIIlIlIllIIlI) {
        super.setDifficultyForAllWorlds(lllllllllllllIllIlIIIIlIlIllIIlI);
        if (this.mc.world != null) {
            this.mc.world.getWorldInfo().setDifficulty(lllllllllllllIllIlIIIIlIlIllIIlI);
        }
    }
}
