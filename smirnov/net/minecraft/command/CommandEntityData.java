// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.server.MinecraftServer;

public class CommandEntityData extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIllIIIlllIIlllllIllII, final int lllllllllllIllIIIlllIIlllllIlIlI) {
        return lllllllllllIllIIIlllIIlllllIlIlI == 0;
    }
    
    @Override
    public String getCommandName() {
        return "entitydata";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIllIIIlllIlIIIIIIIIIl, final ICommandSender lllllllllllIllIIIlllIIllllllIlIl, final String[] lllllllllllIllIIIlllIIllllllllll) throws CommandException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: iconst_2       
        //     3: if_icmpge       20
        //     6: new             Lnet/minecraft/command/WrongUsageException;
        //     9: dup            
        //    10: ldc             "commands.entitydata.usage"
        //    12: iconst_0       
        //    13: anewarray       Ljava/lang/Object;
        //    16: invokespecial   net/minecraft/command/WrongUsageException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    19: athrow         
        //    20: aload_1         /* lllllllllllIllIIIlllIIllllllIllI */
        //    21: aload_2         /* lllllllllllIllIIIlllIlIIIIIIIIII */
        //    22: aload_3         /* lllllllllllIllIIIlllIIllllllIlII */
        //    23: iconst_0       
        //    24: aaload         
        //    25: invokestatic    net/minecraft/command/CommandEntityData.getEntity:(Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)Lnet/minecraft/entity/Entity;
        //    28: astore          lllllllllllIllIIIlllIIlllllllllI
        //    30: aload           lllllllllllIllIIIlllIIlllllllllI
        //    32: instanceof      Lnet/minecraft/entity/player/EntityPlayer;
        //    35: ifeq            60
        //    38: new             Lnet/minecraft/command/CommandException;
        //    41: dup            
        //    42: ldc             "commands.entitydata.noPlayers"
        //    44: iconst_1       
        //    45: anewarray       Ljava/lang/Object;
        //    48: dup            
        //    49: iconst_0       
        //    50: aload           lllllllllllIllIIIlllIIlllllllllI
        //    52: invokevirtual   net/minecraft/entity/Entity.getDisplayName:()Lnet/minecraft/util/text/ITextComponent;
        //    55: aastore        
        //    56: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    59: athrow         
        //    60: aload           lllllllllllIllIIIlllIIlllllllllI
        //    62: invokestatic    net/minecraft/command/CommandEntityData.entityToNBT:(Lnet/minecraft/entity/Entity;)Lnet/minecraft/nbt/NBTTagCompound;
        //    65: astore          lllllllllllIllIIIlllIIllllllllIl
        //    67: aload           lllllllllllIllIIIlllIIllllllllIl
        //    69: invokevirtual   net/minecraft/nbt/NBTTagCompound.copy:()Lnet/minecraft/nbt/NBTTagCompound;
        //    72: astore          lllllllllllIllIIIlllIIllllllllII
        //    74: aload_3         /* lllllllllllIllIIIlllIIllllllIlII */
        //    75: iconst_1       
        //    76: invokestatic    net/minecraft/command/CommandEntityData.buildString:([Ljava/lang/String;I)Ljava/lang/String;
        //    79: invokestatic    net/minecraft/nbt/JsonToNBT.getTagFromJson:(Ljava/lang/String;)Lnet/minecraft/nbt/NBTTagCompound;
        //    82: astore          lllllllllllIllIIIlllIIlllllllIll
        //    84: goto            111
        //    87: astore          lllllllllllIllIIIlllIIlllllllIIl
        //    89: new             Lnet/minecraft/command/CommandException;
        //    92: dup            
        //    93: ldc             "commands.entitydata.tagError"
        //    95: iconst_1       
        //    96: anewarray       Ljava/lang/Object;
        //    99: dup            
        //   100: iconst_0       
        //   101: aload           lllllllllllIllIIIlllIIlllllllIIl
        //   103: invokevirtual   net/minecraft/nbt/NBTException.getMessage:()Ljava/lang/String;
        //   106: aastore        
        //   107: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   110: athrow         
        //   111: aload           lllllllllllIllIIIlllIIlllllllllI
        //   113: invokevirtual   net/minecraft/entity/Entity.getUniqueID:()Ljava/util/UUID;
        //   116: astore          lllllllllllIllIIIlllIIlllllllIII
        //   118: aload           lllllllllllIllIIIlllIIllllllllIl
        //   120: aload           lllllllllllIllIIIlllIIlllllllIlI
        //   122: invokevirtual   net/minecraft/nbt/NBTTagCompound.merge:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   125: aload           lllllllllllIllIIIlllIIlllllllllI
        //   127: aload           lllllllllllIllIIIlllIIlllllllIII
        //   129: invokevirtual   net/minecraft/entity/Entity.setUniqueId:(Ljava/util/UUID;)V
        //   132: aload           lllllllllllIllIIIlllIIllllllllIl
        //   134: aload           lllllllllllIllIIIlllIIllllllllII
        //   136: invokevirtual   net/minecraft/nbt/NBTTagCompound.equals:(Ljava/lang/Object;)Z
        //   139: ifeq            164
        //   142: new             Lnet/minecraft/command/CommandException;
        //   145: dup            
        //   146: ldc             "commands.entitydata.failed"
        //   148: iconst_1       
        //   149: anewarray       Ljava/lang/Object;
        //   152: dup            
        //   153: iconst_0       
        //   154: aload           lllllllllllIllIIIlllIIllllllllIl
        //   156: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   159: aastore        
        //   160: invokespecial   net/minecraft/command/CommandException.<init>:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   163: athrow         
        //   164: aload           lllllllllllIllIIIlllIIlllllllllI
        //   166: aload           lllllllllllIllIIIlllIIllllllllIl
        //   168: invokevirtual   net/minecraft/entity/Entity.readFromNBT:(Lnet/minecraft/nbt/NBTTagCompound;)V
        //   171: aload_2         /* lllllllllllIllIIIlllIlIIIIIIIIII */
        //   172: aload_0         /* lllllllllllIllIIIlllIlIIIIIIIIlI */
        //   173: ldc             "commands.entitydata.success"
        //   175: iconst_1       
        //   176: anewarray       Ljava/lang/Object;
        //   179: dup            
        //   180: iconst_0       
        //   181: aload           lllllllllllIllIIIlllIIllllllllIl
        //   183: invokevirtual   net/minecraft/nbt/NBTTagCompound.toString:()Ljava/lang/String;
        //   186: aastore        
        //   187: invokestatic    net/minecraft/command/CommandEntityData.notifyCommandListener:(Lnet/minecraft/command/ICommandSender;Lnet/minecraft/command/ICommand;Ljava/lang/String;[Ljava/lang/Object;)V
        //   190: return         
        //    Exceptions:
        //  throws net.minecraft.command.CommandException
        //    StackMapTable: 00 05 14 FC 00 27 07 00 37 FF 00 1A 00 07 07 00 02 07 00 95 07 00 97 07 00 98 07 00 37 07 00 42 07 00 42 00 01 07 00 24 FC 00 17 07 00 42 FC 00 34 07 00 9A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  74     84     87     111    Lnet/minecraft/nbt/NBTException;
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
    public String getCommandUsage(final ICommandSender lllllllllllIllIIIlllIlIIIIIIllII) {
        return "commands.entitydata.usage";
    }
}
