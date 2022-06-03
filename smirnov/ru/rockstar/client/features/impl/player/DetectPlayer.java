// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class DetectPlayer extends Feature
{
    public /* synthetic */ NumberSetting dist;
    public /* synthetic */ ListSetting mode;
    public /* synthetic */ BooleanSetting back;
    
    @EventTarget
    public void ebatkopat(final Event2D lllllllllllIIIllIIIlIIIlllIIlIII) {
        int lllllllllllIIIllIIIlIIIlllIIIlll = 44;
        float lllllllllllIIIllIIIlIIIlllIIIllI = -12.0f;
        final String lllllllllllIIIllIIIlIIIlllIIIlIl = this.mode.getOptions();
        for (final EntityPlayer lllllllllllIIIllIIIlIIIlllIIIlII : DetectPlayer.mc.world.playerEntities) {
            if (lllllllllllIIIllIIIlIIIlllIIIlII != DetectPlayer.mc.player) {
                if (lllllllllllIIIllIIIlIIIlllIIIlIl.equalsIgnoreCase("Hueta")) {
                    if (DetectPlayer.mc.player.getDistanceToEntity(lllllllllllIIIllIIIlIIIlllIIIlII) > this.dist.getNumberValue()) {
                        continue;
                    }
                    final String lllllllllllIIIllIIIlIIIlllIIIIll = lllllllllllIIIllIIIlIIIlllIIIlII.getName();
                    final int lllllllllllIIIllIIIlIIIlllIIIIlI = (int)lllllllllllIIIllIIIlIIIlllIIIlII.posX;
                    final int lllllllllllIIIllIIIlIIIlllIIIIIl = (int)lllllllllllIIIllIIIlIIIlllIIIlII.posY;
                    final int lllllllllllIIIllIIIlIIIlllIIIIII = (int)lllllllllllIIIllIIIlIIIlllIIIlII.posZ;
                    final int lllllllllllIIIllIIIlIIIllIllllll = (int)((int)lllllllllllIIIllIIIlIIIlllIIIlII.posX + lllllllllllIIIllIIIlIIIlllIIIlII.posY + lllllllllllIIIllIIIlIIIlllIIIlII.posZ);
                    final int lllllllllllIIIllIIIlIIIllIlllllI = (int)DetectPlayer.mc.player.getDistanceToEntity(lllllllllllIIIllIIIlIIIlllIIIlII);
                    if (this.back.getBoolValue()) {
                        DrawHelper.drawRectWithGlow(2.0, 9 + lllllllllllIIIllIIIlIIIlllIIIlll, 142.0, lllllllllllIIIllIIIlIIIlllIIIlll + 27, 5.0, 5.0, new Color(32, 32, 32, 150));
                    }
                    DrawHelper.drawRect(1.0, 30.0, 143.0, 50.0, new Color(35, 35, 35).getRGB());
                    DrawHelper.drawNewRect(3.5, 51.2, 140.0, 52.2, new Color(35, 35, 35).getRGB());
                    DrawHelper.drawRect(1.0, 2.0, 3.0, 4.0, new Color(15, 15, 15, 120).getRGB());
                    DetectPlayer.mc.neverlose500_17.drawCenteredString("Enemy Players", 69.0f, 38.0f, -1);
                    DetectPlayer.mc.neverlose500_16.drawString(String.valueOf(lllllllllllIIIllIIIlIIIlllIIIIll) + " (" + lllllllllllIIIllIIIlIIIlllIIIIlI + " " + lllllllllllIIIllIIIlIIIlllIIIIIl + " " + lllllllllllIIIllIIIlIIIlllIIIIII + ")  " + lllllllllllIIIllIIIlIIIllIlllllI, 5.0f, (float)(15 + lllllllllllIIIllIIIlIIIlllIIIlll), -1);
                    lllllllllllIIIllIIIlIIIlllIIIlll += 20;
                    lllllllllllIIIllIIIlIIIlllIIIllI -= 11.0f;
                }
                else {
                    if (!lllllllllllIIIllIIIlIIIlllIIIlIl.equalsIgnoreCase("Default") || DetectPlayer.mc.player.getDistanceToEntity(lllllllllllIIIllIIIlIIIlllIIIlII) > this.dist.getNumberValue()) {
                        continue;
                    }
                    final String lllllllllllIIIllIIIlIIIllIllllIl = lllllllllllIIIllIIIlIIIlllIIIlII.getName();
                    final int lllllllllllIIIllIIIlIIIllIllllII = (int)lllllllllllIIIllIIIlIIIlllIIIlII.posX;
                    final int lllllllllllIIIllIIIlIIIllIlllIll = (int)lllllllllllIIIllIIIlIIIlllIIIlII.posY;
                    final int lllllllllllIIIllIIIlIIIllIlllIlI = (int)lllllllllllIIIllIIIlIIIlllIIIlII.posZ;
                    final int lllllllllllIIIllIIIlIIIllIlllIIl = (int)((int)lllllllllllIIIllIIIlIIIlllIIIlII.posX + lllllllllllIIIllIIIlIIIlllIIIlII.posY + lllllllllllIIIllIIIlIIIlllIIIlII.posZ);
                    final int lllllllllllIIIllIIIlIIIllIlllIII = (int)DetectPlayer.mc.player.getDistanceToEntity(lllllllllllIIIllIIIlIIIlllIIIlII);
                    if (this.back.getBoolValue()) {
                        DrawHelper.drawRect(2.0, 8 + lllllllllllIIIllIIIlIIIlllIIIlll, 142.0, lllllllllllIIIllIIIlIIIlllIIIlll + 26, new Color(32, 32, 32, 150).getRGB());
                    }
                    DrawHelper.drawRect(1.0, 2.0, 3.0, 4.0, new Color(15, 15, 15, 120).getRGB());
                    DetectPlayer.mc.mntsb.drawString(String.valueOf(lllllllllllIIIllIIIlIIIllIllllIl) + " (" + lllllllllllIIIllIIIlIIIllIlllIIl + ")  " + lllllllllllIIIllIIIlIIIllIlllIII, 5.0f, (float)(15 + lllllllllllIIIllIIIlIIIlllIIIlll), -1);
                    lllllllllllIIIllIIIlIIIlllIIIlll += 20;
                    lllllllllllIIIllIIIlIIIlllIIIllI -= 11.0f;
                }
            }
        }
    }
    
    public DetectPlayer() {
        super("DetectPlayer", "\u0414\u0435\u0442\u0435\u043a\u0442\u0438\u0442 \u0438\u0433\u0440\u043e\u043a\u043e\u0432 \u0432 \u043e\u043f\u0440\u0435\u0434\u0435\u043b\u0435\u043d\u043d\u043e\u043c \u0440\u0430\u0434\u0438\u0443\u0441\u0435", 0, Category.PLAYER);
        this.back = new BooleanSetting("Background", true, () -> this.mode.currentMode.equals("Default") || this.mode.currentMode.equals("Hueta"));
        this.mode = new ListSetting("List Mode", "Hueta", () -> true, new String[] { "Hueta", "Default" });
        this.dist = new NumberSetting("Distance", 5.0f, 5.0f, 500.0f, 1.0f, () -> true);
        this.addSettings(this.dist, this.mode, this.back);
    }
}
