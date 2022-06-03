// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHandSide;
import ru.rockstar.api.event.event.EventTransformSideFirstPerson;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class ViewModel extends Feature
{
    public static /* synthetic */ NumberSetting rightx;
    public static /* synthetic */ NumberSetting rightz;
    public static /* synthetic */ NumberSetting lefty;
    public static /* synthetic */ NumberSetting leftz;
    public static /* synthetic */ NumberSetting leftx;
    public static /* synthetic */ NumberSetting righty;
    
    @EventTarget
    public void onSidePerson(final EventTransformSideFirstPerson lllllllllllIIlIIIlIIlIlllIIllIIl) {
        if (lllllllllllIIlIIIlIIlIlllIIllIIl.getEnumHandSide() == EnumHandSide.RIGHT) {
            GlStateManager.translate(ViewModel.rightx.getNumberValue(), ViewModel.righty.getNumberValue(), ViewModel.rightz.getNumberValue());
        }
        if (lllllllllllIIlIIIlIIlIlllIIllIIl.getEnumHandSide() == EnumHandSide.LEFT) {
            GlStateManager.translate(-ViewModel.leftx.getNumberValue(), ViewModel.lefty.getNumberValue(), ViewModel.leftz.getNumberValue());
        }
    }
    
    public ViewModel() {
        super("ViewModel", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0440\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043f\u043e\u0437\u0438\u0446\u0438\u044e \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432 \u0432 \u0440\u0443\u043a\u0435", 0, Category.VISUALS);
        ViewModel.rightx = new NumberSetting("RightX", 0.0f, -2.0f, 2.0f, 0.1f, () -> true);
        ViewModel.righty = new NumberSetting("RightY", 0.2f, -2.0f, 2.0f, 0.1f, () -> true);
        ViewModel.rightz = new NumberSetting("RightZ", 0.2f, -2.0f, 2.0f, 0.1f, () -> true);
        ViewModel.leftx = new NumberSetting("LeftX", 0.0f, -2.0f, 2.0f, 0.1f, () -> true);
        ViewModel.lefty = new NumberSetting("LeftY", 0.2f, -2.0f, 2.0f, 0.1f, () -> true);
        ViewModel.leftz = new NumberSetting("LeftZ", 0.2f, -2.0f, 2.0f, 0.1f, () -> true);
        this.addSettings(ViewModel.rightx, ViewModel.righty, ViewModel.rightz, ViewModel.leftx, ViewModel.lefty, ViewModel.leftz);
    }
}
