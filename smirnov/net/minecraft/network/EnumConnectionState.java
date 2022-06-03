// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import net.minecraft.network.login.client.CPacketEncryptionResponse;
import net.minecraft.network.login.client.CPacketLoginStart;
import net.minecraft.network.login.server.SPacketEnableCompression;
import net.minecraft.network.login.server.SPacketLoginSuccess;
import net.minecraft.network.login.server.SPacketEncryptionRequest;
import net.minecraft.network.status.server.SPacketPong;
import net.minecraft.network.status.client.CPacketPing;
import net.minecraft.network.status.server.SPacketServerInfo;
import net.minecraft.network.status.client.CPacketServerQuery;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketSpectate;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketUpdateSign;
import net.minecraft.network.play.client.CPacketCreativeInventoryAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketSeenAdvancements;
import net.minecraft.network.play.client.CPacketResourcePackStatus;
import net.minecraft.network.play.client.CPacketRecipeInfo;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerAbilities;
import net.minecraft.network.play.client.CPacketPlaceRecipe;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketEnchantItem;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketClientSettings;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketTabComplete;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.server.SPacketEntityEffect;
import net.minecraft.network.play.server.SPacketEntityProperties;
import net.minecraft.network.play.server.SPacketAdvancementInfo;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.network.play.server.SPacketCollectItem;
import net.minecraft.network.play.server.SPacketPlayerListHeaderFooter;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.network.play.server.SPacketSpawnPosition;
import net.minecraft.network.play.server.SPacketUpdateScore;
import net.minecraft.network.play.server.SPacketTeams;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.network.play.server.SPacketScoreboardObjective;
import net.minecraft.network.play.server.SPacketUpdateHealth;
import net.minecraft.network.play.server.SPacketSetExperience;
import net.minecraft.network.play.server.SPacketEntityEquipment;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketEntityAttach;
import net.minecraft.network.play.server.SPacketEntityMetadata;
import net.minecraft.network.play.server.SPacketDisplayObjective;
import net.minecraft.network.play.server.SPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketCamera;
import net.minecraft.network.play.server.SPacketWorldBorder;
import net.minecraft.network.play.server.SPacketSelectAdvancementsTab;
import net.minecraft.network.play.server.SPacketEntityHeadLook;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.network.play.server.SPacketResourcePackSend;
import net.minecraft.network.play.server.SPacketRemoveEntityEffect;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketRecipeBook;
import net.minecraft.network.play.server.SPacketUseBed;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.network.play.server.SPacketCombatEvent;
import net.minecraft.network.play.server.SPacketPlayerAbilities;
import net.minecraft.network.play.server.SPacketPlaceGhostRecipe;
import net.minecraft.network.play.server.SPacketSignEditorOpen;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.network.play.server.SPacketEntity;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.network.play.server.SPacketJoinGame;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraft.network.play.server.SPacketEffect;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.network.play.server.SPacketKeepAlive;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.network.play.server.SPacketUnloadChunk;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketCustomSound;
import net.minecraft.network.play.server.SPacketCustomPayload;
import net.minecraft.network.play.server.SPacketCooldown;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.network.play.server.SPacketWindowProperty;
import net.minecraft.network.play.server.SPacketWindowItems;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.network.play.server.SPacketCloseWindow;
import net.minecraft.network.play.server.SPacketConfirmTransaction;
import net.minecraft.network.play.server.SPacketMultiBlockChange;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.network.play.server.SPacketTabComplete;
import net.minecraft.network.play.server.SPacketServerDifficulty;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketBlockAction;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.network.play.server.SPacketStatistics;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraft.network.play.server.SPacketSpawnPainting;
import net.minecraft.network.play.server.SPacketSpawnMob;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.SPacketSpawnExperienceOrb;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.network.handshake.client.C00Handshake;
import com.google.common.collect.BiMap;
import java.util.Map;

public enum EnumConnectionState
{
    private static final /* synthetic */ Map<Class<? extends Packet<?>>, EnumConnectionState> STATES_BY_CLASS;
    
