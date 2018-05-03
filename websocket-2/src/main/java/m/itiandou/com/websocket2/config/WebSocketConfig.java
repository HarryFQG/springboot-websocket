package m.itiandou.com.websocket2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author fengqigui
 * @description webSocket配置类
 * @date 2018/05/02 15:39
 */
@Component
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();
    }

}
