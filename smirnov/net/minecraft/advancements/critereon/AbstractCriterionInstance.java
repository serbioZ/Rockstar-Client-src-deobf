// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionInstance;

public class AbstractCriterionInstance implements ICriterionInstance
{
    private final /* synthetic */ ResourceLocation field_192245_a;
    
    @Override
    public ResourceLocation func_192244_a() {
        return this.field_192245_a;
    }
    
    @Override
    public String toString() {
        return "AbstractCriterionInstance{criterion=" + this.field_192245_a + '}';
    }
    
    public AbstractCriterionInstance(final ResourceLocation lllllllllllIlIIllIIIllIIlllIIllI) {
        this.field_192245_a = lllllllllllIlIIllIIIllIIlllIIllI;
    }
}
