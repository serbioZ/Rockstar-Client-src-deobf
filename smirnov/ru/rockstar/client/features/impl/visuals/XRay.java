// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import java.util.concurrent.CopyOnWriteArrayList;
import ru.rockstar.client.features.Category;
import net.minecraft.network.Packet;
import net.minecraft.util.EnumFacing;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import java.util.Iterator;
import ru.rockstar.api.utils.combat.EntityHelper;
import net.minecraft.block.BlockAir;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.api.event.event.Event3D;
import net.minecraft.block.state.IBlockState;
import ru.rockstar.api.event.event.EventRenderBlock;
import ru.rockstar.api.command.impl.XrayCommand;
import ru.rockstar.api.utils.world.BlockHelper;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.play.server.SPacketMultiBlockChange;
import net.minecraft.block.Block;
import net.minecraft.network.play.server.SPacketBlockChange;
import ru.rockstar.api.event.event.EventReceivePacket;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import net.minecraft.util.math.Vec3i;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import java.util.ArrayList;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class XRay extends Feature
{
    private final /* synthetic */ NumberSetting checkSpeed;
    private final /* synthetic */ ArrayList<BlockPos> ores;
    private final /* synthetic */ List<Vec3i> blocks;
    public static /* synthetic */ int done;
    public static /* synthetic */ BooleanSetting redstone;
    public static /* synthetic */ BooleanSetting brutForce;
    public static /* synthetic */ BooleanSetting lapis;
    private final /* synthetic */ NumberSetting renderDist;
    public static /* synthetic */ BooleanSetting coal;
    private final /* synthetic */ ArrayList<BlockPos> toCheck;
    public static /* synthetic */ BooleanSetting diamond;
    public static /* synthetic */ BooleanSetting emerald;
    public static /* synthetic */ BooleanSetting gold;
    public static /* synthetic */ BooleanSetting iron;
    private final /* synthetic */ NumberSetting rxz;
    public static /* synthetic */ int all;
    private final /* synthetic */ NumberSetting ry;
    
    @EventTarget
    public void onReceivePacket(final EventReceivePacket llllllllllllIIlIIIIlIlIIlIIlIllI) {
        if (XRay.brutForce.getBoolValue()) {
            if (llllllllllllIIlIIIIlIlIIlIIlIllI.getPacket() instanceof SPacketBlockChange) {
                final SPacketBlockChange llllllllllllIIlIIIIlIlIIlIIlIlIl = (SPacketBlockChange)llllllllllllIIlIIIIlIlIIlIIlIllI.getPacket();
                if (this.isEnabledOre(Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIlIIlIlIl.getBlockState().getBlock())) && !XRay.mc.world.isAirBlock(llllllllllllIIlIIIIlIlIIlIIlIlIl.getBlockPosition())) {
                    this.ores.add(llllllllllllIIlIIIIlIlIIlIIlIlIl.getBlockPosition());
                }
            }
            else if (llllllllllllIIlIIIIlIlIIlIIlIllI.getPacket() instanceof SPacketMultiBlockChange) {
                final SPacketMultiBlockChange llllllllllllIIlIIIIlIlIIlIIlIlII = (SPacketMultiBlockChange)llllllllllllIIlIIIIlIlIIlIIlIllI.getPacket();
                final boolean llllllllllllIIlIIIIlIlIIlIIIllII;
                final boolean llllllllllllIIlIIIIlIlIIlIIIllIl = ((SPacketMultiBlockChange.BlockUpdateData[])(Object)(llllllllllllIIlIIIIlIlIIlIIIllII = (boolean)(Object)llllllllllllIIlIIIIlIlIIlIIlIlII.getChangedBlocks())).length != 0;
                for (long llllllllllllIIlIIIIlIlIIlIIIlllI = 0; llllllllllllIIlIIIIlIlIIlIIIlllI < (llllllllllllIIlIIIIlIlIIlIIIllIl ? 1 : 0); ++llllllllllllIIlIIIIlIlIIlIIIlllI) {
                    final SPacketMultiBlockChange.BlockUpdateData llllllllllllIIlIIIIlIlIIlIIlIIll = llllllllllllIIlIIIIlIlIIlIIIllII[llllllllllllIIlIIIIlIlIIlIIIlllI];
                    if (this.isEnabledOre(Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIlIIlIIll.getBlockState().getBlock())) && !XRay.mc.world.isAirBlock(llllllllllllIIlIIIIlIlIIlIIlIIll.getPos())) {
                        this.ores.add(llllllllllllIIlIIIIlIlIIlIIlIIll.getPos());
                    }
                }
            }
        }
    }
    
    private ArrayList<BlockPos> getBlocks(final int llllllllllllIIlIIIIlIlIIllIIllII, final int llllllllllllIIlIIIIlIlIIllIIlIll, final int llllllllllllIIlIIIIlIlIIllIIlIlI) {
        final BlockPos llllllllllllIIlIIIIlIlIIllIIlIIl = new BlockPos(XRay.mc.player.posX - llllllllllllIIlIIIIlIlIIllIIllII, XRay.mc.player.posY - llllllllllllIIlIIIIlIlIIllIIlIll, XRay.mc.player.posZ - llllllllllllIIlIIIIlIlIIllIIlIlI);
        final BlockPos llllllllllllIIlIIIIlIlIIllIIlIII = new BlockPos(XRay.mc.player.posX + llllllllllllIIlIIIIlIlIIllIIllII, XRay.mc.player.posY + llllllllllllIIlIIIIlIlIIllIIlIll, XRay.mc.player.posZ + llllllllllllIIlIIIIlIlIIllIIlIlI);
        return BlockHelper.getAllInBox(llllllllllllIIlIIIIlIlIIllIIlIIl, llllllllllllIIlIIIIlIlIIllIIlIII);
    }
    
    private boolean isEnabledOre(final int llllllllllllIIlIIIIlIlIIllIlllIl) {
        int llllllllllllIIlIIIIlIlIIlllIIllI = 0;
        int llllllllllllIIlIIIIlIlIIlllIIlIl = 0;
        int llllllllllllIIlIIIIlIlIIlllIIlII = 0;
        int llllllllllllIIlIIIIlIlIIlllIIIll = 0;
        int llllllllllllIIlIIIIlIlIIlllIIIlI = 0;
        int llllllllllllIIlIIIIlIlIIlllIIIIl = 0;
        int llllllllllllIIlIIIIlIlIIlllIIIII = 0;
        int llllllllllllIIlIIIIlIlIIllIlllll = 0;
        if (XRay.diamond.getBoolValue() && llllllllllllIIlIIIIlIlIIllIlllIl != 0) {
            llllllllllllIIlIIIIlIlIIlllIIllI = 56;
        }
        if (XRay.gold.getBoolValue() && llllllllllllIIlIIIIlIlIIllIlllIl != 0) {
            llllllllllllIIlIIIIlIlIIlllIIlIl = 14;
        }
        if (XRay.iron.getBoolValue() && llllllllllllIIlIIIIlIlIIllIlllIl != 0) {
            llllllllllllIIlIIIIlIlIIlllIIlII = 15;
        }
        if (XRay.emerald.getBoolValue() && llllllllllllIIlIIIIlIlIIllIlllIl != 0) {
            llllllllllllIIlIIIIlIlIIlllIIIll = 129;
        }
        if (XRay.redstone.getBoolValue() && llllllllllllIIlIIIIlIlIIllIlllIl != 0) {
            llllllllllllIIlIIIIlIlIIlllIIIlI = 73;
        }
        if (XRay.coal.getBoolValue() && llllllllllllIIlIIIIlIlIIllIlllIl != 0) {
            llllllllllllIIlIIIIlIlIIlllIIIIl = 16;
        }
        if (XRay.lapis.getBoolValue() && llllllllllllIIlIIIIlIlIIllIlllIl != 0) {
            llllllllllllIIlIIIIlIlIIlllIIIII = 21;
        }
        for (final Integer llllllllllllIIlIIIIlIlIIllIllllI : XrayCommand.blockIDS) {
            if (llllllllllllIIlIIIIlIlIIllIllllI != 0) {
                llllllllllllIIlIIIIlIlIIllIlllll = llllllllllllIIlIIIIlIlIIllIllllI;
            }
        }
        return llllllllllllIIlIIIIlIlIIllIlllIl != 0 && (llllllllllllIIlIIIIlIlIIllIlllIl == llllllllllllIIlIIIIlIlIIlllIIllI || llllllllllllIIlIIIIlIlIIllIlllIl == llllllllllllIIlIIIIlIlIIlllIIlIl || llllllllllllIIlIIIIlIlIIllIlllIl == llllllllllllIIlIIIIlIlIIlllIIlII || llllllllllllIIlIIIIlIlIIllIlllIl == llllllllllllIIlIIIIlIlIIlllIIIll || llllllllllllIIlIIIIlIlIIllIlllIl == llllllllllllIIlIIIIlIlIIlllIIIlI || llllllllllllIIlIIIIlIlIIllIlllIl == llllllllllllIIlIIIIlIlIIlllIIIIl || llllllllllllIIlIIIIlIlIIllIlllIl == llllllllllllIIlIIIIlIlIIlllIIIII || llllllllllllIIlIIIIlIlIIllIlllIl == llllllllllllIIlIIIIlIlIIllIlllll);
    }
    
    @EventTarget
    public void onRenderBlock(final EventRenderBlock llllllllllllIIlIIIIlIlIIlIIIIlIl) {
        final BlockPos llllllllllllIIlIIIIlIlIIlIIIIlII = llllllllllllIIlIIIIlIlIIlIIIIlIl.getPos();
        final IBlockState llllllllllllIIlIIIIlIlIIlIIIIIll = llllllllllllIIlIIIIlIlIIlIIIIlIl.getState();
        if (this.isEnabledOre(Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIlIIIIIll.getBlock()))) {
            final Vec3i llllllllllllIIlIIIIlIlIIlIIIIIlI = new Vec3i(llllllllllllIIlIIIIlIlIIlIIIIlII.getX(), llllllllllllIIlIIIIlIlIIlIIIIlII.getY(), llllllllllllIIlIIIIlIlIIlIIIIlII.getZ());
            this.blocks.add(llllllllllllIIlIIIIlIlIIlIIIIIlI);
        }
    }
    
    @EventTarget
    public void onRender3D(final Event3D llllllllllllIIlIIIIlIlIIIlllIIlI) {
        if (XRay.brutForce.getBoolValue()) {
            for (final BlockPos llllllllllllIIlIIIIlIlIIIlllIIIl : this.ores) {
                final IBlockState llllllllllllIIlIIIIlIlIIIlllIIII = XRay.mc.world.getBlockState(llllllllllllIIlIIIIlIlIIIlllIIIl);
                final Block llllllllllllIIlIIIIlIlIIIllIllll = llllllllllllIIlIIIIlIlIIIlllIIII.getBlock();
                if (this.toCheck.size() > 0) {
                    if (Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIIllIllll) == 0) {
                        continue;
                    }
                    switch (Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIIllIllll)) {
                        case 56: {
                            if (XRay.diamond.getBoolValue()) {
                                DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIlllIIIl, 0.0f, 255.0f, 255.0f);
                                break;
                            }
                            break;
                        }
                        case 14: {
                            if (XRay.gold.getBoolValue()) {
                                DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIlllIIIl, 255.0f, 215.0f, 0.0f);
                                break;
                            }
                            break;
                        }
                        case 15: {
                            if (XRay.iron.getBoolValue()) {
                                DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIlllIIIl, 213.0f, 213.0f, 213.0f);
                                break;
                            }
                            break;
                        }
                        case 129: {
                            if (XRay.emerald.getBoolValue()) {
                                DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIlllIIIl, 0.0f, 255.0f, 77.0f);
                                break;
                            }
                            break;
                        }
                        case 73: {
                            if (XRay.redstone.getBoolValue()) {
                                DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIlllIIIl, 255.0f, 0.0f, 0.0f);
                                break;
                            }
                            break;
                        }
                        case 16: {
                            if (XRay.coal.getBoolValue()) {
                                DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIlllIIIl, 0.0f, 0.0f, 0.0f);
                                break;
                            }
                            break;
                        }
                        case 21: {
                            if (XRay.lapis.getBoolValue()) {
                                DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIlllIIIl, 38.0f, 97.0f, 156.0f);
                                break;
                            }
                            break;
                        }
                    }
                    for (final Integer llllllllllllIIlIIIIlIlIIIllIlllI : XrayCommand.blockIDS) {
                        if (Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIIllIllll) == llllllllllllIIlIIIIlIlIIIllIlllI) {
                            DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIlllIIIl, ClientHelper.getClientColor().getRed() / 255.0f, ClientHelper.getClientColor().getGreen() / 255.0f, ClientHelper.getClientColor().getBlue() / 255.0f);
                        }
                    }
                }
            }
        }
        else {
            for (final Vec3i llllllllllllIIlIIIIlIlIIIllIllIl : this.blocks) {
                final BlockPos llllllllllllIIlIIIIlIlIIIllIllII = new BlockPos(llllllllllllIIlIIIIlIlIIIllIllIl);
                final IBlockState llllllllllllIIlIIIIlIlIIIllIlIll = XRay.mc.world.getBlockState(llllllllllllIIlIIIIlIlIIIllIllII);
                final Block llllllllllllIIlIIIIlIlIIIllIlIlI = llllllllllllIIlIIIIlIlIIIllIlIll.getBlock();
                final Block llllllllllllIIlIIIIlIlIIIllIlIIl = XRay.mc.world.getBlockState(llllllllllllIIlIIIIlIlIIIllIllII).getBlock();
                if (!(llllllllllllIIlIIIIlIlIIIllIlIIl instanceof BlockAir)) {
                    if (Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIIllIlIIl) == 0) {
                        continue;
                    }
                    if (EntityHelper.getDistance(XRay.mc.player.posX, XRay.mc.player.posZ, llllllllllllIIlIIIIlIlIIIllIllIl.getX(), llllllllllllIIlIIIIlIlIIIllIllIl.getZ()) > this.renderDist.getNumberValue()) {
                        this.blocks.remove(llllllllllllIIlIIIIlIlIIIllIllIl);
                    }
                    else {
                        switch (Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIIllIlIIl)) {
                            case 56: {
                                if (XRay.diamond.getBoolValue()) {
                                    DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIllIllII, 0.0f, 255.0f, 255.0f);
                                    break;
                                }
                                break;
                            }
                            case 14: {
                                if (XRay.gold.getBoolValue()) {
                                    DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIllIllII, 255.0f, 215.0f, 0.0f);
                                    break;
                                }
                                break;
                            }
                            case 15: {
                                if (XRay.iron.getBoolValue()) {
                                    DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIllIllII, 213.0f, 213.0f, 213.0f);
                                    break;
                                }
                                break;
                            }
                            case 129: {
                                if (XRay.emerald.getBoolValue()) {
                                    DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIllIllII, 0.0f, 255.0f, 77.0f);
                                    break;
                                }
                                break;
                            }
                            case 73: {
                                if (XRay.redstone.getBoolValue()) {
                                    DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIllIllII, 255.0f, 0.0f, 0.0f);
                                    break;
                                }
                                break;
                            }
                            case 16: {
                                if (XRay.coal.getBoolValue()) {
                                    DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIllIllII, 0.0f, 0.0f, 0.0f);
                                    break;
                                }
                                break;
                            }
                            case 21: {
                                if (XRay.lapis.getBoolValue()) {
                                    DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIllIllII, 38.0f, 97.0f, 156.0f);
                                    break;
                                }
                                break;
                            }
                        }
                        for (final Integer llllllllllllIIlIIIIlIlIIIllIlIII : XrayCommand.blockIDS) {
                            if (Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIIllIlIlI) != 0 && Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIIllIlIlI) == llllllllllllIIlIIIIlIlIIIllIlIII) {
                                DrawHelper.blockEspFrame(llllllllllllIIlIIIIlIlIIIllIllII, ClientHelper.getClientColor().getRed() / 255.0f, ClientHelper.getClientColor().getGreen() / 255.0f, ClientHelper.getClientColor().getBlue() / 255.0f);
                            }
                        }
                    }
                }
            }
        }
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate llllllllllllIIlIIIIlIlIIlIlIIllI) {
        final String llllllllllllIIlIIIIlIlIIlIlIIlIl = (XRay.done == XRay.all) ? ("Done: " + XRay.all) : (XRay.done + " / " + XRay.all);
        if (XRay.brutForce.getBoolValue()) {
            this.setSuffix(llllllllllllIIlIIIIlIlIIlIlIIlIl, true);
            for (int llllllllllllIIlIIIIlIlIIlIlIIlII = 0; llllllllllllIIlIIIIlIlIIlIlIIlII < this.checkSpeed.getNumberValue(); ++llllllllllllIIlIIIIlIlIIlIlIIlII) {
                if (this.toCheck.size() < 1) {
                    return;
                }
                final BlockPos llllllllllllIIlIIIIlIlIIlIlIIIll = this.toCheck.remove(0);
                ++XRay.done;
                XRay.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, llllllllllllIIlIIIIlIlIIlIlIIIll, EnumFacing.UP));
            }
        }
    }
    
    @Override
    public void onDisable() {
        XRay.mc.renderGlobal.loadRenderers();
        super.onDisable();
    }
    
    public XRay() {
        super("XRay", "\u041f\u043e\u0434\u0441\u0432\u0435\u0447\u0438\u0432\u0430\u0435\u0442 \u0440\u0443\u0434\u044b", 0, Category.VISUALS);
        this.ores = new ArrayList<BlockPos>();
        this.toCheck = new ArrayList<BlockPos>();
        this.blocks = new CopyOnWriteArrayList<Vec3i>();
        XRay.brutForce = new BooleanSetting("BrutForce", false, () -> true);
        this.renderDist = new NumberSetting("Render Distance", 35.0f, 15.0f, 150.0f, 5.0f, () -> !XRay.brutForce.getBoolValue());
        XRay.diamond = new BooleanSetting("Diamond", true, () -> true);
        XRay.gold = new BooleanSetting("Gold", false, () -> true);
        XRay.iron = new BooleanSetting("Iron", false, () -> true);
        XRay.emerald = new BooleanSetting("Emerald", false, () -> true);
        XRay.redstone = new BooleanSetting("Redstone", false, () -> true);
        XRay.lapis = new BooleanSetting("Lapis", false, () -> true);
        XRay.coal = new BooleanSetting("Coal", false, () -> true);
        this.checkSpeed = new NumberSetting("CheckSpeed", 4.0f, 1.0f, 10.0f, 1.0f, XRay.brutForce::getBoolValue);
        this.rxz = new NumberSetting("Radius XZ", 20.0f, 5.0f, 200.0f, 1.0f, XRay.brutForce::getBoolValue);
        this.ry = new NumberSetting("Radius Y", 6.0f, 2.0f, 50.0f, 1.0f, XRay.brutForce::getBoolValue);
        this.addSettings(this.renderDist, XRay.brutForce, this.checkSpeed, this.rxz, this.ry, XRay.diamond, XRay.gold, XRay.iron, XRay.emerald, XRay.redstone, XRay.lapis, XRay.coal);
    }
    
    private boolean isCheckableOre(final int llllllllllllIIlIIIIlIlIIIlIIlIII) {
        int llllllllllllIIlIIIIlIlIIIlIlIIIl = 0;
        int llllllllllllIIlIIIIlIlIIIlIlIIII = 0;
        int llllllllllllIIlIIIIlIlIIIlIIllll = 0;
        int llllllllllllIIlIIIIlIlIIIlIIlllI = 0;
        int llllllllllllIIlIIIIlIlIIIlIIllIl = 0;
        int llllllllllllIIlIIIIlIlIIIlIIllII = 0;
        int llllllllllllIIlIIIIlIlIIIlIIlIll = 0;
        int llllllllllllIIlIIIIlIlIIIlIIlIlI = 0;
        if (XRay.diamond.getBoolValue() && llllllllllllIIlIIIIlIlIIIlIIlIII != 0) {
            llllllllllllIIlIIIIlIlIIIlIlIIIl = 56;
        }
        if (XRay.gold.getBoolValue() && llllllllllllIIlIIIIlIlIIIlIIlIII != 0) {
            llllllllllllIIlIIIIlIlIIIlIlIIII = 14;
        }
        if (XRay.iron.getBoolValue() && llllllllllllIIlIIIIlIlIIIlIIlIII != 0) {
            llllllllllllIIlIIIIlIlIIIlIIllll = 15;
        }
        if (XRay.emerald.getBoolValue() && llllllllllllIIlIIIIlIlIIIlIIlIII != 0) {
            llllllllllllIIlIIIIlIlIIIlIIlllI = 129;
        }
        if (XRay.redstone.getBoolValue() && llllllllllllIIlIIIIlIlIIIlIIlIII != 0) {
            llllllllllllIIlIIIIlIlIIIlIIllIl = 73;
        }
        if (XRay.coal.getBoolValue() && llllllllllllIIlIIIIlIlIIIlIIlIII != 0) {
            llllllllllllIIlIIIIlIlIIIlIIllII = 16;
        }
        if (XRay.lapis.getBoolValue() && llllllllllllIIlIIIIlIlIIIlIIlIII != 0) {
            llllllllllllIIlIIIIlIlIIIlIIlIll = 21;
        }
        for (final Integer llllllllllllIIlIIIIlIlIIIlIIlIIl : XrayCommand.blockIDS) {
            if (llllllllllllIIlIIIIlIlIIIlIIlIIl != 0) {
                llllllllllllIIlIIIIlIlIIIlIIlIlI = llllllllllllIIlIIIIlIlIIIlIIlIIl;
            }
        }
        return llllllllllllIIlIIIIlIlIIIlIIlIII != 0 && (llllllllllllIIlIIIIlIlIIIlIIlIII == llllllllllllIIlIIIIlIlIIIlIlIIIl || llllllllllllIIlIIIIlIlIIIlIIlIII == llllllllllllIIlIIIIlIlIIIlIlIIII || llllllllllllIIlIIIIlIlIIIlIIlIII == llllllllllllIIlIIIIlIlIIIlIIllll || llllllllllllIIlIIIIlIlIIIlIIlIII == llllllllllllIIlIIIIlIlIIIlIIlllI || llllllllllllIIlIIIIlIlIIIlIIlIII == llllllllllllIIlIIIIlIlIIIlIIllIl || llllllllllllIIlIIIIlIlIIIlIIlIII == llllllllllllIIlIIIIlIlIIIlIIllII || llllllllllllIIlIIIIlIlIIIlIIlIII == llllllllllllIIlIIIIlIlIIIlIIlIll || llllllllllllIIlIIIIlIlIIIlIIlIII == llllllllllllIIlIIIIlIlIIIlIIlIlI);
    }
    
    @Override
    public void onEnable() {
        if (XRay.brutForce.getBoolValue()) {
            final int llllllllllllIIlIIIIlIlIIlIlllIlI = (int)this.rxz.getNumberValue();
            final int llllllllllllIIlIIIIlIlIIlIlllIIl = (int)this.ry.getNumberValue();
            final ArrayList<BlockPos> llllllllllllIIlIIIIlIlIIlIlllIII = this.getBlocks(llllllllllllIIlIIIIlIlIIlIlllIlI, llllllllllllIIlIIIIlIlIIlIlllIIl, llllllllllllIIlIIIIlIlIIlIlllIlI);
            for (final BlockPos llllllllllllIIlIIIIlIlIIlIllIlll : llllllllllllIIlIIIIlIlIIlIlllIII) {
                final IBlockState llllllllllllIIlIIIIlIlIIlIllIllI = XRay.mc.world.getBlockState(llllllllllllIIlIIIIlIlIIlIllIlll);
                if (this.isCheckableOre(Block.getIdFromBlock(llllllllllllIIlIIIIlIlIIlIllIllI.getBlock()))) {
                    this.toCheck.add(llllllllllllIIlIIIIlIlIIlIllIlll);
                }
            }
            XRay.all = this.toCheck.size();
            XRay.done = 0;
        }
        super.onEnable();
    }
}
