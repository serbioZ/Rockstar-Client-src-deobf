// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Biomes;
import net.minecraft.client.resources.I18n;
import com.google.common.primitives.Floats;
import javax.annotation.Nullable;
import net.minecraft.util.math.MathHelper;
import java.io.IOException;
import java.util.Random;
import com.google.common.base.Predicate;
import net.minecraft.world.gen.ChunkGeneratorSettings;

public class GuiCustomizeWorldScreen extends GuiScreen implements GuiPageButtonList.GuiResponder, GuiSlider.FormatHelper
{
    private /* synthetic */ boolean confirmDismissed;
    private /* synthetic */ GuiPageButtonList list;
    private final /* synthetic */ GuiCreateWorld parent;
    private /* synthetic */ GuiButton done;
    private /* synthetic */ GuiButton previousPage;
    protected /* synthetic */ String title;
    private /* synthetic */ GuiButton defaults;
    private /* synthetic */ GuiButton randomize;
    private final /* synthetic */ ChunkGeneratorSettings.Factory defaultSettings;
    protected /* synthetic */ String subtitle;
    private final /* synthetic */ Predicate<String> numberFilter;
    private /* synthetic */ boolean settingsModified;
    protected /* synthetic */ String pageTitle;
    private /* synthetic */ ChunkGeneratorSettings.Factory settings;
    private final /* synthetic */ Random random;
    private /* synthetic */ GuiButton nextPage;
    private /* synthetic */ GuiButton confirm;
    private /* synthetic */ GuiButton cancel;
    private /* synthetic */ int confirmMode;
    private /* synthetic */ GuiButton presets;
    protected /* synthetic */ String[] pageNames;
    
    private void exitConfirmation() throws IOException {
        switch (this.confirmMode) {
            case 300: {
                this.actionPerformed((GuiButton)this.list.getComponent(300));
                break;
            }
            case 304: {
                this.restoreDefaults();
                break;
            }
        }
        this.confirmMode = 0;
        this.confirmDismissed = true;
        this.setConfirmationControls(false);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlIlllIIllIllIIIlllII) throws IOException {
        if (lllllllllllIlIlllIIllIllIIIlllII.enabled) {
            switch (lllllllllllIlIlllIIllIllIIIlllII.id) {
                case 300: {
                    this.parent.chunkProviderSettingsJson = this.settings.toString();
                    this.mc.displayGuiScreen(this.parent);
                    break;
                }
                case 301: {
                    for (int lllllllllllIlIlllIIllIllIIIllIll = 0; lllllllllllIlIlllIIllIllIIIllIll < this.list.getSize(); ++lllllllllllIlIlllIIllIllIIIllIll) {
                        final GuiPageButtonList.GuiEntry lllllllllllIlIlllIIllIllIIIllIlI = this.list.getListEntry(lllllllllllIlIlllIIllIllIIIllIll);
                        final Gui lllllllllllIlIlllIIllIllIIIllIIl = lllllllllllIlIlllIIllIllIIIllIlI.getComponent1();
                        if (lllllllllllIlIlllIIllIllIIIllIIl instanceof GuiButton) {
                            final GuiButton lllllllllllIlIlllIIllIllIIIllIII = (GuiButton)lllllllllllIlIlllIIllIllIIIllIIl;
                            if (lllllllllllIlIlllIIllIllIIIllIII instanceof GuiSlider) {
                                final float lllllllllllIlIlllIIllIllIIIlIlll = ((GuiSlider)lllllllllllIlIlllIIllIllIIIllIII).getSliderPosition() * (0.75f + this.random.nextFloat() * 0.5f) + (this.random.nextFloat() * 0.1f - 0.05f);
                                ((GuiSlider)lllllllllllIlIlllIIllIllIIIllIII).setSliderPosition(MathHelper.clamp(lllllllllllIlIlllIIllIllIIIlIlll, 0.0f, 1.0f));
                            }
                            else if (lllllllllllIlIlllIIllIllIIIllIII instanceof GuiListButton) {
                                ((GuiListButton)lllllllllllIlIlllIIllIllIIIllIII).setValue(this.random.nextBoolean());
                            }
                        }
                        final Gui lllllllllllIlIlllIIllIllIIIlIllI = lllllllllllIlIlllIIllIllIIIllIlI.getComponent2();
                        if (lllllllllllIlIlllIIllIllIIIlIllI instanceof GuiButton) {
                            final GuiButton lllllllllllIlIlllIIllIllIIIlIlIl = (GuiButton)lllllllllllIlIlllIIllIllIIIlIllI;
                            if (lllllllllllIlIlllIIllIllIIIlIlIl instanceof GuiSlider) {
                                final float lllllllllllIlIlllIIllIllIIIlIlII = ((GuiSlider)lllllllllllIlIlllIIllIllIIIlIlIl).getSliderPosition() * (0.75f + this.random.nextFloat() * 0.5f) + (this.random.nextFloat() * 0.1f - 0.05f);
                                ((GuiSlider)lllllllllllIlIlllIIllIllIIIlIlIl).setSliderPosition(MathHelper.clamp(lllllllllllIlIlllIIllIllIIIlIlII, 0.0f, 1.0f));
                            }
                            else if (lllllllllllIlIlllIIllIllIIIlIlIl instanceof GuiListButton) {
                                ((GuiListButton)lllllllllllIlIlllIIllIllIIIlIlIl).setValue(this.random.nextBoolean());
                            }
                        }
                    }
                }
                case 302: {
                    this.list.previousPage();
                    this.updatePageControls();
                    break;
                }
                case 303: {
                    this.list.nextPage();
                    this.updatePageControls();
                    break;
                }
                case 304: {
                    if (this.settingsModified) {
                        this.enterConfirmation(304);
                        break;
                    }
                    break;
                }
                case 305: {
                    this.mc.displayGuiScreen(new GuiScreenCustomizePresets(this));
                    break;
                }
                case 306: {
                    this.exitConfirmation();
                    break;
                }
                case 307: {
                    this.confirmMode = 0;
                    this.exitConfirmation();
                    break;
                }
            }
        }
    }
    
