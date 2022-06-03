// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.model;

import net.minecraft.util.math.Vec3d;

public class PositionTextureVertex
{
    public /* synthetic */ float texturePositionX;
    public /* synthetic */ float texturePositionY;
    public /* synthetic */ Vec3d vector3D;
    
    public PositionTextureVertex setTexturePosition(final float llllllllllllllIllllIIlIlIlllllIl, final float llllllllllllllIllllIIlIlIlllllll) {
        return new PositionTextureVertex(this, llllllllllllllIllllIIlIlIlllllIl, llllllllllllllIllllIIlIlIlllllll);
    }
    
    public PositionTextureVertex(final float llllllllllllllIllllIIlIllIIIlIIl, final float llllllllllllllIllllIIlIllIIIlllI, final float llllllllllllllIllllIIlIllIIIIlll, final float llllllllllllllIllllIIlIllIIIIllI, final float llllllllllllllIllllIIlIllIIIIlIl) {
        this(new Vec3d(llllllllllllllIllllIIlIllIIIlIIl, llllllllllllllIllllIIlIllIIIlllI, llllllllllllllIllllIIlIllIIIIlll), llllllllllllllIllllIIlIllIIIIllI, llllllllllllllIllllIIlIllIIIIlIl);
    }
    
    public PositionTextureVertex(final PositionTextureVertex llllllllllllllIllllIIlIlIlllIllI, final float llllllllllllllIllllIIlIlIlllIlIl, final float llllllllllllllIllllIIlIlIlllIIII) {
        this.vector3D = llllllllllllllIllllIIlIlIlllIllI.vector3D;
        this.texturePositionX = llllllllllllllIllllIIlIlIlllIlIl;
        this.texturePositionY = llllllllllllllIllllIIlIlIlllIIII;
    }
    
    public PositionTextureVertex(final Vec3d llllllllllllllIllllIIlIlIllIIllI, final float llllllllllllllIllllIIlIlIllIIlIl, final float llllllllllllllIllllIIlIlIllIlIII) {
        this.vector3D = llllllllllllllIllllIIlIlIllIIllI;
        this.texturePositionX = llllllllllllllIllllIIlIlIllIIlIl;
        this.texturePositionY = llllllllllllllIllllIIlIlIllIlIII;
    }
}
