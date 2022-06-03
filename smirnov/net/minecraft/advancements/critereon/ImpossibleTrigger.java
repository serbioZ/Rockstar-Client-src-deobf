// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class ImpossibleTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192205_a;
    
    static {
        field_192205_a = new ResourceLocation("impossible");
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return ImpossibleTrigger.field_192205_a;
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIIlIIllIlllIIIlIIlIII, final Listener<Instance> lllllllllllIIlIIllIlllIIIlIIIlll) {
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIIlIIllIlllIIIlIIIIll, final JsonDeserializationContext lllllllllllIIlIIllIlllIIIlIIIIlI) {
        return new Instance();
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIIlIIllIlllIIIlIIlIll, final Listener<Instance> lllllllllllIIlIIllIlllIIIlIIlIlI) {
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIIlIIllIlllIIIlIIIlIl) {
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        public Instance() {
            super(ImpossibleTrigger.field_192205_a);
        }
    }
}
