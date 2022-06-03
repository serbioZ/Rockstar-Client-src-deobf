// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.client.renderer.texture.Stitcher;

public class StitcherException extends RuntimeException
{
    private final /* synthetic */ Stitcher.Holder holder;
    
    public StitcherException(final Stitcher.Holder lllllllllllIIIlIIlIIIIllIIlIlIII, final String lllllllllllIIIlIIlIIIIllIIlIIlII) {
        super(lllllllllllIIIlIIlIIIIllIIlIIlII);
        this.holder = lllllllllllIIIlIIlIIIIllIIlIlIII;
    }
}