    STATUS(2, 1) {
        {
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketServerQuery.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketServerInfo.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPing.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPong.class);
        }
    }, 
    LOGIN(3, 2) {
        {
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, net.minecraft.network.login.server.SPacketDisconnect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEncryptionRequest.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketLoginSuccess.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEnableCompression.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketLoginStart.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketEncryptionResponse.class);
        }
    }, 
    PLAY(1, 0) {
        {
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnObject.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnExperienceOrb.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnGlobalEntity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnMob.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnPainting.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnPlayer.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketAnimation.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketStatistics.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketBlockBreakAnim.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUpdateTileEntity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketBlockAction.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketBlockChange.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUpdateBossInfo.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketServerDifficulty.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketTabComplete.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketChat.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketMultiBlockChange.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketConfirmTransaction.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCloseWindow.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketOpenWindow.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketWindowItems.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketWindowProperty.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSetSlot.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCooldown.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCustomPayload.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCustomSound.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketDisconnect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityStatus.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketExplosion.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUnloadChunk.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketChangeGameState.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketKeepAlive.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketChunkData.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketParticles.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketJoinGame.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketMaps.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntity.S15PacketEntityRelMove.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntity.S17PacketEntityLookMove.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntity.S16PacketEntityLook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketMoveVehicle.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSignEditorOpen.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlaceGhostRecipe.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlayerAbilities.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCombatEvent.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlayerListItem.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlayerPosLook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUseBed.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketRecipeBook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketDestroyEntities.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketRemoveEntityEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketResourcePackSend.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketRespawn.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityHeadLook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSelectAdvancementsTab.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketWorldBorder.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCamera.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketHeldItemChange.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketDisplayObjective.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityMetadata.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityAttach.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityVelocity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityEquipment.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSetExperience.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUpdateHealth.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketScoreboardObjective.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSetPassengers.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketTeams.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUpdateScore.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnPosition.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketTimeUpdate.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketTitle.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSoundEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlayerListHeaderFooter.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCollectItem.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityTeleport.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketAdvancementInfo.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityProperties.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityEffect.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketConfirmTeleport.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketTabComplete.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketChatMessage.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketClientStatus.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketClientSettings.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketConfirmTransaction.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketEnchantItem.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketClickWindow.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketCloseWindow.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketCustomPayload.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketUseEntity.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketKeepAlive.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayer.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayer.Position.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayer.PositionRotation.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayer.Rotation.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketVehicleMove.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketSteerBoat.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlaceRecipe.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayerAbilities.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayerDigging.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketEntityAction.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketInput.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketRecipeInfo.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketResourcePackStatus.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketSeenAdvancements.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketHeldItemChange.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketCreativeInventoryAction.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketUpdateSign.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketAnimation.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketSpectate.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayerTryUseItemOnBlock.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayerTryUseItem.class);
        }
    };
    
    private final /* synthetic */ Map<EnumPacketDirection, BiMap<Integer, Class<? extends Packet<?>>>> directionMaps;
    private static final /* synthetic */ EnumConnectionState[] STATES_BY_ID;
    
    HANDSHAKING(0, -1) {
        {
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C00Handshake.class);
        }
    };
    
    private final /* synthetic */ int id;
    
    public static EnumConnectionState getFromPacket(final Packet<?> lllllllllllllIIIlIlIIIlIIlIlIIII) {
        return EnumConnectionState.STATES_BY_CLASS.get(lllllllllllllIIIlIlIIIlIIlIlIIII.getClass());
    }
    
    static {
        STATES_BY_ID = new EnumConnectionState[4];
        STATES_BY_CLASS = Maps.newHashMap();
        char lllllllllllllIIIlIlIIIlIlIIIllIl;
        for (short lllllllllllllIIIlIlIIIlIlIIIlllI = (short)((EnumConnectionState[])(Object)(lllllllllllllIIIlIlIIIlIlIIIllIl = (char)(Object)values())).length, lllllllllllllIIIlIlIIIlIlIIIllll = 0; lllllllllllllIIIlIlIIIlIlIIIllll < lllllllllllllIIIlIlIIIlIlIIIlllI; ++lllllllllllllIIIlIlIIIlIlIIIllll) {
            final EnumConnectionState lllllllllllllIIIlIlIIIlIlIIlIlIl = lllllllllllllIIIlIlIIIlIlIIIllIl[lllllllllllllIIIlIlIIIlIlIIIllll];
            final int lllllllllllllIIIlIlIIIlIlIIlIlII = lllllllllllllIIIlIlIIIlIlIIlIlIl.getId();
            if (lllllllllllllIIIlIlIIIlIlIIlIlII < -1 || lllllllllllllIIIlIlIIIlIlIIlIlII > 2) {
                throw new Error("Invalid protocol ID " + Integer.toString(lllllllllllllIIIlIlIIIlIlIIlIlII));
            }
            EnumConnectionState.STATES_BY_ID[lllllllllllllIIIlIlIIIlIlIIlIlII + 1] = lllllllllllllIIIlIlIIIlIlIIlIlIl;
            for (final EnumPacketDirection lllllllllllllIIIlIlIIIlIlIIlIIll : lllllllllllllIIIlIlIIIlIlIIlIlIl.directionMaps.keySet()) {
                for (final Class<? extends Packet<?>> lllllllllllllIIIlIlIIIlIlIIlIIlI : lllllllllllllIIIlIlIIIlIlIIlIlIl.directionMaps.get(lllllllllllllIIIlIlIIIlIlIIlIIll).values()) {
                    if (EnumConnectionState.STATES_BY_CLASS.containsKey(lllllllllllllIIIlIlIIIlIlIIlIIlI) && EnumConnectionState.STATES_BY_CLASS.get(lllllllllllllIIIlIlIIIlIlIIlIIlI) != lllllllllllllIIIlIlIIIlIlIIlIlIl) {
                        throw new Error("Packet " + lllllllllllllIIIlIlIIIlIlIIlIIlI + " is already assigned to protocol " + EnumConnectionState.STATES_BY_CLASS.get(lllllllllllllIIIlIlIIIlIlIIlIIlI) + " - can't reassign to " + lllllllllllllIIIlIlIIIlIlIIlIlIl);
                    }
                    try {
                        lllllllllllllIIIlIlIIIlIlIIlIIlI.newInstance();
                    }
                    catch (Throwable lllllllllllllIIIlIlIIIlIlIIlIIIl) {
                        throw new Error("Packet " + lllllllllllllIIIlIlIIIlIlIIlIIlI + " fails instantiation checks! " + lllllllllllllIIIlIlIIIlIlIIlIIlI);
                    }
                    EnumConnectionState.STATES_BY_CLASS.put(lllllllllllllIIIlIlIIIlIlIIlIIlI, lllllllllllllIIIlIlIIIlIlIIlIlIl);
                }
            }
        }
    }
    
    public Integer getPacketId(final EnumPacketDirection lllllllllllllIIIlIlIIIlIIllIlIIl, final Packet<?> lllllllllllllIIIlIlIIIlIIllIIlIl) throws Exception {
        return (Integer)this.directionMaps.get(lllllllllllllIIIlIlIIIlIIllIlIIl).inverse().get((Object)lllllllllllllIIIlIlIIIlIIllIIlIl.getClass());
    }
    
    public static EnumConnectionState getById(final int lllllllllllllIIIlIlIIIlIIlIlIlII) {
        return (lllllllllllllIIIlIlIIIlIIlIlIlII >= -1 && lllllllllllllIIIlIlIIIlIIlIlIlII <= 2) ? EnumConnectionState.STATES_BY_ID[lllllllllllllIIIlIlIIIlIIlIlIlII + 1] : null;
    }
    
    public int getId() {
        return this.id;
    }
    
    protected EnumConnectionState registerPacket(final EnumPacketDirection lllllllllllllIIIlIlIIIlIIlllIllI, final Class<? extends Packet<?>> lllllllllllllIIIlIlIIIlIIlllIlIl) {
        BiMap<Integer, Class<? extends Packet<?>>> lllllllllllllIIIlIlIIIlIIlllIlII = this.directionMaps.get(lllllllllllllIIIlIlIIIlIIlllIllI);
        if (lllllllllllllIIIlIlIIIlIIlllIlII == null) {
            lllllllllllllIIIlIlIIIlIIlllIlII = (BiMap<Integer, Class<? extends Packet<?>>>)HashBiMap.create();
            this.directionMaps.put(lllllllllllllIIIlIlIIIlIIlllIllI, lllllllllllllIIIlIlIIIlIIlllIlII);
        }
        if (lllllllllllllIIIlIlIIIlIIlllIlII.containsValue((Object)lllllllllllllIIIlIlIIIlIIlllIlIl)) {
            final String lllllllllllllIIIlIlIIIlIIlllIIll = lllllllllllllIIIlIlIIIlIIlllIllI + " packet " + lllllllllllllIIIlIlIIIlIIlllIlIl + " is already known to ID " + lllllllllllllIIIlIlIIIlIIlllIlII.inverse().get((Object)lllllllllllllIIIlIlIIIlIIlllIlIl);
            LogManager.getLogger().fatal(lllllllllllllIIIlIlIIIlIIlllIIll);
            throw new IllegalArgumentException(lllllllllllllIIIlIlIIIlIIlllIIll);
        }
        lllllllllllllIIIlIlIIIlIIlllIlII.put((Object)lllllllllllllIIIlIlIIIlIIlllIlII.size(), (Object)lllllllllllllIIIlIlIIIlIIlllIlIl);
        return this;
    }
    
    @Nullable
    public Packet<?> getPacket(final EnumPacketDirection lllllllllllllIIIlIlIIIlIIlIlllll, final int lllllllllllllIIIlIlIIIlIIlIllllI) throws InstantiationException, IllegalAccessException {
        final Class<? extends Packet<?>> lllllllllllllIIIlIlIIIlIIlIlllIl = (Class<? extends Packet<?>>)this.directionMaps.get(lllllllllllllIIIlIlIIIlIIlIlllll).get((Object)lllllllllllllIIIlIlIIIlIIlIllllI);
        return (Packet<?>)((lllllllllllllIIIlIlIIIlIIlIlllIl == null) ? null : ((Packet)lllllllllllllIIIlIlIIIlIIlIlllIl.newInstance()));
    }
    
    private EnumConnectionState(final String lllllllllllllIIIlIlIIIlIIlllllll, final int lllllllllllllIIIlIlIIIlIIllllllI, final int lllllllllllllIIIlIlIIIlIlIIIIIIl) {
        this.directionMaps = (Map<EnumPacketDirection, BiMap<Integer, Class<? extends Packet<?>>>>)Maps.newEnumMap((Class)EnumPacketDirection.class);
        this.id = lllllllllllllIIIlIlIIIlIlIIIIIIl;
    }
}
