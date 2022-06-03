// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.Material;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.state.BlockStateContainer;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Blocks;
import net.minecraft.stats.StatList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyEnum;

public class BlockTallGrass extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyEnum<EnumType> TYPE;
    protected static final /* synthetic */ AxisAlignedBB TALL_GRASS_AABB;
    
    @Override
    public void harvestBlock(final World llllllllllllIlIIlIlIlIIIIlIIIIlI, final EntityPlayer llllllllllllIlIIlIlIlIIIIlIIIIIl, final BlockPos llllllllllllIlIIlIlIlIIIIlIIIlll, final IBlockState llllllllllllIlIIlIlIlIIIIlIIIllI, @Nullable final TileEntity llllllllllllIlIIlIlIlIIIIIlllllI, final ItemStack llllllllllllIlIIlIlIlIIIIIllllIl) {
        if (!llllllllllllIlIIlIlIlIIIIlIIIIlI.isRemote && llllllllllllIlIIlIlIlIIIIIllllIl.getItem() == Items.SHEARS) {
            llllllllllllIlIIlIlIlIIIIlIIIIIl.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(llllllllllllIlIIlIlIlIIIIlIIIIlI, llllllllllllIlIIlIlIlIIIIlIIIlll, new ItemStack(Blocks.TALLGRASS, 1, llllllllllllIlIIlIlIlIIIIlIIIllI.getValue(BlockTallGrass.TYPE).getMeta()));
        }
        else {
            super.harvestBlock(llllllllllllIlIIlIlIlIIIIlIIIIlI, llllllllllllIlIIlIlIlIIIIlIIIIIl, llllllllllllIlIIlIlIlIIIIlIIIlll, llllllllllllIlIIlIlIlIIIIlIIIllI, llllllllllllIlIIlIlIlIIIIIlllllI, llllllllllllIlIIlIlIlIIIIIllllIl);
        }
    }
    
    @Override
    public int quantityDroppedWithBonus(final int llllllllllllIlIIlIlIlIIIIlIlIlIl, final Random llllllllllllIlIIlIlIlIIIIlIlIIlI) {
        return 1 + llllllllllllIlIIlIlIlIIIIlIlIIlI.nextInt(llllllllllllIlIIlIlIlIIIIlIlIlIl * 2 + 1);
    }
    
    static {
        TYPE = PropertyEnum.create("type", EnumType.class);
        TALL_GRASS_AABB = new AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTallGrass.TYPE });
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllIlIIlIlIlIIIIIllIIII, final NonNullList<ItemStack> llllllllllllIlIIlIlIlIIIIIlIllll) {
        for (int llllllllllllIlIIlIlIlIIIIIlIlllI = 1; llllllllllllIlIIlIlIlIIIIIlIlllI < 3; ++llllllllllllIlIIlIlIlIIIIIlIlllI) {
            llllllllllllIlIIlIlIlIIIIIlIllll.add(new ItemStack(this, 1, llllllllllllIlIIlIlIlIIIIIlIlllI));
        }
    }
    
    protected BlockTallGrass() {
        super(Material.VINE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockTallGrass.TYPE, EnumType.DEAD_BUSH));
    }
    
    @Override
    public void grow(final World llllllllllllIlIIlIlIlIIIIIIlIlII, final Random llllllllllllIlIIlIlIlIIIIIIllIII, final BlockPos llllllllllllIlIIlIlIlIIIIIIlIlll, final IBlockState llllllllllllIlIIlIlIlIIIIIIlIllI) {
        BlockDoublePlant.EnumPlantType llllllllllllIlIIlIlIlIIIIIIlIlIl = BlockDoublePlant.EnumPlantType.GRASS;
        if (llllllllllllIlIIlIlIlIIIIIIlIllI.getValue(BlockTallGrass.TYPE) == EnumType.FERN) {
            llllllllllllIlIIlIlIlIIIIIIlIlIl = BlockDoublePlant.EnumPlantType.FERN;
        }
        if (Blocks.DOUBLE_PLANT.canPlaceBlockAt(llllllllllllIlIIlIlIlIIIIIIlIlII, llllllllllllIlIIlIlIlIIIIIIlIlll)) {
            Blocks.DOUBLE_PLANT.placeAt(llllllllllllIlIIlIlIlIIIIIIlIlII, llllllllllllIlIIlIlIlIIIIIIlIlll, llllllllllllIlIIlIlIlIIIIIIlIlIl, 2);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIIlIlIlIIIIIIIIlll) {
        return llllllllllllIlIIlIlIlIIIIIIIIlll.getValue(BlockTallGrass.TYPE).getMeta();
    }
    
    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XYZ;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIlIIlIlIlIIIIllIlllI, final IBlockAccess llllllllllllIlIIlIlIlIIIIllIllIl, final BlockPos llllllllllllIlIIlIlIlIIIIllIllII) {
        return BlockTallGrass.TALL_GRASS_AABB;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIIlIlIlIIIIIIIllIl) {
        return this.getDefaultState().withProperty(BlockTallGrass.TYPE, EnumType.byMetadata(llllllllllllIlIIlIlIlIIIIIIIllIl));
    }
    
    @Override
    public boolean canGrow(final World llllllllllllIlIIlIlIlIIIIIlIlIII, final BlockPos llllllllllllIlIIlIlIlIIIIIlIIlll, final IBlockState llllllllllllIlIIlIlIlIIIIIlIIllI, final boolean llllllllllllIlIIlIlIlIIIIIlIIlIl) {
        return llllllllllllIlIIlIlIlIIIIIlIIllI.getValue(BlockTallGrass.TYPE) != EnumType.DEAD_BUSH;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIlIIlIlIlIIIIIlllIIl, final BlockPos llllllllllllIlIIlIlIlIIIIIlllIII, final IBlockState llllllllllllIlIIlIlIlIIIIIllIlll) {
        return new ItemStack(this, 1, llllllllllllIlIIlIlIlIIIIIllIlll.getBlock().getMetaFromState(llllllllllllIlIIlIlIlIIIIIllIlll));
    }
    
    @Override
    public boolean canBlockStay(final World llllllllllllIlIIlIlIlIIIIllIIIll, final BlockPos llllllllllllIlIIlIlIlIIIIllIIllI, final IBlockState llllllllllllIlIIlIlIlIIIIllIIlIl) {
        return this.canSustainBush(llllllllllllIlIIlIlIlIIIIllIIIll.getBlockState(llllllllllllIlIIlIlIlIIIIllIIllI.down()));
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIlIIlIlIlIIIIlIlllII, final Random llllllllllllIlIIlIlIlIIIIlIllIll, final int llllllllllllIlIIlIlIlIIIIlIllIlI) {
        return (llllllllllllIlIIlIlIlIIIIlIllIll.nextInt(8) == 0) ? Items.WHEAT_SEEDS : Items.field_190931_a;
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess llllllllllllIlIIlIlIlIIIIllIIIII, final BlockPos llllllllllllIlIIlIlIlIIIIlIlllll) {
        return true;
    }
    
    @Override
    public boolean canUseBonemeal(final World llllllllllllIlIIlIlIlIIIIIlIIIlI, final Random llllllllllllIlIIlIlIlIIIIIlIIIIl, final BlockPos llllllllllllIlIIlIlIlIIIIIlIIIII, final IBlockState llllllllllllIlIIlIlIlIIIIIIlllll) {
        return true;
    }
    
    public enum EnumType implements IStringSerializable
    {
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ int meta;
        
        GRASS("GRASS", 1, 1, "tall_grass"), 
        FERN("FERN", 2, 2, "fern"), 
        DEAD_BUSH("DEAD_BUSH", 0, 0, "dead_bush");
        
        private final /* synthetic */ String name;
        
        public int getMeta() {
            return this.meta;
        }
        
        public static EnumType byMetadata(int lllllllllllIIlIIllllIIllIllIIllI) {
            if (lllllllllllIIlIIllllIIllIllIIllI < 0 || lllllllllllIIlIIllllIIllIllIIllI >= EnumType.META_LOOKUP.length) {
                lllllllllllIIlIIllllIIllIllIIllI = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllIIlIIllllIIllIllIIllI];
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final byte lllllllllllIIlIIllllIIllIlllllII;
            final char lllllllllllIIlIIllllIIllIlllllIl = (char)((EnumType[])(Object)(lllllllllllIIlIIllllIIllIlllllII = (byte)(Object)values())).length;
            for (long lllllllllllIIlIIllllIIllIllllllI = 0; lllllllllllIIlIIllllIIllIllllllI < lllllllllllIIlIIllllIIllIlllllIl; ++lllllllllllIIlIIllllIIllIllllllI) {
                final EnumType lllllllllllIIlIIllllIIlllIIIIIII = lllllllllllIIlIIllllIIllIlllllII[lllllllllllIIlIIllllIIllIllllllI];
                EnumType.META_LOOKUP[lllllllllllIIlIIllllIIlllIIIIIII.getMeta()] = lllllllllllIIlIIllllIIlllIIIIIII;
            }
        }
        
        private EnumType(final String lllllllllllIIlIIllllIIllIlllIIlI, final int lllllllllllIIlIIllllIIllIlllIIIl, final int lllllllllllIIlIIllllIIllIlllIlIl, final String lllllllllllIIlIIllllIIllIllIllll) {
            this.meta = lllllllllllIIlIIllllIIllIlllIlIl;
            this.name = lllllllllllIIlIIllllIIllIllIllll;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
