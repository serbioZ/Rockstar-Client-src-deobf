// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;

public class LayerBipedArmor extends LayerArmorBase<ModelBiped>
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot;
    
    @Override
    protected void initArmor() {
        this.modelLeggings = (T)new ModelBiped(0.5f);
        this.modelArmor = (T)new ModelBiped(1.0f);
    }
    
    public LayerBipedArmor(final RenderLivingBase<?> lllllllllllllIlIIllIlIIllllIlIlI) {
        super(lllllllllllllIlIIllIlIIllllIlIlI);
    }
    
    @Override
    protected void setModelSlotVisible(final ModelBiped lllllllllllllIlIIllIlIIlllIlllIl, final EntityEquipmentSlot lllllllllllllIlIIllIlIIlllIlllII) {
        this.setModelVisible(lllllllllllllIlIIllIlIIlllIlllIl);
        switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot()[lllllllllllllIlIIllIlIIlllIlllII.ordinal()]) {
            case 6: {
                lllllllllllllIlIIllIlIIlllIlllIl.bipedHead.showModel = true;
                lllllllllllllIlIIllIlIIlllIlllIl.bipedHeadwear.showModel = true;
                break;
            }
            case 5: {
                lllllllllllllIlIIllIlIIlllIlllIl.bipedBody.showModel = true;
                lllllllllllllIlIIllIlIIlllIlllIl.bipedRightArm.showModel = true;
                lllllllllllllIlIIllIlIIlllIlllIl.bipedLeftArm.showModel = true;
                break;
            }
            case 4: {
                lllllllllllllIlIIllIlIIlllIlllIl.bipedBody.showModel = true;
                lllllllllllllIlIIllIlIIlllIlllIl.bipedRightLeg.showModel = true;
                lllllllllllllIlIIllIlIIlllIlllIl.bipedLeftLeg.showModel = true;
                break;
            }
            case 3: {
                lllllllllllllIlIIllIlIIlllIlllIl.bipedRightLeg.showModel = true;
                lllllllllllllIlIIllIlIIlllIlllIl.bipedLeftLeg.showModel = true;
                break;
            }
        }
    }
    
    protected void setModelVisible(final ModelBiped lllllllllllllIlIIllIlIIlllIllIIl) {
        lllllllllllllIlIIllIlIIlllIllIIl.setInvisible(false);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot() {
        final int[] $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot = LayerBipedArmor.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot;
        if ($switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot != null) {
            return $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot;
        }
        final int lllllllllllllIlIIllIlIIlllIlIIII = (Object)new int[EntityEquipmentSlot.values().length];
        try {
            lllllllllllllIlIIllIlIIlllIlIIII[EntityEquipmentSlot.CHEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIlIIlllIlIIII[EntityEquipmentSlot.FEET.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIlIIlllIlIIII[EntityEquipmentSlot.HEAD.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIllIlIIlllIlIIII[EntityEquipmentSlot.LEGS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIIllIlIIlllIlIIII[EntityEquipmentSlot.MAINHAND.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlIIllIlIIlllIlIIII[EntityEquipmentSlot.OFFHAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return LayerBipedArmor.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot = (int[])(Object)lllllllllllllIlIIllIlIIlllIlIIII;
    }
}
