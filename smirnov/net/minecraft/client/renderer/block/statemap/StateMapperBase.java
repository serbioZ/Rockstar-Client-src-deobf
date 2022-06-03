// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.statemap;

import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.block.Block;
import com.google.common.collect.Maps;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import java.util.Map;

public abstract class StateMapperBase implements IStateMapper
{
    protected /* synthetic */ Map<IBlockState, ModelResourceLocation> mapStateModelLocations;
    
    public String getPropertyString(final Map<IProperty<?>, Comparable<?>> lllllllllllIlIllIllIIllIIlIllIIl) {
        final StringBuilder lllllllllllIlIllIllIIllIIlIlllIl = new StringBuilder();
        for (final Map.Entry<IProperty<?>, Comparable<?>> lllllllllllIlIllIllIIllIIlIlllII : lllllllllllIlIllIllIIllIIlIllIIl.entrySet()) {
            if (lllllllllllIlIllIllIIllIIlIlllIl.length() != 0) {
                lllllllllllIlIllIllIIllIIlIlllIl.append(",");
            }
            final IProperty<?> lllllllllllIlIllIllIIllIIlIllIll = lllllllllllIlIllIllIIllIIlIlllII.getKey();
            lllllllllllIlIllIllIIllIIlIlllIl.append(lllllllllllIlIllIllIIllIIlIllIll.getName());
            lllllllllllIlIllIllIIllIIlIlllIl.append("=");
            lllllllllllIlIllIllIIllIIlIlllIl.append(this.getPropertyName(lllllllllllIlIllIllIIllIIlIllIll, lllllllllllIlIllIllIIllIIlIlllII.getValue()));
        }
        if (lllllllllllIlIllIllIIllIIlIlllIl.length() == 0) {
            lllllllllllIlIllIllIIllIIlIlllIl.append("normal");
        }
        return lllllllllllIlIllIllIIllIIlIlllIl.toString();
    }
    
    private <T extends Comparable<T>> String getPropertyName(final IProperty<T> lllllllllllIlIllIllIIllIIlIIllll, final Comparable<?> lllllllllllIlIllIllIIllIIlIlIIII) {
        return lllllllllllIlIllIllIIllIIlIIllll.getName((T)lllllllllllIlIllIllIIllIIlIlIIII);
    }
    
    public StateMapperBase() {
        this.mapStateModelLocations = (Map<IBlockState, ModelResourceLocation>)Maps.newLinkedHashMap();
    }
    
    @Override
    public Map<IBlockState, ModelResourceLocation> putStateModelLocations(final Block lllllllllllIlIllIllIIllIIlIIIlII) {
        for (final IBlockState lllllllllllIlIllIllIIllIIlIIIllI : lllllllllllIlIllIllIIllIIlIIIlII.getBlockState().getValidStates()) {
            this.mapStateModelLocations.put(lllllllllllIlIllIllIIllIIlIIIllI, this.getModelResourceLocation(lllllllllllIlIllIllIIllIIlIIIllI));
        }
        return this.mapStateModelLocations;
    }
    
    protected abstract ModelResourceLocation getModelResourceLocation(final IBlockState p0);
}
