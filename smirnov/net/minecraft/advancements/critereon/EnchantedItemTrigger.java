// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class EnchantedItemTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192191_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192192_b;
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIIllllIlIIIlIIIlIlIIl, final Listener<Instance> lllllllllllIIllllIlIIIlIIIlIlIII) {
        final Listeners lllllllllllIIllllIlIIIlIIIlIlIll = this.field_192192_b.get(lllllllllllIIllllIlIIIlIIIlIlIIl);
        if (lllllllllllIIllllIlIIIlIIIlIlIll != null) {
            lllllllllllIIllllIlIIIlIIIlIlIll.func_192457_b(lllllllllllIIllllIlIIIlIIIlIlIII);
            if (lllllllllllIIllllIlIIIlIIIlIlIll.func_192458_a()) {
                this.field_192192_b.remove(lllllllllllIIllllIlIIIlIIIlIlIIl);
            }
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIIllllIlIIIlIIIlIIIll) {
        this.field_192192_b.remove(lllllllllllIIllllIlIIIlIIIlIIIll);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIIllllIlIIIlIIIIlllII, final JsonDeserializationContext lllllllllllIIllllIlIIIlIIIIllIll) {
        final ItemPredicate lllllllllllIIllllIlIIIlIIIIllIlI = ItemPredicate.func_192492_a(lllllllllllIIllllIlIIIlIIIIlllII.get("item"));
        final MinMaxBounds lllllllllllIIllllIlIIIlIIIIllIIl = MinMaxBounds.func_192515_a(lllllllllllIIllllIlIIIlIIIIlllII.get("levels"));
        return new Instance(lllllllllllIIllllIlIIIlIIIIllIlI, lllllllllllIIllllIlIIIlIIIIllIIl);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return EnchantedItemTrigger.field_192191_a;
    }
    
    static {
        field_192191_a = new ResourceLocation("enchanted_item");
    }
    
    public void func_192190_a(final EntityPlayerMP lllllllllllIIllllIlIIIlIIIIIllll, final ItemStack lllllllllllIIllllIlIIIlIIIIIlllI, final int lllllllllllIIllllIlIIIlIIIIIlIII) {
        final Listeners lllllllllllIIllllIlIIIlIIIIIllII = this.field_192192_b.get(lllllllllllIIllllIlIIIlIIIIIllll.func_192039_O());
        if (lllllllllllIIllllIlIIIlIIIIIllII != null) {
            lllllllllllIIllllIlIIIlIIIIIllII.func_192459_a(lllllllllllIIllllIlIIIlIIIIIlllI, lllllllllllIIllllIlIIIlIIIIIlIII);
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIIllllIlIIIlIIIllIlIl, final Listener<Instance> lllllllllllIIllllIlIIIlIIIlllIII) {
        Listeners lllllllllllIIllllIlIIIlIIIllIlll = this.field_192192_b.get(lllllllllllIIllllIlIIIlIIIllIlIl);
        if (lllllllllllIIllllIlIIIlIIIllIlll == null) {
            lllllllllllIIllllIlIIIlIIIllIlll = new Listeners(lllllllllllIIllllIlIIIlIIIllIlIl);
            this.field_192192_b.put(lllllllllllIIllllIlIIIlIIIllIlIl, lllllllllllIIllllIlIIIlIIIllIlll);
        }
        lllllllllllIIllllIlIIIlIIIllIlll.func_192460_a(lllllllllllIIllllIlIIIlIIIlllIII);
    }
    
    public EnchantedItemTrigger() {
        this.field_192192_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_192259_b;
        private final /* synthetic */ ItemPredicate field_192258_a;
        
        public boolean func_192257_a(final ItemStack lllllllllllIllIlIlllllIlIlllIlIl, final int lllllllllllIllIlIlllllIlIlllIIIl) {
            return this.field_192258_a.func_192493_a(lllllllllllIllIlIlllllIlIlllIlIl) && this.field_192259_b.func_192514_a((float)lllllllllllIllIlIlllllIlIlllIIIl);
        }
        
        public Instance(final ItemPredicate lllllllllllIllIlIlllllIlIllllllI, final MinMaxBounds lllllllllllIllIlIlllllIlIllllIlI) {
            super(EnchantedItemTrigger.field_192191_a);
            this.field_192258_a = lllllllllllIllIlIlllllIlIllllllI;
            this.field_192259_b = lllllllllllIllIlIlllllIlIllllIlI;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192461_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192462_b;
        
        public void func_192460_a(final Listener<Instance> llllllllllIlllIIllIllIlIIlIllIlI) {
            this.field_192462_b.add(llllllllllIlllIIllIllIlIIlIllIlI);
        }
        
        public boolean func_192458_a() {
            return this.field_192462_b.isEmpty();
        }
        
        public void func_192457_b(final Listener<Instance> llllllllllIlllIIllIllIlIIlIlIlII) {
            this.field_192462_b.remove(llllllllllIlllIIllIllIlIIlIlIlII);
        }
        
        public Listeners(final PlayerAdvancements llllllllllIlllIIllIllIlIIllIIIIl) {
            this.field_192462_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192461_a = llllllllllIlllIIllIllIlIIllIIIIl;
        }
        
        public void func_192459_a(final ItemStack llllllllllIlllIIllIllIlIIlIIlIlI, final int llllllllllIlllIIllIllIlIIlIIIIll) {
            List<Listener<Instance>> llllllllllIlllIIllIllIlIIlIIlIII = null;
            for (final Listener<Instance> llllllllllIlllIIllIllIlIIlIIIlll : this.field_192462_b) {
                if (llllllllllIlllIIllIllIlIIlIIIlll.func_192158_a().func_192257_a(llllllllllIlllIIllIllIlIIlIIlIlI, llllllllllIlllIIllIllIlIIlIIIIll)) {
                    if (llllllllllIlllIIllIllIlIIlIIlIII == null) {
                        llllllllllIlllIIllIllIlIIlIIlIII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllIlllIIllIllIlIIlIIlIII.add(llllllllllIlllIIllIllIlIIlIIIlll);
                }
            }
            if (llllllllllIlllIIllIllIlIIlIIlIII != null) {
                for (final Listener<Instance> llllllllllIlllIIllIllIlIIlIIIllI : llllllllllIlllIIllIllIlIIlIIlIII) {
                    llllllllllIlllIIllIllIlIIlIIIllI.func_192159_a(this.field_192461_a);
                }
            }
        }
    }
}
