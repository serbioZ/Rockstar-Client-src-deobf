// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.chat;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.client.Minecraft;

public class OverlayChatListener implements IChatListener
{
    private final /* synthetic */ Minecraft field_192577_a;
    
    @Override
    public void func_192576_a(final ChatType lllllllllllIlIllIlllIlIlIllIlIIl, final ITextComponent lllllllllllIlIllIlllIlIlIllIIllI) {
        this.field_192577_a.ingameGUI.setRecordPlaying(lllllllllllIlIllIlllIlIlIllIIllI, false);
    }
    
    public OverlayChatListener(final Minecraft lllllllllllIlIllIlllIlIlIllIllIl) {
        this.field_192577_a = lllllllllllIlIllIlllIlIlIllIllIl;
    }
}
