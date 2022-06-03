// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;

public class BlockButtonStone extends BlockButton
{
    @Override
    protected void playClickSound(@Nullable final EntityPlayer lllllllllllIIllIIIIIlIllIIlllIII, final World lllllllllllIIllIIIIIlIllIIllIlll, final BlockPos lllllllllllIIllIIIIIlIllIIllIIll) {
        lllllllllllIIllIIIIIlIllIIllIlll.playSound(lllllllllllIIllIIIIIlIllIIlllIII, lllllllllllIIllIIIIIlIllIIllIIll, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.6f);
    }
    
    @Override
    protected void playReleaseSound(final World lllllllllllIIllIIIIIlIllIIlIllll, final BlockPos lllllllllllIIllIIIIIlIllIIlIlllI) {
        lllllllllllIIllIIIIIlIllIIlIllll.playSound(null, lllllllllllIIllIIIIIlIllIIlIlllI, SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.5f);
    }
    
    protected BlockButtonStone() {
        super(false);
    }
}
