// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Maps;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class TickTrigger implements ICriterionTrigger<Instance>
{
    public static final /* synthetic */ ResourceLocation field_193183_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193184_b;
    
    @Override
    public ResourceLocation func_192163_a() {
        return TickTrigger.field_193183_a;
    }
    
    static {
        field_193183_a = new ResourceLocation("tick");
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIllIIIlIlIlIIIIIllIIl) {
        this.field_193184_b.remove(lllllllllllIllIIIlIlIlIIIIIllIIl);
    }
    
    public TickTrigger() {
        this.field_193184_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIllIIIlIlIlIIIIlIIIll, final Listener<Instance> lllllllllllIllIIIlIlIlIIIIlIIIlI) {
        final Listeners lllllllllllIllIIIlIlIlIIIIlIIIIl = this.field_193184_b.get(lllllllllllIllIIIlIlIlIIIIlIIIll);
        if (lllllllllllIllIIIlIlIlIIIIlIIIIl != null) {
            lllllllllllIllIIIlIlIlIIIIlIIIIl.func_193500_b(lllllllllllIllIIIlIlIlIIIIlIIIlI);
            if (lllllllllllIllIIIlIlIlIIIIlIIIIl.func_193501_a()) {
                this.field_193184_b.remove(lllllllllllIllIIIlIlIlIIIIlIIIll);
            }
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIllIIIlIlIlIIIIlIlIll, final Listener<Instance> lllllllllllIllIIIlIlIlIIIIlIlllI) {
        Listeners lllllllllllIllIIIlIlIlIIIIlIllIl = this.field_193184_b.get(lllllllllllIllIIIlIlIlIIIIlIlIll);
        if (lllllllllllIllIIIlIlIlIIIIlIllIl == null) {
            lllllllllllIllIIIlIlIlIIIIlIllIl = new Listeners(lllllllllllIllIIIlIlIlIIIIlIlIll);
            this.field_193184_b.put(lllllllllllIllIIIlIlIlIIIIlIlIll, lllllllllllIllIIIlIlIlIIIIlIllIl);
        }
        lllllllllllIllIIIlIlIlIIIIlIllIl.func_193502_a(lllllllllllIllIIIlIlIlIIIIlIlllI);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIllIIIlIlIlIIIIIlIlIl, final JsonDeserializationContext lllllllllllIllIIIlIlIlIIIIIlIlII) {
        return new Instance();
    }
    
    public void func_193182_a(final EntityPlayerMP lllllllllllIllIIIlIlIlIIIIIIllll) {
        final Listeners lllllllllllIllIIIlIlIlIIIIIIlllI = this.field_193184_b.get(lllllllllllIllIIIlIlIlIIIIIIllll.func_192039_O());
        if (lllllllllllIllIIIlIlIlIIIIIIlllI != null) {
            lllllllllllIllIIIlIlIlIIIIIIlllI.func_193503_b();
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        public Instance() {
            super(TickTrigger.field_193183_a);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193504_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193505_b;
        
        public void func_193500_b(final Listener<Instance> lllllllllllIIlIlIIIIlllIIlIlllll) {
            this.field_193505_b.remove(lllllllllllIIlIlIIIIlllIIlIlllll);
        }
        
        public boolean func_193501_a() {
            return this.field_193505_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements lllllllllllIIlIlIIIIlllIIllIlllI) {
            this.field_193505_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193504_a = lllllllllllIIlIlIIIIlllIIllIlllI;
        }
        
        public void func_193502_a(final Listener<Instance> lllllllllllIIlIlIIIIlllIIllIIlIl) {
            this.field_193505_b.add(lllllllllllIIlIlIIIIlllIIllIIlIl);
        }
        
        public void func_193503_b() {
            for (final Listener<Instance> lllllllllllIIlIlIIIIlllIIlIllIII : Lists.newArrayList((Iterable)this.field_193505_b)) {
                lllllllllllIIlIlIIIIlllIIlIllIII.func_192159_a(this.field_193504_a);
            }
        }
    }
}
