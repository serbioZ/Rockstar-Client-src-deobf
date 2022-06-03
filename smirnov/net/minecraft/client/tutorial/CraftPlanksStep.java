// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.tutorial;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.world.GameType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.client.gui.toasts.TutorialToast;

public class CraftPlanksStep implements ITutorialStep
{
    private /* synthetic */ int field_193290_e;
    private /* synthetic */ TutorialToast field_193289_d;
    private final /* synthetic */ Tutorial field_193288_c;
    private static final /* synthetic */ ITextComponent field_193286_a;
    private static final /* synthetic */ ITextComponent field_193287_b;
    
    @Override
    public void func_193245_a() {
        ++this.field_193290_e;
        if (this.field_193288_c.func_194072_f() != GameType.SURVIVAL) {
            this.field_193288_c.func_193292_a(TutorialSteps.NONE);
        }
        else {
            if (this.field_193290_e == 1) {
                final EntityPlayerSP lllllllllllllIlIlIlIlllllllIIIlI = this.field_193288_c.func_193295_e().player;
                if (lllllllllllllIlIlIlIlllllllIIIlI != null) {
                    if (lllllllllllllIlIlIlIlllllllIIIlI.inventory.hasItemStack(new ItemStack(Blocks.PLANKS))) {
                        this.field_193288_c.func_193292_a(TutorialSteps.NONE);
                        return;
                    }
                    if (func_194071_a(lllllllllllllIlIlIlIlllllllIIIlI)) {
                        this.field_193288_c.func_193292_a(TutorialSteps.NONE);
                        return;
                    }
                }
            }
            if (this.field_193290_e >= 1200 && this.field_193289_d == null) {
                this.field_193289_d = new TutorialToast(TutorialToast.Icons.WOODEN_PLANKS, CraftPlanksStep.field_193286_a, CraftPlanksStep.field_193287_b, false);
                this.field_193288_c.func_193295_e().func_193033_an().func_192988_a(this.field_193289_d);
            }
        }
    }
    
    static {
        field_193286_a = new TextComponentTranslation("tutorial.craft_planks.title", new Object[0]);
        field_193287_b = new TextComponentTranslation("tutorial.craft_planks.description", new Object[0]);
    }
    
    @Override
    public void func_193248_b() {
        if (this.field_193289_d != null) {
            this.field_193289_d.func_193670_a();
            this.field_193289_d = null;
        }
    }
    
    public CraftPlanksStep(final Tutorial lllllllllllllIlIlIlIlllllllIIllI) {
        this.field_193288_c = lllllllllllllIlIlIlIlllllllIIllI;
    }
    
    public static boolean func_194071_a(final EntityPlayerSP lllllllllllllIlIlIlIllllllIlIIlI) {
        final StatBase lllllllllllllIlIlIlIllllllIlIIll = StatList.getCraftStats(Item.getItemFromBlock(Blocks.PLANKS));
        return lllllllllllllIlIlIlIllllllIlIIll != null && lllllllllllllIlIlIlIllllllIlIIlI.getStatFileWriter().readStat(lllllllllllllIlIlIlIllllllIlIIll) > 0;
    }
    
    @Override
    public void func_193252_a(final ItemStack lllllllllllllIlIlIlIllllllIllIIl) {
        if (lllllllllllllIlIlIlIllllllIllIIl.getItem() == Item.getItemFromBlock(Blocks.PLANKS)) {
            this.field_193288_c.func_193292_a(TutorialSteps.NONE);
        }
    }
}
