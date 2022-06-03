// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyBool;

public class BlockWall extends Block
{
    public static final /* synthetic */ PropertyBool UP;
    public static final /* synthetic */ PropertyBool WEST;
    protected static final /* synthetic */ AxisAlignedBB[] AABB_BY_INDEX;
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    protected static final /* synthetic */ AxisAlignedBB[] CLIP_AABB_BY_INDEX;
    public static final /* synthetic */ PropertyBool NORTH;
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool SOUTH;
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIIIlIlIllIIlIlllllIl) {
        return false;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllIIIIlIlIllIIlIllllIll, final BlockPos lllllllllllIIIIlIlIllIIlIllllIlI) {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIIIlIlIllIIlIllllIII) {
        return false;
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllIIIIlIlIllIIlIlIIllII) {
        return lllllllllllIIIIlIlIllIIlIlIIllII.getValue(BlockWall.VARIANT).getMetadata();
    }
    
    protected static boolean func_194143_e(final Block lllllllllllIIIIlIlIllIIlIlIlllll) {
        return Block.func_193382_c(lllllllllllIIIIlIlIllIIlIlIlllll) || lllllllllllIIIIlIlIllIIlIlIlllll == Blocks.BARRIER || lllllllllllIIIIlIlIllIIlIlIlllll == Blocks.MELON_BLOCK || lllllllllllIIIIlIlIllIIlIlIlllll == Blocks.PUMPKIN || lllllllllllIIIIlIlIllIIlIlIlllll == Blocks.LIT_PUMPKIN;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockWall.UP, BlockWall.NORTH, BlockWall.EAST, BlockWall.WEST, BlockWall.SOUTH, BlockWall.VARIANT });
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState lllllllllllIIIIlIlIllIIllIIIlIlI, final IBlockAccess lllllllllllIIIIlIlIllIIllIIIllIl, final BlockPos lllllllllllIIIIlIlIllIIllIIIllII) {
        lllllllllllIIIIlIlIllIIllIIIlIlI = this.getActualState(lllllllllllIIIIlIlIllIIllIIIlIlI, lllllllllllIIIIlIlIllIIllIIIllIl, lllllllllllIIIIlIlIllIIllIIIllII);
        return BlockWall.CLIP_AABB_BY_INDEX[getAABBIndex(lllllllllllIIIIlIlIllIIllIIIlIlI)];
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIIIlIlIllIIlIIIlIIIl, final IBlockState lllllllllllIIIIlIlIllIIlIIIlIIII, final BlockPos lllllllllllIIIIlIlIllIIlIIIIllll, final EnumFacing lllllllllllIIIIlIlIllIIlIIIIlllI) {
        return (lllllllllllIIIIlIlIllIIlIIIIlllI != EnumFacing.UP && lllllllllllIIIIlIlIllIIlIIIIlllI != EnumFacing.DOWN) ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllIIIIlIlIllIIlIlIlIlll, final NonNullList<ItemStack> lllllllllllIIIIlIlIllIIlIlIlIIll) {
        final boolean lllllllllllIIIIlIlIllIIlIlIIllll;
        final byte lllllllllllIIIIlIlIllIIlIlIlIIII = (byte)((EnumType[])(Object)(lllllllllllIIIIlIlIllIIlIlIIllll = (boolean)(Object)EnumType.values())).length;
        for (double lllllllllllIIIIlIlIllIIlIlIlIIIl = 0; lllllllllllIIIIlIlIllIIlIlIlIIIl < lllllllllllIIIIlIlIllIIlIlIlIIII; ++lllllllllllIIIIlIlIllIIlIlIlIIIl) {
            final EnumType lllllllllllIIIIlIlIllIIlIlIlIlIl = lllllllllllIIIIlIlIllIIlIlIIllll[lllllllllllIIIIlIlIllIIlIlIlIIIl];
            lllllllllllIIIIlIlIllIIlIlIlIIll.add(new ItemStack(this, 1, lllllllllllIIIIlIlIllIIlIlIlIlIl.getMetadata()));
        }
    }
    
    private boolean canConnectTo(final IBlockAccess lllllllllllIIIIlIlIllIIlIllIlIII, final BlockPos lllllllllllIIIIlIlIllIIlIllIlllI, final EnumFacing lllllllllllIIIIlIlIllIIlIllIIllI) {
        final IBlockState lllllllllllIIIIlIlIllIIlIllIllII = lllllllllllIIIIlIlIllIIlIllIlIII.getBlockState(lllllllllllIIIIlIlIllIIlIllIlllI);
        final Block lllllllllllIIIIlIlIllIIlIllIlIll = lllllllllllIIIIlIlIllIIlIllIllII.getBlock();
        final BlockFaceShape lllllllllllIIIIlIlIllIIlIllIlIlI = lllllllllllIIIIlIlIllIIlIllIllII.func_193401_d(lllllllllllIIIIlIlIllIIlIllIlIII, lllllllllllIIIIlIlIllIIlIllIlllI, lllllllllllIIIIlIlIllIIlIllIIllI);
        final boolean lllllllllllIIIIlIlIllIIlIllIlIIl = lllllllllllIIIIlIlIllIIlIllIlIlI == BlockFaceShape.MIDDLE_POLE_THICK || (lllllllllllIIIIlIlIllIIlIllIlIlI == BlockFaceShape.MIDDLE_POLE && lllllllllllIIIIlIlIllIIlIllIlIll instanceof BlockFenceGate);
        return (!func_194143_e(lllllllllllIIIIlIlIllIIlIllIlIll) && lllllllllllIIIIlIlIllIIlIllIlIlI == BlockFaceShape.SOLID) || lllllllllllIIIIlIlIllIIlIllIlIIl;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIIlIlIllIIlIIllIllI) {
        return this.getDefaultState().withProperty(BlockWall.VARIANT, EnumType.byMetadata(lllllllllllIIIIlIlIllIIlIIllIllI));
    }
    
    private static int getAABBIndex(final IBlockState lllllllllllIIIIlIlIllIIllIIIIlIl) {
        int lllllllllllIIIIlIlIllIIllIIIIlII = 0;
        if (lllllllllllIIIIlIlIllIIllIIIIlIl.getValue((IProperty<Boolean>)BlockWall.NORTH)) {
            lllllllllllIIIIlIlIllIIllIIIIlII |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }
        if (lllllllllllIIIIlIlIllIIllIIIIlIl.getValue((IProperty<Boolean>)BlockWall.EAST)) {
            lllllllllllIIIIlIlIllIIllIIIIlII |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }
        if (lllllllllllIIIIlIlIllIIllIIIIlIl.getValue((IProperty<Boolean>)BlockWall.SOUTH)) {
            lllllllllllIIIIlIlIllIIllIIIIlII |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }
        if (lllllllllllIIIIlIlIllIIllIIIIlIl.getValue((IProperty<Boolean>)BlockWall.WEST)) {
            lllllllllllIIIIlIlIllIIllIIIIlII |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }
        return lllllllllllIIIIlIlIllIIllIIIIlII;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState lllllllllllIIIIlIlIllIIllIlIllII, final IBlockAccess lllllllllllIIIIlIlIllIIllIlIlIll, final BlockPos lllllllllllIIIIlIlIllIIllIlIlIlI) {
        lllllllllllIIIIlIlIllIIllIlIllII = this.getActualState(lllllllllllIIIIlIlIllIIllIlIllII, lllllllllllIIIIlIlIllIIllIlIlIll, lllllllllllIIIIlIlIllIIllIlIlIlI);
        return BlockWall.AABB_BY_INDEX[getAABBIndex(lllllllllllIIIIlIlIllIIllIlIllII)];
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIIlIlIllIIlIIllIIll) {
        return lllllllllllIIIIlIlIllIIlIIllIIll.getValue(BlockWall.VARIANT).getMetadata();
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIIIIlIlIllIIlIlIIIlII, final IBlockAccess lllllllllllIIIIlIlIllIIlIlIIIIll, final BlockPos lllllllllllIIIIlIlIllIIlIlIIIIlI, final EnumFacing lllllllllllIIIIlIlIllIIlIlIIIIIl) {
        return lllllllllllIIIIlIlIllIIlIlIIIIIl != EnumFacing.DOWN || super.shouldSideBeRendered(lllllllllllIIIIlIlIllIIlIlIIIlII, lllllllllllIIIIlIlIllIIlIlIIIIll, lllllllllllIIIIlIlIllIIlIlIIIIlI, lllllllllllIIIIlIlIllIIlIlIIIIIl);
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(this.getUnlocalizedName()) + "." + EnumType.NORMAL.getUnlocalizedName() + ".name");
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState lllllllllllIIIIlIlIllIIllIIllIIl, final World lllllllllllIIIIlIlIllIIllIIllIII, final BlockPos lllllllllllIIIIlIlIllIIllIIlllll, final AxisAlignedBB lllllllllllIIIIlIlIllIIllIIllllI, final List<AxisAlignedBB> lllllllllllIIIIlIlIllIIllIIlllIl, @Nullable final Entity lllllllllllIIIIlIlIllIIllIIlllII, final boolean lllllllllllIIIIlIlIllIIllIIllIll) {
        if (!lllllllllllIIIIlIlIllIIllIIllIll) {
            lllllllllllIIIIlIlIllIIllIIllIIl = this.getActualState(lllllllllllIIIIlIlIllIIllIIllIIl, lllllllllllIIIIlIlIllIIllIIllIII, lllllllllllIIIIlIlIllIIllIIlllll);
        }
        Block.addCollisionBoxToList(lllllllllllIIIIlIlIllIIllIIlllll, lllllllllllIIIIlIlIllIIllIIllllI, lllllllllllIIIIlIlIllIIllIIlllIl, BlockWall.CLIP_AABB_BY_INDEX[getAABBIndex(lllllllllllIIIIlIlIllIIllIIllIIl)]);
    }
    
    static {
        UP = PropertyBool.create("up");
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        VARIANT = PropertyEnum.create("variant", EnumType.class);
        AABB_BY_INDEX = new AxisAlignedBB[] { new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 0.75), new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.25, 0.75, 1.0, 0.75), new AxisAlignedBB(0.0, 0.0, 0.25, 0.75, 1.0, 1.0), new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 1.0, 0.75), new AxisAlignedBB(0.3125, 0.0, 0.0, 0.6875, 0.875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 0.75, 1.0, 0.75), new AxisAlignedBB(0.0, 0.0, 0.0, 0.75, 1.0, 1.0), new AxisAlignedBB(0.25, 0.0, 0.25, 1.0, 1.0, 0.75), new AxisAlignedBB(0.25, 0.0, 0.25, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.3125, 1.0, 0.875, 0.6875), new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 1.0, 1.0), new AxisAlignedBB(0.25, 0.0, 0.0, 1.0, 1.0, 0.75), new AxisAlignedBB(0.25, 0.0, 0.0, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.75), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
        CLIP_AABB_BY_INDEX = new AxisAlignedBB[] { BlockWall.AABB_BY_INDEX[0].setMaxY(1.5), BlockWall.AABB_BY_INDEX[1].setMaxY(1.5), BlockWall.AABB_BY_INDEX[2].setMaxY(1.5), BlockWall.AABB_BY_INDEX[3].setMaxY(1.5), BlockWall.AABB_BY_INDEX[4].setMaxY(1.5), BlockWall.AABB_BY_INDEX[5].setMaxY(1.5), BlockWall.AABB_BY_INDEX[6].setMaxY(1.5), BlockWall.AABB_BY_INDEX[7].setMaxY(1.5), BlockWall.AABB_BY_INDEX[8].setMaxY(1.5), BlockWall.AABB_BY_INDEX[9].setMaxY(1.5), BlockWall.AABB_BY_INDEX[10].setMaxY(1.5), BlockWall.AABB_BY_INDEX[11].setMaxY(1.5), BlockWall.AABB_BY_INDEX[12].setMaxY(1.5), BlockWall.AABB_BY_INDEX[13].setMaxY(1.5), BlockWall.AABB_BY_INDEX[14].setMaxY(1.5), BlockWall.AABB_BY_INDEX[15].setMaxY(1.5) };
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllIIIIlIlIllIIlIIIllllI, final IBlockAccess lllllllllllIIIIlIlIllIIlIIlIIllI, final BlockPos lllllllllllIIIIlIlIllIIlIIIlllII) {
        final boolean lllllllllllIIIIlIlIllIIlIIlIIlII = this.canConnectTo(lllllllllllIIIIlIlIllIIlIIlIIllI, lllllllllllIIIIlIlIllIIlIIIlllII.north(), EnumFacing.SOUTH);
        final boolean lllllllllllIIIIlIlIllIIlIIlIIIll = this.canConnectTo(lllllllllllIIIIlIlIllIIlIIlIIllI, lllllllllllIIIIlIlIllIIlIIIlllII.east(), EnumFacing.WEST);
        final boolean lllllllllllIIIIlIlIllIIlIIlIIIlI = this.canConnectTo(lllllllllllIIIIlIlIllIIlIIlIIllI, lllllllllllIIIIlIlIllIIlIIIlllII.south(), EnumFacing.NORTH);
        final boolean lllllllllllIIIIlIlIllIIlIIlIIIIl = this.canConnectTo(lllllllllllIIIIlIlIllIIlIIlIIllI, lllllllllllIIIIlIlIllIIlIIIlllII.west(), EnumFacing.EAST);
        final boolean lllllllllllIIIIlIlIllIIlIIlIIIII = (lllllllllllIIIIlIlIllIIlIIlIIlII && !lllllllllllIIIIlIlIllIIlIIlIIIll && lllllllllllIIIIlIlIllIIlIIlIIIlI && !lllllllllllIIIIlIlIllIIlIIlIIIIl) || (!lllllllllllIIIIlIlIllIIlIIlIIlII && lllllllllllIIIIlIlIllIIlIIlIIIll && !lllllllllllIIIIlIlIllIIlIIlIIIlI && lllllllllllIIIIlIlIllIIlIIlIIIIl);
        return lllllllllllIIIIlIlIllIIlIIIllllI.withProperty((IProperty<Comparable>)BlockWall.UP, !lllllllllllIIIIlIlIllIIlIIlIIIII || !lllllllllllIIIIlIlIllIIlIIlIIllI.isAirBlock(lllllllllllIIIIlIlIllIIlIIIlllII.up())).withProperty((IProperty<Comparable>)BlockWall.NORTH, lllllllllllIIIIlIlIllIIlIIlIIlII).withProperty((IProperty<Comparable>)BlockWall.EAST, lllllllllllIIIIlIlIllIIlIIlIIIll).withProperty((IProperty<Comparable>)BlockWall.SOUTH, lllllllllllIIIIlIlIllIIlIIlIIIlI).withProperty((IProperty<Comparable>)BlockWall.WEST, lllllllllllIIIIlIlIllIIlIIlIIIIl);
    }
    
    public BlockWall(final Block lllllllllllIIIIlIlIllIIllIlllIII) {
        super(lllllllllllIIIIlIlIllIIllIlllIII.blockMaterial);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockWall.UP, false).withProperty((IProperty<Comparable>)BlockWall.NORTH, false).withProperty((IProperty<Comparable>)BlockWall.EAST, false).withProperty((IProperty<Comparable>)BlockWall.SOUTH, false).withProperty((IProperty<Comparable>)BlockWall.WEST, false).withProperty(BlockWall.VARIANT, EnumType.NORMAL));
        this.setHardness(lllllllllllIIIIlIlIllIIllIlllIII.blockHardness);
        this.setResistance(lllllllllllIIIIlIlIllIIllIlllIII.blockResistance / 3.0f);
        this.setSoundType(lllllllllllIIIIlIlIllIIllIlllIII.blockSoundType);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ int meta;
        private final /* synthetic */ String unlocalizedName;
        
        MOSSY("MOSSY", 1, 1, "mossy_cobblestone", "mossy");
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ String name;
        
        NORMAL("NORMAL", 0, 0, "cobblestone", "normal");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final char llllllllllllIIIIIlIllIIIllIIllIl;
            final short llllllllllllIIIIIlIllIIIllIIlllI = (short)((EnumType[])(Object)(llllllllllllIIIIIlIllIIIllIIllIl = (char)(Object)values())).length;
            for (Exception llllllllllllIIIIIlIllIIIllIIllll = (Exception)0; llllllllllllIIIIIlIllIIIllIIllll < llllllllllllIIIIIlIllIIIllIIlllI; ++llllllllllllIIIIIlIllIIIllIIllll) {
                final EnumType llllllllllllIIIIIlIllIIIllIlIIIl = llllllllllllIIIIIlIllIIIllIIllIl[llllllllllllIIIIIlIllIIIllIIllll];
                EnumType.META_LOOKUP[llllllllllllIIIIIlIllIIIllIlIIIl.getMetadata()] = llllllllllllIIIIIlIllIIIllIlIIIl;
            }
        }
        
        private EnumType(final String llllllllllllIIIIIlIllIIIllIIIIIl, final int llllllllllllIIIIIlIllIIIllIIIIII, final int llllllllllllIIIIIlIllIIIlIllllll, final String llllllllllllIIIIIlIllIIIlIlllllI, final String llllllllllllIIIIIlIllIIIlIllllIl) {
            this.meta = llllllllllllIIIIIlIllIIIlIllllll;
            this.name = llllllllllllIIIIIlIllIIIlIlllllI;
            this.unlocalizedName = llllllllllllIIIIIlIllIIIlIllllIl;
        }
        
        public static EnumType byMetadata(int llllllllllllIIIIIlIllIIIlIllIlII) {
            if (llllllllllllIIIIIlIllIIIlIllIlII < 0 || llllllllllllIIIIIlIllIIIlIllIlII >= EnumType.META_LOOKUP.length) {
                llllllllllllIIIIIlIllIIIlIllIlII = 0;
            }
            return EnumType.META_LOOKUP[llllllllllllIIIIIlIllIIIlIllIlII];
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
