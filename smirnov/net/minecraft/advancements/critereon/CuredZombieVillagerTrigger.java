// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.entity.Entity;
import com.google.common.collect.Maps;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class CuredZombieVillagerTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192187_b;
    private static final /* synthetic */ ResourceLocation field_192186_a;
    
    @Override
    public ResourceLocation func_192163_a() {
        return CuredZombieVillagerTrigger.field_192186_a;
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIIlIIIlIIlIIIIIll, final Listener<Instance> lllllllllllllIlIIlIIIlIIlIIIIIlI) {
        Listeners lllllllllllllIlIIlIIIlIIlIIIIIIl = this.field_192187_b.get(lllllllllllllIlIIlIIIlIIlIIIIIll);
        if (lllllllllllllIlIIlIIIlIIlIIIIIIl == null) {
            lllllllllllllIlIIlIIIlIIlIIIIIIl = new Listeners(lllllllllllllIlIIlIIIlIIlIIIIIll);
            this.field_192187_b.put(lllllllllllllIlIIlIIIlIIlIIIIIll, lllllllllllllIlIIlIIIlIIlIIIIIIl);
        }
        lllllllllllllIlIIlIIIlIIlIIIIIIl.func_192360_a(lllllllllllllIlIIlIIIlIIlIIIIIlI);
    }
    
    static {
        field_192186_a = new ResourceLocation("cured_zombie_villager");
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIIlIIIlIIIllIllIl) {
        this.field_192187_b.remove(lllllllllllllIlIIlIIIlIIIllIllIl);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIIlIIIlIIIllIIllI, final JsonDeserializationContext lllllllllllllIlIIlIIIlIIIllIIlIl) {
        final EntityPredicate lllllllllllllIlIIlIIIlIIIllIIlII = EntityPredicate.func_192481_a(lllllllllllllIlIIlIIIlIIIllIIllI.get("zombie"));
        final EntityPredicate lllllllllllllIlIIlIIIlIIIllIIIll = EntityPredicate.func_192481_a(lllllllllllllIlIIlIIIlIIIllIIllI.get("villager"));
        return new Instance(lllllllllllllIlIIlIIIlIIIllIIlII, lllllllllllllIlIIlIIIlIIIllIIIll);
    }
    
    public void func_192183_a(final EntityPlayerMP lllllllllllllIlIIlIIIlIIIlIllIIl, final EntityZombie lllllllllllllIlIIlIIIlIIIlIlIIll, final EntityVillager lllllllllllllIlIIlIIIlIIIlIlIIlI) {
        final Listeners lllllllllllllIlIIlIIIlIIIlIlIllI = this.field_192187_b.get(lllllllllllllIlIIlIIIlIIIlIllIIl.func_192039_O());
        if (lllllllllllllIlIIlIIIlIIIlIlIllI != null) {
            lllllllllllllIlIIlIIIlIIIlIlIllI.func_192361_a(lllllllllllllIlIIlIIIlIIIlIllIIl, lllllllllllllIlIIlIIIlIIIlIlIIll, lllllllllllllIlIIlIIIlIIIlIlIIlI);
        }
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIIlIIIlIIIlllIIll, final Listener<Instance> lllllllllllllIlIIlIIIlIIIlllIIlI) {
        final Listeners lllllllllllllIlIIlIIIlIIIlllIlIl = this.field_192187_b.get(lllllllllllllIlIIlIIIlIIIlllIIll);
        if (lllllllllllllIlIIlIIIlIIIlllIlIl != null) {
            lllllllllllllIlIIlIIIlIIIlllIlIl.func_192358_b(lllllllllllllIlIIlIIIlIIIlllIIlI);
            if (lllllllllllllIlIIlIIIlIIIlllIlIl.func_192359_a()) {
                this.field_192187_b.remove(lllllllllllllIlIIlIIIlIIIlllIIll);
            }
        }
    }
    
    public CuredZombieVillagerTrigger() {
        this.field_192187_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ EntityPredicate field_192255_a;
        private final /* synthetic */ EntityPredicate field_192256_b;
        
        public Instance(final EntityPredicate llllllllllllIIIllIIIIIIIlIIIIIIl, final EntityPredicate llllllllllllIIIllIIIIIIIlIIIIIII) {
            super(CuredZombieVillagerTrigger.field_192186_a);
            this.field_192255_a = llllllllllllIIIllIIIIIIIlIIIIIIl;
            this.field_192256_b = llllllllllllIIIllIIIIIIIlIIIIIII;
        }
        
        public boolean func_192254_a(final EntityPlayerMP llllllllllllIIIllIIIIIIIIllllIlI, final EntityZombie llllllllllllIIIllIIIIIIIIllllIIl, final EntityVillager llllllllllllIIIllIIIIIIIIlllIlII) {
            return this.field_192255_a.func_192482_a(llllllllllllIIIllIIIIIIIIllllIlI, llllllllllllIIIllIIIIIIIIllllIIl) && this.field_192256_b.func_192482_a(llllllllllllIIIllIIIIIIIIllllIlI, llllllllllllIIIllIIIIIIIIlllIlII);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192363_b;
        private final /* synthetic */ PlayerAdvancements field_192362_a;
        
        public Listeners(final PlayerAdvancements lllllllllllIIllIllIlllllIIlIIlll) {
            this.field_192363_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192362_a = lllllllllllIIllIllIlllllIIlIIlll;
        }
        
        public void func_192360_a(final Listener<Instance> lllllllllllIIllIllIlllllIIIllllI) {
            this.field_192363_b.add(lllllllllllIIllIllIlllllIIIllllI);
        }
        
        public void func_192358_b(final Listener<Instance> lllllllllllIIllIllIlllllIIIlIllI) {
            this.field_192363_b.remove(lllllllllllIIllIllIlllllIIIlIllI);
        }
        
        public void func_192361_a(final EntityPlayerMP lllllllllllIIllIllIlllllIIIIllIl, final EntityZombie lllllllllllIIllIllIlllllIIIIllII, final EntityVillager lllllllllllIIllIllIlllllIIIIlIll) {
            List<Listener<Instance>> lllllllllllIIllIllIlllllIIIIlIlI = null;
            for (final Listener<Instance> lllllllllllIIllIllIlllllIIIIlIIl : this.field_192363_b) {
                if (lllllllllllIIllIllIlllllIIIIlIIl.func_192158_a().func_192254_a(lllllllllllIIllIllIlllllIIIIllIl, lllllllllllIIllIllIlllllIIIIllII, lllllllllllIIllIllIlllllIIIIlIll)) {
                    if (lllllllllllIIllIllIlllllIIIIlIlI == null) {
                        lllllllllllIIllIllIlllllIIIIlIlI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllIIllIllIlllllIIIIlIlI.add(lllllllllllIIllIllIlllllIIIIlIIl);
                }
            }
            if (lllllllllllIIllIllIlllllIIIIlIlI != null) {
                for (final Listener<Instance> lllllllllllIIllIllIlllllIIIIlIII : lllllllllllIIllIllIlllllIIIIlIlI) {
                    lllllllllllIIllIllIlllllIIIIlIII.func_192159_a(this.field_192362_a);
                }
            }
        }
        
        public boolean func_192359_a() {
            return this.field_192363_b.isEmpty();
        }
    }
}
