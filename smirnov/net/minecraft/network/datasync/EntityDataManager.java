// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.datasync;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.LogManager;
import io.netty.handler.codec.EncoderException;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import javax.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import net.minecraft.network.PacketBuffer;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.locks.ReadWriteLock;
import net.minecraft.entity.Entity;
import java.util.Map;

public class EntityDataManager
{
    private final /* synthetic */ Map<Integer, DataEntry<?>> entries;
    private /* synthetic */ boolean dirty;
    private /* synthetic */ boolean empty;
    private static final /* synthetic */ Map<Class<? extends Entity>, Integer> NEXT_ID_MAP;
    private final /* synthetic */ Entity entity;
    private final /* synthetic */ ReadWriteLock lock;
    private static final /* synthetic */ Logger LOGGER;
    
    @Nullable
    public static List<DataEntry<?>> readEntries(final PacketBuffer llllllllllllIllIIIIIlllllIllIlll) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1        /* llllllllllllIllIIIIIlllllIllllII */
        //     2: goto            83
        //     5: aload_1         /* llllllllllllIllIIIIIlllllIllllII */
        //     6: ifnonnull       13
        //     9: invokestatic    com/google/common/collect/Lists.newArrayList:()Ljava/util/ArrayList;
        //    12: astore_1        /* llllllllllllIllIIIIIlllllIllllII */
        //    13: aload_0         /* llllllllllllIllIIIIIlllllIllllIl */
        //    14: invokevirtual   net/minecraft/network/PacketBuffer.readVarIntFromBuffer:()I
        //    17: istore_3        /* llllllllllllIllIIIIIlllllIlllIIl */
        //    18: iload_3         /* llllllllllllIllIIIIIlllllIlllIIl */
        //    19: invokestatic    net/minecraft/network/datasync/DataSerializers.getSerializer:(I)Lnet/minecraft/network/datasync/DataSerializer;
        //    22: astore          llllllllllllIllIIIIIlllllIlllIII
        //    24: aload           llllllllllllIllIIIIIlllllIlllIII
        //    26: ifnonnull       53
        //    29: new             Lio/netty/handler/codec/DecoderException;
        //    32: dup            
        //    33: new             Ljava/lang/StringBuilder;
        //    36: dup            
        //    37: ldc             "Unknown serializer type "
        //    39: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    42: iload_3         /* llllllllllllIllIIIIIlllllIlllIIl */
        //    43: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    46: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    49: invokespecial   io/netty/handler/codec/DecoderException.<init>:(Ljava/lang/String;)V
        //    52: athrow         
        //    53: aload_1         /* llllllllllllIllIIIIIlllllIllllII */
        //    54: new             Lnet/minecraft/network/datasync/EntityDataManager$DataEntry;
        //    57: dup            
        //    58: aload           llllllllllllIllIIIIIlllllIlllIII
        //    60: iload_2         /* llllllllllllIllIIIIIlllllIlllIll */
        //    61: invokeinterface net/minecraft/network/datasync/DataSerializer.createKey:(I)Lnet/minecraft/network/datasync/DataParameter;
        //    66: aload           llllllllllllIllIIIIIlllllIlllIII
        //    68: aload_0         /* llllllllllllIllIIIIIlllllIllllIl */
        //    69: invokeinterface net/minecraft/network/datasync/DataSerializer.read:(Lnet/minecraft/network/PacketBuffer;)Ljava/lang/Object;
        //    74: invokespecial   net/minecraft/network/datasync/EntityDataManager$DataEntry.<init>:(Lnet/minecraft/network/datasync/DataParameter;Ljava/lang/Object;)V
        //    77: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //    82: pop            
        //    83: aload_0         /* llllllllllllIllIIIIIlllllIllllIl */
        //    84: invokevirtual   net/minecraft/network/PacketBuffer.readUnsignedByte:()S
        //    87: dup            
        //    88: istore_2        /* llllllllllllIllIIIIIlllllIllIlIl */
        //    89: sipush          255
        //    92: if_icmpne       5
        //    95: aload_1         /* llllllllllllIllIIIIIlllllIllllII */
        //    96: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Signature:
        //  (Lnet/minecraft/network/PacketBuffer;)Ljava/util/List<Lnet/minecraft/network/datasync/EntityDataManager$DataEntry<*>;>;
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 00 1B 00 00
        //    StackMapTable: 00 04 FD 00 05 07 00 6D 01 07 FD 00 27 01 07 00 42 F8 00 1D
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
    
    public boolean isEmpty() {
        return this.empty;
    }
    
