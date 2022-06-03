// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraft.world.BossInfo;
import net.minecraft.client.renderer.GlStateManager;
import com.google.common.collect.Maps;
import java.util.UUID;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;

public class GuiBossOverlay extends Gui
{
    private final /* synthetic */ Minecraft client;
    private static final /* synthetic */ ResourceLocation GUI_BARS_TEXTURES;
    private final /* synthetic */ Map<UUID, BossInfoClient> mapBossInfos;
    public static /* synthetic */ boolean pot;
    
    public GuiBossOverlay(final Minecraft lllllllllllllIllIlllIIIIlIIIlIIl) {
        this.mapBossInfos = (Map<UUID, BossInfoClient>)Maps.newLinkedHashMap();
        this.client = lllllllllllllIllIlllIIIIlIIIlIIl;
    }
    
    static {
        GuiBossOverlay.pot = false;
        GUI_BARS_TEXTURES = new ResourceLocation("textures/gui/bars.png");
    }
    
    public void renderBossHealth() {
        if (!this.mapBossInfos.isEmpty()) {
            final ScaledResolution lllllllllllllIllIlllIIIIIlllllIl = new ScaledResolution(this.client);
            final int lllllllllllllIllIlllIIIIIlllllII = lllllllllllllIllIlllIIIIIlllllIl.getScaledWidth();
            int lllllllllllllIllIlllIIIIIllllIll = 12;
            for (final BossInfoClient lllllllllllllIllIlllIIIIIllllIlI : this.mapBossInfos.values()) {
                final int lllllllllllllIllIlllIIIIIllllIIl = lllllllllllllIllIlllIIIIIlllllII / 2 - 91;
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.client.getTextureManager().bindTexture(GuiBossOverlay.GUI_BARS_TEXTURES);
                this.render(lllllllllllllIllIlllIIIIIllllIIl, lllllllllllllIllIlllIIIIIllllIll, lllllllllllllIllIlllIIIIIllllIlI);
                final String lllllllllllllIllIlllIIIIIllllIII = lllllllllllllIllIlllIIIIIllllIlI.getName().getFormattedText();
                Minecraft.fontRendererObj.drawStringWithShadow(lllllllllllllIllIlllIIIIIllllIII, (float)(lllllllllllllIllIlllIIIIIlllllII / 2 - Minecraft.fontRendererObj.getStringWidth(lllllllllllllIllIlllIIIIIllllIII) / 2), (float)(lllllllllllllIllIlllIIIIIllllIll - 9), 16777215);
                lllllllllllllIllIlllIIIIIllllIll += 10 + Minecraft.fontRendererObj.FONT_HEIGHT;
                GuiBossOverlay.pot = true;
                if (lllllllllllllIllIlllIIIIIllllIll >= lllllllllllllIllIlllIIIIIlllllIl.getScaledHeight() / 3) {
                    break;
                }
            }
        }
    }
    
    private void render(final int lllllllllllllIllIlllIIIIIllIIlII, final int lllllllllllllIllIlllIIIIIllIlIII, final BossInfo lllllllllllllIllIlllIIIIIllIIIlI) {
        this.drawTexturedModalRect(lllllllllllllIllIlllIIIIIllIIlII, lllllllllllllIllIlllIIIIIllIlIII, 0, lllllllllllllIllIlllIIIIIllIIIlI.getColor().ordinal() * 5 * 2, 182, 5);
        if (lllllllllllllIllIlllIIIIIllIIIlI.getOverlay() != BossInfo.Overlay.PROGRESS) {
            this.drawTexturedModalRect(lllllllllllllIllIlllIIIIIllIIlII, lllllllllllllIllIlllIIIIIllIlIII, 0, 80 + (lllllllllllllIllIlllIIIIIllIIIlI.getOverlay().ordinal() - 1) * 5 * 2, 182, 5);
        }
        final int lllllllllllllIllIlllIIIIIllIIllI = (int)(lllllllllllllIllIlllIIIIIllIIIlI.getPercent() * 183.0f);
        if (lllllllllllllIllIlllIIIIIllIIllI > 0) {
            this.drawTexturedModalRect(lllllllllllllIllIlllIIIIIllIIlII, lllllllllllllIllIlllIIIIIllIlIII, 0, lllllllllllllIllIlllIIIIIllIIIlI.getColor().ordinal() * 5 * 2 + 5, lllllllllllllIllIlllIIIIIllIIllI, 5);
            if (lllllllllllllIllIlllIIIIIllIIIlI.getOverlay() != BossInfo.Overlay.PROGRESS) {
                this.drawTexturedModalRect(lllllllllllllIllIlllIIIIIllIIlII, lllllllllllllIllIlllIIIIIllIlIII, 0, 80 + (lllllllllllllIllIlllIIIIIllIIIlI.getOverlay().ordinal() - 1) * 5 * 2 + 5, lllllllllllllIllIlllIIIIIllIIllI, 5);
            }
        }
    }
    
    public void clearBossInfos() {
        this.mapBossInfos.clear();
        GuiBossOverlay.pot = false;
    }
    
    public boolean shouldDarkenSky() {
        if (!this.mapBossInfos.isEmpty()) {
            for (final BossInfo lllllllllllllIllIlllIIIIIlIIlIll : this.mapBossInfos.values()) {
                if (lllllllllllllIllIlllIIIIIlIIlIll.shouldDarkenSky()) {
                    return GuiBossOverlay.pot = true;
                }
            }
        }
        return false;
    }
    
    public boolean shouldPlayEndBossMusic() {
        if (!this.mapBossInfos.isEmpty()) {
            for (final BossInfo lllllllllllllIllIlllIIIIIlIlIIll : this.mapBossInfos.values()) {
                if (lllllllllllllIllIlllIIIIIlIlIIll.shouldPlayEndBossMusic()) {
                    return GuiBossOverlay.pot = true;
                }
            }
        }
        return false;
    }
    
    public boolean shouldCreateFog() {
        if (!this.mapBossInfos.isEmpty()) {
            for (final BossInfo lllllllllllllIllIlllIIIIIlIIIIll : this.mapBossInfos.values()) {
                if (lllllllllllllIllIlllIIIIIlIIIIll.shouldCreateFog()) {
                    return GuiBossOverlay.pot = true;
                }
            }
        }
        return false;
    }
    
    public void read(final SPacketUpdateBossInfo lllllllllllllIllIlllIIIIIlIlllIl) {
        if (lllllllllllllIllIlllIIIIIlIlllIl.getOperation() == SPacketUpdateBossInfo.Operation.ADD) {
            this.mapBossInfos.put(lllllllllllllIllIlllIIIIIlIlllIl.getUniqueId(), new BossInfoClient(lllllllllllllIllIlllIIIIIlIlllIl));
        }
        else if (lllllllllllllIllIlllIIIIIlIlllIl.getOperation() == SPacketUpdateBossInfo.Operation.REMOVE) {
            this.mapBossInfos.remove(lllllllllllllIllIlllIIIIIlIlllIl.getUniqueId());
            GuiBossOverlay.pot = false;
        }
        else {
            this.mapBossInfos.get(lllllllllllllIllIlllIIIIIlIlllIl.getUniqueId()).updateFromPacket(lllllllllllllIllIlllIIIIIlIlllIl);
        }
    }
}
