// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.ITextComponent;

public enum EnumHandSide
{
    LEFT("LEFT", 0, (ITextComponent)new TextComponentTranslation("options.mainHand.left", new Object[0])), 
    RIGHT("RIGHT", 1, (ITextComponent)new TextComponentTranslation("options.mainHand.right", new Object[0]));
    
    private final /* synthetic */ ITextComponent handName;
    
    public EnumHandSide opposite() {
        return (this == EnumHandSide.LEFT) ? EnumHandSide.RIGHT : EnumHandSide.LEFT;
    }
    
    @Override
    public String toString() {
        return this.handName.getUnformattedText();
    }
    
    private EnumHandSide(final String llllllllllIlllIIIlIlllIlIIIlllII, final int llllllllllIlllIIIlIlllIlIIIllIll, final ITextComponent llllllllllIlllIIIlIlllIlIIIllllI) {
        this.handName = llllllllllIlllIIIlIlllIlIIIllllI;
    }
}
