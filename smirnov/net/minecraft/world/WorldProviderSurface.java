// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

public class WorldProviderSurface extends WorldProvider
{
    @Override
    public boolean canDropChunk(final int llllllllllllIllIIIlIlIIIllIIIIll, final int llllllllllllIllIIIlIlIIIlIllllll) {
        return !this.worldObj.isSpawnChunk(llllllllllllIllIIIlIlIIIllIIIIll, llllllllllllIllIIIlIlIIIlIllllll);
    }
    
    @Override
    public DimensionType getDimensionType() {
        return DimensionType.OVERWORLD;
    }
}
