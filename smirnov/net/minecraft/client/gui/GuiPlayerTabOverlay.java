// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import com.google.common.collect.ComparisonChain;
import net.minecraft.scoreboard.Team;
import net.minecraft.scoreboard.ScorePlayerTeam;
import com.mojang.authlib.GameProfile;
import java.util.Iterator;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.world.GameType;
import net.minecraft.entity.player.EnumPlayerModelParts;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.visuals.NameProtect;
import ru.rockstar.Main;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.client.renderer.GlStateManager;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import java.util.List;
import java.util.Comparator;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.math.MathHelper;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.scoreboard.ScoreObjective;
import javax.annotation.Nullable;
import net.minecraft.client.network.NetworkPlayerInfo;
import com.google.common.collect.Ordering;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;

public class GuiPlayerTabOverlay extends Gui
{
    private /* synthetic */ long lastTimeOpened;
    private /* synthetic */ ITextComponent footer;
    private /* synthetic */ ITextComponent header;
    private final /* synthetic */ GuiIngame guiIngame;
    private final /* synthetic */ Minecraft mc;
    public static /* synthetic */ Ordering<NetworkPlayerInfo> ENTRY_ORDERING;
    private /* synthetic */ boolean isBeingRendered;
    
    public void setFooter(@Nullable final ITextComponent lllllllllllIlllIlIIlIlIIlIllIIIl) {
        this.footer = lllllllllllIlllIlIIlIlIIlIllIIIl;
    }
    
