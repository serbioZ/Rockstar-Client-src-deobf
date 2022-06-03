// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.ICriterionInstance;
import com.google.common.collect.Maps;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class PlayerHurtEntityTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192223_b;
    private static final /* synthetic */ ResourceLocation field_192222_a;
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllIlllllIIlIIIIllIIIIIIl) {
        this.field_192223_b.remove(llllllllllIlllllIIlIIIIllIIIIIIl);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllIlllllIIlIIIIlIllllIlI, final JsonDeserializationContext llllllllllIlllllIIlIIIIlIllllIIl) {
        final DamagePredicate llllllllllIlllllIIlIIIIlIllllIII = DamagePredicate.func_192364_a(llllllllllIlllllIIlIIIIlIllllIlI.get("damage"));
        final EntityPredicate llllllllllIlllllIIlIIIIlIlllIlll = EntityPredicate.func_192481_a(llllllllllIlllllIIlIIIIlIllllIlI.get("entity"));
        return new Instance(llllllllllIlllllIIlIIIIlIllllIII, llllllllllIlllllIIlIIIIlIlllIlll);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllIlllllIIlIIIIllIIIIlll, final Listener<Instance> llllllllllIlllllIIlIIIIllIIIIllI) {
        final Listeners llllllllllIlllllIIlIIIIllIIIlIIl = this.field_192223_b.get(llllllllllIlllllIIlIIIIllIIIIlll);
        if (llllllllllIlllllIIlIIIIllIIIlIIl != null) {
            llllllllllIlllllIIlIIIIllIIIlIIl.func_192519_b(llllllllllIlllllIIlIIIIllIIIIllI);
            if (llllllllllIlllllIIlIIIIllIIIlIIl.func_192520_a()) {
                this.field_192223_b.remove(llllllllllIlllllIIlIIIIllIIIIlll);
            }
        }
    }
    
    public PlayerHurtEntityTrigger() {
        this.field_192223_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public void func_192220_a(final EntityPlayerMP llllllllllIlllllIIlIIIIlIllIlIlI, final Entity llllllllllIlllllIIlIIIIlIllIlIIl, final DamageSource llllllllllIlllllIIlIIIIlIllIIIII, final float llllllllllIlllllIIlIIIIlIlIlllll, final float llllllllllIlllllIIlIIIIlIlIllllI, final boolean llllllllllIlllllIIlIIIIlIlIlllIl) {
        final Listeners llllllllllIlllllIIlIIIIlIllIIlII = this.field_192223_b.get(llllllllllIlllllIIlIIIIlIllIlIlI.func_192039_O());
        if (llllllllllIlllllIIlIIIIlIllIIlII != null) {
            llllllllllIlllllIIlIIIIlIllIIlII.func_192521_a(llllllllllIlllllIIlIIIIlIllIlIlI, llllllllllIlllllIIlIIIIlIllIlIIl, llllllllllIlllllIIlIIIIlIllIIIII, llllllllllIlllllIIlIIIIlIlIlllll, llllllllllIlllllIIlIIIIlIlIllllI, llllllllllIlllllIIlIIIIlIlIlllIl);
        }
    }
    
    static {
        field_192222_a = new ResourceLocation("player_hurt_entity");
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllIlllllIIlIIIIllIIlIlll, final Listener<Instance> llllllllllIlllllIIlIIIIllIIlIIlI) {
        Listeners llllllllllIlllllIIlIIIIllIIlIlIl = this.field_192223_b.get(llllllllllIlllllIIlIIIIllIIlIlll);
        if (llllllllllIlllllIIlIIIIllIIlIlIl == null) {
            llllllllllIlllllIIlIIIIllIIlIlIl = new Listeners(llllllllllIlllllIIlIIIIllIIlIlll);
            this.field_192223_b.put(llllllllllIlllllIIlIIIIllIIlIlll, llllllllllIlllllIIlIIIIllIIlIlIl);
        }
        llllllllllIlllllIIlIIIIllIIlIlIl.func_192522_a(llllllllllIlllllIIlIIIIllIIlIIlI);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return PlayerHurtEntityTrigger.field_192222_a;
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192523_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192524_b;
        
        public void func_192519_b(final Listener<Instance> lllllllllllIIlIllllIIllIllllllll) {
            this.field_192524_b.remove(lllllllllllIIlIllllIIllIllllllll);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllIIlIllllIIlllIIIlIIII) {
            this.field_192524_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192523_a = lllllllllllIIlIllllIIlllIIIlIIII;
        }
        
        public boolean func_192520_a() {
            return this.field_192524_b.isEmpty();
        }
        
        public void func_192522_a(final Listener<Instance> lllllllllllIIlIllllIIlllIIIIIlIl) {
            this.field_192524_b.add(lllllllllllIIlIllllIIlllIIIIIlIl);
        }
        
        public void func_192521_a(final EntityPlayerMP lllllllllllIIlIllllIIllIlllIlIIl, final Entity lllllllllllIIlIllllIIllIllllIIlI, final DamageSource lllllllllllIIlIllllIIllIllllIIIl, final float lllllllllllIIlIllllIIllIllllIIII, final float lllllllllllIIlIllllIIllIlllIIlIl, final boolean lllllllllllIIlIllllIIllIlllIIlII) {
            List<Listener<Instance>> lllllllllllIIlIllllIIllIlllIllIl = null;
            for (final Listener<Instance> lllllllllllIIlIllllIIllIlllIllII : this.field_192524_b) {
                if (lllllllllllIIlIllllIIllIlllIllII.func_192158_a().func_192278_a(lllllllllllIIlIllllIIllIlllIlIIl, lllllllllllIIlIllllIIllIllllIIlI, lllllllllllIIlIllllIIllIllllIIIl, lllllllllllIIlIllllIIllIllllIIII, lllllllllllIIlIllllIIllIlllIIlIl, lllllllllllIIlIllllIIllIlllIIlII)) {
                    if (lllllllllllIIlIllllIIllIlllIllIl == null) {
                        lllllllllllIIlIllllIIllIlllIllIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllIIlIllllIIllIlllIllIl.add(lllllllllllIIlIllllIIllIlllIllII);
                }
            }
            if (lllllllllllIIlIllllIIllIlllIllIl != null) {
                for (final Listener<Instance> lllllllllllIIlIllllIIllIlllIlIll : lllllllllllIIlIllllIIllIlllIllIl) {
                    lllllllllllIIlIllllIIllIlllIlIll.func_192159_a(this.field_192523_a);
                }
            }
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ DamagePredicate field_192279_a;
        private final /* synthetic */ EntityPredicate field_192280_b;
        
        public Instance(final DamagePredicate lllllllllllIIIIIlIllIIllIlIIIllI, final EntityPredicate lllllllllllIIIIIlIllIIllIlIIlIII) {
            super(PlayerHurtEntityTrigger.field_192222_a);
            this.field_192279_a = lllllllllllIIIIIlIllIIllIlIIIllI;
            this.field_192280_b = lllllllllllIIIIIlIllIIllIlIIlIII;
        }
        
        public boolean func_192278_a(final EntityPlayerMP lllllllllllIIIIIlIllIIllIIllIlIl, final Entity lllllllllllIIIIIlIllIIllIIlllIll, final DamageSource lllllllllllIIIIIlIllIIllIIllIIll, final float lllllllllllIIIIIlIllIIllIIlllIIl, final float lllllllllllIIIIIlIllIIllIIlllIII, final boolean lllllllllllIIIIIlIllIIllIIllIIII) {
            return this.field_192279_a.func_192365_a(lllllllllllIIIIIlIllIIllIIllIlIl, lllllllllllIIIIIlIllIIllIIllIIll, lllllllllllIIIIIlIllIIllIIlllIIl, lllllllllllIIIIIlIllIIllIIlllIII, lllllllllllIIIIIlIllIIllIIllIIII) && this.field_192280_b.func_192482_a(lllllllllllIIIIIlIllIIllIIllIlIl, lllllllllllIIIIIlIllIIllIIlllIll);
        }
    }
}
