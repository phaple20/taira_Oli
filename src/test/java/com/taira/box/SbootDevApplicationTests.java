package com.taira.box;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.taira.box.domain.Student;
import com.taira.box.domain.User;
import com.taira.box.listener.StudentListener;
import com.taira.box.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.util.*;

@SpringBootTest
class SbootDevApplicationTests {

	@Test
	void springbootVersion() {
		System.out.println("-----Version-----");
		System.out.println(SpringVersion.getVersion());
		System.out.println(SpringBootVersion.getVersion());
	}
	@Test
	public void test01() {
		ExcelReaderBuilder readerBuilder = EasyExcel.read("testExcel.xlsx", Student.class,new StudentListener());
		ExcelReaderSheetBuilder sheet = readerBuilder.sheet();
		sheet.doRead();
	}
    @Test
    public void test02() {
		ExcelWriterBuilder writerBuilder = EasyExcel.write("exportExcel.xlsx", Student.class);
        ExcelWriterSheetBuilder writeSheet = writerBuilder.sheet();
		List<Student> students = initData();
		//System.out.println(students);
		writeSheet.doWrite(students);
    }

    private static List<Student> initData() {
		ArrayList<Student> students = new ArrayList<Student>();
		Student data = new Student();
		for (int a = 0;a<10;a++) {
            data.setName("学号" + a);
            data.setBirthday(new Date());
            data.setGender("女");
            students.add(data);
		}
		System.out.println(students);
		return students;
	}

	/*jwt*/
	@Test
	void contentLoads() {
		HashMap<String,Object> map = new HashMap<>();
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.SECOND,60);
		String token = JWT.create()
				.withHeader(map)
				.withClaim("userId",21)
				.withClaim("username","phaple")
				.withExpiresAt(instance.getTime())
				.sign(Algorithm.HMAC256("fjk$432"));
		System.out.println(token);
	}

	@Test
	public void vertifyJwt() {
		JWTVerifier vf = JWT.require(Algorithm.HMAC256("fjk$432")).build();
		DecodedJWT dj =  vf.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDI5NTMwNzksInVzZXJJZCI6MjEsInVzZXJuYW1lIjoicGhhcGxlIn0.Al3o6t__SB1ueHvh7GQKHuagoCh6ttCUiQeDKmw1gjk");
		System.out.println(dj.getClaim("userId").asInt());
		System.out.println(dj.getClaim("username").asString());
	}

	//test mybatis
	@Autowired
	private UserMapper userMapper;
	@Test
	public void testMybatis() {
		List<User> users = userMapper.selectList(null);
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
	}
	//添加用户
	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("Lucy");
		user.setAge(12);
		user.setEmail("lucy@hotmail.com");
		int rows = userMapper.insert(user);
		System.out.println(rows);
	}
	//修改用户
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId("1319923913421021186");
		user.setName("Luci");
		int rows = userMapper.updateById(user);
		System.out.println(rows);
	}
	//测试乐观锁
	@Test
	public void testLGS() {
		User user = userMapper.selectById("1319923913421021186");
		user.setName("Orange");
		int i = userMapper.updateById(user);
		System.out.println(i);
	}
}
