// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ResourcePackListEntry;
import java.util.List;

public abstract class GuiResourcePackList extends GuiListExtended
{
    protected final /* synthetic */ List<ResourcePackListEntry> resourcePackEntries;
    protected final /* synthetic */ Minecraft mc;
    
    @Override
    public ResourcePackListEntry getListEntry(final int lllllllllllIlIlIllIIIIIllllllIlI) {
        return this.getList().get(lllllllllllIlIlIllIIIIIllllllIlI);
    }
    
    public List<ResourcePackListEntry> getList() {
        return this.resourcePackEntries;
    }
    
    @Override
    public int getListWidth() {
        return this.width;
    }
    
    @Override
    protected int getSize() {
        return this.getList().size();
    }
    
    @Override
    protected void drawListHeader(final int lllllllllllIlIlIllIIIIlIIIIIlIII, final int lllllllllllIlIlIllIIIIlIIIIIllII, final Tessellator lllllllllllIlIlIllIIIIlIIIIIlIll) {
        final String lllllllllllIlIlIllIIIIlIIIIIlIlI = new StringBuilder().append(TextFormatting.UNDERLINE).append(TextFormatting.BOLD).append(this.getListHeader()).toString();
        Minecraft.fontRendererObj.drawString(lllllllllllIlIlIllIIIIlIIIIIlIlI, (float)(lllllllllllIlIlIllIIIIlIIIIIlIII + this.width / 2 - Minecraft.fontRendererObj.getStringWidth(lllllllllllIlIlIllIIIIlIIIIIlIlI) / 2), (float)Math.min(this.top + 3, lllllllllllIlIlIllIIIIlIIIIIllII), 16777215);
    }
    
    @Override
    protected int getScrollBarX() {
        return this.right - 6;
    }
    
    protected abstract String getListHeader();
    
    public GuiResourcePackList(final Minecraft lllllllllllIlIlIllIIIIlIIIIlIllI, final int lllllllllllIlIlIllIIIIlIIIIllIlI, final int lllllllllllIlIlIllIIIIlIIIIllIIl, final List<ResourcePackListEntry> lllllllllllIlIlIllIIIIlIIIIlIIll) {
        super(lllllllllllIlIlIllIIIIlIIIIlIllI, lllllllllllIlIlIllIIIIlIIIIllIlI, lllllllllllIlIlIllIIIIlIIIIllIIl, 32, lllllllllllIlIlIllIIIIlIIIIllIIl - 55 + 4, 36);
        this.mc = lllllllllllIlIlIllIIIIlIIIIlIllI;
        this.resourcePackEntries = lllllllllllIlIlIllIIIIlIIIIlIIll;
        this.centerListVertically = false;
        this.setHasListHeader(true, (int)(Minecraft.fontRendererObj.FONT_HEIGHT * 1.5f));
    }
}
