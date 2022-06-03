// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.gen.FlatLayerInfo;
import net.minecraft.client.resources.I18n;
import java.io.IOException;
import net.minecraft.world.gen.FlatGeneratorInfo;

public class GuiCreateFlatWorld extends GuiScreen
{
    private /* synthetic */ FlatGeneratorInfo theFlatGeneratorInfo;
    private /* synthetic */ String flatWorldTitle;
    private /* synthetic */ Details createFlatWorldListSlotGui;
    private /* synthetic */ String heightText;
    private final /* synthetic */ GuiCreateWorld createWorldGui;
    private /* synthetic */ String materialText;
    private /* synthetic */ GuiButton editLayerButton;
    private /* synthetic */ GuiButton removeLayerButton;
    private /* synthetic */ GuiButton addLayerButton;
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlIIIlllllllIIlIllllI) throws IOException {
        final int lllllllllllIlIIIlllllllIIllIIIII = this.theFlatGeneratorInfo.getFlatLayers().size() - this.createFlatWorldListSlotGui.selectedLayer - 1;
        if (lllllllllllIlIIIlllllllIIlIllllI.id == 1) {
            this.mc.displayGuiScreen(this.createWorldGui);
        }
        else if (lllllllllllIlIIIlllllllIIlIllllI.id == 0) {
            this.createWorldGui.chunkProviderSettingsJson = this.getPreset();
            this.mc.displayGuiScreen(this.createWorldGui);
        }
        else if (lllllllllllIlIIIlllllllIIlIllllI.id == 5) {
            this.mc.displayGuiScreen(new GuiFlatPresets(this));
        }
        else if (lllllllllllIlIIIlllllllIIlIllllI.id == 4 && this.hasSelectedLayer()) {
            this.theFlatGeneratorInfo.getFlatLayers().remove(lllllllllllIlIIIlllllllIIllIIIII);
            this.createFlatWorldListSlotGui.selectedLayer = Math.min(this.createFlatWorldListSlotGui.selectedLayer, this.theFlatGeneratorInfo.getFlatLayers().size() - 1);
        }
        this.theFlatGeneratorInfo.updateLayers();
        this.onLayersChanged();
    }
    
    public String getPreset() {
        return this.theFlatGeneratorInfo.toString();
    }
    
    private boolean hasSelectedLayer() {
        return this.createFlatWorldListSlotGui.selectedLayer > -1 && this.createFlatWorldListSlotGui.selectedLayer < this.theFlatGeneratorInfo.getFlatLayers().size();
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIIIlllllllIIlIIlIII, final int lllllllllllIlIIIlllllllIIlIIIlll, final float lllllllllllIlIIIlllllllIIlIIIllI) {
        this.drawDefaultBackground();
        this.createFlatWorldListSlotGui.drawScreen(lllllllllllIlIIIlllllllIIlIIlIII, lllllllllllIlIIIlllllllIIlIIIlll, lllllllllllIlIIIlllllllIIlIIIllI);
        this.drawCenteredString(this.fontRendererObj, this.flatWorldTitle, this.width / 2, 8, 16777215);
        final int lllllllllllIlIIIlllllllIIlIIlIlI = this.width / 2 - 92 - 16;
        this.drawString(this.fontRendererObj, this.materialText, lllllllllllIlIIIlllllllIIlIIlIlI, 32, 16777215);
        this.drawString(this.fontRendererObj, this.heightText, lllllllllllIlIIIlllllllIIlIIlIlI + 2 + 213 - this.fontRendererObj.getStringWidth(this.heightText), 32, 16777215);
        super.drawScreen(lllllllllllIlIIIlllllllIIlIIlIII, lllllllllllIlIIIlllllllIIlIIIlll, lllllllllllIlIIIlllllllIIlIIIllI);
    }
    
    public void setPreset(final String lllllllllllIlIIIlllllllIIllIlllI) {
        this.theFlatGeneratorInfo = FlatGeneratorInfo.createFlatGeneratorFromString(lllllllllllIlIIIlllllllIIllIlllI);
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.createFlatWorldListSlotGui.handleMouseInput();
    }
    
    public void onLayersChanged() {
        final boolean lllllllllllIlIIIlllllllIIlIllIIl = this.hasSelectedLayer();
        this.removeLayerButton.enabled = lllllllllllIlIIIlllllllIIlIllIIl;
        this.editLayerButton.enabled = lllllllllllIlIIIlllllllIIlIllIIl;
        this.editLayerButton.enabled = false;
        this.addLayerButton.enabled = false;
    }
    
    public GuiCreateFlatWorld(final GuiCreateWorld lllllllllllIlIIIlllllllIIlllIllI, final String lllllllllllIlIIIlllllllIIlllIlIl) {
        this.theFlatGeneratorInfo = FlatGeneratorInfo.getDefaultFlatGenerator();
        this.createWorldGui = lllllllllllIlIIIlllllllIIlllIllI;
        this.setPreset(lllllllllllIlIIIlllllllIIlllIlIl);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.flatWorldTitle = I18n.format("createWorld.customize.flat.title", new Object[0]);
        this.materialText = I18n.format("createWorld.customize.flat.tile", new Object[0]);
        this.heightText = I18n.format("createWorld.customize.flat.height", new Object[0]);
        this.createFlatWorldListSlotGui = new Details();
        this.addLayerButton = this.addButton(new GuiButton(2, this.width / 2 - 154, this.height - 52, 100, 20, String.valueOf(I18n.format("createWorld.customize.flat.addLayer", new Object[0])) + " (NYI)"));
        this.editLayerButton = this.addButton(new GuiButton(3, this.width / 2 - 50, this.height - 52, 100, 20, String.valueOf(I18n.format("createWorld.customize.flat.editLayer", new Object[0])) + " (NYI)"));
        this.removeLayerButton = this.addButton(new GuiButton(4, this.width / 2 - 155, this.height - 52, 150, 20, I18n.format("createWorld.customize.flat.removeLayer", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(5, this.width / 2 + 5, this.height - 52, 150, 20, I18n.format("createWorld.customize.presets", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.addLayerButton.visible = false;
        this.editLayerButton.visible = false;
        this.theFlatGeneratorInfo.updateLayers();
        this.onLayersChanged();
    }
    
    class Details extends GuiSlot
    {
        public /* synthetic */ int selectedLayer;
        
        @Override
        protected void drawBackground() {
        }
        
        @Override
        protected void func_192637_a(final int lllllllllllIllIllIllIlllIIllllIl, final int lllllllllllIllIllIllIlllIIlIlIll, final int lllllllllllIllIllIllIlllIIlIlIlI, final int lllllllllllIllIllIllIlllIIlllIlI, final int lllllllllllIllIllIllIlllIIlllIIl, final int lllllllllllIllIllIllIlllIIlllIII, final float lllllllllllIllIllIllIlllIIllIlll) {
            final FlatLayerInfo lllllllllllIllIllIllIlllIIllIllI = GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().get(GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().size() - lllllllllllIllIllIllIlllIIllllIl - 1);
            final IBlockState lllllllllllIllIllIllIlllIIllIlIl = lllllllllllIllIllIllIlllIIllIllI.getLayerMaterial();
            final Block lllllllllllIllIllIllIlllIIllIlII = lllllllllllIllIllIllIlllIIllIlIl.getBlock();
            Item lllllllllllIllIllIllIlllIIllIIll = Item.getItemFromBlock(lllllllllllIllIllIllIlllIIllIlII);
            if (lllllllllllIllIllIllIlllIIllIIll == Items.field_190931_a) {
                if (lllllllllllIllIllIllIlllIIllIlII != Blocks.WATER && lllllllllllIllIllIllIlllIIllIlII != Blocks.FLOWING_WATER) {
                    if (lllllllllllIllIllIllIlllIIllIlII == Blocks.LAVA || lllllllllllIllIllIllIlllIIllIlII == Blocks.FLOWING_LAVA) {
                        lllllllllllIllIllIllIlllIIllIIll = Items.LAVA_BUCKET;
                    }
                }
                else {
                    lllllllllllIllIllIllIlllIIllIIll = Items.WATER_BUCKET;
                }
            }
            final ItemStack lllllllllllIllIllIllIlllIIllIIlI = new ItemStack(lllllllllllIllIllIllIlllIIllIIll, 1, lllllllllllIllIllIllIlllIIllIIll.getHasSubtypes() ? lllllllllllIllIllIllIlllIIllIlII.getMetaFromState(lllllllllllIllIllIllIlllIIllIlIl) : 0);
            final String lllllllllllIllIllIllIlllIIllIIIl = lllllllllllIllIllIllIlllIIllIIll.getItemStackDisplayName(lllllllllllIllIllIllIlllIIllIIlI);
            this.drawItem(lllllllllllIllIllIllIlllIIlIlIll, lllllllllllIllIllIllIlllIIlIlIlI, lllllllllllIllIllIllIlllIIllIIlI);
            GuiCreateFlatWorld.this.fontRendererObj.drawString(lllllllllllIllIllIllIlllIIllIIIl, (float)(lllllllllllIllIllIllIlllIIlIlIll + 18 + 5), (float)(lllllllllllIllIllIllIlllIIlIlIlI + 3), 16777215);
            String lllllllllllIllIllIllIlllIIlIlllI = null;
            if (lllllllllllIllIllIllIlllIIllllIl == 0) {
                final String lllllllllllIllIllIllIlllIIllIIII = I18n.format("createWorld.customize.flat.layer.top", lllllllllllIllIllIllIlllIIllIllI.getLayerCount());
            }
            else if (lllllllllllIllIllIllIlllIIllllIl == GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().size() - 1) {
                final String lllllllllllIllIllIllIlllIIlIllll = I18n.format("createWorld.customize.flat.layer.bottom", lllllllllllIllIllIllIlllIIllIllI.getLayerCount());
            }
            else {
                lllllllllllIllIllIllIlllIIlIlllI = I18n.format("createWorld.customize.flat.layer", lllllllllllIllIllIllIlllIIllIllI.getLayerCount());
            }
            GuiCreateFlatWorld.this.fontRendererObj.drawString(lllllllllllIllIllIllIlllIIlIlllI, (float)(lllllllllllIllIllIllIlllIIlIlIll + 2 + 213 - GuiCreateFlatWorld.this.fontRendererObj.getStringWidth(lllllllllllIllIllIllIlllIIlIlllI)), (float)(lllllllllllIllIllIllIlllIIlIlIlI + 3), 16777215);
        }
        
        public Details() {
            super(GuiCreateFlatWorld.this.mc, GuiCreateFlatWorld.this.width, GuiCreateFlatWorld.this.height, 43, GuiCreateFlatWorld.this.height - 60, 24);
            this.selectedLayer = -1;
        }
        
        @Override
        protected void elementClicked(final int lllllllllllIllIllIllIlllIlIlIIIl, final boolean lllllllllllIllIllIllIlllIlIlIlIl, final int lllllllllllIllIllIllIlllIlIlIlII, final int lllllllllllIllIllIllIlllIlIlIIll) {
            this.selectedLayer = lllllllllllIllIllIllIlllIlIlIIIl;
            GuiCreateFlatWorld.this.onLayersChanged();
        }
        
        @Override
        protected int getScrollBarX() {
            return this.width - 70;
        }
        
        private void drawItemBackground(final int lllllllllllIllIllIllIllllIIIIIlI, final int lllllllllllIllIllIllIllllIIIIIIl) {
            this.drawItemBackground(lllllllllllIllIllIllIllllIIIIIlI, lllllllllllIllIllIllIllllIIIIIIl, 0, 0);
        }
        
        @Override
        protected int getSize() {
            return GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().size();
        }
        
        private void drawItemBackground(final int lllllllllllIllIllIllIlllIllIIllI, final int lllllllllllIllIllIllIlllIlllIIII, final int lllllllllllIllIllIllIlllIllIllll, final int lllllllllllIllIllIllIlllIllIIIll) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(Gui.STAT_ICONS);
            final float lllllllllllIllIllIllIlllIllIllIl = 0.0078125f;
            final float lllllllllllIllIllIllIlllIllIllII = 0.0078125f;
            final int lllllllllllIllIllIllIlllIllIlIll = 18;
            final int lllllllllllIllIllIllIlllIllIlIlI = 18;
            final Tessellator lllllllllllIllIllIllIlllIllIlIIl = Tessellator.getInstance();
            final BufferBuilder lllllllllllIllIllIllIlllIllIlIII = lllllllllllIllIllIllIlllIllIlIIl.getBuffer();
            lllllllllllIllIllIllIlllIllIlIII.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllIllIllIllIlllIllIlIII.pos(lllllllllllIllIllIllIlllIllIIllI + 0, lllllllllllIllIllIllIlllIlllIIII + 18, GuiCreateFlatWorld.this.zLevel).tex((lllllllllllIllIllIllIlllIllIllll + 0) * 0.0078125f, (lllllllllllIllIllIllIlllIllIIIll + 18) * 0.0078125f).endVertex();
            lllllllllllIllIllIllIlllIllIlIII.pos(lllllllllllIllIllIllIlllIllIIllI + 18, lllllllllllIllIllIllIlllIlllIIII + 18, GuiCreateFlatWorld.this.zLevel).tex((lllllllllllIllIllIllIlllIllIllll + 18) * 0.0078125f, (lllllllllllIllIllIllIlllIllIIIll + 18) * 0.0078125f).endVertex();
            lllllllllllIllIllIllIlllIllIlIII.pos(lllllllllllIllIllIllIlllIllIIllI + 18, lllllllllllIllIllIllIlllIlllIIII + 0, GuiCreateFlatWorld.this.zLevel).tex((lllllllllllIllIllIllIlllIllIllll + 18) * 0.0078125f, (lllllllllllIllIllIllIlllIllIIIll + 0) * 0.0078125f).endVertex();
            lllllllllllIllIllIllIlllIllIlIII.pos(lllllllllllIllIllIllIlllIllIIllI + 0, lllllllllllIllIllIllIlllIlllIIII + 0, GuiCreateFlatWorld.this.zLevel).tex((lllllllllllIllIllIllIlllIllIllll + 0) * 0.0078125f, (lllllllllllIllIllIllIlllIllIIIll + 0) * 0.0078125f).endVertex();
            lllllllllllIllIllIllIlllIllIlIIl.draw();
        }
        
        @Override
        protected boolean isSelected(final int lllllllllllIllIllIllIlllIlIIllIl) {
            return lllllllllllIllIllIllIlllIlIIllIl == this.selectedLayer;
        }
        
        private void drawItem(final int lllllllllllIllIllIllIllllIIIllIl, final int lllllllllllIllIllIllIllllIIIlIII, final ItemStack lllllllllllIllIllIllIllllIIIIlll) {
            this.drawItemBackground(lllllllllllIllIllIllIllllIIIllIl + 1, lllllllllllIllIllIllIllllIIIlIII + 1);
            GlStateManager.enableRescaleNormal();
            if (!lllllllllllIllIllIllIllllIIIIlll.func_190926_b()) {
                RenderHelper.enableGUIStandardItemLighting();
                GuiCreateFlatWorld.this.itemRender.renderItemIntoGUI(lllllllllllIllIllIllIllllIIIIlll, (float)(lllllllllllIllIllIllIllllIIIllIl + 2), (float)(lllllllllllIllIllIllIllllIIIlIII + 2));
                RenderHelper.disableStandardItemLighting();
            }
            GlStateManager.disableRescaleNormal();
        }
    }
}
