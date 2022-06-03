// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntityMobSpawner;

public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer<TileEntityMobSpawner>
{
    @Override
    public void func_192841_a(final TileEntityMobSpawner lllllllllllIllIlIlIIIIIlIIlIIIIl, final double lllllllllllIllIlIlIIIIIlIIlIIIII, final double lllllllllllIllIlIlIIIIIlIIIlllll, final double lllllllllllIllIlIlIIIIIlIIIllllI, final float lllllllllllIllIlIlIIIIIlIIlIIlII, final int lllllllllllIllIlIlIIIIIlIIlIIIll, final float lllllllllllIllIlIlIIIIIlIIlIIIlI) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllIllIlIlIIIIIlIIlIIIII + 0.5f, (float)lllllllllllIllIlIlIIIIIlIIIlllll, (float)lllllllllllIllIlIlIIIIIlIIIllllI + 0.5f);
        renderMob(lllllllllllIllIlIlIIIIIlIIlIIIIl.getSpawnerBaseLogic(), lllllllllllIllIlIlIIIIIlIIlIIIII, lllllllllllIllIlIlIIIIIlIIIlllll, lllllllllllIllIlIlIIIIIlIIIllllI, lllllllllllIllIlIlIIIIIlIIlIIlII);
        GlStateManager.popMatrix();
    }
    
    public static void renderMob(final MobSpawnerBaseLogic lllllllllllIllIlIlIIIIIlIIIlIlII, final double lllllllllllIllIlIlIIIIIlIIIlIIll, final double lllllllllllIllIlIlIIIIIlIIIlIIlI, final double lllllllllllIllIlIlIIIIIlIIIlIIIl, final float lllllllllllIllIlIlIIIIIlIIIlIIII) {
        final Entity lllllllllllIllIlIlIIIIIlIIIIllll = lllllllllllIllIlIlIIIIIlIIIlIlII.getCachedEntity();
        if (lllllllllllIllIlIlIIIIIlIIIIllll != null) {
            float lllllllllllIllIlIlIIIIIlIIIIlllI = 0.53125f;
            final float lllllllllllIllIlIlIIIIIlIIIIllIl = Math.max(lllllllllllIllIlIlIIIIIlIIIIllll.width, lllllllllllIllIlIlIIIIIlIIIIllll.height);
            if (lllllllllllIllIlIlIIIIIlIIIIllIl > 1.0) {
                lllllllllllIllIlIlIIIIIlIIIIlllI /= lllllllllllIllIlIlIIIIIlIIIIllIl;
            }
            GlStateManager.translate(0.0f, 0.4f, 0.0f);
            GlStateManager.rotate((float)(lllllllllllIllIlIlIIIIIlIIIlIlII.getPrevMobRotation() + (lllllllllllIllIlIlIIIIIlIIIlIlII.getMobRotation() - lllllllllllIllIlIlIIIIIlIIIlIlII.getPrevMobRotation()) * lllllllllllIllIlIlIIIIIlIIIlIIII) * 10.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.2f, 0.0f);
            GlStateManager.rotate(-30.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.scale(lllllllllllIllIlIlIIIIIlIIIIlllI, lllllllllllIllIlIlIIIIIlIIIIlllI, lllllllllllIllIlIlIIIIIlIIIIlllI);
            lllllllllllIllIlIlIIIIIlIIIIllll.setLocationAndAngles(lllllllllllIllIlIlIIIIIlIIIlIIll, lllllllllllIllIlIlIIIIIlIIIlIIlI, lllllllllllIllIlIlIIIIIlIIIlIIIl, 0.0f, 0.0f);
            Minecraft.getMinecraft().getRenderManager().doRenderEntity(lllllllllllIllIlIlIIIIIlIIIIllll, 0.0, 0.0, 0.0, 0.0f, lllllllllllIllIlIlIIIIIlIIIlIIII, false);
        }
    }
}
