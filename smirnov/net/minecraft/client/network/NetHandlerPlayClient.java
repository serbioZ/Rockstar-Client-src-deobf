// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.network;

import java.util.Collection;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleItemPickup;
import net.minecraft.network.play.server.SPacketCollectItem;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.scoreboard.Score;
import net.minecraft.util.StringUtils;
import net.minecraft.network.play.server.SPacketUpdateScore;
import net.minecraft.network.play.server.SPacketEntityEquipment;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.play.server.SPacketHeldItemChange;
import ru.rockstar.client.features.Feature;
import ru.rockstar.Main;
import ru.rockstar.client.features.impl.visuals.NoRender;
import net.minecraft.client.audio.GuardianSound;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.client.player.inventory.ContainerLocalMenu;
import net.minecraft.world.IInteractionObject;
import net.minecraft.client.player.inventory.LocalBlockIntercommunication;
import net.minecraft.inventory.ContainerHorseChest;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.NpcMerchant;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.network.play.server.SPacketCombatEvent;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.network.play.server.SPacketTeams;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.entity.EntityLiving;
import net.minecraft.network.play.server.SPacketEntityAttach;
import javax.annotation.Nullable;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.Explosion;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketSetExperience;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraft.client.gui.recipebook.GuiRecipeBook;
import net.minecraft.network.play.server.SPacketPlaceGhostRecipe;
import net.minecraft.network.play.server.SPacketCloseWindow;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.ITabCompleter;
import java.util.Arrays;
import net.minecraft.network.play.server.SPacketTabComplete;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.multiplayer.ServerData;
import java.io.UnsupportedEncodingException;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Futures;
import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import net.minecraft.network.play.server.SPacketResourcePackSend;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityEvokerFangs;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityDragonFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.projectile.EntityLlamaSpit;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import com.google.common.util.concurrent.FutureCallback;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.network.play.server.SPacketUnloadChunk;
import net.minecraft.network.play.server.SPacketCamera;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.network.play.server.SPacketSignEditorOpen;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.network.play.server.SPacketEntityEffect;
import net.minecraft.network.play.server.SPacketPlayerAbilities;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.SPacketUseBed;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.network.play.server.SPacketScoreboardObjective;
import net.minecraft.network.play.server.SPacketCooldown;
import net.minecraft.network.play.server.SPacketBlockAction;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketWindowItems;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.network.play.server.SPacketSpawnPainting;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketPlayerListHeaderFooter;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.storage.MapData;
import net.minecraft.item.ItemMap;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.network.play.server.SPacketAdvancementInfo;
import net.minecraft.network.play.server.SPacketMultiBlockChange;
import net.minecraft.network.play.server.SPacketRemoveEntityEffect;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.network.play.server.SPacketEntityProperties;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.realms.DisconnectedRealmsScreen;
import net.minecraft.client.gui.GuiScreenRealmsProxy;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.ISound;
import net.minecraft.network.play.server.SPacketCustomSound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.IMerchant;
import net.minecraft.client.renderer.debug.DebugRendererNeighborsUpdate;
import net.minecraft.client.renderer.debug.DebugRendererPathfinding;
import net.minecraft.pathfinding.Path;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import java.io.IOException;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.network.play.server.SPacketCustomPayload;
import java.util.Iterator;
import net.minecraft.client.gui.recipebook.IRecipeShownListener;
import net.minecraft.client.util.RecipeBookClient;
import net.minecraft.client.gui.toasts.RecipeToast;
import java.util.function.Consumer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.stats.RecipeBook;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.network.play.server.SPacketUpdateHealth;
import net.minecraft.network.play.server.SPacketWindowProperty;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraft.network.play.server.SPacketWorldBorder;
import net.minecraft.network.play.server.SPacketEntityHeadLook;
import net.minecraft.network.play.server.SPacketEntityMetadata;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.inventory.Container;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.server.SPacketConfirmTransaction;
import net.minecraft.network.datasync.EntityDataManager;
import java.util.List;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.server.SPacketSpawnMob;
import net.minecraft.network.play.server.SPacketEffect;
import net.minecraft.network.play.server.SPacketRecipeBook;
import net.minecraft.client.gui.IProgressMeter;
import net.minecraft.stats.StatBase;
import net.minecraft.network.play.server.SPacketStatistics;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.Advancement;
import net.minecraft.network.play.server.SPacketSelectAdvancementsTab;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import net.minecraft.world.WorldSettings;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.network.play.server.SPacketJoinGame;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.network.play.server.SPacketSpawnExperienceOrb;
import net.minecraft.world.World;
import net.minecraft.network.play.server.SPacketEntity;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.network.play.server.SPacketDisplayObjective;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import com.google.common.collect.Maps;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.gui.GuiScreenDemo;
import net.minecraft.client.gui.GuiWinGame;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.world.GameType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.network.play.client.CPacketResourcePackStatus;
import java.net.URISyntaxException;
import java.net.URI;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.network.play.server.SPacketServerDifficulty;
import net.minecraft.network.play.server.SPacketSpawnPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTracker;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.server.SPacketKeepAlive;
import net.minecraft.util.IThreadListener;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.client.multiplayer.ClientAdvancementManager;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.NetworkManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.Minecraft;
import java.util.Random;
import java.util.UUID;
import java.util.Map;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.play.INetHandlerPlayClient;

public class NetHandlerPlayClient implements INetHandlerPlayClient
{
    public /* synthetic */ WorldClient clientWorldController;
    private final /* synthetic */ GameProfile profile;
    private final /* synthetic */ Map<UUID, NetworkPlayerInfo> playerInfoMap;
    private final /* synthetic */ Random avRandomizer;
    private /* synthetic */ boolean hasStatistics;
    public /* synthetic */ int currentServerMaxPlayers;
    private /* synthetic */ Minecraft gameController;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ NetworkManager netManager;
    private final /* synthetic */ GuiScreen guiScreenServer;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type;
    private final /* synthetic */ ClientAdvancementManager field_191983_k;
    private /* synthetic */ boolean doneLoadingTerrain;
    
