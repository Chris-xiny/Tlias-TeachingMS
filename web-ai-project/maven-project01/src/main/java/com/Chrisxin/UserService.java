package com.Chrisxin;

import java.time.LocalDate;
import java.time.Period;

/**
 * 用户业务类，提供身份证信息解析功能
 */
public class UserService {

    /**
     * 根据身份证号计算年龄
     * @param idCard 18位身份证号
     * @return 年龄（整数）
     */
    public Integer getAge(String idCard) {
        // 身份证第7-14位是出生年月日，格式：yyyyMMdd
        String birthStr = idCard.substring(6, 14);
        int year = Integer.parseInt(birthStr.substring(0, 4));
        int month = Integer.parseInt(birthStr.substring(4, 6));
        int day = Integer.parseInt(birthStr.substring(6, 8));

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        // 计算两个日期之间的年数差
        return Period.between(birthDate, today).getYears();
    }

    /**
     * 根据身份证号获取性别
     * @param idCard 18位身份证号
     * @return "男" 或 "女"
     */
    public String getGender(String idCard) {
        if(idCard==null||idCard.length()!=18){
            throw new IllegalArgumentException("无效的身份证号码");
        }
        // 身份证第17位（索引16），奇数为男，偶数为女
        return Integer.parseInt(idCard.substring(16,17)) % 2 == 1 ? "男" : "女";
    }
}