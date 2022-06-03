// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import com.google.common.base.MoreObjects;
import com.google.common.base.Predicates;
import com.google.common.base.Predicate;
import javax.annotation.Nullable;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IntHashMap;
import java.util.List;

public class GuiPageButtonList extends GuiListExtended
{
    private final /* synthetic */ List<GuiEntry> entries;
    private final /* synthetic */ GuiResponder responder;
    private /* synthetic */ int page;
    private /* synthetic */ Gui focusedControl;
    private final /* synthetic */ IntHashMap<Gui> componentMap;
    private final /* synthetic */ GuiListEntry[][] pages;
    private final /* synthetic */ List<GuiTextField> editBoxes;
    
    public int getSize() {
        return this.entries.size();
    }
    
    private GuiListButton createButton(final int lllllllllllIIIllIIlllllllllIIllI, final int lllllllllllIIIllIIlllllllllIIIII, final GuiButtonEntry lllllllllllIIIllIIlllllllllIIlII) {
        final GuiListButton lllllllllllIIIllIIlllllllllIIIll = new GuiListButton(this.responder, lllllllllllIIIllIIlllllllllIIlII.getId(), lllllllllllIIIllIIlllllllllIIllI, lllllllllllIIIllIIlllllllllIIIII, lllllllllllIIIllIIlllllllllIIlII.getCaption(), lllllllllllIIIllIIlllllllllIIlII.getInitialValue());
        lllllllllllIIIllIIlllllllllIIIll.visible = lllllllllllIIIllIIlllllllllIIlII.shouldStartVisible();
        return lllllllllllIIIllIIlllllllllIIIll;
    }
    
    public void previousPage() {
        if (this.page > 0) {
            this.setPage(this.page - 1);
        }
    }
    
    public Gui getComponent(final int lllllllllllIIIllIlIIIIIIIlIIIlII) {
        return this.componentMap.lookup(lllllllllllIIIllIlIIIIIIIlIIIlII);
    }
    
    public GuiPageButtonList(final Minecraft lllllllllllIIIllIlIIIIIIlIlIIIll, final int lllllllllllIIIllIlIIIIIIlIlIIIlI, final int lllllllllllIIIllIlIIIIIIlIlIIIIl, final int lllllllllllIIIllIlIIIIIIlIIlIlll, final int lllllllllllIIIllIlIIIIIIlIIlIllI, final int lllllllllllIIIllIlIIIIIIlIIllllI, final GuiResponder lllllllllllIIIllIlIIIIIIlIIlIlII, final GuiListEntry[]... lllllllllllIIIllIlIIIIIIlIIlllII) {
        super(lllllllllllIIIllIlIIIIIIlIlIIIll, lllllllllllIIIllIlIIIIIIlIlIIIlI, lllllllllllIIIllIlIIIIIIlIlIIIIl, lllllllllllIIIllIlIIIIIIlIIlIlll, lllllllllllIIIllIlIIIIIIlIIlIllI, lllllllllllIIIllIlIIIIIIlIIllllI);
        this.entries = (List<GuiEntry>)Lists.newArrayList();
        this.componentMap = new IntHashMap<Gui>();
        this.editBoxes = (List<GuiTextField>)Lists.newArrayList();
        this.responder = lllllllllllIIIllIlIIIIIIlIIlIlII;
        this.pages = lllllllllllIIIllIlIIIIIIlIIlllII;
        this.centerListVertically = false;
        this.populateComponents();
        this.populateEntries();
    }
    
    private void setComponentVisibility(final Gui lllllllllllIIIllIlIIIIIIIIlIlIll, final boolean lllllllllllIIIllIlIIIIIIIIlIlIlI) {
        if (lllllllllllIIIllIlIIIIIIIIlIlIll instanceof GuiButton) {
            ((GuiButton)lllllllllllIIIllIlIIIIIIIIlIlIll).visible = lllllllllllIIIllIlIIIIIIIIlIlIlI;
        }
        else if (lllllllllllIIIllIlIIIIIIIIlIlIll instanceof GuiTextField) {
            ((GuiTextField)lllllllllllIIIllIlIIIIIIIIlIlIll).setVisible(lllllllllllIIIllIlIIIIIIIIlIlIlI);
        }
        else if (lllllllllllIIIllIlIIIIIIIIlIlIll instanceof GuiLabel) {
            ((GuiLabel)lllllllllllIIIllIlIIIIIIIIlIlIll).visible = lllllllllllIIIllIlIIIIIIIIlIlIlI;
        }
    }
    
    @Override
    public boolean mouseClicked(final int lllllllllllIIIllIlIIIIIIIIIIIIIl, final int lllllllllllIIIllIlIIIIIIIIIIIlll, final int lllllllllllIIIllIlIIIIIIIIIIIllI) {
        final boolean lllllllllllIIIllIlIIIIIIIIIIIlIl = super.mouseClicked(lllllllllllIIIllIlIIIIIIIIIIIIIl, lllllllllllIIIllIlIIIIIIIIIIIlll, lllllllllllIIIllIlIIIIIIIIIIIllI);
        final int lllllllllllIIIllIlIIIIIIIIIIIlII = this.getSlotIndexFromScreenCoords(lllllllllllIIIllIlIIIIIIIIIIIIIl, lllllllllllIIIllIlIIIIIIIIIIIlll);
        if (lllllllllllIIIllIlIIIIIIIIIIIlII >= 0) {
            final GuiEntry lllllllllllIIIllIlIIIIIIIIIIIIll = this.getListEntry(lllllllllllIIIllIlIIIIIIIIIIIlII);
            if (this.focusedControl != lllllllllllIIIllIlIIIIIIIIIIIIll.focusedControl && this.focusedControl != null && this.focusedControl instanceof GuiTextField) {
                ((GuiTextField)this.focusedControl).setFocused(false);
            }
            this.focusedControl = lllllllllllIIIllIlIIIIIIIIIIIIll.focusedControl;
        }
        return lllllllllllIIIllIlIIIIIIIIIIIlIl;
    }
    
