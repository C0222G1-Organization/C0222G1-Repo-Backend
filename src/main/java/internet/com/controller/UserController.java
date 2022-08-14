package internet.com.controller;

import internet.com.dto.user_dto.request.SignInForm;
import internet.com.dto.user_dto.response.JwtResponse;
import internet.com.entity.computer.Computer;
import internet.com.entity.customer.Customer;
import internet.com.security.userprincal.UserOrEmail;
import internet.com.services.computer.IComputerService;
import internet.com.services.customer.ICustomerService;
import internet.com.services.record.IRecordService;
import internet.com.services.user.impl.RoleServiceImpl;
import internet.com.services.user.impl.UserServiceImpl;
import internet.com.security.jwt.JwtProvider;
import internet.com.security.userprincal.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UserOrEmail userOrEmail;
    @Autowired
    IRecordService iRecordService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IComputerService iComputerService;


    /**
     * Create by HoangHN
     * Date create: 09/08/2022
     * function: check login by username or email of customer or employee
     * @param signInForm
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm){
        SignInForm account = userOrEmail.checkUsernameOrEmail(signInForm);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();

        if (userPrinciple.getAuthorities().toString().contains("CUSTOMER")){
            if (iCustomerService.getRemainingTime(iCustomerService.findCustomerByUserName(account.getUsername()).get().getId()) < 1){
                return new ResponseEntity<>(new JwtResponse(true,"Tài khoản đã hết giờ, vui lòng nạp thêm"), HttpStatus.BAD_REQUEST);
            }
            if (!iComputerService.findUnusedComputer().isEmpty()){
                iRecordService.createRecord(iCustomerService.findCustomerByUserName(account.getUsername()).get().getId());
            }else{
                return new ResponseEntity<>(new JwtResponse(true,"Hiện không còn máy trống"), HttpStatus.BAD_REQUEST);
            }
        }
        return ResponseEntity.ok(new JwtResponse(false,"Đăng nhập thành công",
                userOrEmail.getEntity(account.getUsername()),token, userPrinciple.getAuthorities()));
    }

    @GetMapping(value = "/data/data1")
    public ResponseEntity<?> findAllTicket() {
        List<String> list = new ArrayList<>();
        list.add("data1");
        list.add("data2");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
