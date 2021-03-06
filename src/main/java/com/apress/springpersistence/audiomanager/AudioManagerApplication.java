package com.apress.springpersistence.audiomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AudioManagerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AudioManagerApplication.class, args);
    }

//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public Server initH2TCPServer() {
//        Server server = null;
//        try {
//            return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return server;
//    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        // Go to http://localhost:8080/console and use jdbc:h2:mem:testdb as the JDBC URL
        return new ServletRegistrationBean(new org.h2.server.web.WebServlet(), "/console/*");
    }

}
