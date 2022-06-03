// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.entity.Entity;
import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.Set;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.common.collect.Maps;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class TameAnimalTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193179_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193180_b;
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIllIllIIlllIllIlIlI, final Listener<Instance> lllllllllllllIllIllIIlllIllIllIl) {
        final Listeners lllllllllllllIllIllIIlllIllIllII = this.field_193180_b.get(lllllllllllllIllIllIIlllIllIlIlI);
        if (lllllllllllllIllIllIIlllIllIllII != null) {
            lllllllllllllIllIllIIlllIllIllII.func_193494_b(lllllllllllllIllIllIIlllIllIllIl);
            if (lllllllllllllIllIllIIlllIllIllII.func_193495_a()) {
                this.field_193180_b.remove(lllllllllllllIllIllIIlllIllIlIlI);
            }
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return TameAnimalTrigger.field_193179_a;
    }
    
    public TameAnimalTrigger() {
        this.field_193180_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    static {
        field_193179_a = new ResourceLocation("tame_animal");
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIllIllIIlllIlIllllI, final JsonDeserializationContext lllllllllllllIllIllIIlllIlIlllIl) {
        final EntityPredicate lllllllllllllIllIllIIlllIlIlllII = EntityPredicate.func_192481_a(lllllllllllllIllIllIIlllIlIllllI.get("entity"));
        return new Instance(lllllllllllllIllIllIIlllIlIlllII);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIllIllIIlllIllIIIlI) {
        this.field_193180_b.remove(lllllllllllllIllIllIIlllIllIIIlI);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIllIllIIlllIllllIlI, final Listener<Instance> lllllllllllllIllIllIIlllIlllIlIl) {
        Listeners lllllllllllllIllIllIIlllIllllIII = this.field_193180_b.get(lllllllllllllIllIllIIlllIllllIlI);
        if (lllllllllllllIllIllIIlllIllllIII == null) {
            lllllllllllllIllIllIIlllIllllIII = new Listeners(lllllllllllllIllIllIIlllIllllIlI);
            this.field_193180_b.put(lllllllllllllIllIllIIlllIllllIlI, lllllllllllllIllIllIIlllIllllIII);
        }
        lllllllllllllIllIllIIlllIllllIII.func_193496_a(lllllllllllllIllIllIIlllIlllIlIl);
    }
    
    public void func_193178_a(final EntityPlayerMP lllllllllllllIllIllIIlllIlIlIlII, final EntityAnimal lllllllllllllIllIllIIlllIlIlIIll) {
        final Listeners lllllllllllllIllIllIIlllIlIlIIlI = this.field_193180_b.get(lllllllllllllIllIllIIlllIlIlIlII.func_192039_O());
        if (lllllllllllllIllIllIIlllIlIlIIlI != null) {
            lllllllllllllIllIllIIlllIlIlIIlI.func_193497_a(lllllllllllllIllIllIIlllIlIlIlII, lllllllllllllIllIllIIlllIlIlIIll);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_193499_b;
        private final /* synthetic */ PlayerAdvancements field_193498_a;
        
        public void func_193497_a(final EntityPlayerMP llllllllllIlllllIlIlIIIlIIIlIlIl, final EntityAnimal llllllllllIlllllIlIlIIIlIIIlIlII) {
            List<Listener<Instance>> llllllllllIlllllIlIlIIIlIIIlIIll = null;
            for (final Listener<Instance> llllllllllIlllllIlIlIIIlIIIlIIlI : this.field_193499_b) {
                if (llllllllllIlllllIlIlIIIlIIIlIIlI.func_192158_a().func_193216_a(llllllllllIlllllIlIlIIIlIIIlIlIl, llllllllllIlllllIlIlIIIlIIIlIlII)) {
                    if (llllllllllIlllllIlIlIIIlIIIlIIll == null) {
                        llllllllllIlllllIlIlIIIlIIIlIIll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllIlllllIlIlIIIlIIIlIIll.add(llllllllllIlllllIlIlIIIlIIIlIIlI);
                }
            }
            if (llllllllllIlllllIlIlIIIlIIIlIIll != null) {
                for (final Listener<Instance> llllllllllIlllllIlIlIIIlIIIlIIIl : llllllllllIlllllIlIlIIIlIIIlIIll) {
                    llllllllllIlllllIlIlIIIlIIIlIIIl.func_192159_a(this.field_193498_a);
                }
            }
        }
        
        public void func_193496_a(final Listener<Instance> llllllllllIlllllIlIlIIIlIIlIIlIl) {
            this.field_193499_b.add(llllllllllIlllllIlIlIIIlIIlIIlIl);
        }
        
        public void func_193494_b(final Listener<Instance> llllllllllIlllllIlIlIIIlIIIlllIl) {
            this.field_193499_b.remove(llllllllllIlllllIlIlIIIlIIIlllIl);
        }
        
        public boolean func_193495_a() {
            return this.field_193499_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements llllllllllIlllllIlIlIIIlIIlIlllI) {
            this.field_193499_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193498_a = llllllllllIlllllIlIlIIIlIIlIlllI;
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ EntityPredicate field_193217_a;
        
        public boolean func_193216_a(final EntityPlayerMP llllllllllllIllllIlIlllllIIIIIll, final EntityAnimal llllllllllllIllllIlIlllllIIIIIlI) {
            return this.field_193217_a.func_192482_a(llllllllllllIllllIlIlllllIIIIIll, llllllllllllIllllIlIlllllIIIIIlI);
        }
        
        public Instance(final EntityPredicate llllllllllllIllllIlIlllllIIIlIll) {
            super(TameAnimalTrigger.field_193179_a);
            this.field_193217_a = llllllllllllIllllIlIlllllIIIlIll;
        }
    }
}
