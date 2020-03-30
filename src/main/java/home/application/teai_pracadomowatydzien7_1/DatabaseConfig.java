package home.application.teai_pracadomowatydzien7_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    private DataSource dataSource;

    @Autowired
    public DatabaseConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
    /**Initial method to create table in database **/
    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        String sql = "CREATE TABLE cars(car_id int, car_mark varchar (255), car_model varchar (255), car_color varchar (255), car_production int, PRIMARY KEY(car_id))";
        jdbcTemplate().update(sql);
    }

}
