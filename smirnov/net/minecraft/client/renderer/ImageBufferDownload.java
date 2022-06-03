// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import javax.annotation.Nullable;
import java.awt.Graphics;
import java.awt.image.DataBufferInt;
import java.awt.Color;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageBufferDownload implements IImageBuffer
{
    private /* synthetic */ int[] imageData;
    private /* synthetic */ int imageWidth;
    private /* synthetic */ int imageHeight;
    
    private void setAreaOpaque(final int llllllllllllIllIIllIIlIlllIIIlll, final int llllllllllllIllIIllIIlIlllIIIllI, final int llllllllllllIllIIllIIlIlllIIIlIl, final int llllllllllllIllIIllIIlIllIllllIl) {
        for (int llllllllllllIllIIllIIlIlllIIIIll = llllllllllllIllIIllIIlIlllIIIlll; llllllllllllIllIIllIIlIlllIIIIll < llllllllllllIllIIllIIlIlllIIIlIl; ++llllllllllllIllIIllIIlIlllIIIIll) {
            for (int llllllllllllIllIIllIIlIlllIIIIlI = llllllllllllIllIIllIIlIlllIIIllI; llllllllllllIllIIllIIlIlllIIIIlI < llllllllllllIllIIllIIlIllIllllIl; ++llllllllllllIllIIllIIlIlllIIIIlI) {
                final int[] imageData = this.imageData;
                final int n = llllllllllllIllIIllIIlIlllIIIIll + llllllllllllIllIIllIIlIlllIIIIlI * this.imageWidth;
                imageData[n] |= 0xFF000000;
            }
        }
    }
    
    private void doTransparencyHack(final int llllllllllllIllIIllIIlIlllIlIllI, final int llllllllllllIllIIllIIlIlllIlllll, final int llllllllllllIllIIllIIlIlllIllllI, final int llllllllllllIllIIllIIlIlllIlIIll) {
        for (int llllllllllllIllIIllIIlIlllIlllII = llllllllllllIllIIllIIlIlllIlIllI; llllllllllllIllIIllIIlIlllIlllII < llllllllllllIllIIllIIlIlllIllllI; ++llllllllllllIllIIllIIlIlllIlllII) {
            for (int llllllllllllIllIIllIIlIlllIllIll = llllllllllllIllIIllIIlIlllIlllll; llllllllllllIllIIllIIlIlllIllIll < llllllllllllIllIIllIIlIlllIlIIll; ++llllllllllllIllIIllIIlIlllIllIll) {
                final int llllllllllllIllIIllIIlIlllIllIlI = this.imageData[llllllllllllIllIIllIIlIlllIlllII + llllllllllllIllIIllIIlIlllIllIll * this.imageWidth];
                if ((llllllllllllIllIIllIIlIlllIllIlI >> 24 & 0xFF) < 128) {
                    return;
                }
            }
        }
        for (int llllllllllllIllIIllIIlIlllIllIIl = llllllllllllIllIIllIIlIlllIlIllI; llllllllllllIllIIllIIlIlllIllIIl < llllllllllllIllIIllIIlIlllIllllI; ++llllllllllllIllIIllIIlIlllIllIIl) {
            for (int llllllllllllIllIIllIIlIlllIllIII = llllllllllllIllIIllIIlIlllIlllll; llllllllllllIllIIllIIlIlllIllIII < llllllllllllIllIIllIIlIlllIlIIll; ++llllllllllllIllIIllIIlIlllIllIII) {
                final int[] imageData = this.imageData;
                final int n = llllllllllllIllIIllIIlIlllIllIIl + llllllllllllIllIIllIIlIlllIllIII * this.imageWidth;
                imageData[n] &= 0xFFFFFF;
            }
        }
    }
    
    @Nullable
    @Override
    public BufferedImage parseUserSkin(final BufferedImage llllllllllllIllIIllIIlIlllllIIIl) {
        if (llllllllllllIllIIllIIlIlllllIIIl == null) {
            return null;
        }
        this.imageWidth = 64;
        this.imageHeight = 64;
        final int llllllllllllIllIIllIIlIllllllIII = llllllllllllIllIIllIIlIlllllIIIl.getWidth();
        final int llllllllllllIllIIllIIlIlllllIlll = llllllllllllIllIIllIIlIlllllIIIl.getHeight();
        int llllllllllllIllIIllIIlIlllllIllI = 1;
        while (this.imageWidth < llllllllllllIllIIllIIlIllllllIII || this.imageHeight < llllllllllllIllIIllIIlIlllllIlll) {
            this.imageWidth *= 2;
            this.imageHeight *= 2;
            llllllllllllIllIIllIIlIlllllIllI *= 2;
        }
        final BufferedImage llllllllllllIllIIllIIlIlllllIlIl = new BufferedImage(this.imageWidth, this.imageHeight, 2);
        final Graphics llllllllllllIllIIllIIlIlllllIlII = llllllllllllIllIIllIIlIlllllIlIl.getGraphics();
        llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIIIl, 0, 0, null);
        final boolean llllllllllllIllIIllIIlIlllllIIll = llllllllllllIllIIllIIlIlllllIIIl.getHeight() == 32 * llllllllllllIllIIllIIlIlllllIllI;
        if (llllllllllllIllIIllIIlIlllllIIll) {
            llllllllllllIllIIllIIlIlllllIlII.setColor(new Color(0, 0, 0, 0));
            llllllllllllIllIIllIIlIlllllIlII.fillRect(0 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 24 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 4 * llllllllllllIllIIllIIlIlllllIllI, 16 * llllllllllllIllIIllIIlIlllllIllI, 8 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 28 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 24 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 8 * llllllllllllIllIIllIIlIlllllIllI, 16 * llllllllllllIllIIllIIlIlllllIllI, 12 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 20 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 16 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 8 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 12 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 24 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 4 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 8 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 28 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 24 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 0 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 4 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 32 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 28 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 12 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 16 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 40 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 36 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 44 * llllllllllllIllIIllIIlIlllllIllI, 16 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 44 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 40 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 16 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 36 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 40 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 36 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 44 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 44 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 40 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 40 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 44 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, null);
            llllllllllllIllIIllIIlIlllllIlII.drawImage(llllllllllllIllIIllIIlIlllllIlIl, 48 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 44 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 52 * llllllllllllIllIIllIIlIlllllIllI, 20 * llllllllllllIllIIllIIlIlllllIllI, 56 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, null);
        }
        llllllllllllIllIIllIIlIlllllIlII.dispose();
        this.imageData = ((DataBufferInt)llllllllllllIllIIllIIlIlllllIlIl.getRaster().getDataBuffer()).getData();
        this.setAreaOpaque(0 * llllllllllllIllIIllIIlIlllllIllI, 0 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI, 16 * llllllllllllIllIIllIIlIlllllIllI);
        if (llllllllllllIllIIllIIlIlllllIIll) {
            this.doTransparencyHack(32 * llllllllllllIllIIllIIlIlllllIllI, 0 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI);
        }
        this.setAreaOpaque(0 * llllllllllllIllIIllIIlIlllllIllI, 16 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI, 32 * llllllllllllIllIIllIIlIlllllIllI);
        this.setAreaOpaque(16 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 48 * llllllllllllIllIIllIIlIlllllIllI, 64 * llllllllllllIllIIllIIlIlllllIllI);
        return llllllllllllIllIIllIIlIlllllIlIl;
    }
    
    @Override
    public void skinAvailable() {
    }
}
