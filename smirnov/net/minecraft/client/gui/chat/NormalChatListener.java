// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.chat;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.client.Minecraft;

public class NormalChatListener implements IChatListener
{
    private final /* synthetic */ Minecraft field_192581_a;
    
    public NormalChatListener(final Minecraft lllllllllllIllIllIllIlIIIlllllIl) {
        this.field_192581_a = lllllllllllIllIllIllIlIIIlllllIl;
    }
    
    @Override
    public void func_192576_a(final ChatType lllllllllllIllIllIllIlIIIlllIlll, final ITextComponent lllllllllllIllIllIllIlIIIlllIlII) {
        this.field_192581_a.ingameGUI.getChatGUI().printChatMessage(lllllllllllIllIllIllIlIIIlllIlII);
    }
}
