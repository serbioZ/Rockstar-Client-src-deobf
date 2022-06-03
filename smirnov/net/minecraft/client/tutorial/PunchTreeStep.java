// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.tutorial;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.world.GameType;
import net.minecraft.util.text.TextComponentTranslation;
import com.google.common.collect.Sets;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import java.util.Set;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.gui.toasts.TutorialToast;

public class PunchTreeStep implements ITutorialStep
{
    private final /* synthetic */ Tutorial field_193277_d;
    private /* synthetic */ TutorialToast field_193278_e;
    private static final /* synthetic */ ITextComponent field_193275_b;
    private static final /* synthetic */ ITextComponent field_193276_c;
    private static final /* synthetic */ Set<Block> field_193274_a;
    private /* synthetic */ int field_193279_f;
    private /* synthetic */ int field_193280_g;
    
    @Override
    public void func_193252_a(final ItemStack lllllllllllllIllIIIllllIIlIlIIll) {
        for (final Block lllllllllllllIllIIIllllIIlIlIlIl : PunchTreeStep.field_193274_a) {
            if (lllllllllllllIllIIIllllIIlIlIIll.getItem() == Item.getItemFromBlock(lllllllllllllIllIIIllllIIlIlIlIl)) {
                this.field_193277_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
            }
        }
    }
    
    static {
        field_193274_a = Sets.newHashSet((Object[])new Block[] { Blocks.LOG, Blocks.LOG2 });
        field_193275_b = new TextComponentTranslation("tutorial.punch_tree.title", new Object[0]);
        field_193276_c = new TextComponentTranslation("tutorial.punch_tree.description", new Object[] { Tutorial.func_193291_a("attack") });
    }
    
    @Override
    public void func_193248_b() {
        if (this.field_193278_e != null) {
            this.field_193278_e.func_193670_a();
            this.field_193278_e = null;
        }
    }
    
    @Override
    public void func_193245_a() {
        ++this.field_193279_f;
        if (this.field_193277_d.func_194072_f() != GameType.SURVIVAL) {
            this.field_193277_d.func_193292_a(TutorialSteps.NONE);
        }
        else {
            if (this.field_193279_f == 1) {
                final EntityPlayerSP lllllllllllllIllIIIllllIIlllIIlI = this.field_193277_d.func_193295_e().player;
                if (lllllllllllllIllIIIllllIIlllIIlI != null) {
                    for (final Block lllllllllllllIllIIIllllIIlllIIIl : PunchTreeStep.field_193274_a) {
                        if (lllllllllllllIllIIIllllIIlllIIlI.inventory.hasItemStack(new ItemStack(lllllllllllllIllIIIllllIIlllIIIl))) {
                            this.field_193277_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
                            return;
                        }
                    }
                    if (FindTreeStep.func_194070_a(lllllllllllllIllIIIllllIIlllIIlI)) {
                        this.field_193277_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
                        return;
                    }
                }
            }
            if ((this.field_193279_f >= 600 || this.field_193280_g > 3) && this.field_193278_e == null) {
                this.field_193278_e = new TutorialToast(TutorialToast.Icons.TREE, PunchTreeStep.field_193275_b, PunchTreeStep.field_193276_c, true);
                this.field_193277_d.func_193295_e().func_193033_an().func_192988_a(this.field_193278_e);
            }
        }
    }
    
    public PunchTreeStep(final Tutorial lllllllllllllIllIIIllllIIllllIII) {
        this.field_193277_d = lllllllllllllIllIIIllllIIllllIII;
    }
    
    @Override
    public void func_193250_a(final WorldClient lllllllllllllIllIIIllllIIllIIlII, final BlockPos lllllllllllllIllIIIllllIIllIIIll, final IBlockState lllllllllllllIllIIIllllIIllIIIlI, final float lllllllllllllIllIIIllllIIllIIIIl) {
        final boolean lllllllllllllIllIIIllllIIllIIIII = PunchTreeStep.field_193274_a.contains(lllllllllllllIllIIIllllIIllIIIlI.getBlock());
        if (lllllllllllllIllIIIllllIIllIIIII && lllllllllllllIllIIIllllIIllIIIIl > 0.0f) {
            if (this.field_193278_e != null) {
                this.field_193278_e.func_193669_a(lllllllllllllIllIIIllllIIllIIIIl);
            }
            if (lllllllllllllIllIIIllllIIllIIIIl >= 1.0f) {
                this.field_193277_d.func_193292_a(TutorialSteps.OPEN_INVENTORY);
            }
        }
        else if (this.field_193278_e != null) {
            this.field_193278_e.func_193669_a(0.0f);
        }
        else if (lllllllllllllIllIIIllllIIllIIIII) {
            ++this.field_193280_g;
        }
    }
}
