// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.world.WorldServer;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Maps;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class PositionTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192218_b;
    private final /* synthetic */ ResourceLocation field_192217_a;
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIlllllIIIllllIlIlllll, final JsonDeserializationContext lllllllllllIlllllIIIllllIllIIIlI) {
        final LocationPredicate lllllllllllIlllllIIIllllIllIIIIl = LocationPredicate.func_193454_a((JsonElement)lllllllllllIlllllIIIllllIlIlllll);
        return new Instance(this.field_192217_a, lllllllllllIlllllIIIllllIllIIIIl);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return this.field_192217_a;
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIlllllIIIllllIlllIIII, final Listener<Instance> lllllllllllIlllllIIIllllIllIllll) {
        final Listeners lllllllllllIlllllIIIllllIlllIIlI = this.field_192218_b.get(lllllllllllIlllllIIIllllIlllIIII);
        if (lllllllllllIlllllIIIllllIlllIIlI != null) {
            lllllllllllIlllllIIIllllIlllIIlI.func_192507_b(lllllllllllIlllllIIIllllIllIllll);
            if (lllllllllllIlllllIIIllllIlllIIlI.func_192508_a()) {
                this.field_192218_b.remove(lllllllllllIlllllIIIllllIlllIIII);
            }
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIlllllIIIllllIlllllII, final Listener<Instance> lllllllllllIlllllIIIllllIllllIll) {
        Listeners lllllllllllIlllllIIIllllIllllllI = this.field_192218_b.get(lllllllllllIlllllIIIllllIlllllII);
        if (lllllllllllIlllllIIIllllIllllllI == null) {
            lllllllllllIlllllIIIllllIllllllI = new Listeners(lllllllllllIlllllIIIllllIlllllII);
            this.field_192218_b.put(lllllllllllIlllllIIIllllIlllllII, lllllllllllIlllllIIIllllIllllllI);
        }
        lllllllllllIlllllIIIllllIllllllI.func_192510_a(lllllllllllIlllllIIIllllIllllIll);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIlllllIIIllllIllIlIII) {
        this.field_192218_b.remove(lllllllllllIlllllIIIllllIllIlIII);
    }
    
    public PositionTrigger(final ResourceLocation lllllllllllIlllllIIIlllllIIIlIll) {
        this.field_192218_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
        this.field_192217_a = lllllllllllIlllllIIIlllllIIIlIll;
    }
    
    public void func_192215_a(final EntityPlayerMP lllllllllllIlllllIIIllllIlIllIIl) {
        final Listeners lllllllllllIlllllIIIllllIlIllIII = this.field_192218_b.get(lllllllllllIlllllIIIllllIlIllIIl.func_192039_O());
        if (lllllllllllIlllllIIIllllIlIllIII != null) {
            lllllllllllIlllllIIIllllIlIllIII.func_193462_a(lllllllllllIlllllIIIllllIlIllIIl.getServerWorld(), lllllllllllIlllllIIIllllIlIllIIl.posX, lllllllllllIlllllIIIllllIlIllIIl.posY, lllllllllllIlllllIIIllllIlIllIIl.posZ);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192512_b;
        private final /* synthetic */ PlayerAdvancements field_192511_a;
        
        public void func_192510_a(final Listener<Instance> llllllllllllIlIIIIIIlllllllIIlII) {
            this.field_192512_b.add(llllllllllllIlIIIIIIlllllllIIlII);
        }
        
        public void func_192507_b(final Listener<Instance> llllllllllllIlIIIIIIllllllIllllI) {
            this.field_192512_b.remove(llllllllllllIlIIIIIIllllllIllllI);
        }
        
        public void func_193462_a(final WorldServer llllllllllllIlIIIIIIllllllIIllII, final double llllllllllllIlIIIIIIllllllIlIIll, final double llllllllllllIlIIIIIIllllllIlIIlI, final double llllllllllllIlIIIIIIllllllIlIIIl) {
            List<Listener<Instance>> llllllllllllIlIIIIIIllllllIlIIII = null;
            for (final Listener<Instance> llllllllllllIlIIIIIIllllllIIllll : this.field_192512_b) {
                if (llllllllllllIlIIIIIIllllllIIllll.func_192158_a().func_193204_a(llllllllllllIlIIIIIIllllllIIllII, llllllllllllIlIIIIIIllllllIlIIll, llllllllllllIlIIIIIIllllllIlIIlI, llllllllllllIlIIIIIIllllllIlIIIl)) {
                    if (llllllllllllIlIIIIIIllllllIlIIII == null) {
                        llllllllllllIlIIIIIIllllllIlIIII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllIlIIIIIIllllllIlIIII.add(llllllllllllIlIIIIIIllllllIIllll);
                }
            }
            if (llllllllllllIlIIIIIIllllllIlIIII != null) {
                for (final Listener<Instance> llllllllllllIlIIIIIIllllllIIlllI : llllllllllllIlIIIIIIllllllIlIIII) {
                    llllllllllllIlIIIIIIllllllIIlllI.func_192159_a(this.field_192511_a);
                }
            }
        }
        
        public boolean func_192508_a() {
            return this.field_192512_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements llllllllllllIlIIIIIIlllllllIllIl) {
            this.field_192512_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192511_a = llllllllllllIlIIIIIIlllllllIllIl;
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ LocationPredicate field_193205_a;
        
        public boolean func_193204_a(final WorldServer lllllllllllIIlllIIlllIlllllllllI, final double lllllllllllIIlllIIlllIllllllllIl, final double lllllllllllIIlllIIlllIllllllllII, final double lllllllllllIIlllIIlllIllllllIllI) {
            return this.field_193205_a.func_193452_a(lllllllllllIIlllIIlllIlllllllllI, lllllllllllIIlllIIlllIllllllllIl, lllllllllllIIlllIIlllIllllllllII, lllllllllllIIlllIIlllIllllllIllI);
        }
        
        public Instance(final ResourceLocation lllllllllllIIlllIIllllIIIIIIIllI, final LocationPredicate lllllllllllIIlllIIllllIIIIIIlIII) {
            super(lllllllllllIIlllIIllllIIIIIIIllI);
            this.field_193205_a = lllllllllllIIlllIIllllIIIIIIlIII;
        }
    }
}
