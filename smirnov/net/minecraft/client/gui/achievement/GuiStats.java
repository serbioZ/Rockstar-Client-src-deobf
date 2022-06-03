// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.achievement;

import net.minecraft.entity.EntityList;
import net.minecraft.block.Block;
import java.util.Collections;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import org.lwjgl.input.Mouse;
import net.minecraft.item.ItemStack;
import java.util.List;
import java.util.Comparator;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;
import com.google.common.collect.Lists;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.client.Minecraft;
import java.io.IOException;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.Item;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.IProgressMeter;
import net.minecraft.client.gui.GuiScreen;

public class GuiStats extends GuiScreen implements IProgressMeter
{
    protected /* synthetic */ GuiScreen parentScreen;
    protected /* synthetic */ String screenTitle;
    private /* synthetic */ StatsMobsList mobStats;
    private /* synthetic */ GuiSlot displaySlot;
    private /* synthetic */ StatsBlock blockStats;
    private final /* synthetic */ StatisticsManager stats;
    private /* synthetic */ boolean doesGuiPauseGame;
    private /* synthetic */ StatsGeneral generalStats;
    private /* synthetic */ StatsItem itemStats;
    
    public void func_193029_f() {
        this.buttonList.add(new GuiButton(0, this.width / 2 + 4, this.height - 28, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 160, this.height - 52, 80, 20, I18n.format("stat.generalButton", new Object[0])));
        final GuiButton lllllllllllIlllIllIlllllIlIIIlII = this.addButton(new GuiButton(2, this.width / 2 - 80, this.height - 52, 80, 20, I18n.format("stat.blocksButton", new Object[0])));
        final GuiButton lllllllllllIlllIllIlllllIlIIIIll = this.addButton(new GuiButton(3, this.width / 2, this.height - 52, 80, 20, I18n.format("stat.itemsButton", new Object[0])));
        final GuiButton lllllllllllIlllIllIlllllIlIIIIlI = this.addButton(new GuiButton(4, this.width / 2 + 80, this.height - 52, 80, 20, I18n.format("stat.mobsButton", new Object[0])));
        if (this.blockStats.getSize() == 0) {
            lllllllllllIlllIllIlllllIlIIIlII.enabled = false;
        }
        if (this.itemStats.getSize() == 0) {
            lllllllllllIlllIllIlllllIlIIIIll.enabled = false;
        }
        if (this.mobStats.getSize() == 0) {
            lllllllllllIlllIllIlllllIlIIIIlI.enabled = false;
        }
    }
    
    private void drawStatsScreen(final int lllllllllllIlllIllIlllllIIlIIIII, final int lllllllllllIlllIllIlllllIIIlllll, final Item lllllllllllIlllIllIlllllIIIllllI) {
        this.drawButtonBackground(lllllllllllIlllIllIlllllIIlIIIII + 1, lllllllllllIlllIllIlllllIIIlllll + 1);
        GlStateManager.enableRescaleNormal();
        RenderHelper.enableGUIStandardItemLighting();
        this.itemRender.renderItemIntoGUI(lllllllllllIlllIllIlllllIIIllllI.func_190903_i(), (float)(lllllllllllIlllIllIlllllIIlIIIII + 2), (float)(lllllllllllIlllIllIlllllIIIlllll + 2));
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        if (this.displaySlot != null) {
            this.displaySlot.handleMouseInput();
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlllIllIlllllIIllIIlI, final int lllllllllllIlllIllIlllllIIllIIIl, final float lllllllllllIlllIllIlllllIIllIIII) {
        if (this.doesGuiPauseGame) {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingStats", new Object[0]), this.width / 2, this.height / 2, 16777215);
            this.drawCenteredString(this.fontRendererObj, GuiStats.LOADING_STRINGS[(int)(Minecraft.getSystemTime() / 150L % GuiStats.LOADING_STRINGS.length)], this.width / 2, this.height / 2 + this.fontRendererObj.FONT_HEIGHT * 2, 16777215);
        }
        else {
            this.displaySlot.drawScreen(lllllllllllIlllIllIlllllIIllIIlI, lllllllllllIlllIllIlllllIIllIIIl, lllllllllllIlllIllIlllllIIllIIII);
            this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 20, 16777215);
            super.drawScreen(lllllllllllIlllIllIlllllIIllIIlI, lllllllllllIlllIllIlllllIIllIIIl, lllllllllllIlllIllIlllllIIllIIII);
        }
    }
    
    @Override
    public void initGui() {
        this.screenTitle = I18n.format("gui.stats", new Object[0]);
        this.doesGuiPauseGame = true;
        this.mc.getConnection().sendPacket(new CPacketClientStatus(CPacketClientStatus.State.REQUEST_STATS));
    }
    
    private void drawButtonBackground(final int lllllllllllIlllIllIlllllIIIlIIlI, final int lllllllllllIlllIllIlllllIIIlIlII) {
        this.drawSprite(lllllllllllIlllIllIlllllIIIlIIlI, lllllllllllIlllIllIlllllIIIlIlII, 0, 0);
    }
    
    public GuiStats(final GuiScreen lllllllllllIlllIllIlllllIlIlIlII, final StatisticsManager lllllllllllIlllIllIlllllIlIlIIll) {
        this.screenTitle = "Select world";
        this.doesGuiPauseGame = true;
        this.parentScreen = lllllllllllIlllIllIlllllIlIlIlII;
        this.stats = lllllllllllIlllIllIlllllIlIlIIll;
    }
    
