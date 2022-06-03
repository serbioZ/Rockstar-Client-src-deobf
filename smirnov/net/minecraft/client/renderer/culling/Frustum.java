// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.culling;

import net.minecraft.util.math.AxisAlignedBB;

public class Frustum implements ICamera
{
    private final /* synthetic */ ClippingHelper clippingHelper;
    private /* synthetic */ double yPosition;
    private /* synthetic */ double xPosition;
    private /* synthetic */ double zPosition;
    
    @Override
    public void setPosition(final double lllllllllllIlIIllIlIIllIIlIIlIIl, final double lllllllllllIlIIllIlIIllIIlIIIlII, final double lllllllllllIlIIllIlIIllIIlIIIIll) {
        this.xPosition = lllllllllllIlIIllIlIIllIIlIIlIIl;
        this.yPosition = lllllllllllIlIIllIlIIllIIlIIIlII;
        this.zPosition = lllllllllllIlIIllIlIIllIIlIIIIll;
    }
    
    @Override
    public boolean isBoundingBoxInFrustum(final AxisAlignedBB lllllllllllIlIIllIlIIllIIIlIlIlI) {
        return this.isBoxInFrustum(lllllllllllIlIIllIlIIllIIIlIlIlI.minX, lllllllllllIlIIllIlIIllIIIlIlIlI.minY, lllllllllllIlIIllIlIIllIIIlIlIlI.minZ, lllllllllllIlIIllIlIIllIIIlIlIlI.maxX, lllllllllllIlIIllIlIIllIIIlIlIlI.maxY, lllllllllllIlIIllIlIIllIIIlIlIlI.maxZ);
    }
    
    public Frustum() {
        this(ClippingHelperImpl.getInstance());
    }
    
    public boolean isBoxInFrustum(final double lllllllllllIlIIllIlIIllIIIllIIll, final double lllllllllllIlIIllIlIIllIIIllIIlI, final double lllllllllllIlIIllIlIIllIIIlllIII, final double lllllllllllIlIIllIlIIllIIIllIlll, final double lllllllllllIlIIllIlIIllIIIllIllI, final double lllllllllllIlIIllIlIIllIIIlIlllI) {
        return this.clippingHelper.isBoxInFrustum(lllllllllllIlIIllIlIIllIIIllIIll - this.xPosition, lllllllllllIlIIllIlIIllIIIllIIlI - this.yPosition, lllllllllllIlIIllIlIIllIIIlllIII - this.zPosition, lllllllllllIlIIllIlIIllIIIllIlll - this.xPosition, lllllllllllIlIIllIlIIllIIIllIllI - this.yPosition, lllllllllllIlIIllIlIIllIIIlIlllI - this.zPosition);
    }
    
    public Frustum(final ClippingHelper lllllllllllIlIIllIlIIllIIlIIllll) {
        this.clippingHelper = lllllllllllIlIIllIlIIllIIlIIllll;
    }
}
