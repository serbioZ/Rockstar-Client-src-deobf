// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model.multipart;

import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;
import net.minecraft.block.state.BlockStateContainer;

public interface ICondition
{
    Predicate<IBlockState> getPredicate(final BlockStateContainer p0);
}
