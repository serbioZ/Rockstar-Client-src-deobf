// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import net.minecraft.util.EnumFacing;
import org.lwjgl.util.vector.Vector3f;

public class BlockPartRotation
{
    public final /* synthetic */ boolean rescale;
    public final /* synthetic */ float angle;
    public final /* synthetic */ Vector3f origin;
    public final /* synthetic */ EnumFacing.Axis axis;
    
    public BlockPartRotation(final Vector3f lllllllllllIlllIIIlIIllllIIIllII, final EnumFacing.Axis lllllllllllIlllIIIlIIllllIIIlIll, final float lllllllllllIlllIIIlIIllllIIIIlIl, final boolean lllllllllllIlllIIIlIIllllIIIIlII) {
        this.origin = lllllllllllIlllIIIlIIllllIIIllII;
        this.axis = lllllllllllIlllIIIlIIllllIIIlIll;
        this.angle = lllllllllllIlllIIIlIIllllIIIIlIl;
        this.rescale = lllllllllllIlllIIIlIIllllIIIIlII;
    }
}
