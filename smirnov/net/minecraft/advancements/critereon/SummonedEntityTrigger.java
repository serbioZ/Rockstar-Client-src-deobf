// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.Set;
import com.google.common.collect.Maps;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class SummonedEntityTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192232_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192233_b;
    
    static {
        field_192232_a = new ResourceLocation("summoned_entity");
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllIllllIlIIIlIIllIlIIIII, final JsonDeserializationContext llllllllllIllllIlIIIlIIllIIlllll) {
        final EntityPredicate llllllllllIllllIlIIIlIIllIIllllI = EntityPredicate.func_192481_a(llllllllllIllllIlIIIlIIllIlIIIII.get("entity"));
        return new Instance(llllllllllIllllIlIIIlIIllIIllllI);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return SummonedEntityTrigger.field_192232_a;
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllIllllIlIIIlIIllIllIIII, final Listener<Instance> llllllllllIllllIlIIIlIIllIlIlIll) {
        final Listeners llllllllllIllllIlIIIlIIllIlIlllI = this.field_192233_b.get(llllllllllIllllIlIIIlIIllIllIIII);
        if (llllllllllIllllIlIIIlIIllIlIlllI != null) {
            llllllllllIllllIlIIIlIIllIlIlllI.func_192531_b(llllllllllIllllIlIIIlIIllIlIlIll);
            if (llllllllllIllllIlIIIlIIllIlIlllI.func_192532_a()) {
                this.field_192233_b.remove(llllllllllIllllIlIIIlIIllIllIIII);
            }
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllIllllIlIIIlIIllIllllII, final Listener<Instance> llllllllllIllllIlIIIlIIllIllIlll) {
        Listeners llllllllllIllllIlIIIlIIllIlllIlI = this.field_192233_b.get(llllllllllIllllIlIIIlIIllIllllII);
        if (llllllllllIllllIlIIIlIIllIlllIlI == null) {
            llllllllllIllllIlIIIlIIllIlllIlI = new Listeners(llllllllllIllllIlIIIlIIllIllllII);
            this.field_192233_b.put(llllllllllIllllIlIIIlIIllIllllII, llllllllllIllllIlIIIlIIllIlllIlI);
        }
        llllllllllIllllIlIIIlIIllIlllIlI.func_192534_a(llllllllllIllllIlIIIlIIllIllIlll);
    }
    
    public void func_192229_a(final EntityPlayerMP llllllllllIllllIlIIIlIIllIIlIIlI, final Entity llllllllllIllllIlIIIlIIllIIlIlIl) {
        final Listeners llllllllllIllllIlIIIlIIllIIlIlII = this.field_192233_b.get(llllllllllIllllIlIIIlIIllIIlIIlI.func_192039_O());
        if (llllllllllIllllIlIIIlIIllIIlIlII != null) {
            llllllllllIllllIlIIIlIIllIIlIlII.func_192533_a(llllllllllIllllIlIIIlIIllIIlIIlI, llllllllllIllllIlIIIlIIllIIlIlIl);
        }
    }
    
    public SummonedEntityTrigger() {
        this.field_192233_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllIllllIlIIIlIIllIlIIlII) {
        this.field_192233_b.remove(llllllllllIllllIlIIIlIIllIlIIlII);
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192535_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192536_b;
        
        public boolean func_192532_a() {
            return this.field_192536_b.isEmpty();
        }
        
        public void func_192533_a(final EntityPlayerMP llllllllllllIIllIIIIIllIlIIIIlIl, final Entity llllllllllllIIllIIIIIllIlIIIIlII) {
            List<Listener<Instance>> llllllllllllIIllIIIIIllIlIIIlIIl = null;
            for (final Listener<Instance> llllllllllllIIllIIIIIllIlIIIlIII : this.field_192536_b) {
                if (llllllllllllIIllIIIIIllIlIIIlIII.func_192158_a().func_192283_a(llllllllllllIIllIIIIIllIlIIIIlIl, llllllllllllIIllIIIIIllIlIIIIlII)) {
                    if (llllllllllllIIllIIIIIllIlIIIlIIl == null) {
                        llllllllllllIIllIIIIIllIlIIIlIIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllIIllIIIIIllIlIIIlIIl.add(llllllllllllIIllIIIIIllIlIIIlIII);
                }
            }
            if (llllllllllllIIllIIIIIllIlIIIlIIl != null) {
                for (final Listener<Instance> llllllllllllIIllIIIIIllIlIIIIlll : llllllllllllIIllIIIIIllIlIIIlIIl) {
                    llllllllllllIIllIIIIIllIlIIIIlll.func_192159_a(this.field_192535_a);
                }
            }
        }
        
        public void func_192531_b(final Listener<Instance> llllllllllllIIllIIIIIllIlIIlIIll) {
            this.field_192536_b.remove(llllllllllllIIllIIIIIllIlIIlIIll);
        }
        
        public Listeners(final PlayerAdvancements llllllllllllIIllIIIIIllIlIlIIIlI) {
            this.field_192536_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192535_a = llllllllllllIIllIIIIIllIlIlIIIlI;
        }
        
        public void func_192534_a(final Listener<Instance> llllllllllllIIllIIIIIllIlIIllIll) {
            this.field_192536_b.add(llllllllllllIIllIIIIIllIlIIllIll);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ EntityPredicate field_192284_a;
        
        public boolean func_192283_a(final EntityPlayerMP llllllllllIlllIIIllIIlIIllIIIIlI, final Entity llllllllllIlllIIIllIIlIIllIIIIIl) {
            return this.field_192284_a.func_192482_a(llllllllllIlllIIIllIIlIIllIIIIlI, llllllllllIlllIIIllIIlIIllIIIIIl);
        }
        
        public Instance(final EntityPredicate llllllllllIlllIIIllIIlIIllIIllII) {
            super(SummonedEntityTrigger.field_192232_a);
            this.field_192284_a = llllllllllIlllIIIllIIlIIllIIllII;
        }
    }
}
