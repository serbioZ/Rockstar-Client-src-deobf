// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.Set;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Maps;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class ConsumeItemTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193150_b;
    private static final /* synthetic */ ResourceLocation field_193149_a;
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllIIIlllIIIlIlIIIlIlIl) {
        this.field_193150_b.remove(llllllllllllIIIlllIIIlIlIIIlIlIl);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllIIIlllIIIlIlIIIlllll, final Listener<Instance> llllllllllllIIIlllIIIlIlIIIllllI) {
        final Listeners llllllllllllIIIlllIIIlIlIIIlllIl = this.field_193150_b.get(llllllllllllIIIlllIIIlIlIIIlllll);
        if (llllllllllllIIIlllIIIlIlIIIlllIl != null) {
            llllllllllllIIIlllIIIlIlIIIlllIl.func_193237_b(llllllllllllIIIlllIIIlIlIIIllllI);
            if (llllllllllllIIIlllIIIlIlIIIlllIl.func_193238_a()) {
                this.field_193150_b.remove(llllllllllllIIIlllIIIlIlIIIlllll);
            }
        }
    }
    
    static {
        field_193149_a = new ResourceLocation("consume_item");
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return ConsumeItemTrigger.field_193149_a;
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllIIIlllIIIlIlIIlIlIll, final Listener<Instance> llllllllllllIIIlllIIIlIlIIlIlIlI) {
        Listeners llllllllllllIIIlllIIIlIlIIlIlIIl = this.field_193150_b.get(llllllllllllIIIlllIIIlIlIIlIlIll);
        if (llllllllllllIIIlllIIIlIlIIlIlIIl == null) {
            llllllllllllIIIlllIIIlIlIIlIlIIl = new Listeners(llllllllllllIIIlllIIIlIlIIlIlIll);
            this.field_193150_b.put(llllllllllllIIIlllIIIlIlIIlIlIll, llllllllllllIIIlllIIIlIlIIlIlIIl);
        }
        llllllllllllIIIlllIIIlIlIIlIlIIl.func_193239_a(llllllllllllIIIlllIIIlIlIIlIlIlI);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllIIIlllIIIlIlIIIIllll, final JsonDeserializationContext llllllllllllIIIlllIIIlIlIIIIlllI) {
        final ItemPredicate llllllllllllIIIlllIIIlIlIIIIllIl = ItemPredicate.func_192492_a(llllllllllllIIIlllIIIlIlIIIIllll.get("item"));
        return new Instance(llllllllllllIIIlllIIIlIlIIIIllIl);
    }
    
    public ConsumeItemTrigger() {
        this.field_193150_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public void func_193148_a(final EntityPlayerMP llllllllllllIIIlllIIIlIlIIIIIlIl, final ItemStack llllllllllllIIIlllIIIlIlIIIIIIII) {
        final Listeners llllllllllllIIIlllIIIlIlIIIIIIll = this.field_193150_b.get(llllllllllllIIIlllIIIlIlIIIIIlIl.func_192039_O());
        if (llllllllllllIIIlllIIIlIlIIIIIIll != null) {
            llllllllllllIIIlllIIIlIlIIIIIIll.func_193240_a(llllllllllllIIIlllIIIlIlIIIIIIII);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_193242_b;
        private final /* synthetic */ PlayerAdvancements field_193241_a;
        
        public void func_193240_a(final ItemStack lllllllllllllIIlIIlIIllIIlllIllI) {
            List<Listener<Instance>> lllllllllllllIIlIIlIIllIIllllIlI = null;
            for (final Listener<Instance> lllllllllllllIIlIIlIIllIIllllIIl : this.field_193242_b) {
                if (lllllllllllllIIlIIlIIllIIllllIIl.func_192158_a().func_193193_a(lllllllllllllIIlIIlIIllIIlllIllI)) {
                    if (lllllllllllllIIlIIlIIllIIllllIlI == null) {
                        lllllllllllllIIlIIlIIllIIllllIlI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIlIIlIIllIIllllIlI.add(lllllllllllllIIlIIlIIllIIllllIIl);
                }
            }
            if (lllllllllllllIIlIIlIIllIIllllIlI != null) {
                for (final Listener<Instance> lllllllllllllIIlIIlIIllIIllllIII : lllllllllllllIIlIIlIIllIIllllIlI) {
                    lllllllllllllIIlIIlIIllIIllllIII.func_192159_a(this.field_193241_a);
                }
            }
        }
        
        public void func_193237_b(final Listener<Instance> lllllllllllllIIlIIlIIllIlIIIIlII) {
            this.field_193242_b.remove(lllllllllllllIIlIIlIIllIlIIIIlII);
        }
        
        public boolean func_193238_a() {
            return this.field_193242_b.isEmpty();
        }
        
        public void func_193239_a(final Listener<Instance> lllllllllllllIIlIIlIIllIlIIIlIII) {
            this.field_193242_b.add(lllllllllllllIIlIIlIIllIlIIIlIII);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIlIIlIIllIlIIlIIll) {
            this.field_193242_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193241_a = lllllllllllllIIlIIlIIllIlIIlIIll;
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ ItemPredicate field_193194_a;
        
        public Instance(final ItemPredicate lllllllllllIIIIlIIllllIIIIIIIlII) {
            super(ConsumeItemTrigger.field_193149_a);
            this.field_193194_a = lllllllllllIIIIlIIllllIIIIIIIlII;
        }
        
        public boolean func_193193_a(final ItemStack lllllllllllIIIIlIIlllIlllllllllI) {
            return this.field_193194_a.func_192493_a(lllllllllllIIIIlIIlllIlllllllllI);
        }
    }
}
