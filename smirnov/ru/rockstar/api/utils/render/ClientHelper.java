// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.render;

import ru.rockstar.client.features.impl.display.ArreyList;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClientFont;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.font.FontRenderer;
import net.minecraft.client.multiplayer.ServerData;
import ru.rockstar.api.utils.Helper;

public class ClientHelper implements Helper
{
    public static FontRenderer getFontRender() {
        final Minecraft llllllllllllIIIlIIlIIIllIIIlIlII = Minecraft.getMinecraft();
        FontRenderer llllllllllllIIIlIIlIIIllIIIlIIll = llllllllllllIIIlIIlIIIllIIIlIlII.sfui18;
        final String llllllllllllIIIlIIlIIIllIIIlIIlI = ClientFont.fontMode.getOptions();
        final char llllllllllllIIIlIIlIIIllIIIIlllI;
        switch (((String)(llllllllllllIIIlIIlIIIllIIIIlllI = (char)llllllllllllIIIlIIlIIIllIIIlIIlI)).hashCode()) {
            case -1386614847: {
                if (!((String)llllllllllllIIIlIIlIIIllIIIIlllI).equals("WexSide")) {
                    break;
                }
                llllllllllllIIIlIIlIIIllIIIlIIll = llllllllllllIIIlIIlIIIllIIIlIlII.mntsb;
                break;
            }
            case -787673224: {
                if (!((String)llllllllllllIIIlIIlIIIllIIIIlllI).equals("Comic Sans")) {
                    break;
                }
                llllllllllllIIIlIIlIIIllIIIlIIll = llllllllllllIIIlIIlIIIllIIIlIlII.comicsans_14;
                break;
            }
            case -535237183: {
                if (!((String)llllllllllllIIIlIIlIIIllIIIIlllI).equals("Roboto Regular")) {
                    break;
                }
                llllllllllllIIIlIIlIIIllIIIlIIll = llllllllllllIIIlIIlIIIllIIIlIlII.robotoRegular;
                break;
            }
            case 2361040: {
                if (!((String)llllllllllllIIIlIIlIIIllIIIIlllI).equals("Lato")) {
                    break;
                }
                llllllllllllIIIlIIlIIIllIIIlIIll = llllllllllllIIIlIIlIIIllIIIlIlII.lato;
                break;
            }
            case 2542631: {
                if (!((String)llllllllllllIIIlIIlIIIllIIIIlllI).equals("SFUI")) {
                    break;
                }
                llllllllllllIIIlIIlIIIllIIIlIIll = llllllllllllIIIlIIlIIIllIIIlIlII.sfui18;
                break;
            }
            case 74829585: {
                if (!((String)llllllllllllIIIlIIlIIIllIIIIlllI).equals("Myseo")) {
                    break;
                }
                llllllllllllIIIlIIlIIIllIIIlIIll = llllllllllllIIIlIIlIIIllIIIlIlII.neverlose500_18;
                break;
            }
            case 245219335: {
                if (!((String)llllllllllllIIIlIIlIIIllIIIIlllI).equals("URWGeometric")) {
                    break;
                }
                llllllllllllIIIlIIlIIIllIIIlIIll = llllllllllllIIIlIIlIIIllIIIlIlII.urwgeometric;
                break;
            }
            case 1033109409: {
                if (!((String)llllllllllllIIIlIIlIIIllIIIIlllI).equals("NeverLose")) {
                    break;
                }
                llllllllllllIIIlIIlIIIllIIIlIIll = llllllllllllIIIlIIlIIIllIIIlIlII.neverlose500_14;
                break;
            }
        }
        return llllllllllllIIIlIIlIIIllIIIlIIll;
    }
    
