// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyBool;

public abstract class BlockLeaves extends Block
{
    /* synthetic */ int[] surroundings;
    public static final /* synthetic */ PropertyBool CHECK_DECAY;
    protected /* synthetic */ boolean leavesFancy;
    public static final /* synthetic */ PropertyBool DECAYABLE;
    
    static {
        DECAYABLE = PropertyBool.create("decayable");
        CHECK_DECAY = PropertyBool.create("check_decay");
    }
    
    @Override
    public void breakBlock(final World llllllllllllIIlllIlIlIlIlIlIIlIl, final BlockPos llllllllllllIIlllIlIlIlIlIllIIIl, final IBlockState llllllllllllIIlllIlIlIlIlIllIIII) {
        final int llllllllllllIIlllIlIlIlIlIlIllll = 1;
        final int llllllllllllIIlllIlIlIlIlIlIlllI = 2;
        final int llllllllllllIIlllIlIlIlIlIlIllIl = llllllllllllIIlllIlIlIlIlIllIIIl.getX();
        final int llllllllllllIIlllIlIlIlIlIlIllII = llllllllllllIIlllIlIlIlIlIllIIIl.getY();
        final int llllllllllllIIlllIlIlIlIlIlIlIll = llllllllllllIIlllIlIlIlIlIllIIIl.getZ();
        if (llllllllllllIIlllIlIlIlIlIlIIlIl.isAreaLoaded(new BlockPos(llllllllllllIIlllIlIlIlIlIlIllIl - 2, llllllllllllIIlllIlIlIlIlIlIllII - 2, llllllllllllIIlllIlIlIlIlIlIlIll - 2), new BlockPos(llllllllllllIIlllIlIlIlIlIlIllIl + 2, llllllllllllIIlllIlIlIlIlIlIllII + 2, llllllllllllIIlllIlIlIlIlIlIlIll + 2))) {
            for (int llllllllllllIIlllIlIlIlIlIlIlIlI = -1; llllllllllllIIlllIlIlIlIlIlIlIlI <= 1; ++llllllllllllIIlllIlIlIlIlIlIlIlI) {
                for (int llllllllllllIIlllIlIlIlIlIlIlIIl = -1; llllllllllllIIlllIlIlIlIlIlIlIIl <= 1; ++llllllllllllIIlllIlIlIlIlIlIlIIl) {
                    for (int llllllllllllIIlllIlIlIlIlIlIlIII = -1; llllllllllllIIlllIlIlIlIlIlIlIII <= 1; ++llllllllllllIIlllIlIlIlIlIlIlIII) {
                        final BlockPos llllllllllllIIlllIlIlIlIlIlIIlll = llllllllllllIIlllIlIlIlIlIllIIIl.add(llllllllllllIIlllIlIlIlIlIlIlIlI, llllllllllllIIlllIlIlIlIlIlIlIIl, llllllllllllIIlllIlIlIlIlIlIlIII);
                        final IBlockState llllllllllllIIlllIlIlIlIlIlIIllI = llllllllllllIIlllIlIlIlIlIlIIlIl.getBlockState(llllllllllllIIlllIlIlIlIlIlIIlll);
                        if (llllllllllllIIlllIlIlIlIlIlIIllI.getMaterial() == Material.LEAVES && !llllllllllllIIlllIlIlIlIlIlIIllI.getValue((IProperty<Boolean>)BlockLeaves.CHECK_DECAY)) {
                            llllllllllllIIlllIlIlIlIlIlIIlIl.setBlockState(llllllllllllIIlllIlIlIlIlIlIIlll, llllllllllllIIlllIlIlIlIlIlIIllI.withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, true), 4);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIIlllIlIlIlIIIIllIIl) {
        return !this.leavesFancy;
    }
    
    @Override
    public void updateTick(final World llllllllllllIIlllIlIlIlIlIIIIllI, final BlockPos llllllllllllIIlllIlIlIlIIllIllIl, final IBlockState llllllllllllIIlllIlIlIlIlIIIIlII, final Random llllllllllllIIlllIlIlIlIlIIIIIll) {
        if (!llllllllllllIIlllIlIlIlIlIIIIllI.isRemote && llllllllllllIIlllIlIlIlIlIIIIlII.getValue((IProperty<Boolean>)BlockLeaves.CHECK_DECAY) && llllllllllllIIlllIlIlIlIlIIIIlII.getValue((IProperty<Boolean>)BlockLeaves.DECAYABLE)) {
            final int llllllllllllIIlllIlIlIlIlIIIIIlI = 4;
            final int llllllllllllIIlllIlIlIlIlIIIIIIl = 5;
            final int llllllllllllIIlllIlIlIlIlIIIIIII = llllllllllllIIlllIlIlIlIIllIllIl.getX();
            final int llllllllllllIIlllIlIlIlIIlllllll = llllllllllllIIlllIlIlIlIIllIllIl.getY();
            final int llllllllllllIIlllIlIlIlIIllllllI = llllllllllllIIlllIlIlIlIIllIllIl.getZ();
            final int llllllllllllIIlllIlIlIlIIlllllIl = 32;
            final int llllllllllllIIlllIlIlIlIIlllllII = 1024;
            final int llllllllllllIIlllIlIlIlIIllllIll = 16;
            if (this.surroundings == null) {
                this.surroundings = new int[32768];
            }
            if (llllllllllllIIlllIlIlIlIlIIIIllI.isAreaLoaded(new BlockPos(llllllllllllIIlllIlIlIlIlIIIIIII - 5, llllllllllllIIlllIlIlIlIIlllllll - 5, llllllllllllIIlllIlIlIlIIllllllI - 5), new BlockPos(llllllllllllIIlllIlIlIlIlIIIIIII + 5, llllllllllllIIlllIlIlIlIIlllllll + 5, llllllllllllIIlllIlIlIlIIllllllI + 5))) {
                final BlockPos.MutableBlockPos llllllllllllIIlllIlIlIlIIllllIlI = new BlockPos.MutableBlockPos();
                for (int llllllllllllIIlllIlIlIlIIllllIIl = -4; llllllllllllIIlllIlIlIlIIllllIIl <= 4; ++llllllllllllIIlllIlIlIlIIllllIIl) {
                    for (int llllllllllllIIlllIlIlIlIIllllIII = -4; llllllllllllIIlllIlIlIlIIllllIII <= 4; ++llllllllllllIIlllIlIlIlIIllllIII) {
                        for (int llllllllllllIIlllIlIlIlIIlllIlll = -4; llllllllllllIIlllIlIlIlIIlllIlll <= 4; ++llllllllllllIIlllIlIlIlIIlllIlll) {
                            final IBlockState llllllllllllIIlllIlIlIlIIlllIllI = llllllllllllIIlllIlIlIlIlIIIIllI.getBlockState(llllllllllllIIlllIlIlIlIIllllIlI.setPos(llllllllllllIIlllIlIlIlIlIIIIIII + llllllllllllIIlllIlIlIlIIllllIIl, llllllllllllIIlllIlIlIlIIlllllll + llllllllllllIIlllIlIlIlIIllllIII, llllllllllllIIlllIlIlIlIIllllllI + llllllllllllIIlllIlIlIlIIlllIlll));
                            final Block llllllllllllIIlllIlIlIlIIlllIlIl = llllllllllllIIlllIlIlIlIIlllIllI.getBlock();
                            if (llllllllllllIIlllIlIlIlIIlllIlIl != Blocks.LOG && llllllllllllIIlllIlIlIlIIlllIlIl != Blocks.LOG2) {
                                if (llllllllllllIIlllIlIlIlIIlllIllI.getMaterial() == Material.LEAVES) {
                                    this.surroundings[(llllllllllllIIlllIlIlIlIIllllIIl + 16) * 1024 + (llllllllllllIIlllIlIlIlIIllllIII + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIlll + 16] = -2;
                                }
                                else {
                                    this.surroundings[(llllllllllllIIlllIlIlIlIIllllIIl + 16) * 1024 + (llllllllllllIIlllIlIlIlIIllllIII + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIlll + 16] = -1;
                                }
                            }
                            else {
                                this.surroundings[(llllllllllllIIlllIlIlIlIIllllIIl + 16) * 1024 + (llllllllllllIIlllIlIlIlIIllllIII + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIlll + 16] = 0;
                            }
                        }
                    }
                }
                for (int llllllllllllIIlllIlIlIlIIlllIlII = 1; llllllllllllIIlllIlIlIlIIlllIlII <= 4; ++llllllllllllIIlllIlIlIlIIlllIlII) {
                    for (int llllllllllllIIlllIlIlIlIIlllIIll = -4; llllllllllllIIlllIlIlIlIIlllIIll <= 4; ++llllllllllllIIlllIlIlIlIIlllIIll) {
                        for (int llllllllllllIIlllIlIlIlIIlllIIlI = -4; llllllllllllIIlllIlIlIlIIlllIIlI <= 4; ++llllllllllllIIlllIlIlIlIIlllIIlI) {
                            for (int llllllllllllIIlllIlIlIlIIlllIIIl = -4; llllllllllllIIlllIlIlIlIIlllIIIl <= 4; ++llllllllllllIIlllIlIlIlIIlllIIIl) {
                                if (this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16] == llllllllllllIIlllIlIlIlIIlllIlII - 1) {
                                    if (this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16 - 1) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16] == -2) {
                                        this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16 - 1) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16] = llllllllllllIIlllIlIlIlIIlllIlII;
                                    }
                                    if (this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16 + 1) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16] == -2) {
                                        this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16 + 1) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16] = llllllllllllIIlllIlIlIlIIlllIlII;
                                    }
                                    if (this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16 - 1) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16] == -2) {
                                        this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16 - 1) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16] = llllllllllllIIlllIlIlIlIIlllIlII;
                                    }
                                    if (this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16 + 1) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16] == -2) {
                                        this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16 + 1) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16] = llllllllllllIIlllIlIlIlIIlllIlII;
                                    }
                                    if (this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16) * 32 + (llllllllllllIIlllIlIlIlIIlllIIIl + 16 - 1)] == -2) {
                                        this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16) * 32 + (llllllllllllIIlllIlIlIlIIlllIIIl + 16 - 1)] = llllllllllllIIlllIlIlIlIIlllIlII;
                                    }
                                    if (this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16 + 1] == -2) {
                                        this.surroundings[(llllllllllllIIlllIlIlIlIIlllIIll + 16) * 1024 + (llllllllllllIIlllIlIlIlIIlllIIlI + 16) * 32 + llllllllllllIIlllIlIlIlIIlllIIIl + 16 + 1] = llllllllllllIIlllIlIlIlIIlllIlII;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final int llllllllllllIIlllIlIlIlIIlllIIII = this.surroundings[16912];
            if (llllllllllllIIlllIlIlIlIIlllIIII >= 0) {
                llllllllllllIIlllIlIlIlIlIIIIllI.setBlockState(llllllllllllIIlllIlIlIlIIllIllIl, llllllllllllIIlllIlIlIlIlIIIIlII.withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false), 4);
            }
            else {
                this.destroy(llllllllllllIIlllIlIlIlIlIIIIllI, llllllllllllIIlllIlIlIlIIllIllIl);
            }
        }
    }
    
    private void destroy(final World llllllllllllIIlllIlIlIlIIlIIIlIl, final BlockPos llllllllllllIIlllIlIlIlIIlIIIlII) {
        this.dropBlockAsItem(llllllllllllIIlllIlIlIlIIlIIIlIl, llllllllllllIIlllIlIlIlIIlIIIlII, llllllllllllIIlllIlIlIlIIlIIIlIl.getBlockState(llllllllllllIIlllIlIlIlIIlIIIlII), 0);
        llllllllllllIIlllIlIlIlIIlIIIlIl.setBlockToAir(llllllllllllIIlllIlIlIlIIlIIIlII);
    }
    
    protected void dropApple(final World llllllllllllIIlllIlIlIlIIIlIIIIl, final BlockPos llllllllllllIIlllIlIlIlIIIlIIIII, final IBlockState llllllllllllIIlllIlIlIlIIIIlllll, final int llllllllllllIIlllIlIlIlIIIIllllI) {
    }
    
    @Override
    public boolean causesSuffocation(final IBlockState llllllllllllIIlllIlIlIlIIIIIllIl) {
        return false;
    }
    
    protected int getSaplingDropChance(final IBlockState llllllllllllIIlllIlIlIlIIIIlllII) {
        return 20;
    }
    
    public BlockLeaves() {
        super(Material.LEAVES);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(0.2f);
        this.setLightOpacity(1);
        this.setSoundType(SoundType.PLANT);
    }
    
    public abstract BlockPlanks.EnumType getWoodType(final int p0);
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllIIlllIlIlIlIIIlIlIII, final BlockPos llllllllllllIIlllIlIlIlIIIlIllll, final IBlockState llllllllllllIIlllIlIlIlIIIlIIllI, final float llllllllllllIIlllIlIlIlIIIlIllIl, final int llllllllllllIIlllIlIlIlIIIlIIlIl) {
        if (!llllllllllllIIlllIlIlIlIIIlIlIII.isRemote) {
            int llllllllllllIIlllIlIlIlIIIlIlIll = this.getSaplingDropChance(llllllllllllIIlllIlIlIlIIIlIIllI);
            if (llllllllllllIIlllIlIlIlIIIlIIlIl > 0) {
                llllllllllllIIlllIlIlIlIIIlIlIll -= 2 << llllllllllllIIlllIlIlIlIIIlIIlIl;
                if (llllllllllllIIlllIlIlIlIIIlIlIll < 10) {
                    llllllllllllIIlllIlIlIlIIIlIlIll = 10;
                }
            }
            if (llllllllllllIIlllIlIlIlIIIlIlIII.rand.nextInt(llllllllllllIIlllIlIlIlIIIlIlIll) == 0) {
                final Item llllllllllllIIlllIlIlIlIIIlIlIlI = this.getItemDropped(llllllllllllIIlllIlIlIlIIIlIIllI, llllllllllllIIlllIlIlIlIIIlIlIII.rand, llllllllllllIIlllIlIlIlIIIlIIlIl);
                Block.spawnAsEntity(llllllllllllIIlllIlIlIlIIIlIlIII, llllllllllllIIlllIlIlIlIIIlIllll, new ItemStack(llllllllllllIIlllIlIlIlIIIlIlIlI, 1, this.damageDropped(llllllllllllIIlllIlIlIlIIIlIIllI)));
            }
            llllllllllllIIlllIlIlIlIIIlIlIll = 200;
            if (llllllllllllIIlllIlIlIlIIIlIIlIl > 0) {
                llllllllllllIIlllIlIlIlIIIlIlIll -= 10 << llllllllllllIIlllIlIlIlIIIlIIlIl;
                if (llllllllllllIIlllIlIlIlIIIlIlIll < 40) {
                    llllllllllllIIlllIlIlIlIIIlIlIll = 40;
                }
            }
            this.dropApple(llllllllllllIIlllIlIlIlIIIlIlIII, llllllllllllIIlllIlIlIlIIIlIllll, llllllllllllIIlllIlIlIlIIIlIIllI, llllllllllllIIlllIlIlIlIIIlIlIll);
        }
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllIIlllIlIlIlIIIIIIIIl, final IBlockAccess llllllllllllIIlllIlIlIlIIIIIIlIl, final BlockPos llllllllllllIIlllIlIlIIlllllllll, final EnumFacing llllllllllllIIlllIlIlIIllllllllI) {
        return (this.leavesFancy || llllllllllllIIlllIlIlIlIIIIIIlIl.getBlockState(llllllllllllIIlllIlIlIIlllllllll.offset(llllllllllllIIlllIlIlIIllllllllI)).getBlock() != this) && super.shouldSideBeRendered(llllllllllllIIlllIlIlIlIIIIIIIIl, llllllllllllIIlllIlIlIlIIIIIIlIl, llllllllllllIIlllIlIlIIlllllllll, llllllllllllIIlllIlIlIIllllllllI);
    }
    
    public void setGraphicsLevel(final boolean llllllllllllIIlllIlIlIlIIIIlIIlI) {
        this.leavesFancy = llllllllllllIIlllIlIlIlIIIIlIIlI;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllIIlllIlIlIlIIIlllllI) {
        return (llllllllllllIIlllIlIlIlIIIlllllI.nextInt(20) == 0) ? 1 : 0;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllIIlllIlIlIlIIlIlIllI, final World llllllllllllIIlllIlIlIlIIlIlIlIl, final BlockPos llllllllllllIIlllIlIlIlIIlIlIlII, final Random llllllllllllIIlllIlIlIlIIlIIllIl) {
        if (llllllllllllIIlllIlIlIlIIlIlIlIl.isRainingAt(llllllllllllIIlllIlIlIlIIlIlIlII.up()) && !llllllllllllIIlllIlIlIlIIlIlIlIl.getBlockState(llllllllllllIIlllIlIlIlIIlIlIlII.down()).isFullyOpaque() && llllllllllllIIlllIlIlIlIIlIIllIl.nextInt(15) == 1) {
            final double llllllllllllIIlllIlIlIlIIlIlIIlI = llllllllllllIIlllIlIlIlIIlIlIlII.getX() + llllllllllllIIlllIlIlIlIIlIIllIl.nextFloat();
            final double llllllllllllIIlllIlIlIlIIlIlIIIl = llllllllllllIIlllIlIlIlIIlIlIlII.getY() - 0.05;
            final double llllllllllllIIlllIlIlIlIIlIlIIII = llllllllllllIIlllIlIlIlIIlIlIlII.getZ() + llllllllllllIIlllIlIlIlIIlIIllIl.nextFloat();
            llllllllllllIIlllIlIlIlIIlIlIlIl.spawnParticle(EnumParticleTypes.DRIP_WATER, llllllllllllIIlllIlIlIlIIlIlIIlI, llllllllllllIIlllIlIlIlIIlIlIIIl, llllllllllllIIlllIlIlIlIIlIlIIII, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIIlllIlIlIlIIIlllIll, final Random llllllllllllIIlllIlIlIlIIIlllIlI, final int llllllllllllIIlllIlIlIlIIIlllIIl) {
        return Item.getItemFromBlock(Blocks.SAPLING);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return this.leavesFancy ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
    }
}
