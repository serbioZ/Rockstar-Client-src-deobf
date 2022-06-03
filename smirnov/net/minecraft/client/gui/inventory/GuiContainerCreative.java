// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.util.NonNullList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.inventory.ClickType;
import javax.annotation.Nullable;
import net.minecraft.client.settings.CreativeSettings;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.client.Minecraft;
import java.util.Map;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.util.ITooltipFlag;
import org.lwjgl.input.Keyboard;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.GuiButton;
import java.util.Locale;
import net.minecraft.client.util.SearchTreeManager;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.client.settings.HotbarSnapshot;
import net.minecraft.inventory.IInventory;
import com.google.common.collect.Lists;
import java.util.Collection;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import java.io.IOException;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.input.Mouse;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.InventoryEffectRenderer;

public class GuiContainerCreative extends InventoryEffectRenderer
{
    private /* synthetic */ CreativeCrafting listener;
    private static final /* synthetic */ ResourceLocation CREATIVE_INVENTORY_TABS;
    private /* synthetic */ List<Slot> originalSlots;
    private /* synthetic */ Slot destroyItemSlot;
    private static final /* synthetic */ InventoryBasic basicInventory;
    private /* synthetic */ boolean wasClicking;
    private /* synthetic */ GuiTextField searchField;
    private /* synthetic */ boolean clearSearch;
    private /* synthetic */ boolean isScrolling;
    private static /* synthetic */ int selectedTabIndex;
    private /* synthetic */ float currentScroll;
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int lllllllllllIlIIIlIllIIIIllIllIII = Mouse.getEventDWheel();
        if (lllllllllllIlIIIlIllIIIIllIllIII != 0 && this.needsScrollBars()) {
            final int lllllllllllIlIIIlIllIIIIllIlIlll = (((ContainerCreative)this.inventorySlots).itemList.size() + 9 - 1) / 9 - 5;
            if (lllllllllllIlIIIlIllIIIIllIllIII > 0) {
                lllllllllllIlIIIlIllIIIIllIllIII = 1;
            }
            if (lllllllllllIlIIIlIllIIIIllIllIII < 0) {
                lllllllllllIlIIIlIllIIIIllIllIII = -1;
            }
            this.currentScroll -= (float)(lllllllllllIlIIIlIllIIIIllIllIII / (double)lllllllllllIlIIIlIllIIIIllIlIlll);
            this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0f, 1.0f);
            ((ContainerCreative)this.inventorySlots).scrollTo(this.currentScroll);
        }
    }
    
    protected boolean renderCreativeInventoryHoveringText(final CreativeTabs lllllllllllIlIIIlIllIIIIIlIIlIlI, final int lllllllllllIlIIIlIllIIIIIlIlIIII, final int lllllllllllIlIIIlIllIIIIIlIIlIII) {
        final int lllllllllllIlIIIlIllIIIIIlIIlllI = lllllllllllIlIIIlIllIIIIIlIIlIlI.getTabColumn();
        int lllllllllllIlIIIlIllIIIIIlIIllIl = 28 * lllllllllllIlIIIlIllIIIIIlIIlllI;
        int lllllllllllIlIIIlIllIIIIIlIIllII = 0;
        if (lllllllllllIlIIIlIllIIIIIlIIlIlI.func_192394_m()) {
            lllllllllllIlIIIlIllIIIIIlIIllIl = this.xSize - 28 * (6 - lllllllllllIlIIIlIllIIIIIlIIlllI) + 2;
        }
        else if (lllllllllllIlIIIlIllIIIIIlIIlllI > 0) {
            lllllllllllIlIIIlIllIIIIIlIIllIl += lllllllllllIlIIIlIllIIIIIlIIlllI;
        }
        if (lllllllllllIlIIIlIllIIIIIlIIlIlI.isTabInFirstRow()) {
            lllllllllllIlIIIlIllIIIIIlIIllII -= 32;
        }
        else {
            lllllllllllIlIIIlIllIIIIIlIIllII += this.ySize;
        }
        if (this.isPointInRegion(lllllllllllIlIIIlIllIIIIIlIIllIl + 3, lllllllllllIlIIIlIllIIIIIlIIllII + 3, 23, 27, lllllllllllIlIIIlIllIIIIIlIlIIII, lllllllllllIlIIIlIllIIIIIlIIlIII)) {
            this.drawCreativeTabHoveringText(I18n.format(lllllllllllIlIIIlIllIIIIIlIIlIlI.getTranslatedTabLabel(), new Object[0]), lllllllllllIlIIIlIllIIIIIlIlIIII, lllllllllllIlIIIlIllIIIIIlIIlIII);
            return true;
        }
        return false;
    }
    
    protected boolean isMouseOverTab(final CreativeTabs lllllllllllIlIIIlIllIIIIIlIlllll, final int lllllllllllIlIIIlIllIIIIIllIIlIl, final int lllllllllllIlIIIlIllIIIIIlIlllIl) {
        final int lllllllllllIlIIIlIllIIIIIllIIIll = lllllllllllIlIIIlIllIIIIIlIlllll.getTabColumn();
        int lllllllllllIlIIIlIllIIIIIllIIIlI = 28 * lllllllllllIlIIIlIllIIIIIllIIIll;
        int lllllllllllIlIIIlIllIIIIIllIIIIl = 0;
        if (lllllllllllIlIIIlIllIIIIIlIlllll.func_192394_m()) {
            lllllllllllIlIIIlIllIIIIIllIIIlI = this.xSize - 28 * (6 - lllllllllllIlIIIlIllIIIIIllIIIll) + 2;
        }
        else if (lllllllllllIlIIIlIllIIIIIllIIIll > 0) {
            lllllllllllIlIIIlIllIIIIIllIIIlI += lllllllllllIlIIIlIllIIIIIllIIIll;
        }
        if (lllllllllllIlIIIlIllIIIIIlIlllll.isTabInFirstRow()) {
            lllllllllllIlIIIlIllIIIIIllIIIIl -= 32;
        }
        else {
            lllllllllllIlIIIlIllIIIIIllIIIIl += this.ySize;
        }
        return lllllllllllIlIIIlIllIIIIIllIIlIl >= lllllllllllIlIIIlIllIIIIIllIIIlI && lllllllllllIlIIIlIllIIIIIllIIlIl <= lllllllllllIlIIIlIllIIIIIllIIIlI + 28 && lllllllllllIlIIIlIllIIIIIlIlllIl >= lllllllllllIlIIIlIllIIIIIllIIIIl && lllllllllllIlIIIlIllIIIIIlIlllIl <= lllllllllllIlIIIlIllIIIIIllIIIIl + 32;
    }
    
    private void setCurrentCreativeTab(final CreativeTabs lllllllllllIlIIIlIllIIIIlllIIlIl) {
        final int lllllllllllIlIIIlIllIIIIllllIlll = GuiContainerCreative.selectedTabIndex;
        GuiContainerCreative.selectedTabIndex = lllllllllllIlIIIlIllIIIIlllIIlIl.getTabIndex();
        final ContainerCreative lllllllllllIlIIIlIllIIIIllllIllI = (ContainerCreative)this.inventorySlots;
        this.dragSplittingSlots.clear();
        lllllllllllIlIIIlIllIIIIllllIllI.itemList.clear();
        if (lllllllllllIlIIIlIllIIIIlllIIlIl == CreativeTabs.field_192395_m) {
            for (int lllllllllllIlIIIlIllIIIIllllIlIl = 0; lllllllllllIlIIIlIllIIIIllllIlIl < 9; ++lllllllllllIlIIIlIllIIIIllllIlIl) {
                final HotbarSnapshot lllllllllllIlIIIlIllIIIIllllIlII = this.mc.field_191950_u.func_192563_a(lllllllllllIlIIIlIllIIIIllllIlIl);
                if (lllllllllllIlIIIlIllIIIIllllIlII.isEmpty()) {
                    for (int lllllllllllIlIIIlIllIIIIllllIIll = 0; lllllllllllIlIIIlIllIIIIllllIIll < 9; ++lllllllllllIlIIIlIllIIIIllllIIll) {
                        if (lllllllllllIlIIIlIllIIIIllllIIll == lllllllllllIlIIIlIllIIIIllllIlIl) {
                            final ItemStack lllllllllllIlIIIlIllIIIIllllIIlI = new ItemStack(Items.PAPER);
                            lllllllllllIlIIIlIllIIIIllllIIlI.func_190925_c("CustomCreativeLock");
                            final String lllllllllllIlIIIlIllIIIIllllIIIl = GameSettings.getKeyDisplayString(this.mc.gameSettings.keyBindsHotbar[lllllllllllIlIIIlIllIIIIllllIlIl].getKeyCode());
                            final String lllllllllllIlIIIlIllIIIIllllIIII = GameSettings.getKeyDisplayString(this.mc.gameSettings.field_193629_ap.getKeyCode());
                            lllllllllllIlIIIlIllIIIIllllIIlI.setStackDisplayName(new TextComponentTranslation("inventory.hotbarInfo", new Object[] { lllllllllllIlIIIlIllIIIIllllIIII, lllllllllllIlIIIlIllIIIIllllIIIl }).getUnformattedText());
                            lllllllllllIlIIIlIllIIIIllllIllI.itemList.add(lllllllllllIlIIIlIllIIIIllllIIlI);
                        }
                        else {
                            lllllllllllIlIIIlIllIIIIllllIllI.itemList.add(ItemStack.field_190927_a);
                        }
                    }
                }
                else {
                    lllllllllllIlIIIlIllIIIIllllIllI.itemList.addAll((Collection<?>)lllllllllllIlIIIlIllIIIIllllIlII);
                }
            }
        }
        else if (lllllllllllIlIIIlIllIIIIlllIIlIl != CreativeTabs.SEARCH) {
            lllllllllllIlIIIlIllIIIIlllIIlIl.displayAllRelevantItems(lllllllllllIlIIIlIllIIIIllllIllI.itemList);
        }
        if (lllllllllllIlIIIlIllIIIIlllIIlIl == CreativeTabs.INVENTORY) {
            final Container lllllllllllIlIIIlIllIIIIlllIllll = this.mc.player.inventoryContainer;
            if (this.originalSlots == null) {
                this.originalSlots = lllllllllllIlIIIlIllIIIIllllIllI.inventorySlots;
            }
            lllllllllllIlIIIlIllIIIIllllIllI.inventorySlots = (List<Slot>)Lists.newArrayList();
            for (int lllllllllllIlIIIlIllIIIIlllIlllI = 0; lllllllllllIlIIIlIllIIIIlllIlllI < lllllllllllIlIIIlIllIIIIlllIllll.inventorySlots.size(); ++lllllllllllIlIIIlIllIIIIlllIlllI) {
                final Slot lllllllllllIlIIIlIllIIIIlllIllIl = new CreativeSlot(lllllllllllIlIIIlIllIIIIlllIllll.inventorySlots.get(lllllllllllIlIIIlIllIIIIlllIlllI), lllllllllllIlIIIlIllIIIIlllIlllI);
                lllllllllllIlIIIlIllIIIIllllIllI.inventorySlots.add(lllllllllllIlIIIlIllIIIIlllIllIl);
                if (lllllllllllIlIIIlIllIIIIlllIlllI >= 5 && lllllllllllIlIIIlIllIIIIlllIlllI < 9) {
                    final int lllllllllllIlIIIlIllIIIIlllIllII = lllllllllllIlIIIlIllIIIIlllIlllI - 5;
                    final int lllllllllllIlIIIlIllIIIIlllIlIll = lllllllllllIlIIIlIllIIIIlllIllII / 2;
                    final int lllllllllllIlIIIlIllIIIIlllIlIlI = lllllllllllIlIIIlIllIIIIlllIllII % 2;
                    lllllllllllIlIIIlIllIIIIlllIllIl.xDisplayPosition = 54 + lllllllllllIlIIIlIllIIIIlllIlIll * 54;
                    lllllllllllIlIIIlIllIIIIlllIllIl.yDisplayPosition = 6 + lllllllllllIlIIIlIllIIIIlllIlIlI * 27;
                }
                else if (lllllllllllIlIIIlIllIIIIlllIlllI >= 0 && lllllllllllIlIIIlIllIIIIlllIlllI < 5) {
                    lllllllllllIlIIIlIllIIIIlllIllIl.xDisplayPosition = -2000;
                    lllllllllllIlIIIlIllIIIIlllIllIl.yDisplayPosition = -2000;
                }
                else if (lllllllllllIlIIIlIllIIIIlllIlllI == 45) {
                    lllllllllllIlIIIlIllIIIIlllIllIl.xDisplayPosition = 35;
                    lllllllllllIlIIIlIllIIIIlllIllIl.yDisplayPosition = 20;
                }
                else if (lllllllllllIlIIIlIllIIIIlllIlllI < lllllllllllIlIIIlIllIIIIlllIllll.inventorySlots.size()) {
                    final int lllllllllllIlIIIlIllIIIIlllIlIIl = lllllllllllIlIIIlIllIIIIlllIlllI - 9;
                    final int lllllllllllIlIIIlIllIIIIlllIlIII = lllllllllllIlIIIlIllIIIIlllIlIIl % 9;
                    final int lllllllllllIlIIIlIllIIIIlllIIlll = lllllllllllIlIIIlIllIIIIlllIlIIl / 9;
                    lllllllllllIlIIIlIllIIIIlllIllIl.xDisplayPosition = 9 + lllllllllllIlIIIlIllIIIIlllIlIII * 18;
                    if (lllllllllllIlIIIlIllIIIIlllIlllI >= 36) {
                        lllllllllllIlIIIlIllIIIIlllIllIl.yDisplayPosition = 112;
                    }
                    else {
                        lllllllllllIlIIIlIllIIIIlllIllIl.yDisplayPosition = 54 + lllllllllllIlIIIlIllIIIIlllIIlll * 18;
                    }
                }
            }
            this.destroyItemSlot = new Slot(GuiContainerCreative.basicInventory, 0, 173, 112);
            lllllllllllIlIIIlIllIIIIllllIllI.inventorySlots.add(this.destroyItemSlot);
        }
        else if (lllllllllllIlIIIlIllIIIIllllIlll == CreativeTabs.INVENTORY.getTabIndex()) {
            lllllllllllIlIIIlIllIIIIllllIllI.inventorySlots = this.originalSlots;
            this.originalSlots = null;
        }
        if (this.searchField != null) {
            if (lllllllllllIlIIIlIllIIIIlllIIlIl == CreativeTabs.SEARCH) {
                this.searchField.setVisible(true);
                this.searchField.setCanLoseFocus(false);
                this.searchField.setFocused(true);
                this.searchField.setText("");
                this.updateCreativeSearch();
            }
            else {
                this.searchField.setVisible(false);
                this.searchField.setCanLoseFocus(true);
                this.searchField.setFocused(false);
            }
        }
        this.currentScroll = 0.0f;
        lllllllllllIlIIIlIllIIIIllllIllI.scrollTo(0.0f);
    }
    
    @Override
    public void updateScreen() {
        if (!this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiInventory(this.mc.player));
        }
    }
    
    protected void drawTab(final CreativeTabs lllllllllllIlIIIlIllIIIIIIlIllIl) {
        final boolean lllllllllllIlIIIlIllIIIIIIllIlll = lllllllllllIlIIIlIllIIIIIIlIllIl.getTabIndex() == GuiContainerCreative.selectedTabIndex;
        final boolean lllllllllllIlIIIlIllIIIIIIllIllI = lllllllllllIlIIIlIllIIIIIIlIllIl.isTabInFirstRow();
        final int lllllllllllIlIIIlIllIIIIIIllIlIl = lllllllllllIlIIIlIllIIIIIIlIllIl.getTabColumn();
        final int lllllllllllIlIIIlIllIIIIIIllIlII = lllllllllllIlIIIlIllIIIIIIllIlIl * 28;
        int lllllllllllIlIIIlIllIIIIIIllIIll = 0;
        int lllllllllllIlIIIlIllIIIIIIllIIlI = this.guiLeft + 28 * lllllllllllIlIIIlIllIIIIIIllIlIl;
        int lllllllllllIlIIIlIllIIIIIIllIIIl = this.guiTop;
        final int lllllllllllIlIIIlIllIIIIIIllIIII = 32;
        if (lllllllllllIlIIIlIllIIIIIIllIlll) {
            lllllllllllIlIIIlIllIIIIIIllIIll += 32;
        }
        if (lllllllllllIlIIIlIllIIIIIIlIllIl.func_192394_m()) {
            lllllllllllIlIIIlIllIIIIIIllIIlI = this.guiLeft + this.xSize - 28 * (6 - lllllllllllIlIIIlIllIIIIIIllIlIl);
        }
        else if (lllllllllllIlIIIlIllIIIIIIllIlIl > 0) {
            lllllllllllIlIIIlIllIIIIIIllIIlI += lllllllllllIlIIIlIllIIIIIIllIlIl;
        }
        if (lllllllllllIlIIIlIllIIIIIIllIllI) {
            lllllllllllIlIIIlIllIIIIIIllIIIl -= 28;
        }
        else {
            lllllllllllIlIIIlIllIIIIIIllIIll += 64;
            lllllllllllIlIIIlIllIIIIIIllIIIl += this.ySize - 4;
        }
        GlStateManager.disableLighting();
        this.drawTexturedModalRect(lllllllllllIlIIIlIllIIIIIIllIIlI, lllllllllllIlIIIlIllIIIIIIllIIIl, lllllllllllIlIIIlIllIIIIIIllIlII, lllllllllllIlIIIlIllIIIIIIllIIll, 28, 32);
        this.zLevel = 100.0f;
        this.itemRender.zLevel = 100.0f;
        lllllllllllIlIIIlIllIIIIIIllIIlI += 6;
        lllllllllllIlIIIlIllIIIIIIllIIIl = lllllllllllIlIIIlIllIIIIIIllIIIl + 8 + (lllllllllllIlIIIlIllIIIIIIllIllI ? 1 : -1);
        GlStateManager.enableLighting();
        GlStateManager.enableRescaleNormal();
        final ItemStack lllllllllllIlIIIlIllIIIIIIlIllll = lllllllllllIlIIIlIllIIIIIIlIllIl.getIconItemStack();
        this.itemRender.renderItemAndEffectIntoGUI(lllllllllllIlIIIlIllIIIIIIlIllll, lllllllllllIlIIIlIllIIIIIIllIIlI, lllllllllllIlIIIlIllIIIIIIllIIIl);
        this.itemRender.renderItemOverlays(this.fontRendererObj, lllllllllllIlIIIlIllIIIIIIlIllll, lllllllllllIlIIIlIllIIIIIIllIIlI, lllllllllllIlIIIlIllIIIIIIllIIIl);
        GlStateManager.disableLighting();
        this.itemRender.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlIIIlIllIIIlIIllIIIl, final int lllllllllllIlIIIlIllIIIlIIllIIII, final int lllllllllllIlIIIlIllIIIlIIlIlIII) throws IOException {
        if (lllllllllllIlIIIlIllIIIlIIlIlIII == 0) {
            final int lllllllllllIlIIIlIllIIIlIIlIlllI = lllllllllllIlIIIlIllIIIlIIllIIIl - this.guiLeft;
            final int lllllllllllIlIIIlIllIIIlIIlIllIl = lllllllllllIlIIIlIllIIIlIIllIIII - this.guiTop;
            byte lllllllllllIlIIIlIllIIIlIIlIIIlI;
            for (byte lllllllllllIlIIIlIllIIIlIIlIIIll = (byte)((CreativeTabs[])(Object)(lllllllllllIlIIIlIllIIIlIIlIIIlI = (byte)(Object)CreativeTabs.CREATIVE_TAB_ARRAY)).length, lllllllllllIlIIIlIllIIIlIIlIIlII = 0; lllllllllllIlIIIlIllIIIlIIlIIlII < lllllllllllIlIIIlIllIIIlIIlIIIll; ++lllllllllllIlIIIlIllIIIlIIlIIlII) {
                final CreativeTabs lllllllllllIlIIIlIllIIIlIIlIllII = lllllllllllIlIIIlIllIIIlIIlIIIlI[lllllllllllIlIIIlIllIIIlIIlIIlII];
                if (this.isMouseOverTab(lllllllllllIlIIIlIllIIIlIIlIllII, lllllllllllIlIIIlIllIIIlIIlIlllI, lllllllllllIlIIIlIllIIIlIIlIllIl)) {
                    return;
                }
            }
        }
        super.mouseClicked(lllllllllllIlIIIlIllIIIlIIllIIIl, lllllllllllIlIIIlIllIIIlIIllIIII, lllllllllllIlIIIlIllIIIlIIlIlIII);
    }
    
    private void updateCreativeSearch() {
        final ContainerCreative lllllllllllIlIIIlIllIIIlIlIIlIlI = (ContainerCreative)this.inventorySlots;
        lllllllllllIlIIIlIllIIIlIlIIlIlI.itemList.clear();
        if (this.searchField.getText().isEmpty()) {
            for (final Item lllllllllllIlIIIlIllIIIlIlIIlIIl : Item.REGISTRY) {
                lllllllllllIlIIIlIllIIIlIlIIlIIl.getSubItems(CreativeTabs.SEARCH, lllllllllllIlIIIlIllIIIlIlIIlIlI.itemList);
            }
        }
        else {
            lllllllllllIlIIIlIllIIIlIlIIlIlI.itemList.addAll((Collection<?>)this.mc.func_193987_a(SearchTreeManager.field_194011_a).func_194038_a(this.searchField.getText().toLowerCase(Locale.ROOT)));
        }
        this.currentScroll = 0.0f;
        lllllllllllIlIIIlIllIIIlIlIIlIlI.scrollTo(0.0f);
    }
    
    public GuiContainerCreative(final EntityPlayer lllllllllllIlIIIlIllIIIllIIlIlIl) {
        super(new ContainerCreative(lllllllllllIlIIIlIllIIIllIIlIlIl));
        lllllllllllIlIIIlIllIIIllIIlIlIl.openContainer = this.inventorySlots;
        this.allowUserInput = true;
        this.ySize = 136;
        this.xSize = 195;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlIIIlIllIIIIIIlIIIII) throws IOException {
        if (lllllllllllIlIIIlIllIIIIIIlIIIII.id == 1) {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.player.getStatFileWriter()));
        }
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIlIIIlIllIIIlIlIIIIIl, final int lllllllllllIlIIIlIllIIIlIlIIIIII) {
        final CreativeTabs lllllllllllIlIIIlIllIIIlIIllllll = CreativeTabs.CREATIVE_TAB_ARRAY[GuiContainerCreative.selectedTabIndex];
        if (lllllllllllIlIIIlIllIIIlIIllllll.drawInForegroundOfTab()) {
            GlStateManager.disableBlend();
            this.fontRendererObj.drawString(I18n.format(lllllllllllIlIIIlIllIIIlIIllllll.getTranslatedTabLabel(), new Object[0]), 8.0f, 6.0f, 4210752);
        }
    }
    
    static {
        CREATIVE_INVENTORY_TABS = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
        basicInventory = new InventoryBasic("tmp", true, 45);
        GuiContainerCreative.selectedTabIndex = CreativeTabs.BUILDING_BLOCKS.getTabIndex();
    }
    
    private boolean needsScrollBars() {
        return GuiContainerCreative.selectedTabIndex != CreativeTabs.INVENTORY.getTabIndex() && CreativeTabs.CREATIVE_TAB_ARRAY[GuiContainerCreative.selectedTabIndex].shouldHidePlayerInventory() && ((ContainerCreative)this.inventorySlots).canScroll();
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllIlIIIlIllIIIlIIIlIllI, final int lllllllllllIlIIIlIllIIIlIIIIlllI, final int lllllllllllIlIIIlIllIIIlIIIIllIl) {
        if (lllllllllllIlIIIlIllIIIlIIIIllIl == 0) {
            final int lllllllllllIlIIIlIllIIIlIIIlIIll = lllllllllllIlIIIlIllIIIlIIIlIllI - this.guiLeft;
            final int lllllllllllIlIIIlIllIIIlIIIlIIlI = lllllllllllIlIIIlIllIIIlIIIIlllI - this.guiTop;
            final int lllllllllllIlIIIlIllIIIlIIIIIlll;
            final int lllllllllllIlIIIlIllIIIlIIIIlIII = ((CreativeTabs[])(Object)(lllllllllllIlIIIlIllIIIlIIIIIlll = (int)(Object)CreativeTabs.CREATIVE_TAB_ARRAY)).length;
            for (Exception lllllllllllIlIIIlIllIIIlIIIIlIIl = (Exception)0; lllllllllllIlIIIlIllIIIlIIIIlIIl < lllllllllllIlIIIlIllIIIlIIIIlIII; ++lllllllllllIlIIIlIllIIIlIIIIlIIl) {
                final CreativeTabs lllllllllllIlIIIlIllIIIlIIIlIIIl = lllllllllllIlIIIlIllIIIlIIIIIlll[lllllllllllIlIIIlIllIIIlIIIIlIIl];
                if (this.isMouseOverTab(lllllllllllIlIIIlIllIIIlIIIlIIIl, lllllllllllIlIIIlIllIIIlIIIlIIll, lllllllllllIlIIIlIllIIIlIIIlIIlI)) {
                    this.setCurrentCreativeTab(lllllllllllIlIIIlIllIIIlIIIlIIIl);
                    return;
                }
            }
        }
        super.mouseReleased(lllllllllllIlIIIlIllIIIlIIIlIllI, lllllllllllIlIIIlIllIIIlIIIIlllI, lllllllllllIlIIIlIllIIIlIIIIllIl);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlIIIlIllIIIlIlIlIIIl, final int lllllllllllIlIIIlIllIIIlIlIlIIII) throws IOException {
        if (GuiContainerCreative.selectedTabIndex != CreativeTabs.SEARCH.getTabIndex()) {
            if (GameSettings.isKeyDown(this.mc.gameSettings.keyBindChat)) {
                this.setCurrentCreativeTab(CreativeTabs.SEARCH);
            }
            else {
                super.keyTyped(lllllllllllIlIIIlIllIIIlIlIlIIIl, lllllllllllIlIIIlIllIIIlIlIlIIII);
            }
        }
        else {
            if (this.clearSearch) {
                this.clearSearch = false;
                this.searchField.setText("");
            }
            if (!this.checkHotbarKeys(lllllllllllIlIIIlIllIIIlIlIlIIII)) {
                if (this.searchField.textboxKeyTyped(lllllllllllIlIIIlIllIIIlIlIlIIIl, lllllllllllIlIIIlIllIIIlIlIlIIII)) {
                    this.updateCreativeSearch();
                }
                else {
                    super.keyTyped(lllllllllllIlIIIlIllIIIlIlIlIIIl, lllllllllllIlIIIlIllIIIlIlIlIIII);
                }
            }
        }
    }
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (this.mc.player != null && this.mc.player.inventory != null) {
            this.mc.player.inventoryContainer.removeListener(this.listener);
        }
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void initGui() {
        if (this.mc.playerController.isInCreativeMode()) {
            super.initGui();
            this.buttonList.clear();
            Keyboard.enableRepeatEvents(true);
            this.searchField = new GuiTextField(0, this.fontRendererObj, this.guiLeft + 82, this.guiTop + 6, 80, this.fontRendererObj.FONT_HEIGHT);
            this.searchField.setMaxStringLength(50);
            this.searchField.setEnableBackgroundDrawing(false);
            this.searchField.setVisible(false);
            this.searchField.setTextColor(16777215);
            final int lllllllllllIlIIIlIllIIIlIlIllllI = GuiContainerCreative.selectedTabIndex;
            GuiContainerCreative.selectedTabIndex = -1;
            this.setCurrentCreativeTab(CreativeTabs.CREATIVE_TAB_ARRAY[lllllllllllIlIIIlIllIIIlIlIllllI]);
            this.listener = new CreativeCrafting(this.mc);
            this.mc.player.inventoryContainer.addListener(this.listener);
        }
        else {
            this.mc.displayGuiScreen(new GuiInventory(this.mc.player));
        }
    }
    
    @Override
    protected void renderToolTip(final ItemStack lllllllllllIlIIIlIllIIIIlIIlllII, final int lllllllllllIlIIIlIllIIIIlIIlIIIl, final int lllllllllllIlIIIlIllIIIIlIIllIlI) {
        if (GuiContainerCreative.selectedTabIndex == CreativeTabs.SEARCH.getTabIndex()) {
            final List<String> lllllllllllIlIIIlIllIIIIlIIllIIl = lllllllllllIlIIIlIllIIIIlIIlllII.getTooltip(this.mc.player, this.mc.gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL);
            CreativeTabs lllllllllllIlIIIlIllIIIIlIIllIII = lllllllllllIlIIIlIllIIIIlIIlllII.getItem().getCreativeTab();
            if (lllllllllllIlIIIlIllIIIIlIIllIII == null && lllllllllllIlIIIlIllIIIIlIIlllII.getItem() == Items.ENCHANTED_BOOK) {
                final Map<Enchantment, Integer> lllllllllllIlIIIlIllIIIIlIIlIlll = EnchantmentHelper.getEnchantments(lllllllllllIlIIIlIllIIIIlIIlllII);
                if (lllllllllllIlIIIlIllIIIIlIIlIlll.size() == 1) {
                    final Enchantment lllllllllllIlIIIlIllIIIIlIIlIllI = lllllllllllIlIIIlIllIIIIlIIlIlll.keySet().iterator().next();
                    final double lllllllllllIlIIIlIllIIIIlIIIlIII;
                    final long lllllllllllIlIIIlIllIIIIlIIIlIIl = ((CreativeTabs[])(Object)(lllllllllllIlIIIlIllIIIIlIIIlIII = (double)(Object)CreativeTabs.CREATIVE_TAB_ARRAY)).length;
                    for (boolean lllllllllllIlIIIlIllIIIIlIIIlIlI = false; (lllllllllllIlIIIlIllIIIIlIIIlIlI ? 1 : 0) < lllllllllllIlIIIlIllIIIIlIIIlIIl; ++lllllllllllIlIIIlIllIIIIlIIIlIlI) {
                        final CreativeTabs lllllllllllIlIIIlIllIIIIlIIlIlIl = lllllllllllIlIIIlIllIIIIlIIIlIII[lllllllllllIlIIIlIllIIIIlIIIlIlI];
                        if (lllllllllllIlIIIlIllIIIIlIIlIlIl.hasRelevantEnchantmentType(lllllllllllIlIIIlIllIIIIlIIlIllI.type)) {
                            lllllllllllIlIIIlIllIIIIlIIllIII = lllllllllllIlIIIlIllIIIIlIIlIlIl;
                            break;
                        }
                    }
                }
            }
            if (lllllllllllIlIIIlIllIIIIlIIllIII != null) {
                lllllllllllIlIIIlIllIIIIlIIllIIl.add(1, new StringBuilder().append(TextFormatting.BOLD).append(TextFormatting.BLUE).append(I18n.format(lllllllllllIlIIIlIllIIIIlIIllIII.getTranslatedTabLabel(), new Object[0])).toString());
            }
            for (int lllllllllllIlIIIlIllIIIIlIIlIlII = 0; lllllllllllIlIIIlIllIIIIlIIlIlII < lllllllllllIlIIIlIllIIIIlIIllIIl.size(); ++lllllllllllIlIIIlIllIIIIlIIlIlII) {
                if (lllllllllllIlIIIlIllIIIIlIIlIlII == 0) {
                    lllllllllllIlIIIlIllIIIIlIIllIIl.set(lllllllllllIlIIIlIllIIIIlIIlIlII, lllllllllllIlIIIlIllIIIIlIIlllII.getRarity().rarityColor + lllllllllllIlIIIlIllIIIIlIIllIIl.get(lllllllllllIlIIIlIllIIIIlIIlIlII));
                }
                else {
                    lllllllllllIlIIIlIllIIIIlIIllIIl.set(lllllllllllIlIIIlIllIIIIlIIlIlII, TextFormatting.GRAY + lllllllllllIlIIIlIllIIIIlIIllIIl.get(lllllllllllIlIIIlIllIIIIlIIlIlII));
                }
            }
            this.drawHoveringText(lllllllllllIlIIIlIllIIIIlIIllIIl, lllllllllllIlIIIlIllIIIIlIIlIIIl, lllllllllllIlIIIlIllIIIIlIIllIlI);
        }
        else {
            super.renderToolTip(lllllllllllIlIIIlIllIIIIlIIlllII, lllllllllllIlIIIlIllIIIIlIIlIIIl, lllllllllllIlIIIlIllIIIIlIIllIlI);
        }
    }
    
    public static void func_192044_a(final Minecraft lllllllllllIlIIIlIllIIIIIIIIIlll, final int lllllllllllIlIIIlIllIIIIIIIlIIlI, final boolean lllllllllllIlIIIlIllIIIIIIIIIlIl, final boolean lllllllllllIlIIIlIllIIIIIIIlIIII) {
        final EntityPlayerSP lllllllllllIlIIIlIllIIIIIIIIllll = lllllllllllIlIIIlIllIIIIIIIIIlll.player;
        final CreativeSettings lllllllllllIlIIIlIllIIIIIIIIlllI = lllllllllllIlIIIlIllIIIIIIIIIlll.field_191950_u;
        final HotbarSnapshot lllllllllllIlIIIlIllIIIIIIIIllIl = lllllllllllIlIIIlIllIIIIIIIIlllI.func_192563_a(lllllllllllIlIIIlIllIIIIIIIlIIlI);
        if (lllllllllllIlIIIlIllIIIIIIIIIlIl) {
            for (int lllllllllllIlIIIlIllIIIIIIIIllII = 0; lllllllllllIlIIIlIllIIIIIIIIllII < InventoryPlayer.getHotbarSize(); ++lllllllllllIlIIIlIllIIIIIIIIllII) {
                final ItemStack lllllllllllIlIIIlIllIIIIIIIIlIll = lllllllllllIlIIIlIllIIIIIIIIllIl.get(lllllllllllIlIIIlIllIIIIIIIIllII).copy();
                lllllllllllIlIIIlIllIIIIIIIIllll.inventory.setInventorySlotContents(lllllllllllIlIIIlIllIIIIIIIIllII, lllllllllllIlIIIlIllIIIIIIIIlIll);
                lllllllllllIlIIIlIllIIIIIIIIIlll.playerController.sendSlotPacket(lllllllllllIlIIIlIllIIIIIIIIlIll, 36 + lllllllllllIlIIIlIllIIIIIIIIllII);
            }
            lllllllllllIlIIIlIllIIIIIIIIllll.inventoryContainer.detectAndSendChanges();
        }
        else if (lllllllllllIlIIIlIllIIIIIIIlIIII) {
            for (int lllllllllllIlIIIlIllIIIIIIIIlIlI = 0; lllllllllllIlIIIlIllIIIIIIIIlIlI < InventoryPlayer.getHotbarSize(); ++lllllllllllIlIIIlIllIIIIIIIIlIlI) {
                lllllllllllIlIIIlIllIIIIIIIIllIl.set(lllllllllllIlIIIlIllIIIIIIIIlIlI, lllllllllllIlIIIlIllIIIIIIIIllll.inventory.getStackInSlot(lllllllllllIlIIIlIllIIIIIIIIlIlI).copy());
            }
            final String lllllllllllIlIIIlIllIIIIIIIIlIIl = GameSettings.getKeyDisplayString(lllllllllllIlIIIlIllIIIIIIIIIlll.gameSettings.keyBindsHotbar[lllllllllllIlIIIlIllIIIIIIIlIIlI].getKeyCode());
            final String lllllllllllIlIIIlIllIIIIIIIIlIII = GameSettings.getKeyDisplayString(lllllllllllIlIIIlIllIIIIIIIIIlll.gameSettings.field_193630_aq.getKeyCode());
            lllllllllllIlIIIlIllIIIIIIIIIlll.ingameGUI.setRecordPlaying(new TextComponentTranslation("inventory.hotbarSaved", new Object[] { lllllllllllIlIIIlIllIIIIIIIIlIII, lllllllllllIlIIIlIllIIIIIIIIlIIl }), false);
            lllllllllllIlIIIlIllIIIIIIIIlllI.func_192564_b();
        }
    }
    
    @Override
    public void handleMouseClick(@Nullable final Slot lllllllllllIlIIIlIllIIIllIIIIllI, final int lllllllllllIlIIIlIllIIIllIIIIlIl, final int lllllllllllIlIIIlIllIIIlIllIlllI, ClickType lllllllllllIlIIIlIllIIIlIllIllIl) {
        this.clearSearch = true;
        final boolean lllllllllllIlIIIlIllIIIllIIIIIlI = lllllllllllIlIIIlIllIIIlIllIllIl == ClickType.QUICK_MOVE;
        lllllllllllIlIIIlIllIIIlIllIllIl = ((lllllllllllIlIIIlIllIIIllIIIIlIl == -999 && lllllllllllIlIIIlIllIIIlIllIllIl == ClickType.PICKUP) ? ClickType.THROW : lllllllllllIlIIIlIllIIIlIllIllIl);
        if (lllllllllllIlIIIlIllIIIllIIIIllI == null && GuiContainerCreative.selectedTabIndex != CreativeTabs.INVENTORY.getTabIndex() && lllllllllllIlIIIlIllIIIlIllIllIl != ClickType.QUICK_CRAFT) {
            final InventoryPlayer lllllllllllIlIIIlIllIIIllIIIIIIl = this.mc.player.inventory;
            if (!lllllllllllIlIIIlIllIIIllIIIIIIl.getItemStack().func_190926_b()) {
                if (lllllllllllIlIIIlIllIIIlIllIlllI == 0) {
                    this.mc.player.dropItem(lllllllllllIlIIIlIllIIIllIIIIIIl.getItemStack(), true);
                    this.mc.playerController.sendPacketDropItem(lllllllllllIlIIIlIllIIIllIIIIIIl.getItemStack());
                    lllllllllllIlIIIlIllIIIllIIIIIIl.setItemStack(ItemStack.field_190927_a);
                }
                if (lllllllllllIlIIIlIllIIIlIllIlllI == 1) {
                    final ItemStack lllllllllllIlIIIlIllIIIllIIIIIII = lllllllllllIlIIIlIllIIIllIIIIIIl.getItemStack().splitStack(1);
                    this.mc.player.dropItem(lllllllllllIlIIIlIllIIIllIIIIIII, true);
                    this.mc.playerController.sendPacketDropItem(lllllllllllIlIIIlIllIIIllIIIIIII);
                }
            }
        }
        else {
            if (lllllllllllIlIIIlIllIIIllIIIIllI != null && !lllllllllllIlIIIlIllIIIllIIIIllI.canTakeStack(this.mc.player)) {
                return;
            }
            if (lllllllllllIlIIIlIllIIIllIIIIllI == this.destroyItemSlot && lllllllllllIlIIIlIllIIIllIIIIIlI) {
                for (int lllllllllllIlIIIlIllIIIlIlllllll = 0; lllllllllllIlIIIlIllIIIlIlllllll < this.mc.player.inventoryContainer.getInventory().size(); ++lllllllllllIlIIIlIllIIIlIlllllll) {
                    this.mc.playerController.sendSlotPacket(ItemStack.field_190927_a, lllllllllllIlIIIlIllIIIlIlllllll);
                }
            }
            else if (GuiContainerCreative.selectedTabIndex == CreativeTabs.INVENTORY.getTabIndex()) {
                if (lllllllllllIlIIIlIllIIIllIIIIllI == this.destroyItemSlot) {
                    this.mc.player.inventory.setItemStack(ItemStack.field_190927_a);
                }
                else if (lllllllllllIlIIIlIllIIIlIllIllIl == ClickType.THROW && lllllllllllIlIIIlIllIIIllIIIIllI != null && lllllllllllIlIIIlIllIIIllIIIIllI.getHasStack()) {
                    final ItemStack lllllllllllIlIIIlIllIIIlIllllllI = lllllllllllIlIIIlIllIIIllIIIIllI.decrStackSize((lllllllllllIlIIIlIllIIIlIllIlllI == 0) ? 1 : lllllllllllIlIIIlIllIIIllIIIIllI.getStack().getMaxStackSize());
                    final ItemStack lllllllllllIlIIIlIllIIIlIlllllIl = lllllllllllIlIIIlIllIIIllIIIIllI.getStack();
                    this.mc.player.dropItem(lllllllllllIlIIIlIllIIIlIllllllI, true);
                    this.mc.playerController.sendPacketDropItem(lllllllllllIlIIIlIllIIIlIllllllI);
                    this.mc.playerController.sendSlotPacket(lllllllllllIlIIIlIllIIIlIlllllIl, ((CreativeSlot)lllllllllllIlIIIlIllIIIllIIIIllI).slot.slotNumber);
                }
                else if (lllllllllllIlIIIlIllIIIlIllIllIl == ClickType.THROW && !this.mc.player.inventory.getItemStack().func_190926_b()) {
                    this.mc.player.dropItem(this.mc.player.inventory.getItemStack(), true);
                    this.mc.playerController.sendPacketDropItem(this.mc.player.inventory.getItemStack());
                    this.mc.player.inventory.setItemStack(ItemStack.field_190927_a);
                }
                else {
                    this.mc.player.inventoryContainer.slotClick((lllllllllllIlIIIlIllIIIllIIIIllI == null) ? lllllllllllIlIIIlIllIIIllIIIIlIl : ((CreativeSlot)lllllllllllIlIIIlIllIIIllIIIIllI).slot.slotNumber, lllllllllllIlIIIlIllIIIlIllIlllI, lllllllllllIlIIIlIllIIIlIllIllIl, this.mc.player);
                    this.mc.player.inventoryContainer.detectAndSendChanges();
                }
            }
            else if (lllllllllllIlIIIlIllIIIlIllIllIl != ClickType.QUICK_CRAFT && lllllllllllIlIIIlIllIIIllIIIIllI.inventory == GuiContainerCreative.basicInventory) {
                final InventoryPlayer lllllllllllIlIIIlIllIIIlIlllllII = this.mc.player.inventory;
                ItemStack lllllllllllIlIIIlIllIIIlIllllIll = lllllllllllIlIIIlIllIIIlIlllllII.getItemStack();
                final ItemStack lllllllllllIlIIIlIllIIIlIllllIlI = lllllllllllIlIIIlIllIIIllIIIIllI.getStack();
                if (lllllllllllIlIIIlIllIIIlIllIllIl == ClickType.SWAP) {
                    if (!lllllllllllIlIIIlIllIIIlIllllIlI.func_190926_b() && lllllllllllIlIIIlIllIIIlIllIlllI >= 0 && lllllllllllIlIIIlIllIIIlIllIlllI < 9) {
                        final ItemStack lllllllllllIlIIIlIllIIIlIllllIIl = lllllllllllIlIIIlIllIIIlIllllIlI.copy();
                        lllllllllllIlIIIlIllIIIlIllllIIl.func_190920_e(lllllllllllIlIIIlIllIIIlIllllIIl.getMaxStackSize());
                        this.mc.player.inventory.setInventorySlotContents(lllllllllllIlIIIlIllIIIlIllIlllI, lllllllllllIlIIIlIllIIIlIllllIIl);
                        this.mc.player.inventoryContainer.detectAndSendChanges();
                    }
                    return;
                }
                if (lllllllllllIlIIIlIllIIIlIllIllIl == ClickType.CLONE) {
                    if (lllllllllllIlIIIlIllIIIlIlllllII.getItemStack().func_190926_b() && lllllllllllIlIIIlIllIIIllIIIIllI.getHasStack()) {
                        final ItemStack lllllllllllIlIIIlIllIIIlIllllIII = lllllllllllIlIIIlIllIIIllIIIIllI.getStack().copy();
                        lllllllllllIlIIIlIllIIIlIllllIII.func_190920_e(lllllllllllIlIIIlIllIIIlIllllIII.getMaxStackSize());
                        lllllllllllIlIIIlIllIIIlIlllllII.setItemStack(lllllllllllIlIIIlIllIIIlIllllIII);
                    }
                    return;
                }
                if (lllllllllllIlIIIlIllIIIlIllIllIl == ClickType.THROW) {
                    if (!lllllllllllIlIIIlIllIIIlIllllIlI.func_190926_b()) {
                        final ItemStack lllllllllllIlIIIlIllIIIlIlllIlll = lllllllllllIlIIIlIllIIIlIllllIlI.copy();
                        lllllllllllIlIIIlIllIIIlIlllIlll.func_190920_e((lllllllllllIlIIIlIllIIIlIllIlllI == 0) ? 1 : lllllllllllIlIIIlIllIIIlIlllIlll.getMaxStackSize());
                        this.mc.player.dropItem(lllllllllllIlIIIlIllIIIlIlllIlll, true);
                        this.mc.playerController.sendPacketDropItem(lllllllllllIlIIIlIllIIIlIlllIlll);
                    }
                    return;
                }
                if (!lllllllllllIlIIIlIllIIIlIllllIll.func_190926_b() && !lllllllllllIlIIIlIllIIIlIllllIlI.func_190926_b() && lllllllllllIlIIIlIllIIIlIllllIll.isItemEqual(lllllllllllIlIIIlIllIIIlIllllIlI) && ItemStack.areItemStackTagsEqual(lllllllllllIlIIIlIllIIIlIllllIll, lllllllllllIlIIIlIllIIIlIllllIlI)) {
                    if (lllllllllllIlIIIlIllIIIlIllIlllI == 0) {
                        if (lllllllllllIlIIIlIllIIIllIIIIIlI) {
                            lllllllllllIlIIIlIllIIIlIllllIll.func_190920_e(lllllllllllIlIIIlIllIIIlIllllIll.getMaxStackSize());
                        }
                        else if (lllllllllllIlIIIlIllIIIlIllllIll.func_190916_E() < lllllllllllIlIIIlIllIIIlIllllIll.getMaxStackSize()) {
                            lllllllllllIlIIIlIllIIIlIllllIll.func_190917_f(1);
                        }
                    }
                    else {
                        lllllllllllIlIIIlIllIIIlIllllIll.func_190918_g(1);
                    }
                }
                else if (!lllllllllllIlIIIlIllIIIlIllllIlI.func_190926_b() && lllllllllllIlIIIlIllIIIlIllllIll.func_190926_b()) {
                    lllllllllllIlIIIlIllIIIlIlllllII.setItemStack(lllllllllllIlIIIlIllIIIlIllllIlI.copy());
                    lllllllllllIlIIIlIllIIIlIllllIll = lllllllllllIlIIIlIllIIIlIlllllII.getItemStack();
                    if (lllllllllllIlIIIlIllIIIllIIIIIlI) {
                        lllllllllllIlIIIlIllIIIlIllllIll.func_190920_e(lllllllllllIlIIIlIllIIIlIllllIll.getMaxStackSize());
                    }
                }
                else if (lllllllllllIlIIIlIllIIIlIllIlllI == 0) {
                    lllllllllllIlIIIlIllIIIlIlllllII.setItemStack(ItemStack.field_190927_a);
                }
                else {
                    lllllllllllIlIIIlIllIIIlIlllllII.getItemStack().func_190918_g(1);
                }
            }
            else if (this.inventorySlots != null) {
                final ItemStack lllllllllllIlIIIlIllIIIlIlllIllI = (lllllllllllIlIIIlIllIIIllIIIIllI == null) ? ItemStack.field_190927_a : this.inventorySlots.getSlot(lllllllllllIlIIIlIllIIIllIIIIllI.slotNumber).getStack();
                this.inventorySlots.slotClick((lllllllllllIlIIIlIllIIIllIIIIllI == null) ? lllllllllllIlIIIlIllIIIllIIIIlIl : lllllllllllIlIIIlIllIIIllIIIIllI.slotNumber, lllllllllllIlIIIlIllIIIlIllIlllI, lllllllllllIlIIIlIllIIIlIllIllIl, this.mc.player);
                if (Container.getDragEvent(lllllllllllIlIIIlIllIIIlIllIlllI) == 2) {
                    for (int lllllllllllIlIIIlIllIIIlIlllIlIl = 0; lllllllllllIlIIIlIllIIIlIlllIlIl < 9; ++lllllllllllIlIIIlIllIIIlIlllIlIl) {
                        this.mc.playerController.sendSlotPacket(this.inventorySlots.getSlot(45 + lllllllllllIlIIIlIllIIIlIlllIlIl).getStack(), 36 + lllllllllllIlIIIlIllIIIlIlllIlIl);
                    }
                }
                else if (lllllllllllIlIIIlIllIIIllIIIIllI != null) {
                    final ItemStack lllllllllllIlIIIlIllIIIlIlllIlII = this.inventorySlots.getSlot(lllllllllllIlIIIlIllIIIllIIIIllI.slotNumber).getStack();
                    this.mc.playerController.sendSlotPacket(lllllllllllIlIIIlIllIIIlIlllIlII, lllllllllllIlIIIlIllIIIllIIIIllI.slotNumber - this.inventorySlots.inventorySlots.size() + 9 + 36);
                    final int lllllllllllIlIIIlIllIIIlIlllIIll = 45 + lllllllllllIlIIIlIllIIIlIllIlllI;
                    if (lllllllllllIlIIIlIllIIIlIllIllIl == ClickType.SWAP) {
                        this.mc.playerController.sendSlotPacket(lllllllllllIlIIIlIllIIIlIlllIllI, lllllllllllIlIIIlIllIIIlIlllIIll - this.inventorySlots.inventorySlots.size() + 9 + 36);
                    }
                    else if (lllllllllllIlIIIlIllIIIlIllIllIl == ClickType.THROW && !lllllllllllIlIIIlIllIIIlIlllIllI.func_190926_b()) {
                        final ItemStack lllllllllllIlIIIlIllIIIlIlllIIlI = lllllllllllIlIIIlIllIIIlIlllIllI.copy();
                        lllllllllllIlIIIlIllIIIlIlllIIlI.func_190920_e((lllllllllllIlIIIlIllIIIlIllIlllI == 0) ? 1 : lllllllllllIlIIIlIllIIIlIlllIIlI.getMaxStackSize());
                        this.mc.player.dropItem(lllllllllllIlIIIlIllIIIlIlllIIlI, true);
                        this.mc.playerController.sendPacketDropItem(lllllllllllIlIIIlIllIIIlIlllIIlI);
                    }
                    this.mc.player.inventoryContainer.detectAndSendChanges();
                }
            }
        }
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIlIIIlIllIIIIIllllllI, final int lllllllllllIlIIIlIllIIIIIlllIlIl, final int lllllllllllIlIIIlIllIIIIIlllIlII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        RenderHelper.enableGUIStandardItemLighting();
        final CreativeTabs lllllllllllIlIIIlIllIIIIIllllIll = CreativeTabs.CREATIVE_TAB_ARRAY[GuiContainerCreative.selectedTabIndex];
        Exception lllllllllllIlIIIlIllIIIIIllIllll;
        for (int length = (lllllllllllIlIIIlIllIIIIIllIllll = (Exception)(Object)CreativeTabs.CREATIVE_TAB_ARRAY).length, i = 0; i < length; ++i) {
            final CreativeTabs lllllllllllIlIIIlIllIIIIIllllIlI = lllllllllllIlIIIlIllIIIIIllIllll[i];
            this.mc.getTextureManager().bindTexture(GuiContainerCreative.CREATIVE_INVENTORY_TABS);
            if (lllllllllllIlIIIlIllIIIIIllllIlI.getTabIndex() != GuiContainerCreative.selectedTabIndex) {
                this.drawTab(lllllllllllIlIIIlIllIIIIIllllIlI);
            }
        }
        this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/creative_inventory/tab_" + lllllllllllIlIIIlIllIIIIIllllIll.getBackgroundImageName()));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.searchField.drawTextBox();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lllllllllllIlIIIlIllIIIIIllllIIl = this.guiLeft + 175;
        final int lllllllllllIlIIIlIllIIIIIllllIII = this.guiTop + 18;
        final int lllllllllllIlIIIlIllIIIIIlllIlll = lllllllllllIlIIIlIllIIIIIllllIII + 112;
        this.mc.getTextureManager().bindTexture(GuiContainerCreative.CREATIVE_INVENTORY_TABS);
        if (lllllllllllIlIIIlIllIIIIIllllIll.shouldHidePlayerInventory()) {
            this.drawTexturedModalRect(lllllllllllIlIIIlIllIIIIIllllIIl, lllllllllllIlIIIlIllIIIIIllllIII + (int)((lllllllllllIlIIIlIllIIIIIlllIlll - lllllllllllIlIIIlIllIIIIIllllIII - 17) * this.currentScroll), 232 + (this.needsScrollBars() ? 0 : 12), 0, 12, 15);
        }
        this.drawTab(lllllllllllIlIIIlIllIIIIIllllIll);
        if (lllllllllllIlIIIlIllIIIIIllllIll == CreativeTabs.INVENTORY) {
            GuiInventory.drawEntityOnScreen(this.guiLeft + 88, this.guiTop + 45, 20, (float)(this.guiLeft + 88 - lllllllllllIlIIIlIllIIIIIlllIlIl), (float)(this.guiTop + 45 - 30 - lllllllllllIlIIIlIllIIIIIlllIlII), this.mc.player);
        }
    }
    
    @Override
    protected void updateActivePotionEffects() {
        final int lllllllllllIlIIIlIllIIIlIllIIlII = this.guiLeft;
        super.updateActivePotionEffects();
        if (this.searchField != null && this.guiLeft != lllllllllllIlIIIlIllIIIlIllIIlII) {
            this.searchField.xPosition = this.guiLeft + 82;
        }
    }
    
    public int getSelectedTabIndex() {
        return GuiContainerCreative.selectedTabIndex;
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIIIlIllIIIIllIIIIll, final int lllllllllllIlIIIlIllIIIIlIllIllI, final float lllllllllllIlIIIlIllIIIIlIllIlIl) {
        this.drawDefaultBackground();
        final boolean lllllllllllIlIIIlIllIIIIllIIIIII = Mouse.isButtonDown(0);
        final int lllllllllllIlIIIlIllIIIIlIllllll = this.guiLeft;
        final int lllllllllllIlIIIlIllIIIIlIlllllI = this.guiTop;
        final int lllllllllllIlIIIlIllIIIIlIllllIl = lllllllllllIlIIIlIllIIIIlIllllll + 175;
        final int lllllllllllIlIIIlIllIIIIlIllllII = lllllllllllIlIIIlIllIIIIlIlllllI + 18;
        final int lllllllllllIlIIIlIllIIIIlIlllIll = lllllllllllIlIIIlIllIIIIlIllllIl + 14;
        final int lllllllllllIlIIIlIllIIIIlIlllIlI = lllllllllllIlIIIlIllIIIIlIllllII + 112;
        if (!this.wasClicking && lllllllllllIlIIIlIllIIIIllIIIIII && lllllllllllIlIIIlIllIIIIllIIIIll >= lllllllllllIlIIIlIllIIIIlIllllIl && lllllllllllIlIIIlIllIIIIlIllIllI >= lllllllllllIlIIIlIllIIIIlIllllII && lllllllllllIlIIIlIllIIIIllIIIIll < lllllllllllIlIIIlIllIIIIlIlllIll && lllllllllllIlIIIlIllIIIIlIllIllI < lllllllllllIlIIIlIllIIIIlIlllIlI) {
            this.isScrolling = this.needsScrollBars();
        }
        if (!lllllllllllIlIIIlIllIIIIllIIIIII) {
            this.isScrolling = false;
        }
        this.wasClicking = lllllllllllIlIIIlIllIIIIllIIIIII;
        if (this.isScrolling) {
            this.currentScroll = (lllllllllllIlIIIlIllIIIIlIllIllI - lllllllllllIlIIIlIllIIIIlIllllII - 7.5f) / (lllllllllllIlIIIlIllIIIIlIlllIlI - lllllllllllIlIIIlIllIIIIlIllllII - 15.0f);
            this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0f, 1.0f);
            ((ContainerCreative)this.inventorySlots).scrollTo(this.currentScroll);
        }
        super.drawScreen(lllllllllllIlIIIlIllIIIIllIIIIll, lllllllllllIlIIIlIllIIIIlIllIllI, lllllllllllIlIIIlIllIIIIlIllIlIl);
        short lllllllllllIlIIIlIllIIIIlIlIlIlI;
        for (String lllllllllllIlIIIlIllIIIIlIlIlIll = (String)((CreativeTabs[])(Object)(lllllllllllIlIIIlIllIIIIlIlIlIlI = (short)(Object)CreativeTabs.CREATIVE_TAB_ARRAY)).length, lllllllllllIlIIIlIllIIIIlIlIllII = (String)0; lllllllllllIlIIIlIllIIIIlIlIllII < lllllllllllIlIIIlIllIIIIlIlIlIll; ++lllllllllllIlIIIlIllIIIIlIlIllII) {
            final CreativeTabs lllllllllllIlIIIlIllIIIIlIlllIIl = lllllllllllIlIIIlIllIIIIlIlIlIlI[lllllllllllIlIIIlIllIIIIlIlIllII];
            if (this.renderCreativeInventoryHoveringText(lllllllllllIlIIIlIllIIIIlIlllIIl, lllllllllllIlIIIlIllIIIIllIIIIll, lllllllllllIlIIIlIllIIIIlIllIllI)) {
                break;
            }
        }
        if (this.destroyItemSlot != null && GuiContainerCreative.selectedTabIndex == CreativeTabs.INVENTORY.getTabIndex() && this.isPointInRegion(this.destroyItemSlot.xDisplayPosition, this.destroyItemSlot.yDisplayPosition, 16, 16, lllllllllllIlIIIlIllIIIIllIIIIll, lllllllllllIlIIIlIllIIIIlIllIllI)) {
            this.drawCreativeTabHoveringText(I18n.format("inventory.binSlot", new Object[0]), lllllllllllIlIIIlIllIIIIllIIIIll, lllllllllllIlIIIlIllIIIIlIllIllI);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableLighting();
        this.func_191948_b(lllllllllllIlIIIlIllIIIIllIIIIll, lllllllllllIlIIIlIllIIIIlIllIllI);
    }
    
    class CreativeSlot extends Slot
    {
        private final /* synthetic */ Slot slot;
        
        @Override
        public int getItemStackLimit(final ItemStack lllllllllllIIllIIIIlIIlllIlIIIIl) {
            return this.slot.getItemStackLimit(lllllllllllIIllIIIIlIIlllIlIIIIl);
        }
        
        @Override
        public ItemStack decrStackSize(final int lllllllllllIIllIIIIlIIlllIIlIllI) {
            return this.slot.decrStackSize(lllllllllllIIllIIIIlIIlllIIlIllI);
        }
        
        @Nullable
        @Override
        public String getSlotTexture() {
            return this.slot.getSlotTexture();
        }
        
        @Override
        public boolean getHasStack() {
            return this.slot.getHasStack();
        }
        
        @Override
        public void putStack(final ItemStack lllllllllllIIllIIIIlIIlllIlIlIll) {
            this.slot.putStack(lllllllllllIIllIIIIlIIlllIlIlIll);
        }
        
        @Override
        public ItemStack getStack() {
            return this.slot.getStack();
        }
        
        @Override
        public ItemStack func_190901_a(final EntityPlayer lllllllllllIIllIIIIlIIlllIlllllI, final ItemStack lllllllllllIIllIIIIlIIlllIllllIl) {
            this.slot.func_190901_a(lllllllllllIIllIIIIlIIlllIlllllI, lllllllllllIIllIIIIlIIlllIllllIl);
            return lllllllllllIIllIIIIlIIlllIllllIl;
        }
        
        @Override
        public void onSlotChanged() {
            this.slot.onSlotChanged();
        }
        
        @Override
        public boolean isItemValid(final ItemStack lllllllllllIIllIIIIlIIlllIlllIIl) {
            return this.slot.isItemValid(lllllllllllIIllIIIIlIIlllIlllIIl);
        }
        
        @Override
        public boolean canTakeStack(final EntityPlayer lllllllllllIIllIIIIlIIlllIIIIllI) {
            return this.slot.canTakeStack(lllllllllllIIllIIIIlIIlllIIIIllI);
        }
        
        public CreativeSlot(final Slot lllllllllllIIllIIIIlIIllllIIlIll, final int lllllllllllIIllIIIIlIIllllIIlIlI) {
            super(lllllllllllIIllIIIIlIIllllIIlIll.inventory, lllllllllllIIllIIIIlIIllllIIlIlI, 0, 0);
            this.slot = lllllllllllIIllIIIIlIIllllIIlIll;
        }
        
        @Override
        public boolean isHere(final IInventory lllllllllllIIllIIIIlIIlllIIIlllI, final int lllllllllllIIllIIIIlIIlllIIIllIl) {
            return this.slot.isHere(lllllllllllIIllIIIIlIIlllIIIlllI, lllllllllllIIllIIIIlIIlllIIIllIl);
        }
        
        @Override
        public boolean canBeHovered() {
            return this.slot.canBeHovered();
        }
        
        @Override
        public int getSlotStackLimit() {
            return this.slot.getSlotStackLimit();
        }
    }
    
    static class LockedSlot extends Slot
    {
        @Override
        public boolean canTakeStack(final EntityPlayer lllllllllllIlllIlllIIIlIIlIIllll) {
            if (super.canTakeStack(lllllllllllIlllIlllIIIlIIlIIllll) && this.getHasStack()) {
                return this.getStack().getSubCompound("CustomCreativeLock") == null;
            }
            return !this.getHasStack();
        }
        
        public LockedSlot(final IInventory lllllllllllIlllIlllIIIlIIlIllIII, final int lllllllllllIlllIlllIIIlIIlIlIlll, final int lllllllllllIlllIlllIIIlIIlIllIll, final int lllllllllllIlllIlllIIIlIIlIllIlI) {
            super(lllllllllllIlllIlllIIIlIIlIllIII, lllllllllllIlllIlllIIIlIIlIlIlll, lllllllllllIlllIlllIIIlIIlIllIll, lllllllllllIlllIlllIIIlIIlIllIlI);
        }
    }
    
    public static class ContainerCreative extends Container
    {
        public /* synthetic */ NonNullList<ItemStack> itemList;
        
        @Override
        public boolean canMergeSlot(final ItemStack llllllllllIlllIIlllIllIIIIIllllI, final Slot llllllllllIlllIIlllIllIIIIIlllII) {
            return llllllllllIlllIIlllIllIIIIIlllII.yDisplayPosition > 90;
        }
        
        public void scrollTo(final float llllllllllIlllIIlllIllIIIIlllIlI) {
            final int llllllllllIlllIIlllIllIIIIlllIIl = (this.itemList.size() + 9 - 1) / 9 - 5;
            int llllllllllIlllIIlllIllIIIIlllIII = (int)(llllllllllIlllIIlllIllIIIIlllIlI * llllllllllIlllIIlllIllIIIIlllIIl + 0.5);
            if (llllllllllIlllIIlllIllIIIIlllIII < 0) {
                llllllllllIlllIIlllIllIIIIlllIII = 0;
            }
            for (int llllllllllIlllIIlllIllIIIIllIlll = 0; llllllllllIlllIIlllIllIIIIllIlll < 5; ++llllllllllIlllIIlllIllIIIIllIlll) {
                for (int llllllllllIlllIIlllIllIIIIllIllI = 0; llllllllllIlllIIlllIllIIIIllIllI < 9; ++llllllllllIlllIIlllIllIIIIllIllI) {
                    final int llllllllllIlllIIlllIllIIIIllIlIl = llllllllllIlllIIlllIllIIIIllIllI + (llllllllllIlllIIlllIllIIIIllIlll + llllllllllIlllIIlllIllIIIIlllIII) * 9;
                    if (llllllllllIlllIIlllIllIIIIllIlIl >= 0 && llllllllllIlllIIlllIllIIIIllIlIl < this.itemList.size()) {
                        GuiContainerCreative.basicInventory.setInventorySlotContents(llllllllllIlllIIlllIllIIIIllIllI + llllllllllIlllIIlllIllIIIIllIlll * 9, this.itemList.get(llllllllllIlllIIlllIllIIIIllIlIl));
                    }
                    else {
                        GuiContainerCreative.basicInventory.setInventorySlotContents(llllllllllIlllIIlllIllIIIIllIllI + llllllllllIlllIIlllIllIIIIllIlll * 9, ItemStack.field_190927_a);
                    }
                }
            }
        }
        
        @Override
        public boolean canDragIntoSlot(final Slot llllllllllIlllIIlllIllIIIIIllIII) {
            return llllllllllIlllIIlllIllIIIIIllIII.inventory instanceof InventoryPlayer || (llllllllllIlllIIlllIllIIIIIllIII.yDisplayPosition > 90 && llllllllllIlllIIlllIllIIIIIllIII.xDisplayPosition <= 162);
        }
        
        public boolean canScroll() {
            return this.itemList.size() > 45;
        }
        
        public ContainerCreative(final EntityPlayer llllllllllIlllIIlllIllIIIlIIlIII) {
            this.itemList = NonNullList.func_191196_a();
            final InventoryPlayer llllllllllIlllIIlllIllIIIlIIllIl = llllllllllIlllIIlllIllIIIlIIlIII.inventory;
            for (int llllllllllIlllIIlllIllIIIlIIllII = 0; llllllllllIlllIIlllIllIIIlIIllII < 5; ++llllllllllIlllIIlllIllIIIlIIllII) {
                for (int llllllllllIlllIIlllIllIIIlIIlIll = 0; llllllllllIlllIIlllIllIIIlIIlIll < 9; ++llllllllllIlllIIlllIllIIIlIIlIll) {
                    this.addSlotToContainer(new LockedSlot(GuiContainerCreative.basicInventory, llllllllllIlllIIlllIllIIIlIIllII * 9 + llllllllllIlllIIlllIllIIIlIIlIll, 9 + llllllllllIlllIIlllIllIIIlIIlIll * 18, 18 + llllllllllIlllIIlllIllIIIlIIllII * 18));
                }
            }
            for (int llllllllllIlllIIlllIllIIIlIIlIlI = 0; llllllllllIlllIIlllIllIIIlIIlIlI < 9; ++llllllllllIlllIIlllIllIIIlIIlIlI) {
                this.addSlotToContainer(new Slot(llllllllllIlllIIlllIllIIIlIIllIl, llllllllllIlllIIlllIllIIIlIIlIlI, 9 + llllllllllIlllIIlllIllIIIlIIlIlI * 18, 112));
            }
            this.scrollTo(0.0f);
        }
        
        @Override
        public boolean canInteractWith(final EntityPlayer llllllllllIlllIIlllIllIIIlIIIIll) {
            return true;
        }
        
        @Override
        public ItemStack transferStackInSlot(final EntityPlayer llllllllllIlllIIlllIllIIIIlIIllI, final int llllllllllIlllIIlllIllIIIIlIIIlI) {
            if (llllllllllIlllIIlllIllIIIIlIIIlI >= this.inventorySlots.size() - 9 && llllllllllIlllIIlllIllIIIIlIIIlI < this.inventorySlots.size()) {
                final Slot llllllllllIlllIIlllIllIIIIlIIlII = this.inventorySlots.get(llllllllllIlllIIlllIllIIIIlIIIlI);
                if (llllllllllIlllIIlllIllIIIIlIIlII != null && llllllllllIlllIIlllIllIIIIlIIlII.getHasStack()) {
                    llllllllllIlllIIlllIllIIIIlIIlII.putStack(ItemStack.field_190927_a);
                }
            }
            return ItemStack.field_190927_a;
        }
    }
}
