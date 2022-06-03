// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import java.io.DataOutput;
import java.io.IOException;
import java.io.DataInput;

public abstract class NBTBase
{
    @Override
    public abstract String toString();
    
    public abstract NBTBase copy();
    
    public abstract byte getId();
    
    static {
        NBT_TYPES = new String[] { "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]", "LONG[]" };
    }
    
    public static String func_193581_j(final int lllllllllllllIIllIIIIlIlIlllllIl) {
        switch (lllllllllllllIIllIIIIlIlIlllllIl) {
            case 0: {
                return "TAG_End";
            }
            case 1: {
                return "TAG_Byte";
            }
            case 2: {
                return "TAG_Short";
            }
            case 3: {
                return "TAG_Int";
            }
            case 4: {
                return "TAG_Long";
            }
            case 5: {
                return "TAG_Float";
            }
            case 6: {
                return "TAG_Double";
            }
            case 7: {
                return "TAG_Byte_Array";
            }
            case 8: {
                return "TAG_String";
            }
            case 9: {
                return "TAG_List";
            }
            case 10: {
                return "TAG_Compound";
            }
            case 11: {
                return "TAG_Int_Array";
            }
            case 12: {
                return "TAG_Long_Array";
            }
            case 99: {
                return "Any Numeric Tag";
            }
            default: {
                return "UNKNOWN";
            }
        }
    }
    
    protected String getString() {
        return this.toString();
    }
    
    protected static NBTBase createNewByType(final byte lllllllllllllIIllIIIIlIllIIIIIII) {
        switch (lllllllllllllIIllIIIIlIllIIIIIII) {
            case 0: {
                return new NBTTagEnd();
            }
            case 1: {
                return new NBTTagByte();
            }
            case 2: {
                return new NBTTagShort();
            }
            case 3: {
                return new NBTTagInt();
            }
            case 4: {
                return new NBTTagLong();
            }
            case 5: {
                return new NBTTagFloat();
            }
            case 6: {
                return new NBTTagDouble();
            }
            case 7: {
                return new NBTTagByteArray();
            }
            case 8: {
                return new NBTTagString();
            }
            case 9: {
                return new NBTTagList();
            }
            case 10: {
                return new NBTTagCompound();
            }
            case 11: {
                return new NBTTagIntArray();
            }
            case 12: {
                return new NBTTagLongArray();
            }
            default: {
                return null;
            }
        }
    }
    
    public boolean hasNoTags() {
        return false;
    }
    
    abstract void read(final DataInput p0, final int p1, final NBTSizeTracker p2) throws IOException;
    
    @Override
    public int hashCode() {
        return this.getId();
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIllIIIIlIlIlllIlll) {
        return lllllllllllllIIllIIIIlIlIlllIlll instanceof NBTBase && this.getId() == ((NBTBase)lllllllllllllIIllIIIIlIlIlllIlll).getId();
    }
    
    abstract void write(final DataOutput p0) throws IOException;
}
