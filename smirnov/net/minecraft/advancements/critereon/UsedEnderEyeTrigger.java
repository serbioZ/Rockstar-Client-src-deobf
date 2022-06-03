// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import com.google.common.collect.Maps;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class UsedEnderEyeTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192242_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192243_b;
    
    @Override
    public ResourceLocation func_192163_a() {
        return UsedEnderEyeTrigger.field_192242_a;
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIIIIIllIIlllIllllIIIl) {
        this.field_192243_b.remove(lllllllllllIIIIIllIIlllIllllIIIl);
    }
    
    public void func_192239_a(final EntityPlayerMP lllllllllllIIIIIllIIlllIllIllIIl, final BlockPos lllllllllllIIIIIllIIlllIllIllIII) {
        final Listeners lllllllllllIIIIIllIIlllIllIlllIl = this.field_192243_b.get(lllllllllllIIIIIllIIlllIllIllIIl.func_192039_O());
        if (lllllllllllIIIIIllIIlllIllIlllIl != null) {
            final double lllllllllllIIIIIllIIlllIllIlllII = lllllllllllIIIIIllIIlllIllIllIIl.posX - lllllllllllIIIIIllIIlllIllIllIII.getX();
            final double lllllllllllIIIIIllIIlllIllIllIll = lllllllllllIIIIIllIIlllIllIllIIl.posZ - lllllllllllIIIIIllIIlllIllIllIII.getZ();
            lllllllllllIIIIIllIIlllIllIlllIl.func_192543_a(lllllllllllIIIIIllIIlllIllIlllII * lllllllllllIIIIIllIIlllIllIlllII + lllllllllllIIIIIllIIlllIllIllIll * lllllllllllIIIIIllIIlllIllIllIll);
        }
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIIIIIllIIlllIlllIlIII, final JsonDeserializationContext lllllllllllIIIIIllIIlllIlllIlIlI) {
        final MinMaxBounds lllllllllllIIIIIllIIlllIlllIlIIl = MinMaxBounds.func_192515_a(lllllllllllIIIIIllIIlllIlllIlIII.get("distance"));
        return new Instance(lllllllllllIIIIIllIIlllIlllIlIIl);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIIIIIllIIllllIIIIIlll, final Listener<Instance> lllllllllllIIIIIllIIllllIIIIIIlI) {
        Listeners lllllllllllIIIIIllIIllllIIIIIlIl = this.field_192243_b.get(lllllllllllIIIIIllIIllllIIIIIlll);
        if (lllllllllllIIIIIllIIllllIIIIIlIl == null) {
            lllllllllllIIIIIllIIllllIIIIIlIl = new Listeners(lllllllllllIIIIIllIIllllIIIIIlll);
            this.field_192243_b.put(lllllllllllIIIIIllIIllllIIIIIlll, lllllllllllIIIIIllIIllllIIIIIlIl);
        }
        lllllllllllIIIIIllIIllllIIIIIlIl.func_192546_a(lllllllllllIIIIIllIIllllIIIIIIlI);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIIIIIllIIlllIllllIlll, final Listener<Instance> lllllllllllIIIIIllIIlllIllllIllI) {
        final Listeners lllllllllllIIIIIllIIlllIlllllIIl = this.field_192243_b.get(lllllllllllIIIIIllIIlllIllllIlll);
        if (lllllllllllIIIIIllIIlllIlllllIIl != null) {
            lllllllllllIIIIIllIIlllIlllllIIl.func_192544_b(lllllllllllIIIIIllIIlllIllllIllI);
            if (lllllllllllIIIIIllIIlllIlllllIIl.func_192545_a()) {
                this.field_192243_b.remove(lllllllllllIIIIIllIIlllIllllIlll);
            }
        }
    }
    
    static {
        field_192242_a = new ResourceLocation("used_ender_eye");
    }
    
    public UsedEnderEyeTrigger() {
        this.field_192243_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192548_b;
        private final /* synthetic */ PlayerAdvancements field_192547_a;
        
        public Listeners(final PlayerAdvancements llllllllllllIlllIIllllIlIlIIIIlI) {
            this.field_192548_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192547_a = llllllllllllIlllIIllllIlIlIIIIlI;
        }
        
        public void func_192546_a(final Listener<Instance> llllllllllllIlllIIllllIlIIlllIll) {
            this.field_192548_b.add(llllllllllllIlllIIllllIlIIlllIll);
        }
        
        public void func_192543_a(final double llllllllllllIlllIIllllIlIIlIllII) {
            List<Listener<Instance>> llllllllllllIlllIIllllIlIIlIlIll = null;
            for (final Listener<Instance> llllllllllllIlllIIllllIlIIlIlIlI : this.field_192548_b) {
                if (llllllllllllIlllIIllllIlIIlIlIlI.func_192158_a().func_192288_a(llllllllllllIlllIIllllIlIIlIllII)) {
                    if (llllllllllllIlllIIllllIlIIlIlIll == null) {
                        llllllllllllIlllIIllllIlIIlIlIll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllIlllIIllllIlIIlIlIll.add(llllllllllllIlllIIllllIlIIlIlIlI);
                }
            }
            if (llllllllllllIlllIIllllIlIIlIlIll != null) {
                for (final Listener<Instance> llllllllllllIlllIIllllIlIIlIlIIl : llllllllllllIlllIIllllIlIIlIlIll) {
                    llllllllllllIlllIIllllIlIIlIlIIl.func_192159_a(this.field_192547_a);
                }
            }
        }
        
        public void func_192544_b(final Listener<Instance> llllllllllllIlllIIllllIlIIllIlIl) {
            this.field_192548_b.remove(llllllllllllIlllIIllllIlIIllIlIl);
        }
        
        public boolean func_192545_a() {
            return this.field_192548_b.isEmpty();
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_192289_a;
        
        public Instance(final MinMaxBounds lllllllllllIlIIllIIlIlIIIIIIlIIl) {
            super(UsedEnderEyeTrigger.field_192242_a);
            this.field_192289_a = lllllllllllIlIIllIIlIlIIIIIIlIIl;
        }
        
        public boolean func_192288_a(final double lllllllllllIlIIllIIlIlIIIIIIIIIl) {
            return this.field_192289_a.func_192513_a(lllllllllllIlIIllIIlIlIIIIIIIIIl);
        }
    }
}
