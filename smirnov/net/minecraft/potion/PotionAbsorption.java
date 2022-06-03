// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.potion;

import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.EntityLivingBase;

public class PotionAbsorption extends Potion
{
    @Override
    public void applyAttributesModifiersToEntity(final EntityLivingBase llllllllllllIlIIllIIlIIlIlIlIlll, final AbstractAttributeMap llllllllllllIlIIllIIlIIlIlIlIllI, final int llllllllllllIlIIllIIlIIlIlIllIIl) {
        llllllllllllIlIIllIIlIIlIlIlIlll.setAbsorptionAmount(llllllllllllIlIIllIIlIIlIlIlIlll.getAbsorptionAmount() + 4 * (llllllllllllIlIIllIIlIIlIlIllIIl + 1));
        super.applyAttributesModifiersToEntity(llllllllllllIlIIllIIlIIlIlIlIlll, llllllllllllIlIIllIIlIIlIlIlIllI, llllllllllllIlIIllIIlIIlIlIllIIl);
    }
    
    @Override
    public void removeAttributesModifiersFromEntity(final EntityLivingBase llllllllllllIlIIllIIlIIlIllIIlll, final AbstractAttributeMap llllllllllllIlIIllIIlIIlIllIIIlI, final int llllllllllllIlIIllIIlIIlIllIIlIl) {
        llllllllllllIlIIllIIlIIlIllIIlll.setAbsorptionAmount(llllllllllllIlIIllIIlIIlIllIIlll.getAbsorptionAmount() - 4 * (llllllllllllIlIIllIIlIIlIllIIlIl + 1));
        super.removeAttributesModifiersFromEntity(llllllllllllIlIIllIIlIIlIllIIlll, llllllllllllIlIIllIIlIIlIllIIIlI, llllllllllllIlIIllIIlIIlIllIIlIl);
    }
    
    protected PotionAbsorption(final boolean llllllllllllIlIIllIIlIIlIllIlllI, final int llllllllllllIlIIllIIlIIlIlllIIII) {
        super(llllllllllllIlIIllIIlIIlIllIlllI, llllllllllllIlIIllIIlIIlIlllIIII);
    }
}
