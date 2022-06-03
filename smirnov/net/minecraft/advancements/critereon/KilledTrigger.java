// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Maps;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class KilledTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192213_a;
    private final /* synthetic */ ResourceLocation field_192214_b;
    
    public KilledTrigger(final ResourceLocation lllllllllllIIlIIIIllllIIllIlIlll) {
        this.field_192213_a = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
        this.field_192214_b = lllllllllllIIlIIIIllllIIllIlIlll;
    }
    
    public void func_192211_a(final EntityPlayerMP lllllllllllIIlIIIIllllIIlIlIIIll, final Entity lllllllllllIIlIIIIllllIIlIlIIIlI, final DamageSource lllllllllllIIlIIIIllllIIlIlIIIIl) {
        final Listeners lllllllllllIIlIIIIllllIIlIlIIlIl = this.field_192213_a.get(lllllllllllIIlIIIIllllIIlIlIIIll.func_192039_O());
        if (lllllllllllIIlIIIIllllIIlIlIIlIl != null) {
            lllllllllllIIlIIIIllllIIlIlIIlIl.func_192503_a(lllllllllllIIlIIIIllllIIlIlIIIll, lllllllllllIIlIIIIllllIIlIlIIIlI, lllllllllllIIlIIIIllllIIlIlIIIIl);
        }
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIIlIIIIllllIIlIlIllll, final JsonDeserializationContext lllllllllllIIlIIIIllllIIlIllIIIl) {
        return new Instance(this.field_192214_b, EntityPredicate.func_192481_a(lllllllllllIIlIIIIllllIIlIlIllll.get("entity")), DamageSourcePredicate.func_192447_a(lllllllllllIIlIIIIllllIIlIlIllll.get("killing_blow")));
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIIlIIIIllllIIllIIlllI, final Listener<Instance> lllllllllllIIlIIIIllllIIllIIlIIl) {
        Listeners lllllllllllIIlIIIIllllIIllIIllII = this.field_192213_a.get(lllllllllllIIlIIIIllllIIllIIlllI);
        if (lllllllllllIIlIIIIllllIIllIIllII == null) {
            lllllllllllIIlIIIIllllIIllIIllII = new Listeners(lllllllllllIIlIIIIllllIIllIIlllI);
            this.field_192213_a.put(lllllllllllIIlIIIIllllIIllIIlllI, lllllllllllIIlIIIIllllIIllIIllII);
        }
        lllllllllllIIlIIIIllllIIllIIllII.func_192504_a(lllllllllllIIlIIIIllllIIllIIlIIl);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIIlIIIIllllIIlIllIllI) {
        this.field_192213_a.remove(lllllllllllIIlIIIIllllIIlIllIllI);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return this.field_192214_b;
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIIlIIIIllllIIlIlllllI, final Listener<Instance> lllllllllllIIlIIIIllllIIllIIIIIl) {
        final Listeners lllllllllllIIlIIIIllllIIllIIIIII = this.field_192213_a.get(lllllllllllIIlIIIIllllIIlIlllllI);
        if (lllllllllllIIlIIIIllllIIllIIIIII != null) {
            lllllllllllIIlIIIIllllIIllIIIIII.func_192501_b(lllllllllllIIlIIIIllllIIllIIIIIl);
            if (lllllllllllIIlIIIIllllIIllIIIIII.func_192502_a()) {
                this.field_192213_a.remove(lllllllllllIIlIIIIllllIIlIlllllI);
            }
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192506_b;
        private final /* synthetic */ PlayerAdvancements field_192505_a;
        
        public Listeners(final PlayerAdvancements lIIllIlllIllIl) {
            this.field_192506_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192505_a = lIIllIlllIllIl;
        }
        
        public void func_192503_a(final EntityPlayerMP lIIllIllIIllII, final Entity lIIllIllIlIIlI, final DamageSource lIIllIllIlIIIl) {
            List<Listener<Instance>> lIIllIllIlIIII = null;
            for (final Listener<Instance> lIIllIllIIllll : this.field_192506_b) {
                if (lIIllIllIIllll.func_192158_a().func_192270_a(lIIllIllIIllII, lIIllIllIlIIlI, lIIllIllIlIIIl)) {
                    if (lIIllIllIlIIII == null) {
                        lIIllIllIlIIII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lIIllIllIlIIII.add(lIIllIllIIllll);
                }
            }
            if (lIIllIllIlIIII != null) {
                for (final Listener<Instance> lIIllIllIIlllI : lIIllIllIlIIII) {
                    lIIllIllIIlllI.func_192159_a(this.field_192505_a);
                }
            }
        }
        
        public boolean func_192502_a() {
            return this.field_192506_b.isEmpty();
        }
        
        public void func_192504_a(final Listener<Instance> lIIllIlllIIIlI) {
            this.field_192506_b.add(lIIllIlllIIIlI);
        }
        
        public void func_192501_b(final Listener<Instance> lIIllIllIllllI) {
            this.field_192506_b.remove(lIIllIllIllllI);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ DamageSourcePredicate field_192272_b;
        private final /* synthetic */ EntityPredicate field_192271_a;
        
        public Instance(final ResourceLocation llllllllllIllllllllIllIIlIllllIl, final EntityPredicate llllllllllIllllllllIllIIllIIIIII, final DamageSourcePredicate llllllllllIllllllllIllIIlIlllIll) {
            super(llllllllllIllllllllIllIIlIllllIl);
            this.field_192271_a = llllllllllIllllllllIllIIllIIIIII;
            this.field_192272_b = llllllllllIllllllllIllIIlIlllIll;
        }
        
        public boolean func_192270_a(final EntityPlayerMP llllllllllIllllllllIllIIlIllIIIl, final Entity llllllllllIllllllllIllIIlIllIIII, final DamageSource llllllllllIllllllllIllIIlIlIllll) {
            return this.field_192272_b.func_193418_a(llllllllllIllllllllIllIIlIllIIIl, llllllllllIllllllllIllIIlIlIllll) && this.field_192271_a.func_192482_a(llllllllllIllllllllIllIIlIllIIIl, llllllllllIllllllllIllIIlIllIIII);
        }
    }
}
