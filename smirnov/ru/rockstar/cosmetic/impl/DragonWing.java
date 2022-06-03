// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.cosmetic.impl;

import net.minecraft.util.ResourceLocation;
import ru.rockstar.cosmetic.Cosmetic;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class DragonWing extends ModelBase
{
    private static /* synthetic */ ModelRenderer mr2;
    private static /* synthetic */ ModelRenderer mr1;
    
    private static float calRotateBodyNowX(final float llllllllllllIIIIlIIlIIlIlIllIIIl, final float llllllllllllIIIIlIIlIIlIlIllIIII, final float llllllllllllIIIIlIIlIIlIlIlIllll) {
        final float llllllllllllIIIIlIIlIIlIlIllIIlI = (llllllllllllIIIIlIIlIIlIlIllIIIl + (llllllllllllIIIIlIIlIIlIlIllIIII - llllllllllllIIIIlIIlIIlIlIllIIIl) * llllllllllllIIIIlIIlIIlIlIlIllll) % 360.0f;
        return llllllllllllIIIIlIIlIIlIlIllIIlI;
    }
    
    public DragonWing() {
        this.setTextureOffset("wing.bone", 0, 0);
        this.setTextureOffset("wing.skin", -10, 8);
        this.setTextureOffset("wingtip.bone", 0, 5);
        this.setTextureOffset("wingtip.skin", -10, 18);
        (DragonWing.mr1 = new ModelRenderer(this, "wing")).setTextureSize(30, 30);
        DragonWing.mr1.setRotationPoint(-2.0f, 0.0f, 0.0f);
        DragonWing.mr1.addBox("bone", -10.0f, -1.0f, -1.0f, 10, 2, 2);
        DragonWing.mr1.addBox("skin", -10.0f, 0.0f, 0.5f, 10, 0, 10);
        (DragonWing.mr2 = new ModelRenderer(this, "wingtip")).setTextureSize(30, 30);
        DragonWing.mr2.setRotationPoint(-10.0f, 0.0f, 0.0f);
        DragonWing.mr2.addBox("bone", -10.0f, -0.5f, -0.5f, 10, 1, 1);
        DragonWing.mr2.addBox("skin", -10.0f, 0.0f, 0.5f, 10, 0, 10);
        DragonWing.mr1.addChild(DragonWing.mr2);
    }
    
    private static float interpolate(final float llllllllllllIIIIlIIlIIlIlIIlllIl, final float llllllllllllIIIIlIIlIIlIlIIllIII, final float llllllllllllIIIIlIIlIIlIlIIllIll) {
        float llllllllllllIIIIlIIlIIlIlIIllIlI = (llllllllllllIIIIlIIlIIlIlIIlllIl + (llllllllllllIIIIlIIlIIlIlIIllIII - llllllllllllIIIIlIIlIIlIlIIlllIl) * llllllllllllIIIIlIIlIIlIlIIllIll) % 360.0f;
        if (llllllllllllIIIIlIIlIIlIlIIllIlI < 0.0f) {
            llllllllllllIIIIlIIlIIlIlIIllIlI += 360.0f;
        }
        return llllllllllllIIIIlIIlIIlIlIIllIlI;
    }
    
    private static float calRotateHeadNowX(final float llllllllllllIIIIlIIlIIlIllIIIIll, final float llllllllllllIIIIlIIlIIlIllIIIIlI, final float llllllllllllIIIIlIIlIIlIllIIIIIl, final EntityPlayer llllllllllllIIIIlIIlIIlIlIlllIll) {
        if (!llllllllllllIIIIlIIlIIlIlIlllIll.equals(Minecraft.getMinecraft().player) && ((0.0f > llllllllllllIIIIlIIlIIlIllIIIIll && 0.0f < llllllllllllIIIIlIIlIIlIllIIIIlI) || (0.0f < llllllllllllIIIIlIIlIIlIllIIIIll && 0.0f > llllllllllllIIIIlIIlIIlIllIIIIlI))) {
            return llllllllllllIIIIlIIlIIlIllIIIIlI;
        }
        final float llllllllllllIIIIlIIlIIlIlIllllll = (llllllllllllIIIIlIIlIIlIllIIIIll + (llllllllllllIIIIlIIlIIlIllIIIIlI - llllllllllllIIIIlIIlIIlIllIIIIll) * llllllllllllIIIIlIIlIIlIllIIIIIl) % 360.0f;
        return llllllllllllIIIIlIIlIIlIlIllllll;
    }
    
    public static void render(final EntityPlayer llllllllllllIIIIlIIlIIlIllIlIlII, final float llllllllllllIIIIlIIlIIlIllIlIIll) {
        final double llllllllllllIIIIlIIlIIlIllIlIIlI = interpolate(llllllllllllIIIIlIIlIIlIllIlIlII.prevRenderYawOffset, llllllllllllIIIIlIIlIIlIllIlIlII.renderYawOffset, llllllllllllIIIIlIIlIIlIllIlIIll);
        GL11.glPushMatrix();
        GL11.glScaled(10.0, 10.0, 10.0);
        GL11.glRotated(Math.toRadians(llllllllllllIIIIlIIlIIlIllIlIIlI) - 4.0, 0.0, 1.0, 0.0);
        GL11.glTranslated(0.0, 0.1, 0.095);
        if (llllllllllllIIIIlIIlIIlIllIlIlII.isSneaking()) {
            GL11.glTranslated(0.0, 0.2, 0.05);
        }
        if (!llllllllllllIIIIlIIlIIlIllIlIlII.inventory.armorInventory.get(2).func_190926_b()) {
            GL11.glTranslated(0.0, 0.0, 0.05);
        }
        final ResourceLocation llllllllllllIIIIlIIlIIlIllIlIIIl = Cosmetic.getWing("Gray");
        Minecraft.getMinecraft().getTextureManager().bindTexture(llllllllllllIIIIlIIlIIlIllIlIIIl);
        for (int llllllllllllIIIIlIIlIIlIllIlIIII = 0; llllllllllllIIIIlIIlIIlIllIlIIII < 2; ++llllllllllllIIIIlIIlIIlIllIlIIII) {
            final float llllllllllllIIIIlIIlIIlIllIIllll = System.currentTimeMillis() % 1000L / 1000.0f * 3.1415927f * 2.0f;
            DragonWing.mr1.rotateAngleX = (float)(Math.toRadians(-80.0) - Math.cos(llllllllllllIIIIlIIlIIlIllIIllll) * 0.20000000298023224);
            DragonWing.mr1.rotateAngleY = (float)(Math.toRadians(30.0) + Math.sin(llllllllllllIIIIlIIlIIlIllIIllll) * 0.4000000059604645);
            DragonWing.mr1.rotateAngleZ = (float)Math.toRadians(20.0);
            DragonWing.mr2.rotateAngleZ = (float)(-(Math.sin(llllllllllllIIIIlIIlIIlIllIIllll + 2.0f) + 0.5) * 0.75);
            DragonWing.mr1.render(0.0625f);
            GL11.glScalef(-1.0f, 1.0f, 1.0f);
        }
        GL11.glCullFace(1029);
        GL11.glPopMatrix();
    }
    
    private static float calRotateHeadNowY(final float llllllllllllIIIIlIIlIIlIlIlIlIIl, final float llllllllllllIIIIlIIlIIlIlIlIlIII, final float llllllllllllIIIIlIIlIIlIlIlIIIll) {
        final float llllllllllllIIIIlIIlIIlIlIlIIllI = (llllllllllllIIIIlIIlIIlIlIlIlIIl + (llllllllllllIIIIlIIlIIlIlIlIlIII - llllllllllllIIIIlIIlIIlIlIlIlIIl) * llllllllllllIIIIlIIlIIlIlIlIIIll) % 180.0f;
        return llllllllllllIIIIlIIlIIlIlIlIIllI;
    }
}
