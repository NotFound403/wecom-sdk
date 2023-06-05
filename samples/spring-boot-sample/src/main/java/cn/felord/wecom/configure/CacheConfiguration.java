package cn.felord.wecom.configure;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 开启缓存
 *
 * @author dax
 * @since 2023/6/5
 */
@EnableCaching
@Configuration(proxyBeanMethods = false)
public class CacheConfiguration {
}