    public void setPage(final int lllllllllllIIIllIlIIIIIIIlIllIll) {
        if (lllllllllllIIIllIlIIIIIIIlIllIll != this.page) {
            final int lllllllllllIIIllIlIIIIIIIlIllIlI = this.page;
            this.page = lllllllllllIIIllIlIIIIIIIlIllIll;
            this.populateEntries();
            this.markVisibility(lllllllllllIIIllIlIIIIIIIlIllIlI, lllllllllllIIIllIlIIIIIIIlIllIll);
            this.amountScrolled = 0.0f;
        }
    }
    
    public void setActive(final boolean lllllllllllIIIllIlIIIIIIIIIlIllI) {
        for (final GuiEntry lllllllllllIIIllIlIIIIIIIIIlIlIl : this.entries) {
            if (lllllllllllIIIllIlIIIIIIIIIlIlIl.component1 instanceof GuiButton) {
                ((GuiButton)lllllllllllIIIllIlIIIIIIIIIlIlIl.component1).enabled = lllllllllllIIIllIlIIIIIIIIIlIllI;
            }
            if (lllllllllllIIIllIlIIIIIIIIIlIlIl.component2 instanceof GuiButton) {
                ((GuiButton)lllllllllllIIIllIlIIIIIIIIIlIlIl.component2).enabled = lllllllllllIIIllIlIIIIIIIIIlIllI;
            }
        }
    }
    
    private GuiTextField createTextField(final int lllllllllllIIIllIIllllllllIlIIlI, final int lllllllllllIIIllIIllllllllIlIllI, final EditBoxEntry lllllllllllIIIllIIllllllllIlIIII) {
        final GuiTextField lllllllllllIIIllIIllllllllIlIlII = new GuiTextField(lllllllllllIIIllIIllllllllIlIIII.getId(), Minecraft.fontRendererObj, lllllllllllIIIllIIllllllllIlIIlI, lllllllllllIIIllIIllllllllIlIllI, 150, 20);
        lllllllllllIIIllIIllllllllIlIlII.setText(lllllllllllIIIllIIllllllllIlIIII.getCaption());
        lllllllllllIIIllIIllllllllIlIlII.setGuiResponder(this.responder);
        lllllllllllIIIllIIllllllllIlIlII.setVisible(lllllllllllIIIllIIllllllllIlIIII.shouldStartVisible());
        lllllllllllIIIllIIllllllllIlIlII.setValidator(lllllllllllIIIllIIllllllllIlIIII.getFilter());
        return lllllllllllIIIllIIllllllllIlIlII;
    }
    
    public void onKeyPressed(final char lllllllllllIIIllIIlllllllIlIllIl, final int lllllllllllIIIllIIlllllllIIlllll) {
        if (this.focusedControl instanceof GuiTextField) {
            GuiTextField lllllllllllIIIllIIlllllllIlIlIll = (GuiTextField)this.focusedControl;
            if (!GuiScreen.isKeyComboCtrlV(lllllllllllIIIllIIlllllllIIlllll)) {
                if (lllllllllllIIIllIIlllllllIIlllll == 15) {
                    lllllllllllIIIllIIlllllllIlIlIll.setFocused(false);
                    int lllllllllllIIIllIIlllllllIlIlIlI = this.editBoxes.indexOf(this.focusedControl);
                    if (GuiScreen.isShiftKeyDown()) {
                        if (lllllllllllIIIllIIlllllllIlIlIlI == 0) {
                            lllllllllllIIIllIIlllllllIlIlIlI = this.editBoxes.size() - 1;
                        }
                        else {
                            --lllllllllllIIIllIIlllllllIlIlIlI;
                        }
                    }
                    else if (lllllllllllIIIllIIlllllllIlIlIlI == this.editBoxes.size() - 1) {
                        lllllllllllIIIllIIlllllllIlIlIlI = 0;
                    }
                    else {
                        ++lllllllllllIIIllIIlllllllIlIlIlI;
                    }
                    this.focusedControl = this.editBoxes.get(lllllllllllIIIllIIlllllllIlIlIlI);
                    lllllllllllIIIllIIlllllllIlIlIll = (GuiTextField)this.focusedControl;
                    lllllllllllIIIllIIlllllllIlIlIll.setFocused(true);
                    final int lllllllllllIIIllIIlllllllIlIlIIl = lllllllllllIIIllIIlllllllIlIlIll.yPosition + this.slotHeight;
                    final int lllllllllllIIIllIIlllllllIlIlIII = lllllllllllIIIllIIlllllllIlIlIll.yPosition;
                    if (lllllllllllIIIllIIlllllllIlIlIIl > this.bottom) {
                        this.amountScrolled += lllllllllllIIIllIIlllllllIlIlIIl - this.bottom;
                    }
                    else if (lllllllllllIIIllIIlllllllIlIlIII < this.top) {
                        this.amountScrolled = (float)lllllllllllIIIllIIlllllllIlIlIII;
                    }
                }
                else {
                    lllllllllllIIIllIIlllllllIlIlIll.textboxKeyTyped(lllllllllllIIIllIIlllllllIlIllIl, lllllllllllIIIllIIlllllllIIlllll);
                }
            }
            else {
                final String lllllllllllIIIllIIlllllllIlIIlll = GuiScreen.getClipboardString();
                final String[] lllllllllllIIIllIIlllllllIlIIllI = lllllllllllIIIllIIlllllllIlIIlll.split(";");
                int lllllllllllIIIllIIlllllllIlIIlII;
                final int lllllllllllIIIllIIlllllllIlIIlIl = lllllllllllIIIllIIlllllllIlIIlII = this.editBoxes.indexOf(this.focusedControl);
                final float lllllllllllIIIllIIlllllllIIlIllI;
                final byte lllllllllllIIIllIIlllllllIIlIlll = (byte)((String[])(Object)(lllllllllllIIIllIIlllllllIIlIllI = (float)(Object)lllllllllllIIIllIIlllllllIlIIllI)).length;
                for (Exception lllllllllllIIIllIIlllllllIIllIII = (Exception)0; lllllllllllIIIllIIlllllllIIllIII < lllllllllllIIIllIIlllllllIIlIlll; ++lllllllllllIIIllIIlllllllIIllIII) {
                    final String lllllllllllIIIllIIlllllllIlIIIll = lllllllllllIIIllIIlllllllIIlIllI[lllllllllllIIIllIIlllllllIIllIII];
                    final GuiTextField lllllllllllIIIllIIlllllllIlIIIlI = this.editBoxes.get(lllllllllllIIIllIIlllllllIlIIlII);
                    lllllllllllIIIllIIlllllllIlIIIlI.setText(lllllllllllIIIllIIlllllllIlIIIll);
                    lllllllllllIIIllIIlllllllIlIIIlI.func_190516_a(lllllllllllIIIllIIlllllllIlIIIlI.getId(), lllllllllllIIIllIIlllllllIlIIIll);
                    if (lllllllllllIIIllIIlllllllIlIIlII == this.editBoxes.size() - 1) {
                        lllllllllllIIIllIIlllllllIlIIlII = 0;
                    }
                    else {
                        ++lllllllllllIIIllIIlllllllIlIIlII;
                    }
                    if (lllllllllllIIIllIIlllllllIlIIlII == lllllllllllIIIllIIlllllllIlIIlIl) {
                        break;
                    }
                }
            }
        }
    }
    
