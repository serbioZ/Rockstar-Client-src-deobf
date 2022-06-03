// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.advancements;

import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.RenderItem;

enum AdvancementTabType
{
    private final /* synthetic */ int field_192660_f;
    
    LEFT("LEFT", 2, 0, 64, 32, 28, 5);
    
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType;
    
    BELOW("BELOW", 1, 84, 0, 28, 32, 8);
    
    private final /* synthetic */ int field_192662_h;
    
    ABOVE("ABOVE", 0, 0, 0, 28, 32, 8);
    
    private final /* synthetic */ int field_192661_g;
    
    RIGHT("RIGHT", 3, 96, 64, 32, 28, 5);
    
    private final /* synthetic */ int field_192664_j;
    private final /* synthetic */ int field_192663_i;
    
    public int func_192653_b(final int llllllllllllIlIIIIllIIIllIIIllIl) {
        switch ($SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType()[this.ordinal()]) {
            case 1: {
                return -this.field_192663_i + 4;
            }
            case 2: {
                return 136;
            }
            case 3: {
                return this.field_192663_i * llllllllllllIlIIIIllIIIllIIIllIl;
            }
            case 4: {
                return this.field_192663_i * llllllllllllIlIIIIllIIIllIIIllIl;
            }
            default: {
                throw new UnsupportedOperationException("Don't know what this tab type is!" + this);
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType() {
        final int[] $switch_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType = AdvancementTabType.$SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType;
        if ($switch_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType != null) {
            return $switch_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType;
        }
        final Exception llllllllllllIlIIIIllIIIlIllIlIll = (Object)new int[values().length];
        try {
            llllllllllllIlIIIIllIIIlIllIlIll[AdvancementTabType.ABOVE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIIIIllIIIlIllIlIll[AdvancementTabType.BELOW.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIlIIIIllIIIlIllIlIll[AdvancementTabType.LEFT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIlIIIIllIIIlIllIlIll[AdvancementTabType.RIGHT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return AdvancementTabType.$SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType = (int[])(Object)llllllllllllIlIIIIllIIIlIllIlIll;
    }
    
    public int func_192648_a(final int llllllllllllIlIIIIllIIIllIIlIIll) {
        switch ($SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType()[this.ordinal()]) {
            case 1: {
                return (this.field_192662_h + 4) * llllllllllllIlIIIIllIIIllIIlIIll;
            }
            case 2: {
                return (this.field_192662_h + 4) * llllllllllllIlIIIIllIIIllIIlIIll;
            }
            case 3: {
                return -this.field_192662_h + 4;
            }
            case 4: {
                return 248;
            }
            default: {
                throw new UnsupportedOperationException("Don't know what this tab type is!" + this);
            }
        }
    }
    
    public void func_192652_a(final int llllllllllllIlIIIIllIIIllIIlllll, final int llllllllllllIlIIIIllIIIllIIllllI, final int llllllllllllIlIIIIllIIIllIlIIlIl, final RenderItem llllllllllllIlIIIIllIIIllIlIIlII, final ItemStack llllllllllllIlIIIIllIIIllIlIIIll) {
        int llllllllllllIlIIIIllIIIllIlIIIlI = llllllllllllIlIIIIllIIIllIIlllll + this.func_192648_a(llllllllllllIlIIIIllIIIllIlIIlIl);
        int llllllllllllIlIIIIllIIIllIlIIIIl = llllllllllllIlIIIIllIIIllIIllllI + this.func_192653_b(llllllllllllIlIIIIllIIIllIlIIlIl);
        switch ($SWITCH_TABLE$net$minecraft$client$gui$advancements$AdvancementTabType()[this.ordinal()]) {
            case 1: {
                llllllllllllIlIIIIllIIIllIlIIIlI += 6;
                llllllllllllIlIIIIllIIIllIlIIIIl += 9;
                break;
            }
            case 2: {
                llllllllllllIlIIIIllIIIllIlIIIlI += 6;
                llllllllllllIlIIIIllIIIllIlIIIIl += 6;
                break;
            }
            case 3: {
                llllllllllllIlIIIIllIIIllIlIIIlI += 10;
                llllllllllllIlIIIIllIIIllIlIIIIl += 5;
                break;
            }
            case 4: {
                llllllllllllIlIIIIllIIIllIlIIIlI += 6;
                llllllllllllIlIIIIllIIIllIlIIIIl += 5;
                break;
            }
        }
        llllllllllllIlIIIIllIIIllIlIIlII.renderItemAndEffectIntoGUI(null, llllllllllllIlIIIIllIIIllIlIIIll, llllllllllllIlIIIIllIIIllIlIIIlI, llllllllllllIlIIIIllIIIllIlIIIIl);
    }
    
    static {
        int llllllllllllIlIIIIllIIIllllIlIII = 0;
        final int llllllllllllIlIIIIllIIIllllIIIlI;
        final double llllllllllllIlIIIIllIIIllllIIIll = ((AdvancementTabType[])(Object)(llllllllllllIlIIIIllIIIllllIIIlI = (int)(Object)values())).length;
        for (Exception llllllllllllIlIIIIllIIIllllIIlII = (Exception)0; llllllllllllIlIIIIllIIIllllIIlII < llllllllllllIlIIIIllIIIllllIIIll; ++llllllllllllIlIIIIllIIIllllIIlII) {
            final AdvancementTabType llllllllllllIlIIIIllIIIllllIIlll = llllllllllllIlIIIIllIIIllllIIIlI[llllllllllllIlIIIIllIIIllllIIlII];
            llllllllllllIlIIIIllIIIllllIlIII += llllllllllllIlIIIIllIIIllllIIlll.field_192664_j;
        }
        field_192659_e = llllllllllllIlIIIIllIIIllllIlIII;
    }
    
    private AdvancementTabType(final String llllllllllllIlIIIIllIIIlllIlIIlI, final int llllllllllllIlIIIIllIIIlllIlIIIl, final int llllllllllllIlIIIIllIIIlllIlIIII, final int llllllllllllIlIIIIllIIIlllIIllll, final int llllllllllllIlIIIIllIIIlllIlIllI, final int llllllllllllIlIIIIllIIIlllIIllIl, final int llllllllllllIlIIIIllIIIlllIIllII) {
        this.field_192660_f = llllllllllllIlIIIIllIIIlllIlIIII;
        this.field_192661_g = llllllllllllIlIIIIllIIIlllIIllll;
        this.field_192662_h = llllllllllllIlIIIIllIIIlllIlIllI;
        this.field_192663_i = llllllllllllIlIIIIllIIIlllIIllIl;
        this.field_192664_j = llllllllllllIlIIIIllIIIlllIIllII;
    }
    
    public int func_192650_a() {
        return this.field_192664_j;
    }
    
    public void func_192651_a(final Gui llllllllllllIlIIIIllIIIllIllllll, final int llllllllllllIlIIIIllIIIllIlllllI, final int llllllllllllIlIIIIllIIIllIllllIl, final boolean llllllllllllIlIIIIllIIIllIllIlII, final int llllllllllllIlIIIIllIIIllIllIIll) {
        int llllllllllllIlIIIIllIIIllIlllIlI = this.field_192660_f;
        if (llllllllllllIlIIIIllIIIllIllIIll > 0) {
            llllllllllllIlIIIIllIIIllIlllIlI += this.field_192662_h;
        }
        if (llllllllllllIlIIIIllIIIllIllIIll == this.field_192664_j - 1) {
            llllllllllllIlIIIIllIIIllIlllIlI += this.field_192662_h;
        }
        final int llllllllllllIlIIIIllIIIllIlllIIl = llllllllllllIlIIIIllIIIllIllIlII ? (this.field_192661_g + this.field_192663_i) : this.field_192661_g;
        llllllllllllIlIIIIllIIIllIllllll.drawTexturedModalRect(llllllllllllIlIIIIllIIIllIlllllI + this.func_192648_a(llllllllllllIlIIIIllIIIllIllIIll), llllllllllllIlIIIIllIIIllIllllIl + this.func_192653_b(llllllllllllIlIIIIllIIIllIllIIll), llllllllllllIlIIIIllIIIllIlllIlI, llllllllllllIlIIIIllIIIllIlllIIl, this.field_192662_h, this.field_192663_i);
    }
    
    public boolean func_192654_a(final int llllllllllllIlIIIIllIIIllIIIIIll, final int llllllllllllIlIIIIllIIIlIllllIlI, final int llllllllllllIlIIIIllIIIllIIIIIIl, final int llllllllllllIlIIIIllIIIllIIIIIII, final int llllllllllllIlIIIIllIIIlIlllIlll) {
        final int llllllllllllIlIIIIllIIIlIllllllI = llllllllllllIlIIIIllIIIllIIIIIll + this.func_192648_a(llllllllllllIlIIIIllIIIllIIIIIIl);
        final int llllllllllllIlIIIIllIIIlIlllllIl = llllllllllllIlIIIIllIIIlIllllIlI + this.func_192653_b(llllllllllllIlIIIIllIIIllIIIIIIl);
        return llllllllllllIlIIIIllIIIllIIIIIII > llllllllllllIlIIIIllIIIlIllllllI && llllllllllllIlIIIIllIIIllIIIIIII < llllllllllllIlIIIIllIIIlIllllllI + this.field_192662_h && llllllllllllIlIIIIllIIIlIlllIlll > llllllllllllIlIIIIllIIIlIlllllIl && llllllllllllIlIIIIllIIIlIlllIlll < llllllllllllIlIIIIllIIIlIlllllIl + this.field_192663_i;
    }
}
