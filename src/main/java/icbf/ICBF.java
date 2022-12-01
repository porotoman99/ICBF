package icbf;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ICBF implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("ICBF");

	@Override
	public void onInitialize() {
		LOGGER.info("Loading ICBF...");
		LOGGER.info("ICBF loaded!");
	}
}
