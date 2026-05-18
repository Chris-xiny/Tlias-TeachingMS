package com.Chrisxin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UserServiceAITest {
    private final UserService userService = new UserService();

    @Test
    void testGetGender_Male_OddNumber() {
        // 测试男性：第17位是奇数（1）
        String idCard = "110101199001010011";
        assertEquals("男", userService.getGender(idCard), "第17位为奇数应该是男性");
    }

    @Test
    void testGetGender_Female_EvenNumber() {
        // 测试女性：第17位是偶数（0）
        String idCard = "110101199001010020";
        assertEquals("女", userService.getGender(idCard), "第17位为偶数应该是女性");
    }

    @Test
    void testGetGender_Male_Number9() {
        // 测试男性：第17位是9（奇数）
        String idCard = "110101199001010019";
        assertEquals("男", userService.getGender(idCard), "第17位为9应该是男性");
    }

    @Test
    void testGetGender_Female_Number8() {
        // 测试女性：第17位是8（偶数）
        String idCard = "110101199001010028";
        assertEquals("女", userService.getGender(idCard), "第17位为8应该是女性");
    }

    @Test
    void testGetGender_NullInput() {
        // 测试 null 输入
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getGender(null)
        );
        assertEquals("无效的身份证号码", exception.getMessage());
    }

    @Test
    void testGetGender_ShortLength() {
        // 测试长度不足18位
        String idCard = "11010119900101001";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getGender(idCard)
        );
        assertEquals("无效的身份证号码", exception.getMessage());
    }

    @Test
    void testGetGender_LongLength() {
        // 测试长度超过18位
        String idCard = "1101011990010100112";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getGender(idCard)
        );
        assertEquals("无效的身份证号码", exception.getMessage());
    }

    @Test
    void testGetGender_EmptyString() {
        // 测试空字符串
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getGender("")
        );
        assertEquals("无效的身份证号码", exception.getMessage());
    }
}
