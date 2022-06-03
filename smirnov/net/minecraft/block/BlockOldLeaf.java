// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import net.minecraft.block.properties.PropertyEnum;

public class BlockOldLeaf extends BlockLeaves
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    
    @Override
    public BlockPlanks.EnumType getWoodType(final int llIIlIllIIlIlII) {
        return BlockPlanks.EnumType.byMetadata((llIIlIllIIlIlII & 0x3) % 4);
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (com.google.common.base.Predicate<BlockPlanks.EnumType>)new Predicate<BlockPlanks.EnumType>() {
            public boolean apply(@Nullable final BlockPlanks.EnumType llllllllllllllIlllIIllIIlIlIlIII) {
                return llllllllllllllIlllIIllIIlIlIlIII.getMetadata() < 4;
            }
        });
    }
    
    public BlockOldLeaf() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockOldLeaf.CHECK_DECAY, true).withProperty((IProperty<Comparable>)BlockOldLeaf.DECAYABLE, true));
    }
    
    @Override
    protected void dropApple(final World llIIlIllIlllIlI, final BlockPos llIIlIllIlllIIl, final IBlockState llIIlIllIlllIII, final int llIIlIllIllIlll) {
        if (llIIlIllIlllIII.getValue(BlockOldLeaf.VARIANT) == BlockPlanks.EnumType.OAK && llIIlIllIlllIlI.rand.nextInt(llIIlIllIllIlll) == 0) {
            Block.spawnAsEntity(llIIlIllIlllIlI, llIIlIllIlllIIl, new ItemStack(Items.APPLE));
        }
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llIIlIllIlIllIl, final NonNullList<ItemStack> llIIlIllIlIlIlI) {
        llIIlIllIlIlIlI.add(new ItemStack(this, 1, BlockPlanks.EnumType.OAK.getMetadata()));
        llIIlIllIlIlIlI.add(new ItemStack(this, 1, BlockPlanks.EnumType.SPRUCE.getMetadata()));
        llIIlIllIlIlIlI.add(new ItemStack(this, 1, BlockPlanks.EnumType.BIRCH.getMetadata()));
        llIIlIllIlIlIlI.add(new ItemStack(this, 1, BlockPlanks.EnumType.JUNGLE.getMetadata()));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llIIlIllIIllIlI) {
        int llIIlIllIIllIIl = 0;
        llIIlIllIIllIIl |= llIIlIllIIllIlI.getValue(BlockOldLeaf.VARIANT).getMetadata();
        if (!llIIlIllIIllIlI.getValue((IProperty<Boolean>)BlockOldLeaf.DECAYABLE)) {
            llIIlIllIIllIIl |= 0x4;
        }
        if (llIIlIllIIllIlI.getValue((IProperty<Boolean>)BlockOldLeaf.CHECK_DECAY)) {
            llIIlIllIIllIIl |= 0x8;
        }
        return llIIlIllIIllIIl;
    }
    
    @Override
    public int damageDropped(final IBlockState llIIlIllIIIllII) {
        return llIIlIllIIIllII.getValue(BlockOldLeaf.VARIANT).getMetadata();
    }
    
    @Override
    public void harvestBlock(final World llIIlIlIlllllII, final EntityPlayer llIIlIlIllllIll, final BlockPos llIIlIllIIIIIIl, final IBlockState llIIlIllIIIIIII, @Nullable final TileEntity llIIlIlIlllllll, final ItemStack llIIlIlIllllllI) {
        if (!llIIlIlIlllllII.isRemote && llIIlIlIllllllI.getItem() == Items.SHEARS) {
            llIIlIlIllllIll.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(llIIlIlIlllllII, llIIlIllIIIIIIl, new ItemStack(Item.getItemFromBlock(this), 1, llIIlIllIIIIIII.getValue(BlockOldLeaf.VARIANT).getMetadata()));
        }
        else {
            super.harvestBlock(llIIlIlIlllllII, llIIlIlIllllIll, llIIlIllIIIIIIl, llIIlIllIIIIIII, llIIlIlIlllllll, llIIlIlIllllllI);
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockOldLeaf.VARIANT, BlockOldLeaf.CHECK_DECAY, BlockOldLeaf.DECAYABLE });
    }
    
    @Override
    protected int getSaplingDropChance(final IBlockState llIIlIllIllIIll) {
        return (llIIlIllIllIIll.getValue(BlockOldLeaf.VARIANT) == BlockPlanks.EnumType.JUNGLE) ? 40 : super.getSaplingDropChance(llIIlIllIllIIll);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llIIlIllIlIIIII) {
        return this.getDefaultState().withProperty(BlockOldLeaf.VARIANT, this.getWoodType(llIIlIllIlIIIII)).withProperty((IProperty<Comparable>)BlockOldLeaf.DECAYABLE, (llIIlIllIlIIIII & 0x4) == 0x0).withProperty((IProperty<Comparable>)BlockOldLeaf.CHECK_DECAY, (llIIlIllIlIIIII & 0x8) > 0);
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llIIlIllIlIIlII) {
        return new ItemStack(Item.getItemFromBlock(this), 1, llIIlIllIlIIlII.getValue(BlockOldLeaf.VARIANT).getMetadata());
    }
}
