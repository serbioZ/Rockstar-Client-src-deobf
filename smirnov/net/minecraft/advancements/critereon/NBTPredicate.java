// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements.critereon;

import net.minecraft.command.CommandBase;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.nbt.NBTBase;
import net.minecraft.item.ItemStack;
import com.google.gson.JsonElement;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;

public class NBTPredicate
{
    @Nullable
    private final /* synthetic */ NBTTagCompound field_193480_b;
    public static final /* synthetic */ NBTPredicate field_193479_a;
    
    public static NBTPredicate func_193476_a(@Nullable final JsonElement lllllllllllIIlIIIIIIIllllllIIlII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnull          61
        //     4: aload_0         /* lllllllllllIIlIIIIIIIllllllIlIII */
        //     5: invokevirtual   com/google/gson/JsonElement.isJsonNull:()Z
        //     8: ifne            61
        //    11: aload_0         /* lllllllllllIIlIIIIIIIllllllIlIII */
        //    12: ldc             "nbt"
        //    14: invokestatic    net/minecraft/util/JsonUtils.getString:(Lcom/google/gson/JsonElement;Ljava/lang/String;)Ljava/lang/String;
        //    17: invokestatic    net/minecraft/nbt/JsonToNBT.getTagFromJson:(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;
        //    20: astore_1        /* lllllllllllIIlIIIIIIIllllllIIlll */
        //    21: goto            52
        //    24: astore_2        /* lllllllllllIIlIIIIIIIllllllIIIlI */
        //    25: new             Lcom/google/gson/JsonSyntaxException;
        //    28: dup            
        //    29: new             Ljava/lang/StringBuilder;
        //    32: dup            
        //    33: ldc             "Invalid nbt tag: "
        //    35: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    38: aload_2         /* lllllllllllIIlIIIIIIIllllllIIlIl */
        //    39: invokevirtual   net/minecraft/nbt/NBTException.getMessage:()Ljava/lang/String;
        //    42: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    45: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    48: invokespecial   com/google/gson/JsonSyntaxException.<init>:(Ljava/lang/String;)V
        //    51: athrow         
        //    52: new             Lnet/minecraft/advancements/critereon/NBTPredicate;
        //    55: dup            
        //    56: aload_1         /* lllllllllllIIlIIIIIIIllllllIIllI */
        //    57: invokespecial   net/minecraft/advancements/critereon/NBTPredicate.<init>:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //    60: areturn        
        //    61: getstatic       net/minecraft/advancements/critereon/NBTPredicate.field_193479_a:Lnet/minecraft/advancements/critereon/NBTPredicate;
        //    64: areturn        
        //    RuntimeVisibleTypeAnnotations: 00 01 16 00 00 00 07 00 00
        //    StackMapTable: 00 03 58 07 00 0D FC 00 1B 07 00 4A FA 00 08
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  11     21     24     52     Lnet/minecraft/nbt/NBTException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean func_193478_a(final ItemStack lllllllllllIIlIIIIIIIllllllllIII) {
        return this == NBTPredicate.field_193479_a || this.func_193477_a(lllllllllllIIlIIIIIIIllllllllIII.getTagCompound());
    }
    
    public boolean func_193477_a(@Nullable final NBTBase lllllllllllIIlIIIIIIIllllllIlllI) {
        if (lllllllllllIIlIIIIIIIllllllIlllI == null) {
            return this == NBTPredicate.field_193479_a;
        }
        return this.field_193480_b == null || NBTUtil.areNBTEquals(this.field_193480_b, lllllllllllIIlIIIIIIIllllllIlllI, true);
    }
    
    public NBTPredicate(@Nullable final NBTTagCompound lllllllllllIIlIIIIIIIllllllllllI) {
        this.field_193480_b = lllllllllllIIlIIIIIIIllllllllllI;
    }
    
    static {
        field_193479_a = new NBTPredicate(null);
    }
    
    public boolean func_193475_a(final Entity lllllllllllIIlIIIIIIIlllllllIIlI) {
        return this == NBTPredicate.field_193479_a || this.func_193477_a(CommandBase.entityToNBT(lllllllllllIIlIIIIIIIlllllllIIlI));
    }
}
