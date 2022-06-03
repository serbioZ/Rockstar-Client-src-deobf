// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.block.BlockRailBase;
import com.google.common.collect.Sets;
import java.util.Random;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.ChunkPos;
import java.util.Set;

public final class WorldEntitySpawner
{
    private final /* synthetic */ Set<ChunkPos> eligibleChunksForSpawning;
    
    public int findChunksForSpawning(final WorldServer llllllllllllIIlllIllIlIIllllllll, final boolean llllllllllllIIlllIllIlIlIIlIlIII, final boolean llllllllllllIIlllIllIlIIllllllIl, final boolean llllllllllllIIlllIllIlIIllllllII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifne            10
        //     4: iload_3         /* llllllllllllIIlllIllIlIlIIlIIlll */
        //     5: ifne            10
        //     8: iconst_0       
        //     9: ireturn        
        //    10: aload_0         /* llllllllllllIIlllIllIlIlIIlIlIlI */
        //    11: getfield        net/minecraft/world/WorldEntitySpawner.eligibleChunksForSpawning:Ljava/util/Set;
        //    14: invokeinterface java/util/Set.clear:()V
        //    19: iconst_0       
        //    20: istore          llllllllllllIIlllIllIlIlIIlIIlIl
        //    22: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //    23: getfield        net/minecraft/world/WorldServer.playerEntities:Ljava/util/List;
        //    26: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    31: astore          llllllllllllIIlllIllIlIIlllllIIl
        //    33: goto            254
        //    36: aload           llllllllllllIIlllIllIlIIlllllIIl
        //    38: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    43: checkcast       Lnet/minecraft/entity/player/EntityPlayer;
        //    46: astore          llllllllllllIIlllIllIlIlIIlIIlII
        //    48: aload           llllllllllllIIlllIllIlIlIIlIIlII
        //    50: invokevirtual   net/minecraft/entity/player/EntityPlayer.isSpectator:()Z
        //    53: ifne            254
        //    56: aload           llllllllllllIIlllIllIlIlIIlIIlII
        //    58: getfield        net/minecraft/entity/player/EntityPlayer.posX:D
        //    61: ldc2_w          16.0
        //    64: ddiv           
        //    65: invokestatic    net/minecraft/util/math/MathHelper.floor:(D)I
        //    68: istore          llllllllllllIIlllIllIlIlIIlIIIll
        //    70: aload           llllllllllllIIlllIllIlIlIIlIIlII
        //    72: getfield        net/minecraft/entity/player/EntityPlayer.posZ:D
        //    75: ldc2_w          16.0
        //    78: ddiv           
        //    79: invokestatic    net/minecraft/util/math/MathHelper.floor:(D)I
        //    82: istore          llllllllllllIIlllIllIlIlIIlIIIlI
        //    84: bipush          8
        //    86: istore          llllllllllllIIlllIllIlIlIIlIIIIl
        //    88: bipush          -8
        //    90: istore          llllllllllllIIlllIllIlIlIIlIIIII
        //    92: goto            247
        //    95: bipush          -8
        //    97: istore          llllllllllllIIlllIllIlIlIIIlllll
        //    99: goto            237
        //   102: iload           llllllllllllIIlllIllIlIlIIlIIIII
        //   104: bipush          -8
        //   106: if_icmpeq       134
        //   109: iload           llllllllllllIIlllIllIlIlIIlIIIII
        //   111: bipush          8
        //   113: if_icmpeq       134
        //   116: iload           llllllllllllIIlllIllIlIlIIIlllll
        //   118: bipush          -8
        //   120: if_icmpeq       134
        //   123: iload           llllllllllllIIlllIllIlIlIIIlllll
        //   125: bipush          8
        //   127: if_icmpeq       134
        //   130: iconst_0       
        //   131: goto            135
        //   134: iconst_1       
        //   135: istore          llllllllllllIIlllIllIlIlIIIllllI
        //   137: new             Lnet/minecraft/util/math/ChunkPos;
        //   140: dup            
        //   141: iload           llllllllllllIIlllIllIlIlIIlIIIII
        //   143: iload           llllllllllllIIlllIllIlIlIIlIIIll
        //   145: iadd           
        //   146: iload           llllllllllllIIlllIllIlIlIIIlllll
        //   148: iload           llllllllllllIIlllIllIlIlIIlIIIlI
        //   150: iadd           
        //   151: invokespecial   net/minecraft/util/math/ChunkPos.<init>:(II)V
        //   154: astore          llllllllllllIIlllIllIlIlIIIlllIl
        //   156: aload_0         /* llllllllllllIIlllIllIlIlIIlIlIlI */
        //   157: getfield        net/minecraft/world/WorldEntitySpawner.eligibleChunksForSpawning:Ljava/util/Set;
        //   160: aload           llllllllllllIIlllIllIlIlIIIlllIl
        //   162: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //   167: ifne            234
        //   170: iinc            llllllllllllIIlllIllIlIlIIlIIlIl, 1
        //   173: iload           llllllllllllIIlllIllIlIlIIIllllI
        //   175: ifne            234
        //   178: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   179: invokevirtual   net/minecraft/world/WorldServer.getWorldBorder:()Lnet/minecraft/world/border/WorldBorder;
        //   182: aload           llllllllllllIIlllIllIlIlIIIlllIl
        //   184: invokevirtual   net/minecraft/world/border/WorldBorder.contains:(Lnet/minecraft/util/math/ChunkPos;)Z
        //   187: ifeq            234
        //   190: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   191: invokevirtual   net/minecraft/world/WorldServer.getPlayerChunkMap:()Lnet/minecraft/server/management/PlayerChunkMap;
        //   194: aload           llllllllllllIIlllIllIlIlIIIlllIl
        //   196: getfield        net/minecraft/util/math/ChunkPos.chunkXPos:I
        //   199: aload           llllllllllllIIlllIllIlIlIIIlllIl
        //   201: getfield        net/minecraft/util/math/ChunkPos.chunkZPos:I
        //   204: invokevirtual   net/minecraft/server/management/PlayerChunkMap.getEntry:(II)Lnet/minecraft/server/management/PlayerChunkMapEntry;
        //   207: astore          llllllllllllIIlllIllIlIlIIIlllII
        //   209: aload           llllllllllllIIlllIllIlIlIIIlllII
        //   211: ifnull          234
        //   214: aload           llllllllllllIIlllIllIlIlIIIlllII
        //   216: invokevirtual   net/minecraft/server/management/PlayerChunkMapEntry.isSentToPlayers:()Z
        //   219: ifeq            234
        //   222: aload_0         /* llllllllllllIIlllIllIlIlIIlIlIlI */
        //   223: getfield        net/minecraft/world/WorldEntitySpawner.eligibleChunksForSpawning:Ljava/util/Set;
        //   226: aload           llllllllllllIIlllIllIlIlIIIlllIl
        //   228: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   233: pop            
        //   234: iinc            llllllllllllIIlllIllIlIlIIIlllll, 1
        //   237: iload           llllllllllllIIlllIllIlIlIIIlllll
        //   239: bipush          8
        //   241: if_icmple       102
        //   244: iinc            llllllllllllIIlllIllIlIlIIlIIIII, 1
        //   247: iload           llllllllllllIIlllIllIlIlIIlIIIII
        //   249: bipush          8
        //   251: if_icmple       95
        //   254: aload           llllllllllllIIlllIllIlIIlllllIIl
        //   256: invokeinterface java/util/Iterator.hasNext:()Z
        //   261: ifne            36
        //   264: iconst_0       
        //   265: istore          llllllllllllIIlllIllIlIlIIIllIll
        //   267: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   268: invokevirtual   net/minecraft/world/WorldServer.getSpawnPoint:()Lnet/minecraft/util/math/BlockPos;
        //   271: astore          llllllllllllIIlllIllIlIlIIIllIlI
        //   273: invokestatic    net/minecraft/entity/EnumCreatureType.values:()[Lnet/minecraft/entity/EnumCreatureType;
        //   276: dup            
        //   277: astore          llllllllllllIIlllIllIlIIllllIlIl
        //   279: arraylength    
        //   280: istore          llllllllllllIIlllIllIlIIllllIllI
        //   282: iconst_0       
        //   283: istore          llllllllllllIIlllIllIlIIllllIlll
        //   285: goto            882
        //   288: aload           llllllllllllIIlllIllIlIIllllIlIl
        //   290: iload           llllllllllllIIlllIllIlIIllllIlll
        //   292: aaload         
        //   293: astore          llllllllllllIIlllIllIlIlIIIllIIl
        //   295: aload           llllllllllllIIlllIllIlIlIIIllIIl
        //   297: invokevirtual   net/minecraft/entity/EnumCreatureType.getPeacefulCreature:()Z
        //   300: ifeq            307
        //   303: iload_3         /* llllllllllllIIlllIllIlIlIIlIIlll */
        //   304: ifeq            879
        //   307: aload           llllllllllllIIlllIllIlIlIIIllIIl
        //   309: invokevirtual   net/minecraft/entity/EnumCreatureType.getPeacefulCreature:()Z
        //   312: ifne            319
        //   315: iload_2         /* llllllllllllIIlllIllIlIIlllllllI */
        //   316: ifeq            879
        //   319: aload           llllllllllllIIlllIllIlIlIIIllIIl
        //   321: invokevirtual   net/minecraft/entity/EnumCreatureType.getAnimal:()Z
        //   324: ifeq            332
        //   327: iload           llllllllllllIIlllIllIlIlIIlIIllI
        //   329: ifeq            879
        //   332: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   333: aload           llllllllllllIIlllIllIlIlIIIllIIl
        //   335: invokevirtual   net/minecraft/entity/EnumCreatureType.getCreatureClass:()Ljava/lang/Class;
        //   338: invokevirtual   net/minecraft/world/WorldServer.countEntities:(Ljava/lang/Class;)I
        //   341: istore          llllllllllllIIlllIllIlIlIIIllIII
        //   343: aload           llllllllllllIIlllIllIlIlIIIllIIl
        //   345: invokevirtual   net/minecraft/entity/EnumCreatureType.getMaxNumberOfCreature:()I
        //   348: iload           llllllllllllIIlllIllIlIlIIlIIlIl
        //   350: imul           
        //   351: getstatic       net/minecraft/world/WorldEntitySpawner.MOB_COUNT_DIV:I
        //   354: idiv           
        //   355: istore          llllllllllllIIlllIllIlIlIIIlIlll
        //   357: iload           llllllllllllIIlllIllIlIlIIIllIII
        //   359: iload           llllllllllllIIlllIllIlIlIIIlIlll
        //   361: if_icmpgt       879
        //   364: new             Lnet/minecraft/util/math/BlockPos$MutableBlockPos;
        //   367: dup            
        //   368: invokespecial   net/minecraft/util/math/BlockPos$MutableBlockPos.<init>:()V
        //   371: astore          llllllllllllIIlllIllIlIlIIIlIllI
        //   373: aload_0         /* llllllllllllIIlllIllIlIlIIlIlIlI */
        //   374: getfield        net/minecraft/world/WorldEntitySpawner.eligibleChunksForSpawning:Ljava/util/Set;
        //   377: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   382: astore          llllllllllllIIlllIllIlIIllllIIII
        //   384: goto            869
        //   387: aload           llllllllllllIIlllIllIlIIllllIIII
        //   389: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   394: checkcast       Lnet/minecraft/util/math/ChunkPos;
        //   397: astore          llllllllllllIIlllIllIlIlIIIlIlIl
        //   399: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   400: aload           llllllllllllIIlllIllIlIlIIIlIlIl
        //   402: getfield        net/minecraft/util/math/ChunkPos.chunkXPos:I
        //   405: aload           llllllllllllIIlllIllIlIlIIIlIlIl
        //   407: getfield        net/minecraft/util/math/ChunkPos.chunkZPos:I
        //   410: invokestatic    net/minecraft/world/WorldEntitySpawner.getRandomChunkPosition:(Lnet/minecraft/world/World;II)Lnet/minecraft/util/math/BlockPos;
        //   413: astore          llllllllllllIIlllIllIlIlIIIlIlII
        //   415: aload           llllllllllllIIlllIllIlIlIIIlIlII
        //   417: invokevirtual   net/minecraft/util/math/BlockPos.getX:()I
        //   420: istore          llllllllllllIIlllIllIlIlIIIlIIll
        //   422: aload           llllllllllllIIlllIllIlIlIIIlIlII
        //   424: invokevirtual   net/minecraft/util/math/BlockPos.getY:()I
        //   427: istore          llllllllllllIIlllIllIlIlIIIlIIlI
        //   429: aload           llllllllllllIIlllIllIlIlIIIlIlII
        //   431: invokevirtual   net/minecraft/util/math/BlockPos.getZ:()I
        //   434: istore          llllllllllllIIlllIllIlIlIIIlIIIl
        //   436: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   437: aload           llllllllllllIIlllIllIlIlIIIlIlII
        //   439: invokevirtual   net/minecraft/world/WorldServer.getBlockState:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/state/IBlockState;
        //   442: astore          llllllllllllIIlllIllIlIlIIIlIIII
        //   444: aload           llllllllllllIIlllIllIlIlIIIlIIII
        //   446: invokeinterface net/minecraft/block/state/IBlockState.isNormalCube:()Z
        //   451: ifne            869
        //   454: iconst_0       
        //   455: istore          llllllllllllIIlllIllIlIlIIIIllll
        //   457: iconst_0       
        //   458: istore          llllllllllllIIlllIllIlIlIIIIlllI
        //   460: goto            863
        //   463: iload           llllllllllllIIlllIllIlIlIIIlIIll
        //   465: istore          llllllllllllIIlllIllIlIlIIIIllIl
        //   467: iload           llllllllllllIIlllIllIlIlIIIlIIlI
        //   469: istore          llllllllllllIIlllIllIlIlIIIIllII
        //   471: iload           llllllllllllIIlllIllIlIlIIIlIIIl
        //   473: istore          llllllllllllIIlllIllIlIlIIIIlIll
        //   475: bipush          6
        //   477: istore          llllllllllllIIlllIllIlIlIIIIlIlI
        //   479: aconst_null    
        //   480: astore          llllllllllllIIlllIllIlIlIIIIlIIl
        //   482: aconst_null    
        //   483: astore          llllllllllllIIlllIllIlIlIIIIlIII
        //   485: invokestatic    java/lang/Math.random:()D
        //   488: ldc2_w          4.0
        //   491: dmul           
        //   492: invokestatic    net/minecraft/util/math/MathHelper.ceil:(D)I
        //   495: istore          llllllllllllIIlllIllIlIlIIIIIlll
        //   497: iconst_0       
        //   498: istore          llllllllllllIIlllIllIlIlIIIIIllI
        //   500: goto            853
        //   503: iload           llllllllllllIIlllIllIlIlIIIIllIl
        //   505: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   506: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   509: bipush          6
        //   511: invokevirtual   java/util/Random.nextInt:(I)I
        //   514: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   515: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   518: bipush          6
        //   520: invokevirtual   java/util/Random.nextInt:(I)I
        //   523: isub           
        //   524: iadd           
        //   525: istore          llllllllllllIIlllIllIlIlIIIIllIl
        //   527: iload           llllllllllllIIlllIllIlIlIIIIllII
        //   529: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   530: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   533: iconst_1       
        //   534: invokevirtual   java/util/Random.nextInt:(I)I
        //   537: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   538: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   541: iconst_1       
        //   542: invokevirtual   java/util/Random.nextInt:(I)I
        //   545: isub           
        //   546: iadd           
        //   547: istore          llllllllllllIIlllIllIlIlIIIIllII
        //   549: iload           llllllllllllIIlllIllIlIlIIIIlIll
        //   551: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   552: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   555: bipush          6
        //   557: invokevirtual   java/util/Random.nextInt:(I)I
        //   560: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   561: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   564: bipush          6
        //   566: invokevirtual   java/util/Random.nextInt:(I)I
        //   569: isub           
        //   570: iadd           
        //   571: istore          llllllllllllIIlllIllIlIlIIIIlIll
        //   573: aload           llllllllllllIIlllIllIlIlIIIlIllI
        //   575: iload           llllllllllllIIlllIllIlIlIIIIllIl
        //   577: iload           llllllllllllIIlllIllIlIlIIIIllII
        //   579: iload           llllllllllllIIlllIllIlIlIIIIlIll
        //   581: invokevirtual   net/minecraft/util/math/BlockPos$MutableBlockPos.setPos:(III)Lnet/minecraft/util/math/BlockPos$MutableBlockPos;
        //   584: pop            
        //   585: iload           llllllllllllIIlllIllIlIlIIIIllIl
        //   587: i2f            
        //   588: ldc             0.5
        //   590: fadd           
        //   591: fstore          llllllllllllIIlllIllIlIlIIIIIlIl
        //   593: iload           llllllllllllIIlllIllIlIlIIIIlIll
        //   595: i2f            
        //   596: ldc             0.5
        //   598: fadd           
        //   599: fstore          llllllllllllIIlllIllIlIlIIIIIlII
        //   601: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   602: fload           llllllllllllIIlllIllIlIlIIIIIlIl
        //   604: f2d            
        //   605: iload           llllllllllllIIlllIllIlIlIIIIllII
        //   607: i2d            
        //   608: fload           llllllllllllIIlllIllIlIlIIIIIlII
        //   610: f2d            
        //   611: ldc2_w          24.0
        //   614: invokevirtual   net/minecraft/world/WorldServer.isAnyPlayerWithinRangeAt:(DDDD)Z
        //   617: ifne            850
        //   620: aload           llllllllllllIIlllIllIlIlIIIllIlI
        //   622: fload           llllllllllllIIlllIllIlIlIIIIIlIl
        //   624: f2d            
        //   625: iload           llllllllllllIIlllIllIlIlIIIIllII
        //   627: i2d            
        //   628: fload           llllllllllllIIlllIllIlIlIIIIIlII
        //   630: f2d            
        //   631: invokevirtual   net/minecraft/util/math/BlockPos.distanceSq:(DDD)D
        //   634: ldc2_w          576.0
        //   637: dcmpl          
        //   638: iflt            850
        //   641: aload           llllllllllllIIlllIllIlIlIIIIlIIl
        //   643: ifnonnull       664
        //   646: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   647: aload           llllllllllllIIlllIllIlIlIIIllIIl
        //   649: aload           llllllllllllIIlllIllIlIlIIIlIllI
        //   651: invokevirtual   net/minecraft/world/WorldServer.getSpawnListEntryForTypeAt:(Lnet/minecraft/entity/EnumCreatureType;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/biome/Biome$SpawnListEntry;
        //   654: astore          llllllllllllIIlllIllIlIlIIIIlIIl
        //   656: aload           llllllllllllIIlllIllIlIlIIIIlIIl
        //   658: ifnonnull       664
        //   661: goto            860
        //   664: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   665: aload           llllllllllllIIlllIllIlIlIIIllIIl
        //   667: aload           llllllllllllIIlllIllIlIlIIIIlIIl
        //   669: aload           llllllllllllIIlllIllIlIlIIIlIllI
        //   671: invokevirtual   net/minecraft/world/WorldServer.canCreatureTypeSpawnHere:(Lnet/minecraft/entity/EnumCreatureType;Lnet/minecraft/world/biome/Biome$SpawnListEntry;Lnet/minecraft/util/math/BlockPos;)Z
        //   674: ifeq            850
        //   677: aload           llllllllllllIIlllIllIlIlIIIIlIIl
        //   679: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.entityClass:Ljava/lang/Class;
        //   682: invokestatic    net/minecraft/entity/EntitySpawnPlacementRegistry.getPlacementForEntity:(Ljava/lang/Class;)Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;
        //   685: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   686: aload           llllllllllllIIlllIllIlIlIIIlIllI
        //   688: invokestatic    net/minecraft/world/WorldEntitySpawner.canCreatureTypeSpawnAtLocation:(Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Z
        //   691: ifeq            850
        //   694: aload           llllllllllllIIlllIllIlIlIIIIlIIl
        //   696: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.entityClass:Ljava/lang/Class;
        //   699: iconst_1       
        //   700: anewarray       Ljava/lang/Class;
        //   703: dup            
        //   704: iconst_0       
        //   705: ldc             Lnet/minecraft/world/World;.class
        //   707: aastore        
        //   708: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   711: iconst_1       
        //   712: anewarray       Ljava/lang/Object;
        //   715: dup            
        //   716: iconst_0       
        //   717: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   718: aastore        
        //   719: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //   722: checkcast       Lnet/minecraft/entity/EntityLiving;
        //   725: astore          llllllllllllIIlllIllIlIlIIIIIIll
        //   727: goto            740
        //   730: astore          llllllllllllIIlllIllIlIlIIIIIIIl
        //   732: aload           llllllllllllIIlllIllIlIlIIIIIIIl
        //   734: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   737: iload           llllllllllllIIlllIllIlIlIIIllIll
        //   739: ireturn        
        //   740: aload           llllllllllllIIlllIllIlIlIIIIIIlI
        //   742: fload           llllllllllllIIlllIllIlIlIIIIIlIl
        //   744: f2d            
        //   745: iload           llllllllllllIIlllIllIlIlIIIIllII
        //   747: i2d            
        //   748: fload           llllllllllllIIlllIllIlIlIIIIIlII
        //   750: f2d            
        //   751: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   752: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   755: invokevirtual   java/util/Random.nextFloat:()F
        //   758: ldc_w           360.0
        //   761: fmul           
        //   762: fconst_0       
        //   763: invokevirtual   net/minecraft/entity/EntityLiving.setLocationAndAngles:(DDDFF)V
        //   766: aload           llllllllllllIIlllIllIlIlIIIIIIlI
        //   768: invokevirtual   net/minecraft/entity/EntityLiving.getCanSpawnHere:()Z
        //   771: ifeq            843
        //   774: aload           llllllllllllIIlllIllIlIlIIIIIIlI
        //   776: invokevirtual   net/minecraft/entity/EntityLiving.isNotColliding:()Z
        //   779: ifeq            843
        //   782: aload           llllllllllllIIlllIllIlIlIIIIIIlI
        //   784: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   785: new             Lnet/minecraft/util/math/BlockPos;
        //   788: dup            
        //   789: aload           llllllllllllIIlllIllIlIlIIIIIIlI
        //   791: invokespecial   net/minecraft/util/math/BlockPos.<init>:(Lnet/minecraft/entity/Entity;)V
        //   794: invokevirtual   net/minecraft/world/WorldServer.getDifficultyForLocation:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
        //   797: aload           llllllllllllIIlllIllIlIlIIIIlIII
        //   799: invokevirtual   net/minecraft/entity/EntityLiving.onInitialSpawn:(Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/IEntityLivingData;)Lnet/minecraft/entity/IEntityLivingData;
        //   802: astore          llllllllllllIIlllIllIlIlIIIIlIII
        //   804: aload           llllllllllllIIlllIllIlIlIIIIIIlI
        //   806: invokevirtual   net/minecraft/entity/EntityLiving.isNotColliding:()Z
        //   809: ifeq            825
        //   812: iinc            llllllllllllIIlllIllIlIlIIIIllll, 1
        //   815: aload_1         /* llllllllllllIIlllIllIlIlIIlIlIIl */
        //   816: aload           llllllllllllIIlllIllIlIlIIIIIIlI
        //   818: invokevirtual   net/minecraft/world/WorldServer.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   821: pop            
        //   822: goto            830
        //   825: aload           llllllllllllIIlllIllIlIlIIIIIIlI
        //   827: invokevirtual   net/minecraft/entity/EntityLiving.setDead:()V
        //   830: iload           llllllllllllIIlllIllIlIlIIIIllll
        //   832: aload           llllllllllllIIlllIllIlIlIIIIIIlI
        //   834: invokevirtual   net/minecraft/entity/EntityLiving.getMaxSpawnedInChunk:()I
        //   837: if_icmplt       843
        //   840: goto            869
        //   843: iload           llllllllllllIIlllIllIlIlIIIllIll
        //   845: iload           llllllllllllIIlllIllIlIlIIIIllll
        //   847: iadd           
        //   848: istore          llllllllllllIIlllIllIlIlIIIllIll
        //   850: iinc            llllllllllllIIlllIllIlIlIIIIIllI, 1
        //   853: iload           llllllllllllIIlllIllIlIlIIIIIllI
        //   855: iload           llllllllllllIIlllIllIlIlIIIIIlll
        //   857: if_icmplt       503
        //   860: iinc            llllllllllllIIlllIllIlIlIIIIlllI, 1
        //   863: iload           llllllllllllIIlllIllIlIlIIIIlllI
        //   865: iconst_3       
        //   866: if_icmplt       463
        //   869: aload           llllllllllllIIlllIllIlIIllllIIII
        //   871: invokeinterface java/util/Iterator.hasNext:()Z
        //   876: ifne            387
        //   879: iinc            llllllllllllIIlllIllIlIIllllIlll, 1
        //   882: iload           llllllllllllIIlllIllIlIIllllIlll
        //   884: iload           llllllllllllIIlllIllIlIIllllIllI
        //   886: if_icmplt       288
        //   889: iload           llllllllllllIIlllIllIlIlIIIllIll
        //   891: ireturn        
        //    StackMapTable: 00 1E 0A FE 00 19 01 00 07 00 37 FF 00 3A 00 0C 07 00 02 07 00 2B 01 01 01 01 07 00 3D 07 00 37 01 01 01 01 00 00 FC 00 06 01 1F 40 01 FD 00 62 01 07 00 52 F9 00 02 FA 00 09 FF 00 06 00 08 07 00 02 07 00 2B 01 01 01 01 00 07 00 37 00 00 FF 00 21 00 0C 07 00 02 07 00 2B 01 01 01 01 01 07 00 08 00 01 01 07 01 89 00 00 FF 00 12 00 0C 07 00 02 07 00 2B 01 01 01 01 01 07 00 08 07 00 84 01 01 07 01 89 00 00 0B 0C FF 00 36 00 11 07 00 02 07 00 2B 01 01 01 01 01 07 00 08 07 00 84 01 01 07 01 89 01 01 07 00 06 00 07 00 37 00 00 FF 00 4B 00 18 07 00 02 07 00 2B 01 01 01 01 01 07 00 08 07 00 84 01 01 07 01 89 01 01 07 00 06 07 00 52 07 00 37 07 00 08 01 01 01 07 00 B2 01 01 00 00 FF 00 27 00 20 07 00 02 07 00 2B 01 01 01 01 01 07 00 08 07 00 84 01 01 07 01 89 01 01 07 00 06 07 00 52 07 00 37 07 00 08 01 01 01 07 00 B2 01 01 01 01 01 01 07 00 0B 07 01 8B 01 01 00 00 FD 00 A0 02 02 F7 00 41 07 00 21 FC 00 09 07 00 17 FB 00 54 04 0C FA 00 06 F9 00 02 06 FF 00 02 00 18 07 00 02 07 00 2B 01 01 01 01 01 07 00 08 07 00 84 01 01 07 01 89 01 01 07 00 06 07 00 52 07 00 37 07 00 08 01 01 01 07 00 B2 01 01 00 00 FF 00 05 00 11 07 00 02 07 00 2B 01 01 01 01 01 07 00 08 07 00 84 01 01 07 01 89 01 01 07 00 06 00 07 00 37 00 00 FF 00 09 00 0C 07 00 02 07 00 2B 01 01 01 01 01 07 00 08 07 00 84 01 01 07 01 89 00 00 FF 00 02 00 0C 07 00 02 07 00 2B 01 01 01 01 01 07 00 08 00 01 01 07 01 89 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  694    727    730    740    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean canCreatureTypeSpawnAtLocation(final EntityLiving.SpawnPlacementType llllllllllllIIlllIllIlIIlIllIIll, final World llllllllllllIIlllIllIlIIlIlllIIl, final BlockPos llllllllllllIIlllIllIlIIlIlllIII) {
        if (!llllllllllllIIlllIllIlIIlIlllIIl.getWorldBorder().contains(llllllllllllIIlllIllIlIIlIlllIII)) {
            return false;
        }
        final IBlockState llllllllllllIIlllIllIlIIlIllIlll = llllllllllllIIlllIllIlIIlIlllIIl.getBlockState(llllllllllllIIlllIllIlIIlIlllIII);
        if (llllllllllllIIlllIllIlIIlIllIIll == EntityLiving.SpawnPlacementType.IN_WATER) {
            return llllllllllllIIlllIllIlIIlIllIlll.getMaterial() == Material.WATER && llllllllllllIIlllIllIlIIlIlllIIl.getBlockState(llllllllllllIIlllIllIlIIlIlllIII.down()).getMaterial() == Material.WATER && !llllllllllllIIlllIllIlIIlIlllIIl.getBlockState(llllllllllllIIlllIllIlIIlIlllIII.up()).isNormalCube();
        }
        final BlockPos llllllllllllIIlllIllIlIIlIllIllI = llllllllllllIIlllIllIlIIlIlllIII.down();
        if (!llllllllllllIIlllIllIlIIlIlllIIl.getBlockState(llllllllllllIIlllIllIlIIlIllIllI).isFullyOpaque()) {
            return false;
        }
        final Block llllllllllllIIlllIllIlIIlIllIlIl = llllllllllllIIlllIllIlIIlIlllIIl.getBlockState(llllllllllllIIlllIllIlIIlIllIllI).getBlock();
        final boolean llllllllllllIIlllIllIlIIlIllIlII = llllllllllllIIlllIllIlIIlIllIlIl != Blocks.BEDROCK && llllllllllllIIlllIllIlIIlIllIlIl != Blocks.BARRIER;
        return llllllllllllIIlllIllIlIIlIllIlII && isValidEmptySpawnBlock(llllllllllllIIlllIllIlIIlIllIlll) && isValidEmptySpawnBlock(llllllllllllIIlllIllIlIIlIlllIIl.getBlockState(llllllllllllIIlllIllIlIIlIlllIII.up()));
    }
    
