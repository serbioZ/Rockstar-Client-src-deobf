// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNoCallback;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.gui.GuiListExtended;

public abstract class ResourcePackListEntry implements GuiListExtended.IGuiListEntry
{
    private static final /* synthetic */ ITextComponent INCOMPATIBLE;
    private static final /* synthetic */ ITextComponent INCOMPATIBLE_OLD;
    protected final /* synthetic */ GuiScreenResourcePacks resourcePacksGUI;
    protected final /* synthetic */ Minecraft mc;
    private static final /* synthetic */ ResourceLocation RESOURCE_PACKS_TEXTURE;
    private static final /* synthetic */ ITextComponent INCOMPATIBLE_NEW;
    
    protected boolean canMoveUp() {
        final List<ResourcePackListEntry> llllllllllIllllIlllllllllIllllIl = this.resourcePacksGUI.getListContaining(this);
        final int llllllllllIllllIlllllllllIllllII = llllllllllIllllIlllllllllIllllIl.indexOf(this);
        return llllllllllIllllIlllllllllIllllII > 0 && llllllllllIllllIlllllllllIllllIl.get(llllllllllIllllIlllllllllIllllII - 1).showHoverOverlay();
    }
    
    public ResourcePackListEntry(final GuiScreenResourcePacks llllllllllIllllIlllllllllllllIIl) {
        this.resourcePacksGUI = llllllllllIllllIlllllllllllllIIl;
        this.mc = Minecraft.getMinecraft();
    }
    
    protected boolean showHoverOverlay() {
        return true;
    }
    