    public GuiCustomizeWorldScreen(final GuiScreen lllllllllllIlIlllIIllIlllIIlIIlI, final String lllllllllllIlIlllIIllIlllIIlIIIl) {
        this.title = "Customize World Settings";
        this.subtitle = "Page 1 of 3";
        this.pageTitle = "Basic Settings";
        this.pageNames = new String[4];
        this.numberFilter = (Predicate<String>)new Predicate<String>() {
            public boolean apply(@Nullable final String lllllllllllIIIlIIIIlIllllllIllII) {
                final Float lllllllllllIIIlIIIIlIllllllIllIl = Floats.tryParse(lllllllllllIIIlIIIIlIllllllIllII);
                return lllllllllllIIIlIIIIlIllllllIllII.isEmpty() || (lllllllllllIIIlIIIIlIllllllIllIl != null && Floats.isFinite((float)lllllllllllIIIlIIIIlIllllllIllIl) && lllllllllllIIIlIIIIlIllllllIllIl >= 0.0f);
            }
        };
        this.defaultSettings = new ChunkGeneratorSettings.Factory();
        this.random = new Random();
        this.parent = (GuiCreateWorld)lllllllllllIlIlllIIllIlllIIlIIlI;
        this.loadValues(lllllllllllIlIlllIIllIlllIIlIIIl);
    }
    
    private void setConfirmationControls(final boolean lllllllllllIlIlllIIllIlIlllllIlI) {
        this.confirm.visible = lllllllllllIlIlllIIllIlIlllllIlI;
        this.cancel.visible = lllllllllllIlIlllIIllIlIlllllIlI;
        this.randomize.enabled = !lllllllllllIlIlllIIllIlIlllllIlI;
        this.done.enabled = !lllllllllllIlIlllIIllIlIlllllIlI;
        this.previousPage.enabled = !lllllllllllIlIlllIIllIlIlllllIlI;
        this.nextPage.enabled = !lllllllllllIlIlllIIllIlIlllllIlI;
        this.defaults.enabled = (this.settingsModified && !lllllllllllIlIlllIIllIlIlllllIlI);
        this.presets.enabled = !lllllllllllIlIlllIIllIlIlllllIlI;
        this.list.setActive(!lllllllllllIlIlllIIllIlIlllllIlI);
    }
    
