// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.material;

public class MaterialLiquid extends Material
{
    @Override
    public boolean blocksMovement() {
        return false;
    }
    
    @Override
    public boolean isLiquid() {
        return true;
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
    
    public MaterialLiquid(final MapColor lllllllllllllllIIlIllllllIIIllIl) {
        super(lllllllllllllllIIlIllllllIIIllIl);
        this.setReplaceable();
        this.setNoPushMobility();
    }
}
