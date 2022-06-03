// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.multiplayer;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.ActionResult;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import net.minecraft.stats.RecipeBook;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.network.play.client.CPacketPlaceRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.inventory.ClickType;
import net.minecraft.block.BlockStructure;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.CPacketUseEntity;
import ru.rockstar.api.event.event.EventAttackSilent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.SoundCategory;
import net.minecraft.block.material.Material;
import ru.rockstar.api.event.event.EventBlockInteract;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumFacing;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketEnchantItem;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCreativeInventoryAction;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.Minecraft;

public class PlayerControllerMP
{
    private final /* synthetic */ Minecraft mc;
    public /* synthetic */ float stepSoundTickCounter;
    private final /* synthetic */ NetHandlerPlayClient connection;
    public /* synthetic */ int blockHitDelay;
    private /* synthetic */ ItemStack currentItemHittingBlock;
    private /* synthetic */ BlockPos currentBlock;
    private /* synthetic */ int currentPlayerItem;
    private /* synthetic */ boolean isHittingBlock;
    public /* synthetic */ float curBlockDamageMP;
    private /* synthetic */ GameType currentGameType;
    
    public void sendSlotPacket(final ItemStack llllllllllllIlllIlIllllllIllIllI, final int llllllllllllIlllIlIllllllIllIIlI) {
        if (this.currentGameType.isCreative()) {
            this.connection.sendPacket(new CPacketCreativeInventoryAction(llllllllllllIlllIlIllllllIllIIlI, llllllllllllIlllIlIllllllIllIllI));
        }
    }
    
    public void sendEnchantPacket(final int llllllllllllIlllIlIllllllIllllII, final int llllllllllllIlllIlIllllllIlllIll) {
        this.connection.sendPacket(new CPacketEnchantItem(llllllllllllIlllIlIllllllIllllII, llllllllllllIlllIlIllllllIlllIll));
    }
    
    public boolean isSpectator() {
        return this.currentGameType == GameType.SPECTATOR;
    }
    
    public boolean isSpectatorMode() {
        return this.currentGameType == GameType.SPECTATOR;
    }
    
    public void onStoppedUsingItem(final EntityPlayer llllllllllllIlllIlIllllllIlIlIII) {
        this.syncCurrentPlayItem();
        this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
        llllllllllllIlllIlIllllllIlIlIII.stopActiveHand();
    }
    
    private void syncCurrentPlayItem() {
        final int llllllllllllIlllIllIIIIIIllIlIll = Minecraft.getMinecraft().player.inventory.currentItem;
        if (llllllllllllIlllIllIIIIIIllIlIll != this.currentPlayerItem) {
            this.currentPlayerItem = llllllllllllIlllIllIIIIIIllIlIll;
            this.connection.sendPacket(new CPacketHeldItemChange(this.currentPlayerItem));
        }
    }
    
