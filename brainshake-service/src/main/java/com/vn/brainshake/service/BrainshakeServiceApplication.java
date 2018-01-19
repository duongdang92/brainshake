package com.vn.brainshake.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sagag.eshop.repo.config.RepoConfiguration;
import com.sagag.eshop.service.app.ServiceApplication;
import com.sagag.services.elasticsearch.ElasticsearchConfiguration;
import com.sagag.services.gtmotive.app.GtmotiveConfiguration;
import com.sagag.services.gtmotive.app.GtmotiveProxyConfiguration;
import com.sagag.services.haynespro.api.app.HaynesProConfiguration;
import com.sagag.services.haynespro.api.app.HaynesProProxyConfiguration;
import com.sagag.services.hazelcast.app.SagHazelcastConfiguration;
import com.sagag.services.mdm.config.MdmConfiguration;
import com.sagag.services.mdm.config.MdmProxyConfiguration;
import com.sagag.services.olyslager.OlyslagerConfiguration;
import com.sagag.services.olyslager.OlyslagerProxyConfiguration;

@SpringBootApplication
@Configuration
@ComponentScan(value = "com.vn.brainshake")
@EnableAutoConfiguration(exclude = { GtmotiveProxyConfiguration.class,
    HaynesProProxyConfiguration.class, OlyslagerProxyConfiguration.class,
    MdmProxyConfiguration.class })
// @formatter:off
@Import(value =
    {
      RepoConfiguration.class,
      ElasticsearchConfiguration.class,
      SagHazelcastConfiguration.class,
      GtmotiveConfiguration.class,
      HaynesProConfiguration.class,
      OlyslagerConfiguration.class,
      MdmConfiguration.class
    }) // @formatter:on
public class BrainshakeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceApplication.class, args);
  }

}
