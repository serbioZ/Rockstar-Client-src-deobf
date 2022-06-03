// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.cosmetic;

import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.ITextureObject;
import java.io.File;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.Wings;
import ru.rockstar.Main;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.image.BufferedImage;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class CosmeticRender implements LayerRenderer<AbstractClientPlayer>
{
    private final /* synthetic */ RenderPlayer playerRenderer;
    
    private static BufferedImage parseCape(final BufferedImage lllllllllllllIIIllIIlIIllIllIllI) {
        int lllllllllllllIIIllIIlIIllIllllII = 64;
        int lllllllllllllIIIllIIlIIllIlllIll = 32;
        for (int lllllllllllllIIIllIIlIIllIlllIlI = lllllllllllllIIIllIIlIIllIllIllI.getWidth(), lllllllllllllIIIllIIlIIllIlllIIl = lllllllllllllIIIllIIlIIllIllIllI.getHeight(); lllllllllllllIIIllIIlIIllIllllII < lllllllllllllIIIllIIlIIllIlllIlI || lllllllllllllIIIllIIlIIllIlllIll < lllllllllllllIIIllIIlIIllIlllIIl; lllllllllllllIIIllIIlIIllIllllII *= 2, lllllllllllllIIIllIIlIIllIlllIll *= 2) {}
        final BufferedImage lllllllllllllIIIllIIlIIllIlllIII = new BufferedImage(lllllllllllllIIIllIIlIIllIllllII, lllllllllllllIIIllIIlIIllIlllIll, 2);
        final Graphics lllllllllllllIIIllIIlIIllIllIlll = lllllllllllllIIIllIIlIIllIlllIII.getGraphics();
        lllllllllllllIIIllIIlIIllIllIlll.drawImage(lllllllllllllIIIllIIlIIllIllIllI, 0, 0, null);
        lllllllllllllIIIllIIlIIllIllIlll.dispose();
        return lllllllllllllIIIllIIlIIllIlllIII;
    }
    
    @Override
    public void doRenderLayer(final AbstractClientPlayer lllllllllllllIIIllIIlIIllllIIIIl, final float lllllllllllllIIIllIIlIIllllIIIII, final float lllllllllllllIIIllIIlIIlllIlllll, final float lllllllllllllIIIllIIlIIlllIllllI, final float lllllllllllllIIIllIIlIIlllIlllIl, final float lllllllllllllIIIllIIlIIlllIlllII, final float lllllllllllllIIIllIIlIIlllIllIll, final float lllllllllllllIIIllIIlIIlllIllIlI) {
        if (!Main.featureDirector.getFeatureByClass(Wings.class).isToggled()) {
            return;
        }
        if (!lllllllllllllIIIllIIlIIllllIIIIl.hasPlayerInfo() || lllllllllllllIIIllIIlIIllllIIIIl.isInvisible()) {
            return;
        }
        if (lllllllllllllIIIllIIlIIllllIIIIl == Minecraft.getMinecraft().player) {
            Cosmetic.renderAccessory(new String[] { "Dragon_wing" }, lllllllllllllIIIllIIlIIllllIIIIl, lllllllllllllIIIllIIlIIlllIllllI);
        }
    }
    
    public static void bindTexture(final String lllllllllllllIIIllIIlIIlllIlIIII, final String lllllllllllllIIIllIIlIIlllIIllll) {
        final IImageBuffer lllllllllllllIIIllIIlIIlllIIlllI = new IImageBuffer() {
            @Override
            public BufferedImage parseUserSkin(final BufferedImage llllllllllllIIllIllllIllIlllllII) {
                return parseCape(llllllllllllIIllIllllIllIlllllII);
            }
            
            @Override
            public void skinAvailable() {
            }
        };
        final ResourceLocation lllllllllllllIIIllIIlIIlllIIllIl = new ResourceLocation(lllllllllllllIIIllIIlIIlllIIllll);
        final TextureManager lllllllllllllIIIllIIlIIlllIIllII = Minecraft.getMinecraft().getTextureManager();
        lllllllllllllIIIllIIlIIlllIIllII.getTexture(lllllllllllllIIIllIIlIIlllIIllIl);
        final ThreadDownloadImageData lllllllllllllIIIllIIlIIlllIIlIll = new ThreadDownloadImageData(null, lllllllllllllIIIllIIlIIlllIlIIII, null, lllllllllllllIIIllIIlIIlllIIlllI);
        lllllllllllllIIIllIIlIIlllIIllII.loadTexture(lllllllllllllIIIllIIlIIlllIIllIl, lllllllllllllIIIllIIlIIlllIIlIll);
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    public CosmeticRender(final RenderPlayer lllllllllllllIIIllIIlIIllllIIlIl) {
        this.playerRenderer = lllllllllllllIIIllIIlIIllllIIlIl;
    }
}
