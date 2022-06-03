// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.ResourcePackListEntry;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class GuiResourcePackSelected extends GuiResourcePackList
{
    @Override
    protected String getListHeader() {
        return I18n.format("resourcePack.selected.title", new Object[0]);
    }
    
    public GuiResourcePackSelected(final Minecraft lllllllllllIIllIlIllIlIlIllIllII, final int lllllllllllIIllIlIllIlIlIlllIIII, final int lllllllllllIIllIlIllIlIlIllIllll, final List<ResourcePackListEntry> lllllllllllIIllIlIllIlIlIllIlllI) {
        super(lllllllllllIIllIlIllIlIlIllIllII, lllllllllllIIllIlIllIlIlIlllIIII, lllllllllllIIllIlIllIlIlIllIllll, lllllllllllIIllIlIllIlIlIllIlllI);
    }
}
