// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import org.apache.logging.log4j.LogManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.world.DimensionType;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.play.server.SPacketWorldBorder;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.border.IBorderListener;
import net.minecraft.scoreboard.ScoreObjective;
import java.util.Set;
import net.minecraft.network.play.server.SPacketTeams;
import net.minecraft.scoreboard.ScorePlayerTeam;
import com.google.common.collect.Sets;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.stats.StatList;
import java.util.Iterator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.server.SPacketSetExperience;
import net.minecraft.network.play.server.SPacketSpawnPosition;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import java.net.SocketAddress;
import javax.annotation.Nullable;
import com.google.common.collect.Maps;
import net.minecraft.scoreboard.Team;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.network.play.server.SPacketServerDifficulty;
import net.minecraft.network.play.server.SPacketCustomPayload;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import net.minecraft.network.play.server.SPacketJoinGame;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketEntityEffect;
import net.minecraft.potion.PotionEffect;
import net.minecraft.network.play.server.SPacketPlayerAbilities;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.player.EntityPlayer;
import com.mojang.authlib.GameProfile;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.world.WorldServer;
import com.google.common.collect.Lists;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketHeldItemChange;
import net.minecraft.world.storage.IPlayerFileData;
import net.minecraft.stats.StatisticsManagerServer;
import java.util.List;
import org.apache.logging.log4j.Logger;
import net.minecraft.advancements.PlayerAdvancements;
import java.text.SimpleDateFormat;
import net.minecraft.world.GameType;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.UUID;
import java.util.Map;
import net.minecraft.server.MinecraftServer;
import java.io.File;

public abstract class PlayerList
{
    public static final /* synthetic */ File FILE_IPBANS;
    private final /* synthetic */ MinecraftServer mcServer;
    public static final /* synthetic */ File FILE_PLAYERBANS;
    private final /* synthetic */ Map<UUID, EntityPlayerMP> uuidToPlayerMap;
    private final /* synthetic */ UserListBans bannedPlayers;
    private /* synthetic */ boolean whiteListEnforced;
    private /* synthetic */ int playerPingIndex;
    private /* synthetic */ boolean commandsAllowedForAll;
    private /* synthetic */ GameType gameType;
    private final /* synthetic */ UserListOps ops;
    private final /* synthetic */ UserListIPBans bannedIPs;
    private static final /* synthetic */ SimpleDateFormat DATE_FORMAT;
    private final /* synthetic */ Map<UUID, PlayerAdvancements> field_192055_p;
    private final /* synthetic */ UserListWhitelist whiteListedPlayers;
    public static final /* synthetic */ File FILE_WHITELIST;
    private static final /* synthetic */ Logger LOG;
    public static final /* synthetic */ File FILE_OPS;
    protected /* synthetic */ int maxPlayers;
    private final /* synthetic */ List<EntityPlayerMP> playerEntityList;
    private final /* synthetic */ Map<UUID, StatisticsManagerServer> playerStatFiles;
    private /* synthetic */ int viewDistance;
    private /* synthetic */ IPlayerFileData playerNBTManagerObj;
    
    public void syncPlayerInventory(final EntityPlayerMP llllllllllllllllIIIlIlIIIllIllll) {
        llllllllllllllllIIIlIlIIIllIllll.sendContainerToPlayer(llllllllllllllllIIIlIlIIIllIllll.inventoryContainer);
        llllllllllllllllIIIlIlIIIllIllll.setPlayerHealthUpdated();
        llllllllllllllllIIIlIlIIIllIllll.connection.sendPacket(new SPacketHeldItemChange(llllllllllllllllIIIlIlIIIllIllll.inventory.currentItem));
    }
    
    public List<EntityPlayerMP> getPlayersMatchingAddress(final String llllllllllllllllIIIlIlIIIlIlIlII) {
        final List<EntityPlayerMP> llllllllllllllllIIIlIlIIIlIlIlll = (List<EntityPlayerMP>)Lists.newArrayList();
        for (final EntityPlayerMP llllllllllllllllIIIlIlIIIlIlIllI : this.playerEntityList) {
            if (llllllllllllllllIIIlIlIIIlIlIllI.getPlayerIP().equals(llllllllllllllllIIIlIlIIIlIlIlII)) {
                llllllllllllllllIIIlIlIIIlIlIlll.add(llllllllllllllllIIIlIlIIIlIlIllI);
            }
        }
        return llllllllllllllllIIIlIlIIIlIlIlll;
    }
    
    public void setViewDistance(final int llllllllllllllllIIIlIIlllllIlIII) {
        this.viewDistance = llllllllllllllllIIIlIIlllllIlIII;
        if (this.mcServer.worldServers != null) {
            final int llllllllllllllllIIIlIIlllllIIlII;
            final double llllllllllllllllIIIlIIlllllIIlIl = ((WorldServer[])(Object)(llllllllllllllllIIIlIIlllllIIlII = (int)(Object)this.mcServer.worldServers)).length;
            for (float llllllllllllllllIIIlIIlllllIIllI = 0; llllllllllllllllIIIlIIlllllIIllI < llllllllllllllllIIIlIIlllllIIlIl; ++llllllllllllllllIIIlIIlllllIIllI) {
                final WorldServer llllllllllllllllIIIlIIlllllIlIlI = llllllllllllllllIIIlIIlllllIIlII[llllllllllllllllIIIlIIlllllIIllI];
                if (llllllllllllllllIIIlIIlllllIlIlI != null) {
                    llllllllllllllllIIIlIIlllllIlIlI.getPlayerChunkMap().setPlayerViewRadius(llllllllllllllllIIIlIIlllllIlIII);
                    llllllllllllllllIIIlIIlllllIlIlI.getEntityTracker().setViewDistance(llllllllllllllllIIIlIIlllllIlIII);
                }
            }
        }
    }
    
    private void sendPlayerPermissionLevel(final EntityPlayerMP llllllllllllllllIIIlIlIIlllIIlIl, final int llllllllllllllllIIIlIlIIllIlllll) {
        if (llllllllllllllllIIIlIlIIlllIIlIl != null && llllllllllllllllIIIlIlIIlllIIlIl.connection != null) {
            byte llllllllllllllllIIIlIlIIlllIIIIl = 0;
            if (llllllllllllllllIIIlIlIIllIlllll <= 0) {
                final byte llllllllllllllllIIIlIlIIlllIIIll = 24;
            }
            else if (llllllllllllllllIIIlIlIIllIlllll >= 4) {
                final byte llllllllllllllllIIIlIlIIlllIIIlI = 28;
            }
            else {
                llllllllllllllllIIIlIlIIlllIIIIl = (byte)(24 + llllllllllllllllIIIlIlIIllIlllll);
            }
            llllllllllllllllIIIlIlIIlllIIlIl.connection.sendPacket(new SPacketEntityStatus(llllllllllllllllIIIlIlIIlllIIlIl, llllllllllllllllIIIlIlIIlllIIIIl));
        }
    }
    
    public void reloadWhitelist() {
    }
    
    public void sendChatMsg(final ITextComponent llllllllllllllllIIIlIlIIIIIllIlI) {
        this.sendChatMsgImpl(llllllllllllllllIIIlIlIIIIIllIlI, true);
    }
    
    public void setWhiteListEnabled(final boolean llllllllllllllllIIIlIlIIIllIIIIl) {
        this.whiteListEnforced = llllllllllllllllIIIlIlIIIllIIIIl;
    }
    
    public String[] getAvailablePlayerDat() {
        return this.mcServer.worldServers[0].getSaveHandler().getPlayerNBTManager().getAvailablePlayerDat();
    }
    
    public String getFormattedListOfPlayers(final boolean llllllllllllllllIIIlIlIlIIIlIlII) {
        String llllllllllllllllIIIlIlIlIIIllIII = "";
        final List<EntityPlayerMP> llllllllllllllllIIIlIlIlIIIlIlll = (List<EntityPlayerMP>)Lists.newArrayList((Iterable)this.playerEntityList);
        for (int llllllllllllllllIIIlIlIlIIIlIllI = 0; llllllllllllllllIIIlIlIlIIIlIllI < llllllllllllllllIIIlIlIlIIIlIlll.size(); ++llllllllllllllllIIIlIlIlIIIlIllI) {
            if (llllllllllllllllIIIlIlIlIIIlIllI > 0) {
                llllllllllllllllIIIlIlIlIIIllIII = String.valueOf(llllllllllllllllIIIlIlIlIIIllIII) + ", ";
            }
            llllllllllllllllIIIlIlIlIIIllIII = String.valueOf(llllllllllllllllIIIlIlIlIIIllIII) + llllllllllllllllIIIlIlIlIIIlIlll.get(llllllllllllllllIIIlIlIlIIIlIllI).getName();
            if (llllllllllllllllIIIlIlIlIIIlIlII) {
                llllllllllllllllIIIlIlIlIIIllIII = String.valueOf(llllllllllllllllIIIlIlIlIIIllIII) + " (" + llllllllllllllllIIIlIlIlIIIlIlll.get(llllllllllllllllIIIlIlIlIIIlIllI).getCachedUniqueIdString() + ")";
            }
        }
        return llllllllllllllllIIIlIlIlIIIllIII;
    }
    
    public UserListBans getBannedPlayers() {
        return this.bannedPlayers;
    }
    
