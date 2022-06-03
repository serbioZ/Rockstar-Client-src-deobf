// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.Set;
import net.minecraft.entity.EntityLivingBase;
import com.google.common.collect.Maps;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class EffectsChangedTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193155_b;
    private static final /* synthetic */ ResourceLocation field_193154_a;
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllIllIllIIIllIIlIlIIII, final Listener<Instance> llllllllllllIllIllIIIllIIlIlIIll) {
        final Listeners llllllllllllIllIllIIIllIIlIlIIlI = this.field_193155_b.get(llllllllllllIllIllIIIllIIlIlIIII);
        if (llllllllllllIllIllIIIllIIlIlIIlI != null) {
            llllllllllllIllIllIIIllIIlIlIIlI.func_193429_b(llllllllllllIllIllIIIllIIlIlIIll);
            if (llllllllllllIllIllIIIllIIlIlIIlI.func_193430_a()) {
                this.field_193155_b.remove(llllllllllllIllIllIIIllIIlIlIIII);
            }
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllIllIllIIIllIIlIIlIlI) {
        this.field_193155_b.remove(llllllllllllIllIllIIIllIIlIIlIlI);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllIllIllIIIllIIllIIIII, final Listener<Instance> llllllllllllIllIllIIIllIIlIlllll) {
        Listeners llllllllllllIllIllIIIllIIlIllllI = this.field_193155_b.get(llllllllllllIllIllIIIllIIllIIIII);
        if (llllllllllllIllIllIIIllIIlIllllI == null) {
            llllllllllllIllIllIIIllIIlIllllI = new Listeners(llllllllllllIllIllIIIllIIllIIIII);
            this.field_193155_b.put(llllllllllllIllIllIIIllIIllIIIII, llllllllllllIllIllIIIllIIlIllllI);
        }
        llllllllllllIllIllIIIllIIlIllllI.func_193431_a(llllllllllllIllIllIIIllIIlIlllll);
    }
    
    public void func_193153_a(final EntityPlayerMP llllllllllllIllIllIIIllIIIlllIII) {
        final Listeners llllllllllllIllIllIIIllIIIlllIlI = this.field_193155_b.get(llllllllllllIllIllIIIllIIIlllIII.func_192039_O());
        if (llllllllllllIllIllIIIllIIIlllIlI != null) {
            llllllllllllIllIllIIIllIIIlllIlI.func_193432_a(llllllllllllIllIllIIIllIIIlllIII);
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return EffectsChangedTrigger.field_193154_a;
    }
    
    static {
        field_193154_a = new ResourceLocation("effects_changed");
    }
    
    public EffectsChangedTrigger() {
        this.field_193155_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllIllIllIIIllIIlIIIlII, final JsonDeserializationContext llllllllllllIllIllIIIllIIlIIIIll) {
        final MobEffectsPredicate llllllllllllIllIllIIIllIIlIIIIlI = MobEffectsPredicate.func_193471_a(llllllllllllIllIllIIIllIIlIIIlII.get("effects"));
        return new Instance(llllllllllllIllIllIIIllIIlIIIIlI);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MobEffectsPredicate field_193196_a;
        
        public boolean func_193195_a(final EntityPlayerMP lllllllllllllIllllIIIIIIlIIIlIll) {
            return this.field_193196_a.func_193472_a(lllllllllllllIllllIIIIIIlIIIlIll);
        }
        
        public Instance(final MobEffectsPredicate lllllllllllllIllllIIIIIIlIIlIIIl) {
            super(EffectsChangedTrigger.field_193154_a);
            this.field_193196_a = lllllllllllllIllllIIIIIIlIIlIIIl;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_193434_b;
        private final /* synthetic */ PlayerAdvancements field_193433_a;
        
        public void func_193432_a(final EntityPlayerMP llllllllllllIIlIllllllIIIllIIIll) {
            List<Listener<Instance>> llllllllllllIIlIllllllIIIllIIIlI = null;
            for (final Listener<Instance> llllllllllllIIlIllllllIIIllIIIIl : this.field_193434_b) {
                if (llllllllllllIIlIllllllIIIllIIIIl.func_192158_a().func_193195_a(llllllllllllIIlIllllllIIIllIIIll)) {
                    if (llllllllllllIIlIllllllIIIllIIIlI == null) {
                        llllllllllllIIlIllllllIIIllIIIlI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllIIlIllllllIIIllIIIlI.add(llllllllllllIIlIllllllIIIllIIIIl);
                }
            }
            if (llllllllllllIIlIllllllIIIllIIIlI != null) {
                for (final Listener<Instance> llllllllllllIIlIllllllIIIllIIIII : llllllllllllIIlIllllllIIIllIIIlI) {
                    llllllllllllIIlIllllllIIIllIIIII.func_192159_a(this.field_193433_a);
                }
            }
        }
        
        public void func_193431_a(final Listener<Instance> llllllllllllIIlIllllllIIIlllIIlI) {
            this.field_193434_b.add(llllllllllllIIlIllllllIIIlllIIlI);
        }
        
        public boolean func_193430_a() {
            return this.field_193434_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements llllllllllllIIlIllllllIIIllllIll) {
            this.field_193434_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193433_a = llllllllllllIIlIllllllIIIllllIll;
        }
        
        public void func_193429_b(final Listener<Instance> llllllllllllIIlIllllllIIIllIllII) {
            this.field_193434_b.remove(llllllllllllIIlIllllllIIIllIllII);
        }
    }
}
