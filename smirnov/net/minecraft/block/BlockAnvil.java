// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.IInteractionObject;
import net.minecraft.util.EnumHand;
import net.minecraft.block.state.BlockStateContainer;
import org.apache.logging.log4j.LogManager;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.Rotation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import org.apache.logging.log4j.Logger;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.properties.PropertyDirection;

public class BlockAnvil extends BlockFalling
{
    public static final /* synthetic */ PropertyDirection FACING;
    public static final /* synthetic */ PropertyInteger DAMAGE;
    protected static final /* synthetic */ Logger LOGGER;
    protected static final /* synthetic */ AxisAlignedBB X_AXIS_AABB;
    protected static final /* synthetic */ AxisAlignedBB Z_AXIS_AABB;
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllIlllIIIlIlIIIIlllllIIl) {
        return false;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllIlllIIIlIlIIIIlIllIlll, final NonNullList<ItemStack> llllllllllIlllIIIlIlIIIIlIllIlII) {
        llllllllllIlllIIIlIlIIIIlIllIlII.add(new ItemStack(this));
        llllllllllIlllIIIlIlIIIIlIllIlII.add(new ItemStack(this, 1, 1));
        llllllllllIlllIIIlIlIIIIlIllIlII.add(new ItemStack(this, 1, 2));
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllIlllIIIlIlIIIIlllIIIIl, final BlockPos llllllllllIlllIIIlIlIIIIlllIIIII, final EnumFacing llllllllllIlllIIIlIlIIIIllIlllll, final float llllllllllIlllIIIlIlIIIIlllIlIIl, final float llllllllllIlllIIIlIlIIIIlllIlIII, final float llllllllllIlllIIIlIlIIIIlllIIlll, final int llllllllllIlllIIIlIlIIIIlllIIllI, final EntityLivingBase llllllllllIlllIIIlIlIIIIlllIIlIl) {
        final EnumFacing llllllllllIlllIIIlIlIIIIlllIIlII = llllllllllIlllIIIlIlIIIIlllIIlIl.getHorizontalFacing().rotateY();
        try {
            return super.onBlockPlaced(llllllllllIlllIIIlIlIIIIlllIIIIl, llllllllllIlllIIIlIlIIIIlllIIIII, llllllllllIlllIIIlIlIIIIllIlllll, llllllllllIlllIIIlIlIIIIlllIlIIl, llllllllllIlllIIIlIlIIIIlllIlIII, llllllllllIlllIIIlIlIIIIlllIIlll, llllllllllIlllIIIlIlIIIIlllIIllI, llllllllllIlllIIIlIlIIIIlllIIlIl).withProperty((IProperty<Comparable>)BlockAnvil.FACING, llllllllllIlllIIIlIlIIIIlllIIlII).withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, llllllllllIlllIIIlIlIIIIlllIIllI >> 2);
        }
        catch (IllegalArgumentException llllllllllIlllIIIlIlIIIIlllIIIll) {
            if (!llllllllllIlllIIIlIlIIIIlllIIIIl.isRemote) {
                BlockAnvil.LOGGER.warn(String.format("Invalid damage property for anvil at %s. Found %d, must be in [0, 1, 2]", llllllllllIlllIIIlIlIIIIlllIIIII, llllllllllIlllIIIlIlIIIIlllIIllI >> 2));
                if (llllllllllIlllIIIlIlIIIIlllIIlIl instanceof EntityPlayer) {
                    llllllllllIlllIIIlIlIIIIlllIIlIl.addChatMessage(new TextComponentTranslation("Invalid damage property. Please pick in [0, 1, 2]", new Object[0]));
                }
            }
            return super.onBlockPlaced(llllllllllIlllIIIlIlIIIIlllIIIIl, llllllllllIlllIIIlIlIIIIlllIIIII, llllllllllIlllIIIlIlIIIIllIlllll, llllllllllIlllIIIlIlIIIIlllIlIIl, llllllllllIlllIIIlIlIIIIlllIlIII, llllllllllIlllIIIlIlIIIIlllIIlll, 0, llllllllllIlllIIIlIlIIIIlllIIlIl).withProperty((IProperty<Comparable>)BlockAnvil.FACING, llllllllllIlllIIIlIlIIIIlllIIlII).withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, 0);
        }
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllIlllIIIlIlIIIIlIIIlIIl, final Rotation llllllllllIlllIIIlIlIIIIlIIIIlIl) {
        return (llllllllllIlllIIIlIlIIIIlIIIlIIl.getBlock() != this) ? llllllllllIlllIIIlIlIIIIlIIIlIIl : llllllllllIlllIIIlIlIIIIlIIIlIIl.withProperty((IProperty<Comparable>)BlockAnvil.FACING, llllllllllIlllIIIlIlIIIIlIIIIlIl.rotate(llllllllllIlllIIIlIlIIIIlIIIlIIl.getValue((IProperty<EnumFacing>)BlockAnvil.FACING)));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllIlllIIIlIlIIIIlIIlIlll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockAnvil.FACING, EnumFacing.getHorizontal(llllllllllIlllIIIlIlIIIIlIIlIlll & 0x3)).withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, (llllllllllIlllIIIlIlIIIIlIIlIlll & 0xF) >> 2);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllIlllIIIlIlIIIIlIIllllI, final IBlockAccess llllllllllIlllIIIlIlIIIIlIIlllIl, final BlockPos llllllllllIlllIIIlIlIIIIlIIlllII, final EnumFacing llllllllllIlllIIIlIlIIIIlIIllIll) {
        return true;
    }
    
    @Override
    protected void onStartFalling(final EntityFallingBlock llllllllllIlllIIIlIlIIIIlIllIIIl) {
        llllllllllIlllIIIlIlIIIIlIllIIIl.setHurtEntities(true);
    }
    
    protected BlockAnvil() {
        super(Material.ANVIL);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockAnvil.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, 0));
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllIlllIIIlIlIIIIlllllllI, final IBlockState llllllllllIlllIIIlIlIIIIllllllIl, final BlockPos llllllllllIlllIIIlIlIIIIllllllII, final EnumFacing llllllllllIlllIIIlIlIIIIlllllIll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void onEndFalling(final World llllllllllIlllIIIlIlIIIIlIlIllII, final BlockPos llllllllllIlllIIIlIlIIIIlIlIIlll, final IBlockState llllllllllIlllIIIlIlIIIIlIlIlIlI, final IBlockState llllllllllIlllIIIlIlIIIIlIlIlIIl) {
        llllllllllIlllIIIlIlIIIIlIlIllII.playEvent(1031, llllllllllIlllIIIlIlIIIIlIlIIlll, 0);
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        DAMAGE = PropertyInteger.create("damage", 0, 2);
        X_AXIS_AABB = new AxisAlignedBB(0.0, 0.0, 0.125, 1.0, 1.0, 0.875);
        Z_AXIS_AABB = new AxisAlignedBB(0.125, 0.0, 0.0, 0.875, 1.0, 1.0);
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockAnvil.FACING, BlockAnvil.DAMAGE });
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllIlllIIIlIlIIIIllIIlIlI, final BlockPos llllllllllIlllIIIlIlIIIIllIIlIIl, final IBlockState llllllllllIlllIIIlIlIIIIllIlIIIl, final EntityPlayer llllllllllIlllIIIlIlIIIIllIlIIII, final EnumHand llllllllllIlllIIIlIlIIIIllIIllll, final EnumFacing llllllllllIlllIIIlIlIIIIllIIlllI, final float llllllllllIlllIIIlIlIIIIllIIllIl, final float llllllllllIlllIIIlIlIIIIllIIllII, final float llllllllllIlllIIIlIlIIIIllIIlIll) {
        if (!llllllllllIlllIIIlIlIIIIllIIlIlI.isRemote) {
            llllllllllIlllIIIlIlIIIIllIlIIII.displayGui(new Anvil(llllllllllIlllIIIlIlIIIIllIIlIlI, llllllllllIlllIIIlIlIIIIllIIlIIl));
        }
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllIlllIIIlIlIIIIlIIlIIIl) {
        int llllllllllIlllIIIlIlIIIIlIIlIIII = 0;
        llllllllllIlllIIIlIlIIIIlIIlIIII |= llllllllllIlllIIIlIlIIIIlIIlIIIl.getValue((IProperty<EnumFacing>)BlockAnvil.FACING).getHorizontalIndex();
        llllllllllIlllIIIlIlIIIIlIIlIIII |= llllllllllIlllIIIlIlIIIIlIIlIIIl.getValue((IProperty<Integer>)BlockAnvil.DAMAGE) << 2;
        return llllllllllIlllIIIlIlIIIIlIIlIIII;
    }
    
    @Override
    public void func_190974_b(final World llllllllllIlllIIIlIlIIIIlIlIIIll, final BlockPos llllllllllIlllIIIlIlIIIIlIlIIIII) {
        llllllllllIlllIIIlIlIIIIlIlIIIll.playEvent(1029, llllllllllIlllIIIlIlIIIIlIlIIIII, 0);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllIlllIIIlIlIIIIlIllllII, final IBlockAccess llllllllllIlllIIIlIlIIIIlIllllll, final BlockPos llllllllllIlllIIIlIlIIIIlIlllllI) {
        final EnumFacing llllllllllIlllIIIlIlIIIIlIllllIl = llllllllllIlllIIIlIlIIIIlIllllII.getValue((IProperty<EnumFacing>)BlockAnvil.FACING);
        return (llllllllllIlllIIIlIlIIIIlIllllIl.getAxis() == EnumFacing.Axis.X) ? BlockAnvil.X_AXIS_AABB : BlockAnvil.Z_AXIS_AABB;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllIlllIIIlIlIIIlIIIIIIII) {
        return false;
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllIlllIIIlIlIIIIllIIIlIl) {
        return llllllllllIlllIIIlIlIIIIllIIIlIl.getValue((IProperty<Integer>)BlockAnvil.DAMAGE);
    }
    
    public static class Anvil implements IInteractionObject
    {
        private final /* synthetic */ World world;
        private final /* synthetic */ BlockPos position;
        
        @Override
        public String getName() {
            return "anvil";
        }
        
        @Override
        public boolean hasCustomName() {
            return false;
        }
        
        @Override
        public Container createContainer(final InventoryPlayer lllllllllllIllIlIllIllIIIIllIlIl, final EntityPlayer lllllllllllIllIlIllIllIIIIllIIIl) {
            return new ContainerRepair(lllllllllllIllIlIllIllIIIIllIlIl, this.world, this.position, lllllllllllIllIlIllIllIIIIllIIIl);
        }
        
        public Anvil(final World lllllllllllIllIlIllIllIIIlIIIIIl, final BlockPos lllllllllllIllIlIllIllIIIIllllIl) {
            this.world = lllllllllllIllIlIllIllIIIlIIIIIl;
            this.position = lllllllllllIllIlIllIllIIIIllllIl;
        }
        
        @Override
        public ITextComponent getDisplayName() {
            return new TextComponentTranslation(String.valueOf(Blocks.ANVIL.getUnlocalizedName()) + ".name", new Object[0]);
        }
        
        @Override
        public String getGuiID() {
            return "minecraft:anvil";
        }
    }
}
