// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.nbt.NBTBase;
import net.minecraft.server.MinecraftServer;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;

public class CommandResultStats
{
    private /* synthetic */ String[] entitiesID;
    private static final /* synthetic */ String[] STRING_RESULT_TYPES;
    private static final /* synthetic */ int NUM_RESULT_TYPES;
    private /* synthetic */ String[] objectives;
    
    public void readStatsFromNBT(final NBTTagCompound lllllllllllllIllIllllIlllIlIIlll) {
        if (lllllllllllllIllIllllIlllIlIIlll.hasKey("CommandStats", 10)) {
            final NBTTagCompound lllllllllllllIllIllllIlllIlIlllI = lllllllllllllIllIllllIlllIlIIlll.getCompoundTag("CommandStats");
            final char lllllllllllllIllIllllIlllIlIIIlI;
            final long lllllllllllllIllIllllIlllIlIIIll = ((Type[])(Object)(lllllllllllllIllIllllIlllIlIIIlI = (char)(Object)Type.values())).length;
            for (float lllllllllllllIllIllllIlllIlIIlII = 0; lllllllllllllIllIllllIlllIlIIlII < lllllllllllllIllIllllIlllIlIIIll; ++lllllllllllllIllIllllIlllIlIIlII) {
                final Type lllllllllllllIllIllllIlllIlIllIl = lllllllllllllIllIllllIlllIlIIIlI[lllllllllllllIllIllllIlllIlIIlII];
                final String lllllllllllllIllIllllIlllIlIllII = String.valueOf(lllllllllllllIllIllllIlllIlIllIl.getTypeName()) + "Name";
                final String lllllllllllllIllIllllIlllIlIlIll = String.valueOf(lllllllllllllIllIllllIlllIlIllIl.getTypeName()) + "Objective";
                if (lllllllllllllIllIllllIlllIlIlllI.hasKey(lllllllllllllIllIllllIlllIlIllII, 8) && lllllllllllllIllIllllIlllIlIlllI.hasKey(lllllllllllllIllIllllIlllIlIlIll, 8)) {
                    final String lllllllllllllIllIllllIlllIlIlIlI = lllllllllllllIllIllllIlllIlIlllI.getString(lllllllllllllIllIllllIlllIlIllII);
                    final String lllllllllllllIllIllllIlllIlIlIIl = lllllllllllllIllIllllIlllIlIlllI.getString(lllllllllllllIllIllllIlllIlIlIll);
                    setScoreBoardStat(this, lllllllllllllIllIllllIlllIlIllIl, lllllllllllllIllIllllIlllIlIlIlI, lllllllllllllIllIllllIlllIlIlIIl);
                }
            }
        }
    }
    
    public static void setScoreBoardStat(final CommandResultStats lllllllllllllIllIllllIllIlllllIl, final Type lllllllllllllIllIllllIlllIIIIIII, @Nullable final String lllllllllllllIllIllllIllIllllIll, @Nullable final String lllllllllllllIllIllllIllIllllIlI) {
        if (lllllllllllllIllIllllIllIllllIll != null && !lllllllllllllIllIllllIllIllllIll.isEmpty() && lllllllllllllIllIllllIllIllllIlI != null && !lllllllllllllIllIllllIllIllllIlI.isEmpty()) {
            if (lllllllllllllIllIllllIllIlllllIl.entitiesID == CommandResultStats.STRING_RESULT_TYPES || lllllllllllllIllIllllIllIlllllIl.objectives == CommandResultStats.STRING_RESULT_TYPES) {
                lllllllllllllIllIllllIllIlllllIl.entitiesID = new String[CommandResultStats.NUM_RESULT_TYPES];
                lllllllllllllIllIllllIllIlllllIl.objectives = new String[CommandResultStats.NUM_RESULT_TYPES];
            }
            lllllllllllllIllIllllIllIlllllIl.entitiesID[lllllllllllllIllIllllIlllIIIIIII.getTypeID()] = lllllllllllllIllIllllIllIllllIll;
            lllllllllllllIllIllllIllIlllllIl.objectives[lllllllllllllIllIllllIlllIIIIIII.getTypeID()] = lllllllllllllIllIllllIllIllllIlI;
        }
        else {
            removeScoreBoardStat(lllllllllllllIllIllllIllIlllllIl, lllllllllllllIllIllllIlllIIIIIII);
        }
    }
    
    public CommandResultStats() {
        this.entitiesID = CommandResultStats.STRING_RESULT_TYPES;
        this.objectives = CommandResultStats.STRING_RESULT_TYPES;
    }
    
