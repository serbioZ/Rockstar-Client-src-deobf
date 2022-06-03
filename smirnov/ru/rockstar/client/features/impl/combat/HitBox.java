// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.util.text.TextFormatting;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class HitBox extends Feature
{
    public static /* synthetic */ NumberSetting hitboxsize;
    
    public HitBox() {
        super("HitBox", "\u0423\u0432\u0435\u043b\u0438\u0447\u0438\u0432\u0430\u0435\u0442 \u0445\u0438\u0442\u0431\u043e\u043a\u0441 \u0443 \u0435\u043d\u0442\u0438\u0442\u0438", 0, Category.COMBAT);
        HitBox.hitboxsize = new NumberSetting("Size", "\u0420\u0430\u0437\u043c\u0435\u0440 \u0445\u0438\u0442\u0431\u043e\u043a\u0441\u0430", 0.2f, 0.1f, 1.0f, 0.1f, () -> true);
        this.addSettings(HitBox.hitboxsize);
    }
    
    @EventTarget
    public void fsdgsd(final EventUpdate lllllllllllIIlllllIIIlIlIIIllllI) {
        this.setModuleName("HitBox " + TextFormatting.GRAY + "[" + HitBox.hitboxsize.getNumberValue() + "]");
    }
}
