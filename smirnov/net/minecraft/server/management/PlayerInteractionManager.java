// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import net.minecraft.item.ItemBlock;
import net.minecraft.inventory.IInventory;
import net.minecraft.block.BlockChest;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.ILockableContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.WorldServer;
import net.minecraft.block.material.Material;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStructure;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlayerInteractionManager
{
    private /* synthetic */ int curblockDamage;
    private /* synthetic */ int initialBlockDamage;
    private /* synthetic */ boolean isDestroyingBlock;
    private /* synthetic */ boolean receivedFinishDiggingPacket;
    public /* synthetic */ World theWorld;
    private /* synthetic */ BlockPos destroyPos;
    private /* synthetic */ GameType gameType;
    public /* synthetic */ EntityPlayerMP thisPlayerMP;
    private /* synthetic */ int durabilityRemainingOnBlock;
    private /* synthetic */ int initialDamage;
    private /* synthetic */ BlockPos delayedDestroyPos;
    
    private boolean removeBlock(final BlockPos lllllllllllIllIIIIIlIlIlllIIIIIl) {
        final IBlockState lllllllllllIllIIIIIlIlIlllIIIlII = this.theWorld.getBlockState(lllllllllllIllIIIIIlIlIlllIIIIIl);
        lllllllllllIllIIIIIlIlIlllIIIlII.getBlock().onBlockHarvested(this.theWorld, lllllllllllIllIIIIIlIlIlllIIIIIl, lllllllllllIllIIIIIlIlIlllIIIlII, this.thisPlayerMP);
        final boolean lllllllllllIllIIIIIlIlIlllIIIIll = this.theWorld.setBlockToAir(lllllllllllIllIIIIIlIlIlllIIIIIl);
        if (lllllllllllIllIIIIIlIlIlllIIIIll) {
            lllllllllllIllIIIIIlIlIlllIIIlII.getBlock().onBlockDestroyedByPlayer(this.theWorld, lllllllllllIllIIIIIlIlIlllIIIIIl, lllllllllllIllIIIIIlIlIlllIIIlII);
        }
        return lllllllllllIllIIIIIlIlIlllIIIIll;
    }
    
    public void setGameType(final GameType lllllllllllIllIIIIIlIllIIIIlIlIl) {
        this.gameType = lllllllllllIllIIIIIlIllIIIIlIlIl;
        lllllllllllIllIIIIIlIllIIIIlIlIl.configurePlayerCapabilities(this.thisPlayerMP.capabilities);
        this.thisPlayerMP.sendPlayerAbilities();
        this.thisPlayerMP.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.UPDATE_GAME_MODE, new EntityPlayerMP[] { this.thisPlayerMP }));
        this.theWorld.updateAllPlayersSleepingFlag();
    }
    
    public boolean tryHarvestBlock(final BlockPos lllllllllllIllIIIIIlIlIllIllIlII) {
        if (this.gameType.isCreative() && !this.thisPlayerMP.getHeldItemMainhand().func_190926_b() && this.thisPlayerMP.getHeldItemMainhand().getItem() instanceof ItemSword) {
            return false;
        }
        final IBlockState lllllllllllIllIIIIIlIlIllIllIIll = this.theWorld.getBlockState(lllllllllllIllIIIIIlIlIllIllIlII);
        final TileEntity lllllllllllIllIIIIIlIlIllIllIIlI = this.theWorld.getTileEntity(lllllllllllIllIIIIIlIlIllIllIlII);
        final Block lllllllllllIllIIIIIlIlIllIllIIIl = lllllllllllIllIIIIIlIlIllIllIIll.getBlock();
        if ((lllllllllllIllIIIIIlIlIllIllIIIl instanceof BlockCommandBlock || lllllllllllIllIIIIIlIlIllIllIIIl instanceof BlockStructure) && !this.thisPlayerMP.canUseCommandBlock()) {
            this.theWorld.notifyBlockUpdate(lllllllllllIllIIIIIlIlIllIllIlII, lllllllllllIllIIIIIlIlIllIllIIll, lllllllllllIllIIIIIlIlIllIllIIll, 3);
            return false;
        }
        if (this.gameType.isAdventure()) {
            if (this.gameType == GameType.SPECTATOR) {
                return false;
            }
            if (!this.thisPlayerMP.isAllowEdit()) {
                final ItemStack lllllllllllIllIIIIIlIlIllIllIIII = this.thisPlayerMP.getHeldItemMainhand();
                if (lllllllllllIllIIIIIlIlIllIllIIII.func_190926_b()) {
                    return false;
                }
                if (!lllllllllllIllIIIIIlIlIllIllIIII.canDestroy(lllllllllllIllIIIIIlIlIllIllIIIl)) {
                    return false;
                }
            }
        }
        this.theWorld.playEvent(this.thisPlayerMP, 2001, lllllllllllIllIIIIIlIlIllIllIlII, Block.getStateId(lllllllllllIllIIIIIlIlIllIllIIll));
        final boolean lllllllllllIllIIIIIlIlIllIlIllll = this.removeBlock(lllllllllllIllIIIIIlIlIllIllIlII);
        if (this.isCreative()) {
            this.thisPlayerMP.connection.sendPacket(new SPacketBlockChange(this.theWorld, lllllllllllIllIIIIIlIlIllIllIlII));
        }
        else {
            final ItemStack lllllllllllIllIIIIIlIlIllIlIlllI = this.thisPlayerMP.getHeldItemMainhand();
            final ItemStack lllllllllllIllIIIIIlIlIllIlIllIl = lllllllllllIllIIIIIlIlIllIlIlllI.func_190926_b() ? ItemStack.field_190927_a : lllllllllllIllIIIIIlIlIllIlIlllI.copy();
            final boolean lllllllllllIllIIIIIlIlIllIlIllII = this.thisPlayerMP.canHarvestBlock(lllllllllllIllIIIIIlIlIllIllIIll);
            if (!lllllllllllIllIIIIIlIlIllIlIlllI.func_190926_b()) {
                lllllllllllIllIIIIIlIlIllIlIlllI.onBlockDestroyed(this.theWorld, lllllllllllIllIIIIIlIlIllIllIIll, lllllllllllIllIIIIIlIlIllIllIlII, this.thisPlayerMP);
            }
            if (lllllllllllIllIIIIIlIlIllIlIllll && lllllllllllIllIIIIIlIlIllIlIllII) {
                lllllllllllIllIIIIIlIlIllIllIIll.getBlock().harvestBlock(this.theWorld, this.thisPlayerMP, lllllllllllIllIIIIIlIlIllIllIlII, lllllllllllIllIIIIIlIlIllIllIIll, lllllllllllIllIIIIIlIlIllIllIIlI, lllllllllllIllIIIIIlIlIllIlIllIl);
            }
        }
        return lllllllllllIllIIIIIlIlIllIlIllll;
    }
    
    public EnumActionResult processRightClick(final EntityPlayer lllllllllllIllIIIIIlIlIllIIllIII, final World lllllllllllIllIIIIIlIlIllIIlIlll, final ItemStack lllllllllllIllIIIIIlIlIllIIlIllI, final EnumHand lllllllllllIllIIIIIlIlIllIIlIlIl) {
        if (this.gameType == GameType.SPECTATOR) {
            return EnumActionResult.PASS;
        }
        if (lllllllllllIllIIIIIlIlIllIIllIII.getCooldownTracker().hasCooldown(lllllllllllIllIIIIIlIlIllIIlIllI.getItem())) {
            return EnumActionResult.PASS;
        }
        final int lllllllllllIllIIIIIlIlIllIIlIlII = lllllllllllIllIIIIIlIlIllIIlIllI.func_190916_E();
        final int lllllllllllIllIIIIIlIlIllIIlIIll = lllllllllllIllIIIIIlIlIllIIlIllI.getMetadata();
        final ActionResult<ItemStack> lllllllllllIllIIIIIlIlIllIIlIIlI = lllllllllllIllIIIIIlIlIllIIlIllI.useItemRightClick(lllllllllllIllIIIIIlIlIllIIlIlll, lllllllllllIllIIIIIlIlIllIIllIII, lllllllllllIllIIIIIlIlIllIIlIlIl);
        final ItemStack lllllllllllIllIIIIIlIlIllIIlIIIl = lllllllllllIllIIIIIlIlIllIIlIIlI.getResult();
        if (lllllllllllIllIIIIIlIlIllIIlIIIl == lllllllllllIllIIIIIlIlIllIIlIllI && lllllllllllIllIIIIIlIlIllIIlIIIl.func_190916_E() == lllllllllllIllIIIIIlIlIllIIlIlII && lllllllllllIllIIIIIlIlIllIIlIIIl.getMaxItemUseDuration() <= 0 && lllllllllllIllIIIIIlIlIllIIlIIIl.getMetadata() == lllllllllllIllIIIIIlIlIllIIlIIll) {
            return lllllllllllIllIIIIIlIlIllIIlIIlI.getType();
        }
        if (lllllllllllIllIIIIIlIlIllIIlIIlI.getType() == EnumActionResult.FAIL && lllllllllllIllIIIIIlIlIllIIlIIIl.getMaxItemUseDuration() > 0 && !lllllllllllIllIIIIIlIlIllIIllIII.isHandActive()) {
            return lllllllllllIllIIIIIlIlIllIIlIIlI.getType();
        }
        lllllllllllIllIIIIIlIlIllIIllIII.setHeldItem(lllllllllllIllIIIIIlIlIllIIlIlIl, lllllllllllIllIIIIIlIlIllIIlIIIl);
        if (this.isCreative()) {
            lllllllllllIllIIIIIlIlIllIIlIIIl.func_190920_e(lllllllllllIllIIIIIlIlIllIIlIlII);
            if (lllllllllllIllIIIIIlIlIllIIlIIIl.isItemStackDamageable()) {
                lllllllllllIllIIIIIlIlIllIIlIIIl.setItemDamage(lllllllllllIllIIIIIlIlIllIIlIIll);
            }
        }
        if (lllllllllllIllIIIIIlIlIllIIlIIIl.func_190926_b()) {
            lllllllllllIllIIIIIlIlIllIIllIII.setHeldItem(lllllllllllIllIIIIIlIlIllIIlIlIl, ItemStack.field_190927_a);
        }
        if (!lllllllllllIllIIIIIlIlIllIIllIII.isHandActive()) {
            ((EntityPlayerMP)lllllllllllIllIIIIIlIlIllIIllIII).sendContainerToPlayer(lllllllllllIllIIIIIlIlIllIIllIII.inventoryContainer);
        }
        return lllllllllllIllIIIIIlIlIllIIlIIlI.getType();
    }
    
    public PlayerInteractionManager(final World lllllllllllIllIIIIIlIllIIIIllIll) {
        this.gameType = GameType.NOT_SET;
        this.destroyPos = BlockPos.ORIGIN;
        this.delayedDestroyPos = BlockPos.ORIGIN;
        this.durabilityRemainingOnBlock = -1;
        this.theWorld = lllllllllllIllIIIIIlIllIIIIllIll;
    }
    
    public void updateBlockRemoving() {
        ++this.curblockDamage;
        if (this.receivedFinishDiggingPacket) {
            final int lllllllllllIllIIIIIlIlIlllllllll = this.curblockDamage - this.initialBlockDamage;
            final IBlockState lllllllllllIllIIIIIlIlIllllllllI = this.theWorld.getBlockState(this.delayedDestroyPos);
            if (lllllllllllIllIIIIIlIlIllllllllI.getMaterial() == Material.AIR) {
                this.receivedFinishDiggingPacket = false;
            }
            else {
                final float lllllllllllIllIIIIIlIlIlllllllIl = lllllllllllIllIIIIIlIlIllllllllI.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.world, this.delayedDestroyPos) * (lllllllllllIllIIIIIlIlIlllllllll + 1);
                final int lllllllllllIllIIIIIlIlIlllllllII = (int)(lllllllllllIllIIIIIlIlIlllllllIl * 10.0f);
                if (lllllllllllIllIIIIIlIlIlllllllII != this.durabilityRemainingOnBlock) {
                    this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.delayedDestroyPos, lllllllllllIllIIIIIlIlIlllllllII);
                    this.durabilityRemainingOnBlock = lllllllllllIllIIIIIlIlIlllllllII;
                }
                if (lllllllllllIllIIIIIlIlIlllllllIl >= 1.0f) {
                    this.receivedFinishDiggingPacket = false;
                    this.tryHarvestBlock(this.delayedDestroyPos);
                }
            }
        }
        else if (this.isDestroyingBlock) {
            final IBlockState lllllllllllIllIIIIIlIlIllllllIll = this.theWorld.getBlockState(this.destroyPos);
            if (lllllllllllIllIIIIIlIlIllllllIll.getMaterial() == Material.AIR) {
                this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.destroyPos, -1);
                this.durabilityRemainingOnBlock = -1;
                this.isDestroyingBlock = false;
            }
            else {
                final int lllllllllllIllIIIIIlIlIllllllIlI = this.curblockDamage - this.initialDamage;
                final float lllllllllllIllIIIIIlIlIllllllIIl = lllllllllllIllIIIIIlIlIllllllIll.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.world, this.delayedDestroyPos) * (lllllllllllIllIIIIIlIlIllllllIlI + 1);
                final int lllllllllllIllIIIIIlIlIllllllIII = (int)(lllllllllllIllIIIIIlIlIllllllIIl * 10.0f);
                if (lllllllllllIllIIIIIlIlIllllllIII != this.durabilityRemainingOnBlock) {
                    this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.destroyPos, lllllllllllIllIIIIIlIlIllllllIII);
                    this.durabilityRemainingOnBlock = lllllllllllIllIIIIIlIlIllllllIII;
                }
            }
        }
    }
    
    public GameType getGameType() {
        return this.gameType;
    }
    
    public void blockRemoving(final BlockPos lllllllllllIllIIIIIlIlIlllIlIllI) {
        if (lllllllllllIllIIIIIlIlIlllIlIllI.equals(this.destroyPos)) {
            final int lllllllllllIllIIIIIlIlIlllIlIlIl = this.curblockDamage - this.initialDamage;
            final IBlockState lllllllllllIllIIIIIlIlIlllIlIlII = this.theWorld.getBlockState(lllllllllllIllIIIIIlIlIlllIlIllI);
            if (lllllllllllIllIIIIIlIlIlllIlIlII.getMaterial() != Material.AIR) {
                final float lllllllllllIllIIIIIlIlIlllIlIIll = lllllllllllIllIIIIIlIlIlllIlIlII.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.world, lllllllllllIllIIIIIlIlIlllIlIllI) * (lllllllllllIllIIIIIlIlIlllIlIlIl + 1);
                if (lllllllllllIllIIIIIlIlIlllIlIIll >= 0.7f) {
                    this.isDestroyingBlock = false;
                    this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), lllllllllllIllIIIIIlIlIlllIlIllI, -1);
                    this.tryHarvestBlock(lllllllllllIllIIIIIlIlIlllIlIllI);
                }
                else if (!this.receivedFinishDiggingPacket) {
                    this.isDestroyingBlock = false;
                    this.receivedFinishDiggingPacket = true;
                    this.delayedDestroyPos = lllllllllllIllIIIIIlIlIlllIlIllI;
                    this.initialBlockDamage = this.initialDamage;
                }
            }
        }
    }
    
    public void setWorld(final WorldServer lllllllllllIllIIIIIlIlIlIlIllIII) {
        this.theWorld = lllllllllllIllIIIIIlIlIlIlIllIII;
    }
    
    public boolean survivalOrAdventure() {
        return this.gameType.isSurvivalOrAdventure();
    }
    
    public void cancelDestroyingBlock() {
        this.isDestroyingBlock = false;
        this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.destroyPos, -1);
    }
    
    public void initializeGameType(final GameType lllllllllllIllIIIIIlIllIIIIIlIII) {
        if (this.gameType == GameType.NOT_SET) {
            this.gameType = lllllllllllIllIIIIIlIllIIIIIlIII;
        }
        this.setGameType(this.gameType);
    }
    
    public EnumActionResult processRightClickBlock(final EntityPlayer lllllllllllIllIIIIIlIlIlIllIIlll, final World lllllllllllIllIIIIIlIlIlIllllIII, final ItemStack lllllllllllIllIIIIIlIlIlIlllIlll, final EnumHand lllllllllllIllIIIIIlIlIlIllIIlII, final BlockPos lllllllllllIllIIIIIlIlIlIlllIlIl, final EnumFacing lllllllllllIllIIIIIlIlIlIlllIlII, final float lllllllllllIllIIIIIlIlIlIllIIIIl, final float lllllllllllIllIIIIIlIlIlIllIIIII, final float lllllllllllIllIIIIIlIlIlIlllIIIl) {
        if (this.gameType == GameType.SPECTATOR) {
            final TileEntity lllllllllllIllIIIIIlIlIlIlllIIII = lllllllllllIllIIIIIlIlIlIllllIII.getTileEntity(lllllllllllIllIIIIIlIlIlIlllIlIl);
            if (lllllllllllIllIIIIIlIlIlIlllIIII instanceof ILockableContainer) {
                final Block lllllllllllIllIIIIIlIlIlIllIllll = lllllllllllIllIIIIIlIlIlIllllIII.getBlockState(lllllllllllIllIIIIIlIlIlIlllIlIl).getBlock();
                ILockableContainer lllllllllllIllIIIIIlIlIlIllIlllI = (ILockableContainer)lllllllllllIllIIIIIlIlIlIlllIIII;
                if (lllllllllllIllIIIIIlIlIlIllIlllI instanceof TileEntityChest && lllllllllllIllIIIIIlIlIlIllIllll instanceof BlockChest) {
                    lllllllllllIllIIIIIlIlIlIllIlllI = ((BlockChest)lllllllllllIllIIIIIlIlIlIllIllll).getLockableContainer(lllllllllllIllIIIIIlIlIlIllllIII, lllllllllllIllIIIIIlIlIlIlllIlIl);
                }
                if (lllllllllllIllIIIIIlIlIlIllIlllI != null) {
                    lllllllllllIllIIIIIlIlIlIllIIlll.displayGUIChest(lllllllllllIllIIIIIlIlIlIllIlllI);
                    return EnumActionResult.SUCCESS;
                }
            }
            else if (lllllllllllIllIIIIIlIlIlIlllIIII instanceof IInventory) {
                lllllllllllIllIIIIIlIlIlIllIIlll.displayGUIChest((IInventory)lllllllllllIllIIIIIlIlIlIlllIIII);
                return EnumActionResult.SUCCESS;
            }
            return EnumActionResult.PASS;
        }
        if (!lllllllllllIllIIIIIlIlIlIllIIlll.isSneaking() || (lllllllllllIllIIIIIlIlIlIllIIlll.getHeldItemMainhand().func_190926_b() && lllllllllllIllIIIIIlIlIlIllIIlll.getHeldItemOffhand().func_190926_b())) {
            final IBlockState lllllllllllIllIIIIIlIlIlIllIllIl = lllllllllllIllIIIIIlIlIlIllllIII.getBlockState(lllllllllllIllIIIIIlIlIlIlllIlIl);
            if (lllllllllllIllIIIIIlIlIlIllIllIl.getBlock().onBlockActivated(lllllllllllIllIIIIIlIlIlIllllIII, lllllllllllIllIIIIIlIlIlIlllIlIl, lllllllllllIllIIIIIlIlIlIllIllIl, lllllllllllIllIIIIIlIlIlIllIIlll, lllllllllllIllIIIIIlIlIlIllIIlII, lllllllllllIllIIIIIlIlIlIlllIlII, lllllllllllIllIIIIIlIlIlIllIIIIl, lllllllllllIllIIIIIlIlIlIllIIIII, lllllllllllIllIIIIIlIlIlIlllIIIl)) {
                return EnumActionResult.SUCCESS;
            }
        }
        if (lllllllllllIllIIIIIlIlIlIlllIlll.func_190926_b()) {
            return EnumActionResult.PASS;
        }
        if (lllllllllllIllIIIIIlIlIlIllIIlll.getCooldownTracker().hasCooldown(lllllllllllIllIIIIIlIlIlIlllIlll.getItem())) {
            return EnumActionResult.PASS;
        }
        if (lllllllllllIllIIIIIlIlIlIlllIlll.getItem() instanceof ItemBlock && !lllllllllllIllIIIIIlIlIlIllIIlll.canUseCommandBlock()) {
            final Block lllllllllllIllIIIIIlIlIlIllIllII = ((ItemBlock)lllllllllllIllIIIIIlIlIlIlllIlll.getItem()).getBlock();
            if (lllllllllllIllIIIIIlIlIlIllIllII instanceof BlockCommandBlock || lllllllllllIllIIIIIlIlIlIllIllII instanceof BlockStructure) {
                return EnumActionResult.FAIL;
            }
        }
        if (this.isCreative()) {
            final int lllllllllllIllIIIIIlIlIlIllIlIll = lllllllllllIllIIIIIlIlIlIlllIlll.getMetadata();
            final int lllllllllllIllIIIIIlIlIlIllIlIlI = lllllllllllIllIIIIIlIlIlIlllIlll.func_190916_E();
            final EnumActionResult lllllllllllIllIIIIIlIlIlIllIlIIl = lllllllllllIllIIIIIlIlIlIlllIlll.onItemUse(lllllllllllIllIIIIIlIlIlIllIIlll, lllllllllllIllIIIIIlIlIlIllllIII, lllllllllllIllIIIIIlIlIlIlllIlIl, lllllllllllIllIIIIIlIlIlIllIIlII, lllllllllllIllIIIIIlIlIlIlllIlII, lllllllllllIllIIIIIlIlIlIllIIIIl, lllllllllllIllIIIIIlIlIlIllIIIII, lllllllllllIllIIIIIlIlIlIlllIIIl);
            lllllllllllIllIIIIIlIlIlIlllIlll.setItemDamage(lllllllllllIllIIIIIlIlIlIllIlIll);
            lllllllllllIllIIIIIlIlIlIlllIlll.func_190920_e(lllllllllllIllIIIIIlIlIlIllIlIlI);
            return lllllllllllIllIIIIIlIlIlIllIlIIl;
        }
        return lllllllllllIllIIIIIlIlIlIlllIlll.onItemUse(lllllllllllIllIIIIIlIlIlIllIIlll, lllllllllllIllIIIIIlIlIlIllllIII, lllllllllllIllIIIIIlIlIlIlllIlIl, lllllllllllIllIIIIIlIlIlIllIIlII, lllllllllllIllIIIIIlIlIlIlllIlII, lllllllllllIllIIIIIlIlIlIllIIIIl, lllllllllllIllIIIIIlIlIlIllIIIII, lllllllllllIllIIIIIlIlIlIlllIIIl);
    }
    
    public boolean isCreative() {
        return this.gameType.isCreative();
    }
    
    public void onBlockClicked(final BlockPos lllllllllllIllIIIIIlIlIllllIIIlI, final EnumFacing lllllllllllIllIIIIIlIlIllllIlIIl) {
        if (this.isCreative()) {
            if (!this.theWorld.extinguishFire(null, lllllllllllIllIIIIIlIlIllllIIIlI, lllllllllllIllIIIIIlIlIllllIlIIl)) {
                this.tryHarvestBlock(lllllllllllIllIIIIIlIlIllllIIIlI);
            }
        }
        else {
            final IBlockState lllllllllllIllIIIIIlIlIllllIlIII = this.theWorld.getBlockState(lllllllllllIllIIIIIlIlIllllIIIlI);
            final Block lllllllllllIllIIIIIlIlIllllIIlll = lllllllllllIllIIIIIlIlIllllIlIII.getBlock();
            if (this.gameType.isAdventure()) {
                if (this.gameType == GameType.SPECTATOR) {
                    return;
                }
                if (!this.thisPlayerMP.isAllowEdit()) {
                    final ItemStack lllllllllllIllIIIIIlIlIllllIIllI = this.thisPlayerMP.getHeldItemMainhand();
                    if (lllllllllllIllIIIIIlIlIllllIIllI.func_190926_b()) {
                        return;
                    }
                    if (!lllllllllllIllIIIIIlIlIllllIIllI.canDestroy(lllllllllllIllIIIIIlIlIllllIIlll)) {
                        return;
                    }
                }
            }
            this.theWorld.extinguishFire(null, lllllllllllIllIIIIIlIlIllllIIIlI, lllllllllllIllIIIIIlIlIllllIlIIl);
            this.initialDamage = this.curblockDamage;
            float lllllllllllIllIIIIIlIlIllllIIlIl = 1.0f;
            if (lllllllllllIllIIIIIlIlIllllIlIII.getMaterial() != Material.AIR) {
                lllllllllllIllIIIIIlIlIllllIIlll.onBlockClicked(this.theWorld, lllllllllllIllIIIIIlIlIllllIIIlI, this.thisPlayerMP);
                lllllllllllIllIIIIIlIlIllllIIlIl = lllllllllllIllIIIIIlIlIllllIlIII.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.world, lllllllllllIllIIIIIlIlIllllIIIlI);
            }
            if (lllllllllllIllIIIIIlIlIllllIlIII.getMaterial() != Material.AIR && lllllllllllIllIIIIIlIlIllllIIlIl >= 1.0f) {
                this.tryHarvestBlock(lllllllllllIllIIIIIlIlIllllIIIlI);
            }
            else {
                this.isDestroyingBlock = true;
                this.destroyPos = lllllllllllIllIIIIIlIlIllllIIIlI;
                final int lllllllllllIllIIIIIlIlIllllIIlII = (int)(lllllllllllIllIIIIIlIlIllllIIlIl * 10.0f);
                this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), lllllllllllIllIIIIIlIlIllllIIIlI, lllllllllllIllIIIIIlIlIllllIIlII);
                this.durabilityRemainingOnBlock = lllllllllllIllIIIIIlIlIllllIIlII;
            }
        }
    }
}
