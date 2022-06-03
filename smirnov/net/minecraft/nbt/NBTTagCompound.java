// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import org.apache.logging.log4j.LogManager;
import java.util.Objects;
import com.google.common.collect.Maps;
import java.util.Set;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import java.io.DataOutput;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.DataInput;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import com.google.common.collect.Lists;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.Map;
import org.apache.logging.log4j.Logger;

public class NBTTagCompound extends NBTBase
{
    private static final /* synthetic */ Logger field_191551_b;
    private final /* synthetic */ Map<String, NBTBase> tagMap;
    private static final /* synthetic */ Pattern field_193583_c;
    
    public void setUniqueId(final String lllllllllllIIIlIllIIIlIlIlIlIlll, final UUID lllllllllllIIIlIllIIIlIlIlIlIllI) {
        this.setLong(String.valueOf(lllllllllllIIIlIllIIIlIlIlIlIlll) + "Most", lllllllllllIIIlIllIIIlIlIlIlIllI.getMostSignificantBits());
        this.setLong(String.valueOf(lllllllllllIIIlIllIIIlIlIlIlIlll) + "Least", lllllllllllIIIlIllIIIlIlIlIlIllI.getLeastSignificantBits());
    }
    
    public NBTBase getTag(final String lllllllllllIIIlIllIIIlIlIIIIllIl) {
        return this.tagMap.get(lllllllllllIIIlIllIIIlIlIIIIllIl);
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllIIIlIllIIIlIIIlllllIl = new StringBuilder("{");
        Collection<String> lllllllllllIIIlIllIIIlIIIlllllII = this.tagMap.keySet();
        if (NBTTagCompound.field_191551_b.isDebugEnabled()) {
            final List<String> lllllllllllIIIlIllIIIlIIIllllIll = (List<String>)Lists.newArrayList((Iterable)this.tagMap.keySet());
            Collections.sort(lllllllllllIIIlIllIIIlIIIllllIll);
            lllllllllllIIIlIllIIIlIIIlllllII = lllllllllllIIIlIllIIIlIIIllllIll;
        }
        for (final String lllllllllllIIIlIllIIIlIIIllllIlI : lllllllllllIIIlIllIIIlIIIlllllII) {
            if (lllllllllllIIIlIllIIIlIIIlllllIl.length() != 1) {
                lllllllllllIIIlIllIIIlIIIlllllIl.append(',');
            }
            lllllllllllIIIlIllIIIlIIIlllllIl.append(func_193582_s(lllllllllllIIIlIllIIIlIIIllllIlI)).append(':').append(this.tagMap.get(lllllllllllIIIlIllIIIlIIIllllIlI));
        }
        return lllllllllllIIIlIllIIIlIIIlllllIl.append('}').toString();
    }
    
    public boolean getBoolean(final String lllllllllllIIIlIllIIIlIIlIIIlIlI) {
        return this.getByte(lllllllllllIIIlIllIIIlIIlIIIlIlI) != 0;
    }
    