    public static Color getClientColor(final float llllllllllllIIIlIIlIIIllIIlIIlII, final float llllllllllllIIIlIIlIIIllIIlIIIll, final float llllllllllllIIIlIIlIIIllIIlIlllI, final int llllllllllllIIIlIIlIIIllIIlIIIIl) {
        Color llllllllllllIIIlIIlIIIllIIlIllII = Color.white;
        final Color llllllllllllIIIlIIlIIIllIIlIlIll = new Color(ArreyList.onecolor.getColorValue());
        final Color llllllllllllIIIlIIlIIIllIIlIlIlI = new Color(ArreyList.twocolor.getColorValue());
        final double llllllllllllIIIlIIlIIIllIIlIlIIl = ArreyList.time.getNumberValue();
        final String llllllllllllIIIlIIlIIIllIIlIlIII = ArreyList.arrayColor.getOptions();
        final float llllllllllllIIIlIIlIIIllIIlIIlll = 4.0f;
        int llllllllllllIIIlIIlIIIllIIlIIllI = 0;
        for (int llllllllllllIIIlIIlIIIllIIlIIlIl = 0; llllllllllllIIIlIIlIIIllIIlIIlIl < 30; ++llllllllllllIIIlIIlIIIllIIlIIlIl) {
            llllllllllllIIIlIIlIIIllIIlIIllI += Minecraft.getMinecraft().sfui18.getFontHeight() + 5;
        }
        if (llllllllllllIIIlIIlIIIllIIlIlIII.equalsIgnoreCase("Rainbow")) {
            llllllllllllIIIlIIlIIIllIIlIllII = DrawHelper.rainbowCol(llllllllllllIIIlIIlIIIllIIlIIlII, llllllllllllIIIlIIlIIIllIIlIlllI, 0.5f, (float)llllllllllllIIIlIIlIIIllIIlIIIIl);
        }
        else if (llllllllllllIIIlIIlIIIllIIlIlIII.equalsIgnoreCase("Astolfo")) {
            llllllllllllIIIlIIlIIIllIIlIllII = DrawHelper.astolfoColors45(llllllllllllIIIlIIlIIIllIIlIIIll, llllllllllllIIIlIIlIIIllIIlIlllI, 0.5f, (float)llllllllllllIIIlIIlIIIllIIlIIIIl);
        }
        else if (llllllllllllIIIlIIlIIIllIIlIlIII.equalsIgnoreCase("Pulse")) {
            llllllllllllIIIlIIlIIIllIIlIllII = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0 * (llllllllllllIIIlIIlIIIllIIlIIlII * 2.55) / 60.0);
        }
        else if (llllllllllllIIIlIIlIIIllIIlIlIII.equalsIgnoreCase("Custom")) {
            llllllllllllIIIlIIlIIIllIIlIllII = DrawHelper.TwoColoreffect(new Color(llllllllllllIIIlIIlIIIllIIlIlIll.getRGB()), new Color(llllllllllllIIIlIIlIIIllIIlIlIlI.getRGB()), Math.abs(System.currentTimeMillis() / llllllllllllIIIlIIlIIIllIIlIlIIl) / 100.0 + 3.0 * (llllllllllllIIIlIIlIIIllIIlIIlII * 2.55) / 60.0);
        }
        else if (llllllllllllIIIlIIlIIIllIIlIlIII.equalsIgnoreCase("None")) {
            llllllllllllIIIlIIlIIIllIIlIllII = new Color(255, 255, 255);
        }
        return llllllllllllIIIlIIlIIIllIIlIllII;
    }
    
    public static Color getClientColor(final float llllllllllllIIIlIIlIIIllIlIIIlll, final float llllllllllllIIIlIIlIIIllIlIIIllI, final int llllllllllllIIIlIIlIIIllIlIlIIII) {
        Color llllllllllllIIIlIIlIIIllIlIIllll = Color.white;
        final Color llllllllllllIIIlIIlIIIllIlIIlllI = new Color(ArreyList.onecolor.getColorValue());
        final Color llllllllllllIIIlIIlIIIllIlIIllIl = new Color(ArreyList.twocolor.getColorValue());
        final double llllllllllllIIIlIIlIIIllIlIIllII = ArreyList.time.getNumberValue();
        final String llllllllllllIIIlIIlIIIllIlIIlIll = ArreyList.arrayColor.getOptions();
        final float llllllllllllIIIlIIlIIIllIlIIlIlI = 4.0f;
        int llllllllllllIIIlIIlIIIllIlIIlIIl = 0;
        for (int llllllllllllIIIlIIlIIIllIlIIlIII = 0; llllllllllllIIIlIIlIIIllIlIIlIII < 30; ++llllllllllllIIIlIIlIIIllIlIIlIII) {
            llllllllllllIIIlIIlIIIllIlIIlIIl += Minecraft.getMinecraft().sfui18.getFontHeight() + 5;
        }
        if (llllllllllllIIIlIIlIIIllIlIIlIll.equalsIgnoreCase("Rainbow")) {
            llllllllllllIIIlIIlIIIllIlIIllll = DrawHelper.rainbowCol(llllllllllllIIIlIIlIIIllIlIIIlll, llllllllllllIIIlIIlIIIllIlIIIllI, 0.5f, (float)llllllllllllIIIlIIlIIIllIlIlIIII);
        }
        else if (llllllllllllIIIlIIlIIIllIlIIlIll.equalsIgnoreCase("Astolfo")) {
            llllllllllllIIIlIIlIIIllIlIIllll = DrawHelper.astolfoColors45(llllllllllllIIIlIIlIIIllIlIIIlll, llllllllllllIIIlIIlIIIllIlIIIllI, 0.5f, (float)llllllllllllIIIlIIlIIIllIlIlIIII);
        }
        else if (llllllllllllIIIlIIlIIIllIlIIlIll.equalsIgnoreCase("Pulse")) {
            llllllllllllIIIlIIlIIIllIlIIllll = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0 * (llllllllllllIIIlIIlIIIllIlIIIlll * 2.55) / 60.0);
        }
        else if (llllllllllllIIIlIIlIIIllIlIIlIll.equalsIgnoreCase("Custom")) {
            llllllllllllIIIlIIlIIIllIlIIllll = DrawHelper.TwoColoreffect(new Color(llllllllllllIIIlIIlIIIllIlIIlllI.getRGB()), new Color(llllllllllllIIIlIIlIIIllIlIIllIl.getRGB()), Math.abs(System.currentTimeMillis() / llllllllllllIIIlIIlIIIllIlIIllII) / 100.0 + 3.0 * (llllllllllllIIIlIIlIIIllIlIIIlll * 2.55) / 60.0);
        }
        else if (llllllllllllIIIlIIlIIIllIlIIlIll.equalsIgnoreCase("None")) {
            llllllllllllIIIlIIlIIIllIlIIllll = new Color(255, 255, 255);
        }
        return llllllllllllIIIlIIlIIIllIlIIllll;
    }
    
    public static Color getClientColor() {
        Color llllllllllllIIIlIIlIIIllIllIllIl = Color.white;
        final Color llllllllllllIIIlIIlIIIllIllIllII = new Color(ArreyList.onecolor.getColorValue());
        final Color llllllllllllIIIlIIlIIIllIllIlIll = new Color(ArreyList.twocolor.getColorValue());
        final double llllllllllllIIIlIIlIIIllIllIlIlI = ArreyList.time.getNumberValue();
        final String llllllllllllIIIlIIlIIIllIllIlIIl = ArreyList.arrayColor.getOptions();
        final float llllllllllllIIIlIIlIIIllIllIlIII = 4.0f;
        int llllllllllllIIIlIIlIIIllIllIIlll = 0;
        for (int llllllllllllIIIlIIlIIIllIllIIllI = 0; llllllllllllIIIlIIlIIIllIllIIllI < 30; ++llllllllllllIIIlIIlIIIllIllIIllI) {
            llllllllllllIIIlIIlIIIllIllIIlll += Minecraft.getMinecraft().sfui18.getFontHeight() + 5;
        }
        if (llllllllllllIIIlIIlIIIllIllIlIIl.equalsIgnoreCase("Rainbow")) {
            llllllllllllIIIlIIlIIIllIllIllIl = DrawHelper.rainbow(20, 0.5f, 1.0f);
        }
        else if (llllllllllllIIIlIIlIIIllIllIlIIl.equalsIgnoreCase("Astolfo")) {
            llllllllllllIIIlIIlIIIllIllIllIl = DrawHelper.astolfoColors1((float)(int)llllllllllllIIIlIIlIIIllIllIlIII, (float)llllllllllllIIIlIIlIIIllIllIIlll);
        }
        else if (llllllllllllIIIlIIlIIIllIllIlIIl.equalsIgnoreCase("Pulse")) {
            llllllllllllIIIlIIlIIIllIllIllIl = DrawHelper.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / llllllllllllIIIlIIlIIIllIllIlIlI) / 100.0 + 6.0 * (llllllllllllIIIlIIlIIIllIllIlIII * 2.55) / 60.0);
        }
        else if (llllllllllllIIIlIIlIIIllIllIlIIl.equalsIgnoreCase("Custom")) {
            llllllllllllIIIlIIlIIIllIllIllIl = DrawHelper.TwoColoreffect(new Color(llllllllllllIIIlIIlIIIllIllIllII.getRGB()), new Color(llllllllllllIIIlIIlIIIllIllIlIll.getRGB()), Math.abs(System.currentTimeMillis() / llllllllllllIIIlIIlIIIllIllIlIlI) / 100.0 + 3.0 * (llllllllllllIIIlIIlIIIllIllIlIII * 2.55) / 60.0);
        }
        else if (llllllllllllIIIlIIlIIIllIllIlIIl.equalsIgnoreCase("None")) {
            llllllllllllIIIlIIlIIIllIllIllIl = new Color(255, 255, 255);
        }
        return llllllllllllIIIlIIlIIIllIllIllIl;
    }
}
