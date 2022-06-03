// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockNetherWart extends BlockBush
{
    private static final /* synthetic */ AxisAlignedBB[] NETHER_WART_AABB;
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlllIIIllIIlIlIlIllIl) {
        return lllllllllllIlllIIIllIIlIlIlIllIl.getValue((IProperty<Integer>)BlockNetherWart.AGE);
    }
    
    protected BlockNetherWart() {
        super(Material.PLANTS, MapColor.RED);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockNetherWart.AGE, 0));
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }
    
    @Override
    public boolean canBlockStay(final World lllllllllllIlllIIIllIIlIlllIlIll, final BlockPos lllllllllllIlllIIIllIIlIlllIIllI, final IBlockState lllllllllllIlllIIIllIIlIlllIlIIl) {
        return this.canSustainBush(lllllllllllIlllIIIllIIlIlllIlIll.getBlockState(lllllllllllIlllIIIllIIlIlllIIllI.down()));
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 3);
        NETHER_WART_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.6875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0) };
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState lllllllllllIlllIIIllIIlIllllIIII) {
        return lllllllllllIlllIIIllIIlIllllIIII.getBlock() == Blocks.SOUL_SAND;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIlllIIIllIIlIlIlllIII, final BlockPos lllllllllllIlllIIIllIIlIlIllIlll, final IBlockState lllllllllllIlllIIIllIIlIlIllIllI) {
        return new ItemStack(Items.NETHER_WART);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIlllIIIllIIlIlIlllllI, final Random lllllllllllIlllIIIllIIlIlIllllIl, final int lllllllllllIlllIIIllIIlIlIllllII) {
        return Items.field_190931_a;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockNetherWart.AGE });
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIlllIIIllIIlIlIlllIlI) {
        return 0;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllIlllIIIllIIlIllIIllII, final BlockPos lllllllllllIlllIIIllIIlIllIIlIll, final IBlockState lllllllllllIlllIIIllIIlIllIIlIlI, final float lllllllllllIlllIIIllIIlIllIIlIIl, final int lllllllllllIlllIIIllIIlIllIIlIII) {
        if (!lllllllllllIlllIIIllIIlIllIIllII.isRemote) {
            int lllllllllllIlllIIIllIIlIllIIIlll = 1;
            if (lllllllllllIlllIIIllIIlIllIIlIlI.getValue((IProperty<Integer>)BlockNetherWart.AGE) >= 3) {
                lllllllllllIlllIIIllIIlIllIIIlll = 2 + lllllllllllIlllIIIllIIlIllIIllII.rand.nextInt(3);
                if (lllllllllllIlllIIIllIIlIllIIlIII > 0) {
                    lllllllllllIlllIIIllIIlIllIIIlll += lllllllllllIlllIIIllIIlIllIIllII.rand.nextInt(lllllllllllIlllIIIllIIlIllIIlIII + 1);
                }
            }
            for (int lllllllllllIlllIIIllIIlIllIIIllI = 0; lllllllllllIlllIIIllIIlIllIIIllI < lllllllllllIlllIIIllIIlIllIIIlll; ++lllllllllllIlllIIIllIIlIllIIIllI) {
                Block.spawnAsEntity(lllllllllllIlllIIIllIIlIllIIllII, lllllllllllIlllIIIllIIlIllIIlIll, new ItemStack(Items.NETHER_WART));
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlllIIIllIIlIlIllIIII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockNetherWart.AGE, lllllllllllIlllIIIllIIlIlIllIIII);
    }
    
    @Override
    public void updateTick(final World lllllllllllIlllIIIllIIlIllIllllI, final BlockPos lllllllllllIlllIIIllIIlIllIlllIl, IBlockState lllllllllllIlllIIIllIIlIllIlIllI, final Random lllllllllllIlllIIIllIIlIllIlIlIl) {
        final int lllllllllllIlllIIIllIIlIllIllIlI = lllllllllllIlllIIIllIIlIllIlIllI.getValue((IProperty<Integer>)BlockNetherWart.AGE);
        if (lllllllllllIlllIIIllIIlIllIllIlI < 3 && lllllllllllIlllIIIllIIlIllIlIlIl.nextInt(10) == 0) {
            lllllllllllIlllIIIllIIlIllIlIllI = lllllllllllIlllIIIllIIlIllIlIllI.withProperty((IProperty<Comparable>)BlockNetherWart.AGE, lllllllllllIlllIIIllIIlIllIllIlI + 1);
            lllllllllllIlllIIIllIIlIllIllllI.setBlockState(lllllllllllIlllIIIllIIlIllIlllIl, lllllllllllIlllIIIllIIlIllIlIllI, 2);
        }
        super.updateTick(lllllllllllIlllIIIllIIlIllIllllI, lllllllllllIlllIIIllIIlIllIlllIl, lllllllllllIlllIIIllIIlIllIlIllI, lllllllllllIlllIIIllIIlIllIlIlIl);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlllIIIllIIlIllllIlII, final IBlockAccess lllllllllllIlllIIIllIIlIllllIllI, final BlockPos lllllllllllIlllIIIllIIlIllllIlIl) {
        return BlockNetherWart.NETHER_WART_AABB[lllllllllllIlllIIIllIIlIllllIlII.getValue((IProperty<Integer>)BlockNetherWart.AGE)];
    }
}