    @Override
    public void handleTitle(final SPacketTitle lllllllllllllIlIIllIIIllIIIIlIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIIIIlIll, this, this.gameController);
        final SPacketTitle.Type lllllllllllllIlIIllIIIllIIIlIIII = lllllllllllllIlIIllIIIllIIIIlIll.getType();
        String lllllllllllllIlIIllIIIllIIIIllll = null;
        String lllllllllllllIlIIllIIIllIIIIlllI = null;
        final String lllllllllllllIlIIllIIIllIIIIllIl = (lllllllllllllIlIIllIIIllIIIIlIll.getMessage() != null) ? lllllllllllllIlIIllIIIllIIIIlIll.getMessage().getFormattedText() : "";
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type()[lllllllllllllIlIIllIIIllIIIlIIII.ordinal()]) {
            case 1: {
                lllllllllllllIlIIllIIIllIIIIllll = lllllllllllllIlIIllIIIllIIIIllIl;
                break;
            }
            case 2: {
                lllllllllllllIlIIllIIIllIIIIlllI = lllllllllllllIlIIllIIIllIIIIllIl;
                break;
            }
            case 3: {
                this.gameController.ingameGUI.setRecordPlaying(lllllllllllllIlIIllIIIllIIIIllIl, false);
                return;
            }
            case 6: {
                this.gameController.ingameGUI.displayTitle("", "", -1, -1, -1);
                this.gameController.ingameGUI.setDefaultTitlesTimes();
                return;
            }
        }
        this.gameController.ingameGUI.displayTitle(lllllllllllllIlIIllIIIllIIIIllll, lllllllllllllIlIIllIIIllIIIIlllI, lllllllllllllIlIIllIIIllIIIIlIll.getFadeInTime(), lllllllllllllIlIIllIIIllIIIIlIll.getDisplayTime(), lllllllllllllIlIIllIIIllIIIIlIll.getFadeOutTime());
    }
    
    @Override
    public void handleKeepAlive(final SPacketKeepAlive lllllllllllllIlIIllIIIlIlllIIlII) {
        this.sendPacket(new CPacketKeepAlive(lllllllllllllIlIIllIIIlIlllIIlII.getId()));
    }
    
    @Override
    public void handleEntityTeleport(final SPacketEntityTeleport lllllllllllllIlIIllIIlIlIlIlIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIlIlIlIllI, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIlIlIlllIl = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIlIlIlIllI.getEntityId());
        if (lllllllllllllIlIIllIIlIlIlIlllIl != null) {
            final double lllllllllllllIlIIllIIlIlIlIlllII = lllllllllllllIlIIllIIlIlIlIlIllI.getX();
            final double lllllllllllllIlIIllIIlIlIlIllIll = lllllllllllllIlIIllIIlIlIlIlIllI.getY();
            final double lllllllllllllIlIIllIIlIlIlIllIlI = lllllllllllllIlIIllIIlIlIlIlIllI.getZ();
            EntityTracker.updateServerPosition(lllllllllllllIlIIllIIlIlIlIlllIl, lllllllllllllIlIIllIIlIlIlIlllII, lllllllllllllIlIIllIIlIlIlIllIll, lllllllllllllIlIIllIIlIlIlIllIlI);
            if (!lllllllllllllIlIIllIIlIlIlIlllIl.canPassengerSteer()) {
                final float lllllllllllllIlIIllIIlIlIlIllIIl = lllllllllllllIlIIllIIlIlIlIlIllI.getYaw() * 360 / 256.0f;
                final float lllllllllllllIlIIllIIlIlIlIllIII = lllllllllllllIlIIllIIlIlIlIlIllI.getPitch() * 360 / 256.0f;
                if (Math.abs(lllllllllllllIlIIllIIlIlIlIlllIl.posX - lllllllllllllIlIIllIIlIlIlIlllII) < 0.03125 && Math.abs(lllllllllllllIlIIllIIlIlIlIlllIl.posY - lllllllllllllIlIIllIIlIlIlIllIll) < 0.015625 && Math.abs(lllllllllllllIlIIllIIlIlIlIlllIl.posZ - lllllllllllllIlIIllIIlIlIlIllIlI) < 0.03125) {
                    lllllllllllllIlIIllIIlIlIlIlllIl.setPositionAndRotationDirect(lllllllllllllIlIIllIIlIlIlIlllIl.posX, lllllllllllllIlIIllIIlIlIlIlllIl.posY, lllllllllllllIlIIllIIlIlIlIlllIl.posZ, lllllllllllllIlIIllIIlIlIlIllIIl, lllllllllllllIlIIllIIlIlIlIllIII, 0, true);
                }
                else {
                    lllllllllllllIlIIllIIlIlIlIlllIl.setPositionAndRotationDirect(lllllllllllllIlIIllIIlIlIlIlllII, lllllllllllllIlIIllIIlIlIlIllIll, lllllllllllllIlIIllIIlIlIlIllIlI, lllllllllllllIlIIllIIlIlIlIllIIl, lllllllllllllIlIIllIIlIlIlIllIII, 3, true);
                }
                lllllllllllllIlIIllIIlIlIlIlllIl.onGround = lllllllllllllIlIIllIIlIlIlIlIllI.getOnGround();
            }
        }
    }
    
    @Override
    public void handleSetSlot(final SPacketSetSlot lllllllllllllIlIIllIIIlllllllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlllllllllI, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIlIIIIIIIlIl = this.gameController.player;
        final ItemStack lllllllllllllIlIIllIIlIIIIIIIlII = lllllllllllllIlIIllIIIlllllllllI.getStack();
        final int lllllllllllllIlIIllIIlIIIIIIIIll = lllllllllllllIlIIllIIIlllllllllI.getSlot();
        this.gameController.func_193032_ao().func_193301_a(lllllllllllllIlIIllIIlIIIIIIIlII);
        if (lllllllllllllIlIIllIIIlllllllllI.getWindowId() == -1) {
            lllllllllllllIlIIllIIlIIIIIIIlIl.inventory.setItemStack(lllllllllllllIlIIllIIlIIIIIIIlII);
        }
        else if (lllllllllllllIlIIllIIIlllllllllI.getWindowId() == -2) {
            lllllllllllllIlIIllIIlIIIIIIIlIl.inventory.setInventorySlotContents(lllllllllllllIlIIllIIlIIIIIIIIll, lllllllllllllIlIIllIIlIIIIIIIlII);
        }
        else {
            boolean lllllllllllllIlIIllIIlIIIIIIIIlI = false;
            if (this.gameController.currentScreen instanceof GuiContainerCreative) {
                final GuiContainerCreative lllllllllllllIlIIllIIlIIIIIIIIIl = (GuiContainerCreative)this.gameController.currentScreen;
                lllllllllllllIlIIllIIlIIIIIIIIlI = (lllllllllllllIlIIllIIlIIIIIIIIIl.getSelectedTabIndex() != CreativeTabs.INVENTORY.getTabIndex());
            }
            if (lllllllllllllIlIIllIIIlllllllllI.getWindowId() == 0 && lllllllllllllIlIIllIIIlllllllllI.getSlot() >= 36 && lllllllllllllIlIIllIIlIIIIIIIIll < 45) {
                if (!lllllllllllllIlIIllIIlIIIIIIIlII.func_190926_b()) {
                    final ItemStack lllllllllllllIlIIllIIlIIIIIIIIII = lllllllllllllIlIIllIIlIIIIIIIlIl.inventoryContainer.getSlot(lllllllllllllIlIIllIIlIIIIIIIIll).getStack();
                    if (lllllllllllllIlIIllIIlIIIIIIIIII.func_190926_b() || lllllllllllllIlIIllIIlIIIIIIIIII.func_190916_E() < lllllllllllllIlIIllIIlIIIIIIIlII.func_190916_E()) {
                        lllllllllllllIlIIllIIlIIIIIIIlII.func_190915_d(5);
                    }
                }
                lllllllllllllIlIIllIIlIIIIIIIlIl.inventoryContainer.putStackInSlot(lllllllllllllIlIIllIIlIIIIIIIIll, lllllllllllllIlIIllIIlIIIIIIIlII);
            }
            else if (lllllllllllllIlIIllIIIlllllllllI.getWindowId() == lllllllllllllIlIIllIIlIIIIIIIlIl.openContainer.windowId && (lllllllllllllIlIIllIIIlllllllllI.getWindowId() != 0 || !lllllllllllllIlIIllIIlIIIIIIIIlI)) {
                lllllllllllllIlIIllIIlIIIIIIIlIl.openContainer.putStackInSlot(lllllllllllllIlIIllIIlIIIIIIIIll, lllllllllllllIlIIllIIlIIIIIIIlII);
            }
        }
    }
    
    public GameProfile getGameProfile() {
        return this.profile;
    }
    
    @Override
    public void handleSpawnPosition(final SPacketSpawnPosition lllllllllllllIlIIllIIlIIIllIllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIllIllII, this, this.gameController);
        this.gameController.player.setSpawnPoint(lllllllllllllIlIIllIIlIIIllIllII.getSpawnPos(), true);
        this.gameController.world.getWorldInfo().setSpawn(lllllllllllllIlIIllIIlIIIllIllII.getSpawnPos());
    }
    
    @Override
    public void handleServerDifficulty(final SPacketServerDifficulty lllllllllllllIlIIllIIIllIIlIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIIlIlIlI, this, this.gameController);
        this.gameController.world.getWorldInfo().setDifficulty(lllllllllllllIlIIllIIIllIIlIlIlI.getDifficulty());
        this.gameController.world.getWorldInfo().setDifficultyLocked(lllllllllllllIlIIllIIIllIIlIlIlI.isDifficultyLocked());
    }
    
    @Override
    public void handleBlockBreakAnim(final SPacketBlockBreakAnim lllllllllllllIlIIllIIIlllIlIlIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlllIlIlIII, this, this.gameController);
        this.gameController.world.sendBlockBreakProgress(lllllllllllllIlIIllIIIlllIlIlIII.getBreakerId(), lllllllllllllIlIIllIIIlllIlIlIII.getPosition(), lllllllllllllIlIIllIIIlllIlIlIII.getProgress());
    }
    
    private boolean validateResourcePackUrl(final String lllllllllllllIlIIllIIIlIlIlIlIIl) {
        try {
            final URI lllllllllllllIlIIllIIIlIlIlIlIII = new URI(lllllllllllllIlIIllIIIlIlIlIlIIl);
            final String lllllllllllllIlIIllIIIlIlIlIIlll = lllllllllllllIlIIllIIIlIlIlIlIII.getScheme();
            final boolean lllllllllllllIlIIllIIIlIlIlIIllI = "level".equals(lllllllllllllIlIIllIIIlIlIlIIlll);
            if (!"http".equals(lllllllllllllIlIIllIIIlIlIlIIlll) && !"https".equals(lllllllllllllIlIIllIIIlIlIlIIlll) && !lllllllllllllIlIIllIIIlIlIlIIllI) {
                throw new URISyntaxException(lllllllllllllIlIIllIIIlIlIlIlIIl, "Wrong protocol");
            }
            if (!lllllllllllllIlIIllIIIlIlIlIIllI || (!lllllllllllllIlIIllIIIlIlIlIlIIl.contains("..") && lllllllllllllIlIIllIIIlIlIlIlIIl.endsWith("/resources.zip"))) {
                return true;
            }
            throw new URISyntaxException(lllllllllllllIlIIllIIIlIlIlIlIIl, "Invalid levelstorage resourcepack path");
        }
        catch (URISyntaxException lllllllllllllIlIIllIIIlIlIlIIlIl) {
            this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.FAILED_DOWNLOAD));
            return false;
        }
    }
    
    @Override
    public void handleChangeGameState(final SPacketChangeGameState lllllllllllllIlIIllIIIlllIIllIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlllIIllIII, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIIlllIIllllI = this.gameController.player;
        final int lllllllllllllIlIIllIIIlllIIlllIl = lllllllllllllIlIIllIIIlllIIllIII.getGameState();
        final float lllllllllllllIlIIllIIIlllIIlllII = lllllllllllllIlIIllIIIlllIIllIII.getValue();
        final int lllllllllllllIlIIllIIIlllIIllIll = MathHelper.floor(lllllllllllllIlIIllIIIlllIIlllII + 0.5f);
        if (lllllllllllllIlIIllIIIlllIIlllIl >= 0 && lllllllllllllIlIIllIIIlllIIlllIl < SPacketChangeGameState.MESSAGE_NAMES.length && SPacketChangeGameState.MESSAGE_NAMES[lllllllllllllIlIIllIIIlllIIlllIl] != null) {
            lllllllllllllIlIIllIIIlllIIllllI.addChatComponentMessage(new TextComponentTranslation(SPacketChangeGameState.MESSAGE_NAMES[lllllllllllllIlIIllIIIlllIIlllIl], new Object[0]), false);
        }
        if (lllllllllllllIlIIllIIIlllIIlllIl == 1) {
            this.clientWorldController.getWorldInfo().setRaining(true);
            this.clientWorldController.setRainStrength(0.0f);
        }
        else if (lllllllllllllIlIIllIIIlllIIlllIl == 2) {
            this.clientWorldController.getWorldInfo().setRaining(false);
            this.clientWorldController.setRainStrength(1.0f);
        }
        else if (lllllllllllllIlIIllIIIlllIIlllIl == 3) {
            this.gameController.playerController.setGameType(GameType.getByID(lllllllllllllIlIIllIIIlllIIllIll));
        }
        else if (lllllllllllllIlIIllIIIlllIIlllIl == 4) {
            if (lllllllllllllIlIIllIIIlllIIllIll == 0) {
                this.gameController.player.connection.sendPacket(new CPacketClientStatus(CPacketClientStatus.State.PERFORM_RESPAWN));
                this.gameController.displayGuiScreen(new GuiDownloadTerrain());
            }
            else if (lllllllllllllIlIIllIIIlllIIllIll == 1) {
                this.gameController.displayGuiScreen(new GuiWinGame(true, () -> this.gameController.player.connection.sendPacket(new CPacketClientStatus(CPacketClientStatus.State.PERFORM_RESPAWN))));
            }
        }
        else if (lllllllllllllIlIIllIIIlllIIlllIl == 5) {
            final GameSettings lllllllllllllIlIIllIIIlllIIllIlI = this.gameController.gameSettings;
            if (lllllllllllllIlIIllIIIlllIIlllII == 0.0f) {
                this.gameController.displayGuiScreen(new GuiScreenDemo());
            }
            else if (lllllllllllllIlIIllIIIlllIIlllII == 101.0f) {
                this.gameController.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("demo.help.movement", new Object[] { GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIIlllIIllIlI.keyBindForward.getKeyCode()), GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIIlllIIllIlI.keyBindLeft.getKeyCode()), GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIIlllIIllIlI.keyBindBack.getKeyCode()), GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIIlllIIllIlI.keyBindRight.getKeyCode()) }));
            }
            else if (lllllllllllllIlIIllIIIlllIIlllII == 102.0f) {
                this.gameController.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("demo.help.jump", new Object[] { GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIIlllIIllIlI.keyBindJump.getKeyCode()) }));
            }
            else if (lllllllllllllIlIIllIIIlllIIlllII == 103.0f) {
                this.gameController.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("demo.help.inventory", new Object[] { GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIIlllIIllIlI.keyBindInventory.getKeyCode()) }));
            }
        }
        else if (lllllllllllllIlIIllIIIlllIIlllIl == 6) {
            this.clientWorldController.playSound(lllllllllllllIlIIllIIIlllIIllllI, lllllllllllllIlIIllIIIlllIIllllI.posX, lllllllllllllIlIIllIIIlllIIllllI.posY + lllllllllllllIlIIllIIIlllIIllllI.getEyeHeight(), lllllllllllllIlIIllIIIlllIIllllI.posZ, SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.PLAYERS, 0.18f, 0.45f);
        }
        else if (lllllllllllllIlIIllIIIlllIIlllIl == 7) {
            this.clientWorldController.setRainStrength(lllllllllllllIlIIllIIIlllIIlllII);
        }
        else if (lllllllllllllIlIIllIIIlllIIlllIl == 8) {
            this.clientWorldController.setThunderStrength(lllllllllllllIlIIllIIIlllIIlllII);
        }
        else if (lllllllllllllIlIIllIIIlllIIlllIl == 10) {
            this.clientWorldController.spawnParticle(EnumParticleTypes.MOB_APPEARANCE, lllllllllllllIlIIllIIIlllIIllllI.posX, lllllllllllllIlIIllIIIlllIIllllI.posY, lllllllllllllIlIIllIIIlllIIllllI.posZ, 0.0, 0.0, 0.0, new int[0]);
            this.clientWorldController.playSound(lllllllllllllIlIIllIIIlllIIllllI, lllllllllllllIlIIllIIIlllIIllllI.posX, lllllllllllllIlIIllIIIlllIIllllI.posY, lllllllllllllIlIIllIIIlllIIllllI.posZ, SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, SoundCategory.HOSTILE, 1.0f, 1.0f);
        }
    }
    
    static /* synthetic */ void access$4(final NetHandlerPlayClient lllllllllllllIlIIllIIIIllIllIIlI, final Minecraft lllllllllllllIlIIllIIIIllIllIIIl) {
        lllllllllllllIlIIllIIIIllIllIIlI.gameController = lllllllllllllIlIIllIIIIllIllIIIl;
    }
    
    public NetHandlerPlayClient(final Minecraft lllllllllllllIlIIllIIlIlllllIIIl, final GuiScreen lllllllllllllIlIIllIIlIlllllIIII, final NetworkManager lllllllllllllIlIIllIIlIllllIllll, final GameProfile lllllllllllllIlIIllIIlIlllllIIll) {
        this.playerInfoMap = (Map<UUID, NetworkPlayerInfo>)Maps.newHashMap();
        this.currentServerMaxPlayers = 20;
        this.avRandomizer = new Random();
        this.gameController = lllllllllllllIlIIllIIlIlllllIIIl;
        this.guiScreenServer = lllllllllllllIlIIllIIlIlllllIIII;
        this.netManager = lllllllllllllIlIIllIIlIllllIllll;
        this.profile = lllllllllllllIlIIllIIlIlllllIIll;
        this.field_191983_k = new ClientAdvancementManager(lllllllllllllIlIIllIIlIlllllIIIl);
    }
    
    @Override
    public void handleUpdateEntityNBT(final SPacketUpdateBossInfo lllllllllllllIlIIllIIIlIlIIlIlll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIlIIlIlll, this, this.gameController);
        this.gameController.ingameGUI.getBossOverlay().read(lllllllllllllIlIIllIIIlIlIIlIlll);
    }
    
    @Override
    public void handleDisplayObjective(final SPacketDisplayObjective lllllllllllllIlIIllIIIlIIIlllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIIIlllllI, this, this.gameController);
        final Scoreboard lllllllllllllIlIIllIIIlIIlIIIIIl = this.clientWorldController.getScoreboard();
        if (lllllllllllllIlIIllIIIlIIIlllllI.getName().isEmpty()) {
            lllllllllllllIlIIllIIIlIIlIIIIIl.setObjectiveInDisplaySlot(lllllllllllllIlIIllIIIlIIIlllllI.getPosition(), null);
        }
        else {
            final ScoreObjective lllllllllllllIlIIllIIIlIIlIIIIII = lllllllllllllIlIIllIIIlIIlIIIIIl.getObjective(lllllllllllllIlIIllIIIlIIIlllllI.getName());
            lllllllllllllIlIIllIIIlIIlIIIIIl.setObjectiveInDisplaySlot(lllllllllllllIlIIllIIIlIIIlllllI.getPosition(), lllllllllllllIlIIllIIIlIIlIIIIII);
        }
    }
    
    @Override
    public void handleEntityMovement(final SPacketEntity lllllllllllllIlIIllIIlIlIIlllIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIlIIlllIII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIlIIllllll = lllllllllllllIlIIllIIlIlIIlllIII.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIIlIlIIllllll != null) {
            final Entity entity = lllllllllllllIlIIllIIlIlIIllllll;
            entity.serverPosX += lllllllllllllIlIIllIIlIlIIlllIII.getX();
            final Entity entity2 = lllllllllllllIlIIllIIlIlIIllllll;
            entity2.serverPosY += lllllllllllllIlIIllIIlIlIIlllIII.getY();
            final Entity entity3 = lllllllllllllIlIIllIIlIlIIllllll;
            entity3.serverPosZ += lllllllllllllIlIIllIIlIlIIlllIII.getZ();
            final double lllllllllllllIlIIllIIlIlIIlllllI = lllllllllllllIlIIllIIlIlIIllllll.serverPosX / 4096.0;
            final double lllllllllllllIlIIllIIlIlIIllllIl = lllllllllllllIlIIllIIlIlIIllllll.serverPosY / 4096.0;
            final double lllllllllllllIlIIllIIlIlIIllllII = lllllllllllllIlIIllIIlIlIIllllll.serverPosZ / 4096.0;
            if (!lllllllllllllIlIIllIIlIlIIllllll.canPassengerSteer()) {
                final float lllllllllllllIlIIllIIlIlIIlllIll = lllllllllllllIlIIllIIlIlIIlllIII.isRotating() ? (lllllllllllllIlIIllIIlIlIIlllIII.getYaw() * 360 / 256.0f) : lllllllllllllIlIIllIIlIlIIllllll.rotationYaw;
                final float lllllllllllllIlIIllIIlIlIIlllIlI = lllllllllllllIlIIllIIlIlIIlllIII.isRotating() ? (lllllllllllllIlIIllIIlIlIIlllIII.getPitch() * 360 / 256.0f) : lllllllllllllIlIIllIIlIlIIllllll.rotationPitch;
                lllllllllllllIlIIllIIlIlIIllllll.setPositionAndRotationDirect(lllllllllllllIlIIllIIlIlIIlllllI, lllllllllllllIlIIllIIlIlIIllllIl, lllllllllllllIlIIllIIlIlIIllllII, lllllllllllllIlIIllIIlIlIIlllIll, lllllllllllllIlIIllIIlIlIIlllIlI, 3, false);
                lllllllllllllIlIIllIIlIlIIllllll.onGround = lllllllllllllIlIIllIIlIlIIlllIII.getOnGround();
            }
        }
    }
    
    @Override
    public void handleSpawnExperienceOrb(final SPacketSpawnExperienceOrb lllllllllllllIlIIllIIlIllIlllIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIllIlllIlI, this, this.gameController);
        final double lllllllllllllIlIIllIIlIllIlllIIl = lllllllllllllIlIIllIIlIllIlllIlI.getX();
        final double lllllllllllllIlIIllIIlIllIlllIII = lllllllllllllIlIIllIIlIllIlllIlI.getY();
        final double lllllllllllllIlIIllIIlIllIllIlll = lllllllllllllIlIIllIIlIllIlllIlI.getZ();
        final Entity lllllllllllllIlIIllIIlIllIllIllI = new EntityXPOrb(this.clientWorldController, lllllllllllllIlIIllIIlIllIlllIIl, lllllllllllllIlIIllIIlIllIlllIII, lllllllllllllIlIIllIIlIllIllIlll, lllllllllllllIlIIllIIlIllIlllIlI.getXPValue());
        EntityTracker.updateServerPosition(lllllllllllllIlIIllIIlIllIllIllI, lllllllllllllIlIIllIIlIllIlllIIl, lllllllllllllIlIIllIIlIllIlllIII, lllllllllllllIlIIllIIlIllIllIlll);
        lllllllllllllIlIIllIIlIllIllIllI.rotationYaw = 0.0f;
        lllllllllllllIlIIllIIlIllIllIllI.rotationPitch = 0.0f;
        lllllllllllllIlIIllIIlIllIllIllI.setEntityId(lllllllllllllIlIIllIIlIllIlllIlI.getEntityID());
        this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIIlIllIlllIlI.getEntityID(), lllllllllllllIlIIllIIlIllIllIllI);
    }
    
    @Override
    public void handleJoinGame(final SPacketJoinGame lllllllllllllIlIIllIIlIllllIIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIllllIIlIl, this, this.gameController);
        this.gameController.playerController = new PlayerControllerMP(this.gameController, this);
        this.clientWorldController = new WorldClient(this, new WorldSettings(0L, lllllllllllllIlIIllIIlIllllIIlIl.getGameType(), false, lllllllllllllIlIIllIIlIllllIIlIl.isHardcoreMode(), lllllllllllllIlIIllIIlIllllIIlIl.getWorldType()), lllllllllllllIlIIllIIlIllllIIlIl.getDimension(), lllllllllllllIlIIllIIlIllllIIlIl.getDifficulty(), this.gameController.mcProfiler);
        this.gameController.gameSettings.difficulty = lllllllllllllIlIIllIIlIllllIIlIl.getDifficulty();
        this.gameController.loadWorld(this.clientWorldController);
        this.gameController.player.dimension = lllllllllllllIlIIllIIlIllllIIlIl.getDimension();
        this.gameController.displayGuiScreen(new GuiDownloadTerrain());
        this.gameController.player.setEntityId(lllllllllllllIlIIllIIlIllllIIlIl.getPlayerId());
        this.currentServerMaxPlayers = lllllllllllllIlIIllIIlIllllIIlIl.getMaxPlayers();
        this.gameController.player.setReducedDebug(lllllllllllllIlIIllIIlIllllIIlIl.isReducedDebugInfo());
        this.gameController.playerController.setGameType(lllllllllllllIlIIllIIlIllllIIlIl.getGameType());
        this.gameController.gameSettings.sendSettingsToServer();
        this.netManager.sendPacket(new CPacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer()).writeString(ClientBrandRetriever.getClientModName())));
    }
    
    @Override
    public void func_194022_a(final SPacketSelectAdvancementsTab lllllllllllllIlIIllIIIllIllIlIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIllIlIll, this, this.gameController);
        final ResourceLocation lllllllllllllIlIIllIIIllIllIlllI = lllllllllllllIlIIllIIIllIllIlIll.func_194154_a();
        if (lllllllllllllIlIIllIIIllIllIlllI == null) {
            this.field_191983_k.func_194230_a(null, false);
        }
        else {
            final Advancement lllllllllllllIlIIllIIIllIllIllIl = this.field_191983_k.func_194229_a().func_192084_a(lllllllllllllIlIIllIIIllIllIlllI);
            this.field_191983_k.func_194230_a(lllllllllllllIlIIllIIIllIllIllIl, false);
        }
    }
    
    @Override
    public void handleStatistics(final SPacketStatistics lllllllllllllIlIIllIIIllIlIlllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIlIlllII, this, this.gameController);
        for (final Map.Entry<StatBase, Integer> lllllllllllllIlIIllIIIllIllIIIII : lllllllllllllIlIIllIIIllIlIlllII.getStatisticMap().entrySet()) {
            final StatBase lllllllllllllIlIIllIIIllIlIlllll = lllllllllllllIlIIllIIIllIllIIIII.getKey();
            final int lllllllllllllIlIIllIIIllIlIllllI = lllllllllllllIlIIllIIIllIllIIIII.getValue();
            this.gameController.player.getStatFileWriter().unlockAchievement(this.gameController.player, lllllllllllllIlIIllIIIllIlIlllll, lllllllllllllIlIIllIIIllIlIllllI);
        }
        this.hasStatistics = true;
        if (this.gameController.currentScreen instanceof IProgressMeter) {
            ((IProgressMeter)this.gameController.currentScreen).func_193026_g();
        }
    }
    
    public NetworkManager getNetworkManager() {
        return this.netManager;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State = NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State;
        }
        final byte lllllllllllllIlIIllIIIIllIlllIll = (Object)new int[SPacketRecipeBook.State.values().length];
        try {
            lllllllllllllIlIIllIIIIllIlllIll[SPacketRecipeBook.State.ADD.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIIIIllIlllIll[SPacketRecipeBook.State.INIT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIIIIllIlllIll[SPacketRecipeBook.State.REMOVE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State = (int[])(Object)lllllllllllllIlIIllIIIIllIlllIll;
    }
    
    @Override
    public void handleEffect(final SPacketEffect lllllllllllllIlIIllIIIllIllllIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIllllIll, this, this.gameController);
        if (lllllllllllllIlIIllIIIllIllllIll.isSoundServerwide()) {
            this.gameController.world.playBroadcastSound(lllllllllllllIlIIllIIIllIllllIll.getSoundType(), lllllllllllllIlIIllIIIllIllllIll.getSoundPos(), lllllllllllllIlIIllIIIllIllllIll.getSoundData());
        }
        else {
            this.gameController.world.playEvent(lllllllllllllIlIIllIIIllIllllIll.getSoundType(), lllllllllllllIlIIllIIIllIllllIll.getSoundPos(), lllllllllllllIlIIllIIIllIllllIll.getSoundData());
        }
    }
    
    @Override
    public void handleSpawnMob(final SPacketSpawnMob lllllllllllllIlIIllIIlIIlIIIIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIlIIIIIlI, this, this.gameController);
        final double lllllllllllllIlIIllIIlIIlIIIllIl = lllllllllllllIlIIllIIlIIlIIIIIlI.getX();
        final double lllllllllllllIlIIllIIlIIlIIIllII = lllllllllllllIlIIllIIlIIlIIIIIlI.getY();
        final double lllllllllllllIlIIllIIlIIlIIIlIll = lllllllllllllIlIIllIIlIIlIIIIIlI.getZ();
        final float lllllllllllllIlIIllIIlIIlIIIlIlI = lllllllllllllIlIIllIIlIIlIIIIIlI.getYaw() * 360 / 256.0f;
        final float lllllllllllllIlIIllIIlIIlIIIlIIl = lllllllllllllIlIIllIIlIIlIIIIIlI.getPitch() * 360 / 256.0f;
        final EntityLivingBase lllllllllllllIlIIllIIlIIlIIIlIII = (EntityLivingBase)EntityList.createEntityByID(lllllllllllllIlIIllIIlIIlIIIIIlI.getEntityType(), this.gameController.world);
        if (lllllllllllllIlIIllIIlIIlIIIlIII != null) {
            EntityTracker.updateServerPosition(lllllllllllllIlIIllIIlIIlIIIlIII, lllllllllllllIlIIllIIlIIlIIIllIl, lllllllllllllIlIIllIIlIIlIIIllII, lllllllllllllIlIIllIIlIIlIIIlIll);
            lllllllllllllIlIIllIIlIIlIIIlIII.renderYawOffset = lllllllllllllIlIIllIIlIIlIIIIIlI.getHeadPitch() * 360 / 256.0f;
            lllllllllllllIlIIllIIlIIlIIIlIII.rotationYawHead = lllllllllllllIlIIllIIlIIlIIIIIlI.getHeadPitch() * 360 / 256.0f;
            final Entity[] lllllllllllllIlIIllIIlIIlIIIIlll = lllllllllllllIlIIllIIlIIlIIIlIII.getParts();
            if (lllllllllllllIlIIllIIlIIlIIIIlll != null) {
                final int lllllllllllllIlIIllIIlIIlIIIIllI = lllllllllllllIlIIllIIlIIlIIIIIlI.getEntityID() - lllllllllllllIlIIllIIlIIlIIIlIII.getEntityId();
                final float lllllllllllllIlIIllIIlIIIlllIllI;
                final String lllllllllllllIlIIllIIlIIIlllIlll = (String)((Entity[])(Object)(lllllllllllllIlIIllIIlIIIlllIllI = (float)(Object)lllllllllllllIlIIllIIlIIlIIIIlll)).length;
                for (char lllllllllllllIlIIllIIlIIIllllIII = '\0'; lllllllllllllIlIIllIIlIIIllllIII < lllllllllllllIlIIllIIlIIIlllIlll; ++lllllllllllllIlIIllIIlIIIllllIII) {
                    final Entity lllllllllllllIlIIllIIlIIlIIIIlIl = lllllllllllllIlIIllIIlIIIlllIllI[lllllllllllllIlIIllIIlIIIllllIII];
                    lllllllllllllIlIIllIIlIIlIIIIlIl.setEntityId(lllllllllllllIlIIllIIlIIlIIIIlIl.getEntityId() + lllllllllllllIlIIllIIlIIlIIIIllI);
                }
            }
            lllllllllllllIlIIllIIlIIlIIIlIII.setEntityId(lllllllllllllIlIIllIIlIIlIIIIIlI.getEntityID());
            lllllllllllllIlIIllIIlIIlIIIlIII.setUniqueId(lllllllllllllIlIIllIIlIIlIIIIIlI.getUniqueId());
            lllllllllllllIlIIllIIlIIlIIIlIII.setPositionAndRotation(lllllllllllllIlIIllIIlIIlIIIllIl, lllllllllllllIlIIllIIlIIlIIIllII, lllllllllllllIlIIllIIlIIlIIIlIll, lllllllllllllIlIIllIIlIIlIIIlIlI, lllllllllllllIlIIllIIlIIlIIIlIIl);
            lllllllllllllIlIIllIIlIIlIIIlIII.motionX = lllllllllllllIlIIllIIlIIlIIIIIlI.getVelocityX() / 8000.0f;
            lllllllllllllIlIIllIIlIIlIIIlIII.motionY = lllllllllllllIlIIllIIlIIlIIIIIlI.getVelocityY() / 8000.0f;
            lllllllllllllIlIIllIIlIIlIIIlIII.motionZ = lllllllllllllIlIIllIIlIIlIIIIIlI.getVelocityZ() / 8000.0f;
            this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIIlIIlIIIIIlI.getEntityID(), lllllllllllllIlIIllIIlIIlIIIlIII);
            final List<EntityDataManager.DataEntry<?>> lllllllllllllIlIIllIIlIIlIIIIlII = lllllllllllllIlIIllIIlIIlIIIIIlI.getDataManagerEntries();
            if (lllllllllllllIlIIllIIlIIlIIIIlII != null) {
                lllllllllllllIlIIllIIlIIlIIIlIII.getDataManager().setEntryValues(lllllllllllllIlIIllIIlIIlIIIIlII);
            }
        }
        else {
            NetHandlerPlayClient.LOGGER.warn("Skipping Entity with id {}", (Object)lllllllllllllIlIIllIIlIIlIIIIIlI.getEntityType());
        }
    }
    
    @Override
    public void handleConfirmTransaction(final SPacketConfirmTransaction lllllllllllllIlIIllIIIlllllIllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlllllIllll, this, this.gameController);
        Container lllllllllllllIlIIllIIIllllllIIlI = null;
        final EntityPlayer lllllllllllllIlIIllIIIllllllIIIl = this.gameController.player;
        if (lllllllllllllIlIIllIIIlllllIllll.getWindowId() == 0) {
            lllllllllllllIlIIllIIIllllllIIlI = lllllllllllllIlIIllIIIllllllIIIl.inventoryContainer;
        }
        else if (lllllllllllllIlIIllIIIlllllIllll.getWindowId() == lllllllllllllIlIIllIIIllllllIIIl.openContainer.windowId) {
            lllllllllllllIlIIllIIIllllllIIlI = lllllllllllllIlIIllIIIllllllIIIl.openContainer;
        }
        if (lllllllllllllIlIIllIIIllllllIIlI != null && !lllllllllllllIlIIllIIIlllllIllll.wasAccepted()) {
            this.sendPacket(new CPacketConfirmTransaction(lllllllllllllIlIIllIIIlllllIllll.getWindowId(), lllllllllllllIlIIllIIIlllllIllll.getActionNumber(), true));
        }
    }
    
    @Override
    public void handleRespawn(final SPacketRespawn lllllllllllllIlIIllIIlIIIIlIlIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIIlIlIIl, this, this.gameController);
        if (lllllllllllllIlIIllIIlIIIIlIlIIl.getDimensionID() != this.gameController.player.dimension) {
            this.doneLoadingTerrain = false;
            final Scoreboard lllllllllllllIlIIllIIlIIIIlIlIII = this.clientWorldController.getScoreboard();
            this.clientWorldController = new WorldClient(this, new WorldSettings(0L, lllllllllllllIlIIllIIlIIIIlIlIIl.getGameType(), false, this.gameController.world.getWorldInfo().isHardcoreModeEnabled(), lllllllllllllIlIIllIIlIIIIlIlIIl.getWorldType()), lllllllllllllIlIIllIIlIIIIlIlIIl.getDimensionID(), lllllllllllllIlIIllIIlIIIIlIlIIl.getDifficulty(), this.gameController.mcProfiler);
            this.clientWorldController.setWorldScoreboard(lllllllllllllIlIIllIIlIIIIlIlIII);
            this.gameController.loadWorld(this.clientWorldController);
            this.gameController.player.dimension = lllllllllllllIlIIllIIlIIIIlIlIIl.getDimensionID();
            this.gameController.displayGuiScreen(new GuiDownloadTerrain());
        }
        this.gameController.setDimensionAndSpawnPlayer(lllllllllllllIlIIllIIlIIIIlIlIIl.getDimensionID());
        this.gameController.playerController.setGameType(lllllllllllllIlIIllIIlIIIIlIlIIl.getGameType());
    }
    
    @Override
    public void handleEntityMetadata(final SPacketEntityMetadata lllllllllllllIlIIllIIlIllIIIIlll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIllIIIIlll, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIllIIIIllI = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIllIIIIlll.getEntityId());
        if (lllllllllllllIlIIllIIlIllIIIIllI != null && lllllllllllllIlIIllIIlIllIIIIlll.getDataManagerEntries() != null) {
            lllllllllllllIlIIllIIlIllIIIIllI.getDataManager().setEntryValues(lllllllllllllIlIIllIIlIllIIIIlll.getDataManagerEntries());
        }
    }
    
    @Override
    public void handleEntityHeadLook(final SPacketEntityHeadLook lllllllllllllIlIIllIIlIlIIlIlIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIlIIlIlIII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIlIIlIlIll = lllllllllllllIlIIllIIlIlIIlIlIII.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIIlIlIIlIlIll != null) {
            final float lllllllllllllIlIIllIIlIlIIlIlIlI = lllllllllllllIlIIllIIlIlIIlIlIII.getYaw() * 360 / 256.0f;
            lllllllllllllIlIIllIIlIlIIlIlIll.setRotationYawHead(lllllllllllllIlIIllIIlIlIIlIlIlI);
        }
    }
    
    @Override
    public void handleWorldBorder(final SPacketWorldBorder lllllllllllllIlIIllIIIllIIIllIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIIIllIIl, this, this.gameController);
        lllllllllllllIlIIllIIIllIIIllIIl.apply(this.clientWorldController.getWorldBorder());
    }
    
    @Override
    public void handleSpawnPlayer(final SPacketSpawnPlayer lllllllllllllIlIIllIIlIlIllIllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIlIllIllll, this, this.gameController);
        final double lllllllllllllIlIIllIIlIlIlllIlll = lllllllllllllIlIIllIIlIlIllIllll.getX();
        final double lllllllllllllIlIIllIIlIlIlllIllI = lllllllllllllIlIIllIIlIlIllIllll.getY();
        final double lllllllllllllIlIIllIIlIlIlllIlIl = lllllllllllllIlIIllIIlIlIllIllll.getZ();
        final float lllllllllllllIlIIllIIlIlIlllIlII = lllllllllllllIlIIllIIlIlIllIllll.getYaw() * 360 / 256.0f;
        final float lllllllllllllIlIIllIIlIlIlllIIll = lllllllllllllIlIIllIIlIlIllIllll.getPitch() * 360 / 256.0f;
        final EntityOtherPlayerMP lllllllllllllIlIIllIIlIlIlllIIlI = new EntityOtherPlayerMP(this.gameController.world, this.getPlayerInfo(lllllllllllllIlIIllIIlIlIllIllll.getUniqueId()).getGameProfile());
        lllllllllllllIlIIllIIlIlIlllIIlI.prevPosX = lllllllllllllIlIIllIIlIlIlllIlll;
        lllllllllllllIlIIllIIlIlIlllIIlI.lastTickPosX = lllllllllllllIlIIllIIlIlIlllIlll;
        lllllllllllllIlIIllIIlIlIlllIIlI.prevPosY = lllllllllllllIlIIllIIlIlIlllIllI;
        lllllllllllllIlIIllIIlIlIlllIIlI.lastTickPosY = lllllllllllllIlIIllIIlIlIlllIllI;
        lllllllllllllIlIIllIIlIlIlllIIlI.prevPosZ = lllllllllllllIlIIllIIlIlIlllIlIl;
        lllllllllllllIlIIllIIlIlIlllIIlI.lastTickPosZ = lllllllllllllIlIIllIIlIlIlllIlIl;
        EntityTracker.updateServerPosition(lllllllllllllIlIIllIIlIlIlllIIlI, lllllllllllllIlIIllIIlIlIlllIlll, lllllllllllllIlIIllIIlIlIlllIllI, lllllllllllllIlIIllIIlIlIlllIlIl);
        lllllllllllllIlIIllIIlIlIlllIIlI.setPositionAndRotation(lllllllllllllIlIIllIIlIlIlllIlll, lllllllllllllIlIIllIIlIlIlllIllI, lllllllllllllIlIIllIIlIlIlllIlIl, lllllllllllllIlIIllIIlIlIlllIlII, lllllllllllllIlIIllIIlIlIlllIIll);
        this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIIlIlIllIllll.getEntityID(), lllllllllllllIlIIllIIlIlIlllIIlI);
        final List<EntityDataManager.DataEntry<?>> lllllllllllllIlIIllIIlIlIlllIIIl = lllllllllllllIlIIllIIlIlIllIllll.getDataManagerEntries();
        if (lllllllllllllIlIIllIIlIlIlllIIIl != null) {
            lllllllllllllIlIIllIIlIlIlllIIlI.getDataManager().setEntryValues(lllllllllllllIlIIllIIlIlIlllIIIl);
        }
    }
    
    @Override
    public void handleWindowProperty(final SPacketWindowProperty lllllllllllllIlIIllIIIllllIIIlll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllllIIIlll, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIIllllIIIllI = this.gameController.player;
        if (lllllllllllllIlIIllIIIllllIIIllI.openContainer != null && lllllllllllllIlIIllIIIllllIIIllI.openContainer.windowId == lllllllllllllIlIIllIIIllllIIIlll.getWindowId()) {
            lllllllllllllIlIIllIIIllllIIIllI.openContainer.updateProgressBar(lllllllllllllIlIIllIIIllllIIIlll.getProperty(), lllllllllllllIlIIllIIIllllIIIlll.getValue());
        }
    }
    
    @Override
    public void handleUpdateHealth(final SPacketUpdateHealth lllllllllllllIlIIllIIlIIIIllIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIIllIlII, this, this.gameController);
        this.gameController.player.setPlayerSPHealth(lllllllllllllIlIIllIIlIIIIllIlII.getHealth());
        this.gameController.player.getFoodStats().setFoodLevel(lllllllllllllIlIIllIIlIIIIllIlII.getFoodLevel());
        this.gameController.player.getFoodStats().setFoodSaturationLevel(lllllllllllllIlIIllIIlIIIIllIlII.getSaturationLevel());
    }
    
    @Override
    public void handleTimeUpdate(final SPacketTimeUpdate lllllllllllllIlIIllIIlIIIlllIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIlllIIlI, this, this.gameController);
        this.gameController.world.setTotalWorldTime(lllllllllllllIlIIllIIlIIIlllIIlI.getTotalWorldTime());
        this.gameController.world.setWorldTime(lllllllllllllIlIIllIIlIIIlllIIlI.getWorldTime());
    }
    
    @Override
    public void handleSoundEffect(final SPacketSoundEffect lllllllllllllIlIIllIIIlIllIIlllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIllIIlllI, this, this.gameController);
        this.gameController.world.playSound(this.gameController.player, lllllllllllllIlIIllIIIlIllIIlllI.getX(), lllllllllllllIlIIllIIIlIllIIlllI.getY(), lllllllllllllIlIIllIIIlIllIIlllI.getZ(), lllllllllllllIlIIllIIIlIllIIlllI.getSound(), lllllllllllllIlIIllIIIlIllIIlllI.getCategory(), lllllllllllllIlIIllIIIlIllIIlllI.getVolume(), lllllllllllllIlIIllIIIlIllIIlllI.getPitch());
    }
    
    @Override
    public void func_191980_a(final SPacketRecipeBook lllllllllllllIlIIllIIIllIlIIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIlIIlIlI, this, this.gameController);
        final RecipeBook lllllllllllllIlIIllIIIllIlIIllll = this.gameController.player.func_192035_E();
        lllllllllllllIlIIllIIIllIlIIllll.func_192813_a(lllllllllllllIlIIllIIIllIlIIlIlI.func_192593_c());
        lllllllllllllIlIIllIIIllIlIIllll.func_192810_b(lllllllllllllIlIIllIIIllIlIIlIlI.func_192594_d());
        final SPacketRecipeBook.State lllllllllllllIlIIllIIIllIlIIlllI = lllllllllllllIlIIllIIIllIlIIlIlI.func_194151_e();
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State()[lllllllllllllIlIIllIIIllIlIIlllI.ordinal()]) {
            case 3: {
                for (final IRecipe lllllllllllllIlIIllIIIllIlIIllII : lllllllllllllIlIIllIIIllIlIIlIlI.func_192595_a()) {
                    lllllllllllllIlIIllIIIllIlIIllll.func_193831_b(lllllllllllllIlIIllIIIllIlIIllII);
                }
                break;
            }
            case 1: {
                lllllllllllllIlIIllIIIllIlIIlIlI.func_192595_a().forEach(lllllllllllllIlIIllIIIllIlIIllll::func_194073_a);
                lllllllllllllIlIIllIIIllIlIIlIlI.func_193644_b().forEach(lllllllllllllIlIIllIIIllIlIIllll::func_193825_e);
                break;
            }
            case 2: {
                final RecipeBook recipeBook;
                lllllllllllllIlIIllIIIllIlIIlIlI.func_192595_a().forEach(lllllllllllllIlIIllIIIIllIlIIIlI -> {
                    recipeBook.func_194073_a(lllllllllllllIlIIllIIIIllIlIIIlI);
                    recipeBook.func_193825_e(lllllllllllllIlIIllIIIIllIlIIIlI);
                    RecipeToast.func_193665_a(this.gameController.func_193033_an(), lllllllllllllIlIIllIIIIllIlIIIlI);
                    return;
                });
                break;
            }
        }
        RecipeBookClient.field_194087_f.forEach(lllllllllllllIlIIllIIIIllIIlllIl -> lllllllllllllIlIIllIIIIllIIlllIl.func_194214_a(lllllllllllllIlIIllIIIllIlIIllll));
        if (this.gameController.currentScreen instanceof IRecipeShownListener) {
            ((IRecipeShownListener)this.gameController.currentScreen).func_192043_J_();
        }
    }
    
    @Override
    public void handleCustomPayload(final SPacketCustomPayload lllllllllllllIlIIllIIIlIIllllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIIllllllI, this, this.gameController);
        if ("MC|TrList".equals(lllllllllllllIlIIllIIIlIIllllllI.getChannelName())) {
            final PacketBuffer lllllllllllllIlIIllIIIlIIlllllIl = lllllllllllllIlIIllIIIlIIllllllI.getBufferData();
            try {
                final int lllllllllllllIlIIllIIIlIIlllllII = lllllllllllllIlIIllIIIlIIlllllIl.readInt();
                final GuiScreen lllllllllllllIlIIllIIIlIIllllIll = this.gameController.currentScreen;
                if (lllllllllllllIlIIllIIIlIIllllIll != null && lllllllllllllIlIIllIIIlIIllllIll instanceof GuiMerchant && lllllllllllllIlIIllIIIlIIlllllII == this.gameController.player.openContainer.windowId) {
                    final IMerchant lllllllllllllIlIIllIIIlIIllllIlI = ((GuiMerchant)lllllllllllllIlIIllIIIlIIllllIll).getMerchant();
                    final MerchantRecipeList lllllllllllllIlIIllIIIlIIllllIIl = MerchantRecipeList.readFromBuf(lllllllllllllIlIIllIIIlIIlllllIl);
                    lllllllllllllIlIIllIIIlIIllllIlI.setRecipes(lllllllllllllIlIIllIIIlIIllllIIl);
                }
            }
            catch (IOException lllllllllllllIlIIllIIIlIIllllIII) {
                NetHandlerPlayClient.LOGGER.error("Couldn't load trade info", (Throwable)lllllllllllllIlIIllIIIlIIllllIII);
                return;
            }
            finally {
                lllllllllllllIlIIllIIIlIIlllllIl.release();
            }
            lllllllllllllIlIIllIIIlIIlllllIl.release();
        }
        else if ("MC|Brand".equals(lllllllllllllIlIIllIIIlIIllllllI.getChannelName())) {
            this.gameController.player.setServerBrand(lllllllllllllIlIIllIIIlIIllllllI.getBufferData().readStringFromBuffer(32767));
        }
        else if ("MC|BOpen".equals(lllllllllllllIlIIllIIIlIIllllllI.getChannelName())) {
            final EnumHand lllllllllllllIlIIllIIIlIIlllIlll = lllllllllllllIlIIllIIIlIIllllllI.getBufferData().readEnumValue(EnumHand.class);
            final ItemStack lllllllllllllIlIIllIIIlIIlllIllI = (lllllllllllllIlIIllIIIlIIlllIlll == EnumHand.OFF_HAND) ? this.gameController.player.getHeldItemOffhand() : this.gameController.player.getHeldItemMainhand();
            if (lllllllllllllIlIIllIIIlIIlllIllI.getItem() == Items.WRITTEN_BOOK) {
                this.gameController.displayGuiScreen(new GuiScreenBook(this.gameController.player, lllllllllllllIlIIllIIIlIIlllIllI, false));
            }
        }
        else if ("MC|DebugPath".equals(lllllllllllllIlIIllIIIlIIllllllI.getChannelName())) {
            final PacketBuffer lllllllllllllIlIIllIIIlIIlllIlIl = lllllllllllllIlIIllIIIlIIllllllI.getBufferData();
            final int lllllllllllllIlIIllIIIlIIlllIlII = lllllllllllllIlIIllIIIlIIlllIlIl.readInt();
            final float lllllllllllllIlIIllIIIlIIlllIIll = lllllllllllllIlIIllIIIlIIlllIlIl.readFloat();
            final Path lllllllllllllIlIIllIIIlIIlllIIlI = Path.read(lllllllllllllIlIIllIIIlIIlllIlIl);
            ((DebugRendererPathfinding)this.gameController.debugRenderer.debugRendererPathfinding).addPath(lllllllllllllIlIIllIIIlIIlllIlII, lllllllllllllIlIIllIIIlIIlllIIlI, lllllllllllllIlIIllIIIlIIlllIIll);
        }
        else if ("MC|DebugNeighborsUpdate".equals(lllllllllllllIlIIllIIIlIIllllllI.getChannelName())) {
            final PacketBuffer lllllllllllllIlIIllIIIlIIlllIIIl = lllllllllllllIlIIllIIIlIIllllllI.getBufferData();
            final long lllllllllllllIlIIllIIIlIIlllIIII = lllllllllllllIlIIllIIIlIIlllIIIl.readVarLong();
            final BlockPos lllllllllllllIlIIllIIIlIIllIllll = lllllllllllllIlIIllIIIlIIlllIIIl.readBlockPos();
            ((DebugRendererNeighborsUpdate)this.gameController.debugRenderer.field_191557_f).func_191553_a(lllllllllllllIlIIllIIIlIIlllIIII, lllllllllllllIlIIllIIIlIIllIllll);
        }
        else if ("MC|StopSound".equals(lllllllllllllIlIIllIIIlIIllllllI.getChannelName())) {
            final PacketBuffer lllllllllllllIlIIllIIIlIIllIlllI = lllllllllllllIlIIllIIIlIIllllllI.getBufferData();
            final String lllllllllllllIlIIllIIIlIIllIllIl = lllllllllllllIlIIllIIIlIIllIlllI.readStringFromBuffer(32767);
            final String lllllllllllllIlIIllIIIlIIllIllII = lllllllllllllIlIIllIIIlIIllIlllI.readStringFromBuffer(256);
            this.gameController.getSoundHandler().stop(lllllllllllllIlIIllIIIlIIllIllII, SoundCategory.getByName(lllllllllllllIlIIllIIIlIIllIllIl));
        }
    }
    
    @Override
    public void handleCustomSound(final SPacketCustomSound lllllllllllllIlIIllIIIlIllIIlIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIllIIlIII, this, this.gameController);
        this.gameController.getSoundHandler().playSound(new PositionedSoundRecord(new ResourceLocation(lllllllllllllIlIIllIIIlIllIIlIII.getSoundName()), lllllllllllllIlIIllIIIlIllIIlIII.getCategory(), lllllllllllllIlIIllIIIlIllIIlIII.getVolume(), lllllllllllllIlIIllIIIlIllIIlIII.getPitch(), false, 0, ISound.AttenuationType.LINEAR, (float)lllllllllllllIlIIllIIIlIllIIlIII.getX(), (float)lllllllllllllIlIIllIIIlIllIIlIII.getY(), (float)lllllllllllllIlIIllIIIlIllIIlIII.getZ()));
    }
    
    @Override
    public void onDisconnect(final ITextComponent lllllllllllllIlIIllIIlIIllIIlIlI) {
        this.gameController.loadWorld(null);
        if (this.guiScreenServer != null) {
            if (this.guiScreenServer instanceof GuiScreenRealmsProxy) {
                this.gameController.displayGuiScreen(new DisconnectedRealmsScreen(((GuiScreenRealmsProxy)this.guiScreenServer).getProxy(), "disconnect.lost", lllllllllllllIlIIllIIlIIllIIlIlI).getProxy());
            }
            else {
                this.gameController.displayGuiScreen(new GuiDisconnected(this.guiScreenServer, "disconnect.lost", lllllllllllllIlIIllIIlIIllIIlIlI));
            }
        }
        else {
            this.gameController.displayGuiScreen(new GuiDisconnected(new GuiMultiplayer(new GuiMainMenu()), "disconnect.lost", lllllllllllllIlIIllIIlIIllIIlIlI));
        }
    }
    
    @Override
    public void handleEntityProperties(final SPacketEntityProperties lllllllllllllIlIIllIIIIlllllIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIIlllllIlII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIIIlllllIIll = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIIIlllllIlII.getEntityId());
        if (lllllllllllllIlIIllIIIIlllllIIll != null) {
            if (!(lllllllllllllIlIIllIIIIlllllIIll instanceof EntityLivingBase)) {
                throw new IllegalStateException("Server tried to update attributes of a non-living entity (actually: " + lllllllllllllIlIIllIIIIlllllIIll + ")");
            }
            final AbstractAttributeMap lllllllllllllIlIIllIIIIlllllIIlI = ((EntityLivingBase)lllllllllllllIlIIllIIIIlllllIIll).getAttributeMap();
            for (final SPacketEntityProperties.Snapshot lllllllllllllIlIIllIIIIlllllIIIl : lllllllllllllIlIIllIIIIlllllIlII.getSnapshots()) {
                IAttributeInstance lllllllllllllIlIIllIIIIlllllIIII = lllllllllllllIlIIllIIIIlllllIIlI.getAttributeInstanceByName(lllllllllllllIlIIllIIIIlllllIIIl.getName());
                if (lllllllllllllIlIIllIIIIlllllIIII == null) {
                    lllllllllllllIlIIllIIIIlllllIIII = lllllllllllllIlIIllIIIIlllllIIlI.registerAttribute(new RangedAttribute(null, lllllllllllllIlIIllIIIIlllllIIIl.getName(), 0.0, Double.MIN_NORMAL, Double.MAX_VALUE));
                }
                lllllllllllllIlIIllIIIIlllllIIII.setBaseValue(lllllllllllllIlIIllIIIIlllllIIIl.getBaseValue());
                lllllllllllllIlIIllIIIIlllllIIII.removeAllModifiers();
                for (final AttributeModifier lllllllllllllIlIIllIIIIllllIllll : lllllllllllllIlIIllIIIIlllllIIIl.getModifiers()) {
                    lllllllllllllIlIIllIIIIlllllIIII.applyModifier(lllllllllllllIlIIllIIIIllllIllll);
                }
            }
        }
    }
    
    @Override
    public void handleRemoveEntityEffect(final SPacketRemoveEntityEffect lllllllllllllIlIIllIIIlIllllllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIllllllII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIIlIlllllIll = lllllllllllllIlIIllIIIlIllllllII.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIIIlIlllllIll instanceof EntityLivingBase) {
            ((EntityLivingBase)lllllllllllllIlIIllIIIlIlllllIll).removeActivePotionEffect(lllllllllllllIlIIllIIIlIllllllII.getPotion());
        }
    }
    
    @Override
    public void handleMultiBlockChange(final SPacketMultiBlockChange lllllllllllllIlIIllIIlIIllllllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIllllllIl, this, this.gameController);
        final short lllllllllllllIlIIllIIlIIllllIllI;
        final int lllllllllllllIlIIllIIlIIllllIlll = ((SPacketMultiBlockChange.BlockUpdateData[])(Object)(lllllllllllllIlIIllIIlIIllllIllI = (short)(Object)lllllllllllllIlIIllIIlIIllllllIl.getChangedBlocks())).length;
        for (short lllllllllllllIlIIllIIlIIlllllIII = 0; lllllllllllllIlIIllIIlIIlllllIII < lllllllllllllIlIIllIIlIIllllIlll; ++lllllllllllllIlIIllIIlIIlllllIII) {
            final SPacketMultiBlockChange.BlockUpdateData lllllllllllllIlIIllIIlIIllllllII = lllllllllllllIlIIllIIlIIllllIllI[lllllllllllllIlIIllIIlIIlllllIII];
            this.clientWorldController.invalidateRegionAndSetBlock(lllllllllllllIlIIllIIlIIllllllII.getPos(), lllllllllllllIlIIllIIlIIllllllII.getBlockState());
        }
    }
    
    @Override
    public void func_191981_a(final SPacketAdvancementInfo lllllllllllllIlIIllIIIllIlllIlll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIlllIlll, this, this.gameController);
        this.field_191983_k.func_192799_a(lllllllllllllIlIIllIIIllIlllIlll);
    }
    
    public ClientAdvancementManager func_191982_f() {
        return this.field_191983_k;
    }
    
    @Override
    public void handleMaps(final SPacketMaps lllllllllllllIlIIllIIIlllIIIlIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlllIIIlIll, this, this.gameController);
        final MapItemRenderer lllllllllllllIlIIllIIIlllIIIlIlI = this.gameController.entityRenderer.getMapItemRenderer();
        MapData lllllllllllllIlIIllIIIlllIIIlIIl = ItemMap.loadMapData(lllllllllllllIlIIllIIIlllIIIlIll.getMapId(), this.gameController.world);
        if (lllllllllllllIlIIllIIIlllIIIlIIl == null) {
            final String lllllllllllllIlIIllIIIlllIIIlIII = "map_" + lllllllllllllIlIIllIIIlllIIIlIll.getMapId();
            lllllllllllllIlIIllIIIlllIIIlIIl = new MapData(lllllllllllllIlIIllIIIlllIIIlIII);
            if (lllllllllllllIlIIllIIIlllIIIlIlI.func_191205_a(lllllllllllllIlIIllIIIlllIIIlIII) != null) {
                final MapData lllllllllllllIlIIllIIIlllIIIIlll = lllllllllllllIlIIllIIIlllIIIlIlI.func_191207_a(lllllllllllllIlIIllIIIlllIIIlIlI.func_191205_a(lllllllllllllIlIIllIIIlllIIIlIII));
                if (lllllllllllllIlIIllIIIlllIIIIlll != null) {
                    lllllllllllllIlIIllIIIlllIIIlIIl = lllllllllllllIlIIllIIIlllIIIIlll;
                }
            }
            this.gameController.world.setItemData(lllllllllllllIlIIllIIIlllIIIlIII, lllllllllllllIlIIllIIIlllIIIlIIl);
        }
        lllllllllllllIlIIllIIIlllIIIlIll.setMapdataTo(lllllllllllllIlIIllIIIlllIIIlIIl);
        lllllllllllllIlIIllIIIlllIIIlIlI.updateMapTexture(lllllllllllllIlIIllIIIlllIIIlIIl);
    }
    
    @Override
    public void handlePlayerListHeaderFooter(final SPacketPlayerListHeaderFooter lllllllllllllIlIIllIIIllIIIIIIll) {
        this.gameController.ingameGUI.getTabList().setHeader(lllllllllllllIlIIllIIIllIIIIIIll.getHeader().getFormattedText().isEmpty() ? null : lllllllllllllIlIIllIIIllIIIIIIll.getHeader());
        this.gameController.ingameGUI.getTabList().setFooter(lllllllllllllIlIIllIIIllIIIIIIll.getFooter().getFormattedText().isEmpty() ? null : lllllllllllllIlIIllIIIllIIIIIIll.getFooter());
    }
    
    @Override
    public void handleEntityVelocity(final SPacketEntityVelocity lllllllllllllIlIIllIIlIllIIlIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIllIIlIIII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIllIIIllll = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIllIIlIIII.getEntityID());
        if (lllllllllllllIlIIllIIlIllIIIllll != null) {
            lllllllllllllIlIIllIIlIllIIIllll.setVelocity(lllllllllllllIlIIllIIlIllIIlIIII.getMotionX() / 8000.0, lllllllllllllIlIIllIIlIllIIlIIII.getMotionY() / 8000.0, lllllllllllllIlIIllIIlIllIIlIIII.getMotionZ() / 8000.0);
        }
    }
    
    @Override
    public void handleChat(final SPacketChat lllllllllllllIlIIllIIlIIlIllIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIlIllIIlI, this, this.gameController);
        this.gameController.ingameGUI.func_191742_a(lllllllllllllIlIIllIIlIIlIllIIlI.func_192590_c(), lllllllllllllIlIIllIIlIIlIllIIlI.getChatComponent());
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action = NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action;
        }
        final char lllllllllllllIlIIllIIIIllIllIlll = (Object)new int[SPacketPlayerListItem.Action.values().length];
        try {
            lllllllllllllIlIIllIIIIllIllIlll[SPacketPlayerListItem.Action.ADD_PLAYER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIIIIllIllIlll[SPacketPlayerListItem.Action.REMOVE_PLAYER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIIIIllIllIlll[SPacketPlayerListItem.Action.UPDATE_DISPLAY_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIllIIIIllIllIlll[SPacketPlayerListItem.Action.UPDATE_GAME_MODE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIIllIIIIllIllIlll[SPacketPlayerListItem.Action.UPDATE_LATENCY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action = (int[])(Object)lllllllllllllIlIIllIIIIllIllIlll;
    }
    
    public void sendPacket(final Packet<?> lllllllllllllIlIIllIIlIIllIIIllI) {
        this.netManager.sendPacket(lllllllllllllIlIIllIIlIIllIIIllI);
    }
    
    @Override
    public void handleSpawnPainting(final SPacketSpawnPainting lllllllllllllIlIIllIIlIllIIllIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIllIIllIIl, this, this.gameController);
        final EntityPainting lllllllllllllIlIIllIIlIllIIllIII = new EntityPainting(this.clientWorldController, lllllllllllllIlIIllIIlIllIIllIIl.getPosition(), lllllllllllllIlIIllIIlIllIIllIIl.getFacing(), lllllllllllllIlIIllIIlIllIIllIIl.getTitle());
        lllllllllllllIlIIllIIlIllIIllIII.setUniqueId(lllllllllllllIlIIllIIlIllIIllIIl.getUniqueId());
        this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIIlIllIIllIIl.getEntityID(), lllllllllllllIlIIllIIlIllIIllIII);
    }
    
    @Override
    public void handleWindowItems(final SPacketWindowItems lllllllllllllIlIIllIIIlllllIIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlllllIIlIl, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIIlllllIIlll = this.gameController.player;
        if (lllllllllllllIlIIllIIIlllllIIlIl.getWindowId() == 0) {
            lllllllllllllIlIIllIIIlllllIIlll.inventoryContainer.func_190896_a(lllllllllllllIlIIllIIIlllllIIlIl.getItemStacks());
        }
        else if (lllllllllllllIlIIllIIIlllllIIlIl.getWindowId() == lllllllllllllIlIIllIIIlllllIIlll.openContainer.windowId) {
            lllllllllllllIlIIllIIIlllllIIlll.openContainer.func_190896_a(lllllllllllllIlIIllIIIlllllIIlIl.getItemStacks());
        }
    }
    
    @Override
    public void handleBlockChange(final SPacketBlockChange lllllllllllllIlIIllIIlIIllIllIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIllIllIII, this, this.gameController);
        this.clientWorldController.invalidateRegionAndSetBlock(lllllllllllllIlIIllIIlIIllIllIII.getBlockPosition(), lllllllllllllIlIIllIIlIIllIllIII.getBlockState());
    }
    
    @Override
    public void handlePlayerListItem(final SPacketPlayerListItem lllllllllllllIlIIllIIIlIlllIllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIlllIllIl, this, this.gameController);
        for (final SPacketPlayerListItem.AddPlayerData lllllllllllllIlIIllIIIlIllllIIII : lllllllllllllIlIIllIIIlIlllIllIl.getEntries()) {
            if (lllllllllllllIlIIllIIIlIlllIllIl.getAction() == SPacketPlayerListItem.Action.REMOVE_PLAYER) {
                this.playerInfoMap.remove(lllllllllllllIlIIllIIIlIllllIIII.getProfile().getId());
            }
            else {
                NetworkPlayerInfo lllllllllllllIlIIllIIIlIlllIllll = this.playerInfoMap.get(lllllllllllllIlIIllIIIlIllllIIII.getProfile().getId());
                if (lllllllllllllIlIIllIIIlIlllIllIl.getAction() == SPacketPlayerListItem.Action.ADD_PLAYER) {
                    lllllllllllllIlIIllIIIlIlllIllll = new NetworkPlayerInfo(lllllllllllllIlIIllIIIlIllllIIII);
                    this.playerInfoMap.put(lllllllllllllIlIIllIIIlIlllIllll.getGameProfile().getId(), lllllllllllllIlIIllIIIlIlllIllll);
                }
                if (lllllllllllllIlIIllIIIlIlllIllll == null) {
                    continue;
                }
                switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action()[lllllllllllllIlIIllIIIlIlllIllIl.getAction().ordinal()]) {
                    default: {
                        continue;
                    }
                    case 1: {
                        lllllllllllllIlIIllIIIlIlllIllll.setGameType(lllllllllllllIlIIllIIIlIllllIIII.getGameMode());
                        lllllllllllllIlIIllIIIlIlllIllll.setResponseTime(lllllllllllllIlIIllIIIlIllllIIII.getPing());
                        continue;
                    }
                    case 2: {
                        lllllllllllllIlIIllIIIlIlllIllll.setGameType(lllllllllllllIlIIllIIIlIllllIIII.getGameMode());
                        continue;
                    }
                    case 3: {
                        lllllllllllllIlIIllIIIlIlllIllll.setResponseTime(lllllllllllllIlIIllIIIlIllllIIII.getPing());
                        continue;
                    }
                    case 4: {
                        lllllllllllllIlIIllIIIlIlllIllll.setDisplayName(lllllllllllllIlIIllIIIlIllllIIII.getDisplayName());
                        continue;
                    }
                }
            }
        }
    }
    
    @Override
    public void handleBlockAction(final SPacketBlockAction lllllllllllllIlIIllIIIlllIlIlllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlllIlIlllI, this, this.gameController);
        this.gameController.world.addBlockEvent(lllllllllllllIlIIllIIIlllIlIlllI.getBlockPosition(), lllllllllllllIlIIllIIIlllIlIlllI.getBlockType(), lllllllllllllIlIIllIIIlllIlIlllI.getData1(), lllllllllllllIlIIllIIIlllIlIlllI.getData2());
    }
    
    @Override
    public void handleCooldown(final SPacketCooldown lllllllllllllIlIIllIIIlIlIIlIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIlIIlIIIl, this, this.gameController);
        if (lllllllllllllIlIIllIIIlIlIIlIIIl.getTicks() == 0) {
            this.gameController.player.getCooldownTracker().removeCooldown(lllllllllllllIlIIllIIIlIlIIlIIIl.getItem());
        }
        else {
            this.gameController.player.getCooldownTracker().setCooldown(lllllllllllllIlIIllIIIlIlIIlIIIl.getItem(), lllllllllllllIlIIllIIIlIlIIlIIIl.getTicks());
        }
    }
    
    @Override
    public void handleScoreboardObjective(final SPacketScoreboardObjective lllllllllllllIlIIllIIIlIIlIllIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIIlIllIIl, this, this.gameController);
        final Scoreboard lllllllllllllIlIIllIIIlIIlIlllIl = this.clientWorldController.getScoreboard();
        if (lllllllllllllIlIIllIIIlIIlIllIIl.getAction() == 0) {
            final ScoreObjective lllllllllllllIlIIllIIIlIIlIlllII = lllllllllllllIlIIllIIIlIIlIlllIl.addScoreObjective(lllllllllllllIlIIllIIIlIIlIllIIl.getObjectiveName(), IScoreCriteria.DUMMY);
            lllllllllllllIlIIllIIIlIIlIlllII.setDisplayName(lllllllllllllIlIIllIIIlIIlIllIIl.getObjectiveValue());
            lllllllllllllIlIIllIIIlIIlIlllII.setRenderType(lllllllllllllIlIIllIIIlIIlIllIIl.getRenderType());
        }
        else {
            final ScoreObjective lllllllllllllIlIIllIIIlIIlIllIll = lllllllllllllIlIIllIIIlIIlIlllIl.getObjective(lllllllllllllIlIIllIIIlIIlIllIIl.getObjectiveName());
            if (lllllllllllllIlIIllIIIlIIlIllIIl.getAction() == 1) {
                lllllllllllllIlIIllIIIlIIlIlllIl.removeObjective(lllllllllllllIlIIllIIIlIIlIllIll);
            }
            else if (lllllllllllllIlIIllIIIlIIlIllIIl.getAction() == 2) {
                lllllllllllllIlIIllIIIlIIlIllIll.setDisplayName(lllllllllllllIlIIllIIIlIIlIllIIl.getObjectiveValue());
                lllllllllllllIlIIllIIIlIIlIllIll.setRenderType(lllllllllllllIlIIllIIIlIIlIllIIl.getRenderType());
            }
        }
    }
    
    @Override
    public void handleMoveVehicle(final SPacketMoveVehicle lllllllllllllIlIIllIIIlIlIIIllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIlIIIllII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIIlIlIIIlIll = this.gameController.player.getLowestRidingEntity();
        if (lllllllllllllIlIIllIIIlIlIIIlIll != this.gameController.player && lllllllllllllIlIIllIIIlIlIIIlIll.canPassengerSteer()) {
            lllllllllllllIlIIllIIIlIlIIIlIll.setPositionAndRotation(lllllllllllllIlIIllIIIlIlIIIllII.getX(), lllllllllllllIlIIllIIIlIlIIIllII.getY(), lllllllllllllIlIIllIIIlIlIIIllII.getZ(), lllllllllllllIlIIllIIIlIlIIIllII.getYaw(), lllllllllllllIlIIllIIIlIlIIIllII.getPitch());
            this.netManager.sendPacket(new CPacketVehicleMove(lllllllllllllIlIIllIIIlIlIIIlIll));
        }
    }
    
    @Override
    public void handleUseBed(final SPacketUseBed lllllllllllllIlIIllIIlIIlIIllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIlIIllllI, this, this.gameController);
        lllllllllllllIlIIllIIlIIlIIllllI.getPlayer(this.clientWorldController).trySleep(lllllllllllllIlIIllIIlIIlIIllllI.getBedPosition());
    }
    
    @Override
    public void handleSpawnGlobalEntity(final SPacketSpawnGlobalEntity lllllllllllllIlIIllIIlIllIlIlIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIllIlIlIII, this, this.gameController);
        final double lllllllllllllIlIIllIIlIllIlIIlll = lllllllllllllIlIIllIIlIllIlIlIII.getX();
        final double lllllllllllllIlIIllIIlIllIlIIllI = lllllllllllllIlIIllIIlIllIlIlIII.getY();
        final double lllllllllllllIlIIllIIlIllIlIIlIl = lllllllllllllIlIIllIIlIllIlIlIII.getZ();
        Entity lllllllllllllIlIIllIIlIllIlIIlII = null;
        if (lllllllllllllIlIIllIIlIllIlIlIII.getType() == 1) {
            lllllllllllllIlIIllIIlIllIlIIlII = new EntityLightningBolt(this.clientWorldController, lllllllllllllIlIIllIIlIllIlIIlll, lllllllllllllIlIIllIIlIllIlIIllI, lllllllllllllIlIIllIIlIllIlIIlIl, false);
        }
        if (lllllllllllllIlIIllIIlIllIlIIlII != null) {
            EntityTracker.updateServerPosition(lllllllllllllIlIIllIIlIllIlIIlII, lllllllllllllIlIIllIIlIllIlIIlll, lllllllllllllIlIIllIIlIllIlIIllI, lllllllllllllIlIIllIIlIllIlIIlIl);
            lllllllllllllIlIIllIIlIllIlIIlII.rotationYaw = 0.0f;
            lllllllllllllIlIIllIIlIllIlIIlII.rotationPitch = 0.0f;
            lllllllllllllIlIIllIIlIllIlIIlII.setEntityId(lllllllllllllIlIIllIIlIllIlIlIII.getEntityId());
            this.clientWorldController.addWeatherEffect(lllllllllllllIlIIllIIlIllIlIIlII);
        }
    }
    
    @Override
    public void handlePlayerAbilities(final SPacketPlayerAbilities lllllllllllllIlIIllIIIlIllIlllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIllIlllII, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIIlIllIllllI = this.gameController.player;
        lllllllllllllIlIIllIIIlIllIllllI.capabilities.isFlying = lllllllllllllIlIIllIIIlIllIlllII.isFlying();
        lllllllllllllIlIIllIIIlIllIllllI.capabilities.isCreativeMode = lllllllllllllIlIIllIIIlIllIlllII.isCreativeMode();
        lllllllllllllIlIIllIIIlIllIllllI.capabilities.disableDamage = lllllllllllllIlIIllIIIlIllIlllII.isInvulnerable();
        lllllllllllllIlIIllIIIlIllIllllI.capabilities.allowFlying = lllllllllllllIlIIllIIIlIllIlllII.isAllowFlying();
        lllllllllllllIlIIllIIIlIllIllllI.capabilities.setFlySpeed(lllllllllllllIlIIllIIIlIllIlllII.getFlySpeed());
        lllllllllllllIlIIllIIIlIllIllllI.capabilities.setPlayerWalkSpeed(lllllllllllllIlIIllIIIlIllIlllII.getWalkSpeed());
    }
    
    @Override
    public void handleEntityEffect(final SPacketEntityEffect lllllllllllllIlIIllIIIllIIllllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIIllllll, this, this.gameController);
        final Entity lllllllllllllIlIIllIIIllIIlllllI = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIIllIIllllll.getEntityId());
        if (lllllllllllllIlIIllIIIllIIlllllI instanceof EntityLivingBase) {
            final Potion lllllllllllllIlIIllIIIllIIllllIl = Potion.getPotionById(lllllllllllllIlIIllIIIllIIllllll.getEffectId());
            if (lllllllllllllIlIIllIIIllIIllllIl != null) {
                final PotionEffect lllllllllllllIlIIllIIIllIIllllII = new PotionEffect(lllllllllllllIlIIllIIIllIIllllIl, lllllllllllllIlIIllIIIllIIllllll.getDuration(), lllllllllllllIlIIllIIIllIIllllll.getAmplifier(), lllllllllllllIlIIllIIIllIIllllll.getIsAmbient(), lllllllllllllIlIIllIIIllIIllllll.doesShowParticles());
                lllllllllllllIlIIllIIIllIIllllII.setPotionDurationMax(lllllllllllllIlIIllIIIllIIllllll.isMaxDuration());
                ((EntityLivingBase)lllllllllllllIlIIllIIIllIIlllllI).addPotionEffect(lllllllllllllIlIIllIIIllIIllllII);
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketTitle$Type = NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketTitle$Type != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketTitle$Type;
        }
        final double lllllllllllllIlIIllIIIIllIlllIIl = (Object)new int[SPacketTitle.Type.values().length];
        try {
            lllllllllllllIlIIllIIIIllIlllIIl[SPacketTitle.Type.ACTIONBAR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIIIIllIlllIIl[SPacketTitle.Type.CLEAR.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIIIIllIlllIIl[SPacketTitle.Type.RESET.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIllIIIIllIlllIIl[SPacketTitle.Type.SUBTITLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIIllIIIIllIlllIIl[SPacketTitle.Type.TIMES.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlIIllIIIIllIlllIIl[SPacketTitle.Type.TITLE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type = (int[])(Object)lllllllllllllIlIIllIIIIllIlllIIl;
    }
    
    @Override
    public void handleSignEditorOpen(final SPacketSignEditorOpen lllllllllllllIlIIllIIIllllIlllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllllIlllII, this, this.gameController);
        TileEntity lllllllllllllIlIIllIIIllllIllllI = this.clientWorldController.getTileEntity(lllllllllllllIlIIllIIIllllIlllII.getSignPosition());
        if (!(lllllllllllllIlIIllIIIllllIllllI instanceof TileEntitySign)) {
            lllllllllllllIlIIllIIIllllIllllI = new TileEntitySign();
            lllllllllllllIlIIllIIIllllIllllI.setWorldObj(this.clientWorldController);
            lllllllllllllIlIIllIIIllllIllllI.setPos(lllllllllllllIlIIllIIIllllIlllII.getSignPosition());
        }
        this.gameController.player.openEditSign((TileEntitySign)lllllllllllllIlIIllIIIllllIllllI);
    }
    
    @Override
    public void handleCamera(final SPacketCamera lllllllllllllIlIIllIIIllIIlIIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIIlIIIII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIIllIIlIIIlI = lllllllllllllIlIIllIIIllIIlIIIII.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIIIllIIlIIIlI != null) {
            this.gameController.setRenderViewEntity(lllllllllllllIlIIllIIIllIIlIIIlI);
        }
    }
    
    @Override
    public void processChunkUnload(final SPacketUnloadChunk lllllllllllllIlIIllIIlIIllIlllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIllIlllII, this, this.gameController);
        this.clientWorldController.doPreChunk(lllllllllllllIlIIllIIlIIllIlllII.getX(), lllllllllllllIlIIllIIlIIllIlllII.getZ(), false);
    }
    
    @Override
    public void handleSetPassengers(final SPacketSetPassengers lllllllllllllIlIIllIIlIIIlIllIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIlIllIIl, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIIIlIllllI = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIIIlIllIIl.getEntityId());
        if (lllllllllllllIlIIllIIlIIIlIllllI == null) {
            NetHandlerPlayClient.LOGGER.warn("Received passengers for unknown entity");
        }
        else {
            final boolean lllllllllllllIlIIllIIlIIIlIlllIl = lllllllllllllIlIIllIIlIIIlIllllI.isRidingOrBeingRiddenBy(this.gameController.player);
            lllllllllllllIlIIllIIlIIIlIllllI.removePassengers();
            final String lllllllllllllIlIIllIIlIIIlIlIIll;
            final float lllllllllllllIlIIllIIlIIIlIlIlII = ((int[])(Object)(lllllllllllllIlIIllIIlIIIlIlIIll = (String)(Object)lllllllllllllIlIIllIIlIIIlIllIIl.getPassengerIds())).length;
            for (byte lllllllllllllIlIIllIIlIIIlIlIlIl = 0; lllllllllllllIlIIllIIlIIIlIlIlIl < lllllllllllllIlIIllIIlIIIlIlIlII; ++lllllllllllllIlIIllIIlIIIlIlIlIl) {
                final int lllllllllllllIlIIllIIlIIIlIlllII = lllllllllllllIlIIllIIlIIIlIlIIll[lllllllllllllIlIIllIIlIIIlIlIlIl];
                final Entity lllllllllllllIlIIllIIlIIIlIllIll = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIIIlIlllII);
                if (lllllllllllllIlIIllIIlIIIlIllIll != null) {
                    lllllllllllllIlIIllIIlIIIlIllIll.startRiding(lllllllllllllIlIIllIIlIIIlIllllI, true);
                    if (lllllllllllllIlIIllIIlIIIlIllIll == this.gameController.player && !lllllllllllllIlIIllIIlIIIlIlllIl) {
                        this.gameController.ingameGUI.setRecordPlaying(I18n.format("mount.onboard", GameSettings.getKeyDisplayString(this.gameController.gameSettings.keyBindSneak.getKeyCode())), false);
                    }
                }
            }
        }
    }
    
    @Override
    public void handleDisconnect(final SPacketDisconnect lllllllllllllIlIIllIIlIIllIlIIII) {
        this.netManager.closeChannel(lllllllllllllIlIIllIIlIIllIlIIII.getReason());
    }
    
    public NetworkPlayerInfo getPlayerInfo(final UUID lllllllllllllIlIIllIIIIlllIIlllI) {
        return this.playerInfoMap.get(lllllllllllllIlIIllIIIIlllIIlllI);
    }
    
    @Override
    public void handlePlayerPosLook(final SPacketPlayerPosLook lllllllllllllIlIIllIIlIlIIIlIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIlIIIlIIll, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIlIlIIIlIIlI = this.gameController.player;
        double lllllllllllllIlIIllIIlIlIIIlIIIl = lllllllllllllIlIIllIIlIlIIIlIIll.getX();
        double lllllllllllllIlIIllIIlIlIIIlIIII = lllllllllllllIlIIllIIlIlIIIlIIll.getY();
        double lllllllllllllIlIIllIIlIlIIIIllll = lllllllllllllIlIIllIIlIlIIIlIIll.getZ();
        float lllllllllllllIlIIllIIlIlIIIIlllI = lllllllllllllIlIIllIIlIlIIIlIIll.getYaw();
        float lllllllllllllIlIIllIIlIlIIIIllIl = lllllllllllllIlIIllIIlIlIIIlIIll.getPitch();
        if (lllllllllllllIlIIllIIlIlIIIlIIll.getFlags().contains(SPacketPlayerPosLook.EnumFlags.X)) {
            lllllllllllllIlIIllIIlIlIIIlIIIl += lllllllllllllIlIIllIIlIlIIIlIIlI.posX;
        }
        else {
            lllllllllllllIlIIllIIlIlIIIlIIlI.motionX = 0.0;
        }
        if (lllllllllllllIlIIllIIlIlIIIlIIll.getFlags().contains(SPacketPlayerPosLook.EnumFlags.Y)) {
            lllllllllllllIlIIllIIlIlIIIlIIII += lllllllllllllIlIIllIIlIlIIIlIIlI.posY;
        }
        else {
            lllllllllllllIlIIllIIlIlIIIlIIlI.motionY = 0.0;
        }
        if (lllllllllllllIlIIllIIlIlIIIlIIll.getFlags().contains(SPacketPlayerPosLook.EnumFlags.Z)) {
            lllllllllllllIlIIllIIlIlIIIIllll += lllllllllllllIlIIllIIlIlIIIlIIlI.posZ;
        }
        else {
            lllllllllllllIlIIllIIlIlIIIlIIlI.motionZ = 0.0;
        }
        if (lllllllllllllIlIIllIIlIlIIIlIIll.getFlags().contains(SPacketPlayerPosLook.EnumFlags.X_ROT)) {
            lllllllllllllIlIIllIIlIlIIIIllIl += lllllllllllllIlIIllIIlIlIIIlIIlI.rotationPitch;
        }
        if (lllllllllllllIlIIllIIlIlIIIlIIll.getFlags().contains(SPacketPlayerPosLook.EnumFlags.Y_ROT)) {
            lllllllllllllIlIIllIIlIlIIIIlllI += lllllllllllllIlIIllIIlIlIIIlIIlI.rotationYaw;
        }
        lllllllllllllIlIIllIIlIlIIIlIIlI.setPositionAndRotation(lllllllllllllIlIIllIIlIlIIIlIIIl, lllllllllllllIlIIllIIlIlIIIlIIII, lllllllllllllIlIIllIIlIlIIIIllll, lllllllllllllIlIIllIIlIlIIIIlllI, lllllllllllllIlIIllIIlIlIIIIllIl);
        this.netManager.sendPacket(new CPacketConfirmTeleport(lllllllllllllIlIIllIIlIlIIIlIIll.getTeleportId()));
        this.netManager.sendPacket(new CPacketPlayer.PositionRotation(lllllllllllllIlIIllIIlIlIIIlIIlI.posX, lllllllllllllIlIIllIIlIlIIIlIIlI.getEntityBoundingBox().minY, lllllllllllllIlIIllIIlIlIIIlIIlI.posZ, lllllllllllllIlIIllIIlIlIIIlIIlI.rotationYaw, lllllllllllllIlIIllIIlIlIIIlIIlI.rotationPitch, false));
        if (!this.doneLoadingTerrain) {
            this.gameController.player.prevPosX = this.gameController.player.posX;
            this.gameController.player.prevPosY = this.gameController.player.posY;
            this.gameController.player.prevPosZ = this.gameController.player.posZ;
            this.doneLoadingTerrain = true;
            this.gameController.displayGuiScreen(null);
        }
    }
    
    @Override
    public void handleSpawnObject(final SPacketSpawnObject lllllllllllllIlIIllIIlIlllIlIlll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIlllIlIlll, this, this.gameController);
        final double lllllllllllllIlIIllIIlIlllIlIllI = lllllllllllllIlIIllIIlIlllIlIlll.getX();
        final double lllllllllllllIlIIllIIlIlllIlIlIl = lllllllllllllIlIIllIIlIlllIlIlll.getY();
        final double lllllllllllllIlIIllIIlIlllIlIlII = lllllllllllllIlIIllIIlIlllIlIlll.getZ();
        Entity lllllllllllllIlIIllIIlIlllIlIIll = null;
        if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 10) {
            lllllllllllllIlIIllIIlIlllIlIIll = EntityMinecart.create(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, EntityMinecart.Type.getById(lllllllllllllIlIIllIIlIlllIlIlll.getData()));
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 90) {
            final Entity lllllllllllllIlIIllIIlIlllIlIIlI = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIlllIlIlll.getData());
            if (lllllllllllllIlIIllIIlIlllIlIIlI instanceof EntityPlayer) {
                lllllllllllllIlIIllIIlIlllIlIIll = new EntityFishHook(this.clientWorldController, (EntityPlayer)lllllllllllllIlIIllIIlIlllIlIIlI, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
            }
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 60) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityTippedArrow(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 91) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntitySpectralArrow(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 61) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntitySnowball(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 68) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityLlamaSpit(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedX() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedY() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedZ() / 8000.0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 71) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityItemFrame(this.clientWorldController, new BlockPos(lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII), EnumFacing.getHorizontal(lllllllllllllIlIIllIIlIlllIlIlll.getData()));
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 77) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityLeashKnot(this.clientWorldController, new BlockPos(MathHelper.floor(lllllllllllllIlIIllIIlIlllIlIllI), MathHelper.floor(lllllllllllllIlIIllIIlIlllIlIlIl), MathHelper.floor(lllllllllllllIlIIllIIlIlllIlIlII)));
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 65) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityEnderPearl(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 72) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityEnderEye(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 76) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityFireworkRocket(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, ItemStack.field_190927_a);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 63) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityLargeFireball(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedX() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedY() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 93) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityDragonFireball(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedX() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedY() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 64) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntitySmallFireball(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedX() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedY() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 66) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityWitherSkull(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedX() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedY() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 67) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityShulkerBullet(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedX() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedY() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 62) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityEgg(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 79) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityEvokerFangs(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, 0.0f, 0, null);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 73) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityPotion(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, ItemStack.field_190927_a);
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 75) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityExpBottle(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 1) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityBoat(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 50) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityTNTPrimed(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, null);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 78) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityArmorStand(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 51) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityEnderCrystal(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 2) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityItem(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 70) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityFallingBlock(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII, Block.getStateById(lllllllllllllIlIIllIIlIlllIlIlll.getData() & 0xFFFF));
            lllllllllllllIlIIllIIlIlllIlIlll.setData(0);
        }
        else if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 3) {
            lllllllllllllIlIIllIIlIlllIlIIll = new EntityAreaEffectCloud(this.clientWorldController, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
        }
        if (lllllllllllllIlIIllIIlIlllIlIIll != null) {
            EntityTracker.updateServerPosition(lllllllllllllIlIIllIIlIlllIlIIll, lllllllllllllIlIIllIIlIlllIlIllI, lllllllllllllIlIIllIIlIlllIlIlIl, lllllllllllllIlIIllIIlIlllIlIlII);
            lllllllllllllIlIIllIIlIlllIlIIll.rotationPitch = lllllllllllllIlIIllIIlIlllIlIlll.getPitch() * 360 / 256.0f;
            lllllllllllllIlIIllIIlIlllIlIIll.rotationYaw = lllllllllllllIlIIllIIlIlllIlIlll.getYaw() * 360 / 256.0f;
            final Entity[] lllllllllllllIlIIllIIlIlllIlIIIl = lllllllllllllIlIIllIIlIlllIlIIll.getParts();
            if (lllllllllllllIlIIllIIlIlllIlIIIl != null) {
                final int lllllllllllllIlIIllIIlIlllIlIIII = lllllllllllllIlIIllIIlIlllIlIlll.getEntityID() - lllllllllllllIlIIllIIlIlllIlIIll.getEntityId();
                final int lllllllllllllIlIIllIIlIlllIIIIlI;
                final Exception lllllllllllllIlIIllIIlIlllIIIIll = (Exception)((Entity[])(Object)(lllllllllllllIlIIllIIlIlllIIIIlI = (int)(Object)lllllllllllllIlIIllIIlIlllIlIIIl)).length;
                for (char lllllllllllllIlIIllIIlIlllIIIlII = '\0'; lllllllllllllIlIIllIIlIlllIIIlII < lllllllllllllIlIIllIIlIlllIIIIll; ++lllllllllllllIlIIllIIlIlllIIIlII) {
                    final Entity lllllllllllllIlIIllIIlIlllIIllll = lllllllllllllIlIIllIIlIlllIIIIlI[lllllllllllllIlIIllIIlIlllIIIlII];
                    lllllllllllllIlIIllIIlIlllIIllll.setEntityId(lllllllllllllIlIIllIIlIlllIIllll.getEntityId() + lllllllllllllIlIIllIIlIlllIlIIII);
                }
            }
            lllllllllllllIlIIllIIlIlllIlIIll.setEntityId(lllllllllllllIlIIllIIlIlllIlIlll.getEntityID());
            lllllllllllllIlIIllIIlIlllIlIIll.setUniqueId(lllllllllllllIlIIllIIlIlllIlIlll.getUniqueId());
            this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIIlIlllIlIlll.getEntityID(), lllllllllllllIlIIllIIlIlllIlIIll);
            if (lllllllllllllIlIIllIIlIlllIlIlll.getData() > 0) {
                if (lllllllllllllIlIIllIIlIlllIlIlll.getType() == 60 || lllllllllllllIlIIllIIlIlllIlIlll.getType() == 91) {
                    final Entity lllllllllllllIlIIllIIlIlllIIlllI = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIlllIlIlll.getData() - 1);
                    if (lllllllllllllIlIIllIIlIlllIIlllI instanceof EntityLivingBase && lllllllllllllIlIIllIIlIlllIlIIll instanceof EntityArrow) {
                        ((EntityArrow)lllllllllllllIlIIllIIlIlllIlIIll).shootingEntity = lllllllllllllIlIIllIIlIlllIIlllI;
                    }
                }
                lllllllllllllIlIIllIIlIlllIlIIll.setVelocity(lllllllllllllIlIIllIIlIlllIlIlll.getSpeedX() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedY() / 8000.0, lllllllllllllIlIIllIIlIlllIlIlll.getSpeedZ() / 8000.0);
            }
        }
    }
    
    @Override
    public void handleResourcePack(final SPacketResourcePackSend lllllllllllllIlIIllIIIlIlIllIlIl) {
        final String lllllllllllllIlIIllIIIlIlIllllII = lllllllllllllIlIIllIIIlIlIllIlIl.getURL();
        final String lllllllllllllIlIIllIIIlIlIlllIll = lllllllllllllIlIIllIIIlIlIllIlIl.getHash();
        if (this.validateResourcePackUrl(lllllllllllllIlIIllIIIlIlIllllII)) {
            if (lllllllllllllIlIIllIIIlIlIllllII.startsWith("level://")) {
                try {
                    final String lllllllllllllIlIIllIIIlIlIlllIlI = URLDecoder.decode(lllllllllllllIlIIllIIIlIlIllllII.substring("level://".length()), StandardCharsets.UTF_8.toString());
                    final File lllllllllllllIlIIllIIIlIlIlllIIl = new File(this.gameController.mcDataDir, "saves");
                    final File lllllllllllllIlIIllIIIlIlIlllIII = new File(lllllllllllllIlIIllIIIlIlIlllIIl, lllllllllllllIlIIllIIIlIlIlllIlI);
                    if (lllllllllllllIlIIllIIIlIlIlllIII.isFile()) {
                        this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.ACCEPTED));
                        Futures.addCallback((ListenableFuture)this.gameController.getResourcePackRepository().setResourcePackInstance(lllllllllllllIlIIllIIIlIlIlllIII), (FutureCallback)this.createDownloadCallback());
                        return;
                    }
                }
                catch (UnsupportedEncodingException ex) {}
                this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.FAILED_DOWNLOAD));
            }
            else {
                final ServerData lllllllllllllIlIIllIIIlIlIllIlll = this.gameController.getCurrentServerData();
                if (lllllllllllllIlIIllIIIlIlIllIlll != null && lllllllllllllIlIIllIIIlIlIllIlll.getResourceMode() == ServerData.ServerResourceMode.ENABLED) {
                    this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.ACCEPTED));
                    Futures.addCallback((ListenableFuture)this.gameController.getResourcePackRepository().downloadResourcePack(lllllllllllllIlIIllIIIlIlIllllII, lllllllllllllIlIIllIIIlIlIlllIll), (FutureCallback)this.createDownloadCallback());
                }
                else if (lllllllllllllIlIIllIIIlIlIllIlll != null && lllllllllllllIlIIllIIIlIlIllIlll.getResourceMode() != ServerData.ServerResourceMode.PROMPT) {
                    this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.DECLINED));
                }
                else {
                    this.gameController.addScheduledTask(new Runnable() {
                        @Override
                        public void run() {
                            NetHandlerPlayClient.this.gameController.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
                                @Override
                                public void confirmClicked(final boolean lllllllllllIIIlIIIIllIIIIIIllIll, final int lllllllllllIIIlIIIIllIIIIIIllllI) {
                                    NetHandlerPlayClient.access$4(NetHandlerPlayClient.this, Minecraft.getMinecraft());
                                    final ServerData lllllllllllIIIlIIIIllIIIIIIlllIl = NetHandlerPlayClient.this.gameController.getCurrentServerData();
                                    if (lllllllllllIIIlIIIIllIIIIIIllIll) {
                                        if (lllllllllllIIIlIIIIllIIIIIIlllIl != null) {
                                            lllllllllllIIIlIIIIllIIIIIIlllIl.setResourceMode(ServerData.ServerResourceMode.ENABLED);
                                        }
                                        NetHandlerPlayClient.this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.ACCEPTED));
                                        Futures.addCallback((ListenableFuture)NetHandlerPlayClient.this.gameController.getResourcePackRepository().downloadResourcePack(lllllllllllllIlIIllIIIlIlIllllII, lllllllllllllIlIIllIIIlIlIlllIll), NetHandlerPlayClient.this.createDownloadCallback());
                                    }
                                    else {
                                        if (lllllllllllIIIlIIIIllIIIIIIlllIl != null) {
                                            lllllllllllIIIlIIIIllIIIIIIlllIl.setResourceMode(ServerData.ServerResourceMode.DISABLED);
                                        }
                                        NetHandlerPlayClient.this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.DECLINED));
                                    }
                                    ServerList.saveSingleServer(lllllllllllIIIlIIIIllIIIIIIlllIl);
                                    NetHandlerPlayClient.this.gameController.displayGuiScreen(null);
                                }
                            }, I18n.format("multiplayer.texturePrompt.line1", new Object[0]), I18n.format("multiplayer.texturePrompt.line2", new Object[0]), 0));
                        }
                    });
                }
            }
        }
    }
    
    @Override
    public void handleTabComplete(final SPacketTabComplete lllllllllllllIlIIllIIIlIllIlIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIllIlIIll, this, this.gameController);
        final String[] lllllllllllllIlIIllIIIlIllIlIlIl = lllllllllllllIlIIllIIIlIllIlIIll.getMatches();
        Arrays.sort(lllllllllllllIlIIllIIIlIllIlIlIl);
        if (this.gameController.currentScreen instanceof ITabCompleter) {
            ((ITabCompleter)this.gameController.currentScreen).setCompletions(lllllllllllllIlIIllIIIlIllIlIlIl);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void handleDestroyEntities(final SPacketDestroyEntities lllllllllllllIlIIllIIlIlIIIllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIlIIIllllI, this, this.gameController);
        for (int lllllllllllllIlIIllIIlIlIIlIIIII = 0; lllllllllllllIlIIllIIlIlIIlIIIII < lllllllllllllIlIIllIIlIlIIIllllI.getEntityIDs().length; ++lllllllllllllIlIIllIIlIlIIlIIIII) {
            this.clientWorldController.removeEntityFromWorld(lllllllllllllIlIIllIIlIlIIIllllI.getEntityIDs()[lllllllllllllIlIIllIIlIlIIlIIIII]);
        }
    }
    
    @Override
    public void handleCloseWindow(final SPacketCloseWindow lllllllllllllIlIIllIIIlllIllIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlllIllIllI, this, this.gameController);
        this.gameController.player.closeScreenAndDropStack();
    }
    
    @Override
    public void func_194307_a(final SPacketPlaceGhostRecipe lllllllllllllIlIIllIIIIllllIIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIIllllIIIII, this, this.gameController);
        final Container lllllllllllllIlIIllIIIIlllIlllll = this.gameController.player.openContainer;
        if (lllllllllllllIlIIllIIIIlllIlllll.windowId == lllllllllllllIlIIllIIIIllllIIIII.func_194313_b() && lllllllllllllIlIIllIIIIlllIlllll.getCanCraft(this.gameController.player) && this.gameController.currentScreen instanceof IRecipeShownListener) {
            final GuiRecipeBook lllllllllllllIlIIllIIIIlllIllllI = ((IRecipeShownListener)this.gameController.currentScreen).func_194310_f();
            lllllllllllllIlIIllIIIIlllIllllI.func_193951_a(lllllllllllllIlIIllIIIIllllIIIII.func_194311_a(), lllllllllllllIlIIllIIIIlllIlllll.inventorySlots);
        }
    }
    
    @Override
    public void handleParticles(final SPacketParticles lllllllllllllIlIIllIIIlIIIIIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIIIIIlIlI, this, this.gameController);
        if (lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleCount() == 0) {
            final double lllllllllllllIlIIllIIIlIIIIlIlll = lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleSpeed() * lllllllllllllIlIIllIIIlIIIIIlIlI.getXOffset();
            final double lllllllllllllIlIIllIIIlIIIIlIllI = lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleSpeed() * lllllllllllllIlIIllIIIlIIIIIlIlI.getYOffset();
            final double lllllllllllllIlIIllIIIlIIIIlIlIl = lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleSpeed() * lllllllllllllIlIIllIIIlIIIIIlIlI.getZOffset();
            try {
                this.clientWorldController.spawnParticle(lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleType(), lllllllllllllIlIIllIIIlIIIIIlIlI.isLongDistance(), lllllllllllllIlIIllIIIlIIIIIlIlI.getXCoordinate(), lllllllllllllIlIIllIIIlIIIIIlIlI.getYCoordinate(), lllllllllllllIlIIllIIIlIIIIIlIlI.getZCoordinate(), lllllllllllllIlIIllIIIlIIIIlIlll, lllllllllllllIlIIllIIIlIIIIlIllI, lllllllllllllIlIIllIIIlIIIIlIlIl, lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleArgs());
            }
            catch (Throwable lllllllllllllIlIIllIIIlIIIIlIlII) {
                NetHandlerPlayClient.LOGGER.warn("Could not spawn particle effect {}", (Object)lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleType());
            }
        }
        else {
            for (int lllllllllllllIlIIllIIIlIIIIlIIll = 0; lllllllllllllIlIIllIIIlIIIIlIIll < lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleCount(); ++lllllllllllllIlIIllIIIlIIIIlIIll) {
                final double lllllllllllllIlIIllIIIlIIIIlIIlI = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIIlIIIIIlIlI.getXOffset();
                final double lllllllllllllIlIIllIIIlIIIIlIIIl = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIIlIIIIIlIlI.getYOffset();
                final double lllllllllllllIlIIllIIIlIIIIlIIII = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIIlIIIIIlIlI.getZOffset();
                final double lllllllllllllIlIIllIIIlIIIIIllll = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleSpeed();
                final double lllllllllllllIlIIllIIIlIIIIIlllI = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleSpeed();
                final double lllllllllllllIlIIllIIIlIIIIIllIl = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleSpeed();
                try {
                    this.clientWorldController.spawnParticle(lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleType(), lllllllllllllIlIIllIIIlIIIIIlIlI.isLongDistance(), lllllllllllllIlIIllIIIlIIIIIlIlI.getXCoordinate() + lllllllllllllIlIIllIIIlIIIIlIIlI, lllllllllllllIlIIllIIIlIIIIIlIlI.getYCoordinate() + lllllllllllllIlIIllIIIlIIIIlIIIl, lllllllllllllIlIIllIIIlIIIIIlIlI.getZCoordinate() + lllllllllllllIlIIllIIIlIIIIlIIII, lllllllllllllIlIIllIIIlIIIIIllll, lllllllllllllIlIIllIIIlIIIIIlllI, lllllllllllllIlIIllIIIlIIIIIllIl, lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleArgs());
                }
                catch (Throwable lllllllllllllIlIIllIIIlIIIIIllII) {
                    NetHandlerPlayClient.LOGGER.warn("Could not spawn particle effect {}", (Object)lllllllllllllIlIIllIIIlIIIIIlIlI.getParticleType());
                    return;
                }
            }
        }
    }
    
    @Override
    public void handleSetExperience(final SPacketSetExperience lllllllllllllIlIIllIIlIIIIlIlllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIIlIlllI, this, this.gameController);
        this.gameController.player.setXPStats(lllllllllllllIlIIllIIlIIIIlIlllI.getExperienceBar(), lllllllllllllIlIIllIIlIIIIlIlllI.getTotalExperience(), lllllllllllllIlIIllIIlIIIIlIlllI.getLevel());
    }
    
    @Override
    public void handleExplosion(final SPacketExplosion lllllllllllllIlIIllIIlIIIIIlllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIIIlllIl, this, this.gameController);
        final Explosion lllllllllllllIlIIllIIlIIIIIlllll = new Explosion(this.gameController.world, null, lllllllllllllIlIIllIIlIIIIIlllIl.getX(), lllllllllllllIlIIllIIlIIIIIlllIl.getY(), lllllllllllllIlIIllIIlIIIIIlllIl.getZ(), lllllllllllllIlIIllIIlIIIIIlllIl.getStrength(), lllllllllllllIlIIllIIlIIIIIlllIl.getAffectedBlockPositions());
        lllllllllllllIlIIllIIlIIIIIlllll.doExplosionB(true);
        final EntityPlayerSP player = this.gameController.player;
        player.motionX += lllllllllllllIlIIllIIlIIIIIlllIl.getMotionX();
        final EntityPlayerSP player2 = this.gameController.player;
        player2.motionY += lllllllllllllIlIIllIIlIIIIIlllIl.getMotionY();
        final EntityPlayerSP player3 = this.gameController.player;
        player3.motionZ += lllllllllllllIlIIllIIlIIIIIlllIl.getMotionZ();
    }
    
    private FutureCallback<Object> createDownloadCallback() {
        return (FutureCallback<Object>)new FutureCallback<Object>() {
            public void onSuccess(@Nullable final Object lllllllllllllIlIllIlIIIIlllIIllI) {
                NetHandlerPlayClient.this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.SUCCESSFULLY_LOADED));
            }
            
            public void onFailure(final Throwable lllllllllllllIlIllIlIIIIlllIIIlI) {
                NetHandlerPlayClient.this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.FAILED_DOWNLOAD));
            }
        };
    }
    
    @Override
    public void handleEntityAttach(final SPacketEntityAttach lllllllllllllIlIIllIIlIIIlIIllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIlIIllII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIIIlIIlIll = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIIIlIIllII.getEntityId());
        final Entity lllllllllllllIlIIllIIlIIIlIIlIlI = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIIIlIIllII.getVehicleEntityId());
        if (lllllllllllllIlIIllIIlIIIlIIlIll instanceof EntityLiving) {
            if (lllllllllllllIlIIllIIlIIIlIIlIlI != null) {
                ((EntityLiving)lllllllllllllIlIIllIIlIIIlIIlIll).setLeashedToEntity(lllllllllllllIlIIllIIlIIIlIIlIlI, false);
            }
            else {
                ((EntityLiving)lllllllllllllIlIIllIIlIIIlIIlIll).clearLeashed(false, false);
            }
        }
    }
    
    @Override
    public void handleAnimation(final SPacketAnimation lllllllllllllIlIIllIIlIIlIlIllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIlIlIllII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIIlIlIlIll = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIIlIlIllII.getEntityID());
        if (lllllllllllllIlIIllIIlIIlIlIlIll != null) {
            if (lllllllllllllIlIIllIIlIIlIlIllII.getAnimationType() == 0) {
                final EntityLivingBase lllllllllllllIlIIllIIlIIlIlIlIlI = (EntityLivingBase)lllllllllllllIlIIllIIlIIlIlIlIll;
                lllllllllllllIlIIllIIlIIlIlIlIlI.swingArm(EnumHand.MAIN_HAND);
            }
            else if (lllllllllllllIlIIllIIlIIlIlIllII.getAnimationType() == 3) {
                final EntityLivingBase lllllllllllllIlIIllIIlIIlIlIlIIl = (EntityLivingBase)lllllllllllllIlIIllIIlIIlIlIlIll;
                lllllllllllllIlIIllIIlIIlIlIlIIl.swingArm(EnumHand.OFF_HAND);
            }
            else if (lllllllllllllIlIIllIIlIIlIlIllII.getAnimationType() == 1) {
                lllllllllllllIlIIllIIlIIlIlIlIll.performHurtAnimation();
            }
            else if (lllllllllllllIlIIllIIlIIlIlIllII.getAnimationType() == 2) {
                final EntityPlayer lllllllllllllIlIIllIIlIIlIlIlIII = (EntityPlayer)lllllllllllllIlIIllIIlIIlIlIlIll;
                lllllllllllllIlIIllIIlIIlIlIlIII.wakeUpPlayer(false, false, false);
            }
            else if (lllllllllllllIlIIllIIlIIlIlIllII.getAnimationType() == 4) {
                this.gameController.effectRenderer.emitParticleAtEntity(lllllllllllllIlIIllIIlIIlIlIlIll, EnumParticleTypes.CRIT);
            }
            else if (lllllllllllllIlIIllIIlIIlIlIllII.getAnimationType() == 5) {
                this.gameController.effectRenderer.emitParticleAtEntity(lllllllllllllIlIIllIIlIIlIlIlIll, EnumParticleTypes.CRIT_MAGIC);
            }
        }
    }
    
    @Nullable
    public NetworkPlayerInfo getPlayerInfo(final String lllllllllllllIlIIllIIIIlllIIIlIl) {
        for (final NetworkPlayerInfo lllllllllllllIlIIllIIIIlllIIIlll : this.playerInfoMap.values()) {
            if (lllllllllllllIlIIllIIIIlllIIIlll.getGameProfile().getName().equals(lllllllllllllIlIIllIIIIlllIIIlIl)) {
                return lllllllllllllIlIIllIIIIlllIIIlll;
            }
        }
        return null;
    }
    
    @Override
    public void handleTeams(final SPacketTeams lllllllllllllIlIIllIIIlIIIlIlIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIIIlIlIll, this, this.gameController);
        final Scoreboard lllllllllllllIlIIllIIIlIIIllIIll = this.clientWorldController.getScoreboard();
        ScorePlayerTeam lllllllllllllIlIIllIIIlIIIllIIIl = null;
        if (lllllllllllllIlIIllIIIlIIIlIlIll.getAction() == 0) {
            final ScorePlayerTeam lllllllllllllIlIIllIIIlIIIllIIlI = lllllllllllllIlIIllIIIlIIIllIIll.createTeam(lllllllllllllIlIIllIIIlIIIlIlIll.getName());
        }
        else {
            lllllllllllllIlIIllIIIlIIIllIIIl = lllllllllllllIlIIllIIIlIIIllIIll.getTeam(lllllllllllllIlIIllIIIlIIIlIlIll.getName());
        }
        if (lllllllllllllIlIIllIIIlIIIlIlIll.getAction() == 0 || lllllllllllllIlIIllIIIlIIIlIlIll.getAction() == 2) {
            lllllllllllllIlIIllIIIlIIIllIIIl.setTeamName(lllllllllllllIlIIllIIIlIIIlIlIll.getDisplayName());
            lllllllllllllIlIIllIIIlIIIllIIIl.setNamePrefix(lllllllllllllIlIIllIIIlIIIlIlIll.getPrefix());
            lllllllllllllIlIIllIIIlIIIllIIIl.setNameSuffix(lllllllllllllIlIIllIIIlIIIlIlIll.getSuffix());
            lllllllllllllIlIIllIIIlIIIllIIIl.setChatFormat(TextFormatting.fromColorIndex(lllllllllllllIlIIllIIIlIIIlIlIll.getColor()));
            lllllllllllllIlIIllIIIlIIIllIIIl.setFriendlyFlags(lllllllllllllIlIIllIIIlIIIlIlIll.getFriendlyFlags());
            final Team.EnumVisible lllllllllllllIlIIllIIIlIIIllIIII = Team.EnumVisible.getByName(lllllllllllllIlIIllIIIlIIIlIlIll.getNameTagVisibility());
            if (lllllllllllllIlIIllIIIlIIIllIIII != null) {
                lllllllllllllIlIIllIIIlIIIllIIIl.setNameTagVisibility(lllllllllllllIlIIllIIIlIIIllIIII);
            }
            final Team.CollisionRule lllllllllllllIlIIllIIIlIIIlIllll = Team.CollisionRule.getByName(lllllllllllllIlIIllIIIlIIIlIlIll.getCollisionRule());
            if (lllllllllllllIlIIllIIIlIIIlIllll != null) {
                lllllllllllllIlIIllIIIlIIIllIIIl.setCollisionRule(lllllllllllllIlIIllIIIlIIIlIllll);
            }
        }
        if (lllllllllllllIlIIllIIIlIIIlIlIll.getAction() == 0 || lllllllllllllIlIIllIIIlIIIlIlIll.getAction() == 3) {
            for (final String lllllllllllllIlIIllIIIlIIIlIlllI : lllllllllllllIlIIllIIIlIIIlIlIll.getPlayers()) {
                lllllllllllllIlIIllIIIlIIIllIIll.addPlayerToTeam(lllllllllllllIlIIllIIIlIIIlIlllI, lllllllllllllIlIIllIIIlIIIlIlIll.getName());
            }
        }
        if (lllllllllllllIlIIllIIIlIIIlIlIll.getAction() == 4) {
            for (final String lllllllllllllIlIIllIIIlIIIlIllIl : lllllllllllllIlIIllIIIlIIIlIlIll.getPlayers()) {
                lllllllllllllIlIIllIIIlIIIllIIll.removePlayerFromTeam(lllllllllllllIlIIllIIIlIIIlIllIl, lllllllllllllIlIIllIIIlIIIllIIIl);
            }
        }
        if (lllllllllllllIlIIllIIIlIIIlIlIll.getAction() == 1) {
            lllllllllllllIlIIllIIIlIIIllIIll.removeTeam(lllllllllllllIlIIllIIIlIIIllIIIl);
        }
    }
    
    @Override
    public void handleCombatEvent(final SPacketCombatEvent lllllllllllllIlIIllIIIllIIllIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllIIllIIlI, this, this.gameController);
        if (lllllllllllllIlIIllIIIllIIllIIlI.eventType == SPacketCombatEvent.Event.ENTITY_DIED) {
            final Entity lllllllllllllIlIIllIIIllIIllIIIl = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIIllIIllIIlI.playerId);
            if (lllllllllllllIlIIllIIIllIIllIIIl == this.gameController.player) {
                this.gameController.displayGuiScreen(new GuiGameOver(lllllllllllllIlIIllIIIllIIllIIlI.deathMessage));
            }
        }
    }
    
    @Override
    public void handleOpenWindow(final SPacketOpenWindow lllllllllllllIlIIllIIlIIIIIlIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIIIlIIIl, this, this.gameController);
        final EntityPlayerSP lllllllllllllIlIIllIIlIIIIIlIlIl = this.gameController.player;
        if ("minecraft:container".equals(lllllllllllllIlIIllIIlIIIIIlIIIl.getGuiId())) {
            lllllllllllllIlIIllIIlIIIIIlIlIl.displayGUIChest(new InventoryBasic(lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowTitle(), lllllllllllllIlIIllIIlIIIIIlIIIl.getSlotCount()));
            lllllllllllllIlIIllIIlIIIIIlIlIl.openContainer.windowId = lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowId();
        }
        else if ("minecraft:villager".equals(lllllllllllllIlIIllIIlIIIIIlIIIl.getGuiId())) {
            lllllllllllllIlIIllIIlIIIIIlIlIl.displayVillagerTradeGui(new NpcMerchant(lllllllllllllIlIIllIIlIIIIIlIlIl, lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowTitle()));
            lllllllllllllIlIIllIIlIIIIIlIlIl.openContainer.windowId = lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowId();
        }
        else if ("EntityHorse".equals(lllllllllllllIlIIllIIlIIIIIlIIIl.getGuiId())) {
            final Entity lllllllllllllIlIIllIIlIIIIIlIlII = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIIIIIlIIIl.getEntityId());
            if (lllllllllllllIlIIllIIlIIIIIlIlII instanceof AbstractHorse) {
                lllllllllllllIlIIllIIlIIIIIlIlIl.openGuiHorseInventory((AbstractHorse)lllllllllllllIlIIllIIlIIIIIlIlII, new ContainerHorseChest(lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowTitle(), lllllllllllllIlIIllIIlIIIIIlIIIl.getSlotCount()));
                lllllllllllllIlIIllIIlIIIIIlIlIl.openContainer.windowId = lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowId();
            }
        }
        else if (!lllllllllllllIlIIllIIlIIIIIlIIIl.hasSlots()) {
            lllllllllllllIlIIllIIlIIIIIlIlIl.displayGui(new LocalBlockIntercommunication(lllllllllllllIlIIllIIlIIIIIlIIIl.getGuiId(), lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowTitle()));
            lllllllllllllIlIIllIIlIIIIIlIlIl.openContainer.windowId = lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowId();
        }
        else {
            final IInventory lllllllllllllIlIIllIIlIIIIIlIIll = new ContainerLocalMenu(lllllllllllllIlIIllIIlIIIIIlIIIl.getGuiId(), lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowTitle(), lllllllllllllIlIIllIIlIIIIIlIIIl.getSlotCount());
            lllllllllllllIlIIllIIlIIIIIlIlIl.displayGUIChest(lllllllllllllIlIIllIIlIIIIIlIIll);
            lllllllllllllIlIIllIIlIIIIIlIlIl.openContainer.windowId = lllllllllllllIlIIllIIlIIIIIlIIIl.getWindowId();
        }
    }
    
    @Override
    public void handleEntityStatus(final SPacketEntityStatus lllllllllllllIlIIllIIlIIIlIIIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIIlIIIIII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIIIIllllll = lllllllllllllIlIIllIIlIIIlIIIIII.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIIlIIIIllllll != null) {
            if (lllllllllllllIlIIllIIlIIIlIIIIII.getOpCode() == 21) {
                this.gameController.getSoundHandler().playSound(new GuardianSound((EntityGuardian)lllllllllllllIlIIllIIlIIIIllllll));
            }
            else if (lllllllllllllIlIIllIIlIIIlIIIIII.getOpCode() == 35) {
                final int lllllllllllllIlIIllIIlIIIIlllllI = 40;
                this.gameController.effectRenderer.func_191271_a(lllllllllllllIlIIllIIlIIIIllllll, EnumParticleTypes.TOTEM, 30);
                this.clientWorldController.playSound(lllllllllllllIlIIllIIlIIIIllllll.posX, lllllllllllllIlIIllIIlIIIIllllll.posY, lllllllllllllIlIIllIIlIIIIllllll.posZ, SoundEvents.field_191263_gW, lllllllllllllIlIIllIIlIIIIllllll.getSoundCategory(), 1.0f, 1.0f, false);
                if (lllllllllllllIlIIllIIlIIIIllllll == this.gameController.player && (!NoRender.antiTotem.getBoolValue() || !Main.featureDirector.getFeatureByClass(NoRender.class).isToggled())) {
                    this.gameController.entityRenderer.func_190565_a(new ItemStack(Items.TOTEM_OF_UNDYING));
                }
            }
            else {
                lllllllllllllIlIIllIIlIIIIllllll.handleStatusUpdate(lllllllllllllIlIIllIIlIIIlIIIIII.getOpCode());
            }
        }
    }
    
    public void cleanup() {
        this.clientWorldController = null;
    }
    
    @Override
    public void handleHeldItemChange(final SPacketHeldItemChange lllllllllllllIlIIllIIlIlIlIIllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIlIlIIllII, this, this.gameController);
        if (InventoryPlayer.isHotbar(lllllllllllllIlIIllIIlIlIlIIllII.getHeldItemHotbarIndex())) {
            this.gameController.player.inventory.currentItem = lllllllllllllIlIIllIIlIlIlIIllII.getHeldItemHotbarIndex();
        }
    }
    
    @Override
    public void handleEntityEquipment(final SPacketEntityEquipment lllllllllllllIlIIllIIIlllIlllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlllIlllllI, this, this.gameController);
        final Entity lllllllllllllIlIIllIIIlllIllllIl = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIIlllIlllllI.getEntityID());
        if (lllllllllllllIlIIllIIIlllIllllIl != null) {
            lllllllllllllIlIIllIIIlllIllllIl.setItemStackToSlot(lllllllllllllIlIIllIIIlllIlllllI.getEquipmentSlot(), lllllllllllllIlIIllIIIlllIlllllI.getItemStack());
        }
    }
    
    @Override
    public void handleUpdateScore(final SPacketUpdateScore lllllllllllllIlIIllIIIlIIlIlIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIlIIlIlIIII, this, this.gameController);
        final Scoreboard lllllllllllllIlIIllIIIlIIlIIllll = this.clientWorldController.getScoreboard();
        final ScoreObjective lllllllllllllIlIIllIIIlIIlIIlllI = lllllllllllllIlIIllIIIlIIlIIllll.getObjective(lllllllllllllIlIIllIIIlIIlIlIIII.getObjectiveName());
        if (lllllllllllllIlIIllIIIlIIlIlIIII.getScoreAction() == SPacketUpdateScore.Action.CHANGE) {
            final Score lllllllllllllIlIIllIIIlIIlIIllIl = lllllllllllllIlIIllIIIlIIlIIllll.getOrCreateScore(lllllllllllllIlIIllIIIlIIlIlIIII.getPlayerName(), lllllllllllllIlIIllIIIlIIlIIlllI);
            lllllllllllllIlIIllIIIlIIlIIllIl.setScorePoints(lllllllllllllIlIIllIIIlIIlIlIIII.getScoreValue());
        }
        else if (lllllllllllllIlIIllIIIlIIlIlIIII.getScoreAction() == SPacketUpdateScore.Action.REMOVE) {
            if (StringUtils.isNullOrEmpty(lllllllllllllIlIIllIIIlIIlIlIIII.getObjectiveName())) {
                lllllllllllllIlIIllIIIlIIlIIllll.removeObjectiveFromEntity(lllllllllllllIlIIllIIIlIIlIlIIII.getPlayerName(), null);
            }
            else if (lllllllllllllIlIIllIIIlIIlIIlllI != null) {
                lllllllllllllIlIIllIIIlIIlIIllll.removeObjectiveFromEntity(lllllllllllllIlIIllIIIlIIlIlIIII.getPlayerName(), lllllllllllllIlIIllIIIlIIlIIlllI);
            }
        }
    }
    
    @Override
    public void handleChunkData(final SPacketChunkData lllllllllllllIlIIllIIlIIlllIIlll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIlllIIlll, this, this.gameController);
        if (lllllllllllllIlIIllIIlIIlllIIlll.doChunkLoad()) {
            this.clientWorldController.doPreChunk(lllllllllllllIlIIllIIlIIlllIIlll.getChunkX(), lllllllllllllIlIIllIIlIIlllIIlll.getChunkZ(), true);
        }
        this.clientWorldController.invalidateBlockReceiveRegion(lllllllllllllIlIIllIIlIIlllIIlll.getChunkX() << 4, 0, lllllllllllllIlIIllIIlIIlllIIlll.getChunkZ() << 4, (lllllllllllllIlIIllIIlIIlllIIlll.getChunkX() << 4) + 15, 256, (lllllllllllllIlIIllIIlIIlllIIlll.getChunkZ() << 4) + 15);
        final Chunk lllllllllllllIlIIllIIlIIlllIllII = this.clientWorldController.getChunkFromChunkCoords(lllllllllllllIlIIllIIlIIlllIIlll.getChunkX(), lllllllllllllIlIIllIIlIIlllIIlll.getChunkZ());
        lllllllllllllIlIIllIIlIIlllIllII.fillChunk(lllllllllllllIlIIllIIlIIlllIIlll.getReadBuffer(), lllllllllllllIlIIllIIlIIlllIIlll.getExtractedSize(), lllllllllllllIlIIllIIlIIlllIIlll.doChunkLoad());
        this.clientWorldController.markBlockRangeForRenderUpdate(lllllllllllllIlIIllIIlIIlllIIlll.getChunkX() << 4, 0, lllllllllllllIlIIllIIlIIlllIIlll.getChunkZ() << 4, (lllllllllllllIlIIllIIlIIlllIIlll.getChunkX() << 4) + 15, 256, (lllllllllllllIlIIllIIlIIlllIIlll.getChunkZ() << 4) + 15);
        if (!lllllllllllllIlIIllIIlIIlllIIlll.doChunkLoad() || !(this.clientWorldController.provider instanceof WorldProviderSurface)) {
            lllllllllllllIlIIllIIlIIlllIllII.resetRelightChecks();
        }
        for (final NBTTagCompound lllllllllllllIlIIllIIlIIlllIlIll : lllllllllllllIlIIllIIlIIlllIIlll.getTileEntityTags()) {
            final BlockPos lllllllllllllIlIIllIIlIIlllIlIlI = new BlockPos(lllllllllllllIlIIllIIlIIlllIlIll.getInteger("x"), lllllllllllllIlIIllIIlIIlllIlIll.getInteger("y"), lllllllllllllIlIIllIIlIIlllIlIll.getInteger("z"));
            final TileEntity lllllllllllllIlIIllIIlIIlllIlIIl = this.clientWorldController.getTileEntity(lllllllllllllIlIIllIIlIIlllIlIlI);
            if (lllllllllllllIlIIllIIlIIlllIlIIl != null) {
                lllllllllllllIlIIllIIlIIlllIlIIl.readFromNBT(lllllllllllllIlIIllIIlIIlllIlIll);
            }
        }
    }
    
    @Override
    public void handleUpdateTileEntity(final SPacketUpdateTileEntity lllllllllllllIlIIllIIIllllIIllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIIllllIIllll, this, this.gameController);
        if (this.gameController.world.isBlockLoaded(lllllllllllllIlIIllIIIllllIIllll.getPos())) {
            final TileEntity lllllllllllllIlIIllIIIllllIlIIll = this.gameController.world.getTileEntity(lllllllllllllIlIIllIIIllllIIllll.getPos());
            final int lllllllllllllIlIIllIIIllllIlIIlI = lllllllllllllIlIIllIIIllllIIllll.getTileEntityType();
            final boolean lllllllllllllIlIIllIIIllllIlIIIl = lllllllllllllIlIIllIIIllllIlIIlI == 2 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntityCommandBlock;
            if ((lllllllllllllIlIIllIIIllllIlIIlI == 1 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntityMobSpawner) || lllllllllllllIlIIllIIIllllIlIIIl || (lllllllllllllIlIIllIIIllllIlIIlI == 3 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntityBeacon) || (lllllllllllllIlIIllIIIllllIlIIlI == 4 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntitySkull) || (lllllllllllllIlIIllIIIllllIlIIlI == 5 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntityFlowerPot) || (lllllllllllllIlIIllIIIllllIlIIlI == 6 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntityBanner) || (lllllllllllllIlIIllIIIllllIlIIlI == 7 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntityStructure) || (lllllllllllllIlIIllIIIllllIlIIlI == 8 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntityEndGateway) || (lllllllllllllIlIIllIIIllllIlIIlI == 9 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntitySign) || (lllllllllllllIlIIllIIIllllIlIIlI == 10 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntityShulkerBox) || (lllllllllllllIlIIllIIIllllIlIIlI == 11 && lllllllllllllIlIIllIIIllllIlIIll instanceof TileEntityBed)) {
                lllllllllllllIlIIllIIIllllIlIIll.readFromNBT(lllllllllllllIlIIllIIIllllIIllll.getNbtCompound());
            }
            if (lllllllllllllIlIIllIIIllllIlIIIl && this.gameController.currentScreen instanceof GuiCommandBlock) {
                ((GuiCommandBlock)this.gameController.currentScreen).updateGui();
            }
        }
    }
    
    @Override
    public void handleCollectItem(final SPacketCollectItem lllllllllllllIlIIllIIlIIlIlllIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIIlIlllIlI, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIIlIllllIl = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIIlIlllIlI.getCollectedItemEntityID());
        EntityLivingBase lllllllllllllIlIIllIIlIIlIllllII = (EntityLivingBase)this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIIlIlllIlI.getEntityID());
        if (lllllllllllllIlIIllIIlIIlIllllII == null) {
            lllllllllllllIlIIllIIlIIlIllllII = this.gameController.player;
        }
        if (lllllllllllllIlIIllIIlIIlIllllIl != null) {
            if (lllllllllllllIlIIllIIlIIlIllllIl instanceof EntityXPOrb) {
                this.clientWorldController.playSound(lllllllllllllIlIIllIIlIIlIllllIl.posX, lllllllllllllIlIIllIIlIIlIllllIl.posY, lllllllllllllIlIIllIIlIIlIllllIl.posZ, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.1f, (this.avRandomizer.nextFloat() - this.avRandomizer.nextFloat()) * 0.35f + 0.9f, false);
            }
            else {
                this.clientWorldController.playSound(lllllllllllllIlIIllIIlIIlIllllIl.posX, lllllllllllllIlIIllIIlIIlIllllIl.posY, lllllllllllllIlIIllIIlIIlIllllIl.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2f, (this.avRandomizer.nextFloat() - this.avRandomizer.nextFloat()) * 1.4f + 2.0f, false);
            }
            if (lllllllllllllIlIIllIIlIIlIllllIl instanceof EntityItem) {
                ((EntityItem)lllllllllllllIlIIllIIlIIlIllllIl).getEntityItem().func_190920_e(lllllllllllllIlIIllIIlIIlIlllIlI.func_191208_c());
            }
            this.gameController.effectRenderer.addEffect(new ParticleItemPickup(this.clientWorldController, lllllllllllllIlIIllIIlIIlIllllIl, lllllllllllllIlIIllIIlIIlIllllII, 0.5f));
            this.clientWorldController.removeEntityFromWorld(lllllllllllllIlIIllIIlIIlIlllIlI.getCollectedItemEntityID());
        }
    }
    
    public Collection<NetworkPlayerInfo> getPlayerInfoMap() {
        return this.playerInfoMap.values();
    }
}
