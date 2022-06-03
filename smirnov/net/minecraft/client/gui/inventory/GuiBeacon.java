// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.init.MobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.client.renderer.GlStateManager;
import java.io.IOException;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.potion.Potion;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.entity.player.InventoryPlayer;
import org.apache.logging.log4j.LogManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;

public class GuiBeacon extends GuiContainer
{
    private static final /* synthetic */ ResourceLocation BEACON_GUI_TEXTURES;
    private /* synthetic */ ConfirmButton beaconConfirmButton;
    private final /* synthetic */ IInventory tileBeacon;
    private /* synthetic */ boolean buttonsNotDrawn;
    
    static {
        LOGGER = LogManager.getLogger();
        BEACON_GUI_TEXTURES = new ResourceLocation("textures/gui/container/beacon.png");
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIlIllllllIlIIIIllIIl, final int lllllllllllIIlIllllllIlIIIIlllII, final float lllllllllllIIlIllllllIlIIIIlIlll) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllIIlIllllllIlIIIIllIIl, lllllllllllIIlIllllllIlIIIIlllII, lllllllllllIIlIllllllIlIIIIlIlll);
        this.func_191948_b(lllllllllllIIlIllllllIlIIIIllIIl, lllllllllllIIlIllllllIlIIIIlllII);
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.beaconConfirmButton = new ConfirmButton(-1, this.guiLeft + 164, this.guiTop + 107);
        this.buttonList.add(this.beaconConfirmButton);
        this.buttonList.add(new CancelButton(-2, this.guiLeft + 190, this.guiTop + 107));
        this.buttonsNotDrawn = true;
        this.beaconConfirmButton.enabled = false;
    }
    
    public GuiBeacon(final InventoryPlayer lllllllllllIIlIllllllIlIIllIIIII, final IInventory lllllllllllIIlIllllllIlIIlIlllII) {
        super(new ContainerBeacon(lllllllllllIIlIllllllIlIIllIIIII, lllllllllllIIlIllllllIlIIlIlllII));
        this.tileBeacon = lllllllllllIIlIllllllIlIIlIlllII;
        this.xSize = 230;
        this.ySize = 219;
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final int lllllllllllIIlIllllllIlIIlIIllII = this.tileBeacon.getField(0);
        final Potion lllllllllllIIlIllllllIlIIlIIlIll = Potion.getPotionById(this.tileBeacon.getField(1));
        final Potion lllllllllllIIlIllllllIlIIlIIlIlI = Potion.getPotionById(this.tileBeacon.getField(2));
        if (this.buttonsNotDrawn && lllllllllllIIlIllllllIlIIlIIllII >= 0) {
            this.buttonsNotDrawn = false;
            int lllllllllllIIlIllllllIlIIlIIlIIl = 100;
            for (int lllllllllllIIlIllllllIlIIlIIlIII = 0; lllllllllllIIlIllllllIlIIlIIlIII <= 2; ++lllllllllllIIlIllllllIlIIlIIlIII) {
                final int lllllllllllIIlIllllllIlIIlIIIlll = TileEntityBeacon.EFFECTS_LIST[lllllllllllIIlIllllllIlIIlIIlIII].length;
                final int lllllllllllIIlIllllllIlIIlIIIllI = lllllllllllIIlIllllllIlIIlIIIlll * 22 + (lllllllllllIIlIllllllIlIIlIIIlll - 1) * 2;
                for (int lllllllllllIIlIllllllIlIIlIIIlIl = 0; lllllllllllIIlIllllllIlIIlIIIlIl < lllllllllllIIlIllllllIlIIlIIIlll; ++lllllllllllIIlIllllllIlIIlIIIlIl) {
                    final Potion lllllllllllIIlIllllllIlIIlIIIlII = TileEntityBeacon.EFFECTS_LIST[lllllllllllIIlIllllllIlIIlIIlIII][lllllllllllIIlIllllllIlIIlIIIlIl];
                    final PowerButton lllllllllllIIlIllllllIlIIlIIIIll = new PowerButton(lllllllllllIIlIllllllIlIIlIIlIIl++, this.guiLeft + 76 + lllllllllllIIlIllllllIlIIlIIIlIl * 24 - lllllllllllIIlIllllllIlIIlIIIllI / 2, this.guiTop + 22 + lllllllllllIIlIllllllIlIIlIIlIII * 25, lllllllllllIIlIllllllIlIIlIIIlII, lllllllllllIIlIllllllIlIIlIIlIII);
                    this.buttonList.add(lllllllllllIIlIllllllIlIIlIIIIll);
                    if (lllllllllllIIlIllllllIlIIlIIlIII >= lllllllllllIIlIllllllIlIIlIIllII) {
                        lllllllllllIIlIllllllIlIIlIIIIll.enabled = false;
                    }
                    else if (lllllllllllIIlIllllllIlIIlIIIlII == lllllllllllIIlIllllllIlIIlIIlIll) {
                        lllllllllllIIlIllllllIlIIlIIIIll.setSelected(true);
                    }
                }
            }
            final int lllllllllllIIlIllllllIlIIlIIIIlI = 3;
            final int lllllllllllIIlIllllllIlIIlIIIIIl = TileEntityBeacon.EFFECTS_LIST[3].length + 1;
            final int lllllllllllIIlIllllllIlIIlIIIIII = lllllllllllIIlIllllllIlIIlIIIIIl * 22 + (lllllllllllIIlIllllllIlIIlIIIIIl - 1) * 2;
            for (int lllllllllllIIlIllllllIlIIIllllll = 0; lllllllllllIIlIllllllIlIIIllllll < lllllllllllIIlIllllllIlIIlIIIIIl - 1; ++lllllllllllIIlIllllllIlIIIllllll) {
                final Potion lllllllllllIIlIllllllIlIIIlllllI = TileEntityBeacon.EFFECTS_LIST[3][lllllllllllIIlIllllllIlIIIllllll];
                final PowerButton lllllllllllIIlIllllllIlIIIllllIl = new PowerButton(lllllllllllIIlIllllllIlIIlIIlIIl++, this.guiLeft + 167 + lllllllllllIIlIllllllIlIIIllllll * 24 - lllllllllllIIlIllllllIlIIlIIIIII / 2, this.guiTop + 47, lllllllllllIIlIllllllIlIIIlllllI, 3);
                this.buttonList.add(lllllllllllIIlIllllllIlIIIllllIl);
                if (3 >= lllllllllllIIlIllllllIlIIlIIllII) {
                    lllllllllllIIlIllllllIlIIIllllIl.enabled = false;
                }
                else if (lllllllllllIIlIllllllIlIIIlllllI == lllllllllllIIlIllllllIlIIlIIlIlI) {
                    lllllllllllIIlIllllllIlIIIllllIl.setSelected(true);
                }
            }
            if (lllllllllllIIlIllllllIlIIlIIlIll != null) {
                final PowerButton lllllllllllIIlIllllllIlIIIllllII = new PowerButton(lllllllllllIIlIllllllIlIIlIIlIIl++, this.guiLeft + 167 + (lllllllllllIIlIllllllIlIIlIIIIIl - 1) * 24 - lllllllllllIIlIllllllIlIIlIIIIII / 2, this.guiTop + 47, lllllllllllIIlIllllllIlIIlIIlIll, 3);
                this.buttonList.add(lllllllllllIIlIllllllIlIIIllllII);
                if (3 >= lllllllllllIIlIllllllIlIIlIIllII) {
                    lllllllllllIIlIllllllIlIIIllllII.enabled = false;
                }
                else if (lllllllllllIIlIllllllIlIIlIIlIll == lllllllllllIIlIllllllIlIIlIIlIlI) {
                    lllllllllllIIlIllllllIlIIIllllII.setSelected(true);
                }
            }
        }
        this.beaconConfirmButton.enabled = (!this.tileBeacon.getStackInSlot(0).func_190926_b() && lllllllllllIIlIllllllIlIIlIIlIll != null);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIlIllllllIlIIIlIlIll) throws IOException {
        if (lllllllllllIIlIllllllIlIIIlIlIll.id == -2) {
            this.mc.player.connection.sendPacket(new CPacketCloseWindow(this.mc.player.openContainer.windowId));
            this.mc.displayGuiScreen(null);
        }
        else if (lllllllllllIIlIllllllIlIIIlIlIll.id == -1) {
            final String lllllllllllIIlIllllllIlIIIlIlIlI = "MC|Beacon";
            final PacketBuffer lllllllllllIIlIllllllIlIIIlIlIIl = new PacketBuffer(Unpooled.buffer());
            lllllllllllIIlIllllllIlIIIlIlIIl.writeInt(this.tileBeacon.getField(1));
            lllllllllllIIlIllllllIlIIIlIlIIl.writeInt(this.tileBeacon.getField(2));
            this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|Beacon", lllllllllllIIlIllllllIlIIIlIlIIl));
            this.mc.player.connection.sendPacket(new CPacketCloseWindow(this.mc.player.openContainer.windowId));
            this.mc.displayGuiScreen(null);
        }
        else if (lllllllllllIIlIllllllIlIIIlIlIll instanceof PowerButton) {
            final PowerButton lllllllllllIIlIllllllIlIIIlIlIII = (PowerButton)lllllllllllIIlIllllllIlIIIlIlIll;
            if (lllllllllllIIlIllllllIlIIIlIlIII.isSelected()) {
                return;
            }
            final int lllllllllllIIlIllllllIlIIIlIIlll = Potion.getIdFromPotion(lllllllllllIIlIllllllIlIIIlIlIII.effect);
            if (lllllllllllIIlIllllllIlIIIlIlIII.tier < 3) {
                this.tileBeacon.setField(1, lllllllllllIIlIllllllIlIIIlIIlll);
            }
            else {
                this.tileBeacon.setField(2, lllllllllllIIlIllllllIlIIIlIIlll);
            }
            this.buttonList.clear();
            this.initGui();
            this.updateScreen();
        }
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIIlIllllllIlIIIIIIlII, final int lllllllllllIIlIllllllIlIIIIIIIll, final int lllllllllllIIlIllllllIlIIIIIIIlI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiBeacon.BEACON_GUI_TEXTURES);
        final int lllllllllllIIlIllllllIlIIIIIIIIl = (this.width - this.xSize) / 2;
        final int lllllllllllIIlIllllllIlIIIIIIIII = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllIIlIllllllIlIIIIIIIIl, lllllllllllIIlIllllllIlIIIIIIIII, 0, 0, this.xSize, this.ySize);
        this.itemRender.zLevel = 100.0f;
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.EMERALD), lllllllllllIIlIllllllIlIIIIIIIIl + 42, lllllllllllIIlIllllllIlIIIIIIIII + 109);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.DIAMOND), lllllllllllIIlIllllllIlIIIIIIIIl + 42 + 22, lllllllllllIIlIllllllIlIIIIIIIII + 109);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.GOLD_INGOT), lllllllllllIIlIllllllIlIIIIIIIIl + 42 + 44, lllllllllllIIlIllllllIlIIIIIIIII + 109);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.IRON_INGOT), lllllllllllIIlIllllllIlIIIIIIIIl + 42 + 66, lllllllllllIIlIllllllIlIIIIIIIII + 109);
        this.itemRender.zLevel = 0.0f;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIIlIllllllIlIIIIlIIII, final int lllllllllllIIlIllllllIlIIIIIllll) {
        RenderHelper.disableStandardItemLighting();
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.primary", new Object[0]), 62, 10, 14737632);
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.secondary", new Object[0]), 169, 10, 14737632);
        for (final GuiButton lllllllllllIIlIllllllIlIIIIIlllI : this.buttonList) {
            if (lllllllllllIIlIllllllIlIIIIIlllI.isMouseOver()) {
                lllllllllllIIlIllllllIlIIIIIlllI.drawButtonForegroundLayer(lllllllllllIIlIllllllIlIIIIlIIII - this.guiLeft, lllllllllllIIlIllllllIlIIIIIllll - this.guiTop);
                break;
            }
        }
        RenderHelper.enableGUIStandardItemLighting();
    }
    
    class CancelButton extends Button
    {
        public CancelButton(final int llllllllllllllIllIlIlIlllIIlIIlI, final int llllllllllllllIllIlIlIlllIIlIIIl, final int llllllllllllllIllIlIlIlllIIlIlIl) {
            super(llllllllllllllIllIlIlIlllIIlIIlI, llllllllllllllIllIlIlIlllIIlIIIl, llllllllllllllIllIlIlIlllIIlIlIl, GuiBeacon.BEACON_GUI_TEXTURES, 112, 220);
        }
        
        @Override
        public void drawButtonForegroundLayer(final int llllllllllllllIllIlIlIlllIIIlIll, final int llllllllllllllIllIlIlIlllIIIIlll) {
            GuiBeacon.this.drawCreativeTabHoveringText(I18n.format("gui.cancel", new Object[0]), llllllllllllllIllIlIlIlllIIIlIll, llllllllllllllIllIlIlIlllIIIIlll);
        }
    }
    
    static class Button extends GuiButton
    {
        private final /* synthetic */ int iconY;
        private final /* synthetic */ int iconX;
        private /* synthetic */ boolean selected;
        private final /* synthetic */ ResourceLocation iconTexture;
        
        public boolean isSelected() {
            return this.selected;
        }
        
        public void func_191745_a(final Minecraft llllllllllllllllIlllIllllIlllIIl, final int llllllllllllllllIlllIllllIllIIIl, final int llllllllllllllllIlllIllllIllIlll, final float llllllllllllllllIlllIllllIllIllI) {
            if (this.visible) {
                llllllllllllllllIlllIllllIlllIIl.getTextureManager().bindTexture(GuiBeacon.BEACON_GUI_TEXTURES);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.hovered = (llllllllllllllllIlllIllllIllIIIl >= this.xPosition && llllllllllllllllIlllIllllIllIlll >= this.yPosition && llllllllllllllllIlllIllllIllIIIl < this.xPosition + this.width && llllllllllllllllIlllIllllIllIlll < this.yPosition + this.height);
                final int llllllllllllllllIlllIllllIllIlIl = 219;
                int llllllllllllllllIlllIllllIllIlII = 0;
                if (!this.enabled) {
                    llllllllllllllllIlllIllllIllIlII += this.width * 2;
                }
                else if (this.selected) {
                    llllllllllllllllIlllIllllIllIlII += this.width * 1;
                }
                else if (this.hovered) {
                    llllllllllllllllIlllIllllIllIlII += this.width * 3;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllllllIlllIllllIllIlII, 219, this.width, this.height);
                if (!GuiBeacon.BEACON_GUI_TEXTURES.equals(this.iconTexture)) {
                    llllllllllllllllIlllIllllIlllIIl.getTextureManager().bindTexture(this.iconTexture);
                }
                this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, this.iconX, this.iconY, 18, 18);
            }
        }
        
        protected Button(final int llllllllllllllllIlllIlllllIIllIl, final int llllllllllllllllIlllIlllllIIIlIl, final int llllllllllllllllIlllIlllllIIlIll, final ResourceLocation llllllllllllllllIlllIlllllIIIIll, final int llllllllllllllllIlllIlllllIIlIIl, final int llllllllllllllllIlllIlllllIIIIIl) {
            super(llllllllllllllllIlllIlllllIIllIl, llllllllllllllllIlllIlllllIIIlIl, llllllllllllllllIlllIlllllIIlIll, 22, 22, "");
            this.iconTexture = llllllllllllllllIlllIlllllIIIIll;
            this.iconX = llllllllllllllllIlllIlllllIIlIIl;
            this.iconY = llllllllllllllllIlllIlllllIIIIIl;
        }
        
        public void setSelected(final boolean llllllllllllllllIlllIllllIlIIlll) {
            this.selected = llllllllllllllllIlllIllllIlIIlll;
        }
    }
    
    class ConfirmButton extends Button
    {
        public ConfirmButton(final int lllllllllllllllIIllIIlIllllIIlII, final int lllllllllllllllIIllIIlIlllIllllI, final int lllllllllllllllIIllIIlIllllIIIlI) {
            super(lllllllllllllllIIllIIlIllllIIlII, lllllllllllllllIIllIIlIlllIllllI, lllllllllllllllIIllIIlIllllIIIlI, GuiBeacon.BEACON_GUI_TEXTURES, 90, 220);
        }
        
        @Override
        public void drawButtonForegroundLayer(final int lllllllllllllllIIllIIlIlllIlIlIl, final int lllllllllllllllIIllIIlIlllIlIlII) {
            GuiBeacon.this.drawCreativeTabHoveringText(I18n.format("gui.done", new Object[0]), lllllllllllllllIIllIIlIlllIlIlIl, lllllllllllllllIIllIIlIlllIlIlII);
        }
    }
    
    class PowerButton extends Button
    {
        private final /* synthetic */ int tier;
        private final /* synthetic */ Potion effect;
        
        @Override
        public void drawButtonForegroundLayer(final int llllllllllllIIlIIlIlIIIllllllllI, final int llllllllllllIIlIIlIlIIIlllllllIl) {
            String llllllllllllIIlIIlIlIIlIIIIIIIII = I18n.format(this.effect.getName(), new Object[0]);
            if (this.tier >= 3 && this.effect != MobEffects.REGENERATION) {
                llllllllllllIIlIIlIlIIlIIIIIIIII = String.valueOf(llllllllllllIIlIIlIlIIlIIIIIIIII) + " II";
            }
            GuiBeacon.this.drawCreativeTabHoveringText(llllllllllllIIlIIlIlIIlIIIIIIIII, llllllllllllIIlIIlIlIIIllllllllI, llllllllllllIIlIIlIlIIIlllllllIl);
        }
        
        public PowerButton(final int llllllllllllIIlIIlIlIIlIIIIIllII, final int llllllllllllIIlIIlIlIIlIIIIlIIlI, final int llllllllllllIIlIIlIlIIlIIIIlIIIl, final Potion llllllllllllIIlIIlIlIIlIIIIIlIIl, final int llllllllllllIIlIIlIlIIlIIIIIlIII) {
            super(llllllllllllIIlIIlIlIIlIIIIIllII, llllllllllllIIlIIlIlIIlIIIIlIIlI, llllllllllllIIlIIlIlIIlIIIIlIIIl, GuiContainer.INVENTORY_BACKGROUND, llllllllllllIIlIIlIlIIlIIIIIlIIl.getStatusIconIndex() % 8 * 18, 198 + llllllllllllIIlIIlIlIIlIIIIIlIIl.getStatusIconIndex() / 8 * 18);
            this.effect = llllllllllllIIlIIlIlIIlIIIIIlIIl;
            this.tier = llllllllllllIIlIIlIlIIlIIIIIlIII;
        }
    }
}
