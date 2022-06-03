// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializer;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.util.vector.Quaternion;
import net.minecraft.client.renderer.GlStateManager;

public class ItemCameraTransforms
{
    public final /* synthetic */ ItemTransformVec3f head;
    public static /* synthetic */ float offsetRotationX;
    public final /* synthetic */ ItemTransformVec3f thirdperson_left;
    public static /* synthetic */ float offsetScaleX;
    public static /* synthetic */ float offsetTranslateX;
    public static /* synthetic */ float offsetScaleY;
    public static /* synthetic */ float offsetRotationY;
    public final /* synthetic */ ItemTransformVec3f fixed;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType;
    public static /* synthetic */ float offsetTranslateY;
    public static /* synthetic */ float offsetRotationZ;
    public static /* synthetic */ float offsetScaleZ;
    public final /* synthetic */ ItemTransformVec3f firstperson_left;
    public final /* synthetic */ ItemTransformVec3f thirdperson_right;
    public static /* synthetic */ float offsetTranslateZ;
    public final /* synthetic */ ItemTransformVec3f firstperson_right;
    public final /* synthetic */ ItemTransformVec3f gui;
    public final /* synthetic */ ItemTransformVec3f ground;
    
    public ItemCameraTransforms(final ItemCameraTransforms lllllllllllIllIlIIllIllllIlllIlI) {
        this.thirdperson_left = lllllllllllIllIlIIllIllllIlllIlI.thirdperson_left;
        this.thirdperson_right = lllllllllllIllIlIIllIllllIlllIlI.thirdperson_right;
        this.firstperson_left = lllllllllllIllIlIIllIllllIlllIlI.firstperson_left;
        this.firstperson_right = lllllllllllIllIlIIllIllllIlllIlI.firstperson_right;
        this.head = lllllllllllIllIlIIllIllllIlllIlI.head;
        this.gui = lllllllllllIllIlIIllIllllIlllIlI.gui;
        this.ground = lllllllllllIllIlIIllIllllIlllIlI.ground;
        this.fixed = lllllllllllIllIlIIllIllllIlllIlI.fixed;
    }
    