    public void writeEntries(final PacketBuffer llllllllllllIllIIIIIllllllIlllII) throws IOException {
        this.lock.readLock().lock();
        for (final DataEntry<?> llllllllllllIllIIIIIllllllIllllI : this.entries.values()) {
            writeEntry(llllllllllllIllIIIIIllllllIlllII, llllllllllllIllIIIIIllllllIllllI);
        }
        this.lock.readLock().unlock();
        llllllllllllIllIIIIIllllllIlllII.writeByte(255);
    }
    
    public <T> void set(final DataParameter<T> llllllllllllIllIIIIlIIIIIIIIlIlI, final T llllllllllllIllIIIIlIIIIIIIIlIIl) {
        final DataEntry<T> llllllllllllIllIIIIlIIIIIIIIllII = this.getEntry(llllllllllllIllIIIIlIIIIIIIIlIlI);
        if (ObjectUtils.notEqual((Object)llllllllllllIllIIIIlIIIIIIIIlIIl, (Object)llllllllllllIllIIIIlIIIIIIIIllII.getValue())) {
            llllllllllllIllIIIIlIIIIIIIIllII.setValue(llllllllllllIllIIIIlIIIIIIIIlIIl);
            this.entity.notifyDataManagerChange(llllllllllllIllIIIIlIIIIIIIIlIlI);
            llllllllllllIllIIIIlIIIIIIIIllII.setDirty(true);
            this.dirty = true;
        }
    }
    
    @Nullable
    public List<DataEntry<?>> getDirty() {
        List<DataEntry<?>> llllllllllllIllIIIIIlllllllIlIlI = null;
        if (this.dirty) {
            this.lock.readLock().lock();
            for (final DataEntry<?> llllllllllllIllIIIIIlllllllIlIIl : this.entries.values()) {
                if (llllllllllllIllIIIIIlllllllIlIIl.isDirty()) {
                    llllllllllllIllIIIIIlllllllIlIIl.setDirty(false);
                    if (llllllllllllIllIIIIIlllllllIlIlI == null) {
                        llllllllllllIllIIIIIlllllllIlIlI = (List<DataEntry<?>>)Lists.newArrayList();
                    }
                    llllllllllllIllIIIIIlllllllIlIlI.add(llllllllllllIllIIIIIlllllllIlIIl.func_192735_d());
                }
            }
            this.lock.readLock().unlock();
        }
        this.dirty = false;
        return llllllllllllIllIIIIIlllllllIlIlI;
    }
    
    public <T> void setDirty(final DataParameter<T> llllllllllllIllIIIIlIIIIIIIIIlII) {
        DataEntry.access$0((DataEntry<Object>)this.getEntry(llllllllllllIllIIIIlIIIIIIIIIlII), true);
        this.dirty = true;
    }
    
    public static <T> DataParameter<T> createKey(final Class<? extends Entity> llllllllllllIllIIIIlIIIIIlIIlIIl, final DataSerializer<T> llllllllllllIllIIIIlIIIIIlIIlIII) {
        if (EntityDataManager.LOGGER.isDebugEnabled()) {
            try {
                final Class<?> llllllllllllIllIIIIlIIIIIlIIlllI = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
                if (!llllllllllllIllIIIIlIIIIIlIIlllI.equals(llllllllllllIllIIIIlIIIIIlIIlIIl)) {
                    EntityDataManager.LOGGER.debug("defineId called for: {} from {}", (Object)llllllllllllIllIIIIlIIIIIlIIlIIl, (Object)llllllllllllIllIIIIlIIIIIlIIlllI, (Object)new RuntimeException());
                }
            }
            catch (ClassNotFoundException ex) {}
        }
        int llllllllllllIllIIIIlIIIIIlIIllII = 0;
        if (EntityDataManager.NEXT_ID_MAP.containsKey(llllllllllllIllIIIIlIIIIIlIIlIIl)) {
            final int llllllllllllIllIIIIlIIIIIlIIllIl = EntityDataManager.NEXT_ID_MAP.get(llllllllllllIllIIIIlIIIIIlIIlIIl) + 1;
        }
        else {
            int llllllllllllIllIIIIlIIIIIlIIlIll = 0;
            Class<?> llllllllllllIllIIIIlIIIIIlIIlIlI = llllllllllllIllIIIIlIIIIIlIIlIIl;
            while (llllllllllllIllIIIIlIIIIIlIIlIlI != Entity.class) {
                llllllllllllIllIIIIlIIIIIlIIlIlI = llllllllllllIllIIIIlIIIIIlIIlIlI.getSuperclass();
                if (EntityDataManager.NEXT_ID_MAP.containsKey(llllllllllllIllIIIIlIIIIIlIIlIlI)) {
                    llllllllllllIllIIIIlIIIIIlIIlIll = EntityDataManager.NEXT_ID_MAP.get(llllllllllllIllIIIIlIIIIIlIIlIlI) + 1;
                    break;
                }
            }
            llllllllllllIllIIIIlIIIIIlIIllII = llllllllllllIllIIIIlIIIIIlIIlIll;
        }
        if (llllllllllllIllIIIIlIIIIIlIIllII > 254) {
            throw new IllegalArgumentException("Data value id is too big with " + llllllllllllIllIIIIlIIIIIlIIllII + "! (Max is " + 254 + ")");
        }
        EntityDataManager.NEXT_ID_MAP.put(llllllllllllIllIIIIlIIIIIlIIlIIl, llllllllllllIllIIIIlIIIIIlIIllII);
        return llllllllllllIllIIIIlIIIIIlIIlIII.createKey(llllllllllllIllIIIIlIIIIIlIIllII);
    }
    
