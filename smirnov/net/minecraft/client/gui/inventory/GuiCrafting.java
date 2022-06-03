// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import java.io.IOException;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.recipebook.GuiRecipeBook;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.recipebook.IRecipeShownListener;

public class GuiCrafting extends GuiContainer implements IRecipeShownListener
{
    private static final /* synthetic */ ResourceLocation CRAFTING_TABLE_GUI_TEXTURES;
    private final /* synthetic */ GuiRecipeBook field_192050_x;
    private /* synthetic */ GuiButtonImage field_192049_w;
    private /* synthetic */ boolean field_193112_y;
    
    @Override
    public void func_192043_J_() {
        this.field_192050_x.func_193948_e();
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIIIlllIIIIlIlIlIIllII) throws IOException {
        if (lllllllllllIIIlllIIIIlIlIlIIllII.id == 10) {
            this.field_192050_x.func_193014_a(this.field_193112_y, ((ContainerWorkbench)this.inventorySlots).craftMatrix);
            this.field_192050_x.func_191866_a();
            this.guiLeft = this.field_192050_x.func_193011_a(this.field_193112_y, this.width, this.xSize);
            this.field_192049_w.func_191746_c(this.guiLeft + 5, this.height / 2 - 49);
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.field_193112_y = (this.width < 379);
        this.field_192050_x.func_194303_a(this.width, this.height, this.mc, this.field_193112_y, ((ContainerWorkbench)this.inventorySlots).craftMatrix);
        this.guiLeft = this.field_192050_x.func_193011_a(this.field_193112_y, this.width, this.xSize);
        this.field_192049_w = new GuiButtonImage(10, this.guiLeft + 5, this.height / 2 - 49, 20, 18, 0, 168, 19, GuiCrafting.CRAFTING_TABLE_GUI_TEXTURES);
        this.buttonList.add(this.field_192049_w);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        this.field_192050_x.func_193957_d();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIIIlllIIIIlIlIllIIlII, final int lllllllllllIIIlllIIIIlIlIllIIIll, final int lllllllllllIIIlllIIIIlIlIllIIIlI) throws IOException {
        if (!this.field_192050_x.func_191862_a(lllllllllllIIIlllIIIIlIlIllIIlII, lllllllllllIIIlllIIIIlIlIllIIIll, lllllllllllIIIlllIIIIlIlIllIIIlI) && (!this.field_193112_y || !this.field_192050_x.func_191878_b())) {
            super.mouseClicked(lllllllllllIIIlllIIIIlIlIllIIlII, lllllllllllIIIlllIIIIlIlIllIIIll, lllllllllllIIIlllIIIIlIlIllIIIlI);
        }
    }
    
    static {
        CRAFTING_TABLE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/crafting_table.png");
    }
    
    @Override
    protected boolean func_193983_c(final int lllllllllllIIIlllIIIIlIlIlIlIlII, final int lllllllllllIIIlllIIIIlIlIlIllIIl, final int lllllllllllIIIlllIIIIlIlIlIlIIlI, final int lllllllllllIIIlllIIIIlIlIlIlIlll) {
        final boolean lllllllllllIIIlllIIIIlIlIlIlIllI = lllllllllllIIIlllIIIIlIlIlIlIlII < lllllllllllIIIlllIIIIlIlIlIlIIlI || lllllllllllIIIlllIIIIlIlIlIllIIl < lllllllllllIIIlllIIIIlIlIlIlIlll || lllllllllllIIIlllIIIIlIlIlIlIlII >= lllllllllllIIIlllIIIIlIlIlIlIIlI + this.xSize || lllllllllllIIIlllIIIIlIlIlIllIIl >= lllllllllllIIIlllIIIIlIlIlIlIlll + this.ySize;
        return this.field_192050_x.func_193955_c(lllllllllllIIIlllIIIIlIlIlIlIlII, lllllllllllIIIlllIIIIlIlIlIllIIl, this.guiLeft, this.guiTop, this.xSize, this.ySize) && lllllllllllIIIlllIIIIlIlIlIlIllI;
    }
    
    @Override
    protected boolean isPointInRegion(final int lllllllllllIIIlllIIIIlIlIllllIlI, final int lllllllllllIIIlllIIIIlIlIlllIIlI, final int lllllllllllIIIlllIIIIlIlIlllIIIl, final int lllllllllllIIIlllIIIIlIlIlllIlll, final int lllllllllllIIIlllIIIIlIlIllIllll, final int lllllllllllIIIlllIIIIlIlIllIlllI) {
        return (!this.field_193112_y || !this.field_192050_x.func_191878_b()) && super.isPointInRegion(lllllllllllIIIlllIIIIlIlIllllIlI, lllllllllllIIIlllIIIIlIlIlllIIlI, lllllllllllIIIlllIIIIlIlIlllIIIl, lllllllllllIIIlllIIIIlIlIlllIlll, lllllllllllIIIlllIIIIlIlIllIllll, lllllllllllIIIlllIIIIlIlIllIlllI);
    }
    
    @Override
    public void drawScreen(final int lllllllllllIIIlllIIIIlIllIIllIlI, final int lllllllllllIIIlllIIIIlIllIIllIIl, final float lllllllllllIIIlllIIIIlIllIIllIII) {
        this.drawDefaultBackground();
        if (this.field_192050_x.func_191878_b() && this.field_193112_y) {
            this.drawGuiContainerBackgroundLayer(lllllllllllIIIlllIIIIlIllIIllIII, lllllllllllIIIlllIIIIlIllIIllIlI, lllllllllllIIIlllIIIIlIllIIllIIl);
            this.field_192050_x.func_191861_a(lllllllllllIIIlllIIIIlIllIIllIlI, lllllllllllIIIlllIIIIlIllIIllIIl, lllllllllllIIIlllIIIIlIllIIllIII);
        }
        else {
            this.field_192050_x.func_191861_a(lllllllllllIIIlllIIIIlIllIIllIlI, lllllllllllIIIlllIIIIlIllIIllIIl, lllllllllllIIIlllIIIIlIllIIllIII);
            super.drawScreen(lllllllllllIIIlllIIIIlIllIIllIlI, lllllllllllIIIlllIIIIlIllIIllIIl, lllllllllllIIIlllIIIIlIllIIllIII);
            this.field_192050_x.func_191864_a(this.guiLeft, this.guiTop, true, lllllllllllIIIlllIIIIlIllIIllIII);
        }
        this.func_191948_b(lllllllllllIIIlllIIIIlIllIIllIlI, lllllllllllIIIlllIIIIlIllIIllIIl);
        this.field_192050_x.func_191876_c(this.guiLeft, this.guiTop, lllllllllllIIIlllIIIIlIllIIllIlI, lllllllllllIIIlllIIIIlIllIIllIIl);
    }
    
    @Override
    public void handleMouseClick(final Slot lllllllllllIIIlllIIIIlIlIIlllIlI, final int lllllllllllIIIlllIIIIlIlIIlllIIl, final int lllllllllllIIIlllIIIIlIlIIllIIll, final ClickType lllllllllllIIIlllIIIIlIlIIllIIlI) {
        super.handleMouseClick(lllllllllllIIIlllIIIIlIlIIlllIlI, lllllllllllIIIlllIIIIlIlIIlllIIl, lllllllllllIIIlllIIIIlIlIIllIIll, lllllllllllIIIlllIIIIlIlIIllIIlI);
        this.field_192050_x.func_191874_a(lllllllllllIIIlllIIIIlIlIIlllIlI);
    }
    
    public GuiCrafting(final InventoryPlayer lllllllllllIIIlllIIIIlIllIllIIll, final World lllllllllllIIIlllIIIIlIllIllIIlI) {
        this(lllllllllllIIIlllIIIIlIllIllIIll, lllllllllllIIIlllIIIIlIllIllIIlI, BlockPos.ORIGIN);
    }
    
    @Override
    public void onGuiClosed() {
        this.field_192050_x.func_191871_c();
        super.onGuiClosed();
    }
    
    @Override
    public GuiRecipeBook func_194310_f() {
        return this.field_192050_x;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIIIlllIIIIlIllIIlIIIl, final int lllllllllllIIIlllIIIIlIllIIlIIII) {
        this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 28.0f, 6.0f, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIIIlllIIIIlIllIIIlIlI, final int lllllllllllIIIlllIIIIlIllIIIlIIl, final int lllllllllllIIIlllIIIIlIllIIIlIII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiCrafting.CRAFTING_TABLE_GUI_TEXTURES);
        final int lllllllllllIIIlllIIIIlIllIIIIlll = this.guiLeft;
        final int lllllllllllIIIlllIIIIlIllIIIIllI = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllIIIlllIIIIlIllIIIIlll, lllllllllllIIIlllIIIIlIllIIIIllI, 0, 0, this.xSize, this.ySize);
    }
    
    public GuiCrafting(final InventoryPlayer lllllllllllIIIlllIIIIlIllIlIllII, final World lllllllllllIIIlllIIIIlIllIlIlIll, final BlockPos lllllllllllIIIlllIIIIlIllIlIIllI) {
        super(new ContainerWorkbench(lllllllllllIIIlllIIIIlIllIlIllII, lllllllllllIIIlllIIIIlIllIlIlIll, lllllllllllIIIlllIIIIlIllIlIIllI));
        this.field_192050_x = new GuiRecipeBook();
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIIIlllIIIIlIlIlIIIlIl, final int lllllllllllIIIlllIIIIlIlIlIIIIIl) throws IOException {
        if (!this.field_192050_x.func_191859_a(lllllllllllIIIlllIIIIlIlIlIIIlIl, lllllllllllIIIlllIIIIlIlIlIIIIIl)) {
            super.keyTyped(lllllllllllIIIlllIIIIlIlIlIIIlIl, lllllllllllIIIlllIIIIlIlIlIIIIIl);
        }
    }
}
