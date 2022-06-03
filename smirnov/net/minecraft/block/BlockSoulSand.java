// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockSoulSand extends Block
{
    protected static final /* synthetic */ AxisAlignedBB SOUL_SAND_AABB;
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllIlIllIIlIIlllIIIIIIl, final IBlockAccess llllllllllllIlIllIIlIIlllIIIIIII, final BlockPos llllllllllllIlIllIIlIIllIlllllll) {
        return BlockSoulSand.SOUL_SAND_AABB;
    }
    
    public BlockSoulSand() {
        super(Material.SAND, MapColor.BROWN);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    static {
        SOUL_SAND_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllIlIllIIlIIllIlllllII, final BlockPos llllllllllllIlIllIIlIIllIllllIll, final IBlockState llllllllllllIlIllIIlIIllIllllIlI, final Entity llllllllllllIlIllIIlIIllIllllIIl) {
        llllllllllllIlIllIIlIIllIllllIIl.motionX *= 0.4;
        llllllllllllIlIllIIlIIllIllllIIl.motionZ *= 0.4;
    }
}