    public <T> T get(final DataParameter<T> llllllllllllIllIIIIlIIIIIIIlIlII) {
        return this.getEntry(llllllllllllIllIIIIlIIIIIIIlIlII).getValue();
    }
    
    public boolean isDirty() {
        return this.dirty;
    }
    
    protected <T> void setEntryValue(final DataEntry<T> llllllllllllIllIIIIIlllllIIlllll, final DataEntry<?> llllllllllllIllIIIIIlllllIlIIIII) {
        llllllllllllIllIIIIIlllllIIlllll.setValue((T)llllllllllllIllIIIIIlllllIlIIIII.getValue());
    }
    
    public static void writeEntries(final List<DataEntry<?>> llllllllllllIllIIIIIlllllllllIIl, final PacketBuffer llllllllllllIllIIIIIllllllllIIll) throws IOException {
        if (llllllllllllIllIIIIIlllllllllIIl != null) {
            for (int llllllllllllIllIIIIIllllllllIlll = 0, llllllllllllIllIIIIIllllllllIllI = llllllllllllIllIIIIIlllllllllIIl.size(); llllllllllllIllIIIIIllllllllIlll < llllllllllllIllIIIIIllllllllIllI; ++llllllllllllIllIIIIIllllllllIlll) {
                final DataEntry<?> llllllllllllIllIIIIIllllllllIlIl = llllllllllllIllIIIIIlllllllllIIl.get(llllllllllllIllIIIIIllllllllIlll);
                writeEntry(llllllllllllIllIIIIIllllllllIIll, llllllllllllIllIIIIIllllllllIlIl);
            }
        }
        llllllllllllIllIIIIIllllllllIIll.writeByte(255);
    }
    
    private static <T> void writeEntry(final PacketBuffer llllllllllllIllIIIIIllllllIIlIlI, final DataEntry<T> llllllllllllIllIIIIIllllllIIlIIl) throws IOException {
        final DataParameter<T> llllllllllllIllIIIIIllllllIIlIII = llllllllllllIllIIIIIllllllIIlIIl.getKey();
        final int llllllllllllIllIIIIIllllllIIIlll = DataSerializers.getSerializerId(llllllllllllIllIIIIIllllllIIlIII.getSerializer());
        if (llllllllllllIllIIIIIllllllIIIlll < 0) {
            throw new EncoderException("Unknown serializer type " + llllllllllllIllIIIIIllllllIIlIII.getSerializer());
        }
        llllllllllllIllIIIIIllllllIIlIlI.writeByte(llllllllllllIllIIIIIllllllIIlIII.getId());
        llllllllllllIllIIIIIllllllIIlIlI.writeVarIntToBuffer(llllllllllllIllIIIIIllllllIIIlll);
        llllllllllllIllIIIIIllllllIIlIII.getSerializer().write(llllllllllllIllIIIIIllllllIIlIlI, llllllllllllIllIIIIIllllllIIlIIl.getValue());
    }
    
    private <T> void setEntry(final DataParameter<T> llllllllllllIllIIIIlIIIIIIllIIll, final T llllllllllllIllIIIIlIIIIIIlIlllI) {
        final DataEntry<T> llllllllllllIllIIIIlIIIIIIllIIIl = new DataEntry<T>(llllllllllllIllIIIIlIIIIIIllIIll, llllllllllllIllIIIIlIIIIIIlIlllI);
        this.lock.writeLock().lock();
        this.entries.put(llllllllllllIllIIIIlIIIIIIllIIll.getId(), llllllllllllIllIIIIlIIIIIIllIIIl);
        this.empty = false;
        this.lock.writeLock().unlock();
    }
    
