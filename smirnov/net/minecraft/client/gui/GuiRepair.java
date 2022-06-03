// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.inventory.Slot;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiRepair extends GuiContainer implements IContainerListener
{
    private /* synthetic */ GuiTextField nameField;
    private final /* synthetic */ ContainerRepair anvil;
    private final /* synthetic */ InventoryPlayer playerInventory;
    private static final /* synthetic */ ResourceLocation ANVIL_RESOURCE;
    
    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        final int lllllllllllIlIIlIlIIlIIIIIlIlIll = (this.width - this.xSize) / 2;
        final int lllllllllllIlIIlIlIIlIIIIIlIlIlI = (this.height - this.ySize) / 2;
        this.nameField = new GuiTextField(0, this.fontRendererObj, lllllllllllIlIIlIlIIlIIIIIlIlIll + 62, lllllllllllIlIIlIlIIlIIIIIlIlIlI + 24, 103, 12);
        this.nameField.setTextColor(-1);
        this.nameField.setDisabledTextColour(-1);
        this.nameField.setEnableBackgroundDrawing(false);
        this.nameField.setMaxStringLength(35);
        this.inventorySlots.removeListener(this);
        this.inventorySlots.addListener(this);
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIIlIlIIIllllllIlIIl, final int lllllllllllIlIIlIlIIIllllllIlIII, final float lllllllllllIlIIlIlIIIllllllIIlll) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllIlIIlIlIIIllllllIlIIl, lllllllllllIlIIlIlIIIllllllIlIII, lllllllllllIlIIlIlIIIllllllIIlll);
        this.func_191948_b(lllllllllllIlIIlIlIIIllllllIlIIl, lllllllllllIlIIlIlIIIllllllIlIII);
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        this.nameField.drawTextBox();
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIlIIlIlIIIlllllIllllI, final int lllllllllllIlIIlIlIIIlllllIlllIl, final int lllllllllllIlIIlIlIIIlllllIlllII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiRepair.ANVIL_RESOURCE);
        final int lllllllllllIlIIlIlIIIlllllIllIll = (this.width - this.xSize) / 2;
        final int lllllllllllIlIIlIlIIIlllllIllIlI = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllIlIIlIlIIIlllllIllIll, lllllllllllIlIIlIlIIIlllllIllIlI, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(lllllllllllIlIIlIlIIIlllllIllIll + 59, lllllllllllIlIIlIlIIIlllllIllIlI + 20, 0, this.ySize + (this.anvil.getSlot(0).getHasStack() ? 0 : 16), 110, 16);
        if ((this.anvil.getSlot(0).getHasStack() || this.anvil.getSlot(1).getHasStack()) && !this.anvil.getSlot(2).getHasStack()) {
            this.drawTexturedModalRect(lllllllllllIlIIlIlIIIlllllIllIll + 99, lllllllllllIlIIlIlIIIlllllIllIlI + 45, this.xSize, 0, 28, 21);
        }
    }
    
    @Override
    public void sendAllWindowProperties(final Container lllllllllllIlIIlIlIIIlllllIIIIII, final IInventory lllllllllllIlIIlIlIIIllllIllllll) {
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlIIlIlIIlIIIIIIIlIII, final int lllllllllllIlIIlIlIIlIIIIIIIIlII) throws IOException {
        if (this.nameField.textboxKeyTyped(lllllllllllIlIIlIlIIlIIIIIIIlIII, lllllllllllIlIIlIlIIlIIIIIIIIlII)) {
            this.renameItem();
        }
        else {
            super.keyTyped(lllllllllllIlIIlIlIIlIIIIIIIlIII, lllllllllllIlIIlIlIIlIIIIIIIIlII);
        }
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlIIlIlIIIlllllllIlIl, final int lllllllllllIlIIlIlIIIlllllllIlII, final int lllllllllllIlIIlIlIIIlllllllIIll) throws IOException {
        super.mouseClicked(lllllllllllIlIIlIlIIIlllllllIlIl, lllllllllllIlIIlIlIIIlllllllIlII, lllllllllllIlIIlIlIIIlllllllIIll);
        this.nameField.mouseClicked(lllllllllllIlIIlIlIIIlllllllIlIl, lllllllllllIlIIlIlIIIlllllllIlII, lllllllllllIlIIlIlIIIlllllllIIll);
    }
    
    static {
        ANVIL_RESOURCE = new ResourceLocation("textures/gui/container/anvil.png");
    }
    
    private void renameItem() {
        String lllllllllllIlIIlIlIIIlllllllllll = this.nameField.getText();
        final Slot lllllllllllIlIIlIlIIIllllllllllI = this.anvil.getSlot(0);
        if (lllllllllllIlIIlIlIIIllllllllllI != null && lllllllllllIlIIlIlIIIllllllllllI.getHasStack() && !lllllllllllIlIIlIlIIIllllllllllI.getStack().hasDisplayName() && lllllllllllIlIIlIlIIIlllllllllll.equals(lllllllllllIlIIlIlIIIllllllllllI.getStack().getDisplayName())) {
            lllllllllllIlIIlIlIIIlllllllllll = "";
        }
        this.anvil.updateItemName(lllllllllllIlIIlIlIIIlllllllllll);
        this.mc.player.connection.sendPacket(new CPacketCustomPayload("MC|ItemName", new PacketBuffer(Unpooled.buffer()).writeString(lllllllllllIlIIlIlIIIlllllllllll)));
    }
    
    @Override
    public void updateCraftingInventory(final Container lllllllllllIlIIlIlIIIlllllIlIIll, final NonNullList<ItemStack> lllllllllllIlIIlIlIIIlllllIlIIlI) {
        this.sendSlotContents(lllllllllllIlIIlIlIIIlllllIlIIll, 0, lllllllllllIlIIlIlIIIlllllIlIIll.getSlot(0).getStack());
    }
    
    public GuiRepair(final InventoryPlayer lllllllllllIlIIlIlIIlIIIIIllIIIl, final World lllllllllllIlIIlIlIIlIIIIIllIIll) {
        super(new ContainerRepair(lllllllllllIlIIlIlIIlIIIIIllIIIl, lllllllllllIlIIlIlIIlIIIIIllIIll, Minecraft.getMinecraft().player));
        this.playerInventory = lllllllllllIlIIlIlIIlIIIIIllIIIl;
        this.anvil = (ContainerRepair)this.inventorySlots;
    }
    
    @Override
    public void sendSlotContents(final Container lllllllllllIlIIlIlIIIlllllIIlIll, final int lllllllllllIlIIlIlIIIlllllIIIlll, final ItemStack lllllllllllIlIIlIlIIIlllllIIlIIl) {
        if (lllllllllllIlIIlIlIIIlllllIIIlll == 0) {
            this.nameField.setText(lllllllllllIlIIlIlIIIlllllIIlIIl.func_190926_b() ? "" : lllllllllllIlIIlIlIIIlllllIIlIIl.getDisplayName());
            this.nameField.setEnabled(!lllllllllllIlIIlIlIIIlllllIIlIIl.func_190926_b());
            if (!lllllllllllIlIIlIlIIIlllllIIlIIl.func_190926_b()) {
                this.renameItem();
            }
        }
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIlIIlIlIIlIIIIIIllIll, final int lllllllllllIlIIlIlIIlIIIIIIllIlI) {
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        this.fontRendererObj.drawString(I18n.format("container.repair", new Object[0]), 60.0f, 6.0f, 4210752);
        if (this.anvil.maximumCost > 0) {
            int lllllllllllIlIIlIlIIlIIIIIIllIIl = 8453920;
            boolean lllllllllllIlIIlIlIIlIIIIIIllIII = true;
            String lllllllllllIlIIlIlIIlIIIIIIlIlll = I18n.format("container.repair.cost", this.anvil.maximumCost);
            if (this.anvil.maximumCost >= 40 && !this.mc.player.capabilities.isCreativeMode) {
                lllllllllllIlIIlIlIIlIIIIIIlIlll = I18n.format("container.repair.expensive", new Object[0]);
                lllllllllllIlIIlIlIIlIIIIIIllIIl = 16736352;
            }
            else if (!this.anvil.getSlot(2).getHasStack()) {
                lllllllllllIlIIlIlIIlIIIIIIllIII = false;
            }
            else if (!this.anvil.getSlot(2).canTakeStack(this.playerInventory.player)) {
                lllllllllllIlIIlIlIIlIIIIIIllIIl = 16736352;
            }
            if (lllllllllllIlIIlIlIIlIIIIIIllIII) {
                final int lllllllllllIlIIlIlIIlIIIIIIlIllI = 0xFF000000 | (lllllllllllIlIIlIlIIlIIIIIIllIIl & 0xFCFCFC) >> 2 | (lllllllllllIlIIlIlIIlIIIIIIllIIl & 0xFF000000);
                final int lllllllllllIlIIlIlIIlIIIIIIlIlIl = this.xSize - 8 - this.fontRendererObj.getStringWidth(lllllllllllIlIIlIlIIlIIIIIIlIlll);
                final int lllllllllllIlIIlIlIIlIIIIIIlIlII = 67;
                if (this.fontRendererObj.getUnicodeFlag()) {
                    Gui.drawRect(lllllllllllIlIIlIlIIlIIIIIIlIlIl - 3, 65.0, this.xSize - 7, 77.0, -16777216);
                    Gui.drawRect(lllllllllllIlIIlIlIIlIIIIIIlIlIl - 2, 66.0, this.xSize - 8, 76.0, -12895429);
                }
                else {
                    this.fontRendererObj.drawString(lllllllllllIlIIlIlIIlIIIIIIlIlll, (float)lllllllllllIlIIlIlIIlIIIIIIlIlIl, 68.0f, lllllllllllIlIIlIlIIlIIIIIIlIllI);
                    this.fontRendererObj.drawString(lllllllllllIlIIlIlIIlIIIIIIlIlll, (float)(lllllllllllIlIIlIlIIlIIIIIIlIlIl + 1), 67.0f, lllllllllllIlIIlIlIIlIIIIIIlIllI);
                    this.fontRendererObj.drawString(lllllllllllIlIIlIlIIlIIIIIIlIlll, (float)(lllllllllllIlIIlIlIIlIIIIIIlIlIl + 1), 68.0f, lllllllllllIlIIlIlIIlIIIIIIlIllI);
                }
                this.fontRendererObj.drawString(lllllllllllIlIIlIlIIlIIIIIIlIlll, (float)lllllllllllIlIIlIlIIlIIIIIIlIlIl, 67.0f, lllllllllllIlIIlIlIIlIIIIIIllIIl);
            }
        }
        GlStateManager.enableLighting();
    }
    
    @Override
    public void sendProgressBarUpdate(final Container lllllllllllIlIIlIlIIIlllllIIIlII, final int lllllllllllIlIIlIlIIIlllllIIIIll, final int lllllllllllIlIIlIlIIIlllllIIIIlI) {
    }
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
        this.inventorySlots.removeListener(this);
    }
}
