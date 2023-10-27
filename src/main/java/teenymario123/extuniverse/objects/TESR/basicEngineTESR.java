package teenymario123.extuniverse.objects.TESR;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import teenymario123.extuniverse.objects.tileEntity.basicEngineTE;

public class basicEngineTESR extends TileEntitySpecialRenderer<basicEngineTE> {

    @Override
    public void render(basicEngineTE te, double x, double y, double z, float partialTicks, int destroyStage, float partial) {
        // Tile entity data grabbing
        int throttle = te.getThrottle();

        // Position definitions
        double xOff = x + 0.0D;
        double yOff = y + 2.0D;
        double zOff = z + 0.0D;

        // Color definitions
        int baseR = 252;
        int baseG = 235;
        int baseB = 130;

        int endR = 212;
        int endG = 136;
        int endB = 32;

        int alpha = 150;


        //Renderer setup
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();

        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        GlStateManager.disableLighting();

        GlStateManager.alphaFunc(GL11.GL_ALWAYS, 0);
        GlStateManager.translate(x+.5f, y+.5f, z+.5f);

        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
        //Renderer setup


        //Render object
        buffer.setTranslation(xOff, yOff, zOff);

        // Define the vertices for each face
        double[][] vertices = new double[][] {
                //Top face
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 0}
        };

        for (double[] vertex : vertices) {
            buffer.pos(vertex[0], vertex[1], vertex[2]).color(baseR, baseG, baseB, alpha).endVertex();
        }
        //Render object


        //Finish render
        tessellator.draw();
        RenderHelper.enableStandardItemLighting();
        //Finish render
    }
}
