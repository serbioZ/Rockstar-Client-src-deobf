// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network;

import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayerAbilities;
import net.minecraft.network.play.client.CPacketEnchantItem;
import net.minecraft.block.material.Material;
import java.util.Collections;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.server.SPacketKeepAlive;
import net.minecraft.advancements.Advancement;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.play.client.CPacketSeenAdvancements;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import java.util.Set;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.SPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.math.MathHelper;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.entity.item.EntityMinecartCommandBlock;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.item.ItemWrittenBook;
import java.io.IOException;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.network.play.client.CPacketCustomPayload;
import com.google.common.util.concurrent.Futures;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketClientSettings;
import net.minecraft.network.play.server.SPacketConfirmTransaction;
import net.minecraft.inventory.Slot;
import net.minecraft.util.NonNullList;
import net.minecraft.network.play.client.CPacketClickWindow;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Doubles;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.network.play.client.CPacketSpectate;
import net.minecraft.item.ItemElytra;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketResourcePackStatus;
import net.minecraft.util.ChatAllowedCharacters;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.network.play.client.CPacketUpdateSign;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.world.DimensionType;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketPlaceRecipe;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.CPacketCreativeInventoryAction;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import org.apache.logging.log4j.LogManager;
import net.minecraft.network.play.client.CPacketRecipeInfo;
import java.util.List;
import net.minecraft.network.play.server.SPacketTabComplete;
import net.minecraft.command.ICommandSender;
import com.google.common.collect.Lists;
import net.minecraft.network.play.client.CPacketTabComplete;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.init.MobEffects;
import net.minecraft.world.GameType;
import net.minecraft.entity.MoverType;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.WorldServer;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IThreadListener;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ServerRecipeBookHelper;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.IntHashMap;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.util.ITickable;

public class NetHandlerPlayServer implements ITickable, INetHandlerPlayServer
{
    private /* synthetic */ double lowestRiddenY1;
    private /* synthetic */ double lowestRiddenZ;
    private /* synthetic */ long field_194402_f;
    private final /* synthetic */ IntHashMap<Short> pendingTransactions;
    private /* synthetic */ double firstGoodY;
    private /* synthetic */ Vec3d targetPos;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action;
    private /* synthetic */ double lastGoodZ;
    private /* synthetic */ double lowestRiddenX;
    private /* synthetic */ int lastPositionUpdate;
    private /* synthetic */ int movePacketCounter;
    private /* synthetic */ int itemDropThreshold;
    private /* synthetic */ int teleportId;
    private /* synthetic */ int networkTickCount;
    private /* synthetic */ int lastMovePacketCounter;
    private /* synthetic */ boolean field_194403_g;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ int vehicleFloatingTickCount;
    private final /* synthetic */ MinecraftServer serverController;
    public final /* synthetic */ NetworkManager netManager;
    private /* synthetic */ double firstGoodX;
    private /* synthetic */ double lastGoodY;
    private /* synthetic */ ServerRecipeBookHelper field_194309_H;
    private /* synthetic */ double lastGoodX;
    private /* synthetic */ double firstGoodZ;
    private /* synthetic */ double lowestRiddenZ1;
    public /* synthetic */ EntityPlayerMP playerEntity;
    private /* synthetic */ boolean floating;
    private /* synthetic */ int floatingTickCount;
    private /* synthetic */ long field_194404_h;
    private /* synthetic */ boolean vehicleFloating;
    private /* synthetic */ double lowestRiddenX1;
    private /* synthetic */ int chatSpamThresholdCount;
    private /* synthetic */ Entity lowestRiddenEnt;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State;
    private /* synthetic */ double lowestRiddenY;
    
