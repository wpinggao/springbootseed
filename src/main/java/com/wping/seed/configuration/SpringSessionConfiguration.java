package com.wping.seed.configuration;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * describe:
 *
 * @author Wping.gao
 * @date 2019/5/24 16:55
 */
@Configuration
public class SpringSessionConfiguration {

    @Bean
    public DefaultCookieSerializer cookieSerializer(
            ServerProperties serverProperties) {
        Session.Cookie cookie = serverProperties.getServlet().getSession().getCookie();
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        PropertyMapper map = PropertyMapper.get().alwaysApplyingWhenNonNull();
        //map.from(cookie::getName).to(cookieSerializer::setCookieName);
        map.from(cookie::getDomain).to(cookieSerializer::setDomainName);
        map.from(cookie::getPath).to(cookieSerializer::setCookiePath);
        map.from(cookie::getHttpOnly).to(cookieSerializer::setUseHttpOnlyCookie);
        map.from(cookie::getSecure).to(cookieSerializer::setUseSecureCookie);
        map.from(cookie::getMaxAge).to((maxAge) -> cookieSerializer
                .setCookieMaxAge((int) maxAge.getSeconds()));

        cookieSerializer.setUseBase64Encoding(false);
        cookieSerializer.setCookieName("JESSIONID");
        return cookieSerializer;
    }

}
