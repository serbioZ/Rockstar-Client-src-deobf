// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.chat;

import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.client.gui.toasts.SystemToast;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ChatType;
import com.mojang.text2speech.Narrator;

public class NarratorChatListener implements IChatListener
{
    private final /* synthetic */ Narrator field_192580_a;
    
    public boolean func_193640_a() {
        return this.field_192580_a.active();
    }
    
    public NarratorChatListener() {
        this.field_192580_a = Narrator.getNarrator();
    }
    
    @Override
    public void func_192576_a(final ChatType lllllllllllIIllIllIlIIIlllIIlIII, final ITextComponent lllllllllllIIllIllIlIIIlllIIlIll) {
        final int lllllllllllIIllIllIlIIIlllIIlIlI = Minecraft.getMinecraft().gameSettings.field_192571_R;
        if (lllllllllllIIllIllIlIIIlllIIlIlI != 0 && this.field_192580_a.active() && (lllllllllllIIllIllIlIIIlllIIlIlI == 1 || (lllllllllllIIllIllIlIIIlllIIlIlI == 2 && lllllllllllIIllIllIlIIIlllIIlIII == ChatType.CHAT) || (lllllllllllIIllIllIlIIIlllIIlIlI == 3 && lllllllllllIIllIllIlIIIlllIIlIII == ChatType.SYSTEM))) {
            if (lllllllllllIIllIllIlIIIlllIIlIll instanceof TextComponentTranslation && "chat.type.text".equals(((TextComponentTranslation)lllllllllllIIllIllIlIIIlllIIlIll).getKey())) {
                this.field_192580_a.say(new TextComponentTranslation("chat.type.text.narrate", ((TextComponentTranslation)lllllllllllIIllIllIlIIIlllIIlIll).getFormatArgs()).getUnformattedText());
            }
            else {
                this.field_192580_a.say(lllllllllllIIllIllIlIIIlllIIlIll.getUnformattedText());
            }
        }
    }
    
    public void func_193642_b() {
        this.field_192580_a.clear();
    }
    
    public void func_193641_a(final int lllllllllllIIllIllIlIIIllIlllllI) {
        this.field_192580_a.clear();
        this.field_192580_a.say(String.valueOf(new TextComponentTranslation("options.narrator", new Object[0]).getUnformattedText()) + " : " + new TextComponentTranslation(GameSettings.field_193632_b[lllllllllllIIllIllIlIIIllIlllllI], new Object[0]).getUnformattedText());
        final GuiToast lllllllllllIIllIllIlIIIlllIIIIII = Minecraft.getMinecraft().func_193033_an();
        if (this.field_192580_a.active()) {
            if (lllllllllllIIllIllIlIIIllIlllllI == 0) {
                SystemToast.func_193657_a(lllllllllllIIllIllIlIIIlllIIIIII, SystemToast.Type.NARRATOR_TOGGLE, new TextComponentTranslation("narrator.toast.disabled", new Object[0]), null);
            }
            else {
                SystemToast.func_193657_a(lllllllllllIIllIllIlIIIlllIIIIII, SystemToast.Type.NARRATOR_TOGGLE, new TextComponentTranslation("narrator.toast.enabled", new Object[0]), new TextComponentTranslation(GameSettings.field_193632_b[lllllllllllIIllIllIlIIIllIlllllI], new Object[0]));
            }
        }
        else {
            SystemToast.func_193657_a(lllllllllllIIllIllIlIIIlllIIIIII, SystemToast.Type.NARRATOR_TOGGLE, new TextComponentTranslation("narrator.toast.disabled", new Object[0]), new TextComponentTranslation("options.narrator.notavailable", new Object[0]));
        }
    }
    
    static {
        field_193643_a = new NarratorChatListener();
    }
}
