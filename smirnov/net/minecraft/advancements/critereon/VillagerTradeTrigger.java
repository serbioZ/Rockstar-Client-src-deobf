// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class VillagerTradeTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192238_b;
    private static final /* synthetic */ ResourceLocation field_192237_a;
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIIlllIlIIIIlIlllIIIIl, final Listener<Instance> lllllllllllIIlllIlIIIIlIllIlllII) {
        Listeners lllllllllllIIlllIlIIIIlIllIlllll = this.field_192238_b.get(lllllllllllIIlllIlIIIIlIlllIIIIl);
        if (lllllllllllIIlllIlIIIIlIllIlllll == null) {
            lllllllllllIIlllIlIIIIlIllIlllll = new Listeners(lllllllllllIIlllIlIIIIlIlllIIIIl);
            this.field_192238_b.put(lllllllllllIIlllIlIIIIlIlllIIIIl, lllllllllllIIlllIlIIIIlIllIlllll);
        }
        lllllllllllIIlllIlIIIIlIllIlllll.func_192540_a(lllllllllllIIlllIlIIIIlIllIlllII);
    }
    
    public void func_192234_a(final EntityPlayerMP lllllllllllIIlllIlIIIIlIlIllIlll, final EntityVillager lllllllllllIIlllIlIIIIlIlIllIllI, final ItemStack lllllllllllIIlllIlIIIIlIlIllIlIl) {
        final Listeners lllllllllllIIlllIlIIIIlIlIllIlII = this.field_192238_b.get(lllllllllllIIlllIlIIIIlIlIllIlll.func_192039_O());
        if (lllllllllllIIlllIlIIIIlIlIllIlII != null) {
            lllllllllllIIlllIlIIIIlIlIllIlII.func_192537_a(lllllllllllIIlllIlIIIIlIlIllIlll, lllllllllllIIlllIlIIIIlIlIllIllI, lllllllllllIIlllIlIIIIlIlIllIlIl);
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return VillagerTradeTrigger.field_192237_a;
    }
    
    public VillagerTradeTrigger() {
        this.field_192238_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    static {
        field_192237_a = new ResourceLocation("villager_trade");
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIIlllIlIIIIlIllIIlIIl) {
        this.field_192238_b.remove(lllllllllllIIlllIlIIIIlIllIIlIIl);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIIlllIlIIIIlIllIIIlII, final JsonDeserializationContext lllllllllllIIlllIlIIIIlIllIIIIll) {
        final EntityPredicate lllllllllllIIlllIlIIIIlIllIIIIlI = EntityPredicate.func_192481_a(lllllllllllIIlllIlIIIIlIllIIIlII.get("villager"));
        final ItemPredicate lllllllllllIIlllIlIIIIlIllIIIIIl = ItemPredicate.func_192492_a(lllllllllllIIlllIlIIIIlIllIIIlII.get("item"));
        return new Instance(lllllllllllIIlllIlIIIIlIllIIIIlI, lllllllllllIIlllIlIIIIlIllIIIIIl);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIIlllIlIIIIlIllIlIlIl, final Listener<Instance> lllllllllllIIlllIlIIIIlIllIlIIII) {
        final Listeners lllllllllllIIlllIlIIIIlIllIlIIll = this.field_192238_b.get(lllllllllllIIlllIlIIIIlIllIlIlIl);
        if (lllllllllllIIlllIlIIIIlIllIlIIll != null) {
            lllllllllllIIlllIlIIIIlIllIlIIll.func_192538_b(lllllllllllIIlllIlIIIIlIllIlIIII);
            if (lllllllllllIIlllIlIIIIlIllIlIIll.func_192539_a()) {
                this.field_192238_b.remove(lllllllllllIIlllIlIIIIlIllIlIlIl);
            }
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ ItemPredicate field_192287_b;
        private final /* synthetic */ EntityPredicate field_192286_a;
        
        public Instance(final EntityPredicate lllllllllllIlllIIllIIIlIIlllIlII, final ItemPredicate lllllllllllIlllIIllIIIlIIlllIIll) {
            super(VillagerTradeTrigger.field_192237_a);
            this.field_192286_a = lllllllllllIlllIIllIIIlIIlllIlII;
            this.field_192287_b = lllllllllllIlllIIllIIIlIIlllIIll;
        }
        
        public boolean func_192285_a(final EntityPlayerMP lllllllllllIlllIIllIIIlIIllIllIl, final EntityVillager lllllllllllIlllIIllIIIlIIllIlIII, final ItemStack lllllllllllIlllIIllIIIlIIllIlIll) {
            return this.field_192286_a.func_192482_a(lllllllllllIlllIIllIIIlIIllIllIl, lllllllllllIlllIIllIIIlIIllIlIII) && this.field_192287_b.func_192493_a(lllllllllllIlllIIllIIIlIIllIlIll);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192542_b;
        private final /* synthetic */ PlayerAdvancements field_192541_a;
        
        public Listeners(final PlayerAdvancements lllllllllllIIIlIIIlIIIllIllIllll) {
            this.field_192542_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192541_a = lllllllllllIIIlIIIlIIIllIllIllll;
        }
        
        public boolean func_192539_a() {
            return this.field_192542_b.isEmpty();
        }
        
        public void func_192540_a(final Listener<Instance> lllllllllllIIIlIIIlIIIllIllIIlII) {
            this.field_192542_b.add(lllllllllllIIIlIIIlIIIllIllIIlII);
        }
        
        public void func_192538_b(final Listener<Instance> lllllllllllIIIlIIIlIIIllIlIllllI) {
            this.field_192542_b.remove(lllllllllllIIIlIIIlIIIllIlIllllI);
        }
        
        public void func_192537_a(final EntityPlayerMP lllllllllllIIIlIIIlIIIllIlIlIlIl, final EntityVillager lllllllllllIIIlIIIlIIIllIlIIllIl, final ItemStack lllllllllllIIIlIIIlIIIllIlIIllII) {
            List<Listener<Instance>> lllllllllllIIIlIIIlIIIllIlIlIIlI = null;
            for (final Listener<Instance> lllllllllllIIIlIIIlIIIllIlIlIIIl : this.field_192542_b) {
                if (lllllllllllIIIlIIIlIIIllIlIlIIIl.func_192158_a().func_192285_a(lllllllllllIIIlIIIlIIIllIlIlIlIl, lllllllllllIIIlIIIlIIIllIlIIllIl, lllllllllllIIIlIIIlIIIllIlIIllII)) {
                    if (lllllllllllIIIlIIIlIIIllIlIlIIlI == null) {
                        lllllllllllIIIlIIIlIIIllIlIlIIlI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllIIIlIIIlIIIllIlIlIIlI.add(lllllllllllIIIlIIIlIIIllIlIlIIIl);
                }
            }
            if (lllllllllllIIIlIIIlIIIllIlIlIIlI != null) {
                for (final Listener<Instance> lllllllllllIIIlIIIlIIIllIlIlIIII : lllllllllllIIIlIIIlIIIllIlIlIIlI) {
                    lllllllllllIIIlIIIlIIIllIlIlIIII.func_192159_a(this.field_192541_a);
                }
            }
        }
    }
}
