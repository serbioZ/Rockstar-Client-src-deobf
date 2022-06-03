// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.dispenser.IBehaviorDispenseItem;

public class BlockDropper extends BlockDispenser
{
    private final /* synthetic */ IBehaviorDispenseItem dropBehavior;
    
    @Override
    protected void dispense(final World llllllllllllIIlllIllIlIlIllllIlI, final BlockPos llllllllllllIIlllIllIlIlIllllIIl) {
        final BlockSourceImpl llllllllllllIIlllIllIlIllIIIIlII = new BlockSourceImpl(llllllllllllIIlllIllIlIlIllllIlI, llllllllllllIIlllIllIlIlIllllIIl);
        final TileEntityDispenser llllllllllllIIlllIllIlIllIIIIIll = llllllllllllIIlllIllIlIllIIIIlII.getBlockTileEntity();
        if (llllllllllllIIlllIllIlIllIIIIIll != null) {
            final int llllllllllllIIlllIllIlIllIIIIIlI = llllllllllllIIlllIllIlIllIIIIIll.getDispenseSlot();
            if (llllllllllllIIlllIllIlIllIIIIIlI < 0) {
                llllllllllllIIlllIllIlIlIllllIlI.playEvent(1001, llllllllllllIIlllIllIlIlIllllIIl, 0);
            }
            else {
                final ItemStack llllllllllllIIlllIllIlIllIIIIIIl = llllllllllllIIlllIllIlIllIIIIIll.getStackInSlot(llllllllllllIIlllIllIlIllIIIIIlI);
                if (!llllllllllllIIlllIllIlIllIIIIIIl.func_190926_b()) {
                    final EnumFacing llllllllllllIIlllIllIlIllIIIIIII = llllllllllllIIlllIllIlIlIllllIlI.getBlockState(llllllllllllIIlllIllIlIlIllllIIl).getValue((IProperty<EnumFacing>)BlockDropper.FACING);
                    final BlockPos llllllllllllIIlllIllIlIlIlllllll = llllllllllllIIlllIllIlIlIllllIIl.offset(llllllllllllIIlllIllIlIllIIIIIII);
                    final IInventory llllllllllllIIlllIllIlIlIllllllI = TileEntityHopper.getInventoryAtPosition(llllllllllllIIlllIllIlIlIllllIlI, llllllllllllIIlllIllIlIlIlllllll.getX(), llllllllllllIIlllIllIlIlIlllllll.getY(), llllllllllllIIlllIllIlIlIlllllll.getZ());
                    ItemStack llllllllllllIIlllIllIlIlIlllllII = null;
                    if (llllllllllllIIlllIllIlIlIllllllI == null) {
                        final ItemStack llllllllllllIIlllIllIlIlIlllllIl = this.dropBehavior.dispense(llllllllllllIIlllIllIlIllIIIIlII, llllllllllllIIlllIllIlIllIIIIIIl);
                    }
                    else {
                        llllllllllllIIlllIllIlIlIlllllII = TileEntityHopper.putStackInInventoryAllSlots(llllllllllllIIlllIllIlIllIIIIIll, llllllllllllIIlllIllIlIlIllllllI, llllllllllllIIlllIllIlIllIIIIIIl.copy().splitStack(1), llllllllllllIIlllIllIlIllIIIIIII.getOpposite());
                        if (llllllllllllIIlllIllIlIlIlllllII.func_190926_b()) {
                            llllllllllllIIlllIllIlIlIlllllII = llllllllllllIIlllIllIlIllIIIIIIl.copy();
                            llllllllllllIIlllIllIlIlIlllllII.func_190918_g(1);
                        }
                        else {
                            llllllllllllIIlllIllIlIlIlllllII = llllllllllllIIlllIllIlIllIIIIIIl.copy();
                        }
                    }
                    llllllllllllIIlllIllIlIllIIIIIll.setInventorySlotContents(llllllllllllIIlllIllIlIllIIIIIlI, llllllllllllIIlllIllIlIlIlllllII);
                }
            }
        }
    }
    
    @Override
    protected IBehaviorDispenseItem getBehavior(final ItemStack llllllllllllIIlllIllIlIllIIlIlll) {
        return this.dropBehavior;
    }
    
    public BlockDropper() {
        this.dropBehavior = new BehaviorDefaultDispenseItem();
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllIIlllIllIlIllIIlIlII, final int llllllllllllIIlllIllIlIllIIlIIll) {
        return new TileEntityDropper();
    }
}
