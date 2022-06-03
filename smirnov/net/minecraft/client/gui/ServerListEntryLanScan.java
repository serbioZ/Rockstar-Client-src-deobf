// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.Minecraft;

public class ServerListEntryLanScan implements GuiListExtended.IGuiListEntry
{
    private final /* synthetic */ Minecraft mc;
    
    @Override
    public void mouseReleased(final int lllllllllllIIllIllIIIIIIIlIIIIIl, final int lllllllllllIIllIllIIIIIIIlIIIIII, final int lllllllllllIIllIllIIIIIIIIllllll, final int lllllllllllIIllIllIIIIIIIIlllllI, final int lllllllllllIIllIllIIIIIIIIllllIl, final int lllllllllllIIllIllIIIIIIIIllllII) {
    }
    
    @Override
    public void func_192634_a(final int lllllllllllIIllIllIIIIIIIllIIIII, final int lllllllllllIIllIllIIIIIIIlIlllll, final int lllllllllllIIllIllIIIIIIIlIlIIlI, final int lllllllllllIIllIllIIIIIIIlIlllIl, final int lllllllllllIIllIllIIIIIIIlIlllII, final int lllllllllllIIllIllIIIIIIIlIllIll, final int lllllllllllIIllIllIIIIIIIlIllIlI, final boolean lllllllllllIIllIllIIIIIIIlIllIIl, final float lllllllllllIIllIllIIIIIIIlIllIII) {
        final int lllllllllllIIllIllIIIIIIIlIlIlll = lllllllllllIIllIllIIIIIIIlIlIIlI + lllllllllllIIllIllIIIIIIIlIlllII / 2 - Minecraft.fontRendererObj.FONT_HEIGHT / 2;
        Minecraft.fontRendererObj.drawString(I18n.format("lanServer.scanning", new Object[0]), (float)(this.mc.currentScreen.width / 2 - Minecraft.fontRendererObj.getStringWidth(I18n.format("lanServer.scanning", new Object[0])) / 2), (float)lllllllllllIIllIllIIIIIIIlIlIlll, 16777215);
        final String lllllllllllIIllIllIIIIIIIlIlIlII;
        switch ((int)(Minecraft.getSystemTime() / 300L % 4L)) {
            default: {
                final String lllllllllllIIllIllIIIIIIIlIlIllI = "O o o";
                break;
            }
            case 1:
            case 3: {
                final String lllllllllllIIllIllIIIIIIIlIlIlIl = "o O o";
                break;
            }
            case 2: {
                lllllllllllIIllIllIIIIIIIlIlIlII = "o o O";
                break;
            }
        }
        Minecraft.fontRendererObj.drawString(lllllllllllIIllIllIIIIIIIlIlIlII, (float)(this.mc.currentScreen.width / 2 - Minecraft.fontRendererObj.getStringWidth(lllllllllllIIllIllIIIIIIIlIlIlII) / 2), (float)(lllllllllllIIllIllIIIIIIIlIlIlll + Minecraft.fontRendererObj.FONT_HEIGHT), 8421504);
    }
    
    @Override
    public void func_192633_a(final int lllllllllllIIllIllIIIIIIIlIIllIl, final int lllllllllllIIllIllIIIIIIIlIIllII, final int lllllllllllIIllIllIIIIIIIlIIlIll, final float lllllllllllIIllIllIIIIIIIlIIlIlI) {
    }
    
    public ServerListEntryLanScan() {
        this.mc = Minecraft.getMinecraft();
    }
    
    @Override
    public boolean mousePressed(final int lllllllllllIIllIllIIIIIIIlIIlIII, final int lllllllllllIIllIllIIIIIIIlIIIlll, final int lllllllllllIIllIllIIIIIIIlIIIllI, final int lllllllllllIIllIllIIIIIIIlIIIlIl, final int lllllllllllIIllIllIIIIIIIlIIIlII, final int lllllllllllIIllIllIIIIIIIlIIIIll) {
        return false;
    }
}
