// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import java.util.Collections;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Items;
import java.util.Arrays;
import net.minecraft.init.Biomes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import com.google.common.collect.Lists;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;
import java.util.Map;
import com.google.common.collect.Maps;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.world.gen.FlatLayerInfo;
import net.minecraft.world.biome.Biome;
import net.minecraft.item.Item;
import java.io.IOException;
import java.util.List;

public class GuiFlatPresets extends GuiScreen
{
    private /* synthetic */ GuiButton btnSelect;
    private /* synthetic */ GuiTextField export;
    private /* synthetic */ ListSlot list;
    private /* synthetic */ String presetsShare;
    private static final /* synthetic */ List<LayerItem> FLAT_WORLD_PRESETS;
    private /* synthetic */ String presetsTitle;
    private final /* synthetic */ GuiCreateFlatWorld parentScreen;
    private /* synthetic */ String listText;
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    @Override
    public void updateScreen() {
        this.export.updateCursorCounter();
        super.updateScreen();
    }
    
    private static void registerPreset(final String lllllllllllIlllIIlIlIIIIIIIlllII, final Item lllllllllllIlllIIlIlIIIIIIIlIllI, final Biome lllllllllllIlllIIlIlIIIIIIIlIlIl, final List<String> lllllllllllIlllIIlIlIIIIIIIlIlII, final FlatLayerInfo... lllllllllllIlllIIlIlIIIIIIIlIIll) {
        registerPreset(lllllllllllIlllIIlIlIIIIIIIlllII, lllllllllllIlllIIlIlIIIIIIIlIllI, 0, lllllllllllIlllIIlIlIIIIIIIlIlIl, lllllllllllIlllIIlIlIIIIIIIlIlII, lllllllllllIlllIIlIlIIIIIIIlIIll);
    }
    
