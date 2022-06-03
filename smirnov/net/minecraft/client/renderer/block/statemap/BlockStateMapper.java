// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.statemap;

import java.util.Collection;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Sets;
import java.util.Collections;
import net.minecraft.util.ResourceLocation;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import java.util.Set;
import net.minecraft.block.Block;
import java.util.Map;

public class BlockStateMapper
{
    private final /* synthetic */ Map<Block, IStateMapper> blockStateMap;
    private final /* synthetic */ Set<Block> setBuiltInBlocks;
    
    public void registerBlockStateMapper(final Block llllllllllllIlIllIllIlIIlIIlllIl, final IStateMapper llllllllllllIlIllIllIlIIlIIlllII) {
        this.blockStateMap.put(llllllllllllIlIllIllIlIIlIIlllIl, llllllllllllIlIllIllIlIIlIIlllII);
    }
    
    public Map<IBlockState, ModelResourceLocation> putAllStateModelLocations() {
        final Map<IBlockState, ModelResourceLocation> llllllllllllIlIllIllIlIIlIIlIIII = (Map<IBlockState, ModelResourceLocation>)Maps.newIdentityHashMap();
        for (final Block llllllllllllIlIllIllIlIIlIIIllll : Block.REGISTRY) {
            llllllllllllIlIllIllIlIIlIIlIIII.putAll(this.getVariants(llllllllllllIlIllIllIlIIlIIIllll));
        }
        return llllllllllllIlIllIllIlIIlIIlIIII;
    }
    
    public Set<ResourceLocation> getBlockstateLocations(final Block llllllllllllIlIllIllIlIIlIIIIIll) {
        if (this.setBuiltInBlocks.contains(llllllllllllIlIllIllIlIIlIIIIIll)) {
            return Collections.emptySet();
        }
        final IStateMapper llllllllllllIlIllIllIlIIlIIIIIlI = this.blockStateMap.get(llllllllllllIlIllIllIlIIlIIIIIll);
        if (llllllllllllIlIllIllIlIIlIIIIIlI == null) {
            return Collections.singleton(Block.REGISTRY.getNameForObject(llllllllllllIlIllIllIlIIlIIIIIll));
        }
        final Set<ResourceLocation> llllllllllllIlIllIllIlIIlIIIIIIl = (Set<ResourceLocation>)Sets.newHashSet();
        for (final ModelResourceLocation llllllllllllIlIllIllIlIIlIIIIIII : llllllllllllIlIllIllIlIIlIIIIIlI.putStateModelLocations(llllllllllllIlIllIllIlIIlIIIIIll).values()) {
            llllllllllllIlIllIllIlIIlIIIIIIl.add(new ResourceLocation(llllllllllllIlIllIllIlIIlIIIIIII.getResourceDomain(), llllllllllllIlIllIllIlIIlIIIIIII.getResourcePath()));
        }
        return llllllllllllIlIllIllIlIIlIIIIIIl;
    }
    
    public BlockStateMapper() {
        this.blockStateMap = (Map<Block, IStateMapper>)Maps.newIdentityHashMap();
        this.setBuiltInBlocks = (Set<Block>)Sets.newIdentityHashSet();
    }
    
    public Map<IBlockState, ModelResourceLocation> getVariants(final Block llllllllllllIlIllIllIlIIIlllIllI) {
        return this.setBuiltInBlocks.contains(llllllllllllIlIllIllIlIIIlllIllI) ? Collections.emptyMap() : ((IStateMapper)MoreObjects.firstNonNull((Object)this.blockStateMap.get(llllllllllllIlIllIllIlIIIlllIllI), (Object)new DefaultStateMapper())).putStateModelLocations(llllllllllllIlIllIllIlIIIlllIllI);
    }
    
    public void registerBuiltInBlocks(final Block... llllllllllllIlIllIllIlIIlIIlIllI) {
        Collections.addAll(this.setBuiltInBlocks, llllllllllllIlIllIllIlIIlIIlIllI);
    }
}
