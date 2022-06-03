// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.profiler;

import java.util.TimerTask;
import java.util.List;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.util.UUID;
import com.google.common.collect.Maps;
import java.util.Timer;
import java.net.URL;
import java.util.Map;

public class Snooper
{
    private final /* synthetic */ Object syncLock;
    private final /* synthetic */ String uniqueID;
    private final /* synthetic */ Map<String, Object> clientStats;
    private final /* synthetic */ URL serverUrl;
    private final /* synthetic */ Timer threadTrigger;
    private /* synthetic */ boolean isRunning;
    private final /* synthetic */ long minecraftStartTimeMilis;
    private final /* synthetic */ Map<String, Object> snooperStats;
    private final /* synthetic */ ISnooperInfo playerStatsCollector;
    
    public void addClientStat(final String lllllllllllIIIlIlIIlIIlIlIlIlllI, final Object lllllllllllIIIlIlIIlIIlIlIlIllIl) {
        synchronized (this.syncLock) {
            this.clientStats.put(lllllllllllIIIlIlIIlIIlIlIlIlllI, lllllllllllIIIlIlIIlIIlIlIlIllIl);
        }
        // monitorexit(this.syncLock)
    }
    
    public String getUniqueID() {
        return this.uniqueID;
    }
    
    public Map<String, String> getCurrentStats() {
        final Map<String, String> lllllllllllIIIlIlIIlIIlIlIIllIlI = (Map<String, String>)Maps.newLinkedHashMap();
        synchronized (this.syncLock) {
            this.addMemoryStatsToSnooper();
            for (final Map.Entry<String, Object> lllllllllllIIIlIlIIlIIlIlIIllIIl : this.snooperStats.entrySet()) {
                lllllllllllIIIlIlIIlIIlIlIIllIlI.put(lllllllllllIIIlIlIIlIIlIlIIllIIl.getKey(), lllllllllllIIIlIlIIlIIlIlIIllIIl.getValue().toString());
            }
            for (final Map.Entry<String, Object> lllllllllllIIIlIlIIlIIlIlIIllIII : this.clientStats.entrySet()) {
                lllllllllllIIIlIlIIlIIlIlIIllIlI.put(lllllllllllIIIlIlIIlIIlIlIIllIII.getKey(), lllllllllllIIIlIlIIlIIlIlIIllIII.getValue().toString());
            }
            // monitorexit(this.syncLock)
            return lllllllllllIIIlIlIIlIIlIlIIllIlI;
        }
    }
    
    public long getMinecraftStartTimeMillis() {
        return this.minecraftStartTimeMilis;
    }
    
    public Snooper(final String lllllllllllIIIlIlIIlIIlIllIlIlII, final ISnooperInfo lllllllllllIIIlIlIIlIIlIllIlIIll, final long lllllllllllIIIlIlIIlIIlIllIlIlll) {
        this.snooperStats = (Map<String, Object>)Maps.newHashMap();
        this.clientStats = (Map<String, Object>)Maps.newHashMap();
        this.uniqueID = UUID.randomUUID().toString();
        this.threadTrigger = new Timer("Snooper Timer", true);
        this.syncLock = new Object();
        try {
            this.serverUrl = new URL("http://snoop.minecraft.net/" + lllllllllllIIIlIlIIlIIlIllIlIlII + "?version=" + 2);
        }
        catch (MalformedURLException lllllllllllIIIlIlIIlIIlIllIlIllI) {
            throw new IllegalArgumentException();
        }
        this.playerStatsCollector = lllllllllllIIIlIlIIlIIlIllIlIIll;
        this.minecraftStartTimeMilis = lllllllllllIIIlIlIIlIIlIllIlIlll;
    }
    
    public boolean isSnooperRunning() {
        return this.isRunning;
    }
    
    public void addMemoryStatsToSnooper() {
        this.addStatToSnooper("memory_total", Runtime.getRuntime().totalMemory());
        this.addStatToSnooper("memory_max", Runtime.getRuntime().maxMemory());
        this.addStatToSnooper("memory_free", Runtime.getRuntime().freeMemory());
        this.addStatToSnooper("cpu_cores", Runtime.getRuntime().availableProcessors());
        this.playerStatsCollector.addServerStatsToSnooper(this);
    }
    
