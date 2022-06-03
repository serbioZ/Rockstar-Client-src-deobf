// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.material;

public class MaterialTransparent extends Material
{
    @Override
    public boolean isSolid() {
        return false;
    }
    
    @Override
    public boolean blocksMovement() {
        return false;
    }
    
    @Override
    public boolean blocksLight() {
        return false;
    }
    
    public MaterialTransparent(final MapColor lllllllllllIlIIIllIlllllIlIIlllI) {
        super(lllllllllllIlIIIllIlllllIlIIlllI);
        this.setReplaceable();
    }
}
