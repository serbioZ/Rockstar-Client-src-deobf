// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class WeightedSpawnerEntity extends WeightedRandom.Item
{
    private final /* synthetic */ NBTTagCompound nbt;
    
    public NBTTagCompound getNbt() {
        return this.nbt;
    }
    
    public WeightedSpawnerEntity(final NBTTagCompound llllllllllllllIIIIIIIllIIIlllllI) {
        this(llllllllllllllIIIIIIIllIIIlllllI.hasKey("Weight", 99) ? llllllllllllllIIIIIIIllIIIlllllI.getInteger("Weight") : 1, llllllllllllllIIIIIIIllIIIlllllI.getCompoundTag("Entity"));
    }
    
    public NBTTagCompound toCompoundTag() {
        final NBTTagCompound llllllllllllllIIIIIIIllIIIlIllll = new NBTTagCompound();
        if (!this.nbt.hasKey("id", 8)) {
            this.nbt.setString("id", "minecraft:pig");
        }
        else if (!this.nbt.getString("id").contains(":")) {
            this.nbt.setString("id", new ResourceLocation(this.nbt.getString("id")).toString());
        }
        llllllllllllllIIIIIIIllIIIlIllll.setTag("Entity", this.nbt);
        llllllllllllllIIIIIIIllIIIlIllll.setInteger("Weight", this.itemWeight);
        return llllllllllllllIIIIIIIllIIIlIllll;
    }
    
    public WeightedSpawnerEntity() {
        super(1);
        this.nbt = new NBTTagCompound();
        this.nbt.setString("id", "minecraft:pig");
    }
    
    public WeightedSpawnerEntity(final int llllllllllllllIIIIIIIllIIIllIlII, final NBTTagCompound llllllllllllllIIIIIIIllIIIllIIll) {
        super(llllllllllllllIIIIIIIllIIIllIlII);
        this.nbt = llllllllllllllIIIIIIIllIIIllIIll;
    }
}
