// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.Rotation;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.util.NonNullList;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;

public class BlockShulkerBox extends BlockContainer
{
    private final /* synthetic */ EnumDyeColor field_190958_b;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$EnumDyeColor;
    public static final /* synthetic */ PropertyEnum<EnumFacing> field_190957_a;
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllIlllIlllIllIlIlllIllll, final Mirror llllllllllIlllIlllIllIlIlllIlllI) {
        return llllllllllIlllIlllIllIlIlllIllll.withRotation(llllllllllIlllIlllIllIlIlllIlllI.toRotation(llllllllllIlllIlllIllIlIlllIllll.getValue(BlockShulkerBox.field_190957_a)));
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState llllllllllIlllIlllIllIllIIllIlll) {
        return EnumPushReaction.DESTROY;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState llllllllllIlllIlllIllIllIIlIIlII, final World llllllllllIlllIlllIllIllIIlIIIll, final BlockPos llllllllllIlllIlllIllIllIIlIIIII) {
        return Container.calcRedstoneFromInventory((IInventory)llllllllllIlllIlllIllIllIIlIIIll.getTileEntity(llllllllllIlllIlllIllIllIIlIIIII));
    }
    
    @Override
    public boolean func_190946_v(final IBlockState llllllllllIlllIlllIllIllllIllIII) {
        return true;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllIlllIlllIllIllllIllIlI) {
        return false;
    }
    
    public static EnumDyeColor func_190954_c(final Block llllllllllIlllIlllIllIllIIIIIllI) {
        return (llllllllllIlllIlllIllIllIIIIIllI instanceof BlockShulkerBox) ? ((BlockShulkerBox)llllllllllIlllIlllIllIllIIIIIllI).func_190956_e() : EnumDyeColor.PURPLE;
    }
    
    public static EnumDyeColor func_190955_b(final Item llllllllllIlllIlllIllIllIIIIlIIl) {
        return func_190954_c(Block.getBlockFromItem(llllllllllIlllIlllIllIllIIIIlIIl));
    }
    
    public EnumDyeColor func_190956_e() {
        return this.field_190958_b;
    }
    
    @Override
    public void onBlockHarvested(final World llllllllllIlllIlllIllIlllIIlIlII, final BlockPos llllllllllIlllIlllIllIlllIIIlllI, final IBlockState llllllllllIlllIlllIllIlllIIlIIlI, final EntityPlayer llllllllllIlllIlllIllIlllIIlIIIl) {
        if (llllllllllIlllIlllIllIlllIIlIlII.getTileEntity(llllllllllIlllIlllIllIlllIIIlllI) instanceof TileEntityShulkerBox) {
            final TileEntityShulkerBox llllllllllIlllIlllIllIlllIIlIIII = (TileEntityShulkerBox)llllllllllIlllIlllIllIlllIIlIlII.getTileEntity(llllllllllIlllIlllIllIlllIIIlllI);
            llllllllllIlllIlllIllIlllIIlIIII.func_190579_a(llllllllllIlllIlllIllIlllIIlIIIl.capabilities.isCreativeMode);
            llllllllllIlllIlllIllIlllIIlIIII.fillWithLoot(llllllllllIlllIlllIllIlllIIlIIIl);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllIlllIlllIllIllllIllllI) {
        return false;
    }
    
    @Override
    public void func_190948_a(final ItemStack llllllllllIlllIlllIllIllIlIIlllI, @Nullable final World llllllllllIlllIlllIllIllIlIIIIlI, final List<String> llllllllllIlllIlllIllIllIlIIllII, final ITooltipFlag llllllllllIlllIlllIllIllIlIIIIII) {
        super.func_190948_a(llllllllllIlllIlllIllIllIlIIlllI, llllllllllIlllIlllIllIllIlIIIIlI, llllllllllIlllIlllIllIllIlIIllII, llllllllllIlllIlllIllIllIlIIIIII);
        final NBTTagCompound llllllllllIlllIlllIllIllIlIIlIlI = llllllllllIlllIlllIllIllIlIIlllI.getTagCompound();
        if (llllllllllIlllIlllIllIllIlIIlIlI != null && llllllllllIlllIlllIllIllIlIIlIlI.hasKey("BlockEntityTag", 10)) {
            final NBTTagCompound llllllllllIlllIlllIllIllIlIIlIIl = llllllllllIlllIlllIllIllIlIIlIlI.getCompoundTag("BlockEntityTag");
            if (llllllllllIlllIlllIllIllIlIIlIIl.hasKey("LootTable", 8)) {
                llllllllllIlllIlllIllIllIlIIllII.add("???????");
            }
            if (llllllllllIlllIlllIllIllIlIIlIIl.hasKey("Items", 9)) {
                final NonNullList<ItemStack> llllllllllIlllIlllIllIllIlIIlIII = NonNullList.func_191197_a(27, ItemStack.field_190927_a);
                ItemStackHelper.func_191283_b(llllllllllIlllIlllIllIllIlIIlIIl, llllllllllIlllIlllIllIllIlIIlIII);
                int llllllllllIlllIlllIllIllIlIIIlll = 0;
                int llllllllllIlllIlllIllIllIlIIIllI = 0;
                for (final ItemStack llllllllllIlllIlllIllIllIlIIIlIl : llllllllllIlllIlllIllIllIlIIlIII) {
                    if (!llllllllllIlllIlllIllIllIlIIIlIl.func_190926_b()) {
                        ++llllllllllIlllIlllIllIllIlIIIllI;
                        if (llllllllllIlllIlllIllIllIlIIIlll > 4) {
                            continue;
                        }
                        ++llllllllllIlllIlllIllIllIlIIIlll;
                        llllllllllIlllIlllIllIllIlIIllII.add(String.format("%s x%d", llllllllllIlllIlllIllIllIlIIIlIl.getDisplayName(), llllllllllIlllIlllIllIllIlIIIlIl.func_190916_E()));
                    }
                }
                if (llllllllllIlllIlllIllIllIlIIIllI - llllllllllIlllIlllIllIllIlIIIlll > 0) {
                    llllllllllIlllIlllIllIllIlIIllII.add(String.format(TextFormatting.ITALIC + I18n.translateToLocal("container.shulkerBox.more"), llllllllllIlllIlllIllIllIlIIIllI - llllllllllIlllIlllIllIllIlIIIlll));
                }
            }
        }
    }
    
    public static ItemStack func_190953_b(final EnumDyeColor llllllllllIlllIlllIllIlIllllllII) {
        return new ItemStack(func_190952_a(llllllllllIlllIlllIllIlIllllllII));
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllIlllIlllIllIllllIIllII, final BlockPos llllllllllIlllIlllIllIllllIIlIll, final IBlockState llllllllllIlllIlllIllIlllIllllII, final EntityPlayer llllllllllIlllIlllIllIllllIIlIIl, final EnumHand llllllllllIlllIlllIllIllllIIlIII, final EnumFacing llllllllllIlllIlllIllIllllIIIlll, final float llllllllllIlllIlllIllIllllIIIllI, final float llllllllllIlllIlllIllIllllIIIlIl, final float llllllllllIlllIlllIllIllllIIIlII) {
        if (llllllllllIlllIlllIllIllllIIllII.isRemote) {
            return true;
        }
        if (llllllllllIlllIlllIllIllllIIlIIl.isSpectator()) {
            return true;
        }
        final TileEntity llllllllllIlllIlllIllIllllIIIIll = llllllllllIlllIlllIllIllllIIllII.getTileEntity(llllllllllIlllIlllIllIllllIIlIll);
        if (llllllllllIlllIlllIllIllllIIIIll instanceof TileEntityShulkerBox) {
            final EnumFacing llllllllllIlllIlllIllIllllIIIIlI = llllllllllIlllIlllIllIlllIllllII.getValue(BlockShulkerBox.field_190957_a);
            boolean llllllllllIlllIlllIllIllllIIIIII = false;
            if (((TileEntityShulkerBox)llllllllllIlllIlllIllIllllIIIIll).func_190591_p() == TileEntityShulkerBox.AnimationStatus.CLOSED) {
                final AxisAlignedBB llllllllllIlllIlllIllIlllIllllll = BlockShulkerBox.FULL_BLOCK_AABB.addCoord(0.5f * llllllllllIlllIlllIllIllllIIIIlI.getFrontOffsetX(), 0.5f * llllllllllIlllIlllIllIllllIIIIlI.getFrontOffsetY(), 0.5f * llllllllllIlllIlllIllIllllIIIIlI.getFrontOffsetZ()).func_191195_a(llllllllllIlllIlllIllIllllIIIIlI.getFrontOffsetX(), llllllllllIlllIlllIllIllllIIIIlI.getFrontOffsetY(), llllllllllIlllIlllIllIllllIIIIlI.getFrontOffsetZ());
                final boolean llllllllllIlllIlllIllIllllIIIIIl = !llllllllllIlllIlllIllIllllIIllII.collidesWithAnyBlock(llllllllllIlllIlllIllIlllIllllll.offset(llllllllllIlllIlllIllIllllIIlIll.offset(llllllllllIlllIlllIllIllllIIIIlI)));
            }
            else {
                llllllllllIlllIlllIllIllllIIIIII = true;
            }
            if (llllllllllIlllIlllIllIllllIIIIII) {
                llllllllllIlllIlllIllIllllIIlIIl.addStat(StatList.field_191272_ae);
                llllllllllIlllIlllIllIllllIIlIIl.displayGUIChest((IInventory)llllllllllIlllIlllIllIllllIIIIll);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllIlllIlllIllIlllllIIIlI, final int llllllllllIlllIlllIllIlllllIIIIl) {
        return new TileEntityShulkerBox(this.field_190958_b);
    }
    
    @Override
    public boolean causesSuffocation(final IBlockState llllllllllIlllIlllIllIllllIlllII) {
        return true;
    }
    
    public static Block func_190952_a(final EnumDyeColor llllllllllIlllIlllIllIllIIIIIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$item$EnumDyeColor()[llllllllllIlllIlllIllIllIIIIIIlI.ordinal()]) {
            case 1: {
                return Blocks.field_190977_dl;
            }
            case 2: {
                return Blocks.field_190978_dm;
            }
            case 3: {
                return Blocks.field_190979_dn;
            }
            case 4: {
                return Blocks.field_190980_do;
            }
            case 5: {
                return Blocks.field_190981_dp;
            }
            case 6: {
                return Blocks.field_190982_dq;
            }
            case 7: {
                return Blocks.field_190983_dr;
            }
            case 8: {
                return Blocks.field_190984_ds;
            }
            case 9: {
                return Blocks.field_190985_dt;
            }
            case 10: {
                return Blocks.field_190986_du;
            }
            default: {
                return Blocks.field_190987_dv;
            }
            case 12: {
                return Blocks.field_190988_dw;
            }
            case 13: {
                return Blocks.field_190989_dx;
            }
            case 14: {
                return Blocks.field_190990_dy;
            }
            case 15: {
                return Blocks.field_190991_dz;
            }
            case 16: {
                return Blocks.field_190975_dA;
            }
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllIlllIlllIllIlIlllIIlIl, IBlockState llllllllllIlllIlllIllIlIllIlllIl, final BlockPos llllllllllIlllIlllIllIlIlllIIIll, final EnumFacing llllllllllIlllIlllIllIlIllIllIll) {
        llllllllllIlllIlllIllIlIllIlllIl = this.getActualState(llllllllllIlllIlllIllIlIllIlllIl, llllllllllIlllIlllIllIlIlllIIlIl, llllllllllIlllIlllIllIlIlllIIIll);
        final EnumFacing llllllllllIlllIlllIllIlIlllIIIIl = llllllllllIlllIlllIllIlIllIlllIl.getValue(BlockShulkerBox.field_190957_a);
        final TileEntityShulkerBox.AnimationStatus llllllllllIlllIlllIllIlIlllIIIII = ((TileEntityShulkerBox)llllllllllIlllIlllIllIlIlllIIlIl.getTileEntity(llllllllllIlllIlllIllIlIlllIIIll)).func_190591_p();
        return (llllllllllIlllIlllIllIlIlllIIIII != TileEntityShulkerBox.AnimationStatus.CLOSED && (llllllllllIlllIlllIllIlIlllIIIII != TileEntityShulkerBox.AnimationStatus.OPENED || (llllllllllIlllIlllIllIlIlllIIIIl != llllllllllIlllIlllIllIlIllIllIll.getOpposite() && llllllllllIlllIlllIllIlIlllIIIIl != llllllllllIlllIlllIllIlIllIllIll))) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
    }
    
    public BlockShulkerBox(final EnumDyeColor llllllllllIlllIlllIllIlllllIIlll) {
        super(Material.ROCK, MapColor.AIR);
        this.field_190958_b = llllllllllIlllIlllIllIlllllIIlll;
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockShulkerBox.field_190957_a, EnumFacing.UP));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllIlllIlllIllIlllIlIIIll) {
        return llllllllllIlllIlllIllIlllIlIIIll.getValue(BlockShulkerBox.field_190957_a).getIndex();
    }
    
    @Override
    public void breakBlock(final World llllllllllIlllIlllIllIllIllIllII, final BlockPos llllllllllIlllIlllIllIllIllIIIlI, final IBlockState llllllllllIlllIlllIllIllIllIlIlI) {
        final TileEntity llllllllllIlllIlllIllIllIllIlIIl = llllllllllIlllIlllIllIllIllIllII.getTileEntity(llllllllllIlllIlllIllIllIllIIIlI);
        if (llllllllllIlllIlllIllIllIllIlIIl instanceof TileEntityShulkerBox) {
            final TileEntityShulkerBox llllllllllIlllIlllIllIllIllIlIII = (TileEntityShulkerBox)llllllllllIlllIlllIllIllIllIlIIl;
            if (!llllllllllIlllIlllIllIllIllIlIII.func_190590_r() && llllllllllIlllIlllIllIllIllIlIII.func_190582_F()) {
                final ItemStack llllllllllIlllIlllIllIllIllIIlll = new ItemStack(Item.getItemFromBlock(this));
                final NBTTagCompound llllllllllIlllIlllIllIllIllIIllI = new NBTTagCompound();
                final NBTTagCompound llllllllllIlllIlllIllIllIllIIlIl = new NBTTagCompound();
                llllllllllIlllIlllIllIllIllIIllI.setTag("BlockEntityTag", ((TileEntityShulkerBox)llllllllllIlllIlllIllIllIllIlIIl).func_190580_f(llllllllllIlllIlllIllIllIllIIlIl));
                llllllllllIlllIlllIllIllIllIIlll.setTagCompound(llllllllllIlllIlllIllIllIllIIllI);
                if (llllllllllIlllIlllIllIllIllIlIII.hasCustomName()) {
                    llllllllllIlllIlllIllIllIllIIlll.setStackDisplayName(llllllllllIlllIlllIllIllIllIlIII.getName());
                    llllllllllIlllIlllIllIllIllIlIII.func_190575_a("");
                }
                Block.spawnAsEntity(llllllllllIlllIlllIllIllIllIllII, llllllllllIlllIlllIllIllIllIIIlI, llllllllllIlllIlllIllIllIllIIlll);
            }
            llllllllllIlllIlllIllIllIllIllII.updateComparatorOutputLevel(llllllllllIlllIlllIllIllIllIIIlI, llllllllllIlllIlllIllIllIllIlIlI.getBlock());
        }
        super.breakBlock(llllllllllIlllIlllIllIllIllIllII, llllllllllIlllIlllIllIllIllIIIlI, llllllllllIlllIlllIllIllIllIlIlI);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllIlllIlllIllIlllIIIlIlI, final BlockPos llllllllllIlllIlllIllIlllIIIlIIl, final IBlockState llllllllllIlllIlllIllIlllIIIlIII, final float llllllllllIlllIlllIllIlllIIIIlll, final int llllllllllIlllIlllIllIlllIIIIllI) {
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockShulkerBox.field_190957_a });
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllIlllIlllIllIlllIllIIll, final BlockPos llllllllllIlllIlllIllIlllIllIIlI, final EnumFacing llllllllllIlllIlllIllIlllIllIIIl, final float llllllllllIlllIlllIllIlllIllIIII, final float llllllllllIlllIlllIllIlllIlIllll, final float llllllllllIlllIlllIllIlllIlIlllI, final int llllllllllIlllIlllIllIlllIlIllIl, final EntityLivingBase llllllllllIlllIlllIllIlllIlIllII) {
        return this.getDefaultState().withProperty(BlockShulkerBox.field_190957_a, llllllllllIlllIlllIllIlllIllIIIl);
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState llllllllllIlllIlllIllIllIIlIlIII) {
        return true;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllIlllIlllIllIllIIlIllIl, final IBlockAccess llllllllllIlllIlllIllIllIIllIIII, final BlockPos llllllllllIlllIlllIllIllIIlIlIll) {
        final TileEntity llllllllllIlllIlllIllIllIIlIlllI = llllllllllIlllIlllIllIllIIllIIII.getTileEntity(llllllllllIlllIlllIllIllIIlIlIll);
        return (llllllllllIlllIlllIllIllIIlIlllI instanceof TileEntityShulkerBox) ? ((TileEntityShulkerBox)llllllllllIlllIlllIllIllIIlIlllI).func_190584_a(llllllllllIlllIlllIllIllIIlIllIl) : BlockShulkerBox.FULL_BLOCK_AABB;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$EnumDyeColor() {
        final int[] $switch_TABLE$net$minecraft$item$EnumDyeColor = BlockShulkerBox.$SWITCH_TABLE$net$minecraft$item$EnumDyeColor;
        if ($switch_TABLE$net$minecraft$item$EnumDyeColor != null) {
            return $switch_TABLE$net$minecraft$item$EnumDyeColor;
        }
        final long llllllllllIlllIlllIllIlIllIlIlll = (Object)new int[EnumDyeColor.values().length];
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.BLACK.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.BLUE.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.BROWN.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.CYAN.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.GRAY.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.GREEN.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.LIGHT_BLUE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.LIME.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.MAGENTA.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.ORANGE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.PINK.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.PURPLE.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.RED.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.SILVER.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.WHITE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError15) {}
        try {
            llllllllllIlllIlllIllIlIllIlIlll[EnumDyeColor.YELLOW.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError16) {}
        return BlockShulkerBox.$SWITCH_TABLE$net$minecraft$item$EnumDyeColor = (int[])(Object)llllllllllIlllIlllIllIlIllIlIlll;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllIlllIlllIllIllIIIlIlll, final BlockPos llllllllllIlllIlllIllIllIIIIllll, final IBlockState llllllllllIlllIlllIllIllIIIlIlIl) {
        final ItemStack llllllllllIlllIlllIllIllIIIlIlII = super.getItem(llllllllllIlllIlllIllIllIIIlIlll, llllllllllIlllIlllIllIllIIIIllll, llllllllllIlllIlllIllIllIIIlIlIl);
        final TileEntityShulkerBox llllllllllIlllIlllIllIllIIIlIIll = (TileEntityShulkerBox)llllllllllIlllIlllIllIllIIIlIlll.getTileEntity(llllllllllIlllIlllIllIllIIIIllll);
        final NBTTagCompound llllllllllIlllIlllIllIllIIIlIIlI = llllllllllIlllIlllIllIllIIIlIIll.func_190580_f(new NBTTagCompound());
        if (!llllllllllIlllIlllIllIllIIIlIIlI.hasNoTags()) {
            llllllllllIlllIlllIllIllIIIlIlII.setTagInfo("BlockEntityTag", llllllllllIlllIlllIllIllIIIlIIlI);
        }
        return llllllllllIlllIlllIllIllIIIlIlII;
    }
    
    static {
        field_190957_a = PropertyDirection.create("facing");
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllIlllIlllIllIllIllllIlI, final BlockPos llllllllllIlllIlllIllIllIlllllll, final IBlockState llllllllllIlllIlllIllIllIllllllI, final EntityLivingBase llllllllllIlllIlllIllIllIlllllIl, final ItemStack llllllllllIlllIlllIllIllIlllllII) {
        if (llllllllllIlllIlllIllIllIlllllII.hasDisplayName()) {
            final TileEntity llllllllllIlllIlllIllIllIllllIll = llllllllllIlllIlllIllIllIllllIlI.getTileEntity(llllllllllIlllIlllIllIllIlllllll);
            if (llllllllllIlllIlllIllIllIllllIll instanceof TileEntityShulkerBox) {
                ((TileEntityShulkerBox)llllllllllIlllIlllIllIllIllllIll).func_190575_a(llllllllllIlllIlllIllIllIlllllII.getDisplayName());
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllIlllIlllIllIlllIIllllI) {
        final EnumFacing llllllllllIlllIlllIllIlllIIlllIl = EnumFacing.getFront(llllllllllIlllIlllIllIlllIIllllI);
        return this.getDefaultState().withProperty(BlockShulkerBox.field_190957_a, llllllllllIlllIlllIllIlllIIlllIl);
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllIlllIlllIllIllllIlIllI) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllIlllIlllIllIlIllllIllI, final Rotation llllllllllIlllIlllIllIlIllllIlll) {
        return llllllllllIlllIlllIllIlIllllIllI.withProperty(BlockShulkerBox.field_190957_a, llllllllllIlllIlllIllIlIllllIlll.rotate(llllllllllIlllIlllIllIlIllllIllI.getValue(BlockShulkerBox.field_190957_a)));
    }
}
