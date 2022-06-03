// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.LockCode;
import net.minecraft.world.ILockableContainer;

public abstract class TileEntityLockable extends TileEntity implements ILockableContainer
{
    private /* synthetic */ LockCode code;
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIIIIIlIIlIlIIIlllIlll) {
        super.writeToNBT(lllllllllllIIIIIlIIlIlIIIlllIlll);
        if (this.code != null) {
            this.code.toNBT(lllllllllllIIIIIlIIlIlIIIlllIlll);
        }
        return lllllllllllIIIIIlIIlIlIIIlllIlll;
    }
    
    @Override
    public LockCode getLockCode() {
        return this.code;
    }
    
    @Override
    public boolean isLocked() {
        return this.code != null && !this.code.isEmpty();
    }
    
    public TileEntityLockable() {
        this.code = LockCode.EMPTY_CODE;
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIIIIIlIIlIlIIIlllllll) {
        super.readFromNBT(lllllllllllIIIIIlIIlIlIIIlllllll);
        this.code = LockCode.fromNBT(lllllllllllIIIIIlIIlIlIIIlllllll);
    }
    
    @Override
    public void setLockCode(final LockCode lllllllllllIIIIIlIIlIlIIIllIlIll) {
        this.code = lllllllllllIIIIIlIIlIlIIIllIlIll;
    }
}
