package net.dofi.flintknife;

import net.dofi.flintknife.block.ModBlocks;
import net.dofi.flintknife.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Start
public class FlintKnife implements ModInitializer {
	public static final String MOD_ID = "flintknife";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}
//End