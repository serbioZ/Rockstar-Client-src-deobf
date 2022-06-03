// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.material;

public class MaterialLogic extends Material
{
    public MaterialLogic(final MapColor llllllllllllIIIIIlIlIllIlIIlllll) {
        super(llllllllllllIIIIIlIlIllIlIIlllll);
        this.setAdventureModeExempt();
    }
    
    @Override
    public boolean blocksMovement() {
        return false;
    }
    
    @Override
    public boolean blocksLight() {
        return false;
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
}
