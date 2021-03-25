package com.example.LibraryManagement.security;

public class UserSecurity {
    //@Override
//    protected void configure(HttpSecurity http) throws Exception {​​​​​​​
//        http.authorizeRequests()
//                .antMatchers("/","/books").permitAll()
//                .antMatchers("/users").hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and().formLogin()
//                .and().logout()
//                .invalidateHttpSession(true);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {​​​​​​​
//        BCryptPasswordEncoder encoder = getBCryptPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder)
//                .withUser("admin")
//                .password(encoder.encode("admin123"))
//                .authorities("ADMIN");
//    }
//
//    @Bean
//    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

}
