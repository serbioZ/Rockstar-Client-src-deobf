// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

public class ModelPig extends ModelQuadruped
{
    public ModelPig() {
        this(0.0f);
    }
    
    public ModelPig(final float lllllllllllllllllIlIIIlllIIlllIl) {
        super(6, lllllllllllllllllIlIIIlllIIlllIl);
        this.head.setTextureOffset(16, 16).addBox(-2.0f, 0.0f, -9.0f, 4, 3, 1, lllllllllllllllllIlIIIlllIIlllIl);
        this.childYOffset = 4.0f;
    }
}
