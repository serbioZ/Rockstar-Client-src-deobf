// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.stats;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Item;

public class StatCrafting extends StatBase
{
    private final /* synthetic */ Item item;
    
    public Item getItem() {
        return this.item;
    }
    
    public StatCrafting(final String lllllllllllIllIIIlIlllIIIlllIlIl, final String lllllllllllIllIIIlIlllIIIllIllll, final ITextComponent lllllllllllIllIIIlIlllIIIllIlllI, final Item lllllllllllIllIIIlIlllIIIllIllIl) {
        super(String.valueOf(lllllllllllIllIIIlIlllIIIlllIlIl) + lllllllllllIllIIIlIlllIIIllIllll, lllllllllllIllIIIlIlllIIIllIlllI);
        this.item = lllllllllllIllIIIlIlllIIIllIllIl;
    }
}
