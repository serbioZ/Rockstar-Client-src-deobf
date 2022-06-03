// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.Set;
import javax.annotation.Nullable;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.JsonUtils;
import com.google.common.collect.Maps;
import net.minecraft.potion.PotionType;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class BrewedPotionTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192177_b;
    private static final /* synthetic */ ResourceLocation field_192176_a;
    
    public void func_192173_a(final EntityPlayerMP lllllllllllIlIllllIIlllIlllIIIlI, final PotionType lllllllllllIlIllllIIlllIlllIIlIl) {
        final Listeners lllllllllllIlIllllIIlllIlllIIlII = this.field_192177_b.get(lllllllllllIlIllllIIlllIlllIIIlI.func_192039_O());
        if (lllllllllllIlIllllIIlllIlllIIlII != null) {
            lllllllllllIlIllllIIlllIlllIIlII.func_192348_a(lllllllllllIlIllllIIlllIlllIIlIl);
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return BrewedPotionTrigger.field_192176_a;
    }
    
    public BrewedPotionTrigger() {
        this.field_192177_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIlIllllIIllllIIIIIIll, final Listener<Instance> lllllllllllIlIllllIIlllIlllllllI) {
        final Listeners lllllllllllIlIllllIIllllIIIIIIIl = this.field_192177_b.get(lllllllllllIlIllllIIllllIIIIIIll);
        if (lllllllllllIlIllllIIllllIIIIIIIl != null) {
            lllllllllllIlIllllIIllllIIIIIIIl.func_192346_b(lllllllllllIlIllllIIlllIlllllllI);
            if (lllllllllllIlIllllIIllllIIIIIIIl.func_192347_a()) {
                this.field_192177_b.remove(lllllllllllIlIllllIIllllIIIIIIll);
            }
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIlIllllIIllllIIIIllll, final Listener<Instance> lllllllllllIlIllllIIllllIIIIlllI) {
        Listeners lllllllllllIlIllllIIllllIIIIllIl = this.field_192177_b.get(lllllllllllIlIllllIIllllIIIIllll);
        if (lllllllllllIlIllllIIllllIIIIllIl == null) {
            lllllllllllIlIllllIIllllIIIIllIl = new Listeners(lllllllllllIlIllllIIllllIIIIllll);
            this.field_192177_b.put(lllllllllllIlIllllIIllllIIIIllll, lllllllllllIlIllllIIllllIIIIllIl);
        }
        lllllllllllIlIllllIIllllIIIIllIl.func_192349_a(lllllllllllIlIllllIIllllIIIIlllI);
    }
    
    static {
        field_192176_a = new ResourceLocation("brewed_potion");
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIlIllllIIlllIlllIlllI, final JsonDeserializationContext lllllllllllIlIllllIIlllIllllIIIl) {
        PotionType lllllllllllIlIllllIIlllIllllIIII = null;
        if (lllllllllllIlIllllIIlllIlllIlllI.has("potion")) {
            final ResourceLocation lllllllllllIlIllllIIlllIlllIllll = new ResourceLocation(JsonUtils.getString(lllllllllllIlIllllIIlllIlllIlllI, "potion"));
            if (!PotionType.REGISTRY.containsKey(lllllllllllIlIllllIIlllIlllIllll)) {
                throw new JsonSyntaxException("Unknown potion '" + lllllllllllIlIllllIIlllIlllIllll + "'");
            }
            lllllllllllIlIllllIIlllIllllIIII = PotionType.REGISTRY.getObject(lllllllllllIlIllllIIlllIlllIllll);
        }
        return new Instance(lllllllllllIlIllllIIlllIllllIIII);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIlIllllIIlllIllllIlll) {
        this.field_192177_b.remove(lllllllllllIlIllllIIlllIllllIlll);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ PotionType field_192251_a;
        
        public Instance(@Nullable final PotionType llllllllllllIIllIllIIIlllIIlllIl) {
            super(BrewedPotionTrigger.field_192176_a);
            this.field_192251_a = llllllllllllIIllIllIIIlllIIlllIl;
        }
        
        public boolean func_192250_a(final PotionType llllllllllllIIllIllIIIlllIIlIlll) {
            return this.field_192251_a == null || this.field_192251_a == llllllllllllIIllIllIIIlllIIlIlll;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192351_b;
        private final /* synthetic */ PlayerAdvancements field_192350_a;
        
        public void func_192349_a(final Listener<Instance> llllllllllIllllIIlIIIIlllIIlIIll) {
            this.field_192351_b.add(llllllllllIllllIIlIIIIlllIIlIIll);
        }
        
        public boolean func_192347_a() {
            return this.field_192351_b.isEmpty();
        }
        
        public void func_192348_a(final PotionType llllllllllIllllIIlIIIIlllIIIIlII) {
            List<Listener<Instance>> llllllllllIllllIIlIIIIlllIIIIIll = null;
            for (final Listener<Instance> llllllllllIllllIIlIIIIlllIIIIIlI : this.field_192351_b) {
                if (llllllllllIllllIIlIIIIlllIIIIIlI.func_192158_a().func_192250_a(llllllllllIllllIIlIIIIlllIIIIlII)) {
                    if (llllllllllIllllIIlIIIIlllIIIIIll == null) {
                        llllllllllIllllIIlIIIIlllIIIIIll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllIllllIIlIIIIlllIIIIIll.add(llllllllllIllllIIlIIIIlllIIIIIlI);
                }
            }
            if (llllllllllIllllIIlIIIIlllIIIIIll != null) {
                for (final Listener<Instance> llllllllllIllllIIlIIIIlllIIIIIIl : llllllllllIllllIIlIIIIlllIIIIIll) {
                    llllllllllIllllIIlIIIIlllIIIIIIl.func_192159_a(this.field_192350_a);
                }
            }
        }
        
        public Listeners(final PlayerAdvancements llllllllllIllllIIlIIIIlllIIllIlI) {
            this.field_192351_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192350_a = llllllllllIllllIIlIIIIlllIIllIlI;
        }
        
        public void func_192346_b(final Listener<Instance> llllllllllIllllIIlIIIIlllIIIllIl) {
            this.field_192351_b.remove(llllllllllIllllIIlIIIIlllIIIllIl);
        }
    }
}
