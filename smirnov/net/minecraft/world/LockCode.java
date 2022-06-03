// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.nbt.NBTTagCompound;
import javax.annotation.concurrent.Immutable;

@Immutable
public class LockCode
{
    public static final /* synthetic */ LockCode EMPTY_CODE;
    private final /* synthetic */ String lock;
    
    public boolean isEmpty() {
        return this.lock == null || this.lock.isEmpty();
    }
    
    public void toNBT(final NBTTagCompound lllllllllllIlllIlIIlllIlllllIllI) {
        lllllllllllIlllIlIIlllIlllllIllI.setString("Lock", this.lock);
    }
    
    static {
        EMPTY_CODE = new LockCode("");
    }
    
    public LockCode(final String lllllllllllIlllIlIIllllIIIIIIlII) {
        this.lock = lllllllllllIlllIlIIllllIIIIIIlII;
    }
    
    public static LockCode fromNBT(final NBTTagCompound lllllllllllIlllIlIIlllIlllllIIll) {
        if (lllllllllllIlllIlIIlllIlllllIIll.hasKey("Lock", 8)) {
            final String lllllllllllIlllIlIIlllIlllllIIlI = lllllllllllIlllIlIIlllIlllllIIll.getString("Lock");
            return new LockCode(lllllllllllIlllIlIIlllIlllllIIlI);
        }
        return LockCode.EMPTY_CODE;
    }
    
    public String getLock() {
        return this.lock;
    }
}
