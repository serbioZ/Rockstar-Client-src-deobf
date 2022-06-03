// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.world.IInteractionObject;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockEnchantmentTable extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB AABB;
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIllIllIlIllIlIlIIlIll, final IBlockState lllllllllllIllIllIlIllIlIlIIlIlI, final BlockPos lllllllllllIllIllIlIllIlIlIIlIIl, final EnumFacing lllllllllllIllIllIlIllIlIlIIIlll) {
        return (lllllllllllIllIllIlIllIlIlIIIlll == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIllIllIlIllIllIIIIlII, final World lllllllllllIllIllIlIllIllIIIIIll, final BlockPos lllllllllllIllIllIlIllIllIIIlIll, final Random lllllllllllIllIllIlIllIllIIIIIIl) {
        super.randomDisplayTick(lllllllllllIllIllIlIllIllIIIIlII, lllllllllllIllIllIlIllIllIIIIIll, lllllllllllIllIllIlIllIllIIIlIll, lllllllllllIllIllIlIllIllIIIIIIl);
        for (int lllllllllllIllIllIlIllIllIIIlIIl = -2; lllllllllllIllIllIlIllIllIIIlIIl <= 2; ++lllllllllllIllIllIlIllIllIIIlIIl) {
            for (int lllllllllllIllIllIlIllIllIIIlIII = -2; lllllllllllIllIllIlIllIllIIIlIII <= 2; ++lllllllllllIllIllIlIllIllIIIlIII) {
                if (lllllllllllIllIllIlIllIllIIIlIIl > -2 && lllllllllllIllIllIlIllIllIIIlIIl < 2 && lllllllllllIllIllIlIllIllIIIlIII == -1) {
                    lllllllllllIllIllIlIllIllIIIlIII = 2;
                }
                if (lllllllllllIllIllIlIllIllIIIIIIl.nextInt(16) == 0) {
                    for (int lllllllllllIllIllIlIllIllIIIIlll = 0; lllllllllllIllIllIlIllIllIIIIlll <= 1; ++lllllllllllIllIllIlIllIllIIIIlll) {
                        final BlockPos lllllllllllIllIllIlIllIllIIIIllI = lllllllllllIllIllIlIllIllIIIlIll.add(lllllllllllIllIllIlIllIllIIIlIIl, lllllllllllIllIllIlIllIllIIIIlll, lllllllllllIllIllIlIllIllIIIlIII);
                        if (lllllllllllIllIllIlIllIllIIIIIll.getBlockState(lllllllllllIllIllIlIllIllIIIIllI).getBlock() == Blocks.BOOKSHELF) {
                            if (!lllllllllllIllIllIlIllIllIIIIIll.isAirBlock(lllllllllllIllIllIlIllIllIIIlIll.add(lllllllllllIllIllIlIllIllIIIlIIl / 2, 0, lllllllllllIllIllIlIllIllIIIlIII / 2))) {
                                break;
                            }
                            lllllllllllIllIllIlIllIllIIIIIll.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, lllllllllllIllIllIlIllIllIIIlIll.getX() + 0.5, lllllllllllIllIllIlIllIllIIIlIll.getY() + 2.0, lllllllllllIllIllIlIllIllIIIlIll.getZ() + 0.5, lllllllllllIllIllIlIllIllIIIlIIl + lllllllllllIllIllIlIllIllIIIIIIl.nextFloat() - 0.5, lllllllllllIllIllIlIllIllIIIIlll - lllllllllllIllIllIlIllIllIIIIIIl.nextFloat() - 1.0f, lllllllllllIllIllIlIllIllIIIlIII + lllllllllllIllIllIlIllIllIIIIIIl.nextFloat() - 0.5, new int[0]);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllIllIllIlIllIlIlIlIIll, final BlockPos lllllllllllIllIllIlIllIlIlIllIIl, final IBlockState lllllllllllIllIllIlIllIlIlIllIII, final EntityLivingBase lllllllllllIllIllIlIllIlIlIlIIII, final ItemStack lllllllllllIllIllIlIllIlIlIlIllI) {
        super.onBlockPlacedBy(lllllllllllIllIllIlIllIlIlIlIIll, lllllllllllIllIllIlIllIlIlIllIIl, lllllllllllIllIllIlIllIlIlIllIII, lllllllllllIllIllIlIllIlIlIlIIII, lllllllllllIllIllIlIllIlIlIlIllI);
        if (lllllllllllIllIllIlIllIlIlIlIllI.hasDisplayName()) {
            final TileEntity lllllllllllIllIllIlIllIlIlIlIlIl = lllllllllllIllIllIlIllIlIlIlIIll.getTileEntity(lllllllllllIllIllIlIllIlIlIllIIl);
            if (lllllllllllIllIllIlIllIlIlIlIlIl instanceof TileEntityEnchantmentTable) {
                ((TileEntityEnchantmentTable)lllllllllllIllIllIlIllIlIlIlIlIl).setCustomName(lllllllllllIllIllIlIllIlIlIlIllI.getDisplayName());
            }
        }
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIllIllIlIllIlIlllIIII, final BlockPos lllllllllllIllIllIlIllIlIllIIlIl, final IBlockState lllllllllllIllIllIlIllIlIllIlllI, final EntityPlayer lllllllllllIllIllIlIllIlIllIllIl, final EnumHand lllllllllllIllIllIlIllIlIllIllII, final EnumFacing lllllllllllIllIllIlIllIlIllIlIll, final float lllllllllllIllIllIlIllIlIllIlIlI, final float lllllllllllIllIllIlIllIlIllIlIIl, final float lllllllllllIllIllIlIllIlIllIlIII) {
        if (lllllllllllIllIllIlIllIlIlllIIII.isRemote) {
            return true;
        }
        final TileEntity lllllllllllIllIllIlIllIlIllIIlll = lllllllllllIllIllIlIllIlIlllIIII.getTileEntity(lllllllllllIllIllIlIllIlIllIIlIl);
        if (lllllllllllIllIllIlIllIlIllIIlll instanceof TileEntityEnchantmentTable) {
            lllllllllllIllIllIlIllIlIllIllIl.displayGui((IInteractionObject)lllllllllllIllIllIlIllIlIllIIlll);
        }
        return true;
    }
    
    protected BlockEnchantmentTable() {
        super(Material.ROCK, MapColor.RED);
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIllIllIlIllIlIllllIll) {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIllIllIlIllIlIlllIlll, final int lllllllllllIllIllIlIllIlIlllIllI) {
        return new TileEntityEnchantmentTable();
    }
    
    static {
        AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIllIllIlIllIllIIllIII) {
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIllIllIlIllIlIllllIIl) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIllIllIlIllIllIIlllII, final IBlockAccess lllllllllllIllIllIlIllIllIIllIll, final BlockPos lllllllllllIllIllIlIllIllIIllIlI) {
        return BlockEnchantmentTable.AABB;
    }
}
