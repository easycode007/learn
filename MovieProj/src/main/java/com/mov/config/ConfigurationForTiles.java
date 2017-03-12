package com.mov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScan(basePackages = "com.mov")
public class ConfigurationForTiles {

	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {"/WEB-INF/view/tiles/tiles.xml"});
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
//	 /**
//     * Configure ViewResolvers to deliver preferred views.
//     */
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        TilesViewResolver viewResolver = new TilesViewResolver();
//        registry.viewResolver(viewResolver);
//    }
	
	@Bean
    public UrlBasedViewResolver tilesViewResolver() {
        UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }
     
//    /**
//     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
//     */     
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//    }
}
