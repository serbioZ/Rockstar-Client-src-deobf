// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBed;
import net.minecraft.tileentity.TileEntityBed;

public class TileEntityBedRenderer extends TileEntitySpecialRenderer<TileEntityBed>
{
    private /* synthetic */ int field_193850_e;
    private /* synthetic */ ModelBed field_193849_d;
    private static final /* synthetic */ ResourceLocation[] field_193848_a;
    
    @Override
    public void func_192841_a(final TileEntityBed llllllllllllIIIIllIlIIIllIIIIIll, final double llllllllllllIIIIllIlIIIlIlllIlIl, final double llllllllllllIIIIllIlIIIllIIIIIIl, final double llllllllllllIIIIllIlIIIllIIIIIII, final float llllllllllllIIIIllIlIIIlIlllllll, final int llllllllllllIIIIllIlIIIlIllllllI, final float llllllllllllIIIIllIlIIIlIlllllIl) {
        if (this.field_193850_e != this.field_193849_d.func_193770_a()) {
            this.field_193849_d = new ModelBed();
            this.field_193850_e = this.field_193849_d.func_193770_a();
        }
        final boolean llllllllllllIIIIllIlIIIlIlllllII = llllllllllllIIIIllIlIIIllIIIIIll.getWorld() != null;
        final boolean llllllllllllIIIIllIlIIIlIllllIll = !llllllllllllIIIIllIlIIIlIlllllII || llllllllllllIIIIllIlIIIllIIIIIll.func_193050_e();
        final EnumDyeColor llllllllllllIIIIllIlIIIlIllllIlI = (llllllllllllIIIIllIlIIIllIIIIIll != null) ? llllllllllllIIIIllIlIIIllIIIIIll.func_193048_a() : EnumDyeColor.RED;
        final int llllllllllllIIIIllIlIIIlIllllIIl = llllllllllllIIIIllIlIIIlIlllllII ? (llllllllllllIIIIllIlIIIllIIIIIll.getBlockMetadata() & 0x3) : 0;
        if (llllllllllllIIIIllIlIIIlIllllllI >= 0) {
            this.bindTexture(TileEntityBedRenderer.DESTROY_STAGES[llllllllllllIIIIllIlIIIlIllllllI]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 4.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            final ResourceLocation llllllllllllIIIIllIlIIIlIllllIII = TileEntityBedRenderer.field_193848_a[llllllllllllIIIIllIlIIIlIllllIlI.getMetadata()];
            if (llllllllllllIIIIllIlIIIlIllllIII != null) {
                this.bindTexture(llllllllllllIIIIllIlIIIlIllllIII);
            }
        }
        if (llllllllllllIIIIllIlIIIlIlllllII) {
            this.func_193847_a(llllllllllllIIIIllIlIIIlIllllIll, llllllllllllIIIIllIlIIIlIlllIlIl, llllllllllllIIIIllIlIIIllIIIIIIl, llllllllllllIIIIllIlIIIllIIIIIII, llllllllllllIIIIllIlIIIlIllllIIl, llllllllllllIIIIllIlIIIlIlllllIl);
        }
        else {
            GlStateManager.pushMatrix();
            this.func_193847_a(true, llllllllllllIIIIllIlIIIlIlllIlIl, llllllllllllIIIIllIlIIIllIIIIIIl, llllllllllllIIIIllIlIIIllIIIIIII, llllllllllllIIIIllIlIIIlIllllIIl, llllllllllllIIIIllIlIIIlIlllllIl);
            this.func_193847_a(false, llllllllllllIIIIllIlIIIlIlllIlIl, llllllllllllIIIIllIlIIIllIIIIIIl, llllllllllllIIIIllIlIIIllIIIIIII - 1.0, llllllllllllIIIIllIlIIIlIllllIIl, llllllllllllIIIIllIlIIIlIlllllIl);
            GlStateManager.popMatrix();
        }
        if (llllllllllllIIIIllIlIIIlIllllllI >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    private void func_193847_a(final boolean llllllllllllIIIIllIlIIIlIllIIIII, final double llllllllllllIIIIllIlIIIlIlIlIlIl, final double llllllllllllIIIIllIlIIIlIlIlIlII, final double llllllllllllIIIIllIlIIIlIlIlIIll, final int llllllllllllIIIIllIlIIIlIlIlllII, final float llllllllllllIIIIllIlIIIlIlIllIll) {
        this.field_193849_d.func_193769_a(llllllllllllIIIIllIlIIIlIllIIIII);
        GlStateManager.pushMatrix();
        float llllllllllllIIIIllIlIIIlIlIllIlI = 0.0f;
        float llllllllllllIIIIllIlIIIlIlIllIIl = 0.0f;
        float llllllllllllIIIIllIlIIIlIlIllIII = 0.0f;
        if (llllllllllllIIIIllIlIIIlIlIlllII == EnumFacing.NORTH.getHorizontalIndex()) {
            llllllllllllIIIIllIlIIIlIlIllIlI = 0.0f;
        }
        else if (llllllllllllIIIIllIlIIIlIlIlllII == EnumFacing.SOUTH.getHorizontalIndex()) {
            llllllllllllIIIIllIlIIIlIlIllIlI = 180.0f;
            llllllllllllIIIIllIlIIIlIlIllIIl = 1.0f;
            llllllllllllIIIIllIlIIIlIlIllIII = 1.0f;
        }
        else if (llllllllllllIIIIllIlIIIlIlIlllII == EnumFacing.WEST.getHorizontalIndex()) {
            llllllllllllIIIIllIlIIIlIlIllIlI = -90.0f;
            llllllllllllIIIIllIlIIIlIlIllIII = 1.0f;
        }
        else if (llllllllllllIIIIllIlIIIlIlIlllII == EnumFacing.EAST.getHorizontalIndex()) {
            llllllllllllIIIIllIlIIIlIlIllIlI = 90.0f;
            llllllllllllIIIIllIlIIIlIlIllIIl = 1.0f;
        }
        GlStateManager.translate((float)llllllllllllIIIIllIlIIIlIlIlIlIl + llllllllllllIIIIllIlIIIlIlIllIIl, (float)llllllllllllIIIIllIlIIIlIlIlIlII + 0.5625f, (float)llllllllllllIIIIllIlIIIlIlIlIIll + llllllllllllIIIIllIlIIIlIlIllIII);
        GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(llllllllllllIIIIllIlIIIlIlIllIlI, 0.0f, 0.0f, 1.0f);
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        this.field_193849_d.func_193771_b();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllIIIIllIlIIIlIlIllIll);
        GlStateManager.popMatrix();
    }
    
    public TileEntityBedRenderer() {
        this.field_193849_d = new ModelBed();
        this.field_193850_e = this.field_193849_d.func_193770_a();
    }
    
    static {
        final EnumDyeColor[] llllllllllllIIIIllIlIIIllIIllIlI = EnumDyeColor.values();
        field_193848_a = new ResourceLocation[llllllllllllIIIIllIlIIIllIIllIlI.length];
        final long llllllllllllIIIIllIlIIIllIIlIlII;
        final Exception llllllllllllIIIIllIlIIIllIIlIlIl = (Exception)((EnumDyeColor[])(Object)(llllllllllllIIIIllIlIIIllIIlIlII = (long)(Object)llllllllllllIIIIllIlIIIllIIllIlI)).length;
        for (byte llllllllllllIIIIllIlIIIllIIlIllI = 0; llllllllllllIIIIllIlIIIllIIlIllI < llllllllllllIIIIllIlIIIllIIlIlIl; ++llllllllllllIIIIllIlIIIllIIlIllI) {
            final EnumDyeColor llllllllllllIIIIllIlIIIllIIllIIl = llllllllllllIIIIllIlIIIllIIlIlII[llllllllllllIIIIllIlIIIllIIlIllI];
            TileEntityBedRenderer.field_193848_a[llllllllllllIIIIllIlIIIllIIllIIl.getMetadata()] = new ResourceLocation("textures/entity/bed/" + llllllllllllIIIIllIlIIIllIIllIIl.func_192396_c() + ".png");
        }
    }
}
