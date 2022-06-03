// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.spectator;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiSpectator;
import net.minecraft.client.Minecraft;
import com.google.common.collect.Lists;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import com.google.common.base.MoreObjects;
import net.minecraft.client.gui.spectator.categories.SpectatorDetails;
import java.util.List;

public class SpectatorMenu
{
    private /* synthetic */ ISpectatorMenuView category;
    private final /* synthetic */ ISpectatorMenuRecipient listener;
    private /* synthetic */ int selectedSlot;
    private static final /* synthetic */ ISpectatorMenuObject SCROLL_RIGHT_DISABLED;
    private final /* synthetic */ List<SpectatorDetails> previousCategories;
    private static final /* synthetic */ ISpectatorMenuObject CLOSE_ITEM;
    private static final /* synthetic */ ISpectatorMenuObject SCROLL_RIGHT_ENABLED;
    public static final /* synthetic */ ISpectatorMenuObject EMPTY_SLOT;
    private static final /* synthetic */ ISpectatorMenuObject SCROLL_LEFT;
    private /* synthetic */ int page;
    
    static /* synthetic */ void access$1(final SpectatorMenu lllllllllllIIlIIlIIIIllIlIIIlIIl, final int lllllllllllIIlIIlIIIIllIlIIIlIII) {
        lllllllllllIIlIIlIIIIllIlIIIlIIl.page = lllllllllllIIlIIlIIIIllIlIIIlIII;
    }
    
    public ISpectatorMenuObject getSelectedItem() {
        return this.getItem(this.selectedSlot);
    }
    
    public ISpectatorMenuObject getItem(final int lllllllllllIIlIIlIIIIllIlIllIllI) {
        final int lllllllllllIIlIIlIIIIllIlIlllIII = lllllllllllIIlIIlIIIIllIlIllIllI + this.page * 6;
        if (this.page > 0 && lllllllllllIIlIIlIIIIllIlIllIllI == 0) {
            return SpectatorMenu.SCROLL_LEFT;
        }
        if (lllllllllllIIlIIlIIIIllIlIllIllI == 7) {
            return (lllllllllllIIlIIlIIIIllIlIlllIII < this.category.getItems().size()) ? SpectatorMenu.SCROLL_RIGHT_ENABLED : SpectatorMenu.SCROLL_RIGHT_DISABLED;
        }
        if (lllllllllllIIlIIlIIIIllIlIllIllI == 8) {
            return SpectatorMenu.CLOSE_ITEM;
        }
        return (ISpectatorMenuObject)((lllllllllllIIlIIlIIIIllIlIlllIII >= 0 && lllllllllllIIlIIlIIIIllIlIlllIII < this.category.getItems().size()) ? MoreObjects.firstNonNull((Object)this.category.getItems().get(lllllllllllIIlIIlIIIIllIlIlllIII), (Object)SpectatorMenu.EMPTY_SLOT) : SpectatorMenu.EMPTY_SLOT);
    }
    
    static {
        CLOSE_ITEM = new EndSpectatorObject(null);
        SCROLL_LEFT = new MoveMenuObject(-1, true);
        SCROLL_RIGHT_ENABLED = new MoveMenuObject(1, true);
        SCROLL_RIGHT_DISABLED = new MoveMenuObject(1, false);
        EMPTY_SLOT = new ISpectatorMenuObject() {
            @Override
            public boolean isEnabled() {
                return false;
            }
            
            @Override
            public ITextComponent getSpectatorName() {
                return new TextComponentString("");
            }
            
            @Override
            public void renderIcon(final float lllllllllllIllIllIIIIllllIIIlIII, final int lllllllllllIllIllIIIIllllIIIIlll) {
            }
            
            @Override
            public void selectItem(final SpectatorMenu lllllllllllIllIllIIIIllllIIIlIll) {
            }
        };
    }
    
    public List<ISpectatorMenuObject> getItems() {
        final List<ISpectatorMenuObject> lllllllllllIIlIIlIIIIllIlIllIIII = (List<ISpectatorMenuObject>)Lists.newArrayList();
        for (int lllllllllllIIlIIlIIIIllIlIlIllll = 0; lllllllllllIIlIIlIIIIllIlIlIllll <= 8; ++lllllllllllIIlIIlIIIIllIlIlIllll) {
            lllllllllllIIlIIlIIIIllIlIllIIII.add(this.getItem(lllllllllllIIlIIlIIIIllIlIlIllll));
        }
        return lllllllllllIIlIIlIIIIllIlIllIIII;
    }
    
