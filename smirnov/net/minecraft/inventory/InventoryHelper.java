// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import java.util.Random;

public class InventoryHelper
{
    private static final /* synthetic */ Random RANDOM;
    
    public static void spawnItemStack(final World llllllllllllIIIIlllIllllIIIlIlll, final double llllllllllllIIIIlllIllllIIIlIllI, final double llllllllllllIIIIlllIllllIIIlIlIl, final double llllllllllllIIIIlllIllllIIIIlIlI, final ItemStack llllllllllllIIIIlllIllllIIIlIIll) {
        final float llllllllllllIIIIlllIllllIIIlIIlI = InventoryHelper.RANDOM.nextFloat() * 0.8f + 0.1f;
        final float llllllllllllIIIIlllIllllIIIlIIIl = InventoryHelper.RANDOM.nextFloat() * 0.8f + 0.1f;
        final float llllllllllllIIIIlllIllllIIIlIIII = InventoryHelper.RANDOM.nextFloat() * 0.8f + 0.1f;
        while (!llllllllllllIIIIlllIllllIIIlIIll.func_190926_b()) {
            final EntityItem llllllllllllIIIIlllIllllIIIIllll = new EntityItem(llllllllllllIIIIlllIllllIIIlIlll, llllllllllllIIIIlllIllllIIIlIllI + llllllllllllIIIIlllIllllIIIlIIlI, llllllllllllIIIIlllIllllIIIlIlIl + llllllllllllIIIIlllIllllIIIlIIIl, llllllllllllIIIIlllIllllIIIIlIlI + llllllllllllIIIIlllIllllIIIlIIII, llllllllllllIIIIlllIllllIIIlIIll.splitStack(InventoryHelper.RANDOM.nextInt(21) + 10));
            final float llllllllllllIIIIlllIllllIIIIlllI = 0.05f;
            llllllllllllIIIIlllIllllIIIIllll.motionX = InventoryHelper.RANDOM.nextGaussian() * 0.05000000074505806;
            llllllllllllIIIIlllIllllIIIIllll.motionY = InventoryHelper.RANDOM.nextGaussian() * 0.05000000074505806 + 0.20000000298023224;
            llllllllllllIIIIlllIllllIIIIllll.motionZ = InventoryHelper.RANDOM.nextGaussian() * 0.05000000074505806;
            llllllllllllIIIIlllIllllIIIlIlll.spawnEntityInWorld(llllllllllllIIIIlllIllllIIIIllll);
        }
    }
    
    private static void dropInventoryItems(final World llllllllllllIIIIlllIllllIIlIllll, final double llllllllllllIIIIlllIllllIIlIIlll, final double llllllllllllIIIIlllIllllIIlIllIl, final double llllllllllllIIIIlllIllllIIlIIlIl, final IInventory llllllllllllIIIIlllIllllIIlIIlII) {
        for (int llllllllllllIIIIlllIllllIIlIlIlI = 0; llllllllllllIIIIlllIllllIIlIlIlI < llllllllllllIIIIlllIllllIIlIIlII.getSizeInventory(); ++llllllllllllIIIIlllIllllIIlIlIlI) {
            final ItemStack llllllllllllIIIIlllIllllIIlIlIIl = llllllllllllIIIIlllIllllIIlIIlII.getStackInSlot(llllllllllllIIIIlllIllllIIlIlIlI);
            if (!llllllllllllIIIIlllIllllIIlIlIIl.func_190926_b()) {
                spawnItemStack(llllllllllllIIIIlllIllllIIlIllll, llllllllllllIIIIlllIllllIIlIIlll, llllllllllllIIIIlllIllllIIlIllIl, llllllllllllIIIIlllIllllIIlIIlIl, llllllllllllIIIIlllIllllIIlIlIIl);
            }
        }
    }
    
    static {
        RANDOM = new Random();
    }
    
    public static void dropInventoryItems(final World llllllllllllIIIIlllIllllIIllllII, final Entity llllllllllllIIIIlllIllllIIlllIll, final IInventory llllllllllllIIIIlllIllllIIllIlll) {
        dropInventoryItems(llllllllllllIIIIlllIllllIIllllII, llllllllllllIIIIlllIllllIIlllIll.posX, llllllllllllIIIIlllIllllIIlllIll.posY, llllllllllllIIIIlllIllllIIlllIll.posZ, llllllllllllIIIIlllIllllIIllIlll);
    }
    
    public static void dropInventoryItems(final World llllllllllllIIIIlllIllllIlIIIIlI, final BlockPos llllllllllllIIIIlllIllllIlIIIIIl, final IInventory llllllllllllIIIIlllIllllIlIIIIII) {
        dropInventoryItems(llllllllllllIIIIlllIllllIlIIIIlI, llllllllllllIIIIlllIllllIlIIIIIl.getX(), llllllllllllIIIIlllIllllIlIIIIIl.getY(), llllllllllllIIIIlllIllllIlIIIIIl.getZ(), llllllllllllIIIIlllIllllIlIIIIII);
    }
}
