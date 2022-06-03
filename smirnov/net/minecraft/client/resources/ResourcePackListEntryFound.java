// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import net.minecraft.client.gui.GuiScreenResourcePacks;

public class ResourcePackListEntryFound extends ResourcePackListEntry
{
    private final /* synthetic */ ResourcePackRepository.Entry resourcePackEntry;
    
    @Override
    protected String getResourcePackDescription() {
        return this.resourcePackEntry.getTexturePackDescription();
    }
    
    public ResourcePackRepository.Entry getResourcePackEntry() {
        return this.resourcePackEntry;
    }
    
    @Override
    protected int getResourcePackFormat() {
        return this.resourcePackEntry.getPackFormat();
    }
    
    @Override
    protected String getResourcePackName() {
        return this.resourcePackEntry.getResourcePackName();
    }
    
    public ResourcePackListEntryFound(final GuiScreenResourcePacks lllllllllllIlIlIIlllIIlllIlIllll, final ResourcePackRepository.Entry lllllllllllIlIlIIlllIIlllIlIlllI) {
        super(lllllllllllIlIlIIlllIIlllIlIllll);
        this.resourcePackEntry = lllllllllllIlIlIIlllIIlllIlIlllI;
    }
    
    @Override
    protected void bindResourcePackIcon() {
        this.resourcePackEntry.bindTexturePackIcon(this.mc.getTextureManager());
    }
}
