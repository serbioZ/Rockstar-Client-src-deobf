// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import javax.annotation.Nullable;
import com.google.common.collect.Sets;
import java.util.List;
import com.google.common.collect.Lists;
import net.minecraft.world.WorldServer;
import java.util.Set;
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
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.ICriterionTrigger;

public class PlacedBlockTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193174_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193175_b;
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllIlIIlIIl, final Listener<Instance> llllllIlIIllII) {
        Listeners llllllIlIIlIll = this.field_193175_b.get(llllllIlIIlIIl);
        if (llllllIlIIlIll == null) {
            llllllIlIIlIll = new Listeners(llllllIlIIlIIl);
            this.field_193175_b.put(llllllIlIIlIIl, llllllIlIIlIll);
        }
        llllllIlIIlIll.func_193490_a(llllllIlIIllII);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllIlIIIIIl, final Listener<Instance> llllllIIllllII) {
        final Listeners llllllIIllllll = this.field_193175_b.get(llllllIlIIIIIl);
        if (llllllIIllllll != null) {
            llllllIIllllll.func_193487_b(llllllIIllllII);
            if (llllllIIllllll.func_193488_a()) {
                this.field_193175_b.remove(llllllIlIIIIIl);
            }
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return PlacedBlockTrigger.field_193174_a;
    }
    
    public void func_193173_a(final EntityPlayerMP llllllIIIIlIII, final BlockPos llllllIIIIllIl, final ItemStack llllllIIIIllII) {
        final IBlockState llllllIIIIlIll = llllllIIIIlIII.world.getBlockState(llllllIIIIllIl);
        final Listeners llllllIIIIlIlI = this.field_193175_b.get(llllllIIIIlIII.func_192039_O());
        if (llllllIIIIlIlI != null) {
            llllllIIIIlIlI.func_193489_a(llllllIIIIlIll, llllllIIIIllIl, llllllIIIIlIII.getServerWorld(), llllllIIIIllII);
        }
    }
    
    public PlacedBlockTrigger() {
        this.field_193175_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllIIllIlIl) {
        this.field_193175_b.remove(llllllIIllIlIl);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllIIIllllI, final JsonDeserializationContext llllllIIlIlIIl) {
        Block llllllIIlIlIII = null;
        if (llllllIIIllllI.has("block")) {
            final ResourceLocation llllllIIlIIlll = new ResourceLocation(JsonUtils.getString(llllllIIIllllI, "block"));
            if (!Block.REGISTRY.containsKey(llllllIIlIIlll)) {
                throw new JsonSyntaxException("Unknown block type '" + llllllIIlIIlll + "'");
            }
            llllllIIlIlIII = Block.REGISTRY.getObject(llllllIIlIIlll);
        }
        Map<IProperty<?>, Object> llllllIIlIIllI = null;
        if (llllllIIIllllI.has("state")) {
            if (llllllIIlIlIII == null) {
                throw new JsonSyntaxException("Can't define block state without a specific block type");
            }
            final BlockStateContainer llllllIIlIIlIl = llllllIIlIlIII.getBlockState();
            for (final Map.Entry<String, JsonElement> llllllIIlIIlII : JsonUtils.getJsonObject(llllllIIIllllI, "state").entrySet()) {
                final IProperty<?> llllllIIlIIIll = llllllIIlIIlIl.getProperty(llllllIIlIIlII.getKey());
                if (llllllIIlIIIll == null) {
                    throw new JsonSyntaxException("Unknown block state property '" + llllllIIlIIlII.getKey() + "' for block '" + Block.REGISTRY.getNameForObject(llllllIIlIlIII) + "'");
                }
                final String llllllIIlIIIlI = JsonUtils.getString(llllllIIlIIlII.getValue(), llllllIIlIIlII.getKey());
                final Optional<?> llllllIIlIIIIl = llllllIIlIIIll.parseValue(llllllIIlIIIlI);
                if (!llllllIIlIIIIl.isPresent()) {
                    throw new JsonSyntaxException("Invalid block state value '" + llllllIIlIIIlI + "' for property '" + llllllIIlIIlII.getKey() + "' on block '" + Block.REGISTRY.getNameForObject(llllllIIlIlIII) + "'");
                }
                if (llllllIIlIIllI == null) {
                    llllllIIlIIllI = (Map<IProperty<?>, Object>)Maps.newHashMap();
                }
                llllllIIlIIllI.put(llllllIIlIIIll, llllllIIlIIIIl.get());
            }
        }
        final LocationPredicate llllllIIlIIIII = LocationPredicate.func_193454_a(llllllIIIllllI.get("location"));
        final ItemPredicate llllllIIIlllll = ItemPredicate.func_192492_a(llllllIIIllllI.get("item"));
        return new Instance(llllllIIlIlIII, llllllIIlIIllI, llllllIIlIIIII, llllllIIIlllll);
    }
    
    static {
        field_193174_a = new ResourceLocation("placed_block");
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_193492_b;
        private final /* synthetic */ PlayerAdvancements field_193491_a;
        
        public void func_193489_a(final IBlockState lllllllllllIllIIlIlIIllllIlIIllI, final BlockPos lllllllllllIllIIlIlIIllllIlIllIl, final WorldServer lllllllllllIllIIlIlIIllllIlIIlII, final ItemStack lllllllllllIllIIlIlIIllllIlIlIll) {
            List<Listener<Instance>> lllllllllllIllIIlIlIIllllIlIlIlI = null;
            for (final Listener<Instance> lllllllllllIllIIlIlIIllllIlIlIIl : this.field_193492_b) {
                if (lllllllllllIllIIlIlIIllllIlIlIIl.func_192158_a().func_193210_a(lllllllllllIllIIlIlIIllllIlIIllI, lllllllllllIllIIlIlIIllllIlIllIl, lllllllllllIllIIlIlIIllllIlIIlII, lllllllllllIllIIlIlIIllllIlIlIll)) {
                    if (lllllllllllIllIIlIlIIllllIlIlIlI == null) {
                        lllllllllllIllIIlIlIIllllIlIlIlI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllIllIIlIlIIllllIlIlIlI.add(lllllllllllIllIIlIlIIllllIlIlIIl);
                }
            }
            if (lllllllllllIllIIlIlIIllllIlIlIlI != null) {
                for (final Listener<Instance> lllllllllllIllIIlIlIIllllIlIlIII : lllllllllllIllIIlIlIIllllIlIlIlI) {
                    lllllllllllIllIIlIlIIllllIlIlIII.func_192159_a(this.field_193491_a);
                }
            }
        }
        
        public boolean func_193488_a() {
            return this.field_193492_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements lllllllllllIllIIlIlIIlllllIIIlll) {
            this.field_193492_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193491_a = lllllllllllIllIIlIlIIlllllIIIlll;
        }
        
        public void func_193490_a(final Listener<Instance> lllllllllllIllIIlIlIIlllllIIIIII) {
            this.field_193492_b.add(lllllllllllIllIIlIlIIlllllIIIIII);
        }
        
        public void func_193487_b(final Listener<Instance> lllllllllllIllIIlIlIIllllIlllIlI) {
            this.field_193492_b.remove(lllllllllllIllIIlIlIIllllIlllIlI);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ ItemPredicate field_193214_d;
        private final /* synthetic */ Map<IProperty<?>, Object> field_193212_b;
        private final /* synthetic */ LocationPredicate field_193213_c;
        private final /* synthetic */ Block field_193211_a;
        
        public boolean func_193210_a(final IBlockState lllllllllllIlIlIIllIlIlIIIIllllI, final BlockPos lllllllllllIlIlIIllIlIlIIIIlllIl, final WorldServer lllllllllllIlIlIIllIlIlIIIIlllII, final ItemStack lllllllllllIlIlIIllIlIlIIIlIIIIl) {
            if (this.field_193211_a != null && lllllllllllIlIlIIllIlIlIIIIllllI.getBlock() != this.field_193211_a) {
                return false;
            }
            if (this.field_193212_b != null) {
                for (final Map.Entry<IProperty<?>, Object> lllllllllllIlIlIIllIlIlIIIlIIIII : this.field_193212_b.entrySet()) {
                    if (lllllllllllIlIlIIllIlIlIIIIllllI.getValue(lllllllllllIlIlIIllIlIlIIIlIIIII.getKey()) != lllllllllllIlIlIIllIlIlIIIlIIIII.getValue()) {
                        return false;
                    }
                }
            }
            return this.field_193213_c.func_193453_a(lllllllllllIlIlIIllIlIlIIIIlllII, (float)lllllllllllIlIlIIllIlIlIIIIlllIl.getX(), (float)lllllllllllIlIlIIllIlIlIIIIlllIl.getY(), (float)lllllllllllIlIlIIllIlIlIIIIlllIl.getZ()) && this.field_193214_d.func_192493_a(lllllllllllIlIlIIllIlIlIIIlIIIIl);
        }
        
        public Instance(@Nullable final Block lllllllllllIlIlIIllIlIlIIIllIlIl, @Nullable final Map<IProperty<?>, Object> lllllllllllIlIlIIllIlIlIIIlIllll, final LocationPredicate lllllllllllIlIlIIllIlIlIIIlIlllI, final ItemPredicate lllllllllllIlIlIIllIlIlIIIlIllIl) {
            super(PlacedBlockTrigger.field_193174_a);
            this.field_193211_a = lllllllllllIlIlIIllIlIlIIIllIlIl;
            this.field_193212_b = lllllllllllIlIlIIllIlIlIIIlIllll;
            this.field_193213_c = lllllllllllIlIlIIllIlIlIIIlIlllI;
            this.field_193214_d = lllllllllllIlIlIIllIlIlIIIlIllIl;
        }
    }
}
