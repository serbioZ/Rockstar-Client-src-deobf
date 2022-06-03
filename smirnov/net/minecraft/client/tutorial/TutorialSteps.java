// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.tutorial;

import java.util.function.Function;

public enum TutorialSteps
{
    CRAFT_PLANKS("craft_planks", (Function<Tutorial, T>)CraftPlanksStep::new), 
    OPEN_INVENTORY("open_inventory", (Function<Tutorial, T>)OpenInventoryStep::new), 
    PUNCH_TREE("punch_tree", (Function<Tutorial, T>)PunchTreeStep::new);
    
    private final /* synthetic */ Function<Tutorial, ? extends ITutorialStep> field_193317_h;
    
    NONE("none", (Function<Tutorial, T>)CompletedTutorialStep::new), 
    MOVEMENT("movement", (Function<Tutorial, T>)MovementStep::new), 
    FIND_TREE("find_tree", (Function<Tutorial, T>)FindTreeStep::new);
    
    private final /* synthetic */ String field_193316_g;
    
    public static TutorialSteps func_193307_a(final String lllllllllllIIlllIIIIIIIlIlIIlllI) {
        final float lllllllllllIIlllIIIIIIIlIlIIlIII;
        final Exception lllllllllllIIlllIIIIIIIlIlIIlIIl = (Exception)((TutorialSteps[])(Object)(lllllllllllIIlllIIIIIIIlIlIIlIII = (float)(Object)values())).length;
        for (short lllllllllllIIlllIIIIIIIlIlIIlIlI = 0; lllllllllllIIlllIIIIIIIlIlIIlIlI < lllllllllllIIlllIIIIIIIlIlIIlIIl; ++lllllllllllIIlllIIIIIIIlIlIIlIlI) {
            final TutorialSteps lllllllllllIIlllIIIIIIIlIlIIllIl = lllllllllllIIlllIIIIIIIlIlIIlIII[lllllllllllIIlllIIIIIIIlIlIIlIlI];
            if (lllllllllllIIlllIIIIIIIlIlIIllIl.field_193316_g.equals(lllllllllllIIlllIIIIIIIlIlIIlllI)) {
                return lllllllllllIIlllIIIIIIIlIlIIllIl;
            }
        }
        return TutorialSteps.NONE;
    }
    
    public String func_193308_a() {
        return this.field_193316_g;
    }
    
    private <T extends ITutorialStep> TutorialSteps(final String lllllllllllIIlllIIIIIIIlIllIIIll, final Function<Tutorial, T> lllllllllllIIlllIIIIIIIlIllIIIlI) {
        this.field_193316_g = lllllllllllIIlllIIIIIIIlIllIIIll;
        this.field_193317_h = lllllllllllIIlllIIIIIIIlIllIIIlI;
    }
    
    public ITutorialStep func_193309_a(final Tutorial lllllllllllIIlllIIIIIIIlIlIllIIl) {
        return (ITutorialStep)this.field_193317_h.apply(lllllllllllIIlllIIIIIIIlIlIllIIl);
    }
}
