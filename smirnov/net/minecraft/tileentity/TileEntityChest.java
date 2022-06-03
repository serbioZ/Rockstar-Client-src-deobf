// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.block.Block;
import java.util.Iterator;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.util.math.AxisAlignedBB;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.block.BlockChest;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ITickable;

public class TileEntityChest extends TileEntityLockableLoot implements ITickable
{
    private /* synthetic */ NonNullList<ItemStack> chestContents;
    private /* synthetic */ BlockChest.Type cachedChestType;
    public /* synthetic */ TileEntityChest adjacentChestXPos;
    public /* synthetic */ TileEntityChest adjacentChestZNeg;
    private /* synthetic */ int ticksSinceSync;
    public /* synthetic */ float prevLidAngle;
    public /* synthetic */ int numPlayersUsing;
    public /* synthetic */ boolean adjacentChestChecked;
    public /* synthetic */ TileEntityChest adjacentChestXNeg;
    public /* synthetic */ TileEntityChest adjacentChestZPos;
    public /* synthetic */ float lidAngle;
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllIllllIIIIllllIIlllll, final EntityPlayer llllllllllllIllllIIIIllllIIllllI) {
        this.fillWithLoot(llllllllllllIllllIIIIllllIIllllI);
        return new ContainerChest(llllllllllllIllllIIIIllllIIlllll, this, llllllllllllIllllIIIIllllIIllllI);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = TileEntityChest.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final long llllllllllllIllllIIIIllllIIllIIl = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllIllllIIIIllllIIllIIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIllllIIIIllllIIllIIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIllllIIIIllllIIllIIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIllllIIIIllllIIllIIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIllllIIIIllllIIllIIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIllllIIIIllllIIllIIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return TileEntityChest.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIllllIIIIllllIIllIIl;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllIllllIIIlIIIIIIlIIIl) {
        super.readFromNBT(llllllllllllIllllIIIlIIIIIIlIIIl);
        this.chestContents = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        if (!this.checkLootAndRead(llllllllllllIllllIIIlIIIIIIlIIIl)) {
            ItemStackHelper.func_191283_b(llllllllllllIllllIIIlIIIIIIlIIIl, this.chestContents);
        }
        if (llllllllllllIllllIIIlIIIIIIlIIIl.hasKey("CustomName", 8)) {
            this.field_190577_o = llllllllllllIllllIIIlIIIIIIlIIIl.getString("CustomName");
        }
    }
    
    public TileEntityChest(final BlockChest.Type llllllllllllIllllIIIlIIIIIlIIllI) {
        this.chestContents = NonNullList.func_191197_a(27, ItemStack.field_190927_a);
        this.cachedChestType = llllllllllllIllllIIIlIIIIIlIIllI;
    }
    
    @Override
    public void invalidate() {
        super.invalidate();
        this.updateContainingBlockInfo();
        this.checkForAdjacentChests();
    }
    
    @Override
    protected NonNullList<ItemStack> func_190576_q() {
        return this.chestContents;
    }
    
    public void checkForAdjacentChests() {
        if (!this.adjacentChestChecked) {
            this.adjacentChestChecked = true;
            this.adjacentChestXNeg = this.getAdjacentChest(EnumFacing.WEST);
            this.adjacentChestXPos = this.getAdjacentChest(EnumFacing.EAST);
            this.adjacentChestZNeg = this.getAdjacentChest(EnumFacing.NORTH);
            this.adjacentChestZPos = this.getAdjacentChest(EnumFacing.SOUTH);
        }
    }
    
    public BlockChest.Type getChestType() {
        if (this.cachedChestType == null) {
            if (this.world == null || !(this.getBlockType() instanceof BlockChest)) {
                return BlockChest.Type.BASIC;
            }
            this.cachedChestType = ((BlockChest)this.getBlockType()).chestType;
        }
        return this.cachedChestType;
    }
    
    private void setNeighbor(final TileEntityChest llllllllllllIllllIIIIlllllllllll, final EnumFacing llllllllllllIllllIIIlIIIIIIIIIIl) {
        if (llllllllllllIllllIIIIlllllllllll.isInvalid()) {
            this.adjacentChestChecked = false;
        }
        else if (this.adjacentChestChecked) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIllllIIIlIIIIIIIIIIl.ordinal()]) {
                case 3: {
                    if (this.adjacentChestZNeg != llllllllllllIllllIIIIlllllllllll) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
                case 4: {
                    if (this.adjacentChestZPos != llllllllllllIllllIIIIlllllllllll) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
                case 6: {
                    if (this.adjacentChestXPos != llllllllllllIllllIIIIlllllllllll) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
                case 5: {
                    if (this.adjacentChestXNeg != llllllllllllIllllIIIIlllllllllll) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:chest";
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllIllllIIIIllllIllIlII) {
        if (!llllllllllllIllllIIIIllllIllIlII.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
            if (this.getChestType() == BlockChest.Type.TRAP) {
                this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType(), false);
            }
        }
    }
    
    @Override
    public boolean receiveClientEvent(final int llllllllllllIllllIIIIllllIlllIll, final int llllllllllllIllllIIIIllllIllllIl) {
        if (llllllllllllIllllIIIIllllIlllIll == 1) {
            this.numPlayersUsing = llllllllllllIllllIIIIllllIllllIl;
            return true;
        }
        return super.receiveClientEvent(llllllllllllIllllIIIIllllIlllIll, llllllllllllIllllIIIIllllIllllIl);
    }
    
    @Override
    public int getSizeInventory() {
        return 27;
    }
    
    @Nullable
    protected TileEntityChest getAdjacentChest(final EnumFacing llllllllllllIllllIIIIlllllllIlII) {
        final BlockPos llllllllllllIllllIIIIlllllllIIll = this.pos.offset(llllllllllllIllllIIIIlllllllIlII);
        if (this.isChestAt(llllllllllllIllllIIIIlllllllIIll)) {
            final TileEntity llllllllllllIllllIIIIlllllllIIlI = this.world.getTileEntity(llllllllllllIllllIIIIlllllllIIll);
            if (llllllllllllIllllIIIIlllllllIIlI instanceof TileEntityChest) {
                final TileEntityChest llllllllllllIllllIIIIlllllllIIIl = (TileEntityChest)llllllllllllIllllIIIIlllllllIIlI;
                llllllllllllIllllIIIIlllllllIIIl.setNeighbor(this, llllllllllllIllllIIIIlllllllIlII.getOpposite());
                return llllllllllllIllllIIIIlllllllIIIl;
            }
        }
        return null;
    }
    
    @Override
    public void update() {
        this.checkForAdjacentChests();
        final int llllllllllllIllllIIIIlllllIllIII = this.pos.getX();
        final int llllllllllllIllllIIIIlllllIlIlll = this.pos.getY();
        final int llllllllllllIllllIIIIlllllIlIllI = this.pos.getZ();
        ++this.ticksSinceSync;
        if (!this.world.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + llllllllllllIllllIIIIlllllIllIII + llllllllllllIllllIIIIlllllIlIlll + llllllllllllIllllIIIIlllllIlIllI) % 200 == 0) {
            this.numPlayersUsing = 0;
            final float llllllllllllIllllIIIIlllllIlIlIl = 5.0f;
            for (final EntityPlayer llllllllllllIllllIIIIlllllIlIlII : this.world.getEntitiesWithinAABB((Class<? extends EntityPlayer>)EntityPlayer.class, new AxisAlignedBB(llllllllllllIllllIIIIlllllIllIII - 5.0f, llllllllllllIllllIIIIlllllIlIlll - 5.0f, llllllllllllIllllIIIIlllllIlIllI - 5.0f, llllllllllllIllllIIIIlllllIllIII + 1 + 5.0f, llllllllllllIllllIIIIlllllIlIlll + 1 + 5.0f, llllllllllllIllllIIIIlllllIlIllI + 1 + 5.0f))) {
                if (llllllllllllIllllIIIIlllllIlIlII.openContainer instanceof ContainerChest) {
                    final IInventory llllllllllllIllllIIIIlllllIlIIll = ((ContainerChest)llllllllllllIllllIIIIlllllIlIlII.openContainer).getLowerChestInventory();
                    if (llllllllllllIllllIIIIlllllIlIIll != this && (!(llllllllllllIllllIIIIlllllIlIIll instanceof InventoryLargeChest) || !((InventoryLargeChest)llllllllllllIllllIIIIlllllIlIIll).isPartOfLargeChest(this))) {
                        continue;
                    }
                    ++this.numPlayersUsing;
                }
            }
        }
        this.prevLidAngle = this.lidAngle;
        final float llllllllllllIllllIIIIlllllIlIIlI = 0.1f;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0f && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
            double llllllllllllIllllIIIIlllllIlIIIl = llllllllllllIllllIIIIlllllIllIII + 0.5;
            double llllllllllllIllllIIIIlllllIlIIII = llllllllllllIllllIIIIlllllIlIllI + 0.5;
            if (this.adjacentChestZPos != null) {
                llllllllllllIllllIIIIlllllIlIIII += 0.5;
            }
            if (this.adjacentChestXPos != null) {
                llllllllllllIllllIIIIlllllIlIIIl += 0.5;
            }
            this.world.playSound(null, llllllllllllIllllIIIIlllllIlIIIl, llllllllllllIllllIIIIlllllIlIlll + 0.5, llllllllllllIllllIIIIlllllIlIIII, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
        }
        if ((this.numPlayersUsing == 0 && this.lidAngle > 0.0f) || (this.numPlayersUsing > 0 && this.lidAngle < 1.0f)) {
            final float llllllllllllIllllIIIIlllllIIllll = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1f;
            }
            else {
                this.lidAngle -= 0.1f;
            }
            if (this.lidAngle > 1.0f) {
                this.lidAngle = 1.0f;
            }
            final float llllllllllllIllllIIIIlllllIIlllI = 0.5f;
            if (this.lidAngle < 0.5f && llllllllllllIllllIIIIlllllIIllll >= 0.5f && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
                double llllllllllllIllllIIIIlllllIIllIl = llllllllllllIllllIIIIlllllIllIII + 0.5;
                double llllllllllllIllllIIIIlllllIIllII = llllllllllllIllllIIIIlllllIlIllI + 0.5;
                if (this.adjacentChestZPos != null) {
                    llllllllllllIllllIIIIlllllIIllII += 0.5;
                }
                if (this.adjacentChestXPos != null) {
                    llllllllllllIllllIIIIlllllIIllIl += 0.5;
                }
                this.world.playSound(null, llllllllllllIllllIIIIlllllIIllIl, llllllllllllIllllIIIIlllllIlIlll + 0.5, llllllllllllIllllIIIIlllllIIllII, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
            }
            if (this.lidAngle < 0.0f) {
                this.lidAngle = 0.0f;
            }
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIllllIIIlIIIIIIIllIl) {
        super.writeToNBT(llllllllllllIllllIIIlIIIIIIIllIl);
        if (!this.checkLootAndWrite(llllllllllllIllllIIIlIIIIIIIllIl)) {
            ItemStackHelper.func_191282_a(llllllllllllIllllIIIlIIIIIIIllIl, this.chestContents);
        }
        if (this.hasCustomName()) {
            llllllllllllIllllIIIlIIIIIIIllIl.setString("CustomName", this.field_190577_o);
        }
        return llllllllllllIllllIIIlIIIIIIIllIl;
    }
    
    private boolean isChestAt(final BlockPos llllllllllllIllllIIIIllllllIIlll) {
        if (this.world == null) {
            return false;
        }
        final Block llllllllllllIllllIIIIllllllIIllI = this.world.getBlockState(llllllllllllIllllIIIIllllllIIlll).getBlock();
        return llllllllllllIllllIIIIllllllIIllI instanceof BlockChest && ((BlockChest)llllllllllllIllllIIIIllllllIIllI).chestType == this.getChestType();
    }
    
    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        this.adjacentChestChecked = false;
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllIllllIIIIllllIlIlllI) {
        if (!llllllllllllIllllIIIIllllIlIlllI.isSpectator() && this.getBlockType() instanceof BlockChest) {
            --this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
            if (this.getChestType() == BlockChest.Type.TRAP) {
                this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType(), false);
            }
        }
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.chest";
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack llllllllllllIllllIIIlIIIIIlIIIII : this.chestContents) {
            if (!llllllllllllIllllIIIlIIIIIlIIIII.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public static void registerFixesChest(final DataFixer llllllllllllIllllIIIlIIIIIIllIII) {
        llllllllllllIllllIIIlIIIIIIllIII.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityChest.class, new String[] { "Items" }));
    }
    
    public TileEntityChest() {
        this.chestContents = NonNullList.func_191197_a(27, ItemStack.field_190927_a);
    }
}
