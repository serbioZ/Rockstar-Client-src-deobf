// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import com.google.common.collect.Lists;
import net.minecraft.enchantment.Enchantment;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnchantmentNameParts;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.util.glu.Project;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.model.ModelBook;
import java.util.Random;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.IWorldNameable;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiEnchantment extends GuiContainer
{
    private /* synthetic */ ItemStack last;
    public /* synthetic */ float flipA;
    private final /* synthetic */ IWorldNameable nameable;
    private final /* synthetic */ InventoryPlayer playerInventory;
    public /* synthetic */ int ticks;
    private static final /* synthetic */ ResourceLocation ENCHANTMENT_TABLE_BOOK_TEXTURE;
    private final /* synthetic */ ContainerEnchantment container;
    public /* synthetic */ float open;
    public /* synthetic */ float flip;
    private final /* synthetic */ Random random;
    private static final /* synthetic */ ModelBook MODEL_BOOK;
    private static final /* synthetic */ ResourceLocation ENCHANTMENT_TABLE_GUI_TEXTURE;
    public /* synthetic */ float flipT;
    public /* synthetic */ float oOpen;
    public /* synthetic */ float oFlip;
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        this.tickBook();
    }
    
    public void tickBook() {
        final ItemStack lllllllllllIlIlIlIllIIlIlllIIIll = this.inventorySlots.getSlot(0).getStack();
        if (!ItemStack.areItemStacksEqual(lllllllllllIlIlIlIllIIlIlllIIIll, this.last)) {
            this.last = lllllllllllIlIlIlIllIIlIlllIIIll;
            do {
                this.flipT += this.random.nextInt(4) - this.random.nextInt(4);
            } while (this.flip <= this.flipT + 1.0f && this.flip >= this.flipT - 1.0f);
        }
        ++this.ticks;
        this.oFlip = this.flip;
        this.oOpen = this.open;
        boolean lllllllllllIlIlIlIllIIlIlllIIIlI = false;
        for (int lllllllllllIlIlIlIllIIlIlllIIIIl = 0; lllllllllllIlIlIlIllIIlIlllIIIIl < 3; ++lllllllllllIlIlIlIllIIlIlllIIIIl) {
            if (this.container.enchantLevels[lllllllllllIlIlIlIllIIlIlllIIIIl] != 0) {
                lllllllllllIlIlIlIllIIlIlllIIIlI = true;
            }
        }
        if (lllllllllllIlIlIlIllIIlIlllIIIlI) {
            this.open += 0.2f;
        }
        else {
            this.open -= 0.2f;
        }
        this.open = MathHelper.clamp(this.open, 0.0f, 1.0f);
        float lllllllllllIlIlIlIllIIlIlllIIIII = (this.flipT - this.flip) * 0.4f;
        final float lllllllllllIlIlIlIllIIlIllIlllll = 0.2f;
        lllllllllllIlIlIlIllIIlIlllIIIII = MathHelper.clamp(lllllllllllIlIlIlIllIIlIlllIIIII, -0.2f, 0.2f);
        this.flipA += (lllllllllllIlIlIlIllIIlIlllIIIII - this.flipA) * 0.9f;
        this.flip += this.flipA;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllIlIlIlIllIIllIIlIlIll, final int lllllllllllIlIlIlIllIIllIlIIIIlI, final int lllllllllllIlIlIlIllIIllIIlIlIIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiEnchantment.ENCHANTMENT_TABLE_GUI_TEXTURE);
        final int lllllllllllIlIlIlIllIIllIlIIIIII = (this.width - this.xSize) / 2;
        final int lllllllllllIlIlIlIllIIllIIllllll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllIlIlIlIllIIllIlIIIIII, lllllllllllIlIlIlIllIIllIIllllll, 0, 0, this.xSize, this.ySize);
        GlStateManager.pushMatrix();
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        final ScaledResolution lllllllllllIlIlIlIllIIllIIlllllI = new ScaledResolution(this.mc);
        GlStateManager.viewport((lllllllllllIlIlIlIllIIllIIlllllI.getScaledWidth() - 320) / 2 * ScaledResolution.getScaleFactor(), (lllllllllllIlIlIlIllIIllIIlllllI.getScaledHeight() - 240) / 2 * ScaledResolution.getScaleFactor(), 320 * ScaledResolution.getScaleFactor(), 240 * ScaledResolution.getScaleFactor());
        GlStateManager.translate(-0.34f, 0.23f, 0.0f);
        Project.gluPerspective(90.0f, 1.3333334f, 9.0f, 80.0f);
        final float lllllllllllIlIlIlIllIIllIIllllIl = 1.0f;
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.translate(0.0f, 3.3f, -16.0f);
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        final float lllllllllllIlIlIlIllIIllIIllllII = 5.0f;
        GlStateManager.scale(5.0f, 5.0f, 5.0f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiEnchantment.ENCHANTMENT_TABLE_BOOK_TEXTURE);
        GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
        final float lllllllllllIlIlIlIllIIllIIlllIll = this.oOpen + (this.open - this.oOpen) * lllllllllllIlIlIlIllIIllIIlIlIll;
        GlStateManager.translate((1.0f - lllllllllllIlIlIlIllIIllIIlllIll) * 0.2f, (1.0f - lllllllllllIlIlIlIllIIllIIlllIll) * 0.1f, (1.0f - lllllllllllIlIlIlIllIIllIIlllIll) * 0.25f);
        GlStateManager.rotate(-(1.0f - lllllllllllIlIlIlIllIIllIIlllIll) * 90.0f - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        float lllllllllllIlIlIlIllIIllIIlllIlI = this.oFlip + (this.flip - this.oFlip) * lllllllllllIlIlIlIllIIllIIlIlIll + 0.25f;
        float lllllllllllIlIlIlIllIIllIIlllIIl = this.oFlip + (this.flip - this.oFlip) * lllllllllllIlIlIlIllIIllIIlIlIll + 0.75f;
        lllllllllllIlIlIlIllIIllIIlllIlI = (lllllllllllIlIlIlIllIIllIIlllIlI - MathHelper.fastFloor(lllllllllllIlIlIlIllIIllIIlllIlI)) * 1.6f - 0.3f;
        lllllllllllIlIlIlIllIIllIIlllIIl = (lllllllllllIlIlIlIllIIllIIlllIIl - MathHelper.fastFloor(lllllllllllIlIlIlIllIIllIIlllIIl)) * 1.6f - 0.3f;
        if (lllllllllllIlIlIlIllIIllIIlllIlI < 0.0f) {
            lllllllllllIlIlIlIllIIllIIlllIlI = 0.0f;
        }
        if (lllllllllllIlIlIlIllIIllIIlllIIl < 0.0f) {
            lllllllllllIlIlIlIllIIllIIlllIIl = 0.0f;
        }
        if (lllllllllllIlIlIlIllIIllIIlllIlI > 1.0f) {
            lllllllllllIlIlIlIllIIllIIlllIlI = 1.0f;
        }
        if (lllllllllllIlIlIlIllIIllIIlllIIl > 1.0f) {
            lllllllllllIlIlIlIllIIllIIlllIIl = 1.0f;
        }
        GlStateManager.enableRescaleNormal();
        GuiEnchantment.MODEL_BOOK.render(null, 0.0f, lllllllllllIlIlIlIllIIllIIlllIlI, lllllllllllIlIlIlIllIIllIIlllIIl, lllllllllllIlIlIlIllIIllIIlllIll, 0.0f, 0.0625f);
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.matrixMode(5889);
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        EnchantmentNameParts.getInstance().reseedRandomGenerator(this.container.xpSeed);
        final int lllllllllllIlIlIlIllIIllIIlllIII = this.container.getLapisAmount();
        for (int lllllllllllIlIlIlIllIIllIIllIlll = 0; lllllllllllIlIlIlIllIIllIIllIlll < 3; ++lllllllllllIlIlIlIllIIllIIllIlll) {
            final int lllllllllllIlIlIlIllIIllIIllIllI = lllllllllllIlIlIlIllIIllIlIIIIII + 60;
            final int lllllllllllIlIlIlIllIIllIIllIlIl = lllllllllllIlIlIlIllIIllIIllIllI + 20;
            this.zLevel = 0.0f;
            this.mc.getTextureManager().bindTexture(GuiEnchantment.ENCHANTMENT_TABLE_GUI_TEXTURE);
            final int lllllllllllIlIlIlIllIIllIIllIlII = this.container.enchantLevels[lllllllllllIlIlIlIllIIllIIllIlll];
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (lllllllllllIlIlIlIllIIllIIllIlII == 0) {
                this.drawTexturedModalRect(lllllllllllIlIlIlIllIIllIIllIllI, lllllllllllIlIlIlIllIIllIIllllll + 14 + 19 * lllllllllllIlIlIlIllIIllIIllIlll, 0, 185, 108, 19);
            }
            else {
                final String lllllllllllIlIlIlIllIIllIIllIIll = new StringBuilder().append(lllllllllllIlIlIlIllIIllIIllIlII).toString();
                final int lllllllllllIlIlIlIllIIllIIllIIlI = 86 - this.fontRendererObj.getStringWidth(lllllllllllIlIlIlIllIIllIIllIIll);
                final String lllllllllllIlIlIlIllIIllIIllIIIl = EnchantmentNameParts.getInstance().generateNewRandomName(this.fontRendererObj, lllllllllllIlIlIlIllIIllIIllIIlI);
                FontRenderer lllllllllllIlIlIlIllIIllIIllIIII = this.mc.standardGalacticFontRenderer;
                int lllllllllllIlIlIlIllIIllIIlIllll = 6839882;
                if ((lllllllllllIlIlIlIllIIllIIlllIII < lllllllllllIlIlIlIllIIllIIllIlll + 1 || this.mc.player.experienceLevel < lllllllllllIlIlIlIllIIllIIllIlII) && !this.mc.player.capabilities.isCreativeMode) {
                    this.drawTexturedModalRect(lllllllllllIlIlIlIllIIllIIllIllI, lllllllllllIlIlIlIllIIllIIllllll + 14 + 19 * lllllllllllIlIlIlIllIIllIIllIlll, 0, 185, 108, 19);
                    this.drawTexturedModalRect(lllllllllllIlIlIlIllIIllIIllIllI + 1, lllllllllllIlIlIlIllIIllIIllllll + 15 + 19 * lllllllllllIlIlIlIllIIllIIllIlll, 16 * lllllllllllIlIlIlIllIIllIIllIlll, 239, 16, 16);
                    lllllllllllIlIlIlIllIIllIIllIIII.drawSplitString(lllllllllllIlIlIlIllIIllIIllIIIl, lllllllllllIlIlIlIllIIllIIllIlIl, lllllllllllIlIlIlIllIIllIIllllll + 16 + 19 * lllllllllllIlIlIlIllIIllIIllIlll, lllllllllllIlIlIlIllIIllIIllIIlI, (lllllllllllIlIlIlIllIIllIIlIllll & 0xFEFEFE) >> 1);
                    lllllllllllIlIlIlIllIIllIIlIllll = 4226832;
                }
                else {
                    final int lllllllllllIlIlIlIllIIllIIlIlllI = lllllllllllIlIlIlIllIIllIlIIIIlI - (lllllllllllIlIlIlIllIIllIlIIIIII + 60);
                    final int lllllllllllIlIlIlIllIIllIIlIllIl = lllllllllllIlIlIlIllIIllIIlIlIIl - (lllllllllllIlIlIlIllIIllIIllllll + 14 + 19 * lllllllllllIlIlIlIllIIllIIllIlll);
                    if (lllllllllllIlIlIlIllIIllIIlIlllI >= 0 && lllllllllllIlIlIlIllIIllIIlIllIl >= 0 && lllllllllllIlIlIlIllIIllIIlIlllI < 108 && lllllllllllIlIlIlIllIIllIIlIllIl < 19) {
                        this.drawTexturedModalRect(lllllllllllIlIlIlIllIIllIIllIllI, lllllllllllIlIlIlIllIIllIIllllll + 14 + 19 * lllllllllllIlIlIlIllIIllIIllIlll, 0, 204, 108, 19);
                        lllllllllllIlIlIlIllIIllIIlIllll = 16777088;
                    }
                    else {
                        this.drawTexturedModalRect(lllllllllllIlIlIlIllIIllIIllIllI, lllllllllllIlIlIlIllIIllIIllllll + 14 + 19 * lllllllllllIlIlIlIllIIllIIllIlll, 0, 166, 108, 19);
                    }
                    this.drawTexturedModalRect(lllllllllllIlIlIlIllIIllIIllIllI + 1, lllllllllllIlIlIlIllIIllIIllllll + 15 + 19 * lllllllllllIlIlIlIllIIllIIllIlll, 16 * lllllllllllIlIlIlIllIIllIIllIlll, 223, 16, 16);
                    lllllllllllIlIlIlIllIIllIIllIIII.drawSplitString(lllllllllllIlIlIlIllIIllIIllIIIl, lllllllllllIlIlIlIllIIllIIllIlIl, lllllllllllIlIlIlIllIIllIIllllll + 16 + 19 * lllllllllllIlIlIlIllIIllIIllIlll, lllllllllllIlIlIlIllIIllIIllIIlI, lllllllllllIlIlIlIllIIllIIlIllll);
                    lllllllllllIlIlIlIllIIllIIlIllll = 8453920;
                }
                lllllllllllIlIlIlIllIIllIIllIIII = Minecraft.fontRendererObj;
                lllllllllllIlIlIlIllIIllIIllIIII.drawStringWithShadow(lllllllllllIlIlIlIllIIllIIllIIll, (float)(lllllllllllIlIlIlIllIIllIIllIlIl + 86 - lllllllllllIlIlIlIllIIllIIllIIII.getStringWidth(lllllllllllIlIlIlIllIIllIIllIIll)), (float)(lllllllllllIlIlIlIllIIllIIllllll + 16 + 19 * lllllllllllIlIlIlIllIIllIIllIlll + 7), lllllllllllIlIlIlIllIIllIIlIllll);
            }
        }
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIlIlIlIllIIllIllIIlII, final int lllllllllllIlIlIlIllIIllIllIllII, final int lllllllllllIlIlIlIllIIllIllIIIlI) throws IOException {
        super.mouseClicked(lllllllllllIlIlIlIllIIllIllIIlII, lllllllllllIlIlIlIllIIllIllIllII, lllllllllllIlIlIlIllIIllIllIIIlI);
        final int lllllllllllIlIlIlIllIIllIllIlIlI = (this.width - this.xSize) / 2;
        final int lllllllllllIlIlIlIllIIllIllIlIIl = (this.height - this.ySize) / 2;
        for (int lllllllllllIlIlIlIllIIllIllIlIII = 0; lllllllllllIlIlIlIllIIllIllIlIII < 3; ++lllllllllllIlIlIlIllIIllIllIlIII) {
            final int lllllllllllIlIlIlIllIIllIllIIlll = lllllllllllIlIlIlIllIIllIllIIlII - (lllllllllllIlIlIlIllIIllIllIlIlI + 60);
            final int lllllllllllIlIlIlIllIIllIllIIllI = lllllllllllIlIlIlIllIIllIllIllII - (lllllllllllIlIlIlIllIIllIllIlIIl + 14 + 19 * lllllllllllIlIlIlIllIIllIllIlIII);
            if (lllllllllllIlIlIlIllIIllIllIIlll >= 0 && lllllllllllIlIlIlIllIIllIllIIllI >= 0 && lllllllllllIlIlIlIllIIllIllIIlll < 108 && lllllllllllIlIlIlIllIIllIllIIllI < 19 && this.container.enchantItem(this.mc.player, lllllllllllIlIlIlIllIIllIllIlIII)) {
                this.mc.playerController.sendEnchantPacket(this.container.windowId, lllllllllllIlIlIlIllIIllIllIlIII);
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllIlIlIlIllIIllIIIIIlIl, final int lllllllllllIlIlIlIllIIllIIIIIlII, float lllllllllllIlIlIlIllIIlIllllIlII) {
        lllllllllllIlIlIlIllIIlIllllIlII = this.mc.func_193989_ak();
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllIlIlIlIllIIllIIIIIlIl, lllllllllllIlIlIlIllIIllIIIIIlII, lllllllllllIlIlIlIllIIlIllllIlII);
        this.func_191948_b(lllllllllllIlIlIlIllIIllIIIIIlIl, lllllllllllIlIlIlIllIIllIIIIIlII);
        final boolean lllllllllllIlIlIlIllIIllIIIIIIlI = this.mc.player.capabilities.isCreativeMode;
        final int lllllllllllIlIlIlIllIIllIIIIIIIl = this.container.getLapisAmount();
        for (int lllllllllllIlIlIlIllIIllIIIIIIII = 0; lllllllllllIlIlIlIllIIllIIIIIIII < 3; ++lllllllllllIlIlIlIllIIllIIIIIIII) {
            final int lllllllllllIlIlIlIllIIlIllllllll = this.container.enchantLevels[lllllllllllIlIlIlIllIIllIIIIIIII];
            final Enchantment lllllllllllIlIlIlIllIIlIlllllllI = Enchantment.getEnchantmentByID(this.container.enchantClue[lllllllllllIlIlIlIllIIllIIIIIIII]);
            final int lllllllllllIlIlIlIllIIlIllllllIl = this.container.worldClue[lllllllllllIlIlIlIllIIllIIIIIIII];
            final int lllllllllllIlIlIlIllIIlIllllllII = lllllllllllIlIlIlIllIIllIIIIIIII + 1;
            if (this.isPointInRegion(60, 14 + 19 * lllllllllllIlIlIlIllIIllIIIIIIII, 108, 17, lllllllllllIlIlIlIllIIllIIIIIlIl, lllllllllllIlIlIlIllIIllIIIIIlII) && lllllllllllIlIlIlIllIIlIllllllll > 0 && lllllllllllIlIlIlIllIIlIllllllIl >= 0 && lllllllllllIlIlIlIllIIlIlllllllI != null) {
                final List<String> lllllllllllIlIlIlIllIIlIlllllIll = (List<String>)Lists.newArrayList();
                lllllllllllIlIlIlIllIIlIlllllIll.add(new StringBuilder().append(TextFormatting.WHITE).append(TextFormatting.ITALIC).append(I18n.format("container.enchant.clue", lllllllllllIlIlIlIllIIlIlllllllI.getTranslatedName(lllllllllllIlIlIlIllIIlIllllllIl))).toString());
                if (!lllllllllllIlIlIlIllIIllIIIIIIlI) {
                    lllllllllllIlIlIlIllIIlIlllllIll.add("");
                    if (this.mc.player.experienceLevel < lllllllllllIlIlIlIllIIlIllllllll) {
                        lllllllllllIlIlIlIllIIlIlllllIll.add(TextFormatting.RED + I18n.format("container.enchant.level.requirement", this.container.enchantLevels[lllllllllllIlIlIlIllIIllIIIIIIII]));
                    }
                    else {
                        String lllllllllllIlIlIlIllIIlIlllllIIl = null;
                        if (lllllllllllIlIlIlIllIIlIllllllII == 1) {
                            final String lllllllllllIlIlIlIllIIlIlllllIlI = I18n.format("container.enchant.lapis.one", new Object[0]);
                        }
                        else {
                            lllllllllllIlIlIlIllIIlIlllllIIl = I18n.format("container.enchant.lapis.many", lllllllllllIlIlIlIllIIlIllllllII);
                        }
                        final TextFormatting lllllllllllIlIlIlIllIIlIlllllIII = (lllllllllllIlIlIlIllIIllIIIIIIIl >= lllllllllllIlIlIlIllIIlIllllllII) ? TextFormatting.GRAY : TextFormatting.RED;
                        lllllllllllIlIlIlIllIIlIlllllIll.add(lllllllllllIlIlIlIllIIlIlllllIII + lllllllllllIlIlIlIllIIlIlllllIIl);
                        if (lllllllllllIlIlIlIllIIlIllllllII == 1) {
                            lllllllllllIlIlIlIllIIlIlllllIIl = I18n.format("container.enchant.level.one", new Object[0]);
                        }
                        else {
                            lllllllllllIlIlIlIllIIlIlllllIIl = I18n.format("container.enchant.level.many", lllllllllllIlIlIlIllIIlIllllllII);
                        }
                        lllllllllllIlIlIlIllIIlIlllllIll.add(TextFormatting.GRAY + lllllllllllIlIlIlIllIIlIlllllIIl);
                    }
                }
                this.drawHoveringText(lllllllllllIlIlIlIllIIlIlllllIll, lllllllllllIlIlIlIllIIllIIIIIlIl, lllllllllllIlIlIlIllIIllIIIIIlII);
                break;
            }
        }
    }
    
    static {
        ENCHANTMENT_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/enchanting_table.png");
        ENCHANTMENT_TABLE_BOOK_TEXTURE = new ResourceLocation("textures/entity/enchanting_table_book.png");
        MODEL_BOOK = new ModelBook();
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllIlIlIlIllIIllIlllllIl, final int lllllllllllIlIlIlIllIIllIlllllII) {
        this.fontRendererObj.drawString(this.nameable.getDisplayName().getUnformattedText(), 12.0f, 5.0f, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0f, (float)(this.ySize - 96 + 2), 4210752);
    }
    
    public GuiEnchantment(final InventoryPlayer lllllllllllIlIlIlIllIIlllIIIIllI, final World lllllllllllIlIlIlIllIIlllIIIIlIl, final IWorldNameable lllllllllllIlIlIlIllIIlllIIIIIII) {
        super(new ContainerEnchantment(lllllllllllIlIlIlIllIIlllIIIIllI, lllllllllllIlIlIlIllIIlllIIIIlIl));
        this.random = new Random();
        this.last = ItemStack.field_190927_a;
        this.playerInventory = lllllllllllIlIlIlIllIIlllIIIIllI;
        this.container = (ContainerEnchantment)this.inventorySlots;
        this.nameable = lllllllllllIlIlIlIllIIlllIIIIIII;
    }
}
