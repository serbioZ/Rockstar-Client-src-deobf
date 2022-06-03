// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import com.google.common.collect.Lists;
import java.util.List;

public class ItemOverrideList
{
    private final /* synthetic */ List<ItemOverride> overrides;
    
    public ItemOverrideList(final List<ItemOverride> llllllllllIlllIlIlllIlIlIlIlIIlI) {
        this.overrides = (List<ItemOverride>)Lists.newArrayList();
        for (int llllllllllIlllIlIlllIlIlIlIlIlII = llllllllllIlllIlIlllIlIlIlIlIIlI.size() - 1; llllllllllIlllIlIlllIlIlIlIlIlII >= 0; --llllllllllIlllIlIlllIlIlIlIlIlII) {
            this.overrides.add(llllllllllIlllIlIlllIlIlIlIlIIlI.get(llllllllllIlllIlIlllIlIlIlIlIlII));
        }
    }
    
    @Nullable
    public ResourceLocation applyOverride(final ItemStack llllllllllIlllIlIlllIlIlIlIIlIIl, @Nullable final World llllllllllIlllIlIlllIlIlIlIIIIll, @Nullable final EntityLivingBase llllllllllIlllIlIlllIlIlIlIIIlll) {
        if (!this.overrides.isEmpty()) {
            for (final ItemOverride llllllllllIlllIlIlllIlIlIlIIIllI : this.overrides) {
                if (llllllllllIlllIlIlllIlIlIlIIIllI.matchesItemStack(llllllllllIlllIlIlllIlIlIlIIlIIl, llllllllllIlllIlIlllIlIlIlIIIIll, llllllllllIlllIlIlllIlIlIlIIIlll)) {
                    return llllllllllIlllIlIlllIlIlIlIIIllI.getLocation();
                }
            }
        }
        return null;
    }
    
    static {
        NONE = new ItemOverrideList();
    }
    
    private ItemOverrideList() {
        this.overrides = (List<ItemOverride>)Lists.newArrayList();
    }
}
