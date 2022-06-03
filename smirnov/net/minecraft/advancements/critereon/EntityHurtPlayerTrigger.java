// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.Set;
import com.google.common.collect.Maps;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class EntityHurtPlayerTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192201_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192202_b;
    
    static {
        field_192201_a = new ResourceLocation("entity_hurt_player");
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIIlllIlllIIIIllIl, final Listener<Instance> lllllllllllllIlIIlllIlllIIIlIIII) {
        Listeners lllllllllllllIlIIlllIlllIIIIllll = this.field_192202_b.get(lllllllllllllIlIIlllIlllIIIIllIl);
        if (lllllllllllllIlIIlllIlllIIIIllll == null) {
            lllllllllllllIlIIlllIlllIIIIllll = new Listeners(lllllllllllllIlIIlllIlllIIIIllIl);
            this.field_192202_b.put(lllllllllllllIlIIlllIlllIIIIllIl, lllllllllllllIlIIlllIlllIIIIllll);
        }
        lllllllllllllIlIIlllIlllIIIIllll.func_192477_a(lllllllllllllIlIIlllIlllIIIlIIII);
    }
    
    public void func_192200_a(final EntityPlayerMP lllllllllllllIlIIlllIllIlllIlIII, final DamageSource lllllllllllllIlIIlllIllIlllIIlll, final float lllllllllllllIlIIlllIllIllIlllll, final float lllllllllllllIlIIlllIllIllIllllI, final boolean lllllllllllllIlIIlllIllIllIlllIl) {
        final Listeners lllllllllllllIlIIlllIllIlllIIIll = this.field_192202_b.get(lllllllllllllIlIIlllIllIlllIlIII.func_192039_O());
        if (lllllllllllllIlIIlllIllIlllIIIll != null) {
            lllllllllllllIlIIlllIllIlllIIIll.func_192478_a(lllllllllllllIlIIlllIllIlllIlIII, lllllllllllllIlIIlllIllIlllIIlll, lllllllllllllIlIIlllIllIllIlllll, lllllllllllllIlIIlllIllIllIllllI, lllllllllllllIlIIlllIllIllIlllIl);
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIIlllIllIlllllIIl) {
        this.field_192202_b.remove(lllllllllllllIlIIlllIllIlllllIIl);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIIlllIlllIIIIIlIl, final Listener<Instance> lllllllllllllIlIIlllIlllIIIIIlII) {
        final Listeners lllllllllllllIlIIlllIlllIIIIIIll = this.field_192202_b.get(lllllllllllllIlIIlllIlllIIIIIlIl);
        if (lllllllllllllIlIIlllIlllIIIIIIll != null) {
            lllllllllllllIlIIlllIlllIIIIIIll.func_192475_b(lllllllllllllIlIIlllIlllIIIIIlII);
            if (lllllllllllllIlIIlllIlllIIIIIIll.func_192476_a()) {
                this.field_192202_b.remove(lllllllllllllIlIIlllIlllIIIIIlIl);
            }
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return EntityHurtPlayerTrigger.field_192201_a;
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIIlllIllIllllIlIl, final JsonDeserializationContext lllllllllllllIlIIlllIllIllllIlII) {
        final DamagePredicate lllllllllllllIlIIlllIllIllllIIll = DamagePredicate.func_192364_a(lllllllllllllIlIIlllIllIllllIlIl.get("damage"));
        return new Instance(lllllllllllllIlIIlllIllIllllIIll);
    }
    
    public EntityHurtPlayerTrigger() {
        this.field_192202_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ DamagePredicate field_192264_a;
        
        public Instance(final DamagePredicate llllllllllllIlIlIIIlIllIlIIlIlII) {
            super(EntityHurtPlayerTrigger.field_192201_a);
            this.field_192264_a = llllllllllllIlIlIIIlIllIlIIlIlII;
        }
        
        public boolean func_192263_a(final EntityPlayerMP llllllllllllIlIlIIIlIllIlIIIlIlI, final DamageSource llllllllllllIlIlIIIlIllIlIIIlIIl, final float llllllllllllIlIlIIIlIllIlIIIlIII, final float llllllllllllIlIlIIIlIllIlIIIIIIl, final boolean llllllllllllIlIlIIIlIllIlIIIIllI) {
            return this.field_192264_a.func_192365_a(llllllllllllIlIlIIIlIllIlIIIlIlI, llllllllllllIlIlIIIlIllIlIIIlIIl, llllllllllllIlIlIIIlIllIlIIIlIII, llllllllllllIlIlIIIlIllIlIIIIIIl, llllllllllllIlIlIIIlIllIlIIIIllI);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192480_b;
        private final /* synthetic */ PlayerAdvancements field_192479_a;
        
        public void func_192477_a(final Listener<Instance> llllllllllIlllIlIIlllIllIIIlllII) {
            this.field_192480_b.add(llllllllllIlllIlIIlllIllIIIlllII);
        }
        
        public void func_192478_a(final EntityPlayerMP llllllllllIlllIlIIlllIllIIIIIIlI, final DamageSource llllllllllIlllIlIIlllIllIIIIlIlI, final float llllllllllIlllIlIIlllIllIIIIlIIl, final float llllllllllIlllIlIIlllIlIllllllll, final boolean llllllllllIlllIlIIlllIllIIIIIlll) {
            List<Listener<Instance>> llllllllllIlllIlIIlllIllIIIIIllI = null;
            for (final Listener<Instance> llllllllllIlllIlIIlllIllIIIIIlIl : this.field_192480_b) {
                if (llllllllllIlllIlIIlllIllIIIIIlIl.func_192158_a().func_192263_a(llllllllllIlllIlIIlllIllIIIIIIlI, llllllllllIlllIlIIlllIllIIIIlIlI, llllllllllIlllIlIIlllIllIIIIlIIl, llllllllllIlllIlIIlllIlIllllllll, llllllllllIlllIlIIlllIllIIIIIlll)) {
                    if (llllllllllIlllIlIIlllIllIIIIIllI == null) {
                        llllllllllIlllIlIIlllIllIIIIIllI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllIlllIlIIlllIllIIIIIllI.add(llllllllllIlllIlIIlllIllIIIIIlIl);
                }
            }
            if (llllllllllIlllIlIIlllIllIIIIIllI != null) {
                for (final Listener<Instance> llllllllllIlllIlIIlllIllIIIIIlII : llllllllllIlllIlIIlllIllIIIIIllI) {
                    llllllllllIlllIlIIlllIllIIIIIlII.func_192159_a(this.field_192479_a);
                }
            }
        }
        
        public Listeners(final PlayerAdvancements llllllllllIlllIlIIlllIllIIlIIlll) {
            this.field_192480_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192479_a = llllllllllIlllIlIIlllIllIIlIIlll;
        }
        
        public boolean func_192476_a() {
            return this.field_192480_b.isEmpty();
        }
        
        public void func_192475_b(final Listener<Instance> llllllllllIlllIlIIlllIllIIIlIllI) {
            this.field_192480_b.remove(llllllllllIlllIlIIlllIllIIIlIllI);
        }
    }
}