    private void addJvmArgsToSnooper() {
        final RuntimeMXBean lllllllllllIIIlIlIIlIIlIllIIIIll = ManagementFactory.getRuntimeMXBean();
        final List<String> lllllllllllIIIlIlIIlIIlIllIIIIlI = lllllllllllIIIlIlIIlIIlIllIIIIll.getInputArguments();
        int lllllllllllIIIlIlIIlIIlIllIIIIIl = 0;
        for (final String lllllllllllIIIlIlIIlIIlIllIIIIII : lllllllllllIIIlIlIIlIIlIllIIIIlI) {
            if (lllllllllllIIIlIlIIlIIlIllIIIIII.startsWith("-X")) {
                this.addClientStat("jvm_arg[" + lllllllllllIIIlIlIIlIIlIllIIIIIl++ + "]", lllllllllllIIIlIlIIlIIlIllIIIIII);
            }
        }
        this.addClientStat("jvm_args", lllllllllllIIIlIlIIlIIlIllIIIIIl);
    }
    
    public void startSnooper() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.addOSData();
            this.threadTrigger.schedule(new TimerTask() {
                @Override
                public void run() {
                    // 
                    // This method could not be decompiled.
                    // 
                    // Original Bytecode:
                    // 
                    //     1: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //     4: invokestatic    net/minecraft/profiler/Snooper.access$0:(Lnet/minecraft/profiler/Snooper;)Lnet/minecraft/profiler/ISnooperInfo;
                    //     7: invokeinterface net/minecraft/profiler/ISnooperInfo.isSnooperEnabled:()Z
                    //    12: ifeq            162
                    //    15: aload_0         /* lllllllllllIIlIllIlIlIIIIlIlIllI */
                    //    16: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    19: invokestatic    net/minecraft/profiler/Snooper.access$1:(Lnet/minecraft/profiler/Snooper;)Ljava/lang/Object;
                    //    22: dup            
                    //    23: astore_2       
                    //    24: monitorenter   
                    //    25: aload_0         /* lllllllllllIIlIllIlIlIIIIlIlIllI */
                    //    26: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    29: invokestatic    net/minecraft/profiler/Snooper.access$2:(Lnet/minecraft/profiler/Snooper;)Ljava/util/Map;
                    //    32: invokestatic    com/google/common/collect/Maps.newHashMap:(Ljava/util/Map;)Ljava/util/HashMap;
                    //    35: astore_1        /* lllllllllllIIlIllIlIlIIIIlIllIIl */
                    //    36: aload_0         /* lllllllllllIIlIllIlIlIIIIlIlIllI */
                    //    37: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    40: invokestatic    net/minecraft/profiler/Snooper.access$3:(Lnet/minecraft/profiler/Snooper;)I
                    //    43: ifne            59
                    //    46: aload_1         /* lllllllllllIIlIllIlIlIIIIlIllIIl */
                    //    47: aload_0         /* lllllllllllIIlIllIlIlIIIIlIlIllI */
                    //    48: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    51: invokestatic    net/minecraft/profiler/Snooper.access$4:(Lnet/minecraft/profiler/Snooper;)Ljava/util/Map;
                    //    54: invokeinterface java/util/Map.putAll:(Ljava/util/Map;)V
                    //    59: aload_1         /* lllllllllllIIlIllIlIlIIIIlIllIIl */
                    //    60: ldc             "snooper_count"
                    //    62: aload_0         /* lllllllllllIIlIllIlIlIIIIlIlIllI */
                    //    63: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    66: dup            
                    //    67: invokestatic    net/minecraft/profiler/Snooper.access$3:(Lnet/minecraft/profiler/Snooper;)I
                    //    70: dup_x1         
                    //    71: iconst_1       
                    //    72: iadd           
                    //    73: invokestatic    net/minecraft/profiler/Snooper.access$5:(Lnet/minecraft/profiler/Snooper;I)V
                    //    76: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                    //    79: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //    84: pop            
                    //    85: aload_1         /* lllllllllllIIlIllIlIlIIIIlIllIIl */
                    //    86: ldc             "snooper_token"
                    //    88: aload_0         /* lllllllllllIIlIllIlIlIIIIlIlIllI */
                    //    89: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //    92: invokestatic    net/minecraft/profiler/Snooper.access$6:(Lnet/minecraft/profiler/Snooper;)Ljava/lang/String;
                    //    95: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                    //   100: pop            
                    //   101: aload_2        
                    //   102: monitorexit    
                    //   103: goto            109
                    //   106: aload_2        
                    //   107: monitorexit    
                    //   108: athrow         
                    //   109: aload_0         /* lllllllllllIIlIllIlIlIIIIlIlIllI */
                    //   110: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //   113: invokestatic    net/minecraft/profiler/Snooper.access$0:(Lnet/minecraft/profiler/Snooper;)Lnet/minecraft/profiler/ISnooperInfo;
                    //   116: instanceof      Lnet/minecraft/server/MinecraftServer;
                    //   119: ifeq            135
                    //   122: aload_0         /* lllllllllllIIlIllIlIlIIIIlIlIllI */
                    //   123: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //   126: invokestatic    net/minecraft/profiler/Snooper.access$0:(Lnet/minecraft/profiler/Snooper;)Lnet/minecraft/profiler/ISnooperInfo;
                    //   129: checkcast       Lnet/minecraft/server/MinecraftServer;
                    //   132: goto            136
                    //   135: aconst_null    
                    //   136: astore_2        /* lllllllllllIIlIllIlIlIIIIlIlIlll */
                    //   137: aload_0         /* lllllllllllIIlIllIlIlIIIIlIlIllI */
                    //   138: getfield        net/minecraft/profiler/Snooper$1.this$0:Lnet/minecraft/profiler/Snooper;
                    //   141: invokestatic    net/minecraft/profiler/Snooper.access$7:(Lnet/minecraft/profiler/Snooper;)Ljava/net/URL;
                    //   144: aload_1         /* lllllllllllIIlIllIlIlIIIIlIllIII */
                    //   145: iconst_1       
                    //   146: aload_2         /* lllllllllllIIlIllIlIlIIIIlIlIlll */
                    //   147: ifnonnull       154
                    //   150: aconst_null    
                    //   151: goto            158
                    //   154: aload_2         /* lllllllllllIIlIllIlIlIIIIlIlIlll */
                    //   155: invokevirtual   net/minecraft/server/MinecraftServer.getServerProxy:()Ljava/net/Proxy;
                    //   158: invokestatic    net/minecraft/util/HttpUtil.postMap:(Ljava/net/URL;Ljava/util/Map;ZLjava/net/Proxy;)Ljava/lang/String;
                    //   161: pop            
                    //   162: return         
                    //    StackMapTable: 00 08 FD 00 3B 07 00 6A 07 00 6C FF 00 2E 00 03 07 00 02 00 07 00 6C 00 01 07 00 6E FF 00 02 00 03 07 00 02 07 00 6A 07 00 6C 00 00 19 40 07 00 4C FF 00 11 00 03 07 00 02 07 00 6A 07 00 4C 00 03 07 00 70 07 00 6A 01 FF 00 03 00 03 07 00 02 07 00 6A 07 00 4C 00 04 07 00 70 07 00 6A 01 07 00 72 F9 00 03
                    //    Exceptions:
                    //  Try           Handler
                    //  Start  End    Start  End    Type
                    //  -----  -----  -----  -----  ----
                    //  25     103    106    109    Any
                    //  106    108    106    109    Any
                    // 
                    // The error that occurred was:
                    // 
                    // java.lang.NullPointerException
                    // 
                    throw new IllegalStateException("An error occurred while decompiling this method.");
                }
            }, 0L, 900000L);
        }
    }
    
    private void addOSData() {
        this.addJvmArgsToSnooper();
        this.addClientStat("snooper_token", this.uniqueID);
        this.addStatToSnooper("snooper_token", this.uniqueID);
        this.addStatToSnooper("os_name", System.getProperty("os.name"));
        this.addStatToSnooper("os_version", System.getProperty("os.version"));
        this.addStatToSnooper("os_architecture", System.getProperty("os.arch"));
        this.addStatToSnooper("java_version", System.getProperty("java.version"));
        this.addClientStat("version", "1.12.2");
        this.playerStatsCollector.addServerTypeToSnooper(this);
    }
    
    public void stopSnooper() {
        this.threadTrigger.cancel();
    }
    
    public void addStatToSnooper(final String lllllllllllIIIlIlIIlIIlIlIlIIllI, final Object lllllllllllIIIlIlIIlIIlIlIlIIIlI) {
        synchronized (this.syncLock) {
            this.snooperStats.put(lllllllllllIIIlIlIIlIIlIlIlIIllI, lllllllllllIIIlIlIIlIIlIlIlIIIlI);
        }
        // monitorexit(this.syncLock)
    }
}
