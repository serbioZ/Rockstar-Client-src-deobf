// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.enchantment;

import net.minecraft.util.WeightedRandom;

public class EnchantmentData extends WeightedRandom.Item
{
    public final /* synthetic */ int enchantmentLevel;
    public final /* synthetic */ Enchantment enchantmentobj;
    
    public EnchantmentData(final Enchantment llllllllllllIlIlIIlIllllIllllIIl, final int llllllllllllIlIlIIlIllllIllllIll) {
        super(llllllllllllIlIlIIlIllllIllllIIl.getRarity().getWeight());
        this.enchantmentobj = llllllllllllIlIlIIlIllllIllllIIl;
        this.enchantmentLevel = llllllllllllIlIlIIlIllllIllllIll;
    }
}
