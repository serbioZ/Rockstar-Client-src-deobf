// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
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

public class UsedTotemTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193188_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193189_b;
    
    public void func_193187_a(final EntityPlayerMP llllllllllllIIIIlIllIIllllllIIIl, final ItemStack llllllllllllIIIIlIllIIllllllIIII) {
        final Listeners llllllllllllIIIIlIllIIllllllIIll = this.field_193189_b.get(llllllllllllIIIIlIllIIllllllIIIl.func_192039_O());
        if (llllllllllllIIIIlIllIIllllllIIll != null) {
            llllllllllllIIIIlIllIIllllllIIll.func_193509_a(llllllllllllIIIIlIllIIllllllIIII);
        }
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllIIIIlIllIlIIIIIIllll, final Listener<Instance> llllllllllllIIIIlIllIlIIIIIIlllI) {
        final Listeners llllllllllllIIIIlIllIlIIIIIIllIl = this.field_193189_b.get(llllllllllllIIIIlIllIlIIIIIIllll);
        if (llllllllllllIIIIlIllIlIIIIIIllIl != null) {
            llllllllllllIIIIlIllIlIIIIIIllIl.func_193506_b(llllllllllllIIIIlIllIlIIIIIIlllI);
            if (llllllllllllIIIIlIllIlIIIIIIllIl.func_193507_a()) {
                this.field_193189_b.remove(llllllllllllIIIIlIllIlIIIIIIllll);
            }
        }
    }
    
    static {
        field_193188_a = new ResourceLocation("used_totem");
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllIIIIlIllIlIIIIIIIIll) {
        this.field_193189_b.remove(llllllllllllIIIIlIllIlIIIIIIIIll);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllIIIIlIllIlIIIIIllIll, final Listener<Instance> llllllllllllIIIIlIllIlIIIIIlIllI) {
        Listeners llllllllllllIIIIlIllIlIIIIIllIIl = this.field_193189_b.get(llllllllllllIIIIlIllIlIIIIIllIll);
        if (llllllllllllIIIIlIllIlIIIIIllIIl == null) {
            llllllllllllIIIIlIllIlIIIIIllIIl = new Listeners(llllllllllllIIIIlIllIlIIIIIllIll);
            this.field_193189_b.put(llllllllllllIIIIlIllIlIIIIIllIll, llllllllllllIIIIlIllIlIIIIIllIIl);
        }
        llllllllllllIIIIlIllIlIIIIIllIIl.func_193508_a(llllllllllllIIIIlIllIlIIIIIlIllI);
    }
    
    public UsedTotemTrigger() {
        this.field_193189_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return UsedTotemTrigger.field_193188_a;
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllIIIIlIllIIllllllllll, final JsonDeserializationContext llllllllllllIIIIlIllIIlllllllllI) {
        final ItemPredicate llllllllllllIIIIlIllIIllllllllIl = ItemPredicate.func_192492_a(llllllllllllIIIIlIllIIllllllllll.get("item"));
        return new Instance(llllllllllllIIIIlIllIIllllllllIl);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ ItemPredicate field_193219_a;
        
        public boolean func_193218_a(final ItemStack lllllllllllIIlIIlIllIllIIlIlIllI) {
            return this.field_193219_a.func_192493_a(lllllllllllIIlIIlIllIllIIlIlIllI);
        }
        
        public Instance(final ItemPredicate lllllllllllIIlIIlIllIllIIlIlllII) {
            super(UsedTotemTrigger.field_193188_a);
            this.field_193219_a = lllllllllllIIlIIlIllIllIIlIlllII;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193510_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193511_b;
        
        public void func_193509_a(final ItemStack lllllllllllllllIlIlIlIllllIIIlll) {
            List<Listener<Instance>> lllllllllllllllIlIlIlIllllIIIllI = null;
            for (final Listener<Instance> lllllllllllllllIlIlIlIllllIIIlIl : this.field_193511_b) {
                if (lllllllllllllllIlIlIlIllllIIIlIl.func_192158_a().func_193218_a(lllllllllllllllIlIlIlIllllIIIlll)) {
                    if (lllllllllllllllIlIlIlIllllIIIllI == null) {
                        lllllllllllllllIlIlIlIllllIIIllI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllllIlIlIlIllllIIIllI.add(lllllllllllllllIlIlIlIllllIIIlIl);
                }
            }
            if (lllllllllllllllIlIlIlIllllIIIllI != null) {
                for (final Listener<Instance> lllllllllllllllIlIlIlIllllIIIlII : lllllllllllllllIlIlIlIllllIIIllI) {
                    lllllllllllllllIlIlIlIllllIIIlII.func_192159_a(this.field_193510_a);
                }
            }
        }
        
        public void func_193508_a(final Listener<Instance> lllllllllllllllIlIlIlIllllIlIlII) {
            this.field_193511_b.add(lllllllllllllllIlIlIlIllllIlIlII);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllllIlIlIlIllllIlllIl) {
            this.field_193511_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193510_a = lllllllllllllllIlIlIlIllllIlllIl;
        }
        
        public boolean func_193507_a() {
            return this.field_193511_b.isEmpty();
        }
        
        public void func_193506_b(final Listener<Instance> lllllllllllllllIlIlIlIllllIlIIII) {
            this.field_193511_b.remove(lllllllllllllllIlIlIlIllllIlIIII);
        }
    }
}