    private <T> DataEntry<T> getEntry(final DataParameter<T> llllllllllllIllIIIIlIIIIIIIllllI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/network/datasync/EntityDataManager.lock:Ljava/util/concurrent/locks/ReadWriteLock;
        //     4: invokeinterface java/util/concurrent/locks/ReadWriteLock.readLock:()Ljava/util/concurrent/locks/Lock;
        //     9: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    14: aload_0         /* llllllllllllIllIIIIlIIIIIIIlllll */
        //    15: getfield        net/minecraft/network/datasync/EntityDataManager.entries:Ljava/util/Map;
        //    18: aload_1         /* llllllllllllIllIIIIlIIIIIIlIIlIl */
        //    19: invokevirtual   net/minecraft/network/datasync/DataParameter.getId:()I
        //    22: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    25: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: checkcast       Lnet/minecraft/network/datasync/EntityDataManager$DataEntry;
        //    33: astore_2        /* llllllllllllIllIIIIlIIIIIIlIIlII */
        //    34: goto            76
        //    37: astore_3        /* llllllllllllIllIIIIlIIIIIIlIIIlI */
        //    38: aload_3         /* llllllllllllIllIIIIlIIIIIIlIIIlI */
        //    39: ldc_w           "Getting synched entity data"
        //    42: invokestatic    net/minecraft/crash/CrashReport.makeCrashReport:(Ljava/lang/Throwable;Ljava/lang/String;)Lnet/minecraft/crash/CrashReport;
        //    45: astore          llllllllllllIllIIIIlIIIIIIlIIIIl
        //    47: aload           llllllllllllIllIIIIlIIIIIIlIIIIl
        //    49: ldc_w           "Synched entity data"
        //    52: invokevirtual   net/minecraft/crash/CrashReport.makeCategory:(Ljava/lang/String;)Lnet/minecraft/crash/CrashReportCategory;
        //    55: astore          llllllllllllIllIIIIlIIIIIIlIIIII
        //    57: aload           llllllllllllIllIIIIlIIIIIIlIIIII
        //    59: ldc_w           "Data ID"
        //    62: aload_1         /* llllllllllllIllIIIIlIIIIIIlIIlIl */
        //    63: invokevirtual   net/minecraft/crash/CrashReportCategory.addCrashSection:(Ljava/lang/String;Ljava/lang/Object;)V
        //    66: new             Lnet/minecraft/util/ReportedException;
        //    69: dup            
        //    70: aload           llllllllllllIllIIIIlIIIIIIlIIIIl
        //    72: invokespecial   net/minecraft/util/ReportedException.<init>:(Lnet/minecraft/crash/CrashReport;)V
        //    75: athrow         
        //    76: aload_0         /* llllllllllllIllIIIIlIIIIIIIlllll */
        //    77: getfield        net/minecraft/network/datasync/EntityDataManager.lock:Ljava/util/concurrent/locks/ReadWriteLock;
        //    80: invokeinterface java/util/concurrent/locks/ReadWriteLock.readLock:()Ljava/util/concurrent/locks/Lock;
        //    85: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    90: aload_2         /* llllllllllllIllIIIIlIIIIIIlIIIll */
        //    91: areturn        
        //    Signature:
        //  <T:Ljava/lang/Object;>(Lnet/minecraft/network/datasync/DataParameter<TT;>;)Lnet/minecraft/network/datasync/EntityDataManager$DataEntry<TT;>;
        //    StackMapTable: 00 02 65 07 01 B6 FC 00 26 07 00 06
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  14     34     37     76     Ljava/lang/Throwable;
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
    
    public void setClean() {
        this.dirty = false;
        this.lock.readLock().lock();
        for (final DataEntry<?> llllllllllllIllIIIIIlllllIIlIllI : this.entries.values()) {
            llllllllllllIllIIIIIlllllIIlIllI.setDirty(false);
        }
        this.lock.readLock().unlock();
    }
    
    static {
        LOGGER = LogManager.getLogger();
        NEXT_ID_MAP = Maps.newHashMap();
    }
    
    @Nullable
    public List<DataEntry<?>> getAll() {
        List<DataEntry<?>> llllllllllllIllIIIIIllllllIlIlII = null;
        this.lock.readLock().lock();
        for (final DataEntry<?> llllllllllllIllIIIIIllllllIlIIll : this.entries.values()) {
            if (llllllllllllIllIIIIIllllllIlIlII == null) {
                llllllllllllIllIIIIIllllllIlIlII = (List<DataEntry<?>>)Lists.newArrayList();
            }
            llllllllllllIllIIIIIllllllIlIlII.add(llllllllllllIllIIIIIllllllIlIIll.func_192735_d());
        }
        this.lock.readLock().unlock();
        return llllllllllllIllIIIIIllllllIlIlII;
    }
    
    public <T> void register(final DataParameter<T> llllllllllllIllIIIIlIIIIIIllllll, final T llllllllllllIllIIIIlIIIIIIlllllI) {
        final int llllllllllllIllIIIIlIIIIIIllllIl = llllllllllllIllIIIIlIIIIIIllllll.getId();
        if (llllllllllllIllIIIIlIIIIIIllllIl > 254) {
            throw new IllegalArgumentException("Data value id is too big with " + llllllllllllIllIIIIlIIIIIIllllIl + "! (Max is " + 254 + ")");
        }
        if (this.entries.containsKey(llllllllllllIllIIIIlIIIIIIllllIl)) {
            throw new IllegalArgumentException("Duplicate id value for " + llllllllllllIllIIIIlIIIIIIllllIl + "!");
        }
        if (DataSerializers.getSerializerId(llllllllllllIllIIIIlIIIIIIllllll.getSerializer()) < 0) {
            throw new IllegalArgumentException("Unregistered serializer " + llllllllllllIllIIIIlIIIIIIllllll.getSerializer() + " for " + llllllllllllIllIIIIlIIIIIIllllIl + "!");
        }
        this.setEntry((DataParameter<Object>)llllllllllllIllIIIIlIIIIIIllllll, llllllllllllIllIIIIlIIIIIIlllllI);
    }
    
    public void setEntryValues(final List<DataEntry<?>> llllllllllllIllIIIIIlllllIlIllII) {
        this.lock.writeLock().lock();
        for (final DataEntry<?> llllllllllllIllIIIIIlllllIlIlIll : llllllllllllIllIIIIIlllllIlIllII) {
            final DataEntry<?> llllllllllllIllIIIIIlllllIlIlIlI = this.entries.get(llllllllllllIllIIIIIlllllIlIlIll.getKey().getId());
            if (llllllllllllIllIIIIIlllllIlIlIlI != null) {
                this.setEntryValue(llllllllllllIllIIIIIlllllIlIlIlI, llllllllllllIllIIIIIlllllIlIlIll);
                this.entity.notifyDataManagerChange(llllllllllllIllIIIIIlllllIlIlIll.getKey());
            }
        }
        this.lock.writeLock().unlock();
        this.dirty = true;
    }
    
    public EntityDataManager(final Entity llllllllllllIllIIIIlIIIIIlIllIII) {
        this.entries = (Map<Integer, DataEntry<?>>)Maps.newHashMap();
        this.lock = new ReentrantReadWriteLock();
        this.empty = true;
        this.entity = llllllllllllIllIIIIlIIIIIlIllIII;
    }
    
    public static class DataEntry<T>
    {
        private final /* synthetic */ DataParameter<T> key;
        private /* synthetic */ boolean dirty;
        private /* synthetic */ T value;
        
        public boolean isDirty() {
            return this.dirty;
        }
        
        public void setValue(final T lllllllllllllIIIllIlIllIlllIllIl) {
            this.value = lllllllllllllIIIllIlIllIlllIllIl;
        }
        
        public DataEntry(final DataParameter<T> lllllllllllllIIIllIlIllIllllIlIl, final T lllllllllllllIIIllIlIllIllllIlII) {
            this.key = lllllllllllllIIIllIlIllIllllIlIl;
            this.value = lllllllllllllIIIllIlIllIllllIlII;
            this.dirty = true;
        }
        
        public DataParameter<T> getKey() {
            return this.key;
        }
        
        public T getValue() {
            return this.value;
        }
        
        static /* synthetic */ void access$0(final DataEntry lllllllllllllIIIllIlIllIllIllIIl, final boolean lllllllllllllIIIllIlIllIllIllIII) {
            lllllllllllllIIIllIlIllIllIllIIl.dirty = lllllllllllllIIIllIlIllIllIllIII;
        }
        
        public DataEntry<T> func_192735_d() {
            return new DataEntry<T>(this.key, this.key.getSerializer().func_192717_a(this.value));
        }
        
        public void setDirty(final boolean lllllllllllllIIIllIlIllIlllIIIIl) {
            this.dirty = lllllllllllllIIIllIlIllIlllIIIIl;
        }
    }
}
