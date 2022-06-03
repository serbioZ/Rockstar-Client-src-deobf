// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.math.MathHelper;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.util.ResourceLocation;

public class TileEntityEndGatewayRenderer extends TileEntityEndPortalRenderer
{
    private static final /* synthetic */ ResourceLocation END_GATEWAY_BEAM_TEXTURE;
    
    @Override
    protected int func_191286_a(final double lllllllllllIllllIlIIlIllIIIllllI) {
        return super.func_191286_a(lllllllllllIllllIlIIlIllIIIllllI) + 1;
    }
    
    @Override
    public void func_192841_a(final TileEntityEndPortal lllllllllllIllllIlIIlIllIIlIllIl, final double lllllllllllIllllIlIIlIllIIlllIIl, final double lllllllllllIllllIlIIlIllIIlIlIll, final double lllllllllllIllllIlIIlIllIIllIlll, final float lllllllllllIllllIlIIlIllIIllIllI, final int lllllllllllIllllIlIIlIllIIllIlIl, final float lllllllllllIllllIlIIlIllIIllIlII) {
        GlStateManager.disableFog();
        final TileEntityEndGateway lllllllllllIllllIlIIlIllIIllIIll = (TileEntityEndGateway)lllllllllllIllllIlIIlIllIIlIllIl;
        if (lllllllllllIllllIlIIlIllIIllIIll.isSpawning() || lllllllllllIllllIlIIlIllIIllIIll.isCoolingDown()) {
            GlStateManager.alphaFunc(516, 0.1f);
            this.bindTexture(TileEntityEndGatewayRenderer.END_GATEWAY_BEAM_TEXTURE);
            float lllllllllllIllllIlIIlIllIIllIIlI = lllllllllllIllllIlIIlIllIIllIIll.isSpawning() ? lllllllllllIllllIlIIlIllIIllIIll.getSpawnPercent(lllllllllllIllllIlIIlIllIIllIllI) : lllllllllllIllllIlIIlIllIIllIIll.getCooldownPercent(lllllllllllIllllIlIIlIllIIllIllI);
            final double lllllllllllIllllIlIIlIllIIllIIIl = lllllllllllIllllIlIIlIllIIllIIll.isSpawning() ? (256.0 - lllllllllllIllllIlIIlIllIIlIlIll) : 50.0;
            lllllllllllIllllIlIIlIllIIllIIlI = MathHelper.sin(lllllllllllIllllIlIIlIllIIllIIlI * 3.1415927f);
            final int lllllllllllIllllIlIIlIllIIllIIII = MathHelper.floor(lllllllllllIllllIlIIlIllIIllIIlI * lllllllllllIllllIlIIlIllIIllIIIl);
            final float[] lllllllllllIllllIlIIlIllIIlIllll = lllllllllllIllllIlIIlIllIIllIIll.isSpawning() ? EnumDyeColor.MAGENTA.func_193349_f() : EnumDyeColor.PURPLE.func_193349_f();
            TileEntityBeaconRenderer.renderBeamSegment(lllllllllllIllllIlIIlIllIIlllIIl, lllllllllllIllllIlIIlIllIIlIlIll, lllllllllllIllllIlIIlIllIIllIlll, lllllllllllIllllIlIIlIllIIllIllI, lllllllllllIllllIlIIlIllIIllIIlI, (double)lllllllllllIllllIlIIlIllIIllIIll.getWorld().getTotalWorldTime(), 0, lllllllllllIllllIlIIlIllIIllIIII, lllllllllllIllllIlIIlIllIIlIllll, 0.15, 0.175);
            TileEntityBeaconRenderer.renderBeamSegment(lllllllllllIllllIlIIlIllIIlllIIl, lllllllllllIllllIlIIlIllIIlIlIll, lllllllllllIllllIlIIlIllIIllIlll, lllllllllllIllllIlIIlIllIIllIllI, lllllllllllIllllIlIIlIllIIllIIlI, (double)lllllllllllIllllIlIIlIllIIllIIll.getWorld().getTotalWorldTime(), 0, -lllllllllllIllllIlIIlIllIIllIIII, lllllllllllIllllIlIIlIllIIlIllll, 0.15, 0.175);
        }
        super.func_192841_a(lllllllllllIllllIlIIlIllIIlIllIl, lllllllllllIllllIlIIlIllIIlllIIl, lllllllllllIllllIlIIlIllIIlIlIll, lllllllllllIllllIlIIlIllIIllIlll, lllllllllllIllllIlIIlIllIIllIllI, lllllllllllIllllIlIIlIllIIllIlIl, lllllllllllIllllIlIIlIllIIllIlII);
        GlStateManager.enableFog();
    }
    
    @Override
    protected float func_191287_c() {
        return 1.0f;
    }
    
    static {
        END_GATEWAY_BEAM_TEXTURE = new ResourceLocation("textures/entity/end_gateway_beam.png");
    }
}
