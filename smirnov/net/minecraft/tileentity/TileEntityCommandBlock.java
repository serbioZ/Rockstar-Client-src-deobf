// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.Vec3d;
import javax.annotation.Nullable;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.command.CommandResultStats;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class TileEntityCommandBlock extends TileEntity
{
    private final /* synthetic */ CommandBlockBaseLogic commandBlockLogic;
    private /* synthetic */ boolean powered;
    private /* synthetic */ boolean conditionMet;
    private /* synthetic */ boolean auto;
    private /* synthetic */ boolean sendToClient;
    
    public void setPowered(final boolean lllllllllllIllllIlllIlIlIIIIIlIl) {
        this.powered = lllllllllllIllllIlllIlIlIIIIIlIl;
    }
    
    public Mode getMode() {
        final Block lllllllllllIllllIlllIlIIllIllIII = this.getBlockType();
        if (lllllllllllIllllIlllIlIIllIllIII == Blocks.COMMAND_BLOCK) {
            return Mode.REDSTONE;
        }
        if (lllllllllllIllllIlllIlIIllIllIII == Blocks.REPEATING_COMMAND_BLOCK) {
            return Mode.AUTO;
        }
        return (lllllllllllIllllIlllIlIIllIllIII == Blocks.CHAIN_COMMAND_BLOCK) ? Mode.SEQUENCE : Mode.REDSTONE;
    }
    
    public boolean isSendToClient() {
        return this.sendToClient;
    }
    
    public CommandBlockBaseLogic getCommandBlockLogic() {
        return this.commandBlockLogic;
    }
    
    public boolean isConditional() {
        final IBlockState lllllllllllIllllIlllIlIIllIlIIlI = this.world.getBlockState(this.getPos());
        return lllllllllllIllllIlllIlIIllIlIIlI.getBlock() instanceof BlockCommandBlock && lllllllllllIllllIlllIlIIllIlIIlI.getValue((IProperty<Boolean>)BlockCommandBlock.CONDITIONAL);
    }
    
    public CommandResultStats getCommandResultStats() {
        return this.commandBlockLogic.getCommandResultStats();
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIllllIlllIlIlIIIlllII) {
        super.writeToNBT(lllllllllllIllllIlllIlIlIIIlllII);
        this.commandBlockLogic.writeToNBT(lllllllllllIllllIlllIlIlIIIlllII);
        lllllllllllIllllIlllIlIlIIIlllII.setBoolean("powered", this.isPowered());
        lllllllllllIllllIlllIlIlIIIlllII.setBoolean("conditionMet", this.isConditionMet());
        lllllllllllIllllIlllIlIlIIIlllII.setBoolean("auto", this.isAuto());
        return lllllllllllIllllIlllIlIlIIIlllII;
    }
    
    public boolean isPowered() {
        return this.powered;
    }
    
    public boolean isConditionMet() {
        return this.conditionMet;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        if (this.isSendToClient()) {
            this.setSendToClient(false);
            final NBTTagCompound lllllllllllIllllIlllIlIlIIIlIIlI = this.writeToNBT(new NBTTagCompound());
            return new SPacketUpdateTileEntity(this.pos, 2, lllllllllllIllllIlllIlIlIIIlIIlI);
        }
        return null;
    }
    
    public TileEntityCommandBlock() {
        this.commandBlockLogic = new CommandBlockBaseLogic() {
            @Override
            public Vec3d getPositionVector() {
                return new Vec3d(TileEntityCommandBlock.this.pos.getX() + 0.5, TileEntityCommandBlock.this.pos.getY() + 0.5, TileEntityCommandBlock.this.pos.getZ() + 0.5);
            }
            
            @Override
            public void fillInInfo(final ByteBuf llllllllllllllIIIIlIlIlIIlIIIlll) {
                llllllllllllllIIIIlIlIlIIlIIIlll.writeInt(TileEntityCommandBlock.this.pos.getX());
                llllllllllllllIIIIlIlIlIIlIIIlll.writeInt(TileEntityCommandBlock.this.pos.getY());
                llllllllllllllIIIIlIlIlIIlIIIlll.writeInt(TileEntityCommandBlock.this.pos.getZ());
            }
            
            @Override
            public BlockPos getPosition() {
                return TileEntityCommandBlock.this.pos;
            }
            
            @Override
            public void setCommand(final String llllllllllllllIIIIlIlIlIIlIlIlII) {
                super.setCommand(llllllllllllllIIIIlIlIlIIlIlIlII);
                TileEntityCommandBlock.this.markDirty();
            }
            
            @Override
            public MinecraftServer getServer() {
                return TileEntityCommandBlock.this.world.getMinecraftServer();
            }
            
            @Override
            public World getEntityWorld() {
                return TileEntityCommandBlock.this.getWorld();
            }
            
            @Override
            public int getCommandBlockType() {
                return 0;
            }
            
            @Override
            public void updateCommand() {
                final IBlockState llllllllllllllIIIIlIlIlIIlIlIIII = TileEntityCommandBlock.this.world.getBlockState(TileEntityCommandBlock.this.pos);
                TileEntityCommandBlock.this.getWorld().notifyBlockUpdate(TileEntityCommandBlock.this.pos, llllllllllllllIIIIlIlIlIIlIlIIII, llllllllllllllIIIIlIlIlIIlIlIIII, 3);
            }
        };
    }
    
    public void setAuto(final boolean lllllllllllIllllIlllIlIIllllIIll) {
        final boolean lllllllllllIllllIlllIlIIllllIllI = this.auto;
        this.auto = lllllllllllIllllIlllIlIIllllIIll;
        if (!lllllllllllIllllIlllIlIIllllIllI && lllllllllllIllllIlllIlIIllllIIll && !this.powered && this.world != null && this.getMode() != Mode.SEQUENCE) {
            final Block lllllllllllIllllIlllIlIIllllIlIl = this.getBlockType();
            if (lllllllllllIllllIlllIlIIllllIlIl instanceof BlockCommandBlock) {
                this.setConditionMet();
                this.world.scheduleUpdate(this.pos, lllllllllllIllllIlllIlIIllllIlIl, lllllllllllIllllIlllIlIIllllIlIl.tickRate(this.world));
            }
        }
    }
    
    public void setSendToClient(final boolean lllllllllllIllllIlllIlIIllIllllI) {
        this.sendToClient = lllllllllllIllllIlllIlIIllIllllI;
    }
    
    @Override
    public void validate() {
        this.blockType = null;
        super.validate();
    }
    
    public boolean isAuto() {
        return this.auto;
    }
    
    public boolean setConditionMet() {
        this.conditionMet = true;
        if (this.isConditional()) {
            final BlockPos lllllllllllIllllIlllIlIIlllIlIIl = this.pos.offset(this.world.getBlockState(this.pos).getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING).getOpposite());
            if (this.world.getBlockState(lllllllllllIllllIlllIlIIlllIlIIl).getBlock() instanceof BlockCommandBlock) {
                final TileEntity lllllllllllIllllIlllIlIIlllIlIII = this.world.getTileEntity(lllllllllllIllllIlllIlIIlllIlIIl);
                this.conditionMet = (lllllllllllIllllIlllIlIIlllIlIII instanceof TileEntityCommandBlock && ((TileEntityCommandBlock)lllllllllllIllllIlllIlIIlllIlIII).getCommandBlockLogic().getSuccessCount() > 0);
            }
            else {
                this.conditionMet = false;
            }
        }
        return this.conditionMet;
    }
    
    @Override
    public boolean onlyOpsCanSetNbt() {
        return true;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIllllIlllIlIlIIIllIII) {
        super.readFromNBT(lllllllllllIllllIlllIlIlIIIllIII);
        this.commandBlockLogic.readDataFromNBT(lllllllllllIllllIlllIlIlIIIllIII);
        this.powered = lllllllllllIllllIlllIlIlIIIllIII.getBoolean("powered");
        this.conditionMet = lllllllllllIllllIlllIlIlIIIllIII.getBoolean("conditionMet");
        this.setAuto(lllllllllllIllllIlllIlIlIIIllIII.getBoolean("auto"));
    }
    
    public enum Mode
    {
        REDSTONE("REDSTONE", 2), 
        AUTO("AUTO", 1), 
        SEQUENCE("SEQUENCE", 0);
        
        private Mode(final String lllllllllllIIlIIIlIlIIIlllIllllI, final int lllllllllllIIlIIIlIlIIIlllIlllIl) {
        }
    }
}