    @Override
    public void setEntryValue(final int lllllllllllIlIlllIIllIllIIlIllII, final float lllllllllllIlIlllIIllIllIIlIlIll) {
        switch (lllllllllllIlIlllIIllIllIIlIllII) {
            case 100: {
                this.settings.mainNoiseScaleX = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 101: {
                this.settings.mainNoiseScaleY = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 102: {
                this.settings.mainNoiseScaleZ = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 103: {
                this.settings.depthNoiseScaleX = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 104: {
                this.settings.depthNoiseScaleZ = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 105: {
                this.settings.depthNoiseScaleExponent = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 106: {
                this.settings.baseSize = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 107: {
                this.settings.coordinateScale = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 108: {
                this.settings.heightScale = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 109: {
                this.settings.stretchY = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 110: {
                this.settings.upperLimitScale = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 111: {
                this.settings.lowerLimitScale = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 112: {
                this.settings.biomeDepthWeight = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 113: {
                this.settings.biomeDepthOffset = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 114: {
                this.settings.biomeScaleWeight = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 115: {
                this.settings.biomeScaleOffset = lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 157: {
                this.settings.dungeonChance = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 158: {
                this.settings.waterLakeChance = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 159: {
                this.settings.lavaLakeChance = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 160: {
                this.settings.seaLevel = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 162: {
                this.settings.fixedBiome = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 163: {
                this.settings.biomeSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 164: {
                this.settings.riverSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 165: {
                this.settings.dirtSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 166: {
                this.settings.dirtCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 167: {
                this.settings.dirtMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 168: {
                this.settings.dirtMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 169: {
                this.settings.gravelSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 170: {
                this.settings.gravelCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 171: {
                this.settings.gravelMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 172: {
                this.settings.gravelMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 173: {
                this.settings.graniteSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 174: {
                this.settings.graniteCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 175: {
                this.settings.graniteMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 176: {
                this.settings.graniteMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 177: {
                this.settings.dioriteSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 178: {
                this.settings.dioriteCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 179: {
                this.settings.dioriteMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 180: {
                this.settings.dioriteMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 181: {
                this.settings.andesiteSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 182: {
                this.settings.andesiteCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 183: {
                this.settings.andesiteMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 184: {
                this.settings.andesiteMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 185: {
                this.settings.coalSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 186: {
                this.settings.coalCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 187: {
                this.settings.coalMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 189: {
                this.settings.coalMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 190: {
                this.settings.ironSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 191: {
                this.settings.ironCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 192: {
                this.settings.ironMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 193: {
                this.settings.ironMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 194: {
                this.settings.goldSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 195: {
                this.settings.goldCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 196: {
                this.settings.goldMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 197: {
                this.settings.goldMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 198: {
                this.settings.redstoneSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 199: {
                this.settings.redstoneCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 200: {
                this.settings.redstoneMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 201: {
                this.settings.redstoneMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 202: {
                this.settings.diamondSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 203: {
                this.settings.diamondCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 204: {
                this.settings.diamondMinHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 205: {
                this.settings.diamondMaxHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 206: {
                this.settings.lapisSize = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 207: {
                this.settings.lapisCount = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 208: {
                this.settings.lapisCenterHeight = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
            case 209: {
                this.settings.lapisSpread = (int)lllllllllllIlIlllIIllIllIIlIlIll;
                break;
            }
        }
        if (lllllllllllIlIlllIIllIllIIlIllII >= 100 && lllllllllllIlIlllIIllIllIIlIllII < 116) {
            final Gui lllllllllllIlIlllIIllIllIIlIlIlI = this.list.getComponent(lllllllllllIlIlllIIllIllIIlIllII - 100 + 132);
            if (lllllllllllIlIlllIIllIllIIlIlIlI != null) {
                ((GuiTextField)lllllllllllIlIlllIIllIllIIlIlIlI).setText(this.getFormattedValue(lllllllllllIlIlllIIllIllIIlIllII, lllllllllllIlIlllIIllIllIIlIlIll));
            }
        }
        if (!this.settings.equals(this.defaultSettings)) {
            this.setSettingsModified(true);
        }
    }
    
    public String saveValues() {
        return this.settings.toString().replace("\n", "");
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlIlllIIllIlIllIIllII, final int lllllllllllIlIlllIIllIlIllIIllll, final int lllllllllllIlIlllIIllIlIllIIlllI) throws IOException {
        super.mouseClicked(lllllllllllIlIlllIIllIlIllIIllII, lllllllllllIlIlllIIllIlIllIIllll, lllllllllllIlIlllIIllIlIllIIlllI);
        if (this.confirmMode == 0 && !this.confirmDismissed) {
            this.list.mouseClicked(lllllllllllIlIlllIIllIlIllIIllII, lllllllllllIlIlllIIllIlIllIIllll, lllllllllllIlIlllIIllIlIllIIlllI);
        }
    }
    
    private void restoreDefaults() {
        this.settings.setDefaults();
        this.createPagedList();
        this.setSettingsModified(false);
    }
    
    private String getFormattedValue(final int lllllllllllIlIlllIIllIllIIllllIl, final float lllllllllllIlIlllIIllIllIlIIIIII) {
        switch (lllllllllllIlIlllIIllIllIIllllIl) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 107:
            case 108:
            case 110:
            case 111:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 139:
            case 140:
            case 142:
            case 143: {
                return String.format("%5.3f", lllllllllllIlIlllIIllIllIlIIIIII);
            }
            case 105:
            case 106:
            case 109:
            case 112:
            case 113:
            case 114:
            case 115:
            case 137:
            case 138:
            case 141:
            case 144:
            case 145:
            case 146:
            case 147: {
                return String.format("%2.3f", lllllllllllIlIlllIIllIllIlIIIIII);
            }
            default: {
                return String.format("%d", (int)lllllllllllIlIlllIIllIllIlIIIIII);
            }
            case 162: {
                if (lllllllllllIlIlllIIllIllIlIIIIII < 0.0f) {
                    return I18n.format("gui.all", new Object[0]);
                }
                if ((int)lllllllllllIlIlllIIllIllIlIIIIII >= Biome.getIdForBiome(Biomes.HELL)) {
                    final Biome lllllllllllIlIlllIIllIllIIllllll = Biome.getBiomeForId((int)lllllllllllIlIlllIIllIllIlIIIIII + 2);
                    return (lllllllllllIlIlllIIllIllIIllllll != null) ? lllllllllllIlIlllIIllIllIIllllll.getBiomeName() : "?";
                }
                final Biome lllllllllllIlIlllIIllIllIIlllllI = Biome.getBiomeForId((int)lllllllllllIlIlllIIllIllIlIIIIII);
                return (lllllllllllIlIlllIIllIllIIlllllI != null) ? lllllllllllIlIlllIIllIllIIlllllI.getBiomeName() : "?";
            }
        }
    }
    
    @Override
    public void initGui() {
        int lllllllllllIlIlllIIllIlllIIIlIIl = 0;
        int lllllllllllIlIlllIIllIlllIIIlIII = 0;
        if (this.list != null) {
            lllllllllllIlIlllIIllIlllIIIlIIl = this.list.getPage();
            lllllllllllIlIlllIIllIlllIIIlIII = this.list.getAmountScrolled();
        }
        this.title = I18n.format("options.customizeTitle", new Object[0]);
        this.buttonList.clear();
        this.previousPage = this.addButton(new GuiButton(302, 20, 5, 80, 20, I18n.format("createWorld.customize.custom.prev", new Object[0])));
        this.nextPage = this.addButton(new GuiButton(303, this.width - 100, 5, 80, 20, I18n.format("createWorld.customize.custom.next", new Object[0])));
        this.defaults = this.addButton(new GuiButton(304, this.width / 2 - 187, this.height - 27, 90, 20, I18n.format("createWorld.customize.custom.defaults", new Object[0])));
        this.randomize = this.addButton(new GuiButton(301, this.width / 2 - 92, this.height - 27, 90, 20, I18n.format("createWorld.customize.custom.randomize", new Object[0])));
        this.presets = this.addButton(new GuiButton(305, this.width / 2 + 3, this.height - 27, 90, 20, I18n.format("createWorld.customize.custom.presets", new Object[0])));
        this.done = this.addButton(new GuiButton(300, this.width / 2 + 98, this.height - 27, 90, 20, I18n.format("gui.done", new Object[0])));
        this.defaults.enabled = this.settingsModified;
        this.confirm = new GuiButton(306, this.width / 2 - 55, 160, 50, 20, I18n.format("gui.yes", new Object[0]));
        this.confirm.visible = false;
        this.buttonList.add(this.confirm);
        this.cancel = new GuiButton(307, this.width / 2 + 5, 160, 50, 20, I18n.format("gui.no", new Object[0]));
        this.cancel.visible = false;
        this.buttonList.add(this.cancel);
        if (this.confirmMode != 0) {
            this.confirm.visible = true;
            this.cancel.visible = true;
        }
        this.createPagedList();
        if (lllllllllllIlIlllIIllIlllIIIlIIl != 0) {
            this.list.setPage(lllllllllllIlIlllIIllIlllIIIlIIl);
            this.list.scrollBy(lllllllllllIlIlllIIllIlllIIIlIII);
            this.updatePageControls();
        }
    }
    
    private void createPagedList() {
        final GuiPageButtonList.GuiListEntry[] lllllllllllIlIlllIIllIllIllllIlI = { new GuiPageButtonList.GuiSlideEntry(160, I18n.format("createWorld.customize.custom.seaLevel", new Object[0]), true, this, 1.0f, 255.0f, (float)this.settings.seaLevel), new GuiPageButtonList.GuiButtonEntry(148, I18n.format("createWorld.customize.custom.useCaves", new Object[0]), true, this.settings.useCaves), new GuiPageButtonList.GuiButtonEntry(150, I18n.format("createWorld.customize.custom.useStrongholds", new Object[0]), true, this.settings.useStrongholds), new GuiPageButtonList.GuiButtonEntry(151, I18n.format("createWorld.customize.custom.useVillages", new Object[0]), true, this.settings.useVillages), new GuiPageButtonList.GuiButtonEntry(152, I18n.format("createWorld.customize.custom.useMineShafts", new Object[0]), true, this.settings.useMineShafts), new GuiPageButtonList.GuiButtonEntry(153, I18n.format("createWorld.customize.custom.useTemples", new Object[0]), true, this.settings.useTemples), new GuiPageButtonList.GuiButtonEntry(210, I18n.format("createWorld.customize.custom.useMonuments", new Object[0]), true, this.settings.useMonuments), new GuiPageButtonList.GuiButtonEntry(211, I18n.format("createWorld.customize.custom.useMansions", new Object[0]), true, this.settings.field_191076_A), new GuiPageButtonList.GuiButtonEntry(154, I18n.format("createWorld.customize.custom.useRavines", new Object[0]), true, this.settings.useRavines), new GuiPageButtonList.GuiButtonEntry(149, I18n.format("createWorld.customize.custom.useDungeons", new Object[0]), true, this.settings.useDungeons), new GuiPageButtonList.GuiSlideEntry(157, I18n.format("createWorld.customize.custom.dungeonChance", new Object[0]), true, this, 1.0f, 100.0f, (float)this.settings.dungeonChance), new GuiPageButtonList.GuiButtonEntry(155, I18n.format("createWorld.customize.custom.useWaterLakes", new Object[0]), true, this.settings.useWaterLakes), new GuiPageButtonList.GuiSlideEntry(158, I18n.format("createWorld.customize.custom.waterLakeChance", new Object[0]), true, this, 1.0f, 100.0f, (float)this.settings.waterLakeChance), new GuiPageButtonList.GuiButtonEntry(156, I18n.format("createWorld.customize.custom.useLavaLakes", new Object[0]), true, this.settings.useLavaLakes), new GuiPageButtonList.GuiSlideEntry(159, I18n.format("createWorld.customize.custom.lavaLakeChance", new Object[0]), true, this, 10.0f, 100.0f, (float)this.settings.lavaLakeChance), new GuiPageButtonList.GuiButtonEntry(161, I18n.format("createWorld.customize.custom.useLavaOceans", new Object[0]), true, this.settings.useLavaOceans), new GuiPageButtonList.GuiSlideEntry(162, I18n.format("createWorld.customize.custom.fixedBiome", new Object[0]), true, this, -1.0f, 37.0f, (float)this.settings.fixedBiome), new GuiPageButtonList.GuiSlideEntry(163, I18n.format("createWorld.customize.custom.biomeSize", new Object[0]), true, this, 1.0f, 8.0f, (float)this.settings.biomeSize), new GuiPageButtonList.GuiSlideEntry(164, I18n.format("createWorld.customize.custom.riverSize", new Object[0]), true, this, 1.0f, 5.0f, (float)this.settings.riverSize) };
        final GuiPageButtonList.GuiListEntry[] lllllllllllIlIlllIIllIllIllllIIl = { new GuiPageButtonList.GuiLabelEntry(416, I18n.format("tile.dirt.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(165, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.dirtSize), new GuiPageButtonList.GuiSlideEntry(166, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.dirtCount), new GuiPageButtonList.GuiSlideEntry(167, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.dirtMinHeight), new GuiPageButtonList.GuiSlideEntry(168, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.dirtMaxHeight), new GuiPageButtonList.GuiLabelEntry(417, I18n.format("tile.gravel.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(169, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.gravelSize), new GuiPageButtonList.GuiSlideEntry(170, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.gravelCount), new GuiPageButtonList.GuiSlideEntry(171, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.gravelMinHeight), new GuiPageButtonList.GuiSlideEntry(172, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.gravelMaxHeight), new GuiPageButtonList.GuiLabelEntry(418, I18n.format("tile.stone.granite.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(173, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.graniteSize), new GuiPageButtonList.GuiSlideEntry(174, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.graniteCount), new GuiPageButtonList.GuiSlideEntry(175, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.graniteMinHeight), new GuiPageButtonList.GuiSlideEntry(176, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.graniteMaxHeight), new GuiPageButtonList.GuiLabelEntry(419, I18n.format("tile.stone.diorite.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(177, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.dioriteSize), new GuiPageButtonList.GuiSlideEntry(178, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.dioriteCount), new GuiPageButtonList.GuiSlideEntry(179, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.dioriteMinHeight), new GuiPageButtonList.GuiSlideEntry(180, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.dioriteMaxHeight), new GuiPageButtonList.GuiLabelEntry(420, I18n.format("tile.stone.andesite.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(181, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.andesiteSize), new GuiPageButtonList.GuiSlideEntry(182, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.andesiteCount), new GuiPageButtonList.GuiSlideEntry(183, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.andesiteMinHeight), new GuiPageButtonList.GuiSlideEntry(184, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.andesiteMaxHeight), new GuiPageButtonList.GuiLabelEntry(421, I18n.format("tile.oreCoal.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(185, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.coalSize), new GuiPageButtonList.GuiSlideEntry(186, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.coalCount), new GuiPageButtonList.GuiSlideEntry(187, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.coalMinHeight), new GuiPageButtonList.GuiSlideEntry(189, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.coalMaxHeight), new GuiPageButtonList.GuiLabelEntry(422, I18n.format("tile.oreIron.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(190, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.ironSize), new GuiPageButtonList.GuiSlideEntry(191, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.ironCount), new GuiPageButtonList.GuiSlideEntry(192, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.ironMinHeight), new GuiPageButtonList.GuiSlideEntry(193, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.ironMaxHeight), new GuiPageButtonList.GuiLabelEntry(423, I18n.format("tile.oreGold.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(194, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.goldSize), new GuiPageButtonList.GuiSlideEntry(195, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.goldCount), new GuiPageButtonList.GuiSlideEntry(196, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.goldMinHeight), new GuiPageButtonList.GuiSlideEntry(197, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.goldMaxHeight), new GuiPageButtonList.GuiLabelEntry(424, I18n.format("tile.oreRedstone.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(198, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.redstoneSize), new GuiPageButtonList.GuiSlideEntry(199, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.redstoneCount), new GuiPageButtonList.GuiSlideEntry(200, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.redstoneMinHeight), new GuiPageButtonList.GuiSlideEntry(201, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.redstoneMaxHeight), new GuiPageButtonList.GuiLabelEntry(425, I18n.format("tile.oreDiamond.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(202, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.diamondSize), new GuiPageButtonList.GuiSlideEntry(203, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.diamondCount), new GuiPageButtonList.GuiSlideEntry(204, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.diamondMinHeight), new GuiPageButtonList.GuiSlideEntry(205, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.diamondMaxHeight), new GuiPageButtonList.GuiLabelEntry(426, I18n.format("tile.oreLapis.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(206, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.lapisSize), new GuiPageButtonList.GuiSlideEntry(207, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.lapisCount), new GuiPageButtonList.GuiSlideEntry(208, I18n.format("createWorld.customize.custom.center", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.lapisCenterHeight), new GuiPageButtonList.GuiSlideEntry(209, I18n.format("createWorld.customize.custom.spread", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.lapisSpread) };
        final GuiPageButtonList.GuiListEntry[] lllllllllllIlIlllIIllIllIllllIII = { new GuiPageButtonList.GuiSlideEntry(100, I18n.format("createWorld.customize.custom.mainNoiseScaleX", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.mainNoiseScaleX), new GuiPageButtonList.GuiSlideEntry(101, I18n.format("createWorld.customize.custom.mainNoiseScaleY", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.mainNoiseScaleY), new GuiPageButtonList.GuiSlideEntry(102, I18n.format("createWorld.customize.custom.mainNoiseScaleZ", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.mainNoiseScaleZ), new GuiPageButtonList.GuiSlideEntry(103, I18n.format("createWorld.customize.custom.depthNoiseScaleX", new Object[0]), false, this, 1.0f, 2000.0f, this.settings.depthNoiseScaleX), new GuiPageButtonList.GuiSlideEntry(104, I18n.format("createWorld.customize.custom.depthNoiseScaleZ", new Object[0]), false, this, 1.0f, 2000.0f, this.settings.depthNoiseScaleZ), new GuiPageButtonList.GuiSlideEntry(105, I18n.format("createWorld.customize.custom.depthNoiseScaleExponent", new Object[0]), false, this, 0.01f, 20.0f, this.settings.depthNoiseScaleExponent), new GuiPageButtonList.GuiSlideEntry(106, I18n.format("createWorld.customize.custom.baseSize", new Object[0]), false, this, 1.0f, 25.0f, this.settings.baseSize), new GuiPageButtonList.GuiSlideEntry(107, I18n.format("createWorld.customize.custom.coordinateScale", new Object[0]), false, this, 1.0f, 6000.0f, this.settings.coordinateScale), new GuiPageButtonList.GuiSlideEntry(108, I18n.format("createWorld.customize.custom.heightScale", new Object[0]), false, this, 1.0f, 6000.0f, this.settings.heightScale), new GuiPageButtonList.GuiSlideEntry(109, I18n.format("createWorld.customize.custom.stretchY", new Object[0]), false, this, 0.01f, 50.0f, this.settings.stretchY), new GuiPageButtonList.GuiSlideEntry(110, I18n.format("createWorld.customize.custom.upperLimitScale", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.upperLimitScale), new GuiPageButtonList.GuiSlideEntry(111, I18n.format("createWorld.customize.custom.lowerLimitScale", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.lowerLimitScale), new GuiPageButtonList.GuiSlideEntry(112, I18n.format("createWorld.customize.custom.biomeDepthWeight", new Object[0]), false, this, 1.0f, 20.0f, this.settings.biomeDepthWeight), new GuiPageButtonList.GuiSlideEntry(113, I18n.format("createWorld.customize.custom.biomeDepthOffset", new Object[0]), false, this, 0.0f, 20.0f, this.settings.biomeDepthOffset), new GuiPageButtonList.GuiSlideEntry(114, I18n.format("createWorld.customize.custom.biomeScaleWeight", new Object[0]), false, this, 1.0f, 20.0f, this.settings.biomeScaleWeight), new GuiPageButtonList.GuiSlideEntry(115, I18n.format("createWorld.customize.custom.biomeScaleOffset", new Object[0]), false, this, 0.0f, 20.0f, this.settings.biomeScaleOffset) };
        final GuiPageButtonList.GuiListEntry[] lllllllllllIlIlllIIllIllIlllIlll = { new GuiPageButtonList.GuiLabelEntry(400, String.valueOf(I18n.format("createWorld.customize.custom.mainNoiseScaleX", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(132, String.format("%5.3f", this.settings.mainNoiseScaleX), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(401, String.valueOf(I18n.format("createWorld.customize.custom.mainNoiseScaleY", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(133, String.format("%5.3f", this.settings.mainNoiseScaleY), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(402, String.valueOf(I18n.format("createWorld.customize.custom.mainNoiseScaleZ", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(134, String.format("%5.3f", this.settings.mainNoiseScaleZ), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(403, String.valueOf(I18n.format("createWorld.customize.custom.depthNoiseScaleX", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(135, String.format("%5.3f", this.settings.depthNoiseScaleX), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(404, String.valueOf(I18n.format("createWorld.customize.custom.depthNoiseScaleZ", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(136, String.format("%5.3f", this.settings.depthNoiseScaleZ), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(405, String.valueOf(I18n.format("createWorld.customize.custom.depthNoiseScaleExponent", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(137, String.format("%2.3f", this.settings.depthNoiseScaleExponent), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(406, String.valueOf(I18n.format("createWorld.customize.custom.baseSize", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(138, String.format("%2.3f", this.settings.baseSize), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(407, String.valueOf(I18n.format("createWorld.customize.custom.coordinateScale", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(139, String.format("%5.3f", this.settings.coordinateScale), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(408, String.valueOf(I18n.format("createWorld.customize.custom.heightScale", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(140, String.format("%5.3f", this.settings.heightScale), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(409, String.valueOf(I18n.format("createWorld.customize.custom.stretchY", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(141, String.format("%2.3f", this.settings.stretchY), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(410, String.valueOf(I18n.format("createWorld.customize.custom.upperLimitScale", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(142, String.format("%5.3f", this.settings.upperLimitScale), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(411, String.valueOf(I18n.format("createWorld.customize.custom.lowerLimitScale", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(143, String.format("%5.3f", this.settings.lowerLimitScale), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(412, String.valueOf(I18n.format("createWorld.customize.custom.biomeDepthWeight", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(144, String.format("%2.3f", this.settings.biomeDepthWeight), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(413, String.valueOf(I18n.format("createWorld.customize.custom.biomeDepthOffset", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(145, String.format("%2.3f", this.settings.biomeDepthOffset), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(414, String.valueOf(I18n.format("createWorld.customize.custom.biomeScaleWeight", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(146, String.format("%2.3f", this.settings.biomeScaleWeight), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(415, String.valueOf(I18n.format("createWorld.customize.custom.biomeScaleOffset", new Object[0])) + ":", false), new GuiPageButtonList.EditBoxEntry(147, String.format("%2.3f", this.settings.biomeScaleOffset), false, this.numberFilter) };
        this.list = new GuiPageButtonList(this.mc, this.width, this.height, 32, this.height - 32, 25, this, new GuiPageButtonList.GuiListEntry[][] { lllllllllllIlIlllIIllIllIllllIlI, lllllllllllIlIlllIIllIllIllllIIl, lllllllllllIlIlllIIllIllIllllIII, lllllllllllIlIlllIIllIllIlllIlll });
        for (int lllllllllllIlIlllIIllIllIlllIllI = 0; lllllllllllIlIlllIIllIllIlllIllI < 4; ++lllllllllllIlIlllIIllIllIlllIllI) {
            this.pageNames[lllllllllllIlIlllIIllIllIlllIllI] = I18n.format("createWorld.customize.custom.page" + lllllllllllIlIlllIIllIllIlllIllI, new Object[0]);
        }
        this.updatePageControls();
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    @Override
    public String getText(final int lllllllllllIlIlllIIllIllIlIIlIII, final String lllllllllllIlIlllIIllIllIlIIlIll, final float lllllllllllIlIlllIIllIllIlIIIllI) {
        return String.valueOf(lllllllllllIlIlllIIllIllIlIIlIll) + ": " + this.getFormattedValue(lllllllllllIlIlllIIllIllIlIIlIII, lllllllllllIlIlllIIllIllIlIIIllI);
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllIlIlllIIllIlIllIIIlII, final int lllllllllllIlIlllIIllIlIlIllllll, final int lllllllllllIlIlllIIllIlIllIIIIlI) {
        super.mouseReleased(lllllllllllIlIlllIIllIlIllIIIlII, lllllllllllIlIlllIIllIlIlIllllll, lllllllllllIlIlllIIllIlIllIIIIlI);
        if (this.confirmDismissed) {
            this.confirmDismissed = false;
        }
        else if (this.confirmMode == 0) {
            this.list.mouseReleased(lllllllllllIlIlllIIllIlIllIIIlII, lllllllllllIlIlllIIllIlIlIllllll, lllllllllllIlIlllIIllIlIllIIIIlI);
        }
    }
    
    private void modifyFocusValue(final float lllllllllllIlIlllIIllIlIllIlllII) {
        final Gui lllllllllllIlIlllIIllIlIlllIIIll = this.list.getFocusedControl();
        if (lllllllllllIlIlllIIllIlIlllIIIll instanceof GuiTextField) {
            float lllllllllllIlIlllIIllIlIlllIIIlI = lllllllllllIlIlllIIllIlIllIlllII;
            if (GuiScreen.isShiftKeyDown()) {
                lllllllllllIlIlllIIllIlIlllIIIlI = lllllllllllIlIlllIIllIlIllIlllII * 0.1f;
                if (GuiScreen.isCtrlKeyDown()) {
                    lllllllllllIlIlllIIllIlIlllIIIlI *= 0.1f;
                }
            }
            else if (GuiScreen.isCtrlKeyDown()) {
                lllllllllllIlIlllIIllIlIlllIIIlI = lllllllllllIlIlllIIllIlIllIlllII * 10.0f;
                if (GuiScreen.isAltKeyDown()) {
                    lllllllllllIlIlllIIllIlIlllIIIlI *= 10.0f;
                }
            }
            final GuiTextField lllllllllllIlIlllIIllIlIlllIIIIl = (GuiTextField)lllllllllllIlIlllIIllIlIlllIIIll;
            Float lllllllllllIlIlllIIllIlIlllIIIII = Floats.tryParse(lllllllllllIlIlllIIllIlIlllIIIIl.getText());
            if (lllllllllllIlIlllIIllIlIlllIIIII != null) {
                lllllllllllIlIlllIIllIlIlllIIIII += lllllllllllIlIlllIIllIlIlllIIIlI;
                final int lllllllllllIlIlllIIllIlIllIlllll = lllllllllllIlIlllIIllIlIlllIIIIl.getId();
                final String lllllllllllIlIlllIIllIlIllIllllI = this.getFormattedValue(lllllllllllIlIlllIIllIlIlllIIIIl.getId(), lllllllllllIlIlllIIllIlIlllIIIII);
                lllllllllllIlIlllIIllIlIlllIIIIl.setText(lllllllllllIlIlllIIllIlIllIllllI);
                this.setEntryValue(lllllllllllIlIlllIIllIlIllIlllll, lllllllllllIlIlllIIllIlIllIllllI);
            }
        }
    }
    
    private void enterConfirmation(final int lllllllllllIlIlllIIllIllIIIIIIll) {
        this.confirmMode = lllllllllllIlIlllIIllIllIIIIIIll;
        this.setConfirmationControls(true);
    }
    
    public void loadValues(final String lllllllllllIlIlllIIllIllIllIIlll) {
        if (lllllllllllIlIlllIIllIllIllIIlll != null && !lllllllllllIlIlllIIllIllIllIIlll.isEmpty()) {
            this.settings = ChunkGeneratorSettings.Factory.jsonToFactory(lllllllllllIlIlllIIllIllIllIIlll);
        }
        else {
            this.settings = new ChunkGeneratorSettings.Factory();
        }
    }
    
    private void updatePageControls() {
        this.previousPage.enabled = (this.list.getPage() != 0);
        this.nextPage.enabled = (this.list.getPage() != this.list.getPageCount() - 1);
        this.subtitle = I18n.format("book.pageIndicator", this.list.getPage() + 1, this.list.getPageCount());
        this.pageTitle = this.pageNames[this.list.getPage()];
        this.randomize.enabled = (this.list.getPage() != this.list.getPageCount() - 1);
    }
    
    @Override
    public void setEntryValue(final int lllllllllllIlIlllIIllIllIIllIIll, final boolean lllllllllllIlIlllIIllIllIIllIIlI) {
        switch (lllllllllllIlIlllIIllIllIIllIIll) {
            case 148: {
                this.settings.useCaves = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 149: {
                this.settings.useDungeons = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 150: {
                this.settings.useStrongholds = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 151: {
                this.settings.useVillages = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 152: {
                this.settings.useMineShafts = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 153: {
                this.settings.useTemples = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 154: {
                this.settings.useRavines = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 155: {
                this.settings.useWaterLakes = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 156: {
                this.settings.useLavaLakes = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 161: {
                this.settings.useLavaOceans = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 210: {
                this.settings.useMonuments = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
            case 211: {
                this.settings.field_191076_A = lllllllllllIlIlllIIllIllIIllIIlI;
                break;
            }
        }
        if (!this.settings.equals(this.defaultSettings)) {
            this.setSettingsModified(true);
        }
    }
    
    @Override
    public void setEntryValue(final int lllllllllllIlIlllIIllIllIlIllIll, final String lllllllllllIlIlllIIllIllIlIlllll) {
        float lllllllllllIlIlllIIllIllIlIllllI = 0.0f;
        try {
            lllllllllllIlIlllIIllIllIlIllllI = Float.parseFloat(lllllllllllIlIlllIIllIllIlIlllll);
        }
        catch (NumberFormatException ex) {}
        float lllllllllllIlIlllIIllIllIlIlllIl = 0.0f;
        switch (lllllllllllIlIlllIIllIllIlIllIll) {
            case 132: {
                this.settings.mainNoiseScaleX = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 5000.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.mainNoiseScaleX;
                break;
            }
            case 133: {
                this.settings.mainNoiseScaleY = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 5000.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.mainNoiseScaleY;
                break;
            }
            case 134: {
                this.settings.mainNoiseScaleZ = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 5000.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.mainNoiseScaleZ;
                break;
            }
            case 135: {
                this.settings.depthNoiseScaleX = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 2000.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.depthNoiseScaleX;
                break;
            }
            case 136: {
                this.settings.depthNoiseScaleZ = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 2000.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.depthNoiseScaleZ;
                break;
            }
            case 137: {
                this.settings.depthNoiseScaleExponent = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 0.01f, 20.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.depthNoiseScaleExponent;
                break;
            }
            case 138: {
                this.settings.baseSize = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 25.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.baseSize;
                break;
            }
            case 139: {
                this.settings.coordinateScale = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 6000.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.coordinateScale;
                break;
            }
            case 140: {
                this.settings.heightScale = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 6000.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.heightScale;
                break;
            }
            case 141: {
                this.settings.stretchY = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 0.01f, 50.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.stretchY;
                break;
            }
            case 142: {
                this.settings.upperLimitScale = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 5000.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.upperLimitScale;
                break;
            }
            case 143: {
                this.settings.lowerLimitScale = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 5000.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.lowerLimitScale;
                break;
            }
            case 144: {
                this.settings.biomeDepthWeight = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 20.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.biomeDepthWeight;
                break;
            }
            case 145: {
                this.settings.biomeDepthOffset = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 0.0f, 20.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.biomeDepthOffset;
                break;
            }
            case 146: {
                this.settings.biomeScaleWeight = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 1.0f, 20.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.biomeScaleWeight;
                break;
            }
            case 147: {
                this.settings.biomeScaleOffset = MathHelper.clamp(lllllllllllIlIlllIIllIllIlIllllI, 0.0f, 20.0f);
                lllllllllllIlIlllIIllIllIlIlllIl = this.settings.biomeScaleOffset;
                break;
            }
        }
        if (lllllllllllIlIlllIIllIllIlIlllIl != lllllllllllIlIlllIIllIllIlIllllI && lllllllllllIlIlllIIllIllIlIllllI != 0.0f) {
            ((GuiTextField)this.list.getComponent(lllllllllllIlIlllIIllIllIlIllIll)).setText(this.getFormattedValue(lllllllllllIlIlllIIllIllIlIllIll, lllllllllllIlIlllIIllIllIlIlllIl));
        }
        ((GuiSlider)this.list.getComponent(lllllllllllIlIlllIIllIllIlIllIll - 132 + 100)).setSliderValue(lllllllllllIlIlllIIllIllIlIlllIl, false);
        if (!this.settings.equals(this.defaultSettings)) {
            this.setSettingsModified(true);
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIlllIIllIlIlIlIlIlI, final int lllllllllllIlIlllIIllIlIlIlIlIIl, final float lllllllllllIlIlllIIllIlIlIllIIIl) {
        this.drawDefaultBackground();
        this.list.drawScreen(lllllllllllIlIlllIIllIlIlIlIlIlI, lllllllllllIlIlllIIllIlIlIlIlIIl, lllllllllllIlIlllIIllIlIlIllIIIl);
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 2, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.subtitle, this.width / 2, 12, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.pageTitle, this.width / 2, 22, 16777215);
        super.drawScreen(lllllllllllIlIlllIIllIlIlIlIlIlI, lllllllllllIlIlllIIllIlIlIlIlIIl, lllllllllllIlIlllIIllIlIlIllIIIl);
        if (this.confirmMode != 0) {
            Gui.drawRect(0.0, 0.0, this.width, this.height, Integer.MIN_VALUE);
            this.drawHorizontalLine(this.width / 2 - 91, this.width / 2 + 90, 99, -2039584);
            this.drawHorizontalLine(this.width / 2 - 91, this.width / 2 + 90, 185, -6250336);
            this.drawVerticalLine(this.width / 2 - 91, 99, 185, -2039584);
            this.drawVerticalLine(this.width / 2 + 90, 99, 185, -6250336);
            final float lllllllllllIlIlllIIllIlIlIllIIII = 85.0f;
            final float lllllllllllIlIlllIIllIlIlIlIllll = 180.0f;
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            final Tessellator lllllllllllIlIlllIIllIlIlIlIlllI = Tessellator.getInstance();
            final BufferBuilder lllllllllllIlIlllIIllIlIlIlIllIl = lllllllllllIlIlllIIllIlIlIlIlllI.getBuffer();
            this.mc.getTextureManager().bindTexture(GuiCustomizeWorldScreen.OPTIONS_BACKGROUND);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final float lllllllllllIlIlllIIllIlIlIlIllII = 32.0f;
            lllllllllllIlIlllIIllIlIlIlIllIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            lllllllllllIlIlllIIllIlIlIlIllIl.pos(this.width / 2 - 90, 185.0, 0.0).tex(0.0, 2.65625).color(64, 64, 64, 64).endVertex();
            lllllllllllIlIlllIIllIlIlIlIllIl.pos(this.width / 2 + 90, 185.0, 0.0).tex(5.625, 2.65625).color(64, 64, 64, 64).endVertex();
            lllllllllllIlIlllIIllIlIlIlIllIl.pos(this.width / 2 + 90, 100.0, 0.0).tex(5.625, 0.0).color(64, 64, 64, 64).endVertex();
            lllllllllllIlIlllIIllIlIlIlIllIl.pos(this.width / 2 - 90, 100.0, 0.0).tex(0.0, 0.0).color(64, 64, 64, 64).endVertex();
            lllllllllllIlIlllIIllIlIlIlIlllI.draw();
            this.drawCenteredString(this.fontRendererObj, I18n.format("createWorld.customize.custom.confirmTitle", new Object[0]), this.width / 2, 105, 16777215);
            this.drawCenteredString(this.fontRendererObj, I18n.format("createWorld.customize.custom.confirm1", new Object[0]), this.width / 2, 125, 16777215);
            this.drawCenteredString(this.fontRendererObj, I18n.format("createWorld.customize.custom.confirm2", new Object[0]), this.width / 2, 135, 16777215);
            this.confirm.drawButton(this.mc, lllllllllllIlIlllIIllIlIlIlIlIlI, lllllllllllIlIlllIIllIlIlIlIlIIl, lllllllllllIlIlllIIllIlIlIllIIIl);
            this.cancel.drawButton(this.mc, lllllllllllIlIlllIIllIlIlIlIlIlI, lllllllllllIlIlllIIllIlIlIlIlIIl, lllllllllllIlIlllIIllIlIlIllIIIl);
        }
    }
    
    private void setSettingsModified(final boolean lllllllllllIlIlllIIllIllIlIlIIlI) {
        this.settingsModified = lllllllllllIlIlllIIllIllIlIlIIlI;
        this.defaults.enabled = lllllllllllIlIlllIIllIllIlIlIIlI;
    }
    
    @Override
    protected void keyTyped(final char lllllllllllIlIlllIIllIlIllllIIlI, final int lllllllllllIlIlllIIllIlIllllIIIl) throws IOException {
        super.keyTyped(lllllllllllIlIlllIIllIlIllllIIlI, lllllllllllIlIlllIIllIlIllllIIIl);
        if (this.confirmMode == 0) {
            switch (lllllllllllIlIlllIIllIlIllllIIIl) {
                case 200: {
                    this.modifyFocusValue(1.0f);
                    break;
                }
                case 208: {
                    this.modifyFocusValue(-1.0f);
                    break;
                }
                default: {
                    this.list.onKeyPressed(lllllllllllIlIlllIIllIlIllllIIlI, lllllllllllIlIlllIIllIlIllllIIIl);
                    break;
                }
            }
        }
    }
}
