// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.base.Optional;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import net.minecraft.block.Block;
import net.minecraft.util.JsonUtils;
import com.google.common.collect.Maps;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class EnterBlockTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192196_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192197_b;
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllIlIIIlIllllllllIlllII, final Listener<Instance> lllllllllllIlIIIlIllllllllIllIll) {
        Listeners lllllllllllIlIIIlIllllllllIllIlI = this.field_192197_b.get(lllllllllllIlIIIlIllllllllIlllII);
        if (lllllllllllIlIIIlIllllllllIllIlI == null) {
            lllllllllllIlIIIlIllllllllIllIlI = new Listeners(lllllllllllIlIIIlIllllllllIlllII);
            this.field_192197_b.put(lllllllllllIlIIIlIllllllllIlllII, lllllllllllIlIIIlIllllllllIllIlI);
        }
        lllllllllllIlIIIlIllllllllIllIlI.func_192472_a(lllllllllllIlIIIlIllllllllIllIll);
    }
    
    public EnterBlockTrigger() {
        this.field_192197_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllIlIIIlIlllllllIlllIIl, final JsonDeserializationContext lllllllllllIlIIIlIlllllllIlllIII) {
        Block lllllllllllIlIIIlIlllllllIllIlll = null;
        if (lllllllllllIlIIIlIlllllllIlllIIl.has("block")) {
            final ResourceLocation lllllllllllIlIIIlIlllllllIllIllI = new ResourceLocation(JsonUtils.getString(lllllllllllIlIIIlIlllllllIlllIIl, "block"));
            if (!Block.REGISTRY.containsKey(lllllllllllIlIIIlIlllllllIllIllI)) {
                throw new JsonSyntaxException("Unknown block type '" + lllllllllllIlIIIlIlllllllIllIllI + "'");
            }
            lllllllllllIlIIIlIlllllllIllIlll = Block.REGISTRY.getObject(lllllllllllIlIIIlIlllllllIllIllI);
        }
        Map<IProperty<?>, Object> lllllllllllIlIIIlIlllllllIllIlIl = null;
        if (lllllllllllIlIIIlIlllllllIlllIIl.has("state")) {
            if (lllllllllllIlIIIlIlllllllIllIlll == null) {
                throw new JsonSyntaxException("Can't define block state without a specific block type");
            }
            final BlockStateContainer lllllllllllIlIIIlIlllllllIllIlII = lllllllllllIlIIIlIlllllllIllIlll.getBlockState();
            for (final Map.Entry<String, JsonElement> lllllllllllIlIIIlIlllllllIllIIll : JsonUtils.getJsonObject(lllllllllllIlIIIlIlllllllIlllIIl, "state").entrySet()) {
                final IProperty<?> lllllllllllIlIIIlIlllllllIllIIlI = lllllllllllIlIIIlIlllllllIllIlII.getProperty(lllllllllllIlIIIlIlllllllIllIIll.getKey());
                if (lllllllllllIlIIIlIlllllllIllIIlI == null) {
                    throw new JsonSyntaxException("Unknown block state property '" + lllllllllllIlIIIlIlllllllIllIIll.getKey() + "' for block '" + Block.REGISTRY.getNameForObject(lllllllllllIlIIIlIlllllllIllIlll) + "'");
                }
                final String lllllllllllIlIIIlIlllllllIllIIIl = JsonUtils.getString(lllllllllllIlIIIlIlllllllIllIIll.getValue(), lllllllllllIlIIIlIlllllllIllIIll.getKey());
                final Optional<?> lllllllllllIlIIIlIlllllllIllIIII = lllllllllllIlIIIlIlllllllIllIIlI.parseValue(lllllllllllIlIIIlIlllllllIllIIIl);
                if (!lllllllllllIlIIIlIlllllllIllIIII.isPresent()) {
                    throw new JsonSyntaxException("Invalid block state value '" + lllllllllllIlIIIlIlllllllIllIIIl + "' for property '" + lllllllllllIlIIIlIlllllllIllIIll.getKey() + "' on block '" + Block.REGISTRY.getNameForObject(lllllllllllIlIIIlIlllllllIllIlll) + "'");
                }
                if (lllllllllllIlIIIlIlllllllIllIlIl == null) {
                    lllllllllllIlIIIlIlllllllIllIlIl = (Map<IProperty<?>, Object>)Maps.newHashMap();
                }
                lllllllllllIlIIIlIlllllllIllIlIl.put(lllllllllllIlIIIlIlllllllIllIIlI, lllllllllllIlIIIlIlllllllIllIIII.get());
            }
        }
        return new Instance(lllllllllllIlIIIlIlllllllIllIlll, lllllllllllIlIIIlIlllllllIllIlIl);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return EnterBlockTrigger.field_192196_a;
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllIlIIIlIllllllllIIIllI) {
        this.field_192197_b.remove(lllllllllllIlIIIlIllllllllIIIllI);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllIlIIIlIllllllllIIllII, final Listener<Instance> lllllllllllIlIIIlIllllllllIIllll) {
        final Listeners lllllllllllIlIIIlIllllllllIIlllI = this.field_192197_b.get(lllllllllllIlIIIlIllllllllIIllII);
        if (lllllllllllIlIIIlIllllllllIIlllI != null) {
            lllllllllllIlIIIlIllllllllIIlllI.func_192469_b(lllllllllllIlIIIlIllllllllIIllll);
            if (lllllllllllIlIIIlIllllllllIIlllI.func_192470_a()) {
                this.field_192197_b.remove(lllllllllllIlIIIlIllllllllIIllII);
            }
        }
    }
    
    public void func_192193_a(final EntityPlayerMP lllllllllllIlIIIlIlllllllIIlllIl, final IBlockState lllllllllllIlIIIlIlllllllIIlllII) {
        final Listeners lllllllllllIlIIIlIlllllllIIlllll = this.field_192197_b.get(lllllllllllIlIIIlIlllllllIIlllIl.func_192039_O());
        if (lllllllllllIlIIIlIlllllllIIlllll != null) {
            lllllllllllIlIIIlIlllllllIIlllll.func_192471_a(lllllllllllIlIIIlIlllllllIIlllII);
        }
    }
    
    static {
        field_192196_a = new ResourceLocation("enter_block");
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ Map<IProperty<?>, Object> field_192262_b;
        private final /* synthetic */ Block field_192261_a;
        
        public Instance(@Nullable final Block lllllllllllIIIlIlIlllIIlIlIIlllI, @Nullable final Map<IProperty<?>, Object> lllllllllllIIIlIlIlllIIlIlIIllIl) {
            super(EnterBlockTrigger.field_192196_a);
            this.field_192261_a = lllllllllllIIIlIlIlllIIlIlIIlllI;
            this.field_192262_b = lllllllllllIIIlIlIlllIIlIlIIllIl;
        }
        
        public boolean func_192260_a(final IBlockState lllllllllllIIIlIlIlllIIlIlIIIlll) {
            if (this.field_192261_a != null && lllllllllllIIIlIlIlllIIlIlIIIlll.getBlock() != this.field_192261_a) {
                return false;
            }
            if (this.field_192262_b != null) {
                for (final Map.Entry<IProperty<?>, Object> lllllllllllIIIlIlIlllIIlIlIIIllI : this.field_192262_b.entrySet()) {
                    if (lllllllllllIIIlIlIlllIIlIlIIIlll.getValue(lllllllllllIIIlIlIlllIIlIlIIIllI.getKey()) != lllllllllllIIIlIlIlllIIlIlIIIllI.getValue()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192473_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192474_b;
        
        public Listeners(final PlayerAdvancements lllllllllllIllllIIIIlIIIIIIlIIll) {
            this.field_192474_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192473_a = lllllllllllIllllIIIIlIIIIIIlIIll;
        }
        
        public boolean func_192470_a() {
            return this.field_192474_b.isEmpty();
        }
        
        public void func_192472_a(final Listener<Instance> lllllllllllIllllIIIIlIIIIIIIlIlI) {
            this.field_192474_b.add(lllllllllllIllllIIIIlIIIIIIIlIlI);
        }
        
        public void func_192469_b(final Listener<Instance> lllllllllllIllllIIIIlIIIIIIIIIlI) {
            this.field_192474_b.remove(lllllllllllIllllIIIIlIIIIIIIIIlI);
        }
        
        public void func_192471_a(final IBlockState lllllllllllIllllIIIIIllllllllIll) {
            List<Listener<Instance>> lllllllllllIllllIIIIIllllllllIlI = null;
            for (final Listener<Instance> lllllllllllIllllIIIIIllllllllIIl : this.field_192474_b) {
                if (lllllllllllIllllIIIIIllllllllIIl.func_192158_a().func_192260_a(lllllllllllIllllIIIIIllllllllIll)) {
                    if (lllllllllllIllllIIIIIllllllllIlI == null) {
                        lllllllllllIllllIIIIIllllllllIlI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllIllllIIIIIllllllllIlI.add(lllllllllllIllllIIIIIllllllllIIl);
                }
            }
            if (lllllllllllIllllIIIIIllllllllIlI != null) {
                for (final Listener<Instance> lllllllllllIllllIIIIIllllllllIII : lllllllllllIllllIIIIIllllllllIlI) {
                    lllllllllllIllllIIIIIllllllllIII.func_192159_a(this.field_192473_a);
                }
            }
        }
    }
}
