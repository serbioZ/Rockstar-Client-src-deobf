// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import java.io.IOException;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.recipebook.GuiRecipeBook;
import net.minecraft.client.gui.recipebook.IRecipeShownListener;
import net.minecraft.client.renderer.InventoryEffectRenderer;

public class GuiInventory extends InventoryEffectRenderer implements IRecipeShownListener
{
    private /* synthetic */ boolean field_194031_B;
    private final /* synthetic */ GuiRecipeBook field_192045_A;
    public static /* synthetic */ float oldMouseX;
    private /* synthetic */ boolean field_192046_B;
    private /* synthetic */ GuiButtonImage field_192048_z;
    public static /* synthetic */ float oldMouseY;
    
    @Override
    public GuiRecipeBook func_194310_f() {
        return this.field_192045_A;
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIIlllIIlIIllIIIIIllI) throws IOException {
        if (llllllllllllIIlllIIlIIllIIIIIllI.id == 10) {
            this.field_192045_A.func_193014_a(this.field_192046_B, ((ContainerPlayer)this.inventorySlots).craftMatrix);
            this.field_192045_A.func_191866_a();
            this.guiLeft = this.field_192045_A.func_193011_a(this.field_192046_B, this.width, this.xSize);
            this.field_192048_z.func_191746_c(this.guiLeft + 104, this.height / 2 - 22);
            this.field_194031_B = true;
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.player));
        }
        else {
            super.initGui();
        }
        this.field_192046_B = (this.width < 379);
        this.field_192045_A.func_194303_a(this.width, this.height, this.mc, this.field_192046_B, ((ContainerPlayer)this.inventorySlots).craftMatrix);
        this.guiLeft = this.field_192045_A.func_193011_a(this.field_192046_B, this.width, this.xSize);
        this.field_192048_z = new GuiButtonImage(10, this.guiLeft + 104, this.height / 2 - 22, 20, 18, 178, 0, 19, GuiInventory.INVENTORY_BACKGROUND);
        this.buttonList.add(this.field_192048_z);
    }
    
    @Override
    public void func_192043_J_() {
        this.field_192045_A.func_193948_e();
    }
    
    @Override
    public void handleMouseClick(final Slot llllllllllllIIlllIIlIIlIlllIllll, final int llllllllllllIIlllIIlIIlIlllIlllI, final int llllllllllllIIlllIIlIIlIlllIllIl, final ClickType llllllllllllIIlllIIlIIlIllllIIIl) {
        super.handleMouseClick(llllllllllllIIlllIIlIIlIlllIllll, llllllllllllIIlllIIlIIlIlllIlllI, llllllllllllIIlllIIlIIlIlllIllIl, llllllllllllIIlllIIlIIlIllllIIIl);
        this.field_192045_A.func_191874_a(llllllllllllIIlllIIlIIlIlllIllll);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllIIlllIIlIIlllIIIIlll, final int llllllllllllIIlllIIlIIlllIIIIllI) {
        this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 97.0f, 8.0f, 4210752);
    }
    
    @Override
    protected boolean func_193983_c(final int llllllllllllIIlllIIlIIllIIIlIlII, final int llllllllllllIIlllIIlIIllIIIlIIll, final int llllllllllllIIlllIIlIIllIIIlIIlI, final int llllllllllllIIlllIIlIIllIIIIlIll) {
        final boolean llllllllllllIIlllIIlIIllIIIlIIII = llllllllllllIIlllIIlIIllIIIlIlII < llllllllllllIIlllIIlIIllIIIlIIlI || llllllllllllIIlllIIlIIllIIIlIIll < llllllllllllIIlllIIlIIllIIIIlIll || llllllllllllIIlllIIlIIllIIIlIlII >= llllllllllllIIlllIIlIIllIIIlIIlI + this.xSize || llllllllllllIIlllIIlIIllIIIlIIll >= llllllllllllIIlllIIlIIllIIIIlIll + this.ySize;
        return this.field_192045_A.func_193955_c(llllllllllllIIlllIIlIIllIIIlIlII, llllllllllllIIlllIIlIIllIIIlIIll, this.guiLeft, this.guiTop, this.xSize, this.ySize) && llllllllllllIIlllIIlIIllIIIlIIII;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllIIlllIIlIIllIlllIlII, final int llllllllllllIIlllIIlIIllIlllIIll, final int llllllllllllIIlllIIlIIllIlllIIlI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiInventory.INVENTORY_BACKGROUND);
        final int llllllllllllIIlllIIlIIllIlllIIIl = this.guiLeft;
        final int llllllllllllIIlllIIlIIllIlllIIII = this.guiTop;
        this.drawTexturedModalRect(llllllllllllIIlllIIlIIllIlllIIIl, llllllllllllIIlllIIlIIllIlllIIII, 0, 0, this.xSize, this.ySize);
        drawEntityOnScreen(llllllllllllIIlllIIlIIllIlllIIIl + 51, llllllllllllIIlllIIlIIllIlllIIII + 75, 30, llllllllllllIIlllIIlIIllIlllIIIl + 51 - GuiInventory.oldMouseX, llllllllllllIIlllIIlIIllIlllIIII + 75 - 50 - GuiInventory.oldMouseY, this.mc.player);
    }
    
    @Override
    protected boolean isPointInRegion(final int llllllllllllIIlllIIlIIllIlIIIIII, final int llllllllllllIIlllIIlIIllIIlllIII, final int llllllllllllIIlllIIlIIllIIllIlll, final int llllllllllllIIlllIIlIIllIIllIllI, final int llllllllllllIIlllIIlIIllIIllIlIl, final int llllllllllllIIlllIIlIIllIIllIlII) {
        return (!this.field_192046_B || !this.field_192045_A.func_191878_b()) && super.isPointInRegion(llllllllllllIIlllIIlIIllIlIIIIII, llllllllllllIIlllIIlIIllIIlllIII, llllllllllllIIlllIIlIIllIIllIlll, llllllllllllIIlllIIlIIllIIllIllI, llllllllllllIIlllIIlIIllIIllIlIl, llllllllllllIIlllIIlIIllIIllIlII);
    }
    
    @Override
    public void drawScreen(final int llllllllllllIIlllIIlIIllIllllIll, final int llllllllllllIIlllIIlIIllIllllIlI, final float llllllllllllIIlllIIlIIllIlllllIl) {
        this.drawDefaultBackground();
        this.hasActivePotionEffects = !this.field_192045_A.func_191878_b();
        if (this.field_192045_A.func_191878_b() && this.field_192046_B) {
            this.drawGuiContainerBackgroundLayer(llllllllllllIIlllIIlIIllIlllllIl, llllllllllllIIlllIIlIIllIllllIll, llllllllllllIIlllIIlIIllIllllIlI);
            this.field_192045_A.func_191861_a(llllllllllllIIlllIIlIIllIllllIll, llllllllllllIIlllIIlIIllIllllIlI, llllllllllllIIlllIIlIIllIlllllIl);
        }
        else {
            this.field_192045_A.func_191861_a(llllllllllllIIlllIIlIIllIllllIll, llllllllllllIIlllIIlIIllIllllIlI, llllllllllllIIlllIIlIIllIlllllIl);
            super.drawScreen(llllllllllllIIlllIIlIIllIllllIll, llllllllllllIIlllIIlIIllIllllIlI, llllllllllllIIlllIIlIIllIlllllIl);
            this.field_192045_A.func_191864_a(this.guiLeft, this.guiTop, false, llllllllllllIIlllIIlIIllIlllllIl);
        }
        this.func_191948_b(llllllllllllIIlllIIlIIllIllllIll, llllllllllllIIlllIIlIIllIllllIlI);
        this.field_192045_A.func_191876_c(this.guiLeft, this.guiTop, llllllllllllIIlllIIlIIllIllllIll, llllllllllllIIlllIIlIIllIllllIlI);
        GuiInventory.oldMouseX = (float)llllllllllllIIlllIIlIIllIllllIll;
        GuiInventory.oldMouseY = (float)llllllllllllIIlllIIlIIllIllllIlI;
    }
    
    @Override
    public void onGuiClosed() {
        this.field_192045_A.func_191871_c();
        super.onGuiClosed();
    }
    
    @Override
    protected void mouseReleased(final int llllllllllllIIlllIIlIIllIIIllllI, final int llllllllllllIIlllIIlIIllIIlIIIIl, final int llllllllllllIIlllIIlIIllIIlIIIII) {
        if (this.field_194031_B) {
            this.field_194031_B = false;
        }
        else {
            super.mouseReleased(llllllllllllIIlllIIlIIllIIIllllI, llllllllllllIIlllIIlIIllIIlIIIIl, llllllllllllIIlllIIlIIllIIlIIIII);
        }
    }
    
    @Override
    public void updateScreen() {
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.player));
        }
        this.field_192045_A.func_193957_d();
    }
    
    public GuiInventory(final EntityPlayer llllllllllllIIlllIIlIIlllIIlIIlI) {
        super(llllllllllllIIlllIIlIIlllIIlIIlI.inventoryContainer);
        this.field_192045_A = new GuiRecipeBook();
        this.allowUserInput = true;
    }
    
    public static void drawEntityOnScreen(final int llllllllllllIIlllIIlIIllIllIIIII, final int llllllllllllIIlllIIlIIllIlIlllll, final int llllllllllllIIlllIIlIIllIlIllllI, final float llllllllllllIIlllIIlIIllIlIlIIIl, final float llllllllllllIIlllIIlIIllIlIlllII, final EntityLivingBase llllllllllllIIlllIIlIIllIlIllIll) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllIIlllIIlIIllIllIIIII, (float)llllllllllllIIlllIIlIIllIlIlllll, 50.0f);
        GlStateManager.scale((float)(-llllllllllllIIlllIIlIIllIlIllllI), (float)llllllllllllIIlllIIlIIllIlIllllI, (float)llllllllllllIIlllIIlIIllIlIllllI);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        final float llllllllllllIIlllIIlIIllIlIllIlI = llllllllllllIIlllIIlIIllIlIllIll.renderYawOffset;
        final float llllllllllllIIlllIIlIIllIlIllIIl = llllllllllllIIlllIIlIIllIlIllIll.rotationYaw;
        final float llllllllllllIIlllIIlIIllIlIllIII = llllllllllllIIlllIIlIIllIlIllIll.rotationPitch;
        final float llllllllllllIIlllIIlIIllIlIlIlll = llllllllllllIIlllIIlIIllIlIllIll.prevRotationYawHead;
        final float llllllllllllIIlllIIlIIllIlIlIllI = llllllllllllIIlllIIlIIllIlIllIll.rotationYawHead;
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-(float)Math.atan(llllllllllllIIlllIIlIIllIlIlllII / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        llllllllllllIIlllIIlIIllIlIllIll.renderYawOffset = (float)Math.atan(llllllllllllIIlllIIlIIllIlIlIIIl / 40.0f) * 20.0f;
        llllllllllllIIlllIIlIIllIlIllIll.rotationYaw = (float)Math.atan(llllllllllllIIlllIIlIIllIlIlIIIl / 40.0f) * 70.0f;
        llllllllllllIIlllIIlIIllIlIllIll.rotationPitchHead = -(float)Math.atan(llllllllllllIIlllIIlIIllIlIlllII / 40.0f) * 20.0f;
        llllllllllllIIlllIIlIIllIlIllIll.rotationYawHead = llllllllllllIIlllIIlIIllIlIllIll.rotationYaw;
        llllllllllllIIlllIIlIIllIlIllIll.prevRotationYawHead = llllllllllllIIlllIIlIIllIlIllIll.rotationYaw;
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        final RenderManager llllllllllllIIlllIIlIIllIlIlIlIl = Minecraft.getMinecraft().getRenderManager();
        llllllllllllIIlllIIlIIllIlIlIlIl.setPlayerViewY(180.0f);
        llllllllllllIIlllIIlIIllIlIlIlIl.setRenderShadow(false);
        llllllllllllIIlllIIlIIllIlIlIlIl.doRenderEntity(llllllllllllIIlllIIlIIllIlIllIll, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        llllllllllllIIlllIIlIIllIlIlIlIl.setRenderShadow(true);
        llllllllllllIIlllIIlIIllIlIllIll.renderYawOffset = llllllllllllIIlllIIlIIllIlIllIlI;
        llllllllllllIIlllIIlIIllIlIllIll.rotationYaw = llllllllllllIIlllIIlIIllIlIllIIl;
        llllllllllllIIlllIIlIIllIlIllIll.rotationPitchHead = llllllllllllIIlllIIlIIllIlIllIII;
        llllllllllllIIlllIIlIIllIlIllIll.prevRotationYawHead = llllllllllllIIlllIIlIIllIlIlIlll;
        llllllllllllIIlllIIlIIllIlIllIll.rotationYawHead = llllllllllllIIlllIIlIIllIlIlIllI;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIIlllIIlIIlIllllllII, final int llllllllllllIIlllIIlIIlIlllllIll) throws IOException {
        if (!this.field_192045_A.func_191859_a(llllllllllllIIlllIIlIIlIllllllII, llllllllllllIIlllIIlIIlIlllllIll)) {
            super.keyTyped(llllllllllllIIlllIIlIIlIllllllII, llllllllllllIIlllIIlIIlIlllllIll);
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllIIlllIIlIIllIIlIlllI, final int llllllllllllIIlllIIlIIllIIlIlIIl, final int llllllllllllIIlllIIlIIllIIlIllII) throws IOException {
        if (!this.field_192045_A.func_191862_a(llllllllllllIIlllIIlIIllIIlIlllI, llllllllllllIIlllIIlIIllIIlIlIIl, llllllllllllIIlllIIlIIllIIlIllII) && (!this.field_192046_B || !this.field_192045_A.func_191878_b())) {
            super.mouseClicked(llllllllllllIIlllIIlIIllIIlIlllI, llllllllllllIIlllIIlIIllIIlIlIIl, llllllllllllIIlllIIlIIllIIlIllII);
        }
    }
}
