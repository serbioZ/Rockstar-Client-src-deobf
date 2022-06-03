// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBook;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntityEnchantmentTable;

public class TileEntityEnchantmentTableRenderer extends TileEntitySpecialRenderer<TileEntityEnchantmentTable>
{
    private static final /* synthetic */ ResourceLocation TEXTURE_BOOK;
    private final /* synthetic */ ModelBook modelBook;
    
    @Override
    public void func_192841_a(final TileEntityEnchantmentTable lllllllllllIIIllIIllIlIlIIIIIIll, final double lllllllllllIIIllIIllIlIIllllIIll, final double lllllllllllIIIllIIllIlIlIIIIIIIl, final double lllllllllllIIIllIIllIlIlIIIIIIII, final float lllllllllllIIIllIIllIlIIllllllll, final int lllllllllllIIIllIIllIlIIlllllllI, final float lllllllllllIIIllIIllIlIIllllllIl) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllIIIllIIllIlIIllllIIll + 0.5f, (float)lllllllllllIIIllIIllIlIlIIIIIIIl + 0.75f, (float)lllllllllllIIIllIIllIlIlIIIIIIII + 0.5f);
        final float lllllllllllIIIllIIllIlIIllllllII = lllllllllllIIIllIIllIlIlIIIIIIll.tickCount + lllllllllllIIIllIIllIlIIllllllll;
        GlStateManager.translate(0.0f, 0.1f + MathHelper.sin(lllllllllllIIIllIIllIlIIllllllII * 0.1f) * 0.01f, 0.0f);
        float lllllllllllIIIllIIllIlIIlllllIll;
        for (lllllllllllIIIllIIllIlIIlllllIll = lllllllllllIIIllIIllIlIlIIIIIIll.bookRotation - lllllllllllIIIllIIllIlIlIIIIIIll.bookRotationPrev; lllllllllllIIIllIIllIlIIlllllIll >= 3.1415927f; lllllllllllIIIllIIllIlIIlllllIll -= 6.2831855f) {}
        while (lllllllllllIIIllIIllIlIIlllllIll < -3.1415927f) {
            lllllllllllIIIllIIllIlIIlllllIll += 6.2831855f;
        }
        final float lllllllllllIIIllIIllIlIIlllllIlI = lllllllllllIIIllIIllIlIlIIIIIIll.bookRotationPrev + lllllllllllIIIllIIllIlIIlllllIll * lllllllllllIIIllIIllIlIIllllllll;
        GlStateManager.rotate(-lllllllllllIIIllIIllIlIIlllllIlI * 57.295776f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(80.0f, 0.0f, 0.0f, 1.0f);
        this.bindTexture(TileEntityEnchantmentTableRenderer.TEXTURE_BOOK);
        float lllllllllllIIIllIIllIlIIlllllIIl = lllllllllllIIIllIIllIlIlIIIIIIll.pageFlipPrev + (lllllllllllIIIllIIllIlIlIIIIIIll.pageFlip - lllllllllllIIIllIIllIlIlIIIIIIll.pageFlipPrev) * lllllllllllIIIllIIllIlIIllllllll + 0.25f;
        float lllllllllllIIIllIIllIlIIlllllIII = lllllllllllIIIllIIllIlIlIIIIIIll.pageFlipPrev + (lllllllllllIIIllIIllIlIlIIIIIIll.pageFlip - lllllllllllIIIllIIllIlIlIIIIIIll.pageFlipPrev) * lllllllllllIIIllIIllIlIIllllllll + 0.75f;
        lllllllllllIIIllIIllIlIIlllllIIl = (lllllllllllIIIllIIllIlIIlllllIIl - MathHelper.fastFloor(lllllllllllIIIllIIllIlIIlllllIIl)) * 1.6f - 0.3f;
        lllllllllllIIIllIIllIlIIlllllIII = (lllllllllllIIIllIIllIlIIlllllIII - MathHelper.fastFloor(lllllllllllIIIllIIllIlIIlllllIII)) * 1.6f - 0.3f;
        if (lllllllllllIIIllIIllIlIIlllllIIl < 0.0f) {
            lllllllllllIIIllIIllIlIIlllllIIl = 0.0f;
        }
        if (lllllllllllIIIllIIllIlIIlllllIII < 0.0f) {
            lllllllllllIIIllIIllIlIIlllllIII = 0.0f;
        }
        if (lllllllllllIIIllIIllIlIIlllllIIl > 1.0f) {
            lllllllllllIIIllIIllIlIIlllllIIl = 1.0f;
        }
        if (lllllllllllIIIllIIllIlIIlllllIII > 1.0f) {
            lllllllllllIIIllIIllIlIIlllllIII = 1.0f;
        }
        final float lllllllllllIIIllIIllIlIIllllIlll = lllllllllllIIIllIIllIlIlIIIIIIll.bookSpreadPrev + (lllllllllllIIIllIIllIlIlIIIIIIll.bookSpread - lllllllllllIIIllIIllIlIlIIIIIIll.bookSpreadPrev) * lllllllllllIIIllIIllIlIIllllllll;
        GlStateManager.enableCull();
        this.modelBook.render(null, lllllllllllIIIllIIllIlIIllllllII, lllllllllllIIIllIIllIlIIlllllIIl, lllllllllllIIIllIIllIlIIlllllIII, lllllllllllIIIllIIllIlIIllllIlll, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
    }
    
    public TileEntityEnchantmentTableRenderer() {
        this.modelBook = new ModelBook();
    }
    
    static {
        TEXTURE_BOOK = new ResourceLocation("textures/entity/enchanting_table_book.png");
    }
}