    public void setCommandStatForSender(final MinecraftServer lllllllllllllIllIllllIllllIIIllI, final ICommandSender lllllllllllllIllIllllIllllIlIIll, final Type lllllllllllllIllIllllIllllIlIIlI, final int lllllllllllllIllIllllIllllIlIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/command/CommandResultStats.entitiesID:[Ljava/lang/String;
        //     4: aload_3         /* lllllllllllllIllIllllIllllIIIlII */
        //     5: invokevirtual   net/minecraft/command/CommandResultStats$Type.getTypeID:()I
        //     8: aaload         
        //     9: astore          lllllllllllllIllIllllIllllIlIIII
        //    11: aload           lllllllllllllIllIllllIllllIlIIII
        //    13: ifnull          114
        //    16: new             Lnet/minecraft/command/CommandResultStats$1;
        //    19: dup            
        //    20: aload_0         /* lllllllllllllIllIllllIllllIlIlIl */
        //    21: aload_2         /* lllllllllllllIllIllllIllllIIIlIl */
        //    22: invokespecial   net/minecraft/command/CommandResultStats$1.<init>:(Lnet/minecraft/command/CommandResultStats;Lnet/minecraft/command/ICommandSender;)V
        //    25: astore          lllllllllllllIllIllllIllllIIllll
        //    27: aload_1         /* lllllllllllllIllIllllIllllIlIlII */
        //    28: aload           lllllllllllllIllIllllIllllIIllll
        //    30: aload           lllllllllllllIllIllllIllllIlIIII
        //    32: invokestatic    net/minecraft/command/CommandBase.getEntityName:(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)Ljava/lang/String;
        //    35: astore          lllllllllllllIllIllllIllllIIlllI
        //    37: goto            43
        //    40: astore          lllllllllllllIllIllllIllllIIllII
        //    42: return         
        //    43: aload_0         /* lllllllllllllIllIllllIllllIlIlIl */
        //    44: getfield        net/minecraft/command/CommandResultStats.objectives:[Ljava/lang/String;
        //    47: aload_3         /* lllllllllllllIllIllllIllllIIIlII */
        //    48: invokevirtual   net/minecraft/command/CommandResultStats$Type.getTypeID:()I
        //    51: aaload         
        //    52: astore          lllllllllllllIllIllllIllllIIlIll
        //    54: aload           lllllllllllllIllIllllIllllIIlIll
        //    56: ifnull          114
        //    59: aload_2         /* lllllllllllllIllIllllIllllIIIlIl */
        //    60: invokeinterface net/minecraft/command/ICommandSender.getEntityWorld:()Lnet/minecraft/world/World;
        //    65: invokevirtual   net/minecraft/world/World.getScoreboard:()Lnet/minecraft/scoreboard/Scoreboard;
        //    68: astore          lllllllllllllIllIllllIllllIIlIlI
        //    70: aload           lllllllllllllIllIllllIllllIIlIlI
        //    72: aload           lllllllllllllIllIllllIllllIIlIll
        //    74: invokevirtual   net/minecraft/scoreboard/Scoreboard.getObjective:(Ljava/lang/String;)Lnet/minecraft/scoreboard/ScoreObjective;
        //    77: astore          lllllllllllllIllIllllIllllIIlIIl
        //    79: aload           lllllllllllllIllIllllIllllIIlIIl
        //    81: ifnull          114
        //    84: aload           lllllllllllllIllIllllIllllIIlIlI
        //    86: aload           lllllllllllllIllIllllIllllIIllIl
        //    88: aload           lllllllllllllIllIllllIllllIIlIIl
        //    90: invokevirtual   net/minecraft/scoreboard/Scoreboard.entityHasObjective:(Ljava/lang/String;Lnet/minecraft/scoreboard/ScoreObjective;)Z
        //    93: ifeq            114
        //    96: aload           lllllllllllllIllIllllIllllIIlIlI
        //    98: aload           lllllllllllllIllIllllIllllIIllIl
        //   100: aload           lllllllllllllIllIllllIllllIIlIIl
        //   102: invokevirtual   net/minecraft/scoreboard/Scoreboard.getOrCreateScore:(Ljava/lang/String;Lnet/minecraft/scoreboard/ScoreObjective;)Lnet/minecraft/scoreboard/Score;
        //   105: astore          lllllllllllllIllIllllIllllIIlIII
        //   107: aload           lllllllllllllIllIllllIllllIIlIII
        //   109: iload           lllllllllllllIllIllllIllllIIIIll
        //   111: invokevirtual   net/minecraft/scoreboard/Score.setScorePoints:(I)V
        //   114: return         
        //    StackMapTable: 00 03 FF 00 28 00 07 07 00 02 07 00 D6 07 00 95 07 00 06 01 07 00 29 07 00 09 00 01 07 00 8A FC 00 02 07 00 29 F9 00 46
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                    
        //  -----  -----  -----  -----  ----------------------------------------
        //  27     37     40     43     Lnet/minecraft/command/CommandException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void writeStatsToNBT(final NBTTagCompound lllllllllllllIllIllllIlllIIlIIll) {
        final NBTTagCompound lllllllllllllIllIllllIlllIIlIIlI = new NBTTagCompound();
        final long lllllllllllllIllIllllIlllIIIlIII;
        final Exception lllllllllllllIllIllllIlllIIIlIIl = (Exception)((Type[])(Object)(lllllllllllllIllIllllIlllIIIlIII = (long)(Object)Type.values())).length;
        for (long lllllllllllllIllIllllIlllIIIlIlI = 0; lllllllllllllIllIllllIlllIIIlIlI < lllllllllllllIllIllllIlllIIIlIIl; ++lllllllllllllIllIllllIlllIIIlIlI) {
            final Type lllllllllllllIllIllllIlllIIlIIIl = lllllllllllllIllIllllIlllIIIlIII[lllllllllllllIllIllllIlllIIIlIlI];
            final String lllllllllllllIllIllllIlllIIlIIII = this.entitiesID[lllllllllllllIllIllllIlllIIlIIIl.getTypeID()];
            final String lllllllllllllIllIllllIlllIIIllll = this.objectives[lllllllllllllIllIllllIlllIIlIIIl.getTypeID()];
            if (lllllllllllllIllIllllIlllIIlIIII != null && lllllllllllllIllIllllIlllIIIllll != null) {
                lllllllllllllIllIllllIlllIIlIIlI.setString(String.valueOf(lllllllllllllIllIllllIlllIIlIIIl.getTypeName()) + "Name", lllllllllllllIllIllllIlllIIlIIII);
                lllllllllllllIllIllllIlllIIlIIlI.setString(String.valueOf(lllllllllllllIllIllllIlllIIlIIIl.getTypeName()) + "Objective", lllllllllllllIllIllllIlllIIIllll);
            }
        }
        if (!lllllllllllllIllIllllIlllIIlIIlI.hasNoTags()) {
            lllllllllllllIllIllllIlllIIlIIll.setTag("CommandStats", lllllllllllllIllIllllIlllIIlIIlI);
        }
    }
    
    private static void removeScoreBoardStat(final CommandResultStats lllllllllllllIllIllllIllIllIlllI, final Type lllllllllllllIllIllllIllIllIllIl) {
        if (lllllllllllllIllIllllIllIllIlllI.entitiesID != CommandResultStats.STRING_RESULT_TYPES && lllllllllllllIllIllllIllIllIlllI.objectives != CommandResultStats.STRING_RESULT_TYPES) {
            lllllllllllllIllIllllIllIllIlllI.entitiesID[lllllllllllllIllIllllIllIllIllIl.getTypeID()] = null;
            lllllllllllllIllIllllIllIllIlllI.objectives[lllllllllllllIllIllllIllIllIllIl.getTypeID()] = null;
            boolean lllllllllllllIllIllllIllIlllIIII = true;
            String lllllllllllllIllIllllIllIllIlIII;
            for (short lllllllllllllIllIllllIllIllIlIIl = (short)((Type[])(Object)(lllllllllllllIllIllllIllIllIlIII = (String)(Object)Type.values())).length, lllllllllllllIllIllllIllIllIlIlI = 0; lllllllllllllIllIllllIllIllIlIlI < lllllllllllllIllIllllIllIllIlIIl; ++lllllllllllllIllIllllIllIllIlIlI) {
                final Type lllllllllllllIllIllllIllIllIllll = lllllllllllllIllIllllIllIllIlIII[lllllllllllllIllIllllIllIllIlIlI];
                if (lllllllllllllIllIllllIllIllIlllI.entitiesID[lllllllllllllIllIllllIllIllIllll.getTypeID()] != null && lllllllllllllIllIllllIllIllIlllI.objectives[lllllllllllllIllIllllIllIllIllll.getTypeID()] != null) {
                    lllllllllllllIllIllllIllIlllIIII = false;
                    break;
                }
            }
            if (lllllllllllllIllIllllIllIlllIIII) {
                lllllllllllllIllIllllIllIllIlllI.entitiesID = CommandResultStats.STRING_RESULT_TYPES;
                lllllllllllllIllIllllIllIllIlllI.objectives = CommandResultStats.STRING_RESULT_TYPES;
            }
        }
    }
    
    public void addAllStats(final CommandResultStats lllllllllllllIllIllllIllIllIIIII) {
        final float lllllllllllllIllIllllIllIlIllIIl;
        final short lllllllllllllIllIllllIllIlIllIlI = (short)((Type[])(Object)(lllllllllllllIllIllllIllIlIllIIl = (float)(Object)Type.values())).length;
        for (boolean lllllllllllllIllIllllIllIlIllIll = false; (lllllllllllllIllIllllIllIlIllIll ? 1 : 0) < lllllllllllllIllIllllIllIlIllIlI; ++lllllllllllllIllIllllIllIlIllIll) {
            final Type lllllllllllllIllIllllIllIlIlllll = lllllllllllllIllIllllIllIlIllIIl[lllllllllllllIllIllllIllIlIllIll];
            setScoreBoardStat(this, lllllllllllllIllIllllIllIlIlllll, lllllllllllllIllIllllIllIllIIIII.entitiesID[lllllllllllllIllIllllIllIlIlllll.getTypeID()], lllllllllllllIllIllllIllIllIIIII.objectives[lllllllllllllIllIllllIllIlIlllll.getTypeID()]);
        }
    }
    
    static {
        NUM_RESULT_TYPES = Type.values().length;
        STRING_RESULT_TYPES = new String[CommandResultStats.NUM_RESULT_TYPES];
    }
    
    public enum Type
    {
        QUERY_RESULT("QUERY_RESULT", 4, 4, "QueryResult"), 
        SUCCESS_COUNT("SUCCESS_COUNT", 0, 0, "SuccessCount"), 
        AFFECTED_BLOCKS("AFFECTED_BLOCKS", 1, 1, "AffectedBlocks"), 
        AFFECTED_ENTITIES("AFFECTED_ENTITIES", 2, 2, "AffectedEntities");
        
        final /* synthetic */ String typeName;
        final /* synthetic */ int typeID;
        
        AFFECTED_ITEMS("AFFECTED_ITEMS", 3, 3, "AffectedItems");
        
        public int getTypeID() {
            return this.typeID;
        }
        
        public static String[] getTypeNames() {
            final String[] lllllllllllIIIlllIIIIllIIlIIIlll = new String[values().length];
            int lllllllllllIIIlllIIIIllIIlIIIllI = 0;
            final long lllllllllllIIIlllIIIIllIIIllllll;
            final boolean lllllllllllIIIlllIIIIllIIlIIIIII = ((Type[])(Object)(lllllllllllIIIlllIIIIllIIIllllll = (long)(Object)values())).length != 0;
            for (String lllllllllllIIIlllIIIIllIIlIIIIIl = (String)0; lllllllllllIIIlllIIIIllIIlIIIIIl < lllllllllllIIIlllIIIIllIIlIIIIII; ++lllllllllllIIIlllIIIIllIIlIIIIIl) {
                final Type lllllllllllIIIlllIIIIllIIlIIIlIl = lllllllllllIIIlllIIIIllIIIllllll[lllllllllllIIIlllIIIIllIIlIIIIIl];
                lllllllllllIIIlllIIIIllIIlIIIlll[lllllllllllIIIlllIIIIllIIlIIIllI++] = lllllllllllIIIlllIIIIllIIlIIIlIl.getTypeName();
            }
            return lllllllllllIIIlllIIIIllIIlIIIlll;
        }
        
        private Type(final String lllllllllllIIIlllIIIIllIIlIlIlll, final int lllllllllllIIIlllIIIIllIIlIlIllI, final int lllllllllllIIIlllIIIIllIIlIllIlI, final String lllllllllllIIIlllIIIIllIIlIllIIl) {
            this.typeID = lllllllllllIIIlllIIIIllIIlIllIlI;
            this.typeName = lllllllllllIIIlllIIIIllIIlIllIIl;
        }
        
        @Nullable
        public static Type getTypeByName(final String lllllllllllIIIlllIIIIllIIIlllIIl) {
            final long lllllllllllIIIlllIIIIllIIIllIIll;
            final double lllllllllllIIIlllIIIIllIIIllIlII = ((Type[])(Object)(lllllllllllIIIlllIIIIllIIIllIIll = (long)(Object)values())).length;
            for (Exception lllllllllllIIIlllIIIIllIIIllIlIl = (Exception)0; lllllllllllIIIlllIIIIllIIIllIlIl < lllllllllllIIIlllIIIIllIIIllIlII; ++lllllllllllIIIlllIIIIllIIIllIlIl) {
                final Type lllllllllllIIIlllIIIIllIIIlllIII = lllllllllllIIIlllIIIIllIIIllIIll[lllllllllllIIIlllIIIIllIIIllIlIl];
                if (lllllllllllIIIlllIIIIllIIIlllIII.getTypeName().equals(lllllllllllIIIlllIIIIllIIIlllIIl)) {
                    return lllllllllllIIIlllIIIIllIIIlllIII;
                }
            }
            return null;
        }
        
        public String getTypeName() {
            return this.typeName;
        }
    }
}