    public ItemTransformVec3f getTransform(final TransformType lllllllllllIllIlIIllIlllIlIlllIl) {
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType()[lllllllllllIllIlIIllIlllIlIlllIl.ordinal()]) {
            case 2: {
                return this.thirdperson_left;
            }
            case 3: {
                return this.thirdperson_right;
            }
            case 4: {
                return this.firstperson_left;
            }
            case 5: {
                return this.firstperson_right;
            }
            case 6: {
                return this.head;
            }
            case 7: {
                return this.gui;
            }
            case 8: {
                return this.ground;
            }
            case 9: {
                return this.fixed;
            }
            default: {
                return ItemTransformVec3f.DEFAULT;
            }
        }
    }
    
    public static void applyTransformSide(final ItemTransformVec3f lllllllllllIllIlIIllIllllIIlIIlI, final boolean lllllllllllIllIlIIllIllllIIIlIll) {
        if (lllllllllllIllIlIIllIllllIIlIIlI != ItemTransformVec3f.DEFAULT) {
            final int lllllllllllIllIlIIllIllllIIlIIII = lllllllllllIllIlIIllIllllIIIlIll ? -1 : 1;
            GlStateManager.translate(lllllllllllIllIlIIllIllllIIlIIII * (ItemCameraTransforms.offsetTranslateX + lllllllllllIllIlIIllIllllIIlIIlI.translation.x), ItemCameraTransforms.offsetTranslateY + lllllllllllIllIlIIllIllllIIlIIlI.translation.y, ItemCameraTransforms.offsetTranslateZ + lllllllllllIllIlIIllIllllIIlIIlI.translation.z);
            final float lllllllllllIllIlIIllIllllIIIllll = ItemCameraTransforms.offsetRotationX + lllllllllllIllIlIIllIllllIIlIIlI.rotation.x;
            float lllllllllllIllIlIIllIllllIIIlllI = ItemCameraTransforms.offsetRotationY + lllllllllllIllIlIIllIllllIIlIIlI.rotation.y;
            float lllllllllllIllIlIIllIllllIIIllIl = ItemCameraTransforms.offsetRotationZ + lllllllllllIllIlIIllIllllIIlIIlI.rotation.z;
            if (lllllllllllIllIlIIllIllllIIIlIll) {
                lllllllllllIllIlIIllIllllIIIlllI = -lllllllllllIllIlIIllIllllIIIlllI;
                lllllllllllIllIlIIllIllllIIIllIl = -lllllllllllIllIlIIllIllllIIIllIl;
            }
            GlStateManager.rotate(makeQuaternion(lllllllllllIllIlIIllIllllIIIllll, lllllllllllIllIlIIllIllllIIIlllI, lllllllllllIllIlIIllIllllIIIllIl));
            GlStateManager.scale(ItemCameraTransforms.offsetScaleX + lllllllllllIllIlIIllIllllIIlIIlI.scale.x, ItemCameraTransforms.offsetScaleY + lllllllllllIllIlIIllIllllIIlIIlI.scale.y, ItemCameraTransforms.offsetScaleZ + lllllllllllIllIlIIllIllllIIlIIlI.scale.z);
        }
    }
    
    public void applyTransform(final TransformType lllllllllllIllIlIIllIllllIIllIll) {
        applyTransformSide(this.getTransform(lllllllllllIllIlIIllIllllIIllIll), false);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType = ItemCameraTransforms.$SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType;
        if ($switch_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType != null) {
            return $switch_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType;
        }
        final short lllllllllllIllIlIIllIlllIlIlIlIl = (Object)new int[TransformType.values().length];
        try {
            lllllllllllIllIlIIllIlllIlIlIlIl[TransformType.FIRST_PERSON_LEFT_HAND.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIllIlIIllIlllIlIlIlIl[TransformType.FIRST_PERSON_RIGHT_HAND.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIllIlIIllIlllIlIlIlIl[TransformType.FIXED.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIllIlIIllIlllIlIlIlIl[TransformType.GROUND.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIllIlIIllIlllIlIlIlIl[TransformType.GUI.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIllIlIIllIlllIlIlIlIl[TransformType.HEAD.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllIllIlIIllIlllIlIlIlIl[TransformType.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllIllIlIIllIlllIlIlIlIl[TransformType.THIRD_PERSON_LEFT_HAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllIllIlIIllIlllIlIlIlIl[TransformType.THIRD_PERSON_RIGHT_HAND.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        return ItemCameraTransforms.$SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType = (int[])(Object)lllllllllllIllIlIIllIlllIlIlIlIl;
    }
    
    public boolean hasCustomTransform(final TransformType lllllllllllIllIlIIllIlllIlIllIIl) {
        return this.getTransform(lllllllllllIllIlIIllIlllIlIllIIl) != ItemTransformVec3f.DEFAULT;
    }
    
    public ItemCameraTransforms(final ItemTransformVec3f lllllllllllIllIlIIllIllllIlIllll, final ItemTransformVec3f lllllllllllIllIlIIllIllllIlIlllI, final ItemTransformVec3f lllllllllllIllIlIIllIllllIlIIlII, final ItemTransformVec3f lllllllllllIllIlIIllIllllIlIllII, final ItemTransformVec3f lllllllllllIllIlIIllIllllIlIlIll, final ItemTransformVec3f lllllllllllIllIlIIllIllllIlIIIIl, final ItemTransformVec3f lllllllllllIllIlIIllIllllIlIlIIl, final ItemTransformVec3f lllllllllllIllIlIIllIllllIIlllll) {
        this.thirdperson_left = lllllllllllIllIlIIllIllllIlIllll;
        this.thirdperson_right = lllllllllllIllIlIIllIllllIlIlllI;
        this.firstperson_left = lllllllllllIllIlIIllIllllIlIIlII;
        this.firstperson_right = lllllllllllIllIlIIllIllllIlIllII;
        this.head = lllllllllllIllIlIIllIllllIlIlIll;
        this.gui = lllllllllllIllIlIIllIllllIlIIIIl;
        this.ground = lllllllllllIllIlIIllIllllIlIlIIl;
        this.fixed = lllllllllllIllIlIIllIllllIIlllll;
    }
    
    static {
        DEFAULT = new ItemCameraTransforms();
    }
    
    private static Quaternion makeQuaternion(final float lllllllllllIllIlIIllIlllIllllIlI, final float lllllllllllIllIlIIllIlllIllIllIl, final float lllllllllllIllIlIIllIlllIllllIII) {
        final float lllllllllllIllIlIIllIlllIlllIlll = lllllllllllIllIlIIllIlllIllllIlI * 0.017453292f;
        final float lllllllllllIllIlIIllIlllIlllIllI = lllllllllllIllIlIIllIlllIllIllIl * 0.017453292f;
        final float lllllllllllIllIlIIllIlllIlllIlIl = lllllllllllIllIlIIllIlllIllllIII * 0.017453292f;
        final float lllllllllllIllIlIIllIlllIlllIlII = MathHelper.sin(0.5f * lllllllllllIllIlIIllIlllIlllIlll);
        final float lllllllllllIllIlIIllIlllIlllIIll = MathHelper.cos(0.5f * lllllllllllIllIlIIllIlllIlllIlll);
        final float lllllllllllIllIlIIllIlllIlllIIlI = MathHelper.sin(0.5f * lllllllllllIllIlIIllIlllIlllIllI);
        final float lllllllllllIllIlIIllIlllIlllIIIl = MathHelper.cos(0.5f * lllllllllllIllIlIIllIlllIlllIllI);
        final float lllllllllllIllIlIIllIlllIlllIIII = MathHelper.sin(0.5f * lllllllllllIllIlIIllIlllIlllIlIl);
        final float lllllllllllIllIlIIllIlllIllIllll = MathHelper.cos(0.5f * lllllllllllIllIlIIllIlllIlllIlIl);
        return new Quaternion(lllllllllllIllIlIIllIlllIlllIlII * lllllllllllIllIlIIllIlllIlllIIIl * lllllllllllIllIlIIllIlllIllIllll + lllllllllllIllIlIIllIlllIlllIIll * lllllllllllIllIlIIllIlllIlllIIlI * lllllllllllIllIlIIllIlllIlllIIII, lllllllllllIllIlIIllIlllIlllIIll * lllllllllllIllIlIIllIlllIlllIIlI * lllllllllllIllIlIIllIlllIllIllll - lllllllllllIllIlIIllIlllIlllIlII * lllllllllllIllIlIIllIlllIlllIIIl * lllllllllllIllIlIIllIlllIlllIIII, lllllllllllIllIlIIllIlllIlllIlII * lllllllllllIllIlIIllIlllIlllIIlI * lllllllllllIllIlIIllIlllIllIllll + lllllllllllIllIlIIllIlllIlllIIll * lllllllllllIllIlIIllIlllIlllIIIl * lllllllllllIllIlIIllIlllIlllIIII, lllllllllllIllIlIIllIlllIlllIIll * lllllllllllIllIlIIllIlllIlllIIIl * lllllllllllIllIlIIllIlllIllIllll - lllllllllllIllIlIIllIlllIlllIlII * lllllllllllIllIlIIllIlllIlllIIlI * lllllllllllIllIlIIllIlllIlllIIII);
    }
    
    private ItemCameraTransforms() {
        this(ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT);
    }
    
    static class Deserializer implements JsonDeserializer<ItemCameraTransforms>
    {
        private ItemTransformVec3f getTransform(final JsonDeserializationContext lllllllllllIIlIIlIlllIIIllIIIIIl, final JsonObject lllllllllllIIlIIlIlllIIIllIIIIII, final String lllllllllllIIlIIlIlllIIIlIllllll) {
            return (ItemTransformVec3f)(lllllllllllIIlIIlIlllIIIllIIIIII.has(lllllllllllIIlIIlIlllIIIlIllllll) ? lllllllllllIIlIIlIlllIIIllIIIIIl.deserialize(lllllllllllIIlIIlIlllIIIllIIIIII.get(lllllllllllIIlIIlIlllIIIlIllllll), (Type)ItemTransformVec3f.class) : ItemTransformVec3f.DEFAULT);
        }
        
        public ItemCameraTransforms deserialize(final JsonElement lllllllllllIIlIIlIlllIIIllIlllIl, final Type lllllllllllIIlIIlIlllIIIllIlllII, final JsonDeserializationContext lllllllllllIIlIIlIlllIIIllIIllll) throws JsonParseException {
            final JsonObject lllllllllllIIlIIlIlllIIIllIllIlI = lllllllllllIIlIIlIlllIIIllIlllIl.getAsJsonObject();
            final ItemTransformVec3f lllllllllllIIlIIlIlllIIIllIllIIl = this.getTransform(lllllllllllIIlIIlIlllIIIllIIllll, lllllllllllIIlIIlIlllIIIllIllIlI, "thirdperson_righthand");
            ItemTransformVec3f lllllllllllIIlIIlIlllIIIllIllIII = this.getTransform(lllllllllllIIlIIlIlllIIIllIIllll, lllllllllllIIlIIlIlllIIIllIllIlI, "thirdperson_lefthand");
            if (lllllllllllIIlIIlIlllIIIllIllIII == ItemTransformVec3f.DEFAULT) {
                lllllllllllIIlIIlIlllIIIllIllIII = lllllllllllIIlIIlIlllIIIllIllIIl;
            }
            final ItemTransformVec3f lllllllllllIIlIIlIlllIIIllIlIlll = this.getTransform(lllllllllllIIlIIlIlllIIIllIIllll, lllllllllllIIlIIlIlllIIIllIllIlI, "firstperson_righthand");
            ItemTransformVec3f lllllllllllIIlIIlIlllIIIllIlIllI = this.getTransform(lllllllllllIIlIIlIlllIIIllIIllll, lllllllllllIIlIIlIlllIIIllIllIlI, "firstperson_lefthand");
            if (lllllllllllIIlIIlIlllIIIllIlIllI == ItemTransformVec3f.DEFAULT) {
                lllllllllllIIlIIlIlllIIIllIlIllI = lllllllllllIIlIIlIlllIIIllIlIlll;
            }
            final ItemTransformVec3f lllllllllllIIlIIlIlllIIIllIlIlIl = this.getTransform(lllllllllllIIlIIlIlllIIIllIIllll, lllllllllllIIlIIlIlllIIIllIllIlI, "head");
            final ItemTransformVec3f lllllllllllIIlIIlIlllIIIllIlIlII = this.getTransform(lllllllllllIIlIIlIlllIIIllIIllll, lllllllllllIIlIIlIlllIIIllIllIlI, "gui");
            final ItemTransformVec3f lllllllllllIIlIIlIlllIIIllIlIIll = this.getTransform(lllllllllllIIlIIlIlllIIIllIIllll, lllllllllllIIlIIlIlllIIIllIllIlI, "ground");
            final ItemTransformVec3f lllllllllllIIlIIlIlllIIIllIlIIlI = this.getTransform(lllllllllllIIlIIlIlllIIIllIIllll, lllllllllllIIlIIlIlllIIIllIllIlI, "fixed");
            return new ItemCameraTransforms(lllllllllllIIlIIlIlllIIIllIllIII, lllllllllllIIlIIlIlllIIIllIllIIl, lllllllllllIIlIIlIlllIIIllIlIllI, lllllllllllIIlIIlIlllIIIllIlIlll, lllllllllllIIlIIlIlllIIIllIlIlIl, lllllllllllIIlIIlIlllIIIllIlIlII, lllllllllllIIlIIlIlllIIIllIlIIll, lllllllllllIIlIIlIlllIIIllIlIIlI);
        }
    }
    
    public enum TransformType
    {
        FIRST_PERSON_LEFT_HAND("FIRST_PERSON_LEFT_HAND", 3), 
        HEAD("HEAD", 5), 
        GROUND("GROUND", 7), 
        FIRST_PERSON_RIGHT_HAND("FIRST_PERSON_RIGHT_HAND", 4), 
        FIXED("FIXED", 8), 
        THIRD_PERSON_RIGHT_HAND("THIRD_PERSON_RIGHT_HAND", 2), 
        THIRD_PERSON_LEFT_HAND("THIRD_PERSON_LEFT_HAND", 1), 
        NONE("NONE", 0), 
        GUI("GUI", 6);
        
        private TransformType(final String lllllllllllllllIlllIIIlIlIlllIll, final int lllllllllllllllIlllIIIlIlIlllIlI) {
        }
    }
}
