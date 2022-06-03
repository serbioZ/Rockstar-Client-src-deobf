// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import com.google.common.collect.Lists;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;
import java.io.IOException;
import java.util.List;

public class GuiScreenCustomizePresets extends GuiScreen
{
    private static final /* synthetic */ List<Info> PRESETS;
    private final /* synthetic */ GuiCustomizeWorldScreen parent;
    private /* synthetic */ String shareText;
    private /* synthetic */ String listText;
    protected /* synthetic */ String title;
    private /* synthetic */ ListPreset list;
    private /* synthetic */ GuiTextField export;
    private /* synthetic */ GuiButton select;
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlIIIllIlIllIIIlIllIl, final int lllllllllllIlIIIllIlIllIIIlIllII) throws IOException {
        if (!this.export.textboxKeyTyped(lllllllllllIlIIIllIlIllIIIlIllIl, lllllllllllIlIIIllIlIllIIIlIllII)) {
            super.keyTyped(lllllllllllIlIIIllIlIllIIIlIllIl, lllllllllllIlIIIllIlIllIIIlIllII);
        }
    }
    
    public void updateButtonValidity() {
        this.select.enabled = this.hasValidSelection();
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.title = I18n.format("createWorld.customize.custom.presets.title", new Object[0]);
        this.shareText = I18n.format("createWorld.customize.presets.share", new Object[0]);
        this.listText = I18n.format("createWorld.customize.presets.list", new Object[0]);
        this.export = new GuiTextField(2, this.fontRendererObj, 50, 40, this.width - 100, 20);
        this.list = new ListPreset();
        this.export.setMaxStringLength(2000);
        this.export.setText(this.parent.saveValues());
        this.select = this.addButton(new GuiButton(0, this.width / 2 - 102, this.height - 27, 100, 20, I18n.format("createWorld.customize.presets.select", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 3, this.height - 27, 100, 20, I18n.format("gui.cancel", new Object[0])));
        this.updateButtonValidity();
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlIIIllIlIllIIIlIIIll) throws IOException {
        switch (lllllllllllIlIIIllIlIllIIIlIIIll.id) {
            case 0: {
                this.parent.loadValues(this.export.getText());
                this.mc.displayGuiScreen(this.parent);
                break;
            }
            case 1: {
                this.mc.displayGuiScreen(this.parent);
                break;
            }
        }
    }
    
    public GuiScreenCustomizePresets(final GuiCustomizeWorldScreen lllllllllllIlIIIllIlIllIIlIIIlIl) {
        this.title = "Customize World Presets";
        this.parent = lllllllllllIlIIIllIlIllIIlIIIlIl;
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIIIllIlIllIIIIlllIl, final int lllllllllllIlIIIllIlIllIIIIlllII, final float lllllllllllIlIIIllIlIllIIIIllIll) {
        this.drawDefaultBackground();
        this.list.drawScreen(lllllllllllIlIIIllIlIllIIIIlllIl, lllllllllllIlIIIllIlIllIIIIlllII, lllllllllllIlIIIllIlIllIIIIllIll);
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 8, 16777215);
        this.drawString(this.fontRendererObj, this.shareText, 50, 30, 10526880);
        this.drawString(this.fontRendererObj, this.listText, 50, 70, 10526880);
        this.export.drawTextBox();
        super.drawScreen(lllllllllllIlIIIllIlIllIIIIlllIl, lllllllllllIlIIIllIlIllIIIIlllII, lllllllllllIlIIIllIlIllIIIIllIll);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlIIIllIlIllIIIlllIII, final int lllllllllllIlIIIllIlIllIIIllIIll, final int lllllllllllIlIIIllIlIllIIIllIIlI) throws IOException {
        this.export.mouseClicked(lllllllllllIlIIIllIlIllIIIlllIII, lllllllllllIlIIIllIlIllIIIllIIll, lllllllllllIlIIIllIlIllIIIllIIlI);
        super.mouseClicked(lllllllllllIlIIIllIlIllIIIlllIII, lllllllllllIlIIIllIlIllIIIllIIll, lllllllllllIlIIIllIlIllIIIllIIlI);
    }
    
    static {
        PRESETS = Lists.newArrayList();
        ChunkGeneratorSettings.Factory lllllllllllIlIIIllIlIllIIlIIlllI = ChunkGeneratorSettings.Factory.jsonToFactory("{ \"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":8.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":0.5, \"biomeScaleWeight\":2.0, \"biomeScaleOffset\":0.375, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":255 }");
        ResourceLocation lllllllllllIlIIIllIlIllIIlIIllIl = new ResourceLocation("textures/gui/presets/water.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.waterWorld", new Object[0]), lllllllllllIlIIIllIlIllIIlIIllIl, lllllllllllIlIIIllIlIllIIlIIlllI));
        lllllllllllIlIIIllIlIllIIlIIlllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":3000.0, \"heightScale\":6000.0, \"upperLimitScale\":250.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
        lllllllllllIlIIIllIlIllIIlIIllIl = new ResourceLocation("textures/gui/presets/isles.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.isleLand", new Object[0]), lllllllllllIlIIIllIlIllIIlIIllIl, lllllllllllIlIIIllIlIllIIlIIlllI));
        lllllllllllIlIIIllIlIllIIlIIlllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":5.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":1.0, \"biomeScaleWeight\":4.0, \"biomeScaleOffset\":1.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
        lllllllllllIlIIIllIlIllIIlIIllIl = new ResourceLocation("textures/gui/presets/delight.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.caveDelight", new Object[0]), lllllllllllIlIIIllIlIllIIlIIllIl, lllllllllllIlIIIllIlIllIIlIIlllI));
        lllllllllllIlIIIllIlIllIIlIIlllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":738.41864, \"heightScale\":157.69133, \"upperLimitScale\":801.4267, \"lowerLimitScale\":1254.1643, \"depthNoiseScaleX\":374.93652, \"depthNoiseScaleZ\":288.65228, \"depthNoiseScaleExponent\":1.2092624, \"mainNoiseScaleX\":1355.9908, \"mainNoiseScaleY\":745.5343, \"mainNoiseScaleZ\":1183.464, \"baseSize\":1.8758626, \"stretchY\":1.7137525, \"biomeDepthWeight\":1.7553768, \"biomeDepthOffset\":3.4701107, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":2.535211, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
        lllllllllllIlIIIllIlIllIIlIIllIl = new ResourceLocation("textures/gui/presets/madness.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.mountains", new Object[0]), lllllllllllIlIIIllIlIllIIlIIllIl, lllllllllllIlIIIllIlIllIIlIIlllI));
        lllllllllllIlIIIllIlIllIIlIIlllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":1000.0, \"mainNoiseScaleY\":3000.0, \"mainNoiseScaleZ\":1000.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":20 }");
        lllllllllllIlIIIllIlIllIIlIIllIl = new ResourceLocation("textures/gui/presets/drought.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.drought", new Object[0]), lllllllllllIlIIIllIlIllIIlIIllIl, lllllllllllIlIIIllIlIllIIlIIlllI));
        lllllllllllIlIIIllIlIllIIlIIlllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":2.0, \"lowerLimitScale\":64.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":6 }");
        lllllllllllIlIIIllIlIllIIlIIllIl = new ResourceLocation("textures/gui/presets/chaos.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.caveChaos", new Object[0]), lllllllllllIlIIIllIlIllIIlIIllIl, lllllllllllIlIIIllIlIllIIlIIlllI));
        lllllllllllIlIIIllIlIllIIlIIlllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":true, \"seaLevel\":40 }");
        lllllllllllIlIIIllIlIllIIlIIllIl = new ResourceLocation("textures/gui/presets/luck.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.goodLuck", new Object[0]), lllllllllllIlIIIllIlIllIIlIIllIl, lllllllllllIlIIIllIlIllIIlIIlllI));
    }
    
    private boolean hasValidSelection() {
        return (this.list.selected > -1 && this.list.selected < GuiScreenCustomizePresets.PRESETS.size()) || this.export.getText().length() > 1;
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void updateScreen() {
        this.export.updateCursorCounter();
        super.updateScreen();
    }
    
    static class Info
    {
        public /* synthetic */ ResourceLocation texture;
        public /* synthetic */ String name;
        public /* synthetic */ ChunkGeneratorSettings.Factory settings;
        
        public Info(final String lllllllllllllIIIIlllllllllIlIlII, final ResourceLocation lllllllllllllIIIIlllllllllIlIIll, final ChunkGeneratorSettings.Factory lllllllllllllIIIIlllllllllIIlllI) {
            this.name = lllllllllllllIIIIlllllllllIlIlII;
            this.texture = lllllllllllllIIIIlllllllllIlIIll;
            this.settings = lllllllllllllIIIIlllllllllIIlllI;
        }
    }
    
    class ListPreset extends GuiSlot
    {
        public /* synthetic */ int selected;
        
        @Override
        protected boolean isSelected(final int llllllllllllllllIlIlIlIIlIllllII) {
            return llllllllllllllllIlIlIlIIlIllllII == this.selected;
        }
        
        @Override
        protected void drawBackground() {
        }
        
        private void blitIcon(final int llllllllllllllllIlIlIlIIlIlIIlIl, final int llllllllllllllllIlIlIlIIlIlIllIl, final ResourceLocation llllllllllllllllIlIlIlIIlIlIllII) {
            final int llllllllllllllllIlIlIlIIlIlIlIll = llllllllllllllllIlIlIlIIlIlIIlIl + 5;
            GuiScreenCustomizePresets.this.drawHorizontalLine(llllllllllllllllIlIlIlIIlIlIlIll - 1, llllllllllllllllIlIlIlIIlIlIlIll + 32, llllllllllllllllIlIlIlIIlIlIllIl - 1, -2039584);
            GuiScreenCustomizePresets.this.drawHorizontalLine(llllllllllllllllIlIlIlIIlIlIlIll - 1, llllllllllllllllIlIlIlIIlIlIlIll + 32, llllllllllllllllIlIlIlIIlIlIllIl + 32, -6250336);
            GuiScreenCustomizePresets.this.drawVerticalLine(llllllllllllllllIlIlIlIIlIlIlIll - 1, llllllllllllllllIlIlIlIIlIlIllIl - 1, llllllllllllllllIlIlIlIIlIlIllIl + 32, -2039584);
            GuiScreenCustomizePresets.this.drawVerticalLine(llllllllllllllllIlIlIlIIlIlIlIll + 32, llllllllllllllllIlIlIlIIlIlIllIl - 1, llllllllllllllllIlIlIlIIlIlIllIl + 32, -6250336);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(llllllllllllllllIlIlIlIIlIlIllII);
            final int llllllllllllllllIlIlIlIIlIlIlIlI = 32;
            final int llllllllllllllllIlIlIlIIlIlIlIIl = 32;
            final Tessellator llllllllllllllllIlIlIlIIlIlIlIII = Tessellator.getInstance();
            final BufferBuilder llllllllllllllllIlIlIlIIlIlIIlll = llllllllllllllllIlIlIlIIlIlIlIII.getBuffer();
            llllllllllllllllIlIlIlIIlIlIIlll.begin(7, DefaultVertexFormats.POSITION_TEX);
            llllllllllllllllIlIlIlIIlIlIIlll.pos(llllllllllllllllIlIlIlIIlIlIlIll + 0, llllllllllllllllIlIlIlIIlIlIllIl + 32, 0.0).tex(0.0, 1.0).endVertex();
            llllllllllllllllIlIlIlIIlIlIIlll.pos(llllllllllllllllIlIlIlIIlIlIlIll + 32, llllllllllllllllIlIlIlIIlIlIllIl + 32, 0.0).tex(1.0, 1.0).endVertex();
            llllllllllllllllIlIlIlIIlIlIIlll.pos(llllllllllllllllIlIlIlIIlIlIlIll + 32, llllllllllllllllIlIlIlIIlIlIllIl + 0, 0.0).tex(1.0, 0.0).endVertex();
            llllllllllllllllIlIlIlIIlIlIIlll.pos(llllllllllllllllIlIlIlIIlIlIlIll + 0, llllllllllllllllIlIlIlIIlIlIllIl + 0, 0.0).tex(0.0, 0.0).endVertex();
            llllllllllllllllIlIlIlIIlIlIlIII.draw();
        }
        
        @Override
        protected int getSize() {
            return GuiScreenCustomizePresets.PRESETS.size();
        }
        
        public ListPreset() {
            super(GuiScreenCustomizePresets.this.mc, GuiScreenCustomizePresets.this.width, GuiScreenCustomizePresets.this.height, 80, GuiScreenCustomizePresets.this.height - 32, 38);
            this.selected = -1;
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllllIlIlIlIIllIIIIII, final boolean llllllllllllllllIlIlIlIIllIIIlII, final int llllllllllllllllIlIlIlIIllIIIIll, final int llllllllllllllllIlIlIlIIllIIIIlI) {
            this.selected = llllllllllllllllIlIlIlIIllIIIIII;
            GuiScreenCustomizePresets.this.updateButtonValidity();
            GuiScreenCustomizePresets.this.export.setText(GuiScreenCustomizePresets.PRESETS.get(GuiScreenCustomizePresets.this.list.selected).settings.toString());
        }
        
        @Override
        protected void func_192637_a(final int llllllllllllllllIlIlIlIIlIIIlllI, final int llllllllllllllllIlIlIlIIlIIlIllI, final int llllllllllllllllIlIlIlIIlIIlIlIl, final int llllllllllllllllIlIlIlIIlIIlIlII, final int llllllllllllllllIlIlIlIIlIIlIIll, final int llllllllllllllllIlIlIlIIlIIlIIlI, final float llllllllllllllllIlIlIlIIlIIlIIIl) {
            final Info llllllllllllllllIlIlIlIIlIIlIIII = GuiScreenCustomizePresets.PRESETS.get(llllllllllllllllIlIlIlIIlIIIlllI);
            this.blitIcon(llllllllllllllllIlIlIlIIlIIlIllI, llllllllllllllllIlIlIlIIlIIlIlIl, llllllllllllllllIlIlIlIIlIIlIIII.texture);
            GuiScreenCustomizePresets.this.fontRendererObj.drawString(llllllllllllllllIlIlIlIIlIIlIIII.name, (float)(llllllllllllllllIlIlIlIIlIIlIllI + 32 + 10), (float)(llllllllllllllllIlIlIlIIlIIlIlIl + 14), 16777215);
        }
    }
}
