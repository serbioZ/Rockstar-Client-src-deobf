// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.io.File;
import java.util.Collections;
import net.minecraft.client.renderer.OpenGlHelper;
import java.util.Iterator;
import net.minecraft.client.resources.ResourcePackListEntryDefault;
import net.minecraft.client.resources.ResourcePackListEntryServer;
import net.minecraft.client.resources.ResourcePackListEntryFound;
import net.minecraft.client.resources.ResourcePackRepository;
import java.util.Collection;
import com.google.common.collect.Lists;
import net.minecraft.client.resources.I18n;
import java.io.IOException;
import net.minecraft.client.resources.ResourcePackListEntry;
import java.util.List;

public class GuiScreenResourcePacks extends GuiScreen
{
    private /* synthetic */ List<ResourcePackListEntry> selectedResourcePacks;
    private /* synthetic */ GuiResourcePackAvailable availableResourcePacksList;
    private /* synthetic */ GuiResourcePackSelected selectedResourcePacksList;
    private /* synthetic */ List<ResourcePackListEntry> availableResourcePacks;
    private /* synthetic */ boolean changed;
    private final /* synthetic */ GuiScreen parentScreen;
    
    public List<ResourcePackListEntry> getAvailableResourcePacks() {
        return this.availableResourcePacks;
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIllIlIlIIlIIlIlIlllll, final int lllllllllllIllIlIlIIlIIlIlIllllI, final int lllllllllllIllIlIlIIlIIlIllIIIIl) throws IOException {
        super.mouseClicked(lllllllllllIllIlIlIIlIIlIlIlllll, lllllllllllIllIlIlIIlIIlIlIllllI, lllllllllllIllIlIlIIlIIlIllIIIIl);
        this.availableResourcePacksList.mouseClicked(lllllllllllIllIlIlIIlIIlIlIlllll, lllllllllllIllIlIlIIlIIlIlIllllI, lllllllllllIllIlIlIIlIIlIllIIIIl);
        this.selectedResourcePacksList.mouseClicked(lllllllllllIllIlIlIIlIIlIlIlllll, lllllllllllIllIlIlIIlIIlIlIllllI, lllllllllllIllIlIlIIlIIlIllIIIIl);
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(2, this.width / 2 - 154, this.height - 48, I18n.format("resourcePack.openFolder", new Object[0])));
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 4, this.height - 48, I18n.format("gui.done", new Object[0])));
        if (!this.changed) {
            this.availableResourcePacks = (List<ResourcePackListEntry>)Lists.newArrayList();
            this.selectedResourcePacks = (List<ResourcePackListEntry>)Lists.newArrayList();
            final ResourcePackRepository lllllllllllIllIlIlIIlIIllIIllIII = this.mc.getResourcePackRepository();
            lllllllllllIllIlIlIIlIIllIIllIII.updateRepositoryEntriesAll();
            final List<ResourcePackRepository.Entry> lllllllllllIllIlIlIIlIIllIIlIlll = (List<ResourcePackRepository.Entry>)Lists.newArrayList((Iterable)lllllllllllIllIlIlIIlIIllIIllIII.getRepositoryEntriesAll());
            lllllllllllIllIlIlIIlIIllIIlIlll.removeAll(lllllllllllIllIlIlIIlIIllIIllIII.getRepositoryEntries());
            for (final ResourcePackRepository.Entry lllllllllllIllIlIlIIlIIllIIlIllI : lllllllllllIllIlIlIIlIIllIIlIlll) {
                this.availableResourcePacks.add(new ResourcePackListEntryFound(this, lllllllllllIllIlIlIIlIIllIIlIllI));
            }
            final ResourcePackRepository.Entry lllllllllllIllIlIlIIlIIllIIlIlIl = lllllllllllIllIlIlIIlIIllIIllIII.getResourcePackEntry();
            if (lllllllllllIllIlIlIIlIIllIIlIlIl != null) {
                this.selectedResourcePacks.add(new ResourcePackListEntryServer(this, lllllllllllIllIlIlIIlIIllIIllIII.getResourcePackInstance()));
            }
            for (final ResourcePackRepository.Entry lllllllllllIllIlIlIIlIIllIIlIlII : Lists.reverse((List)lllllllllllIllIlIlIIlIIllIIllIII.getRepositoryEntries())) {
                this.selectedResourcePacks.add(new ResourcePackListEntryFound(this, lllllllllllIllIlIlIIlIIllIIlIlII));
            }
            this.selectedResourcePacks.add(new ResourcePackListEntryDefault(this));
        }
        this.availableResourcePacksList = new GuiResourcePackAvailable(this.mc, 200, this.height, this.availableResourcePacks);
        this.availableResourcePacksList.setSlotXBoundsFromLeft(this.width / 2 - 4 - 200);
        this.availableResourcePacksList.registerScrollButtons(7, 8);
        this.selectedResourcePacksList = new GuiResourcePackSelected(this.mc, 200, this.height, this.selectedResourcePacks);
        this.selectedResourcePacksList.setSlotXBoundsFromLeft(this.width / 2 + 4);
        this.selectedResourcePacksList.registerScrollButtons(7, 8);
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.selectedResourcePacksList.handleMouseInput();
        this.availableResourcePacksList.handleMouseInput();
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIllIlIlIIlIIlIlllIIlI) throws IOException {
        if (lllllllllllIllIlIlIIlIIlIlllIIlI.enabled) {
            if (lllllllllllIllIlIlIIlIIlIlllIIlI.id == 2) {
                final File lllllllllllIllIlIlIIlIIlIlllIIIl = this.mc.getResourcePackRepository().getDirResourcepacks();
                OpenGlHelper.openFile(lllllllllllIllIlIlIIlIIlIlllIIIl);
            }
            else if (lllllllllllIllIlIlIIlIIlIlllIIlI.id == 1) {
                if (this.changed) {
                    final List<ResourcePackRepository.Entry> lllllllllllIllIlIlIIlIIlIlllIIII = (List<ResourcePackRepository.Entry>)Lists.newArrayList();
                    for (final ResourcePackListEntry lllllllllllIllIlIlIIlIIlIllIllll : this.selectedResourcePacks) {
                        if (lllllllllllIllIlIlIIlIIlIllIllll instanceof ResourcePackListEntryFound) {
                            lllllllllllIllIlIlIIlIIlIlllIIII.add(((ResourcePackListEntryFound)lllllllllllIllIlIlIIlIIlIllIllll).getResourcePackEntry());
                        }
                    }
                    Collections.reverse(lllllllllllIllIlIlIIlIIlIlllIIII);
                    this.mc.getResourcePackRepository().setRepositories(lllllllllllIllIlIlIIlIIlIlllIIII);
                    this.mc.gameSettings.resourcePacks.clear();
                    this.mc.gameSettings.incompatibleResourcePacks.clear();
                    for (final ResourcePackRepository.Entry lllllllllllIllIlIlIIlIIlIllIlllI : lllllllllllIllIlIlIIlIIlIlllIIII) {
                        this.mc.gameSettings.resourcePacks.add(lllllllllllIllIlIlIIlIIlIllIlllI.getResourcePackName());
                        if (lllllllllllIllIlIlIIlIIlIllIlllI.getPackFormat() != 3) {
                            this.mc.gameSettings.incompatibleResourcePacks.add(lllllllllllIllIlIlIIlIIlIllIlllI.getResourcePackName());
                        }
                    }
                    this.mc.gameSettings.saveOptions();
                    this.mc.refreshResources();
                }
                this.mc.displayGuiScreen(this.parentScreen);
            }
        }
    }
    
    public GuiScreenResourcePacks(final GuiScreen lllllllllllIllIlIlIIlIIllIlIIIII) {
        this.parentScreen = lllllllllllIllIlIlIIlIIllIlIIIII;
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllIllIlIlIIlIIlIlIlIlll, final int lllllllllllIllIlIlIIlIIlIlIlIIlI, final int lllllllllllIllIlIlIIlIIlIlIlIIIl) {
        super.mouseReleased(lllllllllllIllIlIlIIlIIlIlIlIlll, lllllllllllIllIlIlIIlIIlIlIlIIlI, lllllllllllIllIlIlIIlIIlIlIlIIIl);
    }
    
    public boolean hasResourcePackEntry(final ResourcePackListEntry lllllllllllIllIlIlIIlIIllIIIIlIl) {
        return this.selectedResourcePacks.contains(lllllllllllIllIlIlIIlIIllIIIIlIl);
    }
    
    public void markChanged() {
        this.changed = true;
    }
    
    public List<ResourcePackListEntry> getSelectedResourcePacks() {
        return this.selectedResourcePacks;
    }
    
    public List<ResourcePackListEntry> getListContaining(final ResourcePackListEntry lllllllllllIllIlIlIIlIIllIIIIIIl) {
        return this.hasResourcePackEntry(lllllllllllIllIlIlIIlIIllIIIIIIl) ? this.selectedResourcePacks : this.availableResourcePacks;
    }
    
    @Override
    public void drawScreen(final int lllllllllllIllIlIlIIlIIlIlIIIlll, final int lllllllllllIllIlIlIIlIIlIlIIIllI, final float lllllllllllIllIlIlIIlIIlIlIIIlIl) {
        this.drawBackground(0);
        this.availableResourcePacksList.drawScreen(lllllllllllIllIlIlIIlIIlIlIIIlll, lllllllllllIllIlIlIIlIIlIlIIIllI, lllllllllllIllIlIlIIlIIlIlIIIlIl);
        this.selectedResourcePacksList.drawScreen(lllllllllllIllIlIlIIlIIlIlIIIlll, lllllllllllIllIlIlIIlIIlIlIIIllI, lllllllllllIllIlIlIIlIIlIlIIIlIl);
        this.drawCenteredString(this.fontRendererObj, I18n.format("resourcePack.title", new Object[0]), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRendererObj, I18n.format("resourcePack.folderInfo", new Object[0]), this.width / 2 - 77, this.height - 26, 8421504);
        super.drawScreen(lllllllllllIllIlIlIIlIIlIlIIIlll, lllllllllllIllIlIlIIlIIlIlIIIllI, lllllllllllIllIlIlIIlIIlIlIIIlIl);
    }
}
