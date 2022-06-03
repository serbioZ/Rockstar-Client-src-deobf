// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.ResourcePackListEntry;
import java.util.List;
import net.minecraft.client.Minecraft;

public class GuiResourcePackAvailable extends GuiResourcePackList
{
    public GuiResourcePackAvailable(final Minecraft llllllllllllllIllIIIIIllIIIllIII, final int llllllllllllllIllIIIIIllIIIlIIlI, final int llllllllllllllIllIIIIIllIIIlIIIl, final List<ResourcePackListEntry> llllllllllllllIllIIIIIllIIIlIlIl) {
        super(llllllllllllllIllIIIIIllIIIllIII, llllllllllllllIllIIIIIllIIIlIIlI, llllllllllllllIllIIIIIllIIIlIIIl, llllllllllllllIllIIIIIllIIIlIlIl);
    }
    
    @Override
    protected String getListHeader() {
        return I18n.format("resourcePack.available.title", new Object[0]);
    }
}
