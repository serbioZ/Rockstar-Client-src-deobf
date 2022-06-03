// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntity;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.PalatteHelper;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class BeaconRadius extends Feature
{
    private final /* synthetic */ BooleanSetting outline;
    private final /* synthetic */ ListSetting colorMode;
    private final /* synthetic */ ColorSetting customColor;
    
    @EventTarget
    public void onRender3D(final Event3D lllllllllllIllllIIlIlIlIIIIlIIII) {
        final int lllllllllllIllllIIlIlIlIIIIllIII = this.customColor.getColorValue();
        int lllllllllllIllllIIlIlIlIIIIlIlll = 0;
        final String lllllllllllIllllIIlIlIlIIIIlIllI = this.colorMode.currentMode;
        final float lllllllllllIllllIIlIlIlIIIIIllII;
        switch (((String)(lllllllllllIllllIIlIlIlIIIIIllII = (float)lllllllllllIllllIIlIlIlIIIIlIllI)).hashCode()) {
            case -1656737386: {
                if (!((String)lllllllllllIllllIIlIlIlIIIIIllII).equals("Rainbow")) {
                    break;
                }
                lllllllllllIllllIIlIlIlIIIIlIlll = PalatteHelper.rainbow(300, 1.0f, 1.0f).getRGB();
                break;
            }
            case 961091784: {
                if (!((String)lllllllllllIllllIIlIlIlIIIIIllII).equals("Astolfo")) {
                    break;
                }
                lllllllllllIllllIIlIlIlIIIIlIlll = PalatteHelper.astolfo(5000.0f, 1).getRGB();
                break;
            }
            case 2021122027: {
                if (!((String)lllllllllllIllllIIlIlIlIIIIIllII).equals("Client")) {
                    break;
                }
                lllllllllllIllllIIlIlIlIIIIlIlll = ClientHelper.getClientColor().getRGB();
                break;
            }
            case 2029746065: {
                if (!((String)lllllllllllIllllIIlIlIlIIIIIllII).equals("Custom")) {
                    break;
                }
                lllllllllllIllllIIlIlIlIIIIlIlll = lllllllllllIllllIIlIlIlIIIIllIII;
                break;
            }
        }
        for (final TileEntity lllllllllllIllllIIlIlIlIIIIlIlIl : BeaconRadius.mc.world.loadedTileEntityList) {
            if (lllllllllllIllllIIlIlIlIIIIlIlIl instanceof TileEntityBeacon) {
                final float lllllllllllIllllIIlIlIlIIIIlIlII = (float)((TileEntityBeacon)lllllllllllIllllIIlIlIlIIIIlIlIl).getLevels();
                final float lllllllllllIllllIIlIlIlIIIIlIIll = (lllllllllllIllllIIlIlIlIIIIlIlII == 1.0f) ? 21.0f : ((lllllllllllIllllIIlIlIlIIIIlIlII == 2.0f) ? 31.0f : ((lllllllllllIllllIIlIlIlIIIIlIlII == 3.0f) ? 41.0f : ((lllllllllllIllllIIlIlIlIIIIlIlII == 4.0f) ? 51.0f : 0.0f)));
                final int lllllllllllIllllIIlIlIlIIIIlIIlI = 360;
                if (this.outline.getBoolValue()) {
                    DrawHelper.drawCircle3D(lllllllllllIllllIIlIlIlIIIIlIlIl, lllllllllllIllllIIlIlIlIIIIlIIll - 0.006, lllllllllllIllllIIlIlIlIIIIlIIII.getPartialTicks(), 360, 6.0f, Color.BLACK.getRGB());
                    DrawHelper.drawCircle3D(lllllllllllIllllIIlIlIlIIIIlIlIl, lllllllllllIllllIIlIlIlIIIIlIIll + 0.006, lllllllllllIllllIIlIlIlIIIIlIIII.getPartialTicks(), 360, 6.0f, Color.BLACK.getRGB());
                }
                DrawHelper.drawCircle3D(lllllllllllIllllIIlIlIlIIIIlIlIl, lllllllllllIllllIIlIlIlIIIIlIIll, lllllllllllIllllIIlIlIlIIIIlIIII.getPartialTicks(), 360, 2.0f, lllllllllllIllllIIlIlIlIIIIlIlll);
            }
        }
    }
    
    public BeaconRadius() {
        super("BeaconRadius", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u0437\u043e\u043d\u0443 \u0440\u0430\u0434\u0438\u0443\u0441\u0430 \u043c\u0430\u044f\u043a\u0430", 0, Category.VISUALS);
        this.colorMode = new ListSetting("Circle Mode", "Custom", () -> true, new String[] { "Astolfo", "Rainbow", "Client", "Custom", "Cosmo" });
        this.customColor = new ColorSetting("Custom Color", Color.WHITE.getRGB(), () -> this.colorMode.currentMode.equals("Custom"));
        this.outline = new BooleanSetting("Outline", true, () -> true);
        this.addSettings(this.colorMode, this.customColor, this.outline);
    }
}
