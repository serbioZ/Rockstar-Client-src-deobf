// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.WeightedSpawnerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.datafix.IFixType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.IDataFixer;
import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import javax.annotation.Nullable;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;

public class TileEntityMobSpawner extends TileEntity implements ITickable
{
    private final /* synthetic */ MobSpawnerBaseLogic spawnerLogic;
    
    public MobSpawnerBaseLogic getSpawnerBaseLogic() {
        return this.spawnerLogic;
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        final NBTTagCompound llllllllllllIIlllIllIIlIllllIlll = this.writeToNBT(new NBTTagCompound());
        llllllllllllIIlllIllIIlIllllIlll.removeTag("SpawnPotentials");
        return llllllllllllIIlllIllIIlIllllIlll;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIIlllIllIIllIIIIIIIl) {
        super.writeToNBT(llllllllllllIIlllIllIIllIIIIIIIl);
        this.spawnerLogic.writeToNBT(llllllllllllIIlllIllIIllIIIIIIIl);
        return llllllllllllIIlllIllIIllIIIIIIIl;
    }
    
    @Override
    public boolean onlyOpsCanSetNbt() {
        return true;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllIIlllIllIIllIIIIIlll) {
        super.readFromNBT(llllllllllllIIlllIllIIllIIIIIlll);
        this.spawnerLogic.readFromNBT(llllllllllllIIlllIllIIllIIIIIlll);
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 1, this.getUpdateTag());
    }
    
    @Override
    public boolean receiveClientEvent(final int llllllllllllIIlllIllIIlIllllIIII, final int llllllllllllIIlllIllIIlIlllIllII) {
        return this.spawnerLogic.setDelayToMin(llllllllllllIIlllIllIIlIllllIIII) || super.receiveClientEvent(llllllllllllIIlllIllIIlIllllIIII, llllllllllllIIlllIllIIlIlllIllII);
    }
    
    public static void registerFixesMobSpawner(final DataFixer llllllllllllIIlllIllIIllIIIIlllI) {
        llllllllllllIIlllIllIIllIIIIlllI.registerWalker(FixTypes.BLOCK_ENTITY, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer llllllllllllIlIIIlIlllIlIlIIIIIl, final NBTTagCompound llllllllllllIlIIIlIlllIlIlIIIIII, final int llllllllllllIlIIIlIlllIlIlIIIlIl) {
                if (TileEntity.func_190559_a(TileEntityMobSpawner.class).equals(new ResourceLocation(llllllllllllIlIIIlIlllIlIlIIIIII.getString("id")))) {
                    if (llllllllllllIlIIIlIlllIlIlIIIIII.hasKey("SpawnPotentials", 9)) {
                        final NBTTagList llllllllllllIlIIIlIlllIlIlIIIlII = llllllllllllIlIIIlIlllIlIlIIIIII.getTagList("SpawnPotentials", 10);
                        for (int llllllllllllIlIIIlIlllIlIlIIIIll = 0; llllllllllllIlIIIlIlllIlIlIIIIll < llllllllllllIlIIIlIlllIlIlIIIlII.tagCount(); ++llllllllllllIlIIIlIlllIlIlIIIIll) {
                            final NBTTagCompound llllllllllllIlIIIlIlllIlIlIIIIlI = llllllllllllIlIIIlIlllIlIlIIIlII.getCompoundTagAt(llllllllllllIlIIIlIlllIlIlIIIIll);
                            llllllllllllIlIIIlIlllIlIlIIIIlI.setTag("Entity", llllllllllllIlIIIlIlllIlIlIIIIIl.process(FixTypes.ENTITY, llllllllllllIlIIIlIlllIlIlIIIIlI.getCompoundTag("Entity"), llllllllllllIlIIIlIlllIlIlIIIlIl));
                        }
                    }
                    llllllllllllIlIIIlIlllIlIlIIIIII.setTag("SpawnData", llllllllllllIlIIIlIlllIlIlIIIIIl.process(FixTypes.ENTITY, llllllllllllIlIIIlIlllIlIlIIIIII.getCompoundTag("SpawnData"), llllllllllllIlIIIlIlllIlIlIIIlIl));
                }
                return llllllllllllIlIIIlIlllIlIlIIIIII;
            }
        });
    }
    
    @Override
    public void update() {
        this.spawnerLogic.updateSpawner();
    }
    
    public TileEntityMobSpawner() {
        this.spawnerLogic = new MobSpawnerBaseLogic() {
            @Override
            public BlockPos getSpawnerPosition() {
                return TileEntityMobSpawner.this.pos;
            }
            
            @Override
            public World getSpawnerWorld() {
                return TileEntityMobSpawner.this.world;
            }
            
            @Override
            public void setNextSpawnData(final WeightedSpawnerEntity llllllllllIlllllIIlIllIIIllIlIIl) {
                super.setNextSpawnData(llllllllllIlllllIIlIllIIIllIlIIl);
                if (this.getSpawnerWorld() != null) {
                    final IBlockState llllllllllIlllllIIlIllIIIllIlIII = this.getSpawnerWorld().getBlockState(this.getSpawnerPosition());
                    this.getSpawnerWorld().notifyBlockUpdate(TileEntityMobSpawner.this.pos, llllllllllIlllllIIlIllIIIllIlIII, llllllllllIlllllIIlIllIIIllIlIII, 4);
                }
            }
            
            @Override
            public void broadcastEvent(final int llllllllllIlllllIIlIllIIIlllIllI) {
                TileEntityMobSpawner.this.world.addBlockEvent(TileEntityMobSpawner.this.pos, Blocks.MOB_SPAWNER, llllllllllIlllllIIlIllIIIlllIllI, 0);
            }
        };
    }
}
