// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Maps;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class LevitationTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193164_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193165_b;
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllIIlllllIlllIlllIllIl, final JsonDeserializationContext llllllllllllIIlllllIlllIllllIIII) {
        final DistancePredicate llllllllllllIIlllllIlllIlllIllll = DistancePredicate.func_193421_a(llllllllllllIIlllllIlllIlllIllIl.get("distance"));
        final MinMaxBounds llllllllllllIIlllllIlllIlllIlllI = MinMaxBounds.func_192515_a(llllllllllllIIlllllIlllIlllIllIl.get("duration"));
        return new Instance(llllllllllllIIlllllIlllIlllIllll, llllllllllllIIlllllIlllIlllIlllI);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return LevitationTrigger.field_193164_a;
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllIIlllllIlllIlllllllI, final Listener<Instance> llllllllllllIIlllllIllllIIIIIIIl) {
        final Listeners llllllllllllIIlllllIllllIIIIIIII = this.field_193165_b.get(llllllllllllIIlllllIlllIlllllllI);
        if (llllllllllllIIlllllIllllIIIIIIII != null) {
            llllllllllllIIlllllIllllIIIIIIII.func_193446_b(llllllllllllIIlllllIllllIIIIIIIl);
            if (llllllllllllIIlllllIllllIIIIIIII.func_193447_a()) {
                this.field_193165_b.remove(llllllllllllIIlllllIlllIlllllllI);
            }
        }
    }
    
    static {
        field_193164_a = new ResourceLocation("levitation");
    }
    
    public LevitationTrigger() {
        this.field_193165_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public void func_193162_a(final EntityPlayerMP llllllllllllIIlllllIlllIlllIIlII, final Vec3d llllllllllllIIlllllIlllIllIllllI, final int llllllllllllIIlllllIlllIllIlllIl) {
        final Listeners llllllllllllIIlllllIlllIlllIIIIl = this.field_193165_b.get(llllllllllllIIlllllIlllIlllIIlII.func_192039_O());
        if (llllllllllllIIlllllIlllIlllIIIIl != null) {
            llllllllllllIIlllllIlllIlllIIIIl.func_193448_a(llllllllllllIIlllllIlllIlllIIlII, llllllllllllIIlllllIlllIllIllllI, llllllllllllIIlllllIlllIllIlllIl);
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllIIlllllIlllIlllllIII) {
        this.field_193165_b.remove(llllllllllllIIlllllIlllIlllllIII);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllIIlllllIllllIIIIlIlI, final Listener<Instance> llllllllllllIIlllllIllllIIIIlIIl) {
        Listeners llllllllllllIIlllllIllllIIIIllII = this.field_193165_b.get(llllllllllllIIlllllIllllIIIIlIlI);
        if (llllllllllllIIlllllIllllIIIIllII == null) {
            llllllllllllIIlllllIllllIIIIllII = new Listeners(llllllllllllIIlllllIllllIIIIlIlI);
            this.field_193165_b.put(llllllllllllIIlllllIllllIIIIlIlI, llllllllllllIIlllllIllllIIIIllII);
        }
        llllllllllllIIlllllIllllIIIIllII.func_193449_a(llllllllllllIIlllllIllllIIIIlIIl);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ DistancePredicate field_193202_a;
        private final /* synthetic */ MinMaxBounds field_193203_b;
        
        public boolean func_193201_a(final EntityPlayerMP lllllllllllIlIIIIlllIIlIIlIllIll, final Vec3d lllllllllllIlIIIIlllIIlIIlIllIlI, final int lllllllllllIlIIIIlllIIlIIlIlIlIl) {
            return this.field_193202_a.func_193422_a(lllllllllllIlIIIIlllIIlIIlIllIlI.xCoord, lllllllllllIlIIIIlllIIlIIlIllIlI.yCoord, lllllllllllIlIIIIlllIIlIIlIllIlI.zCoord, lllllllllllIlIIIIlllIIlIIlIllIll.posX, lllllllllllIlIIIIlllIIlIIlIllIll.posY, lllllllllllIlIIIIlllIIlIIlIllIll.posZ) && this.field_193203_b.func_192514_a((float)lllllllllllIlIIIIlllIIlIIlIlIlIl);
        }
        
        public Instance(final DistancePredicate lllllllllllIlIIIIlllIIlIIllIIIlI, final MinMaxBounds lllllllllllIlIIIIlllIIlIIllIIIIl) {
            super(LevitationTrigger.field_193164_a);
            this.field_193202_a = lllllllllllIlIIIIlllIIlIIllIIIlI;
            this.field_193203_b = lllllllllllIlIIIIlllIIlIIllIIIIl;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193450_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193451_b;
        
        public void func_193446_b(final Listener<Instance> llllllllllllIlIIIllIlIIIIIIlIIII) {
            this.field_193451_b.remove(llllllllllllIlIIIllIlIIIIIIlIIII);
        }
        
        public void func_193449_a(final Listener<Instance> llllllllllllIlIIIllIlIIIIIIlIllI) {
            this.field_193451_b.add(llllllllllllIlIIIllIlIIIIIIlIllI);
        }
        
        public Listeners(final PlayerAdvancements llllllllllllIlIIIllIlIIIIIIlllll) {
            this.field_193451_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193450_a = llllllllllllIlIIIllIlIIIIIIlllll;
        }
        
        public boolean func_193447_a() {
            return this.field_193451_b.isEmpty();
        }
        
        public void func_193448_a(final EntityPlayerMP llllllllllllIlIIIllIlIIIIIIIIlll, final Vec3d llllllllllllIlIIIllIIlllllllllll, final int llllllllllllIlIIIllIIllllllllllI) {
            List<Listener<Instance>> llllllllllllIlIIIllIlIIIIIIIIlII = null;
            for (final Listener<Instance> llllllllllllIlIIIllIlIIIIIIIIIll : this.field_193451_b) {
                if (llllllllllllIlIIIllIlIIIIIIIIIll.func_192158_a().func_193201_a(llllllllllllIlIIIllIlIIIIIIIIlll, llllllllllllIlIIIllIIlllllllllll, llllllllllllIlIIIllIIllllllllllI)) {
                    if (llllllllllllIlIIIllIlIIIIIIIIlII == null) {
                        llllllllllllIlIIIllIlIIIIIIIIlII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllIlIIIllIlIIIIIIIIlII.add(llllllllllllIlIIIllIlIIIIIIIIIll);
                }
            }
            if (llllllllllllIlIIIllIlIIIIIIIIlII != null) {
                for (final Listener<Instance> llllllllllllIlIIIllIlIIIIIIIIIlI : llllllllllllIlIIIllIlIIIIIIIIlII) {
                    llllllllllllIlIIIllIlIIIIIIIIIlI.func_192159_a(this.field_193450_a);
                }
            }
        }
    }
}
