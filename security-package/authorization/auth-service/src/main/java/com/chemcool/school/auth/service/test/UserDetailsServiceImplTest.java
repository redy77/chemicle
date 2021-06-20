package com.chemcool.school.auth.service.test;

import com.chemcool.school.auth.service.domain.RegisterUser;
import com.chemcool.school.auth.service.domain.RegisterUserAccountRole;
import com.chemcool.school.auth.service.security.UserDetailsImpl;
import com.chemcool.school.auth.service.security.UserDetailsServiceImpl;
import com.chemcool.school.auth.service.storage.RegisterUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class UserDetailsServiceImplTest {

    private UserDetailsServiceImpl userDetailsService=mock(UserDetailsServiceImpl.class);
  private RegisterUserRepository repository = mock(RegisterUserRepository.class);
  private UserDetails userDetails = mock(UserDetails.class);

  @Test
    void loadUserByUsername_Ok(){
       String email = "email@test.ru";
       RegisterUser user= new RegisterUser();
       user.setEmail(email);
       Optional<RegisterUser> optionalRegisterUser = Optional.of(user);
       doReturn(optionalRegisterUser).when(repository).findByEmail(email);

       List<GrantedAuthority> authorities = Collections.
              singletonList(RegisterUserAccountRole.ROLE_USER_BASE);

       UserDetails saveUser = new UserDetailsImpl("test_id", "test_name", "email@test.ru"
              , "test", true, authorities);

       when(userDetailsService.loadUserByUsername(email)).thenReturn(saveUser);
       UserDetails newUser = userDetailsService.loadUserByUsername(email);
       assertEquals(email, newUser.getUsername());
      assertNotNull(newUser);
  }

//  }
}