package teenymario123.extuniverse.util;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;

public class statics {

    //Blockstate property statics
    public static final PropertyBool ENABLED = PropertyBool.create("enabled");
    public static final PropertyInteger THROTTLE = PropertyInteger.create("throttle", 0, 100);
}
