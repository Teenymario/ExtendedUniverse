package teenymario123.extuniverse.objects.TESR;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraftforge.client.model.animation.FastTESR;
import teenymario123.extuniverse.objects.tileEntity.basicEngineTE;

import java.awt.*;

public class basicEngineTESR extends FastTESR<basicEngineTE> {

    @Override
    public void renderTileEntityFast(basicEngineTE te, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder buffer) {
        //Tile entity data grabbing
        int throttle = te.getThrottle();

        //Position definitions
        double xOff = x + 1.0D;
        double yOff = y + 1.5D;
        double zOff = z + 1.0D;

        //Color definitions
        int baseR = 252;
        int baseG = 235;
        int baseB = 130;

        int endR = 212;
        int endG = 136;
        int endB = 32;

        int alpha = 150;

        buffer.setTranslation(xOff, yOff, zOff);

        //Bottom 4 vertices
        buffer.pos(0, 0, 0).color(baseR, baseG, baseB, alpha).endVertex();
        buffer.pos(1, 0,0).color(baseR, baseG, baseB, alpha).endVertex();
        buffer.pos(0, 0, 1).color(baseR, baseG, baseB, alpha).endVertex();
        buffer.pos(1, 0, 1).color(baseR, baseG, baseB, alpha).endVertex();

        //Top 4 vertices
        buffer.pos(0, 1, 0).color(baseR, baseG, baseB, alpha).endVertex();
        buffer.pos(1, 1, 0).color(baseR, baseG, baseB, alpha).endVertex();
        buffer.pos(0, 1, 1).color(baseR, baseG, baseB, alpha).endVertex();
        buffer.pos(1, 1, 1).color(baseR, baseG, baseB, alpha).endVertex();
    }
}
