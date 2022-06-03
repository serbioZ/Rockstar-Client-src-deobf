// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.dispenser;

import net.minecraft.entity.Entity;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class BehaviorProjectileDispense extends BehaviorDefaultDispenseItem
{
    protected abstract IProjectile getProjectileEntity(final World p0, final IPosition p1, final ItemStack p2);
    
    @Override
    protected void playDispenseSound(final IBlockSource lllllllllllllIIlIIIlIlIIIIlIlIll) {
        lllllllllllllIIlIIIlIlIIIIlIlIll.getWorld().playEvent(1002, lllllllllllllIIlIIIlIlIIIIlIlIll.getBlockPos(), 0);
    }
    
    protected float getProjectileVelocity() {
        return 1.1f;
    }
    
    public ItemStack dispenseStack(final IBlockSource lllllllllllllIIlIIIlIlIIIIllIIll, final ItemStack lllllllllllllIIlIIIlIlIIIIlllIIl) {
        final World lllllllllllllIIlIIIlIlIIIIlllIII = lllllllllllllIIlIIIlIlIIIIllIIll.getWorld();
        final IPosition lllllllllllllIIlIIIlIlIIIIllIlll = BlockDispenser.getDispensePosition(lllllllllllllIIlIIIlIlIIIIllIIll);
        final EnumFacing lllllllllllllIIlIIIlIlIIIIllIllI = lllllllllllllIIlIIIlIlIIIIllIIll.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
        final IProjectile lllllllllllllIIlIIIlIlIIIIllIlIl = this.getProjectileEntity(lllllllllllllIIlIIIlIlIIIIlllIII, lllllllllllllIIlIIIlIlIIIIllIlll, lllllllllllllIIlIIIlIlIIIIlllIIl);
        lllllllllllllIIlIIIlIlIIIIllIlIl.setThrowableHeading(lllllllllllllIIlIIIlIlIIIIllIllI.getFrontOffsetX(), lllllllllllllIIlIIIlIlIIIIllIllI.getFrontOffsetY() + 0.1f, lllllllllllllIIlIIIlIlIIIIllIllI.getFrontOffsetZ(), this.getProjectileVelocity(), this.getProjectileInaccuracy());
        lllllllllllllIIlIIIlIlIIIIlllIII.spawnEntityInWorld((Entity)lllllllllllllIIlIIIlIlIIIIllIlIl);
        lllllllllllllIIlIIIlIlIIIIlllIIl.func_190918_g(1);
        return lllllllllllllIIlIIIlIlIIIIlllIIl;
    }
    
    protected float getProjectileInaccuracy() {
        return 6.0f;
    }
}
