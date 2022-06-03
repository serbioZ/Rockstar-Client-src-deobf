// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.tutorial;

import net.minecraft.util.MouseHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.ItemStack;

public interface ITutorialStep
{
    default void func_193252_a(final ItemStack llllllllllllIlIllIIlIlllIIlIlIll) {
    }
    
    default void func_193245_a() {
    }
    
    default void func_193246_a(final WorldClient llllllllllllIlIllIIlIlllIIllIlII, final RayTraceResult llllllllllllIlIllIIlIlllIIllIIll) {
    }
    
    default void func_193250_a(final WorldClient llllllllllllIlIllIIlIlllIIllIIIl, final BlockPos llllllllllllIlIllIIlIlllIIllIIII, final IBlockState llllllllllllIlIllIIlIlllIIlIllll, final float llllllllllllIlIllIIlIlllIIlIlllI) {
    }
    
    default void func_193247_a(final MovementInput llllllllllllIlIllIIlIlllIIlllIII) {
    }
    
    default void func_193248_b() {
    }
    
    default void func_193251_c() {
    }
    
    default void func_193249_a(final MouseHelper llllllllllllIlIllIIlIlllIIllIllI) {
    }
}
