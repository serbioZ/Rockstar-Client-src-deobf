// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityComparator extends TileEntity
{
    private /* synthetic */ int outputSignal;
    
    public int getOutputSignal() {
        return this.outputSignal;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIlllIIIIlllIlIIlIlIIl) {
        super.writeToNBT(lllllllllllIlllIIIIlllIlIIlIlIIl);
        lllllllllllIlllIIIIlllIlIIlIlIIl.setInteger("OutputSignal", this.outputSignal);
        return lllllllllllIlllIIIIlllIlIIlIlIIl;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIlllIIIIlllIlIIlIIIll) {
        super.readFromNBT(lllllllllllIlllIIIIlllIlIIlIIIll);
        this.outputSignal = lllllllllllIlllIIIIlllIlIIlIIIll.getInteger("OutputSignal");
    }
    
    public void setOutputSignal(final int lllllllllllIlllIIIIlllIlIIIllIlI) {
        this.outputSignal = lllllllllllIlllIIIIlllIlIIIllIlI;
    }
}