    public void exit() {
        this.listener.onSpectatorMenuClosed(this);
    }
    
    public void selectSlot(final int lllllllllllIIlIIlIIIIllIlIIllllI) {
        final ISpectatorMenuObject lllllllllllIIlIIlIIIIllIlIlIIIII = this.getItem(lllllllllllIIlIIlIIIIllIlIIllllI);
        if (lllllllllllIIlIIlIIIIllIlIlIIIII != SpectatorMenu.EMPTY_SLOT) {
            if (this.selectedSlot == lllllllllllIIlIIlIIIIllIlIIllllI && lllllllllllIIlIIlIIIIllIlIlIIIII.isEnabled()) {
                lllllllllllIIlIIlIIIIllIlIlIIIII.selectItem(this);
            }
            else {
                this.selectedSlot = lllllllllllIIlIIlIIIIllIlIIllllI;
            }
        }
    }
    
    public int getSelectedSlot() {
        return this.selectedSlot;
    }
    
    public ISpectatorMenuView getSelectedCategory() {
        return this.category;
    }
    
    public SpectatorDetails getCurrentPage() {
        return new SpectatorDetails(this.category, this.getItems(), this.selectedSlot);
    }
    
    public void selectCategory(final ISpectatorMenuView lllllllllllIIlIIlIIIIllIlIIlIIll) {
        this.previousCategories.add(this.getCurrentPage());
        this.category = lllllllllllIIlIIlIIIIllIlIIlIIll;
        this.selectedSlot = -1;
        this.page = 0;
    }
    
    public SpectatorMenu(final ISpectatorMenuRecipient lllllllllllIIlIIlIIIIllIlIlllllI) {
        this.previousCategories = (List<SpectatorDetails>)Lists.newArrayList();
        this.category = new BaseSpectatorGroup();
        this.selectedSlot = -1;
        this.listener = lllllllllllIIlIIlIIIIllIlIlllllI;
    }
    
    static class MoveMenuObject implements ISpectatorMenuObject
    {
        private final /* synthetic */ boolean enabled;
        private final /* synthetic */ int direction;
        
        @Override
        public void selectItem(final SpectatorMenu llllllllllIlllIllllllIlIllllIlll) {
            SpectatorMenu.access$1(llllllllllIlllIllllllIlIllllIlll, llllllllllIlllIllllllIlIllllIlll.page + this.direction);
        }
        
        @Override
        public boolean isEnabled() {
            return this.enabled;
        }
        
        public MoveMenuObject(final int llllllllllIlllIllllllIlIlllllllI, final boolean llllllllllIlllIllllllIllIIIIIIII) {
            this.direction = llllllllllIlllIllllllIlIlllllllI;
            this.enabled = llllllllllIlllIllllllIllIIIIIIII;
        }
        
        @Override
        public void renderIcon(final float llllllllllIlllIllllllIlIllllIIIl, final int llllllllllIlllIllllllIlIllllIIII) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
            if (this.direction < 0) {
                Gui.drawModalRectWithCustomSizedTexture(0.0f, 0.0f, 144.0f, 0.0f, 16.0f, 16.0f, 256.0f, 256.0f);
            }
            else {
                Gui.drawModalRectWithCustomSizedTexture(0.0f, 0.0f, 160.0f, 0.0f, 16.0f, 16.0f, 256.0f, 256.0f);
            }
        }
        
        @Override
        public ITextComponent getSpectatorName() {
            return (this.direction < 0) ? new TextComponentTranslation("spectatorMenu.previous_page", new Object[0]) : new TextComponentTranslation("spectatorMenu.next_page", new Object[0]);
        }
    }
    
    static class EndSpectatorObject implements ISpectatorMenuObject
    {
        private EndSpectatorObject() {
        }
        
        @Override
        public void renderIcon(final float lllllllllllIIlIIlllIIllIlIlllIII, final int lllllllllllIIlIIlllIIllIlIllIlll) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
            Gui.drawModalRectWithCustomSizedTexture(0.0f, 0.0f, 128.0f, 0.0f, 16.0f, 16.0f, 256.0f, 256.0f);
        }
        
        @Override
        public ITextComponent getSpectatorName() {
            return new TextComponentTranslation("spectatorMenu.close", new Object[0]);
        }
        
        @Override
        public void selectItem(final SpectatorMenu lllllllllllIIlIIlllIIllIlIlllIll) {
            lllllllllllIIlIIlllIIllIlIlllIll.exit();
        }
        
        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
