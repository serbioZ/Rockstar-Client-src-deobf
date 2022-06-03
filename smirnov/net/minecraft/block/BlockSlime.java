// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockSlime extends BlockBreakable
{
    @Override
    public void onLanded(final World lllllllllllllIlIllIlIlllIIlIlIll, final Entity lllllllllllllIlIllIlIlllIIlIlIlI) {
        if (lllllllllllllIlIllIlIlllIIlIlIlI.isSneaking()) {
            super.onLanded(lllllllllllllIlIllIlIlllIIlIlIll, lllllllllllllIlIllIlIlllIIlIlIlI);
        }
        else if (lllllllllllllIlIllIlIlllIIlIlIlI.motionY < 0.0) {
            lllllllllllllIlIllIlIlllIIlIlIlI.motionY = -lllllllllllllIlIllIlIlllIIlIlIlI.motionY;
            if (!(lllllllllllllIlIllIlIlllIIlIlIlI instanceof EntityLivingBase)) {
                lllllllllllllIlIllIlIlllIIlIlIlI.motionY *= 0.8;
            }
        }
    }
    
    @Override
    public void onEntityWalk(final World lllllllllllllIlIllIlIlllIIIllIll, final BlockPos lllllllllllllIlIllIlIlllIIIllIlI, final Entity lllllllllllllIlIllIlIlllIIIllllI) {
        if (Math.abs(lllllllllllllIlIllIlIlllIIIllllI.motionY) < 0.1 && !lllllllllllllIlIllIlIlllIIIllllI.isSneaking()) {
            final double lllllllllllllIlIllIlIlllIIIlllIl = 0.4 + Math.abs(lllllllllllllIlIllIlIlllIIIllllI.motionY) * 0.2;
            lllllllllllllIlIllIlIlllIIIllllI.motionX *= lllllllllllllIlIllIlIlllIIIlllIl;
            lllllllllllllIlIllIlIlllIIIllllI.motionZ *= lllllllllllllIlIllIlIlllIIIlllIl;
        }
        super.onEntityWalk(lllllllllllllIlIllIlIlllIIIllIll, lllllllllllllIlIllIlIlllIIIllIlI, lllllllllllllIlIllIlIlllIIIllllI);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public void onFallenUpon(final World lllllllllllllIlIllIlIlllIIllIIll, final BlockPos lllllllllllllIlIllIlIlllIIllIIlI, final Entity lllllllllllllIlIllIlIlllIIllIllI, final float lllllllllllllIlIllIlIlllIIllIIII) {
        if (lllllllllllllIlIllIlIlllIIllIllI.isSneaking()) {
            super.onFallenUpon(lllllllllllllIlIllIlIlllIIllIIll, lllllllllllllIlIllIlIlllIIllIIlI, lllllllllllllIlIllIlIlllIIllIllI, lllllllllllllIlIllIlIlllIIllIIII);
        }
        else {
            lllllllllllllIlIllIlIlllIIllIllI.fall(lllllllllllllIlIllIlIlllIIllIIII, 0.0f);
        }
    }
    
    public BlockSlime() {
        super(Material.CLAY, false, MapColor.GRASS);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.slipperiness = 0.8f;
    }
}
