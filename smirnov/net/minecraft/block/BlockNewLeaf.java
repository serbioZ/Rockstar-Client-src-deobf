// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import com.google.common.base.Predicate;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyEnum;

public class BlockNewLeaf extends BlockLeaves
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    
    @Override
    protected void dropApple(final World llllllllllllIlIlIIIlIIIIlIllIllI, final BlockPos llllllllllllIlIlIIIlIIIIlIllIlIl, final IBlockState llllllllllllIlIlIIIlIIIIlIllIlII, final int llllllllllllIlIlIIIlIIIIlIllIlll) {
        if (llllllllllllIlIlIIIlIIIIlIllIlII.getValue(BlockNewLeaf.VARIANT) == BlockPlanks.EnumType.DARK_OAK && llllllllllllIlIlIIIlIIIIlIllIllI.rand.nextInt(llllllllllllIlIlIIIlIIIIlIllIlll) == 0) {
            Block.spawnAsEntity(llllllllllllIlIlIIIlIIIIlIllIllI, llllllllllllIlIlIIIlIIIIlIllIlIl, new ItemStack(Items.APPLE));
        }
    }
    
    @Override
    public void harvestBlock(final World llllllllllllIlIlIIIlIIIIIlllllIl, final EntityPlayer llllllllllllIlIlIIIlIIIIIlllIlIl, final BlockPos llllllllllllIlIlIIIlIIIIIllllIll, final IBlockState llllllllllllIlIlIIIlIIIIIllllIlI, @Nullable final TileEntity llllllllllllIlIlIIIlIIIIIllllIIl, final ItemStack llllllllllllIlIlIIIlIIIIIllllIII) {
        if (!llllllllllllIlIlIIIlIIIIIlllllIl.isRemote && llllllllllllIlIlIIIlIIIIIllllIII.getItem() == Items.SHEARS) {
            llllllllllllIlIlIIIlIIIIIlllIlIl.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(llllllllllllIlIlIIIlIIIIIlllllIl, llllllllllllIlIlIIIlIIIIIllllIll, new ItemStack(Item.getItemFromBlock(this), 1, llllllllllllIlIlIIIlIIIIIllllIlI.getValue(BlockNewLeaf.VARIANT).getMetadata() - 4));
        }
        else {
            super.harvestBlock(llllllllllllIlIlIIIlIIIIIlllllIl, llllllllllllIlIlIIIlIIIIIlllIlIl, llllllllllllIlIlIIIlIIIIIllllIll, llllllllllllIlIlIIIlIIIIIllllIlI, llllllllllllIlIlIIIlIIIIIllllIIl, llllllllllllIlIlIIIlIIIIIllllIII);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIlIIIlIIIIlIIlIlII) {
        return this.getDefaultState().withProperty(BlockNewLeaf.VARIANT, this.getWoodType(llllllllllllIlIlIIIlIIIIlIIlIlII)).withProperty((IProperty<Comparable>)BlockNewLeaf.DECAYABLE, (llllllllllllIlIlIIIlIIIIlIIlIlII & 0x4) == 0x0).withProperty((IProperty<Comparable>)BlockNewLeaf.CHECK_DECAY, (llllllllllllIlIlIIIlIIIIlIIlIlII & 0x8) > 0);
    }
    
    @Override
    public BlockPlanks.EnumType getWoodType(final int llllllllllllIlIlIIIlIIIIlIIIlIlI) {
        return BlockPlanks.EnumType.byMetadata((llllllllllllIlIlIIIlIIIIlIIIlIlI & 0x3) + 4);
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllIlIlIIIlIIIIlIllIIII) {
        return llllllllllllIlIlIIIlIIIIlIllIIII.getValue(BlockNewLeaf.VARIANT).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockNewLeaf.VARIANT, BlockNewLeaf.CHECK_DECAY, BlockNewLeaf.DECAYABLE });
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llllllllllllIlIlIIIlIIIIlIIllIlI) {
        return new ItemStack(Item.getItemFromBlock(this), 1, llllllllllllIlIlIIIlIIIIlIIllIlI.getValue(BlockNewLeaf.VARIANT).getMetadata() - 4);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIlIIIlIIIIlIIlIIII) {
        int llllllllllllIlIlIIIlIIIIlIIIllll = 0;
        llllllllllllIlIlIIIlIIIIlIIIllll |= llllllllllllIlIlIIIlIIIIlIIlIIII.getValue(BlockNewLeaf.VARIANT).getMetadata() - 4;
        if (!llllllllllllIlIlIIIlIIIIlIIlIIII.getValue((IProperty<Boolean>)BlockNewLeaf.DECAYABLE)) {
            llllllllllllIlIlIIIlIIIIlIIIllll |= 0x4;
        }
        if (llllllllllllIlIlIIIlIIIIlIIlIIII.getValue((IProperty<Boolean>)BlockNewLeaf.CHECK_DECAY)) {
            llllllllllllIlIlIIIlIIIIlIIIllll |= 0x8;
        }
        return llllllllllllIlIlIIIlIIIIlIIIllll;
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (com.google.common.base.Predicate<BlockPlanks.EnumType>)new Predicate<BlockPlanks.EnumType>() {
            public boolean apply(@Nullable final BlockPlanks.EnumType llllllllllllIIIIIlIlIIIlIIIIllII) {
                return llllllllllllIIIIIlIlIIIlIIIIllII.getMetadata() >= 4;
            }
        });
    }
    
    public BlockNewLeaf() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty((IProperty<Comparable>)BlockNewLeaf.CHECK_DECAY, true).withProperty((IProperty<Comparable>)BlockNewLeaf.DECAYABLE, true));
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIlIlIIIlIIIIlIlIlIll, final BlockPos llllllllllllIlIlIIIlIIIIlIlIlIlI, final IBlockState llllllllllllIlIlIIIlIIIIlIlIIlll) {
        return new ItemStack(this, 1, llllllllllllIlIlIIIlIIIIlIlIIlll.getBlock().getMetaFromState(llllllllllllIlIlIIIlIIIIlIlIIlll) & 0x3);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllIlIlIIIlIIIIlIlIIIll, final NonNullList<ItemStack> llllllllllllIlIlIIIlIIIIlIlIIIII) {
        llllllllllllIlIlIIIlIIIIlIlIIIII.add(new ItemStack(this, 1, 0));
        llllllllllllIlIlIIIlIIIIlIlIIIII.add(new ItemStack(this, 1, 1));
    }
}