    @Override
    public boolean mousePressed(final int llllllllllIllllIlllllllllIlIIlll, final int llllllllllIllllIlllllllllIlIIllI, final int llllllllllIllllIlllllllllIlIIlIl, final int llllllllllIllllIlllllllllIlIIlII, final int llllllllllIllllIlllllllllIIllIII, final int llllllllllIllllIlllllllllIlIIIlI) {
        if (this.showHoverOverlay() && llllllllllIllllIlllllllllIIllIII <= 32) {
            if (this.canMoveRight()) {
                this.resourcePacksGUI.markChanged();
                final int llllllllllIllllIlllllllllIlIIIIl = this.resourcePacksGUI.getSelectedResourcePacks().get(0).isServerPack() ? 1 : 0;
                final int llllllllllIllllIlllllllllIlIIIII = this.getResourcePackFormat();
                if (llllllllllIllllIlllllllllIlIIIII == 3) {
                    this.resourcePacksGUI.getListContaining(this).remove(this);
                    this.resourcePacksGUI.getSelectedResourcePacks().add(llllllllllIllllIlllllllllIlIIIIl, this);
                }
                else {
                    final String llllllllllIllllIlllllllllIIlllll = I18n.format("resourcePack.incompatible.confirm.title", new Object[0]);
                    final String llllllllllIllllIlllllllllIIllllI = I18n.format("resourcePack.incompatible.confirm." + ((llllllllllIllllIlllllllllIlIIIII > 3) ? "new" : "old"), new Object[0]);
                    this.mc.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
                        @Override
                        public void confirmClicked(final boolean lllllllllllIlIllIIIllllIIIlIIlII, final int lllllllllllIlIllIIIllllIIIlIIlll) {
                            final List<ResourcePackListEntry> lllllllllllIlIllIIIllllIIIlIIllI = ResourcePackListEntry.this.resourcePacksGUI.getListContaining(ResourcePackListEntry.this);
                            ResourcePackListEntry.this.mc.displayGuiScreen(ResourcePackListEntry.this.resourcePacksGUI);
                            if (lllllllllllIlIllIIIllllIIIlIIlII) {
                                lllllllllllIlIllIIIllllIIIlIIllI.remove(ResourcePackListEntry.this);
                                ResourcePackListEntry.this.resourcePacksGUI.getSelectedResourcePacks().add(llllllllllIllllIlllllllllIlIIIIl, ResourcePackListEntry.this);
                            }
                        }
                    }, llllllllllIllllIlllllllllIIlllll, llllllllllIllllIlllllllllIIllllI, 0));
                }
                return true;
            }
            if (llllllllllIllllIlllllllllIIllIII < 16 && this.canMoveLeft()) {
                this.resourcePacksGUI.getListContaining(this).remove(this);
                this.resourcePacksGUI.getAvailableResourcePacks().add(0, this);
                this.resourcePacksGUI.markChanged();
                return true;
            }
            if (llllllllllIllllIlllllllllIIllIII > 16 && llllllllllIllllIlllllllllIlIIIlI < 16 && this.canMoveUp()) {
                final List<ResourcePackListEntry> llllllllllIllllIlllllllllIIlllIl = this.resourcePacksGUI.getListContaining(this);
                final int llllllllllIllllIlllllllllIIlllII = llllllllllIllllIlllllllllIIlllIl.indexOf(this);
                llllllllllIllllIlllllllllIIlllIl.remove(this);
                llllllllllIllllIlllllllllIIlllIl.add(llllllllllIllllIlllllllllIIlllII - 1, this);
                this.resourcePacksGUI.markChanged();
                return true;
            }
            if (llllllllllIllllIlllllllllIIllIII > 16 && llllllllllIllllIlllllllllIlIIIlI > 16 && this.canMoveDown()) {
                final List<ResourcePackListEntry> llllllllllIllllIlllllllllIIllIll = this.resourcePacksGUI.getListContaining(this);
                final int llllllllllIllllIlllllllllIIllIlI = llllllllllIllllIlllllllllIIllIll.indexOf(this);
                llllllllllIllllIlllllllllIIllIll.remove(this);
                llllllllllIllllIlllllllllIIllIll.add(llllllllllIllllIlllllllllIIllIlI + 1, this);
                this.resourcePacksGUI.markChanged();
                return true;
            }
        }
        return false;
    }
    
    protected abstract String getResourcePackName();
    
    public boolean isServerPack() {
        return false;
    }
    
    protected abstract void bindResourcePackIcon();
    
    protected abstract String getResourcePackDescription();
    
    protected boolean canMoveLeft() {
        return this.resourcePacksGUI.hasResourcePackEntry(this);
    }
    
    static {
        RESOURCE_PACKS_TEXTURE = new ResourceLocation("textures/gui/resource_packs.png");
        INCOMPATIBLE = new TextComponentTranslation("resourcePack.incompatible", new Object[0]);
        INCOMPATIBLE_OLD = new TextComponentTranslation("resourcePack.incompatible.old", new Object[0]);
        INCOMPATIBLE_NEW = new TextComponentTranslation("resourcePack.incompatible.new", new Object[0]);
    }
    
    @Override
    public void func_192633_a(final int llllllllllIllllIlllllllllIIlIIIl, final int llllllllllIllllIlllllllllIIlIIII, final int llllllllllIllllIlllllllllIIIllll, final float llllllllllIllllIlllllllllIIIlllI) {
    }
    
    protected boolean canMoveDown() {
        final List<ResourcePackListEntry> llllllllllIllllIlllllllllIllIlII = this.resourcePacksGUI.getListContaining(this);
        final int llllllllllIllllIlllllllllIllIIll = llllllllllIllllIlllllllllIllIlII.indexOf(this);
        return llllllllllIllllIlllllllllIllIIll >= 0 && llllllllllIllllIlllllllllIllIIll < llllllllllIllllIlllllllllIllIlII.size() - 1 && llllllllllIllllIlllllllllIllIlII.get(llllllllllIllllIlllllllllIllIIll + 1).showHoverOverlay();
    }
    
    protected boolean canMoveRight() {
        return !this.resourcePacksGUI.hasResourcePackEntry(this);
    }
    
    protected abstract int getResourcePackFormat();
    
    @Override
    public void mouseReleased(final int llllllllllIllllIlllllllllIIIllII, final int llllllllllIllllIlllllllllIIIlIll, final int llllllllllIllllIlllllllllIIIlIlI, final int llllllllllIllllIlllllllllIIIlIIl, final int llllllllllIllllIlllllllllIIIlIII, final int llllllllllIllllIlllllllllIIIIlll) {
    }
    
    @Override
    public void func_192634_a(final int llllllllllIllllIlllllllllllIIlll, final int llllllllllIllllIllllllllllIlIlIl, final int llllllllllIllllIllllllllllIlIlII, final int llllllllllIllllIllllllllllIlIIll, final int llllllllllIllllIlllllllllllIIIll, final int llllllllllIllllIllllllllllIlIIIl, final int llllllllllIllllIllllllllllIlIIII, final boolean llllllllllIllllIlllllllllllIIIII, final float llllllllllIllllIllllllllllIlllll) {
        final int llllllllllIllllIllllllllllIllllI = this.getResourcePackFormat();
        if (llllllllllIllllIllllllllllIllllI != 3) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            Gui.drawRect(llllllllllIllllIllllllllllIlIlIl - 1, llllllllllIllllIllllllllllIlIlII - 1, llllllllllIllllIllllllllllIlIlIl + llllllllllIllllIllllllllllIlIIll - 9, llllllllllIllllIllllllllllIlIlII + llllllllllIllllIlllllllllllIIIll + 1, -8978432);
        }
        this.bindResourcePackIcon();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Gui.drawModalRectWithCustomSizedTexture((float)llllllllllIllllIllllllllllIlIlIl, (float)llllllllllIllllIllllllllllIlIlII, 0.0f, 0.0f, 32.0f, 32.0f, 32.0f, 32.0f);
        String llllllllllIllllIllllllllllIlllIl = this.getResourcePackName();
        String llllllllllIllllIllllllllllIlllII = this.getResourcePackDescription();
        if (this.showHoverOverlay() && (this.mc.gameSettings.touchscreen || llllllllllIllllIlllllllllllIIIII)) {
            this.mc.getTextureManager().bindTexture(ResourcePackListEntry.RESOURCE_PACKS_TEXTURE);
            Gui.drawRect(llllllllllIllllIllllllllllIlIlIl, llllllllllIllllIllllllllllIlIlII, llllllllllIllllIllllllllllIlIlIl + 32, llllllllllIllllIllllllllllIlIlII + 32, -1601138544);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int llllllllllIllllIllllllllllIllIll = llllllllllIllllIllllllllllIlIIIl - llllllllllIllllIllllllllllIlIlIl;
            final int llllllllllIllllIllllllllllIllIlI = llllllllllIllllIllllllllllIlIIII - llllllllllIllllIllllllllllIlIlII;
            if (llllllllllIllllIllllllllllIllllI < 3) {
                llllllllllIllllIllllllllllIlllIl = ResourcePackListEntry.INCOMPATIBLE.getFormattedText();
                llllllllllIllllIllllllllllIlllII = ResourcePackListEntry.INCOMPATIBLE_OLD.getFormattedText();
            }
            else if (llllllllllIllllIllllllllllIllllI > 3) {
                llllllllllIllllIllllllllllIlllIl = ResourcePackListEntry.INCOMPATIBLE.getFormattedText();
                llllllllllIllllIllllllllllIlllII = ResourcePackListEntry.INCOMPATIBLE_NEW.getFormattedText();
            }
            if (this.canMoveRight()) {
                if (llllllllllIllllIllllllllllIllIll < 32) {
                    Gui.drawModalRectWithCustomSizedTexture((float)llllllllllIllllIllllllllllIlIlIl, (float)llllllllllIllllIllllllllllIlIlII, 0.0f, 32.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture((float)llllllllllIllllIllllllllllIlIlIl, (float)llllllllllIllllIllllllllllIlIlII, 0.0f, 0.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                }
            }
            else {
                if (this.canMoveLeft()) {
                    if (llllllllllIllllIllllllllllIllIll < 16) {
                        Gui.drawModalRectWithCustomSizedTexture((float)llllllllllIllllIllllllllllIlIlIl, (float)llllllllllIllllIllllllllllIlIlII, 32.0f, 32.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                    }
                    else {
                        Gui.drawModalRectWithCustomSizedTexture((float)llllllllllIllllIllllllllllIlIlIl, (float)llllllllllIllllIllllllllllIlIlII, 32.0f, 0.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                    }
                }
                if (this.canMoveUp()) {
                    if (llllllllllIllllIllllllllllIllIll < 32 && llllllllllIllllIllllllllllIllIll > 16 && llllllllllIllllIllllllllllIllIlI < 16) {
                        Gui.drawModalRectWithCustomSizedTexture((float)llllllllllIllllIllllllllllIlIlIl, (float)llllllllllIllllIllllllllllIlIlII, 96.0f, 32.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                    }
                    else {
                        Gui.drawModalRectWithCustomSizedTexture((float)llllllllllIllllIllllllllllIlIlIl, (float)llllllllllIllllIllllllllllIlIlII, 96.0f, 0.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                    }
                }
                if (this.canMoveDown()) {
                    if (llllllllllIllllIllllllllllIllIll < 32 && llllllllllIllllIllllllllllIllIll > 16 && llllllllllIllllIllllllllllIllIlI > 16) {
                        Gui.drawModalRectWithCustomSizedTexture((float)llllllllllIllllIllllllllllIlIlIl, (float)llllllllllIllllIllllllllllIlIlII, 64.0f, 32.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                    }
                    else {
                        Gui.drawModalRectWithCustomSizedTexture((float)llllllllllIllllIllllllllllIlIlIl, (float)llllllllllIllllIllllllllllIlIlII, 64.0f, 0.0f, 32.0f, 32.0f, 256.0f, 256.0f);
                    }
                }
            }
        }
        final int llllllllllIllllIllllllllllIllIIl = Minecraft.fontRendererObj.getStringWidth(llllllllllIllllIllllllllllIlllIl);
        if (llllllllllIllllIllllllllllIllIIl > 157) {
            llllllllllIllllIllllllllllIlllIl = String.valueOf(Minecraft.fontRendererObj.trimStringToWidth(llllllllllIllllIllllllllllIlllIl, 157 - Minecraft.fontRendererObj.getStringWidth("..."))) + "...";
        }
        Minecraft.fontRendererObj.drawStringWithShadow(llllllllllIllllIllllllllllIlllIl, (float)(llllllllllIllllIllllllllllIlIlIl + 32 + 2), (float)(llllllllllIllllIllllllllllIlIlII + 1), 16777215);
        final List<String> llllllllllIllllIllllllllllIllIII = Minecraft.fontRendererObj.listFormattedStringToWidth(llllllllllIllllIllllllllllIlllII, 157);
        for (int llllllllllIllllIllllllllllIlIlll = 0; llllllllllIllllIllllllllllIlIlll < 2 && llllllllllIllllIllllllllllIlIlll < llllllllllIllllIllllllllllIllIII.size(); ++llllllllllIllllIllllllllllIlIlll) {
            Minecraft.fontRendererObj.drawStringWithShadow(llllllllllIllllIllllllllllIllIII.get(llllllllllIllllIllllllllllIlIlll), (float)(llllllllllIllllIllllllllllIlIlIl + 32 + 2), (float)(llllllllllIllllIllllllllllIlIlII + 12 + 10 * llllllllllIllllIllllllllllIlIlll), 8421504);
        }
    }
}
