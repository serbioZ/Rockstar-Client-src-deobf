// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Maps;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class ConstructBeaconTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192181_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192182_b;
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIIIlIlllIIlIlIlllIlIl, final Listener<Instance> lllllllllllIIIlIlllIIlIlIlllIlII) {
        Listeners lllllllllllIIIlIlllIIlIlIlllIIll = this.field_192182_b.get(lllllllllllIIIlIlllIIlIlIlllIlIl);
        if (lllllllllllIIIlIlllIIlIlIlllIIll == null) {
            lllllllllllIIIlIlllIIlIlIlllIIll = new Listeners(lllllllllllIIIlIlllIIlIlIlllIlIl);
            this.field_192182_b.put(lllllllllllIIIlIlllIIlIlIlllIlIl, lllllllllllIIIlIlllIIlIlIlllIIll);
        }
        lllllllllllIIIlIlllIIlIlIlllIIll.func_192355_a(lllllllllllIIIlIlllIIlIlIlllIlII);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIIIlIlllIIlIlIlIlIllI, final JsonDeserializationContext lllllllllllIIIlIlllIIlIlIlIllIII) {
        final MinMaxBounds lllllllllllIIIlIlllIIlIlIlIlIlll = MinMaxBounds.func_192515_a(lllllllllllIIIlIlllIIlIlIlIlIllI.get("level"));
        return new Instance(lllllllllllIIIlIlllIIlIlIlIlIlll);
    }
    
    public ConstructBeaconTrigger() {
        this.field_192182_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    static {
        field_192181_a = new ResourceLocation("construct_beacon");
    }
    
    public void func_192180_a(final EntityPlayerMP lllllllllllIIIlIlllIIlIlIlIIlIll, final TileEntityBeacon lllllllllllIIIlIlllIIlIlIlIIlIlI) {
        final Listeners lllllllllllIIIlIlllIIlIlIlIIllIl = this.field_192182_b.get(lllllllllllIIIlIlllIIlIlIlIIlIll.func_192039_O());
        if (lllllllllllIIIlIlllIIlIlIlIIllIl != null) {
            lllllllllllIIIlIlllIIlIlIlIIllIl.func_192352_a(lllllllllllIIIlIlllIIlIlIlIIlIlI);
        }
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIIIlIlllIIlIlIllIIlIl, final Listener<Instance> lllllllllllIIIlIlllIIlIlIllIIlII) {
        final Listeners lllllllllllIIIlIlllIIlIlIllIIlll = this.field_192182_b.get(lllllllllllIIIlIlllIIlIlIllIIlIl);
        if (lllllllllllIIIlIlllIIlIlIllIIlll != null) {
            lllllllllllIIIlIlllIIlIlIllIIlll.func_192353_b(lllllllllllIIIlIlllIIlIlIllIIlII);
            if (lllllllllllIIIlIlllIIlIlIllIIlll.func_192354_a()) {
                this.field_192182_b.remove(lllllllllllIIIlIlllIIlIlIllIIlIl);
            }
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIIIlIlllIIlIlIlIlllIl) {
        this.field_192182_b.remove(lllllllllllIIIlIlllIIlIlIlIlllIl);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return ConstructBeaconTrigger.field_192181_a;
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_192253_a;
        
        public boolean func_192252_a(final TileEntityBeacon lllllllllllIlIllIIlIllIIllllIIlI) {
            return this.field_192253_a.func_192514_a((float)lllllllllllIlIllIIlIllIIllllIIlI.func_191979_s());
        }
        
        public Instance(final MinMaxBounds lllllllllllIlIllIIlIllIIlllllIII) {
            super(ConstructBeaconTrigger.field_192181_a);
            this.field_192253_a = lllllllllllIlIllIIlIllIIlllllIII;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192356_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192357_b;
        
        public Listeners(final PlayerAdvancements lllllllllllllllIIlllIIlIIIlIIlll) {
            this.field_192357_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192356_a = lllllllllllllllIIlllIIlIIIlIIlll;
        }
        
        public boolean func_192354_a() {
            return this.field_192357_b.isEmpty();
        }
        
        public void func_192355_a(final Listener<Instance> lllllllllllllllIIlllIIlIIIIllllI) {
            this.field_192357_b.add(lllllllllllllllIIlllIIlIIIIllllI);
        }
        
        public void func_192353_b(final Listener<Instance> lllllllllllllllIIlllIIlIIIIlIllI) {
            this.field_192357_b.remove(lllllllllllllllIIlllIIlIIIIlIllI);
        }
        
        public void func_192352_a(final TileEntityBeacon lllllllllllllllIIlllIIlIIIIIllll) {
            List<Listener<Instance>> lllllllllllllllIIlllIIlIIIIIlllI = null;
            for (final Listener<Instance> lllllllllllllllIIlllIIlIIIIIllIl : this.field_192357_b) {
                if (lllllllllllllllIIlllIIlIIIIIllIl.func_192158_a().func_192252_a(lllllllllllllllIIlllIIlIIIIIllll)) {
                    if (lllllllllllllllIIlllIIlIIIIIlllI == null) {
                        lllllllllllllllIIlllIIlIIIIIlllI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllllIIlllIIlIIIIIlllI.add(lllllllllllllllIIlllIIlIIIIIllIl);
                }
            }
            if (lllllllllllllllIIlllIIlIIIIIlllI != null) {
                for (final Listener<Instance> lllllllllllllllIIlllIIlIIIIIllII : lllllllllllllllIIlllIIlIIIIIlllI) {
                    lllllllllllllllIIlllIIlIIIIIllII.func_192159_a(this.field_192356_a);
                }
            }
        }
    }
}
