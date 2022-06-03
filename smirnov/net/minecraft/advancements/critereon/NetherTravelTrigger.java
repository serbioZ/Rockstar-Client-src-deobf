// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.world.WorldServer;
import com.google.common.collect.Sets;
import java.util.Set;
import com.google.common.collect.Maps;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class NetherTravelTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193169_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193170_b;
    
    public void func_193168_a(final EntityPlayerMP lllllllllllIlIIIIIIIIlIlllIlIIIl, final Vec3d lllllllllllIlIIIIIIIIlIlllIlIlII) {
        final Listeners lllllllllllIlIIIIIIIIlIlllIlIIll = this.field_193170_b.get(lllllllllllIlIIIIIIIIlIlllIlIIIl.func_192039_O());
        if (lllllllllllIlIIIIIIIIlIlllIlIIll != null) {
            lllllllllllIlIIIIIIIIlIlllIlIIll.func_193483_a(lllllllllllIlIIIIIIIIlIlllIlIIIl.getServerWorld(), lllllllllllIlIIIIIIIIlIlllIlIlII, lllllllllllIlIIIIIIIIlIlllIlIIIl.posX, lllllllllllIlIIIIIIIIlIlllIlIIIl.posY, lllllllllllIlIIIIIIIIlIlllIlIIIl.posZ);
        }
    }
    
    static {
        field_193169_a = new ResourceLocation("nether_travel");
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIlIIIIIIIIlIlllllllIl, final Listener<Instance> lllllllllllIlIIIIIIIIlIlllllllII) {
        Listeners lllllllllllIlIIIIIIIIlIlllllllll = this.field_193170_b.get(lllllllllllIlIIIIIIIIlIlllllllIl);
        if (lllllllllllIlIIIIIIIIlIlllllllll == null) {
            lllllllllllIlIIIIIIIIlIlllllllll = new Listeners(lllllllllllIlIIIIIIIIlIlllllllIl);
            this.field_193170_b.put(lllllllllllIlIIIIIIIIlIlllllllIl, lllllllllllIlIIIIIIIIlIlllllllll);
        }
        lllllllllllIlIIIIIIIIlIlllllllll.func_193484_a(lllllllllllIlIIIIIIIIlIlllllllII);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return NetherTravelTrigger.field_193169_a;
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIlIIIIIIIIlIllllIlIll) {
        this.field_193170_b.remove(lllllllllllIlIIIIIIIIlIllllIlIll);
    }
    
    public NetherTravelTrigger() {
        this.field_193170_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIlIIIIIIIIlIllllIIIll, final JsonDeserializationContext lllllllllllIlIIIIIIIIlIllllIIIlI) {
        final LocationPredicate lllllllllllIlIIIIIIIIlIllllIIIIl = LocationPredicate.func_193454_a(lllllllllllIlIIIIIIIIlIllllIIIll.get("entered"));
        final LocationPredicate lllllllllllIlIIIIIIIIlIllllIIIII = LocationPredicate.func_193454_a(lllllllllllIlIIIIIIIIlIllllIIIll.get("exited"));
        final DistancePredicate lllllllllllIlIIIIIIIIlIlllIlllll = DistancePredicate.func_193421_a(lllllllllllIlIIIIIIIIlIllllIIIll.get("distance"));
        return new Instance(lllllllllllIlIIIIIIIIlIllllIIIIl, lllllllllllIlIIIIIIIIlIllllIIIII, lllllllllllIlIIIIIIIIlIlllIlllll);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIlIIIIIIIIlIlllllIIIl, final Listener<Instance> lllllllllllIlIIIIIIIIlIlllllIIII) {
        final Listeners lllllllllllIlIIIIIIIIlIlllllIIll = this.field_193170_b.get(lllllllllllIlIIIIIIIIlIlllllIIIl);
        if (lllllllllllIlIIIIIIIIlIlllllIIll != null) {
            lllllllllllIlIIIIIIIIlIlllllIIll.func_193481_b(lllllllllllIlIIIIIIIIlIlllllIIII);
            if (lllllllllllIlIIIIIIIIlIlllllIIll.func_193482_a()) {
                this.field_193170_b.remove(lllllllllllIlIIIIIIIIlIlllllIIIl);
            }
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193485_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193486_b;
        
        public boolean func_193482_a() {
            return this.field_193486_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements llllllllllllIIIIIlllllIIllIIIlll) {
            this.field_193486_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193485_a = llllllllllllIIIIIlllllIIllIIIlll;
        }
        
        public void func_193481_b(final Listener<Instance> llllllllllllIIIIIlllllIIlIlllIII) {
            this.field_193486_b.remove(llllllllllllIIIIIlllllIIlIlllIII);
        }
        
        public void func_193484_a(final Listener<Instance> llllllllllllIIIIIlllllIIlIllllII) {
            this.field_193486_b.add(llllllllllllIIIIIlllllIIlIllllII);
        }
        
        public void func_193483_a(final WorldServer llllllllllllIIIIIlllllIIlIlIIIlI, final Vec3d llllllllllllIIIIIlllllIIlIlIlIlI, final double llllllllllllIIIIIlllllIIlIlIlIIl, final double llllllllllllIIIIIlllllIIlIIlllll, final double llllllllllllIIIIIlllllIIlIIllllI) {
            List<Listener<Instance>> llllllllllllIIIIIlllllIIlIlIIllI = null;
            for (final Listener<Instance> llllllllllllIIIIIlllllIIlIlIIlIl : this.field_193486_b) {
                if (llllllllllllIIIIIlllllIIlIlIIlIl.func_192158_a().func_193206_a(llllllllllllIIIIIlllllIIlIlIIIlI, llllllllllllIIIIIlllllIIlIlIlIlI, llllllllllllIIIIIlllllIIlIlIlIIl, llllllllllllIIIIIlllllIIlIIlllll, llllllllllllIIIIIlllllIIlIIllllI)) {
                    if (llllllllllllIIIIIlllllIIlIlIIllI == null) {
                        llllllllllllIIIIIlllllIIlIlIIllI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllIIIIIlllllIIlIlIIllI.add(llllllllllllIIIIIlllllIIlIlIIlIl);
                }
            }
            if (llllllllllllIIIIIlllllIIlIlIIllI != null) {
                for (final Listener<Instance> llllllllllllIIIIIlllllIIlIlIIlII : llllllllllllIIIIIlllllIIlIlIIllI) {
                    llllllllllllIIIIIlllllIIlIlIIlII.func_192159_a(this.field_193485_a);
                }
            }
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ DistancePredicate field_193209_c;
        private final /* synthetic */ LocationPredicate field_193207_a;
        private final /* synthetic */ LocationPredicate field_193208_b;
        
        public boolean func_193206_a(final WorldServer lllllllllllIlIIlllIIIIIIIIIIIIIl, final Vec3d lllllllllllIlIIlllIIIIIIIIIIIIII, final double lllllllllllIlIIlllIIIIIIIIIIIlIl, final double lllllllllllIlIIllIlllllllllllllI, final double lllllllllllIlIIlllIIIIIIIIIIIIll) {
            return this.field_193207_a.func_193452_a(lllllllllllIlIIlllIIIIIIIIIIIIIl, lllllllllllIlIIlllIIIIIIIIIIIIII.xCoord, lllllllllllIlIIlllIIIIIIIIIIIIII.yCoord, lllllllllllIlIIlllIIIIIIIIIIIIII.zCoord) && this.field_193208_b.func_193452_a(lllllllllllIlIIlllIIIIIIIIIIIIIl, lllllllllllIlIIlllIIIIIIIIIIIlIl, lllllllllllIlIIllIlllllllllllllI, lllllllllllIlIIlllIIIIIIIIIIIIll) && this.field_193209_c.func_193422_a(lllllllllllIlIIlllIIIIIIIIIIIIII.xCoord, lllllllllllIlIIlllIIIIIIIIIIIIII.yCoord, lllllllllllIlIIlllIIIIIIIIIIIIII.zCoord, lllllllllllIlIIlllIIIIIIIIIIIlIl, lllllllllllIlIIllIlllllllllllllI, lllllllllllIlIIlllIIIIIIIIIIIIll);
        }
        
        public Instance(final LocationPredicate lllllllllllIlIIlllIIIIIIIIIlIIIl, final LocationPredicate lllllllllllIlIIlllIIIIIIIIIlIIII, final DistancePredicate lllllllllllIlIIlllIIIIIIIIIIllll) {
            super(NetherTravelTrigger.field_193169_a);
            this.field_193207_a = lllllllllllIlIIlllIIIIIIIIIlIIIl;
            this.field_193208_b = lllllllllllIlIIlllIIIIIIIIIlIIII;
            this.field_193209_c = lllllllllllIlIIlllIIIIIIIIIIllll;
        }
    }
}
