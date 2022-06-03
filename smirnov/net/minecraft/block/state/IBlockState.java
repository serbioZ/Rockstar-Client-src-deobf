// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state;

import net.minecraft.block.Block;
import java.util.Collection;
import net.minecraft.block.properties.IProperty;
import com.google.common.collect.ImmutableMap;

public interface IBlockState extends IBlockProperties, IBlockBehaviors
{
    ImmutableMap<IProperty<?>, Comparable<?>> getProperties();
    
     <T extends Comparable<T>, V extends T> IBlockState withProperty(final IProperty<T> p0, final V p1);
    
     <T extends Comparable<T>> IBlockState cycleProperty(final IProperty<T> p0);
    
    Collection<IProperty<?>> getPropertyNames();
    
    Block getBlock();
    
     <T extends Comparable<T>> T getValue(final IProperty<T> p0);
}