    @Override
    public void processRightClickBlock(final CPacketPlayerTryUseItemOnBlock llllllllllllllIIlIlllllIllIlllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIllIlllll, this, this.playerEntity.getServerWorld());
        final WorldServer llllllllllllllIIlIlllllIlllIIllI = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final EnumHand llllllllllllllIIlIlllllIlllIIlIl = llllllllllllllIIlIlllllIllIlllll.getHand();
        final ItemStack llllllllllllllIIlIlllllIlllIIlII = this.playerEntity.getHeldItem(llllllllllllllIIlIlllllIlllIIlIl);
        final BlockPos llllllllllllllIIlIlllllIlllIIIll = llllllllllllllIIlIlllllIllIlllll.getPos();
        final EnumFacing llllllllllllllIIlIlllllIlllIIIlI = llllllllllllllIIlIlllllIllIlllll.getDirection();
        this.playerEntity.markPlayerActive();
        if (llllllllllllllIIlIlllllIlllIIIll.getY() < this.serverController.getBuildLimit() - 1 || (llllllllllllllIIlIlllllIlllIIIlI != EnumFacing.UP && llllllllllllllIIlIlllllIlllIIIll.getY() < this.serverController.getBuildLimit())) {
            if (this.targetPos == null && this.playerEntity.getDistanceSq(llllllllllllllIIlIlllllIlllIIIll.getX() + 0.5, llllllllllllllIIlIlllllIlllIIIll.getY() + 0.5, llllllllllllllIIlIlllllIlllIIIll.getZ() + 0.5) < 64.0 && !this.serverController.isBlockProtected(llllllllllllllIIlIlllllIlllIIllI, llllllllllllllIIlIlllllIlllIIIll, this.playerEntity) && llllllllllllllIIlIlllllIlllIIllI.getWorldBorder().contains(llllllllllllllIIlIlllllIlllIIIll)) {
                this.playerEntity.interactionManager.processRightClickBlock(this.playerEntity, llllllllllllllIIlIlllllIlllIIllI, llllllllllllllIIlIlllllIlllIIlII, llllllllllllllIIlIlllllIlllIIlIl, llllllllllllllIIlIlllllIlllIIIll, llllllllllllllIIlIlllllIlllIIIlI, llllllllllllllIIlIlllllIllIlllll.getFacingX(), llllllllllllllIIlIlllllIllIlllll.getFacingY(), llllllllllllllIIlIlllllIllIlllll.getFacingZ());
            }
        }
        else {
            final TextComponentTranslation llllllllllllllIIlIlllllIlllIIIIl = new TextComponentTranslation("build.tooHigh", new Object[] { this.serverController.getBuildLimit() });
            llllllllllllllIIlIlllllIlllIIIIl.getStyle().setColor(TextFormatting.RED);
            this.playerEntity.connection.sendPacket(new SPacketChat(llllllllllllllIIlIlllllIlllIIIIl, ChatType.GAME_INFO));
        }
        this.playerEntity.connection.sendPacket(new SPacketBlockChange(llllllllllllllIIlIlllllIlllIIllI, llllllllllllllIIlIlllllIlllIIIll));
        this.playerEntity.connection.sendPacket(new SPacketBlockChange(llllllllllllllIIlIlllllIlllIIllI, llllllllllllllIIlIlllllIlllIIIll.offset(llllllllllllllIIlIlllllIlllIIIlI)));
    }
    
    @Override
    public void processPlayer(final CPacketPlayer llllllllllllllIIlIllllllIllIlIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIllllllIllIlIll, this, this.playerEntity.getServerWorld());
        if (isMovePlayerPacketInvalid(llllllllllllllIIlIllllllIllIlIll)) {
            this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.invalid_player_movement", new Object[0]));
        }
        else {
            final WorldServer llllllllllllllIIlIllllllIllIlIlI = this.serverController.worldServerForDimension(this.playerEntity.dimension);
            if (!this.playerEntity.playerConqueredTheEnd) {
                if (this.networkTickCount == 0) {
                    this.captureCurrentPosition();
                }
                if (this.targetPos != null) {
                    if (this.networkTickCount - this.lastPositionUpdate > 20) {
                        this.lastPositionUpdate = this.networkTickCount;
                        this.setPlayerLocation(this.targetPos.xCoord, this.targetPos.yCoord, this.targetPos.zCoord, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                    }
                }
                else {
                    this.lastPositionUpdate = this.networkTickCount;
                    if (this.playerEntity.isRiding()) {
                        this.playerEntity.setPositionAndRotation(this.playerEntity.posX, this.playerEntity.posY, this.playerEntity.posZ, llllllllllllllIIlIllllllIllIlIll.getYaw(this.playerEntity.rotationYaw), llllllllllllllIIlIllllllIllIlIll.getPitch(this.playerEntity.rotationPitch));
                        this.serverController.getPlayerList().serverUpdateMovingPlayer(this.playerEntity);
                    }
                    else {
                        final double llllllllllllllIIlIllllllIllIlIIl = this.playerEntity.posX;
                        final double llllllllllllllIIlIllllllIllIlIII = this.playerEntity.posY;
                        final double llllllllllllllIIlIllllllIllIIlll = this.playerEntity.posZ;
                        final double llllllllllllllIIlIllllllIllIIllI = this.playerEntity.posY;
                        final double llllllllllllllIIlIllllllIllIIlIl = llllllllllllllIIlIllllllIllIlIll.getX(this.playerEntity.posX);
                        final double llllllllllllllIIlIllllllIllIIlII = llllllllllllllIIlIllllllIllIlIll.getY(this.playerEntity.posY);
                        final double llllllllllllllIIlIllllllIllIIIll = llllllllllllllIIlIllllllIllIlIll.getZ(this.playerEntity.posZ);
                        final float llllllllllllllIIlIllllllIllIIIlI = llllllllllllllIIlIllllllIllIlIll.getYaw(this.playerEntity.rotationYaw);
                        final float llllllllllllllIIlIllllllIllIIIIl = llllllllllllllIIlIllllllIllIlIll.getPitch(this.playerEntity.rotationPitch);
                        double llllllllllllllIIlIllllllIllIIIII = llllllllllllllIIlIllllllIllIIlIl - this.firstGoodX;
                        double llllllllllllllIIlIllllllIlIlllll = llllllllllllllIIlIllllllIllIIlII - this.firstGoodY;
                        double llllllllllllllIIlIllllllIlIllllI = llllllllllllllIIlIllllllIllIIIll - this.firstGoodZ;
                        final double llllllllllllllIIlIllllllIlIlllIl = this.playerEntity.motionX * this.playerEntity.motionX + this.playerEntity.motionY * this.playerEntity.motionY + this.playerEntity.motionZ * this.playerEntity.motionZ;
                        double llllllllllllllIIlIllllllIlIlllII = llllllllllllllIIlIllllllIllIIIII * llllllllllllllIIlIllllllIllIIIII + llllllllllllllIIlIllllllIlIlllll * llllllllllllllIIlIllllllIlIlllll + llllllllllllllIIlIllllllIlIllllI * llllllllllllllIIlIllllllIlIllllI;
                        if (this.playerEntity.isPlayerSleeping()) {
                            if (llllllllllllllIIlIllllllIlIlllII > 1.0) {
                                this.setPlayerLocation(this.playerEntity.posX, this.playerEntity.posY, this.playerEntity.posZ, llllllllllllllIIlIllllllIllIlIll.getYaw(this.playerEntity.rotationYaw), llllllllllllllIIlIllllllIllIlIll.getPitch(this.playerEntity.rotationPitch));
                            }
                        }
                        else {
                            ++this.movePacketCounter;
                            int llllllllllllllIIlIllllllIlIllIll = this.movePacketCounter - this.lastMovePacketCounter;
                            if (llllllllllllllIIlIllllllIlIllIll > 5) {
                                NetHandlerPlayServer.LOGGER.debug("{} is sending move packets too frequently ({} packets since last tick)", (Object)this.playerEntity.getName(), (Object)llllllllllllllIIlIllllllIlIllIll);
                                llllllllllllllIIlIllllllIlIllIll = 1;
                            }
                            if (!this.playerEntity.isInvulnerableDimensionChange() && (!this.playerEntity.getServerWorld().getGameRules().getBoolean("disableElytraMovementCheck") || !this.playerEntity.isElytraFlying())) {
                                final float llllllllllllllIIlIllllllIlIllIlI = this.playerEntity.isElytraFlying() ? 300.0f : 100.0f;
                                if (llllllllllllllIIlIllllllIlIlllII - llllllllllllllIIlIllllllIlIlllIl > llllllllllllllIIlIllllllIlIllIlI * llllllllllllllIIlIllllllIlIllIll && (!this.serverController.isSinglePlayer() || !this.serverController.getServerOwner().equals(this.playerEntity.getName()))) {
                                    NetHandlerPlayServer.LOGGER.warn("{} moved too quickly! {},{},{}", (Object)this.playerEntity.getName(), (Object)llllllllllllllIIlIllllllIllIIIII, (Object)llllllllllllllIIlIllllllIlIlllll, (Object)llllllllllllllIIlIllllllIlIllllI);
                                    this.setPlayerLocation(this.playerEntity.posX, this.playerEntity.posY, this.playerEntity.posZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                                    return;
                                }
                            }
                            final boolean llllllllllllllIIlIllllllIlIllIIl = llllllllllllllIIlIllllllIllIlIlI.getCollisionBoxes(this.playerEntity, this.playerEntity.getEntityBoundingBox().contract(0.0625)).isEmpty();
                            llllllllllllllIIlIllllllIllIIIII = llllllllllllllIIlIllllllIllIIlIl - this.lastGoodX;
                            llllllllllllllIIlIllllllIlIlllll = llllllllllllllIIlIllllllIllIIlII - this.lastGoodY;
                            llllllllllllllIIlIllllllIlIllllI = llllllllllllllIIlIllllllIllIIIll - this.lastGoodZ;
                            if (this.playerEntity.onGround && !llllllllllllllIIlIllllllIllIlIll.isOnGround() && llllllllllllllIIlIllllllIlIlllll > 0.0) {
                                this.playerEntity.jump();
                            }
                            this.playerEntity.moveEntity(MoverType.PLAYER, llllllllllllllIIlIllllllIllIIIII, llllllllllllllIIlIllllllIlIlllll, llllllllllllllIIlIllllllIlIllllI);
                            this.playerEntity.onGround = llllllllllllllIIlIllllllIllIlIll.isOnGround();
                            final double llllllllllllllIIlIllllllIlIllIII = llllllllllllllIIlIllllllIlIlllll;
                            llllllllllllllIIlIllllllIllIIIII = llllllllllllllIIlIllllllIllIIlIl - this.playerEntity.posX;
                            llllllllllllllIIlIllllllIlIlllll = llllllllllllllIIlIllllllIllIIlII - this.playerEntity.posY;
                            if (llllllllllllllIIlIllllllIlIlllll > -0.5 || llllllllllllllIIlIllllllIlIlllll < 0.5) {
                                llllllllllllllIIlIllllllIlIlllll = 0.0;
                            }
                            llllllllllllllIIlIllllllIlIllllI = llllllllllllllIIlIllllllIllIIIll - this.playerEntity.posZ;
                            llllllllllllllIIlIllllllIlIlllII = llllllllllllllIIlIllllllIllIIIII * llllllllllllllIIlIllllllIllIIIII + llllllllllllllIIlIllllllIlIlllll * llllllllllllllIIlIllllllIlIlllll + llllllllllllllIIlIllllllIlIllllI * llllllllllllllIIlIllllllIlIllllI;
                            boolean llllllllllllllIIlIllllllIlIlIlll = false;
                            if (!this.playerEntity.isInvulnerableDimensionChange() && llllllllllllllIIlIllllllIlIlllII > 0.0625 && !this.playerEntity.isPlayerSleeping() && !this.playerEntity.interactionManager.isCreative() && this.playerEntity.interactionManager.getGameType() != GameType.SPECTATOR) {
                                llllllllllllllIIlIllllllIlIlIlll = true;
                                NetHandlerPlayServer.LOGGER.warn("{} moved wrongly!", (Object)this.playerEntity.getName());
                            }
                            this.playerEntity.setPositionAndRotation(llllllllllllllIIlIllllllIllIIlIl, llllllllllllllIIlIllllllIllIIlII, llllllllllllllIIlIllllllIllIIIll, llllllllllllllIIlIllllllIllIIIlI, llllllllllllllIIlIllllllIllIIIIl);
                            this.playerEntity.addMovementStat(this.playerEntity.posX - llllllllllllllIIlIllllllIllIlIIl, this.playerEntity.posY - llllllllllllllIIlIllllllIllIlIII, this.playerEntity.posZ - llllllllllllllIIlIllllllIllIIlll);
                            if (!this.playerEntity.noClip && !this.playerEntity.isPlayerSleeping()) {
                                final boolean llllllllllllllIIlIllllllIlIlIllI = llllllllllllllIIlIllllllIllIlIlI.getCollisionBoxes(this.playerEntity, this.playerEntity.getEntityBoundingBox().contract(0.0625)).isEmpty();
                                if (llllllllllllllIIlIllllllIlIllIIl && (llllllllllllllIIlIllllllIlIlIlll || !llllllllllllllIIlIllllllIlIlIllI)) {
                                    this.setPlayerLocation(llllllllllllllIIlIllllllIllIlIIl, llllllllllllllIIlIllllllIllIlIII, llllllllllllllIIlIllllllIllIIlll, llllllllllllllIIlIllllllIllIIIlI, llllllllllllllIIlIllllllIllIIIIl);
                                    return;
                                }
                            }
                            this.floating = (llllllllllllllIIlIllllllIlIllIII >= -0.03125);
                            this.floating &= (!this.serverController.isFlightAllowed() && !this.playerEntity.capabilities.allowFlying);
                            this.floating &= (!this.playerEntity.isPotionActive(MobEffects.LEVITATION) && !this.playerEntity.isElytraFlying() && !llllllllllllllIIlIllllllIllIlIlI.checkBlockCollision(this.playerEntity.getEntityBoundingBox().expandXyz(0.0625).addCoord(0.0, -0.55, 0.0)));
                            this.playerEntity.onGround = llllllllllllllIIlIllllllIllIlIll.isOnGround();
                            this.serverController.getPlayerList().serverUpdateMovingPlayer(this.playerEntity);
                            this.playerEntity.handleFalling(this.playerEntity.posY - llllllllllllllIIlIllllllIllIIllI, llllllllllllllIIlIllllllIllIlIll.isOnGround());
                            this.lastGoodX = this.playerEntity.posX;
                            this.lastGoodY = this.playerEntity.posY;
                            this.lastGoodZ = this.playerEntity.posZ;
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void handleAnimation(final CPacketAnimation llllllllllllllIIlIlllllIIlllIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIlllIIll, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        this.playerEntity.swingArm(llllllllllllllIIlIlllllIIlllIIll.getHand());
    }
    
    @Override
    public void processConfirmTransaction(final CPacketConfirmTransaction llllllllllllllIIlIllllIllllllIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIllllIllllllIII, this, this.playerEntity.getServerWorld());
        final Short llllllllllllllIIlIllllIllllllIlI = this.pendingTransactions.lookup(this.playerEntity.openContainer.windowId);
        if (llllllllllllllIIlIllllIllllllIlI != null && llllllllllllllIIlIllllIllllllIII.getUid() == llllllllllllllIIlIllllIllllllIlI && this.playerEntity.openContainer.windowId == llllllllllllllIIlIllllIllllllIII.getWindowId() && !this.playerEntity.openContainer.getCanCraft(this.playerEntity) && !this.playerEntity.isSpectator()) {
            this.playerEntity.openContainer.setCanCraft(this.playerEntity, true);
        }
    }
    
    @Override
    public void processHeldItemChange(final CPacketHeldItemChange llllllllllllllIIlIlllllIlIIIlIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIlIIIlIll, this, this.playerEntity.getServerWorld());
        if (llllllllllllllIIlIlllllIlIIIlIll.getSlotId() >= 0 && llllllllllllllIIlIlllllIlIIIlIll.getSlotId() < InventoryPlayer.getHotbarSize()) {
            this.playerEntity.inventory.currentItem = llllllllllllllIIlIlllllIlIIIlIll.getSlotId();
            this.playerEntity.markPlayerActive();
        }
        else {
            NetHandlerPlayServer.LOGGER.warn("{} tried to set an invalid carried item", (Object)this.playerEntity.getName());
        }
    }
    
    @Override
    public void processTabComplete(final CPacketTabComplete llllllllllllllIIlIllllIlllIIIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIllllIlllIIIlIl, this, this.playerEntity.getServerWorld());
        final List<String> llllllllllllllIIlIllllIlllIIIlII = (List<String>)Lists.newArrayList();
        for (final String llllllllllllllIIlIllllIlllIIIIll : this.serverController.getTabCompletions(this.playerEntity, llllllllllllllIIlIllllIlllIIIlIl.getMessage(), llllllllllllllIIlIllllIlllIIIlIl.getTargetBlock(), llllllllllllllIIlIllllIlllIIIlIl.hasTargetBlock())) {
            llllllllllllllIIlIllllIlllIIIlII.add(llllllllllllllIIlIllllIlllIIIIll);
        }
        this.playerEntity.connection.sendPacket(new SPacketTabComplete(llllllllllllllIIlIllllIlllIIIlII.toArray(new String[llllllllllllllIIlIllllIlllIIIlII.size()])));
    }
    
    private long currentTimeMillis() {
        return System.nanoTime() / 1000000L;
    }
    
    @Override
    public void func_191984_a(final CPacketRecipeInfo llllllllllllllIIlIlllllllIIIllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllllIIIllll, this, this.playerEntity.getServerWorld());
        if (llllllllllllllIIlIlllllllIIIllll.func_194156_a() == CPacketRecipeInfo.Purpose.SHOWN) {
            this.playerEntity.func_192037_E().func_194074_f(llllllllllllllIIlIlllllllIIIllll.func_193648_b());
        }
        else if (llllllllllllllIIlIlllllllIIIllll.func_194156_a() == CPacketRecipeInfo.Purpose.SETTINGS) {
            this.playerEntity.func_192037_E().func_192813_a(llllllllllllllIIlIlllllllIIIllll.func_192624_c());
            this.playerEntity.func_192037_E().func_192810_b(llllllllllllllIIlIlllllllIIIllll.func_192625_d());
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void sendPacket(final Packet<?> llllllllllllllIIlIlllllIlIIlIlII) {
        if (llllllllllllllIIlIlllllIlIIlIlII instanceof SPacketChat) {
            final SPacketChat llllllllllllllIIlIlllllIlIIllIlI = (SPacketChat)llllllllllllllIIlIlllllIlIIlIlII;
            final EntityPlayer.EnumChatVisibility llllllllllllllIIlIlllllIlIIllIIl = this.playerEntity.getChatVisibility();
            if (llllllllllllllIIlIlllllIlIIllIIl == EntityPlayer.EnumChatVisibility.HIDDEN && llllllllllllllIIlIlllllIlIIllIlI.func_192590_c() != ChatType.GAME_INFO) {
                return;
            }
            if (llllllllllllllIIlIlllllIlIIllIIl == EntityPlayer.EnumChatVisibility.SYSTEM && !llllllllllllllIIlIlllllIlIIllIlI.isSystem()) {
                return;
            }
        }
        try {
            this.netManager.sendPacket(llllllllllllllIIlIlllllIlIIlIlII);
        }
        catch (Throwable llllllllllllllIIlIlllllIlIIllIII) {
            final CrashReport llllllllllllllIIlIlllllIlIIlIlll = CrashReport.makeCrashReport(llllllllllllllIIlIlllllIlIIllIII, "Sending packet");
            final CrashReportCategory llllllllllllllIIlIlllllIlIIlIllI = llllllllllllllIIlIlllllIlIIlIlll.makeCategory("Packet being sent");
            llllllllllllllIIlIlllllIlIIlIllI.setDetail("Packet class", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return llllllllllllllIIlIlllllIlIIlIlII.getClass().getCanonicalName();
                }
            });
            throw new ReportedException(llllllllllllllIIlIlllllIlIIlIlll);
        }
    }
    
    @Override
    public void processCreativeInventoryAction(final CPacketCreativeInventoryAction llllllllllllllIIlIlllllIIIIlIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIIIlIIIl, this, this.playerEntity.getServerWorld());
        if (this.playerEntity.interactionManager.isCreative()) {
            final boolean llllllllllllllIIlIlllllIIIIlIIII = llllllllllllllIIlIlllllIIIIlIIIl.getSlotId() < 0;
            final ItemStack llllllllllllllIIlIlllllIIIIIllll = llllllllllllllIIlIlllllIIIIlIIIl.getStack();
            if (!llllllllllllllIIlIlllllIIIIIllll.func_190926_b() && llllllllllllllIIlIlllllIIIIIllll.hasTagCompound() && llllllllllllllIIlIlllllIIIIIllll.getTagCompound().hasKey("BlockEntityTag", 10)) {
                final NBTTagCompound llllllllllllllIIlIlllllIIIIIlllI = llllllllllllllIIlIlllllIIIIIllll.getTagCompound().getCompoundTag("BlockEntityTag");
                if (llllllllllllllIIlIlllllIIIIIlllI.hasKey("x") && llllllllllllllIIlIlllllIIIIIlllI.hasKey("y") && llllllllllllllIIlIlllllIIIIIlllI.hasKey("z")) {
                    final BlockPos llllllllllllllIIlIlllllIIIIIllIl = new BlockPos(llllllllllllllIIlIlllllIIIIIlllI.getInteger("x"), llllllllllllllIIlIlllllIIIIIlllI.getInteger("y"), llllllllllllllIIlIlllllIIIIIlllI.getInteger("z"));
                    final TileEntity llllllllllllllIIlIlllllIIIIIllII = this.playerEntity.world.getTileEntity(llllllllllllllIIlIlllllIIIIIllIl);
                    if (llllllllllllllIIlIlllllIIIIIllII != null) {
                        final NBTTagCompound llllllllllllllIIlIlllllIIIIIlIll = llllllllllllllIIlIlllllIIIIIllII.writeToNBT(new NBTTagCompound());
                        llllllllllllllIIlIlllllIIIIIlIll.removeTag("x");
                        llllllllllllllIIlIlllllIIIIIlIll.removeTag("y");
                        llllllllllllllIIlIlllllIIIIIlIll.removeTag("z");
                        llllllllllllllIIlIlllllIIIIIllll.setTagInfo("BlockEntityTag", llllllllllllllIIlIlllllIIIIIlIll);
                    }
                }
            }
            final boolean llllllllllllllIIlIlllllIIIIIlIlI = llllllllllllllIIlIlllllIIIIlIIIl.getSlotId() >= 1 && llllllllllllllIIlIlllllIIIIlIIIl.getSlotId() <= 45;
            final boolean llllllllllllllIIlIlllllIIIIIlIIl = llllllllllllllIIlIlllllIIIIIllll.func_190926_b() || (llllllllllllllIIlIlllllIIIIIllll.getMetadata() >= 0 && llllllllllllllIIlIlllllIIIIIllll.func_190916_E() <= 64 && !llllllllllllllIIlIlllllIIIIIllll.func_190926_b());
            if (llllllllllllllIIlIlllllIIIIIlIlI && llllllllllllllIIlIlllllIIIIIlIIl) {
                if (llllllllllllllIIlIlllllIIIIIllll.func_190926_b()) {
                    this.playerEntity.inventoryContainer.putStackInSlot(llllllllllllllIIlIlllllIIIIlIIIl.getSlotId(), ItemStack.field_190927_a);
                }
                else {
                    this.playerEntity.inventoryContainer.putStackInSlot(llllllllllllllIIlIlllllIIIIlIIIl.getSlotId(), llllllllllllllIIlIlllllIIIIIllll);
                }
                this.playerEntity.inventoryContainer.setCanCraft(this.playerEntity, true);
            }
            else if (llllllllllllllIIlIlllllIIIIlIIII && llllllllllllllIIlIlllllIIIIIlIIl && this.itemDropThreshold < 200) {
                this.itemDropThreshold += 20;
                final EntityItem llllllllllllllIIlIlllllIIIIIlIII = this.playerEntity.dropItem(llllllllllllllIIlIlllllIIIIIllll, true);
                if (llllllllllllllIIlIlllllIIIIIlIII != null) {
                    llllllllllllllIIlIlllllIIIIIlIII.setAgeToCreativeDespawnTime();
                }
            }
        }
    }
    
    @Override
    public void func_194308_a(final CPacketPlaceRecipe llllllllllllllIIlIlllllIIIlIIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIIlIIIIl, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        if (!this.playerEntity.isSpectator() && this.playerEntity.openContainer.windowId == llllllllllllllIIlIlllllIIIlIIIIl.func_194318_a() && this.playerEntity.openContainer.getCanCraft(this.playerEntity)) {
            this.field_194309_H.func_194327_a(this.playerEntity, llllllllllllllIIlIlllllIIIlIIIIl.func_194317_b(), llllllllllllllIIlIlllllIIIlIIIIl.func_194319_c());
        }
    }
    
    @Override
    public void processUseEntity(final CPacketUseEntity llllllllllllllIIlIlllllIIlIllIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIlIllIlI, this, this.playerEntity.getServerWorld());
        final WorldServer llllllllllllllIIlIlllllIIlIllIIl = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final Entity llllllllllllllIIlIlllllIIlIllIII = llllllllllllllIIlIlllllIIlIllIlI.getEntityFromWorld(llllllllllllllIIlIlllllIIlIllIIl);
        this.playerEntity.markPlayerActive();
        if (llllllllllllllIIlIlllllIIlIllIII != null) {
            final boolean llllllllllllllIIlIlllllIIlIlIlll = this.playerEntity.canEntityBeSeen(llllllllllllllIIlIlllllIIlIllIII);
            double llllllllllllllIIlIlllllIIlIlIllI = 36.0;
            if (!llllllllllllllIIlIlllllIIlIlIlll) {
                llllllllllllllIIlIlllllIIlIlIllI = 9.0;
            }
            if (this.playerEntity.getDistanceSqToEntity(llllllllllllllIIlIlllllIIlIllIII) < llllllllllllllIIlIlllllIIlIlIllI) {
                if (llllllllllllllIIlIlllllIIlIllIlI.getAction() == CPacketUseEntity.Action.INTERACT) {
                    final EnumHand llllllllllllllIIlIlllllIIlIlIlIl = llllllllllllllIIlIlllllIIlIllIlI.getHand();
                    this.playerEntity.func_190775_a(llllllllllllllIIlIlllllIIlIllIII, llllllllllllllIIlIlllllIIlIlIlIl);
                }
                else if (llllllllllllllIIlIlllllIIlIllIlI.getAction() == CPacketUseEntity.Action.INTERACT_AT) {
                    final EnumHand llllllllllllllIIlIlllllIIlIlIlII = llllllllllllllIIlIlllllIIlIllIlI.getHand();
                    llllllllllllllIIlIlllllIIlIllIII.applyPlayerInteraction(this.playerEntity, llllllllllllllIIlIlllllIIlIllIlI.getHitVec(), llllllllllllllIIlIlllllIIlIlIlII);
                }
                else if (llllllllllllllIIlIlllllIIlIllIlI.getAction() == CPacketUseEntity.Action.ATTACK) {
                    if (llllllllllllllIIlIlllllIIlIllIII instanceof EntityItem || llllllllllllllIIlIlllllIIlIllIII instanceof EntityXPOrb || llllllllllllllIIlIlllllIIlIllIII instanceof EntityArrow || llllllllllllllIIlIlllllIIlIllIII == this.playerEntity) {
                        this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.invalid_entity_attacked", new Object[0]));
                        this.serverController.logWarning("Player " + this.playerEntity.getName() + " tried to attack an invalid entity");
                        return;
                    }
                    this.playerEntity.attackTargetEntityWithCurrentItem(llllllllllllllIIlIlllllIIlIllIII);
                }
            }
        }
    }
    
    @Override
    public void onDisconnect(final ITextComponent llllllllllllllIIlIlllllIlIlIIllI) {
        NetHandlerPlayServer.LOGGER.info("{} lost connection: {}", (Object)this.playerEntity.getName(), (Object)llllllllllllllIIlIlllllIlIlIIllI.getUnformattedText());
        this.serverController.refreshStatusNextTick();
        final TextComponentTranslation llllllllllllllIIlIlllllIlIlIIlIl = new TextComponentTranslation("multiplayer.player.left", new Object[] { this.playerEntity.getDisplayName() });
        llllllllllllllIIlIlllllIlIlIIlIl.getStyle().setColor(TextFormatting.YELLOW);
        this.serverController.getPlayerList().sendChatMsg(llllllllllllllIIlIlllllIlIlIIlIl);
        this.playerEntity.mountEntityAndWakeUp();
        this.serverController.getPlayerList().playerLoggedOut(this.playerEntity);
        if (this.serverController.isSinglePlayer() && this.playerEntity.getName().equals(this.serverController.getServerOwner())) {
            NetHandlerPlayServer.LOGGER.info("Stopping singleplayer server as player logged out");
            this.serverController.initiateShutdown();
        }
    }
    
    @Override
    public void processClientStatus(final CPacketClientStatus llllllllllllllIIlIlllllIIlIIIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIlIIIlIl, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        final CPacketClientStatus.State llllllllllllllIIlIlllllIIlIIIlll = llllllllllllllIIlIlllllIIlIIIlIl.getStatus();
        switch ($SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State()[llllllllllllllIIlIlllllIIlIIIlll.ordinal()]) {
            case 1: {
                if (this.playerEntity.playerConqueredTheEnd) {
                    this.playerEntity.playerConqueredTheEnd = false;
                    this.playerEntity = this.serverController.getPlayerList().recreatePlayerEntity(this.playerEntity, 0, true);
                    CriteriaTriggers.field_193134_u.func_193143_a(this.playerEntity, DimensionType.THE_END, DimensionType.OVERWORLD);
                    break;
                }
                if (this.playerEntity.getHealth() > 0.0f) {
                    return;
                }
                this.playerEntity = this.serverController.getPlayerList().recreatePlayerEntity(this.playerEntity, 0, false);
                if (this.serverController.isHardcore()) {
                    this.playerEntity.setGameType(GameType.SPECTATOR);
                    this.playerEntity.getServerWorld().getGameRules().setOrCreateGameRule("spectatorsGenerateChunks", "false");
                    break;
                }
                break;
            }
            case 2: {
                this.playerEntity.getStatFile().sendStats(this.playerEntity);
                break;
            }
        }
    }
    
    @Override
    public void processPlayerBlockPlacement(final CPacketPlayerTryUseItem llllllllllllllIIlIlllllIllIIllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIllIIllIl, this, this.playerEntity.getServerWorld());
        final WorldServer llllllllllllllIIlIlllllIllIlIIIl = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final EnumHand llllllllllllllIIlIlllllIllIlIIII = llllllllllllllIIlIlllllIllIIllIl.getHand();
        final ItemStack llllllllllllllIIlIlllllIllIIllll = this.playerEntity.getHeldItem(llllllllllllllIIlIlllllIllIlIIII);
        this.playerEntity.markPlayerActive();
        if (!llllllllllllllIIlIlllllIllIIllll.func_190926_b()) {
            this.playerEntity.interactionManager.processRightClick(this.playerEntity, llllllllllllllIIlIlllllIllIlIIIl, llllllllllllllIIlIlllllIllIIllll, llllllllllllllIIlIlllllIllIlIIII);
        }
    }
    
    @Override
    public void processUpdateSign(final CPacketUpdateSign llllllllllllllIIlIllllIllllIllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIllllIllllIllII, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        final WorldServer llllllllllllllIIlIllllIllllIlIll = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final BlockPos llllllllllllllIIlIllllIllllIlIlI = llllllllllllllIIlIllllIllllIllII.getPosition();
        if (llllllllllllllIIlIllllIllllIlIll.isBlockLoaded(llllllllllllllIIlIllllIllllIlIlI)) {
            final IBlockState llllllllllllllIIlIllllIllllIlIIl = llllllllllllllIIlIllllIllllIlIll.getBlockState(llllllllllllllIIlIllllIllllIlIlI);
            final TileEntity llllllllllllllIIlIllllIllllIlIII = llllllllllllllIIlIllllIllllIlIll.getTileEntity(llllllllllllllIIlIllllIllllIlIlI);
            if (!(llllllllllllllIIlIllllIllllIlIII instanceof TileEntitySign)) {
                return;
            }
            final TileEntitySign llllllllllllllIIlIllllIllllIIlll = (TileEntitySign)llllllllllllllIIlIllllIllllIlIII;
            if (!llllllllllllllIIlIllllIllllIIlll.getIsEditable() || llllllllllllllIIlIllllIllllIIlll.getPlayer() != this.playerEntity) {
                this.serverController.logWarning("Player " + this.playerEntity.getName() + " just tried to change non-editable sign");
                return;
            }
            final String[] llllllllllllllIIlIllllIllllIIllI = llllllllllllllIIlIllllIllllIllII.getLines();
            for (int llllllllllllllIIlIllllIllllIIlIl = 0; llllllllllllllIIlIllllIllllIIlIl < llllllllllllllIIlIllllIllllIIllI.length; ++llllllllllllllIIlIllllIllllIIlIl) {
                llllllllllllllIIlIllllIllllIIlll.signText[llllllllllllllIIlIllllIllllIIlIl] = new TextComponentString(TextFormatting.getTextWithoutFormattingCodes(llllllllllllllIIlIllllIllllIIllI[llllllllllllllIIlIllllIllllIIlIl]));
            }
            llllllllllllllIIlIllllIllllIIlll.markDirty();
            llllllllllllllIIlIllllIllllIlIll.notifyBlockUpdate(llllllllllllllIIlIllllIllllIlIlI, llllllllllllllIIlIllllIllllIlIIl, llllllllllllllIIlIllllIllllIlIIl, 3);
        }
    }
    
    @Override
    public void processChatMessage(final CPacketChatMessage llllllllllllllIIlIlllllIIlllllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIlllllll, this, this.playerEntity.getServerWorld());
        if (this.playerEntity.getChatVisibility() == EntityPlayer.EnumChatVisibility.HIDDEN) {
            final TextComponentTranslation llllllllllllllIIlIlllllIlIIIIlII = new TextComponentTranslation("chat.cannotSend", new Object[0]);
            llllllllllllllIIlIlllllIlIIIIlII.getStyle().setColor(TextFormatting.RED);
            this.sendPacket(new SPacketChat(llllllllllllllIIlIlllllIlIIIIlII));
        }
        else {
            this.playerEntity.markPlayerActive();
            String llllllllllllllIIlIlllllIlIIIIIll = llllllllllllllIIlIlllllIIlllllll.getMessage();
            llllllllllllllIIlIlllllIlIIIIIll = StringUtils.normalizeSpace(llllllllllllllIIlIlllllIlIIIIIll);
            for (int llllllllllllllIIlIlllllIlIIIIIlI = 0; llllllllllllllIIlIlllllIlIIIIIlI < llllllllllllllIIlIlllllIlIIIIIll.length(); ++llllllllllllllIIlIlllllIlIIIIIlI) {
                if (!ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIIlIlllllIlIIIIIll.charAt(llllllllllllllIIlIlllllIlIIIIIlI))) {
                    this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.illegal_characters", new Object[0]));
                    return;
                }
            }
            if (llllllllllllllIIlIlllllIlIIIIIll.startsWith("/")) {
                this.handleSlashCommand(llllllllllllllIIlIlllllIlIIIIIll);
            }
            else {
                final ITextComponent llllllllllllllIIlIlllllIlIIIIIIl = new TextComponentTranslation("chat.type.text", new Object[] { this.playerEntity.getDisplayName(), llllllllllllllIIlIlllllIlIIIIIll });
                this.serverController.getPlayerList().sendChatMsgImpl(llllllllllllllIIlIlllllIlIIIIIIl, false);
            }
            this.chatSpamThresholdCount += 20;
            if (this.chatSpamThresholdCount > 200 && !this.serverController.getPlayerList().canSendCommands(this.playerEntity.getGameProfile())) {
                this.func_194028_b(new TextComponentTranslation("disconnect.spam", new Object[0]));
            }
        }
    }
    
    @Override
    public void handleResourcePackStatus(final CPacketResourcePackStatus llllllllllllllIIlIlllllIlIllIlII) {
    }
    
    @Override
    public void processEntityAction(final CPacketEntityAction llllllllllllllIIlIlllllIIllIlIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIllIlIll, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        switch ($SWITCH_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action()[llllllllllllllIIlIlllllIIllIlIll.getAction().ordinal()]) {
            case 1: {
                this.playerEntity.setSneaking(true);
                break;
            }
            case 2: {
                this.playerEntity.setSneaking(false);
                break;
            }
            case 4: {
                this.playerEntity.setSprinting(true);
                break;
            }
            case 5: {
                this.playerEntity.setSprinting(false);
                break;
            }
            case 3: {
                if (this.playerEntity.isPlayerSleeping()) {
                    this.playerEntity.wakeUpPlayer(false, true, true);
                    this.targetPos = new Vec3d(this.playerEntity.posX, this.playerEntity.posY, this.playerEntity.posZ);
                    break;
                }
                break;
            }
            case 6: {
                if (!(this.playerEntity.getRidingEntity() instanceof IJumpingMount)) {
                    break;
                }
                final IJumpingMount llllllllllllllIIlIlllllIIllIlIlI = (IJumpingMount)this.playerEntity.getRidingEntity();
                final int llllllllllllllIIlIlllllIIllIlIIl = llllllllllllllIIlIlllllIIllIlIll.getAuxData();
                if (llllllllllllllIIlIlllllIIllIlIlI.canJump() && llllllllllllllIIlIlllllIIllIlIIl > 0) {
                    llllllllllllllIIlIlllllIIllIlIlI.handleStartJump(llllllllllllllIIlIlllllIIllIlIIl);
                    break;
                }
                break;
            }
            case 7: {
                if (this.playerEntity.getRidingEntity() instanceof IJumpingMount) {
                    final IJumpingMount llllllllllllllIIlIlllllIIllIlIII = (IJumpingMount)this.playerEntity.getRidingEntity();
                    llllllllllllllIIlIlllllIIllIlIII.handleStopJump();
                    break;
                }
                break;
            }
            case 8: {
                if (this.playerEntity.getRidingEntity() instanceof AbstractHorse) {
                    ((AbstractHorse)this.playerEntity.getRidingEntity()).openGUI(this.playerEntity);
                    break;
                }
                break;
            }
            case 9: {
                if (this.playerEntity.onGround || this.playerEntity.motionY >= 0.0 || this.playerEntity.isElytraFlying() || this.playerEntity.isInWater()) {
                    this.playerEntity.clearElytraFlying();
                    break;
                }
                final ItemStack llllllllllllllIIlIlllllIIllIIlll = this.playerEntity.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                if (llllllllllllllIIlIlllllIIllIIlll.getItem() == Items.ELYTRA && ItemElytra.isBroken(llllllllllllllIIlIlllllIIllIIlll)) {
                    this.playerEntity.setElytraFlying();
                    break;
                }
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid client command!");
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State() {
        final int[] $switch_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State = NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State;
        if ($switch_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State != null) {
            return $switch_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State;
        }
        final double llllllllllllllIIlIllllIlIlIIIlIl = (Object)new int[CPacketClientStatus.State.values().length];
        try {
            llllllllllllllIIlIllllIlIlIIIlIl[CPacketClientStatus.State.PERFORM_RESPAWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIllllIlIlIIIlIl[CPacketClientStatus.State.REQUEST_STATS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State = (int[])(Object)llllllllllllllIIlIllllIlIlIIIlIl;
    }
    
    private void captureCurrentPosition() {
        this.firstGoodX = this.playerEntity.posX;
        this.firstGoodY = this.playerEntity.posY;
        this.firstGoodZ = this.playerEntity.posZ;
        this.lastGoodX = this.playerEntity.posX;
        this.lastGoodY = this.playerEntity.posY;
        this.lastGoodZ = this.playerEntity.posZ;
    }
    
    @Override
    public void handleSpectate(final CPacketSpectate llllllllllllllIIlIlllllIlIlllIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIlIlllIll, this, this.playerEntity.getServerWorld());
        if (this.playerEntity.isSpectator()) {
            Entity llllllllllllllIIlIlllllIllIIIIII = null;
            final long llllllllllllllIIlIlllllIlIllIllI;
            final boolean llllllllllllllIIlIlllllIlIllIlll = ((WorldServer[])(Object)(llllllllllllllIIlIlllllIlIllIllI = (long)(Object)this.serverController.worldServers)).length != 0;
            for (final WorldServer llllllllllllllIIlIlllllIlIllllll : llllllllllllllIIlIlllllIlIllIllI) {
                if (llllllllllllllIIlIlllllIlIllllll != null) {
                    llllllllllllllIIlIlllllIllIIIIII = llllllllllllllIIlIlllllIlIlllIll.getEntity(llllllllllllllIIlIlllllIlIllllll);
                    if (llllllllllllllIIlIlllllIllIIIIII != null) {
                        break;
                    }
                }
            }
            if (llllllllllllllIIlIlllllIllIIIIII != null) {
                this.playerEntity.setSpectatingEntity(this.playerEntity);
                this.playerEntity.dismountRidingEntity();
                if (llllllllllllllIIlIlllllIllIIIIII.world == this.playerEntity.world) {
                    this.playerEntity.setPositionAndUpdate(llllllllllllllIIlIlllllIllIIIIII.posX, llllllllllllllIIlIlllllIllIIIIII.posY, llllllllllllllIIlIlllllIllIIIIII.posZ);
                }
                else {
                    final WorldServer llllllllllllllIIlIlllllIlIlllllI = this.playerEntity.getServerWorld();
                    final WorldServer llllllllllllllIIlIlllllIlIllllIl = (WorldServer)llllllllllllllIIlIlllllIllIIIIII.world;
                    this.playerEntity.dimension = llllllllllllllIIlIlllllIllIIIIII.dimension;
                    this.sendPacket(new SPacketRespawn(this.playerEntity.dimension, llllllllllllllIIlIlllllIlIlllllI.getDifficulty(), llllllllllllllIIlIlllllIlIlllllI.getWorldInfo().getTerrainType(), this.playerEntity.interactionManager.getGameType()));
                    this.serverController.getPlayerList().updatePermissionLevel(this.playerEntity);
                    llllllllllllllIIlIlllllIlIlllllI.removeEntityDangerously(this.playerEntity);
                    this.playerEntity.isDead = false;
                    this.playerEntity.setLocationAndAngles(llllllllllllllIIlIlllllIllIIIIII.posX, llllllllllllllIIlIlllllIllIIIIII.posY, llllllllllllllIIlIlllllIllIIIIII.posZ, llllllllllllllIIlIlllllIllIIIIII.rotationYaw, llllllllllllllIIlIlllllIllIIIIII.rotationPitch);
                    if (this.playerEntity.isEntityAlive()) {
                        llllllllllllllIIlIlllllIlIlllllI.updateEntityWithOptionalForce(this.playerEntity, false);
                        llllllllllllllIIlIlllllIlIllllIl.spawnEntityInWorld(this.playerEntity);
                        llllllllllllllIIlIlllllIlIllllIl.updateEntityWithOptionalForce(this.playerEntity, false);
                    }
                    this.playerEntity.setWorld(llllllllllllllIIlIlllllIlIllllIl);
                    this.serverController.getPlayerList().preparePlayer(this.playerEntity, llllllllllllllIIlIlllllIlIlllllI);
                    this.playerEntity.setPositionAndUpdate(llllllllllllllIIlIlllllIllIIIIII.posX, llllllllllllllIIlIlllllIllIIIIII.posY, llllllllllllllIIlIlllllIllIIIIII.posZ);
                    this.playerEntity.interactionManager.setWorld(llllllllllllllIIlIlllllIlIllllIl);
                    this.serverController.getPlayerList().updateTimeAndWeatherForPlayer(this.playerEntity, llllllllllllllIIlIlllllIlIllllIl);
                    this.serverController.getPlayerList().syncPlayerInventory(this.playerEntity);
                }
            }
        }
    }
    
    private static boolean isMovePlayerPacketInvalid(final CPacketPlayer llllllllllllllIIlIllllllllIllllI) {
        return !Doubles.isFinite(llllllllllllllIIlIllllllllIllllI.getX(0.0)) || !Doubles.isFinite(llllllllllllllIIlIllllllllIllllI.getY(0.0)) || !Doubles.isFinite(llllllllllllllIIlIllllllllIllllI.getZ(0.0)) || !Floats.isFinite(llllllllllllllIIlIllllllllIllllI.getPitch(0.0f)) || !Floats.isFinite(llllllllllllllIIlIllllllllIllllI.getYaw(0.0f)) || Math.abs(llllllllllllllIIlIllllllllIllllI.getX(0.0)) > 3.0E7 || Math.abs(llllllllllllllIIlIllllllllIllllI.getY(0.0)) > 3.0E7 || Math.abs(llllllllllllllIIlIllllllllIllllI.getZ(0.0)) > 3.0E7;
    }
    
    @Override
    public void processClickWindow(final CPacketClickWindow llllllllllllllIIlIlllllIIIlIllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIIlIllII, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        if (this.playerEntity.openContainer.windowId == llllllllllllllIIlIlllllIIIlIllII.getWindowId() && this.playerEntity.openContainer.getCanCraft(this.playerEntity)) {
            if (this.playerEntity.isSpectator()) {
                final NonNullList<ItemStack> llllllllllllllIIlIlllllIIIllIlII = NonNullList.func_191196_a();
                for (int llllllllllllllIIlIlllllIIIllIIll = 0; llllllllllllllIIlIlllllIIIllIIll < this.playerEntity.openContainer.inventorySlots.size(); ++llllllllllllllIIlIlllllIIIllIIll) {
                    llllllllllllllIIlIlllllIIIllIlII.add(this.playerEntity.openContainer.inventorySlots.get(llllllllllllllIIlIlllllIIIllIIll).getStack());
                }
                this.playerEntity.updateCraftingInventory(this.playerEntity.openContainer, llllllllllllllIIlIlllllIIIllIlII);
            }
            else {
                final ItemStack llllllllllllllIIlIlllllIIIllIIlI = this.playerEntity.openContainer.slotClick(llllllllllllllIIlIlllllIIIlIllII.getSlotId(), llllllllllllllIIlIlllllIIIlIllII.getUsedButton(), llllllllllllllIIlIlllllIIIlIllII.getClickType(), this.playerEntity);
                if (ItemStack.areItemStacksEqual(llllllllllllllIIlIlllllIIIlIllII.getClickedItem(), llllllllllllllIIlIlllllIIIllIIlI)) {
                    this.playerEntity.connection.sendPacket(new SPacketConfirmTransaction(llllllllllllllIIlIlllllIIIlIllII.getWindowId(), llllllllllllllIIlIlllllIIIlIllII.getActionNumber(), true));
                    this.playerEntity.isChangingQuantityOnly = true;
                    this.playerEntity.openContainer.detectAndSendChanges();
                    this.playerEntity.updateHeldItem();
                    this.playerEntity.isChangingQuantityOnly = false;
                }
                else {
                    this.pendingTransactions.addKey(this.playerEntity.openContainer.windowId, llllllllllllllIIlIlllllIIIlIllII.getActionNumber());
                    this.playerEntity.connection.sendPacket(new SPacketConfirmTransaction(llllllllllllllIIlIlllllIIIlIllII.getWindowId(), llllllllllllllIIlIlllllIIIlIllII.getActionNumber(), false));
                    this.playerEntity.openContainer.setCanCraft(this.playerEntity, false);
                    final NonNullList<ItemStack> llllllllllllllIIlIlllllIIIllIIIl = NonNullList.func_191196_a();
                    for (int llllllllllllllIIlIlllllIIIllIIII = 0; llllllllllllllIIlIlllllIIIllIIII < this.playerEntity.openContainer.inventorySlots.size(); ++llllllllllllllIIlIlllllIIIllIIII) {
                        final ItemStack llllllllllllllIIlIlllllIIIlIllll = this.playerEntity.openContainer.inventorySlots.get(llllllllllllllIIlIlllllIIIllIIII).getStack();
                        final ItemStack llllllllllllllIIlIlllllIIIlIlllI = llllllllllllllIIlIlllllIIIlIllll.func_190926_b() ? ItemStack.field_190927_a : llllllllllllllIIlIlllllIIIlIllll;
                        llllllllllllllIIlIlllllIIIllIIIl.add(llllllllllllllIIlIlllllIIIlIlllI);
                    }
                    this.playerEntity.updateCraftingInventory(this.playerEntity.openContainer, llllllllllllllIIlIlllllIIIllIIIl);
                }
            }
        }
    }
    
    @Override
    public void processClientSettings(final CPacketClientSettings llllllllllllllIIlIllllIllIlllIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIllllIllIlllIII, this, this.playerEntity.getServerWorld());
        this.playerEntity.handleClientSettings(llllllllllllllIIlIllllIllIlllIII);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action = NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action;
        if ($switch_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action;
        }
        final Exception llllllllllllllIIlIllllIlIlIIlIIl = (Object)new int[CPacketPlayerDigging.Action.values().length];
        try {
            llllllllllllllIIlIllllIlIlIIlIIl[CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIllllIlIlIIlIIl[CPacketPlayerDigging.Action.DROP_ALL_ITEMS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIllllIlIlIIlIIl[CPacketPlayerDigging.Action.DROP_ITEM.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIlIllllIlIlIIlIIl[CPacketPlayerDigging.Action.RELEASE_USE_ITEM.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIlIllllIlIlIIlIIl[CPacketPlayerDigging.Action.START_DESTROY_BLOCK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIlIllllIlIlIIlIIl[CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIIlIllllIlIlIIlIIl[CPacketPlayerDigging.Action.SWAP_HELD_ITEMS.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action = (int[])(Object)llllllllllllllIIlIllllIlIlIIlIIl;
    }
    
    @Override
    public void processSteerBoat(final CPacketSteerBoat llllllllllllllIIlIlllllIlIlIllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIlIlIllII, this, this.playerEntity.getServerWorld());
        final Entity llllllllllllllIIlIlllllIlIlIlllI = this.playerEntity.getRidingEntity();
        if (llllllllllllllIIlIlllllIlIlIlllI instanceof EntityBoat) {
            ((EntityBoat)llllllllllllllIIlIlllllIlIlIlllI).setPaddleState(llllllllllllllIIlIlllllIlIlIllII.getLeft(), llllllllllllllIIlIlllllIlIlIllII.getRight());
        }
    }
    
    public void func_194028_b(final ITextComponent llllllllllllllIIlIlllllllllIlIII) {
        this.netManager.sendPacket(new SPacketDisconnect(llllllllllllllIIlIlllllllllIlIII), (GenericFutureListener<? extends Future<? super Void>>)new GenericFutureListener<Future<? super Void>>() {
            public void operationComplete(final Future<? super Void> lllllllllllIlIlIlIllIlIlllIIIIll) throws Exception {
                NetHandlerPlayServer.this.netManager.closeChannel(llllllllllllllIIlIlllllllllIlIII);
            }
        }, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]);
        this.netManager.disableAutoRead();
        Futures.getUnchecked((java.util.concurrent.Future)this.serverController.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                NetHandlerPlayServer.this.netManager.checkDisconnected();
            }
        }));
    }
    
    @Override
    public void processCustomPayload(final CPacketCustomPayload llllllllllllllIIlIllllIllIlIIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIllllIllIlIIIll, this, this.playerEntity.getServerWorld());
        final String llllllllllllllIIlIllllIllIlIIIlI = llllllllllllllIIlIllllIllIlIIIll.getChannelName();
        if ("MC|BEdit".equals(llllllllllllllIIlIllllIllIlIIIlI)) {
            final PacketBuffer llllllllllllllIIlIllllIllIlIIIIl = llllllllllllllIIlIllllIllIlIIIll.getBufferData();
            try {
                final ItemStack llllllllllllllIIlIllllIllIlIIIII = llllllllllllllIIlIllllIllIlIIIIl.readItemStackFromBuffer();
                if (llllllllllllllIIlIllllIllIlIIIII.func_190926_b()) {
                    return;
                }
                if (!ItemWritableBook.isNBTValid(llllllllllllllIIlIllllIllIlIIIII.getTagCompound())) {
                    throw new IOException("Invalid book tag!");
                }
                final ItemStack llllllllllllllIIlIllllIllIIlllll = this.playerEntity.getHeldItemMainhand();
                if (llllllllllllllIIlIllllIllIIlllll.func_190926_b()) {
                    return;
                }
                if (llllllllllllllIIlIllllIllIlIIIII.getItem() == Items.WRITABLE_BOOK && llllllllllllllIIlIllllIllIlIIIII.getItem() == llllllllllllllIIlIllllIllIIlllll.getItem()) {
                    llllllllllllllIIlIllllIllIIlllll.setTagInfo("pages", llllllllllllllIIlIllllIllIlIIIII.getTagCompound().getTagList("pages", 8));
                }
            }
            catch (Exception llllllllllllllIIlIllllIllIIllllI) {
                NetHandlerPlayServer.LOGGER.error("Couldn't handle book info", (Throwable)llllllllllllllIIlIllllIllIIllllI);
            }
        }
        else if ("MC|BSign".equals(llllllllllllllIIlIllllIllIlIIIlI)) {
            final PacketBuffer llllllllllllllIIlIllllIllIIlllIl = llllllllllllllIIlIllllIllIlIIIll.getBufferData();
            try {
                final ItemStack llllllllllllllIIlIllllIllIIlllII = llllllllllllllIIlIllllIllIIlllIl.readItemStackFromBuffer();
                if (llllllllllllllIIlIllllIllIIlllII.func_190926_b()) {
                    return;
                }
                if (!ItemWrittenBook.validBookTagContents(llllllllllllllIIlIllllIllIIlllII.getTagCompound())) {
                    throw new IOException("Invalid book tag!");
                }
                final ItemStack llllllllllllllIIlIllllIllIIllIll = this.playerEntity.getHeldItemMainhand();
                if (llllllllllllllIIlIllllIllIIllIll.func_190926_b()) {
                    return;
                }
                if (llllllllllllllIIlIllllIllIIlllII.getItem() == Items.WRITABLE_BOOK && llllllllllllllIIlIllllIllIIllIll.getItem() == Items.WRITABLE_BOOK) {
                    final ItemStack llllllllllllllIIlIllllIllIIllIlI = new ItemStack(Items.WRITTEN_BOOK);
                    llllllllllllllIIlIllllIllIIllIlI.setTagInfo("author", new NBTTagString(this.playerEntity.getName()));
                    llllllllllllllIIlIllllIllIIllIlI.setTagInfo("title", new NBTTagString(llllllllllllllIIlIllllIllIIlllII.getTagCompound().getString("title")));
                    final NBTTagList llllllllllllllIIlIllllIllIIllIIl = llllllllllllllIIlIllllIllIIlllII.getTagCompound().getTagList("pages", 8);
                    for (int llllllllllllllIIlIllllIllIIllIII = 0; llllllllllllllIIlIllllIllIIllIII < llllllllllllllIIlIllllIllIIllIIl.tagCount(); ++llllllllllllllIIlIllllIllIIllIII) {
                        String llllllllllllllIIlIllllIllIIlIlll = llllllllllllllIIlIllllIllIIllIIl.getStringTagAt(llllllllllllllIIlIllllIllIIllIII);
                        final ITextComponent llllllllllllllIIlIllllIllIIlIllI = new TextComponentString(llllllllllllllIIlIllllIllIIlIlll);
                        llllllllllllllIIlIllllIllIIlIlll = ITextComponent.Serializer.componentToJson(llllllllllllllIIlIllllIllIIlIllI);
                        llllllllllllllIIlIllllIllIIllIIl.set(llllllllllllllIIlIllllIllIIllIII, new NBTTagString(llllllllllllllIIlIllllIllIIlIlll));
                    }
                    llllllllllllllIIlIllllIllIIllIlI.setTagInfo("pages", llllllllllllllIIlIllllIllIIllIIl);
                    this.playerEntity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, llllllllllllllIIlIllllIllIIllIlI);
                }
            }
            catch (Exception llllllllllllllIIlIllllIllIIlIlIl) {
                NetHandlerPlayServer.LOGGER.error("Couldn't sign book", (Throwable)llllllllllllllIIlIllllIllIIlIlIl);
            }
        }
        else if ("MC|TrSel".equals(llllllllllllllIIlIllllIllIlIIIlI)) {
            try {
                final int llllllllllllllIIlIllllIllIIlIlII = llllllllllllllIIlIllllIllIlIIIll.getBufferData().readInt();
                final Container llllllllllllllIIlIllllIllIIlIIll = this.playerEntity.openContainer;
                if (llllllllllllllIIlIllllIllIIlIIll instanceof ContainerMerchant) {
                    ((ContainerMerchant)llllllllllllllIIlIllllIllIIlIIll).setCurrentRecipeIndex(llllllllllllllIIlIllllIllIIlIlII);
                }
            }
            catch (Exception llllllllllllllIIlIllllIllIIlIIlI) {
                NetHandlerPlayServer.LOGGER.error("Couldn't select trade", (Throwable)llllllllllllllIIlIllllIllIIlIIlI);
            }
        }
        else if ("MC|AdvCmd".equals(llllllllllllllIIlIllllIllIlIIIlI)) {
            if (!this.serverController.isCommandBlockEnabled()) {
                this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.notEnabled", new Object[0]));
                return;
            }
            if (!this.playerEntity.canUseCommandBlock()) {
                this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.notAllowed", new Object[0]));
                return;
            }
            final PacketBuffer llllllllllllllIIlIllllIllIIlIIIl = llllllllllllllIIlIllllIllIlIIIll.getBufferData();
            try {
                final int llllllllllllllIIlIllllIllIIlIIII = llllllllllllllIIlIllllIllIIlIIIl.readByte();
                CommandBlockBaseLogic llllllllllllllIIlIllllIllIIIllll = null;
                if (llllllllllllllIIlIllllIllIIlIIII == 0) {
                    final TileEntity llllllllllllllIIlIllllIllIIIlllI = this.playerEntity.world.getTileEntity(new BlockPos(llllllllllllllIIlIllllIllIIlIIIl.readInt(), llllllllllllllIIlIllllIllIIlIIIl.readInt(), llllllllllllllIIlIllllIllIIlIIIl.readInt()));
                    if (llllllllllllllIIlIllllIllIIIlllI instanceof TileEntityCommandBlock) {
                        llllllllllllllIIlIllllIllIIIllll = ((TileEntityCommandBlock)llllllllllllllIIlIllllIllIIIlllI).getCommandBlockLogic();
                    }
                }
                else if (llllllllllllllIIlIllllIllIIlIIII == 1) {
                    final Entity llllllllllllllIIlIllllIllIIIllIl = this.playerEntity.world.getEntityByID(llllllllllllllIIlIllllIllIIlIIIl.readInt());
                    if (llllllllllllllIIlIllllIllIIIllIl instanceof EntityMinecartCommandBlock) {
                        llllllllllllllIIlIllllIllIIIllll = ((EntityMinecartCommandBlock)llllllllllllllIIlIllllIllIIIllIl).getCommandBlockLogic();
                    }
                }
                final String llllllllllllllIIlIllllIllIIIllII = llllllllllllllIIlIllllIllIIlIIIl.readStringFromBuffer(llllllllllllllIIlIllllIllIIlIIIl.readableBytes());
                final boolean llllllllllllllIIlIllllIllIIIlIll = llllllllllllllIIlIllllIllIIlIIIl.readBoolean();
                if (llllllllllllllIIlIllllIllIIIllll != null) {
                    llllllllllllllIIlIllllIllIIIllll.setCommand(llllllllllllllIIlIllllIllIIIllII);
                    llllllllllllllIIlIllllIllIIIllll.setTrackOutput(llllllllllllllIIlIllllIllIIIlIll);
                    if (!llllllllllllllIIlIllllIllIIIlIll) {
                        llllllllllllllIIlIllllIllIIIllll.setLastOutput(null);
                    }
                    llllllllllllllIIlIllllIllIIIllll.updateCommand();
                    this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.setCommand.success", new Object[] { llllllllllllllIIlIllllIllIIIllII }));
                }
            }
            catch (Exception llllllllllllllIIlIllllIllIIIlIlI) {
                NetHandlerPlayServer.LOGGER.error("Couldn't set command block", (Throwable)llllllllllllllIIlIllllIllIIIlIlI);
            }
        }
        else if ("MC|AutoCmd".equals(llllllllllllllIIlIllllIllIlIIIlI)) {
            if (!this.serverController.isCommandBlockEnabled()) {
                this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.notEnabled", new Object[0]));
                return;
            }
            if (!this.playerEntity.canUseCommandBlock()) {
                this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.notAllowed", new Object[0]));
                return;
            }
            final PacketBuffer llllllllllllllIIlIllllIllIIIlIIl = llllllllllllllIIlIllllIllIlIIIll.getBufferData();
            try {
                CommandBlockBaseLogic llllllllllllllIIlIllllIllIIIlIII = null;
                TileEntityCommandBlock llllllllllllllIIlIllllIllIIIIlll = null;
                final BlockPos llllllllllllllIIlIllllIllIIIIllI = new BlockPos(llllllllllllllIIlIllllIllIIIlIIl.readInt(), llllllllllllllIIlIllllIllIIIlIIl.readInt(), llllllllllllllIIlIllllIllIIIlIIl.readInt());
                final TileEntity llllllllllllllIIlIllllIllIIIIlIl = this.playerEntity.world.getTileEntity(llllllllllllllIIlIllllIllIIIIllI);
                if (llllllllllllllIIlIllllIllIIIIlIl instanceof TileEntityCommandBlock) {
                    llllllllllllllIIlIllllIllIIIIlll = (TileEntityCommandBlock)llllllllllllllIIlIllllIllIIIIlIl;
                    llllllllllllllIIlIllllIllIIIlIII = llllllllllllllIIlIllllIllIIIIlll.getCommandBlockLogic();
                }
                final String llllllllllllllIIlIllllIllIIIIlII = llllllllllllllIIlIllllIllIIIlIIl.readStringFromBuffer(llllllllllllllIIlIllllIllIIIlIIl.readableBytes());
                final boolean llllllllllllllIIlIllllIllIIIIIll = llllllllllllllIIlIllllIllIIIlIIl.readBoolean();
                final TileEntityCommandBlock.Mode llllllllllllllIIlIllllIllIIIIIlI = TileEntityCommandBlock.Mode.valueOf(llllllllllllllIIlIllllIllIIIlIIl.readStringFromBuffer(16));
                final boolean llllllllllllllIIlIllllIllIIIIIIl = llllllllllllllIIlIllllIllIIIlIIl.readBoolean();
                final boolean llllllllllllllIIlIllllIllIIIIIII = llllllllllllllIIlIllllIllIIIlIIl.readBoolean();
                if (llllllllllllllIIlIllllIllIIIlIII != null) {
                    final EnumFacing llllllllllllllIIlIllllIlIlllllll = this.playerEntity.world.getBlockState(llllllllllllllIIlIllllIllIIIIllI).getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING);
                    switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode()[llllllllllllllIIlIllllIllIIIIIlI.ordinal()]) {
                        case 1: {
                            final IBlockState llllllllllllllIIlIllllIlIllllllI = Blocks.CHAIN_COMMAND_BLOCK.getDefaultState();
                            this.playerEntity.world.setBlockState(llllllllllllllIIlIllllIllIIIIllI, llllllllllllllIIlIllllIlIllllllI.withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, llllllllllllllIIlIllllIlIlllllll).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, llllllllllllllIIlIllllIllIIIIIIl), 2);
                            break;
                        }
                        case 2: {
                            final IBlockState llllllllllllllIIlIllllIlIlllllIl = Blocks.REPEATING_COMMAND_BLOCK.getDefaultState();
                            this.playerEntity.world.setBlockState(llllllllllllllIIlIllllIllIIIIllI, llllllllllllllIIlIllllIlIlllllIl.withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, llllllllllllllIIlIllllIlIlllllll).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, llllllllllllllIIlIllllIllIIIIIIl), 2);
                            break;
                        }
                        case 3: {
                            final IBlockState llllllllllllllIIlIllllIlIlllllII = Blocks.COMMAND_BLOCK.getDefaultState();
                            this.playerEntity.world.setBlockState(llllllllllllllIIlIllllIllIIIIllI, llllllllllllllIIlIllllIlIlllllII.withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, llllllllllllllIIlIllllIlIlllllll).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, llllllllllllllIIlIllllIllIIIIIIl), 2);
                            break;
                        }
                    }
                    llllllllllllllIIlIllllIllIIIIlIl.validate();
                    this.playerEntity.world.setTileEntity(llllllllllllllIIlIllllIllIIIIllI, llllllllllllllIIlIllllIllIIIIlIl);
                    llllllllllllllIIlIllllIllIIIlIII.setCommand(llllllllllllllIIlIllllIllIIIIlII);
                    llllllllllllllIIlIllllIllIIIlIII.setTrackOutput(llllllllllllllIIlIllllIllIIIIIll);
                    if (!llllllllllllllIIlIllllIllIIIIIll) {
                        llllllllllllllIIlIllllIllIIIlIII.setLastOutput(null);
                    }
                    llllllllllllllIIlIllllIllIIIIlll.setAuto(llllllllllllllIIlIllllIllIIIIIII);
                    llllllllllllllIIlIllllIllIIIlIII.updateCommand();
                    if (!net.minecraft.util.StringUtils.isNullOrEmpty(llllllllllllllIIlIllllIllIIIIlII)) {
                        this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.setCommand.success", new Object[] { llllllllllllllIIlIllllIllIIIIlII }));
                    }
                }
            }
            catch (Exception llllllllllllllIIlIllllIlIllllIll) {
                NetHandlerPlayServer.LOGGER.error("Couldn't set command block", (Throwable)llllllllllllllIIlIllllIlIllllIll);
            }
        }
        else if ("MC|Beacon".equals(llllllllllllllIIlIllllIllIlIIIlI)) {
            if (this.playerEntity.openContainer instanceof ContainerBeacon) {
                try {
                    final PacketBuffer llllllllllllllIIlIllllIlIllllIlI = llllllllllllllIIlIllllIllIlIIIll.getBufferData();
                    final int llllllllllllllIIlIllllIlIllllIIl = llllllllllllllIIlIllllIlIllllIlI.readInt();
                    final int llllllllllllllIIlIllllIlIllllIII = llllllllllllllIIlIllllIlIllllIlI.readInt();
                    final ContainerBeacon llllllllllllllIIlIllllIlIlllIlll = (ContainerBeacon)this.playerEntity.openContainer;
                    final Slot llllllllllllllIIlIllllIlIlllIllI = llllllllllllllIIlIllllIlIlllIlll.getSlot(0);
                    if (llllllllllllllIIlIllllIlIlllIllI.getHasStack()) {
                        llllllllllllllIIlIllllIlIlllIllI.decrStackSize(1);
                        final IInventory llllllllllllllIIlIllllIlIlllIlIl = llllllllllllllIIlIllllIlIlllIlll.getTileEntity();
                        llllllllllllllIIlIllllIlIlllIlIl.setField(1, llllllllllllllIIlIllllIlIllllIIl);
                        llllllllllllllIIlIllllIlIlllIlIl.setField(2, llllllllllllllIIlIllllIlIllllIII);
                        llllllllllllllIIlIllllIlIlllIlIl.markDirty();
                    }
                }
                catch (Exception llllllllllllllIIlIllllIlIlllIlII) {
                    NetHandlerPlayServer.LOGGER.error("Couldn't set beacon", (Throwable)llllllllllllllIIlIllllIlIlllIlII);
                }
            }
        }
        else if ("MC|ItemName".equals(llllllllllllllIIlIllllIllIlIIIlI)) {
            if (this.playerEntity.openContainer instanceof ContainerRepair) {
                final ContainerRepair llllllllllllllIIlIllllIlIlllIIll = (ContainerRepair)this.playerEntity.openContainer;
                if (llllllllllllllIIlIllllIllIlIIIll.getBufferData() != null && llllllllllllllIIlIllllIllIlIIIll.getBufferData().readableBytes() >= 1) {
                    final String llllllllllllllIIlIllllIlIlllIIlI = ChatAllowedCharacters.filterAllowedCharacters(llllllllllllllIIlIllllIllIlIIIll.getBufferData().readStringFromBuffer(32767));
                    if (llllllllllllllIIlIllllIlIlllIIlI.length() <= 35) {
                        llllllllllllllIIlIllllIlIlllIIll.updateItemName(llllllllllllllIIlIllllIlIlllIIlI);
                    }
                }
                else {
                    llllllllllllllIIlIllllIlIlllIIll.updateItemName("");
                }
            }
        }
        else if ("MC|Struct".equals(llllllllllllllIIlIllllIllIlIIIlI)) {
            if (!this.playerEntity.canUseCommandBlock()) {
                return;
            }
            final PacketBuffer llllllllllllllIIlIllllIlIlllIIIl = llllllllllllllIIlIllllIllIlIIIll.getBufferData();
            try {
                final BlockPos llllllllllllllIIlIllllIlIlllIIII = new BlockPos(llllllllllllllIIlIllllIlIlllIIIl.readInt(), llllllllllllllIIlIllllIlIlllIIIl.readInt(), llllllllllllllIIlIllllIlIlllIIIl.readInt());
                final IBlockState llllllllllllllIIlIllllIlIllIllll = this.playerEntity.world.getBlockState(llllllllllllllIIlIllllIlIlllIIII);
                final TileEntity llllllllllllllIIlIllllIlIllIlllI = this.playerEntity.world.getTileEntity(llllllllllllllIIlIllllIlIlllIIII);
                if (llllllllllllllIIlIllllIlIllIlllI instanceof TileEntityStructure) {
                    final TileEntityStructure llllllllllllllIIlIllllIlIllIllIl = (TileEntityStructure)llllllllllllllIIlIllllIlIllIlllI;
                    final int llllllllllllllIIlIllllIlIllIllII = llllllllllllllIIlIllllIlIlllIIIl.readByte();
                    final String llllllllllllllIIlIllllIlIllIlIll = llllllllllllllIIlIllllIlIlllIIIl.readStringFromBuffer(32);
                    llllllllllllllIIlIllllIlIllIllIl.setMode(TileEntityStructure.Mode.valueOf(llllllllllllllIIlIllllIlIllIlIll));
                    llllllllllllllIIlIllllIlIllIllIl.setName(llllllllllllllIIlIllllIlIlllIIIl.readStringFromBuffer(64));
                    final int llllllllllllllIIlIllllIlIllIlIlI = MathHelper.clamp(llllllllllllllIIlIllllIlIlllIIIl.readInt(), -32, 32);
                    final int llllllllllllllIIlIllllIlIllIlIIl = MathHelper.clamp(llllllllllllllIIlIllllIlIlllIIIl.readInt(), -32, 32);
                    final int llllllllllllllIIlIllllIlIllIlIII = MathHelper.clamp(llllllllllllllIIlIllllIlIlllIIIl.readInt(), -32, 32);
                    llllllllllllllIIlIllllIlIllIllIl.setPosition(new BlockPos(llllllllllllllIIlIllllIlIllIlIlI, llllllllllllllIIlIllllIlIllIlIIl, llllllllllllllIIlIllllIlIllIlIII));
                    final int llllllllllllllIIlIllllIlIllIIlll = MathHelper.clamp(llllllllllllllIIlIllllIlIlllIIIl.readInt(), 0, 32);
                    final int llllllllllllllIIlIllllIlIllIIllI = MathHelper.clamp(llllllllllllllIIlIllllIlIlllIIIl.readInt(), 0, 32);
                    final int llllllllllllllIIlIllllIlIllIIlIl = MathHelper.clamp(llllllllllllllIIlIllllIlIlllIIIl.readInt(), 0, 32);
                    llllllllllllllIIlIllllIlIllIllIl.setSize(new BlockPos(llllllllllllllIIlIllllIlIllIIlll, llllllllllllllIIlIllllIlIllIIllI, llllllllllllllIIlIllllIlIllIIlIl));
                    final String llllllllllllllIIlIllllIlIllIIlII = llllllllllllllIIlIllllIlIlllIIIl.readStringFromBuffer(32);
                    llllllllllllllIIlIllllIlIllIllIl.setMirror(Mirror.valueOf(llllllllllllllIIlIllllIlIllIIlII));
                    final String llllllllllllllIIlIllllIlIllIIIll = llllllllllllllIIlIllllIlIlllIIIl.readStringFromBuffer(32);
                    llllllllllllllIIlIllllIlIllIllIl.setRotation(Rotation.valueOf(llllllllllllllIIlIllllIlIllIIIll));
                    llllllllllllllIIlIllllIlIllIllIl.setMetadata(llllllllllllllIIlIllllIlIlllIIIl.readStringFromBuffer(128));
                    llllllllllllllIIlIllllIlIllIllIl.setIgnoresEntities(llllllllllllllIIlIllllIlIlllIIIl.readBoolean());
                    llllllllllllllIIlIllllIlIllIllIl.setShowAir(llllllllllllllIIlIllllIlIlllIIIl.readBoolean());
                    llllllllllllllIIlIllllIlIllIllIl.setShowBoundingBox(llllllllllllllIIlIllllIlIlllIIIl.readBoolean());
                    llllllllllllllIIlIllllIlIllIllIl.setIntegrity(MathHelper.clamp(llllllllllllllIIlIllllIlIlllIIIl.readFloat(), 0.0f, 1.0f));
                    llllllllllllllIIlIllllIlIllIllIl.setSeed(llllllllllllllIIlIllllIlIlllIIIl.readVarLong());
                    final String llllllllllllllIIlIllllIlIllIIIlI = llllllllllllllIIlIllllIlIllIllIl.getName();
                    if (llllllllllllllIIlIllllIlIllIllII == 2) {
                        if (llllllllllllllIIlIllllIlIllIllIl.save()) {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.save_success", new Object[] { llllllllllllllIIlIllllIlIllIIIlI }), false);
                        }
                        else {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.save_failure", new Object[] { llllllllllllllIIlIllllIlIllIIIlI }), false);
                        }
                    }
                    else if (llllllllllllllIIlIllllIlIllIllII == 3) {
                        if (!llllllllllllllIIlIllllIlIllIllIl.isStructureLoadable()) {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.load_not_found", new Object[] { llllllllllllllIIlIllllIlIllIIIlI }), false);
                        }
                        else if (llllllllllllllIIlIllllIlIllIllIl.load()) {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.load_success", new Object[] { llllllllllllllIIlIllllIlIllIIIlI }), false);
                        }
                        else {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.load_prepare", new Object[] { llllllllllllllIIlIllllIlIllIIIlI }), false);
                        }
                    }
                    else if (llllllllllllllIIlIllllIlIllIllII == 4) {
                        if (llllllllllllllIIlIllllIlIllIllIl.detectSize()) {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.size_success", new Object[] { llllllllllllllIIlIllllIlIllIIIlI }), false);
                        }
                        else {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.size_failure", new Object[0]), false);
                        }
                    }
                    llllllllllllllIIlIllllIlIllIllIl.markDirty();
                    this.playerEntity.world.notifyBlockUpdate(llllllllllllllIIlIllllIlIlllIIII, llllllllllllllIIlIllllIlIllIllll, llllllllllllllIIlIllllIlIllIllll, 3);
                }
            }
            catch (Exception llllllllllllllIIlIllllIlIllIIIIl) {
                NetHandlerPlayServer.LOGGER.error("Couldn't set structure block", (Throwable)llllllllllllllIIlIllllIlIllIIIIl);
            }
        }
        else if ("MC|PickItem".equals(llllllllllllllIIlIllllIllIlIIIlI)) {
            final PacketBuffer llllllllllllllIIlIllllIlIllIIIII = llllllllllllllIIlIllllIllIlIIIll.getBufferData();
            try {
                final int llllllllllllllIIlIllllIlIlIlllll = llllllllllllllIIlIllllIlIllIIIII.readVarIntFromBuffer();
                this.playerEntity.inventory.pickItem(llllllllllllllIIlIllllIlIlIlllll);
                this.playerEntity.connection.sendPacket(new SPacketSetSlot(-2, this.playerEntity.inventory.currentItem, this.playerEntity.inventory.getStackInSlot(this.playerEntity.inventory.currentItem)));
                this.playerEntity.connection.sendPacket(new SPacketSetSlot(-2, llllllllllllllIIlIllllIlIlIlllll, this.playerEntity.inventory.getStackInSlot(llllllllllllllIIlIllllIlIlIlllll)));
                this.playerEntity.connection.sendPacket(new SPacketHeldItemChange(this.playerEntity.inventory.currentItem));
            }
            catch (Exception llllllllllllllIIlIllllIlIlIllllI) {
                NetHandlerPlayServer.LOGGER.error("Couldn't pick item", (Throwable)llllllllllllllIIlIllllIlIlIllllI);
            }
        }
    }
    
    public void setPlayerLocation(final double llllllllllllllIIlIllllllIIlIIIII, final double llllllllllllllIIlIllllllIIIlllll, final double llllllllllllllIIlIllllllIIIlIIII, final float llllllllllllllIIlIllllllIIIIllll, final float llllllllllllllIIlIllllllIIIIlllI, final Set<SPacketPlayerPosLook.EnumFlags> llllllllllllllIIlIllllllIIIIllIl) {
        final double llllllllllllllIIlIllllllIIIllIlI = llllllllllllllIIlIllllllIIIIllIl.contains(SPacketPlayerPosLook.EnumFlags.X) ? this.playerEntity.posX : 0.0;
        final double llllllllllllllIIlIllllllIIIllIIl = llllllllllllllIIlIllllllIIIIllIl.contains(SPacketPlayerPosLook.EnumFlags.Y) ? this.playerEntity.posY : 0.0;
        final double llllllllllllllIIlIllllllIIIllIII = llllllllllllllIIlIllllllIIIIllIl.contains(SPacketPlayerPosLook.EnumFlags.Z) ? this.playerEntity.posZ : 0.0;
        this.targetPos = new Vec3d(llllllllllllllIIlIllllllIIlIIIII + llllllllllllllIIlIllllllIIIllIlI, llllllllllllllIIlIllllllIIIlllll + llllllllllllllIIlIllllllIIIllIIl, llllllllllllllIIlIllllllIIIlIIII + llllllllllllllIIlIllllllIIIllIII);
        float llllllllllllllIIlIllllllIIIlIlll = llllllllllllllIIlIllllllIIIIllll;
        float llllllllllllllIIlIllllllIIIlIllI = llllllllllllllIIlIllllllIIIIlllI;
        if (llllllllllllllIIlIllllllIIIIllIl.contains(SPacketPlayerPosLook.EnumFlags.Y_ROT)) {
            llllllllllllllIIlIllllllIIIlIlll = llllllllllllllIIlIllllllIIIIllll + this.playerEntity.rotationYaw;
        }
        if (llllllllllllllIIlIllllllIIIIllIl.contains(SPacketPlayerPosLook.EnumFlags.X_ROT)) {
            llllllllllllllIIlIllllllIIIlIllI = llllllllllllllIIlIllllllIIIIlllI + this.playerEntity.rotationPitch;
        }
        if (++this.teleportId == Integer.MAX_VALUE) {
            this.teleportId = 0;
        }
        this.lastPositionUpdate = this.networkTickCount;
        this.playerEntity.setPositionAndRotation(this.targetPos.xCoord, this.targetPos.yCoord, this.targetPos.zCoord, llllllllllllllIIlIllllllIIIlIlll, llllllllllllllIIlIllllllIIIlIllI);
        this.playerEntity.connection.sendPacket(new SPacketPlayerPosLook(llllllllllllllIIlIllllllIIlIIIII, llllllllllllllIIlIllllllIIIlllll, llllllllllllllIIlIllllllIIIlIIII, llllllllllllllIIlIllllllIIIIllll, llllllllllllllIIlIllllllIIIIlllI, llllllllllllllIIlIllllllIIIIllIl, this.teleportId));
    }
    
    @Override
    public void processVehicleMove(final CPacketVehicleMove llllllllllllllIIlIlllllllIlIllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllllIlIllIl, this, this.playerEntity.getServerWorld());
        if (isMoveVehiclePacketInvalid(llllllllllllllIIlIlllllllIlIllIl)) {
            this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.invalid_vehicle_movement", new Object[0]));
        }
        else {
            final Entity llllllllllllllIIlIllllllllIIIIlI = this.playerEntity.getLowestRidingEntity();
            if (llllllllllllllIIlIllllllllIIIIlI != this.playerEntity && llllllllllllllIIlIllllllllIIIIlI.getControllingPassenger() == this.playerEntity && llllllllllllllIIlIllllllllIIIIlI == this.lowestRiddenEnt) {
                final WorldServer llllllllllllllIIlIllllllllIIIIIl = this.playerEntity.getServerWorld();
                final double llllllllllllllIIlIllllllllIIIIII = llllllllllllllIIlIllllllllIIIIlI.posX;
                final double llllllllllllllIIlIlllllllIllllll = llllllllllllllIIlIllllllllIIIIlI.posY;
                final double llllllllllllllIIlIlllllllIlllllI = llllllllllllllIIlIllllllllIIIIlI.posZ;
                final double llllllllllllllIIlIlllllllIllllIl = llllllllllllllIIlIlllllllIlIllIl.getX();
                final double llllllllllllllIIlIlllllllIllllII = llllllllllllllIIlIlllllllIlIllIl.getY();
                final double llllllllllllllIIlIlllllllIlllIll = llllllllllllllIIlIlllllllIlIllIl.getZ();
                final float llllllllllllllIIlIlllllllIlllIlI = llllllllllllllIIlIlllllllIlIllIl.getYaw();
                final float llllllllllllllIIlIlllllllIlllIIl = llllllllllllllIIlIlllllllIlIllIl.getPitch();
                double llllllllllllllIIlIlllllllIlllIII = llllllllllllllIIlIlllllllIllllIl - this.lowestRiddenX;
                double llllllllllllllIIlIlllllllIllIlll = llllllllllllllIIlIlllllllIllllII - this.lowestRiddenY;
                double llllllllllllllIIlIlllllllIllIllI = llllllllllllllIIlIlllllllIlllIll - this.lowestRiddenZ;
                final double llllllllllllllIIlIlllllllIllIlIl = llllllllllllllIIlIllllllllIIIIlI.motionX * llllllllllllllIIlIllllllllIIIIlI.motionX + llllllllllllllIIlIllllllllIIIIlI.motionY * llllllllllllllIIlIllllllllIIIIlI.motionY + llllllllllllllIIlIllllllllIIIIlI.motionZ * llllllllllllllIIlIllllllllIIIIlI.motionZ;
                double llllllllllllllIIlIlllllllIllIlII = llllllllllllllIIlIlllllllIlllIII * llllllllllllllIIlIlllllllIlllIII + llllllllllllllIIlIlllllllIllIlll * llllllllllllllIIlIlllllllIllIlll + llllllllllllllIIlIlllllllIllIllI * llllllllllllllIIlIlllllllIllIllI;
                if (llllllllllllllIIlIlllllllIllIlII - llllllllllllllIIlIlllllllIllIlIl > 100.0 && (!this.serverController.isSinglePlayer() || !this.serverController.getServerOwner().equals(llllllllllllllIIlIllllllllIIIIlI.getName()))) {
                    NetHandlerPlayServer.LOGGER.warn("{} (vehicle of {}) moved too quickly! {},{},{}", (Object)llllllllllllllIIlIllllllllIIIIlI.getName(), (Object)this.playerEntity.getName(), (Object)llllllllllllllIIlIlllllllIlllIII, (Object)llllllllllllllIIlIlllllllIllIlll, (Object)llllllllllllllIIlIlllllllIllIllI);
                    this.netManager.sendPacket(new SPacketMoveVehicle(llllllllllllllIIlIllllllllIIIIlI));
                    return;
                }
                final boolean llllllllllllllIIlIlllllllIllIIll = llllllllllllllIIlIllllllllIIIIIl.getCollisionBoxes(llllllllllllllIIlIllllllllIIIIlI, llllllllllllllIIlIllllllllIIIIlI.getEntityBoundingBox().contract(0.0625)).isEmpty();
                llllllllllllllIIlIlllllllIlllIII = llllllllllllllIIlIlllllllIllllIl - this.lowestRiddenX1;
                llllllllllllllIIlIlllllllIllIlll = llllllllllllllIIlIlllllllIllllII - this.lowestRiddenY1 - 1.0E-6;
                llllllllllllllIIlIlllllllIllIllI = llllllllllllllIIlIlllllllIlllIll - this.lowestRiddenZ1;
                llllllllllllllIIlIllllllllIIIIlI.moveEntity(MoverType.PLAYER, llllllllllllllIIlIlllllllIlllIII, llllllllllllllIIlIlllllllIllIlll, llllllllllllllIIlIlllllllIllIllI);
                final double llllllllllllllIIlIlllllllIllIIlI = llllllllllllllIIlIlllllllIllIlll;
                llllllllllllllIIlIlllllllIlllIII = llllllllllllllIIlIlllllllIllllIl - llllllllllllllIIlIllllllllIIIIlI.posX;
                llllllllllllllIIlIlllllllIllIlll = llllllllllllllIIlIlllllllIllllII - llllllllllllllIIlIllllllllIIIIlI.posY;
                if (llllllllllllllIIlIlllllllIllIlll > -0.5 || llllllllllllllIIlIlllllllIllIlll < 0.5) {
                    llllllllllllllIIlIlllllllIllIlll = 0.0;
                }
                llllllllllllllIIlIlllllllIllIllI = llllllllllllllIIlIlllllllIlllIll - llllllllllllllIIlIllllllllIIIIlI.posZ;
                llllllllllllllIIlIlllllllIllIlII = llllllllllllllIIlIlllllllIlllIII * llllllllllllllIIlIlllllllIlllIII + llllllllllllllIIlIlllllllIllIlll * llllllllllllllIIlIlllllllIllIlll + llllllllllllllIIlIlllllllIllIllI * llllllllllllllIIlIlllllllIllIllI;
                boolean llllllllllllllIIlIlllllllIllIIIl = false;
                if (llllllllllllllIIlIlllllllIllIlII > 0.0625) {
                    llllllllllllllIIlIlllllllIllIIIl = true;
                    NetHandlerPlayServer.LOGGER.warn("{} moved wrongly!", (Object)llllllllllllllIIlIllllllllIIIIlI.getName());
                }
                llllllllllllllIIlIllllllllIIIIlI.setPositionAndRotation(llllllllllllllIIlIlllllllIllllIl, llllllllllllllIIlIlllllllIllllII, llllllllllllllIIlIlllllllIlllIll, llllllllllllllIIlIlllllllIlllIlI, llllllllllllllIIlIlllllllIlllIIl);
                final boolean llllllllllllllIIlIlllllllIllIIII = llllllllllllllIIlIllllllllIIIIIl.getCollisionBoxes(llllllllllllllIIlIllllllllIIIIlI, llllllllllllllIIlIllllllllIIIIlI.getEntityBoundingBox().contract(0.0625)).isEmpty();
                if (llllllllllllllIIlIlllllllIllIIll && (llllllllllllllIIlIlllllllIllIIIl || !llllllllllllllIIlIlllllllIllIIII)) {
                    llllllllllllllIIlIllllllllIIIIlI.setPositionAndRotation(llllllllllllllIIlIllllllllIIIIII, llllllllllllllIIlIlllllllIllllll, llllllllllllllIIlIlllllllIlllllI, llllllllllllllIIlIlllllllIlllIlI, llllllllllllllIIlIlllllllIlllIIl);
                    this.netManager.sendPacket(new SPacketMoveVehicle(llllllllllllllIIlIllllllllIIIIlI));
                    return;
                }
                this.serverController.getPlayerList().serverUpdateMovingPlayer(this.playerEntity);
                this.playerEntity.addMovementStat(this.playerEntity.posX - llllllllllllllIIlIllllllllIIIIII, this.playerEntity.posY - llllllllllllllIIlIlllllllIllllll, this.playerEntity.posZ - llllllllllllllIIlIlllllllIlllllI);
                this.vehicleFloating = (llllllllllllllIIlIlllllllIllIIlI >= -0.03125 && !this.serverController.isFlightAllowed() && !llllllllllllllIIlIllllllllIIIIIl.checkBlockCollision(llllllllllllllIIlIllllllllIIIIlI.getEntityBoundingBox().expandXyz(0.0625).addCoord(0.0, -0.55, 0.0)));
                this.lowestRiddenX1 = llllllllllllllIIlIllllllllIIIIlI.posX;
                this.lowestRiddenY1 = llllllllllllllIIlIllllllllIIIIlI.posY;
                this.lowestRiddenZ1 = llllllllllllllIIlIllllllllIIIIlI.posZ;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action = NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action;
        if ($switch_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action;
        }
        final long llllllllllllllIIlIllllIlIlIIIlll = (Object)new int[CPacketEntityAction.Action.values().length];
        try {
            llllllllllllllIIlIllllIlIlIIIlll[CPacketEntityAction.Action.OPEN_INVENTORY.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIllllIlIlIIIlll[CPacketEntityAction.Action.START_FALL_FLYING.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIllllIlIlIIIlll[CPacketEntityAction.Action.START_RIDING_JUMP.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIlIllllIlIlIIIlll[CPacketEntityAction.Action.START_SNEAKING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIlIllllIlIlIIIlll[CPacketEntityAction.Action.START_SPRINTING.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIlIllllIlIlIIIlll[CPacketEntityAction.Action.STOP_RIDING_JUMP.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIIlIllllIlIlIIIlll[CPacketEntityAction.Action.STOP_SLEEPING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllIIlIllllIlIlIIIlll[CPacketEntityAction.Action.STOP_SNEAKING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllIIlIllllIlIlIIIlll[CPacketEntityAction.Action.STOP_SPRINTING.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        return NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action = (int[])(Object)llllllllllllllIIlIllllIlIlIIIlll;
    }
    
    public NetworkManager getNetworkManager() {
        return this.netManager;
    }
    
    @Override
    public void func_194027_a(final CPacketSeenAdvancements llllllllllllllIIlIlllllllIIIlIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllllIIIlIIl, this, this.playerEntity.getServerWorld());
        if (llllllllllllllIIlIlllllllIIIlIIl.func_194162_b() == CPacketSeenAdvancements.Action.OPENED_TAB) {
            final ResourceLocation llllllllllllllIIlIlllllllIIIlIII = llllllllllllllIIlIlllllllIIIlIIl.func_194165_c();
            final Advancement llllllllllllllIIlIlllllllIIIIlll = this.serverController.func_191949_aK().func_192778_a(llllllllllllllIIlIlllllllIIIlIII);
            if (llllllllllllllIIlIlllllllIIIIlll != null) {
                this.playerEntity.func_192039_O().func_194220_a(llllllllllllllIIlIlllllllIIIIlll);
            }
        }
    }
    
    private void handleSlashCommand(final String llllllllllllllIIlIlllllIIllllIIl) {
        this.serverController.getCommandManager().executeCommand(this.playerEntity, llllllllllllllIIlIlllllIIllllIIl);
    }
    
    @Override
    public void update() {
        this.captureCurrentPosition();
        this.playerEntity.onUpdateEntity();
        this.playerEntity.setPositionAndRotation(this.firstGoodX, this.firstGoodY, this.firstGoodZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
        ++this.networkTickCount;
        this.lastMovePacketCounter = this.movePacketCounter;
        if (this.floating) {
            if (++this.floatingTickCount > 80) {
                NetHandlerPlayServer.LOGGER.warn("{} was kicked for floating too long!", (Object)this.playerEntity.getName());
                this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.flying", new Object[0]));
                return;
            }
        }
        else {
            this.floating = false;
            this.floatingTickCount = 0;
        }
        this.lowestRiddenEnt = this.playerEntity.getLowestRidingEntity();
        if (this.lowestRiddenEnt != this.playerEntity && this.lowestRiddenEnt.getControllingPassenger() == this.playerEntity) {
            this.lowestRiddenX = this.lowestRiddenEnt.posX;
            this.lowestRiddenY = this.lowestRiddenEnt.posY;
            this.lowestRiddenZ = this.lowestRiddenEnt.posZ;
            this.lowestRiddenX1 = this.lowestRiddenEnt.posX;
            this.lowestRiddenY1 = this.lowestRiddenEnt.posY;
            this.lowestRiddenZ1 = this.lowestRiddenEnt.posZ;
            if (this.vehicleFloating && this.playerEntity.getLowestRidingEntity().getControllingPassenger() == this.playerEntity) {
                if (++this.vehicleFloatingTickCount > 80) {
                    NetHandlerPlayServer.LOGGER.warn("{} was kicked for floating a vehicle too long!", (Object)this.playerEntity.getName());
                    this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.flying", new Object[0]));
                    return;
                }
            }
            else {
                this.vehicleFloating = false;
                this.vehicleFloatingTickCount = 0;
            }
        }
        else {
            this.lowestRiddenEnt = null;
            this.vehicleFloating = false;
            this.vehicleFloatingTickCount = 0;
        }
        this.serverController.theProfiler.startSection("keepAlive");
        final long llllllllllllllIIlIllllllllllIlII = this.currentTimeMillis();
        if (llllllllllllllIIlIllllllllllIlII - this.field_194402_f >= 15000L) {
            if (this.field_194403_g) {
                this.func_194028_b(new TextComponentTranslation("disconnect.timeout", new Object[0]));
            }
            else {
                this.field_194403_g = true;
                this.field_194402_f = llllllllllllllIIlIllllllllllIlII;
                this.field_194404_h = llllllllllllllIIlIllllllllllIlII;
                this.sendPacket(new SPacketKeepAlive(this.field_194404_h));
            }
        }
        this.serverController.theProfiler.endSection();
        if (this.chatSpamThresholdCount > 0) {
            --this.chatSpamThresholdCount;
        }
        if (this.itemDropThreshold > 0) {
            --this.itemDropThreshold;
        }
        if (this.playerEntity.getLastActiveTime() > 0L && this.serverController.getMaxPlayerIdleMinutes() > 0 && MinecraftServer.getCurrentTimeMillis() - this.playerEntity.getLastActiveTime() > this.serverController.getMaxPlayerIdleMinutes() * 1000 * 60) {
            this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.idling", new Object[0]));
        }
    }
    
    private static boolean isMoveVehiclePacketInvalid(final CPacketVehicleMove llllllllllllllIIlIllllllllIllIll) {
        return !Doubles.isFinite(llllllllllllllIIlIllllllllIllIll.getX()) || !Doubles.isFinite(llllllllllllllIIlIllllllllIllIll.getY()) || !Doubles.isFinite(llllllllllllllIIlIllllllllIllIll.getZ()) || !Floats.isFinite(llllllllllllllIIlIllllllllIllIll.getPitch()) || !Floats.isFinite(llllllllllllllIIlIllllllllIllIll.getYaw());
    }
    
    @Override
    public void processCloseWindow(final CPacketCloseWindow llllllllllllllIIlIlllllIIIlllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIIlllllI, this, this.playerEntity.getServerWorld());
        this.playerEntity.closeContainer();
    }
    
    public void setPlayerLocation(final double llllllllllllllIIlIllllllIIlllIII, final double llllllllllllllIIlIllllllIIllIIIl, final double llllllllllllllIIlIllllllIIllIllI, final float llllllllllllllIIlIllllllIIlIllll, final float llllllllllllllIIlIllllllIIllIlII) {
        this.setPlayerLocation(llllllllllllllIIlIllllllIIlllIII, llllllllllllllIIlIllllllIIllIIIl, llllllllllllllIIlIllllllIIllIllI, llllllllllllllIIlIllllllIIlIllll, llllllllllllllIIlIllllllIIllIlII, Collections.emptySet());
    }
    
    @Override
    public void processPlayerDigging(final CPacketPlayerDigging llllllllllllllIIlIllllllIIIIIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIllllllIIIIIIII, this, this.playerEntity.getServerWorld());
        final WorldServer llllllllllllllIIlIlllllIllllllll = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final BlockPos llllllllllllllIIlIlllllIlllllllI = llllllllllllllIIlIllllllIIIIIIII.getPosition();
        this.playerEntity.markPlayerActive();
        switch ($SWITCH_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action()[llllllllllllllIIlIllllllIIIIIIII.getAction().ordinal()]) {
            case 7: {
                if (!this.playerEntity.isSpectator()) {
                    final ItemStack llllllllllllllIIlIlllllIllllllIl = this.playerEntity.getHeldItem(EnumHand.OFF_HAND);
                    this.playerEntity.setHeldItem(EnumHand.OFF_HAND, this.playerEntity.getHeldItem(EnumHand.MAIN_HAND));
                    this.playerEntity.setHeldItem(EnumHand.MAIN_HAND, llllllllllllllIIlIlllllIllllllIl);
                }
            }
            case 5: {
                if (!this.playerEntity.isSpectator()) {
                    this.playerEntity.dropItem(false);
                }
            }
            case 4: {
                if (!this.playerEntity.isSpectator()) {
                    this.playerEntity.dropItem(true);
                }
            }
            case 6: {
                this.playerEntity.stopActiveHand();
            }
            case 1:
            case 2:
            case 3: {
                final double llllllllllllllIIlIlllllIllllllII = this.playerEntity.posX - (llllllllllllllIIlIlllllIlllllllI.getX() + 0.5);
                final double llllllllllllllIIlIlllllIlllllIll = this.playerEntity.posY - (llllllllllllllIIlIlllllIlllllllI.getY() + 0.5) + 1.5;
                final double llllllllllllllIIlIlllllIlllllIlI = this.playerEntity.posZ - (llllllllllllllIIlIlllllIlllllllI.getZ() + 0.5);
                final double llllllllllllllIIlIlllllIlllllIIl = llllllllllllllIIlIlllllIllllllII * llllllllllllllIIlIlllllIllllllII + llllllllllllllIIlIlllllIlllllIll * llllllllllllllIIlIlllllIlllllIll + llllllllllllllIIlIlllllIlllllIlI * llllllllllllllIIlIlllllIlllllIlI;
                if (llllllllllllllIIlIlllllIlllllIIl > 36.0) {
                    return;
                }
                if (llllllllllllllIIlIlllllIlllllllI.getY() >= this.serverController.getBuildLimit()) {
                    return;
                }
                if (llllllllllllllIIlIllllllIIIIIIII.getAction() == CPacketPlayerDigging.Action.START_DESTROY_BLOCK) {
                    if (!this.serverController.isBlockProtected(llllllllllllllIIlIlllllIllllllll, llllllllllllllIIlIlllllIlllllllI, this.playerEntity) && llllllllllllllIIlIlllllIllllllll.getWorldBorder().contains(llllllllllllllIIlIlllllIlllllllI)) {
                        this.playerEntity.interactionManager.onBlockClicked(llllllllllllllIIlIlllllIlllllllI, llllllllllllllIIlIllllllIIIIIIII.getFacing());
                    }
                    else {
                        this.playerEntity.connection.sendPacket(new SPacketBlockChange(llllllllllllllIIlIlllllIllllllll, llllllllllllllIIlIlllllIlllllllI));
                    }
                }
                else {
                    if (llllllllllllllIIlIllllllIIIIIIII.getAction() == CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK) {
                        this.playerEntity.interactionManager.blockRemoving(llllllllllllllIIlIlllllIlllllllI);
                    }
                    else if (llllllllllllllIIlIllllllIIIIIIII.getAction() == CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK) {
                        this.playerEntity.interactionManager.cancelDestroyingBlock();
                    }
                    if (llllllllllllllIIlIlllllIllllllll.getBlockState(llllllllllllllIIlIlllllIlllllllI).getMaterial() != Material.AIR) {
                        this.playerEntity.connection.sendPacket(new SPacketBlockChange(llllllllllllllIIlIlllllIllllllll, llllllllllllllIIlIlllllIlllllllI));
                    }
                }
            }
            default: {
                throw new IllegalArgumentException("Invalid player action");
            }
        }
    }
    
    @Override
    public void processEnchantItem(final CPacketEnchantItem llllllllllllllIIlIlllllIIIIllIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllIIIIllIll, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        if (this.playerEntity.openContainer.windowId == llllllllllllllIIlIlllllIIIIllIll.getWindowId() && this.playerEntity.openContainer.getCanCraft(this.playerEntity) && !this.playerEntity.isSpectator()) {
            this.playerEntity.openContainer.enchantItem(this.playerEntity, llllllllllllllIIlIlllllIIIIllIll.getButton());
            this.playerEntity.openContainer.detectAndSendChanges();
        }
    }
    
    @Override
    public void processPlayerAbilities(final CPacketPlayerAbilities llllllllllllllIIlIllllIlllIIlllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIllllIlllIIlllI, this, this.playerEntity.getServerWorld());
        this.playerEntity.capabilities.isFlying = (llllllllllllllIIlIllllIlllIIlllI.isFlying() && this.playerEntity.capabilities.allowFlying);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode = NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
        }
        final int llllllllllllllIIlIllllIlIlIIIIll = (Object)new int[TileEntityCommandBlock.Mode.values().length];
        try {
            llllllllllllllIIlIllllIlIlIIIIll[TileEntityCommandBlock.Mode.AUTO.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIllllIlIlIIIIll[TileEntityCommandBlock.Mode.REDSTONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIllllIlIlIIIIll[TileEntityCommandBlock.Mode.SEQUENCE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode = (int[])(Object)llllllllllllllIIlIllllIlIlIIIIll;
    }
    
    @Override
    public void processConfirmTeleport(final CPacketConfirmTeleport llllllllllllllIIlIlllllllIIlIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllllIIlIlIl, this, this.playerEntity.getServerWorld());
        if (llllllllllllllIIlIlllllllIIlIlIl.getTeleportId() == this.teleportId) {
            this.playerEntity.setPositionAndRotation(this.targetPos.xCoord, this.targetPos.yCoord, this.targetPos.zCoord, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
            if (this.playerEntity.isInvulnerableDimensionChange()) {
                this.lastGoodX = this.targetPos.xCoord;
                this.lastGoodY = this.targetPos.yCoord;
                this.lastGoodZ = this.targetPos.zCoord;
                this.playerEntity.clearInvulnerableDimensionChange();
            }
            this.targetPos = null;
        }
    }
    
    @Override
    public void processKeepAlive(final CPacketKeepAlive llllllllllllllIIlIllllIlllIlIlll) {
        if (this.field_194403_g && llllllllllllllIIlIllllIlllIlIlll.getKey() == this.field_194404_h) {
            final int llllllllllllllIIlIllllIlllIlIllI = (int)(this.currentTimeMillis() - this.field_194402_f);
            this.playerEntity.ping = (this.playerEntity.ping * 3 + llllllllllllllIIlIllllIlllIlIllI) / 4;
            this.field_194403_g = false;
        }
        else if (!this.playerEntity.getName().equals(this.serverController.getServerOwner())) {
            this.func_194028_b(new TextComponentTranslation("disconnect.timeout", new Object[0]));
        }
    }
    
    public NetHandlerPlayServer(final MinecraftServer llllllllllllllIIlIlllllllllllIlI, final NetworkManager llllllllllllllIIlIlllllllllllIIl, final EntityPlayerMP llllllllllllllIIlIllllllllllllII) {
        this.pendingTransactions = new IntHashMap<Short>();
        this.field_194309_H = new ServerRecipeBookHelper();
        this.serverController = llllllllllllllIIlIlllllllllllIlI;
        this.netManager = llllllllllllllIIlIlllllllllllIIl;
        llllllllllllllIIlIlllllllllllIIl.setNetHandler(this);
        this.playerEntity = llllllllllllllIIlIllllllllllllII;
        llllllllllllllIIlIllllllllllllII.connection = this;
    }
    
    @Override
    public void processInput(final CPacketInput llllllllllllllIIlIlllllllllIIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlllllllllIIIlI, this, this.playerEntity.getServerWorld());
        this.playerEntity.setEntityActionState(llllllllllllllIIlIlllllllllIIIlI.getStrafeSpeed(), llllllllllllllIIlIlllllllllIIIlI.func_192620_b(), llllllllllllllIIlIlllllllllIIIlI.isJumping(), llllllllllllllIIlIlllllllllIIIlI.isSneaking());
    }
}
