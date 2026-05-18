package com.Chrisxin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("用户信息测试类")
public class UserServiceTest {
    private UserService us;
    @BeforeEach
    public void setUp(){
        us=new UserService();
    }
    /*测试*/
    @Test
    public void testGetAge() {
        Integer age=us.getAge("500224200510138234");
        System.out.println(age);
    }
    @Test
    public void testGetGender(){
        String gender=us.getGender("500224200510138234");
        System.out.println(gender);
        
    }
    /*断言测试*/
    @Test
    public void testGetGenderWithAssert01(){
        String gender=us.getGender("500224200510138234");
        Assertions.assertEquals("男",gender,"预期结果的性别不符合");
    }
    @Test
    public void testGetGenderWithAssert02(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            us.getGender(null);
        });
    }
    /*参数化测试*/

    @ParameterizedTest
    @ValueSource(strings={"500224200510138234","500224200510138284","null"})
    @DisplayName("用户性别测试类")
    public void tsetGetGender2(String idCard){
        String gender=us.getGender(idCard);
        Assertions.assertEquals("男",gender,"预期结果的性别不符合");
    }
}