    public int getPageCount() {
        return this.pages.length;
    }
    
    private void populateEntries() {
        this.entries.clear();
        for (int lllllllllllIIIllIlIIIIIIIllIllII = 0; lllllllllllIIIllIlIIIIIIIllIllII < this.pages[this.page].length; lllllllllllIIIllIlIIIIIIIllIllII += 2) {
            final GuiListEntry lllllllllllIIIllIlIIIIIIIllIlIll = this.pages[this.page][lllllllllllIIIllIlIIIIIIIllIllII];
            final GuiListEntry lllllllllllIIIllIlIIIIIIIllIlIlI = (lllllllllllIIIllIlIIIIIIIllIllII < this.pages[this.page].length - 1) ? this.pages[this.page][lllllllllllIIIllIlIIIIIIIllIllII + 1] : null;
            final Gui lllllllllllIIIllIlIIIIIIIllIlIIl = this.componentMap.lookup(lllllllllllIIIllIlIIIIIIIllIlIll.getId());
            final Gui lllllllllllIIIllIlIIIIIIIllIlIII = (lllllllllllIIIllIlIIIIIIIllIlIlI != null) ? this.componentMap.lookup(lllllllllllIIIllIlIIIIIIIllIlIlI.getId()) : null;
            final GuiEntry lllllllllllIIIllIlIIIIIIIllIIlll = new GuiEntry(lllllllllllIIIllIlIIIIIIIllIlIIl, lllllllllllIIIllIlIIIIIIIllIlIII);
            this.entries.add(lllllllllllIIIllIlIIIIIIIllIIlll);
        }
    }
    
    @Nullable
    private Gui createEntry(@Nullable final GuiListEntry lllllllllllIIIllIlIIIIIIIIIllllI, final int lllllllllllIIIllIlIIIIIIIIIlllIl, final boolean lllllllllllIIIllIlIIIIIIIIIlllII) {
        if (lllllllllllIIIllIlIIIIIIIIIllllI instanceof GuiSlideEntry) {
            return this.createSlider(this.width / 2 - 155 + lllllllllllIIIllIlIIIIIIIIIlllIl, 0, (GuiSlideEntry)lllllllllllIIIllIlIIIIIIIIIllllI);
        }
        if (lllllllllllIIIllIlIIIIIIIIIllllI instanceof GuiButtonEntry) {
            return this.createButton(this.width / 2 - 155 + lllllllllllIIIllIlIIIIIIIIIlllIl, 0, (GuiButtonEntry)lllllllllllIIIllIlIIIIIIIIIllllI);
        }
        if (lllllllllllIIIllIlIIIIIIIIIllllI instanceof EditBoxEntry) {
            return this.createTextField(this.width / 2 - 155 + lllllllllllIIIllIlIIIIIIIIIlllIl, 0, (EditBoxEntry)lllllllllllIIIllIlIIIIIIIIIllllI);
        }
        return (lllllllllllIIIllIlIIIIIIIIIllllI instanceof GuiLabelEntry) ? this.createLabel(this.width / 2 - 155 + lllllllllllIIIllIlIIIIIIIIIlllIl, 0, (GuiLabelEntry)lllllllllllIIIllIlIIIIIIIIIllllI, lllllllllllIIIllIlIIIIIIIIIlllII) : null;
    }
    
