// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.text.TextComponentString;
import javax.annotation.Nullable;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.command.CommandException;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.command.ICommandSender;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.command.CommandResultStats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;

public class TileEntitySign extends TileEntity
{
    public /* synthetic */ int lineBeingEdited;
    public final /* synthetic */ ITextComponent[] signText;
    private /* synthetic */ boolean isEditable;
    private /* synthetic */ EntityPlayer player;
    private final /* synthetic */ CommandResultStats stats;
    
    public void setEditable(final boolean llllllllllllllllIIIIlIIllIIIlIll) {
        this.isEditable = llllllllllllllllIIIIlIIllIIIlIll;
        if (!llllllllllllllllIIIIlIIllIIIlIll) {
            this.player = null;
        }
    }
    
    public void setPlayer(final EntityPlayer llllllllllllllllIIIIlIIllIIIIlIl) {
        this.player = llllllllllllllllIIIIlIIllIIIIlIl;
    }
    
    @Override
    public boolean onlyOpsCanSetNbt() {
        return true;
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    @Override
    protected void setWorldCreate(final World llllllllllllllllIIIIlIIllIlIlllI) {
        this.setWorldObj(llllllllllllllllIIIIlIIllIlIlllI);
    }
    
    public boolean executeCommand(final EntityPlayer llllllllllllllllIIIIlIIlIlllIlIl) {
        final ICommandSender llllllllllllllllIIIIlIIlIlllIlII = new ICommandSender() {
            @Override
            public boolean sendCommandFeedback() {
                return false;
            }
            
            @Override
            public void setCommandStat(final CommandResultStats.Type lllllllllllIIIlIlIIIIIIIIIIIIIII, final int lllllllllllIIIlIIlllllllllllllII) {
                if (TileEntitySign.this.world != null && !TileEntitySign.this.world.isRemote) {
                    TileEntitySign.this.stats.setCommandStatForSender(TileEntitySign.this.world.getMinecraftServer(), this, lllllllllllIIIlIlIIIIIIIIIIIIIII, lllllllllllIIIlIIlllllllllllllII);
                }
            }
            
            @Override
            public String getName() {
                return llllllllllllllllIIIIlIIlIlllIlIl.getName();
            }
            
            @Override
            public Vec3d getPositionVector() {
                return new Vec3d(TileEntitySign.this.pos.getX() + 0.5, TileEntitySign.this.pos.getY() + 0.5, TileEntitySign.this.pos.getZ() + 0.5);
            }
            
            @Override
            public boolean canCommandSenderUseCommand(final int lllllllllllIIIlIlIIIIIIIIIIlIIlI, final String lllllllllllIIIlIlIIIIIIIIIIlIIll) {
                return lllllllllllIIIlIlIIIIIIIIIIlIIlI <= 2;
            }
            
            @Override
            public ITextComponent getDisplayName() {
                return llllllllllllllllIIIIlIIlIlllIlIl.getDisplayName();
            }
            
            @Override
            public World getEntityWorld() {
                return llllllllllllllllIIIIlIIlIlllIlIl.getEntityWorld();
            }
            
            @Override
            public Entity getCommandSenderEntity() {
                return llllllllllllllllIIIIlIIlIlllIlIl;
            }
            
            @Override
            public void addChatMessage(final ITextComponent lllllllllllIIIlIlIIIIIIIIIIlIlll) {
            }
            
            @Override
            public MinecraftServer getServer() {
                return llllllllllllllllIIIIlIIlIlllIlIl.getServer();
            }
            
            @Override
            public BlockPos getPosition() {
                return TileEntitySign.this.pos;
            }
        };
        final double llllllllllllllllIIIIlIIlIllIlIlI;
        final String llllllllllllllllIIIIlIIlIllIlIll = (String)((ITextComponent[])(Object)(llllllllllllllllIIIIlIIlIllIlIlI = (double)(Object)this.signText)).length;
        for (char llllllllllllllllIIIIlIIlIllIllII = '\0'; llllllllllllllllIIIIlIIlIllIllII < llllllllllllllllIIIIlIIlIllIlIll; ++llllllllllllllllIIIIlIIlIllIllII) {
            final ITextComponent llllllllllllllllIIIIlIIlIlllIIll = llllllllllllllllIIIIlIIlIllIlIlI[llllllllllllllllIIIIlIIlIllIllII];
            final Style llllllllllllllllIIIIlIIlIlllIIlI = (llllllllllllllllIIIIlIIlIlllIIll == null) ? null : llllllllllllllllIIIIlIIlIlllIIll.getStyle();
            if (llllllllllllllllIIIIlIIlIlllIIlI != null && llllllllllllllllIIIIlIIlIlllIIlI.getClickEvent() != null) {
                final ClickEvent llllllllllllllllIIIIlIIlIlllIIIl = llllllllllllllllIIIIlIIlIlllIIlI.getClickEvent();
                if (llllllllllllllllIIIIlIIlIlllIIIl.getAction() == ClickEvent.Action.RUN_COMMAND) {
                    llllllllllllllllIIIIlIIlIlllIlIl.getServer().getCommandManager().executeCommand(llllllllllllllllIIIIlIIlIlllIlII, llllllllllllllllIIIIlIIlIlllIIIl.getValue());
                }
            }
        }
        return true;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllllIIIIlIIllIIllllI) {
        this.isEditable = false;
        super.readFromNBT(llllllllllllllllIIIIlIIllIIllllI);
        final ICommandSender llllllllllllllllIIIIlIIllIlIIlII = new ICommandSender() {
            @Override
            public Vec3d getPositionVector() {
                return new Vec3d(TileEntitySign.this.pos.getX() + 0.5, TileEntitySign.this.pos.getY() + 0.5, TileEntitySign.this.pos.getZ() + 0.5);
            }
            
            @Override
            public BlockPos getPosition() {
                return TileEntitySign.this.pos;
            }
            
            @Override
            public String getName() {
                return "Sign";
            }
            
            @Override
            public World getEntityWorld() {
                return TileEntitySign.this.world;
            }
            
            @Override
            public boolean canCommandSenderUseCommand(final int lllllllllllllIIIIIIIlIIIlllIIIIl, final String lllllllllllllIIIIIIIlIIIlllIIIII) {
                return true;
            }
            
            @Override
            public MinecraftServer getServer() {
                return TileEntitySign.this.world.getMinecraftServer();
            }
        };
        for (int llllllllllllllllIIIIlIIllIlIIIll = 0; llllllllllllllllIIIIlIIllIlIIIll < 4; ++llllllllllllllllIIIIlIIllIlIIIll) {
            final String llllllllllllllllIIIIlIIllIlIIIlI = llllllllllllllllIIIIlIIllIIllllI.getString("Text" + (llllllllllllllllIIIIlIIllIlIIIll + 1));
            final ITextComponent llllllllllllllllIIIIlIIllIlIIIIl = ITextComponent.Serializer.jsonToComponent(llllllllllllllllIIIIlIIllIlIIIlI);
            try {
                this.signText[llllllllllllllllIIIIlIIllIlIIIll] = TextComponentUtils.processComponent(llllllllllllllllIIIIlIIllIlIIlII, llllllllllllllllIIIIlIIllIlIIIIl, null);
            }
            catch (CommandException llllllllllllllllIIIIlIIllIlIIIII) {
                this.signText[llllllllllllllllIIIIlIIllIlIIIll] = llllllllllllllllIIIIlIIllIlIIIIl;
            }
        }
        this.stats.readStatsFromNBT(llllllllllllllllIIIIlIIllIIllllI);
    }
    
    public EntityPlayer getPlayer() {
        return this.player;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllllIIIIlIIllIlllIlI) {
        super.writeToNBT(llllllllllllllllIIIIlIIllIlllIlI);
        for (int llllllllllllllllIIIIlIIllIlllIIl = 0; llllllllllllllllIIIIlIIllIlllIIl < 4; ++llllllllllllllllIIIIlIIllIlllIIl) {
            final String llllllllllllllllIIIIlIIllIlllIII = ITextComponent.Serializer.componentToJson(this.signText[llllllllllllllllIIIIlIIllIlllIIl]);
            llllllllllllllllIIIIlIIllIlllIlI.setString("Text" + (llllllllllllllllIIIIlIIllIlllIIl + 1), llllllllllllllllIIIIlIIllIlllIII);
        }
        this.stats.writeStatsToNBT(llllllllllllllllIIIIlIIllIlllIlI);
        return llllllllllllllllIIIIlIIllIlllIlI;
    }
    
    public CommandResultStats getStats() {
        return this.stats;
    }
    
    public boolean getIsEditable() {
        return this.isEditable;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 9, this.getUpdateTag());
    }
    
    public TileEntitySign() {
        this.signText = new ITextComponent[] { new TextComponentString(""), new TextComponentString(""), new TextComponentString(""), new TextComponentString("") };
        this.lineBeingEdited = -1;
        this.isEditable = true;
        this.stats = new CommandResultStats();
    }
}
