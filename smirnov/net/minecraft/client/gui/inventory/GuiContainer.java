// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.input.Mouse;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.player.ItemScroller;
import ru.rockstar.Main;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import com.google.common.collect.Sets;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.text.TextFormatting;
import java.io.IOException;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import java.util.Set;
import ru.rockstar.api.utils.world.TimerHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.GuiScreen;

public abstract class GuiContainer extends GuiScreen
{
    private /* synthetic */ boolean isRightMouseClick;
    private /* synthetic */ long dragItemDropDelay;
    private /* synthetic */ ItemStack draggedStack;
    private /* synthetic */ Slot theSlot;
    protected /* synthetic */ int xSize;
    private final /* synthetic */ TimerHelper timerHelper;
    protected /* synthetic */ int ySize;
    private /* synthetic */ long returningStackTime;
    private /* synthetic */ Slot currentDragTargetSlot;
    private /* synthetic */ int touchUpX;
    public static /* synthetic */ float animTicks;
    private /* synthetic */ boolean ignoreMouseUp;
    private /* synthetic */ Slot clickedSlot;
    private /* synthetic */ Slot returningStackDestSlot;
    private /* synthetic */ int dragSplittingButton;
    public static /* synthetic */ float lastTime;
    private /* synthetic */ Slot lastClickSlot;
    private /* synthetic */ int lastClickButton;
    protected final /* synthetic */ Set<Slot> dragSplittingSlots;
    private /* synthetic */ int touchUpY;
    private /* synthetic */ boolean doubleClick;
    protected /* synthetic */ int guiLeft;
    protected /* synthetic */ boolean dragSplitting;
    private /* synthetic */ ItemStack shiftClickedSlot;
    protected /* synthetic */ int guiTop;
    private /* synthetic */ int dragSplittingLimit;
    private /* synthetic */ int dragSplittingRemnant;
    public /* synthetic */ Container inventorySlots;
    public static /* synthetic */ float addition;
    private /* synthetic */ ItemStack returningStack;
    private /* synthetic */ long lastClickTime;
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    protected boolean checkHotbarKeys(final int lllllllllllIlIIlIIIllIIllllIlIlI) {
        if (this.mc.player.inventory.getItemStack().isEmpty() && this.theSlot != null) {
            for (int lllllllllllIlIIlIIIllIIllllIllII = 0; lllllllllllIlIIlIIIllIIllllIllII < 9; ++lllllllllllIlIIlIIIllIIllllIllII) {
                if (lllllllllllIlIIlIIIllIIllllIlIlI == this.mc.gameSettings.keyBindsHotbar[lllllllllllIlIIlIIIllIIllllIllII].getKeyCode()) {
                    this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, lllllllllllIlIIlIIIllIIllllIllII, ClickType.SWAP);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.mc.player.openContainer = this.inventorySlots;
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
    }
    
    protected abstract void drawGuiContainerBackgroundLayer(final float p0, final int p1, final int p2);
    
    @Override
    protected void keyTyped(final char lllllllllllIlIIlIIIllIIlllllIlIl, final int lllllllllllIlIIlIIIllIIlllllIIlI) throws IOException {
        if (lllllllllllIlIIlIIIllIIlllllIIlI == 1 || lllllllllllIlIIlIIIllIIlllllIIlI == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.player.closeScreen();
        }
        this.checkHotbarKeys(lllllllllllIlIIlIIIllIIlllllIIlI);
        if (this.theSlot != null && this.theSlot.getHasStack()) {
            if (lllllllllllIlIIlIIIllIIlllllIIlI == this.mc.gameSettings.keyBindPickBlock.getKeyCode()) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, 0, ClickType.CLONE);
            }
            else if (lllllllllllIlIIlIIIllIIlllllIIlI == this.mc.gameSettings.keyBindDrop.getKeyCode()) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, GuiScreen.isCtrlKeyDown() ? 1 : 0, ClickType.THROW);
            }
        }
    }
    
    protected boolean func_193983_c(final int lllllllllllIlIIlIIIllIlIIllIlIll, final int lllllllllllIlIIlIIIllIlIIllIllll, final int lllllllllllIlIIlIIIllIlIIllIlIIl, final int lllllllllllIlIIlIIIllIlIIllIlIII) {
        return lllllllllllIlIIlIIIllIlIIllIlIll < lllllllllllIlIIlIIIllIlIIllIlIIl || lllllllllllIlIIlIIIllIlIIllIllll < lllllllllllIlIIlIIIllIlIIllIlIII || lllllllllllIlIIlIIIllIlIIllIlIll >= lllllllllllIlIIlIIIllIlIIllIlIIl + this.xSize || lllllllllllIlIIlIIIllIlIIllIllll >= lllllllllllIlIIlIIIllIlIIllIlIII + this.ySize;
    }
    
    protected void func_191948_b(final int lllllllllllIlIIlIIIllIlIlllllIIl, final int lllllllllllIlIIlIIIllIlIlllllIll) {
        if (this.mc.player.inventory.getItemStack().isEmpty() && this.theSlot != null && this.theSlot.getHasStack()) {
            this.renderToolTip(this.theSlot.getStack(), lllllllllllIlIIlIIIllIlIlllllIIl, lllllllllllIlIIlIIIllIlIlllllIll);
        }
    }
    
    private void drawSlot(final Slot lllllllllllIlIIlIIIllIlIllIIllIl) {
        final int lllllllllllIlIIlIIIllIlIllIllIII = lllllllllllIlIIlIIIllIlIllIIllIl.xDisplayPosition;
        final int lllllllllllIlIIlIIIllIlIllIlIlll = lllllllllllIlIIlIIIllIlIllIIllIl.yDisplayPosition;
        ItemStack lllllllllllIlIIlIIIllIlIllIlIllI = lllllllllllIlIIlIIIllIlIllIIllIl.getStack();
        boolean lllllllllllIlIIlIIIllIlIllIlIlIl = false;
        boolean lllllllllllIlIIlIIIllIlIllIlIlII = lllllllllllIlIIlIIIllIlIllIIllIl == this.clickedSlot && !this.draggedStack.isEmpty() && !this.isRightMouseClick;
        final ItemStack lllllllllllIlIIlIIIllIlIllIlIIll = this.mc.player.inventory.getItemStack();
        String lllllllllllIlIIlIIIllIlIllIlIIlI = null;
        if (lllllllllllIlIIlIIIllIlIllIIllIl == this.clickedSlot && !this.draggedStack.isEmpty() && this.isRightMouseClick && !lllllllllllIlIIlIIIllIlIllIlIllI.isEmpty()) {
            lllllllllllIlIIlIIIllIlIllIlIllI = lllllllllllIlIIlIIIllIlIllIlIllI.copy();
            lllllllllllIlIIlIIIllIlIllIlIllI.func_190920_e(lllllllllllIlIIlIIIllIlIllIlIllI.getCount() / 2);
        }
        else if (this.dragSplitting && this.dragSplittingSlots.contains(lllllllllllIlIIlIIIllIlIllIIllIl) && !lllllllllllIlIIlIIIllIlIllIlIIll.isEmpty()) {
            if (this.dragSplittingSlots.size() == 1) {
                return;
            }
            if (Container.canAddItemToSlot(lllllllllllIlIIlIIIllIlIllIIllIl, lllllllllllIlIIlIIIllIlIllIlIIll, true) && this.inventorySlots.canDragIntoSlot(lllllllllllIlIIlIIIllIlIllIIllIl)) {
                lllllllllllIlIIlIIIllIlIllIlIllI = lllllllllllIlIIlIIIllIlIllIlIIll.copy();
                lllllllllllIlIIlIIIllIlIllIlIlIl = true;
                Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, lllllllllllIlIIlIIIllIlIllIlIllI, lllllllllllIlIIlIIIllIlIllIIllIl.getStack().isEmpty() ? 0 : lllllllllllIlIIlIIIllIlIllIIllIl.getStack().getCount());
                final int lllllllllllIlIIlIIIllIlIllIlIIIl = Math.min(lllllllllllIlIIlIIIllIlIllIlIllI.getMaxStackSize(), lllllllllllIlIIlIIIllIlIllIIllIl.getItemStackLimit(lllllllllllIlIIlIIIllIlIllIlIllI));
                if (lllllllllllIlIIlIIIllIlIllIlIllI.getCount() > lllllllllllIlIIlIIIllIlIllIlIIIl) {
                    lllllllllllIlIIlIIIllIlIllIlIIlI = String.valueOf(TextFormatting.YELLOW.toString()) + lllllllllllIlIIlIIIllIlIllIlIIIl;
                    lllllllllllIlIIlIIIllIlIllIlIllI.func_190920_e(lllllllllllIlIIlIIIllIlIllIlIIIl);
                }
            }
            else {
                this.dragSplittingSlots.remove(lllllllllllIlIIlIIIllIlIllIIllIl);
                this.updateDragSplitting();
            }
        }
        this.zLevel = 100.0f;
        this.itemRender.zLevel = 100.0f;
        if (lllllllllllIlIIlIIIllIlIllIlIllI.isEmpty() && lllllllllllIlIIlIIIllIlIllIIllIl.canBeHovered()) {
            final String lllllllllllIlIIlIIIllIlIllIlIIII = lllllllllllIlIIlIIIllIlIllIIllIl.getSlotTexture();
            if (lllllllllllIlIIlIIIllIlIllIlIIII != null) {
                final TextureAtlasSprite lllllllllllIlIIlIIIllIlIllIIllll = this.mc.getTextureMapBlocks().getAtlasSprite(lllllllllllIlIIlIIIllIlIllIlIIII);
                GlStateManager.disableLighting();
                this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                this.drawTexturedModalRect(lllllllllllIlIIlIIIllIlIllIllIII, lllllllllllIlIIlIIIllIlIllIlIlll, lllllllllllIlIIlIIIllIlIllIIllll, 16, 16);
                GlStateManager.enableLighting();
                lllllllllllIlIIlIIIllIlIllIlIlII = true;
            }
        }
        if (!lllllllllllIlIIlIIIllIlIllIlIlII) {
            if (lllllllllllIlIIlIIIllIlIllIlIlIl) {
                Gui.drawRect(lllllllllllIlIIlIIIllIlIllIllIII, lllllllllllIlIIlIIIllIlIllIlIlll, lllllllllllIlIIlIIIllIlIllIllIII + 16, lllllllllllIlIIlIIIllIlIllIlIlll + 16, -2130706433);
            }
            GlStateManager.enableDepth();
            this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, lllllllllllIlIIlIIIllIlIllIlIllI, lllllllllllIlIIlIIIllIlIllIllIII, lllllllllllIlIIlIIIllIlIllIlIlll);
            this.itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, lllllllllllIlIIlIIIllIlIllIlIllI, lllllllllllIlIIlIIIllIlIllIllIII, lllllllllllIlIIlIIIllIlIllIlIlll, lllllllllllIlIIlIIIllIlIllIlIIlI);
        }
        this.itemRender.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllIlIIlIIIllIlIIIlllIII, final int lllllllllllIlIIlIIIllIlIIlIIIlII, final int lllllllllllIlIIlIIIllIlIIlIIIIll) {
        final Slot lllllllllllIlIIlIIIllIlIIlIIIIlI = this.getSlotAtPosition(lllllllllllIlIIlIIIllIlIIIlllIII, lllllllllllIlIIlIIIllIlIIlIIIlII);
        final int lllllllllllIlIIlIIIllIlIIlIIIIIl = this.guiLeft;
        final int lllllllllllIlIIlIIIllIlIIlIIIIII = this.guiTop;
        final boolean lllllllllllIlIIlIIIllIlIIIllllll = this.func_193983_c(lllllllllllIlIIlIIIllIlIIIlllIII, lllllllllllIlIIlIIIllIlIIlIIIlII, lllllllllllIlIIlIIIllIlIIlIIIIIl, lllllllllllIlIIlIIIllIlIIlIIIIII);
        int lllllllllllIlIIlIIIllIlIIIlllllI = -1;
        if (lllllllllllIlIIlIIIllIlIIlIIIIlI != null) {
            lllllllllllIlIIlIIIllIlIIIlllllI = lllllllllllIlIIlIIIllIlIIlIIIIlI.slotNumber;
        }
        if (lllllllllllIlIIlIIIllIlIIIllllll) {
            lllllllllllIlIIlIIIllIlIIIlllllI = -999;
        }
        if (this.doubleClick && lllllllllllIlIIlIIIllIlIIlIIIIlI != null && lllllllllllIlIIlIIIllIlIIlIIIIll == 0 && this.inventorySlots.canMergeSlot(ItemStack.field_190927_a, lllllllllllIlIIlIIIllIlIIlIIIIlI)) {
            if (isShiftKeyDown()) {
                if (!this.shiftClickedSlot.isEmpty()) {
                    for (final Slot lllllllllllIlIIlIIIllIlIIIllllIl : this.inventorySlots.inventorySlots) {
                        if (lllllllllllIlIIlIIIllIlIIIllllIl != null && lllllllllllIlIIlIIIllIlIIIllllIl.canTakeStack(this.mc.player) && lllllllllllIlIIlIIIllIlIIIllllIl.getHasStack() && lllllllllllIlIIlIIIllIlIIIllllIl.inventory == lllllllllllIlIIlIIIllIlIIlIIIIlI.inventory && Container.canAddItemToSlot(lllllllllllIlIIlIIIllIlIIIllllIl, this.shiftClickedSlot, true)) {
                            this.handleMouseClick(lllllllllllIlIIlIIIllIlIIIllllIl, lllllllllllIlIIlIIIllIlIIIllllIl.slotNumber, lllllllllllIlIIlIIIllIlIIlIIIIll, ClickType.QUICK_MOVE);
                        }
                    }
                }
            }
            else {
                this.handleMouseClick(lllllllllllIlIIlIIIllIlIIlIIIIlI, lllllllllllIlIIlIIIllIlIIIlllllI, lllllllllllIlIIlIIIllIlIIlIIIIll, ClickType.PICKUP_ALL);
            }
            this.doubleClick = false;
            this.lastClickTime = 0L;
        }
        else {
            if (this.dragSplitting && this.dragSplittingButton != lllllllllllIlIIlIIIllIlIIlIIIIll) {
                this.dragSplitting = false;
                this.dragSplittingSlots.clear();
                this.ignoreMouseUp = true;
                return;
            }
            if (this.ignoreMouseUp) {
                this.ignoreMouseUp = false;
                return;
            }
            if (this.clickedSlot != null && this.mc.gameSettings.touchscreen) {
                if (lllllllllllIlIIlIIIllIlIIlIIIIll == 0 || lllllllllllIlIIlIIIllIlIIlIIIIll == 1) {
                    if (this.draggedStack.isEmpty() && lllllllllllIlIIlIIIllIlIIlIIIIlI != this.clickedSlot) {
                        this.draggedStack = this.clickedSlot.getStack();
                    }
                    final boolean lllllllllllIlIIlIIIllIlIIIllllII = Container.canAddItemToSlot(lllllllllllIlIIlIIIllIlIIlIIIIlI, this.draggedStack, false);
                    if (lllllllllllIlIIlIIIllIlIIIlllllI != -1 && !this.draggedStack.isEmpty() && lllllllllllIlIIlIIIllIlIIIllllII) {
                        this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, lllllllllllIlIIlIIIllIlIIlIIIIll, ClickType.PICKUP);
                        this.handleMouseClick(lllllllllllIlIIlIIIllIlIIlIIIIlI, lllllllllllIlIIlIIIllIlIIIlllllI, 0, ClickType.PICKUP);
                        if (this.mc.player.inventory.getItemStack().isEmpty()) {
                            this.returningStack = ItemStack.field_190927_a;
                        }
                        else {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, lllllllllllIlIIlIIIllIlIIlIIIIll, ClickType.PICKUP);
                            this.touchUpX = lllllllllllIlIIlIIIllIlIIIlllIII - lllllllllllIlIIlIIIllIlIIlIIIIIl;
                            this.touchUpY = lllllllllllIlIIlIIIllIlIIlIIIlII - lllllllllllIlIIlIIIllIlIIlIIIIII;
                            this.returningStackDestSlot = this.clickedSlot;
                            this.returningStack = this.draggedStack;
                            this.returningStackTime = Minecraft.getSystemTime();
                        }
                    }
                    else if (!this.draggedStack.isEmpty()) {
                        this.touchUpX = lllllllllllIlIIlIIIllIlIIIlllIII - lllllllllllIlIIlIIIllIlIIlIIIIIl;
                        this.touchUpY = lllllllllllIlIIlIIIllIlIIlIIIlII - lllllllllllIlIIlIIIllIlIIlIIIIII;
                        this.returningStackDestSlot = this.clickedSlot;
                        this.returningStack = this.draggedStack;
                        this.returningStackTime = Minecraft.getSystemTime();
                    }
                    this.draggedStack = ItemStack.field_190927_a;
                    this.clickedSlot = null;
                }
            }
            else if (this.dragSplitting && !this.dragSplittingSlots.isEmpty()) {
                this.handleMouseClick(null, -999, Container.getQuickcraftMask(0, this.dragSplittingLimit), ClickType.QUICK_CRAFT);
                for (final Slot lllllllllllIlIIlIIIllIlIIIlllIll : this.dragSplittingSlots) {
                    this.handleMouseClick(lllllllllllIlIIlIIIllIlIIIlllIll, lllllllllllIlIIlIIIllIlIIIlllIll.slotNumber, Container.getQuickcraftMask(1, this.dragSplittingLimit), ClickType.QUICK_CRAFT);
                }
                this.handleMouseClick(null, -999, Container.getQuickcraftMask(2, this.dragSplittingLimit), ClickType.QUICK_CRAFT);
            }
            else if (!this.mc.player.inventory.getItemStack().isEmpty()) {
                if (lllllllllllIlIIlIIIllIlIIlIIIIll == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                    this.handleMouseClick(lllllllllllIlIIlIIIllIlIIlIIIIlI, lllllllllllIlIIlIIIllIlIIIlllllI, lllllllllllIlIIlIIIllIlIIlIIIIll, ClickType.CLONE);
                }
                else {
                    final boolean lllllllllllIlIIlIIIllIlIIIlllIlI = lllllllllllIlIIlIIIllIlIIIlllllI != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                    if (lllllllllllIlIIlIIIllIlIIIlllIlI) {
                        this.shiftClickedSlot = ((lllllllllllIlIIlIIIllIlIIlIIIIlI != null && lllllllllllIlIIlIIIllIlIIlIIIIlI.getHasStack()) ? lllllllllllIlIIlIIIllIlIIlIIIIlI.getStack().copy() : ItemStack.field_190927_a);
                    }
                    this.handleMouseClick(lllllllllllIlIIlIIIllIlIIlIIIIlI, lllllllllllIlIIlIIIllIlIIIlllllI, lllllllllllIlIIlIIIllIlIIlIIIIll, lllllllllllIlIIlIIIllIlIIIlllIlI ? ClickType.QUICK_MOVE : ClickType.PICKUP);
                }
            }
        }
        if (this.mc.player.inventory.getItemStack().isEmpty()) {
            this.lastClickTime = 0L;
        }
        this.dragSplitting = false;
    }
    
    private Slot getSlotAtPosition(final int lllllllllllIlIIlIIIllIlIlIlIIIIl, final int lllllllllllIlIIlIIIllIlIlIlIIlIl) {
        for (int lllllllllllIlIIlIIIllIlIlIlIIlII = 0; lllllllllllIlIIlIIIllIlIlIlIIlII < this.inventorySlots.inventorySlots.size(); ++lllllllllllIlIIlIIIllIlIlIlIIlII) {
            final Slot lllllllllllIlIIlIIIllIlIlIlIIIll = this.inventorySlots.inventorySlots.get(lllllllllllIlIIlIIIllIlIlIlIIlII);
            if (this.isMouseOverSlot(lllllllllllIlIIlIIIllIlIlIlIIIll, lllllllllllIlIIlIIIllIlIlIlIIIIl, lllllllllllIlIIlIIIllIlIlIlIIlIl) && lllllllllllIlIIlIIIllIlIlIlIIIll.canBeHovered()) {
                return lllllllllllIlIIlIIIllIlIlIlIIIll;
            }
        }
        return null;
    }
    
    public void handleMouseClick(final Slot lllllllllllIlIIlIIIllIlIIIIIIIIl, int lllllllllllIlIIlIIIllIIllllllIll, final int lllllllllllIlIIlIIIllIIllllllIlI, final ClickType lllllllllllIlIIlIIIllIIllllllIIl) {
        if (lllllllllllIlIIlIIIllIlIIIIIIIIl != null) {
            lllllllllllIlIIlIIIllIIllllllIll = lllllllllllIlIIlIIIllIlIIIIIIIIl.slotNumber;
        }
        this.mc.playerController.windowClick(this.inventorySlots.windowId, lllllllllllIlIIlIIIllIIllllllIll, lllllllllllIlIIlIIIllIIllllllIlI, lllllllllllIlIIlIIIllIIllllllIIl, this.mc.player);
    }
    
    @Override
    public void onGuiClosed() {
        GuiContainer.animTicks = 0.0f;
        GuiContainer.addition = 0.0f;
        GuiContainer.lastTime = 0.0f;
        if (this.mc.player != null) {
            this.inventorySlots.onContainerClosed(this.mc.player);
        }
    }
    
    private boolean isMouseOverSlot(final Slot lllllllllllIlIIlIIIllIlIIIlIlIIl, final int lllllllllllIlIIlIIIllIlIIIlIIlII, final int lllllllllllIlIIlIIIllIlIIIlIIlll) {
        return this.isPointInRegion(lllllllllllIlIIlIIIllIlIIIlIlIIl.xDisplayPosition, lllllllllllIlIIlIIIllIlIIIlIlIIl.yDisplayPosition, 16, 16, lllllllllllIlIIlIIIllIlIIIlIIlII, lllllllllllIlIIlIIIllIlIIIlIIlll);
    }
    
    public GuiContainer(final Container lllllllllllIlIIlIIIllIllIIlllIlI) {
        this.xSize = 176;
        this.ySize = 166;
        this.draggedStack = ItemStack.field_190927_a;
        this.returningStack = ItemStack.field_190927_a;
        this.dragSplittingSlots = (Set<Slot>)Sets.newHashSet();
        this.shiftClickedSlot = ItemStack.field_190927_a;
        this.timerHelper = new TimerHelper();
        this.inventorySlots = lllllllllllIlIIlIIIllIllIIlllIlI;
        this.ignoreMouseUp = true;
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead) {
            this.mc.player.closeScreen();
        }
    }
    
    private void updateDragSplitting() {
        final ItemStack lllllllllllIlIIlIIIllIlIlIlllIlI = this.mc.player.inventory.getItemStack();
        if (!lllllllllllIlIIlIIIllIlIlIlllIlI.isEmpty() && this.dragSplitting) {
            if (this.dragSplittingLimit == 2) {
                this.dragSplittingRemnant = lllllllllllIlIIlIIIllIlIlIlllIlI.getMaxStackSize();
            }
            else {
                this.dragSplittingRemnant = lllllllllllIlIIlIIIllIlIlIlllIlI.getCount();
                for (final Slot lllllllllllIlIIlIIIllIlIlIlllIIl : this.dragSplittingSlots) {
                    final ItemStack lllllllllllIlIIlIIIllIlIlIlllIII = lllllllllllIlIIlIIIllIlIlIlllIlI.copy();
                    final ItemStack lllllllllllIlIIlIIIllIlIlIllIlll = lllllllllllIlIIlIIIllIlIlIlllIIl.getStack();
                    final int lllllllllllIlIIlIIIllIlIlIllIllI = lllllllllllIlIIlIIIllIlIlIllIlll.isEmpty() ? 0 : lllllllllllIlIIlIIIllIlIlIllIlll.getCount();
                    Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, lllllllllllIlIIlIIIllIlIlIlllIII, lllllllllllIlIIlIIIllIlIlIllIllI);
                    final int lllllllllllIlIIlIIIllIlIlIllIlIl = Math.min(lllllllllllIlIIlIIIllIlIlIlllIII.getMaxStackSize(), lllllllllllIlIIlIIIllIlIlIlllIIl.getItemStackLimit(lllllllllllIlIIlIIIllIlIlIlllIII));
                    if (lllllllllllIlIIlIIIllIlIlIlllIII.getCount() > lllllllllllIlIIlIIIllIlIlIllIlIl) {
                        lllllllllllIlIIlIIIllIlIlIlllIII.func_190920_e(lllllllllllIlIIlIIIllIlIlIllIlIl);
                    }
                    this.dragSplittingRemnant -= lllllllllllIlIIlIIIllIlIlIlllIII.getCount() - lllllllllllIlIIlIIIllIlIlIllIllI;
                }
            }
        }
    }
    
    private void drawItemStack(final ItemStack lllllllllllIlIIlIIIllIlIllllIIIl, final int lllllllllllIlIIlIIIllIlIlllIlIll, final int lllllllllllIlIIlIIIllIlIlllIllll, final String lllllllllllIlIIlIIIllIlIlllIlllI) {
        GlStateManager.translate(0.0f, 0.0f, 32.0f);
        this.zLevel = 200.0f;
        this.itemRender.zLevel = 200.0f;
        this.itemRender.renderItemAndEffectIntoGUI(lllllllllllIlIIlIIIllIlIllllIIIl, lllllllllllIlIIlIIIllIlIlllIlIll, lllllllllllIlIIlIIIllIlIlllIllll);
        this.itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, lllllllllllIlIIlIIIllIlIllllIIIl, lllllllllllIlIIlIIIllIlIlllIlIll, lllllllllllIlIIlIIIllIlIlllIllll - (this.draggedStack.isEmpty() ? 0 : 8), lllllllllllIlIIlIIIllIlIlllIlllI);
        this.zLevel = 0.0f;
        this.itemRender.zLevel = 0.0f;
    }
    
    @Override
    protected void mouseClickMove(final int lllllllllllIlIIlIIIllIlIIlIlIlll, final int lllllllllllIlIIlIIIllIlIIlIlIllI, final int lllllllllllIlIIlIIIllIlIIlIlIlIl, final long lllllllllllIlIIlIIIllIlIIlIlllII) {
        final Slot lllllllllllIlIIlIIIllIlIIlIllIll = this.getSlotAtPosition(lllllllllllIlIIlIIIllIlIIlIlIlll, lllllllllllIlIIlIIIllIlIIlIlIllI);
        final ItemStack lllllllllllIlIIlIIIllIlIIlIllIlI = this.mc.player.inventory.getItemStack();
        if (this.clickedSlot != null && this.mc.gameSettings.touchscreen) {
            if (lllllllllllIlIIlIIIllIlIIlIlIlIl == 0 || lllllllllllIlIIlIIIllIlIIlIlIlIl == 1) {
                if (this.draggedStack.isEmpty()) {
                    if (lllllllllllIlIIlIIIllIlIIlIllIll != this.clickedSlot && !this.clickedSlot.getStack().isEmpty()) {
                        this.draggedStack = this.clickedSlot.getStack().copy();
                    }
                }
                else if (this.draggedStack.getCount() > 1 && lllllllllllIlIIlIIIllIlIIlIllIll != null && Container.canAddItemToSlot(lllllllllllIlIIlIIIllIlIIlIllIll, this.draggedStack, false)) {
                    final long lllllllllllIlIIlIIIllIlIIlIllIIl = Minecraft.getSystemTime();
                    if (this.currentDragTargetSlot == lllllllllllIlIIlIIIllIlIIlIllIll) {
                        if (lllllllllllIlIIlIIIllIlIIlIllIIl - this.dragItemDropDelay > 500L) {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, ClickType.PICKUP);
                            this.handleMouseClick(lllllllllllIlIIlIIIllIlIIlIllIll, lllllllllllIlIIlIIIllIlIIlIllIll.slotNumber, 1, ClickType.PICKUP);
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, ClickType.PICKUP);
                            this.dragItemDropDelay = lllllllllllIlIIlIIIllIlIIlIllIIl + 750L;
                            this.draggedStack.func_190918_g(1);
                        }
                    }
                    else {
                        this.currentDragTargetSlot = lllllllllllIlIIlIIIllIlIIlIllIll;
                        this.dragItemDropDelay = lllllllllllIlIIlIIIllIlIIlIllIIl;
                    }
                }
            }
        }
        else if (this.dragSplitting && lllllllllllIlIIlIIIllIlIIlIllIll != null && !lllllllllllIlIIlIIIllIlIIlIllIlI.isEmpty() && (lllllllllllIlIIlIIIllIlIIlIllIlI.getCount() > this.dragSplittingSlots.size() || this.dragSplittingLimit == 2) && Container.canAddItemToSlot(lllllllllllIlIIlIIIllIlIIlIllIll, lllllllllllIlIIlIIIllIlIIlIllIlI, true) && lllllllllllIlIIlIIIllIlIIlIllIll.isItemValid(lllllllllllIlIIlIIIllIlIIlIllIlI) && this.inventorySlots.canDragIntoSlot(lllllllllllIlIIlIIIllIlIIlIllIll)) {
            this.dragSplittingSlots.add(lllllllllllIlIIlIIIllIlIIlIllIll);
            this.updateDragSplitting();
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIIlIIIllIllIIIIlllI, final int lllllllllllIlIIlIIIllIllIIIIllIl, final float lllllllllllIlIIlIIIllIllIIlIIIlI) {
        GuiContainer.addition = ((GuiContainer.lastTime < this.mc.timer.renderPartialTicks) ? (this.mc.timer.renderPartialTicks - GuiContainer.lastTime) : ((GuiContainer.lastTime != this.mc.timer.renderPartialTicks) ? (1.0f - GuiContainer.lastTime + this.mc.timer.renderPartialTicks) : 0.0f));
        if (GuiContainer.animTicks < 20.0f) {
            GuiContainer.animTicks += Math.min(GuiContainer.addition / 1.5f * (20.5f - GuiContainer.animTicks), 20.0f - GuiContainer.animTicks);
        }
        GlStateManager.translate(this.width / 2.0f, this.height / 2.0f, 1.0f);
        GlStateManager.scale(GuiContainer.animTicks * 0.05f, GuiContainer.animTicks * 0.05f, GuiContainer.animTicks * 0.05f);
        GlStateManager.translate(-this.width / 2.0f, -this.height / 2.0f, 1.0f);
        GuiContainer.lastTime = this.mc.timer.renderPartialTicks;
        final int lllllllllllIlIIlIIIllIllIIlIIIIl = this.guiLeft;
        final int lllllllllllIlIIlIIIllIllIIlIIIII = this.guiTop;
        this.drawGuiContainerBackgroundLayer(lllllllllllIlIIlIIIllIllIIlIIIlI, lllllllllllIlIIlIIIllIllIIIIlllI, lllllllllllIlIIlIIIllIllIIIIllIl);
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        super.drawScreen(lllllllllllIlIIlIIIllIllIIIIlllI, lllllllllllIlIIlIIIllIllIIIIllIl, lllllllllllIlIIlIIIllIllIIlIIIlI);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllIlIIlIIIllIllIIlIIIIl, (float)lllllllllllIlIIlIIIllIllIIlIIIII, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableRescaleNormal();
        this.theSlot = null;
        final int lllllllllllIlIIlIIIllIllIIIlllll = 240;
        final int lllllllllllIlIIlIIIllIllIIIllllI = 240;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        for (int lllllllllllIlIIlIIIllIllIIIlllIl = 0; lllllllllllIlIIlIIIllIllIIIlllIl < this.inventorySlots.inventorySlots.size(); ++lllllllllllIlIIlIIIllIllIIIlllIl) {
            final Slot lllllllllllIlIIlIIIllIllIIIlllII = this.inventorySlots.inventorySlots.get(lllllllllllIlIIlIIIllIllIIIlllIl);
            if (lllllllllllIlIIlIIIllIllIIIlllII.canBeHovered()) {
                this.drawSlot(lllllllllllIlIIlIIIllIllIIIlllII);
            }
            if (this.isMouseOverSlot(lllllllllllIlIIlIIIllIllIIIlllII, lllllllllllIlIIlIIIllIllIIIIlllI, lllllllllllIlIIlIIIllIllIIIIllIl) && lllllllllllIlIIlIIIllIllIIIlllII.canBeHovered()) {
                if (Main.featureDirector.getFeatureByClass(ItemScroller.class).isToggled() && Mouse.isButtonDown(0) && Keyboard.isKeyDown(this.mc.gameSettings.keyBindSneak.getKeyCode()) && this.mc.currentScreen != null && this.timerHelper.hasReached(ItemScroller.scrollerDelay.getNumberValue())) {
                    this.handleMouseClick(lllllllllllIlIIlIIIllIllIIIlllII, lllllllllllIlIIlIIIllIllIIIlllII.slotNumber, 0, ClickType.QUICK_MOVE);
                    this.timerHelper.reset();
                }
                this.theSlot = lllllllllllIlIIlIIIllIllIIIlllII;
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                final int lllllllllllIlIIlIIIllIllIIIllIll = lllllllllllIlIIlIIIllIllIIIlllII.xDisplayPosition;
                final int lllllllllllIlIIlIIIllIllIIIllIlI = lllllllllllIlIIlIIIllIllIIIlllII.yDisplayPosition;
                GlStateManager.colorMask(true, true, true, false);
                this.drawGradientRect(lllllllllllIlIIlIIIllIllIIIllIll, lllllllllllIlIIlIIIllIllIIIllIlI, lllllllllllIlIIlIIIllIllIIIllIll + 16, lllllllllllIlIIlIIIllIllIIIllIlI + 16, -2130706433, -2130706433);
                GlStateManager.colorMask(true, true, true, true);
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
        }
        RenderHelper.disableStandardItemLighting();
        this.drawGuiContainerForegroundLayer(lllllllllllIlIIlIIIllIllIIIIlllI, lllllllllllIlIIlIIIllIllIIIIllIl);
        RenderHelper.enableGUIStandardItemLighting();
        final InventoryPlayer lllllllllllIlIIlIIIllIllIIIllIIl = this.mc.player.inventory;
        ItemStack lllllllllllIlIIlIIIllIllIIIllIII = this.draggedStack.isEmpty() ? lllllllllllIlIIlIIIllIllIIIllIIl.getItemStack() : this.draggedStack;
        if (!lllllllllllIlIIlIIIllIllIIIllIII.isEmpty()) {
            final int lllllllllllIlIIlIIIllIllIIIlIlll = 8;
            final int lllllllllllIlIIlIIIllIllIIIlIllI = this.draggedStack.isEmpty() ? 8 : 16;
            String lllllllllllIlIIlIIIllIllIIIlIlIl = null;
            if (!this.draggedStack.isEmpty() && this.isRightMouseClick) {
                lllllllllllIlIIlIIIllIllIIIllIII = lllllllllllIlIIlIIIllIllIIIllIII.copy();
                lllllllllllIlIIlIIIllIllIIIllIII.func_190920_e(MathHelper.ceil(lllllllllllIlIIlIIIllIllIIIllIII.getCount() / 2.0f));
            }
            else if (this.dragSplitting && this.dragSplittingSlots.size() > 1) {
                lllllllllllIlIIlIIIllIllIIIllIII = lllllllllllIlIIlIIIllIllIIIllIII.copy();
                lllllllllllIlIIlIIIllIllIIIllIII.func_190920_e(this.dragSplittingRemnant);
                if (lllllllllllIlIIlIIIllIllIIIllIII.isEmpty()) {
                    lllllllllllIlIIlIIIllIllIIIlIlIl = TextFormatting.YELLOW + "0";
                }
            }
            this.drawItemStack(lllllllllllIlIIlIIIllIllIIIllIII, lllllllllllIlIIlIIIllIllIIIIlllI - lllllllllllIlIIlIIIllIllIIlIIIIl - 8, lllllllllllIlIIlIIIllIllIIIIllIl - lllllllllllIlIIlIIIllIllIIlIIIII - lllllllllllIlIIlIIIllIllIIIlIllI, lllllllllllIlIIlIIIllIllIIIlIlIl);
        }
        if (!this.returningStack.isEmpty()) {
            float lllllllllllIlIIlIIIllIllIIIlIlII = (Minecraft.getSystemTime() - this.returningStackTime) / 100.0f;
            if (lllllllllllIlIIlIIIllIllIIIlIlII >= 1.0f) {
                lllllllllllIlIIlIIIllIllIIIlIlII = 1.0f;
                this.returningStack = ItemStack.field_190927_a;
            }
            final int lllllllllllIlIIlIIIllIllIIIlIIll = this.returningStackDestSlot.xDisplayPosition - this.touchUpX;
            final int lllllllllllIlIIlIIIllIllIIIlIIlI = this.returningStackDestSlot.yDisplayPosition - this.touchUpY;
            final int lllllllllllIlIIlIIIllIllIIIlIIIl = this.touchUpX + (int)(lllllllllllIlIIlIIIllIllIIIlIIll * lllllllllllIlIIlIIIllIllIIIlIlII);
            final int lllllllllllIlIIlIIIllIllIIIlIIII = this.touchUpY + (int)(lllllllllllIlIIlIIIllIllIIIlIIlI * lllllllllllIlIIlIIIllIllIIIlIlII);
            this.drawItemStack(this.returningStack, lllllllllllIlIIlIIIllIllIIIlIIIl, lllllllllllIlIIlIIIllIllIIIlIIII, null);
        }
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
    }
    
    protected boolean isPointInRegion(final int lllllllllllIlIIlIIIllIlIIIIIllll, final int lllllllllllIlIIlIIIllIlIIIIlIlll, final int lllllllllllIlIIlIIIllIlIIIIIllIl, final int lllllllllllIlIIlIIIllIlIIIIlIlIl, int lllllllllllIlIIlIIIllIlIIIIIlIll, int lllllllllllIlIIlIIIllIlIIIIIlIlI) {
        final int lllllllllllIlIIlIIIllIlIIIIlIIlI = this.guiLeft;
        final int lllllllllllIlIIlIIIllIlIIIIlIIIl = this.guiTop;
        lllllllllllIlIIlIIIllIlIIIIIlIll -= (String)lllllllllllIlIIlIIIllIlIIIIlIIlI;
        lllllllllllIlIIlIIIllIlIIIIIlIlI -= lllllllllllIlIIlIIIllIlIIIIlIIIl;
        return lllllllllllIlIIlIIIllIlIIIIIlIll >= lllllllllllIlIIlIIIllIlIIIIIllll - 1 && lllllllllllIlIIlIIIllIlIIIIIlIll < lllllllllllIlIIlIIIllIlIIIIIllll + lllllllllllIlIIlIIIllIlIIIIIllIl + 1 && lllllllllllIlIIlIIIllIlIIIIIlIlI >= lllllllllllIlIIlIIIllIlIIIIlIlll - 1 && lllllllllllIlIIlIIIllIlIIIIIlIlI < lllllllllllIlIIlIIIllIlIIIIlIlll + lllllllllllIlIIlIIIllIlIIIIlIlIl + 1;
    }
    
    static {
        INVENTORY_BACKGROUND = new ResourceLocation("textures/gui/container/inventory.png");
    }
    
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIlIIlIIIllIlIlllIIlll, final int lllllllllllIlIIlIIIllIlIlllIIllI) {
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlIIlIIIllIlIlIIIllll, final int lllllllllllIlIIlIIIllIlIlIIIlllI, final int lllllllllllIlIIlIIIllIlIlIIIllIl) throws IOException {
        super.mouseClicked(lllllllllllIlIIlIIIllIlIlIIIllll, lllllllllllIlIIlIIIllIlIlIIIlllI, lllllllllllIlIIlIIIllIlIlIIIllIl);
        final boolean lllllllllllIlIIlIIIllIlIlIIIllII = lllllllllllIlIIlIIIllIlIlIIIllIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100;
        final Slot lllllllllllIlIIlIIIllIlIlIIIlIll = this.getSlotAtPosition(lllllllllllIlIIlIIIllIlIlIIIllll, lllllllllllIlIIlIIIllIlIlIIIlllI);
        final long lllllllllllIlIIlIIIllIlIlIIIlIlI = Minecraft.getSystemTime();
        this.doubleClick = (this.lastClickSlot == lllllllllllIlIIlIIIllIlIlIIIlIll && lllllllllllIlIIlIIIllIlIlIIIlIlI - this.lastClickTime < 250L && this.lastClickButton == lllllllllllIlIIlIIIllIlIlIIIllIl);
        this.ignoreMouseUp = false;
        if (lllllllllllIlIIlIIIllIlIlIIIllIl == 0 || lllllllllllIlIIlIIIllIlIlIIIllIl == 1 || lllllllllllIlIIlIIIllIlIlIIIllII) {
            final int lllllllllllIlIIlIIIllIlIlIIIlIIl = this.guiLeft;
            final int lllllllllllIlIIlIIIllIlIlIIIlIII = this.guiTop;
            final boolean lllllllllllIlIIlIIIllIlIlIIIIlll = this.func_193983_c(lllllllllllIlIIlIIIllIlIlIIIllll, lllllllllllIlIIlIIIllIlIlIIIlllI, lllllllllllIlIIlIIIllIlIlIIIlIIl, lllllllllllIlIIlIIIllIlIlIIIlIII);
            int lllllllllllIlIIlIIIllIlIlIIIIllI = -1;
            if (lllllllllllIlIIlIIIllIlIlIIIlIll != null) {
                lllllllllllIlIIlIIIllIlIlIIIIllI = lllllllllllIlIIlIIIllIlIlIIIlIll.slotNumber;
            }
            if (lllllllllllIlIIlIIIllIlIlIIIIlll) {
                lllllllllllIlIIlIIIllIlIlIIIIllI = -999;
            }
            if (this.mc.gameSettings.touchscreen && lllllllllllIlIIlIIIllIlIlIIIIlll && this.mc.player.inventory.getItemStack().isEmpty()) {
                this.mc.displayGuiScreen(null);
                return;
            }
            if (lllllllllllIlIIlIIIllIlIlIIIIllI != -1) {
                if (this.mc.gameSettings.touchscreen) {
                    if (lllllllllllIlIIlIIIllIlIlIIIlIll != null && lllllllllllIlIIlIIIllIlIlIIIlIll.getHasStack()) {
                        this.clickedSlot = lllllllllllIlIIlIIIllIlIlIIIlIll;
                        this.draggedStack = ItemStack.field_190927_a;
                        this.isRightMouseClick = (lllllllllllIlIIlIIIllIlIlIIIllIl == 1);
                    }
                    else {
                        this.clickedSlot = null;
                    }
                }
                else if (!this.dragSplitting) {
                    if (this.mc.player.inventory.getItemStack().isEmpty()) {
                        if (lllllllllllIlIIlIIIllIlIlIIIllIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                            this.handleMouseClick(lllllllllllIlIIlIIIllIlIlIIIlIll, lllllllllllIlIIlIIIllIlIlIIIIllI, lllllllllllIlIIlIIIllIlIlIIIllIl, ClickType.CLONE);
                        }
                        else {
                            final boolean lllllllllllIlIIlIIIllIlIlIIIIlIl = lllllllllllIlIIlIIIllIlIlIIIIllI != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            ClickType lllllllllllIlIIlIIIllIlIlIIIIlII = ClickType.PICKUP;
                            if (lllllllllllIlIIlIIIllIlIlIIIIlIl) {
                                this.shiftClickedSlot = ((lllllllllllIlIIlIIIllIlIlIIIlIll != null && lllllllllllIlIIlIIIllIlIlIIIlIll.getHasStack()) ? lllllllllllIlIIlIIIllIlIlIIIlIll.getStack().copy() : ItemStack.field_190927_a);
                                lllllllllllIlIIlIIIllIlIlIIIIlII = ClickType.QUICK_MOVE;
                            }
                            else if (lllllllllllIlIIlIIIllIlIlIIIIllI == -999) {
                                lllllllllllIlIIlIIIllIlIlIIIIlII = ClickType.THROW;
                            }
                            this.handleMouseClick(lllllllllllIlIIlIIIllIlIlIIIlIll, lllllllllllIlIIlIIIllIlIlIIIIllI, lllllllllllIlIIlIIIllIlIlIIIllIl, lllllllllllIlIIlIIIllIlIlIIIIlII);
                        }
                        this.ignoreMouseUp = true;
                    }
                    else {
                        this.dragSplitting = true;
                        this.dragSplittingButton = lllllllllllIlIIlIIIllIlIlIIIllIl;
                        this.dragSplittingSlots.clear();
                        if (lllllllllllIlIIlIIIllIlIlIIIllIl == 0) {
                            this.dragSplittingLimit = 0;
                        }
                        else if (lllllllllllIlIIlIIIllIlIlIIIllIl == 1) {
                            this.dragSplittingLimit = 1;
                        }
                        else if (lllllllllllIlIIlIIIllIlIlIIIllIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                            this.dragSplittingLimit = 2;
                        }
                    }
                }
            }
        }
        this.lastClickSlot = lllllllllllIlIIlIIIllIlIlIIIlIll;
        this.lastClickTime = lllllllllllIlIIlIIIllIlIlIIIlIlI;
        this.lastClickButton = lllllllllllIlIIlIIIllIlIlIIIllIl;
    }
}