    private void populateComponents() {
        final int lllllllllllIIIllIlIIIIIIIllllIll;
        final float lllllllllllIIIllIlIIIIIIIlllllII = ((GuiListEntry[][])(Object)(lllllllllllIIIllIlIIIIIIIllllIll = (int)(Object)this.pages)).length;
        for (final GuiListEntry[] lllllllllllIIIllIlIIIIIIlIIIIllI : lllllllllllIIIllIlIIIIIIIllllIll) {
            for (int lllllllllllIIIllIlIIIIIIlIIIIlIl = 0; lllllllllllIIIllIlIIIIIIlIIIIlIl < lllllllllllIIIllIlIIIIIIlIIIIllI.length; lllllllllllIIIllIlIIIIIIlIIIIlIl += 2) {
                final GuiListEntry lllllllllllIIIllIlIIIIIIlIIIIlII = lllllllllllIIIllIlIIIIIIlIIIIllI[lllllllllllIIIllIlIIIIIIlIIIIlIl];
                final GuiListEntry lllllllllllIIIllIlIIIIIIlIIIIIll = (lllllllllllIIIllIlIIIIIIlIIIIlIl < lllllllllllIIIllIlIIIIIIlIIIIllI.length - 1) ? lllllllllllIIIllIlIIIIIIlIIIIllI[lllllllllllIIIllIlIIIIIIlIIIIlIl + 1] : null;
                final Gui lllllllllllIIIllIlIIIIIIlIIIIIlI = this.createEntry(lllllllllllIIIllIlIIIIIIlIIIIlII, 0, lllllllllllIIIllIlIIIIIIlIIIIIll == null);
                final Gui lllllllllllIIIllIlIIIIIIlIIIIIIl = this.createEntry(lllllllllllIIIllIlIIIIIIlIIIIIll, 160, lllllllllllIIIllIlIIIIIIlIIIIlII == null);
                final GuiEntry lllllllllllIIIllIlIIIIIIlIIIIIII = new GuiEntry(lllllllllllIIIllIlIIIIIIlIIIIIlI, lllllllllllIIIllIlIIIIIIlIIIIIIl);
                this.entries.add(lllllllllllIIIllIlIIIIIIlIIIIIII);
                if (lllllllllllIIIllIlIIIIIIlIIIIlII != null && lllllllllllIIIllIlIIIIIIlIIIIIlI != null) {
                    this.componentMap.addKey(lllllllllllIIIllIlIIIIIIlIIIIlII.getId(), lllllllllllIIIllIlIIIIIIlIIIIIlI);
                    if (lllllllllllIIIllIlIIIIIIlIIIIIlI instanceof GuiTextField) {
                        this.editBoxes.add((GuiTextField)lllllllllllIIIllIlIIIIIIlIIIIIlI);
                    }
                }
                if (lllllllllllIIIllIlIIIIIIlIIIIIll != null && lllllllllllIIIllIlIIIIIIlIIIIIIl != null) {
                    this.componentMap.addKey(lllllllllllIIIllIlIIIIIIlIIIIIll.getId(), lllllllllllIIIllIlIIIIIIlIIIIIIl);
                    if (lllllllllllIIIllIlIIIIIIlIIIIIIl instanceof GuiTextField) {
                        this.editBoxes.add((GuiTextField)lllllllllllIIIllIlIIIIIIlIIIIIIl);
                    }
                }
            }
        }
    }
    
    @Override
    public int getListWidth() {
        return 400;
    }
    
    public Gui getFocusedControl() {
        return this.focusedControl;
    }
    
    public void nextPage() {
        if (this.page < this.pages.length - 1) {
            this.setPage(this.page + 1);
        }
    }
    
    private void markVisibility(final int lllllllllllIIIllIlIIIIIIIIllIlII, final int lllllllllllIIIllIlIIIIIIIIllIIll) {
        boolean lllllllllllIIIllIlIIIIIIIIlIllll;
        char lllllllllllIIIllIlIIIIIIIIllIIII = (char)((GuiListEntry[])(Object)(lllllllllllIIIllIlIIIIIIIIlIllll = (boolean)(Object)this.pages[lllllllllllIIIllIlIIIIIIIIllIlII])).length;
        for (boolean lllllllllllIIIllIlIIIIIIIIllIIIl = false; (lllllllllllIIIllIlIIIIIIIIllIIIl ? 1 : 0) < lllllllllllIIIllIlIIIIIIIIllIIII; ++lllllllllllIIIllIlIIIIIIIIllIIIl) {
            final GuiListEntry lllllllllllIIIllIlIIIIIIIIllIlll = lllllllllllIIIllIlIIIIIIIIlIllll[lllllllllllIIIllIlIIIIIIIIllIIIl];
            if (lllllllllllIIIllIlIIIIIIIIllIlll != null) {
                this.setComponentVisibility(this.componentMap.lookup(lllllllllllIIIllIlIIIIIIIIllIlll.getId()), false);
            }
        }
        lllllllllllIIIllIlIIIIIIIIllIIII = (char)((GuiListEntry[])(Object)(lllllllllllIIIllIlIIIIIIIIlIllll = (boolean)(Object)this.pages[lllllllllllIIIllIlIIIIIIIIllIIll])).length;
        for (boolean lllllllllllIIIllIlIIIIIIIIllIIIl = 0 != 0; (lllllllllllIIIllIlIIIIIIIIllIIIl ? 1 : 0) < lllllllllllIIIllIlIIIIIIIIllIIII; ++lllllllllllIIIllIlIIIIIIIIllIIIl) {
            final GuiListEntry lllllllllllIIIllIlIIIIIIIIllIllI = lllllllllllIIIllIlIIIIIIIIlIllll[lllllllllllIIIllIlIIIIIIIIllIIIl];
            if (lllllllllllIIIllIlIIIIIIIIllIllI != null) {
                this.setComponentVisibility(this.componentMap.lookup(lllllllllllIIIllIlIIIIIIIIllIllI.getId()), true);
            }
        }
    }
    
