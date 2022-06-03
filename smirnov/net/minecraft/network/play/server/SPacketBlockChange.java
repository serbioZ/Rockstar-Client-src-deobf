// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import net.minecraft.world.World;
import java.io.IOException;
import net.minecraft.block.Block;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketBlockChange implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ IBlockState blockState;
    private /* synthetic */ BlockPos blockPosition;
    
    public BlockPos getBlockPosition() {
        return this.blockPosition;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIIllIIIllIlIIIIIlIl) throws IOException {
        this.blockPosition = lllllllllllIIIIllIIIllIlIIIIIlIl.readBlockPos();
        this.blockState = Block.BLOCK_STATE_IDS.getByValue(lllllllllllIIIIllIIIllIlIIIIIlIl.readVarIntFromBuffer());
    }
    
    public SPacketBlockChange(final World lllllllllllIIIIllIIIllIlIIIIlIlI, final BlockPos lllllllllllIIIIllIIIllIlIIIIlIIl) {
        this.blockPosition = lllllllllllIIIIllIIIllIlIIIIlIIl;
        this.blockState = lllllllllllIIIIllIIIllIlIIIIlIlI.getBlockState(lllllllllllIIIIllIIIllIlIIIIlIIl);
    }
    
    public IBlockState getBlockState() {
        return this.blockState;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIIllIIIllIIllllllll) throws IOException {
        lllllllllllIIIIllIIIllIIllllllll.writeBlockPos(this.blockPosition);
        lllllllllllIIIIllIIIllIIllllllll.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(this.blockState));
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIIIllIIIllIIllllIlll) {
        lllllllllllIIIIllIIIllIIllllIlll.handleBlockChange(this);
    }
    
    public SPacketBlockChange() {
    }
}
