// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ContainerShulkerBox;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.block.Block;
import javax.annotation.Nullable;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.MoverType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.util.ITickable;

public class TileEntityShulkerBox extends TileEntityLockableLoot implements ITickable, ISidedInventory
{
    private /* synthetic */ NonNullList<ItemStack> field_190596_f;
    private /* synthetic */ boolean field_190597_g;
    private /* synthetic */ float field_190601_k;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
    private /* synthetic */ float field_190600_j;
    private /* synthetic */ EnumDyeColor field_190602_l;
    private static final /* synthetic */ int[] field_190595_a;
    private /* synthetic */ int field_190598_h;
    private /* synthetic */ AnimationStatus field_190599_i;
    private /* synthetic */ boolean field_190594_p;
    
    @Override
    public String getGuiID() {
        return "minecraft:shulker_box";
    }
    
    public float func_190585_a(final float lllllllllllllllIIlIIllIlIIlIIIll) {
        return this.field_190601_k + (this.field_190600_j - this.field_190601_k) * lllllllllllllllIIlIIllIlIIlIIIll;
    }
    
    private void func_190589_G() {
        final IBlockState lllllllllllllllIIlIIllIllIIllIIl = this.world.getBlockState(this.getPos());
        if (lllllllllllllllIIlIIllIllIIllIIl.getBlock() instanceof BlockShulkerBox) {
            final EnumFacing lllllllllllllllIIlIIllIllIIllIII = lllllllllllllllIIlIIllIllIIllIIl.getValue(BlockShulkerBox.field_190957_a);
            final AxisAlignedBB lllllllllllllllIIlIIllIllIIlIlll = this.func_190588_c(lllllllllllllllIIlIIllIllIIllIII).offset(this.pos);
            final List<Entity> lllllllllllllllIIlIIllIllIIlIllI = this.world.getEntitiesWithinAABBExcludingEntity(null, lllllllllllllllIIlIIllIllIIlIlll);
            if (!lllllllllllllllIIlIIllIllIIlIllI.isEmpty()) {
                for (int lllllllllllllllIIlIIllIllIIlIlIl = 0; lllllllllllllllIIlIIllIllIIlIlIl < lllllllllllllllIIlIIllIllIIlIllI.size(); ++lllllllllllllllIIlIIllIllIIlIlIl) {
                    final Entity lllllllllllllllIIlIIllIllIIlIlII = lllllllllllllllIIlIIllIllIIlIllI.get(lllllllllllllllIIlIIllIllIIlIlIl);
                    if (lllllllllllllllIIlIIllIllIIlIlII.getPushReaction() != EnumPushReaction.IGNORE) {
                        double lllllllllllllllIIlIIllIllIIlIIll = 0.0;
                        double lllllllllllllllIIlIIllIllIIlIIlI = 0.0;
                        double lllllllllllllllIIlIIllIllIIlIIIl = 0.0;
                        final AxisAlignedBB lllllllllllllllIIlIIllIllIIlIIII = lllllllllllllllIIlIIllIllIIlIlII.getEntityBoundingBox();
                        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllllIIlIIllIllIIllIII.getAxis().ordinal()]) {
                            case 1: {
                                if (lllllllllllllllIIlIIllIllIIllIII.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
                                    lllllllllllllllIIlIIllIllIIlIIll = lllllllllllllllIIlIIllIllIIlIlll.maxX - lllllllllllllllIIlIIllIllIIlIIII.minX;
                                }
                                else {
                                    lllllllllllllllIIlIIllIllIIlIIll = lllllllllllllllIIlIIllIllIIlIIII.maxX - lllllllllllllllIIlIIllIllIIlIlll.minX;
                                }
                                lllllllllllllllIIlIIllIllIIlIIll += 0.01;
                                break;
                            }
                            case 2: {
                                if (lllllllllllllllIIlIIllIllIIllIII.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
                                    lllllllllllllllIIlIIllIllIIlIIlI = lllllllllllllllIIlIIllIllIIlIlll.maxY - lllllllllllllllIIlIIllIllIIlIIII.minY;
                                }
                                else {
                                    lllllllllllllllIIlIIllIllIIlIIlI = lllllllllllllllIIlIIllIllIIlIIII.maxY - lllllllllllllllIIlIIllIllIIlIlll.minY;
                                }
                                lllllllllllllllIIlIIllIllIIlIIlI += 0.01;
                                break;
                            }
                            case 3: {
                                if (lllllllllllllllIIlIIllIllIIllIII.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
                                    lllllllllllllllIIlIIllIllIIlIIIl = lllllllllllllllIIlIIllIllIIlIlll.maxZ - lllllllllllllllIIlIIllIllIIlIIII.minZ;
                                }
                                else {
                                    lllllllllllllllIIlIIllIllIIlIIIl = lllllllllllllllIIlIIllIllIIlIIII.maxZ - lllllllllllllllIIlIIllIllIIlIlll.minZ;
                                }
                                lllllllllllllllIIlIIllIllIIlIIIl += 0.01;
                                break;
                            }
                        }
                        lllllllllllllllIIlIIllIllIIlIlII.moveEntity(MoverType.SHULKER_BOX, lllllllllllllllIIlIIllIllIIlIIll * lllllllllllllllIIlIIllIllIIllIII.getFrontOffsetX(), lllllllllllllllIIlIIllIllIIlIIlI * lllllllllllllllIIlIIllIllIIllIII.getFrontOffsetY(), lllllllllllllllIIlIIllIllIIlIIIl * lllllllllllllllIIlIIllIllIIllIII.getFrontOffsetZ());
                    }
                }
            }
        }
    }
    
    public AxisAlignedBB func_190584_a(final IBlockState lllllllllllllllIIlIIllIllIllIlIl) {
        return this.func_190587_b(lllllllllllllllIIlIIllIllIllIlIl.getValue(BlockShulkerBox.field_190957_a));
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllllIIlIIllIlIIllllII : this.field_190596_f) {
            if (!lllllllllllllllIIlIIllIlIIllllII.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public TileEntityShulkerBox() {
        this(null);
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 10, this.getUpdateTag());
    }
    
    @Override
    public boolean canInsertItem(final int lllllllllllllllIIlIIllIlIIllIlII, final ItemStack lllllllllllllllIIlIIllIlIIllIIll, final EnumFacing lllllllllllllllIIlIIllIlIIllIIlI) {
        return !(Block.getBlockFromItem(lllllllllllllllIIlIIllIlIIllIIll.getItem()) instanceof BlockShulkerBox);
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllllIIlIIllIlIllIIlll, final EntityPlayer lllllllllllllllIIlIIllIlIllIIllI) {
        return new ContainerShulkerBox(lllllllllllllllIIlIIllIlIllIIlll, this, lllllllllllllllIIlIIllIlIllIIllI);
    }
    
    public AnimationStatus func_190591_p() {
        return this.field_190599_i;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus = TileEntityShulkerBox.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus;
        }
        final Exception lllllllllllllllIIlIIllIlIIIIllIl = (Object)new int[AnimationStatus.values().length];
        try {
            lllllllllllllllIIlIIllIlIIIIllIl[AnimationStatus.CLOSED.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIIlIIllIlIIIIllIl[AnimationStatus.CLOSING.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIIlIIllIlIIIIllIl[AnimationStatus.OPENED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIIlIIllIlIIIIllIl[AnimationStatus.OPENING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return TileEntityShulkerBox.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus = (int[])(Object)lllllllllllllllIIlIIllIlIIIIllIl;
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing lllllllllllllllIIlIIllIlIIllIlll) {
        return TileEntityShulkerBox.field_190595_a;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = TileEntityShulkerBox.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final byte lllllllllllllllIIlIIllIlIIIIlIll = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllllllIIlIIllIlIIIIlIll[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIIlIIllIlIIIIlIll[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIIlIIllIlIIIIlIll[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return TileEntityShulkerBox.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllllllIIlIIllIlIIIIlIll;
    }
    
    public boolean func_190581_E() {
        return this.field_190594_p;
    }
    
    @Override
    public boolean receiveClientEvent(final int lllllllllllllllIIlIIllIlIllllIIl, final int lllllllllllllllIIlIIllIlIllllIII) {
        if (lllllllllllllllIIlIIllIlIllllIIl == 1) {
            if ((this.field_190598_h = lllllllllllllllIIlIIllIlIllllIII) == 0) {
                this.field_190599_i = AnimationStatus.CLOSING;
            }
            if (lllllllllllllllIIlIIllIlIllllIII == 1) {
                this.field_190599_i = AnimationStatus.OPENING;
            }
            return true;
        }
        return super.receiveClientEvent(lllllllllllllllIIlIIllIlIllllIIl, lllllllllllllllIIlIIllIlIllllIII);
    }
    
    public AxisAlignedBB func_190587_b(final EnumFacing lllllllllllllllIIlIIllIllIllIIIl) {
        return Block.FULL_BLOCK_AABB.addCoord(0.5f * this.func_190585_a(1.0f) * lllllllllllllllIIlIIllIllIllIIIl.getFrontOffsetX(), 0.5f * this.func_190585_a(1.0f) * lllllllllllllllIIlIIllIllIllIIIl.getFrontOffsetY(), 0.5f * this.func_190585_a(1.0f) * lllllllllllllllIIlIIllIllIllIIIl.getFrontOffsetZ());
    }
    
    public NBTTagCompound func_190580_f(final NBTTagCompound lllllllllllllllIIlIIllIlIlIIIlII) {
        if (!this.checkLootAndWrite(lllllllllllllllIIlIIllIlIlIIIlII)) {
            ItemStackHelper.func_191281_a(lllllllllllllllIIlIIllIlIlIIIlII, this.field_190596_f, false);
        }
        if (this.hasCustomName()) {
            lllllllllllllllIIlIIllIlIlIIIlII.setString("CustomName", this.field_190577_o);
        }
        if (!lllllllllllllllIIlIIllIlIlIIIlII.hasKey("Lock") && this.isLocked()) {
            this.getLockCode().toNBT(lllllllllllllllIIlIIllIlIlIIIlII);
        }
        return lllllllllllllllIIlIIllIlIlIIIlII;
    }
    
    public void func_190579_a(final boolean lllllllllllllllIIlIIllIlIIIlIlII) {
        this.field_190594_p = lllllllllllllllIIlIIllIlIIIlIlII;
    }
    
    public boolean func_190590_r() {
        return this.field_190597_g;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIIlIIllIlIlIllIII) {
        super.readFromNBT(lllllllllllllllIIlIIllIlIlIllIII);
        this.func_190586_e(lllllllllllllllIIlIIllIlIlIllIII);
    }
    
    public EnumDyeColor func_190592_s() {
        if (this.field_190602_l == null) {
            this.field_190602_l = BlockShulkerBox.func_190954_c(this.getBlockType());
        }
        return this.field_190602_l;
    }
    
    @Override
    public void update() {
        this.func_190583_o();
        if (this.field_190599_i == AnimationStatus.OPENING || this.field_190599_i == AnimationStatus.CLOSING) {
            this.func_190589_G();
        }
    }
    
    public boolean func_190582_F() {
        return !this.func_190581_E() || !this.func_191420_l() || this.hasCustomName() || this.lootTable != null;
    }
    
    @Override
    public int getSizeInventory() {
        return this.field_190596_f.size();
    }
    
    @Override
    protected NonNullList<ItemStack> func_190576_q() {
        return this.field_190596_f;
    }
    
    @Override
    public void clear() {
        this.field_190597_g = true;
        super.clear();
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllllIIlIIllIlIlllIIlI) {
        if (!lllllllllllllllIIlIIllIlIlllIIlI.isSpectator()) {
            if (this.field_190598_h < 0) {
                this.field_190598_h = 0;
            }
            ++this.field_190598_h;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.field_190598_h);
            if (this.field_190598_h == 1) {
                this.world.playSound(null, this.pos, SoundEvents.field_191262_fB, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
            }
        }
    }
    
    static {
        field_190595_a = new int[27];
        for (int lllllllllllllllIIlIIllIlllIIlllI = 0; lllllllllllllllIIlIIllIlllIIlllI < TileEntityShulkerBox.field_190595_a.length; TileEntityShulkerBox.field_190595_a[lllllllllllllllIIlIIllIlllIIlllI] = lllllllllllllllIIlIIllIlllIIlllI++) {}
    }
    
    private AxisAlignedBB func_190588_c(final EnumFacing lllllllllllllllIIlIIllIllIlIlIlI) {
        final EnumFacing lllllllllllllllIIlIIllIllIlIlIIl = lllllllllllllllIIlIIllIllIlIlIlI.getOpposite();
        return this.func_190587_b(lllllllllllllllIIlIIllIllIlIlIlI).func_191195_a(lllllllllllllllIIlIIllIllIlIlIIl.getFrontOffsetX(), lllllllllllllllIIlIIllIllIlIlIIl.getFrontOffsetY(), lllllllllllllllIIlIIllIllIlIlIIl.getFrontOffsetZ());
    }
    
    public void func_190586_e(final NBTTagCompound lllllllllllllllIIlIIllIlIlIIlIlI) {
        this.field_190596_f = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        if (!this.checkLootAndRead(lllllllllllllllIIlIIllIlIlIIlIlI) && lllllllllllllllIIlIIllIlIlIIlIlI.hasKey("Items", 9)) {
            ItemStackHelper.func_191283_b(lllllllllllllllIIlIIllIlIlIIlIlI, this.field_190596_f);
        }
        if (lllllllllllllllIIlIIllIlIlIIlIlI.hasKey("CustomName", 8)) {
            this.field_190577_o = lllllllllllllllIIlIIllIlIlIIlIlI.getString("CustomName");
        }
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.shulkerBox";
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllllIIlIIllIlIllIllII) {
        if (!lllllllllllllllIIlIIllIlIllIllII.isSpectator()) {
            --this.field_190598_h;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.field_190598_h);
            if (this.field_190598_h <= 0) {
                this.world.playSound(null, this.pos, SoundEvents.field_191261_fA, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
            }
        }
    }
    
    protected void func_190583_o() {
        this.field_190601_k = this.field_190600_j;
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus()[this.field_190599_i.ordinal()]) {
            case 1: {
                this.field_190600_j = 0.0f;
                break;
            }
            case 2: {
                this.field_190600_j += 0.1f;
                if (this.field_190600_j >= 1.0f) {
                    this.func_190589_G();
                    this.field_190599_i = AnimationStatus.OPENED;
                    this.field_190600_j = 1.0f;
                    break;
                }
                break;
            }
            case 4: {
                this.field_190600_j -= 0.1f;
                if (this.field_190600_j <= 0.0f) {
                    this.field_190599_i = AnimationStatus.CLOSED;
                    this.field_190600_j = 0.0f;
                    break;
                }
                break;
            }
            case 3: {
                this.field_190600_j = 1.0f;
                break;
            }
        }
    }
    
    @Override
    public boolean canExtractItem(final int lllllllllllllllIIlIIllIlIIlIllll, final ItemStack lllllllllllllllIIlIIllIlIIlIlllI, final EnumFacing lllllllllllllllIIlIIllIlIIlIllIl) {
        return true;
    }
    
    public TileEntityShulkerBox(@Nullable final EnumDyeColor lllllllllllllllIIlIIllIlllIIIlII) {
        this.field_190596_f = NonNullList.func_191197_a(27, ItemStack.field_190927_a);
        this.field_190599_i = AnimationStatus.CLOSED;
        this.field_190602_l = lllllllllllllllIIlIIllIlllIIIlII;
    }
    
    public static void func_190593_a(final DataFixer lllllllllllllllIIlIIllIlIlIlllIl) {
        lllllllllllllllIIlIIllIlIlIlllIl.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityShulkerBox.class, new String[] { "Items" }));
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllllIIlIIllIlIlIlIIlI) {
        super.writeToNBT(lllllllllllllllIIlIIllIlIlIlIIlI);
        return this.func_190580_f(lllllllllllllllIIlIIllIlIlIlIIlI);
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public enum AnimationStatus
    {
        OPENED("OPENED", 2), 
        CLOSING("CLOSING", 3), 
        OPENING("OPENING", 1), 
        CLOSED("CLOSED", 0);
        
        private AnimationStatus(final String llllllllllIlllIlIllIIlllIlIlIlII, final int llllllllllIlllIlIllIIlllIlIlIIll) {
        }
    }
}