    public GuiFlatPresets(final GuiCreateFlatWorld lllllllllllIlllIIlIlIIIIIlIllIIl) {
        this.parentScreen = lllllllllllIlllIIlIlIIIIIlIllIIl;
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlllIIlIlIIIIIIllIIIl, final int lllllllllllIlllIIlIlIIIIIIllIIII, final float lllllllllllIlllIIlIlIIIIIIlIlIll) {
        this.drawDefaultBackground();
        this.list.drawScreen(lllllllllllIlllIIlIlIIIIIIllIIIl, lllllllllllIlllIIlIlIIIIIIllIIII, lllllllllllIlllIIlIlIIIIIIlIlIll);
        this.drawCenteredString(this.fontRendererObj, this.presetsTitle, this.width / 2, 8, 16777215);
        this.drawString(this.fontRendererObj, this.presetsShare, 50, 30, 10526880);
        this.drawString(this.fontRendererObj, this.listText, 50, 70, 10526880);
        this.export.drawTextBox();
        super.drawScreen(lllllllllllIlllIIlIlIIIIIIllIIIl, lllllllllllIlllIIlIlIIIIIIllIIII, lllllllllllIlllIIlIlIIIIIIlIlIll);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlllIIlIlIIIIIIllIlll) throws IOException {
        if (lllllllllllIlllIIlIlIIIIIIllIlll.id == 0 && this.hasValidSelection()) {
            this.parentScreen.setPreset(this.export.getText());
            this.mc.displayGuiScreen(this.parentScreen);
        }
        else if (lllllllllllIlllIIlIlIIIIIIllIlll.id == 1) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
    
    private static void registerPreset(final String lllllllllllIlllIIlIlIIIIIIIIlIIl, final Item lllllllllllIlllIIlIIllllllllllll, final int lllllllllllIlllIIlIIlllllllllllI, final Biome lllllllllllIlllIIlIlIIIIIIIIIllI, final List<String> lllllllllllIlllIIlIlIIIIIIIIIlIl, final FlatLayerInfo... lllllllllllIlllIIlIIlllllllllIll) {
        final FlatGeneratorInfo lllllllllllIlllIIlIlIIIIIIIIIIll = new FlatGeneratorInfo();
        for (int lllllllllllIlllIIlIlIIIIIIIIIIlI = lllllllllllIlllIIlIIlllllllllIll.length - 1; lllllllllllIlllIIlIlIIIIIIIIIIlI >= 0; --lllllllllllIlllIIlIlIIIIIIIIIIlI) {
            lllllllllllIlllIIlIlIIIIIIIIIIll.getFlatLayers().add(lllllllllllIlllIIlIIlllllllllIll[lllllllllllIlllIIlIlIIIIIIIIIIlI]);
        }
        lllllllllllIlllIIlIlIIIIIIIIIIll.setBiome(Biome.getIdForBiome(lllllllllllIlllIIlIlIIIIIIIIIllI));
        lllllllllllIlllIIlIlIIIIIIIIIIll.updateLayers();
        for (final String lllllllllllIlllIIlIlIIIIIIIIIIIl : lllllllllllIlllIIlIlIIIIIIIIIlIl) {
            lllllllllllIlllIIlIlIIIIIIIIIIll.getWorldFeatures().put(lllllllllllIlllIIlIlIIIIIIIIIIIl, Maps.newHashMap());
        }
        GuiFlatPresets.FLAT_WORLD_PRESETS.add(new LayerItem(lllllllllllIlllIIlIIllllllllllll, lllllllllllIlllIIlIIlllllllllllI, lllllllllllIlllIIlIlIIIIIIIIlIIl, lllllllllllIlllIIlIlIIIIIIIIIIll.toString()));
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlllIIlIlIIIIIlIIlIII, final int lllllllllllIlllIIlIlIIIIIlIIIlll, final int lllllllllllIlllIIlIlIIIIIlIIIllI) throws IOException {
        this.export.mouseClicked(lllllllllllIlllIIlIlIIIIIlIIlIII, lllllllllllIlllIIlIlIIIIIlIIIlll, lllllllllllIlllIIlIlIIIIIlIIIllI);
        super.mouseClicked(lllllllllllIlllIIlIlIIIIIlIIlIII, lllllllllllIlllIIlIlIIIIIlIIIlll, lllllllllllIlllIIlIlIIIIIlIIIllI);
    }
    
    public void updateButtonValidity() {
        this.btnSelect.enabled = this.hasValidSelection();
    }
    
    private boolean hasValidSelection() {
        return (this.list.selected > -1 && this.list.selected < GuiFlatPresets.FLAT_WORLD_PRESETS.size()) || this.export.getText().length() > 1;
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.presetsTitle = I18n.format("createWorld.customize.presets.title", new Object[0]);
        this.presetsShare = I18n.format("createWorld.customize.presets.share", new Object[0]);
        this.listText = I18n.format("createWorld.customize.presets.list", new Object[0]);
        this.export = new GuiTextField(2, this.fontRendererObj, 50, 40, this.width - 100, 20);
        this.list = new ListSlot();
        this.export.setMaxStringLength(1230);
        this.export.setText(this.parentScreen.getPreset());
        this.btnSelect = this.addButton(new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("createWorld.customize.presets.select", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.updateButtonValidity();
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlllIIlIlIIIIIIlllllI, final int lllllllllllIlllIIlIlIIIIIlIIIIII) throws IOException {
        if (!this.export.textboxKeyTyped(lllllllllllIlllIIlIlIIIIIIlllllI, lllllllllllIlllIIlIlIIIIIlIIIIII)) {
            super.keyTyped(lllllllllllIlllIIlIlIIIIIIlllllI, lllllllllllIlllIIlIlIIIIIlIIIIII);
        }
    }
    
    static {
        FLAT_WORLD_PRESETS = Lists.newArrayList();
        registerPreset(I18n.format("createWorld.customize.preset.classic_flat", new Object[0]), Item.getItemFromBlock(Blocks.GRASS), Biomes.PLAINS, Arrays.asList("village"), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(2, Blocks.DIRT), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.tunnelers_dream", new Object[0]), Item.getItemFromBlock(Blocks.STONE), Biomes.EXTREME_HILLS, Arrays.asList("biome_1", "dungeon", "decoration", "stronghold", "mineshaft"), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(5, Blocks.DIRT), new FlatLayerInfo(230, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.water_world", new Object[0]), Items.WATER_BUCKET, Biomes.DEEP_OCEAN, Arrays.asList("biome_1", "oceanmonument"), new FlatLayerInfo(90, Blocks.WATER), new FlatLayerInfo(5, Blocks.SAND), new FlatLayerInfo(5, Blocks.DIRT), new FlatLayerInfo(5, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.overworld", new Object[0]), Item.getItemFromBlock(Blocks.TALLGRASS), BlockTallGrass.EnumType.GRASS.getMeta(), Biomes.PLAINS, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake"), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(3, Blocks.DIRT), new FlatLayerInfo(59, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.snowy_kingdom", new Object[0]), Item.getItemFromBlock(Blocks.SNOW_LAYER), Biomes.ICE_PLAINS, Arrays.asList("village", "biome_1"), new FlatLayerInfo(1, Blocks.SNOW_LAYER), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(3, Blocks.DIRT), new FlatLayerInfo(59, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.bottomless_pit", new Object[0]), Items.FEATHER, Biomes.PLAINS, Arrays.asList("village", "biome_1"), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(3, Blocks.DIRT), new FlatLayerInfo(2, Blocks.COBBLESTONE));
        registerPreset(I18n.format("createWorld.customize.preset.desert", new Object[0]), Item.getItemFromBlock(Blocks.SAND), Biomes.DESERT, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon"), new FlatLayerInfo(8, Blocks.SAND), new FlatLayerInfo(52, Blocks.SANDSTONE), new FlatLayerInfo(3, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.redstone_ready", new Object[0]), Items.REDSTONE, Biomes.DESERT, Collections.emptyList(), new FlatLayerInfo(52, Blocks.SANDSTONE), new FlatLayerInfo(3, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.the_void", new Object[0]), Item.getItemFromBlock(Blocks.BARRIER), Biomes.VOID, Arrays.asList("decoration"), new FlatLayerInfo(1, Blocks.AIR));
    }
    
    static class LayerItem
    {
        public /* synthetic */ String name;
        public /* synthetic */ String generatorInfo;
        public /* synthetic */ Item icon;
        public /* synthetic */ int iconMetadata;
        
        public LayerItem(final Item lllllllllllllIllIlIIllIIlIIllIIl, final int lllllllllllllIllIlIIllIIlIIlllIl, final String lllllllllllllIllIlIIllIIlIIlllII, final String lllllllllllllIllIlIIllIIlIIllIll) {
            this.icon = lllllllllllllIllIlIIllIIlIIllIIl;
            this.iconMetadata = lllllllllllllIllIlIIllIIlIIlllIl;
            this.name = lllllllllllllIllIlIIllIIlIIlllII;
            this.generatorInfo = lllllllllllllIllIlIIllIIlIIllIll;
        }
    }
    
    class ListSlot extends GuiSlot
    {
        public /* synthetic */ int selected;
        
        @Override
        protected void elementClicked(final int llllllllllIllllIIIIlIIlIllllIlll, final boolean llllllllllIllllIIIIlIIlIlllllIll, final int llllllllllIllllIIIIlIIlIlllllIlI, final int llllllllllIllllIIIIlIIlIlllllIIl) {
            this.selected = llllllllllIllllIIIIlIIlIllllIlll;
            GuiFlatPresets.this.updateButtonValidity();
            GuiFlatPresets.this.export.setText(GuiFlatPresets.FLAT_WORLD_PRESETS.get(GuiFlatPresets.this.list.selected).generatorInfo);
        }
        
        @Override
        protected boolean isSelected(final int llllllllllIllllIIIIlIIlIllllIIIl) {
            return llllllllllIllllIIIIlIIlIllllIIIl == this.selected;
        }
        
        @Override
        protected void drawBackground() {
        }
        
        @Override
        protected void func_192637_a(final int llllllllllIllllIIIIlIIlIlllIIIII, final int llllllllllIllllIIIIlIIlIllIlllll, final int llllllllllIllllIIIIlIIlIlllIIlll, final int llllllllllIllllIIIIlIIlIlllIIllI, final int llllllllllIllllIIIIlIIlIlllIIlIl, final int llllllllllIllllIIIIlIIlIlllIIlII, final float llllllllllIllllIIIIlIIlIlllIIIll) {
            final LayerItem llllllllllIllllIIIIlIIlIlllIIIlI = GuiFlatPresets.FLAT_WORLD_PRESETS.get(llllllllllIllllIIIIlIIlIlllIIIII);
            this.renderIcon(llllllllllIllllIIIIlIIlIllIlllll, llllllllllIllllIIIIlIIlIlllIIlll, llllllllllIllllIIIIlIIlIlllIIIlI.icon, llllllllllIllllIIIIlIIlIlllIIIlI.iconMetadata);
            GuiFlatPresets.this.fontRendererObj.drawString(llllllllllIllllIIIIlIIlIlllIIIlI.name, (float)(llllllllllIllllIIIIlIIlIllIlllll + 18 + 5), (float)(llllllllllIllllIIIIlIIlIlllIIlll + 6), 16777215);
        }
        
        public ListSlot() {
            super(GuiFlatPresets.this.mc, GuiFlatPresets.this.width, GuiFlatPresets.this.height, 80, GuiFlatPresets.this.height - 37, 24);
            this.selected = -1;
        }
        
        private void blitSlotBg(final int llllllllllIllllIIIIlIIllIIlIIIll, final int llllllllllIllllIIIIlIIllIIlIIIlI) {
            this.blitSlotIcon(llllllllllIllllIIIIlIIllIIlIIIll, llllllllllIllllIIIIlIIllIIlIIIlI, 0, 0);
        }
        
        @Override
        protected int getSize() {
            return GuiFlatPresets.FLAT_WORLD_PRESETS.size();
        }
        
        private void renderIcon(final int llllllllllIllllIIIIlIIllIIllIIll, final int llllllllllIllllIIIIlIIllIIllIIlI, final Item llllllllllIllllIIIIlIIllIIllIIIl, final int llllllllllIllllIIIIlIIllIIlIlIll) {
            this.blitSlotBg(llllllllllIllllIIIIlIIllIIllIIll + 1, llllllllllIllllIIIIlIIllIIllIIlI + 1);
            GlStateManager.enableRescaleNormal();
            RenderHelper.enableGUIStandardItemLighting();
            GuiFlatPresets.this.itemRender.renderItemIntoGUI(new ItemStack(llllllllllIllllIIIIlIIllIIllIIIl, 1, llllllllllIllllIIIIlIIllIIllIIIl.getHasSubtypes() ? llllllllllIllllIIIIlIIllIIlIlIll : 0), (float)(llllllllllIllllIIIIlIIllIIllIIll + 2), (float)(llllllllllIllllIIIIlIIllIIllIIlI + 2));
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
        }
        
        private void blitSlotIcon(final int llllllllllIllllIIIIlIIllIIIIlIlI, final int llllllllllIllllIIIIlIIllIIIIlIIl, final int llllllllllIllllIIIIlIIllIIIIlIII, final int llllllllllIllllIIIIlIIllIIIIIlll) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(Gui.STAT_ICONS);
            final float llllllllllIllllIIIIlIIllIIIlIIIl = 0.0078125f;
            final float llllllllllIllllIIIIlIIllIIIlIIII = 0.0078125f;
            final int llllllllllIllllIIIIlIIllIIIIllll = 18;
            final int llllllllllIllllIIIIlIIllIIIIlllI = 18;
            final Tessellator llllllllllIllllIIIIlIIllIIIIllIl = Tessellator.getInstance();
            final BufferBuilder llllllllllIllllIIIIlIIllIIIIllII = llllllllllIllllIIIIlIIllIIIIllIl.getBuffer();
            llllllllllIllllIIIIlIIllIIIIllII.begin(7, DefaultVertexFormats.POSITION_TEX);
            llllllllllIllllIIIIlIIllIIIIllII.pos(llllllllllIllllIIIIlIIllIIIIlIlI + 0, llllllllllIllllIIIIlIIllIIIIlIIl + 18, GuiFlatPresets.this.zLevel).tex((llllllllllIllllIIIIlIIllIIIIlIII + 0) * 0.0078125f, (llllllllllIllllIIIIlIIllIIIIIlll + 18) * 0.0078125f).endVertex();
            llllllllllIllllIIIIlIIllIIIIllII.pos(llllllllllIllllIIIIlIIllIIIIlIlI + 18, llllllllllIllllIIIIlIIllIIIIlIIl + 18, GuiFlatPresets.this.zLevel).tex((llllllllllIllllIIIIlIIllIIIIlIII + 18) * 0.0078125f, (llllllllllIllllIIIIlIIllIIIIIlll + 18) * 0.0078125f).endVertex();
            llllllllllIllllIIIIlIIllIIIIllII.pos(llllllllllIllllIIIIlIIllIIIIlIlI + 18, llllllllllIllllIIIIlIIllIIIIlIIl + 0, GuiFlatPresets.this.zLevel).tex((llllllllllIllllIIIIlIIllIIIIlIII + 18) * 0.0078125f, (llllllllllIllllIIIIlIIllIIIIIlll + 0) * 0.0078125f).endVertex();
            llllllllllIllllIIIIlIIllIIIIllII.pos(llllllllllIllllIIIIlIIllIIIIlIlI + 0, llllllllllIllllIIIIlIIllIIIIlIIl + 0, GuiFlatPresets.this.zLevel).tex((llllllllllIllllIIIIlIIllIIIIlIII + 0) * 0.0078125f, (llllllllllIllllIIIIlIIllIIIIIlll + 0) * 0.0078125f).endVertex();
            llllllllllIllllIIIIlIIllIIIIllIl.draw();
        }
    }
}
