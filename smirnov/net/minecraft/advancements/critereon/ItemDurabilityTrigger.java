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
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Maps;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class ItemDurabilityTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193160_b;
    private static final /* synthetic */ ResourceLocation field_193159_a;
    
    static {
        field_193159_a = new ResourceLocation("item_durability_changed");
    }
    
    public ItemDurabilityTrigger() {
        this.field_193160_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllIIlIIIlIllllIllllIlI, final Listener<Instance> llllllllllllIIlIIIlIllllIllllIIl) {
        final Listeners llllllllllllIIlIIIlIllllIllllIII = this.field_193160_b.get(llllllllllllIIlIIIlIllllIllllIlI);
        if (llllllllllllIIlIIIlIllllIllllIII != null) {
            llllllllllllIIlIIIlIllllIllllIII.func_193438_b(llllllllllllIIlIIIlIllllIllllIIl);
            if (llllllllllllIIlIIIlIllllIllllIII.func_193439_a()) {
                this.field_193160_b.remove(llllllllllllIIlIIIlIllllIllllIlI);
            }
        }
    }
    
    public void func_193158_a(final EntityPlayerMP llllllllllllIIlIIIlIllllIlIlIlII, final ItemStack llllllllllllIIlIIIlIllllIlIlIIll, final int llllllllllllIIlIIIlIllllIlIlIlll) {
        final Listeners llllllllllllIIlIIIlIllllIlIlIllI = this.field_193160_b.get(llllllllllllIIlIIIlIllllIlIlIlII.func_192039_O());
        if (llllllllllllIIlIIIlIllllIlIlIllI != null) {
            llllllllllllIIlIIIlIllllIlIlIllI.func_193441_a(llllllllllllIIlIIIlIllllIlIlIIll, llllllllllllIIlIIIlIllllIlIlIlll);
        }
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllIIlIIIlIllllIllIlIII, final JsonDeserializationContext llllllllllllIIlIIIlIllllIllIIlll) {
        final ItemPredicate llllllllllllIIlIIIlIllllIllIIllI = ItemPredicate.func_192492_a(llllllllllllIIlIIIlIllllIllIlIII.get("item"));
        final MinMaxBounds llllllllllllIIlIIIlIllllIllIIlIl = MinMaxBounds.func_192515_a(llllllllllllIIlIIIlIllllIllIlIII.get("durability"));
        final MinMaxBounds llllllllllllIIlIIIlIllllIllIIlII = MinMaxBounds.func_192515_a(llllllllllllIIlIIIlIllllIllIlIII.get("delta"));
        return new Instance(llllllllllllIIlIIIlIllllIllIIllI, llllllllllllIIlIIIlIllllIllIIlIl, llllllllllllIIlIIIlIllllIllIIlII);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllIIlIIIlIllllIlllIIII) {
        this.field_193160_b.remove(llllllllllllIIlIIIlIllllIlllIIII);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return ItemDurabilityTrigger.field_193159_a;
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllIIlIIIlIlllllIIIIIlI, final Listener<Instance> llllllllllllIIlIIIlIlllllIIIIlIl) {
        Listeners llllllllllllIIlIIIlIlllllIIIIlII = this.field_193160_b.get(llllllllllllIIlIIIlIlllllIIIIIlI);
        if (llllllllllllIIlIIIlIlllllIIIIlII == null) {
            llllllllllllIIlIIIlIlllllIIIIlII = new Listeners(llllllllllllIIlIIIlIlllllIIIIIlI);
            this.field_193160_b.put(llllllllllllIIlIIIlIlllllIIIIIlI, llllllllllllIIlIIIlIlllllIIIIlII);
        }
        llllllllllllIIlIIIlIlllllIIIIlII.func_193440_a(llllllllllllIIlIIIlIlllllIIIIlIl);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ ItemPredicate field_193198_a;
        private final /* synthetic */ MinMaxBounds field_193200_c;
        private final /* synthetic */ MinMaxBounds field_193199_b;
        
        public boolean func_193197_a(final ItemStack lllllllllllIlIllIIlIIIIllIlIIlll, final int lllllllllllIlIllIIlIIIIllIlIIllI) {
            return this.field_193198_a.func_192493_a(lllllllllllIlIllIIlIIIIllIlIIlll) && this.field_193199_b.func_192514_a((float)(lllllllllllIlIllIIlIIIIllIlIIlll.getMaxDamage() - lllllllllllIlIllIIlIIIIllIlIIllI)) && this.field_193200_c.func_192514_a((float)(lllllllllllIlIllIIlIIIIllIlIIlll.getItemDamage() - lllllllllllIlIllIIlIIIIllIlIIllI));
        }
        
        public Instance(final ItemPredicate lllllllllllIlIllIIlIIIIllIllIlIl, final MinMaxBounds lllllllllllIlIllIIlIIIIllIllIIII, final MinMaxBounds lllllllllllIlIllIIlIIIIllIllIIll) {
            super(ItemDurabilityTrigger.field_193159_a);
            this.field_193198_a = lllllllllllIlIllIIlIIIIllIllIlIl;
            this.field_193199_b = lllllllllllIlIllIIlIIIIllIllIIII;
            this.field_193200_c = lllllllllllIlIllIIlIIIIllIllIIll;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193442_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193443_b;
        
        public void func_193440_a(final Listener<Instance> llllllllllllllIlIllIlIIlIIIIllIl) {
            this.field_193443_b.add(llllllllllllllIlIllIlIIlIIIIllIl);
        }
        
        public Listeners(final PlayerAdvancements llllllllllllllIlIllIlIIlIIIlIllI) {
            this.field_193443_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193442_a = llllllllllllllIlIllIlIIlIIIlIllI;
        }
        
        public void func_193441_a(final ItemStack llllllllllllllIlIllIlIIIllllllll, final int llllllllllllllIlIllIlIIIlllllIII) {
            List<Listener<Instance>> llllllllllllllIlIllIlIIIllllllIl = null;
            for (final Listener<Instance> llllllllllllllIlIllIlIIIllllllII : this.field_193443_b) {
                if (llllllllllllllIlIllIlIIIllllllII.func_192158_a().func_193197_a(llllllllllllllIlIllIlIIIllllllll, llllllllllllllIlIllIlIIIlllllIII)) {
                    if (llllllllllllllIlIllIlIIIllllllIl == null) {
                        llllllllllllllIlIllIlIIIllllllIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllllIlIllIlIIIllllllIl.add(llllllllllllllIlIllIlIIIllllllII);
                }
            }
            if (llllllllllllllIlIllIlIIIllllllIl != null) {
                for (final Listener<Instance> llllllllllllllIlIllIlIIIlllllIll : llllllllllllllIlIllIlIIIllllllIl) {
                    llllllllllllllIlIllIlIIIlllllIll.func_192159_a(this.field_193442_a);
                }
            }
        }
        
        public boolean func_193439_a() {
            return this.field_193443_b.isEmpty();
        }
        
        public void func_193438_b(final Listener<Instance> llllllllllllllIlIllIlIIlIIIIlIIl) {
            this.field_193443_b.remove(llllllllllllllIlIllIlIIlIIIIlIIl);
        }
    }
}
