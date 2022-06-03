// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.renderer.Tessellator;

public class Tezzelator
{
    public static /* synthetic */ Tessellator t;
    
    public void tex2(final short lllllllllllIlIllllIIllllIlllIIlI, final short lllllllllllIlIllllIIllllIllIllll) {
        Tezzelator.t.getBuffer().lightmap(lllllllllllIlIllllIIllllIlllIIlI, lllllllllllIlIllllIIllllIllIllll);
    }
    
    public Tezzelator vertex(final double lllllllllllIlIllllIIlllllIIIlIIl, final double lllllllllllIlIllllIIlllllIIIlIII, final double lllllllllllIlIllllIIlllllIIIIIll) {
        Tezzelator.t.getBuffer().pos(lllllllllllIlIllllIIlllllIIIlIIl, lllllllllllIlIllllIIlllllIIIlIII, lllllllllllIlIllllIIlllllIIIIIll);
        return this;
    }
    
    public RealmsBufferBuilder color(final int lllllllllllIlIllllIIllllIlIIllIl, final int lllllllllllIlIllllIIllllIlIIllII, final int lllllllllllIlIllllIIllllIlIIlIll, final int lllllllllllIlIllllIIllllIlIIlIlI) {
        return new RealmsBufferBuilder(Tezzelator.t.getBuffer().color(lllllllllllIlIllllIIllllIlIIllIl, lllllllllllIlIllllIIllllIlIIllII, lllllllllllIlIllllIIllllIlIIlIll, lllllllllllIlIllllIIllllIlIIlIlI));
    }
    
    public void color(final float lllllllllllIlIllllIIllllIlllllIl, final float lllllllllllIlIllllIIllllIlllllII, final float lllllllllllIlIllllIIllllIlllIlll, final float lllllllllllIlIllllIIllllIllllIlI) {
        Tezzelator.t.getBuffer().color(lllllllllllIlIllllIIllllIlllllIl, lllllllllllIlIllllIIllllIlllllII, lllllllllllIlIllllIIllllIlllIlll, lllllllllllIlIllllIIllllIllllIlI);
    }
    
    public void normal(final float lllllllllllIlIllllIIllllIllIlIlI, final float lllllllllllIlIllllIIllllIllIlIIl, final float lllllllllllIlIllllIIllllIllIlIII) {
        Tezzelator.t.getBuffer().normal(lllllllllllIlIllllIIllllIllIlIlI, lllllllllllIlIllllIIllllIllIlIIl, lllllllllllIlIllllIIllllIllIlIII);
    }
    
    public void begin(final int lllllllllllIlIllllIIllllIlIlllll, final RealmsVertexFormat lllllllllllIlIllllIIllllIlIllllI) {
        Tezzelator.t.getBuffer().begin(lllllllllllIlIllllIIllllIlIlllll, lllllllllllIlIllllIIllllIlIllllI.getVertexFormat());
    }
    
    public Tezzelator tex(final double lllllllllllIlIllllIIllllIlIIIIIl, final double lllllllllllIlIllllIIllllIIllllIl) {
        Tezzelator.t.getBuffer().tex(lllllllllllIlIllllIIllllIlIIIIIl, lllllllllllIlIllllIIllllIIllllIl);
        return this;
    }
    
    static {
        Tezzelator.t = Tessellator.getInstance();
        instance = new Tezzelator();
    }
    
    public void offset(final double lllllllllllIlIllllIIllllIlIlIlIl, final double lllllllllllIlIllllIIllllIlIlIlII, final double lllllllllllIlIllllIIllllIlIlIllI) {
        Tezzelator.t.getBuffer().setTranslation(lllllllllllIlIllllIIllllIlIlIlIl, lllllllllllIlIllllIIllllIlIlIlII, lllllllllllIlIllllIIllllIlIlIllI);
    }
    
    public void end() {
        Tezzelator.t.draw();
    }
    
    public void endVertex() {
        Tezzelator.t.getBuffer().endVertex();
    }
}