    private void drawScoreboardValues(final ScoreObjective lllllllllllIlllIlIIlIlIIllIIIIlI, final int lllllllllllIlllIlIIlIlIIllIlIIll, final String lllllllllllIlllIlIIlIlIIllIIIIII, final int lllllllllllIlllIlIIlIlIIlIllllll, final int lllllllllllIlllIlIIlIlIIllIlIIII, final NetworkPlayerInfo lllllllllllIlllIlIIlIlIIlIllllIl) {
        final int lllllllllllIlllIlIIlIlIIllIIlllI = lllllllllllIlllIlIIlIlIIllIIIIlI.getScoreboard().getOrCreateScore(lllllllllllIlllIlIIlIlIIllIIIIII, lllllllllllIlllIlIIlIlIIllIIIIlI).getScorePoints();
        if (lllllllllllIlllIlIIlIlIIllIIIIlI.getRenderType() == IScoreCriteria.EnumRenderType.HEARTS) {
            this.mc.getTextureManager().bindTexture(GuiPlayerTabOverlay.ICONS);
            if (this.lastTimeOpened == lllllllllllIlllIlIIlIlIIlIllllIl.getRenderVisibilityId()) {
                if (lllllllllllIlllIlIIlIlIIllIIlllI < lllllllllllIlllIlIIlIlIIlIllllIl.getLastHealth()) {
                    lllllllllllIlllIlIIlIlIIlIllllIl.setLastHealthTime(Minecraft.getSystemTime());
                    lllllllllllIlllIlIIlIlIIlIllllIl.setHealthBlinkTime(this.guiIngame.getUpdateCounter() + 20);
                }
                else if (lllllllllllIlllIlIIlIlIIllIIlllI > lllllllllllIlllIlIIlIlIIlIllllIl.getLastHealth()) {
                    lllllllllllIlllIlIIlIlIIlIllllIl.setLastHealthTime(Minecraft.getSystemTime());
                    lllllllllllIlllIlIIlIlIIlIllllIl.setHealthBlinkTime(this.guiIngame.getUpdateCounter() + 10);
                }
            }
            if (Minecraft.getSystemTime() - lllllllllllIlllIlIIlIlIIlIllllIl.getLastHealthTime() > 1000L || this.lastTimeOpened != lllllllllllIlllIlIIlIlIIlIllllIl.getRenderVisibilityId()) {
                lllllllllllIlllIlIIlIlIIlIllllIl.setLastHealth(lllllllllllIlllIlIIlIlIIllIIlllI);
                lllllllllllIlllIlIIlIlIIlIllllIl.setDisplayHealth(lllllllllllIlllIlIIlIlIIllIIlllI);
                lllllllllllIlllIlIIlIlIIlIllllIl.setLastHealthTime(Minecraft.getSystemTime());
            }
            lllllllllllIlllIlIIlIlIIlIllllIl.setRenderVisibilityId(this.lastTimeOpened);
            lllllllllllIlllIlIIlIlIIlIllllIl.setLastHealth(lllllllllllIlllIlIIlIlIIllIIlllI);
            final int lllllllllllIlllIlIIlIlIIllIIllIl = MathHelper.ceil(Math.max(lllllllllllIlllIlIIlIlIIllIIlllI, lllllllllllIlllIlIIlIlIIlIllllIl.getDisplayHealth()) / 2.0f);
            final int lllllllllllIlllIlIIlIlIIllIIllII = Math.max(MathHelper.ceil((float)(lllllllllllIlllIlIIlIlIIllIIlllI / 2)), Math.max(MathHelper.ceil((float)(lllllllllllIlllIlIIlIlIIlIllllIl.getDisplayHealth() / 2)), 10));
            final boolean lllllllllllIlllIlIIlIlIIllIIlIll = lllllllllllIlllIlIIlIlIIlIllllIl.getHealthBlinkTime() > this.guiIngame.getUpdateCounter() && (lllllllllllIlllIlIIlIlIIlIllllIl.getHealthBlinkTime() - this.guiIngame.getUpdateCounter()) / 3L % 2L == 1L;
            if (lllllllllllIlllIlIIlIlIIllIIllIl > 0) {
                final float lllllllllllIlllIlIIlIlIIllIIlIlI = Math.min((lllllllllllIlllIlIIlIlIIllIlIIII - lllllllllllIlllIlIIlIlIIlIllllll - 4) / (float)lllllllllllIlllIlIIlIlIIllIIllII, 9.0f);
                if (lllllllllllIlllIlIIlIlIIllIIlIlI > 3.0f) {
                    for (int lllllllllllIlllIlIIlIlIIllIIlIIl = lllllllllllIlllIlIIlIlIIllIIllIl; lllllllllllIlllIlIIlIlIIllIIlIIl < lllllllllllIlllIlIIlIlIIllIIllII; ++lllllllllllIlllIlIIlIlIIllIIlIIl) {
                        this.drawTexturedModalRect(lllllllllllIlllIlIIlIlIIlIllllll + lllllllllllIlllIlIIlIlIIllIIlIIl * lllllllllllIlllIlIIlIlIIllIIlIlI, (float)lllllllllllIlllIlIIlIlIIllIlIIll, lllllllllllIlllIlIIlIlIIllIIlIll ? 25 : 16, 0, 9, 9);
                    }
                    for (int lllllllllllIlllIlIIlIlIIllIIlIII = 0; lllllllllllIlllIlIIlIlIIllIIlIII < lllllllllllIlllIlIIlIlIIllIIllIl; ++lllllllllllIlllIlIIlIlIIllIIlIII) {
                        this.drawTexturedModalRect(lllllllllllIlllIlIIlIlIIlIllllll + lllllllllllIlllIlIIlIlIIllIIlIII * lllllllllllIlllIlIIlIlIIllIIlIlI, (float)lllllllllllIlllIlIIlIlIIllIlIIll, lllllllllllIlllIlIIlIlIIllIIlIll ? 25 : 16, 0, 9, 9);
                        if (lllllllllllIlllIlIIlIlIIllIIlIll) {
                            if (lllllllllllIlllIlIIlIlIIllIIlIII * 2 + 1 < lllllllllllIlllIlIIlIlIIlIllllIl.getDisplayHealth()) {
                                this.drawTexturedModalRect(lllllllllllIlllIlIIlIlIIlIllllll + lllllllllllIlllIlIIlIlIIllIIlIII * lllllllllllIlllIlIIlIlIIllIIlIlI, (float)lllllllllllIlllIlIIlIlIIllIlIIll, 70, 0, 9, 9);
                            }
                            if (lllllllllllIlllIlIIlIlIIllIIlIII * 2 + 1 == lllllllllllIlllIlIIlIlIIlIllllIl.getDisplayHealth()) {
                                this.drawTexturedModalRect(lllllllllllIlllIlIIlIlIIlIllllll + lllllllllllIlllIlIIlIlIIllIIlIII * lllllllllllIlllIlIIlIlIIllIIlIlI, (float)lllllllllllIlllIlIIlIlIIllIlIIll, 79, 0, 9, 9);
                            }
                        }
                        if (lllllllllllIlllIlIIlIlIIllIIlIII * 2 + 1 < lllllllllllIlllIlIIlIlIIllIIlllI) {
                            this.drawTexturedModalRect(lllllllllllIlllIlIIlIlIIlIllllll + lllllllllllIlllIlIIlIlIIllIIlIII * lllllllllllIlllIlIIlIlIIllIIlIlI, (float)lllllllllllIlllIlIIlIlIIllIlIIll, (lllllllllllIlllIlIIlIlIIllIIlIII >= 10) ? 160 : 52, 0, 9, 9);
                        }
                        if (lllllllllllIlllIlIIlIlIIllIIlIII * 2 + 1 == lllllllllllIlllIlIIlIlIIllIIlllI) {
                            this.drawTexturedModalRect(lllllllllllIlllIlIIlIlIIlIllllll + lllllllllllIlllIlIIlIlIIllIIlIII * lllllllllllIlllIlIIlIlIIllIIlIlI, (float)lllllllllllIlllIlIIlIlIIllIlIIll, (lllllllllllIlllIlIIlIlIIllIIlIII >= 10) ? 169 : 61, 0, 9, 9);
                        }
                    }
                }
                else {
                    final float lllllllllllIlllIlIIlIlIIllIIIlll = MathHelper.clamp(lllllllllllIlllIlIIlIlIIllIIlllI / 20.0f, 0.0f, 1.0f);
                    final int lllllllllllIlllIlIIlIlIIllIIIllI = (int)((1.0f - lllllllllllIlllIlIIlIlIIllIIIlll) * 255.0f) << 16 | (int)(lllllllllllIlllIlIIlIlIIllIIIlll * 255.0f) << 8;
                    String lllllllllllIlllIlIIlIlIIllIIIlIl = new StringBuilder().append(lllllllllllIlllIlIIlIlIIllIIlllI / 2.0f).toString();
                    if (lllllllllllIlllIlIIlIlIIllIlIIII - Minecraft.fontRendererObj.getStringWidth(String.valueOf(lllllllllllIlllIlIIlIlIIllIIIlIl) + "hp") >= lllllllllllIlllIlIIlIlIIlIllllll) {
                        lllllllllllIlllIlIIlIlIIllIIIlIl = String.valueOf(lllllllllllIlllIlIIlIlIIllIIIlIl) + "hp";
                    }
                    Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIlIIlIlIIllIIIlIl, (float)((lllllllllllIlllIlIIlIlIIllIlIIII + lllllllllllIlllIlIIlIlIIlIllllll) / 2 - Minecraft.fontRendererObj.getStringWidth(lllllllllllIlllIlIIlIlIIllIIIlIl) / 2), (float)lllllllllllIlllIlIIlIlIIllIlIIll, lllllllllllIlllIlIIlIlIIllIIIllI);
                }
            }
        }
        else {
            final String lllllllllllIlllIlIIlIlIIllIIIlII = new StringBuilder().append(TextFormatting.YELLOW).append(lllllllllllIlllIlIIlIlIIllIIlllI).toString();
            Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIlIIlIlIIllIIIlII, (float)(lllllllllllIlllIlIIlIlIIllIlIIII - Minecraft.fontRendererObj.getStringWidth(lllllllllllIlllIlIIlIlIIllIIIlII)), (float)lllllllllllIlllIlIIlIlIIllIlIIll, 16777215);
        }
    }
    
    public GuiPlayerTabOverlay(final Minecraft lllllllllllIlllIlIIlIlIllIIIIllI, final GuiIngame lllllllllllIlllIlIIlIlIllIIIIIlI) {
        this.mc = lllllllllllIlllIlIIlIlIllIIIIllI;
        this.guiIngame = lllllllllllIlllIlIIlIlIllIIIIIlI;
    }
    
    static {
        GuiPlayerTabOverlay.ENTRY_ORDERING = (Ordering<NetworkPlayerInfo>)Ordering.from((Comparator)new PlayerComparator());
    }
    
    public static List<EntityPlayer> getPlayers() {
        final List<NetworkPlayerInfo> lllllllllllIlllIlIIlIlIlIlllllIl = (List<NetworkPlayerInfo>)GuiPlayerTabOverlay.ENTRY_ORDERING.sortedCopy((Iterable)Minecraft.getMinecraft().player.connection.getPlayerInfoMap());
        final List<EntityPlayer> lllllllllllIlllIlIIlIlIlIlllllII = new ArrayList<EntityPlayer>();
        for (final NetworkPlayerInfo lllllllllllIlllIlIIlIlIlIllllIll : lllllllllllIlllIlIIlIlIlIlllllIl) {
            if (lllllllllllIlllIlIIlIlIlIllllIll != null) {
                lllllllllllIlllIlIIlIlIlIlllllII.add(Minecraft.getMinecraft().world.getPlayerEntityByName(lllllllllllIlllIlIIlIlIlIllllIll.getGameProfile().getName()));
            }
        }
        return lllllllllllIlllIlIIlIlIlIlllllII;
    }
    
    public void resetFooterHeader() {
        this.header = null;
        this.footer = null;
    }
    
    protected void drawPing(final int lllllllllllIlllIlIIlIlIIllllIllI, final int lllllllllllIlllIlIIlIlIIllllIlIl, final int lllllllllllIlllIlIIlIlIIlllIlIII, final NetworkPlayerInfo lllllllllllIlllIlIIlIlIIlllIIlll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiPlayerTabOverlay.ICONS);
        final int lllllllllllIlllIlIIlIlIIllllIIlI = 0;
        int lllllllllllIlllIlIIlIlIIlllIllII = 0;
        if (lllllllllllIlllIlIIlIlIIlllIIlll.getResponseTime() < 0) {
            final int lllllllllllIlllIlIIlIlIIllllIIIl = 5;
        }
        else if (lllllllllllIlllIlIIlIlIIlllIIlll.getResponseTime() < 150) {
            final int lllllllllllIlllIlIIlIlIIllllIIII = 0;
        }
        else if (lllllllllllIlllIlIIlIlIIlllIIlll.getResponseTime() < 300) {
            final int lllllllllllIlllIlIIlIlIIlllIllll = 1;
        }
        else if (lllllllllllIlllIlIIlIlIIlllIIlll.getResponseTime() < 600) {
            final int lllllllllllIlllIlIIlIlIIlllIlllI = 2;
        }
        else if (lllllllllllIlllIlIIlIlIIlllIIlll.getResponseTime() < 1000) {
            final int lllllllllllIlllIlIIlIlIIlllIllIl = 3;
        }
        else {
            lllllllllllIlllIlIIlIlIIlllIllII = 4;
        }
        this.zLevel += 100.0f;
        this.drawTexturedModalRect(lllllllllllIlllIlIIlIlIIllllIlIl + lllllllllllIlllIlIIlIlIIllllIllI - 11, lllllllllllIlllIlIIlIlIIlllIlIII, 0, 176 + lllllllllllIlllIlIIlIlIIlllIllII * 8, 10, 8);
        this.zLevel -= 100.0f;
    }
    
    public void updatePlayerList(final boolean lllllllllllIlllIlIIlIlIlIlllIIII) {
        if (lllllllllllIlllIlIIlIlIlIlllIIII && !this.isBeingRendered) {
            this.lastTimeOpened = Minecraft.getSystemTime();
        }
        this.isBeingRendered = lllllllllllIlllIlIIlIlIlIlllIIII;
    }
    
    public void renderPlayerlist(final int lllllllllllIlllIlIIlIlIlIIIllllI, final Scoreboard lllllllllllIlllIlIIlIlIlIIIlllIl, @Nullable final ScoreObjective lllllllllllIlllIlIIlIlIlIIIlllII) {
        final NetHandlerPlayClient lllllllllllIlllIlIIlIlIlIlIIlIII = this.mc.player.connection;
        List<NetworkPlayerInfo> lllllllllllIlllIlIIlIlIlIlIIIlll = (List<NetworkPlayerInfo>)GuiPlayerTabOverlay.ENTRY_ORDERING.sortedCopy((Iterable)lllllllllllIlllIlIIlIlIlIlIIlIII.getPlayerInfoMap());
        int lllllllllllIlllIlIIlIlIlIlIIIllI = 0;
        int lllllllllllIlllIlIIlIlIlIlIIIlIl = 0;
        for (final NetworkPlayerInfo lllllllllllIlllIlIIlIlIlIlIIIlII : lllllllllllIlllIlIIlIlIlIlIIIlll) {
            int lllllllllllIlllIlIIlIlIlIlIIIIll = Minecraft.fontRendererObj.getStringWidth(getPlayerName(lllllllllllIlllIlIIlIlIlIlIIIlII));
            lllllllllllIlllIlIIlIlIlIlIIIllI = Math.max(lllllllllllIlllIlIIlIlIlIlIIIllI, lllllllllllIlllIlIIlIlIlIlIIIIll);
            if (lllllllllllIlllIlIIlIlIlIIIlllII != null && lllllllllllIlllIlIIlIlIlIIIlllII.getRenderType() != IScoreCriteria.EnumRenderType.HEARTS) {
                lllllllllllIlllIlIIlIlIlIlIIIIll = Minecraft.fontRendererObj.getStringWidth(" " + lllllllllllIlllIlIIlIlIlIIIlllIl.getOrCreateScore(lllllllllllIlllIlIIlIlIlIlIIIlII.getGameProfile().getName(), lllllllllllIlllIlIIlIlIlIIIlllII).getScorePoints());
                lllllllllllIlllIlIIlIlIlIlIIIlIl = Math.max(lllllllllllIlllIlIIlIlIlIlIIIlIl, lllllllllllIlllIlIIlIlIlIlIIIIll);
            }
        }
        lllllllllllIlllIlIIlIlIlIlIIIlll = lllllllllllIlllIlIIlIlIlIlIIIlll.subList(0, Math.min(lllllllllllIlllIlIIlIlIlIlIIIlll.size(), 80));
        int lllllllllllIlllIlIIlIlIlIlIIIIIl;
        int lllllllllllIlllIlIIlIlIlIlIIIIlI;
        int lllllllllllIlllIlIIlIlIlIlIIIIII;
        for (lllllllllllIlllIlIIlIlIlIlIIIIlI = (lllllllllllIlllIlIIlIlIlIlIIIIIl = lllllllllllIlllIlIIlIlIlIlIIIlll.size()), lllllllllllIlllIlIIlIlIlIlIIIIII = 1; lllllllllllIlllIlIIlIlIlIlIIIIIl > 20; lllllllllllIlllIlIIlIlIlIlIIIIIl = (lllllllllllIlllIlIIlIlIlIlIIIIlI + lllllllllllIlllIlIIlIlIlIlIIIIII - 1) / lllllllllllIlllIlIIlIlIlIlIIIIII) {
            ++lllllllllllIlllIlIIlIlIlIlIIIIII;
        }
        final boolean lllllllllllIlllIlIIlIlIlIIllllll = this.mc.isIntegratedServerRunning() || this.mc.getConnection().getNetworkManager().isEncrypted();
        int lllllllllllIlllIlIIlIlIlIIllllII = 0;
        if (lllllllllllIlllIlIIlIlIlIIIlllII != null) {
            if (lllllllllllIlllIlIIlIlIlIIIlllII.getRenderType() == IScoreCriteria.EnumRenderType.HEARTS) {
                final int lllllllllllIlllIlIIlIlIlIIlllllI = 90;
            }
            else {
                final int lllllllllllIlllIlIIlIlIlIIllllIl = lllllllllllIlllIlIIlIlIlIlIIIlIl;
            }
        }
        else {
            lllllllllllIlllIlIIlIlIlIIllllII = 0;
        }
        final int lllllllllllIlllIlIIlIlIlIIlllIll = Math.min(lllllllllllIlllIlIIlIlIlIlIIIIII * ((lllllllllllIlllIlIIlIlIlIIllllll ? 9 : 0) + lllllllllllIlllIlIIlIlIlIlIIIllI + lllllllllllIlllIlIIlIlIlIIllllII + 13), lllllllllllIlllIlIIlIlIlIIIllllI - 50) / lllllllllllIlllIlIIlIlIlIlIIIIII;
        final int lllllllllllIlllIlIIlIlIlIIlllIlI = lllllllllllIlllIlIIlIlIlIIIllllI / 2 - (lllllllllllIlllIlIIlIlIlIIlllIll * lllllllllllIlllIlIIlIlIlIlIIIIII + (lllllllllllIlllIlIIlIlIlIlIIIIII - 1) * 5) / 2;
        int lllllllllllIlllIlIIlIlIlIIlllIIl = 10;
        int lllllllllllIlllIlIIlIlIlIIlllIII = lllllllllllIlllIlIIlIlIlIIlllIll * lllllllllllIlllIlIIlIlIlIlIIIIII + (lllllllllllIlllIlIIlIlIlIlIIIIII - 1) * 5;
        List<String> lllllllllllIlllIlIIlIlIlIIllIlll = null;
        if (this.header != null) {
            lllllllllllIlllIlIIlIlIlIIllIlll = Minecraft.fontRendererObj.listFormattedStringToWidth(this.header.getFormattedText(), lllllllllllIlllIlIIlIlIlIIIllllI - 50);
            for (final String lllllllllllIlllIlIIlIlIlIIllIllI : lllllllllllIlllIlIIlIlIlIIllIlll) {
                lllllllllllIlllIlIIlIlIlIIlllIII = Math.max(lllllllllllIlllIlIIlIlIlIIlllIII, Minecraft.fontRendererObj.getStringWidth(lllllllllllIlllIlIIlIlIlIIllIllI));
            }
        }
        List<String> lllllllllllIlllIlIIlIlIlIIllIlIl = null;
        if (this.footer != null) {
            lllllllllllIlllIlIIlIlIlIIllIlIl = Minecraft.fontRendererObj.listFormattedStringToWidth(this.footer.getFormattedText(), lllllllllllIlllIlIIlIlIlIIIllllI - 50);
            for (final String lllllllllllIlllIlIIlIlIlIIllIlII : lllllllllllIlllIlIIlIlIlIIllIlIl) {
                lllllllllllIlllIlIIlIlIlIIlllIII = Math.max(lllllllllllIlllIlIIlIlIlIIlllIII, Minecraft.fontRendererObj.getStringWidth(lllllllllllIlllIlIIlIlIlIIllIlII));
            }
        }
        if (lllllllllllIlllIlIIlIlIlIIllIlll != null) {
            Gui.drawRect(lllllllllllIlllIlIIlIlIlIIIllllI / 2 - lllllllllllIlllIlIIlIlIlIIlllIII / 2 - 1, lllllllllllIlllIlIIlIlIlIIlllIIl - 1, lllllllllllIlllIlIIlIlIlIIIllllI / 2 + lllllllllllIlllIlIIlIlIlIIlllIII / 2 + 1, lllllllllllIlllIlIIlIlIlIIlllIIl + lllllllllllIlllIlIIlIlIlIIllIlll.size() * Minecraft.fontRendererObj.FONT_HEIGHT, Integer.MIN_VALUE);
            for (final String lllllllllllIlllIlIIlIlIlIIllIIll : lllllllllllIlllIlIIlIlIlIIllIlll) {
                final int lllllllllllIlllIlIIlIlIlIIllIIlI = Minecraft.fontRendererObj.getStringWidth(lllllllllllIlllIlIIlIlIlIIllIIll);
                Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIlIIlIlIlIIllIIll, (float)(lllllllllllIlllIlIIlIlIlIIIllllI / 2 - lllllllllllIlllIlIIlIlIlIIllIIlI / 2), (float)lllllllllllIlllIlIIlIlIlIIlllIIl, -1);
                lllllllllllIlllIlIIlIlIlIIlllIIl += Minecraft.fontRendererObj.FONT_HEIGHT;
            }
            ++lllllllllllIlllIlIIlIlIlIIlllIIl;
        }
        Gui.drawRect(lllllllllllIlllIlIIlIlIlIIIllllI / 2 - lllllllllllIlllIlIIlIlIlIIlllIII / 2 - 1, lllllllllllIlllIlIIlIlIlIIlllIIl - 1, lllllllllllIlllIlIIlIlIlIIIllllI / 2 + lllllllllllIlllIlIIlIlIlIIlllIII / 2 + 1, lllllllllllIlllIlIIlIlIlIIlllIIl + lllllllllllIlllIlIIlIlIlIlIIIIIl * 9, Integer.MIN_VALUE);
        for (int lllllllllllIlllIlIIlIlIlIIllIIIl = 0; lllllllllllIlllIlIIlIlIlIIllIIIl < lllllllllllIlllIlIIlIlIlIlIIIIlI; ++lllllllllllIlllIlIIlIlIlIIllIIIl) {
            final int lllllllllllIlllIlIIlIlIlIIllIIII = lllllllllllIlllIlIIlIlIlIIllIIIl / lllllllllllIlllIlIIlIlIlIlIIIIIl;
            final int lllllllllllIlllIlIIlIlIlIIlIllll = lllllllllllIlllIlIIlIlIlIIllIIIl % lllllllllllIlllIlIIlIlIlIlIIIIIl;
            int lllllllllllIlllIlIIlIlIlIIlIlllI = lllllllllllIlllIlIIlIlIlIIlllIlI + lllllllllllIlllIlIIlIlIlIIllIIII * lllllllllllIlllIlIIlIlIlIIlllIll + lllllllllllIlllIlIIlIlIlIIllIIII * 5;
            final int lllllllllllIlllIlIIlIlIlIIlIllIl = lllllllllllIlllIlIIlIlIlIIlllIIl + lllllllllllIlllIlIIlIlIlIIlIllll * 9;
            Gui.drawRect(lllllllllllIlllIlIIlIlIlIIlIlllI, lllllllllllIlllIlIIlIlIlIIlIllIl, lllllllllllIlllIlIIlIlIlIIlIlllI + lllllllllllIlllIlIIlIlIlIIlllIll, lllllllllllIlllIlIIlIlIlIIlIllIl + 8, 553648127);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            if (lllllllllllIlllIlIIlIlIlIIllIIIl < lllllllllllIlllIlIIlIlIlIlIIIlll.size()) {
                final NetworkPlayerInfo lllllllllllIlllIlIIlIlIlIIlIllII = lllllllllllIlllIlIIlIlIlIlIIIlll.get(lllllllllllIlllIlIIlIlIlIIllIIIl);
                final GameProfile lllllllllllIlllIlIIlIlIlIIlIlIll = lllllllllllIlllIlIIlIlIlIIlIllII.getGameProfile();
                String lllllllllllIlllIlIIlIlIlIIlIlIlI = getPlayerName(lllllllllllIlllIlIIlIlIlIIlIllII);
                if (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled()) {
                    if (NameProtect.tabSpoof.getBoolValue() && !lllllllllllIlllIlIIlIlIlIIlIlIlI.contains(this.mc.player.getName())) {
                        lllllllllllIlllIlIIlIlIlIIlIlIlI = "§aProtected";
                    }
                    if (Main.featureDirector.getFeatureByClass(NameProtect.class).isToggled() && NameProtect.otherNames.getBoolValue()) {
                        lllllllllllIlllIlIIlIlIlIIlIlIlI = lllllllllllIlllIlIIlIlIlIIlIlIlI.replace(this.mc.player.getName(), ChatFormatting.GREEN + "Protected");
                    }
                }
                if (lllllllllllIlllIlIIlIlIlIIllllll) {
                    final EntityPlayer lllllllllllIlllIlIIlIlIlIIlIlIIl = this.mc.world.getPlayerEntityByUUID(lllllllllllIlllIlIIlIlIlIIlIlIll.getId());
                    final boolean lllllllllllIlllIlIIlIlIlIIlIlIII = lllllllllllIlllIlIIlIlIlIIlIlIIl != null && lllllllllllIlllIlIIlIlIlIIlIlIIl.isWearing(EnumPlayerModelParts.CAPE) && ("Dinnerbone".equals(lllllllllllIlllIlIIlIlIlIIlIlIll.getName()) || "Grumm".equals(lllllllllllIlllIlIIlIlIlIIlIlIll.getName()));
                    this.mc.getTextureManager().bindTexture(lllllllllllIlllIlIIlIlIlIIlIllII.getLocationSkin());
                    final int lllllllllllIlllIlIIlIlIlIIlIIlll = 8 + (lllllllllllIlllIlIIlIlIlIIlIlIII ? 8 : 0);
                    final int lllllllllllIlllIlIIlIlIlIIlIIllI = 8 * (lllllllllllIlllIlIIlIlIlIIlIlIII ? -1 : 1);
                    Gui.drawScaledCustomSizeModalRect(lllllllllllIlllIlIIlIlIlIIlIlllI, lllllllllllIlllIlIIlIlIlIIlIllIl, 8.0f, (float)lllllllllllIlllIlIIlIlIlIIlIIlll, 8, lllllllllllIlllIlIIlIlIlIIlIIllI, 8, 8, 64.0f, 64.0f);
                    if (lllllllllllIlllIlIIlIlIlIIlIlIIl != null && lllllllllllIlllIlIIlIlIlIIlIlIIl.isWearing(EnumPlayerModelParts.HAT)) {
                        final int lllllllllllIlllIlIIlIlIlIIlIIlIl = 8 + (lllllllllllIlllIlIIlIlIlIIlIlIII ? 8 : 0);
                        final int lllllllllllIlllIlIIlIlIlIIlIIlII = 8 * (lllllllllllIlllIlIIlIlIlIIlIlIII ? -1 : 1);
                        Gui.drawScaledCustomSizeModalRect(lllllllllllIlllIlIIlIlIlIIlIlllI, lllllllllllIlllIlIIlIlIlIIlIllIl, 40.0f, (float)lllllllllllIlllIlIIlIlIlIIlIIlIl, 8, lllllllllllIlllIlIIlIlIlIIlIIlII, 8, 8, 64.0f, 64.0f);
                    }
                    lllllllllllIlllIlIIlIlIlIIlIlllI += 9;
                }
                if (lllllllllllIlllIlIIlIlIlIIlIllII.getGameType() == GameType.SPECTATOR) {
                    Minecraft.fontRendererObj.drawStringWithShadow(TextFormatting.ITALIC + lllllllllllIlllIlIIlIlIlIIlIlIlI, (float)lllllllllllIlllIlIIlIlIlIIlIlllI, (float)lllllllllllIlllIlIIlIlIlIIlIllIl, -1862270977);
                }
                else {
                    Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIlIIlIlIlIIlIlIlI, (float)lllllllllllIlllIlIIlIlIlIIlIlllI, (float)lllllllllllIlllIlIIlIlIlIIlIllIl, -1);
                }
                if (lllllllllllIlllIlIIlIlIlIIIlllII != null && lllllllllllIlllIlIIlIlIlIIlIllII.getGameType() != GameType.SPECTATOR) {
                    final int lllllllllllIlllIlIIlIlIlIIlIIIll = lllllllllllIlllIlIIlIlIlIIlIlllI + lllllllllllIlllIlIIlIlIlIlIIIllI + 1;
                    final int lllllllllllIlllIlIIlIlIlIIlIIIlI = lllllllllllIlllIlIIlIlIlIIlIIIll + lllllllllllIlllIlIIlIlIlIIllllII;
                    if (lllllllllllIlllIlIIlIlIlIIlIIIlI - lllllllllllIlllIlIIlIlIlIIlIIIll > 5) {
                        this.drawScoreboardValues(lllllllllllIlllIlIIlIlIlIIIlllII, lllllllllllIlllIlIIlIlIlIIlIllIl, lllllllllllIlllIlIIlIlIlIIlIlIll.getName(), lllllllllllIlllIlIIlIlIlIIlIIIll, lllllllllllIlllIlIIlIlIlIIlIIIlI, lllllllllllIlllIlIIlIlIlIIlIllII);
                    }
                }
                this.drawPing(lllllllllllIlllIlIIlIlIlIIlllIll, lllllllllllIlllIlIIlIlIlIIlIlllI - (lllllllllllIlllIlIIlIlIlIIllllll ? 9 : 0), lllllllllllIlllIlIIlIlIlIIlIllIl, lllllllllllIlllIlIIlIlIlIIlIllII);
            }
        }
        if (lllllllllllIlllIlIIlIlIlIIllIlIl != null) {
            lllllllllllIlllIlIIlIlIlIIlllIIl = lllllllllllIlllIlIIlIlIlIIlllIIl + lllllllllllIlllIlIIlIlIlIlIIIIIl * 9 + 1;
            Gui.drawRect(lllllllllllIlllIlIIlIlIlIIIllllI / 2 - lllllllllllIlllIlIIlIlIlIIlllIII / 2 - 1, lllllllllllIlllIlIIlIlIlIIlllIIl - 1, lllllllllllIlllIlIIlIlIlIIIllllI / 2 + lllllllllllIlllIlIIlIlIlIIlllIII / 2 + 1, lllllllllllIlllIlIIlIlIlIIlllIIl + lllllllllllIlllIlIIlIlIlIIllIlIl.size() * Minecraft.fontRendererObj.FONT_HEIGHT, Integer.MIN_VALUE);
            for (final String lllllllllllIlllIlIIlIlIlIIlIIIIl : lllllllllllIlllIlIIlIlIlIIllIlIl) {
                final int lllllllllllIlllIlIIlIlIlIIlIIIII = Minecraft.fontRendererObj.getStringWidth(lllllllllllIlllIlIIlIlIlIIlIIIIl);
                Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllIlllIlIIlIlIlIIlIIIIl, (float)(lllllllllllIlllIlIIlIlIlIIIllllI / 2 - lllllllllllIlllIlIIlIlIlIIlIIIII / 2), (float)lllllllllllIlllIlIIlIlIlIIlllIIl, -1);
                lllllllllllIlllIlIIlIlIlIIlllIIl += Minecraft.fontRendererObj.FONT_HEIGHT;
            }
        }
    }
    
    public void setHeader(@Nullable final ITextComponent lllllllllllIlllIlIIlIlIIlIlIlIIl) {
        this.header = lllllllllllIlllIlIIlIlIIlIlIlIIl;
    }
    
    public static String getPlayerName(final NetworkPlayerInfo lllllllllllIlllIlIIlIlIlIlllIlIl) {
        return (lllllllllllIlllIlIIlIlIlIlllIlIl.getDisplayName() != null) ? lllllllllllIlllIlIIlIlIlIlllIlIl.getDisplayName().getFormattedText() : ScorePlayerTeam.formatPlayerName(lllllllllllIlllIlIIlIlIlIlllIlIl.getPlayerTeam(), lllllllllllIlllIlIIlIlIlIlllIlIl.getGameProfile().getName());
    }
    
    public static class PlayerComparator implements Comparator<NetworkPlayerInfo>
    {
        @Override
        public int compare(final NetworkPlayerInfo llllllllllIlllllIIIIIIlIlIlIlllI, final NetworkPlayerInfo llllllllllIlllllIIIIIIlIlIlIllIl) {
            final ScorePlayerTeam llllllllllIlllllIIIIIIlIlIllIIII = llllllllllIlllllIIIIIIlIlIlIlllI.getPlayerTeam();
            final ScorePlayerTeam llllllllllIlllllIIIIIIlIlIlIllll = llllllllllIlllllIIIIIIlIlIlIllIl.getPlayerTeam();
            return ComparisonChain.start().compareTrueFirst(llllllllllIlllllIIIIIIlIlIlIlllI.getGameType() != GameType.SPECTATOR, llllllllllIlllllIIIIIIlIlIlIllIl.getGameType() != GameType.SPECTATOR).compare((Comparable)((llllllllllIlllllIIIIIIlIlIllIIII != null) ? llllllllllIlllllIIIIIIlIlIllIIII.getRegisteredName() : ""), (Comparable)((llllllllllIlllllIIIIIIlIlIlIllll != null) ? llllllllllIlllllIIIIIIlIlIlIllll.getRegisteredName() : "")).compare((Comparable)llllllllllIlllllIIIIIIlIlIlIlllI.getGameProfile().getName(), (Comparable)llllllllllIlllllIIIIIIlIlIlIllIl.getGameProfile().getName()).result();
        }
    }
}
