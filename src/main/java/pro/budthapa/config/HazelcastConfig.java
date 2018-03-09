package pro.budthapa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;

@Configuration
public class HazelcastConfig {
	@Bean
	public Config hazelcastConfig() {
		Config config = new Config();
		config.setInstanceName("hazelcast-cache");
		
		MapConfig mapConfig = new MapConfig();
		mapConfig.setTimeToLiveSeconds(20);
		mapConfig.setEvictionPolicy(EvictionPolicy.LFU);
		
		config.getMapConfigs().put("mapConfig", mapConfig);
		
		return config;
	}
}
