// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.world.World;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.IMerchant;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiMerchant extends GuiContainer
{
    private final /* synthetic */ ITextComponent chatComponent;
    private static final /* synthetic */ ResourceLocation MERCHANT_GUI_TEXTURE;
    private final /* synthetic */ IMerchant merchant;
    private /* synthetic */ MerchantButton nextButton;
    private /* synthetic */ MerchantButton previousButton;
    private /* synthetic */ int selectedMerchantRecipe;
    
    @Override
    public void drawScreen(final int lllllllllllIlllIllIIIIllIllIlIlI, final int lllllllllllIlllIllIIIIllIlIlllIl, final float lllllllllllIlllIllIIIIllIlIlllII) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl, lllllllllllIlllIllIIIIllIlIlllII);
        final MerchantRecipeList lllllllllllIlllIllIIIIllIllIIlll = this.merchant.getRecipes(this.mc.player);
        if (lllllllllllIlllIllIIIIllIllIIlll != null && !lllllllllllIlllIllIIIIllIllIIlll.isEmpty()) {
            final int lllllllllllIlllIllIIIIllIllIIllI = (this.width - this.xSize) / 2;
            final int lllllllllllIlllIllIIIIllIllIIlIl = (this.height - this.ySize) / 2;
            final int lllllllllllIlllIllIIIIllIllIIlII = this.selectedMerchantRecipe;
            final MerchantRecipe lllllllllllIlllIllIIIIllIllIIIll = lllllllllllIlllIllIIIIllIllIIlll.get(lllllllllllIlllIllIIIIllIllIIlII);
            final ItemStack lllllllllllIlllIllIIIIllIllIIIlI = lllllllllllIlllIllIIIIllIllIIIll.getItemToBuy();
            final ItemStack lllllllllllIlllIllIIIIllIllIIIIl = lllllllllllIlllIllIIIIllIllIIIll.getSecondItemToBuy();
            final ItemStack lllllllllllIlllIllIIIIllIllIIIII = lllllllllllIlllIllIIIIllIllIIIll.getItemToSell();
            GlStateManager.pushMatrix();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableColorMaterial();
            GlStateManager.enableLighting();
            this.itemRender.zLevel = 100.0f;
            this.itemRender.renderItemAndEffectIntoGUI(lllllllllllIlllIllIIIIllIllIIIlI, lllllllllllIlllIllIIIIllIllIIllI + 36, lllllllllllIlllIllIIIIllIllIIlIl + 24);
            this.itemRender.renderItemOverlays(this.fontRendererObj, lllllllllllIlllIllIIIIllIllIIIlI, lllllllllllIlllIllIIIIllIllIIllI + 36, lllllllllllIlllIllIIIIllIllIIlIl + 24);
            if (!lllllllllllIlllIllIIIIllIllIIIIl.func_190926_b()) {
                this.itemRender.renderItemAndEffectIntoGUI(lllllllllllIlllIllIIIIllIllIIIIl, lllllllllllIlllIllIIIIllIllIIllI + 62, lllllllllllIlllIllIIIIllIllIIlIl + 24);
                this.itemRender.renderItemOverlays(this.fontRendererObj, lllllllllllIlllIllIIIIllIllIIIIl, lllllllllllIlllIllIIIIllIllIIllI + 62, lllllllllllIlllIllIIIIllIllIIlIl + 24);
            }
            this.itemRender.renderItemAndEffectIntoGUI(lllllllllllIlllIllIIIIllIllIIIII, lllllllllllIlllIllIIIIllIllIIllI + 120, lllllllllllIlllIllIIIIllIllIIlIl + 24);
            this.itemRender.renderItemOverlays(this.fontRendererObj, lllllllllllIlllIllIIIIllIllIIIII, lllllllllllIlllIllIIIIllIllIIllI + 120, lllllllllllIlllIllIIIIllIllIIlIl + 24);
            this.itemRender.zLevel = 0.0f;
            GlStateManager.disableLighting();
            if (this.isPointInRegion(36, 24, 16, 16, lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl) && !lllllllllllIlllIllIIIIllIllIIIlI.func_190926_b()) {
                this.renderToolTip(lllllllllllIlllIllIIIIllIllIIIlI, lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl);
            }
            else if (!lllllllllllIlllIllIIIIllIllIIIIl.func_190926_b() && this.isPointInRegion(62, 24, 16, 16, lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl) && !lllllllllllIlllIllIIIIllIllIIIIl.func_190926_b()) {
                this.renderToolTip(lllllllllllIlllIllIIIIllIllIIIIl, lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl);
            }
            else if (!lllllllllllIlllIllIIIIllIllIIIII.func_190926_b() && this.isPointInRegion(120, 24, 16, 16, lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl) && !lllllllllllIlllIllIIIIllIllIIIII.func_190926_b()) {
                this.renderToolTip(lllllllllllIlllIllIIIIllIllIIIII, lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl);
            }
            else if (lllllllllllIlllIllIIIIllIllIIIll.isRecipeDisabled() && (this.isPointInRegion(83, 21, 28, 21, lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl) || this.isPointInRegion(83, 51, 28, 21, lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl))) {
                this.drawCreativeTabHoveringText(I18n.format("merchant.deprecated", new Object[0]), lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl);
            }
            GlStateManager.popMatrix();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
        }
        this.func_191948_b(lllllllllllIlllIllIIIIllIllIlIlI, lllllllllllIlllIllIIIIllIlIlllIl);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIlllIllIIIIlllIIIIlIl, final int lllllllllllIlllIllIIIIlllIIIIlII, final int lllllllllllIlllIllIIIIlllIIIIIll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiMerchant.MERCHANT_GUI_TEXTURE);
        final int lllllllllllIlllIllIIIIlllIIIIIlI = (this.width - this.xSize) / 2;
        final int lllllllllllIlllIllIIIIlllIIIIIIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllIlllIllIIIIlllIIIIIlI, lllllllllllIlllIllIIIIlllIIIIIIl, 0, 0, this.xSize, this.ySize);
        final MerchantRecipeList lllllllllllIlllIllIIIIlllIIIIIII = this.merchant.getRecipes(this.mc.player);
        if (lllllllllllIlllIllIIIIlllIIIIIII != null && !lllllllllllIlllIllIIIIlllIIIIIII.isEmpty()) {
            final int lllllllllllIlllIllIIIIllIlllllll = this.selectedMerchantRecipe;
            if (lllllllllllIlllIllIIIIllIlllllll < 0 || lllllllllllIlllIllIIIIllIlllllll >= lllllllllllIlllIllIIIIlllIIIIIII.size()) {
                return;
            }
            final MerchantRecipe lllllllllllIlllIllIIIIllIllllllI = lllllllllllIlllIllIIIIlllIIIIIII.get(lllllllllllIlllIllIIIIllIlllllll);
            if (lllllllllllIlllIllIIIIllIllllllI.isRecipeDisabled()) {
                this.mc.getTextureManager().bindTexture(GuiMerchant.MERCHANT_GUI_TEXTURE);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.disableLighting();
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 21, 212, 0, 28, 21);
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 51, 212, 0, 28, 21);
            }
        }
    }
    
    public GuiMerchant(final InventoryPlayer lllllllllllIlllIllIIIIlllIllIIll, final IMerchant lllllllllllIlllIllIIIIlllIllIIlI, final World lllllllllllIlllIllIIIIlllIllIlIl) {
        super(new ContainerMerchant(lllllllllllIlllIllIIIIlllIllIIll, lllllllllllIlllIllIIIIlllIllIIlI, lllllllllllIlllIllIIIIlllIllIlIl));
        this.merchant = lllllllllllIlllIllIIIIlllIllIIlI;
        this.chatComponent = lllllllllllIlllIllIIIIlllIllIIlI.getDisplayName();
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final MerchantRecipeList lllllllllllIlllIllIIIIlllIIlllII = this.merchant.getRecipes(this.mc.player);
        if (lllllllllllIlllIllIIIIlllIIlllII != null) {
            this.nextButton.enabled = (this.selectedMerchantRecipe < lllllllllllIlllIllIIIIlllIIlllII.size() - 1);
            this.previousButton.enabled = (this.selectedMerchantRecipe > 0);
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        final int lllllllllllIlllIllIIIIlllIlIllII = (this.width - this.xSize) / 2;
        final int lllllllllllIlllIllIIIIlllIlIlIll = (this.height - this.ySize) / 2;
        this.nextButton = this.addButton(new MerchantButton(1, lllllllllllIlllIllIIIIlllIlIllII + 120 + 27, lllllllllllIlllIllIIIIlllIlIlIll + 24 - 1, true));
        this.previousButton = this.addButton(new MerchantButton(2, lllllllllllIlllIllIIIIlllIlIllII + 36 - 19, lllllllllllIlllIllIIIIlllIlIlIll + 24 - 1, false));
        this.nextButton.enabled = false;
        this.previousButton.enabled = false;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIlllIllIIIIlllIlIIlII, final int lllllllllllIlllIllIIIIlllIlIIIll) {
        final String lllllllllllIlllIllIIIIlllIlIIIlI = this.chatComponent.getUnformattedText();
        this.fontRendererObj.drawString(lllllllllllIlllIllIIIIlllIlIIIlI, (float)(this.xSize / 2 - this.fontRendererObj.getStringWidth(lllllllllllIlllIllIIIIlllIlIIIlI) / 2), 6.0f, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
    
    public IMerchant getMerchant() {
        return this.merchant;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlllIllIIIIlllIIlIlII) throws IOException {
        boolean lllllllllllIlllIllIIIIlllIIlIIll = false;
        if (lllllllllllIlllIllIIIIlllIIlIlII == this.nextButton) {
            ++this.selectedMerchantRecipe;
            final MerchantRecipeList lllllllllllIlllIllIIIIlllIIlIIlI = this.merchant.getRecipes(this.mc.player);
            if (lllllllllllIlllIllIIIIlllIIlIIlI != null && this.selectedMerchantRecipe >= lllllllllllIlllIllIIIIlllIIlIIlI.size()) {
                this.selectedMerchantRecipe = lllllllllllIlllIllIIIIlllIIlIIlI.size() - 1;
            }
            lllllllllllIlllIllIIIIlllIIlIIll = true;
        }
        else if (lllllllllllIlllIllIIIIlllIIlIlII == this.previousButton) {
            --this.selectedMerchantRecipe;
            if (this.selectedMerchantRecipe < 0) {
                this.selectedMerchantRecipe = 0;
            }
            lllllllllllIlllIllIIIIlllIIlIIll = true;
        }
        if (lllllllllllIlllIllIIIIlllIIlIIll) {
            ((ContainerMerchant)this.inventorySlots).setCurrentRecipeIndex(this.selectedMerchantRecipe);
            final PacketBuffer lllllllllllIlllIllIIIIlllIIlIIIl = new PacketBuffer(Unpooled.buffer());
            lllllllllllIlllIllIIIIlllIIlIIIl.writeInt(this.selectedMerchantRecipe);
            this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|TrSel", lllllllllllIlllIllIIIIlllIIlIIIl));
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        MERCHANT_GUI_TEXTURE = new ResourceLocation("textures/gui/container/villager.png");
    }
    
    static class MerchantButton extends GuiButton
    {
        private final /* synthetic */ boolean forward;
        
        public MerchantButton(final int lllllllllllIlIllIlIllIlIlIlIIIIl, final int lllllllllllIlIllIlIllIlIlIIllIll, final int lllllllllllIlIllIlIllIlIlIIllIlI, final boolean lllllllllllIlIllIlIllIlIlIIllllI) {
            super(lllllllllllIlIllIlIllIlIlIlIIIIl, lllllllllllIlIllIlIllIlIlIIllIll, lllllllllllIlIllIlIllIlIlIIllIlI, 12, 19, "");
            this.forward = lllllllllllIlIllIlIllIlIlIIllllI;
        }
        
        public void func_191745_a(final Minecraft lllllllllllIlIllIlIllIlIlIIIlIII, final int lllllllllllIlIllIlIllIlIlIIIllll, final int lllllllllllIlIllIlIllIlIlIIIlllI, final float lllllllllllIlIllIlIllIlIlIIIllIl) {
            if (this.visible) {
                lllllllllllIlIllIlIllIlIlIIIlIII.getTextureManager().bindTexture(GuiMerchant.MERCHANT_GUI_TEXTURE);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                final boolean lllllllllllIlIllIlIllIlIlIIIllII = lllllllllllIlIllIlIllIlIlIIIllll >= this.xPosition && lllllllllllIlIllIlIllIlIlIIIlllI >= this.yPosition && lllllllllllIlIllIlIllIlIlIIIllll < this.xPosition + this.width && lllllllllllIlIllIlIllIlIlIIIlllI < this.yPosition + this.height;
                int lllllllllllIlIllIlIllIlIlIIIlIll = 0;
                int lllllllllllIlIllIlIllIlIlIIIlIlI = 176;
                if (!this.enabled) {
                    lllllllllllIlIllIlIllIlIlIIIlIlI += this.width * 2;
                }
                else if (lllllllllllIlIllIlIllIlIlIIIllII) {
                    lllllllllllIlIllIlIllIlIlIIIlIlI += this.width;
                }
                if (!this.forward) {
                    lllllllllllIlIllIlIllIlIlIIIlIll += this.height;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, lllllllllllIlIllIlIllIlIlIIIlIlI, lllllllllllIlIllIlIllIlIlIIIlIll, this.width, this.height);
            }
        }
    }
}