    private static BlockPos getRandomChunkPosition(final World llllllllllllIIlllIllIlIIllIIllII, final int llllllllllllIIlllIllIlIIllIlIIll, final int llllllllllllIIlllIllIlIIllIIlIlI) {
        final Chunk llllllllllllIIlllIllIlIIllIlIIIl = llllllllllllIIlllIllIlIIllIIllII.getChunkFromChunkCoords(llllllllllllIIlllIllIlIIllIlIIll, llllllllllllIIlllIllIlIIllIIlIlI);
        final int llllllllllllIIlllIllIlIIllIlIIII = llllllllllllIIlllIllIlIIllIlIIll * 16 + llllllllllllIIlllIllIlIIllIIllII.rand.nextInt(16);
        final int llllllllllllIIlllIllIlIIllIIllll = llllllllllllIIlllIllIlIIllIIlIlI * 16 + llllllllllllIIlllIllIlIIllIIllII.rand.nextInt(16);
        final int llllllllllllIIlllIllIlIIllIIlllI = MathHelper.roundUp(llllllllllllIIlllIllIlIIllIlIIIl.getHeight(new BlockPos(llllllllllllIIlllIllIlIIllIlIIII, 0, llllllllllllIIlllIllIlIIllIIllll)) + 1, 16);
        final int llllllllllllIIlllIllIlIIllIIllIl = llllllllllllIIlllIllIlIIllIIllII.rand.nextInt((llllllllllllIIlllIllIlIIllIIlllI > 0) ? llllllllllllIIlllIllIlIIllIIlllI : (llllllllllllIIlllIllIlIIllIlIIIl.getTopFilledSegment() + 16 - 1));
        return new BlockPos(llllllllllllIIlllIllIlIIllIlIIII, llllllllllllIIlllIllIlIIllIIllIl, llllllllllllIIlllIllIlIIllIIllll);
    }
    
