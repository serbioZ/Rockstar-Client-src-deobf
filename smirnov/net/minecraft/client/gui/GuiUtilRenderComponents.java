// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import net.minecraft.util.text.TextComponentString;
import java.util.List;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.Minecraft;

public class GuiUtilRenderComponents
{
    public static String removeTextColorsIfConfigured(final String llllllllllllIllllIIIIIlIllllIIll, final boolean llllllllllllIllllIIIIIlIllllIIlI) {
        return (!llllllllllllIllllIIIIIlIllllIIlI && !Minecraft.getMinecraft().gameSettings.chatColours) ? TextFormatting.getTextWithoutFormattingCodes(llllllllllllIllllIIIIIlIllllIIll) : llllllllllllIllllIIIIIlIllllIIll;
    }
    
    public static List<ITextComponent> splitText(final ITextComponent llllllllllllIllllIIIIIlIllIllIlI, final int llllllllllllIllllIIIIIlIllIIIIIl, final FontRenderer llllllllllllIllllIIIIIlIllIllIII, final boolean llllllllllllIllllIIIIIlIllIlIlll, final boolean llllllllllllIllllIIIIIlIlIlllllI) {
        int llllllllllllIllllIIIIIlIllIlIlIl = 0;
        ITextComponent llllllllllllIllllIIIIIlIllIlIlII = new TextComponentString("");
        final List<ITextComponent> llllllllllllIllllIIIIIlIllIlIIll = (List<ITextComponent>)Lists.newArrayList();
        final List<ITextComponent> llllllllllllIllllIIIIIlIllIlIIlI = (List<ITextComponent>)Lists.newArrayList((Iterable)llllllllllllIllllIIIIIlIllIllIlI);
        for (int llllllllllllIllllIIIIIlIllIlIIIl = 0; llllllllllllIllllIIIIIlIllIlIIIl < llllllllllllIllllIIIIIlIllIlIIlI.size(); ++llllllllllllIllllIIIIIlIllIlIIIl) {
            final ITextComponent llllllllllllIllllIIIIIlIllIlIIII = llllllllllllIllllIIIIIlIllIlIIlI.get(llllllllllllIllllIIIIIlIllIlIIIl);
            String llllllllllllIllllIIIIIlIllIIllll = llllllllllllIllllIIIIIlIllIlIIII.getUnformattedComponentText();
            boolean llllllllllllIllllIIIIIlIllIIlllI = false;
            if (llllllllllllIllllIIIIIlIllIIllll.contains("\n")) {
                final int llllllllllllIllllIIIIIlIllIIllIl = llllllllllllIllllIIIIIlIllIIllll.indexOf(10);
                final String llllllllllllIllllIIIIIlIllIIllII = llllllllllllIllllIIIIIlIllIIllll.substring(llllllllllllIllllIIIIIlIllIIllIl + 1);
                llllllllllllIllllIIIIIlIllIIllll = llllllllllllIllllIIIIIlIllIIllll.substring(0, llllllllllllIllllIIIIIlIllIIllIl + 1);
                final ITextComponent llllllllllllIllllIIIIIlIllIIlIll = new TextComponentString(llllllllllllIllllIIIIIlIllIIllII);
                llllllllllllIllllIIIIIlIllIIlIll.setStyle(llllllllllllIllllIIIIIlIllIlIIII.getStyle().createShallowCopy());
                llllllllllllIllllIIIIIlIllIlIIlI.add(llllllllllllIllllIIIIIlIllIlIIIl + 1, llllllllllllIllllIIIIIlIllIIlIll);
                llllllllllllIllllIIIIIlIllIIlllI = true;
            }
            final String llllllllllllIllllIIIIIlIllIIlIlI = removeTextColorsIfConfigured(String.valueOf(llllllllllllIllllIIIIIlIllIlIIII.getStyle().getFormattingCode()) + llllllllllllIllllIIIIIlIllIIllll, llllllllllllIllllIIIIIlIlIlllllI);
            final String llllllllllllIllllIIIIIlIllIIlIIl = llllllllllllIllllIIIIIlIllIIlIlI.endsWith("\n") ? llllllllllllIllllIIIIIlIllIIlIlI.substring(0, llllllllllllIllllIIIIIlIllIIlIlI.length() - 1) : llllllllllllIllllIIIIIlIllIIlIlI;
            int llllllllllllIllllIIIIIlIllIIlIII = llllllllllllIllllIIIIIlIllIllIII.getStringWidth(llllllllllllIllllIIIIIlIllIIlIIl);
            TextComponentString llllllllllllIllllIIIIIlIllIIIlll = new TextComponentString(llllllllllllIllllIIIIIlIllIIlIIl);
            llllllllllllIllllIIIIIlIllIIIlll.setStyle(llllllllllllIllllIIIIIlIllIlIIII.getStyle().createShallowCopy());
            if (llllllllllllIllllIIIIIlIllIlIlIl + llllllllllllIllllIIIIIlIllIIlIII > llllllllllllIllllIIIIIlIllIIIIIl) {
                String llllllllllllIllllIIIIIlIllIIIllI = llllllllllllIllllIIIIIlIllIllIII.trimStringToWidth(llllllllllllIllllIIIIIlIllIIlIlI, llllllllllllIllllIIIIIlIllIIIIIl - llllllllllllIllllIIIIIlIllIlIlIl, false);
                String llllllllllllIllllIIIIIlIllIIIlIl = (llllllllllllIllllIIIIIlIllIIIllI.length() < llllllllllllIllllIIIIIlIllIIlIlI.length()) ? llllllllllllIllllIIIIIlIllIIlIlI.substring(llllllllllllIllllIIIIIlIllIIIllI.length()) : null;
                if (llllllllllllIllllIIIIIlIllIIIlIl != null && !llllllllllllIllllIIIIIlIllIIIlIl.isEmpty()) {
                    int llllllllllllIllllIIIIIlIllIIIlII = llllllllllllIllllIIIIIlIllIIIllI.lastIndexOf(32);
                    if (llllllllllllIllllIIIIIlIllIIIlII >= 0 && llllllllllllIllllIIIIIlIllIllIII.getStringWidth(llllllllllllIllllIIIIIlIllIIlIlI.substring(0, llllllllllllIllllIIIIIlIllIIIlII)) > 0) {
                        llllllllllllIllllIIIIIlIllIIIllI = llllllllllllIllllIIIIIlIllIIlIlI.substring(0, llllllllllllIllllIIIIIlIllIIIlII);
                        if (llllllllllllIllllIIIIIlIllIlIlll) {
                            ++llllllllllllIllllIIIIIlIllIIIlII;
                        }
                        llllllllllllIllllIIIIIlIllIIIlIl = llllllllllllIllllIIIIIlIllIIlIlI.substring(llllllllllllIllllIIIIIlIllIIIlII);
                    }
                    else if (llllllllllllIllllIIIIIlIllIlIlIl > 0 && !llllllllllllIllllIIIIIlIllIIlIlI.contains(" ")) {
                        llllllllllllIllllIIIIIlIllIIIllI = "";
                        llllllllllllIllllIIIIIlIllIIIlIl = llllllllllllIllllIIIIIlIllIIlIlI;
                    }
                    final TextComponentString llllllllllllIllllIIIIIlIllIIIIll = new TextComponentString(llllllllllllIllllIIIIIlIllIIIlIl);
                    llllllllllllIllllIIIIIlIllIIIIll.setStyle(llllllllllllIllllIIIIIlIllIlIIII.getStyle().createShallowCopy());
                    llllllllllllIllllIIIIIlIllIlIIlI.add(llllllllllllIllllIIIIIlIllIlIIIl + 1, llllllllllllIllllIIIIIlIllIIIIll);
                }
                llllllllllllIllllIIIIIlIllIIlIII = llllllllllllIllllIIIIIlIllIllIII.getStringWidth(llllllllllllIllllIIIIIlIllIIIllI);
                llllllllllllIllllIIIIIlIllIIIlll = new TextComponentString(llllllllllllIllllIIIIIlIllIIIllI);
                llllllllllllIllllIIIIIlIllIIIlll.setStyle(llllllllllllIllllIIIIIlIllIlIIII.getStyle().createShallowCopy());
                llllllllllllIllllIIIIIlIllIIlllI = true;
            }
            if (llllllllllllIllllIIIIIlIllIlIlIl + llllllllllllIllllIIIIIlIllIIlIII <= llllllllllllIllllIIIIIlIllIIIIIl) {
                llllllllllllIllllIIIIIlIllIlIlIl += llllllllllllIllllIIIIIlIllIIlIII;
                llllllllllllIllllIIIIIlIllIlIlII.appendSibling(llllllllllllIllllIIIIIlIllIIIlll);
            }
            else {
                llllllllllllIllllIIIIIlIllIIlllI = true;
            }
            if (llllllllllllIllllIIIIIlIllIIlllI) {
                llllllllllllIllllIIIIIlIllIlIIll.add(llllllllllllIllllIIIIIlIllIlIlII);
                llllllllllllIllllIIIIIlIllIlIlIl = 0;
                llllllllllllIllllIIIIIlIllIlIlII = new TextComponentString("");
            }
        }
        llllllllllllIllllIIIIIlIllIlIIll.add(llllllllllllIllllIIIIIlIllIlIlII);
        return llllllllllllIllllIIIIIlIllIlIIll;
    }
}
