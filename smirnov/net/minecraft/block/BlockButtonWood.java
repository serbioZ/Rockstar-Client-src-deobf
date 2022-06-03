// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockButtonWood extends BlockButton
{
    @Override
    protected void playReleaseSound(final World llllllllllllIllIIllIlIlIlIlllIIl, final BlockPos llllllllllllIllIIllIlIlIlIlllIII) {
        llllllllllllIllIIllIlIlIlIlllIIl.playSound(null, llllllllllllIllIIllIlIlIlIlllIII, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.5f);
    }
    
    protected BlockButtonWood() {
        super(true);
    }
    
    @Override
    protected void playClickSound(@Nullable final EntityPlayer llllllllllllIllIIllIlIlIlIllllll, final World llllllllllllIllIIllIlIlIllIIIIIl, final BlockPos llllllllllllIllIIllIlIlIllIIIIII) {
        llllllllllllIllIIllIlIlIllIIIIIl.playSound(llllllllllllIllIIllIlIlIlIllllll, llllllllllllIllIIllIlIlIllIIIIII, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.6f);
    }
}