    @Override
    public GuiEntry getListEntry(final int lllllllllllIIIllIIlllllllIIlIIIl) {
        return this.entries.get(lllllllllllIIIllIIlllllllIIlIIIl);
    }
    
    private GuiSlider createSlider(final int lllllllllllIIIllIIllllllllllIIII, final int lllllllllllIIIllIIlllllllllIllll, final GuiSlideEntry lllllllllllIIIllIIllllllllllIIll) {
        final GuiSlider lllllllllllIIIllIIllllllllllIIlI = new GuiSlider(this.responder, lllllllllllIIIllIIllllllllllIIll.getId(), lllllllllllIIIllIIllllllllllIIII, lllllllllllIIIllIIlllllllllIllll, lllllllllllIIIllIIllllllllllIIll.getCaption(), lllllllllllIIIllIIllllllllllIIll.getMinValue(), lllllllllllIIIllIIllllllllllIIll.getMaxValue(), lllllllllllIIIllIIllllllllllIIll.getInitalValue(), lllllllllllIIIllIIllllllllllIIll.getFormatter());
        lllllllllllIIIllIIllllllllllIIlI.visible = lllllllllllIIIllIIllllllllllIIll.shouldStartVisible();
        return lllllllllllIIIllIIllllllllllIIlI;
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 32;
    }
    
    public int getPage() {
        return this.page;
    }
    
    private GuiLabel createLabel(final int lllllllllllIIIllIIllllllllIIIIII, final int lllllllllllIIIllIIlllllllIllllll, final GuiLabelEntry lllllllllllIIIllIIlllllllIlllllI, final boolean lllllllllllIIIllIIlllllllIllllIl) {
        GuiLabel lllllllllllIIIllIIllllllllIIIIlI = null;
        if (lllllllllllIIIllIIlllllllIllllIl) {
            final GuiLabel lllllllllllIIIllIIllllllllIIIIll = new GuiLabel(Minecraft.fontRendererObj, lllllllllllIIIllIIlllllllIlllllI.getId(), lllllllllllIIIllIIllllllllIIIIII, lllllllllllIIIllIIlllllllIllllll, this.width - lllllllllllIIIllIIllllllllIIIIII * 2, 20, -1);
        }
        else {
            lllllllllllIIIllIIllllllllIIIIlI = new GuiLabel(Minecraft.fontRendererObj, lllllllllllIIIllIIlllllllIlllllI.getId(), lllllllllllIIIllIIllllllllIIIIII, lllllllllllIIIllIIlllllllIllllll, 150, 20, -1);
        }
        lllllllllllIIIllIIllllllllIIIIlI.visible = lllllllllllIIIllIIlllllllIlllllI.shouldStartVisible();
        lllllllllllIIIllIIllllllllIIIIlI.addLine(lllllllllllIIIllIIlllllllIlllllI.getCaption());
        lllllllllllIIIllIIllllllllIIIIlI.setCentered();
        return lllllllllllIIIllIIllllllllIIIIlI;
    }
    
    public interface GuiResponder
    {
        void setEntryValue(final int p0, final boolean p1);
        
        void setEntryValue(final int p0, final float p1);
        
        void setEntryValue(final int p0, final String p1);
    }
    
    public static class GuiSlideEntry extends GuiListEntry
    {
        private final /* synthetic */ float maxValue;
        private final /* synthetic */ float minValue;
        private final /* synthetic */ float initialValue;
        private final /* synthetic */ GuiSlider.FormatHelper formatter;
        
        public float getMinValue() {
            return this.minValue;
        }
        
        public float getInitalValue() {
            return this.initialValue;
        }
        
        public GuiSlider.FormatHelper getFormatter() {
            return this.formatter;
        }
        
        public float getMaxValue() {
            return this.maxValue;
        }
        
        public GuiSlideEntry(final int llllllllllllIlIlIlIIllIIIIIIIIII, final String llllllllllllIlIlIlIIlIllllllllll, final boolean llllllllllllIlIlIlIIlIlllllllllI, final GuiSlider.FormatHelper llllllllllllIlIlIlIIllIIIIIIIlIl, final float llllllllllllIlIlIlIIllIIIIIIIlII, final float llllllllllllIlIlIlIIllIIIIIIIIll, final float llllllllllllIlIlIlIIllIIIIIIIIlI) {
            super(llllllllllllIlIlIlIIllIIIIIIIIII, llllllllllllIlIlIlIIlIllllllllll, llllllllllllIlIlIlIIlIlllllllllI);
            this.formatter = llllllllllllIlIlIlIIllIIIIIIIlIl;
            this.minValue = llllllllllllIlIlIlIIllIIIIIIIlII;
            this.maxValue = llllllllllllIlIlIlIIllIIIIIIIIll;
            this.initialValue = llllllllllllIlIlIlIIllIIIIIIIIlI;
        }
    }
    
