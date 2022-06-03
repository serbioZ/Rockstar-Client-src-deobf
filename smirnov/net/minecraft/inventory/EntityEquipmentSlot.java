// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.inventory;

public enum EntityEquipmentSlot
{
    HEAD("HEAD", 5, Type.ARMOR, 3, 4, "head");
    
    private final /* synthetic */ String name;
    private final /* synthetic */ Type slotType;
    
    LEGS("LEGS", 3, Type.ARMOR, 1, 2, "legs"), 
    FEET("FEET", 2, Type.ARMOR, 0, 1, "feet");
    
    private final /* synthetic */ int slotIndex;
    private final /* synthetic */ int index;
    
    OFFHAND("OFFHAND", 1, Type.HAND, 1, 5, "offhand"), 
    MAINHAND("MAINHAND", 0, Type.HAND, 0, 0, "mainhand"), 
    CHEST("CHEST", 4, Type.ARMOR, 2, 3, "chest");
    
    public int getIndex() {
        return this.index;
    }
    
    public int getSlotIndex() {
        return this.slotIndex;
    }
    
    private EntityEquipmentSlot(final String lllllllllllIlIIllIIIlIIlllIlIllI, final int lllllllllllIlIIllIIIlIIlllIlIlIl, final Type lllllllllllIlIIllIIIlIIlllIlIlII, final int lllllllllllIlIIllIIIlIIlllIlIIll, final int lllllllllllIlIIllIIIlIIlllIllIIl, final String lllllllllllIlIIllIIIlIIlllIllIII) {
        this.slotType = lllllllllllIlIIllIIIlIIlllIlIlII;
        this.index = lllllllllllIlIIllIIIlIIlllIlIIll;
        this.slotIndex = lllllllllllIlIIllIIIlIIlllIllIIl;
        this.name = lllllllllllIlIIllIIIlIIlllIllIII;
    }
    
    public static EntityEquipmentSlot fromString(final String lllllllllllIlIIllIIIlIIllIllllll) {
        final byte lllllllllllIlIIllIIIlIIllIlllIIl;
        final String lllllllllllIlIIllIIIlIIllIlllIlI = (String)((EntityEquipmentSlot[])(Object)(lllllllllllIlIIllIIIlIIllIlllIIl = (byte)(Object)values())).length;
        for (boolean lllllllllllIlIIllIIIlIIllIlllIll = false; lllllllllllIlIIllIIIlIIllIlllIll < lllllllllllIlIIllIIIlIIllIlllIlI; ++lllllllllllIlIIllIIIlIIllIlllIll) {
            final EntityEquipmentSlot lllllllllllIlIIllIIIlIIllIlllllI = lllllllllllIlIIllIIIlIIllIlllIIl[lllllllllllIlIIllIIIlIIllIlllIll];
            if (lllllllllllIlIIllIIIlIIllIlllllI.getName().equals(lllllllllllIlIIllIIIlIIllIllllll)) {
                return lllllllllllIlIIllIIIlIIllIlllllI;
            }
        }
        throw new IllegalArgumentException("Invalid slot '" + lllllllllllIlIIllIIIlIIllIllllll + "'");
    }
    
    public Type getSlotType() {
        return this.slotType;
    }
    
    public String getName() {
        return this.name;
    }
    
    public enum Type
    {
        HAND("HAND", 0), 
        ARMOR("ARMOR", 1);
        
        private Type(final String llllllllllIllllllllIIIlIllIllIII, final int llllllllllIllllllllIIIlIllIlIlll) {
        }
    }
}
