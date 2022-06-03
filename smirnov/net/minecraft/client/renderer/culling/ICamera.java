// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.culling;

import net.minecraft.util.math.AxisAlignedBB;

public interface ICamera
{
    void setPosition(final double p0, final double p1, final double p2);
    
    boolean isBoundingBoxInFrustum(final AxisAlignedBB p0);
}
