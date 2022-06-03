// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.toasts;

import net.minecraft.init.SoundEvents;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;

public interface IToast
{
    public static final /* synthetic */ Object field_193655_b = new Object();
    
    default Object func_193652_b() {
        return IToast.field_193655_b;
    }
    
    Visibility func_193653_a(final GuiToast p0, final long p1);
    
    public enum Visibility
    {
        HIDE("HIDE", 1, SoundEvents.field_194227_ie);
        
        private final /* synthetic */ SoundEvent field_194170_c;
        
        SHOW("SHOW", 0, SoundEvents.field_194226_id);
        
        public void func_194169_a(final SoundHandler llllllllllIllllIlIIIllIlIllIIlll) {
            llllllllllIllllIlIIIllIlIllIIlll.playSound(PositionedSoundRecord.func_194007_a(this.field_194170_c, 1.0f, 1.0f));
        }
        
        private Visibility(final String llllllllllIllllIlIIIllIlIllIllIl, final int llllllllllIllllIlIIIllIlIllIllII, final SoundEvent llllllllllIllllIlIIIllIlIllIlIll) {
            this.field_194170_c = llllllllllIllllIlIIIllIlIllIlIll;
        }
    }
}
