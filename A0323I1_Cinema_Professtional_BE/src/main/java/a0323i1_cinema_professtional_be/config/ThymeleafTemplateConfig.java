package a0323i1_cinema_professtional_be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafTemplateConfig {
    @Bean
    public ITemplateResolver templateResolver(){
        ClassLoaderTemplateResolver templeResolver = new ClassLoaderTemplateResolver();
        templeResolver.setPrefix("templates/");
        templeResolver.setSuffix(".html");
        templeResolver.setTemplateMode("HTML");
        templeResolver.setCharacterEncoding("UTF-8");
        return templeResolver;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
}