    public long getLong(final String lllllllllllIIIlIllIIIlIIllIlIIIl) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIllIlIIIl, 99)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIllIlIIIl).getLong();
            }
        }
        catch (ClassCastException ex) {}
        return 0L;
    }
    
    private static String readKey(final DataInput lllllllllllIIIlIllIIIlIIIIllllIl, final NBTSizeTracker lllllllllllIIIlIllIIIlIIIIllllII) throws IOException {
        return lllllllllllIIIlIllIIIlIIIIllllIl.readUTF();
    }
    
    public void setShort(final String lllllllllllIIIlIllIIIlIlIlllIIlI, final short lllllllllllIIIlIllIIIlIlIllIlllI) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIlIlllIIlI, new NBTTagShort(lllllllllllIIIlIllIIIlIlIllIlllI));
    }
    
    public byte getTagId(final String lllllllllllIIIlIllIIIlIlIIIIIllI) {
        final NBTBase lllllllllllIIIlIllIIIlIlIIIIIlIl = this.tagMap.get(lllllllllllIIIlIllIIIlIlIIIIIllI);
        return (byte)((lllllllllllIIIlIllIIIlIlIIIIIlIl == null) ? 0 : lllllllllllIIIlIllIIIlIlIIIIIlIl.getId());
    }
    
    public void setByteArray(final String lllllllllllIIIlIllIIIlIlIIlIIlll, final byte[] lllllllllllIIIlIllIIIlIlIIlIIIll) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIlIIlIIlll, new NBTTagByteArray(lllllllllllIIIlIllIIIlIlIIlIIIll));
    }
    
    public void setBoolean(final String lllllllllllIIIlIllIIIlIlIIIlIIlI, final boolean lllllllllllIIIlIllIIIlIlIIIlIIIl) {
        this.setByte(lllllllllllIIIlIllIIIlIlIIIlIIlI, (byte)(lllllllllllIIIlIllIIIlIlIIIlIIIl ? 1 : 0));
    }
    
    public void setLong(final String lllllllllllIIIlIllIIIlIlIllIIIII, final long lllllllllllIIIlIllIIIlIlIlIlllII) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIlIllIIIII, new NBTTagLong(lllllllllllIIIlIllIIIlIlIlIlllII));
    }
    
    public int getInteger(final String lllllllllllIIIlIllIIIlIIllIllIll) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIllIllIll, 99)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIllIllIll).getInt();
            }
        }
        catch (ClassCastException ex) {}
        return 0;
    }
    
    public void merge(final NBTTagCompound lllllllllllIIIlIllIIIlIIIIIlIIll) {
        for (final String lllllllllllIIIlIllIIIlIIIIIlIlll : lllllllllllIIIlIllIIIlIIIIIlIIll.tagMap.keySet()) {
            final NBTBase lllllllllllIIIlIllIIIlIIIIIlIllI = lllllllllllIIIlIllIIIlIIIIIlIIll.tagMap.get(lllllllllllIIIlIllIIIlIIIIIlIlll);
            if (lllllllllllIIIlIllIIIlIIIIIlIllI.getId() == 10) {
                if (this.hasKey(lllllllllllIIIlIllIIIlIIIIIlIlll, 10)) {
                    final NBTTagCompound lllllllllllIIIlIllIIIlIIIIIlIlIl = this.getCompoundTag(lllllllllllIIIlIllIIIlIIIIIlIlll);
                    lllllllllllIIIlIllIIIlIIIIIlIlIl.merge((NBTTagCompound)lllllllllllIIIlIllIIIlIIIIIlIllI);
                }
                else {
                    this.setTag(lllllllllllIIIlIllIIIlIIIIIlIlll, lllllllllllIIIlIllIIIlIIIIIlIllI.copy());
                }
            }
            else {
                this.setTag(lllllllllllIIIlIllIIIlIIIIIlIlll, lllllllllllIIIlIllIIIlIIIIIlIllI.copy());
            }
        }
    }
    
    public void setByte(final String lllllllllllIIIlIllIIIlIlIllllIll, final byte lllllllllllIIIlIllIIIlIlIlllIlll) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIlIllllIll, new NBTTagByte(lllllllllllIIIlIllIIIlIlIlllIlll));
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.tagMap.hashCode();
    }
    
    public boolean hasKey(final String lllllllllllIIIlIllIIIlIIllllIIlI, final int lllllllllllIIIlIllIIIlIIllllIlIl) {
        final int lllllllllllIIIlIllIIIlIIllllIlII = this.getTagId(lllllllllllIIIlIllIIIlIIllllIIlI);
        return lllllllllllIIIlIllIIIlIIllllIlII == lllllllllllIIIlIllIIIlIIllllIlIl || (lllllllllllIIIlIllIIIlIIllllIlIl == 99 && (lllllllllllIIIlIllIIIlIIllllIlII == 1 || lllllllllllIIIlIllIIIlIIllllIlII == 2 || lllllllllllIIIlIllIIIlIIllllIlII == 3 || lllllllllllIIIlIllIIIlIIllllIlII == 4 || lllllllllllIIIlIllIIIlIIllllIlII == 5 || lllllllllllIIIlIllIIIlIIllllIlII == 6));
    }
    
    public void setInteger(final String lllllllllllIIIlIllIIIlIlIllIlIIl, final int lllllllllllIIIlIllIIIlIlIllIlIII) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIlIllIlIIl, new NBTTagInt(lllllllllllIIIlIllIIIlIlIllIlIII));
    }
    
    @Override
    public byte getId() {
        return 10;
    }
    
    @Nullable
    public UUID getUniqueId(final String lllllllllllIIIlIllIIIlIlIlIIllll) {
        return new UUID(this.getLong(String.valueOf(lllllllllllIIIlIllIIIlIlIlIIllll) + "Most"), this.getLong(String.valueOf(lllllllllllIIIlIllIIIlIlIlIIllll) + "Least"));
    }
    
    public int getSize() {
        return this.tagMap.size();
    }
    
    private static void writeEntry(final String lllllllllllIIIlIllIIIlIIIlIIlIII, final NBTBase lllllllllllIIIlIllIIIlIIIlIIIlll, final DataOutput lllllllllllIIIlIllIIIlIIIlIIIllI) throws IOException {
        lllllllllllIIIlIllIIIlIIIlIIIllI.writeByte(lllllllllllIIIlIllIIIlIIIlIIIlll.getId());
        if (lllllllllllIIIlIllIIIlIIIlIIIlll.getId() != 0) {
            lllllllllllIIIlIllIIIlIIIlIIIllI.writeUTF(lllllllllllIIIlIllIIIlIIIlIIlIII);
            lllllllllllIIIlIllIIIlIIIlIIIlll.write(lllllllllllIIIlIllIIIlIIIlIIIllI);
        }
    }
    
    private CrashReport createCrashReport(final String lllllllllllIIIlIllIIIlIIIllIIlII, final int lllllllllllIIIlIllIIIlIIIllIlIIl, final ClassCastException lllllllllllIIIlIllIIIlIIIllIIIlI) {
        final CrashReport lllllllllllIIIlIllIIIlIIIllIIlll = CrashReport.makeCrashReport(lllllllllllIIIlIllIIIlIIIllIIIlI, "Reading NBT data");
        final CrashReportCategory lllllllllllIIIlIllIIIlIIIllIIllI = lllllllllllIIIlIllIIIlIIIllIIlll.makeCategoryDepth("Corrupt NBT tag", 1);
        lllllllllllIIIlIllIIIlIIIllIIllI.setDetail("Tag type found", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return NBTBase.NBT_TYPES[NBTTagCompound.this.tagMap.get(lllllllllllIIIlIllIIIlIIIllIIlII).getId()];
            }
        });
        lllllllllllIIIlIllIIIlIIIllIIllI.setDetail("Tag type expected", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return NBTBase.NBT_TYPES[lllllllllllIIIlIllIIIlIIIllIlIIl];
            }
        });
        lllllllllllIIIlIllIIIlIIIllIIllI.addCrashSection("Tag name", lllllllllllIIIlIllIIIlIIIllIIlII);
        return lllllllllllIIIlIllIIIlIIIllIIlll;
    }
    
    static NBTBase readNBT(final byte lllllllllllIIIlIllIIIlIIIIlIlIII, final String lllllllllllIIIlIllIIIlIIIIlIIlll, final DataInput lllllllllllIIIlIllIIIlIIIIlIllll, final int lllllllllllIIIlIllIIIlIIIIlIIlIl, final NBTSizeTracker lllllllllllIIIlIllIIIlIIIIlIllIl) throws IOException {
        final NBTBase lllllllllllIIIlIllIIIlIIIIlIllII = NBTBase.createNewByType(lllllllllllIIIlIllIIIlIIIIlIlIII);
        try {
            lllllllllllIIIlIllIIIlIIIIlIllII.read(lllllllllllIIIlIllIIIlIIIIlIllll, lllllllllllIIIlIllIIIlIIIIlIIlIl, lllllllllllIIIlIllIIIlIIIIlIllIl);
            return lllllllllllIIIlIllIIIlIIIIlIllII;
        }
        catch (IOException lllllllllllIIIlIllIIIlIIIIlIlIll) {
            final CrashReport lllllllllllIIIlIllIIIlIIIIlIlIlI = CrashReport.makeCrashReport(lllllllllllIIIlIllIIIlIIIIlIlIll, "Loading NBT data");
            final CrashReportCategory lllllllllllIIIlIllIIIlIIIIlIlIIl = lllllllllllIIIlIllIIIlIIIIlIlIlI.makeCategory("NBT Tag");
            lllllllllllIIIlIllIIIlIIIIlIlIIl.addCrashSection("Tag name", lllllllllllIIIlIllIIIlIIIIlIIlll);
            lllllllllllIIIlIllIIIlIIIIlIlIIl.addCrashSection("Tag type", lllllllllllIIIlIllIIIlIIIIlIlIII);
            throw new ReportedException(lllllllllllIIIlIllIIIlIIIIlIlIlI);
        }
    }
    
    public boolean hasKey(final String lllllllllllIIIlIllIIIlIIllllllII) {
        return this.tagMap.containsKey(lllllllllllIIIlIllIIIlIIllllllII);
    }
    
    public byte[] getByteArray(final String lllllllllllIIIlIllIIIlIIlIllIIII) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIlIllIIII, 7)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIlIllIIII).getByteArray();
            }
        }
        catch (ClassCastException lllllllllllIIIlIllIIIlIIlIllIIlI) {
            throw new ReportedException(this.createCrashReport(lllllllllllIIIlIllIIIlIIlIllIIII, 7, lllllllllllIIIlIllIIIlIIlIllIIlI));
        }
        return new byte[0];
    }
    
    @Override
    void read(final DataInput lllllllllllIIIlIllIIIlIllIIlIlIl, final int lllllllllllIIIlIllIIIlIllIIlllII, final NBTSizeTracker lllllllllllIIIlIllIIIlIllIIllIll) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: invokevirtual   net/minecraft/nbt/NBTSizeTracker.read:(J)V
        //     7: iload_2         /* lllllllllllIIIlIllIIIlIllIIlIlII */
        //     8: sipush          512
        //    11: if_icmple       25
        //    14: new             Ljava/lang/RuntimeException;
        //    17: dup            
        //    18: ldc_w           "Tried to read NBT tag with too high complexity, depth > 512"
        //    21: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //    24: athrow         
        //    25: aload_0         /* lllllllllllIIIlIllIIIlIllIIlIllI */
        //    26: getfield        net/minecraft/nbt/NBTTagCompound.tagMap:Ljava/util/Map;
        //    29: invokeinterface java/util/Map.clear:()V
        //    34: goto            98
        //    37: aload_1         /* lllllllllllIIIlIllIIIlIllIIlllIl */
        //    38: aload_3         /* lllllllllllIIIlIllIIIlIllIIlIIll */
        //    39: invokestatic    net/minecraft/nbt/NBTTagCompound.readKey:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)Ljava/lang/String;
        //    42: astore          lllllllllllIIIlIllIIIlIllIIllIII
        //    44: aload_3         /* lllllllllllIIIlIllIIIlIllIIlIIll */
        //    45: sipush          224
        //    48: bipush          16
        //    50: aload           lllllllllllIIIlIllIIIlIllIIllIII
        //    52: invokevirtual   java/lang/String.length:()I
        //    55: imul           
        //    56: iadd           
        //    57: i2l            
        //    58: invokevirtual   net/minecraft/nbt/NBTSizeTracker.read:(J)V
        //    61: iload           lllllllllllIIIlIllIIIlIllIIllIlI
        //    63: aload           lllllllllllIIIlIllIIIlIllIIllIII
        //    65: aload_1         /* lllllllllllIIIlIllIIIlIllIIlllIl */
        //    66: iload_2         /* lllllllllllIIIlIllIIIlIllIIlIlII */
        //    67: iconst_1       
        //    68: iadd           
        //    69: aload_3         /* lllllllllllIIIlIllIIIlIllIIlIIll */
        //    70: invokestatic    net/minecraft/nbt/NBTTagCompound.readNBT:(BLjava/lang/String;Ljava/io/DataInput;ILnet/minecraft/nbt/NBTSizeTracker;)Lnet/minecraft/nbt/NBTBase;
        //    73: astore          lllllllllllIIIlIllIIIlIllIIlIlll
        //    75: aload_0         /* lllllllllllIIIlIllIIIlIllIIlIllI */
        //    76: getfield        net/minecraft/nbt/NBTTagCompound.tagMap:Ljava/util/Map;
        //    79: aload           lllllllllllIIIlIllIIIlIllIIllIII
        //    81: aload           lllllllllllIIIlIllIIIlIllIIlIlll
        //    83: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    88: ifnull          98
        //    91: aload_3         /* lllllllllllIIIlIllIIIlIllIIlIIll */
        //    92: ldc2_w          288
        //    95: invokevirtual   net/minecraft/nbt/NBTSizeTracker.read:(J)V
        //    98: aload_1         /* lllllllllllIIIlIllIIIlIllIIlllIl */
        //    99: aload_3         /* lllllllllllIIIlIllIIIlIllIIlIIll */
        //   100: invokestatic    net/minecraft/nbt/NBTTagCompound.readType:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)B
        //   103: dup            
        //   104: istore          lllllllllllIIIlIllIIIlIllIIllIIl
        //   106: ifne            37
        //   109: return         
        //    Exceptions:
        //  throws java.io.IOException
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public NBTTagCompound copy() {
        final NBTTagCompound lllllllllllIIIlIllIIIlIIIlIllIlI = new NBTTagCompound();
        for (final String lllllllllllIIIlIllIIIlIIIlIllIIl : this.tagMap.keySet()) {
            lllllllllllIIIlIllIIIlIIIlIllIlI.setTag(lllllllllllIIIlIllIIIlIIIlIllIIl, this.tagMap.get(lllllllllllIIIlIllIIIlIIIlIllIIl).copy());
        }
        return lllllllllllIIIlIllIIIlIIIlIllIlI;
    }
    
    public Set<String> getKeySet() {
        return this.tagMap.keySet();
    }
    
    public NBTTagList getTagList(final String lllllllllllIIIlIllIIIlIIlIIlIIlI, final int lllllllllllIIIlIllIIIlIIlIIlIllI) {
        try {
            if (this.getTagId(lllllllllllIIIlIllIIIlIIlIIlIIlI) == 9) {
                final NBTTagList lllllllllllIIIlIllIIIlIIlIIlIlIl = this.tagMap.get(lllllllllllIIIlIllIIIlIIlIIlIIlI);
                if (!lllllllllllIIIlIllIIIlIIlIIlIlIl.hasNoTags() && lllllllllllIIIlIllIIIlIIlIIlIlIl.getTagType() != lllllllllllIIIlIllIIIlIIlIIlIllI) {
                    return new NBTTagList();
                }
                return lllllllllllIIIlIllIIIlIIlIIlIlIl;
            }
        }
        catch (ClassCastException lllllllllllIIIlIllIIIlIIlIIlIlII) {
            throw new ReportedException(this.createCrashReport(lllllllllllIIIlIllIIIlIIlIIlIIlI, 9, lllllllllllIIIlIllIIIlIIlIIlIlII));
        }
        return new NBTTagList();
    }
    
    public NBTTagCompound getCompoundTag(final String lllllllllllIIIlIllIIIlIIlIIllllI) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIlIIllllI, 10)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIlIIllllI);
            }
        }
        catch (ClassCastException lllllllllllIIIlIllIIIlIIlIlIIIII) {
            throw new ReportedException(this.createCrashReport(lllllllllllIIIlIllIIIlIIlIIllllI, 10, lllllllllllIIIlIllIIIlIIlIlIIIII));
        }
        return new NBTTagCompound();
    }
    
    public float getFloat(final String lllllllllllIIIlIllIIIlIIllIIlIll) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIllIIlIll, 99)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIllIIlIll).getFloat();
            }
        }
        catch (ClassCastException ex) {}
        return 0.0f;
    }
    
    private static byte readType(final DataInput lllllllllllIIIlIllIIIlIIIlIIIIIl, final NBTSizeTracker lllllllllllIIIlIllIIIlIIIlIIIIII) throws IOException {
        return lllllllllllIIIlIllIIIlIIIlIIIIIl.readByte();
    }
    
    public boolean hasUniqueId(final String lllllllllllIIIlIllIIIlIlIlIIIlll) {
        return this.hasKey(String.valueOf(lllllllllllIIIlIllIIIlIlIlIIIlll) + "Most", 99) && this.hasKey(String.valueOf(lllllllllllIIIlIllIIIlIlIlIIIlll) + "Least", 99);
    }
    
    public void setDouble(final String lllllllllllIIIlIllIIIlIlIIllIllI, final double lllllllllllIIIlIllIIIlIlIIlllIII) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIlIIllIllI, new NBTTagDouble(lllllllllllIIIlIllIIIlIlIIlllIII));
    }
    
    public void removeTag(final String lllllllllllIIIlIllIIIlIIlIIIIllI) {
        this.tagMap.remove(lllllllllllIIIlIllIIIlIIlIIIIllI);
    }
    
    public String getString(final String lllllllllllIIIlIllIIIlIIlIlllIll) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIlIlllIll, 8)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIlIlllIll).getString();
            }
        }
        catch (ClassCastException ex) {}
        return "";
    }
    
    public NBTTagCompound() {
        this.tagMap = (Map<String, NBTBase>)Maps.newHashMap();
    }
    
    public void setTag(final String lllllllllllIIIlIllIIIlIllIIIIIIl, final NBTBase lllllllllllIIIlIllIIIlIllIIIIIII) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIllIIIIIIl, lllllllllllIIIlIllIIIlIllIIIIIII);
    }
    
    @Override
    public boolean equals(final Object lllllllllllIIIlIllIIIlIIIlIIllll) {
        return super.equals(lllllllllllIIIlIllIIIlIIIlIIllll) && Objects.equals(this.tagMap.entrySet(), ((NBTTagCompound)lllllllllllIIIlIllIIIlIIIlIIllll).tagMap.entrySet());
    }
    
    static {
        field_191551_b = LogManager.getLogger();
        field_193583_c = Pattern.compile("[A-Za-z0-9._+-]+");
    }
    
    @Override
    public boolean hasNoTags() {
        return this.tagMap.isEmpty();
    }
    
    @Override
    void write(final DataOutput lllllllllllIIIlIllIIIlIllIlIllIl) throws IOException {
        for (final String lllllllllllIIIlIllIIIlIllIlIllII : this.tagMap.keySet()) {
            final NBTBase lllllllllllIIIlIllIIIlIllIlIlIll = this.tagMap.get(lllllllllllIIIlIllIIIlIllIlIllII);
            writeEntry(lllllllllllIIIlIllIIIlIllIlIllII, lllllllllllIIIlIllIIIlIllIlIlIll, lllllllllllIIIlIllIIIlIllIlIllIl);
        }
        lllllllllllIIIlIllIIIlIllIlIllIl.writeByte(0);
    }
    
    public double getDouble(final String lllllllllllIIIlIllIIIlIIllIIIIIl) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIllIIIIIl, 99)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIllIIIIIl).getDouble();
            }
        }
        catch (ClassCastException ex) {}
        return 0.0;
    }
    
    public short getShort(final String lllllllllllIIIlIllIIIlIIlllIIIIl) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIlllIIIIl, 99)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIlllIIIIl).getShort();
            }
        }
        catch (ClassCastException ex) {}
        return 0;
    }
    
    public void setString(final String lllllllllllIIIlIllIIIlIlIIllIIII, final String lllllllllllIIIlIllIIIlIlIIlIllII) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIlIIllIIII, new NBTTagString(lllllllllllIIIlIllIIIlIlIIlIllII));
    }
    
    public void setFloat(final String lllllllllllIIIlIllIIIlIlIlIIIIlI, final float lllllllllllIIIlIllIIIlIlIlIIIIIl) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIlIlIIIIlI, new NBTTagFloat(lllllllllllIIIlIllIIIlIlIlIIIIIl));
    }
    
    public void setIntArray(final String lllllllllllIIIlIllIIIlIlIIIllIll, final int[] lllllllllllIIIlIllIIIlIlIIIlllIl) {
        this.tagMap.put(lllllllllllIIIlIllIIIlIlIIIllIll, new NBTTagIntArray(lllllllllllIIIlIllIIIlIlIIIlllIl));
    }
    
    protected static String func_193582_s(final String lllllllllllIIIlIllIIIlIIIIIIllII) {
        return NBTTagCompound.field_193583_c.matcher(lllllllllllIIIlIllIIIlIIIIIIllII).matches() ? lllllllllllIIIlIllIIIlIIIIIIllII : NBTTagString.func_193588_a(lllllllllllIIIlIllIIIlIIIIIIllII);
    }
    
    public int[] getIntArray(final String lllllllllllIIIlIllIIIlIIlIlIIlll) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIlIlIIlll, 11)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIlIlIIlll).getIntArray();
            }
        }
        catch (ClassCastException lllllllllllIIIlIllIIIlIIlIlIlIIl) {
            throw new ReportedException(this.createCrashReport(lllllllllllIIIlIllIIIlIIlIlIIlll, 11, lllllllllllIIIlIllIIIlIIlIlIlIIl));
        }
        return new int[0];
    }
    
    public byte getByte(final String lllllllllllIIIlIllIIIlIIlllIlIIl) {
        try {
            if (this.hasKey(lllllllllllIIIlIllIIIlIIlllIlIIl, 99)) {
                return this.tagMap.get(lllllllllllIIIlIllIIIlIIlllIlIIl).getByte();
            }
        }
        catch (ClassCastException ex) {}
        return 0;
    }
}
