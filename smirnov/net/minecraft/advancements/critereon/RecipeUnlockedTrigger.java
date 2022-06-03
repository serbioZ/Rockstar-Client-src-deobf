// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import java.util.List;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import com.google.common.collect.Maps;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.crafting.IRecipe;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.JsonUtils;
import net.minecraft.advancements.ICriterionInstance;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Map;
import net.minecraft.advancements.ICriterionTrigger;

public class RecipeUnlockedTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192228_b;
    private static final /* synthetic */ ResourceLocation field_192227_a;
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIIIIIIlIIlIIlIlIIII) {
        this.field_192228_b.remove(lllllllllllllIIIIIIlIIlIIlIlIIII);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIIIIIIlIIlIIllIlIII, final Listener<Instance> lllllllllllllIIIIIIlIIlIIllIIlll) {
        Listeners lllllllllllllIIIIIIlIIlIIllIIllI = this.field_192228_b.get(lllllllllllllIIIIIIlIIlIIllIlIII);
        if (lllllllllllllIIIIIIlIIlIIllIIllI == null) {
            lllllllllllllIIIIIIlIIlIIllIIllI = new Listeners(lllllllllllllIIIIIIlIIlIIllIlIII);
            this.field_192228_b.put(lllllllllllllIIIIIIlIIlIIllIlIII, lllllllllllllIIIIIIlIIlIIllIIllI);
        }
        lllllllllllllIIIIIIlIIlIIllIIllI.func_192528_a(lllllllllllllIIIIIIlIIlIIllIIlll);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return RecipeUnlockedTrigger.field_192227_a;
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIIIIIIlIIlIIlIIlIll, final JsonDeserializationContext lllllllllllllIIIIIIlIIlIIlIIlIlI) {
        final ResourceLocation lllllllllllllIIIIIIlIIlIIlIIlIIl = new ResourceLocation(JsonUtils.getString(lllllllllllllIIIIIIlIIlIIlIIlIll, "recipe"));
        final IRecipe lllllllllllllIIIIIIlIIlIIlIIlIII = CraftingManager.func_193373_a(lllllllllllllIIIIIIlIIlIIlIIlIIl);
        if (lllllllllllllIIIIIIlIIlIIlIIlIII == null) {
            throw new JsonSyntaxException("Unknown recipe '" + lllllllllllllIIIIIIlIIlIIlIIlIIl + "'");
        }
        return new Instance(lllllllllllllIIIIIIlIIlIIlIIlIII);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIIIIIIlIIlIIlIlllII, final Listener<Instance> lllllllllllllIIIIIIlIIlIIlIllIll) {
        final Listeners lllllllllllllIIIIIIlIIlIIlIllIlI = this.field_192228_b.get(lllllllllllllIIIIIIlIIlIIlIlllII);
        if (lllllllllllllIIIIIIlIIlIIlIllIlI != null) {
            lllllllllllllIIIIIIlIIlIIlIllIlI.func_192525_b(lllllllllllllIIIIIIlIIlIIlIllIll);
            if (lllllllllllllIIIIIIlIIlIIlIllIlI.func_192527_a()) {
                this.field_192228_b.remove(lllllllllllllIIIIIIlIIlIIlIlllII);
            }
        }
    }
    
    static {
        field_192227_a = new ResourceLocation("recipe_unlocked");
    }
    
    public void func_192225_a(final EntityPlayerMP lllllllllllllIIIIIIlIIlIIIlllIll, final IRecipe lllllllllllllIIIIIIlIIlIIIlllIlI) {
        final Listeners lllllllllllllIIIIIIlIIlIIIllllIl = this.field_192228_b.get(lllllllllllllIIIIIIlIIlIIIlllIll.func_192039_O());
        if (lllllllllllllIIIIIIlIIlIIIllllIl != null) {
            lllllllllllllIIIIIIlIIlIIIllllIl.func_193493_a(lllllllllllllIIIIIIlIIlIIIlllIlI);
        }
    }
    
    public RecipeUnlockedTrigger() {
        this.field_192228_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ IRecipe field_192282_a;
        
        public Instance(final IRecipe llllllllllIlllllIlllIllllIlIIlII) {
            super(RecipeUnlockedTrigger.field_192227_a);
            this.field_192282_a = llllllllllIlllllIlllIllllIlIIlII;
        }
        
        public boolean func_193215_a(final IRecipe llllllllllIlllllIlllIllllIIlllII) {
            return this.field_192282_a == llllllllllIlllllIlllIllllIIlllII;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192529_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192530_b;
        
        public void func_192525_b(final Listener<Instance> lllllllllllllllIIIIlIlllllIIIIIl) {
            this.field_192530_b.remove(lllllllllllllllIIIIlIlllllIIIIIl);
        }
        
        public void func_192528_a(final Listener<Instance> lllllllllllllllIIIIlIlllllIIlIIl) {
            this.field_192530_b.add(lllllllllllllllIIIIlIlllllIIlIIl);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllllIIIIlIlllllIlIIII) {
            this.field_192530_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192529_a = lllllllllllllllIIIIlIlllllIlIIII;
        }
        
        public boolean func_192527_a() {
            return this.field_192530_b.isEmpty();
        }
        
        public void func_193493_a(final IRecipe lllllllllllllllIIIIlIllllIlllIlI) {
            List<Listener<Instance>> lllllllllllllllIIIIlIllllIlllIIl = null;
            for (final Listener<Instance> lllllllllllllllIIIIlIllllIlllIII : this.field_192530_b) {
                if (lllllllllllllllIIIIlIllllIlllIII.func_192158_a().func_193215_a(lllllllllllllllIIIIlIllllIlllIlI)) {
                    if (lllllllllllllllIIIIlIllllIlllIIl == null) {
                        lllllllllllllllIIIIlIllllIlllIIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllllIIIIlIllllIlllIIl.add(lllllllllllllllIIIIlIllllIlllIII);
                }
            }
            if (lllllllllllllllIIIIlIllllIlllIIl != null) {
                for (final Listener<Instance> lllllllllllllllIIIIlIllllIllIlll : lllllllllllllllIIIIlIllllIlllIIl) {
                    lllllllllllllllIIIIlIllllIllIlll.func_192159_a(this.field_192529_a);
                }
            }
        }
    }
}