    public static class GuiEntry implements IGuiListEntry
    {
        private final /* synthetic */ Minecraft client;
        private final /* synthetic */ Gui component2;
        private final /* synthetic */ Gui component1;
        private /* synthetic */ Gui focusedControl;
        
        private void renderTextField(final GuiTextField lllllllllllIIllIlIlIIIlIlIlIIlll, final int lllllllllllIIllIlIlIIIlIlIlIIIll, final boolean lllllllllllIIllIlIlIIIlIlIlIIIlI) {
            lllllllllllIIllIlIlIIIlIlIlIIlll.yPosition = lllllllllllIIllIlIlIIIlIlIlIIIll;
            if (!lllllllllllIIllIlIlIIIlIlIlIIIlI) {
                lllllllllllIIllIlIlIIIlIlIlIIlll.drawTextBox();
            }
        }
        
        public GuiEntry(@Nullable final Gui lllllllllllIIllIlIlIIIlIllllIlII, @Nullable final Gui lllllllllllIIllIlIlIIIlIllllIIII) {
            this.client = Minecraft.getMinecraft();
            this.component1 = lllllllllllIIllIlIlIIIlIllllIlII;
            this.component2 = lllllllllllIIllIlIlIIIlIllllIIII;
        }
        
        private boolean clickComponent(final Gui lllllllllllIIllIlIlIIIlIIllIIlII, final int lllllllllllIIllIlIlIIIlIIllIIIll, final int lllllllllllIIllIlIlIIIlIIllIIlll, final int lllllllllllIIllIlIlIIIlIIllIIllI) {
            if (lllllllllllIIllIlIlIIIlIIllIIlII == null) {
                return false;
            }
            if (lllllllllllIIllIlIlIIIlIIllIIlII instanceof GuiButton) {
                return this.clickButton((GuiButton)lllllllllllIIllIlIlIIIlIIllIIlII, lllllllllllIIllIlIlIIIlIIllIIIll, lllllllllllIIllIlIlIIIlIIllIIlll, lllllllllllIIllIlIlIIIlIIllIIllI);
            }
            if (lllllllllllIIllIlIlIIIlIIllIIlII instanceof GuiTextField) {
                this.clickTextField((GuiTextField)lllllllllllIIllIlIlIIIlIIllIIlII, lllllllllllIIllIlIlIIIlIIllIIIll, lllllllllllIIllIlIlIIIlIIllIIlll, lllllllllllIIllIlIlIIIlIIllIIllI);
            }
            return false;
        }
        
        private void clickTextField(final GuiTextField lllllllllllIIllIlIlIIIlIIlIIlIlI, final int lllllllllllIIllIlIlIIIlIIlIIlIIl, final int lllllllllllIIllIlIlIIIlIIlIIlIII, final int lllllllllllIIllIlIlIIIlIIlIIIlll) {
            lllllllllllIIllIlIlIIIlIIlIIlIlI.mouseClicked(lllllllllllIIllIlIlIIIlIIlIIlIIl, lllllllllllIIllIlIlIIIlIIlIIlIII, lllllllllllIIllIlIlIIIlIIlIIIlll);
            if (lllllllllllIIllIlIlIIIlIIlIIlIlI.isFocused()) {
                this.focusedControl = lllllllllllIIllIlIlIIIlIIlIIlIlI;
            }
        }
        
        private void releaseComponent(final Gui lllllllllllIIllIlIlIIIlIIIlIllII, final int lllllllllllIIllIlIlIIIlIIIlIIllI, final int lllllllllllIIllIlIlIIIlIIIlIIlIl, final int lllllllllllIIllIlIlIIIlIIIlIIlII) {
            if (lllllllllllIIllIlIlIIIlIIIlIllII != null && lllllllllllIIllIlIlIIIlIIIlIllII instanceof GuiButton) {
                this.releaseButton((GuiButton)lllllllllllIIllIlIlIIIlIIIlIllII, lllllllllllIIllIlIlIIIlIIIlIIllI, lllllllllllIIllIlIlIIIlIIIlIIlIl, lllllllllllIIllIlIlIIIlIIIlIIlII);
            }
        }
        
        private void func_192636_a(final Gui lllllllllllIIllIlIlIIIlIllIIIllI, final int lllllllllllIIllIlIlIIIlIllIIllII, final int lllllllllllIIllIlIlIIIlIllIIIlII, final int lllllllllllIIllIlIlIIIlIllIIIIll, final boolean lllllllllllIIllIlIlIIIlIllIIlIIl, final float lllllllllllIIllIlIlIIIlIllIIlIII) {
            if (lllllllllllIIllIlIlIIIlIllIIIllI != null) {
                if (lllllllllllIIllIlIlIIIlIllIIIllI instanceof GuiButton) {
                    this.func_192635_a((GuiButton)lllllllllllIIllIlIlIIIlIllIIIllI, lllllllllllIIllIlIlIIIlIllIIllII, lllllllllllIIllIlIlIIIlIllIIIlII, lllllllllllIIllIlIlIIIlIllIIIIll, lllllllllllIIllIlIlIIIlIllIIlIIl, lllllllllllIIllIlIlIIIlIllIIlIII);
                }
                else if (lllllllllllIIllIlIlIIIlIllIIIllI instanceof GuiTextField) {
                    this.renderTextField((GuiTextField)lllllllllllIIllIlIlIIIlIllIIIllI, lllllllllllIIllIlIlIIIlIllIIllII, lllllllllllIIllIlIlIIIlIllIIlIIl);
                }
                else if (lllllllllllIIllIlIlIIIlIllIIIllI instanceof GuiLabel) {
                    this.renderLabel((GuiLabel)lllllllllllIIllIlIlIIIlIllIIIllI, lllllllllllIIllIlIlIIIlIllIIllII, lllllllllllIIllIlIlIIIlIllIIIlII, lllllllllllIIllIlIlIIIlIllIIIIll, lllllllllllIIllIlIlIIIlIllIIlIIl);
                }
            }
        }
        
