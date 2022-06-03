// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.tutorial;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.MovementInput;
import net.minecraft.world.GameType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentKeybind;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.MouseHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;

public class Tutorial
{
    @Nullable
    private /* synthetic */ ITutorialStep field_193305_b;
    private final /* synthetic */ Minecraft field_193304_a;
    
    public void func_193294_a(final WorldClient lllllllllllllllIIIlIlllIlllIIIII, final BlockPos lllllllllllllllIIIlIlllIllIlllll, final IBlockState lllllllllllllllIIIlIlllIlllIIIll, final float lllllllllllllllIIIlIlllIllIlllIl) {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193250_a(lllllllllllllllIIIlIlllIlllIIIII, lllllllllllllllIIIlIlllIllIlllll, lllllllllllllllIIIlIlllIlllIIIll, lllllllllllllllIIIlIlllIllIlllIl);
        }
    }
    
    public void func_193299_a(final MouseHelper lllllllllllllllIIIlIlllIllllIlIl) {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193249_a(lllllllllllllllIIIlIlllIllllIlIl);
        }
    }
    
    public static ITextComponent func_193291_a(final String lllllllllllllllIIIlIlllIlIllllII) {
        final TextComponentKeybind lllllllllllllllIIIlIlllIlIlllIll = new TextComponentKeybind("key." + lllllllllllllllIIIlIlllIlIllllII);
        lllllllllllllllIIIlIlllIlIlllIll.getStyle().setBold(true);
        return lllllllllllllllIIIlIlllIlIlllIll;
    }
    
    public void func_193292_a(final TutorialSteps lllllllllllllllIIIlIlllIllIIIlll) {
        this.field_193304_a.gameSettings.field_193631_S = lllllllllllllllIIIlIlllIllIIIlll;
        this.field_193304_a.gameSettings.saveOptions();
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193248_b();
            this.field_193305_b = lllllllllllllllIIIlIlllIllIIIlll.func_193309_a(this);
        }
    }
    
    public Tutorial(final Minecraft lllllllllllllllIIIlIllllIIIIIIIl) {
        this.field_193304_a = lllllllllllllllIIIlIllllIIIIIIIl;
    }
    
    public void func_193296_a() {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193251_c();
        }
    }
    
    public void func_193301_a(final ItemStack lllllllllllllllIIIlIlllIllIlIlII) {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193252_a(lllllllllllllllIIIlIlllIllIlIlII);
        }
    }
    
    public GameType func_194072_f() {
        return (this.field_193304_a.playerController == null) ? GameType.NOT_SET : this.field_193304_a.playerController.getCurrentGameType();
    }
    
    public void func_193303_d() {
        if (this.field_193305_b != null) {
            if (this.field_193304_a.world != null) {
                this.field_193305_b.func_193245_a();
            }
            else {
                this.func_193300_b();
            }
        }
        else if (this.field_193304_a.world != null) {
            this.func_193302_c();
        }
    }
    
    public Minecraft func_193295_e() {
        return this.field_193304_a;
    }
    
    public void func_193293_a(final MovementInput lllllllllllllllIIIlIlllIllllllIl) {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193247_a(lllllllllllllllIIIlIlllIllllllIl);
        }
    }
    
    public void func_193297_a(@Nullable final WorldClient lllllllllllllllIIIlIlllIllllIIII, @Nullable final RayTraceResult lllllllllllllllIIIlIlllIlllIllll) {
        if (this.field_193305_b != null && lllllllllllllllIIIlIlllIlllIllll != null && lllllllllllllllIIIlIlllIllllIIII != null) {
            this.field_193305_b.func_193246_a(lllllllllllllllIIIlIlllIllllIIII, lllllllllllllllIIIlIlllIlllIllll);
        }
    }
    
    public void func_193300_b() {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193248_b();
            this.field_193305_b = null;
        }
    }
    
    public void func_193302_c() {
        if (this.field_193305_b != null) {
            this.func_193300_b();
        }
        this.field_193305_b = this.field_193304_a.gameSettings.field_193631_S.func_193309_a(this);
    }
}
