// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.util.math.BlockPos;
import ru.rockstar.api.utils.render.DrawHelper;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntity;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.Setting;
import java.awt.Color;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.features.Feature;

public class ChestEsp extends Feature
{
    public static /* synthetic */ ColorSetting chestColor;
    public static /* synthetic */ BooleanSetting espOutline;
    
    public ChestEsp() {
        super("ChestEsp", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0441\u0443\u043d\u0434\u0443\u043a\u0438 \u0447\u0435\u0440\u0435\u0437 \u0441\u0442\u0435\u043d\u044b", 0, Category.VISUALS);
        ChestEsp.chestColor = new ColorSetting("Chest Color", new Color(16777215).getRGB(), () -> true);
        ChestEsp.espOutline = new BooleanSetting("ESP Outline", false, () -> true);
        this.addSettings(ChestEsp.espOutline, ChestEsp.chestColor);
    }
    
    @EventTarget
    public void onRender3D(final Event3D llllllllllllllIIllIlIIlIlIIIlIlI) {
        if (ChestEsp.mc.player != null || ChestEsp.mc.world != null) {
            for (final TileEntity llllllllllllllIIllIlIIlIlIIIlIIl : ChestEsp.mc.world.loadedTileEntityList) {
                final BlockPos llllllllllllllIIllIlIIlIlIIIlIII = llllllllllllllIIllIlIIlIlIIIlIIl.getPos();
                if (llllllllllllllIIllIlIIlIlIIIlIIl instanceof TileEntityChest) {
                    DrawHelper.blockEsp(llllllllllllllIIllIlIIlIlIIIlIII, new Color(ChestEsp.chestColor.getColorValue()), ChestEsp.espOutline.getBoolValue());
                }
            }
        }
    }
}
