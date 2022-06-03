// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.potion;

import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.EntityLivingBase;

public class PotionHealthBoost extends Potion
{
    @Override
    public void removeAttributesModifiersFromEntity(final EntityLivingBase lllllllllllllIllllIlllIIIIIlllIl, final AbstractAttributeMap lllllllllllllIllllIlllIIIIlIIIII, final int lllllllllllllIllllIlllIIIIIllIll) {
        super.removeAttributesModifiersFromEntity(lllllllllllllIllllIlllIIIIIlllIl, lllllllllllllIllllIlllIIIIlIIIII, lllllllllllllIllllIlllIIIIIllIll);
        if (lllllllllllllIllllIlllIIIIIlllIl.getHealth() > lllllllllllllIllllIlllIIIIIlllIl.getMaxHealth()) {
            lllllllllllllIllllIlllIIIIIlllIl.setHealth(lllllllllllllIllllIlllIIIIIlllIl.getMaxHealth());
        }
    }
    
    public PotionHealthBoost(final boolean lllllllllllllIllllIlllIIIIlIlIII, final int lllllllllllllIllllIlllIIIIlIlIlI) {
        super(lllllllllllllIllllIlllIIIIlIlIII, lllllllllllllIllllIlllIIIIlIlIlI);
    }
}