    private void drawSprite(final int lllllllllllIlllIllIlllllIIIIIlII, final int lllllllllllIlllIllIlllllIIIIIIll, final int lllllllllllIlllIllIllllIllllIlll, final int lllllllllllIlllIllIllllIllllIllI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiStats.STAT_ICONS);
        final float lllllllllllIlllIllIlllllIIIIIIII = 0.0078125f;
        final float lllllllllllIlllIllIllllIllllllll = 0.0078125f;
        final int lllllllllllIlllIllIllllIlllllllI = 18;
        final int lllllllllllIlllIllIllllIllllllIl = 18;
        final Tessellator lllllllllllIlllIllIllllIllllllII = Tessellator.getInstance();
        final BufferBuilder lllllllllllIlllIllIllllIlllllIll = lllllllllllIlllIllIllllIllllllII.getBuffer();
        lllllllllllIlllIllIllllIlllllIll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIlllIllIllllIlllllIll.pos(lllllllllllIlllIllIlllllIIIIIlII + 0, lllllllllllIlllIllIlllllIIIIIIll + 18, this.zLevel).tex((lllllllllllIlllIllIllllIllllIlll + 0) * 0.0078125f, (lllllllllllIlllIllIllllIllllIllI + 18) * 0.0078125f).endVertex();
        lllllllllllIlllIllIllllIlllllIll.pos(lllllllllllIlllIllIlllllIIIIIlII + 18, lllllllllllIlllIllIlllllIIIIIIll + 18, this.zLevel).tex((lllllllllllIlllIllIllllIllllIlll + 18) * 0.0078125f, (lllllllllllIlllIllIllllIllllIllI + 18) * 0.0078125f).endVertex();
        lllllllllllIlllIllIllllIlllllIll.pos(lllllllllllIlllIllIlllllIIIIIlII + 18, lllllllllllIlllIllIlllllIIIIIIll + 0, this.zLevel).tex((lllllllllllIlllIllIllllIllllIlll + 18) * 0.0078125f, (lllllllllllIlllIllIllllIllllIllI + 0) * 0.0078125f).endVertex();
        lllllllllllIlllIllIllllIlllllIll.pos(lllllllllllIlllIllIlllllIIIIIlII + 0, lllllllllllIlllIllIlllllIIIIIIll + 0, this.zLevel).tex((lllllllllllIlllIllIllllIllllIlll + 0) * 0.0078125f, (lllllllllllIlllIllIllllIllllIllI + 0) * 0.0078125f).endVertex();
        lllllllllllIlllIllIllllIllllllII.draw();
    }
    
    @Override
    public void func_193026_g() {
        if (this.doesGuiPauseGame) {
            this.func_193028_a();
            this.func_193029_f();
            this.displaySlot = this.generalStats;
            this.doesGuiPauseGame = false;
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return !this.doesGuiPauseGame;
    }
    
    public void func_193028_a() {
        this.generalStats = new StatsGeneral(this.mc);
        this.generalStats.registerScrollButtons(1, 1);
        this.itemStats = new StatsItem(this.mc);
        this.itemStats.registerScrollButtons(1, 1);
        this.blockStats = new StatsBlock(this.mc);
        this.blockStats.registerScrollButtons(1, 1);
        this.mobStats = new StatsMobsList(this.mc);
        this.mobStats.registerScrollButtons(1, 1);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIlllIllIlllllIIlllIlI) throws IOException {
        if (lllllllllllIlllIllIlllllIIlllIlI.enabled) {
            if (lllllllllllIlllIllIlllllIIlllIlI.id == 0) {
                this.mc.displayGuiScreen(this.parentScreen);
            }
            else if (lllllllllllIlllIllIlllllIIlllIlI.id == 1) {
                this.displaySlot = this.generalStats;
            }
            else if (lllllllllllIlllIllIlllllIIlllIlI.id == 3) {
                this.displaySlot = this.itemStats;
            }
            else if (lllllllllllIlllIllIlllllIIlllIlI.id == 2) {
                this.displaySlot = this.blockStats;
            }
            else if (lllllllllllIlllIllIlllllIIlllIlI.id == 4) {
                this.displaySlot = this.mobStats;
            }
            else {
                this.displaySlot.actionPerformed(lllllllllllIlllIllIlllllIIlllIlI);
            }
        }
    }
    
    class StatsItem extends Stats
    {
        public StatsItem(final Minecraft llllllllllllllIIIIIllIIlIlIIIIIl) {
            super(llllllllllllllIIIIIllIIlIlIIIIIl);
            this.statsHolder = (List<StatCrafting>)Lists.newArrayList();
            for (final StatCrafting llllllllllllllIIIIIllIIlIlIIIIII : StatList.USE_ITEM_STATS) {
                boolean llllllllllllllIIIIIllIIlIIllllll = false;
                final Item llllllllllllllIIIIIllIIlIIlllllI = llllllllllllllIIIIIllIIlIlIIIIII.getItem();
                if (GuiStats.this.stats.readStat(llllllllllllllIIIIIllIIlIlIIIIII) > 0) {
                    llllllllllllllIIIIIllIIlIIllllll = true;
                }
                else if (StatList.getObjectBreakStats(llllllllllllllIIIIIllIIlIIlllllI) != null && GuiStats.this.stats.readStat(StatList.getObjectBreakStats(llllllllllllllIIIIIllIIlIIlllllI)) > 0) {
                    llllllllllllllIIIIIllIIlIIllllll = true;
                }
                else if (StatList.getCraftStats(llllllllllllllIIIIIllIIlIIlllllI) != null && GuiStats.this.stats.readStat(StatList.getCraftStats(llllllllllllllIIIIIllIIlIIlllllI)) > 0) {
                    llllllllllllllIIIIIllIIlIIllllll = true;
                }
                else if (StatList.getObjectsPickedUpStats(llllllllllllllIIIIIllIIlIIlllllI) != null && GuiStats.this.stats.readStat(StatList.getObjectsPickedUpStats(llllllllllllllIIIIIllIIlIIlllllI)) > 0) {
                    llllllllllllllIIIIIllIIlIIllllll = true;
                }
                else if (StatList.getDroppedObjectStats(llllllllllllllIIIIIllIIlIIlllllI) != null && GuiStats.this.stats.readStat(StatList.getDroppedObjectStats(llllllllllllllIIIIIllIIlIIlllllI)) > 0) {
                    llllllllllllllIIIIIllIIlIIllllll = true;
                }
                if (llllllllllllllIIIIIllIIlIIllllll) {
                    this.statsHolder.add(llllllllllllllIIIIIllIIlIlIIIIII);
                }
            }
            this.statSorter = new Comparator<StatCrafting>() {
                @Override
                public int compare(final StatCrafting lllllllllllllIIIllIIIlIllIIlIIlI, final StatCrafting lllllllllllllIIIllIIIlIllIIlIIIl) {
                    final Item lllllllllllllIIIllIIIlIllIIllIll = lllllllllllllIIIllIIIlIllIIlIIlI.getItem();
                    final Item lllllllllllllIIIllIIIlIllIIllIlI = lllllllllllllIIIllIIIlIllIIlIIIl.getItem();
                    final int lllllllllllllIIIllIIIlIllIIllIIl = Item.getIdFromItem(lllllllllllllIIIllIIIlIllIIllIll);
                    final int lllllllllllllIIIllIIIlIllIIllIII = Item.getIdFromItem(lllllllllllllIIIllIIIlIllIIllIlI);
                    StatBase lllllllllllllIIIllIIIlIllIIlIlll = null;
                    StatBase lllllllllllllIIIllIIIlIllIIlIllI = null;
                    if (StatsItem.this.sortColumn == 0) {
                        lllllllllllllIIIllIIIlIllIIlIlll = StatList.getObjectBreakStats(lllllllllllllIIIllIIIlIllIIllIll);
                        lllllllllllllIIIllIIIlIllIIlIllI = StatList.getObjectBreakStats(lllllllllllllIIIllIIIlIllIIllIlI);
                    }
                    else if (StatsItem.this.sortColumn == 1) {
                        lllllllllllllIIIllIIIlIllIIlIlll = StatList.getCraftStats(lllllllllllllIIIllIIIlIllIIllIll);
                        lllllllllllllIIIllIIIlIllIIlIllI = StatList.getCraftStats(lllllllllllllIIIllIIIlIllIIllIlI);
                    }
                    else if (StatsItem.this.sortColumn == 2) {
                        lllllllllllllIIIllIIIlIllIIlIlll = StatList.getObjectUseStats(lllllllllllllIIIllIIIlIllIIllIll);
                        lllllllllllllIIIllIIIlIllIIlIllI = StatList.getObjectUseStats(lllllllllllllIIIllIIIlIllIIllIlI);
                    }
                    else if (StatsItem.this.sortColumn == 3) {
                        lllllllllllllIIIllIIIlIllIIlIlll = StatList.getObjectsPickedUpStats(lllllllllllllIIIllIIIlIllIIllIll);
                        lllllllllllllIIIllIIIlIllIIlIllI = StatList.getObjectsPickedUpStats(lllllllllllllIIIllIIIlIllIIllIlI);
                    }
                    else if (StatsItem.this.sortColumn == 4) {
                        lllllllllllllIIIllIIIlIllIIlIlll = StatList.getDroppedObjectStats(lllllllllllllIIIllIIIlIllIIllIll);
                        lllllllllllllIIIllIIIlIllIIlIllI = StatList.getDroppedObjectStats(lllllllllllllIIIllIIIlIllIIllIlI);
                    }
                    if (lllllllllllllIIIllIIIlIllIIlIlll != null || lllllllllllllIIIllIIIlIllIIlIllI != null) {
                        if (lllllllllllllIIIllIIIlIllIIlIlll == null) {
                            return 1;
                        }
                        if (lllllllllllllIIIllIIIlIllIIlIllI == null) {
                            return -1;
                        }
                        final int lllllllllllllIIIllIIIlIllIIlIlIl = GuiStats.this.stats.readStat(lllllllllllllIIIllIIIlIllIIlIlll);
                        final int lllllllllllllIIIllIIIlIllIIlIlII = GuiStats.this.stats.readStat(lllllllllllllIIIllIIIlIllIIlIllI);
                        if (lllllllllllllIIIllIIIlIllIIlIlIl != lllllllllllllIIIllIIIlIllIIlIlII) {
                            return (lllllllllllllIIIllIIIlIllIIlIlIl - lllllllllllllIIIllIIIlIllIIlIlII) * StatsItem.this.sortOrder;
                        }
                    }
                    return lllllllllllllIIIllIIIlIllIIllIIl - lllllllllllllIIIllIIIlIllIIllIII;
                }
            };
        }
        
        @Override
        protected void drawListHeader(final int llllllllllllllIIIIIllIIlIIlIllIl, final int llllllllllllllIIIIIllIIlIIlIllII, final Tessellator llllllllllllllIIIIIllIIlIIlIlIll) {
            super.drawListHeader(llllllllllllllIIIIIllIIlIIlIllIl, llllllllllllllIIIIIllIIlIIlIllII, llllllllllllllIIIIIllIIlIIlIlIll);
            if (this.headerPressed == 0) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 115 - 18 + 1, llllllllllllllIIIIIllIIlIIlIllII + 1 + 1, 72, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 115 - 18, llllllllllllllIIIIIllIIlIIlIllII + 1, 72, 18);
            }
            if (this.headerPressed == 1) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 165 - 18 + 1, llllllllllllllIIIIIllIIlIIlIllII + 1 + 1, 18, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 165 - 18, llllllllllllllIIIIIllIIlIIlIllII + 1, 18, 18);
            }
            if (this.headerPressed == 2) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 215 - 18 + 1, llllllllllllllIIIIIllIIlIIlIllII + 1 + 1, 36, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 215 - 18, llllllllllllllIIIIIllIIlIIlIllII + 1, 36, 18);
            }
            if (this.headerPressed == 3) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 265 - 18 + 1, llllllllllllllIIIIIllIIlIIlIllII + 1 + 1, 90, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 265 - 18, llllllllllllllIIIIIllIIlIIlIllII + 1, 90, 18);
            }
            if (this.headerPressed == 4) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 315 - 18 + 1, llllllllllllllIIIIIllIIlIIlIllII + 1 + 1, 108, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIllIIlIIlIllIl + 315 - 18, llllllllllllllIIIIIllIIlIIlIllII + 1, 108, 18);
            }
        }
        
        @Override
        protected String getHeaderDescriptionId(final int llllllllllllllIIIIIllIIlIIIlIIIl) {
            if (llllllllllllllIIIIIllIIlIIIlIIIl == 1) {
                return "stat.crafted";
            }
            if (llllllllllllllIIIIIllIIlIIIlIIIl == 2) {
                return "stat.used";
            }
            if (llllllllllllllIIIIIllIIlIIIlIIIl == 3) {
                return "stat.pickup";
            }
            return (llllllllllllllIIIIIllIIlIIIlIIIl == 4) ? "stat.dropped" : "stat.depleted";
        }
        
        @Override
        protected void func_192637_a(final int llllllllllllllIIIIIllIIlIIIllIIl, final int llllllllllllllIIIIIllIIlIIlIIIlI, final int llllllllllllllIIIIIllIIlIIlIIIIl, final int llllllllllllllIIIIIllIIlIIlIIIII, final int llllllllllllllIIIIIllIIlIIIlllll, final int llllllllllllllIIIIIllIIlIIIllllI, final float llllllllllllllIIIIIllIIlIIIlllIl) {
            final StatCrafting llllllllllllllIIIIIllIIlIIIlllII = this.getSlotStat(llllllllllllllIIIIIllIIlIIIllIIl);
            final Item llllllllllllllIIIIIllIIlIIIllIll = llllllllllllllIIIIIllIIlIIIlllII.getItem();
            GuiStats.this.drawStatsScreen(llllllllllllllIIIIIllIIlIIlIIIlI + 40, llllllllllllllIIIIIllIIlIIlIIIIl, llllllllllllllIIIIIllIIlIIIllIll);
            this.renderStat(StatList.getObjectBreakStats(llllllllllllllIIIIIllIIlIIIllIll), llllllllllllllIIIIIllIIlIIlIIIlI + 115, llllllllllllllIIIIIllIIlIIlIIIIl, llllllllllllllIIIIIllIIlIIIllIIl % 2 == 0);
            this.renderStat(StatList.getCraftStats(llllllllllllllIIIIIllIIlIIIllIll), llllllllllllllIIIIIllIIlIIlIIIlI + 165, llllllllllllllIIIIIllIIlIIlIIIIl, llllllllllllllIIIIIllIIlIIIllIIl % 2 == 0);
            this.renderStat(llllllllllllllIIIIIllIIlIIIlllII, llllllllllllllIIIIIllIIlIIlIIIlI + 215, llllllllllllllIIIIIllIIlIIlIIIIl, llllllllllllllIIIIIllIIlIIIllIIl % 2 == 0);
            this.renderStat(StatList.getObjectsPickedUpStats(llllllllllllllIIIIIllIIlIIIllIll), llllllllllllllIIIIIllIIlIIlIIIlI + 265, llllllllllllllIIIIIllIIlIIlIIIIl, llllllllllllllIIIIIllIIlIIIllIIl % 2 == 0);
            this.renderStat(StatList.getDroppedObjectStats(llllllllllllllIIIIIllIIlIIIllIll), llllllllllllllIIIIIllIIlIIlIIIlI + 315, llllllllllllllIIIIIllIIlIIlIIIIl, llllllllllllllIIIIIllIIlIIIllIIl % 2 == 0);
        }
    }
    
    abstract class Stats extends GuiSlot
    {
        protected /* synthetic */ Comparator<StatCrafting> statSorter;
        protected /* synthetic */ int headerPressed;
        protected /* synthetic */ List<StatCrafting> statsHolder;
        protected /* synthetic */ int sortOrder;
        protected /* synthetic */ int sortColumn;
        
        protected void renderMouseHoverToolTip(final StatCrafting lllllllllllllIlllIIlllIIIllIlIIl, final int lllllllllllllIlllIIlllIIIllIlIII, final int lllllllllllllIlllIIlllIIIllIIlll) {
            if (lllllllllllllIlllIIlllIIIllIlIIl != null) {
                final Item lllllllllllllIlllIIlllIIIllIIllI = lllllllllllllIlllIIlllIIIllIlIIl.getItem();
                final ItemStack lllllllllllllIlllIIlllIIIllIIlIl = new ItemStack(lllllllllllllIlllIIlllIIIllIIllI);
                final String lllllllllllllIlllIIlllIIIllIIlII = lllllllllllllIlllIIlllIIIllIIlIl.getUnlocalizedName();
                final String lllllllllllllIlllIIlllIIIllIIIll = new StringBuilder().append(I18n.format(String.valueOf(lllllllllllllIlllIIlllIIIllIIlII) + ".name", new Object[0])).toString().trim();
                if (!lllllllllllllIlllIIlllIIIllIIIll.isEmpty()) {
                    final int lllllllllllllIlllIIlllIIIllIIIlI = lllllllllllllIlllIIlllIIIllIlIII + 12;
                    final int lllllllllllllIlllIIlllIIIllIIIIl = lllllllllllllIlllIIlllIIIllIIlll - 12;
                    final int lllllllllllllIlllIIlllIIIllIIIII = GuiStats.this.fontRendererObj.getStringWidth(lllllllllllllIlllIIlllIIIllIIIll);
                    Gui.this.drawGradientRect(lllllllllllllIlllIIlllIIIllIIIlI - 3, lllllllllllllIlllIIlllIIIllIIIIl - 3, lllllllllllllIlllIIlllIIIllIIIlI + lllllllllllllIlllIIlllIIIllIIIII + 3, lllllllllllllIlllIIlllIIIllIIIIl + 8 + 3, -1073741824, -1073741824);
                    GuiStats.this.fontRendererObj.drawStringWithShadow(lllllllllllllIlllIIlllIIIllIIIll, (float)lllllllllllllIlllIIlllIIIllIIIlI, (float)lllllllllllllIlllIIlllIIIllIIIIl, -1);
                }
            }
        }
        
        protected void renderStat(final StatBase lllllllllllllIlllIIlllIIlIIllIlI, final int lllllllllllllIlllIIlllIIlIIllIIl, final int lllllllllllllIlllIIlllIIlIIllIII, final boolean lllllllllllllIlllIIlllIIlIIllllI) {
            if (lllllllllllllIlllIIlllIIlIIllIlI != null) {
                final String lllllllllllllIlllIIlllIIlIIlllIl = lllllllllllllIlllIIlllIIlIIllIlI.format(GuiStats.this.stats.readStat(lllllllllllllIlllIIlllIIlIIllIlI));
                GuiStats.this.drawString(GuiStats.this.fontRendererObj, lllllllllllllIlllIIlllIIlIIlllIl, lllllllllllllIlllIIlllIIlIIllIIl - GuiStats.this.fontRendererObj.getStringWidth(lllllllllllllIlllIIlllIIlIIlllIl), lllllllllllllIlllIIlllIIlIIllIII + 5, lllllllllllllIlllIIlllIIlIIllllI ? 16777215 : 9474192);
            }
            else {
                final String lllllllllllllIlllIIlllIIlIIlllII = "-";
                GuiStats.this.drawString(GuiStats.this.fontRendererObj, "-", lllllllllllllIlllIIlllIIlIIllIIl - GuiStats.this.fontRendererObj.getStringWidth("-"), lllllllllllllIlllIIlllIIlIIllIII + 5, lllllllllllllIlllIIlllIIlIIllllI ? 16777215 : 9474192);
            }
        }
        
        @Override
        protected void renderDecorations(final int lllllllllllllIlllIIlllIIIlllllIl, final int lllllllllllllIlllIIlllIIIlllllII) {
            if (lllllllllllllIlllIIlllIIIlllllII >= this.top && lllllllllllllIlllIIlllIIIlllllII <= this.bottom) {
                final int lllllllllllllIlllIIlllIIlIIIlIIl = this.getSlotIndexFromScreenCoords(lllllllllllllIlllIIlllIIIlllllIl, lllllllllllllIlllIIlllIIIlllllII);
                final int lllllllllllllIlllIIlllIIlIIIlIII = (this.width - this.getListWidth()) / 2;
                if (lllllllllllllIlllIIlllIIlIIIlIIl >= 0) {
                    if (lllllllllllllIlllIIlllIIIlllllIl < lllllllllllllIlllIIlllIIlIIIlIII + 40 || lllllllllllllIlllIIlllIIIlllllIl > lllllllllllllIlllIIlllIIlIIIlIII + 40 + 20) {
                        return;
                    }
                    final StatCrafting lllllllllllllIlllIIlllIIlIIIIlll = this.getSlotStat(lllllllllllllIlllIIlllIIlIIIlIIl);
                    this.renderMouseHoverToolTip(lllllllllllllIlllIIlllIIlIIIIlll, lllllllllllllIlllIIlllIIIlllllIl, lllllllllllllIlllIIlllIIIlllllII);
                }
                else {
                    String lllllllllllllIlllIIlllIIlIIIIIlI = null;
                    if (lllllllllllllIlllIIlllIIIlllllIl >= lllllllllllllIlllIIlllIIlIIIlIII + 115 - 18 && lllllllllllllIlllIIlllIIIlllllIl <= lllllllllllllIlllIIlllIIlIIIlIII + 115) {
                        final String lllllllllllllIlllIIlllIIlIIIIllI = this.getHeaderDescriptionId(0);
                    }
                    else if (lllllllllllllIlllIIlllIIIlllllIl >= lllllllllllllIlllIIlllIIlIIIlIII + 165 - 18 && lllllllllllllIlllIIlllIIIlllllIl <= lllllllllllllIlllIIlllIIlIIIlIII + 165) {
                        final String lllllllllllllIlllIIlllIIlIIIIlIl = this.getHeaderDescriptionId(1);
                    }
                    else if (lllllllllllllIlllIIlllIIIlllllIl >= lllllllllllllIlllIIlllIIlIIIlIII + 215 - 18 && lllllllllllllIlllIIlllIIIlllllIl <= lllllllllllllIlllIIlllIIlIIIlIII + 215) {
                        final String lllllllllllllIlllIIlllIIlIIIIlII = this.getHeaderDescriptionId(2);
                    }
                    else if (lllllllllllllIlllIIlllIIIlllllIl >= lllllllllllllIlllIIlllIIlIIIlIII + 265 - 18 && lllllllllllllIlllIIlllIIIlllllIl <= lllllllllllllIlllIIlllIIlIIIlIII + 265) {
                        final String lllllllllllllIlllIIlllIIlIIIIIll = this.getHeaderDescriptionId(3);
                    }
                    else {
                        if (lllllllllllllIlllIIlllIIIlllllIl < lllllllllllllIlllIIlllIIlIIIlIII + 315 - 18 || lllllllllllllIlllIIlllIIIlllllIl > lllllllllllllIlllIIlllIIlIIIlIII + 315) {
                            return;
                        }
                        lllllllllllllIlllIIlllIIlIIIIIlI = this.getHeaderDescriptionId(4);
                    }
                    lllllllllllllIlllIIlllIIlIIIIIlI = new StringBuilder().append(I18n.format(lllllllllllllIlllIIlllIIlIIIIIlI, new Object[0])).toString().trim();
                    if (!lllllllllllllIlllIIlllIIlIIIIIlI.isEmpty()) {
                        final int lllllllllllllIlllIIlllIIlIIIIIIl = lllllllllllllIlllIIlllIIIlllllIl + 12;
                        final int lllllllllllllIlllIIlllIIlIIIIIII = lllllllllllllIlllIIlllIIIlllllII - 12;
                        final int lllllllllllllIlllIIlllIIIlllllll = GuiStats.this.fontRendererObj.getStringWidth(lllllllllllllIlllIIlllIIlIIIIIlI);
                        Gui.this.drawGradientRect(lllllllllllllIlllIIlllIIlIIIIIIl - 3, lllllllllllllIlllIIlllIIlIIIIIII - 3, lllllllllllllIlllIIlllIIlIIIIIIl + lllllllllllllIlllIIlllIIIlllllll + 3, lllllllllllllIlllIIlllIIlIIIIIII + 8 + 3, -1073741824, -1073741824);
                        GuiStats.this.fontRendererObj.drawStringWithShadow(lllllllllllllIlllIIlllIIlIIIIIlI, (float)lllllllllllllIlllIIlllIIlIIIIIIl, (float)lllllllllllllIlllIIlllIIlIIIIIII, -1);
                    }
                }
            }
        }
        
        @Override
        protected void drawListHeader(final int lllllllllllllIlllIIlllIIllIIIIlI, final int lllllllllllllIlllIIlllIIlIlllIll, final Tessellator lllllllllllllIlllIIlllIIllIIIIII) {
            if (!Mouse.isButtonDown(0)) {
                this.headerPressed = -1;
            }
            if (this.headerPressed == 0) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 115 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 115 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 18);
            }
            if (this.headerPressed == 1) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 165 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 165 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 18);
            }
            if (this.headerPressed == 2) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 215 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 215 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 18);
            }
            if (this.headerPressed == 3) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 265 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 265 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 18);
            }
            if (this.headerPressed == 4) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 315 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + 315 - 18, lllllllllllllIlllIIlllIIlIlllIll + 1, 0, 18);
            }
            if (this.sortColumn != -1) {
                int lllllllllllllIlllIIlllIIlIllllll = 79;
                int lllllllllllllIlllIIlllIIlIlllllI = 18;
                if (this.sortColumn == 1) {
                    lllllllllllllIlllIIlllIIlIllllll = 129;
                }
                else if (this.sortColumn == 2) {
                    lllllllllllllIlllIIlllIIlIllllll = 179;
                }
                else if (this.sortColumn == 3) {
                    lllllllllllllIlllIIlllIIlIllllll = 229;
                }
                else if (this.sortColumn == 4) {
                    lllllllllllllIlllIIlllIIlIllllll = 279;
                }
                if (this.sortOrder == 1) {
                    lllllllllllllIlllIIlllIIlIlllllI = 36;
                }
                GuiStats.this.drawSprite(lllllllllllllIlllIIlllIIllIIIIlI + lllllllllllllIlllIIlllIIlIllllll, lllllllllllllIlllIIlllIIlIlllIll + 1, lllllllllllllIlllIIlllIIlIlllllI, 0);
            }
        }
        
        @Override
        protected boolean isSelected(final int lllllllllllllIlllIIlllIIllIlIIII) {
            return false;
        }
        
        @Override
        protected void clickedHeader(final int lllllllllllllIlllIIlllIIlIllIlIl, final int lllllllllllllIlllIIlllIIlIllIlII) {
            this.headerPressed = -1;
            if (lllllllllllllIlllIIlllIIlIllIlIl >= 79 && lllllllllllllIlllIIlllIIlIllIlIl < 115) {
                this.headerPressed = 0;
            }
            else if (lllllllllllllIlllIIlllIIlIllIlIl >= 129 && lllllllllllllIlllIIlllIIlIllIlIl < 165) {
                this.headerPressed = 1;
            }
            else if (lllllllllllllIlllIIlllIIlIllIlIl >= 179 && lllllllllllllIlllIIlllIIlIllIlIl < 215) {
                this.headerPressed = 2;
            }
            else if (lllllllllllllIlllIIlllIIlIllIlIl >= 229 && lllllllllllllIlllIIlllIIlIllIlIl < 265) {
                this.headerPressed = 3;
            }
            else if (lllllllllllllIlllIIlllIIlIllIlIl >= 279 && lllllllllllllIlllIIlllIIlIllIlIl < 315) {
                this.headerPressed = 4;
            }
            if (this.headerPressed >= 0) {
                this.sortByColumn(this.headerPressed);
                this.mc.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            }
        }
        
        protected void sortByColumn(final int lllllllllllllIlllIIlllIIIlIIllll) {
            if (lllllllllllllIlllIIlllIIIlIIllll != this.sortColumn) {
                this.sortColumn = lllllllllllllIlllIIlllIIIlIIllll;
                this.sortOrder = -1;
            }
            else if (this.sortOrder == -1) {
                this.sortOrder = 1;
            }
            else {
                this.sortColumn = -1;
                this.sortOrder = 0;
            }
            Collections.sort(this.statsHolder, this.statSorter);
        }
        
        @Override
        protected void elementClicked(final int lllllllllllllIlllIIlllIIllIlIlIl, final boolean lllllllllllllIlllIIlllIIllIlIlII, final int lllllllllllllIlllIIlllIIllIlIIll, final int lllllllllllllIlllIIlllIIllIlIIlI) {
        }
        
        @Override
        public int getListWidth() {
            return 375;
        }
        
        @Override
        protected void drawBackground() {
            GuiStats.this.drawDefaultBackground();
        }
        
        protected Stats(final Minecraft lllllllllllllIlllIIlllIIllIllIlI) {
            super(lllllllllllllIlllIIlllIIllIllIlI, GuiStats.this.width, GuiStats.this.height, 32, GuiStats.this.height - 64, 20);
            this.headerPressed = -1;
            this.sortColumn = -1;
            this.func_193651_b(false);
            this.setHasListHeader(true, 20);
        }
        
        @Override
        protected final int getSize() {
            return this.statsHolder.size();
        }
        
        protected final StatCrafting getSlotStat(final int lllllllllllllIlllIIlllIIlIlIlIll) {
            return this.statsHolder.get(lllllllllllllIlllIIlllIIlIlIlIll);
        }
        
        @Override
        protected int getScrollBarX() {
            return this.width / 2 + 140;
        }
        
        protected abstract String getHeaderDescriptionId(final int p0);
    }
    
    class StatsBlock extends Stats
    {
        @Override
        protected void func_192637_a(final int llllllllllllIIllIllllIIllIllIIIl, final int llllllllllllIIllIllllIIllIlIIllI, final int llllllllllllIIllIllllIIllIlIllll, final int llllllllllllIIllIllllIIllIlIlllI, final int llllllllllllIIllIllllIIllIlIllIl, final int llllllllllllIIllIllllIIllIlIllII, final float llllllllllllIIllIllllIIllIlIlIll) {
            final StatCrafting llllllllllllIIllIllllIIllIlIlIlI = this.getSlotStat(llllllllllllIIllIllllIIllIllIIIl);
            final Item llllllllllllIIllIllllIIllIlIlIIl = llllllllllllIIllIllllIIllIlIlIlI.getItem();
            GuiStats.this.drawStatsScreen(llllllllllllIIllIllllIIllIlIIllI + 40, llllllllllllIIllIllllIIllIlIllll, llllllllllllIIllIllllIIllIlIlIIl);
            this.renderStat(StatList.getCraftStats(llllllllllllIIllIllllIIllIlIlIIl), llllllllllllIIllIllllIIllIlIIllI + 115, llllllllllllIIllIllllIIllIlIllll, llllllllllllIIllIllllIIllIllIIIl % 2 == 0);
            this.renderStat(StatList.getObjectUseStats(llllllllllllIIllIllllIIllIlIlIIl), llllllllllllIIllIllllIIllIlIIllI + 165, llllllllllllIIllIllllIIllIlIllll, llllllllllllIIllIllllIIllIllIIIl % 2 == 0);
            this.renderStat(llllllllllllIIllIllllIIllIlIlIlI, llllllllllllIIllIllllIIllIlIIllI + 215, llllllllllllIIllIllllIIllIlIllll, llllllllllllIIllIllllIIllIllIIIl % 2 == 0);
            this.renderStat(StatList.getObjectsPickedUpStats(llllllllllllIIllIllllIIllIlIlIIl), llllllllllllIIllIllllIIllIlIIllI + 265, llllllllllllIIllIllllIIllIlIllll, llllllllllllIIllIllllIIllIllIIIl % 2 == 0);
            this.renderStat(StatList.getDroppedObjectStats(llllllllllllIIllIllllIIllIlIlIIl), llllllllllllIIllIllllIIllIlIIllI + 315, llllllllllllIIllIllllIIllIlIllll, llllllllllllIIllIllllIIllIllIIIl % 2 == 0);
        }
        
        @Override
        protected void drawListHeader(final int llllllllllllIIllIllllIIllIllllll, final int llllllllllllIIllIllllIIllIlllllI, final Tessellator llllllllllllIIllIllllIIllIllllIl) {
            super.drawListHeader(llllllllllllIIllIllllIIllIllllll, llllllllllllIIllIllllIIllIlllllI, llllllllllllIIllIllllIIllIllllIl);
            if (this.headerPressed == 0) {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 115 - 18 + 1, llllllllllllIIllIllllIIllIlllllI + 1 + 1, 18, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 115 - 18, llllllllllllIIllIllllIIllIlllllI + 1, 18, 18);
            }
            if (this.headerPressed == 1) {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 165 - 18 + 1, llllllllllllIIllIllllIIllIlllllI + 1 + 1, 36, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 165 - 18, llllllllllllIIllIllllIIllIlllllI + 1, 36, 18);
            }
            if (this.headerPressed == 2) {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 215 - 18 + 1, llllllllllllIIllIllllIIllIlllllI + 1 + 1, 54, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 215 - 18, llllllllllllIIllIllllIIllIlllllI + 1, 54, 18);
            }
            if (this.headerPressed == 3) {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 265 - 18 + 1, llllllllllllIIllIllllIIllIlllllI + 1 + 1, 90, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 265 - 18, llllllllllllIIllIllllIIllIlllllI + 1, 90, 18);
            }
            if (this.headerPressed == 4) {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 315 - 18 + 1, llllllllllllIIllIllllIIllIlllllI + 1 + 1, 108, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllIIllIllllIIllIllllll + 315 - 18, llllllllllllIIllIllllIIllIlllllI + 1, 108, 18);
            }
        }
        
        public StatsBlock(final Minecraft llllllllllllIIllIllllIIlllIIlIIl) {
            super(llllllllllllIIllIllllIIlllIIlIIl);
            this.statsHolder = (List<StatCrafting>)Lists.newArrayList();
            for (final StatCrafting llllllllllllIIllIllllIIlllIIlllI : StatList.MINE_BLOCK_STATS) {
                boolean llllllllllllIIllIllllIIlllIIllIl = false;
                final Item llllllllllllIIllIllllIIlllIIllII = llllllllllllIIllIllllIIlllIIlllI.getItem();
                if (GuiStats.this.stats.readStat(llllllllllllIIllIllllIIlllIIlllI) > 0) {
                    llllllllllllIIllIllllIIlllIIllIl = true;
                }
                else if (StatList.getObjectUseStats(llllllllllllIIllIllllIIlllIIllII) != null && GuiStats.this.stats.readStat(StatList.getObjectUseStats(llllllllllllIIllIllllIIlllIIllII)) > 0) {
                    llllllllllllIIllIllllIIlllIIllIl = true;
                }
                else if (StatList.getCraftStats(llllllllllllIIllIllllIIlllIIllII) != null && GuiStats.this.stats.readStat(StatList.getCraftStats(llllllllllllIIllIllllIIlllIIllII)) > 0) {
                    llllllllllllIIllIllllIIlllIIllIl = true;
                }
                else if (StatList.getObjectsPickedUpStats(llllllllllllIIllIllllIIlllIIllII) != null && GuiStats.this.stats.readStat(StatList.getObjectsPickedUpStats(llllllllllllIIllIllllIIlllIIllII)) > 0) {
                    llllllllllllIIllIllllIIlllIIllIl = true;
                }
                else if (StatList.getDroppedObjectStats(llllllllllllIIllIllllIIlllIIllII) != null && GuiStats.this.stats.readStat(StatList.getDroppedObjectStats(llllllllllllIIllIllllIIlllIIllII)) > 0) {
                    llllllllllllIIllIllllIIlllIIllIl = true;
                }
                if (llllllllllllIIllIllllIIlllIIllIl) {
                    this.statsHolder.add(llllllllllllIIllIllllIIlllIIlllI);
                }
            }
            this.statSorter = new Comparator<StatCrafting>() {
                @Override
                public int compare(final StatCrafting lllllllllllIIIIIIlIlIllIlllIllIl, final StatCrafting lllllllllllIIIIIIlIlIllIlllIllII) {
                    final Item lllllllllllIIIIIIlIlIllIlllIlIll = lllllllllllIIIIIIlIlIllIlllIllIl.getItem();
                    final Item lllllllllllIIIIIIlIlIllIlllIlIlI = lllllllllllIIIIIIlIlIllIlllIllII.getItem();
                    StatBase lllllllllllIIIIIIlIlIllIlllIlIIl = null;
                    StatBase lllllllllllIIIIIIlIlIllIlllIlIII = null;
                    if (StatsBlock.this.sortColumn == 2) {
                        lllllllllllIIIIIIlIlIllIlllIlIIl = StatList.getBlockStats(Block.getBlockFromItem(lllllllllllIIIIIIlIlIllIlllIlIll));
                        lllllllllllIIIIIIlIlIllIlllIlIII = StatList.getBlockStats(Block.getBlockFromItem(lllllllllllIIIIIIlIlIllIlllIlIlI));
                    }
                    else if (StatsBlock.this.sortColumn == 0) {
                        lllllllllllIIIIIIlIlIllIlllIlIIl = StatList.getCraftStats(lllllllllllIIIIIIlIlIllIlllIlIll);
                        lllllllllllIIIIIIlIlIllIlllIlIII = StatList.getCraftStats(lllllllllllIIIIIIlIlIllIlllIlIlI);
                    }
                    else if (StatsBlock.this.sortColumn == 1) {
                        lllllllllllIIIIIIlIlIllIlllIlIIl = StatList.getObjectUseStats(lllllllllllIIIIIIlIlIllIlllIlIll);
                        lllllllllllIIIIIIlIlIllIlllIlIII = StatList.getObjectUseStats(lllllllllllIIIIIIlIlIllIlllIlIlI);
                    }
                    else if (StatsBlock.this.sortColumn == 3) {
                        lllllllllllIIIIIIlIlIllIlllIlIIl = StatList.getObjectsPickedUpStats(lllllllllllIIIIIIlIlIllIlllIlIll);
                        lllllllllllIIIIIIlIlIllIlllIlIII = StatList.getObjectsPickedUpStats(lllllllllllIIIIIIlIlIllIlllIlIlI);
                    }
                    else if (StatsBlock.this.sortColumn == 4) {
                        lllllllllllIIIIIIlIlIllIlllIlIIl = StatList.getDroppedObjectStats(lllllllllllIIIIIIlIlIllIlllIlIll);
                        lllllllllllIIIIIIlIlIllIlllIlIII = StatList.getDroppedObjectStats(lllllllllllIIIIIIlIlIllIlllIlIlI);
                    }
                    if (lllllllllllIIIIIIlIlIllIlllIlIIl != null || lllllllllllIIIIIIlIlIllIlllIlIII != null) {
                        if (lllllllllllIIIIIIlIlIllIlllIlIIl == null) {
                            return 1;
                        }
                        if (lllllllllllIIIIIIlIlIllIlllIlIII == null) {
                            return -1;
                        }
                        final int lllllllllllIIIIIIlIlIllIlllIIlll = GuiStats.this.stats.readStat(lllllllllllIIIIIIlIlIllIlllIlIIl);
                        final int lllllllllllIIIIIIlIlIllIlllIIllI = GuiStats.this.stats.readStat(lllllllllllIIIIIIlIlIllIlllIlIII);
                        if (lllllllllllIIIIIIlIlIllIlllIIlll != lllllllllllIIIIIIlIlIllIlllIIllI) {
                            return (lllllllllllIIIIIIlIlIllIlllIIlll - lllllllllllIIIIIIlIlIllIlllIIllI) * StatsBlock.this.sortOrder;
                        }
                    }
                    return Item.getIdFromItem(lllllllllllIIIIIIlIlIllIlllIlIll) - Item.getIdFromItem(lllllllllllIIIIIIlIlIllIlllIlIlI);
                }
            };
        }
        
        @Override
        protected String getHeaderDescriptionId(final int llllllllllllIIllIllllIIllIlIIIII) {
            if (llllllllllllIIllIllllIIllIlIIIII == 0) {
                return "stat.crafted";
            }
            if (llllllllllllIIllIllllIIllIlIIIII == 1) {
                return "stat.used";
            }
            if (llllllllllllIIllIllllIIllIlIIIII == 3) {
                return "stat.pickup";
            }
            return (llllllllllllIIllIllllIIllIlIIIII == 4) ? "stat.dropped" : "stat.mined";
        }
    }
    
    class StatsGeneral extends GuiSlot
    {
        @Override
        protected void elementClicked(final int lllllllllllIIIIIIIIlllIlIIIllIlI, final boolean lllllllllllIIIIIIIIlllIlIIIllIIl, final int lllllllllllIIIIIIIIlllIlIIIllIII, final int lllllllllllIIIIIIIIlllIlIIIlIlll) {
        }
        
        @Override
        protected void func_192637_a(final int lllllllllllIIIIIIIIlllIlIIIIIlll, final int lllllllllllIIIIIIIIlllIlIIIIIllI, final int lllllllllllIIIIIIIIlllIlIIIIIlIl, final int lllllllllllIIIIIIIIlllIlIIIIIlII, final int lllllllllllIIIIIIIIlllIlIIIIIIll, final int lllllllllllIIIIIIIIlllIlIIIIIIlI, final float lllllllllllIIIIIIIIlllIlIIIIIIIl) {
            final StatBase lllllllllllIIIIIIIIlllIlIIIIIIII = StatList.BASIC_STATS.get(lllllllllllIIIIIIIIlllIlIIIIIlll);
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, lllllllllllIIIIIIIIlllIlIIIIIIII.getStatName().getUnformattedText(), lllllllllllIIIIIIIIlllIlIIIIIllI + 2, lllllllllllIIIIIIIIlllIlIIIIIlIl + 1, (lllllllllllIIIIIIIIlllIlIIIIIlll % 2 == 0) ? 16777215 : 9474192);
            final String lllllllllllIIIIIIIIlllIIllllllll = lllllllllllIIIIIIIIlllIlIIIIIIII.format(GuiStats.this.stats.readStat(lllllllllllIIIIIIIIlllIlIIIIIIII));
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, lllllllllllIIIIIIIIlllIIllllllll, lllllllllllIIIIIIIIlllIlIIIIIllI + 2 + 213 - GuiStats.this.fontRendererObj.getStringWidth(lllllllllllIIIIIIIIlllIIllllllll), lllllllllllIIIIIIIIlllIlIIIIIlIl + 1, (lllllllllllIIIIIIIIlllIlIIIIIlll % 2 == 0) ? 16777215 : 9474192);
        }
        
        @Override
        protected int getSize() {
            return StatList.BASIC_STATS.size();
        }
        
        public StatsGeneral(final Minecraft lllllllllllIIIIIIIIlllIlIIIlllIl) {
            super(lllllllllllIIIIIIIIlllIlIIIlllIl, GuiStats.this.width, GuiStats.this.height, 32, GuiStats.this.height - 64, 10);
            this.func_193651_b(false);
        }
        
        @Override
        protected boolean isSelected(final int lllllllllllIIIIIIIIlllIlIIIlIlIl) {
            return false;
        }
        
        @Override
        protected void drawBackground() {
            GuiStats.this.drawDefaultBackground();
        }
        
        @Override
        protected int getContentHeight() {
            return this.getSize() * 10;
        }
    }
    
    class StatsMobsList extends GuiSlot
    {
        private final /* synthetic */ List<EntityList.EntityEggInfo> mobs;
        
        public StatsMobsList(final Minecraft llllllllllllllIIIlIlIIIllIlllIlI) {
            super(llllllllllllllIIIlIlIIIllIlllIlI, GuiStats.this.width, GuiStats.this.height, 32, GuiStats.this.height - 64, GuiStats.this.fontRendererObj.FONT_HEIGHT * 4);
            this.mobs = (List<EntityList.EntityEggInfo>)Lists.newArrayList();
            this.func_193651_b(false);
            for (final EntityList.EntityEggInfo llllllllllllllIIIlIlIIIllIllllIl : EntityList.ENTITY_EGGS.values()) {
                if (GuiStats.this.stats.readStat(llllllllllllllIIIlIlIIIllIllllIl.killEntityStat) > 0 || GuiStats.this.stats.readStat(llllllllllllllIIIlIlIIIllIllllIl.entityKilledByStat) > 0) {
                    this.mobs.add(llllllllllllllIIIlIlIIIllIllllIl);
                }
            }
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllIIIlIlIIIllIllIIll, final boolean llllllllllllllIIIlIlIIIllIllIIlI, final int llllllllllllllIIIlIlIIIllIllIIIl, final int llllllllllllllIIIlIlIIIllIllIIII) {
        }
        
        @Override
        protected int getSize() {
            return this.mobs.size();
        }
        
        @Override
        protected int getContentHeight() {
            return this.getSize() * GuiStats.this.fontRendererObj.FONT_HEIGHT * 4;
        }
        
        @Override
        protected void drawBackground() {
            GuiStats.this.drawDefaultBackground();
        }
        
        @Override
        protected boolean isSelected(final int llllllllllllllIIIlIlIIIllIlIlllI) {
            return false;
        }
        
        @Override
        protected void func_192637_a(final int llllllllllllllIIIlIlIIIllIIlllII, final int llllllllllllllIIIlIlIIIllIIllIll, final int llllllllllllllIIIlIlIIIllIIIllII, final int llllllllllllllIIIlIlIIIllIIllIIl, final int llllllllllllllIIIlIlIIIllIIllIII, final int llllllllllllllIIIlIlIIIllIIlIlll, final float llllllllllllllIIIlIlIIIllIIlIllI) {
            final EntityList.EntityEggInfo llllllllllllllIIIlIlIIIllIIlIlIl = this.mobs.get(llllllllllllllIIIlIlIIIllIIlllII);
            final String llllllllllllllIIIlIlIIIllIIlIlII = I18n.format("entity." + EntityList.func_191302_a(llllllllllllllIIIlIlIIIllIIlIlIl.spawnedID) + ".name", new Object[0]);
            final int llllllllllllllIIIlIlIIIllIIlIIll = GuiStats.this.stats.readStat(llllllllllllllIIIlIlIIIllIIlIlIl.killEntityStat);
            final int llllllllllllllIIIlIlIIIllIIlIIlI = GuiStats.this.stats.readStat(llllllllllllllIIIlIlIIIllIIlIlIl.entityKilledByStat);
            String llllllllllllllIIIlIlIIIllIIlIIIl = I18n.format("stat.entityKills", llllllllllllllIIIlIlIIIllIIlIIll, llllllllllllllIIIlIlIIIllIIlIlII);
            String llllllllllllllIIIlIlIIIllIIlIIII = I18n.format("stat.entityKilledBy", llllllllllllllIIIlIlIIIllIIlIlII, llllllllllllllIIIlIlIIIllIIlIIlI);
            if (llllllllllllllIIIlIlIIIllIIlIIll == 0) {
                llllllllllllllIIIlIlIIIllIIlIIIl = I18n.format("stat.entityKills.none", llllllllllllllIIIlIlIIIllIIlIlII);
            }
            if (llllllllllllllIIIlIlIIIllIIlIIlI == 0) {
                llllllllllllllIIIlIlIIIllIIlIIII = I18n.format("stat.entityKilledBy.none", llllllllllllllIIIlIlIIIllIIlIlII);
            }
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllIIIlIlIIIllIIlIlII, llllllllllllllIIIlIlIIIllIIllIll + 2 - 10, llllllllllllllIIIlIlIIIllIIIllII + 1, 16777215);
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllIIIlIlIIIllIIlIIIl, llllllllllllllIIIlIlIIIllIIllIll + 2, llllllllllllllIIIlIlIIIllIIIllII + 1 + GuiStats.this.fontRendererObj.FONT_HEIGHT, (llllllllllllllIIIlIlIIIllIIlIIll == 0) ? 6316128 : 9474192);
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllIIIlIlIIIllIIlIIII, llllllllllllllIIIlIlIIIllIIllIll + 2, llllllllllllllIIIlIlIIIllIIIllII + 1 + GuiStats.this.fontRendererObj.FONT_HEIGHT * 2, (llllllllllllllIIIlIlIIIllIIlIIlI == 0) ? 6316128 : 9474192);
        }
    }
}
