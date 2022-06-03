// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.potion;

import net.minecraft.entity.ai.attributes.AttributeModifier;

public class PotionAttackDamage extends Potion
{
    protected final /* synthetic */ double bonusPerLevel;
    
    @Override
    public double getAttributeModifierAmount(final int llllllllllIlllIIllllIllIIllIllIl, final AttributeModifier llllllllllIlllIIllllIllIIllIllll) {
        return this.bonusPerLevel * (llllllllllIlllIIllllIllIIllIllIl + 1);
    }
    
    protected PotionAttackDamage(final boolean llllllllllIlllIIllllIllIIlllIllI, final int llllllllllIlllIIllllIllIIlllIlIl, final double llllllllllIlllIIllllIllIIllllIII) {
        super(llllllllllIlllIIllllIllIIlllIllI, llllllllllIlllIIllllIllIIlllIlIl);
        this.bonusPerLevel = llllllllllIlllIIllllIllIIllllIII;
    }
}
