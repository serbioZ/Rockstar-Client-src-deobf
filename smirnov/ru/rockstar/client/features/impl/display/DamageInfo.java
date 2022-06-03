// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.display;

import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.api.event.event.Event2D;
import ru.rockstar.client.features.Feature;

public class DamageInfo extends Feature
{
    @EventTarget
    public void hotbar(final Event2D lllllllllllIIllIlllIIIlllIIIlIll) {
        final ScaledResolution lllllllllllIIllIlllIIIlllIIIlIlI = new ScaledResolution(DamageInfo.mc);
        if (DamageInfo.mc.player.hurtTime > 0) {
            DrawHelper.drawGradientRect(0.0, 0.0, lllllllllllIIllIlllIIIlllIIIlIlI.getScaledWidth(), 10.0, new Color(255, 0, 0, 255).getRGB(), new Color(0, 0, 0, 0).getRGB());
            DrawHelper.drawGradientRect(0.0, lllllllllllIIllIlllIIIlllIIIlIlI.getScaledHeight() - 12, lllllllllllIIllIlllIIIlllIIIlIlI.getScaledWidth(), lllllllllllIIllIlllIIIlllIIIlIlI.getScaledHeight(), new Color(0, 0, 0, 0).getRGB(), new Color(255, 0, 0, 255).getRGB());
            DrawHelper.drawGradientRect1(12.0, lllllllllllIIllIlllIIIlllIIIlIlI.getScaledHeight(), 0.0, 0.0, new Color(0, 0, 0, 0).getRGB(), new Color(255, 0, 0, 255).getRGB());
            DrawHelper.drawGradientRect1(lllllllllllIIllIlllIIIlllIIIlIlI.getScaledWidth(), lllllllllllIIllIlllIIIlllIIIlIlI.getScaledHeight(), lllllllllllIIllIlllIIIlllIIIlIlI.getScaledWidth() - 12, 0.0, new Color(255, 0, 0, 255).getRGB(), new Color(0, 0, 0, 0).getRGB());
        }
    }
    
    public DamageInfo() {
        super("DamageInfo", "\u0412\u0438\u0437\u0443\u0430\u043b\u044c\u043d\u043e \u043f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043f\u043e\u043b\u0443\u0447\u0430\u0435\u043c\u044b\u0439 \u0443\u0440\u043e\u043d", 0, Category.DISPLAY);
    }
}
