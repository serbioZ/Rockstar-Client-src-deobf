// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.entity.Entity;
import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import com.google.common.collect.Maps;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class BredAnimalsTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192172_b;
    private static final /* synthetic */ ResourceLocation field_192171_a;
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIIIIlIIIlIlllIIllIIlI, final Listener<Instance> lllllllllllIIIIlIIIlIlllIIllIlIl) {
        Listeners lllllllllllIIIIlIIIlIlllIIllIlII = this.field_192172_b.get(lllllllllllIIIIlIIIlIlllIIllIIlI);
        if (lllllllllllIIIIlIIIlIlllIIllIlII == null) {
            lllllllllllIIIIlIIIlIlllIIllIlII = new Listeners(lllllllllllIIIIlIIIlIlllIIllIIlI);
            this.field_192172_b.put(lllllllllllIIIIlIIIlIlllIIllIIlI, lllllllllllIIIIlIIIlIlllIIllIlII);
        }
        lllllllllllIIIIlIIIlIlllIIllIlII.func_192343_a(lllllllllllIIIIlIIIlIlllIIllIlIl);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIIIIlIIIlIlllIIlIlIlI, final Listener<Instance> lllllllllllIIIIlIIIlIlllIIlIlIIl) {
        final Listeners lllllllllllIIIIlIIIlIlllIIlIlIII = this.field_192172_b.get(lllllllllllIIIIlIIIlIlllIIlIlIlI);
        if (lllllllllllIIIIlIIIlIlllIIlIlIII != null) {
            lllllllllllIIIIlIIIlIlllIIlIlIII.func_192340_b(lllllllllllIIIIlIIIlIlllIIlIlIIl);
            if (lllllllllllIIIIlIIIlIlllIIlIlIII.func_192341_a()) {
                this.field_192172_b.remove(lllllllllllIIIIlIIIlIlllIIlIlIlI);
            }
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return BredAnimalsTrigger.field_192171_a;
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIIIIlIIIlIlllIIlIIIII) {
        this.field_192172_b.remove(lllllllllllIIIIlIIIlIlllIIlIIIII);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIIIIlIIIlIlllIIIlIIll, final JsonDeserializationContext lllllllllllIIIIlIIIlIlllIIIlIlll) {
        final EntityPredicate lllllllllllIIIIlIIIlIlllIIIlIllI = EntityPredicate.func_192481_a(lllllllllllIIIIlIIIlIlllIIIlIIll.get("parent"));
        final EntityPredicate lllllllllllIIIIlIIIlIlllIIIlIlIl = EntityPredicate.func_192481_a(lllllllllllIIIIlIIIlIlllIIIlIIll.get("partner"));
        final EntityPredicate lllllllllllIIIIlIIIlIlllIIIlIlII = EntityPredicate.func_192481_a(lllllllllllIIIIlIIIlIlllIIIlIIll.get("child"));
        return new Instance(lllllllllllIIIIlIIIlIlllIIIlIllI, lllllllllllIIIIlIIIlIlllIIIlIlIl, lllllllllllIIIIlIIIlIlllIIIlIlII);
    }
    
    public void func_192168_a(final EntityPlayerMP lllllllllllIIIIlIIIlIlllIIIIlIII, final EntityAnimal lllllllllllIIIIlIIIlIlllIIIIIlll, final EntityAnimal lllllllllllIIIIlIIIlIlllIIIIIIII, final EntityAgeable lllllllllllIIIIlIIIlIlllIIIIIlIl) {
        final Listeners lllllllllllIIIIlIIIlIlllIIIIIlII = this.field_192172_b.get(lllllllllllIIIIlIIIlIlllIIIIlIII.func_192039_O());
        if (lllllllllllIIIIlIIIlIlllIIIIIlII != null) {
            lllllllllllIIIIlIIIlIlllIIIIIlII.func_192342_a(lllllllllllIIIIlIIIlIlllIIIIlIII, lllllllllllIIIIlIIIlIlllIIIIIlll, lllllllllllIIIIlIIIlIlllIIIIIIII, lllllllllllIIIIlIIIlIlllIIIIIlIl);
        }
    }
    
    public BredAnimalsTrigger() {
        this.field_192172_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    static {
        field_192171_a = new ResourceLocation("bred_animals");
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192344_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192345_b;
        
        public void func_192343_a(final Listener<Instance> llllllllllllIIIIlIlIIlIIIlIIIIll) {
            this.field_192345_b.add(llllllllllllIIIIlIlIIlIIIlIIIIll);
        }
        
        public Listeners(final PlayerAdvancements llllllllllllIIIIlIlIIlIIIlIIlllI) {
            this.field_192345_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192344_a = llllllllllllIIIIlIlIIlIIIlIIlllI;
        }
        
        public void func_192340_b(final Listener<Instance> llllllllllllIIIIlIlIIlIIIIllllll) {
            this.field_192345_b.remove(llllllllllllIIIIlIlIIlIIIIllllll);
        }
        
        public boolean func_192341_a() {
            return this.field_192345_b.isEmpty();
        }
        
        public void func_192342_a(final EntityPlayerMP llllllllllllIIIIlIlIIlIIIIllIIll, final EntityAnimal llllllllllllIIIIlIlIIlIIIIlIlIlI, final EntityAnimal llllllllllllIIIIlIlIIlIIIIllIIIl, final EntityAgeable llllllllllllIIIIlIlIIlIIIIllIIII) {
            List<Listener<Instance>> llllllllllllIIIIlIlIIlIIIIlIllll = null;
            for (final Listener<Instance> llllllllllllIIIIlIlIIlIIIIlIlllI : this.field_192345_b) {
                if (llllllllllllIIIIlIlIIlIIIIlIlllI.func_192158_a().func_192246_a(llllllllllllIIIIlIlIIlIIIIllIIll, llllllllllllIIIIlIlIIlIIIIlIlIlI, llllllllllllIIIIlIlIIlIIIIllIIIl, llllllllllllIIIIlIlIIlIIIIllIIII)) {
                    if (llllllllllllIIIIlIlIIlIIIIlIllll == null) {
                        llllllllllllIIIIlIlIIlIIIIlIllll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllIIIIlIlIIlIIIIlIllll.add(llllllllllllIIIIlIlIIlIIIIlIlllI);
                }
            }
            if (llllllllllllIIIIlIlIIlIIIIlIllll != null) {
                for (final Listener<Instance> llllllllllllIIIIlIlIIlIIIIlIllIl : llllllllllllIIIIlIlIIlIIIIlIllll) {
                    llllllllllllIIIIlIlIIlIIIIlIllIl.func_192159_a(this.field_192344_a);
                }
            }
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ EntityPredicate field_192248_b;
        private final /* synthetic */ EntityPredicate field_192247_a;
        private final /* synthetic */ EntityPredicate field_192249_c;
        
        public Instance(final EntityPredicate lllllllllllIIlIIIIlIIIlllllIllII, final EntityPredicate lllllllllllIIlIIIIlIIIlllllIllll, final EntityPredicate lllllllllllIIlIIIIlIIIlllllIlIlI) {
            super(BredAnimalsTrigger.field_192171_a);
            this.field_192247_a = lllllllllllIIlIIIIlIIIlllllIllII;
            this.field_192248_b = lllllllllllIIlIIIIlIIIlllllIllll;
            this.field_192249_c = lllllllllllIIlIIIIlIIIlllllIlIlI;
        }
        
        public boolean func_192246_a(final EntityPlayerMP lllllllllllIIlIIIIlIIIlllllIIIll, final EntityAnimal lllllllllllIIlIIIIlIIIllllIlllIl, final EntityAnimal lllllllllllIIlIIIIlIIIlllllIIIIl, final EntityAgeable lllllllllllIIlIIIIlIIIlllllIIIII) {
            return this.field_192249_c.func_192482_a(lllllllllllIIlIIIIlIIIlllllIIIll, lllllllllllIIlIIIIlIIIlllllIIIII) && ((this.field_192247_a.func_192482_a(lllllllllllIIlIIIIlIIIlllllIIIll, lllllllllllIIlIIIIlIIIllllIlllIl) && this.field_192248_b.func_192482_a(lllllllllllIIlIIIIlIIIlllllIIIll, lllllllllllIIlIIIIlIIIlllllIIIIl)) || (this.field_192247_a.func_192482_a(lllllllllllIIlIIIIlIIIlllllIIIll, lllllllllllIIlIIIIlIIIlllllIIIIl) && this.field_192248_b.func_192482_a(lllllllllllIIlIIIIlIIIlllllIIIll, lllllllllllIIlIIIIlIIIllllIlllIl)));
        }
    }
}