    public static void performWorldGenSpawning(final World llllllllllllIIlllIllIlIIlIIIIIIl, final Biome llllllllllllIIlllIllIlIIlIIlIllI, final int llllllllllllIIlllIllIlIIIlllllll, final int llllllllllllIIlllIllIlIIlIIlIlII, final int llllllllllllIIlllIllIlIIIlllllIl, final int llllllllllllIIlllIllIlIIlIIlIIlI, final Random llllllllllllIIlllIllIlIIlIIlIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       net/minecraft/entity/EnumCreatureType.CREATURE:Lnet/minecraft/entity/EnumCreatureType;
        //     4: invokevirtual   net/minecraft/world/biome/Biome.getSpawnableList:(Lnet/minecraft/entity/EnumCreatureType;)Ljava/util/List;
        //     7: astore          llllllllllllIIlllIllIlIIlIIlIIII
        //     9: aload           llllllllllllIIlllIllIlIIlIIlIIII
        //    11: invokeinterface java/util/List.isEmpty:()Z
        //    16: ifne            395
        //    19: goto            382
        //    22: aload_0         /* llllllllllllIIlllIllIlIIlIIlIlll */
        //    23: getfield        net/minecraft/world/World.rand:Ljava/util/Random;
        //    26: aload           llllllllllllIIlllIllIlIIlIIlIIII
        //    28: invokestatic    net/minecraft/util/WeightedRandom.getRandomItem:(Ljava/util/Random;Ljava/util/List;)Lnet/minecraft/util/WeightedRandom$Item;
        //    31: checkcast       Lnet/minecraft/world/biome/Biome$SpawnListEntry;
        //    34: astore          llllllllllllIIlllIllIlIIlIIIllll
        //    36: aload           llllllllllllIIlllIllIlIIlIIIllll
        //    38: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.minGroupCount:I
        //    41: aload           llllllllllllIIlllIllIlIIIllllIll
        //    43: iconst_1       
        //    44: aload           llllllllllllIIlllIllIlIIlIIIllll
        //    46: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.maxGroupCount:I
        //    49: iadd           
        //    50: aload           llllllllllllIIlllIllIlIIlIIIllll
        //    52: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.minGroupCount:I
        //    55: isub           
        //    56: invokevirtual   java/util/Random.nextInt:(I)I
        //    59: iadd           
        //    60: istore          llllllllllllIIlllIllIlIIlIIIlllI
        //    62: aconst_null    
        //    63: astore          llllllllllllIIlllIllIlIIlIIIllIl
        //    65: iload_2         /* llllllllllllIIlllIllIlIIlIIlIlIl */
        //    66: aload           llllllllllllIIlllIllIlIIIllllIll
        //    68: iload           llllllllllllIIlllIllIlIIlIIlIIll
        //    70: invokevirtual   java/util/Random.nextInt:(I)I
        //    73: iadd           
        //    74: istore          llllllllllllIIlllIllIlIIlIIIllII
        //    76: iload_3         /* llllllllllllIIlllIllIlIIIllllllI */
        //    77: aload           llllllllllllIIlllIllIlIIIllllIll
        //    79: iload           llllllllllllIIlllIllIlIIIlllllII
        //    81: invokevirtual   java/util/Random.nextInt:(I)I
        //    84: iadd           
        //    85: istore          llllllllllllIIlllIllIlIIlIIIlIll
        //    87: iload           llllllllllllIIlllIllIlIIlIIIllII
        //    89: istore          llllllllllllIIlllIllIlIIlIIIlIlI
        //    91: iload           llllllllllllIIlllIllIlIIlIIIlIll
        //    93: istore          llllllllllllIIlllIllIlIIlIIIlIIl
        //    95: iconst_0       
        //    96: istore          llllllllllllIIlllIllIlIIlIIIlIII
        //    98: goto            375
        //   101: iconst_0       
        //   102: istore          llllllllllllIIlllIllIlIIlIIIIlll
        //   104: iconst_0       
        //   105: istore          llllllllllllIIlllIllIlIIlIIIIllI
        //   107: goto            361
        //   110: aload_0         /* llllllllllllIIlllIllIlIIlIIlIlll */
        //   111: new             Lnet/minecraft/util/math/BlockPos;
        //   114: dup            
        //   115: iload           llllllllllllIIlllIllIlIIlIIIllII
        //   117: iconst_0       
        //   118: iload           llllllllllllIIlllIllIlIIlIIIlIll
        //   120: invokespecial   net/minecraft/util/math/BlockPos.<init>:(III)V
        //   123: invokevirtual   net/minecraft/world/World.getTopSolidOrLiquidBlock:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/math/BlockPos;
        //   126: astore          llllllllllllIIlllIllIlIIlIIIIlIl
        //   128: getstatic       net/minecraft/entity/EntityLiving$SpawnPlacementType.ON_GROUND:Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;
        //   131: aload_0         /* llllllllllllIIlllIllIlIIlIIlIlll */
        //   132: aload           llllllllllllIIlllIllIlIIlIIIIlIl
        //   134: invokestatic    net/minecraft/world/WorldEntitySpawner.canCreatureTypeSpawnAtLocation:(Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Z
        //   137: ifeq            253
        //   140: aload           llllllllllllIIlllIllIlIIlIIIllll
        //   142: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.entityClass:Ljava/lang/Class;
        //   145: iconst_1       
        //   146: anewarray       Ljava/lang/Class;
        //   149: dup            
        //   150: iconst_0       
        //   151: ldc             Lnet/minecraft/world/World;.class
        //   153: aastore        
        //   154: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   157: iconst_1       
        //   158: anewarray       Ljava/lang/Object;
        //   161: dup            
        //   162: iconst_0       
        //   163: aload_0         /* llllllllllllIIlllIllIlIIlIIlIlll */
        //   164: aastore        
        //   165: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //   168: checkcast       Lnet/minecraft/entity/EntityLiving;
        //   171: astore          llllllllllllIIlllIllIlIIlIIIIlII
        //   173: goto            186
        //   176: astore          llllllllllllIIlllIllIlIIlIIIIIlI
        //   178: aload           llllllllllllIIlllIllIlIIlIIIIIlI
        //   180: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   183: goto            358
        //   186: aload           llllllllllllIIlllIllIlIIlIIIIIll
        //   188: iload           llllllllllllIIlllIllIlIIlIIIllII
        //   190: i2f            
        //   191: ldc             0.5
        //   193: fadd           
        //   194: f2d            
        //   195: aload           llllllllllllIIlllIllIlIIlIIIIlIl
        //   197: invokevirtual   net/minecraft/util/math/BlockPos.getY:()I
        //   200: i2d            
        //   201: iload           llllllllllllIIlllIllIlIIlIIIlIll
        //   203: i2f            
        //   204: ldc             0.5
        //   206: fadd           
        //   207: f2d            
        //   208: aload           llllllllllllIIlllIllIlIIIllllIll
        //   210: invokevirtual   java/util/Random.nextFloat:()F
        //   213: ldc_w           360.0
        //   216: fmul           
        //   217: fconst_0       
        //   218: invokevirtual   net/minecraft/entity/EntityLiving.setLocationAndAngles:(DDDFF)V
        //   221: aload_0         /* llllllllllllIIlllIllIlIIlIIlIlll */
        //   222: aload           llllllllllllIIlllIllIlIIlIIIIIll
        //   224: invokevirtual   net/minecraft/world/World.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   227: pop            
        //   228: aload           llllllllllllIIlllIllIlIIlIIIIIll
        //   230: aload_0         /* llllllllllllIIlllIllIlIIlIIlIlll */
        //   231: new             Lnet/minecraft/util/math/BlockPos;
        //   234: dup            
        //   235: aload           llllllllllllIIlllIllIlIIlIIIIIll
        //   237: invokespecial   net/minecraft/util/math/BlockPos.<init>:(Lnet/minecraft/entity/Entity;)V
        //   240: invokevirtual   net/minecraft/world/World.getDifficultyForLocation:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
        //   243: aload           llllllllllllIIlllIllIlIIlIIIllIl
        //   245: invokevirtual   net/minecraft/entity/EntityLiving.onInitialSpawn:(Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/IEntityLivingData;)Lnet/minecraft/entity/IEntityLivingData;
        //   248: astore          llllllllllllIIlllIllIlIIlIIIllIl
        //   250: iconst_1       
        //   251: istore          llllllllllllIIlllIllIlIIlIIIIlll
        //   253: iload           llllllllllllIIlllIllIlIIlIIIllII
        //   255: aload           llllllllllllIIlllIllIlIIIllllIll
        //   257: iconst_5       
        //   258: invokevirtual   java/util/Random.nextInt:(I)I
        //   261: aload           llllllllllllIIlllIllIlIIIllllIll
        //   263: iconst_5       
        //   264: invokevirtual   java/util/Random.nextInt:(I)I
        //   267: isub           
        //   268: iadd           
        //   269: istore          llllllllllllIIlllIllIlIIlIIIllII
        //   271: iload           llllllllllllIIlllIllIlIIlIIIlIll
        //   273: aload           llllllllllllIIlllIllIlIIIllllIll
        //   275: iconst_5       
        //   276: invokevirtual   java/util/Random.nextInt:(I)I
        //   279: aload           llllllllllllIIlllIllIlIIIllllIll
        //   281: iconst_5       
        //   282: invokevirtual   java/util/Random.nextInt:(I)I
        //   285: isub           
        //   286: iadd           
        //   287: istore          llllllllllllIIlllIllIlIIlIIIlIll
        //   289: goto            328
        //   292: iload           llllllllllllIIlllIllIlIIlIIIlIlI
        //   294: aload           llllllllllllIIlllIllIlIIIllllIll
        //   296: iconst_5       
        //   297: invokevirtual   java/util/Random.nextInt:(I)I
        //   300: iadd           
        //   301: aload           llllllllllllIIlllIllIlIIIllllIll
        //   303: iconst_5       
        //   304: invokevirtual   java/util/Random.nextInt:(I)I
        //   307: isub           
        //   308: istore          llllllllllllIIlllIllIlIIlIIIllII
        //   310: iload           llllllllllllIIlllIllIlIIlIIIlIIl
        //   312: aload           llllllllllllIIlllIllIlIIIllllIll
        //   314: iconst_5       
        //   315: invokevirtual   java/util/Random.nextInt:(I)I
        //   318: iadd           
        //   319: aload           llllllllllllIIlllIllIlIIIllllIll
        //   321: iconst_5       
        //   322: invokevirtual   java/util/Random.nextInt:(I)I
        //   325: isub           
        //   326: istore          llllllllllllIIlllIllIlIIlIIIlIll
        //   328: iload           llllllllllllIIlllIllIlIIlIIIllII
        //   330: iload_2         /* llllllllllllIIlllIllIlIIlIIlIlIl */
        //   331: if_icmplt       292
        //   334: iload           llllllllllllIIlllIllIlIIlIIIllII
        //   336: iload_2         /* llllllllllllIIlllIllIlIIlIIlIlIl */
        //   337: iload           llllllllllllIIlllIllIlIIlIIlIIll
        //   339: iadd           
        //   340: if_icmpge       292
        //   343: iload           llllllllllllIIlllIllIlIIlIIIlIll
        //   345: iload_3         /* llllllllllllIIlllIllIlIIIllllllI */
        //   346: if_icmplt       292
        //   349: iload           llllllllllllIIlllIllIlIIlIIIlIll
        //   351: iload_3         /* llllllllllllIIlllIllIlIIIllllllI */
        //   352: iload           llllllllllllIIlllIllIlIIlIIlIIll
        //   354: iadd           
        //   355: if_icmpge       292
        //   358: iinc            llllllllllllIIlllIllIlIIlIIIIllI, 1
        //   361: iload           llllllllllllIIlllIllIlIIlIIIIlll
        //   363: ifne            372
        //   366: iload           llllllllllllIIlllIllIlIIlIIIIllI
        //   368: iconst_4       
        //   369: if_icmplt       110
        //   372: iinc            llllllllllllIIlllIllIlIIlIIIlIII, 1
        //   375: iload           llllllllllllIIlllIllIlIIlIIIlIII
        //   377: iload           llllllllllllIIlllIllIlIIlIIIlllI
        //   379: if_icmplt       101
        //   382: aload           llllllllllllIIlllIllIlIIIllllIll
        //   384: invokevirtual   java/util/Random.nextFloat:()F
        //   387: aload_1         /* llllllllllllIIlllIllIlIIlIIIIIII */
        //   388: invokevirtual   net/minecraft/world/biome/Biome.getSpawningChance:()F
        //   391: fcmpg          
        //   392: iflt            22
        //   395: return         
        //    StackMapTable: 00 0E FC 00 16 07 00 31 FF 00 4E 00 10 07 00 F5 07 00 0D 01 01 01 01 07 00 C6 07 00 31 07 00 0B 01 07 01 8B 01 01 01 01 01 00 00 FD 00 08 01 01 FF 00 41 00 13 07 00 F5 07 00 0D 01 01 01 01 07 00 C6 07 00 31 07 00 0B 01 07 01 8B 01 01 01 01 01 01 01 07 00 08 00 01 07 00 21 FC 00 09 07 00 17 FA 00 42 26 23 1D FA 00 02 0A F9 00 02 FF 00 06 00 08 07 00 F5 07 00 0D 01 01 01 01 07 00 C6 07 00 31 00 00 0C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  140    173    176    186    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public WorldEntitySpawner() {
        this.eligibleChunksForSpawning = (Set<ChunkPos>)Sets.newHashSet();
    }
    
    public static boolean isValidEmptySpawnBlock(final IBlockState llllllllllllIIlllIllIlIIllIIIIll) {
        return !llllllllllllIIlllIllIlIIllIIIIll.isBlockNormalCube() && !llllllllllllIIlllIllIlIIllIIIIll.canProvidePower() && !llllllllllllIIlllIllIlIIllIIIIll.getMaterial().isLiquid() && !BlockRailBase.isRailBlock(llllllllllllIIlllIllIlIIllIIIIll);
    }
    
    static {
        MOB_COUNT_DIV = (int)Math.pow(17.0, 2.0);
    }
}
