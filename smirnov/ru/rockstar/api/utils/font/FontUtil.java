// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.font;

import net.minecraft.client.Minecraft;
import java.awt.Font;
import net.minecraft.util.ResourceLocation;

public class FontUtil
{
    public static Font getFontFromTTF(final ResourceLocation llllllllllllllIIIIIIllIlllIIIlIl, final float llllllllllllllIIIIIIllIlllIIIlII, final int llllllllllllllIIIIIIllIlllIIIIll) {
        try {
            Font llllllllllllllIIIIIIllIlllIIIIlI = Font.createFont(llllllllllllllIIIIIIllIlllIIIIll, Minecraft.getMinecraft().getResourceManager().getResource(llllllllllllllIIIIIIllIlllIIIlIl).getInputStream());
            llllllllllllllIIIIIIllIlllIIIIlI = llllllllllllllIIIIIIllIlllIIIIlI.deriveFont(llllllllllllllIIIIIIllIlllIIIlII);
            return llllllllllllllIIIIIIllIlllIIIIlI;
        }
        catch (Exception llllllllllllllIIIIIIllIlllIIIIIl) {
            return null;
        }
    }
}
