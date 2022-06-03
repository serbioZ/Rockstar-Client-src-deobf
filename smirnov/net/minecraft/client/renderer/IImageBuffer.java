// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import java.awt.image.BufferedImage;

public interface IImageBuffer
{
    void skinAvailable();
    
    BufferedImage parseUserSkin(final BufferedImage p0);
}
