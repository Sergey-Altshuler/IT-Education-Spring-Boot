package com.altshuler.it_education_springboot.utilTest;


import com.altshuler.it_education_springboot.util.CourseGroupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.TEST_GROUP_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseGroupUtilTest {
    CourseGroupUtil courseGroupUtil = new CourseGroupUtil();

    @Test
    void getCourseGroup() {
        assertEquals(1, courseGroupUtil.getCourseGroup(TEST_GROUP_NAME));
        assertEquals(2, courseGroupUtil.getCourseGroup(TEST_GROUP_NAME));
    }
}
