// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.text.ITextComponent;

public class ChatLine
{
    private final /* synthetic */ int updateCounterCreated;
    private final /* synthetic */ ITextComponent lineString;
    private final /* synthetic */ int chatLineID;
    
    public ChatLine(final int lllllllllllIlIlIllIIlIIIIlIlIlIl, final ITextComponent lllllllllllIlIlIllIIlIIIIlIlIIII, final int lllllllllllIlIlIllIIlIIIIlIlIIll) {
        this.lineString = lllllllllllIlIlIllIIlIIIIlIlIIII;
        this.updateCounterCreated = lllllllllllIlIlIllIIlIIIIlIlIlIl;
        this.chatLineID = lllllllllllIlIlIllIIlIIIIlIlIIll;
    }
    
    public int getChatLineID() {
        return this.chatLineID;
    }
    
    public ITextComponent getChatComponent() {
        return this.lineString;
    }
    
    public int getUpdatedCounter() {
        return this.updateCounterCreated;
    }
}
