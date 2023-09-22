package br.leal.called.configuracao

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfig {
    @Bean
    fun corsFilter(): CorsFilter {
        val corsConfig = CorsConfiguration()
        corsConfig.addAllowedOriginPattern("*") // Permitir requisições de qualquer origem (você pode configurar isso de forma mais restritiva)
        corsConfig.addAllowedMethod("*") // Permitir todos os métodos HTTP
        corsConfig.addAllowedHeader("*") // Permitir todos os cabeçalhos
        corsConfig.allowCredentials = true // Permitir credenciais (por exemplo, cookies)

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig) // Aplicar essa configuração a todos os caminhos

        return CorsFilter(source)
    }
}