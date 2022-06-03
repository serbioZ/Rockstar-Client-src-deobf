// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenResourcePacks;

public class ResourcePackListEntryDefault extends ResourcePackListEntryServer
{
    @Override
    protected String getResourcePackName() {
        return "Default";
    }
    
    @Override
    public boolean isServerPack() {
        return false;
    }
    
    public ResourcePackListEntryDefault(final GuiScreenResourcePacks lllllllllllllIllIIlllllIllIllIll) {
        super(lllllllllllllIllIIlllllIllIllIll, Minecraft.getMinecraft().getResourcePackRepository().rprDefaultResourcePack);
    }
}
