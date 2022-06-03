// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.Iterator;
import net.minecraft.item.ItemStack;
import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.JsonUtils;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.common.collect.Maps;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class InventoryChangeTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192209_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192210_b;
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIlllIllIllIIIIIll) {
        this.field_192210_b.remove(lllllllllllllIlIlllIllIllIIIIIll);
    }
    
    static {
        field_192209_a = new ResourceLocation("inventory_changed");
    }
    
    public InventoryChangeTrigger() {
        this.field_192210_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIlllIllIlIllllIll, final JsonDeserializationContext lllllllllllllIlIlllIllIlIllllIlI) {
        final JsonObject lllllllllllllIlIlllIllIlIllllIIl = JsonUtils.getJsonObject(lllllllllllllIlIlllIllIlIllllIll, "slots", new JsonObject());
        final MinMaxBounds lllllllllllllIlIlllIllIlIllllIII = MinMaxBounds.func_192515_a(lllllllllllllIlIlllIllIlIllllIIl.get("occupied"));
        final MinMaxBounds lllllllllllllIlIlllIllIlIlllIlll = MinMaxBounds.func_192515_a(lllllllllllllIlIlllIllIlIllllIIl.get("full"));
        final MinMaxBounds lllllllllllllIlIlllIllIlIlllIllI = MinMaxBounds.func_192515_a(lllllllllllllIlIlllIllIlIllllIIl.get("empty"));
        final ItemPredicate[] lllllllllllllIlIlllIllIlIlllIlIl = ItemPredicate.func_192494_b(lllllllllllllIlIlllIllIlIllllIll.get("items"));
        return new Instance(lllllllllllllIlIlllIllIlIllllIII, lllllllllllllIlIlllIllIlIlllIlll, lllllllllllllIlIlllIllIlIlllIllI, lllllllllllllIlIlllIllIlIlllIlIl);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return InventoryChangeTrigger.field_192209_a;
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIlllIllIllIIIllll, final Listener<Instance> lllllllllllllIlIlllIllIllIIIlIlI) {
        final Listeners lllllllllllllIlIlllIllIllIIIllIl = this.field_192210_b.get(lllllllllllllIlIlllIllIllIIIllll);
        if (lllllllllllllIlIlllIllIllIIIllIl != null) {
            lllllllllllllIlIlllIllIllIIIllIl.func_192487_b(lllllllllllllIlIlllIllIllIIIlIlI);
            if (lllllllllllllIlIlllIllIllIIIllIl.func_192488_a()) {
                this.field_192210_b.remove(lllllllllllllIlIlllIllIllIIIllll);
            }
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIlllIllIllIIlIlll, final Listener<Instance> lllllllllllllIlIlllIllIllIIllIlI) {
        Listeners lllllllllllllIlIlllIllIllIIllIIl = this.field_192210_b.get(lllllllllllllIlIlllIllIllIIlIlll);
        if (lllllllllllllIlIlllIllIllIIllIIl == null) {
            lllllllllllllIlIlllIllIllIIllIIl = new Listeners(lllllllllllllIlIlllIllIllIIlIlll);
            this.field_192210_b.put(lllllllllllllIlIlllIllIllIIlIlll, lllllllllllllIlIlllIllIllIIllIIl);
        }
        lllllllllllllIlIlllIllIllIIllIIl.func_192489_a(lllllllllllllIlIlllIllIllIIllIlI);
    }
    
    public void func_192208_a(final EntityPlayerMP lllllllllllllIlIlllIllIlIllIIlIl, final InventoryPlayer lllllllllllllIlIlllIllIlIllIIlII) {
        final Listeners lllllllllllllIlIlllIllIlIllIIlll = this.field_192210_b.get(lllllllllllllIlIlllIllIlIllIIlIl.func_192039_O());
        if (lllllllllllllIlIlllIllIlIllIIlll != null) {
            lllllllllllllIlIlllIllIlIllIIlll.func_192486_a(lllllllllllllIlIlllIllIlIllIIlII);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_192266_a;
        private final /* synthetic */ ItemPredicate[] field_192269_d;
        private final /* synthetic */ MinMaxBounds field_192267_b;
        private final /* synthetic */ MinMaxBounds field_192268_c;
        
        public boolean func_192265_a(final InventoryPlayer llllllllllllllIIlIllIIllllIIlIlI) {
            int llllllllllllllIIlIllIIllllIIlIIl = 0;
            int llllllllllllllIIlIllIIllllIIlIII = 0;
            int llllllllllllllIIlIllIIllllIIIlll = 0;
            final List<ItemPredicate> llllllllllllllIIlIllIIllllIIIllI = (List<ItemPredicate>)Lists.newArrayList((Object[])this.field_192269_d);
            for (int llllllllllllllIIlIllIIllllIIIlIl = 0; llllllllllllllIIlIllIIllllIIIlIl < llllllllllllllIIlIllIIllllIIlIlI.getSizeInventory(); ++llllllllllllllIIlIllIIllllIIIlIl) {
                final ItemStack llllllllllllllIIlIllIIllllIIIlII = llllllllllllllIIlIllIIllllIIlIlI.getStackInSlot(llllllllllllllIIlIllIIllllIIIlIl);
                if (llllllllllllllIIlIllIIllllIIIlII.func_190926_b()) {
                    ++llllllllllllllIIlIllIIllllIIlIII;
                }
                else {
                    ++llllllllllllllIIlIllIIllllIIIlll;
                    if (llllllllllllllIIlIllIIllllIIIlII.func_190916_E() >= llllllllllllllIIlIllIIllllIIIlII.getMaxStackSize()) {
                        ++llllllllllllllIIlIllIIllllIIlIIl;
                    }
                    final Iterator<ItemPredicate> llllllllllllllIIlIllIIllllIIIIll = llllllllllllllIIlIllIIllllIIIllI.iterator();
                    while (llllllllllllllIIlIllIIllllIIIIll.hasNext()) {
                        final ItemPredicate llllllllllllllIIlIllIIllllIIIIlI = llllllllllllllIIlIllIIllllIIIIll.next();
                        if (llllllllllllllIIlIllIIllllIIIIlI.func_192493_a(llllllllllllllIIlIllIIllllIIIlII)) {
                            llllllllllllllIIlIllIIllllIIIIll.remove();
                        }
                    }
                }
            }
            return this.field_192267_b.func_192514_a((float)llllllllllllllIIlIllIIllllIIlIIl) && this.field_192268_c.func_192514_a((float)llllllllllllllIIlIllIIllllIIlIII) && this.field_192266_a.func_192514_a((float)llllllllllllllIIlIllIIllllIIIlll) && llllllllllllllIIlIllIIllllIIIllI.isEmpty();
        }
        
        public Instance(final MinMaxBounds llllllllllllllIIlIllIIllllIllllI, final MinMaxBounds llllllllllllllIIlIllIIllllIllIII, final MinMaxBounds llllllllllllllIIlIllIIllllIlIlll, final ItemPredicate[] llllllllllllllIIlIllIIllllIllIll) {
            super(InventoryChangeTrigger.field_192209_a);
            this.field_192266_a = llllllllllllllIIlIllIIllllIllllI;
            this.field_192267_b = llllllllllllllIIlIllIIllllIllIII;
            this.field_192268_c = llllllllllllllIIlIllIIllllIlIlll;
            this.field_192269_d = llllllllllllllIIlIllIIllllIllIll;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192491_b;
        private final /* synthetic */ PlayerAdvancements field_192490_a;
        
        public void func_192486_a(final InventoryPlayer lllllllllllIIIIlIllIllIIlllIIllI) {
            List<Listener<Instance>> lllllllllllIIIIlIllIllIIlllIIlIl = null;
            for (final Listener<Instance> lllllllllllIIIIlIllIllIIlllIIlII : this.field_192491_b) {
                if (lllllllllllIIIIlIllIllIIlllIIlII.func_192158_a().func_192265_a(lllllllllllIIIIlIllIllIIlllIIllI)) {
                    if (lllllllllllIIIIlIllIllIIlllIIlIl == null) {
                        lllllllllllIIIIlIllIllIIlllIIlIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllIIIIlIllIllIIlllIIlIl.add(lllllllllllIIIIlIllIllIIlllIIlII);
                }
            }
            if (lllllllllllIIIIlIllIllIIlllIIlIl != null) {
                for (final Listener<Instance> lllllllllllIIIIlIllIllIIlllIIIll : lllllllllllIIIIlIllIllIIlllIIlIl) {
                    lllllllllllIIIIlIllIllIIlllIIIll.func_192159_a(this.field_192490_a);
                }
            }
        }
        
        public void func_192487_b(final Listener<Instance> lllllllllllIIIIlIllIllIIlllIllIl) {
            this.field_192491_b.remove(lllllllllllIIIIlIllIllIIlllIllIl);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllIIIIlIllIllIIlllllllI) {
            this.field_192491_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192490_a = lllllllllllIIIIlIllIllIIlllllllI;
        }
        
        public void func_192489_a(final Listener<Instance> lllllllllllIIIIlIllIllIIllllIIll) {
            this.field_192491_b.add(lllllllllllIIIIlIllIllIIllllIIll);
        }
        
        public boolean func_192488_a() {
            return this.field_192491_b.isEmpty();
        }
    }
}
