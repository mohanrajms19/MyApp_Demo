package customer.myapp.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Profile("cloud")
public class CloudDatabaseConfig extends AbstractCloudConfig{
	String url = "jdbc:sap://b9451bf7-ebb2-4bab-9be7-e24185b149a2.hana.trial-us10.hanacloud.ondemand.com:443?encrypt=true&validateCertificate=true&currentschema=MYAPP_HDI_DB_1";
	String user ="MYAPP_HDI_DB_1_0V88KC0QY8VM39KN8WI8GSCWE_RT";
	String password = "Gc9WBnD1co_RvDmej2Nmv4bIcJEkUQEncFG_zaqEGiYfY-r1eAAmOi6y4GNZW_gOL6jWl4i4uqqDg.3l3aCtTowfxopDPkoYvMWudqh4aanop2HSPH2mIybxO.a.0Z.M";
    // @Bean
	//public DataSource dataSource(@Value("${hana.url}")final String url,
	// 		@Value("${hana.user}")final String user,
	// 		@Value("${hana.password}")final String password) {
		
		
	// 	return DataSourceBuilder.create()
	// 			.type(HikariDataSource.class)
	// 			.driverClassName(com.sap.db.jdbc.Driver.class.getName())
	// 			.url(url)
	// 			.username(user)
	// 			.password(password)
	// 			.build();	

	// }

	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.type(HikariDataSource.class)
				.driverClassName(com.sap.db.jdbc.Driver.class.getName())
				.url(url)
				.username(user)
				.password(password)
				.build();	

	}
}
