// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.entity.EntityPlayerSP;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class FastClimb extends Feature
{
    public static /* synthetic */ NumberSetting ladderSpeed;
    public static /* synthetic */ ListSetting ladderMode;
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIIlIllIlIlIIIllIIlIlI) {
        this.setSuffix(FastClimb.ladderMode.getCurrentMode(), true);
        if (FastClimb.mc.player == null || FastClimb.mc.world == null) {
            return;
        }
        final String lllllllllllIIlIllIlIlIIIllIIlIIl;
        switch (lllllllllllIIlIllIlIlIIIllIIlIIl = FastClimb.ladderMode.getOptions()) {
            case "Matrix": {
                if (FastClimb.mc.player.isOnLadder() && FastClimb.mc.player.isCollidedHorizontally && MovementHelper.isMoving()) {
                    final EntityPlayerSP player = FastClimb.mc.player;
                    player.motionY += 0.31200000643730164;
                    lllllllllllIIlIllIlIlIIIllIIlIlI.setGround(true);
                    break;
                }
                break;
            }
            case "Vanilla": {
                if (FastClimb.mc.player.isOnLadder() && FastClimb.mc.player.isCollidedHorizontally && MovementHelper.isMoving()) {
                    final EntityPlayerSP player2 = FastClimb.mc.player;
                    player2.motionY += FastClimb.ladderSpeed.getNumberValue();
                    break;
                }
                break;
            }
            default:
                break;
        }
    }
    
    public FastClimb() {
        super("FastClimb", "\u041f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0431\u044b\u0441\u0442\u0440\u043e \u0437\u0430\u0431\u0438\u0440\u0430\u0442\u044c\u0441\u044f \u043f\u043e \u043b\u0435\u0441\u0442\u043d\u0438\u0446\u0430\u043c \u0438 \u043b\u0438\u0430\u043d\u0430\u043c", 0, Category.PLAYER);
        FastClimb.ladderMode = new ListSetting("FastClimb Mode", "Matrix", () -> true, new String[] { "Matrix", "Vanilla" });
        FastClimb.ladderSpeed = new NumberSetting("Ladder Speed", 0.5f, 0.1f, 2.0f, 0.1f, () -> FastClimb.ladderMode.currentMode.equals("Vanilla"));
        this.addSettings(FastClimb.ladderMode);
    }
}
