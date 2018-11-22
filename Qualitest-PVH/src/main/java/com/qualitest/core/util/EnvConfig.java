package com.qualitest.core.util;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Sources({
	"file:src/test/resources/config/project.${env}.properties",
	"file:src/test/resources/config/project.properties"
})

public interface EnvConfig extends Config {

	@Key("ckus.url")
	String ckusURL();

	@Key("speedo.url")
	String speedoURL();

	@Key("th.url")
	String thURL();
	
	@Key("ckca.url")
	String ckcaURL();
	
	@Key("izod.url")
	String izodURL();
	
	@Key("vh.url")
	String vhURL();
	
	@Key("sb.url")
	String sbURL();

}