        public Gui getComponent1() {
            return this.component1;
        }
        
        @Override
        public void func_192634_a(final int lllllllllllIIllIlIlIIIlIlllIIIll, final int lllllllllllIIllIlIlIIIlIlllIIIlI, final int lllllllllllIIllIlIlIIIlIllIllIIl, final int lllllllllllIIllIlIlIIIlIlllIIIII, final int lllllllllllIIllIlIlIIIlIllIlllll, final int lllllllllllIIllIlIlIIIlIllIllIII, final int lllllllllllIIllIlIlIIIlIllIlllIl, final boolean lllllllllllIIllIlIlIIIlIllIlllII, final float lllllllllllIIllIlIlIIIlIllIllIll) {
            this.func_192636_a(this.component1, lllllllllllIIllIlIlIIIlIllIllIIl, lllllllllllIIllIlIlIIIlIllIllIII, lllllllllllIIllIlIlIIIlIllIlllIl, false, lllllllllllIIllIlIlIIIlIllIllIll);
            this.func_192636_a(this.component2, lllllllllllIIllIlIlIIIlIllIllIIl, lllllllllllIIllIlIlIIIlIllIllIII, lllllllllllIIllIlIlIIIlIllIlllIl, false, lllllllllllIIllIlIlIIIlIllIllIll);
        }
        
        @Override
        public void mouseReleased(final int lllllllllllIIllIlIlIIIlIIIllllII, final int lllllllllllIIllIlIlIIIlIIIllIlIl, final int lllllllllllIIllIlIlIIIlIIIlllIlI, final int lllllllllllIIllIlIlIIIlIIIlllIIl, final int lllllllllllIIllIlIlIIIlIIIlllIII, final int lllllllllllIIllIlIlIIIlIIIllIlll) {
            this.releaseComponent(this.component1, lllllllllllIIllIlIlIIIlIIIllIlIl, lllllllllllIIllIlIlIIIlIIIlllIlI, lllllllllllIIllIlIlIIIlIIIlllIIl);
            this.releaseComponent(this.component2, lllllllllllIIllIlIlIIIlIIIllIlIl, lllllllllllIIllIlIlIIIlIIIlllIlI, lllllllllllIIllIlIlIIIlIIIlllIIl);
        }
        
        private boolean clickButton(final GuiButton lllllllllllIIllIlIlIIIlIIlIllIlI, final int lllllllllllIIllIlIlIIIlIIlIlIIll, final int lllllllllllIIllIlIlIIIlIIlIlIIlI, final int lllllllllllIIllIlIlIIIlIIlIlIlll) {
            final boolean lllllllllllIIllIlIlIIIlIIlIlIllI = lllllllllllIIllIlIlIIIlIIlIllIlI.mousePressed(this.client, lllllllllllIIllIlIlIIIlIIlIlIIll, lllllllllllIIllIlIlIIIlIIlIlIIlI);
            if (lllllllllllIIllIlIlIIIlIIlIlIllI) {
                this.focusedControl = lllllllllllIIllIlIlIIIlIIlIllIlI;
            }
            return lllllllllllIIllIlIlIIIlIIlIlIllI;
        }
        
        public Gui getComponent2() {
            return this.component2;
        }
        
        private void renderLabel(final GuiLabel lllllllllllIIllIlIlIIIlIlIIllIlI, final int lllllllllllIIllIlIlIIIlIlIIlIIll, final int lllllllllllIIllIlIlIIIlIlIIllIII, final int lllllllllllIIllIlIlIIIlIlIIlIlll, final boolean lllllllllllIIllIlIlIIIlIlIIlIllI) {
            lllllllllllIIllIlIlIIIlIlIIllIlI.y = lllllllllllIIllIlIlIIIlIlIIlIIll;
            if (!lllllllllllIIllIlIlIIIlIlIIlIllI) {
                lllllllllllIIllIlIlIIIlIlIIllIlI.drawLabel(this.client, lllllllllllIIllIlIlIIIlIlIIllIII, lllllllllllIIllIlIlIIIlIlIIlIlll);
            }
        }
        
        private void func_192635_a(final GuiButton lllllllllllIIllIlIlIIIlIlIlllIII, final int lllllllllllIIllIlIlIIIlIlIllIlll, final int lllllllllllIIllIlIlIIIlIlIllIllI, final int lllllllllllIIllIlIlIIIlIlIlIlllI, final boolean lllllllllllIIllIlIlIIIlIlIllIlII, final float lllllllllllIIllIlIlIIIlIlIllIIll) {
            lllllllllllIIllIlIlIIIlIlIlllIII.yPosition = lllllllllllIIllIlIlIIIlIlIllIlll;
            if (!lllllllllllIIllIlIlIIIlIlIllIlII) {
                lllllllllllIIllIlIlIIIlIlIlllIII.drawButton(this.client, lllllllllllIIllIlIlIIIlIlIllIllI, lllllllllllIIllIlIlIIIlIlIlIlllI, lllllllllllIIllIlIlIIIlIlIllIIll);
            }
        }
        
