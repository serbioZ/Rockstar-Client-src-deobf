// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;

public class EntityDamageSourceIndirect extends EntityDamageSource
{
    private final /* synthetic */ Entity indirectEntity;
    
    @Nullable
    @Override
    public Entity getEntity() {
        return this.indirectEntity;
    }
    
    public EntityDamageSourceIndirect(final String llllllllllllIIIllIIIIIllIlIIlIII, final Entity llllllllllllIIIllIIIIIllIlIIIlll, @Nullable final Entity llllllllllllIIIllIIIIIllIlIIlIlI) {
        super(llllllllllllIIIllIIIIIllIlIIlIII, llllllllllllIIIllIIIIIllIlIIIlll);
        this.indirectEntity = llllllllllllIIIllIIIIIllIlIIlIlI;
    }
    
    @Override
    public ITextComponent getDeathMessage(final EntityLivingBase llllllllllllIIIllIIIIIllIIlllIII) {
        final ITextComponent llllllllllllIIIllIIIIIllIIllIlll = (this.indirectEntity == null) ? this.damageSourceEntity.getDisplayName() : this.indirectEntity.getDisplayName();
        final ItemStack llllllllllllIIIllIIIIIllIIllIllI = (this.indirectEntity instanceof EntityLivingBase) ? ((EntityLivingBase)this.indirectEntity).getHeldItemMainhand() : ItemStack.field_190927_a;
        final String llllllllllllIIIllIIIIIllIIllIlIl = "death.attack." + this.damageType;
        final String llllllllllllIIIllIIIIIllIIllIlII = String.valueOf(llllllllllllIIIllIIIIIllIIllIlIl) + ".item";
        return (!llllllllllllIIIllIIIIIllIIllIllI.func_190926_b() && llllllllllllIIIllIIIIIllIIllIllI.hasDisplayName() && I18n.canTranslate(llllllllllllIIIllIIIIIllIIllIlII)) ? new TextComponentTranslation(llllllllllllIIIllIIIIIllIIllIlII, new Object[] { llllllllllllIIIllIIIIIllIIlllIII.getDisplayName(), llllllllllllIIIllIIIIIllIIllIlll, llllllllllllIIIllIIIIIllIIllIllI.getTextComponent() }) : new TextComponentTranslation(llllllllllllIIIllIIIIIllIIllIlIl, new Object[] { llllllllllllIIIllIIIIIllIIlllIII.getDisplayName(), llllllllllllIIIllIIIIIllIIllIlll });
    }
    
    @Nullable
    @Override
    public Entity getSourceOfDamage() {
        return this.damageSourceEntity;
    }
}
