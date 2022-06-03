// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.dispenser;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class BehaviorDefaultDispenseItem implements IBehaviorDispenseItem
{
    private int getWorldEventDataFrom(final EnumFacing lllllllllllllIllIllIIllIlIllIIlI) {
        return lllllllllllllIllIllIIllIlIllIIlI.getFrontOffsetX() + 1 + (lllllllllllllIllIllIIllIlIllIIlI.getFrontOffsetZ() + 1) * 3;
    }
    
    protected ItemStack dispenseStack(final IBlockSource lllllllllllllIllIllIIllIlllIIlIl, final ItemStack lllllllllllllIllIllIIllIlllIlIIl) {
        final EnumFacing lllllllllllllIllIllIIllIlllIlIII = lllllllllllllIllIllIIllIlllIIlIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
        final IPosition lllllllllllllIllIllIIllIlllIIlll = BlockDispenser.getDispensePosition(lllllllllllllIllIllIIllIlllIIlIl);
        final ItemStack lllllllllllllIllIllIIllIlllIIllI = lllllllllllllIllIllIIllIlllIlIIl.splitStack(1);
        doDispense(lllllllllllllIllIllIIllIlllIIlIl.getWorld(), lllllllllllllIllIllIIllIlllIIllI, 6, lllllllllllllIllIllIIllIlllIlIII, lllllllllllllIllIllIIllIlllIIlll);
        return lllllllllllllIllIllIIllIlllIlIIl;
    }
    
    protected void spawnDispenseParticles(final IBlockSource lllllllllllllIllIllIIllIlIllIlll, final EnumFacing lllllllllllllIllIllIIllIlIllIllI) {
        lllllllllllllIllIllIIllIlIllIlll.getWorld().playEvent(2000, lllllllllllllIllIllIIllIlIllIlll.getBlockPos(), this.getWorldEventDataFrom(lllllllllllllIllIllIIllIlIllIllI));
    }
    
    @Override
    public final ItemStack dispense(final IBlockSource lllllllllllllIllIllIIllIllllIIll, final ItemStack lllllllllllllIllIllIIllIllllIIlI) {
        final ItemStack lllllllllllllIllIllIIllIllllIlIl = this.dispenseStack(lllllllllllllIllIllIIllIllllIIll, lllllllllllllIllIllIIllIllllIIlI);
        this.playDispenseSound(lllllllllllllIllIllIIllIllllIIll);
        this.spawnDispenseParticles(lllllllllllllIllIllIIllIllllIIll, lllllllllllllIllIllIIllIllllIIll.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
        return lllllllllllllIllIllIIllIllllIlIl;
    }
    
    public static void doDispense(final World lllllllllllllIllIllIIllIllIlIllI, final ItemStack lllllllllllllIllIllIIllIllIlIlIl, final int lllllllllllllIllIllIIllIllIlIlII, final EnumFacing lllllllllllllIllIllIIllIllIlIIll, final IPosition lllllllllllllIllIllIIllIllIIlIII) {
        final double lllllllllllllIllIllIIllIllIlIIIl = lllllllllllllIllIllIIllIllIIlIII.getX();
        double lllllllllllllIllIllIIllIllIlIIII = lllllllllllllIllIllIIllIllIIlIII.getY();
        final double lllllllllllllIllIllIIllIllIIllll = lllllllllllllIllIllIIllIllIIlIII.getZ();
        if (lllllllllllllIllIllIIllIllIlIIll.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllllIllIllIIllIllIlIIII -= 0.125;
        }
        else {
            lllllllllllllIllIllIIllIllIlIIII -= 0.15625;
        }
        final EntityItem lllllllllllllIllIllIIllIllIIlllI = new EntityItem(lllllllllllllIllIllIIllIllIlIllI, lllllllllllllIllIllIIllIllIlIIIl, lllllllllllllIllIllIIllIllIlIIII, lllllllllllllIllIllIIllIllIIllll, lllllllllllllIllIllIIllIllIlIlIl);
        final double lllllllllllllIllIllIIllIllIIllIl = lllllllllllllIllIllIIllIllIlIllI.rand.nextDouble() * 0.1 + 0.2;
        lllllllllllllIllIllIIllIllIIlllI.motionX = lllllllllllllIllIllIIllIllIlIIll.getFrontOffsetX() * lllllllllllllIllIllIIllIllIIllIl;
        lllllllllllllIllIllIIllIllIIlllI.motionY = 0.20000000298023224;
        lllllllllllllIllIllIIllIllIIlllI.motionZ = lllllllllllllIllIllIIllIllIlIIll.getFrontOffsetZ() * lllllllllllllIllIllIIllIllIIllIl;
        final EntityItem entityItem = lllllllllllllIllIllIIllIllIIlllI;
        entityItem.motionX += lllllllllllllIllIllIIllIllIlIllI.rand.nextGaussian() * 0.007499999832361937 * lllllllllllllIllIllIIllIllIlIlII;
        final EntityItem entityItem2 = lllllllllllllIllIllIIllIllIIlllI;
        entityItem2.motionY += lllllllllllllIllIllIIllIllIlIllI.rand.nextGaussian() * 0.007499999832361937 * lllllllllllllIllIllIIllIllIlIlII;
        final EntityItem entityItem3 = lllllllllllllIllIllIIllIllIIlllI;
        entityItem3.motionZ += lllllllllllllIllIllIIllIllIlIllI.rand.nextGaussian() * 0.007499999832361937 * lllllllllllllIllIllIIllIllIlIlII;
        lllllllllllllIllIllIIllIllIlIllI.spawnEntityInWorld(lllllllllllllIllIllIIllIllIIlllI);
    }
    
    protected void playDispenseSound(final IBlockSource lllllllllllllIllIllIIllIllIIIIII) {
        lllllllllllllIllIllIIllIllIIIIII.getWorld().playEvent(1000, lllllllllllllIllIllIIllIllIIIIII.getBlockPos(), 0);
    }
}