        @Override
        public void func_192633_a(final int lllllllllllIIllIlIlIIIlIlIIIlIll, final int lllllllllllIIllIlIlIIIlIlIIIlIlI, final int lllllllllllIIllIlIlIIIlIlIIIIllI, final float lllllllllllIIllIlIlIIIlIlIIIlIII) {
            this.func_192636_a(this.component1, lllllllllllIIllIlIlIIIlIlIIIIllI, 0, 0, true, lllllllllllIIllIlIlIIIlIlIIIlIII);
            this.func_192636_a(this.component2, lllllllllllIIllIlIlIIIlIlIIIIllI, 0, 0, true, lllllllllllIIllIlIlIIIlIlIIIlIII);
        }
        
        @Override
        public boolean mousePressed(final int lllllllllllIIllIlIlIIIlIIlllllIl, final int lllllllllllIIllIlIlIIIlIIlllllII, final int lllllllllllIIllIlIlIIIlIIlllIIll, final int lllllllllllIIllIlIlIIIlIIlllIIlI, final int lllllllllllIIllIlIlIIIlIIllllIIl, final int lllllllllllIIllIlIlIIIlIIllllIII) {
            final boolean lllllllllllIIllIlIlIIIlIIlllIlll = this.clickComponent(this.component1, lllllllllllIIllIlIlIIIlIIlllllII, lllllllllllIIllIlIlIIIlIIlllIIll, lllllllllllIIllIlIlIIIlIIlllIIlI);
            final boolean lllllllllllIIllIlIlIIIlIIlllIllI = this.clickComponent(this.component2, lllllllllllIIllIlIlIIIlIIlllllII, lllllllllllIIllIlIlIIIlIIlllIIll, lllllllllllIIllIlIlIIIlIIlllIIlI);
            return lllllllllllIIllIlIlIIIlIIlllIlll || lllllllllllIIllIlIlIIIlIIlllIllI;
        }
        
        private void releaseButton(final GuiButton lllllllllllIIllIlIlIIIlIIIIlllll, final int lllllllllllIIllIlIlIIIlIIIIllllI, final int lllllllllllIIllIlIlIIIlIIIIlllIl, final int lllllllllllIIllIlIlIIIlIIIIlllII) {
            lllllllllllIIllIlIlIIIlIIIIlllll.mouseReleased(lllllllllllIIllIlIlIIIlIIIIllllI, lllllllllllIIllIlIlIIIlIIIIlllIl);
        }
    }
    
    public static class GuiListEntry
    {
        private final /* synthetic */ String caption;
        private final /* synthetic */ int id;
        private final /* synthetic */ boolean startVisible;
        
        public GuiListEntry(final int lllllllllllIIlIllIlIIIIlIIlllIll, final String lllllllllllIIlIllIlIIIIlIIlllllI, final boolean lllllllllllIIlIllIlIIIIlIIllllIl) {
            this.id = lllllllllllIIlIllIlIIIIlIIlllIll;
            this.caption = lllllllllllIIlIllIlIIIIlIIlllllI;
            this.startVisible = lllllllllllIIlIllIlIIIIlIIllllIl;
        }
        
        public boolean shouldStartVisible() {
            return this.startVisible;
        }
        
        public String getCaption() {
            return this.caption;
        }
        
        public int getId() {
            return this.id;
        }
    }
    
    public static class GuiLabelEntry extends GuiListEntry
    {
        public GuiLabelEntry(final int lllllllllllIIlIIIIllIIlIlIllIIII, final String lllllllllllIIlIIIIllIIlIlIlIlIll, final boolean lllllllllllIIlIIIIllIIlIlIlIlllI) {
            super(lllllllllllIIlIIIIllIIlIlIllIIII, lllllllllllIIlIIIIllIIlIlIlIlIll, lllllllllllIIlIIIIllIIlIlIlIlllI);
        }
    }
    
    public static class GuiButtonEntry extends GuiListEntry
    {
        private final /* synthetic */ boolean initialValue;
        
        public GuiButtonEntry(final int lllllllllllllIIIlIIlllIIlllllllI, final String lllllllllllllIIIlIIlllIIlllllIII, final boolean lllllllllllllIIIlIIlllIIllllIlll, final boolean lllllllllllllIIIlIIlllIIllllIllI) {
            super(lllllllllllllIIIlIIlllIIlllllllI, lllllllllllllIIIlIIlllIIlllllIII, lllllllllllllIIIlIIlllIIllllIlll);
            this.initialValue = lllllllllllllIIIlIIlllIIllllIllI;
        }
        
        public boolean getInitialValue() {
            return this.initialValue;
        }
    }
    
    public static class EditBoxEntry extends GuiListEntry
    {
        private final /* synthetic */ Predicate<String> filter;
        
        public EditBoxEntry(final int llllllllllllIllllIIIlIllIIlIIIll, final String llllllllllllIllllIIIlIllIIlIIIlI, final boolean llllllllllllIllllIIIlIllIIIlllII, final Predicate<String> llllllllllllIllllIIIlIllIIlIIIII) {
            super(llllllllllllIllllIIIlIllIIlIIIll, llllllllllllIllllIIIlIllIIlIIIlI, llllllllllllIllllIIIlIllIIIlllII);
            this.filter = (Predicate<String>)MoreObjects.firstNonNull((Object)llllllllllllIllllIIIlIllIIlIIIII, (Object)Predicates.alwaysTrue());
        }
        
        public Predicate<String> getFilter() {
            return this.filter;
        }
    }
}
