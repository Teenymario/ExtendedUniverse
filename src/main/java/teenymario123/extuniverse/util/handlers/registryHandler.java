package teenymario123.extuniverse.util.handlers;

import net.minecraftforge.event.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;
import teenymario123.extuniverse.util.interfaces.*;
import teenymario123.extuniverse.init.*;
import net.minecraft.block.*;
import net.minecraftforge.fml.common.event.*;

@EventBusSubscriber
public class registryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(itemInit.ITEMS.toArray(new Item[0]));
    }
    
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (final Item item : itemInit.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel)item).registerModels();
            }
        }
        for (final Block block : blockInit.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel)block).registerModels();
            }
        }
    }
    
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(blockInit.BLOCKS.toArray(new Block[0]));
    }
    
    public static void preInitRegistries() {
    }
    
    public static void initRegistries() {
    }
    
    public static void postInitRegistries() {
    }
    
    public static void serverRegistries(FMLServerStartingEvent event) {
    }
}
