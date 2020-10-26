package colors;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = {"colors"})
public class Config {
    @Bean
    public ColoredFrame frame (){
        ColoredFrame coloredFrame = new ColoredFrame() {
            @Override
            public void showOnRandomPlace() {
                Random random = new Random();
                setLocation(random.nextInt(1000), random.nextInt(500));
                getContentPane().setBackground(randomColor());
                this.repaint();
                this.validate();
            }
        };
        return coloredFrame;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
     public Color randomColor(){
        Random random = new Random();
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }
}