    public EntityPlayerMP createPlayerForUser(final GameProfile llllllllllllllllIIIlIlIlllIlIIIl) {
        final UUID llllllllllllllllIIIlIlIlllIlIIII = EntityPlayer.getUUID(llllllllllllllllIIIlIlIlllIlIIIl);
        final List<EntityPlayerMP> llllllllllllllllIIIlIlIlllIIllll = (List<EntityPlayerMP>)Lists.newArrayList();
        for (int llllllllllllllllIIIlIlIlllIIlllI = 0; llllllllllllllllIIIlIlIlllIIlllI < this.playerEntityList.size(); ++llllllllllllllllIIIlIlIlllIIlllI) {
            final EntityPlayerMP llllllllllllllllIIIlIlIlllIIllIl = this.playerEntityList.get(llllllllllllllllIIIlIlIlllIIlllI);
            if (llllllllllllllllIIIlIlIlllIIllIl.getUniqueID().equals(llllllllllllllllIIIlIlIlllIlIIII)) {
                llllllllllllllllIIIlIlIlllIIllll.add(llllllllllllllllIIIlIlIlllIIllIl);
            }
        }
        final EntityPlayerMP llllllllllllllllIIIlIlIlllIIllII = this.uuidToPlayerMap.get(llllllllllllllllIIIlIlIlllIlIIIl.getId());
        if (llllllllllllllllIIIlIlIlllIIllII != null && !llllllllllllllllIIIlIlIlllIIllll.contains(llllllllllllllllIIIlIlIlllIIllII)) {
            llllllllllllllllIIIlIlIlllIIllll.add(llllllllllllllllIIIlIlIlllIIllII);
        }
        for (final EntityPlayerMP llllllllllllllllIIIlIlIlllIIlIll : llllllllllllllllIIIlIlIlllIIllll) {
            llllllllllllllllIIIlIlIlllIIlIll.connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.duplicate_login", new Object[0]));
        }
        PlayerInteractionManager llllllllllllllllIIIlIlIlllIIlIIl = null;
        if (this.mcServer.isDemo()) {
            final PlayerInteractionManager llllllllllllllllIIIlIlIlllIIlIlI = new DemoPlayerInteractionManager(this.mcServer.worldServerForDimension(0));
        }
        else {
            llllllllllllllllIIIlIlIlllIIlIIl = new PlayerInteractionManager(this.mcServer.worldServerForDimension(0));
        }
        return new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(0), llllllllllllllllIIIlIlIlllIlIIIl, llllllllllllllllIIIlIlIlllIIlIIl);
    }
    
    public int getCurrentPlayerCount() {
        return this.playerEntityList.size();
    }
    
    public void changePlayerDimension(final EntityPlayerMP llllllllllllllllIIIlIlIllIIIIlII, final int llllllllllllllllIIIlIlIllIIIIIll) {
        final int llllllllllllllllIIIlIlIllIIIlIIl = llllllllllllllllIIIlIlIllIIIIlII.dimension;
        final WorldServer llllllllllllllllIIIlIlIllIIIlIII = this.mcServer.worldServerForDimension(llllllllllllllllIIIlIlIllIIIIlII.dimension);
        llllllllllllllllIIIlIlIllIIIIlII.dimension = llllllllllllllllIIIlIlIllIIIIIll;
        final WorldServer llllllllllllllllIIIlIlIllIIIIlll = this.mcServer.worldServerForDimension(llllllllllllllllIIIlIlIllIIIIlII.dimension);
        llllllllllllllllIIIlIlIllIIIIlII.connection.sendPacket(new SPacketRespawn(llllllllllllllllIIIlIlIllIIIIlII.dimension, llllllllllllllllIIIlIlIllIIIIlII.world.getDifficulty(), llllllllllllllllIIIlIlIllIIIIlII.world.getWorldInfo().getTerrainType(), llllllllllllllllIIIlIlIllIIIIlII.interactionManager.getGameType()));
        this.updatePermissionLevel(llllllllllllllllIIIlIlIllIIIIlII);
        llllllllllllllllIIIlIlIllIIIlIII.removeEntityDangerously(llllllllllllllllIIIlIlIllIIIIlII);
        llllllllllllllllIIIlIlIllIIIIlII.isDead = false;
        this.transferEntityToWorld(llllllllllllllllIIIlIlIllIIIIlII, llllllllllllllllIIIlIlIllIIIlIIl, llllllllllllllllIIIlIlIllIIIlIII, llllllllllllllllIIIlIlIllIIIIlll);
        this.preparePlayer(llllllllllllllllIIIlIlIllIIIIlII, llllllllllllllllIIIlIlIllIIIlIII);
        llllllllllllllllIIIlIlIllIIIIlII.connection.setPlayerLocation(llllllllllllllllIIIlIlIllIIIIlII.posX, llllllllllllllllIIIlIlIllIIIIlII.posY, llllllllllllllllIIIlIlIllIIIIlII.posZ, llllllllllllllllIIIlIlIllIIIIlII.rotationYaw, llllllllllllllllIIIlIlIllIIIIlII.rotationPitch);
        llllllllllllllllIIIlIlIllIIIIlII.interactionManager.setWorld(llllllllllllllllIIIlIlIllIIIIlll);
        llllllllllllllllIIIlIlIllIIIIlII.connection.sendPacket(new SPacketPlayerAbilities(llllllllllllllllIIIlIlIllIIIIlII.capabilities));
        this.updateTimeAndWeatherForPlayer(llllllllllllllllIIIlIlIllIIIIlII, llllllllllllllllIIIlIlIllIIIIlll);
        this.syncPlayerInventory(llllllllllllllllIIIlIlIllIIIIlII);
        for (final PotionEffect llllllllllllllllIIIlIlIllIIIIllI : llllllllllllllllIIIlIlIllIIIIlII.getActivePotionEffects()) {
            llllllllllllllllIIIlIlIllIIIIlII.connection.sendPacket(new SPacketEntityEffect(llllllllllllllllIIIlIlIllIIIIlII.getEntityId(), llllllllllllllllIIIlIlIllIIIIllI));
        }
    }
    
    public void initializeConnectionToPlayer(final NetworkManager llllllllllllllllIIIlIllIIlllIlII, final EntityPlayerMP llllllllllllllllIIIlIllIIlllIIll) {
        final GameProfile llllllllllllllllIIIlIllIIlllIIlI = llllllllllllllllIIIlIllIIlllIIll.getGameProfile();
        final PlayerProfileCache llllllllllllllllIIIlIllIIlllIIIl = this.mcServer.getPlayerProfileCache();
        final GameProfile llllllllllllllllIIIlIllIIlllIIII = llllllllllllllllIIIlIllIIlllIIIl.getProfileByUUID(llllllllllllllllIIIlIllIIlllIIlI.getId());
        final String llllllllllllllllIIIlIllIIllIllll = (llllllllllllllllIIIlIllIIlllIIII == null) ? llllllllllllllllIIIlIllIIlllIIlI.getName() : llllllllllllllllIIIlIllIIlllIIII.getName();
        llllllllllllllllIIIlIllIIlllIIIl.addEntry(llllllllllllllllIIIlIllIIlllIIlI);
        final NBTTagCompound llllllllllllllllIIIlIllIIllIlllI = this.readPlayerDataFromFile(llllllllllllllllIIIlIllIIlllIIll);
        llllllllllllllllIIIlIllIIlllIIll.setWorld(this.mcServer.worldServerForDimension(llllllllllllllllIIIlIllIIlllIIll.dimension));
        llllllllllllllllIIIlIllIIlllIIll.interactionManager.setWorld((WorldServer)llllllllllllllllIIIlIllIIlllIIll.world);
        String llllllllllllllllIIIlIllIIllIllIl = "local";
        if (llllllllllllllllIIIlIllIIlllIlII.getRemoteAddress() != null) {
            llllllllllllllllIIIlIllIIllIllIl = llllllllllllllllIIIlIllIIlllIlII.getRemoteAddress().toString();
        }
        PlayerList.LOG.info("{}[{}] logged in with entity id {} at ({}, {}, {})", (Object)llllllllllllllllIIIlIllIIlllIIll.getName(), (Object)llllllllllllllllIIIlIllIIllIllIl, (Object)llllllllllllllllIIIlIllIIlllIIll.getEntityId(), (Object)llllllllllllllllIIIlIllIIlllIIll.posX, (Object)llllllllllllllllIIIlIllIIlllIIll.posY, (Object)llllllllllllllllIIIlIllIIlllIIll.posZ);
        final WorldServer llllllllllllllllIIIlIllIIllIllII = this.mcServer.worldServerForDimension(llllllllllllllllIIIlIllIIlllIIll.dimension);
        final WorldInfo llllllllllllllllIIIlIllIIllIlIll = llllllllllllllllIIIlIllIIllIllII.getWorldInfo();
        this.setPlayerGameTypeBasedOnOther(llllllllllllllllIIIlIllIIlllIIll, null, llllllllllllllllIIIlIllIIllIllII);
        final NetHandlerPlayServer llllllllllllllllIIIlIllIIllIlIlI = new NetHandlerPlayServer(this.mcServer, llllllllllllllllIIIlIllIIlllIlII, llllllllllllllllIIIlIllIIlllIIll);
        llllllllllllllllIIIlIllIIllIlIlI.sendPacket(new SPacketJoinGame(llllllllllllllllIIIlIllIIlllIIll.getEntityId(), llllllllllllllllIIIlIllIIlllIIll.interactionManager.getGameType(), llllllllllllllllIIIlIllIIllIlIll.isHardcoreModeEnabled(), llllllllllllllllIIIlIllIIllIllII.provider.getDimensionType().getId(), llllllllllllllllIIIlIllIIllIllII.getDifficulty(), this.getMaxPlayers(), llllllllllllllllIIIlIllIIllIlIll.getTerrainType(), llllllllllllllllIIIlIllIIllIllII.getGameRules().getBoolean("reducedDebugInfo")));
        llllllllllllllllIIIlIllIIllIlIlI.sendPacket(new SPacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer()).writeString(this.getServerInstance().getServerModName())));
        llllllllllllllllIIIlIllIIllIlIlI.sendPacket(new SPacketServerDifficulty(llllllllllllllllIIIlIllIIllIlIll.getDifficulty(), llllllllllllllllIIIlIllIIllIlIll.isDifficultyLocked()));
        llllllllllllllllIIIlIllIIllIlIlI.sendPacket(new SPacketPlayerAbilities(llllllllllllllllIIIlIllIIlllIIll.capabilities));
        llllllllllllllllIIIlIllIIllIlIlI.sendPacket(new SPacketHeldItemChange(llllllllllllllllIIIlIllIIlllIIll.inventory.currentItem));
        this.updatePermissionLevel(llllllllllllllllIIIlIllIIlllIIll);
        llllllllllllllllIIIlIllIIlllIIll.getStatFile().markAllDirty();
        llllllllllllllllIIIlIllIIlllIIll.func_192037_E().func_192826_c(llllllllllllllllIIIlIllIIlllIIll);
        this.sendScoreboard((ServerScoreboard)llllllllllllllllIIIlIllIIllIllII.getScoreboard(), llllllllllllllllIIIlIllIIlllIIll);
        this.mcServer.refreshStatusNextTick();
        TextComponentTranslation llllllllllllllllIIIlIllIIllIlIII = null;
        if (llllllllllllllllIIIlIllIIlllIIll.getName().equalsIgnoreCase(llllllllllllllllIIIlIllIIllIllll)) {
            final TextComponentTranslation llllllllllllllllIIIlIllIIllIlIIl = new TextComponentTranslation("multiplayer.player.joined", new Object[] { llllllllllllllllIIIlIllIIlllIIll.getDisplayName() });
        }
        else {
            llllllllllllllllIIIlIllIIllIlIII = new TextComponentTranslation("multiplayer.player.joined.renamed", new Object[] { llllllllllllllllIIIlIllIIlllIIll.getDisplayName(), llllllllllllllllIIIlIllIIllIllll });
        }
        llllllllllllllllIIIlIllIIllIlIII.getStyle().setColor(TextFormatting.YELLOW);
        this.sendChatMsg(llllllllllllllllIIIlIllIIllIlIII);
        this.playerLoggedIn(llllllllllllllllIIIlIllIIlllIIll);
        llllllllllllllllIIIlIllIIllIlIlI.setPlayerLocation(llllllllllllllllIIIlIllIIlllIIll.posX, llllllllllllllllIIIlIllIIlllIIll.posY, llllllllllllllllIIIlIllIIlllIIll.posZ, llllllllllllllllIIIlIllIIlllIIll.rotationYaw, llllllllllllllllIIIlIllIIlllIIll.rotationPitch);
        this.updateTimeAndWeatherForPlayer(llllllllllllllllIIIlIllIIlllIIll, llllllllllllllllIIIlIllIIllIllII);
        if (!this.mcServer.getResourcePackUrl().isEmpty()) {
            llllllllllllllllIIIlIllIIlllIIll.loadResourcePack(this.mcServer.getResourcePackUrl(), this.mcServer.getResourcePackHash());
        }
        for (final PotionEffect llllllllllllllllIIIlIllIIllIIlll : llllllllllllllllIIIlIllIIlllIIll.getActivePotionEffects()) {
            llllllllllllllllIIIlIllIIllIlIlI.sendPacket(new SPacketEntityEffect(llllllllllllllllIIIlIllIIlllIIll.getEntityId(), llllllllllllllllIIIlIllIIllIIlll));
        }
        if (llllllllllllllllIIIlIllIIllIlllI != null && llllllllllllllllIIIlIllIIllIlllI.hasKey("RootVehicle", 10)) {
            final NBTTagCompound llllllllllllllllIIIlIllIIllIIllI = llllllllllllllllIIIlIllIIllIlllI.getCompoundTag("RootVehicle");
            final Entity llllllllllllllllIIIlIllIIllIIlIl = AnvilChunkLoader.readWorldEntity(llllllllllllllllIIIlIllIIllIIllI.getCompoundTag("Entity"), llllllllllllllllIIIlIllIIllIllII, true);
            if (llllllllllllllllIIIlIllIIllIIlIl != null) {
                final UUID llllllllllllllllIIIlIllIIllIIlII = llllllllllllllllIIIlIllIIllIIllI.getUniqueId("Attach");
                if (llllllllllllllllIIIlIllIIllIIlIl.getUniqueID().equals(llllllllllllllllIIIlIllIIllIIlII)) {
                    llllllllllllllllIIIlIllIIlllIIll.startRiding(llllllllllllllllIIIlIllIIllIIlIl, true);
                }
                else {
                    for (final Entity llllllllllllllllIIIlIllIIllIIIll : llllllllllllllllIIIlIllIIllIIlIl.getRecursivePassengers()) {
                        if (llllllllllllllllIIIlIllIIllIIIll.getUniqueID().equals(llllllllllllllllIIIlIllIIllIIlII)) {
                            llllllllllllllllIIIlIllIIlllIIll.startRiding(llllllllllllllllIIIlIllIIllIIIll, true);
                            break;
                        }
                    }
                }
                if (!llllllllllllllllIIIlIllIIlllIIll.isRiding()) {
                    PlayerList.LOG.warn("Couldn't reattach entity to player");
                    llllllllllllllllIIIlIllIIllIllII.removeEntityDangerously(llllllllllllllllIIIlIllIIllIIlIl);
                    for (final Entity llllllllllllllllIIIlIllIIllIIIlI : llllllllllllllllIIIlIllIIllIIlIl.getRecursivePassengers()) {
                        llllllllllllllllIIIlIllIIllIllII.removeEntityDangerously(llllllllllllllllIIIlIllIIllIIIlI);
                    }
                }
            }
        }
        llllllllllllllllIIIlIllIIlllIIll.addSelfToInternalCraftingInventory();
    }
    
    protected void writePlayerData(final EntityPlayerMP llllllllllllllllIIIlIllIIIIlIlII) {
        this.playerNBTManagerObj.writePlayerData(llllllllllllllllIIIlIllIIIIlIlII);
        final StatisticsManagerServer llllllllllllllllIIIlIllIIIIlIIll = this.playerStatFiles.get(llllllllllllllllIIIlIllIIIIlIlII.getUniqueID());
        if (llllllllllllllllIIIlIllIIIIlIIll != null) {
            llllllllllllllllIIIlIllIIIIlIIll.saveStatFile();
        }
        final PlayerAdvancements llllllllllllllllIIIlIllIIIIlIIlI = this.field_192055_p.get(llllllllllllllllIIIlIllIIIIlIlII.getUniqueID());
        if (llllllllllllllllIIIlIllIIIIlIIlI != null) {
            llllllllllllllllIIIlIllIIIIlIIlI.func_192749_b();
        }
    }
    
    public String[] getAllUsernames() {
        final String[] llllllllllllllllIIIlIlIlIIIIllII = new String[this.playerEntityList.size()];
        for (int llllllllllllllllIIIlIlIlIIIIlIll = 0; llllllllllllllllIIIlIlIlIIIIlIll < this.playerEntityList.size(); ++llllllllllllllllIIIlIlIlIIIIlIll) {
            llllllllllllllllIIIlIlIlIIIIllII[llllllllllllllllIIIlIlIlIIIIlIll] = this.playerEntityList.get(llllllllllllllllIIIlIlIlIIIIlIll).getName();
        }
        return llllllllllllllllIIIlIlIlIIIIllII;
    }
    
    public void sendMessageToAllTeamMembers(final EntityPlayer llllllllllllllllIIIlIlIlIIllIlll, final ITextComponent llllllllllllllllIIIlIlIlIIllIllI) {
        final Team llllllllllllllllIIIlIlIlIIlllIll = llllllllllllllllIIIlIlIlIIllIlll.getTeam();
        if (llllllllllllllllIIIlIlIlIIlllIll != null) {
            for (final String llllllllllllllllIIIlIlIlIIlllIlI : llllllllllllllllIIIlIlIlIIlllIll.getMembershipCollection()) {
                final EntityPlayerMP llllllllllllllllIIIlIlIlIIlllIIl = this.getPlayerByUsername(llllllllllllllllIIIlIlIlIIlllIlI);
                if (llllllllllllllllIIIlIlIlIIlllIIl != null && llllllllllllllllIIIlIlIlIIlllIIl != llllllllllllllllIIIlIlIlIIllIlll) {
                    llllllllllllllllIIIlIlIlIIlllIIl.addChatMessage(llllllllllllllllIIIlIlIlIIllIllI);
                }
            }
        }
    }
    
    public boolean canJoin(final GameProfile llllllllllllllllIIIlIlIIllIllIII) {
        return !this.whiteListEnforced || ((UserList<GameProfile, V>)this.ops).hasEntry(llllllllllllllllIIIlIlIIllIllIII) || ((UserList<GameProfile, V>)this.whiteListedPlayers).hasEntry(llllllllllllllllIIIlIlIIllIllIII);
    }
    
    public void addOp(final GameProfile llllllllllllllllIIIlIlIIllllIIIl) {
        final int llllllllllllllllIIIlIlIIllllIIll = this.mcServer.getOpPermissionLevel();
        ((UserList<K, UserListOpsEntry>)this.ops).addEntry(new UserListOpsEntry(llllllllllllllllIIIlIlIIllllIIIl, this.mcServer.getOpPermissionLevel(), this.ops.bypassesPlayerLimit(llllllllllllllllIIIlIlIIllllIIIl)));
        this.sendPlayerPermissionLevel(this.getPlayerByUUID(llllllllllllllllIIIlIlIIllllIIIl.getId()), llllllllllllllllIIIlIlIIllllIIll);
    }
    
    public PlayerList(final MinecraftServer llllllllllllllllIIIlIllIlIIIlIII) {
        this.playerEntityList = (List<EntityPlayerMP>)Lists.newArrayList();
        this.uuidToPlayerMap = (Map<UUID, EntityPlayerMP>)Maps.newHashMap();
        this.bannedPlayers = new UserListBans(PlayerList.FILE_PLAYERBANS);
        this.bannedIPs = new UserListIPBans(PlayerList.FILE_IPBANS);
        this.ops = new UserListOps(PlayerList.FILE_OPS);
        this.whiteListedPlayers = new UserListWhitelist(PlayerList.FILE_WHITELIST);
        this.playerStatFiles = (Map<UUID, StatisticsManagerServer>)Maps.newHashMap();
        this.field_192055_p = (Map<UUID, PlayerAdvancements>)Maps.newHashMap();
        this.mcServer = llllllllllllllllIIIlIllIlIIIlIII;
        this.bannedPlayers.setLanServer(false);
        this.bannedIPs.setLanServer(false);
        this.maxPlayers = 8;
    }
    
    public void sendToAllNearExcept(@Nullable final EntityPlayer llllllllllllllllIIIlIlIIlIlllIII, final double llllllllllllllllIIIlIlIIlIllIlll, final double llllllllllllllllIIIlIlIIlIlIlIIl, final double llllllllllllllllIIIlIlIIlIlIlIII, final double llllllllllllllllIIIlIlIIlIlIIlll, final int llllllllllllllllIIIlIlIIlIlIIllI, final Packet<?> llllllllllllllllIIIlIlIIlIlIIlIl) {
        for (int llllllllllllllllIIIlIlIIlIllIIIl = 0; llllllllllllllllIIIlIlIIlIllIIIl < this.playerEntityList.size(); ++llllllllllllllllIIIlIlIIlIllIIIl) {
            final EntityPlayerMP llllllllllllllllIIIlIlIIlIllIIII = this.playerEntityList.get(llllllllllllllllIIIlIlIIlIllIIIl);
            if (llllllllllllllllIIIlIlIIlIllIIII != llllllllllllllllIIIlIlIIlIlllIII && llllllllllllllllIIIlIlIIlIllIIII.dimension == llllllllllllllllIIIlIlIIlIlIIllI) {
                final double llllllllllllllllIIIlIlIIlIlIllll = llllllllllllllllIIIlIlIIlIllIlll - llllllllllllllllIIIlIlIIlIllIIII.posX;
                final double llllllllllllllllIIIlIlIIlIlIlllI = llllllllllllllllIIIlIlIIlIlIlIIl - llllllllllllllllIIIlIlIIlIllIIII.posY;
                final double llllllllllllllllIIIlIlIIlIlIllIl = llllllllllllllllIIIlIlIIlIlIlIII - llllllllllllllllIIIlIlIIlIllIIII.posZ;
                if (llllllllllllllllIIIlIlIIlIlIllll * llllllllllllllllIIIlIlIIlIlIllll + llllllllllllllllIIIlIlIIlIlIlllI * llllllllllllllllIIIlIlIIlIlIlllI + llllllllllllllllIIIlIlIIlIlIllIl * llllllllllllllllIIIlIlIIlIlIllIl < llllllllllllllllIIIlIlIIlIlIIlll * llllllllllllllllIIIlIlIIlIlIIlll) {
                    llllllllllllllllIIIlIlIIlIllIIII.connection.sendPacket(llllllllllllllllIIIlIlIIlIlIIlIl);
                }
            }
        }
    }
    
    public GameProfile[] getAllProfiles() {
        final GameProfile[] llllllllllllllllIIIlIlIlIIIIIIll = new GameProfile[this.playerEntityList.size()];
        for (int llllllllllllllllIIIlIlIlIIIIIIlI = 0; llllllllllllllllIIIlIlIlIIIIIIlI < this.playerEntityList.size(); ++llllllllllllllllIIIlIlIlIIIIIIlI) {
            llllllllllllllllIIIlIlIlIIIIIIll[llllllllllllllllIIIlIlIlIIIIIIlI] = this.playerEntityList.get(llllllllllllllllIIIlIlIlIIIIIIlI).getGameProfile();
        }
        return llllllllllllllllIIIlIlIlIIIIIIll;
    }
    
    public String allowUserToConnect(final SocketAddress llllllllllllllllIIIlIlIlllIlllIl, final GameProfile llllllllllllllllIIIlIlIllllIIIll) {
        if (this.bannedPlayers.isBanned(llllllllllllllllIIIlIlIllllIIIll)) {
            final UserListBansEntry llllllllllllllllIIIlIlIllllIIIlI = this.bannedPlayers.getEntry(llllllllllllllllIIIlIlIllllIIIll);
            String llllllllllllllllIIIlIlIllllIIIIl = "You are banned from this server!\nReason: " + llllllllllllllllIIIlIlIllllIIIlI.getBanReason();
            if (llllllllllllllllIIIlIlIllllIIIlI.getBanEndDate() != null) {
                llllllllllllllllIIIlIlIllllIIIIl = String.valueOf(llllllllllllllllIIIlIlIllllIIIIl) + "\nYour ban will be removed on " + PlayerList.DATE_FORMAT.format(llllllllllllllllIIIlIlIllllIIIlI.getBanEndDate());
            }
            return llllllllllllllllIIIlIlIllllIIIIl;
        }
        if (!this.canJoin(llllllllllllllllIIIlIlIllllIIIll)) {
            return "You are not white-listed on this server!";
        }
        if (this.bannedIPs.isBanned(llllllllllllllllIIIlIlIlllIlllIl)) {
            final UserListIPBansEntry llllllllllllllllIIIlIlIllllIIIII = this.bannedIPs.getBanEntry(llllllllllllllllIIIlIlIlllIlllIl);
            String llllllllllllllllIIIlIlIlllIlllll = "Your IP address is banned from this server!\nReason: " + llllllllllllllllIIIlIlIllllIIIII.getBanReason();
            if (llllllllllllllllIIIlIlIllllIIIII.getBanEndDate() != null) {
                llllllllllllllllIIIlIlIlllIlllll = String.valueOf(llllllllllllllllIIIlIlIlllIlllll) + "\nYour ban will be removed on " + PlayerList.DATE_FORMAT.format(llllllllllllllllIIIlIlIllllIIIII.getBanEndDate());
            }
            return llllllllllllllllIIIlIlIlllIlllll;
        }
        return (this.playerEntityList.size() >= this.maxPlayers && !this.bypassesPlayerLimit(llllllllllllllllIIIlIlIllllIIIll)) ? "The server is full!" : null;
    }
    
    public boolean canSendCommands(final GameProfile llllllllllllllllIIIlIlIIllIlIlII) {
        return ((UserList<GameProfile, V>)this.ops).hasEntry(llllllllllllllllIIIlIlIIllIlIlII) || (this.mcServer.isSinglePlayer() && this.mcServer.worldServers[0].getWorldInfo().areCommandsAllowed() && this.mcServer.getServerOwner().equalsIgnoreCase(llllllllllllllllIIIlIlIIllIlIlII.getName())) || this.commandsAllowedForAll;
    }
    
    public void setGameType(final GameType llllllllllllllllIIIlIlIIIlIIIllI) {
        this.gameType = llllllllllllllllIIIlIlIIIlIIIllI;
    }
    
    public void sendMessageToTeamOrAllPlayers(final EntityPlayer llllllllllllllllIIIlIlIlIIlIlIlI, final ITextComponent llllllllllllllllIIIlIlIlIIlIIIll) {
        final Team llllllllllllllllIIIlIlIlIIlIlIII = llllllllllllllllIIIlIlIlIIlIlIlI.getTeam();
        if (llllllllllllllllIIIlIlIlIIlIlIII == null) {
            this.sendChatMsg(llllllllllllllllIIIlIlIlIIlIIIll);
        }
        else {
            for (int llllllllllllllllIIIlIlIlIIlIIlll = 0; llllllllllllllllIIIlIlIlIIlIIlll < this.playerEntityList.size(); ++llllllllllllllllIIIlIlIlIIlIIlll) {
                final EntityPlayerMP llllllllllllllllIIIlIlIlIIlIIllI = this.playerEntityList.get(llllllllllllllllIIIlIlIlIIlIIlll);
                if (llllllllllllllllIIIlIlIlIIlIIllI.getTeam() != llllllllllllllllIIIlIlIlIIlIlIII) {
                    llllllllllllllllIIIlIlIlIIlIIllI.addChatMessage(llllllllllllllllIIIlIlIlIIlIIIll);
                }
            }
        }
    }
    
    public String[] getWhitelistedPlayerNames() {
        return this.whiteListedPlayers.getKeys();
    }
    
    public void sendChatMsgImpl(final ITextComponent llllllllllllllllIIIlIlIIIIlIIIlI, final boolean llllllllllllllllIIIlIlIIIIlIIlIl) {
        this.mcServer.addChatMessage(llllllllllllllllIIIlIlIIIIlIIIlI);
        final ChatType llllllllllllllllIIIlIlIIIIlIIlII = llllllllllllllllIIIlIlIIIIlIIlIl ? ChatType.SYSTEM : ChatType.CHAT;
        this.sendPacketToAllPlayers(new SPacketChat(llllllllllllllllIIIlIlIIIIlIIIlI, llllllllllllllllIIIlIlIIIIlIIlII));
    }
    
    public void setCommandsAllowedForAll(final boolean llllllllllllllllIIIlIlIIIIllIIlI) {
        this.commandsAllowedForAll = llllllllllllllllIIIlIlIIIIllIIlI;
    }
    
    public int getEntityViewDistance() {
        return PlayerChunkMap.getFurthestViewableBlock(this.getViewDistance());
    }
    
    @Nullable
    public EntityPlayerMP getPlayerByUsername(final String llllllllllllllllIIIlIlIIllIIlIIl) {
        for (final EntityPlayerMP llllllllllllllllIIIlIlIIllIIlIll : this.playerEntityList) {
            if (llllllllllllllllIIIlIlIIllIIlIll.getName().equalsIgnoreCase(llllllllllllllllIIIlIlIIllIIlIIl)) {
                return llllllllllllllllIIIlIlIIllIIlIll;
            }
        }
        return null;
    }
    
    public EntityPlayerMP recreatePlayerEntity(final EntityPlayerMP llllllllllllllllIIIlIlIllIllIllI, final int llllllllllllllllIIIlIlIllIlIlIII, final boolean llllllllllllllllIIIlIlIllIlIIlll) {
        llllllllllllllllIIIlIlIllIllIllI.getServerWorld().getEntityTracker().removePlayerFromTrackers(llllllllllllllllIIIlIlIllIllIllI);
        llllllllllllllllIIIlIlIllIllIllI.getServerWorld().getEntityTracker().untrackEntity(llllllllllllllllIIIlIlIllIllIllI);
        llllllllllllllllIIIlIlIllIllIllI.getServerWorld().getPlayerChunkMap().removePlayer(llllllllllllllllIIIlIlIllIllIllI);
        this.playerEntityList.remove(llllllllllllllllIIIlIlIllIllIllI);
        this.mcServer.worldServerForDimension(llllllllllllllllIIIlIlIllIllIllI.dimension).removeEntityDangerously(llllllllllllllllIIIlIlIllIllIllI);
        final BlockPos llllllllllllllllIIIlIlIllIllIIll = llllllllllllllllIIIlIlIllIllIllI.getBedLocation();
        final boolean llllllllllllllllIIIlIlIllIllIIlI = llllllllllllllllIIIlIlIllIllIllI.isSpawnForced();
        llllllllllllllllIIIlIlIllIllIllI.dimension = llllllllllllllllIIIlIlIllIlIlIII;
        PlayerInteractionManager llllllllllllllllIIIlIlIllIllIIII = null;
        if (this.mcServer.isDemo()) {
            final PlayerInteractionManager llllllllllllllllIIIlIlIllIllIIIl = new DemoPlayerInteractionManager(this.mcServer.worldServerForDimension(llllllllllllllllIIIlIlIllIllIllI.dimension));
        }
        else {
            llllllllllllllllIIIlIlIllIllIIII = new PlayerInteractionManager(this.mcServer.worldServerForDimension(llllllllllllllllIIIlIlIllIllIllI.dimension));
        }
        final EntityPlayerMP llllllllllllllllIIIlIlIllIlIllll = new EntityPlayerMP(this.mcServer, this.mcServer.worldServerForDimension(llllllllllllllllIIIlIlIllIllIllI.dimension), llllllllllllllllIIIlIlIllIllIllI.getGameProfile(), llllllllllllllllIIIlIlIllIllIIII);
        llllllllllllllllIIIlIlIllIlIllll.connection = llllllllllllllllIIIlIlIllIllIllI.connection;
        llllllllllllllllIIIlIlIllIlIllll.func_193104_a(llllllllllllllllIIIlIlIllIllIllI, llllllllllllllllIIIlIlIllIlIIlll);
        llllllllllllllllIIIlIlIllIlIllll.setEntityId(llllllllllllllllIIIlIlIllIllIllI.getEntityId());
        llllllllllllllllIIIlIlIllIlIllll.setCommandStats(llllllllllllllllIIIlIlIllIllIllI);
        llllllllllllllllIIIlIlIllIlIllll.setPrimaryHand(llllllllllllllllIIIlIlIllIllIllI.getPrimaryHand());
        for (final String llllllllllllllllIIIlIlIllIlIlllI : llllllllllllllllIIIlIlIllIllIllI.getTags()) {
            llllllllllllllllIIIlIlIllIlIllll.addTag(llllllllllllllllIIIlIlIllIlIlllI);
        }
        final WorldServer llllllllllllllllIIIlIlIllIlIllIl = this.mcServer.worldServerForDimension(llllllllllllllllIIIlIlIllIllIllI.dimension);
        this.setPlayerGameTypeBasedOnOther(llllllllllllllllIIIlIlIllIlIllll, llllllllllllllllIIIlIlIllIllIllI, llllllllllllllllIIIlIlIllIlIllIl);
        if (llllllllllllllllIIIlIlIllIllIIll != null) {
            final BlockPos llllllllllllllllIIIlIlIllIlIllII = EntityPlayer.getBedSpawnLocation(this.mcServer.worldServerForDimension(llllllllllllllllIIIlIlIllIllIllI.dimension), llllllllllllllllIIIlIlIllIllIIll, llllllllllllllllIIIlIlIllIllIIlI);
            if (llllllllllllllllIIIlIlIllIlIllII != null) {
                llllllllllllllllIIIlIlIllIlIllll.setLocationAndAngles(llllllllllllllllIIIlIlIllIlIllII.getX() + 0.5f, llllllllllllllllIIIlIlIllIlIllII.getY() + 0.1f, llllllllllllllllIIIlIlIllIlIllII.getZ() + 0.5f, 0.0f, 0.0f);
                llllllllllllllllIIIlIlIllIlIllll.setSpawnPoint(llllllllllllllllIIIlIlIllIllIIll, llllllllllllllllIIIlIlIllIllIIlI);
            }
            else {
                llllllllllllllllIIIlIlIllIlIllll.connection.sendPacket(new SPacketChangeGameState(0, 0.0f));
            }
        }
        llllllllllllllllIIIlIlIllIlIllIl.getChunkProvider().provideChunk((int)llllllllllllllllIIIlIlIllIlIllll.posX >> 4, (int)llllllllllllllllIIIlIlIllIlIllll.posZ >> 4);
        while (!llllllllllllllllIIIlIlIllIlIllIl.getCollisionBoxes(llllllllllllllllIIIlIlIllIlIllll, llllllllllllllllIIIlIlIllIlIllll.getEntityBoundingBox()).isEmpty() && llllllllllllllllIIIlIlIllIlIllll.posY < 256.0) {
            llllllllllllllllIIIlIlIllIlIllll.setPosition(llllllllllllllllIIIlIlIllIlIllll.posX, llllllllllllllllIIIlIlIllIlIllll.posY + 1.0, llllllllllllllllIIIlIlIllIlIllll.posZ);
        }
        llllllllllllllllIIIlIlIllIlIllll.connection.sendPacket(new SPacketRespawn(llllllllllllllllIIIlIlIllIlIllll.dimension, llllllllllllllllIIIlIlIllIlIllll.world.getDifficulty(), llllllllllllllllIIIlIlIllIlIllll.world.getWorldInfo().getTerrainType(), llllllllllllllllIIIlIlIllIlIllll.interactionManager.getGameType()));
        final BlockPos llllllllllllllllIIIlIlIllIlIlIll = llllllllllllllllIIIlIlIllIlIllIl.getSpawnPoint();
        llllllllllllllllIIIlIlIllIlIllll.connection.setPlayerLocation(llllllllllllllllIIIlIlIllIlIllll.posX, llllllllllllllllIIIlIlIllIlIllll.posY, llllllllllllllllIIIlIlIllIlIllll.posZ, llllllllllllllllIIIlIlIllIlIllll.rotationYaw, llllllllllllllllIIIlIlIllIlIllll.rotationPitch);
        llllllllllllllllIIIlIlIllIlIllll.connection.sendPacket(new SPacketSpawnPosition(llllllllllllllllIIIlIlIllIlIlIll));
        llllllllllllllllIIIlIlIllIlIllll.connection.sendPacket(new SPacketSetExperience(llllllllllllllllIIIlIlIllIlIllll.experience, llllllllllllllllIIIlIlIllIlIllll.experienceTotal, llllllllllllllllIIIlIlIllIlIllll.experienceLevel));
        this.updateTimeAndWeatherForPlayer(llllllllllllllllIIIlIlIllIlIllll, llllllllllllllllIIIlIlIllIlIllIl);
        this.updatePermissionLevel(llllllllllllllllIIIlIlIllIlIllll);
        llllllllllllllllIIIlIlIllIlIllIl.getPlayerChunkMap().addPlayer(llllllllllllllllIIIlIlIllIlIllll);
        llllllllllllllllIIIlIlIllIlIllIl.spawnEntityInWorld(llllllllllllllllIIIlIlIllIlIllll);
        this.playerEntityList.add(llllllllllllllllIIIlIlIllIlIllll);
        this.uuidToPlayerMap.put(llllllllllllllllIIIlIlIllIlIllll.getUniqueID(), llllllllllllllllIIIlIlIllIlIllll);
        llllllllllllllllIIIlIlIllIlIllll.addSelfToInternalCraftingInventory();
        llllllllllllllllIIIlIlIllIlIllll.setHealth(llllllllllllllllIIIlIlIllIlIllll.getHealth());
        return llllllllllllllllIIIlIlIllIlIllll;
    }
    
    public void playerLoggedOut(final EntityPlayerMP llllllllllllllllIIIlIlIlllllIllI) {
        final WorldServer llllllllllllllllIIIlIlIlllllIlIl = llllllllllllllllIIIlIlIlllllIllI.getServerWorld();
        llllllllllllllllIIIlIlIlllllIllI.addStat(StatList.LEAVE_GAME);
        this.writePlayerData(llllllllllllllllIIIlIlIlllllIllI);
        if (llllllllllllllllIIIlIlIlllllIllI.isRiding()) {
            final Entity llllllllllllllllIIIlIlIlllllIlII = llllllllllllllllIIIlIlIlllllIllI.getLowestRidingEntity();
            if (llllllllllllllllIIIlIlIlllllIlII.getRecursivePassengersByType(EntityPlayerMP.class).size() == 1) {
                PlayerList.LOG.debug("Removing player mount");
                llllllllllllllllIIIlIlIlllllIllI.dismountRidingEntity();
                llllllllllllllllIIIlIlIlllllIlIl.removeEntityDangerously(llllllllllllllllIIIlIlIlllllIlII);
                for (final Entity llllllllllllllllIIIlIlIlllllIIll : llllllllllllllllIIIlIlIlllllIlII.getRecursivePassengers()) {
                    llllllllllllllllIIIlIlIlllllIlIl.removeEntityDangerously(llllllllllllllllIIIlIlIlllllIIll);
                }
                llllllllllllllllIIIlIlIlllllIlIl.getChunkFromChunkCoords(llllllllllllllllIIIlIlIlllllIllI.chunkCoordX, llllllllllllllllIIIlIlIlllllIllI.chunkCoordZ).setChunkModified();
            }
        }
        llllllllllllllllIIIlIlIlllllIlIl.removeEntity(llllllllllllllllIIIlIlIlllllIllI);
        llllllllllllllllIIIlIlIlllllIlIl.getPlayerChunkMap().removePlayer(llllllllllllllllIIIlIlIlllllIllI);
        llllllllllllllllIIIlIlIlllllIllI.func_192039_O().func_192745_a();
        this.playerEntityList.remove(llllllllllllllllIIIlIlIlllllIllI);
        final UUID llllllllllllllllIIIlIlIlllllIIlI = llllllllllllllllIIIlIlIlllllIllI.getUniqueID();
        final EntityPlayerMP llllllllllllllllIIIlIlIlllllIIIl = this.uuidToPlayerMap.get(llllllllllllllllIIIlIlIlllllIIlI);
        if (llllllllllllllllIIIlIlIlllllIIIl == llllllllllllllllIIIlIlIlllllIllI) {
            this.uuidToPlayerMap.remove(llllllllllllllllIIIlIlIlllllIIlI);
            this.playerStatFiles.remove(llllllllllllllllIIIlIlIlllllIIlI);
            this.field_192055_p.remove(llllllllllllllllIIIlIlIlllllIIlI);
        }
        this.sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.REMOVE_PLAYER, new EntityPlayerMP[] { llllllllllllllllIIIlIlIlllllIllI }));
    }
    
    protected void sendScoreboard(final ServerScoreboard llllllllllllllllIIIlIllIIlIIIIII, final EntityPlayerMP llllllllllllllllIIIlIllIIlIIIllI) {
        final Set<ScoreObjective> llllllllllllllllIIIlIllIIlIIIlIl = (Set<ScoreObjective>)Sets.newHashSet();
        for (final ScorePlayerTeam llllllllllllllllIIIlIllIIlIIIlII : llllllllllllllllIIIlIllIIlIIIIII.getTeams()) {
            llllllllllllllllIIIlIllIIlIIIllI.connection.sendPacket(new SPacketTeams(llllllllllllllllIIIlIllIIlIIIlII, 0));
        }
        for (int llllllllllllllllIIIlIllIIlIIIIll = 0; llllllllllllllllIIIlIllIIlIIIIll < 19; ++llllllllllllllllIIIlIllIIlIIIIll) {
            final ScoreObjective llllllllllllllllIIIlIllIIlIIIIlI = llllllllllllllllIIIlIllIIlIIIIII.getObjectiveInDisplaySlot(llllllllllllllllIIIlIllIIlIIIIll);
            if (llllllllllllllllIIIlIllIIlIIIIlI != null && !llllllllllllllllIIIlIllIIlIIIlIl.contains(llllllllllllllllIIIlIllIIlIIIIlI)) {
                for (final Packet<?> llllllllllllllllIIIlIllIIlIIIIIl : llllllllllllllllIIIlIllIIlIIIIII.getCreatePackets(llllllllllllllllIIIlIllIIlIIIIlI)) {
                    llllllllllllllllIIIlIllIIlIIIllI.connection.sendPacket(llllllllllllllllIIIlIllIIlIIIIIl);
                }
                llllllllllllllllIIIlIllIIlIIIlIl.add(llllllllllllllllIIIlIllIIlIIIIlI);
            }
        }
    }
    
    public void setPlayerManager(final WorldServer[] llllllllllllllllIIIlIllIIIllIllI) {
        this.playerNBTManagerObj = llllllllllllllllIIIlIllIIIllIllI[0].getSaveHandler().getPlayerNBTManager();
        llllllllllllllllIIIlIllIIIllIllI[0].getWorldBorder().addListener(new IBorderListener() {
            @Override
            public void onDamageBufferChanged(final WorldBorder llllllllllllllllIIIIIIIllllIlllI, final double llllllllllllllllIIIIIIIllllIllIl) {
            }
            
            @Override
            public void onDamageAmountChanged(final WorldBorder llllllllllllllllIIIIIIIlllllIIIl, final double llllllllllllllllIIIIIIIlllllIIII) {
            }
            
            @Override
            public void onSizeChanged(final WorldBorder llllllllllllllllIIIIIIlIIIIlIIlI, final double llllllllllllllllIIIIIIlIIIIlIlII) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(llllllllllllllllIIIIIIlIIIIlIIlI, SPacketWorldBorder.Action.SET_SIZE));
            }
            
            @Override
            public void onWarningDistanceChanged(final WorldBorder llllllllllllllllIIIIIIIlllllIIll, final int llllllllllllllllIIIIIIIlllllIlIl) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(llllllllllllllllIIIIIIIlllllIIll, SPacketWorldBorder.Action.SET_WARNING_BLOCKS));
            }
            
            @Override
            public void onWarningTimeChanged(final WorldBorder llllllllllllllllIIIIIIIllllllIlI, final int llllllllllllllllIIIIIIIlllllllII) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(llllllllllllllllIIIIIIIllllllIlI, SPacketWorldBorder.Action.SET_WARNING_TIME));
            }
            
            @Override
            public void onCenterChanged(final WorldBorder llllllllllllllllIIIIIIlIIIIIIlIl, final double llllllllllllllllIIIIIIlIIIIIIlII, final double llllllllllllllllIIIIIIlIIIIIIIll) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(llllllllllllllllIIIIIIlIIIIIIlIl, SPacketWorldBorder.Action.SET_CENTER));
            }
            
            @Override
            public void onTransitionStarted(final WorldBorder llllllllllllllllIIIIIIlIIIIIlllI, final double llllllllllllllllIIIIIIlIIIIIllIl, final double llllllllllllllllIIIIIIlIIIIIllII, final long llllllllllllllllIIIIIIlIIIIIlIll) {
                PlayerList.this.sendPacketToAllPlayers(new SPacketWorldBorder(llllllllllllllllIIIIIIlIIIIIlllI, SPacketWorldBorder.Action.LERP_SIZE));
            }
        });
    }
    
    public int getMaxPlayers() {
        return this.maxPlayers;
    }
    
    public UserListWhitelist getWhitelistedPlayers() {
        return this.whiteListedPlayers;
    }
    
    public void removePlayerFromWhitelist(final GameProfile llllllllllllllllIIIlIlIIlIIIlllI) {
        ((UserList<GameProfile, V>)this.whiteListedPlayers).removeEntry(llllllllllllllllIIIlIlIIlIIIlllI);
    }
    
    public EntityPlayerMP getPlayerByUUID(final UUID llllllllllllllllIIIlIIllllIllIll) {
        return this.uuidToPlayerMap.get(llllllllllllllllIIIlIIllllIllIll);
    }
    
    private void setPlayerGameTypeBasedOnOther(final EntityPlayerMP llllllllllllllllIIIlIlIIIIlllllI, final EntityPlayerMP llllllllllllllllIIIlIlIIIIllllIl, final World llllllllllllllllIIIlIlIIIIllllII) {
        if (llllllllllllllllIIIlIlIIIIllllIl != null) {
            llllllllllllllllIIIlIlIIIIlllllI.interactionManager.setGameType(llllllllllllllllIIIlIlIIIIllllIl.interactionManager.getGameType());
        }
        else if (this.gameType != null) {
            llllllllllllllllIIIlIlIIIIlllllI.interactionManager.setGameType(this.gameType);
        }
        llllllllllllllllIIIlIlIIIIlllllI.interactionManager.initializeGameType(llllllllllllllllIIIlIlIIIIllllII.getWorldInfo().getGameType());
    }
    
    public void updatePermissionLevel(final EntityPlayerMP llllllllllllllllIIIlIlIllIIlIlll) {
        final GameProfile llllllllllllllllIIIlIlIllIIllIlI = llllllllllllllllIIIlIlIllIIlIlll.getGameProfile();
        int llllllllllllllllIIIlIlIllIIllIIl = this.canSendCommands(llllllllllllllllIIIlIlIllIIllIlI) ? this.ops.getPermissionLevel(llllllllllllllllIIIlIlIllIIllIlI) : 0;
        llllllllllllllllIIIlIlIllIIllIIl = ((this.mcServer.isSinglePlayer() && this.mcServer.worldServers[0].getWorldInfo().areCommandsAllowed()) ? 4 : llllllllllllllllIIIlIlIllIIllIIl);
        llllllllllllllllIIIlIlIllIIllIIl = (this.commandsAllowedForAll ? 4 : llllllllllllllllIIIlIlIllIIllIIl);
        this.sendPlayerPermissionLevel(llllllllllllllllIIIlIlIllIIlIlll, llllllllllllllllIIIlIlIllIIllIIl);
    }
    
    public void onTick() {
        if (++this.playerPingIndex > 600) {
            this.sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.UPDATE_LATENCY, this.playerEntityList));
            this.playerPingIndex = 0;
        }
    }
    
    public void sendPacketToAllPlayers(final Packet<?> llllllllllllllllIIIlIlIlIlIllIIl) {
        for (int llllllllllllllllIIIlIlIlIlIllIII = 0; llllllllllllllllIIIlIlIlIlIllIII < this.playerEntityList.size(); ++llllllllllllllllIIIlIlIlIlIllIII) {
            this.playerEntityList.get(llllllllllllllllIIIlIlIlIlIllIII).connection.sendPacket(llllllllllllllllIIIlIlIlIlIllIIl);
        }
    }
    
    public void func_193244_w() {
        for (final PlayerAdvancements llllllllllllllllIIIlIIllllIlIlII : this.field_192055_p.values()) {
            llllllllllllllllIIIlIIllllIlIlII.func_193766_b();
        }
    }
    
    public MinecraftServer getServerInstance() {
        return this.mcServer;
    }
    
    public int getViewDistance() {
        return this.viewDistance;
    }
    
    public void removeAllPlayers() {
        for (int llllllllllllllllIIIlIlIIIIlIlllI = 0; llllllllllllllllIIIlIlIIIIlIlllI < this.playerEntityList.size(); ++llllllllllllllllIIIlIlIIIIlIlllI) {
            this.playerEntityList.get(llllllllllllllllIIIlIlIIIIlIlllI).connection.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.server_shutdown", new Object[0]));
        }
    }
    
    @Nullable
    public NBTTagCompound readPlayerDataFromFile(final EntityPlayerMP llllllllllllllllIIIlIllIIIIlllII) {
        final NBTTagCompound llllllllllllllllIIIlIllIIIlIIIII = this.mcServer.worldServers[0].getWorldInfo().getPlayerNBTTagCompound();
        NBTTagCompound llllllllllllllllIIIlIllIIIIllllI = null;
        if (llllllllllllllllIIIlIllIIIIlllII.getName().equals(this.mcServer.getServerOwner()) && llllllllllllllllIIIlIllIIIlIIIII != null) {
            final NBTTagCompound llllllllllllllllIIIlIllIIIIlllll = llllllllllllllllIIIlIllIIIlIIIII;
            llllllllllllllllIIIlIllIIIIlllII.readFromNBT(llllllllllllllllIIIlIllIIIlIIIII);
            PlayerList.LOG.debug("loading single player");
        }
        else {
            llllllllllllllllIIIlIllIIIIllllI = this.playerNBTManagerObj.readPlayerData(llllllllllllllllIIIlIllIIIIlllII);
        }
        return llllllllllllllllIIIlIllIIIIllllI;
    }
    
    public void preparePlayer(final EntityPlayerMP llllllllllllllllIIIlIllIIIlIllll, @Nullable final WorldServer llllllllllllllllIIIlIllIIIlIlllI) {
        final WorldServer llllllllllllllllIIIlIllIIIlIllIl = llllllllllllllllIIIlIllIIIlIllll.getServerWorld();
        if (llllllllllllllllIIIlIllIIIlIlllI != null) {
            llllllllllllllllIIIlIllIIIlIlllI.getPlayerChunkMap().removePlayer(llllllllllllllllIIIlIllIIIlIllll);
        }
        llllllllllllllllIIIlIllIIIlIllIl.getPlayerChunkMap().addPlayer(llllllllllllllllIIIlIllIIIlIllll);
        llllllllllllllllIIIlIllIIIlIllIl.getChunkProvider().provideChunk((int)llllllllllllllllIIIlIllIIIlIllll.posX >> 4, (int)llllllllllllllllIIIlIllIIIlIllll.posZ >> 4);
        if (llllllllllllllllIIIlIllIIIlIlllI != null) {
            CriteriaTriggers.field_193134_u.func_193143_a(llllllllllllllllIIIlIllIIIlIllll, llllllllllllllllIIIlIllIIIlIlllI.provider.getDimensionType(), llllllllllllllllIIIlIllIIIlIllIl.provider.getDimensionType());
            if (llllllllllllllllIIIlIllIIIlIlllI.provider.getDimensionType() == DimensionType.NETHER && llllllllllllllllIIIlIllIIIlIllll.world.provider.getDimensionType() == DimensionType.OVERWORLD && llllllllllllllllIIIlIllIIIlIllll.func_193106_Q() != null) {
                CriteriaTriggers.field_193131_B.func_193168_a(llllllllllllllllIIIlIllIIIlIllll, llllllllllllllllIIIlIllIIIlIllll.func_193106_Q());
            }
        }
    }
    
    public void updateTimeAndWeatherForPlayer(final EntityPlayerMP llllllllllllllllIIIlIlIIIllllIlI, final WorldServer llllllllllllllllIIIlIlIIIllllIIl) {
        final WorldBorder llllllllllllllllIIIlIlIIIllllIII = this.mcServer.worldServers[0].getWorldBorder();
        llllllllllllllllIIIlIlIIIllllIlI.connection.sendPacket(new SPacketWorldBorder(llllllllllllllllIIIlIlIIIllllIII, SPacketWorldBorder.Action.INITIALIZE));
        llllllllllllllllIIIlIlIIIllllIlI.connection.sendPacket(new SPacketTimeUpdate(llllllllllllllllIIIlIlIIIllllIIl.getTotalWorldTime(), llllllllllllllllIIIlIlIIIllllIIl.getWorldTime(), llllllllllllllllIIIlIlIIIllllIIl.getGameRules().getBoolean("doDaylightCycle")));
        final BlockPos llllllllllllllllIIIlIlIIIlllIlll = llllllllllllllllIIIlIlIIIllllIIl.getSpawnPoint();
        llllllllllllllllIIIlIlIIIllllIlI.connection.sendPacket(new SPacketSpawnPosition(llllllllllllllllIIIlIlIIIlllIlll));
        if (llllllllllllllllIIIlIlIIIllllIIl.isRaining()) {
            llllllllllllllllIIIlIlIIIllllIlI.connection.sendPacket(new SPacketChangeGameState(1, 0.0f));
            llllllllllllllllIIIlIlIIIllllIlI.connection.sendPacket(new SPacketChangeGameState(7, llllllllllllllllIIIlIlIIIllllIIl.getRainStrength(1.0f)));
            llllllllllllllllIIIlIlIIIllllIlI.connection.sendPacket(new SPacketChangeGameState(8, llllllllllllllllIIIlIlIIIllllIIl.getThunderStrength(1.0f)));
        }
    }
    
    public List<EntityPlayerMP> getPlayerList() {
        return this.playerEntityList;
    }
    
    public UserListOps getOppedPlayers() {
        return this.ops;
    }
    
    public void transferEntityToWorld(final Entity llllllllllllllllIIIlIlIlIllIlIIl, final int llllllllllllllllIIIlIlIlIllIlIII, final WorldServer llllllllllllllllIIIlIlIlIlllIIIl, final WorldServer llllllllllllllllIIIlIlIlIlllIIII) {
        double llllllllllllllllIIIlIlIlIllIllll = llllllllllllllllIIIlIlIlIllIlIIl.posX;
        double llllllllllllllllIIIlIlIlIllIlllI = llllllllllllllllIIIlIlIlIllIlIIl.posZ;
        final double llllllllllllllllIIIlIlIlIllIllIl = 8.0;
        final float llllllllllllllllIIIlIlIlIllIllII = llllllllllllllllIIIlIlIlIllIlIIl.rotationYaw;
        llllllllllllllllIIIlIlIlIlllIIIl.theProfiler.startSection("moving");
        if (llllllllllllllllIIIlIlIlIllIlIIl.dimension == -1) {
            llllllllllllllllIIIlIlIlIllIllll = MathHelper.clamp(llllllllllllllllIIIlIlIlIllIllll / 8.0, llllllllllllllllIIIlIlIlIlllIIII.getWorldBorder().minX() + 16.0, llllllllllllllllIIIlIlIlIlllIIII.getWorldBorder().maxX() - 16.0);
            llllllllllllllllIIIlIlIlIllIlllI = MathHelper.clamp(llllllllllllllllIIIlIlIlIllIlllI / 8.0, llllllllllllllllIIIlIlIlIlllIIII.getWorldBorder().minZ() + 16.0, llllllllllllllllIIIlIlIlIlllIIII.getWorldBorder().maxZ() - 16.0);
            llllllllllllllllIIIlIlIlIllIlIIl.setLocationAndAngles(llllllllllllllllIIIlIlIlIllIllll, llllllllllllllllIIIlIlIlIllIlIIl.posY, llllllllllllllllIIIlIlIlIllIlllI, llllllllllllllllIIIlIlIlIllIlIIl.rotationYaw, llllllllllllllllIIIlIlIlIllIlIIl.rotationPitch);
            if (llllllllllllllllIIIlIlIlIllIlIIl.isEntityAlive()) {
                llllllllllllllllIIIlIlIlIlllIIIl.updateEntityWithOptionalForce(llllllllllllllllIIIlIlIlIllIlIIl, false);
            }
        }
        else if (llllllllllllllllIIIlIlIlIllIlIIl.dimension == 0) {
            llllllllllllllllIIIlIlIlIllIllll = MathHelper.clamp(llllllllllllllllIIIlIlIlIllIllll * 8.0, llllllllllllllllIIIlIlIlIlllIIII.getWorldBorder().minX() + 16.0, llllllllllllllllIIIlIlIlIlllIIII.getWorldBorder().maxX() - 16.0);
            llllllllllllllllIIIlIlIlIllIlllI = MathHelper.clamp(llllllllllllllllIIIlIlIlIllIlllI * 8.0, llllllllllllllllIIIlIlIlIlllIIII.getWorldBorder().minZ() + 16.0, llllllllllllllllIIIlIlIlIlllIIII.getWorldBorder().maxZ() - 16.0);
            llllllllllllllllIIIlIlIlIllIlIIl.setLocationAndAngles(llllllllllllllllIIIlIlIlIllIllll, llllllllllllllllIIIlIlIlIllIlIIl.posY, llllllllllllllllIIIlIlIlIllIlllI, llllllllllllllllIIIlIlIlIllIlIIl.rotationYaw, llllllllllllllllIIIlIlIlIllIlIIl.rotationPitch);
            if (llllllllllllllllIIIlIlIlIllIlIIl.isEntityAlive()) {
                llllllllllllllllIIIlIlIlIlllIIIl.updateEntityWithOptionalForce(llllllllllllllllIIIlIlIlIllIlIIl, false);
            }
        }
        else {
            BlockPos llllllllllllllllIIIlIlIlIllIlIlI = null;
            if (llllllllllllllllIIIlIlIlIllIlIII == 1) {
                final BlockPos llllllllllllllllIIIlIlIlIllIlIll = llllllllllllllllIIIlIlIlIlllIIII.getSpawnPoint();
            }
            else {
                llllllllllllllllIIIlIlIlIllIlIlI = llllllllllllllllIIIlIlIlIlllIIII.getSpawnCoordinate();
            }
            llllllllllllllllIIIlIlIlIllIllll = llllllllllllllllIIIlIlIlIllIlIlI.getX();
            llllllllllllllllIIIlIlIlIllIlIIl.posY = llllllllllllllllIIIlIlIlIllIlIlI.getY();
            llllllllllllllllIIIlIlIlIllIlllI = llllllllllllllllIIIlIlIlIllIlIlI.getZ();
            llllllllllllllllIIIlIlIlIllIlIIl.setLocationAndAngles(llllllllllllllllIIIlIlIlIllIllll, llllllllllllllllIIIlIlIlIllIlIIl.posY, llllllllllllllllIIIlIlIlIllIlllI, 90.0f, 0.0f);
            if (llllllllllllllllIIIlIlIlIllIlIIl.isEntityAlive()) {
                llllllllllllllllIIIlIlIlIlllIIIl.updateEntityWithOptionalForce(llllllllllllllllIIIlIlIlIllIlIIl, false);
            }
        }
        llllllllllllllllIIIlIlIlIlllIIIl.theProfiler.endSection();
        if (llllllllllllllllIIIlIlIlIllIlIII != 1) {
            llllllllllllllllIIIlIlIlIlllIIIl.theProfiler.startSection("placing");
            llllllllllllllllIIIlIlIlIllIllll = MathHelper.clamp((int)llllllllllllllllIIIlIlIlIllIllll, -29999872, 29999872);
            llllllllllllllllIIIlIlIlIllIlllI = MathHelper.clamp((int)llllllllllllllllIIIlIlIlIllIlllI, -29999872, 29999872);
            if (llllllllllllllllIIIlIlIlIllIlIIl.isEntityAlive()) {
                llllllllllllllllIIIlIlIlIllIlIIl.setLocationAndAngles(llllllllllllllllIIIlIlIlIllIllll, llllllllllllllllIIIlIlIlIllIlIIl.posY, llllllllllllllllIIIlIlIlIllIlllI, llllllllllllllllIIIlIlIlIllIlIIl.rotationYaw, llllllllllllllllIIIlIlIlIllIlIIl.rotationPitch);
                llllllllllllllllIIIlIlIlIlllIIII.getDefaultTeleporter().placeInPortal(llllllllllllllllIIIlIlIlIllIlIIl, llllllllllllllllIIIlIlIlIllIllII);
                llllllllllllllllIIIlIlIlIlllIIII.spawnEntityInWorld(llllllllllllllllIIIlIlIlIllIlIIl);
                llllllllllllllllIIIlIlIlIlllIIII.updateEntityWithOptionalForce(llllllllllllllllIIIlIlIlIllIlIIl, false);
            }
            llllllllllllllllIIIlIlIlIlllIIIl.theProfiler.endSection();
        }
        llllllllllllllllIIIlIlIlIllIlIIl.setWorld(llllllllllllllllIIIlIlIlIlllIIII);
    }
    
    public NBTTagCompound getHostPlayerData() {
        return null;
    }
    
    public void saveAllPlayerData() {
        for (int llllllllllllllllIIIlIlIIlIIlllII = 0; llllllllllllllllIIIlIlIIlIIlllII < this.playerEntityList.size(); ++llllllllllllllllIIIlIlIIlIIlllII) {
            this.writePlayerData(this.playerEntityList.get(llllllllllllllllIIIlIlIIlIIlllII));
        }
    }
    
    static {
        FILE_PLAYERBANS = new File("banned-players.json");
        FILE_IPBANS = new File("banned-ips.json");
        FILE_OPS = new File("ops.json");
        FILE_WHITELIST = new File("whitelist.json");
        LOG = LogManager.getLogger();
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    }
    
    public void removeOp(final GameProfile llllllllllllllllIIIlIlIIlllIllII) {
        ((UserList<GameProfile, V>)this.ops).removeEntry(llllllllllllllllIIIlIlIIlllIllII);
        this.sendPlayerPermissionLevel(this.getPlayerByUUID(llllllllllllllllIIIlIlIIlllIllII.getId()), 0);
    }
    
    public void sendPacketToAllPlayersInDimension(final Packet<?> llllllllllllllllIIIlIlIlIlIIlllI, final int llllllllllllllllIIIlIlIlIlIIlIII) {
        for (int llllllllllllllllIIIlIlIlIlIIllII = 0; llllllllllllllllIIIlIlIlIlIIllII < this.playerEntityList.size(); ++llllllllllllllllIIIlIlIlIlIIllII) {
            final EntityPlayerMP llllllllllllllllIIIlIlIlIlIIlIll = this.playerEntityList.get(llllllllllllllllIIIlIlIlIlIIllII);
            if (llllllllllllllllIIIlIlIlIlIIlIll.dimension == llllllllllllllllIIIlIlIlIlIIlIII) {
                llllllllllllllllIIIlIlIlIlIIlIll.connection.sendPacket(llllllllllllllllIIIlIlIlIlIIlllI);
            }
        }
    }
    
    public StatisticsManagerServer getPlayerStatsFile(final EntityPlayer llllllllllllllllIIIlIlIIIIIIlIlI) {
        final UUID llllllllllllllllIIIlIlIIIIIlIIII = llllllllllllllllIIIlIlIIIIIIlIlI.getUniqueID();
        StatisticsManagerServer llllllllllllllllIIIlIlIIIIIIllll = (llllllllllllllllIIIlIlIIIIIlIIII == null) ? null : this.playerStatFiles.get(llllllllllllllllIIIlIlIIIIIlIIII);
        if (llllllllllllllllIIIlIlIIIIIIllll == null) {
            final File llllllllllllllllIIIlIlIIIIIIlllI = new File(this.mcServer.worldServerForDimension(0).getSaveHandler().getWorldDirectory(), "stats");
            final File llllllllllllllllIIIlIlIIIIIIllIl = new File(llllllllllllllllIIIlIlIIIIIIlllI, llllllllllllllllIIIlIlIIIIIlIIII + ".json");
            if (!llllllllllllllllIIIlIlIIIIIIllIl.exists()) {
                final File llllllllllllllllIIIlIlIIIIIIllII = new File(llllllllllllllllIIIlIlIIIIIIlllI, String.valueOf(llllllllllllllllIIIlIlIIIIIIlIlI.getName()) + ".json");
                if (llllllllllllllllIIIlIlIIIIIIllII.exists() && llllllllllllllllIIIlIlIIIIIIllII.isFile()) {
                    llllllllllllllllIIIlIlIIIIIIllII.renameTo(llllllllllllllllIIIlIlIIIIIIllIl);
                }
            }
            llllllllllllllllIIIlIlIIIIIIllll = new StatisticsManagerServer(this.mcServer, llllllllllllllllIIIlIlIIIIIIllIl);
            llllllllllllllllIIIlIlIIIIIIllll.readStatFile();
            this.playerStatFiles.put(llllllllllllllllIIIlIlIIIIIlIIII, llllllllllllllllIIIlIlIIIIIIllll);
        }
        return llllllllllllllllIIIlIlIIIIIIllll;
    }
    
    public UserListIPBans getBannedIPs() {
        return this.bannedIPs;
    }
    
    public PlayerAdvancements func_192054_h(final EntityPlayerMP llllllllllllllllIIIlIIllllllIlll) {
        final UUID llllllllllllllllIIIlIIllllllllII = llllllllllllllllIIIlIIllllllIlll.getUniqueID();
        PlayerAdvancements llllllllllllllllIIIlIIlllllllIll = this.field_192055_p.get(llllllllllllllllIIIlIIllllllllII);
        if (llllllllllllllllIIIlIIlllllllIll == null) {
            final File llllllllllllllllIIIlIIlllllllIlI = new File(this.mcServer.worldServerForDimension(0).getSaveHandler().getWorldDirectory(), "advancements");
            final File llllllllllllllllIIIlIIlllllllIIl = new File(llllllllllllllllIIIlIIlllllllIlI, llllllllllllllllIIIlIIllllllllII + ".json");
            llllllllllllllllIIIlIIlllllllIll = new PlayerAdvancements(this.mcServer, llllllllllllllllIIIlIIlllllllIIl, llllllllllllllllIIIlIIllllllIlll);
            this.field_192055_p.put(llllllllllllllllIIIlIIllllllllII, llllllllllllllllIIIlIIlllllllIll);
        }
        llllllllllllllllIIIlIIlllllllIll.func_192739_a(llllllllllllllllIIIlIIllllllIlll);
        return llllllllllllllllIIIlIIlllllllIll;
    }
    
    public void playerLoggedIn(final EntityPlayerMP llllllllllllllllIIIlIllIIIIIIlII) {
        this.playerEntityList.add(llllllllllllllllIIIlIllIIIIIIlII);
        this.uuidToPlayerMap.put(llllllllllllllllIIIlIllIIIIIIlII.getUniqueID(), llllllllllllllllIIIlIllIIIIIIlII);
        this.sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[] { llllllllllllllllIIIlIllIIIIIIlII }));
        final WorldServer llllllllllllllllIIIlIllIIIIIIlll = this.mcServer.worldServerForDimension(llllllllllllllllIIIlIllIIIIIIlII.dimension);
        for (int llllllllllllllllIIIlIllIIIIIIllI = 0; llllllllllllllllIIIlIllIIIIIIllI < this.playerEntityList.size(); ++llllllllllllllllIIIlIllIIIIIIllI) {
            llllllllllllllllIIIlIllIIIIIIlII.connection.sendPacket(new SPacketPlayerListItem(SPacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[] { this.playerEntityList.get(llllllllllllllllIIIlIllIIIIIIllI) }));
        }
        llllllllllllllllIIIlIllIIIIIIlll.spawnEntityInWorld(llllllllllllllllIIIlIllIIIIIIlII);
        this.preparePlayer(llllllllllllllllIIIlIllIIIIIIlII, null);
    }
    
    public String[] getOppedPlayerNames() {
        return this.ops.getKeys();
    }
    
    public boolean bypassesPlayerLimit(final GameProfile llllllllllllllllIIIlIIllllIllIIl) {
        return false;
    }
    
    public void serverUpdateMovingPlayer(final EntityPlayerMP llllllllllllllllIIIlIlIlllllllll) {
        llllllllllllllllIIIlIlIlllllllll.getServerWorld().getPlayerChunkMap().updateMovingPlayer(llllllllllllllllIIIlIlIlllllllll);
    }
    
    public void addWhitelistedPlayer(final GameProfile llllllllllllllllIIIlIlIIlIIlIllI) {
        ((UserList<K, UserListWhitelistEntry>)this.whiteListedPlayers).addEntry(new UserListWhitelistEntry(llllllllllllllllIIIlIlIIlIIlIllI));
    }
}