    public boolean onPlayerDamageBlock(final BlockPos llllllllllllIlllIllIIIIIlIIlIIII, final EnumFacing llllllllllllIlllIllIIIIIlIIIllll) {
        this.syncCurrentPlayItem();
        final EventBlockInteract llllllllllllIlllIllIIIIIlIIIlllI = new EventBlockInteract(llllllllllllIlllIllIIIIIlIIlIIII, llllllllllllIlllIllIIIIIlIIIllll);
        llllllllllllIlllIllIIIIIlIIIlllI.call();
        if (llllllllllllIlllIllIIIIIlIIIlllI.isCancelled()) {
            return false;
        }
        if (this.blockHitDelay > 0) {
            --this.blockHitDelay;
            return true;
        }
        if (this.currentGameType.isCreative() && this.mc.world.getWorldBorder().contains(llllllllllllIlllIllIIIIIlIIlIIII)) {
            this.blockHitDelay = 5;
            this.mc.func_193032_ao().func_193294_a(this.mc.world, llllllllllllIlllIllIIIIIlIIlIIII, this.mc.world.getBlockState(llllllllllllIlllIllIIIIIlIIlIIII), 1.0f);
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, llllllllllllIlllIllIIIIIlIIlIIII, llllllllllllIlllIllIIIIIlIIIllll));
            clickBlockCreative(this.mc, this, llllllllllllIlllIllIIIIIlIIlIIII, llllllllllllIlllIllIIIIIlIIIllll);
            return true;
        }
        if (!this.isHittingPosition(llllllllllllIlllIllIIIIIlIIlIIII)) {
            return this.clickBlock(llllllllllllIlllIllIIIIIlIIlIIII, llllllllllllIlllIllIIIIIlIIIllll);
        }
        final IBlockState llllllllllllIlllIllIIIIIlIIIllIl = this.mc.world.getBlockState(llllllllllllIlllIllIIIIIlIIlIIII);
        final Block llllllllllllIlllIllIIIIIlIIIllII = llllllllllllIlllIllIIIIIlIIIllIl.getBlock();
        if (llllllllllllIlllIllIIIIIlIIIllIl.getMaterial() == Material.AIR) {
            this.isHittingBlock = false;
            return false;
        }
        this.curBlockDamageMP += llllllllllllIlllIllIIIIIlIIIllIl.getPlayerRelativeBlockHardness(Minecraft.getMinecraft().player, Minecraft.getMinecraft().player.world, llllllllllllIlllIllIIIIIlIIlIIII);
        if (this.stepSoundTickCounter % 4.0f == 0.0f) {
            final SoundType llllllllllllIlllIllIIIIIlIIIlIll = llllllllllllIlllIllIIIIIlIIIllII.getSoundType();
            this.mc.getSoundHandler().playSound(new PositionedSoundRecord(llllllllllllIlllIllIIIIIlIIIlIll.getHitSound(), SoundCategory.NEUTRAL, (llllllllllllIlllIllIIIIIlIIIlIll.getVolume() + 1.0f) / 8.0f, llllllllllllIlllIllIIIIIlIIIlIll.getPitch() * 0.5f, llllllllllllIlllIllIIIIIlIIlIIII));
        }
        ++this.stepSoundTickCounter;
        this.mc.func_193032_ao().func_193294_a(this.mc.world, llllllllllllIlllIllIIIIIlIIlIIII, llllllllllllIlllIllIIIIIlIIIllIl, MathHelper.clamp(this.curBlockDamageMP, 0.0f, 1.0f));
        if (this.curBlockDamageMP >= 1.0f) {
            this.isHittingBlock = false;
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, llllllllllllIlllIllIIIIIlIIlIIII, llllllllllllIlllIllIIIIIlIIIllll));
            this.onPlayerDestroyBlock(llllllllllllIlllIllIIIIIlIIlIIII);
            this.curBlockDamageMP = 0.0f;
            this.stepSoundTickCounter = 0.0f;
            this.blockHitDelay = 5;
        }
        this.mc.world.sendBlockBreakProgress(Minecraft.getMinecraft().player.getEntityId(), this.currentBlock, (int)(this.curBlockDamageMP * 10.0f) - 1);
        return true;
    }
    
    public void setPlayerCapabilities(final EntityPlayer llllllllllllIlllIllIIIIIllIlIlll) {
        this.currentGameType.configurePlayerCapabilities(llllllllllllIlllIllIIIIIllIlIlll.capabilities);
    }
    
    public boolean isRidingHorse() {
        return Minecraft.getMinecraft().player.isRiding() && Minecraft.getMinecraft().player.getRidingEntity() instanceof AbstractHorse;
    }
    
    public void attackEntity(final EntityPlayer llllllllllllIlllIllIIIIIIIIIlIIl, final Entity llllllllllllIlllIllIIIIIIIIIlIII) {
        final EventAttackSilent llllllllllllIlllIllIIIIIIIIIlIll = new EventAttackSilent(llllllllllllIlllIllIIIIIIIIIlIII);
        llllllllllllIlllIllIIIIIIIIIlIll.call();
        if (llllllllllllIlllIllIIIIIIIIIlIll.isCancelled()) {
            return;
        }
        this.syncCurrentPlayItem();
        this.connection.sendPacket(new CPacketUseEntity(llllllllllllIlllIllIIIIIIIIIlIII));
        if (this.currentGameType != GameType.SPECTATOR) {
            llllllllllllIlllIllIIIIIIIIIlIIl.attackTargetEntityWithCurrentItem(llllllllllllIlllIllIIIIIIIIIlIII);
            llllllllllllIlllIllIIIIIIIIIlIIl.resetCooldown();
        }
    }
    
    public EnumActionResult processRightClickBlock(final EntityPlayerSP llllllllllllIlllIllIIIIIIlIIIlIl, final WorldClient llllllllllllIlllIllIIIIIIlIlIllI, final BlockPos llllllllllllIlllIllIIIIIIlIlIlIl, final EnumFacing llllllllllllIlllIllIIIIIIlIlIlII, final Vec3d llllllllllllIlllIllIIIIIIlIIIIIl, final EnumHand llllllllllllIlllIllIIIIIIlIIIIII) {
        this.syncCurrentPlayItem();
        final ItemStack llllllllllllIlllIllIIIIIIlIlIIIl = llllllllllllIlllIllIIIIIIlIIIlIl.getHeldItem(llllllllllllIlllIllIIIIIIlIIIIII);
        final float llllllllllllIlllIllIIIIIIlIlIIII = (float)(llllllllllllIlllIllIIIIIIlIIIIIl.xCoord - llllllllllllIlllIllIIIIIIlIlIlIl.getX());
        final float llllllllllllIlllIllIIIIIIlIIllll = (float)(llllllllllllIlllIllIIIIIIlIIIIIl.yCoord - llllllllllllIlllIllIIIIIIlIlIlIl.getY());
        final float llllllllllllIlllIllIIIIIIlIIlllI = (float)(llllllllllllIlllIllIIIIIIlIIIIIl.zCoord - llllllllllllIlllIllIIIIIIlIlIlIl.getZ());
        boolean llllllllllllIlllIllIIIIIIlIIllIl = false;
        if (!this.mc.world.getWorldBorder().contains(llllllllllllIlllIllIIIIIIlIlIlIl)) {
            return EnumActionResult.FAIL;
        }
        if (this.currentGameType != GameType.SPECTATOR) {
            final IBlockState llllllllllllIlllIllIIIIIIlIIlIll = llllllllllllIlllIllIIIIIIlIlIllI.getBlockState(llllllllllllIlllIllIIIIIIlIlIlIl);
            if ((!llllllllllllIlllIllIIIIIIlIIIlIl.isSneaking() || (llllllllllllIlllIllIIIIIIlIIIlIl.getHeldItemMainhand().func_190926_b() && llllllllllllIlllIllIIIIIIlIIIlIl.getHeldItemOffhand().func_190926_b())) && llllllllllllIlllIllIIIIIIlIIlIll.getBlock().onBlockActivated(llllllllllllIlllIllIIIIIIlIlIllI, llllllllllllIlllIllIIIIIIlIlIlIl, llllllllllllIlllIllIIIIIIlIIlIll, llllllllllllIlllIllIIIIIIlIIIlIl, llllllllllllIlllIllIIIIIIlIIIIII, llllllllllllIlllIllIIIIIIlIlIlII, llllllllllllIlllIllIIIIIIlIlIIII, llllllllllllIlllIllIIIIIIlIIllll, llllllllllllIlllIllIIIIIIlIIlllI)) {
                llllllllllllIlllIllIIIIIIlIIllIl = true;
            }
            final ItemBlock llllllllllllIlllIllIIIIIIlIIllII;
            if (!llllllllllllIlllIllIIIIIIlIIllIl && llllllllllllIlllIllIIIIIIlIlIIIl.getItem() instanceof ItemBlock && !(llllllllllllIlllIllIIIIIIlIIllII = (ItemBlock)llllllllllllIlllIllIIIIIIlIlIIIl.getItem()).canPlaceBlockOnSide(llllllllllllIlllIllIIIIIIlIlIllI, llllllllllllIlllIllIIIIIIlIlIlIl, llllllllllllIlllIllIIIIIIlIlIlII, llllllllllllIlllIllIIIIIIlIIIlIl, llllllllllllIlllIllIIIIIIlIlIIIl)) {
                return EnumActionResult.FAIL;
            }
        }
        this.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(llllllllllllIlllIllIIIIIIlIlIlIl, llllllllllllIlllIllIIIIIIlIlIlII, llllllllllllIlllIllIIIIIIlIIIIII, llllllllllllIlllIllIIIIIIlIlIIII, llllllllllllIlllIllIIIIIIlIIllll, llllllllllllIlllIllIIIIIIlIIlllI));
        if (llllllllllllIlllIllIIIIIIlIIllIl || this.currentGameType == GameType.SPECTATOR) {
            return EnumActionResult.SUCCESS;
        }
        if (llllllllllllIlllIllIIIIIIlIlIIIl.func_190926_b()) {
            return EnumActionResult.PASS;
        }
        if (llllllllllllIlllIllIIIIIIlIIIlIl.getCooldownTracker().hasCooldown(llllllllllllIlllIllIIIIIIlIlIIIl.getItem())) {
            return EnumActionResult.PASS;
        }
        final Block llllllllllllIlllIllIIIIIIlIIlIlI;
        if (llllllllllllIlllIllIIIIIIlIlIIIl.getItem() instanceof ItemBlock && !llllllllllllIlllIllIIIIIIlIIIlIl.canUseCommandBlock() && ((llllllllllllIlllIllIIIIIIlIIlIlI = ((ItemBlock)llllllllllllIlllIllIIIIIIlIlIIIl.getItem()).getBlock()) instanceof BlockCommandBlock || llllllllllllIlllIllIIIIIIlIIlIlI instanceof BlockStructure)) {
            return EnumActionResult.FAIL;
        }
        if (this.currentGameType.isCreative()) {
            final int llllllllllllIlllIllIIIIIIlIIlIIl = llllllllllllIlllIllIIIIIIlIlIIIl.getMetadata();
            final int llllllllllllIlllIllIIIIIIlIIlIII = llllllllllllIlllIllIIIIIIlIlIIIl.func_190916_E();
            final EnumActionResult llllllllllllIlllIllIIIIIIlIIIlll = llllllllllllIlllIllIIIIIIlIlIIIl.onItemUse(llllllllllllIlllIllIIIIIIlIIIlIl, llllllllllllIlllIllIIIIIIlIlIllI, llllllllllllIlllIllIIIIIIlIlIlIl, llllllllllllIlllIllIIIIIIlIIIIII, llllllllllllIlllIllIIIIIIlIlIlII, llllllllllllIlllIllIIIIIIlIlIIII, llllllllllllIlllIllIIIIIIlIIllll, llllllllllllIlllIllIIIIIIlIIlllI);
            llllllllllllIlllIllIIIIIIlIlIIIl.setItemDamage(llllllllllllIlllIllIIIIIIlIIlIIl);
            llllllllllllIlllIllIIIIIIlIlIIIl.func_190920_e(llllllllllllIlllIllIIIIIIlIIlIII);
            return llllllllllllIlllIllIIIIIIlIIIlll;
        }
        return llllllllllllIlllIllIIIIIIlIlIIIl.onItemUse(llllllllllllIlllIllIIIIIIlIIIlIl, llllllllllllIlllIllIIIIIIlIlIllI, llllllllllllIlllIllIIIIIIlIlIlIl, llllllllllllIlllIllIIIIIIlIIIIII, llllllllllllIlllIllIIIIIIlIlIlII, llllllllllllIlllIllIIIIIIlIlIIII, llllllllllllIlllIllIIIIIIlIIllll, llllllllllllIlllIllIIIIIIlIIlllI);
    }
    
    public float getBlockReachDistance() {
        return this.currentGameType.isCreative() ? 5.0f : 4.5f;
    }
    
    public boolean clickBlock(final BlockPos llllllllllllIlllIllIIIIIlIlIIIII, final EnumFacing llllllllllllIlllIllIIIIIlIIlllll) {
        if (this.currentGameType.isAdventure()) {
            if (this.currentGameType == GameType.SPECTATOR) {
                return false;
            }
            if (!Minecraft.getMinecraft().player.isAllowEdit()) {
                final ItemStack llllllllllllIlllIllIIIIIlIlIIlII = Minecraft.getMinecraft().player.getHeldItemMainhand();
                if (llllllllllllIlllIllIIIIIlIlIIlII.func_190926_b()) {
                    return false;
                }
                if (!llllllllllllIlllIllIIIIIlIlIIlII.canDestroy(this.mc.world.getBlockState(llllllllllllIlllIllIIIIIlIlIIIII).getBlock())) {
                    return false;
                }
            }
        }
        if (!this.mc.world.getWorldBorder().contains(llllllllllllIlllIllIIIIIlIlIIIII)) {
            return false;
        }
        if (this.currentGameType.isCreative()) {
            this.mc.func_193032_ao().func_193294_a(this.mc.world, llllllllllllIlllIllIIIIIlIlIIIII, this.mc.world.getBlockState(llllllllllllIlllIllIIIIIlIlIIIII), 1.0f);
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, llllllllllllIlllIllIIIIIlIlIIIII, llllllllllllIlllIllIIIIIlIIlllll));
            clickBlockCreative(this.mc, this, llllllllllllIlllIllIIIIIlIlIIIII, llllllllllllIlllIllIIIIIlIIlllll);
            this.blockHitDelay = 5;
            return true;
        }
        if (this.isHittingBlock && this.isHittingPosition(llllllllllllIlllIllIIIIIlIlIIIII)) {
            return true;
        }
        if (this.isHittingBlock) {
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.currentBlock, llllllllllllIlllIllIIIIIlIIlllll));
        }
        final IBlockState llllllllllllIlllIllIIIIIlIlIIIll = this.mc.world.getBlockState(llllllllllllIlllIllIIIIIlIlIIIII);
        this.mc.func_193032_ao().func_193294_a(this.mc.world, llllllllllllIlllIllIIIIIlIlIIIII, llllllllllllIlllIllIIIIIlIlIIIll, 0.0f);
        this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, llllllllllllIlllIllIIIIIlIlIIIII, llllllllllllIlllIllIIIIIlIIlllll));
        final boolean llllllllllllIlllIllIIIIIlIlIIIlI;
        final boolean llllllllllllIlllIllIIIIIlIlIIlIl = llllllllllllIlllIllIIIIIlIlIIIlI = (llllllllllllIlllIllIIIIIlIlIIIll.getMaterial() != Material.AIR);
        if (llllllllllllIlllIllIIIIIlIlIIlIl && this.curBlockDamageMP == 0.0f) {
            llllllllllllIlllIllIIIIIlIlIIIll.getBlock().onBlockClicked(this.mc.world, llllllllllllIlllIllIIIIIlIlIIIII, Minecraft.getMinecraft().player);
        }
        if (llllllllllllIlllIllIIIIIlIlIIlIl && llllllllllllIlllIllIIIIIlIlIIIll.getPlayerRelativeBlockHardness(Minecraft.getMinecraft().player, Minecraft.getMinecraft().player.world, llllllllllllIlllIllIIIIIlIlIIIII) >= 1.0f) {
            this.onPlayerDestroyBlock(llllllllllllIlllIllIIIIIlIlIIIII);
            return true;
        }
        this.isHittingBlock = true;
        this.currentBlock = llllllllllllIlllIllIIIIIlIlIIIII;
        this.currentItemHittingBlock = Minecraft.getMinecraft().player.getHeldItemMainhand();
        this.curBlockDamageMP = 0.0f;
        this.stepSoundTickCounter = 0.0f;
        this.mc.world.sendBlockBreakProgress(Minecraft.getMinecraft().player.getEntityId(), this.currentBlock, (int)(this.curBlockDamageMP * 10.0f) - 1);
        return true;
    }
    
    public boolean getIsHittingBlock() {
        return this.isHittingBlock;
    }
    
    public PlayerControllerMP(final Minecraft llllllllllllIlllIllIIIIIlllIlIII, final NetHandlerPlayClient llllllllllllIlllIllIIIIIlllIIlll) {
        this.currentBlock = new BlockPos(-1, -1, -1);
        this.currentItemHittingBlock = ItemStack.field_190927_a;
        this.currentGameType = GameType.SURVIVAL;
        this.mc = llllllllllllIlllIllIIIIIlllIlIII;
        this.connection = llllllllllllIlllIllIIIIIlllIIlll;
    }
    
    public void updateController() {
        this.syncCurrentPlayItem();
        if (this.connection.getNetworkManager().isChannelOpen()) {
            this.connection.getNetworkManager().processReceivedPackets();
        }
        else {
            this.connection.getNetworkManager().checkDisconnected();
        }
    }
    
    public static void clickBlockCreative(final Minecraft llllllllllllIlllIllIIIIIlllIIIlI, final PlayerControllerMP llllllllllllIlllIllIIIIIlllIIIIl, final BlockPos llllllllllllIlllIllIIIIIllIlllII, final EnumFacing llllllllllllIlllIllIIIIIllIllIll) {
        if (!llllllllllllIlllIllIIIIIlllIIIlI.world.extinguishFire(Minecraft.getMinecraft().player, llllllllllllIlllIllIIIIIllIlllII, llllllllllllIlllIllIIIIIllIllIll)) {
            llllllllllllIlllIllIIIIIlllIIIIl.onPlayerDestroyBlock(llllllllllllIlllIllIIIIIllIlllII);
        }
    }
    
    public boolean extendedReach() {
        return this.currentGameType.isCreative();
    }
    
    public ItemStack windowClick(final int llllllllllllIlllIlIlllllllIlllll, final int llllllllllllIlllIlIlllllllIlIllI, final int llllllllllllIlllIlIlllllllIlllIl, final ClickType llllllllllllIlllIlIlllllllIlllII, final EntityPlayer llllllllllllIlllIlIlllllllIlIIll) {
        final short llllllllllllIlllIlIlllllllIllIlI = llllllllllllIlllIlIlllllllIlIIll.openContainer.getNextTransactionID(llllllllllllIlllIlIlllllllIlIIll.inventory);
        final ItemStack llllllllllllIlllIlIlllllllIllIIl = llllllllllllIlllIlIlllllllIlIIll.openContainer.slotClick(llllllllllllIlllIlIlllllllIlIllI, llllllllllllIlllIlIlllllllIlllIl, llllllllllllIlllIlIlllllllIlllII, llllllllllllIlllIlIlllllllIlIIll);
        this.connection.sendPacket(new CPacketClickWindow(llllllllllllIlllIlIlllllllIlllll, llllllllllllIlllIlIlllllllIlIllI, llllllllllllIlllIlIlllllllIlllIl, llllllllllllIlllIlIlllllllIlllII, llllllllllllIlllIlIlllllllIllIIl, llllllllllllIlllIlIlllllllIllIlI));
        return llllllllllllIlllIlIlllllllIllIIl;
    }
    
    public boolean isNotCreative() {
        return !this.currentGameType.isCreative();
    }
    
    public boolean onPlayerDestroyBlock(final BlockPos llllllllllllIlllIllIIIIIlIllIlII) {
        if (this.currentGameType.isAdventure()) {
            if (this.currentGameType == GameType.SPECTATOR) {
                return false;
            }
            if (!Minecraft.getMinecraft().player.isAllowEdit()) {
                final ItemStack llllllllllllIlllIllIIIIIlIlllIII = Minecraft.getMinecraft().player.getHeldItemMainhand();
                if (llllllllllllIlllIllIIIIIlIlllIII.func_190926_b()) {
                    return false;
                }
                if (!llllllllllllIlllIllIIIIIlIlllIII.canDestroy(this.mc.world.getBlockState(llllllllllllIlllIllIIIIIlIllIlII).getBlock())) {
                    return false;
                }
            }
        }
        if (this.currentGameType.isCreative() && !Minecraft.getMinecraft().player.getHeldItemMainhand().func_190926_b() && Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof ItemSword) {
            return false;
        }
        final WorldClient llllllllllllIlllIllIIIIIlIlllIll;
        final IBlockState llllllllllllIlllIllIIIIIlIlllIlI;
        final Block llllllllllllIlllIllIIIIIlIlllIIl;
        if (((llllllllllllIlllIllIIIIIlIlllIIl = (llllllllllllIlllIllIIIIIlIlllIlI = (llllllllllllIlllIllIIIIIlIlllIll = this.mc.world).getBlockState(llllllllllllIlllIllIIIIIlIllIlII)).getBlock()) instanceof BlockCommandBlock || llllllllllllIlllIllIIIIIlIlllIIl instanceof BlockStructure) && !Minecraft.getMinecraft().player.canUseCommandBlock()) {
            return false;
        }
        if (llllllllllllIlllIllIIIIIlIlllIlI.getMaterial() == Material.AIR) {
            return false;
        }
        llllllllllllIlllIllIIIIIlIlllIll.playEvent(2001, llllllllllllIlllIllIIIIIlIllIlII, Block.getStateId(llllllllllllIlllIllIIIIIlIlllIlI));
        llllllllllllIlllIllIIIIIlIlllIIl.onBlockHarvested(llllllllllllIlllIllIIIIIlIlllIll, llllllllllllIlllIllIIIIIlIllIlII, llllllllllllIlllIllIIIIIlIlllIlI, Minecraft.getMinecraft().player);
        final boolean llllllllllllIlllIllIIIIIlIllIlll = llllllllllllIlllIllIIIIIlIlllIll.setBlockState(llllllllllllIlllIllIIIIIlIllIlII, Blocks.AIR.getDefaultState(), 11);
        if (llllllllllllIlllIllIIIIIlIllIlll) {
            llllllllllllIlllIllIIIIIlIlllIIl.onBlockDestroyedByPlayer(llllllllllllIlllIllIIIIIlIlllIll, llllllllllllIlllIllIIIIIlIllIlII, llllllllllllIlllIllIIIIIlIlllIlI);
        }
        this.currentBlock = new BlockPos(this.currentBlock.getX(), -1, this.currentBlock.getZ());
        if (!this.currentGameType.isCreative()) {
            final ItemStack llllllllllllIlllIllIIIIIlIllIllI = Minecraft.getMinecraft().player.getHeldItemMainhand();
            if (!llllllllllllIlllIllIIIIIlIllIllI.func_190926_b()) {
                llllllllllllIlllIllIIIIIlIllIllI.onBlockDestroyed(llllllllllllIlllIllIIIIIlIlllIll, llllllllllllIlllIllIIIIIlIlllIlI, llllllllllllIlllIllIIIIIlIllIlII, Minecraft.getMinecraft().player);
                if (llllllllllllIlllIllIIIIIlIllIllI.func_190926_b()) {
                    Minecraft.getMinecraft().player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.field_190927_a);
                }
            }
        }
        return llllllllllllIlllIllIIIIIlIllIlll;
    }
    
    public boolean shouldDrawHUD() {
        return this.currentGameType.isSurvivalOrAdventure();
    }
    
    public boolean isInCreativeMode() {
        return this.currentGameType.isCreative();
    }
    
    public void setGameType(final GameType llllllllllllIlllIllIIIIIllIIllII) {
        this.currentGameType = llllllllllllIlllIllIIIIIllIIllII;
        this.currentGameType.configurePlayerCapabilities(Minecraft.getMinecraft().player.capabilities);
    }
    
    public boolean gameIsSurvivalOrAdventure() {
        return this.currentGameType.isSurvivalOrAdventure();
    }
    
    public EnumActionResult interactWithEntity(final EntityPlayer llllllllllllIlllIllIIIIIIIIIIIIl, final Entity llllllllllllIlllIllIIIIIIIIIIIII, final EnumHand llllllllllllIlllIlIlllllllllllll) {
        this.syncCurrentPlayItem();
        this.connection.sendPacket(new CPacketUseEntity(llllllllllllIlllIllIIIIIIIIIIIII, llllllllllllIlllIlIlllllllllllll));
        return (this.currentGameType == GameType.SPECTATOR) ? EnumActionResult.PASS : llllllllllllIlllIllIIIIIIIIIIIIl.func_190775_a(llllllllllllIlllIllIIIIIIIIIIIII, llllllllllllIlllIlIlllllllllllll);
    }
    
    public void func_194338_a(final int llllllllllllIlllIlIlllllllIIIllI, final IRecipe llllllllllllIlllIlIlllllllIIIlIl, final boolean llllllllllllIlllIlIlllllllIIIlII, final EntityPlayer llllllllllllIlllIlIlllllllIIlIII) {
        this.connection.sendPacket(new CPacketPlaceRecipe(llllllllllllIlllIlIlllllllIIIllI, llllllllllllIlllIlIlllllllIIIlIl, llllllllllllIlllIlIlllllllIIIlII));
    }
    
    public void sendPacketDropItem(final ItemStack llllllllllllIlllIlIllllllIlIlllI) {
        if (this.currentGameType.isCreative() && !llllllllllllIlllIlIllllllIlIlllI.func_190926_b()) {
            this.connection.sendPacket(new CPacketCreativeInventoryAction(-1, llllllllllllIlllIlIllllllIlIlllI));
        }
    }
    
    public EntityPlayerSP func_192830_a(final World llllllllllllIlllIllIIIIIIIIlIlIl, final StatisticsManager llllllllllllIlllIllIIIIIIIIllIII, final RecipeBook llllllllllllIlllIllIIIIIIIIlIlll) {
        return new EntityPlayerSP(this.mc, llllllllllllIlllIllIIIIIIIIlIlIl, this.connection, llllllllllllIlllIllIIIIIIIIllIII, llllllllllllIlllIllIIIIIIIIlIlll);
    }
    
    public void resetBlockRemoving() {
        if (this.isHittingBlock) {
            this.mc.func_193032_ao().func_193294_a(this.mc.world, this.currentBlock, this.mc.world.getBlockState(this.currentBlock), -1.0f);
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.currentBlock, EnumFacing.DOWN));
            this.isHittingBlock = false;
            this.curBlockDamageMP = 0.0f;
            this.mc.world.sendBlockBreakProgress(Minecraft.getMinecraft().player.getEntityId(), this.currentBlock, -1);
            Minecraft.getMinecraft().player.resetCooldown();
        }
    }
    
    public void pickItem(final int llllllllllllIlllIlIllllllIIIllII) {
        this.connection.sendPacket(new CPacketCustomPayload("MC|PickItem", new PacketBuffer(Unpooled.buffer()).writeVarIntToBuffer(llllllllllllIlllIlIllllllIIIllII)));
    }
    
    public GameType getCurrentGameType() {
        return this.currentGameType;
    }
    
    public EnumActionResult processRightClick(final EntityPlayer llllllllllllIlllIllIIIIIIIlIIlIl, final World llllllllllllIlllIllIIIIIIIlIllII, final EnumHand llllllllllllIlllIllIIIIIIIlIIIll) {
        if (this.currentGameType == GameType.SPECTATOR) {
            return EnumActionResult.PASS;
        }
        this.syncCurrentPlayItem();
        this.connection.sendPacket(new CPacketPlayerTryUseItem(llllllllllllIlllIllIIIIIIIlIIIll));
        final ItemStack llllllllllllIlllIllIIIIIIIlIlIlI = llllllllllllIlllIllIIIIIIIlIIlIl.getHeldItem(llllllllllllIlllIllIIIIIIIlIIIll);
        if (llllllllllllIlllIllIIIIIIIlIIlIl.getCooldownTracker().hasCooldown(llllllllllllIlllIllIIIIIIIlIlIlI.getItem())) {
            return EnumActionResult.PASS;
        }
        final int llllllllllllIlllIllIIIIIIIlIlIIl = llllllllllllIlllIllIIIIIIIlIlIlI.func_190916_E();
        final ActionResult<ItemStack> llllllllllllIlllIllIIIIIIIlIlIII = llllllllllllIlllIllIIIIIIIlIlIlI.useItemRightClick(llllllllllllIlllIllIIIIIIIlIllII, llllllllllllIlllIllIIIIIIIlIIlIl, llllllllllllIlllIllIIIIIIIlIIIll);
        final ItemStack llllllllllllIlllIllIIIIIIIlIIlll = llllllllllllIlllIllIIIIIIIlIlIII.getResult();
        if (llllllllllllIlllIllIIIIIIIlIIlll != llllllllllllIlllIllIIIIIIIlIlIlI || llllllllllllIlllIllIIIIIIIlIIlll.func_190916_E() != llllllllllllIlllIllIIIIIIIlIlIIl) {
            llllllllllllIlllIllIIIIIIIlIIlIl.setHeldItem(llllllllllllIlllIllIIIIIIIlIIIll, llllllllllllIlllIllIIIIIIIlIIlll);
        }
        return llllllllllllIlllIllIIIIIIIlIlIII.getType();
    }
    
    public EnumActionResult interactWithEntity(final EntityPlayer llllllllllllIlllIlIlllllllllIIll, final Entity llllllllllllIlllIlIlllllllllIIlI, final RayTraceResult llllllllllllIlllIlIllllllllIlIll, final EnumHand llllllllllllIlllIlIlllllllllIIII) {
        this.syncCurrentPlayItem();
        final Vec3d llllllllllllIlllIlIllllllllIllll = new Vec3d(llllllllllllIlllIlIllllllllIlIll.hitVec.xCoord - llllllllllllIlllIlIlllllllllIIlI.posX, llllllllllllIlllIlIllllllllIlIll.hitVec.yCoord - llllllllllllIlllIlIlllllllllIIlI.posY, llllllllllllIlllIlIllllllllIlIll.hitVec.zCoord - llllllllllllIlllIlIlllllllllIIlI.posZ);
        this.connection.sendPacket(new CPacketUseEntity(llllllllllllIlllIlIlllllllllIIlI, llllllllllllIlllIlIlllllllllIIII, llllllllllllIlllIlIllllllllIllll));
        return (this.currentGameType == GameType.SPECTATOR) ? EnumActionResult.PASS : llllllllllllIlllIlIlllllllllIIlI.applyPlayerInteraction(llllllllllllIlllIlIlllllllllIIll, llllllllllllIlllIlIllllllllIllll, llllllllllllIlllIlIlllllllllIIII);
    }
    
    private boolean isHittingPosition(final BlockPos llllllllllllIlllIllIIIIIIlllIIlI) {
        final ItemStack llllllllllllIlllIllIIIIIIlllIlIl = Minecraft.getMinecraft().player.getHeldItemMainhand();
        final boolean llllllllllllIlllIllIIIIIIlllIlII;
        boolean llllllllllllIlllIllIIIIIIlllIllI = llllllllllllIlllIllIIIIIIlllIlII = (this.currentItemHittingBlock.func_190926_b() && llllllllllllIlllIllIIIIIIlllIlIl.func_190926_b());
        if (!this.currentItemHittingBlock.func_190926_b() && !llllllllllllIlllIllIIIIIIlllIlIl.func_190926_b()) {
            llllllllllllIlllIllIIIIIIlllIllI = (llllllllllllIlllIllIIIIIIlllIlIl.getItem() == this.currentItemHittingBlock.getItem() && ItemStack.areItemStackTagsEqual(llllllllllllIlllIllIIIIIIlllIlIl, this.currentItemHittingBlock) && (llllllllllllIlllIllIIIIIIlllIlIl.isItemStackDamageable() || llllllllllllIlllIllIIIIIIlllIlIl.getMetadata() == this.currentItemHittingBlock.getMetadata()));
        }
        return llllllllllllIlllIllIIIIIIlllIIlI.equals(this.currentBlock) && llllllllllllIlllIllIIIIIIlllIllI;
    }
    
    public void flipPlayer(final EntityPlayer llllllllllllIlllIllIIIIIllIIlIIl) {
        llllllllllllIlllIllIIIIIllIIlIIl.rotationYaw = -180.0f;
    }
}
