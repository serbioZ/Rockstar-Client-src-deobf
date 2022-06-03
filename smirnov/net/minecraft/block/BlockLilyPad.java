// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.util.math.Vec3i;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.Entity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockLilyPad extends BlockBush
{
    protected static final /* synthetic */ AxisAlignedBB LILY_PAD_AABB;
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIIlIllIIIllIlIIIIIlI, final IBlockAccess lllllllllllIIIlIllIIIllIlIIIIIIl, final BlockPos lllllllllllIIIlIllIIIllIlIIIIIII) {
        return BlockLilyPad.LILY_PAD_AABB;
    }
    
    static {
        LILY_PAD_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.09375, 0.9375);
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState lllllllllllIIIlIllIIIllIIlllllIl) {
        return lllllllllllIIIlIllIIIllIIlllllIl.getBlock() == Blocks.WATER || lllllllllllIIIlIllIIIllIIlllllIl.getMaterial() == Material.ICE;
    }
    
    @Override
    public boolean canBlockStay(final World lllllllllllIIIlIllIIIllIIlllIIIl, final BlockPos lllllllllllIIIlIllIIIllIIlllIlIl, final IBlockState lllllllllllIIIlIllIIIllIIlllIlII) {
        if (lllllllllllIIIlIllIIIllIIlllIlIl.getY() >= 0 && lllllllllllIIIlIllIIIllIIlllIlIl.getY() < 256) {
            final IBlockState lllllllllllIIIlIllIIIllIIlllIIll = lllllllllllIIIlIllIIIllIIlllIIIl.getBlockState(lllllllllllIIIlIllIIIllIIlllIlIl.down());
            final Material lllllllllllIIIlIllIIIllIIlllIIlI = lllllllllllIIIlIllIIIllIIlllIIll.getMaterial();
            return (lllllllllllIIIlIllIIIllIIlllIIlI == Material.WATER && lllllllllllIIIlIllIIIllIIlllIIll.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0) || lllllllllllIIIlIllIIIllIIlllIIlI == Material.ICE;
        }
        return false;
    }
    
    protected BlockLilyPad() {
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllIIIlIllIIIllIlIIIIlll, final BlockPos lllllllllllIIIlIllIIIllIlIIIIllI, final IBlockState lllllllllllIIIlIllIIIllIlIIIlIlI, final Entity lllllllllllIIIlIllIIIllIlIIIlIIl) {
        super.onEntityCollidedWithBlock(lllllllllllIIIlIllIIIllIlIIIIlll, lllllllllllIIIlIllIIIllIlIIIIllI, lllllllllllIIIlIllIIIllIlIIIlIlI, lllllllllllIIIlIllIIIllIlIIIlIIl);
        if (lllllllllllIIIlIllIIIllIlIIIlIIl instanceof EntityBoat) {
            lllllllllllIIIlIllIIIllIlIIIIlll.destroyBlock(new BlockPos(lllllllllllIIIlIllIIIllIlIIIIllI), true);
        }
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllIIIlIllIIIllIlIIlllIl, final World lllllllllllIIIlIllIIIllIlIIlllII, final BlockPos lllllllllllIIIlIllIIIllIlIIlIllI, final AxisAlignedBB lllllllllllIIIlIllIIIllIlIIlIlIl, final List<AxisAlignedBB> lllllllllllIIIlIllIIIllIlIIlIlII, @Nullable final Entity lllllllllllIIIlIllIIIllIlIIllIII, final boolean lllllllllllIIIlIllIIIllIlIIlIlll) {
        if (!(lllllllllllIIIlIllIIIllIlIIllIII instanceof EntityBoat)) {
            Block.addCollisionBoxToList(lllllllllllIIIlIllIIIllIlIIlIllI, lllllllllllIIIlIllIIIllIlIIlIlIl, lllllllllllIIIlIllIIIllIlIIlIlII, BlockLilyPad.LILY_PAD_AABB);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIlIllIIIllIIllIllII) {
        return 0;
    }
}
