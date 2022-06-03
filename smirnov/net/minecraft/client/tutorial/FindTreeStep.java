// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.tutorial;

import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.world.GameType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentTranslation;
import com.google.common.collect.Sets;
import net.minecraft.init.Blocks;
import net.minecraft.client.gui.toasts.TutorialToast;
import net.minecraft.block.Block;
import java.util.Set;
import net.minecraft.util.text.ITextComponent;

public class FindTreeStep implements ITutorialStep
{
    private final /* synthetic */ Tutorial field_193271_d;
    private static final /* synthetic */ ITextComponent field_193270_c;
    private static final /* synthetic */ Set<Block> field_193268_a;
    private static final /* synthetic */ ITextComponent field_193269_b;
    private /* synthetic */ int field_193273_f;
    private /* synthetic */ TutorialToast field_193272_e;
    
    static {
        field_193268_a = Sets.newHashSet((Object[])new Block[] { Blocks.LOG, Blocks.LOG2, Blocks.LEAVES, Blocks.LEAVES2 });
        field_193269_b = new TextComponentTranslation("tutorial.find_tree.title", new Object[0]);
        field_193270_c = new TextComponentTranslation("tutorial.find_tree.description", new Object[0]);
    }
    
    public FindTreeStep(final Tutorial lllllllllllIllIllIlIlllllIIllllI) {
        this.field_193271_d = lllllllllllIllIllIlIlllllIIllllI;
    }
    
    public static boolean func_194070_a(final EntityPlayerSP lllllllllllIllIllIlIllllIlllIIlI) {
        for (final Block lllllllllllIllIllIlIllllIlllIIIl : FindTreeStep.field_193268_a) {
            final StatBase lllllllllllIllIllIlIllllIlllIIII = StatList.getBlockStats(lllllllllllIllIllIlIllllIlllIIIl);
            if (lllllllllllIllIllIlIllllIlllIIII != null && lllllllllllIllIllIlIllllIlllIIlI.getStatFileWriter().readStat(lllllllllllIllIllIlIllllIlllIIII) > 0) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void func_193252_a(final ItemStack lllllllllllIllIllIlIllllIllllIIl) {
        for (final Block lllllllllllIllIllIlIllllIllllIll : FindTreeStep.field_193268_a) {
            if (lllllllllllIllIllIlIllllIllllIIl.getItem() == Item.getItemFromBlock(lllllllllllIllIllIlIllllIllllIll)) {
                this.field_193271_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
            }
        }
    }
    
    @Override
    public void func_193246_a(final WorldClient lllllllllllIllIllIlIlllllIIIlIII, final RayTraceResult lllllllllllIllIllIlIlllllIIIIIll) {
        if (lllllllllllIllIllIlIlllllIIIIIll.typeOfHit == RayTraceResult.Type.BLOCK && lllllllllllIllIllIlIlllllIIIIIll.getBlockPos() != null) {
            final IBlockState lllllllllllIllIllIlIlllllIIIIllI = lllllllllllIllIllIlIlllllIIIlIII.getBlockState(lllllllllllIllIllIlIlllllIIIIIll.getBlockPos());
            if (FindTreeStep.field_193268_a.contains(lllllllllllIllIllIlIlllllIIIIllI.getBlock())) {
                this.field_193271_d.func_193292_a(TutorialSteps.PUNCH_TREE);
            }
        }
    }
    
    @Override
    public void func_193245_a() {
        ++this.field_193273_f;
        if (this.field_193271_d.func_194072_f() != GameType.SURVIVAL) {
            this.field_193271_d.func_193292_a(TutorialSteps.NONE);
        }
        else {
            if (this.field_193273_f == 1) {
                final EntityPlayerSP lllllllllllIllIllIlIlllllIIlIllI = this.field_193271_d.func_193295_e().player;
                if (lllllllllllIllIllIlIlllllIIlIllI != null) {
                    for (final Block lllllllllllIllIllIlIlllllIIlIlIl : FindTreeStep.field_193268_a) {
                        if (lllllllllllIllIllIlIlllllIIlIllI.inventory.hasItemStack(new ItemStack(lllllllllllIllIllIlIlllllIIlIlIl))) {
                            this.field_193271_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
                            return;
                        }
                    }
                    if (func_194070_a(lllllllllllIllIllIlIlllllIIlIllI)) {
                        this.field_193271_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
                        return;
                    }
                }
            }
            if (this.field_193273_f >= 6000 && this.field_193272_e == null) {
                this.field_193272_e = new TutorialToast(TutorialToast.Icons.TREE, FindTreeStep.field_193269_b, FindTreeStep.field_193270_c, false);
                this.field_193271_d.func_193295_e().func_193033_an().func_192988_a(this.field_193272_e);
            }
        }
    }
    
    @Override
    public void func_193248_b() {
        if (this.field_193272_e != null) {
            this.field_193272_e.func_193670_a();
            this.field_193272_e = null;
        }
    }
}
