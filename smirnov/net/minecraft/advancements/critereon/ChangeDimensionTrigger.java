// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.DimensionType;
import net.minecraft.util.JsonUtils;
import com.google.common.collect.Maps;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class ChangeDimensionTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193144_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193145_b;
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllllIlIIlIllIIIllIIIlI) {
        this.field_193145_b.remove(llllllllllllllIlIIlIllIIIllIIIlI);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllllIlIIlIllIIIlllIlII, final Listener<Instance> llllllllllllllIlIIlIllIIIlllIlll) {
        Listeners llllllllllllllIlIIlIllIIIlllIllI = this.field_193145_b.get(llllllllllllllIlIIlIllIIIlllIlII);
        if (llllllllllllllIlIIlIllIIIlllIllI == null) {
            llllllllllllllIlIIlIllIIIlllIllI = new Listeners(llllllllllllllIlIIlIllIIIlllIlII);
            this.field_193145_b.put(llllllllllllllIlIIlIllIIIlllIlII, llllllllllllllIlIIlIllIIIlllIllI);
        }
        llllllllllllllIlIIlIllIIIlllIllI.func_193233_a(llllllllllllllIlIIlIllIIIlllIlll);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return ChangeDimensionTrigger.field_193144_a;
    }
    
    public ChangeDimensionTrigger() {
        this.field_193145_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllllIlIIlIllIIIlIllIll, final JsonDeserializationContext llllllllllllllIlIIlIllIIIlIllIlI) {
        final DimensionType llllllllllllllIlIIlIllIIIlIllIIl = llllllllllllllIlIIlIllIIIlIllIll.has("from") ? DimensionType.func_193417_a(JsonUtils.getString(llllllllllllllIlIIlIllIIIlIllIll, "from")) : null;
        final DimensionType llllllllllllllIlIIlIllIIIlIllIII = llllllllllllllIlIIlIllIIIlIllIll.has("to") ? DimensionType.func_193417_a(JsonUtils.getString(llllllllllllllIlIIlIllIIIlIllIll, "to")) : null;
        return new Instance(llllllllllllllIlIIlIllIIIlIllIIl, llllllllllllllIlIIlIllIIIlIllIII);
    }
    
    static {
        field_193144_a = new ResourceLocation("changed_dimension");
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllllIlIIlIllIIIllIllII, final Listener<Instance> llllllllllllllIlIIlIllIIIllIIlll) {
        final Listeners llllllllllllllIlIIlIllIIIllIlIlI = this.field_193145_b.get(llllllllllllllIlIIlIllIIIllIllII);
        if (llllllllllllllIlIIlIllIIIllIlIlI != null) {
            llllllllllllllIlIIlIllIIIllIlIlI.func_193231_b(llllllllllllllIlIIlIllIIIllIIlll);
            if (llllllllllllllIlIIlIllIIIllIlIlI.func_193232_a()) {
                this.field_193145_b.remove(llllllllllllllIlIIlIllIIIllIllII);
            }
        }
    }
    
    public void func_193143_a(final EntityPlayerMP llllllllllllllIlIIlIllIIIlIIlllI, final DimensionType llllllllllllllIlIIlIllIIIlIIlIII, final DimensionType llllllllllllllIlIIlIllIIIlIIIlll) {
        final Listeners llllllllllllllIlIIlIllIIIlIIlIll = this.field_193145_b.get(llllllllllllllIlIIlIllIIIlIIlllI.func_192039_O());
        if (llllllllllllllIlIIlIllIIIlIIlIll != null) {
            llllllllllllllIlIIlIllIIIlIIlIll.func_193234_a(llllllllllllllIlIIlIllIIIlIIlIII, llllllllllllllIlIIlIllIIIlIIIlll);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        @Nullable
        private final /* synthetic */ DimensionType field_193191_a;
        @Nullable
        private final /* synthetic */ DimensionType field_193192_b;
        
        public Instance(@Nullable final DimensionType lllllllllllIIIlllllIlIlllllllIIl, @Nullable final DimensionType lllllllllllIIIlllllIlIllllllIlIl) {
            super(ChangeDimensionTrigger.field_193144_a);
            this.field_193191_a = lllllllllllIIIlllllIlIlllllllIIl;
            this.field_193192_b = lllllllllllIIIlllllIlIllllllIlIl;
        }
        
        public boolean func_193190_a(final DimensionType lllllllllllIIIlllllIlIllllllIIII, final DimensionType lllllllllllIIIlllllIlIlllllIllll) {
            return (this.field_193191_a == null || this.field_193191_a == lllllllllllIIIlllllIlIllllllIIII) && (this.field_193192_b == null || this.field_193192_b == lllllllllllIIIlllllIlIlllllIllll);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193235_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193236_b;
        
        public void func_193234_a(final DimensionType lllllllllllllIIIlIlIlllIIlIIIllI, final DimensionType lllllllllllllIIIlIlIlllIIlIIIlIl) {
            List<Listener<Instance>> lllllllllllllIIIlIlIlllIIlIIIlII = null;
            for (final Listener<Instance> lllllllllllllIIIlIlIlllIIlIIIIll : this.field_193236_b) {
                if (lllllllllllllIIIlIlIlllIIlIIIIll.func_192158_a().func_193190_a(lllllllllllllIIIlIlIlllIIlIIIllI, lllllllllllllIIIlIlIlllIIlIIIlIl)) {
                    if (lllllllllllllIIIlIlIlllIIlIIIlII == null) {
                        lllllllllllllIIIlIlIlllIIlIIIlII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIIlIlIlllIIlIIIlII.add(lllllllllllllIIIlIlIlllIIlIIIIll);
                }
            }
            if (lllllllllllllIIIlIlIlllIIlIIIlII != null) {
                for (final Listener<Instance> lllllllllllllIIIlIlIlllIIlIIIIlI : lllllllllllllIIIlIlIlllIIlIIIlII) {
                    lllllllllllllIIIlIlIlllIIlIIIIlI.func_192159_a(this.field_193235_a);
                }
            }
        }
        
        public void func_193233_a(final Listener<Instance> lllllllllllllIIIlIlIlllIIlIlIllI) {
            this.field_193236_b.add(lllllllllllllIIIlIlIlllIIlIlIllI);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIIlIlIlllIIlIlllIl) {
            this.field_193236_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193235_a = lllllllllllllIIIlIlIlllIIlIlllIl;
        }
        
        public void func_193231_b(final Listener<Instance> lllllllllllllIIIlIlIlllIIlIlIIII) {
            this.field_193236_b.remove(lllllllllllllIIIlIlIlllIIlIlIIII);
        }
        
        public boolean func_193232_a() {
            return this.field_193236_b.isEmpty();
        }
    }
}
